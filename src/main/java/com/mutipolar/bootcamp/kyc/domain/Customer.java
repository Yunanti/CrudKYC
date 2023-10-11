package com.mutipolar.bootcamp.kyc.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document
public class Customer {
    @Id
    private String id;
    @NotEmpty(message = "nik cannot be empty")
    private String nik;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private Address address;
    private MembershipStatus membershipStatus;
}
