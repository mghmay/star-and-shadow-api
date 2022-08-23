import com.starAndShadow.may.sakila.model.Customer;
import com.starAndShadow.may.sakila.model.Film;
import com.starAndShadow.may.sakila.model.Inventory;
import com.starAndShadow.may.sakila.model.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryTest {
    Integer inventoryId;
    Film film = new Film();
    Store store = new Store();
    String lastUpdate;
    Inventory testInventory = new Inventory();
    @Test
    @BeforeEach
    void beforeAll() {
        testInventory = new Inventory(inventoryId, film, store,lastUpdate);
    }
    @Test
    void test_getInventoryId(){
        assertEquals(inventoryId, testInventory.getInventoryId(), "returns inventory id.");
    }
    @Test
    void test_getFilm(){
        assertEquals(film, testInventory.getFilm(), "returns film.");
    }
    @Test
    void test_getStore(){
        assertEquals(store, testInventory.getStore(), "returns store.");
    }
    @Test
    void test_getLastUpdate(){
        assertEquals(lastUpdate, testInventory.getLastUpdate(), "returns last update.");
    }
}
