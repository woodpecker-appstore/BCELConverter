package me.gv7.woodpecker.plugin.util;

import org.apache.bcel.classfile.Utility;
import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.io.*;

public class BcelUtil {
    public static void decode(String strBCEL,String classSavePath) throws Exception{
        strBCEL = strBCEL.replace("$$BCEL$$","");
        byte[] decodeStr = Utility.decode(strBCEL,true);
        FileOutputStream fos = new FileOutputStream(new File(classSavePath));
        fos.write(decodeStr);
        fos.flush();
    }

    public static String encode(String classFilePath) throws Exception{
        byte[] byteCode = getFileBytes(classFilePath);
        return "$$BCEL$$" + Utility.encode(byteCode,true);
    }

    public static String readFileContent(String fileName) throws Exception {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        reader = new BufferedReader(new FileReader(file));
        String tempStr;
        while ((tempStr = reader.readLine()) != null) {
            sbf.append(tempStr);
        }
        reader.close();
        return sbf.toString();
    }

    public static byte[] getFileBytes(String file) throws Exception {
        File f = new File(file);
        int length = (int) f.length();
        byte[] data = new byte[length];
        new FileInputStream(f).read(data);
        return data;
    }

    public static void main(String[] args) throws Exception {
        String bcel_string = encode("/Users/c0ny1/Documents/codebak/w/Class2BCEL/target/classes/me/gv7/woodpecker/plugin/BCELConverter.class");
        System.out.println(bcel_string);
        //String bcel_string="$$BCEL$$$l$8b$I$A$A$A$A$A$A$A$95TkO$TA$U$3d$b3$F$b6$dd$$P$da$8a$P$7c$d4$X$b6$a5v$v$a2UA$U$w$I$a6$m$J$a4D$a3$l$b6$ed$a4$y$y$bb$cdv$8b$e1g$v$lH$r$f1$H$f8$cd$3fd$bc$b3K$856X1$9b$cc$9ds$e7$de$3b$e7$cc$dc$d9$l$bf$be$7d$H0$85$b7$K$e2H$87$Q$c3D$Y$Z$3c$U$b3l$Q$9a$A$93A$e4$84$9d$K$e2$91$b0$d32$k$x$I$p$z$e3$89$82A$a4$c3$c8$e3$a9$8cg$K$o$Cd$f0$5c$c6$8c$8cY$Z$_$YB$V$dd4$cbze$b7$c1$90$x$eeq$ad$b6$9f$d7$3e$dbv$b5$ce$x$bb$dc$d1$eaf$b3fX$da$ca27$eb$dcY$f7P$a1$9d2$c3$a0$fa$B$fe2C$b2G$89$f53$91$9490kX$86$3b$c7$QH$a6J$M$7d$F$bb$ca$Z$86$8b$86$c5$d7$9a$7be$eel$eae$93$3c$d1$a2M$iK$bac$I$7c$e2$ecs$b7$8dF$cf$ed$W$K$8b$c5$82m$eds$c7$f5$b6$8b$9cU$b0$aa$h$W$c3t$_$b6$e7$L$WLG$8ds$d7$Y$94m$cf_4$g$$$edW$dc$d1$f7u$ad$e9$g$a6$s$3cDa$b4S$c9A$bd$adf$ba$xv$f6$9f$bcf$e6$a8$9e$b2a7$9d$K_2$bcc$ea$Q$9c$V$FU$5c$c3$98$8aQ$5c$961$a7$e2$r$5e$a9$b8$82$ab$M$f1$82$a97$g$J$91$91$a8$b4ST$ccc$81$a1$7f2$9b$cb$e6T$U$3cP$99$b4$O$I$bc$W$mvJr$deq$f4$D_g$fe$afT$ffT$d6$bc$ed6$ed$O$862$WU$y$e1$cd$c5$w$88$d4M$db$abS8$r$bc$8c$V$86$f1$8b$b5$A$dd$88$c7$df$d4$ad$9a$f6$ae$bc$c3$xn$af$dc$8e$fbg$d0$fe$b3Q$a8$91k$dc$5d$efx$h$e9d$ea$e2$af$p$d6$e0$ee$d9$cak$fa$k$5d$f2$a5d$f1T$c4$86$eb$YV$cdo$c9$ae$e8$Sw$g$86M$bc$e3$5d$L$f3M$d7$s$wC$9d$fdFoP$afV$bb$ca$fbg4$93$fa$40$e1$O$afQ$Yw$daRb$c9$ee$eeN$95p$9b$7eJqP$VH$I$89$ae$a3_WH4$iY$89$fc$d4$8c4$5e$t$a4$91ed$fb$d3G$60_$bc$e5$h4$Ox$ce$mn$d2$a8$fa$B$b8$85$EYF$c5$ef$9c$q$ffD$80$3e$e0Szk$e2$Q$S$8d$z$E$Y$O$d1$f7$VR$b4$bf$85$B$Jb$s$b7$Q$f4g$a1$W$U$J$c7$I$bf$3f$82$ba$9a9$c6$mM$86Z$Y$96$b0E$uBh$c4G$U$9di$n$wA$90$Kx$a4$d2Ph$i$sr$R$8c$d07$86$u$ee$93R$8d$b4$e6I$eb$o$v$dd$m$ad$lI$a9$m$9e$f0$c9$9d$Q$X$b3$bb$b4J$5d$8eq$dc$a3L$89$ac$_$cf$f7$3c$f0$ce$s$e9$jB$ea7$f7$e3$E$ea$f1$F$A$A";

        new ClassLoader().loadClass(bcel_string);
//        decode(bcel_string,"./test.class");
    }
}

