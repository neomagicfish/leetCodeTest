package leetcode.sort;

import static java.lang.System.out;
import static java.util.Collections.reverseOrder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * LeetCode problems
 * 451. Sort Characters By Frequency 
 * use list with stream
 * @author Warp Chen
 *
 */
public class SortCharByFrequency2 {

	public static void main(String[] args) {		
		SortCharByFrequency2 ans = new SortCharByFrequency2();
		
		String testStr = "tree";
		out.println(ans.frequencySort(testStr));		

	}
	
	public String frequencySort(String testStr) {
		StringBuffer result = new StringBuffer("");
	
		List<String> targetList = Arrays.asList(testStr.split(""));
	
	    Map bb = targetList.stream()
		    	.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	    
	    TreeMap<String,Long> charCounterMap = new TreeMap(bb);

		out.println("result "+charCounterMap);
		
		
		charCounterMap.entrySet().stream()
			.sorted(reverseOrder(Entry.comparingByValue()))
			.forEach(vv -> {
				for(int i=0;i<vv.getValue();i++){
					result.append(vv.getKey());
				}
			} );
			//.collect(Collectors.toCollection(result.append(this));
		
		
		
		return result.toString();
    }

}
