package br.unitins.tp1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.fornecedor.FornecedorDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class FornecedorResourceTest {

    @Test
    public void findAllTest() {
        given()
                .when()
                .get("/fornecedores")
                .then()
                .statusCode(200);
    }

    @Test
    public void findByIdTest() {
        given()
                .when()
                .get("/fornecedores/1")
                .then()
                .statusCode(200)
                .body("id", is(1));
    }

    @Test
    public void findByNomeTest() {
        given()
                .when()
                .get("/fornecedores/search/nome/tomaAi")
                .then()
                .statusCode(200)
                .body("nome", everyItem(is("tomaAi")));
    }

    @Test
    public void createTest() {
        FornecedorDTO dto = new FornecedorDTO(
                "TesteForne",
                "ttff@gmail.com",
                3L);

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .post("/fornecedores")
                .then()
                .statusCode(201)
                .body("nome", is("TesteForne"))
                .body("gmail", is("ttff@gmail.com"))
                .body("telefone.id", is(3));

    }

    @Test
    public void updateTest() {
        FornecedorDTO dto = new FornecedorDTO(
            "FornecedorTeste2",
        "ft22@gmail.com",
        9L);

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .pathParam("id", 3)
                .put("/fornecedores/{id}")
                .then()
                .statusCode(204);

    }

    @Test
    public void deleteTest() {

        given()
                .when()
                .pathParam("id", 4)
                .delete("/fornecedores/{id}")
                .then()
                .statusCode(204);
    }

}
