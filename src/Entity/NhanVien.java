
package Entity;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class NhanVien {

    private int Manv;
    private String TenNv;
    private String MatKhau;
    private boolean GioiTinh;
    private Date NgaySinh;
    private String SDT;
    private String Email;
    private String DiaChi;
    private int TrangThai;

    public NhanVien() {
    }

    public NhanVien(int Manv, String TenNv, String MatKhau, boolean GioiTinh, Date NgaySinh, String SDT, String Email, String DiaChi, int TrangThai) {
        this.Manv = Manv;
        this.TenNv = TenNv;
        this.MatKhau = MatKhau;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.SDT = SDT;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.TrangThai = TrangThai;
    }

    public int getManv() {
        return Manv;
    }

    public void setManv(int Manv) {
        this.Manv = Manv;
    }

    public String getTenNv() {
        return TenNv;
    }

    public void setTenNv(String TenNv) {
        this.TenNv = TenNv;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return  Manv +"";
    }

    
    
}
