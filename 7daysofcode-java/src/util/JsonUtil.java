package util;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    // Modificado pois regex não suporta aspas duplas (") e colchetes ({ e })
    public static List<String> getObjectList(String json, String key) {
        List<String> resultList = new ArrayList<>();
        String searchKey = "\"" + key + "\":\"";
        int index = 0;

        while ((index = json.indexOf(searchKey, index)) != -1) {
            index += searchKey.length();
            int endIndex = json.indexOf("\"", index);
            if (endIndex != -1) {
                String value = json.substring(index, endIndex);
                resultList.add(value);
                index = endIndex + 1;
            } else {
                break;
            }
        }

        return resultList;
    }

}

/*

public static List<String> getObjectList(String json, String key) {
    String[] list = json.split("\"" + key + "\":\"");
    List<String> processedList = new ArrayList<>();
    for (int i = 1; i < list.length; i++) {
        String nome = list[i].split("\"")[0];
        processedList.add(nome);
    }
    return processedList;
}

*/
