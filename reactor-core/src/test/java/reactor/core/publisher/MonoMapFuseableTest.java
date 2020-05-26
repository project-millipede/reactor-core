package reactor.core.publisher;

import org.junit.Test;
import reactor.core.Scannable;

import static org.assertj.core.api.Assertions.assertThat;

public class MonoMapFuseableTest {

    @Test
    public void scanOperator(){
        MonoMapFuseable<String, String> test = new MonoMapFuseable<>(Mono.just("foo"), s -> s.toUpperCase());

        assertThat(test.scan(Scannable.Attr.RUN_STYLE)).isSameAs(Scannable.Attr.RunStyle.SYNC);
    }

}