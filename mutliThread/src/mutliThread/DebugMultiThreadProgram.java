package mutliThread;


class Singleton {
	private static Singleton instance;
	
	private Singleton() {
	}
	
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
public class DebugMultiThreadProgram implements Runnable{

	@Override
	public void run() {
		Singleton singleton = Singleton.getInstance();
		System.out.println(singleton);
	}
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(new DebugMultiThreadProgram());
		Thread thread2 = new Thread(new DebugMultiThreadProgram());
		thread1.start();
		thread2.start();
	}
		
				

	
}
