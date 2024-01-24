package bomteng.logic.ch1;

import java.util.Arrays;

public class ch1 {

	public static void main(String[] args) {
		// ch1-1 例題1
		int[] arr1 = {3,6,9,-8,1};
		
		int sum = 0;
		for (int i=0; i<arr1.length; i++){
			sum += arr1[i];
		}
		System.out.println("sum:" + sum);
		
		// ch1-1 例題2 選擇排序法
		ch1_1_2();
		
		// ch1-1 例題3 三角形例題
	}
	
	private static void ch1_1_2(){
		int[] arr = {3,6,9,-8,1};
		
		// 從尚未排序的數值之中，找出第i小的數值
		for (int i=0; i<arr.length;i++) {
			
			int min_index = i;
			int tmp = i;
			for (int j=i+1; j<arr.length; j++) {
				//比較數值
				if (arr[j]<arr[min_index]) {
					min_index = j;
				}
			}
			tmp = arr[i];
			arr[i] = arr[min_index];
			arr[min_index] = tmp;
		}
		
		System.out.println("重新排序後:");
		Arrays.stream(arr).forEach(element -> System.out.print(element + ", "));
		
		System.out.println();
		System.out.print("第二種 重新排序後:");
		//第二種打印
		for (int element : arr) {
			System.out.print(element + ",");
		}
	}
	

}
