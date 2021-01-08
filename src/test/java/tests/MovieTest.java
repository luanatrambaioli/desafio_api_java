package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

public class MovieTest {

  private final String MOVIE_ID = "tt1285016";
  private final String INVALID_MOVIE_ID = "tt128016";
  private final String API_KEY = "52ec71bf";

  @Test
  public void getMovieTitle() {

    given()
        .when()
        .get("http://www.omdbapi.com/?i={MOVIE_ID}&apikey={API_KEY}", MOVIE_ID, API_KEY)
        .then()
        .statusCode(200)
        .body("Title", equalTo("The Social Network"));
  }

  @Test
  public void getMovieYear() {

    given()
        .when()
        .get("http://www.omdbapi.com/?i={MOVIE_ID}&apikey={API_KEY}", MOVIE_ID, API_KEY)
        .then()
        .statusCode(200)
        .body("Year", equalTo("2010"));
  }

  @Test
  public void getMovieLanguage() {

    given()
        .when()
        .get("http://www.omdbapi.com/?i={MOVIE_ID}&apikey={API_KEY}", MOVIE_ID, API_KEY)
        .then()
        .statusCode(200)
        .body("Language", equalTo("English, French"));
  }

  @Test
  public void getInvalidMovie() {

    given()
        .when()
        .get(
            "http://www.omdbapi.com/?i={INVALID_MOVIE_ID}&apikey={API_KEY}",
            INVALID_MOVIE_ID,
            API_KEY)
        .then()
        .statusCode(200)
        .body("Error", equalTo("Incorrect IMDb ID."));
  }
}
