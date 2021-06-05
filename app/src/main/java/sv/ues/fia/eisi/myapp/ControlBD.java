package sv.ues.fia.eisi.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ControlBD {

    private final Context context; //Almacenara el context de nuestra Activity
    private DatabaseHelper DBHelper; //Nuestro Auxiliador de BD
    private SQLiteDatabase db;

    public ControlBD(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String BASE_DATOS = "reserva.s3db";
        private static final int VERSION = 1;

        public DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL("create table ACCESOUSUARIO  (\n" +
                        "   USUARIO              VARCHAR2(10)                    not null,\n" +
                        "   IDOPCION             CHAR(3)                         not null,\n" +
                        "   constraint PK_ACCESOUSUARIO primary key (USUARIO, IDOPCION)\n" +
                        ");");//1
                db.execSQL("create table ASIGNACION  (\n" +
                        "   IDPROPUESTA          CHAR(5)                         not null,\n" +
                        "   IDHORARIO            CHAR(5)                         not null,\n" +
                        "   IDDIA                CHAR(5)                         not null,\n" +
                        "   constraint PK_ASIGNACION primary key (IDPROPUESTA, IDHORARIO, IDDIA)\n" +
                        ");");//2
                db.execSQL("create table CICLO  (\n" +
                        "   IDCICLO              CHAR(5)                         not null,\n" +
                        "   FECHAINICIO          DATE                            not null,\n" +
                        "   FECHAFIN             DATE                            not null,\n" +
                        "   constraint PK_CICLO primary key (IDCICLO)\n" +
                        ");");//3
                db.execSQL("create table DETALLEEVENTO  (\n" +
                        "   IDSALON              CHAR(6)                         not null,\n" +
                        "   IDEVENTO             CHAR(5)                         not null,\n" +
                        "   IDHORARIO            CHAR(5)                         not null,\n" +
                        "   IDDIA                CHAR(5)                         not null,\n" +
                        "   constraint PK_DETALLEEVENTO primary key (IDSALON, IDEVENTO, IDHORARIO, IDDIA)\n" +
                        ");");//4
                db.execSQL("create table DIA  (\n" +
                        "   IDDIA                CHAR(5)                         not null,\n" +
                        "   NOMBREDIA            VARCHAR2(9)                     not null,\n" +
                        "   constraint PK_DIA primary key (IDDIA)\n" +
                        ");");//5
                db.execSQL("create table DOCENTE  (\n" +
                        "   CARNETDOCENTE        CHAR(7)                         not null,\n" +
                        "   IDROL                CHAR(5)                         not null,\n" +
                        "   NOMBREDOCENTE        VARCHAR2(50)                    not null,\n" +
                        "   APELLIDOSDOCENTE     VARCHAR2(50)                    not null,\n" +
                        "   constraint PK_DOCENTE primary key (CARNETDOCENTE)\n" +
                        ");");//6
                db.execSQL("create table ESCUELA  (\n" +
                        "   IDESCUELA            CHAR(5)                         not null,\n" +
                        "   NOMBREESCUELA        VARCHAR2(100)                   not null,\n" +
                        "   constraint PK_ESCUELA primary key (IDESCUELA)\n" +
                        ");");//7
                db.execSQL("create table EVENTO  (\n" +
                        "   IDEVENTO             CHAR(5)                         not null,\n" +
                        "   NOMBREEVENTO         VARCHAR2(20)                    not null,\n" +
                        "   DESCRIPCION          VARCHAR2(80)                    not null,\n" +
                        "   constraint PK_EVENTO primary key (IDEVENTO)\n" +
                        ");");//8
                db.execSQL("create table HORARIO  (\n" +
                        "   IDHORARIO            CHAR(5)                         not null,\n" +
                        "   IDDIA                CHAR(5)                         not null,\n" +
                        "   HORAINICIO           DATE                            not null,\n" +
                        "   HORAFIN              DATE                            not null,\n" +
                        "   constraint PK_HORARIO primary key (IDHORARIO, IDDIA)\n" +
                        ");");//9
                db.execSQL("create table LABORATORIO  (\n" +
                        "   IDLAB                CHAR(4)                         not null,\n" +
                        "   IDMAT                CHAR(6)                         not null,\n" +
                        "   constraint PK_LABORATORIO primary key (IDLAB, IDMAT)\n" +
                        ");");//10
                db.execSQL("create table MATERIA  (\n" +
                        "   IDMAT                CHAR(6)                         not null,\n" +
                        "   IDCICLO              CHAR(5)                         not null,\n" +
                        "   CARNETDOCENTE        CHAR(7),\n" +
                        "   IDESCUELA            CHAR(5)                         not null,\n" +
                        "   NOMBREMATERIA        VARCHAR2(50)                    not null,\n" +
                        "   constraint PK_MATERIA primary key (IDMAT)\n" +
                        ");");//11
                db.execSQL("create table OPCIONCRUD  (\n" +
                        "   IDOPCION             CHAR(3)                         not null,\n" +
                        "   DESCRIPCIONOP        VARCHAR2(30)                    not null,\n" +
                        "   NUMCRUD              INTEGER                         not null,\n" +
                        "   constraint PK_OPCIONCRUD primary key (IDOPCION)\n" +
                        ");");//12
                db.execSQL("create table PROPUESTA  (\n" +
                        "   IDPROPUESTA          CHAR(5)                         not null,\n" +
                        "   IDTEORICO            CHAR(4),\n" +
                        "   IDMAT                CHAR(6)                         not null,\n" +
                        "   IDLAB                CHAR(4),\n" +
                        "   IDHORARIO            CHAR(5)                         not null,\n" +
                        "   IDDIA                CHAR(5)                         not null,\n" +
                        "   IDSALON              CHAR(6)                         not null,\n" +
                        "   APROBADO             VARCHAR(10)                     not null,\n" +
                        "   constraint PK_PROPUESTA primary key (IDPROPUESTA)\n" +
                        ");");//13
                db.execSQL("create table ROLDOCENTE  (\n" +
                        "   IDROL                CHAR(5)                         not null,\n" +
                        "   NOMBREROL            VARCHAR2(20)                    not null,\n" +
                        "   constraint PK_ROLDOCENTE primary key (IDROL)\n" +
                        ");");//14
                db.execSQL("create table SALON  (\n" +
                        "   IDSALON              CHAR(6)                         not null,\n" +
                        "   IDENCARGADO          CHAR(5)                         not null,\n" +
                        "   TIPO                 VARCHAR2(20)                    not null,\n" +
                        "   NOMBRE               VARCHAR2(50)                    not null,\n" +
                        "   constraint PK_SALON primary key (IDSALON)\n" +
                        ");");//15
                db.execSQL("create table TEORICO  (\n" +
                        "   IDTEORICO            CHAR(4)                         not null,\n" +
                        "   IDMAT                CHAR(6)                         not null,\n" +
                        "   constraint PK_TEORICO primary key (IDTEORICO, IDMAT)\n" +
                        ");");//16
                db.execSQL("create table USUARIO  (\n" +
                        "   USUARIO              VARCHAR2(10)                    not null,\n" +
                        "   CONTRASENIA          VARCHAR2(15)                    not null,\n" +
                        "   NOMBREUSUARIO        VARCHAR2(100)                   not null,\n" +
                        "   constraint PK_USUARIO primary key (USUARIO)\n" +
                        ");");//17
                db.execSQL("create table ENCARGADO  (\n" +
                        "   IDENCARGADO          CHAR(5)                         not null,\n" +
                        "   NOMBRESENCARGADO     VARCHAR2(50)                    not null,\n" +
                        "   APELLIDOSENCARGADO   VARCHAR2(50)                    not null,\n" +
                        "   constraint PK_ENCARGADO primary key (IDENCARGADO)\n" +
                        ");");//18

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub
        }
    }

    public void abrir() throws SQLException {
        db = DBHelper.getWritableDatabase();
    }

    public void cerrar() {
        DBHelper.close();
    }


    //Métodos CRUD SH15001
    //Este método pasa fechas a string para usar en ContentValues.put()
    private String getDateTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return dateFormat.format(date);
    }

    private Date getStringDate(String date) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
    }



    //Inserción
    public String insertar(Escuela escuela) {
        String regInsertados = "Registro insertado No. ";
        long contador = 0;

        ContentValues esc = new ContentValues();
        esc.put("idescuela", escuela.getId());
        esc.put("nombreescuela", escuela.getNombre());
        contador = db.insert("escuela", null, esc);
        if (contador == -1 || contador == 0) {
            regInsertados = "Error de inserción, registro duplicado. Verificar datos.";
        } else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    public String insertar(Ciclo ciclo) {
        String regInsertados = "Registro insertado No. ";
        long contador = 0;

        ContentValues cv = new ContentValues();
        cv.put("idciclo", ciclo.getId());
        cv.put("fechainicio", getDateTime(ciclo.getInicio()));
        cv.put("fechafin", getDateTime(ciclo.getFin()));
        contador = db.insert("ciclo", null, cv);
        if (contador == -1 || contador == 0) {
            regInsertados = "Error de inserción, registro duplicado. Verificar datos.";
        } else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    public String insertar(Materia materia) {
        String regInsertados = "Registro insertado No. ";
        long contador = 0;
        if (verificarIntegridad(materia, 5)) {
            ContentValues cv = new ContentValues();
            cv.put("idmat", materia.getId());
            cv.put("idciclo", materia.getIdCiclo());
            cv.put("idescuela", materia.getIdEscuela());
            cv.put("carnetdocente", materia.getCarnetDocente());
            cv.put("nombremateria", materia.getNombre());
            contador = db.insert("materia", null, cv);
        }
        if (contador == -1 || contador == 0) {
            regInsertados = "Error de inserción. ¡Verificar datos!";
        } else regInsertados = regInsertados + contador;
        return regInsertados;
    }

    public String insertar(Usuario usuario) {
        String regInsertados = "Registro insertado No. ";
        long contador = 0;

        ContentValues esc = new ContentValues();
        esc.put("usuario", usuario.getUsuario());
        esc.put("contrasenia", usuario.getCont());
        esc.put("nombreusuario", usuario.getNombre());
        contador = db.insert("usuario", null, esc);
        if (contador == -1 || contador == 0) {
            regInsertados = "Error de inserción, registro duplicado. Verificar datos.";
        } else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    public void insertar(AccesoUsuario acceso) {
        ContentValues cv = new ContentValues();
        cv.put("usuario", acceso.getUsuario());
        cv.put("idopcion", acceso.getIdopcion());
        db.insert("accesousuario", null, cv);
    }

    public void insertar(OpcionCrud opcion) {
        ContentValues cv = new ContentValues();
        cv.put("idopcion", opcion.getIdopcion());
        cv.put("descripcionop", opcion.getDescripcion());
        cv.put("numcrud", opcion.getNumcrud());
        db.insert("opcioncrud", null, cv);
    }

    //Consulta
    public Escuela consultarEscuela(String id) {

        String[] camposEscuela = {"idescuela", "nombreescuela"}, idescuela = {id};
        Cursor cursor = db.query("escuela", camposEscuela, "idescuela = ?", idescuela, null, null, null);
        if (cursor.moveToFirst()) {
            Escuela escuela = new Escuela();
            escuela.setId(cursor.getString(0));
            escuela.setNombre(cursor.getString(1));
            return escuela;
        } else {
            return null;
        }
    }

    public Ciclo consultarCiclo(String id) throws ParseException {

        String[] camposCiclo = {"idciclo", "fechainicio", "fechafin"}, idciclo = {id};
        Cursor cursor = db.query("ciclo", camposCiclo, "idciclo = ?", idciclo, null, null, null);
        if (cursor.moveToFirst()) {
            Ciclo ciclo = new Ciclo();
            ciclo.setId(cursor.getString(0));
            ciclo.setInicio(getStringDate(cursor.getString(1)));
            ciclo.setFin(getStringDate(cursor.getString(2)));
            return ciclo;
        } else {
            return null;
        }
    }

    public Materia consultarMateria(String id) {
        String[] camposMateria = {"idmat", "idciclo", "carnetdocente", "idescuela", "nombremateria"};
        String[] idMat = {id};
        Cursor c = db.query("materia", camposMateria, "idmat = ?", idMat, null, null, null);
        if (c.moveToFirst()) {
            Materia materia = new Materia();
            materia.setId(c.getString(0));
            materia.setIdCiclo(c.getString(1));
            materia.setCarnetDocente(c.getString(2));
            materia.setIdEscuela(c.getString(3));
            materia.setNombre(c.getString(4));
            return materia;
        } else return null;
    }

    public Usuario consultarUsuario(String id) {
        String[] camposUsuario = {"usuario", "contrasenia", "nombreusuario"};
        String[] idUsuario = {id};
        Cursor c = db.query("usuario", camposUsuario, "usuario = ?", idUsuario, null, null, null);
        if (c.moveToFirst()) {
            Usuario usuario = new Usuario(c.getString(0), c.getString(1), c.getString(2));
            return usuario;
        } else return null;
    }

    public boolean consultarAcceso(String usuario, String opcion) {
        String[] camposAcceso = {"usuario", "idopcion"};
        String[] id = {usuario, opcion};
        Cursor c = db.query("accesousuario", camposAcceso, "usuario = ? AND idopcion = ?", id, null, null, null);
        if (c.moveToFirst()) {
            return true;
        } else return false;
    }

    //Actualización
    public String actualizar(Escuela escuela) {
        if (verificarIntegridad(escuela, 1)) {
            String[] id = {escuela.getId()};
            ContentValues cv = new ContentValues();

            cv.put("nombreescuela", escuela.getNombre());
            db.update("escuela", cv, "idescuela = ?", id);
            return "¡Registro actualizado correctamente!";
        } else {
            return "La escuela con id " + escuela.getId() + " no existe.";
        }
    }

    public String actualizar(Ciclo ciclo) {
        if (verificarIntegridad(ciclo, 2)) {
            String[] id = {ciclo.getId()};
            ContentValues cv = new ContentValues();

            cv.put("fechainicio", getDateTime(ciclo.getInicio()));
            cv.put("fechafin", getDateTime(ciclo.getFin()));
            db.update("ciclo", cv, "idciclo = ?", id);
            return "¡Registro actualizado correctamente!";
        } else {
            return "El ciclo con id " + ciclo.getId() + " no existe";
        }
    }

    public String actualizar(Materia materia) {
        if (verificarIntegridad(materia, 6)) {
            String[] id = {materia.getId()};
            ContentValues cv = new ContentValues();

            cv.put("idciclo", materia.getIdCiclo());
            cv.put("carnetdocente", materia.getCarnetDocente());
            cv.put("idescuela", materia.getIdEscuela());
            cv.put("nombremateria", materia.getNombre());
            db.update("materia", cv, "idmat = ?", id);
            return "¡Registro actualizado correctamente!";
        } else {
            return "El código de materia " + materia.getId() + " no existe.";
        }
    }

    //Eliminacion
    public String eliminar(Escuela escuela) {
        String afectados = "Filas afectadas: ";
        int cont = 0;

        if (verificarIntegridad(escuela, 3)) {
            cont += db.delete("materia", "idescuela='" +
                    escuela.getId() + "'", null);
        }
        cont += db.delete("escuela", "idescuela='" +
                escuela.getId() + "'", null);
        return afectados += cont;
    }

    public String eliminar(Ciclo ciclo) {
        String afectados = "Filas afectadas: ";
        int cont = 0;

        if (verificarIntegridad(ciclo, 4)) {
            cont += db.delete("materia", "idciclo='" +
                    ciclo.getId() + "'", null);
        }
        cont += db.delete("ciclo", "idciclo='" +
                ciclo.getId() + "'", null);
        return afectados += cont;
    }

    public String eliminar(Materia materia) {
        String afectados = "Filas afectadas: ";
        int cont = 0;

        if (verificarIntegridad(materia, 7)) {
            cont += db.delete("laboratorio", "idmat='" +
                    materia.getId() + "'", null);
        }
        if (verificarIntegridad(materia, 8)) {
            cont += db.delete("teorico", "idmat='" +
                    materia.getId() + "'", null);
        }
        cont += db.delete("materia", "idmat='" +
                materia.getId() + "'", null);
        return afectados += cont;
    }
    //Fin SH15001

    //inicio NA15004
//Inserción
    public String insertar(Propuesta propuesta) {
        String regInsertados = "Registro insertado No. ";
        long contador = 0;

        ContentValues esc = new ContentValues();
        esc.put("idpropuesta", propuesta.getIdPropuesta());
        esc.put("idteorico", propuesta.getIdteorico());
        esc.put("idmat", propuesta.getIdMat());
        esc.put("idlab", propuesta.getIdLab());
        esc.put("idhorario", propuesta.getIdHorario());
        esc.put("idsalon", propuesta.getIdSalon());
        esc.put("iddia", propuesta.getIdDia());
        esc.put("aprobado", propuesta.getAprobado());
        contador = db.insert("propuesta", null, esc);
        if (contador == -1 || contador == 0) {
            regInsertados = "Error de inserción, registro duplicado. Verificar datos.";
        } else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }


    public String insertar(Horario horario) {
        String regInsertados = "Registro insertado No. ";
        long contador = 0;

        ContentValues esc = new ContentValues();
        esc.put("idhorario", horario.getidHorario());
        esc.put("iddia", horario.getidDia());
        esc.put("horainicio", getDateTime(horario.getHorainicio()));
        esc.put("horafin", getDateTime(horario.getHorafin()));
        contador = db.insert("horario", null, esc);
        if (contador == -1 || contador == 0) {
            regInsertados = "Error de inserción, registro duplicado. Verificar datos.";
        } else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    public String insertar(Laboratorio laboratorio) {
        String regInsertados = "Registro insertado No. ";
        long contador = 0;

        ContentValues esc = new ContentValues();
        esc.put("idmat", laboratorio.getidMat());
        esc.put("idlab", laboratorio.getidLab());
        contador = db.insert("laboratorio", null, esc);
        if (contador == -1 || contador == 0) {
            regInsertados = "Error de inserción, registro duplicado. Verificar datos.";
        } else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    //Consulta
    public Propuesta consultarPropuesta(String id) {
        String[] camposPropuesta = {"idpropuesta", "idteorico", "idmat", "idlab", "idhorario", "iddia", "idsalon", "aprobado"};
        String[] idPropuesta = {id};
        Cursor c = db.query("propuesta", camposPropuesta, "idpropuesta = ?", idPropuesta, null, null, null);
        if (c.moveToFirst()) {
            Propuesta propuesta = new Propuesta();
            propuesta.setIdPropuesta(c.getString(0));
            propuesta.setIdteorico(c.getString(1));
            propuesta.setIdMat(c.getString(2));
            propuesta.setIdLab(c.getString(3));
            propuesta.setIdHorario(c.getString(4));
            propuesta.setIdDia(c.getString(5));
            propuesta.setIdSalon(c.getString(6));
            propuesta.setAprobado(c.getString(7));
            return propuesta;
        } else return null;
    }

    public Laboratorio consultarLaboratorio(String id) {

        String[] camposidLaboratorio = {"idMat", "idLab",}, idLaboratorio = {id};
        Cursor cursor = db.query("laboratorio", camposidLaboratorio, "idlaboratorio = ?", idLaboratorio, null, null, null);
        if (cursor.moveToFirst()) {
            Laboratorio laboratorio = new Laboratorio();
            laboratorio.setidMat(cursor.getString(0));
            laboratorio.setidLab(cursor.getString(1));
            return laboratorio;
        } else {
            return null;
        }
    }

    public Horario consultarHorario(String id) throws ParseException{
        String[] camposHorario = {"idHorario", "idDia", "HoraInicio", "HoraFin"};
        String[] idHorario = {id};
        Cursor c = db.query("horario", camposHorario, "idHorario = ?", idHorario, null, null, null);
        if (c.moveToFirst()) {
            Horario horario = new Horario();
            horario.setidHorario(c.getString(0));
            horario.setidDia(c.getString(1));
            horario.setHorainicio(getStringDate(c.getString(2)));
            horario.setHorafin(getStringDate(c.getString(3)));
            return horario;
        } else return null;
    }

    //Actualización
    public String actualizar(Propuesta propuesta) {
        if (verificarIntegridad(propuesta, 27)) {
            String[] id = {propuesta.getIdPropuesta()};
            ContentValues cv = new ContentValues();

            cv.put("aprobado", propuesta.getAprobado());
            db.update("propuesta", cv, "idpropuesta = ?", id);
            return "¡Registro actualizado correctamente!";
        } else {
            return "La propuesta con id " + propuesta.getIdPropuesta() + " no existe.";
        }
    }

    public String actualizar(Laboratorio laboratorio) {
        if (verificarIntegridad(laboratorio, 28)) {
            String[] id = {laboratorio.getidLab()};
            ContentValues cv = new ContentValues();

            cv.put("laboratorio", laboratorio.getidLab());
            db.update("laboratorio", cv, "idlaboratorio = ?", id);
            return "¡Registro actualizado correctamente!";
        } else {
            return "El laboratorio con id " + laboratorio.getidLab() + " no existe";
        }
    }

    public String actualizar(Horario horario) {
        if (verificarIntegridad(horario, 29)) {
            String[] id = {horario.getidHorario()};
            ContentValues cv = new ContentValues();

            cv.put("horainicio", getDateTime(horario.getHorainicio()));
            cv.put("horafin", getDateTime(horario.getHorafin()));
            db.update("horario", cv, "idhorario = ?", id);
            return "¡Registro actualizado correctamente!";
        } else {
            return "El horario de materia " + horario.getidHorario() + " no existe.";
        }
    }

    //Eliminacion
    public String eliminar(Propuesta propuesta) {
        String afectados = "Filas afectadas: ";
        int cont = 0;

        if (verificarIntegridad(propuesta, 24)) {
            cont += db.delete("propuesta", "idpropuesta='" +
                    propuesta.getIdPropuesta() + "'", null);
        }
        cont += db.delete("propuesta", "idpropuesta='" +
                propuesta.getIdPropuesta() + "'", null);
        return afectados += cont;
    }

    public String eliminar(Laboratorio laboratorio) {
        String afectados = "Filas afectadas: ";
        int cont = 0;

        if (verificarIntegridad(laboratorio, 26)) {
            cont += db.delete("laboratorio", "idlab='" +
                    laboratorio.getidLab() + "'", null);
        }
        cont += db.delete("laboratorio", "idlab='" +
                laboratorio.getidLab() + "'", null);
        return afectados += cont;
    }

    public String eliminar(Horario horario) {
        String afectados = "Filas afectadas: ";
        int cont = 0;

        if (verificarIntegridad(horario, 25)) {
            cont += db.delete("horario", "idhorario='" +
                    horario.getidHorario() + "'", null);
        }
        cont += db.delete("horario", "idhorario='" +
                horario.getidHorario() + "'", null);
        return afectados += cont;
    }

    //Fin NA15004

    //Inicio metodos CRUD GM15003


    //Insertar registros
    public String insertar(Asignacion asignacion){
        String regInsertados = "Registro insertado No. ";
        long contador = 0;
        if(verificarIntegridad(asignacion, 9)){
            ContentValues cv = new ContentValues();
            cv.put("idpropuesta", asignacion.getIdPropuesta());
            cv.put("idhorario", asignacion.getIdHorario());
            cv.put("iddia", asignacion.getIdDia());
            contador = db.insert("asignacion", null, cv);
        }
        if(contador == -1 || contador ==0){
            regInsertados = "Error de inserción. ¡Verificar datos!";
        }
        else regInsertados = regInsertados + contador;
        return regInsertados;
    }

    public String insertar(Encargado encargado){
        String regInsertados = "Registro insertado No. ";
        long contador = 0;

        ContentValues cv = new ContentValues();
        cv.put("idencargado", encargado.getIdEncargado());
        cv.put("nombresencargado", encargado.getNombresEncargado());
        cv.put("apellidosencargado", encargado.getApellidosEncargado());
        contador = db.insert("encargado", null, cv);

        if(contador == -1 || contador ==0){
            regInsertados = "Error de inserción. ¡Verificar datos!";
        }
        else regInsertados = regInsertados + contador;
        return regInsertados;
    }

    public String insertar(Salon salon){
        String regInsertados = "Registro insertado No. ";
        long contador = 0;
        if(verificarIntegridad(salon, 10)){
            ContentValues cv = new ContentValues();
            cv.put("idsalon", salon.getIdSalon());
            cv.put("idencargado", salon.getIdEncargado());
            cv.put("tipo", salon.getTipo());
            cv.put("nombre", salon.getNombre());
            contador = db.insert("salon", null, cv);
        }
        if(contador == -1 || contador ==0){
            regInsertados = "Error de inserción. ¡Verificar datos!";
        }
        else regInsertados = regInsertados + contador;
        return regInsertados;
    }


    //Consultar registros
    public Asignacion consultarAsignacion(String idPropuesta)  {

        String[] camposAsignacion = {"idpropuesta", "idhorario", "iddia"}, idPro = {idPropuesta};
        Cursor cursor = db.query("asignacion", camposAsignacion, "idpropuesta = ?", idPro, null, null, null );
        if(cursor.moveToFirst()){
            Asignacion asignacion = new Asignacion();
            asignacion.setIdPropuesta(cursor.getString(0));
            asignacion.setIdHorario(cursor.getString(1));
            asignacion.setIdDia(cursor.getString(2));
            return asignacion;
        }
        else {
            return null;
        }
    }

    public Encargado consultarEncargado(String idEncargado){
        String[] camposEncargado = {"idencargado", "nombreencargado", "apellidoencargado"};
        String[] idEnc = {idEncargado};
        Cursor c = db.query("encargado", camposEncargado, "idenc = ?", idEnc, null, null, null);
        if(c.moveToFirst()){
            Encargado encargado = new Encargado();
            encargado.setIdEncargado(c.getString(0));
            encargado.setNombresEncargado(c.getString(1));
            encargado.setApellidosEncargado(c.getString(2));
            return encargado;
        }
        else return null;
    }

    public Salon consultarSalon(String idSalon){
        String[] camposSalon = {"idsalon", "idencargado", "tipo", "nombre"};
        String[] idSal = {idSalon};
        Cursor c = db.query("salon", camposSalon, "idsal = ?", idSal, null, null, null);
        if(c.moveToFirst()){
            Salon salon = new Salon();
            salon.setIdSalon(c.getString(0));
            salon.setIdEncargado(c.getString(1));
            salon.setTipo(c.getString(2));
            salon.setNombre(c.getString(3));
            return salon;
        }
        else return null;
    }

    //Actualizar registros
    public String actualizar(Asignacion asignacion){
        if(verificarIntegridad(asignacion, 11)){
            String[] idPropuesta = {asignacion.getIdPropuesta()};
            ContentValues cv = new ContentValues();

            cv.put("idhorario", asignacion.getIdHorario());
            cv.put("iddia", asignacion.getIdDia());
            db.update("asignacion", cv, "idpropuesta = ?", idPropuesta);
            return "¡Registro actualizado correctamente!";
        }
        else{
            return "La asignacion con id "+asignacion.getIdPropuesta()+" no existe";
        }
    }

    public String actualizar(Encargado encargado){
        if(verificarIntegridad(encargado, 12)){
            String[] idEncargado = {encargado.getIdEncargado()};
            ContentValues cv = new ContentValues();

            cv.put("nombresencargado", encargado.getNombresEncargado());
            cv.put("apellidosencargado", encargado.getApellidosEncargado());
            db.update("encargado", cv, "idencargado = ?", idEncargado);
            return "¡Registro actualizado correctamente!";
        }
        else{
            return "El encargado con id "+encargado.getIdEncargado()+" no existe.";
        }
    }

    public String actualizar(Salon salon){
        if(verificarIntegridad(salon, 13)){
            String[] idSalon = {salon.getIdSalon()};
            ContentValues cv = new ContentValues();

            cv.put("idencargado", salon.getIdEncargado());
            cv.put("tipo", salon.getTipo());
            cv.put("nombre", salon.getNombre());
            db.update("salon", cv, "idsalon = ?", idSalon);
            return "¡Registro actualizado correctamente!";
        }
        else{
            return "El salon con id "+salon.getIdSalon()+" no existe.";
        }
    }

    //Eliminar registros
    public String eliminar(Asignacion asignacion){
        String afectados = "Filas afectadas: ";
        int cont = 0;

        if(verificarIntegridad(asignacion,14)){
            cont += db.delete("asignacion", "idpropuesta='"+
                    asignacion.getIdPropuesta()+"'", null);
        }
        cont += db.delete("asignacion", "idpropuesta='"+
                asignacion.getIdPropuesta()+"'", null);
        return afectados+=cont;
    }

    public String eliminar(Encargado encargado){
        String afectados = "Filas afectadas: ";
        int cont = 0;

        if(verificarIntegridad(encargado,15)){
            cont += db.delete("encargado", "idencargado='"+
                    encargado.getIdEncargado()+"'", null);
        }
        cont += db.delete("encargado", "idencargado='"+
                encargado.getIdEncargado()+"'", null);
        return afectados+=cont;
    }

    public String eliminar(Salon salon){
        String afectados = "Filas afectadas: ";
        int cont = 0;

        if(verificarIntegridad(salon,16)){
            cont += db.delete("salon", "idsalon='"+
                    salon.getIdSalon()+"'", null);
        }
        cont += db.delete("salon", "idsalon='"+
                salon.getIdSalon()+"'", null);
        return afectados+=cont;
    }

    //Fin GM15003

    //Métodos CRUD DM15001
    //Inserción
    public String insertar(Evento evento){
        String regInsertados = "Registro insertado No. ";
        long contador = 0;

        ContentValues esc = new ContentValues();
        esc.put("idevento", evento.getIdEvento());
        esc.put("nombreevento", evento.getNombreEvento());
        esc.put("descripcion", evento.getDescripcion());
        contador = db.insert("evento", null, esc);
        if (contador==-1 || contador == 0){
            regInsertados = "Error de inserción, registro duplicado. Verificar datos.";
        }
        else{
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    public String insertar(Dia dia){
        String regInsertados = "Registro insertado No. ";
        long contador = 0;

        ContentValues cv = new ContentValues();
        cv.put("iddia", dia.getIdDia());
        cv.put("nombredia", dia.getNombreDia());
        contador = db.insert("dia", null, cv);
        if (contador==-1 || contador == 0){
            regInsertados = "Error de inserción, registro duplicado. Verificar datos.";
        }
        else{
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    public String insertar(DetalleEvento detalleevento){
        String regInsertados = "Registro insertado No. ";
        long contador = 0;
        if(verificarIntegridad(detalleevento, 21)){
            ContentValues cv = new ContentValues();
            cv.put("idevento", detalleevento.getIdEvento());
            cv.put("idsalon", detalleevento.getIdSalon());
            cv.put("idhorario", detalleevento.getIdHorario());
            cv.put("iddia", detalleevento.getIdDia());
            contador = db.insert("detalleevento", null, cv);
        }
        if(contador == -1 || contador ==0){
            regInsertados = "Error de inserción. ¡Verificar datos!";
        }
        else regInsertados = regInsertados + contador;
        return regInsertados;
    }

    //Consulta
    public Evento consultarEvento(String id){

        String[] camposEvento = {"idevento", "nombreevento", "descripcion"}, idevento = {id};
        Cursor cursor = db.query("evento", camposEvento, "idevento = ?", idevento, null, null, null );
        if(cursor.moveToFirst()){
            Evento evento = new Evento();
            evento.setIdEvento(cursor.getString(0));
            evento.setNombreEvento(cursor.getString(1));
            evento.setDescripcion(cursor.getString(2));
            return evento;
        }
        else {
            return null;
        }
    }

    public Dia consultarDia(String id)  {

        String[] camposDia = {"iddia", "nombredia"}, iddia = {id};
        Cursor cursor = db.query("dia", camposDia, "iddia= ?", iddia, null, null, null );
        if(cursor.moveToFirst()){
            Dia dia = new Dia();
            dia.setIdDia(cursor.getString(0));
            dia.setNombreDia(cursor.getString(1));

            return dia;
        }
        else {
            return null;
        }
    }

    public DetalleEvento consultarDetalleEvento(String id){
        String[] camposDetalleEvento = {"idevento", "idsalon", "idhorario", "iddia"};
        String[] idEvento = {id};
        Cursor cursor = db.query("detalleevento", camposDetalleEvento, "idevento = ?", idEvento, null, null, null);
        if(cursor.moveToFirst()){
            DetalleEvento detalleevento = new DetalleEvento();
            detalleevento.setIdEvento(cursor.getString(0));
            detalleevento.setIdSalon(cursor.getString(1));
            detalleevento.setIdHorario(cursor.getString(2));
            detalleevento.setIdDia(cursor.getString(3));

            return detalleevento;
        }
        else return null;
    }

    //Actualización
    public String actualizar(Evento evento){
        if(verificarIntegridad(evento, 17)){
            String[] id = {evento.getIdEvento()};
            ContentValues cv = new ContentValues();

            cv.put("nombreevento", evento.getNombreEvento());
            cv.put("descripcion", evento.getDescripcion());
            db.update("evento", cv, "idevento = ?", id);
            return "¡Registro actualizado correctamente!";
        }
        else{
            return "La evento con id "+evento.getIdEvento()+" no existe.";
        }
    }

    public String actualizar(Dia dia){
        if(verificarIntegridad(dia, 18)){
            String[] id = {dia.getIdDia()};
            ContentValues cv = new ContentValues();

            cv.put("nombredia", dia.getNombreDia());
            db.update("dia", cv, "iddia = ?", id);
            return "¡Registro actualizado correctamente!";
        }
        else{
            return "El dia con id "+dia.getIdDia()+" no existe";
        }
    }

    public String actualizar(DetalleEvento detalleevento){
        if (verificarIntegridad(detalleevento, 22)){
            String[] id = {detalleevento.getIdEvento()};
            ContentValues cv = new ContentValues();

            cv.put("idevento", detalleevento.getIdEvento());
            cv.put("idsalon", detalleevento.getIdSalon());
            cv.put("idhorario", detalleevento.getIdHorario());
            cv.put("iddia", detalleevento.getIdDia());
            db.update("detalleevento", cv, "idevento = ?", id);
            return "¡Registro actualizado correctamente!";
        }
        else{
            return "El código de evento "+detalleevento.getIdEvento()+" no existe.";
        }
    }

    //Eliminacion
    public String eliminar(Evento evento){
        String afectados = "Filas afectadas: ";
        int cont = 0;

        if (verificarIntegridad(evento, 19)){
            cont += db.delete("detalleevento", "idevento='"+
                    evento.getIdEvento()+"'", null);
        }
        cont += db.delete("evento", "idevento='"+
                evento.getIdEvento()+"'", null);
        return afectados+=cont;
    }

    public String eliminar(Dia dia){
        String afectados = "Filas afectadas: ";
        int cont = 0;

        if(verificarIntegridad(dia, 23)){
            cont += db.delete("horario", "iddia='"+
                    dia.getIdDia()+"'", null);
        }
        if(verificarIntegridad(dia, 20)){
            cont += db.delete("detalleevento", "iddia='"+
                    dia.getIdDia()+"'", null);
        }
        cont += db.delete("dia", "iddia='"+
                dia.getIdDia()+"'", null);
        return afectados+=cont;
    }

    public String eliminar(DetalleEvento detalleevento){
        String afectados = "Filas afectadas: ";
        int cont = 0;
        cont += db.delete("detalleevento", "idevento='"+
                detalleevento.getIdEvento()+"'", null);
        return afectados+=cont;
    }
    //Fin DM15001

    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException {
        switch (relacion) {
            case 1: {//verificación de existencia de escuela
                Escuela escuela = (Escuela) dato;
                String[] id = {escuela.getId()};

                abrir();
                Cursor cursor = db.query("escuela", null, "idescuela = ?", id, null, null, null);
                //cerrar();
                if (cursor.moveToFirst()) {
                    return true;
                }
                return false;
            }

            case 2: {//verificación de existencia de ciclo
                Ciclo ciclo = (Ciclo) dato;
                String[] id = {ciclo.getId()};

                abrir();
                Cursor cursor = db.query("ciclo", null, "idciclo = ?", id, null, null, null);
                //cerrar();
                if (cursor.moveToFirst()) {
                    return true;
                }
                return false;
            }

            case 3: {//verifica si hay materia(s) impartida por la escuela
                Escuela escuela = (Escuela) dato;
                String[] id = {"idescuela"};
                Cursor c = db.query(true, "materia", id, "idescuela='"
                        + escuela.getId() + "'", null, null, null, null, null);
                if (c.moveToFirst()) {
                    return true;
                } else {
                    return false;
                }
            }

            case 4: {//verifica si hay materia(s) impartida en el ciclo
                Ciclo ciclo = (Ciclo) dato;
                String[] id = {"idciclo"};
                Cursor c = db.query(true, "materia", id, "idciclo='" +
                        ciclo.getId() + "'", null, null, null, null, null);
                if (c.moveToFirst())
                    return true;
                else
                    return false;
            }

            case 5: {//Verifica que existan las llaves foraneas
                Materia materia = (Materia) dato;
                String[] id1 = {materia.getIdEscuela()};
                String[] id2 = {materia.getIdCiclo()};
                String[] id3 = {materia.getCarnetDocente()};

                Cursor c1 = db.query("escuela", null, "idescuela = ?", id1, null, null, null);
                Cursor c2 = db.query("ciclo", null, "idciclo = ?", id2, null, null, null);
                Cursor c3 = db.query("docente", null, "carnetdocente = ?", id3, null, null, null);
                if (c1.moveToFirst() && c2.moveToFirst() || c3.moveToFirst()) { //Cambiar a && cuando existan datos de docente
                    return true;
                }
                return false;

            }

            case 6: {//Verificar existencia de Materia
                Materia materia = (Materia) dato;
                String[] id = {materia.getId()};
                abrir();
                Cursor c = db.query("Materia", null, "idmat = ?", id, null, null, null);
                if (c.moveToFirst()) return true;
                else return false;

            }

            case 7: {
                Materia materia = (Materia) dato;
                String[] id = {"idmat"};
                Cursor c = db.query(true, "teorico", id, "idmat='" +
                        materia.getId() + "'", null, null, null, null, null);
                if (c.moveToFirst()) return true;
                else return false;
            }

            case 8: {
                Materia materia = (Materia) dato;
                String[] id = {"idmat"};
                Cursor c = db.query(true, "laboratorio", id, "idmat='" +
                        materia.getId() + "'", null, null, null, null, null);
                if (c.moveToFirst()) return true;
                else return false;
            }

            case 9:{
                Asignacion asignacion = (Asignacion) dato;
                String[] id1 = {asignacion.getIdPropuesta()};
                String[] id2 = {asignacion.getIdHorario()};
                String[] id3 = {asignacion.getIdDia()};

                Cursor c1 = db.query("propuesta", null, "idpropuesta = ?", id1, null, null, null);
                Cursor c2 = db.query("horario", null, "idhorario = ?", id2, null, null, null);
                Cursor c3 = db.query("dia", null, "iddia = ?", id3, null, null, null);
                if(c1.moveToFirst() && c2.moveToFirst() || c3.moveToFirst()){ //Cambiar a && cuando existan datos de docente
                    return true;
                }
                return false;
            }

            case 10:{
                Salon salon = (Salon) dato;
                String[] id1 = {salon.getIdEncargado()};

                Cursor c1 = db.query("encargado", null, "idencargado = ?", id1, null, null, null);

                if(c1.moveToFirst()){
                    return true;
                }
                return false;
            }

            case 11:{
                Asignacion asignacion = (Asignacion) dato;
                String[] idPropuesta = {asignacion.getIdPropuesta()};

                abrir();
                Cursor cursor = db.query("asignacion", null, "idpropuesta = ?", idPropuesta, null, null, null);
                //cerrar();
                if (cursor.moveToFirst()) {
                    return true;
                }
                return false;
            }

            case 12:{
                Encargado encargado = (Encargado) dato;
                String[] idEncargado = {encargado.getIdEncargado()};

                abrir();
                Cursor cursor = db.query("encargado", null, "idencargado = ?", idEncargado, null, null, null);
                //cerrar();
                if (cursor.moveToFirst()) {
                    return true;
                }
                return false;
            }

            case 13:{
                Salon salon = (Salon) dato;
                String[] idSalon = {salon.getIdSalon()};

                abrir();
                Cursor cursor = db.query("salon", null, "idsalon = ?", idSalon, null, null, null);
                //cerrar();
                if (cursor.moveToFirst()) {
                    return true;
                }
                return false;
            }

            case 14:{
                Asignacion asignacion = (Asignacion) dato;
                String[] idPropuesta = {"idpropuesta"};
                Cursor c = db.query(true, "asignacion", idPropuesta, "idpropuesta='"+
                        asignacion.getIdPropuesta()+"'", null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }

            case 15:{
                Encargado encargado = (Encargado) dato;
                String[] idEncargado = {"idencargado"};
                Cursor c = db.query(true, "encargado", idEncargado, "idencargado='"+
                        encargado.getIdEncargado()+"'", null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }

            case 16:{
                Salon salon = (Salon) dato;
                String[] idSalon = {"idsalon"};
                Cursor c = db.query(true, "salon", idSalon, "idsalon='"+
                        salon.getIdSalon()+"'", null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }
            case 17:{//verificación de existencia de evento
                Evento evento = (Evento) dato;
                String[] id = {evento.getIdEvento()};

                abrir();
                Cursor cursor = db.query("evento", null, "idevento = ?", id, null, null, null);
                //cerrar();
                if(cursor.moveToFirst()){
                    return true;
                }
                return false;
            }

            case 18:{//verificación de existencia de dia
                Dia dia = (Dia) dato;
                String[] id = {dia.getIdDia()};

                abrir();
                Cursor cursor = db.query("dia", null, "iddia = ?", id, null, null, null);
                //cerrar();
                if (cursor.moveToFirst()) {
                    return true;
                }
                return false;
            }

            case 19:{//verifica si hay detalles de los eventos
                Evento evento = (Evento) dato;
                String[] id = {"idevento"};
                Cursor c = db.query(true, "detalleevento", id,  "idevento='"
                        +evento.getIdEvento()+"'", null, null, null, null, null);
                if(c.moveToFirst()){
                    return true;
                }
                else{
                    return false;
                }
            }

            case 20:{//verifica si hay detalleevento contenido en el dia
                Dia dia = (Dia) dato;
                String[] id = {"iddia"};
                Cursor c = db.query(true, "detalleevento", id, "iddia='"+
                        dia.getIdDia()+"'", null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }


            case 21:{//Verifica que existan las llaves foraneas
                DetalleEvento detalleevento = (DetalleEvento) dato;
                String[] id1 = {detalleevento.getIdEvento()};
                String[] id2 = {detalleevento.getIdSalon()};
                String[] id3 = {detalleevento.getIdHorario()};
                String[] id4 = {detalleevento.getIdDia()};

                Cursor c1 = db.query("evento", null, "idevento = ?", id1, null, null, null);
                Cursor c2 = db.query("salon", null, "idsalon = ?", id2, null, null, null);
                Cursor c3 = db.query("horario", null, "idhorario = ?", id3, null, null, null);
                Cursor c4 = db.query("dia", null, "iddia = ?", id4, null, null, null);
                if(c1.moveToFirst() && c4.moveToFirst() || c3.moveToFirst() || c2.moveToFirst()){ //Cambiar a && cuando existan datos de salon y horario
                    return true;
                }
                return false;

            }

            case 22:{//Verificar existencia de DetalleEvento
                DetalleEvento detalleevento = (DetalleEvento) dato;
                String[] id = {detalleevento.getIdEvento()};
                abrir();
                Cursor c = db.query("detalleevento", null, "idevento = ?", id, null, null, null);
                if(c.moveToFirst()) return true;
                else return false;

            }

            case 23:{//verificar si hay horario contenido en el dia
                Dia dia = (Dia) dato;
                String[] id = {"iddia"};
                Cursor c = db.query(true, "horario", id, "iddia='"+
                        dia.getIdDia()+"'", null, null, null, null, null);
                if (c.moveToFirst()) return true;
                else return false;
            }

            case 24: {//verificación de existencia de propuesta
                Propuesta propuesta = (Propuesta) dato;
                String[] id = {propuesta.getIdPropuesta()};

                abrir();
                Cursor cursor = db.query("propuesta", null, "idpropuesta = ?", id, null, null, null);
                //cerrar();
                if (cursor.moveToFirst()) {
                    return true;
                }
                return false;
            }

            case 25: {//verificación de existencia de Horario
                Horario horario = (Horario) dato;
                String[] id = {horario.getidDia()};

                abrir();
                Cursor cursor = db.query("horario", null, "iddia = ?", id, null, null, null);
                //cerrar();
                if (cursor.moveToFirst()) {
                    return true;
                }
                return false;
            }

            case 26: {//verificación de existencia de Laboratorio
                Laboratorio laboratorio = (Laboratorio) dato;
                String[] id = {laboratorio.getidLab()};

                abrir();
                Cursor cursor = db.query("laboratorio", null, "idlab = ?", id, null, null, null);
                //cerrar();
                if (cursor.moveToFirst()) {
                    return true;
                }
                return false;
            }

            case 27: {//Verifica que existan las llaves foraneas
                Propuesta propuestaforeneas = (Propuesta) dato;
                String[] id1 = {propuestaforeneas.getIdteorico()};
                String[] id2 = {propuestaforeneas.getIdMat()};
                String[] id3 = {propuestaforeneas.getIdLab()};

                Cursor c1 = db.query("teorico", null, "idteorico = ?", id1, null, null, null);
                Cursor c2 = db.query("materia", null, "idmateria = ?", id2, null, null, null);
                Cursor c3 = db.query("laboratorio", null, "idlaboratorio = ?", id3, null, null, null);
                if (c1.moveToFirst() && c2.moveToFirst() || c3.moveToFirst()) {
                    return true;
                }
                return false;

            }

                case 28: {//Verifica que existan las llaves foraneas
                    Laboratorio laboratorioforeneas = (Laboratorio) dato;
                    String[] id1 = {laboratorioforeneas.getidMat()};

                    Cursor c1 = db.query("materia", null, "idteorico = ?", id1, null, null, null);
                    if (c1.moveToFirst()) {
                        return true;
                    }
                    return false;

            }

                    case 29: {//Verifica que existan las llaves foraneas
                        Horario horarioforeneas = (Horario) dato;
                        String[] id1 = {horarioforeneas.getidDia()};

                        Cursor c1 = db.query("iddia", null, "iddia = ?", id1, null, null, null);
                        if (c1.moveToFirst()) {
                            return true;
                        }
                        return false;

            }

                        default:
                            return false;
                    }


                }

                public String llenarBD () throws ParseException {
                    final String[] Vidciclo = {"P2019", "I2020", "P2020", "I2021", "P2021"};
                    final Date[] Vfechainicio = {
                            getStringDate("2019-08-19 00:00:00"), getStringDate("2020-02-18 00:00:00"), getStringDate("2020-08-10 00:00:00"), getStringDate("2021-02-18 00:00:00"), getStringDate("2021-08-10 00:00:00")
                    };
                    final Date[] Vfechafin = {
                            getStringDate("2019-12-15 00:00:00"), getStringDate("2020-07-30 00:00:00"), getStringDate("2021-01-15 00:00:00"), getStringDate("2021-08-08 00:00:00"), getStringDate("2021-12-10 00:00:00")
                    };
                    final String[] Videscuela = {"EISI", "EA", "EIM", "EII", "UCB"};
                    final String[] Vnomescuela = {"Escuela de Ingenieria de Sistemas Informaticos", "Escuela de Arquitectura", "Escuela de Ingenieria Mecanica",
                            "Escuela de Ingenieria Industrial", "Unidad de Ciencias Basicas"};
                    final String[] Vcarnetmateria = {"SH15001", "HH15002", "SS15003"};
                    abrir();
                    db.execSQL("DELETE FROM ciclo");
                    db.execSQL("DELETE FROM escuela");
                    db.execSQL("DELETE FROM materia");
                    db.execSQL("DELETE FROM usuario");
                    db.execSQL("DELETE FROM accesousuario");
                    db.execSQL("DELETE FROM opcioncrud");

                    for (int i = 0; i < 5; i++) {
                        Ciclo ciclo = new Ciclo(Vidciclo[i], Vfechainicio[i], Vfechafin[i]);
                        insertar(ciclo);
                    }
                    for (int i = 0; i < 5; i++) {
                        Escuela escuela = new Escuela(Videscuela[i], Vnomescuela[i]);
                        insertar(escuela);
                    }

                    Materia mate1 = new Materia("MAT115", Vidciclo[1], Videscuela[4], "Matematicas 1", Vcarnetmateria[0]);
                    Materia prn1 = new Materia("PRN115", Vidciclo[3], Videscuela[0], "Programacion 1", Vcarnetmateria[1]);
                    Materia bad1 = new Materia("BAD115", Vidciclo[2], Videscuela[0], "Bases de Datos", Vcarnetmateria[2]);
                    insertar(mate1);
                    insertar(prn1);
                    insertar(bad1);
                    /*^^^^^datos para escuela, ciclo y materia^^^^^^^*/

                    final String[] Vusuario = {"admin", "krlos", "albrto", "herni"};
                    Usuario admin = new Usuario(Vusuario[0], "admin123", "Administrador");
                    Usuario carlos = new Usuario(Vusuario[1], "Ch1q2", "Carlos Argueta");
                    Usuario alberto = new Usuario(Vusuario[2], "jA3f2", "Alberto Luna");
                    Usuario hernan = new Usuario(Vusuario[3], "gD21d", "Hernan Morales");
                    insertar(admin);
                    insertar(carlos);
                    insertar(alberto);
                    insertar(hernan);

                    String[] Vtablas = {"Escuela", "Ciclo", "Materia", "Docente", "Rol de docente", "Teorico", "Evento", "Detalle Evento", "Dia", "Asignación", "Encargado", "Salón", "Laboratorio", "Horario", "Propuesta"};
                    for (int i = 0; i < 15; i++) {
                        OpcionCrud crud = new OpcionCrud(String.valueOf(i), "Menu de " + Vtablas[i], i);
                        insertar(crud);
                    }

                    for (int i = 0; i < 17; i++) {
                        AccesoUsuario acceso = new AccesoUsuario(Vusuario[0], String.valueOf(i));
                        insertar(acceso);
                    }

                    for (int i = 0; i < 7; i++) {
                        AccesoUsuario acceso = new AccesoUsuario(Vusuario[1], String.valueOf(i));
                        insertar(acceso);
                    }

                    for (int i = 7; i < 15; i++) {
                        AccesoUsuario acceso = new AccesoUsuario(Vusuario[2], String.valueOf(i));
                        insertar(acceso);
                    }

                    for (int i = 0; i < 15; i = i + 2) {
                        AccesoUsuario acceso = new AccesoUsuario(Vusuario[3], String.valueOf(i));
                        insertar(acceso);
                    }

                    /*^^^^^datos para usuarios y permisos^^^^^^^*/

        //llenar tablas evento, detalle evento y dia
        final String[] Videvento = {"E0001", "E0002", "E0003", "E0004", "E0005"};
        final String[] Vnomevento = {"Parciales", "Diferidos", "Repetidos", "Suficiencia", "Conferencias"};
        final String[] Vdescripcion = {"Evaluaciones ordinarias", "Evaluaciones extraordinarias", "Evaluaciones repetidas", "Ultimo examen", "Charlas sobre las materias"};


        final String[] Viddia = {"LUNES", "MARTE", "MIERC", "JUEVE", "VIERN"};
        final String[] Vnomdia = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};

        final String[] Vidsalon = {"SAB41", "SAC11", "SAD11"};
        final String[] Vidhorario = {"MATUT", "VESPE", "NOCTU"};

        abrir();
        db.execSQL("DELETE FROM dia");
        db.execSQL("DELETE FROM evento");
        db.execSQL("DELETE FROM detalleevento");

        for(int i=0; i<5; i++){
            Dia dia = new Dia(Viddia[i], Vnomdia[i]);
            insertar(dia);
        }
        for(int i=0; i<5; i++){
            Evento evento = new Evento(Videvento[i], Vnomevento[i], Vdescripcion[i]);
            insertar(evento);
        }

        DetalleEvento detalleevento1 = new DetalleEvento(Vidsalon[1], Videvento[1], Vidhorario[0],  Viddia[0]);
        DetalleEvento detalleevento2 = new DetalleEvento(Vidsalon[2], Videvento[3], Vidhorario[1],  Viddia[1]);
        DetalleEvento detalleevento3 = new DetalleEvento(Vidsalon[0], Videvento[2], Vidhorario[2],  Viddia[2]);
        insertar(detalleevento1);
        insertar(detalleevento2);
        insertar(detalleevento3);
        //fin llenar tablas evento, detalle evento y dia

                    //llenar tablas Asignacion, Encargado, Salon
                    final String[] Vidpropuesta = {"P0001", "P0002", "P0003", "P0004", "P0005"};

                    final String[] Videncargado = {"EN001", "EN002", "EN003", "EN004", "EN005"};
                    final String[] Vnombresencargado = {"Jose Alejandro", "Ernesto Benjamin", "Isaac Roberto", "Maria Elizabeth", "Rosa Margarita"};
                    final String[] Vapellidosencargado = {"Castro Martinez", "Mendez Nuñes", "Guerrero Lopez", "Rivas Hernandez", "Cortez Ardon"};

                    final String[] Vtipo = {"Salon pequeño", "Salon grande", "Salon grande"};
                    final String[] Vnombre = {"C41", "C11", "D11", "LCOMP"};

                    abrir();
                    db.execSQL("DELETE FROM asignacion");
                    db.execSQL("DELETE FROM encargado");
                    db.execSQL("DELETE FROM salon");

                    for(int i=0; i<5; i++){
                        Encargado encargado = new Encargado(Videncargado[i], Vnombresencargado[i],  Vapellidosencargado[i]);
                        insertar(encargado);
                    }

                    Salon salon = new Salon(Vidsalon[0], Videncargado[0], Vtipo[0], Vnombre[0]);
                    Salon salon1 = new Salon(Vidsalon[1], Videncargado[1], Vtipo[1], Vnombre[1]);
                    Salon salon2 = new Salon(Vidsalon[2], Videncargado[2], Vtipo[2], Vnombre[2]);
                    insertar(salon);
                    insertar(salon1);
                    insertar(salon2);


                    Asignacion asignacion1 = new Asignacion(Vidpropuesta[0], Vidhorario[0], Viddia[0]);
                    Asignacion asignacion2 = new Asignacion(Vidpropuesta[1], Vidhorario[1], Viddia[1]);
                    Asignacion asignacion3 = new Asignacion(Vidpropuesta[2], Vidhorario[2], Viddia[2]);
                    Asignacion asignacion4 = new Asignacion(Vidpropuesta[3], Vidhorario[1], Viddia[3]);
                    Asignacion asignacion5 = new Asignacion(Vidpropuesta[4], Vidhorario[2], Viddia[4]);
                    insertar(asignacion1);
                    insertar(asignacion2);
                    insertar(asignacion3);
                    insertar(asignacion4);
                    insertar(asignacion5);
                    //Fin tablas Asingacion, encargado, salon

                    //llenar tablas Propuesta, Laboratorio, Horario

                    final String[] Vidteorico = {"TE01", "TE02", "TE03", "TE04", "TE05"};
                    final String[] Vidmat = {"PRN115", "MAT115", "PDM115", "TAD115", "HDP115"};
                    final String[] Vidlab = {"LA01", "LA02", "LA03", "LA04", "LA05"};
                    final String[] Vaprobado = {"SI", "NO", "PENDIENTE"};

                    final Date[] Vhorainicio = {getStringDate("2021-08-15 16:00:00"), getStringDate("2021-08-30 10:00:00"), getStringDate("2021-10-15 09:00:00"), getStringDate("2021-08-08 00:00:00"), getStringDate("2021-09-10 08:00:00")};
                    final Date[] Vhorafin = {getStringDate("2021-08-15 17:30:00"), getStringDate("2021-08-30 10:30:00"), getStringDate("2021-10-15 10:30:00"), getStringDate("2021-08-08 00:00:00"), getStringDate("2021-09-10 11:00:00")};

                    abrir();
                    db.execSQL("DELETE FROM propuesta");
                    db.execSQL("DELETE FROM laboratorio");
                    db.execSQL("DELETE FROM horario");

                    Propuesta propuesta1 = new Propuesta(Vidpropuesta[0], Vidteorico[0], Vidmat[0], Vidlab[0], Vidhorario[0], Viddia[0], Vidsalon[0], Vaprobado[0]);
                    Propuesta propuesta2 = new Propuesta(Vidpropuesta[1], Vidteorico[1], Vidmat[1], Vidlab[1], Vidhorario[1], Viddia[1], Vidsalon[1], Vaprobado[1]);
                    Propuesta propuesta3 = new Propuesta(Vidpropuesta[2], Vidteorico[2], Vidmat[2], Vidlab[2], Vidhorario[2], Viddia[2], Vidsalon[2], Vaprobado[2]);
                    Propuesta propuesta4 = new Propuesta(Vidpropuesta[3], Vidteorico[3], Vidmat[3], Vidlab[3], Vidhorario[0], Viddia[3], Vidsalon[1], Vaprobado[1]);
                    Propuesta propuesta5 = new Propuesta(Vidpropuesta[4], Vidteorico[4], Vidmat[4], Vidlab[4], Vidhorario[1], Viddia[4], Vidsalon[2], Vaprobado[2]);
                    insertar(propuesta1);
                    insertar(propuesta2);
                    insertar(propuesta3);
                    insertar(propuesta3);
                    insertar(propuesta4);
                    insertar(propuesta5);

                    for(int i=0; i<5; i++){
                        Laboratorio laboratorio = new Laboratorio(Vidmat[i], Vidlab[i]);
                        insertar(laboratorio);
                    }

                    Horario horario1 = new Horario(Vidhorario[0], Viddia[0], Vhorainicio[4], Vhorafin[4]);
                    Horario horario2 = new Horario(Vidhorario[1], Viddia[1], Vhorainicio[3], Vhorafin[3]);
                    Horario horario3 = new Horario(Vidhorario[2], Viddia[2], Vhorainicio[2], Vhorafin[2]);
                    Horario horario4 = new Horario(Vidhorario[0], Viddia[3], Vhorainicio[1], Vhorafin[1]);
                    Horario horario5 = new Horario(Vidhorario[1], Viddia[4], Vhorainicio[0], Vhorafin[0]);

                    insertar(horario1);
                    insertar(horario2);
                    insertar(horario3);
                    insertar(horario4);
                    insertar(horario5);


                    cerrar();
        return "Se realizó correctamente";
    }
}