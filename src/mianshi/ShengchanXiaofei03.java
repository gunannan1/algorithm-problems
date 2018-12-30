package mianshi;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 生产者消费者03，阻塞队列
 */
public class ShengchanXiaofei03 {
    public static void main(String[] args) {
//        BlockingQueue<Object> queue=new ArrayBlockingQueue<>(3);
        BlockingQueue<Object> queue=new LinkedBlockingDeque<>(3);
        new Thread(new Producer03(queue)).start();
        new Thread(new Consumer03(queue)).start();


    }

}

class Producer03 implements Runnable{
    BlockingQueue<Object> queue;

    public Producer03(BlockingQueue<Object> queue){
        this.queue=queue;
    }


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                queue.put(new Object());
                System.out.println("生产者" + Thread.currentThread().getName()
                        + "已生产完成，商品数量：" + queue.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

class Consumer03 implements Runnable{
    BlockingQueue<Object> queue;

    public Consumer03(BlockingQueue<Object> queue){
        this.queue=queue;
    }


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                queue.take();
                System.out.println("消费者" + Thread.currentThread().getName()
                        + "剩余商品数量：" + queue.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}


