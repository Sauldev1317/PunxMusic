package dev.saul1317.punxmusic.Data.SQLite;

public class SQLiteTables {

    public static final int VERSION_BD = 1;

    /*------TABLA SHOPPING CART-----*/
    public static final String TABLA_INSTRUMENTO = "instrumentos";

    public static final String CAMPO_ID_INSTRUMENTO = "id_instrumento";
    public static final String CAMPO_NUMERO_MODELO = "num_modelo";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_DESCRIPCION = "descripcion";
    public static final String CAMPO_PRECIO = "precio";
    public static final String CAMPO_DESCUENTO = "descuento";
    public static final String CAMPO_INVENTARIO = "inventario";
    public static final String CAMPO_NUMERO_VENTA = "num_ventas";
    public static final String CAMPO_NUMERO_VISITAS = "numero_visitas";
    public static final String CAMPO_URL_IMAGEN = "url_img";
    public static final String CAMPO_URL_VIDEO = "url_video";

    public static final String CREAR_TABLA_INSTRUMENTO = "CREATE TABLE "+ TABLA_INSTRUMENTO + " ("
            + CAMPO_ID_INSTRUMENTO + " TEXT PRIMARY KEY NOT NULL, "
            + CAMPO_NUMERO_MODELO + " INTERGER, "
            + CAMPO_NOMBRE + " TEXT,"
            + CAMPO_DESCRIPCION + " TEXT,"
            + CAMPO_PRECIO + " INTERGER,"
            + CAMPO_DESCUENTO + " INTERGER,"
            + CAMPO_INVENTARIO + " INTERGER,"
            + CAMPO_NUMERO_VENTA + " INTERGER,"
            + CAMPO_NUMERO_VISITAS + " INTERGER,"
            + CAMPO_URL_IMAGEN + " TEXT,"
            + CAMPO_URL_VIDEO + " TEXT "
            + ")";

}
