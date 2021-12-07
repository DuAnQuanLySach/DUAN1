/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBCHelper.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class ThongKeDao {

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //Doanh thu theo nam

    public List<Object[]> getHoaDonNam() {
        String sql = "{call SP_SLSP1}";
        String[] cols = {"nam", "TONGSOLUONG", "TONGTIEN"};
        return getListOfArray(sql, cols);
    }
    //Doanh thu theo tung nam

    public List<Object[]> getHoaDonNam1(Integer nam) {
        String sql = "{call SP_SLSP3(?)}";
        String[] cols = {"nam", "TONGSOLUONG", "TONGTIEN"};
        return getListOfArray(sql, cols, nam);
    }

    public List<Object[]> getHoaDonThang(Integer nam) {
        String sql = "{call SP_SLSP(?)}";
        String[] cols = {"thang", "TONGSOLUONG", "TONGTIEN"};
        return getListOfArray(sql, cols, nam);
    }
// Doanh thu theo tung nam và tháng

    public List<Object[]> getHoaDonThang1(Integer nam, Integer thang) {
        String sql = "{call SP_SLSPThang(?,?)}";
        String[] cols = {"thang", "TONGSOLUONG", "TONGTIEN"};
        return getListOfArray(sql, cols, nam, thang);
    }

    public List<Object[]> getHoaDonNamSP() {
        String sql = "{call SP_SPBC1}";
        String[] cols = {"NAM", "TENTHELOAI", "SOLUONG", "TONGTIEN"};
        return getListOfArray(sql, cols);
    }

    public List<Object[]> getHoaDonNamSP1(Integer nam) {
        String sql = "{call SP_SPBC(?)}";
        String[] cols = {"NAM", "TENTHELOAI", "SOLUONG", "TONGTIEN"};
        return getListOfArray(sql, cols, nam);
    }

    public List<Object[]> getHoaDonThangSP(Integer nam) {
        String sql = "{call SP_SPBC2(?)}";
        String[] cols = {"THANG", "TENTHELOAI", "SOLUONG", "TONGTIEN"};
        return getListOfArray(sql, cols, nam);
    }

    public List<Object[]> getHoaDonThangSP1(Integer nam, Integer thang) {
        String sql = "{call SP_SPBC3(?,?)}";
        String[] cols = {"THANG", "TENTHELOAI", "SOLUONG", "TONGTIEN"};
        return getListOfArray(sql, cols, nam, thang);
    }

    public List<Object[]> getHoaDonNamSBC() {
        String sql = "{call SP_SBC}";
        String[] cols = {"NAM", "TEN", "SOLUONG", "TONGTIEN"};
        return getListOfArray(sql, cols);
    }

    public List<Object[]> getHoaDonNamSBC1(Integer nam) {
        String sql = "{call SP_SBC1(?)}";
        String[] cols = {"NAM", "TEN", "SOLUONG", "TONGTIEN"};
        return getListOfArray(sql, cols, nam);
    }

    public List<Object[]> getHoaDonThangSBC2(Integer nam) {
        String sql = "{call SP_SBC2(?)}";
        String[] cols = {"THANG", "TEN", "SOLUONG", "TONGTIEN"};
        return getListOfArray(sql, cols, nam);
    }

    public List<Object[]> getHoaDonThangSBC3(Integer nam, Integer thang) {
        String sql = "{call SP_SBC3(?,?)}";
        String[] cols = {"THANG", "TEN", "SOLUONG", "TONGTIEN"};
        return getListOfArray(sql, cols, nam, thang);
    }
    
    public List<Object[]> getHoaDonNGAY(Date NgayMua) {
        String sql = "{call SP_SBCN(?)}";
        String[] cols = {"NGAY", "TEN", "SOLUONG", "TONGTIEN","GHICHU"};
        return getListOfArray(sql, cols, NgayMua);
    }
}
