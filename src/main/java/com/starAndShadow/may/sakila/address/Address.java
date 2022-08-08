package com.starAndShadow.may.sakila.address;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name="address")
public class Address {
    @Id
    @Column(name="address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    //attribute
    @Column(name="address")
    private String address;

    @Column(name="address2")
    private String address2;

    @Column(name="district")
    private String district;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name="phone")
    private String phone;

    @Column(name="location")
    private String location;

    @Column(name="last_update")
    private String lastUpdate;

    @OneToMany(mappedBy="addressId")
    private Set<Address> addresses;

    public Address(String address, String address2, String district, String postalCode, String phone, String location) {
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.postalCode = postalCode;
        this.phone = phone;
        this.location = location;
    }

    public Address() {
    }

    public Integer getAddressId() {
        return addressId;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void update(Map<String, Object> changes) {
        changes.forEach(
            (change, value) -> {
            switch (change) {
                case "address":
                    this.setAddress((String) value);
                    break;
                case "address2":
                    this.setAddress2((String) value);
                    break;
                case "district":
                    this.setDistrict((String) value);
                    break;
                case "postalCode":
                    this.setPostalCode((String) value);
                    break;
                case "phone":
                    this.setPhone((String) value);
                    break;
                case "location":
                    this.setLocation((String) value);
                    break;
            }
        });
        LocalDateTime now = LocalDateTime.now();
        this.setLastUpdate(String.valueOf(now));
    }

    @Override
    public String toString() {
        return "{" +
                "\"ID\"= \"" + addressId +
                "\"Address\"= \"" + address +
                "\"}";
    }
}

