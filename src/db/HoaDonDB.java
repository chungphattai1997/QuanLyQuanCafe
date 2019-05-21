/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import data.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static main.jfrLogin.maNV;
import static main.jfrStaff.conn;

/**
 *
 * @author Phat Tai
 */
public class HoaDonDB {

    public static void insert(int idban) throws SQLException {
        Connection conn = Connect.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO dbo.HoaDon (idBan,NhanVienLap) VALUES (?, ?)");
        ps.setInt(1, idban);
        ps.setString(2, maNV);
        ps.execute();
    }

    public static int maxID() throws SQLException {
        Connection conn = Connect.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT MAX(id) FROM dbo.HoaDon");
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public static void update(String idHoaDon) throws SQLException {
        Connection conn = Connect.getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE dbo.HoaDon SET TrangThai = ? WHERE id = ?");
        ps.setInt(1, 1);
        ps.setString(2, idHoaDon);
        ps.execute();
    }
}
