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
}

