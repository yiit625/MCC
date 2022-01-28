package com.bank.MCC.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="meta")
public class MetaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;

    @Column(name = "nameOfApplication")
    String nameOfApplication;

    @Column(name = "ownerOfApplication")
    String ownerOfApplication;

    @Column(name = "configManagerOfApplication")
    String configManagerOfApplication;

    @Column(name = "version")
    int version;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updateDate")
    private Date updateDate;

}
