package br.unitins.tp1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.endereco.EnderecoDTO;
import br.unitins.tp1.dto.funcionario.FuncionarioDTO;
import br.unitins.tp1.dto.telefone.TelefoneDTO;
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
                EnderecoDTO enderecoDTO = new EnderecoDTO("44", "44", "create", "44", "create", "teste", "to");
                TelefoneDTO telefoneDTO = new TelefoneDTO("21", "21212121");
                FuncionarioDTO dto = new FuncionarioDTO(
                                "dono da firma",
                                "cleiton",
                                "cleitin",
                                "cleiton@gmail.com",
                                "cleiton123",
                                1,
                                enderecoDTO,
                                telefoneDTO);

                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6ImV1IiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjMzODI0OCwiaWF0IjoxNzE2MjUxODQ4LCJqdGkiOiJkYWMxZGZhYi03YmQwLTQ2NTgtYjRhMS1iMWEyMTVlOWEzODcifQ.XI5cGU1kLSwaz7FjOPG3_oQMDclX_MkBnGOlyxIY7OudtobuPHXUUx4pSnjAwnjB-KBl48rXu1TvmqgDlnlz6YwDiP6ZScz2IU9B2yBFmq_Z704mzadzzS1nwtkFp8AfrgWfqMscgQO1Wrz4PUFq-2ouoPw6-vu9vxtE2tp101PzAdbfNnFY9I2SYvKHDIB_-QpOirCaP_AvCLloH7VMJXoJ0h8r-aj1qnGKha0lWnmYske-MMGLtZ5V30KXOwROj4vBj2LvviK7WpCX41LEV_jdXIs4hf821OVxO7DqvvHsglFMNbvgf-QsTmfH2GqV8oNcjCwMl1sorHko8Szpgg";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(dto)
                                .when()
                                .post("/funcionarios")
                                .then()
                                .statusCode(201)
                                .body("cargo", is("dono da firma"));
        }

        @Test
        public void updateTest() {
                EnderecoDTO enderecoDTO = new EnderecoDTO("55", "55", "update", "55", "updatee", "cdd", "est");
                TelefoneDTO telefoneDTO = new TelefoneDTO("85", "858585");

                FuncionarioDTO dto = new FuncionarioDTO(
                                "Gerente",
                                "Lia",
                                "liaa",
                                "lia@gmail.com",
                                "lia123",
                                2,
                                enderecoDTO,
                                telefoneDTO);

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
