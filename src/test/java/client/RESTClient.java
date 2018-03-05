package client;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;

public class RESTClient {

    private static final String BASE_URL = "https://restcountries.eu/rest/v1/";
    private static final String ALL_COUNTRIES_URI = "all";

    public static Response getAllCountries() {

        return given().when().get(BASE_URL + ALL_COUNTRIES_URI);

    }

}