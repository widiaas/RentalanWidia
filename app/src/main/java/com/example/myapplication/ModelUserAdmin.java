package com.example.myapplication;
import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;


public class ModelUserAdmin implements Parcelable {
    //user
    private int id;
    private String email;
    private String password;
    private String nama;
    private String nohp;
    private String alamat;
    private String noktp;
    private String roleuser;

    //Item
    private int iditem;
    private String kodesepeda;
    private String merk;
    private String warna;
    private String gambar;
    private String url;
    private String harga;

    protected ModelUserAdmin(Parcel in) {
        //USER
        id = in.readInt();
        email = in.readString();
        nama = in.readString();
        nohp = in.readString();
        alamat = in.readString();
        noktp = in.readString();
        roleuser = in.readString();
        password = in.readString();

        //ITEM
         iditem = in.readInt();
         kodesepeda = in.readString();
         merk = in.readString();
         warna = in.readString();
         gambar = in.readString();
         url = in.readString();
         harga = in.readString();

    }

    public static final Creator<ModelUserAdmin> CREATOR = new Creator<ModelUserAdmin>() {
        @Override
        public ModelUserAdmin createFromParcel(Parcel in) {
            return new ModelUserAdmin(in);
        }

        @Override
        public ModelUserAdmin[] newArray(int size) {
            return new ModelUserAdmin[size];
        }
    };

    public ModelUserAdmin(JSONObject dataUser) {
    }

    public int getId() {return id;}
    public void setId(int id){this.id = id;}
    public int getIditem(){return iditem;}
    public void setIditem(int iditem){this.iditem = iditem;}

    //USER
    public  String getPassword(){return password;}
    public void setPassword(String password){
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNama() {return nama;}
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNohp() {return nohp;}
    public void setNohp(String nohp) {
        this.nohp = nohp;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getNoktp() {
        return noktp;
    }
    public void setNoktp(String noktp) {
        this.noktp = noktp;
    }
    public String getRoleuser() {
        return roleuser;
    }
    public void setRoleuser(String roleuser) {
        this.roleuser = roleuser;
    }

    //ITEM
    public String getKodesepeda(){return kodesepeda;}
    public void setKodesepeda(String kodesepeda){this.kodesepeda = kodesepeda;}
    public String getWarna(){return warna;}
    public void setWarna(String warna) {this.warna = warna;}
    public String getMerk(){return merk;}
    public void setMerk(String merk){this.merk = merk;}
    public String getGambar(){return gambar;}
    public void setGambar(String gambar){this.gambar = gambar;}
    public String getUrl(){return gambar;}
    public void setUrl(String url){this.url = url;}
    public String getHarga(){return harga;}
    public void  setHarga(String harga){this.harga = harga;}

    public static Creator<ModelUserAdmin> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        //USER
        parcel.writeInt(id);
        parcel.writeString(email);
        parcel.writeString(nama);
        parcel.writeString(nohp);
        parcel.writeString(alamat);
        parcel.writeString(noktp);
        parcel.writeString(roleuser);

        //ITEM
        parcel.writeInt(iditem);
        parcel.writeString(warna);
        parcel.writeString(merk);
        parcel.writeString(kodesepeda);
        parcel.writeString(gambar);
        parcel.writeString(url);
        parcel.writeString(harga);
    }
}
