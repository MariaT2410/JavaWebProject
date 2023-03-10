package persistence;

import java.util.ArrayList;
import java.util.List;

public interface Store {
	public static <T> List<T> toList(T[] arr) {
        List<T> list = new ArrayList<T>();
        for (T elt : arr)
            list.add(elt);
        return list;
    }

}
