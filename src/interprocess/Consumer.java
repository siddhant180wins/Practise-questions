package interprocess;

public class Consumer<E> {
	Buffer<E> buffer;
	Consumer(Buffer<E> buffer){
		this.buffer = buffer;
	}
	public void consume(){
		
		E ne = buffer.remove();
		System.out.println("Consumed" + ne+"...");
//		notify();
	}
}
