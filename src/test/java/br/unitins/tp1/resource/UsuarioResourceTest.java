package br.unitins.tp1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.usuario.UsuarioDTO;
import jakarta.ws.rs.core.MediaType;

public class UsuarioResourceTest {
    @Test
    public void findAllTest() {
        given()
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200);
    }

    @Test
    public void findByIdTest() {
        given()
                .when()
                .get("/usuarios/1")
                .then()
                .statusCode(200)
                .body("id", is(1));
    }

    @Test
    public void findByNomeTest() {
        given()
                .when()
                .get("/usuarios/search/nome/ciclano")
                .then()
                .statusCode(200)
                .body("nome", everyItem(is("ciclano")));
    }


    @Test
    public void createTest() {
        UsuarioDTO dto = new UsuarioDTO(
            "tester",
            "tester@gmail.com",
            "senha",
            1,
            3L,
            14L
        );

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .post("/usuarios")
                .then()
                .statusCode(201)
                .body("nome", is("tester"))
                .body("gmail", is("tester@gmail.com"))
                .body("senha", is("senha"))
                .body("idSexo.id", is(1))
                .body("enderco.id", is(3))
                .body("telefone.id", is(14));
    }

    @Test
    public void updateTest() {
        UsuarioDTO dto = new UsuarioDTO(
            "tester5",
            "tete5gmail.com",
            "senhaaa5",
            1,
            2L,
            12L
        );

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .pathParam("id", 3)
                .put("/usuarios/{id}")
                .then()
                .statusCode(204);

    }

    @Test
    public void deleteTest() {

        given()
                .when()
                .pathParam("id", 4)
                .delete("/usuarios/{id}")
                .then()
                .statusCode(204);

    }
}
