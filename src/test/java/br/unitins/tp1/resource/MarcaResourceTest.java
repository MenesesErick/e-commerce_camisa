package br.unitins.tp1.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.marca.MarcaDTO;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MarcaResourceTest {

    @Test
    public void findAllTest() {
        given()
                .when()
                .get("/marcas")
                .then()
                .statusCode(200);
    }

    @Test
    public void findByIdTest() {
        given()
                .when()
                .get("/marcas/1")
                .then()
                .statusCode(200)
                .body("id", is(1));
    }

    @Test
    public void findByNomeTest() {
        given()
                .when()
                .get("/marcas/search/nome/Nike")
                .then()
                .statusCode(200)
                .body("nome", everyItem(is("Nike")));
    }

    @Test
    public void createTest() {
        MarcaDTO dto = new MarcaDTO("Adidas");

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .post("/marcas")
                .then()
                .statusCode(201)
                .body("nome", is("Adidas"));
    }

    @Test
    public void updateTest() {
        MarcaDTO dto = new MarcaDTO("Nike2");

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .pathParam("id", 3)
                .put("/marcas/{id}")
                .then()
                .statusCode(204);

    }

    @Test
    public void deleteTest() {

        given()
                .when()
                .pathParam("id", 3)
                .delete("/marcas/{id}")
                .then()
                .statusCode(204);

    }

}
