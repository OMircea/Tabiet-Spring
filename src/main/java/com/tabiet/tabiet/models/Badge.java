package com.tabiet.tabiet.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="badges")
@Table(name="badges")
public class Badge {

    @Id
    private Long id;

    private Long zile_necesare;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getZile_necesare() {
        return zile_necesare;
    }

    public void setZile_necesare(Long zile_necesare) {
        this.zile_necesare = zile_necesare;
    }
}
