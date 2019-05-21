/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import data.Connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Menu;

/**
 *
 * @author Phat Tai
 */
public class MenuDB {

    //lay menu tu database
    public ArrayList<Menu> getListMenu() throws SQLException {
        Connection conn = Connect.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Menu");
        ResultSet rs = ps.executeQuery();
        ArrayList<Menu> listMenu = new ArrayList<Menu>();
        while (rs.next()) {
            Menu menu = new Menu();
            menu.setId(rs.getInt("id"));
            menu.setTen(rs.getString("Ten"));
            menu.setGia(rs.getFloat("Gia"));
            listMenu.add(menu);
        }
        return listMenu;
    }
    
    public static void insert(String ten, int gia) throws SQLException{
        Connection conn = Connect.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO dbo.Menu ( Ten, Gia ) VALUES (?,?)");
        ps.setString(1, ten);
        ps.setInt(2, gia);
        ps.execute();
    }

    public static boolean checkDrink(int idMenu, int idHoaDon) throws SQLException {
        boolean check = false;
        String sql = "SELECT COUNT(idHoaDon) FROM dbo.CT_HoaDon WHERE idMenu = ? AND idHoaDon = ?";
        Connection conn = Connect.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idMenu);
        ps.setInt(2, idHoaDon);

        int countMenu;
        
        ResultSet rs = ps.executeQuery();
        rs.next();
        countMenu = rs.getInt(1);
        
        if(countMenu > 0){
            check = true;
        }

        return check;
    }

}
