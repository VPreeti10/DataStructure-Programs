//Find set of numbers from the array that add upto a sum (target).
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
	
	public ArrayList<ArrayList<Integer>> combinationSums(int[] candidates,int target){
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> current=new ArrayList<Integer>();
		if(candidates==null||candidates.length==0) {
			return result;
		}
		Arrays.sort(candidates);
		getCombinationSum(candidates,target,0,current,result);
		return result;
	}
	public void getCombinationSum(int[] candidates,int target,int start,ArrayList<Integer> current,ArrayList<ArrayList<Integer>> result) {
		if(target==0) {
			ArrayList<Integer> temp=new ArrayList<Integer>(current);
			result.add(temp);
			return;
		}
		for(int i=start;i<candidates.length && candidates[i]<=target;i++) {
			current.add(candidates[i]);
			getCombinationSum(candidates, target-candidates[i], i, current, result);
			current.remove(current.size()-1);
		}
	}
	public static void main(String[] args) {
		CombinationSum cs=new CombinationSum();
		int[] candidates= {2,3,4,7};
		ArrayList<ArrayList<Integer>> finalRes=cs.combinationSums(candidates, 7);
		for(ArrayList<Integer> al: finalRes) {
			for(Integer in:al) {
				System.out.print(in+"  ");
			}
			System.out.println();
		}
	}
}
