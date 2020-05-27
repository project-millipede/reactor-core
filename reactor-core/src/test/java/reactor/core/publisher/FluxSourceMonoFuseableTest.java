package reactor.core.publisher;

import org.junit.Test;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class FluxSourceMonoFuseableTest {

    @Test
    public void scanOperatorWithSyncSource(){
        FluxSourceMonoFuseable<String> test = new FluxSourceMonoFuseable<>(Mono.just("Foo"));

        assertThat(test.scan(Scannable.Attr.RUN_STYLE)).isSameAs(Scannable.Attr.RunStyle.SYNC);
    }

    @Test
    public void scanOperatorWithAsyncSource(){
        MonoDelayElement<String> source = new MonoDelayElement<>(Mono.empty(), 1, TimeUnit.SECONDS, Schedulers.immediate());

        FluxSourceMonoFuseable<String> test = new FluxSourceMonoFuseable(source);

        assertThat(test.scan(Scannable.Attr.RUN_STYLE)).isSameAs(Scannable.Attr.RunStyle.ASYNC);
    }

}