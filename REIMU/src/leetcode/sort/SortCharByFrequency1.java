package leetcode.sort;

import static java.lang.System.out;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * LeetCode problems
 * 451. Sort Characters By Frequency 
 * use list
 * @author Warp Chen
 *
 */
public class SortCharByFrequency1 {

	public static void main(String[] args) {		
		SortCharByFrequency1 ans = new SortCharByFrequency1();
		
		String testStr = "Aabb";
		out.println(ans.frequencySort(testStr));		

	}
	
	public String frequencySort(String testStr) {
		StringBuffer result = new StringBuffer("");
		
		ArrayList<Entry<String,Integer>> charCounterList = new ArrayList<Entry<String,Integer>>();
		
		char[] dst = new char[testStr.length()] ;
		
		testStr.getChars(0, testStr.length(), dst, 0);
		
		for(char ch:dst){
			String targetChar = new String(new char[]{ch});
			
			boolean testKeyExist = false;
			for(Entry<String,Integer> si:charCounterList){				
				if(si.getKey().equals(targetChar)){
					testKeyExist = true;
					si.setValue(si.getValue()+1);
				}
			}
			
			if(!testKeyExist){
				charCounterList.add(new AbstractMap.SimpleEntry<String,Integer>(targetChar,1));
			}
		}
		
		
		Collections.sort(charCounterList,  new Comparator<Map.Entry<String, Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				int retVal = 0;
				
				if (o1.getValue()>o2.getValue()){
					retVal = -1;
				}else if(o1.getValue()<o2.getValue()){
					retVal = 1;
				}else{
					//retVal = o1.getKey().compareTo(o2.getKey());
				}
				return retVal;
			}		
			
		});
		
		for(Entry<String, Integer> entryObj:charCounterList){			
			for(int i=0;i<entryObj.getValue();i++){
				result.append(entryObj.getKey());
			}
		}
		
		return result.toString();
    }
	

}
