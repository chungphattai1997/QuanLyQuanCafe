/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import data.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static main.jfrStaff.conn;

/**
 *
 * @author Phat Tai
 */
public class CTHoaDonDB {

    public static void insert(int idHoaDon, int idMenu, int soLuong) throws SQLException {
        Connection conn = Connect.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO CT_HoaDon (idHoaDon, idMenu, SoLuong) VALUES ( ?, ?, ?)");
        ps.setInt(1, idHoaDon);
        ps.setInt(2, idMenu);
        ps.setInt(3, soLuong);
        ps.execute();
    }

    public static void update(int countDrink, int idHoaDon, int idMenu) throws SQLException {
        Connection conn = Connect.getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE CT_HoaDon SET SoLuong = SoLuong+? WHERE idHoaDon = ? AND idMenu = ?");
        ps.setInt(1, countDrink);
        ps.setInt(2, idHoaDon);
        ps.setInt(3, idMenu);
        ps.execute();
    }
}