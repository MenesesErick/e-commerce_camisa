package br.unitins.tp1.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.marca.MarcaDTO;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MarcaResourceTest {

    @Test
    public void findAllTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6ImV1IiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjMzODI0OCwiaWF0IjoxNzE2MjUxODQ4LCJqdGkiOiJkYWMxZGZhYi03YmQwLTQ2NTgtYjRhMS1iMWEyMTVlOWEzODcifQ.XI5cGU1kLSwaz7FjOPG3_oQMDclX_MkBnGOlyxIY7OudtobuPHXUUx4pSnjAwnjB-KBl48rXu1TvmqgDlnlz6YwDiP6ZScz2IU9B2yBFmq_Z704mzadzzS1nwtkFp8AfrgWfqMscgQO1Wrz4PUFq-2ouoPw6-vu9vxtE2tp101PzAdbfNnFY9I2SYvKHDIB_-QpOirCaP_AvCLloH7VMJXoJ0h8r-aj1qnGKha0lWnmYske-MMGLtZ5V30KXOwROj4vBj2LvviK7WpCX41LEV_jdXIs4hf821OVxO7DqvvHsglFMNbvgf-QsTmfH2GqV8oNcjCwMl1sorHko8Szpgg";

        given()
                .header("Authorization", "Bearer " + tokenAdm)
                .when()
                .get("/marcas")
                .then()
                .statusCode(200);
    }

    @Test
    public void findByIdTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6ImV1IiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjMzODI0OCwiaWF0IjoxNzE2MjUxODQ4LCJqdGkiOiJkYWMxZGZhYi03YmQwLTQ2NTgtYjRhMS1iMWEyMTVlOWEzODcifQ.XI5cGU1kLSwaz7FjOPG3_oQMDclX_MkBnGOlyxIY7OudtobuPHXUUx4pSnjAwnjB-KBl48rXu1TvmqgDlnlz6YwDiP6ZScz2IU9B2yBFmq_Z704mzadzzS1nwtkFp8AfrgWfqMscgQO1Wrz4PUFq-2ouoPw6-vu9vxtE2tp101PzAdbfNnFY9I2SYvKHDIB_-QpOirCaP_AvCLloH7VMJXoJ0h8r-aj1qnGKha0lWnmYske-MMGLtZ5V30KXOwROj4vBj2LvviK7WpCX41LEV_jdXIs4hf821OVxO7DqvvHsglFMNbvgf-QsTmfH2GqV8oNcjCwMl1sorHko8Szpgg";

        given()
                .header("Authorization", "Bearer " + tokenAdm)
                .when()
                .get("/marcas/1")
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
                .get("/marcas/search/nome/Nike")
                .then()
                .statusCode(200)
                .body("nome", everyItem(is("Nike")));
    }

    @Test
    public void createTest() {
        MarcaDTO dto = new MarcaDTO("Adidas");

        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6ImV1IiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjMzODI0OCwiaWF0IjoxNzE2MjUxODQ4LCJqdGkiOiJkYWMxZGZhYi03YmQwLTQ2NTgtYjRhMS1iMWEyMTVlOWEzODcifQ.XI5cGU1kLSwaz7FjOPG3_oQMDclX_MkBnGOlyxIY7OudtobuPHXUUx4pSnjAwnjB-KBl48rXu1TvmqgDlnlz6YwDiP6ZScz2IU9B2yBFmq_Z704mzadzzS1nwtkFp8AfrgWfqMscgQO1Wrz4PUFq-2ouoPw6-vu9vxtE2tp101PzAdbfNnFY9I2SYvKHDIB_-QpOirCaP_AvCLloH7VMJXoJ0h8r-aj1qnGKha0lWnmYske-MMGLtZ5V30KXOwROj4vBj2LvviK7WpCX41LEV_jdXIs4hf821OVxO7DqvvHsglFMNbvgf-QsTmfH2GqV8oNcjCwMl1sorHko8Szpgg";

        given()
                .header("Authorization", "Bearer " + tokenAdm)
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .post("/marcas")
                .then()
                .statusCode(201)
                .body("nome", is("Adidas"));
    }

    @Test
    public void updateTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6ImV1IiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjMzODI0OCwiaWF0IjoxNzE2MjUxODQ4LCJqdGkiOiJkYWMxZGZhYi03YmQwLTQ2NTgtYjRhMS1iMWEyMTVlOWEzODcifQ.XI5cGU1kLSwaz7FjOPG3_oQMDclX_MkBnGOlyxIY7OudtobuPHXUUx4pSnjAwnjB-KBl48rXu1TvmqgDlnlz6YwDiP6ZScz2IU9B2yBFmq_Z704mzadzzS1nwtkFp8AfrgWfqMscgQO1Wrz4PUFq-2ouoPw6-vu9vxtE2tp101PzAdbfNnFY9I2SYvKHDIB_-QpOirCaP_AvCLloH7VMJXoJ0h8r-aj1qnGKha0lWnmYske-MMGLtZ5V30KXOwROj4vBj2LvviK7WpCX41LEV_jdXIs4hf821OVxO7DqvvHsglFMNbvgf-QsTmfH2GqV8oNcjCwMl1sorHko8Szpgg";

        MarcaDTO dto = new MarcaDTO("Nike2");

        given()
                .header("Authorization", "Bearer " + tokenAdm)
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .pathParam("id", 3)
                .put("/marcas/{id}")
                .then()
                .statusCode(204);

    }

    @Test
    public void deleteTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6ImV1IiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjMzODI0OCwiaWF0IjoxNzE2MjUxODQ4LCJqdGkiOiJkYWMxZGZhYi03YmQwLTQ2NTgtYjRhMS1iMWEyMTVlOWEzODcifQ.XI5cGU1kLSwaz7FjOPG3_oQMDclX_MkBnGOlyxIY7OudtobuPHXUUx4pSnjAwnjB-KBl48rXu1TvmqgDlnlz6YwDiP6ZScz2IU9B2yBFmq_Z704mzadzzS1nwtkFp8AfrgWfqMscgQO1Wrz4PUFq-2ouoPw6-vu9vxtE2tp101PzAdbfNnFY9I2SYvKHDIB_-QpOirCaP_AvCLloH7VMJXoJ0h8r-aj1qnGKha0lWnmYske-MMGLtZ5V30KXOwROj4vBj2LvviK7WpCX41LEV_jdXIs4hf821OVxO7DqvvHsglFMNbvgf-QsTmfH2GqV8oNcjCwMl1sorHko8Szpgg";

        given()
                .header("Authorization", "Bearer " + tokenAdm)
                .when()
                .pathParam("id", 3)
                .delete("/marcas/{id}")
                .then()
                .statusCode(204);

    }

}
