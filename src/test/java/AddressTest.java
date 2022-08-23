import com.starAndShadow.may.sakila.model.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddressTest {
    //test address getters and setters
    Integer addressId = 1;
    String address = "123 blah";
    String address2 = "Blah blah";
    String district = "Kentucky";
    String postalCode = "NE12 3RF";
    String phone = "123456789";
    String location = "1";
    String lastUpdate = "2022-06-23";

    Address testAddress = new Address();
    @Test
    @BeforeEach
    void beforeAll() {
        testAddress = new Address(addressId, address, address2, district, postalCode, phone, location, lastUpdate);
    }
    @Test
    void test_getAddressId(){
        assertEquals(addressId, testAddress.getAddressId(), "returns address id.");
    }
    @Test
    void test_getAddress(){
        assertEquals(address, testAddress.getAddress(),"returns address");
    }
    @Test
    void test_getAddress2(){
        assertEquals(address2, testAddress.getAddress2(), "returns line 2 off address");
    }
    @Test
    void test_getDistrict(){
        assertEquals(district, testAddress.getDistrict(), "returns district");
    }
    @Test
    void test_getPostalCode(){
        assertEquals(postalCode, testAddress.getPostalCode(), "returns postal code");
    }
    @Test
    void test_getPhone(){
        assertEquals(phone, testAddress.getPhone(), "returns phone number");
    }
    @Test
    void test_getLocation(){
        assertEquals(location, testAddress.getLocation(), "returns location");
    }
    @Test
    void test_getLastUpdate(){
        assertEquals(lastUpdate, testAddress.getLastUpdate(), "returns last update");
    }
}