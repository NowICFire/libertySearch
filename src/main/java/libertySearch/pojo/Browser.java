package libertySearch.pojo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Browser {
    private String name;
    private String privateMode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrivateMode() {
        return privateMode;
    }

    public void setPrivateMode(String privateMode) {
        this.privateMode = privateMode;
    }

    public void open(String url) {
        List<String> cmd = new ArrayList<>();
        cmd.add("cmd");
        cmd.add("/c");
        cmd.add("start");
        cmd.add(this.name);
        cmd.add("\"" + url + "\"");
        cmd.add(this.privateMode);
        try {
            Runtime.getRuntime().exec(String.join(" ",cmd));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
