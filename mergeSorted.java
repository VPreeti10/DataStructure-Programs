
public class mergeSorted {
	
	public static int[] merge(int[] arr,int l,int m,int r) {
		
		int len1=m-l+1;
		int len2=r-m;
		
		int[] arr1=new int[len1];
		int[] arr2=new int[len2];
		
		for(int i=0;i<len1;i++) {
			arr1[i]=arr[i+l];
		}
		for(int i=0;i<=len2;i++) {
			arr2[i]=arr[m+1+i];
		}
		int[] arr3 = new int[arr1.length+arr2.length];
		
		int i=0,j=0,k=0;
		while(i<arr1.length &&j<arr2.length) {
			if(arr1[i]<arr2[j]) {
				arr3[k]=arr1[i];
				i++;
			}
			else {
				arr3[k]=arr2[j];
				j++;
			}
			k++;
		}
		while(i<arr1.length) {
			arr3[k]=arr1[i];
			i++;
			k++;
		}
		while(j<arr2.length) {
			arr3[k]=arr2[j];
			j++;
			k++;
		}
		System.out.println();
		for(int y: arr3) {
			System.out.print(y+"  ");
		}
		return arr3;
		
	}
	public static void mergeSort(int[] array,int l,int r) {
		if(l<r) {
			int mid=(l+r)/2;
			mergeSort(array,l,mid);
			mergeSort(array, mid+1, r);			
			merge(array,l,mid,r);
		}
	}
	public static void main(String[] args) {
		int[] array1= {1,12,23,44,11,26,37,49};
		mergeSort(array1, 0, array1.length-1);
	}
}