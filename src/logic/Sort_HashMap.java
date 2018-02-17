package logic;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class Sort_HashMap {

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue( Map<K, V> map ){
		
	      Map<K,V> result = new LinkedHashMap<>();
	      
	      Stream<Entry<K,V>> st = map.entrySet().stream();

	      st.sorted(Comparator.comparing(e -> e.getValue())).forEach(e ->result.put(e.getKey(),e.getValue()));

	      return result;
	}
	
	public static float calculate100(float total, float remain) throws Exception{
		
		try{
			float ans = ((100*remain) / total);
			return ans;
			
		}
		catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
	}
	
	
	public static float calculateAvg(float[] total) throws Exception{
		
		try{
			
			float temp = 0L; 
			
			for (float f : total) {
				temp = temp + f;
			}
			
			return (temp / total.length);
			
		}
		catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
	}
	
	public static float calculateToValue(float total, float remians) throws Exception{
		
		try{
			
			return (remians*total) / 100;
			
		}
		catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
	}
}
