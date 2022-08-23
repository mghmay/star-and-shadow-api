import com.starAndShadow.may.sakila.model.Actor;
import com.starAndShadow.may.sakila.model.Film;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActorTest {
    //test address getters and setters
    Integer actorId = 1;
    Set<Film> films = new HashSet<>();
    String firstName = "Blah blah";
    String lastName = "Kentucky";
    String fullName = "Blah blah Kentucky";
    String lastUpdate = "2022-06-23";
    Actor testActor = new Actor();
    @Test
    @BeforeEach
    void beforeAll() {
        Film film = new Film();
        films.add(film);
        testActor = new Actor(actorId, films, firstName, lastName, fullName, lastUpdate);
    }
    @Test
    void test_getActorId(){
        assertEquals(actorId, testActor.getActorId(), "returns actor id.");
    }
    @Test
    void test_getFilms(){
        assertEquals(films, testActor.getFilms(),"returns films");
    }
    @Test
    void test_getFirstName(){
        assertEquals(firstName, testActor.getFirstName(), "returns first name");
    }
    @Test
    void test_getLastName(){
        assertEquals(lastName, testActor.getLastName(), "returns last name");
    }
    @Test
    void test_getFullName(){
        assertEquals(fullName, testActor.getFullName(), "returns Full Name");
    }
    @Test
    void test_getLastUpdate(){
        assertEquals(lastUpdate, testActor.getLastUpdate(), "returns last update");
    }
}