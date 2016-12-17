package interprocess;

import java.util.Random;

public class Producer<E> {
	Buffer<E> buffer;

	public Producer(Buffer<E> buffer) {
		super();
		this.buffer = buffer;
	}
	public void produce(E e){
		System.out.println("Producing " + e+" ...");
		buffer.add(e);
		System.out.println("Produced "+e);
		//notify();
	}
	
	

}
