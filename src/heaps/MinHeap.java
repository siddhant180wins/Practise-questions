package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class MinHeap<E>{
	List<E> heap;

	public MinHeap(){
		this.heap = new ArrayList<E>();
	}
	public List<E> getHeap() {
		return heap;
	}

	public void setHeap(List<E> input) {
		this.heap = input;
	}
	
	public void insert(E data){
		buildMinHeap(Arrays.asList(data));
	}
	private int getParent(int index){
		if(index %2 ==0){
			return (index-1)/2;
		}
		return index/2;
	}
	
	public abstract <E> int compare(E ob1,E ob2);
	
	/*
	 * Compare left and right childs, and swap the min with parent if min < parent.
	 */
	public void buildMinHeap(List<E> arr){
		heap.addAll(arr);
		int len = heap.size();
		for(int i = (len-1)/2;i>=0;i--){
			minHeapify(i);
		}
	}
	private void minHeapify(int index){
		//System.out.println(heap);
		int len = heap.size();
		if(index<len){
			int left = left(index);
			int right = right(index);
			int min = index;
			if(left < len && compare(heap.get(index),heap.get(left))==1){
				min = left;
			}
			if(right < len &&  compare(heap.get(min),heap.get(right))==1){
				min = right;
			}
			if(min!=index){
				Collections.swap(heap, index, min);
				minHeapify(min);
			}
		}
		
	}
	private int left(int i){
		return 2*i+1;
	}
	private int right(int i){
		return 2*i+2;
	}
		
	
	/*TODO://
	 * HeapSort using min heap
	 */
	public List<E> heapSort(List<E> list){
		buildMinHeap(list);
		//System.out.println(heap);
		//min at 0;
		List<E> temp = heap;
		List<E> rlist = new ArrayList<E>();
		int l = heap.size();
		for(int i =(l-1); l>=2;l--){
		//	System.out.println(heap);
			rlist.add(heap.get(0));
			heap = heap.subList(1, l);
			minHeapify(0);
			//System.out.println("___________________");
		}
		heap = temp;
		return rlist;
	}
	
	public void printHeap(){
		System.out.println(heap);
		char sp = '-';
		int n = heap.size();
		int h = (int)n/2-1;
		System.out.println("height:"+h);
		int node=0;
		int total = (int)Math.pow(2,h);
		for(int i=1;i<=h;i++){
			int spaces = (int)Math.ceil((double)total/(2*i));
			int tempspace = spaces;
			for(int k=node;k<node+(int)Math.pow(2, i-1);k++){
				spaces = tempspace;
				for(int j=0;j<spaces;j++){
					System.out.print(sp);
				}
				if(k<heap.size()){
					System.out.print(heap.get(k));
				}
				else{
					System.out.print('x');
				}
				if(k%2==0) spaces = spaces/2; 
				for(int j=0;j<spaces-2;j++){
					System.out.print(sp);
				}
			
			}
			node = (int)Math.pow(2,i-1);
			System.out.print('\n');
		}
	}
}
