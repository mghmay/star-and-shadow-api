import com.starAndShadow.may.sakila.model.Address;
import com.starAndShadow.may.sakila.model.Inventory;
import com.starAndShadow.may.sakila.model.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StoreTest {
    int storeId;
    Set<Inventory> inventory;
    Address address;
    String lastUpdate;
    Store testStore = new Store();

    @BeforeEach
    void beforeAll() {
        testStore = new Store(storeId,
                inventory,
                address,
                lastUpdate);
    }
    @Test
    void test_getStoreId(){
        assertEquals(storeId, testStore.getStoreId(), "returns store id.");
    }
    @Test
    void test_getInventory(){
        assertEquals(inventory, testStore.getInventory(), "returns inventory.");
    }
    @Test
    void test_getAddress(){
        assertEquals(address, testStore.getAddress(), "returns address.");
    }
    @Test
    void test_getLastUpdate(){
        assertEquals(lastUpdate, testStore.getLastUpdate(), "returns last update.");
    }
}
// blah blah test