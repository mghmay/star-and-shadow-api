package com.starAndShadow.may.sakila.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RentalDTO {
    private String rentalDate;
    private Integer inventoryId;
    private Integer customerId;
    private Integer staffId;
    private String lastUpdate;
}
