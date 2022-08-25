import com.starAndShadow.may.sakila.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {
    int customerId = 1;
    int storeId = 2;
    String firstName = "Blah";
    String lastName = "Flah";
    String fullName = "Blah Flah";
    int addressId = 1;
    Boolean active = true;
    String email = "blah@blah.co.uk";
    String createDate = "2022-08-22";
    String lastUpdate = "2022-08-22";
    Customer testCustomer = new Customer();
    @BeforeEach
    void beforeAll() {
        testCustomer = new Customer(customerId, storeId,firstName,lastName, fullName, addressId, active, email, createDate, lastUpdate);
    }

    @Test
    void test_getCustomerId(){
        assertEquals(customerId, testCustomer.getCustomerId(), "returns customer id.");
    }
    @Test
    void test_getStoreId(){
        assertEquals(storeId, testCustomer.getStoreId(),"returns name");
    }
    @Test
    void test_getFirstName(){
        assertEquals(firstName, testCustomer.getFirstName(), "returns first name");
    }
    @Test
    void test_getLastName(){
        assertEquals(lastName, testCustomer.getLastName(), "returns last name");
    }
    @Test
    void test_getFullName(){
        assertEquals(fullName, testCustomer.getFullName(), "returns full name");
    }
    @Test
    void test_getAddressId(){
        assertEquals(addressId, testCustomer.getAddressId(), "returns address id");
    }
    @Test
    void test_getActive(){
        assertEquals(active, testCustomer.getActive(), "returns active");
    }
    @Test
    void test_getEmail(){
        assertEquals(email, testCustomer.getEmail(), "returns email");
    }
    @Test
    void test_getLastUpdate(){
        assertEquals(lastUpdate, testCustomer.getLastUpdate(), "returns last update");
    }
}
