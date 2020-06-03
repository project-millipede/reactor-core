package reactor.core.publisher;

import org.junit.Test;
import reactor.core.Scannable;

import static org.assertj.core.api.Assertions.*;


public class FluxSourceFuseableTest {

	@Test
	public void scanOperator(){
		Flux<Integer> source = Flux.just(1);
		FluxSourceFuseable<Integer> test = new FluxSourceFuseable<>(source);

	    assertThat(test.scan(Scannable.Attr.PARENT)).isSameAs(source);
	    assertThat(test.scan(Scannable.Attr.PREFETCH)).isEqualTo(-1);
	    assertThat(test.scan(Scannable.Attr.RUN_STYLE)).isSameAs(Scannable.Attr.RunStyle.SYNC);
	}

}