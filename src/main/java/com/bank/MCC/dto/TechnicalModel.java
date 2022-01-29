package com.bank.MCC.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TechnicalModel {
    Integer id;

    String roles;

    String permissions;

    Integer version;
}
