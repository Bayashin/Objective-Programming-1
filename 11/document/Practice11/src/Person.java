public class Person {
    // 1	姓(漢字)	文字列
    private String fname;

    // 2	名(漢字)	文字列
    private String lname;

    // 3	姓(かな)	文字列
    private String fname_kana;

    // 4	名(かな)	文字列
    private String lname_kana;

    // 5	性別	文字列
    private String seibetsu;

    // 6	郵便番号	文字列
    private String postal_code;

    // 7	住所(前半)	文字列
    private String juusho1;

    // 8	住所(後半)	文字列
    private String juusho2;

    // 9	電話番号	文字列
    private String tel_no;

    // 10	血液型	文字列
    private String ketsuekigata;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname_kana() {
        return fname_kana;
    }

    public void setFname_kana(String fname_kana) {
        this.fname_kana = fname_kana;
    }

    public String getLname_kana() {
        return lname_kana;
    }

    public void setLname_kana(String lname_kana) {
        this.lname_kana = lname_kana;
    }

    public String getSeibetsu() {
        return seibetsu;
    }

    public void setSeibetsu(String seibetsu) {
        this.seibetsu = seibetsu;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getJuusho1() {
        return juusho1;
    }

    public void setJuusho1(String juusho1) {
        this.juusho1 = juusho1;
    }

    public String getJuusho2() {
        return juusho2;
    }

    public void setJuusho2(String juusho2) {
        this.juusho2 = juusho2;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    public String getKetsuekigata() {
        return ketsuekigata;
    }

    public void setKetsuekigata(String ketsuekigata) {
        this.ketsuekigata = ketsuekigata;
    }

    @Override
    public String toString() {
        return getLname() + getFname() + "(" + getKetsuekigata() + ")";
    }

    public String getName() {
        return (this.getLname() + this.getFname());
    }
    public String getNameKana() {
        return (this.getLname_kana() + this.getFname_kana());
    }
    public String getJuusho() {
        return (this.getJuusho1() + this.getJuusho2());
    }
    public String getCSVLine() {
        StringBuilder sb = new StringBuilder(getName());
        sb.append(",");
        sb.append(getNameKana());
        sb.append(",");
        sb.append(getPostal_code());
        sb.append(",");
        sb.append(getJuusho());
        return sb.toString();
    }

}

