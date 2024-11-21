package util;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    public static List<String> getObectList(String json, String key) {
        String[] list = json.split("\"" + key + "\":\"");
        List<String> processedList = new ArrayList<>();
        for (int i = 1; i < list.length; i++) {
            String nome = list[i].split("\"")[0];
            processedList.add(nome);
        }
        return processedList;
    }
}
