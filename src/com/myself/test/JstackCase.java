package com.myself.test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 类名称：JstackCase<br>
 * 类描述：<br>
 * 创建时间：2019年03月06日<br>
 *
 * @author maopanpan
 * @version 1.0.0
 */
public class JstackCase {
    public static Executor executor = Executors.newFixedThreadPool(10);
    public static Object lock = new Object();

    public static void main(String[] args) {
        Task task1 = new Task();
        Task task2 = new Task();
        executor.execute(task1);
        executor.execute(task2);
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                calculate();
            }
        }

        private void calculate() {
            int i = 0;
            while (Boolean.TRUE) {
                i++;
            }
        }
    }


}
