package mutliThread;

//class Tortoise extends Thread {
//	public void run() {
//		for(int i = 1; i <= 10; i ++) {
//			System.out.println("Tortoise run " + i + " step");
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//}
//
//class Rabbit extends Thread {
//	public void run() {
//		for(int i = 1; i <= 10; i ++) {
//			System.out.println("Rabbit run " + i + " step");
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//}
//
//public class test {
//	public static void main(String args[]) {
//		Tortoise tortoise = new Tortoise();
//		Rabbit rabbit = new Rabbit();
//		tortoise.start();
//		rabbit.start();
//	}
//}

class Tortoise implements Runnable {
	public void run() {
		for(int i = 1; i <= 10; i ++) {
			System.out.println("Tortoise run " + i + " step");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Rabbit implements Runnable {
	public void run() {
		for(int i = 1; i <= 10; i ++) {
			System.out.println("Rabbit run " + i + " step");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class test {
	public static void main(String args[]) {
		Tortoise tortoise = new Tortoise();
		Rabbit rabbit = new Rabbit();
		Thread tortoiseProxy = new Thread(tortoise);
		Thread rabbitProxy = new Thread(rabbit);
		tortoiseProxy.start();
		rabbitProxy.start();
	}
}
