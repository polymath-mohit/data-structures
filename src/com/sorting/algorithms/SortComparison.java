package com.sorting.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SortComparison {

	public static void main(String[] args) {
	
		int[] sourceArray,sortedArray;
		long start,finish;
		int N=1000;
		int maxLimit = 100;//Integer.MAX_VALUE;
		sourceArray = generateRandomArrayOfLengthN(N,maxLimit);
		//System.out.println("Source Random Array - \n" + Arrays.toString(sourceArray));
		
		// Bubble Sort
		start = System.currentTimeMillis();
		sortedArray = sortBubble(sourceArray);
		finish = System.currentTimeMillis();
		//System.out.println("Bubble Output - \n" + Arrays.toString(sortedArray));
		System.out.println("Time taken in milliseconds to Bubble sort - " + (finish-start));

		// Insertion Sort
		start = System.currentTimeMillis();
		sortedArray = sortInsertion(sourceArray);
		finish = System.currentTimeMillis();
		//System.out.println("Insertion Output - \n" + Arrays.toString(sortedArray));
		System.out.println("Time taken in milliseconds to Insertion sort - " + (finish-start));

		// Selection Sort
		start = System.currentTimeMillis();
		sortedArray = sortSelection(sourceArray);
		finish = System.currentTimeMillis();
		//System.out.println("Selection Output - \n" + Arrays.toString(sortedArray));
		System.out.println("Time taken in milliseconds to Selection sort - " + (finish-start));

		// Merge Sort
		start = System.currentTimeMillis();
		sortMerge(sourceArray,0,sourceArray.length-1);
		finish = System.currentTimeMillis();
		System.out.println("Time taken in milliseconds to Merge sort - " + (finish-start));

		
	
	}

	private static int[] generateRandomArrayOfLengthN(int n, int maxLimit) {
		List<Integer> arrayList = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			arrayList.add(ThreadLocalRandom.current().nextInt(0, maxLimit));
		}
		return arrayList.stream().mapToInt(i->i).toArray();
	}

	private static int[]sortBubble(int[] sourceArray) {
		int temp;
		boolean sortCompleted = false;
		while (!sortCompleted) {
			sortCompleted = true;
			for (int i=0;i<sourceArray.length-1;i++) {
				if (sourceArray[i]>sourceArray[i+1]) {
					temp = sourceArray[i+1];
					sourceArray[i+1] = sourceArray[i];
					sourceArray[i]=temp;
					sortCompleted = false;
				}	
		}
		
		}
		
		return sourceArray;
	}
	
	private static int[]sortInsertion(int[] sourceArray) {
		
		for(int i =1;i<sourceArray.length;i++) {
			int pivot = sourceArray[i];
			int j;
			for (j = i-1;j>=0 && pivot < sourceArray[j] ; j--) {
				sourceArray[j+1] = sourceArray[j];
			}
			sourceArray[j+1]=pivot;
		}
		
		return sourceArray;
	}
	
private static int[]sortSelection(int[] sourceArray) {
		int temp=0;
		for (int i=0; i < sourceArray.length; i++) {
			int smallest = sourceArray[i];
			int save =i;
			for (int j = i+1 ; j<sourceArray.length;j++) {
				if (sourceArray[j]<smallest)
					{
					smallest = sourceArray[j];
					save = j;
					}
			}
			temp = sourceArray[i];
			sourceArray[i] = smallest;
			sourceArray[save] = temp;
		}
		
		return sourceArray;
	}

private static void sortMerge(int[] sourceArray, int left, int right) {
	// TODO Auto-generated method stub
	if (right<=left)
		return;
	int mid = left + right / 2; 
	sortMerge(sourceArray,left,mid);
	sortMerge(sourceArray,mid+1,right);
	merge(sourceArray,left,mid,right);
}

private static void merge(int[] array, int left, int mid, int right) {
	// TODO Auto-generated method stub
	int leftLength = mid-left+1;
	int rightLength = right-mid;
	
	int[] leftArray = new int[leftLength];
	int[] rightArray = new int[rightLength];
	
	for(int i=0;i<leftLength;i++) {
		leftArray[i] = array[left+i];
	}
	for(int i=0;i<rightLength;i++) {
		rightArray[i]= array[mid+1+i];
	}
	
	int leftIterator=0,rightIterator=0;
	
	for(int i = left; i < right+1 ; i++) {
		
		if(leftIterator<leftLength && rightIterator < rightLength) {
			if(leftArray[leftIterator] < rightArray[rightIterator]) 
				array[i] = leftArray[leftIterator++];
			else
				array[i] = rightArray[rightIterator++];
		}
		else if (leftIterator < leftLength)
		array[i] = leftArray[leftIterator++];
		else if (rightIterator < rightLength)
		array[i] = rightArray[rightIterator++];	
	}
	System.out.println("Merge Output - \n" + Arrays.toString(array));

}


}
