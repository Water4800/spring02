package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现线程的第三种方式
 *  实现 Callable接口
 */
public class ThreadTest03 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //创建一个未来任务类对象
        //给一个Callable接口实现类对象
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("call method begin");
                Thread.sleep(1000*5);
                System.out.println("call method end!");
                int a = 100;
                int b = 200;
                return a + b ;
            }
        });

        //创建线程对象
        Thread t = new Thread(task);

        //启动线程
        t.run();

        //get()方法执行，会导致当前线程阻塞
        //可以拿到线程的返回结果
        Object obj = task.get();
        System.out.println(obj);



    }


}
