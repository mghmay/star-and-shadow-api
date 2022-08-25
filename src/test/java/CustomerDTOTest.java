import com.starAndShadow.may.sakila.dto.CustomerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerDTOTest {
    int customerId = 1;
    int storeId = 2;
    String firstName = "Blah";
    String lastName = "Flah";
    String fullName = "Blah Flah";
    int addressId = 1;
    String email = "blah@blah.co.uk";
    CustomerDTO testCustomer = new CustomerDTO();
    @BeforeEach
    void beforeAll() {
        testCustomer = new CustomerDTO(customerId, storeId,firstName,lastName, fullName, email, addressId);
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
    void test_getEmail(){
        assertEquals(email, testCustomer.getEmail(), "returns email");
    }

}
