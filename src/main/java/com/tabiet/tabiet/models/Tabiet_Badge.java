package com.tabiet.tabiet.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="tabiet_badge")
@Table(name="tabiet_badge")
public class Tabiet_Badge {

    @Id
    private Long idt;


    private Long idb;

    public Long getIdt() {
        return idt;
    }

    public void setIdt(Long idt) {
        this.idt = idt;
    }

    public Long getIdb() {
        return idb;
    }

    public void setIdb(Long idb) {
        this.idb = idb;
    }
}
