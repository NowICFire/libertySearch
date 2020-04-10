package libertySearch.util;

import libertySearch.config.Configuration;
import libertySearch.pojo.Browser;
import libertySearch.pojo.Engine;

import java.util.Iterator;
import java.util.List;

public class Factory {
    private Configuration config;

    public Factory(Configuration config) {
        this.config = config;
    }

    public void loadParam(List<String> params) {
        Iterator<String> iterator = params.iterator();
        String browserName = null;
        String engineName = null;
        Boolean isPrivate = null;
        while (iterator.hasNext()) {
            String param = iterator.next();
            if (param.equals("/p")) {
                iterator.remove();
                isPrivate = true;
            }
            if (param.equals("/b")) {
                iterator.remove();
                browserName = iterator.next();
                if (config.browsers.containsKey(browserName)) {
                    iterator.remove();
                } else {
                    browserName = null;
                }
            }
            if (param.equals("/e")) {
                iterator.remove();
                engineName = iterator.next();
                if (config.engines.containsKey(engineName)) {
                    iterator.remove();
                } else {
                    engineName = null;
                }
            }
        }
        config.changeConfig(browserName, engineName, isPrivate);
    }

    public String getKeyword(List<String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String param : params) {
            stringBuilder.append(param).append("%20");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());
        }
        String keyword = stringBuilder.toString();
        keyword = keyword.replaceAll("#", "%23");
        return keyword;
    }

    public Browser getBrowser() {
        Browser browser = config.browsers.getJSONObject(config.browserName).toJavaObject(Browser.class);
        if (!config.isPrivate) {
            browser.setPrivateMode("");
        }
        return browser;
    }

    public Engine getEngine() {
        Engine engine = config.engines.getJSONObject(config.engineName).toJavaObject(Engine.class);
        return engine;
    }
}
