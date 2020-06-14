import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhouxu
 * @email 1419982188@qq.com
 * @date 2020/6/2
 */
public class TestThread extends Thread {

    private volatile boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag = " + flag);
    }

    public static void main(String[] args) {

        TestThread testThread = new TestThread();
        testThread.start();
        for (; ; ) {
            synchronized (testThread) {
                if (testThread.isFlag()) {
                    System.out.println("有点东西");
                }
            }
        }
    }
}
