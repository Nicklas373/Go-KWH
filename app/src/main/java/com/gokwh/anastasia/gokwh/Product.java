package com.gokwh.anastasia.gokwh;

public class Product {

    private String id;
    private String nama;
    private String jabatan;
    private String email;

    public Product(String id, String nama, String jabatan, String email) {
        this.id = id;
        this.nama = nama;
        this.jabatan = jabatan;
        this.email= email;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public String getEmail() {
        return email;
    }
}