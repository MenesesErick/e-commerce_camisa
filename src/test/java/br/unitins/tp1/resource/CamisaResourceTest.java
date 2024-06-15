package br.unitins.tp1.resource;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.camisa.CamisaDTO;
import jakarta.ws.rs.core.MediaType;

public class CamisaResourceTest {
        @Test
        public void findAllTest() {
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .when()
                                .get("/camisas")
                                .then()
                                .statusCode(200);

        }

        @Test
        public void findByIdTest() {
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .when()
                                .get("/camisas/1")
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
                                .get("/camisas/search/nome/Camisa1")
                                .then()
                                .statusCode(200)
                                .body("nome", everyItem(is("Camisa1")));
        }

        @Test
        public void findByDescricaoTest() {
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .when()
                                .get("/camisas/search/descricao/CamisaComDragao")
                                .then()
                                .statusCode(200)
                                .body("descricao", everyItem(is("CamisaComDragao")));
        }

        @Test
        public void createTest() {
                CamisaDTO dto = new CamisaDTO(
                                "Camisa do Flamengooo",
                                "Camisa Principal do Flamengooo",
                                "Vermelho e Preto",
                                200,
                                55,
                                50,
                                50,
                                2,
                                2L,
                                2L,
                                4L,
                                List.of(2L));
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(dto)
                                .when()
                                .post("/camisas")
                                .then()
                                .statusCode(201)
                                .body("nome", is("Camisa do Flamengooo"))
                                .body("descricao", is("Camisa Principal do Flamengooo"))
                                .body("cor", is("Vermelho e Preto"));
        }

        @Test
        public void updateTest() {
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

                CamisaDTO dto = new CamisaDTO(

                                "Camisa do Real Madri",
                                "Camisa Principal do Real Madri",
                                "Branco",
                                200,
                                55,
                                50,
                                50,
                                3,
                                2L,
                                2L,
                                4L,
                                List.of(4L));

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(dto)
                                .when()
                                .pathParam("id", 1)
                                .put("/camisas/{id}")
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
                                .delete("/camisas/{id}")
                                .then()
                                .statusCode(204);
        }

}
