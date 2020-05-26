package reactor.core.publisher;

import org.junit.Test;
import reactor.core.Scannable;

import static org.assertj.core.api.Assertions.assertThat;

public class MonoFilterFuseableTest {

    @Test
    public void scanOperator() {
        MonoFilterFuseable<Integer> test = new MonoFilterFuseable<>(Mono.just(1), (v -> v % 2 != 0));

        assertThat(test.scan(Scannable.Attr.RUN_STYLE)).isSameAs(Scannable.Attr.RunStyle.SYNC);
    }
}