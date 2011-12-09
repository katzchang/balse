package balse;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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

	@Test
	public void testBalsableThread() throws Exception {
		ProcessBuilder pb = new ProcessBuilder("java", "-classpath",
				"./target/test-classes;./target/classes",
				"balse.BalsableThreadRunner");
		Process p = pb.start();
		assertThat(p.waitFor(), is(1));
		
		InputStream is = p.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
		List<String> lines = new ArrayList<String>();
		while ((line = br.readLine()) != null) lines.add(line);
		is.close();
		
		assertThat(lines.size(), is(2));
		assertThat(lines.get(0), is("時間だ！！答えを聞こう！！"));
		assertThat(lines.get(1), is("バルス！"));
	}
}
