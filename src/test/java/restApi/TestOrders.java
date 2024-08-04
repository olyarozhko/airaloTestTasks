package restApi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import restApi.entities.Order;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static utils.Constants.ORDER_URL;

public class TestOrders extends BaseTestAPI {

    protected String package_id = "merhaba-7days-1gb", type = "sim";
    protected int quantity = 6;
    JsonNode orderNode;
    Order orderNew, orderCreated;
    Map<String, Object> orderNewMap;

    @Test
    @SneakyThrows
    public void createNewOrderAndCheckResponse() {
        orderNew = new Order(quantity, package_id, type);

        orderNewMap = objectMapper.convertValue(orderNew, new TypeReference<Map<String, Object>>() {
        });

        requestHeaders();
        reqSpec.params(orderNewMap);

        response = reqSpec.post(ORDER_URL);
        response.then().assertThat().statusCode(200);

        //creating Node to specify path with properties corresponded to the Order Entity
        node = objectMapper.readTree(response.getBody().asString());
        orderNode = node.at("/data");

        orderCreated = objectMapper.treeToValue(orderNode, Order.class);

        Assert.assertEquals(orderCreated, orderNew);


    }

}
