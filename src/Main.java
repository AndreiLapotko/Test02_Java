
public class Main {
    public static void main(String[] args) {
        String path = "input.txt";

        ItemsCounter itemsCounter = new ItemsCounter(path);

        itemsCounter.showItemsNumber();

        itemsCounter.showLongestWords();

        itemsCounter.showHashMap();

    }
}