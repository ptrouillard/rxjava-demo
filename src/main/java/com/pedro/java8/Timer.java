package com.pedro.java8;

import rx.Observable;
import rx.Observer;

import java.util.concurrent.TimeUnit;

/**
 * Created by pierre on 03/12/15.
 */
public class Timer {

    public static void main(String[] args) {

        Observable<Long> timer = Observable.timer(1000L, TimeUnit.SECONDS);
        timer.subscribe(new Observer<Long>() {
            @Override
            public void onCompleted() {
                System.out.println("Done");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error");

            }

            @Override
            public void onNext(Long aLong) {
                System.out.println(Long.valueOf(aLong));
            }
        });

    }
}
