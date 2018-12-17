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
        Map<V, Set<K>> inversemap = new HashMap<V,Set<K>>();
        Collection<V> values = map.values();
        Set<K> keys = map.keySet();
        for (V v: values) {
          Set<K> set = new HashSet<>();
          for (K k : keys) {
              if (map.get(k).equals(v)) {
                  set.add(k);
              }
          }
          inversemap.put(v, set);
        }
        return inversemap;
	}
    
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
	  Map<V, K> inversemap = new HashMap<V, K>();
      Collection<V> values = map.values();
      Set<K> keys = map.keySet();
      for (V v: values) {
        for (K k : keys) {
            if (map.get(k).equals(v)) {
              inversemap.put(v, k);
            }
        }
      }
      return inversemap;
	}
	
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
	  Collection<V> values = f.values();
	  Collection<V> keys = g.keySet();
	  int count =0;
	  for (V v: values) {
	    if (!keys.contains(v)) {
	      count++;
	    }
	  }
        return count==0;
	}
	
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        assert (compatible (f,g)==true);
        Map<K, W> composedmap = new HashMap<K, W>();
        Set<K> keysf = f.keySet();
        Set<V> keysg = g.keySet();
        for (V v: keysg) {
          for (K k: keysf) {
            if (f.get(k).equals(v)) {
              composedmap.put(k, g.get(v));
            }
          }
        }
        return composedmap;
	}
}
