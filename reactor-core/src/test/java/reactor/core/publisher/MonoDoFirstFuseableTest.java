package reactor.core.publisher;

import org.junit.Test;
import reactor.core.Scannable;

import static org.assertj.core.api.Assertions.assertThat;

public class MonoDoFirstFuseableTest {

    @Test
    public void scanOperator(){
        MonoDoFirstFuseable<String> test = new MonoDoFirstFuseable<>(Mono.just("foo"), () -> {});

        assertThat(test.scan(Scannable.Attr.RUN_STYLE)).isSameAs(Scannable.Attr.RunStyle.SYNC);
    }

}