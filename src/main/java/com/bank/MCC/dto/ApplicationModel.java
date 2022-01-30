package com.bank.MCC.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApplicationModel {

    String nameOfApplication;

    String ownerOfApplication;

    String configManagerOfApplication;

    String roles;

    String permissions;
}
