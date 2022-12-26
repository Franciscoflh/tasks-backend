package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAPI {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "http://localhost:8001/tasks-backend";
    }

    @Test
    public void shouldReturnAllTasks(){
        RestAssured.given().when().get("/todo").then().statusCode(200);
    }

    @Test
    public void shoudAddTaskSuccess(){
        RestAssured.
                given().
                body("{\"id\": 2, \"task\": \"teste API\", \"dueDate\": \"2022-12-26\"}").
                contentType(ContentType.JSON).
                when().
                post("/todo").
                then().
                statusCode(201);
    }

    @Test
    public void shoudNotAddTaskWithInvalidDate(){
        RestAssured.
                given().
                body("{\"id\": 2, \"task\": \"teste API\", \"dueDate\": \"2020-12-26\"}").
                contentType(ContentType.JSON).
                when().
                post("/todo").
                then().
                statusCode(400)
                .body("message", CoreMatchers.is("Due date must not be in past"));
    }
}
