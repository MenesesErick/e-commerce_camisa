package br.unitins.tp1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.fornecedor.FornecedorDTO;
import br.unitins.tp1.dto.telefone.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class FornecedorResourceTest {

        @Test
        public void findAllTest() {
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6ImV1IiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjMzODI0OCwiaWF0IjoxNzE2MjUxODQ4LCJqdGkiOiJkYWMxZGZhYi03YmQwLTQ2NTgtYjRhMS1iMWEyMTVlOWEzODcifQ.XI5cGU1kLSwaz7FjOPG3_oQMDclX_MkBnGOlyxIY7OudtobuPHXUUx4pSnjAwnjB-KBl48rXu1TvmqgDlnlz6YwDiP6ZScz2IU9B2yBFmq_Z704mzadzzS1nwtkFp8AfrgWfqMscgQO1Wrz4PUFq-2ouoPw6-vu9vxtE2tp101PzAdbfNnFY9I2SYvKHDIB_-QpOirCaP_AvCLloH7VMJXoJ0h8r-aj1qnGKha0lWnmYske-MMGLtZ5V30KXOwROj4vBj2LvviK7WpCX41LEV_jdXIs4hf821OVxO7DqvvHsglFMNbvgf-QsTmfH2GqV8oNcjCwMl1sorHko8Szpgg";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .when()
                                .get("/fornecedores")
                                .then()
                                .statusCode(200);
        }

        @Test
        public void findByIdTest() {
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6ImV1IiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjMzODI0OCwiaWF0IjoxNzE2MjUxODQ4LCJqdGkiOiJkYWMxZGZhYi03YmQwLTQ2NTgtYjRhMS1iMWEyMTVlOWEzODcifQ.XI5cGU1kLSwaz7FjOPG3_oQMDclX_MkBnGOlyxIY7OudtobuPHXUUx4pSnjAwnjB-KBl48rXu1TvmqgDlnlz6YwDiP6ZScz2IU9B2yBFmq_Z704mzadzzS1nwtkFp8AfrgWfqMscgQO1Wrz4PUFq-2ouoPw6-vu9vxtE2tp101PzAdbfNnFY9I2SYvKHDIB_-QpOirCaP_AvCLloH7VMJXoJ0h8r-aj1qnGKha0lWnmYske-MMGLtZ5V30KXOwROj4vBj2LvviK7WpCX41LEV_jdXIs4hf821OVxO7DqvvHsglFMNbvgf-QsTmfH2GqV8oNcjCwMl1sorHko8Szpgg";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .when()
                                .get("/fornecedores/1")
                                .then()
                                .statusCode(200)
                                .body("id", is(1));
        }

        @Test
        public void findByNomeTest() {
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6ImV1IiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjMzODI0OCwiaWF0IjoxNzE2MjUxODQ4LCJqdGkiOiJkYWMxZGZhYi03YmQwLTQ2NTgtYjRhMS1iMWEyMTVlOWEzODcifQ.XI5cGU1kLSwaz7FjOPG3_oQMDclX_MkBnGOlyxIY7OudtobuPHXUUx4pSnjAwnjB-KBl48rXu1TvmqgDlnlz6YwDiP6ZScz2IU9B2yBFmq_Z704mzadzzS1nwtkFp8AfrgWfqMscgQO1Wrz4PUFq-2ouoPw6-vu9vxtE2tp101PzAdbfNnFY9I2SYvKHDIB_-QpOirCaP_AvCLloH7VMJXoJ0h8r-aj1qnGKha0lWnmYske-MMGLtZ5V30KXOwROj4vBj2LvviK7WpCX41LEV_jdXIs4hf821OVxO7DqvvHsglFMNbvgf-QsTmfH2GqV8oNcjCwMl1sorHko8Szpgg";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .when()
                                .get("/fornecedores/search/nome/tomaAi")
                                .then()
                                .statusCode(200)
                                .body("nome", everyItem(is("tomaAi")));
        }

        @Test
        public void createTest() {
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6ImV1IiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjMzODI0OCwiaWF0IjoxNzE2MjUxODQ4LCJqdGkiOiJkYWMxZGZhYi03YmQwLTQ2NTgtYjRhMS1iMWEyMTVlOWEzODcifQ.XI5cGU1kLSwaz7FjOPG3_oQMDclX_MkBnGOlyxIY7OudtobuPHXUUx4pSnjAwnjB-KBl48rXu1TvmqgDlnlz6YwDiP6ZScz2IU9B2yBFmq_Z704mzadzzS1nwtkFp8AfrgWfqMscgQO1Wrz4PUFq-2ouoPw6-vu9vxtE2tp101PzAdbfNnFY9I2SYvKHDIB_-QpOirCaP_AvCLloH7VMJXoJ0h8r-aj1qnGKha0lWnmYske-MMGLtZ5V30KXOwROj4vBj2LvviK7WpCX41LEV_jdXIs4hf821OVxO7DqvvHsglFMNbvgf-QsTmfH2GqV8oNcjCwMl1sorHko8Szpgg";

                TelefoneDTO telefoneDTO = new TelefoneDTO("63", "12548647");

                FornecedorDTO dto = new FornecedorDTO(
                                "patolino",
                                "ttff@gmail.com",
                                telefoneDTO);

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(dto)
                                .when()
                                .post("/fornecedores")
                                .then()
                                .statusCode(201)
                                .body("nome", is("patolino"));

        }

        @Test
        public void updateTest() {

                TelefoneDTO telefoneDTO = new TelefoneDTO("636", "12548127");

                FornecedorDTO dto = new FornecedorDTO(
                                "FornecedorTeste2",
                                "ft22@gmail.com",
                                telefoneDTO);

                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6ImV1IiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjMzODI0OCwiaWF0IjoxNzE2MjUxODQ4LCJqdGkiOiJkYWMxZGZhYi03YmQwLTQ2NTgtYjRhMS1iMWEyMTVlOWEzODcifQ.XI5cGU1kLSwaz7FjOPG3_oQMDclX_MkBnGOlyxIY7OudtobuPHXUUx4pSnjAwnjB-KBl48rXu1TvmqgDlnlz6YwDiP6ZScz2IU9B2yBFmq_Z704mzadzzS1nwtkFp8AfrgWfqMscgQO1Wrz4PUFq-2ouoPw6-vu9vxtE2tp101PzAdbfNnFY9I2SYvKHDIB_-QpOirCaP_AvCLloH7VMJXoJ0h8r-aj1qnGKha0lWnmYske-MMGLtZ5V30KXOwROj4vBj2LvviK7WpCX41LEV_jdXIs4hf821OVxO7DqvvHsglFMNbvgf-QsTmfH2GqV8oNcjCwMl1sorHko8Szpgg";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
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
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6ImV1IiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjMzODI0OCwiaWF0IjoxNzE2MjUxODQ4LCJqdGkiOiJkYWMxZGZhYi03YmQwLTQ2NTgtYjRhMS1iMWEyMTVlOWEzODcifQ.XI5cGU1kLSwaz7FjOPG3_oQMDclX_MkBnGOlyxIY7OudtobuPHXUUx4pSnjAwnjB-KBl48rXu1TvmqgDlnlz6YwDiP6ZScz2IU9B2yBFmq_Z704mzadzzS1nwtkFp8AfrgWfqMscgQO1Wrz4PUFq-2ouoPw6-vu9vxtE2tp101PzAdbfNnFY9I2SYvKHDIB_-QpOirCaP_AvCLloH7VMJXoJ0h8r-aj1qnGKha0lWnmYske-MMGLtZ5V30KXOwROj4vBj2LvviK7WpCX41LEV_jdXIs4hf821OVxO7DqvvHsglFMNbvgf-QsTmfH2GqV8oNcjCwMl1sorHko8Szpgg";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .when()
                                .pathParam("id", 4)
                                .delete("/fornecedores/{id}")
                                .then()
                                .statusCode(204);
        }

}
