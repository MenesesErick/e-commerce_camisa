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
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .when()
                                .get("/clientes")
                                .then()
                                .statusCode(200);

        }

        @Test
        public void findByIdTest() {
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

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
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

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

                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

                given()
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
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

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
                String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

                given()
                                .header("Authorization", "Bearer " + tokenAdm)
                                .when()
                                .pathParam("id", 2)
                                .delete("/clientes/{id}")
                                .then()
                                .statusCode(204);
        }
}
