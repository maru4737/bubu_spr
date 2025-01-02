package com.kw.Proj2_spr_2020202060.Model;

import jakarta.persistence.*;

@Entity
public class UserVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "VARCHAR(255)")
    private String id;

    @Column(columnDefinition = "VARCHAR(255)")
    private String pw;

    @Lob
    private byte[] data;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
