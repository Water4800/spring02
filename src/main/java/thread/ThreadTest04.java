package thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest04 {
    public static void main(String[] args) {

        //仓库
        List list = new ArrayList();

        //生产者线程
        Thread t1 = new Thread(new Product(list));
        t1.setName("Producer线程");

        //消费者线程
        Thread t2 = new Thread(new Consumer(list));
        t2.setName("Consumer线程");

        t1.start();
        t2.start();

    }
}

class Product implements Runnable{

    List list ;

    public Product(List list) {
        this.list = list;
    }

    @Override
    public void run() {

        while (true){
            // 给list对象加锁
            synchronized (list){
                if (list.size() > 0){
                    try {
                        //线程进行等待，释放list的锁
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Object obj = new Object();
                list.add(obj);
                System.out.println(Thread.currentThread().getName() + obj);
                //唤醒线程
                list.notify();
            }
        }

    }
}

class Consumer implements Runnable{

    List list ;

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            synchronized (list){
                if (list.size() == 0){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Object obj = list.remove(0);
                System.out.println(Thread.currentThread().getName() + obj);
                list.notify();
            }
        }
    }
}