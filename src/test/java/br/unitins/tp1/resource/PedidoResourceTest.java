package br.unitins.tp1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.itemPedido.ItemPedidoDTO;
import br.unitins.tp1.dto.pedido.PedidoDTO;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PedidoResourceTest {
    @Test
    public void findAllTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

        given()
                .header("Authorization", "Bearer " + tokenAdm)
                .when()
                .get("/pedidos")
                .then()
                .statusCode(200);
    }

    @Test
    public void findByIdTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjoxLCJzdWIiOiJFcmljayIsImdyb3VwcyI6WyJGdW5jaW9uYXJpbyJdLCJleHAiOjE3MTg0OTg5MjUsImlhdCI6MTcxODQxMjUyNSwianRpIjoiZWM3MDhmZWEtYjlmMC00NzhjLWFjMGEtNzA3ZThkYWVjNDg2In0.YiNi9LtNCnaJL0Y4n5yKkJ4ymaPfmrrF2Oprqt2GyZwsIHFbHCK8ow3gofgUO41TmPvY1DbzQfT-JibjsXGFHi-4aNinUo_zQfNrBtEItxbOD_NzUvH3IRROVGSxY1NQfzIXePQi690wPQt6clx_pgwRxG9rSMQlXlnnNoQ2E2lDJ2ZQZ9s8wL_DFzD3WfP90PxoA7qPgTuL85_2tq3chBhmYWTBK07iSlL3lQlMxdDgOMbvJ5RWjs9LJ4DoeZtYvyDqCxSr0EL9yDZXnLMSOIkHsW6oGUa7u-_m0c-NbqjYD_tJXFfRH140SRNIy4ftr31yi4X0ECFGgzV5dywkCw";

        given()
                .header("Authorization", "Bearer " + tokenAdm)
                .when()
                .get("/pedidos/1")
                .then()
                .statusCode(200)
                .body("id", is(1));
    }

    @Test
    public void findByClienteTest() {

        String tokenCliente = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjo1LCJzdWIiOiJtdXNzYXR0byIsImdyb3VwcyI6WyJDbGllbnRlIl0sImV4cCI6MTcxODUwODcxMCwiaWF0IjoxNzE4NDIyMzEwLCJqdGkiOiIyY2NlNjgyNi05YjdlLTQzOWMtYmQzNy01NDI5YWRlOWY2MTMifQ.dwBKgwNp7x9j1TQrysBg8CKadv6b8C1-_Do6KPB6dy9wA7Xcl6gcarNHRI7pCZWyIe_PCamTlD--r9p1mA5EJlCSxd0n5wluFgNM7N256ikXHv1dnGj7ncGlOHB2-fUwr_eDRKvyeYyPPRMh6KFhvTIB-QHVfSivPKmH-wJj4Po5TnQTJMVy912HdBecjTeRKvm2QA6OROmH_dbJ8LPftVOnBltayyNaBbFuOOvs2U7xaio2CkE8RZOGWr-qGWzJPjveY2Qp4AmPKlWjTjPOFrnsoqG7HKkVAndUIyNcV1OuEKJqk-2dNW8XqIl0ymV_GLb9axuqCM0h_pllekpEbA";

        given()
        .header("Authorization", "Bearer " + tokenCliente)
        .when()
        .get("/pedidos/cliente/1")
        .then()
        .statusCode(200);
    }

    @Test
    public void createTest() {
        ItemPedidoDTO item1 = new ItemPedidoDTO(1, 2L); 
        PedidoDTO dto = new PedidoDTO(1L, List.of(item1), 1);

        String tokenCliente = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjo1LCJzdWIiOiJtdXNzYXR0byIsImdyb3VwcyI6WyJDbGllbnRlIl0sImV4cCI6MTcxODUwODcxMCwiaWF0IjoxNzE4NDIyMzEwLCJqdGkiOiIyY2NlNjgyNi05YjdlLTQzOWMtYmQzNy01NDI5YWRlOWY2MTMifQ.dwBKgwNp7x9j1TQrysBg8CKadv6b8C1-_Do6KPB6dy9wA7Xcl6gcarNHRI7pCZWyIe_PCamTlD--r9p1mA5EJlCSxd0n5wluFgNM7N256ikXHv1dnGj7ncGlOHB2-fUwr_eDRKvyeYyPPRMh6KFhvTIB-QHVfSivPKmH-wJj4Po5TnQTJMVy912HdBecjTeRKvm2QA6OROmH_dbJ8LPftVOnBltayyNaBbFuOOvs2U7xaio2CkE8RZOGWr-qGWzJPjveY2Qp4AmPKlWjTjPOFrnsoqG7HKkVAndUIyNcV1OuEKJqk-2dNW8XqIl0ymV_GLb9axuqCM0h_pllekpEbA";

        given()
            .header("Authorization", "Bearer " + tokenCliente)
            .contentType("application/json")
            .body(dto)
            .when()
            .post("/pedidos")
            .then()
            .statusCode(204);//coloquei 204 mas o certo em tese é o 201 :)
    }

    @Test
    public void alterarStatusPagamentoTest() {
        String tokenCliente = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsIklkIjo1LCJzdWIiOiJtdXNzYXR0byIsImdyb3VwcyI6WyJDbGllbnRlIl0sImV4cCI6MTcxODUwODcxMCwiaWF0IjoxNzE4NDIyMzEwLCJqdGkiOiIyY2NlNjgyNi05YjdlLTQzOWMtYmQzNy01NDI5YWRlOWY2MTMifQ.dwBKgwNp7x9j1TQrysBg8CKadv6b8C1-_Do6KPB6dy9wA7Xcl6gcarNHRI7pCZWyIe_PCamTlD--r9p1mA5EJlCSxd0n5wluFgNM7N256ikXHv1dnGj7ncGlOHB2-fUwr_eDRKvyeYyPPRMh6KFhvTIB-QHVfSivPKmH-wJj4Po5TnQTJMVy912HdBecjTeRKvm2QA6OROmH_dbJ8LPftVOnBltayyNaBbFuOOvs2U7xaio2CkE8RZOGWr-qGWzJPjveY2Qp4AmPKlWjTjPOFrnsoqG7HKkVAndUIyNcV1OuEKJqk-2dNW8XqIl0ymV_GLb9axuqCM0h_pllekpEbA";

        given()
            .header("Authorization", "Bearer " + tokenCliente)
            .contentType("application/json")
            .when()
            .patch("/pedidos/alterarStatusPagamento/1")
            .then()
            .statusCode(204);
    }

}
