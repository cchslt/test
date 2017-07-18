package main.com.stone.demo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chenchaohai
 * Date: 2017-07-18 17:16:58
 */

public class VolatileTest {

    public volatile int i =0;

    public void increase(){
        i ++ ;
    }

    public static void main(String[] args) {
        final VolatileTest volatileTest = new VolatileTest();

        for (int j =0; j< 10; j++) {
            new Thread(){
                public void  run(){
                    for (int h =0; h < 1000; h ++){
                        volatileTest.increase();
                    }
                }
            }.start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println(volatileTest.i);
    }
}
