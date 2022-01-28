package com.bank.MCC.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="meta_old")
public class MetaOldEntity implements Serializable {
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

    @ManyToOne
    @JoinColumn(name = "meta_id")
    private MetaEntity metaId;

}
