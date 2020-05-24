package bean;

import java.util.HashMap;
import java.util.Map;

public class Config {
    private static Config config = null;
    private Map<String, Map<Integer, String>> dict = new HashMap<>();
    public static int count = 0;


    public Map<String, Map<Integer, String>> getDict() {
        return dict;
    }

    public void setDict(Map<String, Map<Integer, String>> dict) {
        this.dict = dict;
    }

    public static Config getInstance() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }
}
