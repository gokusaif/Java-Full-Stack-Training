package array2;

public class BubbleSort {
	
	static void bubbleSort(int ar[]) {
		
		for(int i=0;i<ar.length-1;i++) {
			for(int j=0;j<ar.length-1;j++) {
				if(ar[j]>ar[j+1]){
					int temp=ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=temp;
				}
			}
		}
		
		System.out.println("after bubble sort");
		for(int i=0;i<ar.length;i++) {
			System.out.print(ar[i] + "");
			System.out.print(" ");
		}
	}

}
