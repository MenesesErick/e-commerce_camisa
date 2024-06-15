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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

        given()
                .header("Authorization", "Bearer " + tokenAdm)
                .when()
                .get("/estilos")
                .then()
                .statusCode(200);

    }

    @Test
    public void findByIdTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

        given()
                .header("Authorization", "Bearer " + tokenAdm)
                .when()
                .get("/estilos/1")
                .then()
                .statusCode(200)
                .body("id", is(1));
    }

    @Test
    public void findByNomeTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

        given()
                .header("Authorization", "Bearer " + tokenAdm)
                .when()
                .get("/estilos/search/nome/StreetWear")
                .then()
                .statusCode(200)
                .body("nome", everyItem(is("StreetWear")));
    }

    @Test
    public void createTest() {
        EstiloDTO dto = new EstiloDTO("Normal", "Estilo normal");
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

        given()
                .header("Authorization", "Bearer " + tokenAdm)
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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

        EstiloDTO dto = new EstiloDTO("EstiloTeste", "Descricão Teste");

        given()
                .header("Authorization", "Bearer " + tokenAdm)
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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

        given()
                .header("Authorization", "Bearer " + tokenAdm)
                .when()
                .pathParam("id", 3)
                .delete("/estilos/{id}")
                .then()
                .statusCode(204);
    }

}
