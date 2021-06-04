package sv.ues.fia.eisi.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ControlBDLj16001 {
    private final Context CONTEXT;
    private DataBaseHelper DBHelper;
    private SQLiteDatabase db;

    public ControlBDLj16001(Context context) {
        CONTEXT = context;
        DBHelper = new DataBaseHelper(context);
    }

    private static class DataBaseHelper
            extends android.database.sqlite.SQLiteOpenHelper {
        private static final String DATA_BASE = "reserva.s3db";
        private static final int VERSION= 1;

        public DataBaseHelper(Context context) {
            super(context, DATA_BASE, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Vacio.
        }
    }

    public void abrir() throws SQLException {
        db = DBHelper.getWritableDatabase();
    }

    public void cerrar() {
        DBHelper.close();
    }

    private String getDateTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return dateFormat.format(date);
    }

    private Date getStringDate(String date) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
    }

    public String insertar(Teorico teorico) {
        String regInsertados = "Registro insertado No. ";
        long contador = 0;
        if (!verificarIntegridad(teorico, 4)) {
            if(verificarIntegridad(teorico, 3)) {
                ContentValues cv = new ContentValues();

                cv.put("IDTEORICO", teorico.getIdTeorico());
                cv.put("IDMAT", teorico.getIdMateria());

                contador = db.insert("TEORICO", null, cv);
            }
        }
        if (contador == -1 || contador == 0) {
            regInsertados = "Error de inserción. ¡Verificar datos!";
        }
        else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    public String insertar(Docente docente) {
        String regInsertados = "Registro insertado No. ";
        long contador = 0;
        if (verificarIntegridad(docente, 1)){
            ContentValues cv = new ContentValues();
            cv.put("CARNETDOCENTE", docente.getCarnet());
            cv.put("IDROL", docente.getIdRol());
            cv.put("NOMBREDOCENTE", docente.getNombre());
            cv.put("APELLIDOSDOCENTE", docente.getApellido());
            contador = db.insert("DOCENTE", null, cv);
        }
        if (contador == -1 || contador == 0) {
            regInsertados = "Error de inserción. ¡Verificar datos!";
        }
        else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    public String insertar(RolDocente rolDocente) {
        String regInsertados = "Registro insertado No. ";
        long contador = 0;

        ContentValues cv = new ContentValues();

        cv.put("IDROL", rolDocente.getId());
        cv.put("NOMBREROL", rolDocente.getNombre());

        contador = db.insert("ROLDOCENTE", null, cv);

        if (contador==-1 || contador == 0){
            regInsertados = "Error de inserción, registro duplicado. Verificar datos.";
        }
        else{
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    public String actualizar(Teorico teorico) {
        if (verificarIntegridad(teorico, 4)) {
            String[] id = {teorico.getIdTeorico()};

            ContentValues cv = new ContentValues();

            cv.put("idteorico", teorico.getIdTeorico());
            cv.put("idmat", teorico.getIdMateria());


            db.update("teorico", cv, "idteorico = ?", id);

            return "Registro Actualizado Correctamente";
        }
        else {
            return "Registro con carnet "+ teorico.getIdTeorico() + " no existe";
        }
    }

    public String actualizar(Docente docente) {
        if (verificarIntegridad(docente, 6)) {
            String[] id = {docente.getCarnet()};
            ContentValues cv = new ContentValues();

            cv.put("carnetdocente", docente.getCarnet());
            cv.put("idrol", docente.getIdRol());
            cv.put("nombredocente", docente.getNombre());
            cv.put("apellidosdocente", docente.getApellido());


            db.update("docente", cv, "carnetdocente = ?", id);

            return "Registro Actualizado Correctamente";
        }
        else {
            return "Registro con carnet "+ docente.getCarnet() + " no existe";
        }
    }

    public String actualizar(RolDocente rolDocente) {
        if (verificarIntegridad(rolDocente, 5)) {
            String[] id = {rolDocente.getId()};
            ContentValues cv = new ContentValues();
            cv.put("NOMBREROL", rolDocente.getNombre());

            db.update("ROLDOCENTE", cv, "IDROL = ?", id);

            return "Registro Actualizado Correctamente";
        }

        else {
            return "Registro con id "+ rolDocente.getId() + " no existe";
        }
    }

    public String eliminar(Teorico teorico){
        String regAfectados = "filas afectadas= ";
        int contador = 0;
        if (verificarIntegridad(teorico,4)) {
            contador += db.delete("teorico", "idteorico='" +
                    teorico.getIdTeorico() + "'", null);
            regAfectados += contador;
            return regAfectados;
        }
        else return null;
    }

    public String eliminar(Docente docente){
        String regAfectados = "filas afectadas= ";
        int contador = 0;
        if (verificarIntegridad(docente,6)) {
            contador += db.delete("DOCENTE", "CARNETDOCENTE='" +
                    docente.getCarnet() + "'", null);
            regAfectados += contador;
            return regAfectados;
        }
        return "No se ha podido eliminar el registro.";
    }

    public String eliminar(RolDocente rolDocente) {
        String regAfectados = "filas afectadas= ";
        int contador = 0;
        if (verificarIntegridad(rolDocente,5)) {
            contador += db.delete("roldocente", "idrol='" +
                                  rolDocente.getId() + "'", null);
            regAfectados += contador;
            return regAfectados;
        }
        return "No se ha podido eliminar el registro";
    }

    public Teorico consultarTeorico(String idTeorico, String idmat) {
        String[] id = {idTeorico, idmat};
        String[] campos = {"IDTEORICO", "IDMAT"};
        Cursor cursor = db.query("TEORICO", campos,
                "IDTEORICO = ? and IDMAT = ?", id, null, null, null);
        if (cursor.moveToFirst()) {
            Teorico t = new Teorico();
            t.setIdTeorico(cursor.getString(0));
            t.setIdMateria(cursor.getString(1));

            return t;
        }
        else {
            return null;
        }

    }

    public Docente consultarDocente(String carnet) {
        String[] id = {carnet};
        String[] campos = {"CARNETDOCENTE", "IDROL", "NOMBREDOCENTE", "APELLIDOSDOCENTE"};
        Cursor cursor = db.query("DOCENTE", campos,
                                 "CARNETDOCENTE = ?", id,
                                 null, null, null);
        if (cursor.moveToFirst()) {
            Docente d = new Docente();

            d.setCarnet(cursor.getString(0));
            d.setIdRol(cursor.getString(1));
            d.setNombre(cursor.getString(2));
            d.setApellido(cursor.getString(2));
            return d;
        }
        else {
            return null;
        }
    }

    public RolDocente consultarRolDocente(String idRolDecente) {
        String[] id = {idRolDecente};
        String[] campos = {"idrol", "nombrerol"};
        Cursor cursor = db.query("ROLDOCENTE", campos,
                                 "IDROL = ?", id, null, null, null);
        if (cursor.moveToFirst()) {
            RolDocente rd = new RolDocente();
            rd.setId(cursor.getString(0));
            rd.setNombre(cursor.getString(1));
            return rd;
        }
        else {
            return null;
        }
    }

    private boolean verificarIntegridad(Object t, int relacion) {
        boolean returnValue = false;
        Cursor cursor;
        String[] id;
        switch (relacion) {
            case 1: // ver si existe roldocente al crear docente.
                Docente d = (Docente) t;
                id = new String[]{d.getIdRol()};
                cursor = db.query("roldocente", null, "idrol=?",
                                         id, null,null,null);
                returnValue = (cursor.moveToFirst())? true: false;
                break;
            case 2: // ver si existe el docente al editarlo.
                Docente d1 = (Docente) t;
                id = new String[]{d1.getCarnet(), d1.getIdRol()};
                cursor = db.query("docente", null,
                                  "carnetdocente=? and idrol=?",
                                  id, null,null,null);
                returnValue = (cursor.moveToFirst())? true: false;
                break;
            case 3: // ver si existe la materia al crear teorico.
                Teorico t1 = (Teorico) t;
                id = new String[]{t1.getIdMateria()};
                cursor = db.query("materia", null, "idmat = ?", id, null, null,
                                  null, null);
                returnValue = (cursor.moveToFirst())? true: false;
                break;
            case 4: // ver si existe el teorico al editarlo.
                Teorico t3 = (Teorico) t;
                id = new String[]{t3.getIdTeorico(), t3.getIdMateria()};
                cursor = db.query("TEORICO", null, "IDTEORICO = ? and IDMAT = ?",
                                  id, null, null, null, null);
                returnValue = (cursor.moveToFirst())? true: false;
                break;
            case 5:  // ver si existe el roldocente.
                RolDocente r = (RolDocente) t;
                id = new String[]{r.getId()};
                cursor = db.query("ROLDOCENTE", null, "IDROL = ?",
                        id, null, null, null, null);
                returnValue = (cursor.moveToFirst())? true: false;
                break;

            case 6: // ver si docente existe al ediatrlo.
                Docente d2 = (Docente) t;
                id = new String[]{d2.getCarnet()};
                cursor = db.query("docente", null,
                                  "carnetdocente = ?", id,
                                  null,null,null);
                returnValue = (cursor.moveToFirst())? true: false;
                break;
        }
        return returnValue;
    }
}
