import org.testng.annotations.Test;
import rx.Observable;

/**
 * Created by pierre on 21/11/15.
 */
public class ObservableMisc {

    @Test
    public void empty() {

        // sends nothing but terminate normally
        Observable.empty();

        // sends nothing but never terminate
        Observable.never();

        // send nothing and terminate on error
        //Observable.throw( new NullPointerException());


    }
}
