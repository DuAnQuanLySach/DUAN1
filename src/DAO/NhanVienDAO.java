/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;



import Entity.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhanVienDAO extends DAO<NhanVien, Integer> {

    String INSERT_SQL = "SET IDENTITY_INSERT NHANVIEN ON "
            + "INSERT INTO NhanVien (MANV, TENNV, MATKHAU, GIOITINH, NGAYSINH, SDT, EMAIL, DIACHI, TRANGTHAI) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) "
            + "SET IDENTITY_INSERT NHANVIEN OFF";
    String UPDATE_SQL = "UPDATE NhanVien SET TENNV=?, MATKHAU=?, GIOITINH=?, NGAYSINH=?, SDT=?, EMAIL=? , DIACHI=?,  TRANGTHAI=? WHERE MANV=? ";
    String DELETE_SQL = "DELETE FROM NhanVien WHERE MANV=? ";
    String SELECT_ALL_SQL = "SELECT * FROM NhanVien ";
    String SELECt_BY_ID_SQL = "SELECT  *from NhanVien where EMAIL= ?";
    String SELECT_BY_ID_SQL = "SELECT  *from NhanVien where MANV= ?";
    String SELECt_BY_ID_SQLNV = "SELECT*from NhanVien where MANV= ?";

    @Override
    public void insert(NhanVien entity) {
        JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getManv(), entity.getTenNv(), entity.getMatKhau(), entity.isGioiTinh(), entity.getNgaySinh(), entity.getSDT(), entity.getEmail(), entity.getDiaChi(), entity.getTrangThai());
    }

    @Override
    public void update(NhanVien entity) {
        JDBCHelper.jdbcHelper.update(UPDATE_SQL, entity.getTenNv(), entity.getMatKhau(), entity.isGioiTinh(), entity.getNgaySinh(), entity.getSDT(), entity.getEmail(), entity.getDiaChi(), entity.getTrangThai(), entity.getManv());
    }

    @Override
    public List<NhanVien> selecALL() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    public NhanVien selectByIdNV(String key) {
        List<NhanVien> list = this.selectBySql(SELECt_BY_ID_SQLNV, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.jdbcHelper.query(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setManv(rs.getInt(1));
                entity.setTenNv(rs.getString(2));
                entity.setMatKhau(rs.getString(3));
                entity.setGioiTinh(rs.getBoolean(4));
                entity.setNgaySinh(rs.getDate(5));
                entity.setSDT(rs.getString(6));
                entity.setEmail(rs.getString(7));
                entity.setDiaChi(rs.getString(8));
                entity.setTrangThai(rs.getInt(9));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        JDBCHelper.jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public NhanVien selectById(Integer key) {
       List<NhanVien> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
     public NhanVien selectByEmail(String key) {
       List<NhanVien> list = this.selectBySql(SELECt_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
