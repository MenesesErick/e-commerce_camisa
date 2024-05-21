package br.unitins.tp1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.cliente.ClienteDTO;
import br.unitins.tp1.dto.endereco.EnderecoDTO;
import br.unitins.tp1.dto.telefone.TelefoneDTO;
import jakarta.ws.rs.core.MediaType;

public class ClienteResourceTest {

        @Test
        public void findAllTest() {
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6ImV1IiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjMzODI0OCwiaWF0IjoxNzE2MjUxODQ4LCJqdGkiOiJkYWMxZGZhYi03YmQwLTQ2NTgtYjRhMS1iMWEyMTVlOWEzODcifQ.XI5cGU1kLSwaz7FjOPG3_oQMDclX_MkBnGOlyxIY7OudtobuPHXUUx4pSnjAwnjB-KBl48rXu1TvmqgDlnlz6YwDiP6ZScz2IU9B2yBFmq_Z704mzadzzS1nwtkFp8AfrgWfqMscgQO1Wrz4PUFq-2ouoPw6-vu9vxtE2tp101PzAdbfNnFY9I2SYvKHDIB_-QpOirCaP_AvCLloH7VMJXoJ0h8r-aj1qnGKha0lWnmYske-MMGLtZ5V30KXOwROj4vBj2LvviK7WpCX41LEV_jdXIs4hf821OVxO7DqvvHsglFMNbvgf-QsTmfH2GqV8oNcjCwMl1sorHko8Szpgg";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .when()
                                .get("/clientes")
                                .then()
                                .statusCode(200);

        }

        @Test
        public void findByIdTest() {
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6ImV1IiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjMzODI0OCwiaWF0IjoxNzE2MjUxODQ4LCJqdGkiOiJkYWMxZGZhYi03YmQwLTQ2NTgtYjRhMS1iMWEyMTVlOWEzODcifQ.XI5cGU1kLSwaz7FjOPG3_oQMDclX_MkBnGOlyxIY7OudtobuPHXUUx4pSnjAwnjB-KBl48rXu1TvmqgDlnlz6YwDiP6ZScz2IU9B2yBFmq_Z704mzadzzS1nwtkFp8AfrgWfqMscgQO1Wrz4PUFq-2ouoPw6-vu9vxtE2tp101PzAdbfNnFY9I2SYvKHDIB_-QpOirCaP_AvCLloH7VMJXoJ0h8r-aj1qnGKha0lWnmYske-MMGLtZ5V30KXOwROj4vBj2LvviK7WpCX41LEV_jdXIs4hf821OVxO7DqvvHsglFMNbvgf-QsTmfH2GqV8oNcjCwMl1sorHko8Szpgg";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .when()
                                .get("/clientes/1")
                                .then()
                                .statusCode(200)
                                .body("id", is(1));
        }

        @Test
        public void findByCpfTest() {
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6ImV1IiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjMzODI0OCwiaWF0IjoxNzE2MjUxODQ4LCJqdGkiOiJkYWMxZGZhYi03YmQwLTQ2NTgtYjRhMS1iMWEyMTVlOWEzODcifQ.XI5cGU1kLSwaz7FjOPG3_oQMDclX_MkBnGOlyxIY7OudtobuPHXUUx4pSnjAwnjB-KBl48rXu1TvmqgDlnlz6YwDiP6ZScz2IU9B2yBFmq_Z704mzadzzS1nwtkFp8AfrgWfqMscgQO1Wrz4PUFq-2ouoPw6-vu9vxtE2tp101PzAdbfNnFY9I2SYvKHDIB_-QpOirCaP_AvCLloH7VMJXoJ0h8r-aj1qnGKha0lWnmYske-MMGLtZ5V30KXOwROj4vBj2LvviK7WpCX41LEV_jdXIs4hf821OVxO7DqvvHsglFMNbvgf-QsTmfH2GqV8oNcjCwMl1sorHko8Szpgg";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .when()
                                .get("/clientes/search/cpf/745896123")
                                .then()
                                .statusCode(200)
                                .body("cpf", everyItem(is("745896123")));
                ;
        }

        @Test
        public void createTest() {
                EnderecoDTO enderecoDTO = new EnderecoDTO("575", "55", "update", "55", "updatee", "cdd", "est");
                TelefoneDTO telefoneDTO = new TelefoneDTO("855", "8585855");
                ClienteDTO dto = new ClienteDTO(
                                "88888",
                                "marco",
                                "marquinhoss",
                                "omarcoss@gmail.com",
                                "marcos1",
                                1,
                                enderecoDTO,
                                telefoneDTO);

                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6ImV1IiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjMzODI0OCwiaWF0IjoxNzE2MjUxODQ4LCJqdGkiOiJkYWMxZGZhYi03YmQwLTQ2NTgtYjRhMS1iMWEyMTVlOWEzODcifQ.XI5cGU1kLSwaz7FjOPG3_oQMDclX_MkBnGOlyxIY7OudtobuPHXUUx4pSnjAwnjB-KBl48rXu1TvmqgDlnlz6YwDiP6ZScz2IU9B2yBFmq_Z704mzadzzS1nwtkFp8AfrgWfqMscgQO1Wrz4PUFq-2ouoPw6-vu9vxtE2tp101PzAdbfNnFY9I2SYvKHDIB_-QpOirCaP_AvCLloH7VMJXoJ0h8r-aj1qnGKha0lWnmYske-MMGLtZ5V30KXOwROj4vBj2LvviK7WpCX41LEV_jdXIs4hf821OVxO7DqvvHsglFMNbvgf-QsTmfH2GqV8oNcjCwMl1sorHko8Szpgg";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .header("Authorization", "Bearer " + tokenAdm)
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(dto)
                                .when()
                                .post("/clientes")
                                .then()
                                .statusCode(201)
                                .body("cpf", is("88888"));
        }

        @Test
        public void updateTest() {
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6ImV1IiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjMzODI0OCwiaWF0IjoxNzE2MjUxODQ4LCJqdGkiOiJkYWMxZGZhYi03YmQwLTQ2NTgtYjRhMS1iMWEyMTVlOWEzODcifQ.XI5cGU1kLSwaz7FjOPG3_oQMDclX_MkBnGOlyxIY7OudtobuPHXUUx4pSnjAwnjB-KBl48rXu1TvmqgDlnlz6YwDiP6ZScz2IU9B2yBFmq_Z704mzadzzS1nwtkFp8AfrgWfqMscgQO1Wrz4PUFq-2ouoPw6-vu9vxtE2tp101PzAdbfNnFY9I2SYvKHDIB_-QpOirCaP_AvCLloH7VMJXoJ0h8r-aj1qnGKha0lWnmYske-MMGLtZ5V30KXOwROj4vBj2LvviK7WpCX41LEV_jdXIs4hf821OVxO7DqvvHsglFMNbvgf-QsTmfH2GqV8oNcjCwMl1sorHko8Szpgg";

                EnderecoDTO enderecoDTO = new EnderecoDTO("55", "55", "update", "55", "updatee", "cdd", "est");
                TelefoneDTO telefoneDTO = new TelefoneDTO("855", "8585855");

                ClienteDTO dto = new ClienteDTO(
                                "00000001",
                                "henry",
                                "henryy",
                                "hery@gmail.com",
                                "enrir1",
                                1,
                                enderecoDTO,
                                telefoneDTO);
                given()
                                .header("Authorization", "Bearer " + tokenAdm)
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
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6ImV1IiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjMzODI0OCwiaWF0IjoxNzE2MjUxODQ4LCJqdGkiOiJkYWMxZGZhYi03YmQwLTQ2NTgtYjRhMS1iMWEyMTVlOWEzODcifQ.XI5cGU1kLSwaz7FjOPG3_oQMDclX_MkBnGOlyxIY7OudtobuPHXUUx4pSnjAwnjB-KBl48rXu1TvmqgDlnlz6YwDiP6ZScz2IU9B2yBFmq_Z704mzadzzS1nwtkFp8AfrgWfqMscgQO1Wrz4PUFq-2ouoPw6-vu9vxtE2tp101PzAdbfNnFY9I2SYvKHDIB_-QpOirCaP_AvCLloH7VMJXoJ0h8r-aj1qnGKha0lWnmYske-MMGLtZ5V30KXOwROj4vBj2LvviK7WpCX41LEV_jdXIs4hf821OVxO7DqvvHsglFMNbvgf-QsTmfH2GqV8oNcjCwMl1sorHko8Szpgg";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .when()
                                .pathParam("id", 2)
                                .delete("/clientes/{id}")
                                .then()
                                .statusCode(204);
        }
}
