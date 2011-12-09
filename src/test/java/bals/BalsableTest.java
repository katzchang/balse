package bals;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Ignore;
import org.junit.Test;

public class BalsableTest {

	@Ignore
	@Test
	public void test() {
		new Balsable().balse();
		fail();
	}
	
	@Test
	public void characterizeProcess() throws Exception {
		ProcessBuilder pb = new ProcessBuilder("java", "-version");
		Process p = pb.start();
		assertThat(p.waitFor(), is(0));
	}

}
