import java.util.ArrayList;
import java.util.List;

public class NoFromString {
	
	public int sumofNos(String str) {
		char[] arr=str.toCharArray();
		List<Integer> list=new ArrayList<Integer>();
	//	StringBuilder sb=new StringBuilder();
		String sb="";
		boolean flag=false;
		for(int i=0;i<arr.length;i++) {
			if(Character.isDigit(arr[i])) {
				flag=true;
			}
			else {
				flag=false;
				if(sb.length()!=0) {
					list.add(Integer.parseInt(sb));
					sb="";
				}
			}
			if(flag) {
				sb=sb+arr[i];
			}
		}
		int tot=0;
		for(int i:list) {
			tot+=i;
		}
		
		return tot;
	}
	public boolean hasSequence(String st,String subSeq) {
		int len=subSeq.length();
		int countOccurence=0;
		boolean flag=true;
		char a=subSeq.charAt(0);
		char[] arr=st.toCharArray();
		for(int y=0;y<arr.length;y++) {
			if(arr[y]==a) {
				if(arr.length==1) {
					countOccurence++;
					break;
				}
					
				for(int i=1;i<len;i++) {
					if(!(arr[y+i]==subSeq.charAt(i))) {
						flag=false;
						break;
					}
					else
						continue;
				}
				countOccurence++;
			}
			else
				continue;
		}
		if(countOccurence==0) {
			flag=false;
		}
		
	return flag;
	}
	public List<String> subString(String main,String[] check){
		List<String> ans=new ArrayList<String>();
		for(String s:check) {
			boolean res=hasSequence(main,s);
			if(res) {
				ans.add("True");
			}
			else {
				ans.add("False");
			}				
		}
		return ans;
	}
	
	public static void main(String[] args) {
		NoFromString nos=new NoFromString();
		//int res=nos.sumofNos("ABC123KIBJUI45S100wer");
		String[] check= {"Love","Flower","India","Check","Always"};
		List<String> r=nos.subString("ILoveIndiaAlways!!", check);
	}
}
