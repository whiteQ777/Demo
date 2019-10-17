package com.learn.thread;

/**
 * @Classname Thread001
 * @Description TODO
 * @Date 2019/10/9 20:03
 * @Created by HeYu5
 */
public class Thread001 extends Thread{
    @Override
    public void run(){
//        System.out.println("Thread001");
        System.out.println(currentThread().getId() + ", " + currentThread().getName());
    }

    public static void main(String[] args) {
        Thread th = new Thread001();
        th.start();
        /*
        * start表示启动该线程， 使其成为一个单独的执行流，操作系统为该线程分配线程相关资源，每个线程
        * 会有一个单独的程序计数器和一个栈
        * 操作系统会把这个线程作为一个独立的个体进行调度，分配时间片让他执行
        * 执行的起点是run()
        * */
    }
}