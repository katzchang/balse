package balse;

public class BalsableThreadRunner {
	
	public static void main(String...args) {
		BalsableThreadRunner runner = new BalsableThreadRunner();
		runner.startPazuAndSheeta();
		runner.startMooska();
	}
	
	public void startMooska() {
		new Thread(new Mooska()).start();
	}
	
	public void startPazuAndSheeta() {
		new Thread(new PazuAndSheeta()).start();
	}
	
	class Mooska implements Runnable {
		public void run() {
			System.out.println("時間だ！！答えを聞こう！！");
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		};
	}
	
	class PazuAndSheeta implements Runnable {
		public void run() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			} finally {
				System.out.println("バルス！");
				new Balsable().balse();
			}
		};
	}
}
