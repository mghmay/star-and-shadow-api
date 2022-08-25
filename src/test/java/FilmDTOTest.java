import com.starAndShadow.may.sakila.dto.FilmDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilmDTOTest {
    int filmId = 1;
    String title = "Hyyuuhh";
    String description = "A film about hyuh" ;
    int releaseYear = 2020;
    int languageId = 1;
    String language = "English";
    Map<String, List<Integer>> inventory = new HashMap<>();
    int originalLanguageId = 1;
    Integer rentalDuration = 69;
    BigDecimal rentalRate = BigDecimal.valueOf(10.50);
    int length = 9;
    BigDecimal replacementCost = BigDecimal.valueOf(10.50);
    String rating = "PG-13";
    String[] specialFeatures = {"trailers"};

    List<String> category = new ArrayList<>();

    List<String> cast = new ArrayList<>();

    String lastUpdate = "2022-08-22";

    FilmDTO testFilm = new FilmDTO();

    @BeforeEach
    void beforeAll() {
        testFilm = new FilmDTO(filmId,
                title,
                description,
                releaseYear,
                language,
                languageId,
                originalLanguageId,
                rentalDuration,
                rentalRate,
                length,
                replacementCost,
                rating,
                specialFeatures,
                lastUpdate,
                cast,
                inventory,
                category
                );
    }

    @Test
    void test_getFilmId(){
        assertEquals(filmId, testFilm.getFilmId(), "returns film id.");
    }
    @Test
    void test_getTitle(){
        assertEquals(title, testFilm.getTitle(), "returns title.");
    }
    @Test
    void test_getDescription(){
        assertEquals(description, testFilm.getDescription(),"returns description");
    }
    @Test
    void test_getReleaseYear(){
        assertEquals(releaseYear, testFilm.getReleaseYear(), "returns release year.");
    }
    @Test
    void test_getLanguageId(){
        assertEquals(languageId, testFilm.getLanguageId(), "returns language id");
    }
    @Test
    void test_getLanguage(){
        assertEquals(language, testFilm.getLanguage(), "returns language");
    }
    @Test
    void test_getInventory(){
        assertEquals(inventory, testFilm.getInventory(), "returns inventory");
    }
    @Test
    void test_getOriginalLanguageId(){
        assertEquals(originalLanguageId, testFilm.getOriginalLanguageId(), "returns original language id");
    }
    @Test
    void test_getRentalDuration(){
        assertEquals(rentalDuration, testFilm.getRentalDuration(), "returns rental duration");
    }
    @Test
    void test_getRentalRate(){
        assertEquals(rentalRate, testFilm.getRentalRate(), "returns rental rate");
    }
    @Test
    void test_getLength(){
        assertEquals(length, testFilm.getLength(), "returns length");
    }
    @Test
    void test_getReplacementCost(){
        assertEquals(replacementCost, testFilm.getReplacementCost(), "returns replacement cost");
    }
    @Test
    void test_getSpecialFeatures(){
        assertEquals(specialFeatures, testFilm.getSpecialFeatures(),"returns special features");
    }
    @Test
    void test_getFilmCategory(){
        assertEquals(category, testFilm.getCategory(), "returns film category");
    }
    @Test
    void test_getLastUpdate(){
        assertEquals(lastUpdate, testFilm.getLastUpdate(), "returns last update");
    }

    @Test
    void test_setTitle(){
        String expected = "new title";
        testFilm.setTitle(expected);
        assertEquals(expected, testFilm.getTitle(), "set title.");
    }
    @Test
    void test_setDescription(){
        String expected = "new description";
        testFilm.setDescription(expected);
        assertEquals(expected, testFilm.getDescription(), "set description.");
    }
    @Test
    void test_setReleaseYear(){
        int expected = 1905;
        testFilm.setReleaseYear(expected);
        assertEquals(expected, testFilm.getReleaseYear(), "set release year.");
    }
    @Test
    void test_setLanguageId(){
        int expected = 5;
        testFilm.setLanguageId(expected);
        assertEquals(expected, testFilm.getLanguageId(), "set language id.");
    }
    @Test
    void test_setOriginalLanguageId(){
        int expected = 10;
        testFilm.setOriginalLanguageId(expected);
        assertEquals(expected, testFilm.getOriginalLanguageId(), "set original language id.");
    }
    @Test
    void test_setRentalDuration(){
        int expected = 250;
        testFilm.setRentalDuration(expected);
        assertEquals(expected, testFilm.getRentalDuration(), "set rental duration.");
    }
    @Test
    void test_setRentalRate(){
        BigDecimal expected = BigDecimal.valueOf(380);
        testFilm.setRentalRate(expected);
        assertEquals(expected, testFilm.getRentalRate(), "set rental rate.");
    }
    @Test
    void test_setLength(){
        int expected = 404;
        testFilm.setLength(expected);
        assertEquals(expected, testFilm.getLength(), "set length.");
    }
    @Test
    void test_setReplacementCost(){
        BigDecimal expected = BigDecimal.valueOf(404);
        testFilm.setReplacementCost(expected);
        assertEquals(expected, testFilm.getReplacementCost(), "set replacement cost.");
    }
    @Test
    void test_setRating(){
        String expected = "R";
        testFilm.setRating(expected);
        assertEquals(expected, testFilm.getRating(), "set rating.");
    }
    @Test
    void test_setSpecialFeatures(){
        String[] expected = {"Special features"};
        testFilm.setSpecialFeatures(expected);
        assertEquals(expected, testFilm.getSpecialFeatures(), "set rating.");
    }
    @Test
    void test_lastUpdate(){
        String expected = "2032-1-1";
        testFilm.setLastUpdate(expected);
        assertEquals(expected, testFilm.getLastUpdate(), "set last update.");
    }

}