import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhouxu
 * @email 1419982188@qq.com
 * @date 2020/6/4
 */
public class Test {

    public static void main(String[] args) {
        String s6 = new String("go") + new String("od");
        String s7 = s6.intern();
        String s8 = "good";
        System.out.println(s6 == s7);
        System.out.println(s7 == s8);
        System.out.println(s6 == s8);

        ThreadPoolExecutor
    }
}
