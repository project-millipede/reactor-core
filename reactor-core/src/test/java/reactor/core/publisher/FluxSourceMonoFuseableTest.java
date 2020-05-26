package reactor.core.publisher;

import org.junit.Test;
import reactor.core.Scannable;

import static org.assertj.core.api.Assertions.assertThat;

public class FluxSourceMonoFuseableTest {

    @Test
    public void scanOperator(){
        FluxSourceMonoFuseable<String> test = new FluxSourceMonoFuseable<>(Mono.just("Foo"));

        assertThat(test.scan(Scannable.Attr.RUN_STYLE)).isSameAs(Scannable.Attr.RunStyle.SYNC);
    }

}