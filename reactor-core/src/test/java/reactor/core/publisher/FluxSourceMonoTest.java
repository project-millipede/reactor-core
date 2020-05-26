package reactor.core.publisher;

import org.junit.Test;
import reactor.core.Scannable;

import static org.assertj.core.api.Assertions.assertThat;

public class FluxSourceMonoTest {

    @Test
    public void scanOperator(){
        FluxSourceMono<String> test = new FluxSourceMono<>(Mono.just("Foo"));

        assertThat(test.scan(Scannable.Attr.RUN_STYLE)).isSameAs(Scannable.Attr.RunStyle.SYNC);
    }
}