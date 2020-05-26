package reactor.core.publisher;

import org.junit.Test;
import reactor.core.Scannable;

import static org.assertj.core.api.Assertions.assertThat;

public class MonoHandleFuseableTest {

    @Test
    public void scanOperator(){
        MonoHandleFuseable<Integer, Integer> test = new MonoHandleFuseable(Mono.just(1), (v, s) -> {});

        assertThat(test.scan(Scannable.Attr.RUN_STYLE)).isSameAs(Scannable.Attr.RunStyle.SYNC);
    }

}