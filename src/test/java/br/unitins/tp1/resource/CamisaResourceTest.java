package br.unitins.tp1.resource;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.camisa.CamisaDTO;
import jakarta.ws.rs.core.MediaType;

public class CamisaResourceTest {
    @Test
    public void findAllTest() {
        given()
                .when()
                .get("/camisas")
                .then()
                .statusCode(200);

    }

    @Test
    public void findByIdTest() {
        given()
                .when()
                .get("/camisas/1")
                .then()
                .statusCode(200)
                .body("id", is(1));
    }

    @Test
    public void findByNomeTest() {
        given()
                .when()
                .get("/camisas/search/nome/Camisa1")
                .then()
                .statusCode(200)
                .body("nome", everyItem(is("Camisa1")));
    }

    @Test
    public void findByDescricaoTest() {
        given()
                .when()
                .get("/camisas/search/descricao/CamisaComDragao")
                .then()
                .statusCode(200)
                .body("descricao", everyItem(is("CamisaComDragao")));
    }

    @Test
    public void createTest() {
        CamisaDTO dto = new CamisaDTO(
                "Camisa do Flamengooo",
                "Camisa Principal do Flamengooo",
                "Vermelho e Preto",
                200,
                55,
                50,
                50,
                2,
                2L, 
                2L, 
                4L, 
                List.of(2L)
        );

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .post("/camisas")
                .then()
                .statusCode(201)
                .body("nome", is("Camisa do Flamengooo"))
                .body("descricao", is("Camisa Principal do Flamengooo"))
                .body("cor", is("Vermelho e Preto"))
                ;
    }

    @Test
    public void updateTest() {
        CamisaDTO dto = new CamisaDTO(
                "Camisa do Real Madri",
                "Camisa Principal do Real Madri",
                "Branco",
                200,
                55,
                50,
                50,
                3,
                2L,
                2L,
                4L,
                List.of(4L));

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .pathParam("id", 1)
                .put("/camisas/{id}")
                .then()
                .statusCode(204);

    }

    @Test
    public void deleteTest() {

        given()
                .when()
                .pathParam("id", 3)
                .delete("/camisas/{id}")
                .then()
                .statusCode(204);
    }

}

