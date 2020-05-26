package reactor.core.publisher;

import org.junit.Test;
import reactor.core.Scannable;

import static org.assertj.core.api.Assertions.assertThat;

public class MonoPeekFuseableTest {

    @Test
    public void scanOperator(){
        MonoPeekFuseable test = new MonoPeekFuseable(Mono.just(1), null, null, null, null, null, null);

        assertThat(test.scan(Scannable.Attr.RUN_STYLE)).isSameAs(Scannable.Attr.RunStyle.SYNC);
    }

}