package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import heaps.MinHeap;



class MinHeapExt extends MinHeap<Integer>{
	@SuppressWarnings("hiding")
	@Override
	public <Integer> int compare(Integer ob1, Integer ob2) {
		if((int)ob1 == (int)ob2) return 0;
		else if( (int) ob1> (int)ob2) return 1;
		return -1;
	}
}
public class BinaryTree <E> {
	Node<E> root;
	
	BinaryTree(){
		this.root = new Node<E>();
		this.root.setData(null);
		this.root.setRight(null);
		this.root.setLeft(null);
	}
	BinaryTree(E data){
		this.root = new Node<E>();
		this.root.setData(data);
		this.root.setRight(null);
		this.root.setLeft(null);
	}
	public Node<E> addNode(E data){
		Node<E> node = new Node<E>();
		node.setData(data);
		node.setRight(null);
		node.setRight(null);
		return node;
	}
	public Node<E> getRoot(){
		return this.root;
	}
	
	/*
	 * A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible. 
	 */
	public Node<E> buildCompleteBinaryTree(List<E> arr){
		int len = arr.size();
		
		if(!arr.isEmpty()){
			int leftIndex = 1;
			int rightIndex =2;
			root = addNode(arr.get(0));	
			root.setLeft(buildBinaryTreeNodes(arr,root,leftIndex));
			root.setRight(buildBinaryTreeNodes(arr,root,rightIndex));
			return root;
		}
		return null;
	}
	private Node<E> buildBinaryTreeNodes(List<E> arr, Node<E> node,int index){
		int len = arr.size();
		if(node!=null && len>index){
			int left = (int)Math.pow(2,index)+1;
			int right = (int)Math.pow(2,index)+2;
			node = addNode(arr.get(index));
			node.setLeft(buildBinaryTreeNodes(arr,node,left));
			node.setRight(buildBinaryTreeNodes(arr,node,right));
			return node;
		}
		return null;
	}
	
	public void printTree(BinaryTree<E> tree){
		Queue<Node<E>> q = new LinkedList<Node<E>>();
		q.add(tree.getRoot());
		while(!q.isEmpty()){
			Node<E> temp = q.remove();
			if(temp!=null){
				System.out.println(temp.getData()+" has left "+temp.getLeft().getData());
				System.out.println(temp.getData()+" has right "+temp.getRight().getData());
				q.add(temp.getLeft());
				q.add(temp.getRight());
			}
		}
	}
	public static void main(String... strings){
		MinHeapExt runnable = new MinHeapExt();
		Integer[] arr = {16,4,10,14,7,9,3,2,8,1};
		List<Integer> list = Arrays.asList(arr);
		runnable.buildMinHeap(list);
		runnable.printHeap();
		//System.out.println(runnable.getHeap());
		
		MinHeapExt runnable2 = new MinHeapExt();
		list = runnable2.heapSort(list);
		//System.out.println(list);
	}

}
