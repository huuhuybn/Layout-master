package vn.edu.poly.layout;

public class Constants {

    public static final boolean isDEBUG = true;

    // khai bao bang nguoiDung

    public static final String USER_TABLE = "nguoiDung";

    // khai bao ten cot trong bang nguoiDung

    public static final String USER_USER_NAME = "userName";

    public static final String USER_PASSWORD = "Password";

    public static final String USER_PHONE = "Phone";

    public static final String USER_FULL_NAME = "hoTen";


    // Cau lenh tao bang nguoiDung

    // CREATE TABLE nguoiDung
    // (userName NVARCHAR(50), Password NVARCHAR(50),Phone NCHAR(10),hoTen NVARCHAR(50))

    public static final String CREATE_USER_TABLE = "CREATE TABLE " + USER_TABLE + "(" +
            "" + USER_USER_NAME + " NVARCHAR(50)," +
            "" + USER_PASSWORD + " NVARCHAR(50)," +
            "" + USER_PHONE + " NCHAR(10)," +
            "" + USER_FULL_NAME + " NVARCHAR(50)" +
            ")";



    // khai bao bang HoaDon

    public static final String BILL_TABLE = "HoaDon";

    public static final String BILL_ID = "MaHoaDon";
    public static final String BILL_DATE = "NgayMua";


    // Cau lenh tao bang HoaDon

    // CREATE TABLE HoaDon (MaHoaDon NCHAR(7),NgayMua DATE)


    public static final  String CREATE_BILL_TABLE = "CREATE TABLE " + BILL_TABLE +
            "("+BILL_ID+" NCHAR(7) PRIMARY KEY,"
            +BILL_DATE+" DATE)";




}
