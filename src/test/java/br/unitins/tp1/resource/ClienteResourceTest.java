package br.unitins.tp1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.cliente.ClienteDTO;
import jakarta.ws.rs.core.MediaType;

public class ClienteResourceTest {

        @Test
        public void findAllTest() {
                given()
                                .when()
                                .get("/clientes")
                                .then()
                                .statusCode(200);

        }

        @Test
        public void findByIdTest() {
                given()
                                .when()
                                .get("/clientes/1")
                                .then()
                                .statusCode(200)
                                .body("id", is(1));
        }

        @Test
        public void findByCpfTest() {
                given()
                                .when()
                                .get("/clientes/search/cpf/745896123")
                                .then()
                                .statusCode(200)
                                .body("cpf", everyItem(is("745896123")));
                ;
        }

        // insert into endereco(cpf, logradouro, bairro, numero, complemento, cidade,
        // estado)
        // values ('741741','lugar','arnos','74','ali','palmas','tocantins');

        @Test
        public void createTest() {
                ClienteDTO dto = new ClienteDTO("07851141141", 13L);

                given()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(dto)
                                .when()
                                .post("/clientes")
                                .then()
                                .statusCode(201)
                                .body("cpf", is("07851141141"))
                                .body("usuario.id", is(13));
        }

        @Test
        public void updateTest() {
                ClienteDTO dto = new ClienteDTO("11111111111", 1L);

                given()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(dto)
                                .when()
                                .pathParam("id", 1)
                                .put("/clientes/{id}")
                                .then()
                                .statusCode(204);

        }

        @Test
        public void deleteTest() {

                given()
                                .when()
                                .pathParam("id", 2)
                                .delete("/clientes/{id}")
                                .then()
                                .statusCode(204);
        }
}
