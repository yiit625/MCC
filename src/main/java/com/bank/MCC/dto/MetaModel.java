package com.bank.MCC.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MetaModel {

    Integer id;

    String nameOfApplication;

    String ownerOfApplication;

    String configManagerOfApplication;

    int version;
}
