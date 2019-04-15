import java.io.IOException;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class test {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.peek());

        String a="9";
        boolean b=Character.isDigit('9');

        System.out.println(b);

    }
}
