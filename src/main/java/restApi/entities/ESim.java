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
public class ESim {

    @JsonProperty("id")
    protected long id;
    @JsonProperty("iccid")
    protected long iccid;
    @JsonProperty("lpa")
    protected String lpa;
    @JsonProperty("is_roaming")
    protected boolean isRoaming;
    @JsonProperty("simable")
    protected ESimSimable simable;

}
