package interprocess;

import java.lang.reflect.Array;
import java.util.Deque;

public class Buffer<E> {
	
	E q[];
	int n;
	int index;
	public Buffer(Class<E> clazz,int n){
		this.n = n;
		index=-1;
		q = (E[])Array.newInstance(clazz,n);
	}
	public synchronized void add(E o){
			while(index >= n){
				try{
					System.out.println("Queue full.Waiting for queue..."+index);
					wait();
				}catch(InterruptedException ie){
					ie.printStackTrace();
				}
			}
			q[++index] = o;
			System.out.println("Ready for production, notifying...");
			notify();
	}
	public synchronized E remove(){
			while(index<0){
				try{
					System.out.println("Queue Empty. Waiting..."+index);
					wait();
				}catch(InterruptedException ie){
					ie.printStackTrace();
				}
			}
			System.out.println("Ready for consumption, notifying...");
			E e = q[index--];
			notify();
			return e;
			
	}
}
