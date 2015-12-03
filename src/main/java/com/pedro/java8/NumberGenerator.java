package com.pedro.java8;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class NumberGenerator {

    private Observable<Integer> integerObservable;

    public NumberGenerator() {
        integerObservable = Observable.create(new Observable.OnSubscribe<Integer>() {

            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 100; i++) {
                    subscriber.onNext(i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted !");
                    }
                }
                subscriber.onCompleted();
            }
        });
    }

    public void addSubscriber(String name) {
        integerObservable.subscribe(new MyObserver(name));
    }

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();

        // cold observable : sequential work
        numberGenerator.addSubscriber("1");
        numberGenerator.addSubscriber("2");

        //
    }

    private class MyObserver implements Observer<Integer> {

        private String name;
        public MyObserver(String name) {
            this.name = name;
        }

        @Override
        public void onCompleted() {
            System.out.println("#" + name +" : Done.");
        }

        @Override
        public void onError(Throwable throwable) {
            System.out.println("#" + name +" : Error detected. Damned !");
        }

        @Override
        public void onNext(Integer integer) {
            System.out.println("#" + name +" : " + integer);
        }
    }
}
