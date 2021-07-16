
package information;


public class bangDiem {
    private int ID;
    private String MASV;
    private int TIENGANH,TINHOC,GDTC;

    public bangDiem() {
    }

    public bangDiem(int ID, String MASV, int TIENGANH, int TINHOC, int GDTC) {
        this.ID = ID;
        this.MASV = MASV;
        this.TIENGANH = TIENGANH;
        this.TINHOC = TINHOC;
        this.GDTC = GDTC;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMASV() {
        return MASV;
    }

    public void setMASV(String MASV) {
        this.MASV = MASV;
    }

    public int getTIENGANH() {
        return TIENGANH;
    }

    public void setTIENGANH(int TIENGANH) {
        this.TIENGANH = TIENGANH;
    }

    public int getTINHOC() {
        return TINHOC;
    }

    public void setTINHOC(int TINHOC) {
        this.TINHOC = TINHOC;
    }

    public int getGDTC() {
        return GDTC;
    }

    public void setGDTC(int GDTC) {
        this.GDTC = GDTC;
    }
    
}
