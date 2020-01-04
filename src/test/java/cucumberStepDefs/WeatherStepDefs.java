package cucumberStepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Response;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

public class WeatherStepDefs {
    private String city;
    private Response response;

    @Given("city is: (.*) ")
    public void set_city (String city) {
        this.city = city;
    }
    @When(" we are requesting weather ")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
       response = requester.requestWeather(city);
    }
    @Then("lon is (.*) ")
    public void check_lon(double lon) {
        Assertions.assertEquals (lon, response.getCoord().getLon(), "wrong lon");
    }
    @Then("lat is (.*) ")
    public void check_lat(double lat) {
        Assertions.assertEquals (lat, response.getCoord().getLon(), "wrong lon");


    }
}
