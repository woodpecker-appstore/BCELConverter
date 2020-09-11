package me.gv7.woodpecker.plugin.converter;

import me.gv7.woodpecker.plugin.BCELConverter;
import me.gv7.woodpecker.plugin.IArgs;
import me.gv7.woodpecker.plugin.IPayloadGenerator;
import me.gv7.woodpecker.plugin.IResultOutput;
import me.gv7.woodpecker.plugin.util.BcelUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BCELToClassConverter implements IPayloadGenerator {
    @Override
    public String getPayloadTabCaption() {
        return "ClassToBCEL";
    }

    @Override
    public List<IArgs> getCutomArgs() {
        List<IArgs> args = new ArrayList<IArgs>();
        IArgs args1 = BCELConverter.pluginHelper.createArgs();
        args1.setName("bcel_string");
        args1.setDefaultValue("$$BCEL$$...");
        args1.setDescription("要转换的BCEL");
        args1.setMastSetup(true);

        IArgs args2 = BCELConverter.pluginHelper.createArgs();
        args2.setName("save_class_path");
        args2.setDefaultValue("/tmp/Woodpecker.class");
        args2.setDescription("保存的class名");
        args2.setMastSetup(true);
        args.add(args1);
        args.add(args2);
        return args;
    }

    @Override
    public void generatorPayload(Map<String, String> customArgs, IResultOutput res) {
        try {
            String bcelString = customArgs.get("bcel_string");
            String saveClassPath = customArgs.get("save_class_path");
            BcelUtil.decode(bcelString,saveClassPath);
            res.successPrintln("save file: " + saveClassPath);
        }catch (Throwable t){
            res.errorPrintln(BCELConverter.pluginHelper.getThrowableInfo(t));
        }
    }
}
