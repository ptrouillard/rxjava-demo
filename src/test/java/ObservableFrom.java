import org.testng.annotations.Test;
import rx.Observable;

import java.util.Arrays;

/**
 * Created by pierre on 21/11/15.
 */
public class ObservableFrom {

    @Test
    public void from() {

        Observable<String> from = Observable.from(
                Arrays.asList(new String[]{"Annie Wilks", "Paul Sheldon"}));
        from.subscribe( s -> System.out.println("<"+s+">"));

    }

}
