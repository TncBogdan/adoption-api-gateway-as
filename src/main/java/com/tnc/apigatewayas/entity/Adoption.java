package com.tnc.apigatewayas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adoption {
    private String animal;
    private String shelter;
    private String user;

}
