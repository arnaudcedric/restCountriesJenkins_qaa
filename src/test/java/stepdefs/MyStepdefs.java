package stepdefs;
import client.RESTClient;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
public class MyStepdefs {
    Response response;
    JSONArray listOfCountries;
    public MyStepdefs() {
        listOfCountries = new JSONArray();
    }
    @Given("^user makes a get request to get list of all countries$")
    public void getAllCountries() {
        response = RESTClient.getAllCountries();
        listOfCountries = new JSONArray(response.getBody().asString());
    }
    @Then("^the status code is \"([^\"]*)\"$")
    public void checkStatusCode(int responseCode) {
        assertThat("status code did not match ", response.getStatusCode(), is(responseCode));
    }
    @And("^\"([^\"]*)\" countries are returned$")
    public void coutriesAreReturned(int numberOfCountries) {
        assertThat("number of countries are incorrect", listOfCountries.length(), is(numberOfCountries));
    }
    @When("^the population for \"([^\"]*)\" is \"([^\"]*)\"$")
    public void theUserSelects(String countryName, String population) {
//        JSONObject expectedCountry = null;
        for (int i = 0; i < listOfCountries.length(); i++) {
            JSONObject country = (JSONObject) listOfCountries.get(i);
            if (country.get("name").toString().equalsIgnoreCase(countryName)) {
                assertThat("population number does not match ", country.get("population").toString(), is(population));
//                expectedCountry = country;
//                JSONArray languages = country.getJSONArray("languages");
                break;

//                for (int j = 0; j <languages.length(); j++) {
//                    languages.get(j).toString().equalsIgnoreCase("nl");
//                }
//                for (Object language:languages) {
//                    System.out.println("language : " + language.toString());
//                }
            }
        }
//        for (int x = 0; x < listOfCountries.length(); x++) {
//            JSONArray languages = expectedCountry.getJSONArray("languages");
//            System.out.println("languages : "+languages);
//
//        }
    }
    @And("^languages for \"([^\"]*)\" are:$")
    public void languagesForAre(String countryName, List<String> expectedLanguages)  {
        for (int i = 0; i < listOfCountries.length(); i++){
            JSONObject country = (JSONObject) listOfCountries.get(i);
            if (country.get("name").toString().equalsIgnoreCase(countryName)) {
                JSONArray languages = country.getJSONArray("languages");
                for (int j = 0; j <languages.length(); j++) {
                    assertThat("population number does not match ", languages.get(j).toString(), is(expectedLanguages.get(j)));
                }
            }
        }
    }
}
