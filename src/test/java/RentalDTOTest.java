import com.starAndShadow.may.sakila.dto.RentalDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RentalDTOTest {
    String rentalDate;
    Integer inventoryId;
    Integer customerId;
    Integer staffId;
    String lastUpdate;
    RentalDTO testRental = new RentalDTO();

    @BeforeEach
    void beforeAll() {
        testRental = new RentalDTO(
                rentalDate,
                inventoryId,
                customerId,
                staffId,
                lastUpdate);
    }

    @Test
    void test_getRentalDate(){
        assertEquals(rentalDate, testRental.getRentalDate(), "returns rental date.");
    }
    @Test
    void test_getInventoryId(){
        assertEquals(inventoryId, testRental.getInventoryId(), "returns inventory id.");
    }
    @Test
    void test_getCustomerId(){
        assertEquals(customerId, testRental.getCustomerId(), "returns customer id.");
    }
    @Test
    void test_getStaffId(){
        assertEquals(staffId, testRental.getStaffId(), "returns staff id.");
    }
    @Test
    void test_getLastUpdate(){
        assertEquals(lastUpdate, testRental.getLastUpdate(), "returns last update.");
    }
    @Test
    void test_setRentalDate(){
        String expected = "2022-10-1";
        testRental.setRentalDate(expected);
        assertEquals(expected, testRental.getRentalDate(), "set rental date.");
    }
    @Test
    void test_setInventoryId(){
        int expected = 1;
        testRental.setInventoryId(expected);
        assertEquals(expected, testRental.getInventoryId(), "set inventory id.");
    }
    @Test
    void test_setCustomerId(){
        int expected = 1;
        testRental.setCustomerId(expected);
        assertEquals(expected, testRental.getCustomerId(), "set customer id.");
    }
    @Test
    void test_setStaffId(){
        int expected = 1;
        testRental.setStaffId(expected);
        assertEquals(expected, testRental.getStaffId(), "set staff id.");
    }
    @Test
    void test_setLastUpdate(){
        String expected = "2032-1-1";
        testRental.setLastUpdate(expected);
        assertEquals(expected, testRental.getLastUpdate(), "set last update.");
    }
}
