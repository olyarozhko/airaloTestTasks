package utils;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {
    protected Properties props;
    protected FileInputStream fileInputStream;

    @SneakyThrows
    public void readPropFile() {
        props = new Properties();
        fileInputStream = new FileInputStream("config/config.properties");
        props.load(fileInputStream);

    }
}
