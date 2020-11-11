package me.gv7.woodpecker.plugin.converter;

import me.gv7.woodpecker.plugin.*;
import me.gv7.woodpecker.plugin.util.BcelUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClassToBCELConverter implements IHelper {

    @Override
    public String getHelperTabCaption() {
        return "ClassToBCEL";
    }

    @Override
    public IArgsUsageBinder getHelperCutomArgs() {
        IArgsUsageBinder argsUsageBinder = BCELConverter.pluginHelper.createArgsUsageBinder();
        List<IArg> args = new ArrayList<IArg>();
        IArg args1 = BCELConverter.pluginHelper.createArg();
        args1.setName("class_file");
        args1.setDefaultValue("/tmp/Woodpecker.class");
        args1.setDescription("要转换为BCEL的class");
        args1.setRequired(true);
        args.add(args1);
        argsUsageBinder.setArgsList(args);
        return argsUsageBinder;
    }

    @Override
    public void doHelp(Map<String, Object> customArgs, IResultOutput iResultOutput) {
        try {
            String classPath = (String)customArgs.get("class_file");
            String strEncode = BcelUtil.encode(classPath);
            iResultOutput.rawPrintln("\n");
            iResultOutput.rawPrintln(strEncode);
            iResultOutput.rawPrintln("\n");
        }catch (Throwable t){
            iResultOutput.errorPrintln(BCELConverter.pluginHelper.getThrowableInfo(t));
        }
    }
}
