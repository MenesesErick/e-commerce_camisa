package br.unitins.tp1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.material.MaterialDTO;
import jakarta.ws.rs.core.MediaType;

public class MaterialResourceTest {
        @Test
    public void findAllTest() {
        given()
                .when()
                .get("/materiais")
                .then()
                .statusCode(200);
    }

    @Test
    public void findByIdTest() {
        given()
                .when()
                .get("/materiais/1")
                .then()
                .statusCode(200)
                .body("id", is(1));
    }

    @Test
    public void findByNomeTest() {
        given()
                .when()
                .get("/materiais/search/nome/Algodao")
                .then()
                .statusCode(200)
                .body("nome", everyItem(is("Algodao")));
    }

    @Test
    public void createTest() {
        MaterialDTO dto = new MaterialDTO("Malha", 100);

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .post("/materiais")
                .then()
                .statusCode(201)
                .body("nome", is("Malha"))
                .body("porcentagem", is(100f));;
    }

    @Test
    public void updateTest() {
        MaterialDTO dto = new MaterialDTO("Poliester", 75);

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .pathParam("id", 3)
                .put("/materiais/{id}")
                .then()
                .statusCode(204);

    }

    @Test
    public void deleteTest() {

        given()
                .when()
                .pathParam("id", 5)
                .delete("/materiais/{id}")
                .then()
                .statusCode(204);

    }
}
