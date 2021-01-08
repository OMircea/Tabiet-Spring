package com.tabiet.tabiet.models;

import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity(name="tabieturi")
@Table(name="tabieturi")
public class Tabiet {

    @Id
    @GeneratedValue
    private Long id;

    private String descriere;

    private Long nr_zile;

    private Long zile_ramase;

    private String username;

    private String ultima_indeplinire;

    private Long idTG;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getZile_ramase() {
        return zile_ramase;
    }

    public void setZile_ramase(Long zile_ramase) {
        this.zile_ramase = zile_ramase;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUltima_indeplinire() {
        return ultima_indeplinire;
    }

    public void setUltima_indeplinire(String ultima_indeplinire) {
        this.ultima_indeplinire = ultima_indeplinire;
    }

    public Long getIdTG() {
        return idTG;
    }

    public void setIdTG(Long idTG) {
        this.idTG = idTG;
    }
}
