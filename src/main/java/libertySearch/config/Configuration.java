package libertySearch.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Configuration {


    public String browserName;
    public String engineName;
    public Boolean isPrivate;
    public JSONObject browsers;
    public JSONObject engines;

    public Configuration() {
        this.loadConfig();
    }


    private void loadConfig() {
        FileInputStream inputStream= null;
        try {
            inputStream = new FileInputStream("conf/config.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert inputStream != null;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        JSONReader jsonReader = new JSONReader(inputStreamReader);
        String jsonStr = jsonReader.readString();


        JSONObject config = JSONObject.parseObject(jsonStr);
        JSONObject defaultOption = config.getJSONObject("option");
        browsers = config.getJSONObject("browsers");
        engines = config.getJSONObject("engines");


        browserName = defaultOption.getString("/b");
        engineName = defaultOption.getString("/e");
        isPrivate = defaultOption.getBoolean("/p");
    }

    public void changeConfig(String b, String e, Boolean p) {
        if (b != null) this.browserName = b;
        if (e != null) this.engineName = e;
        if (p != null) this.isPrivate = p;
    }
}
