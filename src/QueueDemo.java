import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {
	public static void main(String[] args) {
		Queue q1 = new PriorityQueue();
		q1.add(10);
		q1.add(25);
		q1.add(25);
		q1.add(22);
		q1.add(35);
		q1.add(125);
		q1.add(12);
		System.out.println(q1);
		
		// Reterive Head Element & remove Queue
		System.out.println("Poll method : "+q1.poll());
		System.out.println(q1);
		// Reterive Head Element Queue
		System.out.println("Peek method : "+q1.peek());
		

	}
}
