import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Etl {
    public Map<String, Integer> transform(Map<Integer, List<String>> data) {
        Map<String, Integer> result = new HashMap<String, Integer>();
        for (Map.Entry<Integer, List<String>> score : data.entrySet()) {
            for (String letter : score.getValue()) {
                result.put(letter.toLowerCase(), score.getKey());
            }
        }
        return result;
    }
}