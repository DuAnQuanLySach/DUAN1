/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Entity.VaiTro;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class VaiTroDAO extends DAO<VaiTro, String> {

    String INSERT_SQL = "SET IDENTITY_INSERT VAITRO ON "
            + "INSERT INTO VaiTro (IDVAITRO, VAITRO, MANV, TENNV, CALAMVCTU, CALAMVCDEN, TRANGTHAI) VALUES (?, ?, ?, ?, ?, ?, ?)"
            + "SET IDENTITY_INSERT VAITRO OFF";
    String UPDATE_SQL = "UPDATE VaiTro SET VAITRO=?, MANV=?, TENNV=?, CALAMVCTU=?, CALAMVCDEN=?, TRANGTHAI=? WHERE IDVAITRO=? ";
    String DELETE_SQL = "DELETE FROM VaiTro WHERE IDVAITRO=? ";
    String SELECT_ALL_SQL = "SELECT * FROM VaiTro ";
    String SELECt_BY_ID_SQL = "SELECT*from VaiTro where IDVAITRO= ?";
    String SELECt_BY_ID_SQLL = "SELECT*from VaiTro where TENNV= ?";

    @Override
    public void insert(VaiTro entity) {
        JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getIDVaiTro(), entity.isVaiTro(), entity.getManv(), entity.getTenNv(), entity.getCaLamVcTu(), entity.getCaLamVcDen(), entity.isTrangThai());
    }

    @Override
    public void update(VaiTro entity) {
        JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getIDVaiTro(), entity.isVaiTro(), entity.getManv(), entity.getTenNv(), entity.getCaLamVcTu(), entity.getCaLamVcDen(), entity.isTrangThai());
    }

    @Override
    public void delete(String id) {
        JDBCHelper.jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<VaiTro> selecALL() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public VaiTro selectById(String key) {
        List<VaiTro> list = this.selectBySql(SELECt_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }



    @Override
    public List<VaiTro> selectBySql(String sql, Object... args) {
        List<VaiTro> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.jdbcHelper.query(sql, args);
            while (rs.next()) {
                VaiTro entity = new VaiTro();
                entity.setIDVaiTro(rs.getString(1));
                entity.setVaiTro(rs.getBoolean(2));
                entity.setManv(rs.getString(3));
                entity.setTenNv(rs.getString(4));
                entity.setCaLamVcTu(rs.getString(5));
                entity.setCaLamVcDen(rs.getString(6));
                entity.setTrangThai(rs.getInt(7));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public VaiTro selectByIdd(String key) {
        List<VaiTro> listt = this.selectBySql(SELECt_BY_ID_SQLL, key);
        if (listt.isEmpty()) {
            return null;
        }
        return listt.get(0);
    }
}
