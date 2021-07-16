/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import information.SinhVien;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.Buffer;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author Đặng Quốc
 */
public class DaoQLSV {
    public boolean insert(SinhVien sv){
        String sql = "INSERT INTO dbo.STUDENT VALUES(?,?,?,?,?,?,?)";
        try {
            Connection con = database.data.opeConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sv.getMaSV());
            pstmt.setString(2, sv.getHoTen());
            pstmt.setString(3, sv.getEmail());
            pstmt.setString(4, sv.getSDT());
            pstmt.setInt(5, sv.getGioiTinh());
            pstmt.setString(6, sv.getDiaChi());
            if (sv.getHinh() != null) {
                Blob Hinh = new SerialBlob(sv.getHinh());
                pstmt.setBlob(7, Hinh);
            }else{
                Blob Hinh = null;
                pstmt.setBlob(7, Hinh);
            }     
            return pstmt.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean update(SinhVien sv){
        String sql = "UPDATE dbo.STUDENT SET HOTEN=?,EMAIL=?,SODT=?,GIOITINH=?,DIACHI=?,HINH=?"
                + " WHERE MASV=?";
        try {
            Connection con = database.data.opeConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sv.getHoTen());
            pstmt.setString(2, sv.getEmail());
            pstmt.setString(3, sv.getSDT());
            pstmt.setInt(4, sv.getGioiTinh());
            pstmt.setString(5, sv.getDiaChi());
            if (sv.getHinh()!=null) {
                Blob hinh = new SerialBlob(sv.getHinh());
                pstmt.setBlob(6, hinh);
            }else{
                Blob hinh = null;
                pstmt.setBlob(6, hinh);
            }
            pstmt.setString(7, sv.getMaSV());
//            File input = null;
//            BufferedImage read = ImageIO.read(input);
            
            return pstmt.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean delete(String maSV){
        String sql = "DELETE dbo.STUDENT WHERE MASV=?";
        try {
            Connection con = database.data.opeConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, maSV);
            return pstmt.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public SinhVien findById(String maSV){
        String sql = "SELECT * FROM dbo.STUDENT WHERE MASV =?";
        try {
            Connection con = database.data.opeConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, maSV);
            try {
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    SinhVien sv = createSV(rs);
                    return sv;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private SinhVien createSV(ResultSet rs) throws SQLException {
        SinhVien sv = new SinhVien();
        sv.setMaSV(rs.getString("MASV"));
        sv.setHoTen(rs.getString("HOTEN"));
        sv.setEmail(rs.getString("EMAIL"));
        sv.setSDT(rs.getString("SODT"));
        sv.setDiaChi(rs.getString("DIACHI"));
        sv.setGioiTinh(rs.getInt("GIOITINH"));
        Blob blob = rs.getBlob("HINH");
        if (blob!=null) {
            sv.setHinh(blob.getBytes(1, (int) blob.length()));
        }
        return sv;
    }
    public List<SinhVien> finByAll(){
        String sql = "SELECT * FROM dbo.STUDENT";
        try {
            Connection con = database.data.opeConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            try {
                ResultSet rs = pstmt.executeQuery();
                List<SinhVien> lst = new ArrayList<>();
                while (rs.next()) {
                    SinhVien sv = createSV(rs);
                    lst.add(sv);
                }
                return lst;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
