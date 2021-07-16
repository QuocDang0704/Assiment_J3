/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import information.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Đặng Quốc
 */
public class DaoLogin {
    public User checkLogin(String tenDangNhap, String maKhau)throws Exception{
        String sql = "SELECT USERNAME,PASSWORD,ROLE FROM dbo.USERS "
                + "WHERE USERNAME=? AND PASSWORD = ?";
        try {
            Connection con = database.data.opeConnection();
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, tenDangNhap);
            psmt.setString(2, maKhau);
            try {
                ResultSet rs = psmt.executeQuery();
                if (rs.next()) {
                    User nd = new User(tenDangNhap, maKhau, rs.getString("ROLE"));
                    return nd;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
        
    }
}
