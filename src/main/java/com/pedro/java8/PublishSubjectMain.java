package com.pedro.java8;

import rx.Observer;
import rx.subjects.PublishSubject;

/**
 * Created by pierre on 03/12/15.
 */
public class PublishSubjectMain {

    public static void main(String[] args) {

        PublishSubject<String> pipe1 = PublishSubject.create();

        PublishSubject<Object> pipe2 = PublishSubject.create();
        pipe2.subscribe(new Observer<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(Object o) {
                System.out.println("Done with '" + o + "'");
            }
        });

        pipe1.subscribe(pipe2);

        pipe1.onNext("Daddy go !");

    }

}
