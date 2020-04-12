package xyz.startcode.libertySearch.service;

import xyz.startcode.libertySearch.config.Configuration;
import xyz.startcode.libertySearch.pojo.Browser;
import xyz.startcode.libertySearch.pojo.Engine;
import xyz.startcode.libertySearch.util.Factory;

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
