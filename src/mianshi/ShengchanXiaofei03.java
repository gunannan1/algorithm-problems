package mianshi;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 生产者消费者03，阻塞队列
 */
public class ShengchanXiaofei03 {
    public static void main(String[] args) {
        BlockingQueue<Object> queue=new ArrayBlockingQueue<>(3);
        BlockingQueue<String> queue2=new LinkedBlockingDeque<>(3);
//        BlockingQueue<Object> queue=new LinkedBlockingDeque<>(3);
        new Thread(new Producer03(queue)).start();
        new Thread(new Consumer03(queue)).start();

        Consumer031 consumer = new Consumer031(queue2);
        Producer031 producer = new Producer031(queue2);
        for (int i = 0; i < 5; i++) {
            new Thread(producer, "Producer" + (i + 1)).start();
            new Thread(consumer, "Consumer" + (i + 1)).start();
        }
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

class Producer031 implements Runnable{
    BlockingQueue<String> queue;

    public Producer031(BlockingQueue<String> queue){
        this.queue=queue;
    }

    @Override
    public void run() {
        try {
            String temp = "A Product, 生产线程："
                    + Thread.currentThread().getName();
            System.out.println("Produce a product:"
                    + Thread.currentThread().getName());
            queue.put(temp);//如果队列是满的话，会阻塞当前线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Consumer031 implements Runnable{
    BlockingQueue<String> queue;

    public Consumer031(BlockingQueue<String> queue){
        this.queue=queue;
    }

    @Override
    public void run() {
        try {
            String temp = queue.take();//如果队列为空，会阻塞当前线程
            System.out.println("Consume "+ temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

