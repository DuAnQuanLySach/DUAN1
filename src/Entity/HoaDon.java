
package Entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class HoaDon implements Serializable{
    private int MaHd;
    private int MaKH;
    private int MaNV;
    private int TongSL;
    private float TongTien;
    private Date Ngaymua;
    private String GhiChu;
    private int TrangThai;
    private float ThuKhac;

    public HoaDon() {
    }

    

    public HoaDon(int MaHd, int MaKH, int MaNV, int TongSL, float TongTien, Date Ngaymua, String GhiChu, int TrangThai, float ThuKhac) {
        this.MaHd = MaHd;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
        this.TongSL = TongSL;
        this.TongTien = TongTien;
        this.Ngaymua = Ngaymua;
        this.GhiChu = GhiChu;
        this.TrangThai = TrangThai;
        this.ThuKhac = ThuKhac;
    }

    public int getMaHd() {
        return MaHd;
    }

    public void setMaHd(int MaHd) {
        this.MaHd = MaHd;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public int getTongSL() {
        return TongSL;
    }

    public void setTongSL(int TongSL) {
        this.TongSL = TongSL;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public Date getNgaymua() {
        return Ngaymua;
    }

    public void setNgaymua(Date Ngaymua) {
        this.Ngaymua = Ngaymua;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public float getThuKhac() {
        return ThuKhac;
    }

    public void setThuKhac(float ThuKhac) {
        this.ThuKhac = ThuKhac;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "MaHd=" + MaHd + ", MaKH=" + MaKH + ", MaNV=" + MaNV + ", TongSL=" + TongSL + ", TongTien=" + TongTien + ", Ngaymua=" + Ngaymua + ", GhiChu=" + GhiChu + ", TrangThai=" + TrangThai + ", ThuKhac=" + ThuKhac + '}';
    }
    
}
