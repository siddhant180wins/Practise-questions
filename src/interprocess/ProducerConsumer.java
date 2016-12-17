package interprocess;

import java.util.Random;

class ProducerThread<E> implements Runnable{
	Producer<E> p;
	Buffer<E> buffer;
	E value;
	public ProducerThread(Buffer<E> b,E value){
		this.buffer = b;
		this.value = value;
	}
	public void run(){
		p = new Producer<E>(buffer); 
		
		for(int i = 0;i<10;i++){
			try{
				p.produce(value);
				Thread.sleep(new Random().nextInt(5000));
			}catch(Exception e){
				System.out.println("Thread is interrupted"+e);
			}
		}
	}
}
class ConsumerThread<E> implements Runnable{
	Consumer<E> c;
	Buffer<E> buffer;
	public ConsumerThread(Buffer<E> b){
		this.buffer = b;
	}
	public void run(){
		c = new Consumer<E>(buffer);
		for(int i=0;i<3;i++){
			c.consume();
			try{
				Thread.sleep(new Random().nextInt(5000));
			}catch(Exception e){
				System.out.println("Thread is interrupted"+e);
			}
		}
	}
}
public class ProducerConsumer{
	
	void x1(){
		Buffer<Integer>  buffer1 = new Buffer<Integer>(Integer.class,10);
		

	}

	static Buffer<Integer> buffer;
	public static void main(String s[]){
	
		  buffer = new Buffer<Integer>(Integer.class,10);
		  
		  
		//Single Produce - Single Consumer
			  ProducerThread<Integer> pthread = new ProducerThread<Integer>(buffer,1);
			  Thread t = new Thread(pthread);
			  try{
					Thread.sleep(new Random().nextInt(5000));
				}catch(Exception e){
					System.out.println("Thread is interrupted"+e);
				}
			  t.start();
			  try{
					Thread.sleep(new Random().nextInt(5000));
				}catch(Exception e){
					System.out.println("Thread is interrupted"+e);
				}
			  ConsumerThread<Integer> cthread = new ConsumerThread<Integer>(buffer);
			  Thread t1 = new Thread(cthread);
			t1.start();
		
		
	}
	
	
}
