package bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Config implements Serializable {
    public final static String filePath ="file.txt";
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

    public static void setConfig(Config config) {
        if(config!=null)
        Config.config = config;
    }
}
