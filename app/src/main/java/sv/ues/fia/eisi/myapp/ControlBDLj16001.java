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
    }

    private static class DataBaseHelper
            extends android.database.sqlite.SQLiteOpenHelper {
        private static final String DATA_BASE = "reserva.3sdb";
        private static final int VERSION= 1;

        public DataBaseHelper(Context context) {
            super(context, DATA_BASE, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // Vacio.
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
        if (verificarIntegridad(teorico, 3)){
            ContentValues cv = new ContentValues();
            cv.put("idteorico", teorico.getIdTeorico());
            cv.put("idmat", teorico.getIdMateria());

            contador = db.insert("teorico", null, cv);
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
            cv.put("carnetdocente", docente.getCarnet());
            cv.put("idrol", docente.getIdRol());
            cv.put("nombredocente", docente.getNombre());
            cv.put("apellidodocente", docente.getApellido());
            contador = db.insert("docente", null, cv);
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

        ContentValues rol = new ContentValues();

        rol.put("nomberol", rolDocente.getNombre());
        rol.put("idrol", rolDocente.getId());

        contador = db.insert("roldecente", null, rol);

        if (contador == -1 || contador == 0) {
            regInsertados = "Error al Insertar el registro, Registro duplicado. Verificar inserción";
        }
        else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    public String actualizar(Teorico teorico) {
        return null;
    }

    public String actualizar(Docente docente) {
        return null;
    }

    public String actualizar(RolDocente rolDocente) {
        return null;
    }

    public String eliminar(Teorico teorico){
        return null;
    }

    public String eliminar(Docente docente){
        return null;
    }

    public String eliminar(RolDocente rolDocente){
        return null;
    }

    public Teorico consultarTeorico(String idTeorico) {
        return null;
    }

    public Docente consultarDocente(String carnet) {
        return null;
    }

    public RolDocente consultarRolDocente(String idRolDecente) {
        return null;
    }

    private boolean verificarIntegridad(Object t, int relacion) {
        boolean returnValue = false;
        Cursor cursor;
        String[] id;
        switch (relacion) {
            case 1: // ver si existe la roldocente al crear docente.
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
                cursor = db.query("materia", null, "idmat=?", id, null, null,
                                  null, null);
                returnValue = (cursor.moveToFirst())? true: false;
                break;
            case 4: // ver si existe el teorico al editarlo.
                Teorico t3 = (Teorico) t;
                id = new String[]{t3.getIdMateria(), t3.getIdMateria()};
                cursor = db.query("teorico", null, "idteorico=? and idmat=?",
                                  id, null, null, null, null);
                returnValue = (cursor.moveToFirst())? true: false;
                break;
            case 5:  // ver si existe el roldocente.
                RolDocente r = (RolDocente) t;
                id = new String[]{r.getId()};
                cursor = db.query("roldocente", null, "idrol=?",
                        id, null, null, null, null);
                returnValue = (cursor.moveToFirst())? true: false;
                break;
                /*
            case 6: // ver si existe el teorico al crearlo.
                Teorico t4 = (Teorico) t;
                id = new String[]{t4.getIdMateria()};
                cursor = db.query("materia", null, "idmat=?",
                                  id, null, null, null, null);

                returnValue = (cursor.moveToFirst())? true: false;
                break;*/
        }
        return returnValue;
    }
}
