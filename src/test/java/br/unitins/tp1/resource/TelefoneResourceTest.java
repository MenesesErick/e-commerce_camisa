package br.unitins.tp1.resource;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.telefone.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
public class TelefoneResourceTest {
    @Test
    public void findAllTest() {
        given()
                .when()
                .get("/telefones")
                .then()
                .statusCode(200);
    }

    @Test
    public void findByIdTest() {
        given()
                .when()
                .get("/telefones/1")
                .then()
                .statusCode(200)
                .body("id", is(1));
    }

    @Test
    public void findByCodigoArea() {
        given()
                .when()
                .get("/telefones/search/codigoArea/11")
                .then()
                .statusCode(200)
                .body("codigoArea", hasItem(is("11")));
    }

    @Test
    public void findByNumero() {
        given()
                .when()
                .get("/telefones/search/numero/123456789")
                .then()
                .statusCode(200)
                .body("numero", hasItem(is("123456789")));
    }

    @Test
    public void createTest(){
        TelefoneDTO dto = new TelefoneDTO("77", "2468159753");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .post("/telefones")
            .then()
            .statusCode(201)
            .body("codigoArea", is("77"))
            .body("numero", is("2468159753"));
    }

    @Test
    public void updateTest(){//ta fazendo update apenas de telefones cadastrados no banco
        TelefoneDTO dto = new TelefoneDTO("88", "3579518642");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .pathParam("id", 11)
            .put("/telefones/{id}")
            .then()
            .statusCode(204);
    }
 
    @Test
    public void deleteTest(){
        given()
            .when()
            .pathParam("id", 10)
            .delete("/telefones/{id}")
            .then()
            .statusCode(204);
    }
           
}