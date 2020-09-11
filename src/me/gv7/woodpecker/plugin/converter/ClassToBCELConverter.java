package me.gv7.woodpecker.plugin.converter;

import me.gv7.woodpecker.plugin.BCELConverter;
import me.gv7.woodpecker.plugin.IArgs;
import me.gv7.woodpecker.plugin.IPayloadGenerator;
import me.gv7.woodpecker.plugin.IResultOutput;
import me.gv7.woodpecker.plugin.util.BcelUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClassToBCELConverter implements IPayloadGenerator {
    @Override
    public String getPayloadTabCaption() {
        return "ClassToBCEL";
    }

    @Override
    public List<IArgs> getCutomArgs() {
        List<IArgs> args = new ArrayList<IArgs>();
        IArgs args1 = BCELConverter.pluginHelper.createArgs();
        args1.setName("class_file");
        args1.setDefaultValue("/tmp/Woodpecker.class");
        args1.setDescription("要转换为BCEL的class");
        args1.setMastSetup(true);
        args.add(args1);
        return args;
    }

    @Override
    public void generatorPayload(Map<String, String> customArgs, IResultOutput res) {
        try {
            String classPath = customArgs.get("class_file");
            String strEncode = BcelUtil.encode(classPath);
            res.rawPrintln("\n");
            res.rawPrintln(strEncode);
            res.rawPrintln("\n");
        }catch (Throwable t){
            res.errorPrintln(BCELConverter.pluginHelper.getThrowableInfo(t));
        }
    }
}
