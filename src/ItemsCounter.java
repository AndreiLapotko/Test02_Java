import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ItemsCounter {
    private final String path;
    Map<String, Integer> hashMap = new HashMap<>();


    public ItemsCounter(String path) {
        this.path = path;
    }

    private String[] getStringFromFile(String path) {
        StringBuilder resultSB = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().length() != 0) {
                    resultSB.append(line.trim()).append(" ");
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return resultSB.toString().replaceAll("\\s+", " ").split(" ");
    }

    public void showItemsNumber() {

        String[] arrWords = getStringFromFile(path);

        System.out.println("В данном наборе содержится " + arrWords.length + (arrWords.length % 10 < 5 ? " слова." : " слов."));
    }

    public void showLongestWords() {

        hashMap = getMap(getStringFromFile(path));
        int maxLength = 0;
        List<String> longestWords = new ArrayList<>();
        Set<String> items = hashMap.keySet();
        for (String item : items) {
            if (item.length() > maxLength) {
                maxLength = item.length();
            }
        }
        for (String item : items) {
            if (item.length() == maxLength) {
                longestWords.add(item);
            }
        }
        System.out.println("Самые длинные слова: " + Arrays.toString(longestWords.toArray()).replaceAll("[\\[\\]]", "") + ".");
    }

    private Map<String, Integer> getMap(String[] array) {
        for (String word : array) {
            if (hashMap.containsKey(word)) {
                hashMap.put(word, hashMap.get(word) + 1);
            } else {
                hashMap.put(word, 1);
            }
        }
        return hashMap;
    }

    public void showHashMap() {
        System.out.println("Частота слов:");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": в количестве: " + entry.getValue());
        }
    }
}
