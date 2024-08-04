package ui.windowsDialogsAlerts;


import lombok.Data;

import java.util.Objects;

@Data
public class EsimDetails {
    private String coverage;
    private String data;
    private String validity;
    private String price;

    public EsimDetails(String coverage, String data, String validity, String price) {
        this.coverage = coverage;
        this.data = data;
        this.validity = validity;
        this.price = price;
    }

    /**
     * Modifying string - changing Case to the Lower and removing whitespaces. It helps to compare Strings.
     */
    private String optimizeString(String text) {
        return text.toLowerCase().replaceAll("\\s+", "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EsimDetails that = (EsimDetails) o;
        return Objects.equals(optimizeString(coverage), optimizeString(that.coverage)) &&
                Objects.equals(optimizeString(data), optimizeString(that.data)) &&
                Objects.equals(optimizeString(validity), optimizeString(that.validity)) &&
                Objects.equals(optimizeString(price), optimizeString(that.price));
    }

    @Override
    public int hashCode() {
        return Objects.hash(coverage, data, validity, price);
    }
}
