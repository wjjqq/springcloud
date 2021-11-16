package com.wjj.test;

/**
 * @Author wjj
 * @create 2021/11/15
 * @Description
 */
public class jvmSize {
    public static void main(String[] args) {
        String initialHeapSize = Runtime.getRuntime().totalMemory()/1024/1024+"m";
        String maxHeapSize = Runtime.getRuntime().maxMemory()/1024/1024+"m";
        System.out.println("default initialHeapSize="+initialHeapSize);
        System.out.println("default maxHeapSize="+maxHeapSize);
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
