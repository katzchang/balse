package balse;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Ignore;
import org.junit.Test;

import balse.Balsable;

public class BalsableTest {

	@Ignore
	@Test
	public void test() {
		new Balsable().balse();
		fail();
	}
	
	@Test
	public void testBalsableProcess() throws Exception {
		ProcessBuilder pb = new ProcessBuilder("java",
				"-classpath", "./target/test-classes;./target/classes",
				"balse.BalsableRunner");
		Process p = pb.start();
		assertThat(p.waitFor(), is(1));
	}

}
