package inv;

import inv.api.ClientAPI;
import inv.dec.Client;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClientAPITest  extends BaseAPITest{


 private ClientAPI clientAPI = new ClientAPI();


    @Test
    @DisplayName("Can get all clients")
    void canGetAllClients(){
        Response getAllResponse = clientAPI.getALLClient();
        Assertions.assertEquals(200, getAllResponse.getStatusCode());
    }




    @Test
    @DisplayName("Can create client")
    void canCreateClient(){

        //Create Client dec
        Client client = new Client("VeloSport13", "Sofia",
                "Stara Planina", false, "Setefan Stefanov");
        Response createResponse = clientAPI.createClient(client);
        Assertions.assertEquals(200, createResponse.getStatusCode());
        Assertions.assertTrue(createResponse.getBody().asString().contains("Клиента е създаден успешно!"));
    }
}
