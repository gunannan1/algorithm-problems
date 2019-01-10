import java.io.IOException;
import java.util.PriorityQueue;

public class test {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.peek());
    }
}
