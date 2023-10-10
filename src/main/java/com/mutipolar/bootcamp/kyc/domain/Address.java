package com.mutipolar.bootcamp.kyc.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document
public class Address {
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
