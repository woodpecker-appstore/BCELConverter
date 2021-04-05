import java.io.IOException;

public class Exec {
    public Exec() throws IOException {
        Runtime.getRuntime().exec(new String[]{"/bin/sh","-c","open /System/Applications/Calculator.app/Contents/MacOS/Calculator"});
    }
}
