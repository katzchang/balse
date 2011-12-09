package balse;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class BalsableTest {
	@Test
	public void testBalsableProcess() throws Exception {
		ProcessBuilder pb = new ProcessBuilder("java", "-classpath",
				"./target/test-classes;./target/classes",
				"balse.BalsableRunner");
		Process p = pb.start();
		assertThat(p.waitFor(), is(1));
	}

}
