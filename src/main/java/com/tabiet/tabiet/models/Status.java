package com.tabiet.tabiet.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name="statusuri")
@IdClass(StatusId.class)
@Table(name="statusuri")
public class Status {

    @Id private Long idT;

    @Id private Long zi;

    private String descriere_status;

    public Long getIdT() {
        return idT;
    }

    public void setIdT(Long idT) {
        this.idT = idT;
    }

    public Long getZi() {
        return zi;
    }

    public void setZi(Long zi) {
        this.zi = zi;
    }

    public String getDescriere_status() {
        return descriere_status;
    }

    public void setDescriere_status(String descriere_status) {
        this.descriere_status = descriere_status;
    }
}
