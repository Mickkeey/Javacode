package base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationException {

		public static class error {
		    public static void main(String args[]) {
		        List<String> list = new ArrayList<>();
		        list.add("a");
		        list.add("b");
		        list.add("c");
		        list.add("d");

		        
//		        Error Code
//		        for (String elem : list) {
//		            if (elem.equals("a")) {
//		                list.remove(elem);
//		            }
//		        }
		        
//		        Traditional for loop not using iterator
//		        for (int i = 0; i < list.size(); i++) {
//		            if (list.get(i).equals("a")) {
//		                list.remove(list.get(i));
//		            }
//		        }
//
//		        System.out.println(list);
		        
//		        
		        // using Iterator
		        
//		        Iterator<String> iterator = list.iterator();
//		        while (iterator.hasNext()) {
//		            String elem = iterator.next();
//		            if (elem.equals("a")) {
//		                iterator.remove();
//				        System.out.println(list);
//		            }
//		        }
		        
		        // using collection 
		        
		        list.removeIf(elem -> elem.equals("a"));
		        System.out.println(list);
   
		    }
		}
	}
