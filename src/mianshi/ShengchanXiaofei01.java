package mianshi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 生产者消费者写法1 wait/notify
 */
public class ShengchanXiaofei01 {
    public static void main(String[] args) {
        int maxSize=10;
        Queue<Object> queue=new LinkedList<>();
        new Thread(new Consumer01(queue,maxSize)).start();
//        new Thread(new Consumer01(queue,maxSize)).start();
        new Thread(new Producer01(queue,maxSize)).start();
        new Thread(new Producer01(queue,maxSize)).start();
        new Thread(new Consumer01(queue,maxSize)).start();
//        new Thread(new Producer01(queue,maxSize)).start();
//        new Thread(new Producer01(queue,maxSize)).start();
//        new Thread(new Producer01(queue,maxSize)).start();
//        new Thread(new Producer01(queue,maxSize)).start();

    }

}
class Producer01 implements Runnable{
    private Queue<Object> queue;
    private int maxSize;

    public Producer01(Queue<Object> queue, int maxSize){
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        for (int i = 0; i < maxSize; i++) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        queue.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                queue.add(new Object());
                System.out.println(Thread.currentThread().getName()+"生产了产品，" + "目前总共有" + queue.size());
                queue.notifyAll();
            }
        }
    }
}

class Consumer01 implements Runnable{
    private Queue<Object> queue;
    private int maxSize;

    public Consumer01(Queue<Object> queue, int maxSize){
        this.queue = queue;
        this.maxSize = maxSize;
    }


    @Override
    public void run() {
        for (int i = 0; i < maxSize; i++) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (queue) {
                while (queue.size() == 0) {
                    try {
                        queue.wait();
                    } catch (Exception e) {
                    }
                }
                queue.poll();
                System.out.println(Thread.currentThread().getName() + "消费者消费，还剩下" + queue.size());
                queue.notifyAll();
            }
        }
    }
}



