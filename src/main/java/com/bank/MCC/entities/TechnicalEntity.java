package com.bank.MCC.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="technical")
public class TechnicalEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;

    @Column(name = "roles")
    String roles;

    @Column(name = "permissions")
    String permissions;

    @Column(name = "version")
    int version;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updateDate")
    private Date updateDate;
}
