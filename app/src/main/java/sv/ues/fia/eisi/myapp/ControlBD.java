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
                        "   APROBADO             SMALLINT                        not null,\n" +
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
    public String insertar(Escuela escuela){
        String regInsertados = "Registro insertado No. ";
        long contador = 0;

        ContentValues esc = new ContentValues();
        esc.put("idescuela", escuela.getId());
        esc.put("nombreescuela", escuela.getNombre());
        contador = db.insert("escuela", null, esc);
        if (contador==-1 || contador == 0){
            regInsertados = "Error de inserción, registro duplicado. Verificar datos.";
        }
        else{
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    public String insertar(Ciclo ciclo){
        String regInsertados = "Registro insertado No. ";
        long contador = 0;

        ContentValues cv = new ContentValues();
        cv.put("idciclo", ciclo.getId());
        cv.put("fechainicio", getDateTime(ciclo.getInicio()));
        cv.put("fechafin", getDateTime(ciclo.getFin()));
        contador = db.insert("ciclo", null, cv);
        if (contador==-1 || contador == 0){
            regInsertados = "Error de inserción, registro duplicado. Verificar datos.";
        }
        else{
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    public String insertar(Materia materia){
        String regInsertados = "Registro insertado No. ";
        long contador = 0;
        if(verificarIntegridad(materia, 5)){
            ContentValues cv = new ContentValues();
            cv.put("idmat", materia.getId());
            cv.put("idciclo", materia.getIdCiclo());
            cv.put("idescuela", materia.getIdEscuela());
            cv.put("carnetdocente", materia.getCarnetDocente());
            cv.put("nombremateria", materia.getNombre());
            contador = db.insert("materia", null, cv);
        }
        if(contador == -1 || contador ==0){
            regInsertados = "Error de inserción. ¡Verificar datos!";
        }
        else regInsertados = regInsertados + contador;
        return regInsertados;
    }

    public String insertar(Usuario usuario){
        String regInsertados = "Registro insertado No. ";
        long contador = 0;

        ContentValues esc = new ContentValues();
        esc.put("usuario", usuario.getUsuario());
        esc.put("contrasenia", usuario.getCont());
        esc.put("nombreusuario", usuario.getNombre());
        contador = db.insert("usuario", null, esc);
        if (contador==-1 || contador == 0){
            regInsertados = "Error de inserción, registro duplicado. Verificar datos.";
        }
        else{
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    public void insertar(AccesoUsuario acceso){
        ContentValues cv = new ContentValues();
        cv.put("usuario", acceso.getUsuario());
        cv.put("idopcion", acceso.getIdopcion());
        db.insert("accesousuario", null, cv);
    }

    public void insertar(OpcionCrud opcion){
        ContentValues cv = new ContentValues();
        cv.put("idopcion", opcion.getIdopcion());
        cv.put("descripcionop", opcion.getDescripcion());
        cv.put("numcrud", opcion.getNumcrud());
        db.insert("opcioncrud", null, cv);
    }

    //Consulta
    public Escuela consultarEscuela(String id){

        String[] camposEscuela = {"idescuela", "nombreescuela"}, idescuela = {id};
        Cursor cursor = db.query("escuela", camposEscuela, "idescuela = ?", idescuela, null, null, null );
        if(cursor.moveToFirst()){
            Escuela escuela = new Escuela();
            escuela.setId(cursor.getString(0));
            escuela.setNombre(cursor.getString(1));
            return escuela;
        }
        else {
            return null;
        }
    }

    public Ciclo consultarCiclo(String id) throws ParseException {

        String[] camposCiclo = {"idciclo", "fechainicio", "fechafin"}, idciclo = {id};
        Cursor cursor = db.query("ciclo", camposCiclo, "idciclo = ?", idciclo, null, null, null );
        if(cursor.moveToFirst()){
            Ciclo ciclo = new Ciclo();
            ciclo.setId(cursor.getString(0));
            ciclo.setInicio(getStringDate(cursor.getString(1)));
            ciclo.setFin(getStringDate(cursor.getString(2)));
            return ciclo;
        }
        else {
            return null;
        }
    }

    public Materia consultarMateria(String id){
        String[] camposMateria = {"idmat", "idciclo", "carnetdocente", "idescuela", "nombremateria"};
        String[] idMat = {id};
        Cursor c = db.query("materia", camposMateria, "idmat = ?", idMat, null, null, null);
        if(c.moveToFirst()){
            Materia materia = new Materia();
            materia.setId(c.getString(0));
            materia.setIdCiclo(c.getString(1));
            materia.setCarnetDocente(c.getString(2));
            materia.setIdEscuela(c.getString(3));
            materia.setNombre(c.getString(4));
            return materia;
        }
        else return null;
    }

    //Actualización
    public String actualizar(Escuela escuela){
        if(verificarIntegridad(escuela, 1)){
            String[] id = {escuela.getId()};
            ContentValues cv = new ContentValues();

            cv.put("nombreescuela", escuela.getNombre());
            db.update("escuela", cv, "idescuela = ?", id);
            return "¡Registro actualizado correctamente!";
        }
        else{
            return "La escuela con id "+escuela.getId()+" no existe.";
        }
    }

    public String actualizar(Ciclo ciclo){
        if(verificarIntegridad(ciclo, 2)){
            String[] id = {ciclo.getId()};
            ContentValues cv = new ContentValues();

            cv.put("fechainicio", getDateTime(ciclo.getInicio()));
            cv.put("fechafin", getDateTime(ciclo.getFin()));
            db.update("ciclo", cv, "idciclo = ?", id);
            return "¡Registro actualizado correctamente!";
        }
        else{
            return "El ciclo con id "+ciclo.getId()+" no existe";
        }
    }

    public String actualizar(Materia materia){
        if (verificarIntegridad(materia, 6)){
            String[] id = {materia.getId()};
            ContentValues cv = new ContentValues();

            cv.put("idciclo", materia.getIdCiclo());
            cv.put("carnetdocente", materia.getCarnetDocente());
            cv.put("idescuela", materia.getIdEscuela());
            cv.put("nombremateria", materia.getNombre());
            db.update("materia", cv, "idmat = ?", id);
            return "¡Registro actualizado correctamente!";
        }
        else{
            return "El código de materia "+materia.getId()+" no existe.";
        }
    }

    //Eliminacion
    public String eliminar(Escuela escuela){
        String afectados = "Filas afectadas: ";
        int cont = 0;

        if (verificarIntegridad(escuela, 3)){
            cont += db.delete("materia", "idescuela='"+
                    escuela.getId()+"'", null);
        }
        cont += db.delete("escuela", "idescuela='"+
                escuela.getId()+"'", null);
        return afectados+=cont;
    }

    public String eliminar(Ciclo ciclo){
        String afectados = "Filas afectadas: ";
        int cont = 0;

        if(verificarIntegridad(ciclo, 4)){
            cont += db.delete("materia", "idciclo='"+
                    ciclo.getId()+"'", null);
        }
        cont += db.delete("ciclo", "idciclo='"+
                ciclo.getId()+"'", null);
        return afectados+=cont;
    }

    public String eliminar(Materia materia){
        String afectados = "Filas afectadas: ";
        int cont = 0;

        if(verificarIntegridad(materia, 7)){
            cont += db.delete("laboratorio", "idmat='"+
                    materia.getId()+"'", null);
        }
        if(verificarIntegridad(materia, 8)){
            cont += db.delete("teorico", "idmat='"+
                    materia.getId()+"'", null);
        }
        cont += db.delete("materia", "idmat='"+
                materia.getId()+"'", null);
        return afectados+=cont;
    }
    //Fin SH15001

    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException{
        switch (relacion){
            case 1:{//verificación de existencia de escuela
                Escuela escuela = (Escuela) dato;
                String[] id = {escuela.getId()};

                abrir();
                Cursor cursor = db.query("escuela", null, "idescuela = ?", id, null, null, null);
                //cerrar();
                if(cursor.moveToFirst()){
                    return true;
                }
                return false;
            }

            case 2:{//verificación de existencia de ciclo
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

            case 3:{//verifica si hay materia(s) impartida por la escuela
                Escuela escuela = (Escuela) dato;
                String[] id = {"idescuela"};
                Cursor c = db.query(true, "materia", id,  "idescuela='"
                        +escuela.getId()+"'", null, null, null, null, null);
                if(c.moveToFirst()){
                    return true;
                }
                else{
                    return false;
                }
            }

            case 4:{//verifica si hay materia(s) impartida en el ciclo
                Ciclo ciclo = (Ciclo) dato;
                String[] id = {"idciclo"};
                Cursor c = db.query(true, "materia", id, "idciclo='"+
                        ciclo.getId()+"'", null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }

            case 5:{//Verifica que existan las llaves foraneas
                Materia materia = (Materia) dato;
                String[] id1 = {materia.getIdEscuela()};
                String[] id2 = {materia.getIdCiclo()};
                String[] id3 = {materia.getCarnetDocente()};

                Cursor c1 = db.query("escuela", null, "idescuela = ?", id1, null, null, null);
                Cursor c2 = db.query("ciclo", null, "idciclo = ?", id2, null, null, null);
                Cursor c3 = db.query("docente", null, "carnetdocente = ?", id3, null, null, null);
                if(c1.moveToFirst() && c2.moveToFirst() || c3.moveToFirst()){ //Cambiar a && cuando existan datos de docente
                    return true;
                }
                return false;

            }

            case 6:{//Verificar existencia de Materia
                Materia materia = (Materia) dato;
                String[] id = {materia.getId()};
                abrir();
                Cursor c = db.query("Materia", null, "idmat = ?", id, null, null, null);
                if(c.moveToFirst()) return true;
                else return false;

            }

            case 7:{
                Materia materia = (Materia) dato;
                String[] id = {"idmat"};
                Cursor c = db.query(true, "teorico", id, "idmat='"+
                        materia.getId()+"'", null, null, null, null, null);
                if (c.moveToFirst()) return true;
                else return false;
            }

            case 8:{
                Materia materia = (Materia) dato;
                String[] id = {"idmat"};
                Cursor c = db.query(true, "laboratorio", id, "idmat='"+
                        materia.getId()+"'", null, null, null, null, null);
                if (c.moveToFirst()) return true;
                else return false;
            }
            default:
                return false;
        }
    }

    public String llenarBD() throws ParseException {
        final String[] Vidciclo = {"P2019", "I2020", "P2020", "I2021", "P2021"};
        final Date[] Vfechainicio = {
                getStringDate("2019-08-19 00:00:00"), getStringDate("2020-02-18 00:00:00"),  getStringDate("2020-08-10 00:00:00"), getStringDate("2021-02-18 00:00:00"), getStringDate("2021-08-10 00:00:00")
        };
        final Date[] Vfechafin = {
                getStringDate("2019-12-15 00:00:00"), getStringDate("2020-07-30 00:00:00"),  getStringDate("2021-01-15 00:00:00"), getStringDate("2021-08-08 00:00:00"), getStringDate("2021-12-10 00:00:00")
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

        for(int i=0; i<5; i++){
            Ciclo ciclo = new Ciclo(Vidciclo[i], Vfechainicio[i], Vfechafin[i]);
            insertar(ciclo);
        }
        for(int i=0; i<5; i++){
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

        final String[] Vusuario = {"admin", "1", "2", "3"};
        Usuario admin = new Usuario(Vusuario[0], "admin123", "Administrador");
        Usuario carlos = new Usuario(Vusuario[1], "Ch1q2", "Carlos");
        Usuario alberto = new Usuario(Vusuario[2], "jA3f2", "Alberto");
        Usuario hernan = new Usuario(Vusuario[3], "gD21d", "Hernan");
        insertar(admin); insertar(carlos); insertar(alberto); insertar(hernan);

        String[] Vtablas = {"Escuela", "Ciclo", "Materia", "4", "5", "6", "7","8","9","Asignación", "Encargado", "Salón", "Laboratorio", "Horario", "Propuesta"};
        for(int i=0; i<15; i++){
            OpcionCrud crud = new OpcionCrud(String.valueOf(i), "Menu de "+Vtablas[i], i);
            insertar(crud);
        }

        for(int i=0; i<4; i++){
            AccesoUsuario acceso = new AccesoUsuario(Vusuario[i], String.valueOf(i));
            insertar(acceso);
        }

        cerrar();
        return "Se realizó correctamente";
    }
}
