package restApi.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static utils.Constants.*;

public class AccessToken {
    private static String accessToken;
    public static long expiresIn;
    public static long tokenCreationTime;
    public long currentTime;


    public static void tokenGeneration(String clientId, String clientSecret) {

        RestAssured.baseURI = BASE_URL;
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.param(CLIENT_ID, clientId);
        requestSpecification.param(CLIENT_SECRET, clientSecret);
        requestSpecification.param(GRANT_TYPE, GRANT_TYPE_VALUE);

        Response response = requestSpecification.post(TOKEN_URL);
        response.then().assertThat().statusCode(200);

        accessToken = TOKEN_TYPE + " " + response.jsonPath().getString(TOKEN_JSON_PATH);
        expiresIn = Long.parseLong(response.jsonPath().getString(EXP_IN_JSON_PATH)) * 1000;
        tokenCreationTime = System.currentTimeMillis();
    }

    public boolean isTokenValid() {
        currentTime = System.currentTimeMillis();
        return currentTime - tokenCreationTime < expiresIn;
    }

    public boolean accessTokenExists() {
        return !(accessToken == null);
    }

    public static String getAccessToken() {
        return accessToken;
    }
}
