package inv;

import inv.api.ClientAPI;
import inv.dec.Client;
import inv.dec.SuccessMessageResponse;
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
        Client client = new Client("VeloSport133", "Sofia",
                "Stara Planina", false, "Setefan Stefanov");
        Response createResponse = clientAPI.createClient(client);
        Assertions.assertEquals(200, createResponse.getStatusCode());
        Assertions.assertTrue(createResponse.getBody().asString().contains("Клиента е създаден успешно!"));
        //Deserialize the success response into success object
        SuccessMessageResponse successMessageResponse = GSON.fromJson(createResponse.body().asString(), SuccessMessageResponse.class);
    }


    @Test
    @DisplayName("Can get existing client")
    void canGetExistingClient(){
        Response response = clientAPI.getClient(9);
        Assertions.assertEquals(200,response.getStatusCode());
    }



    @Test
    @DisplayName("Can update client")
    void canUpdateClient(){

        // Update the client
        Client client = new Client("VeloSport13", "Sofia",
                "Stara Planina", false, "Setefan Stefanov");

         // Change the client name in dec
        client.setFirm_name("SportVelo");
        Response updateResponse = clientAPI.updateClient(55, client);
        Assertions.assertEquals(200, updateResponse.getStatusCode());
    }

    @Test
    @DisplayName("Can delete existing client")
    void canDeleteExistingClient(){
        Response response = clientAPI.deleteClient(55);
        Assertions.assertEquals(200, response.getStatusCode());
        SuccessMessageResponse successMessageResponse =
                GSON.fromJson(response.body().asString(), SuccessMessageResponse.class);
    }
}
