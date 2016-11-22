package leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static java.lang.System.out;

/**
 * LeetCode problems
 * 127. Word Ladder 
 * 
 *  Given two words (beginWord and endWord), and a dictionary's word list, 
 *  find the length of shortest transformation sequence from beginWord to endWord, such that:
 *  Only one letter can be changed at a time
 *  Each intermediate word must exist in the word list
 *  
 * @author Warp Chen
 *
 */
public class WordLadder1 {

	public static void main(String[] args) {
		/*String beginWord = "hit";
		String endWord = "cog";
		Set<String> wordList =  new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"));*/
		
/*		String beginWord = "a";
		String endWord = "c";
		Set<String> wordList =  new HashSet<String>(Arrays.asList("a","b","c"));*/
		
		/*String beginWord = "talk";
		String endWord = "tail";
		Set<String> wordList =  new HashSet<String>(Arrays.asList("talk","tons","fall","tail","gale","hall","negs"));*/
		
		
		String beginWord = "hot";
		String endWord = "dog";
		Set<String> wordList =  new HashSet<String>(Arrays.asList("pot", "dot", "cog", "hot", "dog"));
				
		WordLadder1 wordLadder = new WordLadder1();
		wordLadder.ladderLength(beginWord, endWord, wordList);		
	}
	
	//FIXME  shortest transformation!!
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
	
		int vaildLength = beginWord.length();		
		char[] tempWord = beginWord.toCharArray();		
		char[] targetWord = endWord.toCharArray();
		
		out.println("beginWord:"+beginWord+"   endWord:"+endWord);
		out.println(wordList);
		wordList.removeIf(x -> x.equals(beginWord)||x.equals(endWord));
		out.println(wordList);
		
		List<String> changedHistory = new ArrayList<String>();
		changedHistory.add(beginWord);
		
		if (vaildLength == endWord.length()) {

			boolean hasChanged = false;
			boolean changedEnd = false;
			do {
				hasChanged = false;
				
				out.println("tempWord ==>"+new String(tempWord));
				for (int i = 0; i < tempWord.length; i++) {
					if (tempWord[i] != targetWord[i]) {
						char[] ttempWord = tempWord.clone();
						ttempWord[i] = targetWord[i];
						
						//can changed to endWord
						if (Arrays.equals(ttempWord, targetWord)){
							changedHistory.add(new String(targetWord));
							changedEnd = true;
							break;
						}
						break;
					}
				}
				
				if(!changedEnd){
				Iterator<String> it = wordList.iterator();
				while (it.hasNext() && !hasChanged) {
					
					String v = it.next();

					for (int i = 0; i < tempWord.length; i++) {
						if (tempWord[i] != targetWord[i]) {
							if (v.length() == vaildLength) {

									// Only one letter can be changed at a time
									char[] ttempWord = tempWord.clone();
									ttempWord[i] = v.toCharArray()[i];
									String tempStr = new String(ttempWord);

									if (v.equals(tempStr)) {
										tempWord[i] = v.toCharArray()[i];
										out.println("change to:" + tempStr);
										it.remove();
										changedHistory.add(tempStr);
										hasChanged = true;
										break;
									}
								
							}
						}
					}
					out.println("=======");

				}
				}
				out.println("hasChanged=>" + hasChanged + " size:" + wordList.size() + " each loop result:"
						+ new String(tempWord));
			} while (hasChanged && !changedEnd);

			
		}
		

		
		out.println("Changed History =>"+changedHistory);
		
		if(!changedHistory.contains(endWord)){
			changedHistory = new ArrayList<String>();
			out.println("Cannot transformation sequence");
		}
		
		return changedHistory.size();
    }
}
