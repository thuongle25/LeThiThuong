package com.company;

public class Demo {
    private int mSharedResource = 0;

    private Object mLock = new Object();

    public void decrement(){
        synchronized (mLock){
            mSharedResource--;
            System.out.println(Thread.currentThread().getName()+ " - mSharedResource = "  + mSharedResource);
        }
    }

    public void startThreadA(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                boolean running = true;
                while (running) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (mLock) {
                        mSharedResource++;
                        if (mSharedResource >= 3) {
                            {
                                running = false;
                            }
                            System.out.println(Thread.currentThread().getName() + " - mSharedResource = " + mSharedResource);
                        }
                    }
                }
            }
        });
        thread.setName("Thread-B");
        thread.start();
    }
}
