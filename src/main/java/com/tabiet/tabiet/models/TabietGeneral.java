package com.tabiet.tabiet.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="tabieturigenerale")
@Table(name="tabieturigenerale")
public class TabietGeneral {

    @Id
    private Long idTG;

    private String descriere;

    private Long nr_zile;


    public Long getIdTG() {
        return idTG;
    }

    public void setIdTG(Long idTG) {
        idTG = idTG;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Long getNr_zile() {
        return nr_zile;
    }

    public void setNr_zile(Long nr_zile) {
        this.nr_zile = nr_zile;
    }
}
