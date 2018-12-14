package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class MapUtil {
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
        int numberofkeys = map.size();
        int numberofvalues= new HashSet<>(map.values()).size();
        return numberofkeys <= numberofvalues;
    }
    public static <K, V> 
           boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
      Collection<K> key = map.keySet();  
      for (K k1: key) {
        if (range.contains(map.get(k1))) {
          range.remove(map.get(k1));
        }
      }
        return range.isEmpty();
    }
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        // TODO: implement, see exercise P-5.3
        return null;
	}
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        // TODO: implement, see exercise P-5.3
        return null;
	}
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.4
        return false;
	}
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.5
        return null;
	}
}
