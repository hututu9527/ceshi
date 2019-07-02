package model;

import dao.User;
import java.sql.*;

public class LoginModel {
    private static String DBUNAME = "root";
    private static String DBUPWD = "1234";
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/userinfo";

    @SuppressWarnings("finally")
	public static boolean login(User user){
        String loginAccount = user.getLoginAccount();
        String loginPassword = user.getLoginPassword();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,DBUNAME,DBUPWD);
            pstmt = con.prepareStatement("select count(*)from userinfo where loginaccount=? and loginpassword=?");
            pstmt.setString(1,loginAccount);
            pstmt.setString(2,loginPassword);
            rs = pstmt.executeQuery();
            if (rs.next()){
                count = rs.getInt(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if (rs!=null){
                    rs.close();
                }
                if (pstmt!=null){
                    pstmt.close();
                }
                if (con!=null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (count==1){
                return true;
            }else{
                return false;
            }
        }
    }

    @SuppressWarnings("finally")
	public static boolean register(User user){
        String loginAccount = user.getLoginAccount();
        String loginPassword = user.getLoginPassword();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,DBUNAME,DBUPWD);
            pstmt = con.prepareStatement("insert into userinfo values (?,?)");
            pstmt.setString(1,loginAccount);
            pstmt.setString(2,loginPassword);
            count = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if (rs!=null){
                    rs.close();
                }
                if (pstmt!=null){
                    pstmt.close();
                }
                if (con!=null){
                    con.close();
                }
            } catch (final SQLException e) {
                e.printStackTrace();
            }
            if (count==1){
                return true;
            }else{
                return false;
            }
        }
    }
}