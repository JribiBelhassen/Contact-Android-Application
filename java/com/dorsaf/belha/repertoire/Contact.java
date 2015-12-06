package com.dorsaf.belha.repertoire;

public class Contact {
    private String nom_contact;
    private String num_contact;

    public Contact(String nom_contact, String num_contact) {
        this.nom_contact = nom_contact;
        this.num_contact = num_contact;
    }

    public String getNom_contact() {
        return nom_contact;
    }

    public void setNom_contact(String nom_contact) {
        this.nom_contact = nom_contact;
    }

    public String getNum_contact() {
        return num_contact;
    }

    public void setNum_contact(String num_contact) {
        this.num_contact = num_contact;
    }
}
