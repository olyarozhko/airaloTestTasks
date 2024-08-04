package restApi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ESimSimable {

    @JsonProperty("id")
    protected long id;
    @JsonProperty("package_id")
    protected String packageId;
    @JsonProperty("quantity")
    protected int quantity;
    @JsonProperty("validity")
    protected int validity;
    @JsonProperty("price")
    protected double price;
    @JsonProperty("data")
    protected String data;
    @JsonProperty("currency")
    protected String currency;

}
