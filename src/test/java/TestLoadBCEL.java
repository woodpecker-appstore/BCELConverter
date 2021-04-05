import com.sun.org.apache.bcel.internal.util.ClassLoader;
import me.gv7.woodpecker.bcel.HackBCELs;

public class TestLoadBCEL {
    public static void main(String[] args) throws Exception {
        String strBCEL = HackBCELs.encode("/Users/c0ny1/Documents/codebak/w/Class2BCEL/src/test/java/Exec.class");
        new ClassLoader().loadClass(strBCEL).newInstance();
    }
}
