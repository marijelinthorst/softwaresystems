package ss.week4;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
  
  
    public static <E extends Comparable<E>>
           void mergesort(List<E> list) {
      if (list.size()<=1) {
      } else {
        int half = list.size()/2;
        List<E> firsthalf = new ArrayList<E>(list.subList(0, half));
        List<E> secondhalf = new ArrayList<E>(list.subList(half, list.size()));
        mergesort(firsthalf);
        mergesort(secondhalf);
        list.clear();
        list.addAll(merge(firsthalf, secondhalf)); 
      }
      
    }
   
    public static <E extends Comparable<E>>
      List<E> merge (List<E> firsthalf, List<E> secondhalf) {
      List<E> temp= new ArrayList<E>(firsthalf.size()+secondhalf.size());
      
      while (firsthalf.size()>0 && secondhalf.size()>0) {
        if (firsthalf.get(0).compareTo(secondhalf.get(0))<0) {
          temp.add(firsthalf.get(0));
          firsthalf.remove(0);
        } else {
          temp.add(secondhalf.get(0));
          secondhalf.remove(0);
        }
      }
      
      while (firsthalf.size()>0) {
        temp.add(firsthalf.get(0));
        firsthalf.remove(0);
      }
      
      while (secondhalf.size()>0) {
        temp.add(secondhalf.get(0));
        secondhalf.remove(0);
      }
      return temp;
    
    }
}

