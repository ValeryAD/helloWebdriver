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

}
