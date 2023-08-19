package app.advertising_board.utils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static String getRandomItemFromArray(List<String> values){
        int index = getRandomInt(0, values.size() - 1);
        return values.get(index);
    }

    private static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
