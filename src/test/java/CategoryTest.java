import com.starAndShadow.may.sakila.model.Address;
import com.starAndShadow.may.sakila.model.Category;
import com.starAndShadow.may.sakila.model.Film;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.Column;
import javax.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {
    //test address getters and setters
    Integer categoryId = 1;
    String name = "blah";
    Set<Film> filmCategory = new HashSet<>();
    String lastUpdate = "2022-06-23";

    Category testCategory = new Category();
    @Test
    @BeforeEach
    void beforeAll() {
        Film film = new Film();
        filmCategory.add(film);
        testCategory = new Category(categoryId, name, lastUpdate, filmCategory);
    }
    @Test
    void test_getCategoryId(){
        assertEquals(categoryId, testCategory.getCategoryId(), "returns category id.");
    }
    @Test
    void test_getName(){
        assertEquals(name, testCategory.getName(),"returns name");
    }
    @Test
    void test_getLastUpdate(){
        assertEquals(lastUpdate, testCategory.getLastUpdate(), "returns last update");
    }
    @Test
    void test_getFilmCategory(){
        assertEquals(filmCategory, testCategory.getFilmCategory(), "returns film category");
    }
}