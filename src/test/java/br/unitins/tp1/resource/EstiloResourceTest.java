package br.unitins.tp1.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.estilo.EstiloDTO;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;



@QuarkusTest
public class EstiloResourceTest {

    @Test
    public void findAllTest() {
        given()
                .when()
                .get("/estilos")
                .then()
                .statusCode(200);
    }

    @Test
    public void findByIdTest() {
        given()
                .when()
                .get("/estilos/1")
                .then()
                .statusCode(200)
                .body("id", is(1));
    }

    @Test
    public void findByNomeTest() {
        given()
                .when()
                .get("/estilos/search/nome/StreetWear")
                .then()
                .statusCode(200)
                .body("nome", everyItem(is("StreetWear")));
    }

    @Test
    public void createTest() {
        EstiloDTO dto = new EstiloDTO("Normal", "Estilo normal");

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .post("/estilos")
                .then()
                .statusCode(201)
                .body("nome", is("Normal"))
                .body("descricao", is("Estilo normal"));
    }

    
    @Test
    public void updateTest() {
        EstiloDTO dto = new EstiloDTO("EstiloTeste", "Descricão Teste");

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .pathParam("id", 1)
                .put("/estilos/{id}")
                .then()
                .statusCode(204);

    }


    @Test
    public void deleteTest() {

        given()
                .when()
                .pathParam("id", 3)
                .delete("/estilos/{id}")
                .then()
                .statusCode(204);
    }
    
    
}
