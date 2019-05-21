/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import data.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Phat Tai
 */
public class checkLogin {

    public static Connection conn = null;
    public static ResultSet rs = null;
    public static PreparedStatement ps = null;

    public static String testConnect() {
        try {
            conn = Connect.getConnection();
            return "Kết nối cơ sở dữ liệu thành công!";
        } catch (Exception e) {
            return null;
        }
    }

    public static ResultSet cLog(String user, String pass) {
        String sql = "SELECT * FROM TaiKhoan WHERE TenDangNhap=? AND MatKhau=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            return rs = ps.executeQuery();
        } catch (SQLException e) {
            return rs = null;
        }

    }
}
