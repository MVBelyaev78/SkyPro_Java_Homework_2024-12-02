package pro.sky.JavaHomework.utilities;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Utilities {
    public static Set<Integer> transformStringToSetOfInteger(String ids) {
        return Arrays
                .stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}
