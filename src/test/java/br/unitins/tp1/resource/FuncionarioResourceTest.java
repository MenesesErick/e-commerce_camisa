package br.unitins.tp1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.endereco.EnderecoDTO;
import br.unitins.tp1.dto.funcionario.FuncionarioDTO;
import br.unitins.tp1.dto.telefone.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class FuncionarioResourceTest {
        @Test
        public void findAllTest() {
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .when()
                                .get("/funcionarios")
                                .then()
                                .statusCode(200);

        }

        @Test
        public void findByIdTest() {
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .when()
                                .get("/funcionarios/1")
                                .then()
                                .statusCode(200)
                                .body("id", is(1));
        }

        @Test
        public void findByCpfTest() {
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
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

                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

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

                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
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
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";


                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .when()
                                .pathParam("id", 2)
                                .delete("/funcionarios/{id}")
                                .then()
                                .statusCode(204);
        }
}
