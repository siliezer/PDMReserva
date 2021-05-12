package sv.ues.fia.eisi.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    //Fin SH15001
}
