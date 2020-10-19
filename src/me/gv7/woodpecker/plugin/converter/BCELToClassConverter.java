package me.gv7.woodpecker.plugin.converter;

import me.gv7.woodpecker.plugin.*;
import me.gv7.woodpecker.plugin.util.BcelUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BCELToClassConverter implements IHelper {
    @Override
    public String getHelperTabCaption() {
        return "ClassToBCEL";
    }

    @Override
    public IArgsUsageBinder getHelperCutomArgs() {
        IArgsUsageBinder argsUsageBinder = BCELConverter.pluginHelper.createArgsUsageBinder();
        List<IArgs> args = new ArrayList<IArgs>();
        IArgs args1 = BCELConverter.pluginHelper.createArgs();
        args1.setName("bcel_string");
        args1.setDefaultValue("$$BCEL$$...");
        args1.setDescription("要转换的BCEL");
        args1.setRequired(true);
        IArgs args2 = BCELConverter.pluginHelper.createArgs();
        args2.setName("save_class_path");
        args2.setDefaultValue("/tmp/Woodpecker.class");
        args2.setDescription("保存的class名");
        args2.setRequired(true);
        args.add(args1);
        args.add(args2);
        argsUsageBinder.setArgsList(args);
        return argsUsageBinder;
    }

    @Override
    public void doHelp(Map<String, String> customArgs, IResultOutput iResultOutput) {
        try {
            String bcelString = customArgs.get("bcel_string");
            String saveClassPath = customArgs.get("save_class_path");
            BcelUtil.decode(bcelString,saveClassPath);
            iResultOutput.successPrintln("save file: " + saveClassPath);
        }catch (Throwable t){
            iResultOutput.errorPrintln(BCELConverter.pluginHelper.getThrowableInfo(t));
        }
    }
}
