import com.starAndShadow.may.sakila.dto.CustomerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerDTOTest {
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

    @Test
    void test_setCustomerId(){
        int expected = 123;
        testCustomer.setCustomerId(expected);
        assertEquals(expected, testCustomer.getCustomerId(), "set customer id.");
    }

    @Test
    void test_setStoreId(){
        int expected = 123;
        testCustomer.setStoreId(expected);
        assertEquals(expected, testCustomer.getStoreId(), "set store id.");
    }

    @Test
    void test_setFirstName(){
        String expected = "blah";
        testCustomer.setFirstName(expected);
        assertEquals(expected, testCustomer.getFirstName(), "set first name.");
    }

    @Test
    void test_setLastName(){
        String expected = "flah";
        testCustomer.setLastName(expected);
        assertEquals(expected, testCustomer.getLastName(), "set last name.");
    }

    @Test
    void test_setFullName(){
        String expected = "flah blah";
        testCustomer.setFullName(expected);
        assertEquals(expected, testCustomer.getFullName(), "set full name.");
    }

    @Test
    void test_setAddressId(){
        int expected = 1;
        testCustomer.setAddressId(expected);
        assertEquals(expected, testCustomer.getAddressId(), "set last name.");
    }

    @Test
    void test_setEmail(){
        String expected = "blahflah@flah.com";
        testCustomer.setEmail(expected);
        assertEquals(expected, testCustomer.getEmail(), "set last name.");
    }
}
