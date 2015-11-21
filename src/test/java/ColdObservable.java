import org.testng.annotations.Test;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by pierre on 21/11/15.
 */
public class ColdObservable {

    @Test
    public void basic() {

        // cold observable
        Observable<String> stringObservable = Observable.create(new Observable.OnSubscribe<String>() {
            public void call(Subscriber<? super String> subscriber) {

                subscriber.onNext("forever");
                subscriber.onCompleted();
            }
        });

        // start consumer in another thread
        new Thread(new RxRunnable(stringObservable)).start();

    }

    public class RxRunnable implements Runnable {

        private Observable<String> observable;
        public RxRunnable(Observable<String> stringObservable) {
            this.observable = stringObservable;
        }

        public void run() {

            observable.subscribe(new Observer<String>() {
                public void onCompleted() {
                    System.out.println("onCompleted");
                }

                public void onError(Throwable throwable) {
                    System.out.println("onError");
                }

                public void onNext(String s) {
                    System.out.println("onNext : " + s);
                }
            });
        }
    }

}
