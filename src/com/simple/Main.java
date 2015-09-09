package com.simple;

public class Main {
	public static void main(String args[]) {
		System.out.println("Start Test");
		checkMem();
		for (int i = 0; i < 30000; i++) {
			System.out.println("Running Main.class.getResourceAsStream(\"/META-INF/version.properties\");");
			System.out.println(Main.class.getResourceAsStream("/version.properties"));
		}
		System.out.println("End Test");
		checkMem();

		System.out.println("Running com.sun.deploy.security.TrustDecider.reset()");
		com.sun.deploy.security.TrustDecider.reset();
		checkMem();
	}

	private static void checkMem() {

		// "hint" gc
		System.gc();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Used Memory: "
				+ ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1000000) + "MB");
	}
}
