package libertySearch.service;

import libertySearch.config.Configuration;
import libertySearch.pojo.Browser;
import libertySearch.pojo.Engine;
import libertySearch.util.Factory;

import java.util.ArrayList;
import java.util.Arrays;

public class LibertySearch {
    public static void main(String[] args) {
        ArrayList<String> params=new ArrayList<>(Arrays.asList(args));
        Configuration config=new Configuration();
        Factory factory=new Factory(config);
        factory.loadParam(params);
        String keyword=factory.getKeyword(params);
        Browser browser=factory.getBrowser();
        Engine engine=factory.getEngine();
        browser.open(engine.readKeyword(keyword));
    }
}
