package restApi;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.Test;
import restApi.entities.ESim;

import java.util.List;

import static utils.Constants.ESIMS_URL;

public class TestESims extends BaseTestAPI {
    private List<ESim> eSimList;
    private String packageId = "merhaba-7days-1gb";
    private final int eSimNumber = 6;
    JsonNode simNode;

    @Test
    @SneakyThrows
    public void verifyESimsList() {

        requestHeaders();

        response = reqSpec.get(ESIMS_URL);
        response.then().assertThat().statusCode(200);

        node = objectMapper.readTree(response.getBody().asString());
        simNode = node.at("/data");

        eSimList = (List.of(objectMapper.treeToValue(simNode, ESim[].class)));

        Assert.assertNotNull(eSimList, "eSim list is blank");
        Assert.assertEquals(eSimList.size(), eSimNumber, "eSim number is wrong");
        Assert.assertEquals(eSimList.stream().filter(sim -> sim.getSimable() != null).count(), eSimNumber,
                "Not all sims contain simable information");


        Assert.assertEquals(eSimList.stream().filter(eSim -> eSim.getSimable() != null &&
                        eSim.getSimable().getPackageId().toLowerCase().contains(packageId)).count(), eSimNumber,
                "Not all sims contains correct package");

    }

}
