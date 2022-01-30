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

    @Column(name = "name_of_application")
    String nameOfApplication;

    @Column(name = "owner_of_application")
    String ownerOfApplication;

    @Column(name = "config_manager_of_application")
    String configManagerOfApplication;

    @Column(name = "version")
    int version;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "update_date")
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name = "meta_id")
    private MetaEntity metaId;

}
