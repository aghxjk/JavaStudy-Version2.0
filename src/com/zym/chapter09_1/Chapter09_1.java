package com.zym.chapter09_1;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by zhaoyimeng on 15/12/2.
 */
public class Chapter09_1 {

    public static void main(String[] argv) throws InterruptedException {
//        if (true) {
        if (false) {
            /**
             * 1.Executor示例
             *   a. 该种方式在main()线程结束后,Executors线程还会存在等待,整个java进程不会退出
             */
            MyExcutors.run();
        }

//        if (true) {
        if (false) {
            /**
             * 1.ExecutorService示例
             *   a. 当main()线程调用shutdown方法后
             *      (1)如果有ExecutorService线程在运行,则等待线程结束后关闭ExecutorService线程池
             *      (2)如果线程池当前没有运行线程,则直接关闭线程池
             *
             */
            MyExecutorService.run();
            System.out.println("将要关闭executorService.....");
            MyExecutorService.executorService.shutdown();
        }

//        if (true) {
        if (false) {
            /**
             *  单个异步操作示例
             */
            FutureAndCallable.run();
        }

//        if (false) {
        if ( true ) {
            ScheduledExecutorServiceAndCallable.run();
        }
    }

}

class MyExcutors{

    public static void run() {

        Executor executor = Executors.newFixedThreadPool(5);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("MyExecutor task running...." + Thread.currentThread().getName());
                }
            }
        };


        for (int i=0; i<9; i++) {
            executor.execute(task);
        }
    }
}

class MyExecutorService{
    public static ExecutorService executorService = Executors.newFixedThreadPool(5);
    public static void run() {

        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("MyExecutorService task running...."+ Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        for (int i = 0; i < 5; i++) {
//            executorService.execute(task);
            executorService.submit(task);
        }
        System.out.println("end..........");
    }
}

class FutureAndCallable{

    public static void run(){

        /**
         *  1. 创建一个Callable提供给FutureTask 回调
         *  2. 创建FutureTask实例
         *  3. 创建FutureTask的线程
         *  4. 等待Future的计算结果
         */
        //创建一个Callable提供给FutureTask 回调
        Callable<Integer> addCall = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int tmp=0;
                for (int i = 0; i < 10; i++) {
                    tmp += i;
                    System.out.println("计算中.....");
                    Thread.sleep(1000);
                }
                return tmp;
            }
        };

        //创建FutureTask实例
        FutureTask futureTask = new FutureTask<Integer>(addCall);

        //创建FutureTask的线程
        Thread task =  new Thread(futureTask);
        task.start();

        System.out.println("等待FutureTask线程执行的结果:");
        try {
            Integer integer = (Integer) futureTask.get();
            System.out.println("计算结果是: " + integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class ScheduledExecutorServiceAndCallable {

    public static void run() {

        //创建一个Callable提供给FutureTask 回调
        Callable<Integer> addCall = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int tmp = 0;
                for (int i = 0; i < 3; i++) {
                    tmp += i;
                    System.out.println("计算中.....");
                    Thread.sleep(1000);
                }
                return tmp;
            }
        };

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        // 延迟2秒开始执行计划
        ScheduledFuture<Integer> future = scheduledExecutorService.schedule(addCall, 2, SECONDS);
        scheduledExecutorService.shutdown();

        try {
            System.out.println(future.get());
            System.out.println("Finished...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}




