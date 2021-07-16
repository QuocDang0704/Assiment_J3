/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import information.SinhVien;
import information.bangDiem;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author Đặng Quốc
 */
public class DaoQLDiem {

    public boolean insert(bangDiem bd) {
        String sql = "INSERT INTO dbo.GRADE VALUES(?,?,?,?)";
        try {
            Connection con = database.data.opeConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, bd.getMASV());
            pstmt.setInt(2, bd.getTIENGANH());
            pstmt.setInt(3, bd.getTINHOC());
            pstmt.setInt(4, bd.getGDTC());

            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(bangDiem bd) {
        String sql = "UPDATE dbo.GRADE SET TIENGANH = ?, TINHOC=?, GDTC=? "
                + "WHERE MASV=?";
        try {
            Connection con = database.data.opeConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(4, bd.getMASV());
            pstmt.setInt(1, bd.getTIENGANH());
            pstmt.setInt(2, bd.getTINHOC());
            pstmt.setInt(3, bd.getGDTC());

            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteByID(String MaSv) {
        String sql = "DELETE dbo.GRADE "
                + "WHERE MASV = ?";
        try {
            Connection con = database.data.opeConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, MaSv);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public bangDiem findByMSV(String MaSv) {
        String sql = "SELECT * FROM dbo.GRADE "
                + "WHERE MASV=?";
        try {
            Connection con = database.data.opeConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, MaSv);
            try {
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    bangDiem bd = new bangDiem();
                    bd.setID(rs.getInt("ID"));
                    bd.setMASV(rs.getString("MASV"));
                    bd.setTIENGANH(rs.getInt("TIENGANH"));
                    bd.setTINHOC(rs.getInt("TINHOC"));
                    bd.setGDTC(rs.getInt("GDTC"));
                    return bd;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();      
        }
        return null;
    }

    public List<bangDiem> findAll() {
        String sql = "SELECT * FROM dbo.GRADE";
        try {
            Connection con = database.data.opeConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            try {
                List<bangDiem> lst = new ArrayList<>();
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    bangDiem bd = new bangDiem();
                    bd.setID(rs.getInt("ID"));
                    bd.setMASV(rs.getString("MASV"));
                    bd.setTIENGANH(rs.getInt("TIENGANH"));
                    bd.setTINHOC(rs.getInt("TINHOC"));
                    bd.setGDTC(rs.getInt("GDTC"));
                    lst.add(bd);
                }
                return lst;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<bangDiem> findTop3() {
        String sql = "SELECT TOP 3*,(TIENGANH+TINHOC+GDTC)/3 AS dtb \n"
                + "FROM dbo.GRADE ORDER BY dtb DESC";
        try {
            Connection con = database.data.opeConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            try {
                List<bangDiem> lst = new ArrayList<>();
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    bangDiem bd = new bangDiem();
                    bd.setID(rs.getInt("ID"));
                    bd.setMASV(rs.getString("MASV"));
                    bd.setTIENGANH(rs.getInt("TIENGANH"));
                    bd.setTINHOC(rs.getInt("TINHOC"));
                    bd.setGDTC(rs.getInt("GDTC"));
                    lst.add(bd);
                }
                return lst;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
