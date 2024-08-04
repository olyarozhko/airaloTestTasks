package restApi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import restApi.services.AccessToken;
import utils.ReadProperties;

import static utils.Constants.*;

public class BaseTestAPI extends ReadProperties {

    private AccessToken accessToken;
    protected ObjectMapper objectMapper;
    protected Response response;
    protected RequestSpecification reqSpec;
    JsonNode node;

    private static String clientId;
    private static String clientSecret;

    @BeforeClass
    public void setUp() {
        readPropFile();
        specifyProps();
        RestAssured.baseURI = BASE_URL;
        objectMapper = new ObjectMapper();
        reqSpec = RestAssured.given();
    }


    @BeforeMethod
    public void checkAndGetToken() {
        accessToken = new AccessToken();
        if (!accessToken.accessTokenExists() || !accessToken.isTokenValid()) {
            AccessToken.tokenGeneration(clientId, clientSecret);
        }

    }

    public void requestHeaders() {
        reqSpec.header(HEADER_ACCEPT, HEADER_ACCEPT_VALUE);
        reqSpec.header(HEADER_AUTHORIZATION, AccessToken.getAccessToken());

    }

    private void specifyProps(){
        clientId = props.getProperty("clientId");
        clientSecret = props.getProperty("clientSecret");
    }

}
