package rest_assured;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

public class RestAssuredTest {
  private final String TRAINING_PROCESS_ONLINE_TASKS = "/api/training-process/tasks/online";
  private final String SKILL_DESCRIPTION_LOCALISED ="/api/skills-descriptions/get-localized";

  private final int taskId = 9097;

  @Test
  public void checkOnlineTask() {
    ValidatableResponse response = given()
        .when()
        .get(TRAINING_PROCESS_ONLINE_TASKS + "/" + taskId)
        .then();
    response.log().body();
  }

  @Test //There's differen waitpoints - sometimes they need queryParam, sometimes - not.
  public void checkSkillDescriptionLocalised() {
    ValidatableResponse response = given()
        .queryParam("stringId", "AutoSkillDescr")
        .when()
        .get(SKILL_DESCRIPTION_LOCALISED)
        .then();
    response.log().body();
  }

  @Test //making a post request
  public void postRequest() {
    String endPoint = "http://Some.end.point";
    String body = "{"                      //Json string is used here
        + "\"name\": \"Some Object\","
        + "\"description\": \"Json string\""
        + "\"other_fields\": \"some String\""
        + "}";

    given()
        .body(body)
        .when()
        .post(endPoint)
        .then()
        .log()
        .body();
  }

  @Test //making a put request
  //DELETE - almost the same, just need to use delete() instead of put() and most likely the body will be {"id": 15}
  public void putRequest() {
    String endPoint = "http://end.point.for.put";
    String body = "{"                       //Json string is used here
        + "\"id\": 15"
        + "\"name\": \"You might change name here\","
        + "\"description\": \"changes might be here\""
        + "\"other_fields\": \"changes might be here\""
        + "}";

    given()
        .body(body)
        .when()
        .put(endPoint)
        .then()
        .log()
        .body();
  }

}
