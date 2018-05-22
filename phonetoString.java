//Find combinations of characters for a phone number. Each number is mapped to set of characters

import java.util.HashMap;

public class phonetoString
{
	public static void printStrings(String phnno,int i,HashMap<Character,String> hash,StringBuilder result) {
		
		if(i==phnno.length()) {
			System.out.println(result);
			return;
		}
		String s=hash.get(phnno.charAt(i));
		for(int j=0;j<s.length();j++) {
			result.append(s.charAt(j));
			printStrings(phnno,i+1,hash,result);
			result.deleteCharAt(result.length()-1);
		}
	
	}
	public static void main(String[] args) {
		
		HashMap<Character,String> hash=new HashMap<Character,String>();
		hash.put('1', "1");
		hash.put('0', "0");
		hash.put('2', "ABC");
		hash.put('3', "DEF");
		StringBuilder res=new StringBuilder();
		printStrings("23", 0,hash,res);
	}
}

