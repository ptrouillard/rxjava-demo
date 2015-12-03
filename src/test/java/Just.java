import org.testng.annotations.Test;
import rx.Observable;

/**
 * Created by pierre on 21/11/15.
 */
public class Just {

    @Test
    public void just() {

        Observable<String> from = Observable.just(source1(), source2());
        from.subscribe( s -> System.out.println("<"+s+">"));
    }

    public String source1() {
        return "Annie Wilks";
    }

    public String source2() {
        return "Paul Sheldon";
    }
}
