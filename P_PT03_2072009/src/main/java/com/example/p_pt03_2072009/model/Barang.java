package com.example.p_pt03_2072009.model;

public class Barang {
    private String idbarang;
    private String namabarang;
    private String supplier;

    public String getIdbarang() {
        return idbarang;
    }

    public void setIdbarang(String idbarang) {
        this.idbarang = idbarang;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Barang(String idbarang, String namabarang, String supplier) {
        this.idbarang = idbarang;
        this.namabarang = namabarang;
        this.supplier = supplier;
    }
}
