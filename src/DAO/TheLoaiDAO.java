package DAO;

import Entity.TheLoai;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TheLoaiDAO extends DAO<TheLoai, Integer> {

    String INSERT_SQL = "SET IDENTITY_INSERT THELOAI ON\n"
            + "INSERT INTO  THELOAI (MATL, TENTL, MAVITRI, TRANGTHAI) VALUES (?, ? ,?, ?)\n"
            + "SET IDENTITY_INSERT THELOAI OFF";
    String UPDATE_SQL = "UPDATE THELOAI SET TENTL=?,MAVITRI =? ,TRANGTHAI=? WHERE MATL=? ";
    String DELETE_SQL = "DELETE FROM THELOAI WHERE MATL=? ";
    String SELECT_ALL_SQL = "SELECT * FROM THELOAI ";
    String SELECT_ALLHD_SQL = "SELECT * FROM THELOAI WHERE TRANGTHAI = 1";
    String SELECt_BY_ID_SQL = "SELECT*from THELOAI where MATL= ?";

    @Override
    public void insert(TheLoai entity) {
        JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getMaTL(), entity.getTenTL(),entity.getMaVT(), entity.getTrangThai());
    }

    @Override
    public void update(TheLoai entity) {
        JDBCHelper.jdbcHelper.update(UPDATE_SQL , entity.getTenTL(),entity.getMaVT(), entity.getTrangThai(),entity.getMaTL());
    }



    @Override
    public List<TheLoai> selecALL() {
        return this.selectBySql(SELECT_ALLHD_SQL);
    }
    public List<TheLoai> selecALLL() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public TheLoai selectById(Integer key) {
        List<TheLoai> list = this.selectBySql(SELECt_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<TheLoai> selectBySql(String sql, Object... args) {
        List<TheLoai> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.jdbcHelper.query(sql, args);
            while (rs.next()) {
                TheLoai entity = new TheLoai();
                entity.setMaTL(rs.getInt(1));
                entity.setTenTL(rs.getString(2));
                entity.setMaVT(rs.getString(3));
                entity.setTrangThai(rs.getInt(4));
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
