package br.unitins.tp1.resource;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;


import br.unitins.tp1.dto.endereco.EnderecoDTO;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class EnderecoResourceTest {

        @Test
        public void findAllTest() {
                given()
                        .when()
                        .get("/enderecos")
                        .then()
                        .statusCode(200);

        }

        @Test
        public void findByIdTest() {
                given()
                        .when()
                        .get("/enderecos/1")
                        .then()
                        .statusCode(200)
                        .body("id", is(1));
        }

        @Test
        public void findByCepTest() {
                given()
                                .when()
                                .get("/enderecos/search/cep/741741")
                                .then()
                                .statusCode(200)
                                .body("cep", everyItem(is("741741")));
                ;
        }

        @Test
        public void findByCidadeTest() {
                given()
                                .when()
                                .get("/enderecos/search/cidade/palmas")
                                .then()
                                .statusCode(200)
                                .body("cidade", everyItem(is("palmas")));

        }

        // insert into endereco(cep, logradouro, bairro, numero, complemento, cidade,
        // estado)
        // values ('741741','lugar','arnos','74','ali','palmas','tocantins');

        @Test
        public void createTest() {
                EnderecoDTO dto = new EnderecoDTO(
                                "777",
                                "teste",
                                "bairroTeste",
                                "77",
                                "complementoTeste",
                                "cidadeTeste",
                                "estadoTeste");

                given()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(dto)
                                .when()
                                .post("/enderecos")
                                .then()
                                .statusCode(201)
                                .body("cep", is("777"))
                                .body("logradouro", is("teste"))
                                .body("bairro", is("bairroTeste"))
                                .body("numero", is("77"))
                                .body("complemento", is("complementoTeste"))
                                .body("cidade", is("cidadeTeste"))
                                .body("estado", is("estadoTeste"));
        }

        @Test
        public void updateTest() {
                EnderecoDTO dto = new EnderecoDTO("888", "teste2", "bairroTeste2", "88", "complementoTeste2",
                                "cidadeTeste2",
                                "estadoTeste2");

                given()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(dto)
                                .when()
                                .pathParam("id", 3)
                                .put("/enderecos/{id}")
                                .then()
                                .statusCode(204);

        }

        @Test
        public void deleteTest() {

                given()
                        .when()
                        .pathParam("id", 5)
                        .delete("/enderecos/{id}")
                        .then()
                        .statusCode(204);
        }

}
