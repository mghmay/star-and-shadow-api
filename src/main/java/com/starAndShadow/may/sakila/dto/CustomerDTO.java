package com.starAndShadow.may.sakila.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CustomerDTO {
    private Integer customerId;
    private Integer storeId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private Integer addressId;
}
