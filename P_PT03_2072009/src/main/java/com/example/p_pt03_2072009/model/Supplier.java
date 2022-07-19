package com.example.p_pt03_2072009.model;

public class Supplier {
    private String idsupp;
    private String namasupp;
    private String alamat;

    public Supplier(String idsupp, String namasupp, String alamat) {
        this.idsupp = idsupp;
        this.namasupp = namasupp;
        this.alamat = alamat;
    }

    public String getIdsupp() {
        return idsupp;
    }

    public void setIdsupp(String idsupp) {
        this.idsupp = idsupp;
    }

    public String getNamasupp() {
        return namasupp;
    }

    public void setNamasupp(String namasupp) {
        this.namasupp = namasupp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }


}
