package br.unitins.tp1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.funcionario.FuncionarioDTO;
import jakarta.ws.rs.core.MediaType;

public class FuncionarioResourceTest {
            @Test
        public void findAllTest() {
                given()
                        .when()
                        .get("/funcionarios")
                        .then()
                        .statusCode(200);

        }

        @Test
        public void findByIdTest() {
                given()
                        .when()
                        .get("/funcionarios/1")
                        .then()
                        .statusCode(200)
                        .body("id", is(1));
        }

        @Test
        public void findByCpfTest() {
                given()
                                .when()
                                .get("/funcionarios/search/cargo/745896123")
                                .then()
                                .statusCode(200)
                                .body("cargo", everyItem(is("745896123")));
                ;
        }

        @Test
        public void createTest() {
                FuncionarioDTO dto = new FuncionarioDTO("dono da firma", 5L);

                given()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(dto)
                                .when()
                                .post("/funcionarios")
                                .then()
                                .statusCode(201)
                                .body("cargo", is("dono da firma"))
                                .body("usuario.id", is(5))
;
        }

        @Test
        public void updateTest() {
                FuncionarioDTO dto = new FuncionarioDTO("Gerente", 1L);

                given()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(dto)
                                .when()
                                .pathParam("id", 1)
                                .put("/funcionarios/{id}")
                                .then()
                                .statusCode(204);

        }

        @Test
        public void deleteTest() {

                given()
                        .when()
                        .pathParam("id", 2)
                        .delete("/funcionarios/{id}")
                        .then()
                        .statusCode(204);
        }
}
