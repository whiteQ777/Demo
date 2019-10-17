package com.learn.thread;

/**
 * @Classname Thread002
 * @Description TODO
 * @Date 2019/10/9 20:31
 * @Created by HeYu5
 */
public class Thread002 implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread002");
    }

    public static void main(String[] args) {
        Thread th = new Thread(new Thread002());
        th.start();

    }
}