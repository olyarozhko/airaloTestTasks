package utils;

public class Constants {
    public static final String BASE_URL = "https://sandbox-partners-api.airalo.com/v2";
    public static final String TOKEN_TYPE = "Bearer";
    public static final String TOKEN_URL = "/token";
    public static final String ORDER_URL = "/orders";
    public static final String ESIMS_URL = "/sims";

    public static final String CLIENT_ID = "client_id";
    public static final String CLIENT_SECRET = "client_secret";
    public static final String GRANT_TYPE = "grant_type";
    public static final String GRANT_TYPE_VALUE = "client_credentials";

    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_ACCEPT_VALUE = "application/json";
    public static final String HEADER_AUTHORIZATION = "Authorization";

    public static final String TOKEN_JSON_PATH = "data.access_token";
    public static final String EXP_IN_JSON_PATH = "data.expires_in";


}
