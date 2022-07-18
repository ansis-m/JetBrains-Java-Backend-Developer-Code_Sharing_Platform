// do not remove imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {
    public static <T> String info(T[] array) {
        StringBuilder result = new StringBuilder("[");
        for(int i = 0; i < array.length; i++) {
            if(i != 0)
                result.append(", ");
            result.append(array[i]);
        }
        result.append("]");
        return result.toString();
    }
}