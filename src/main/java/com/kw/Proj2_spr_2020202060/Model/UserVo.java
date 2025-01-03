package com.kw.Proj2_spr_2020202060.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class UserVo {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "VARCHAR(255)")
    private String id;

    @Setter
    @Getter
    @Column(columnDefinition = "VARCHAR(255)")
    private String pw;

    @Setter
    @Getter
    @Column(columnDefinition = "VARCHAR(255)")
    private String name;

    @Lob
    private byte[] data;

    // Getters and Setters

}
