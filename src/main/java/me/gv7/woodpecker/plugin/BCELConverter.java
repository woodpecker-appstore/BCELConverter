package me.gv7.woodpecker.plugin;

import me.gv7.woodpecker.bcel.HackBCELs;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BCELConverter implements IHelperPlugin {
    public static IHelperPluginCallbacks callbacks;
    public static IPluginHelper pluginHelper;


    @Override
    public void HelperPluginMain(IHelperPluginCallbacks iHelperPluginCallbacks) {
        this.callbacks = iHelperPluginCallbacks;
        this.pluginHelper = iHelperPluginCallbacks.getPluginHelper();
        callbacks.setHelperPluginName("Class BCEL converter");
        callbacks.setHelperPluginVersion("0.2.0");
        callbacks.setHelperPluginAutor("c0ny1");
        List<IHelper> helperList = new ArrayList<IHelper>();
        helperList.add(new ClassToBCELConverter());
        helperList.add(new BCELToClassConverter());
        callbacks.registerHelper(helperList);
    }

    public class BCELToClassConverter implements IHelper {
        @Override
        public String getHelperTabCaption() {
            return "BCELToClass";
        }

        @Override
        public IArgsUsageBinder getHelperCutomArgs() {
            IArgsUsageBinder argsUsageBinder = pluginHelper.createArgsUsageBinder();
            List<IArg> args = new ArrayList<IArg>();
            IArg args1 = BCELConverter.pluginHelper.createArg();
            args1.setName("bcel_string");
            args1.setDefaultValue("$$BCEL$$...");
            args1.setDescription("要转换的BCEL");
            args1.setRequired(true);
            IArg args2 = BCELConverter.pluginHelper.createArg();
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
        public void doHelp(Map<String, Object> customArgs, IResultOutput iResultOutput) {
            try {
                String bcelString = (String)customArgs.get("bcel_string");
                String saveClassPath = (String)customArgs.get("save_class_path");
                byte[] clazzBytes = HackBCELs.decode(bcelString);
                FileOutputStream fos = new FileOutputStream(saveClassPath);
                fos.write(clazzBytes);
                fos.flush();
                fos.close();
                iResultOutput.successPrintln("save file: " + saveClassPath);
            }catch (Throwable t){
                iResultOutput.errorPrintln(BCELConverter.pluginHelper.getThrowableInfo(t));
            }
        }
    }

    public class ClassToBCELConverter implements IHelper {

        @Override
        public String getHelperTabCaption() {
            return "ClassToBCEL";
        }

        @Override
        public IArgsUsageBinder getHelperCutomArgs() {
            IArgsUsageBinder argsUsageBinder = pluginHelper.createArgsUsageBinder();
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
                String strEncode = HackBCELs.encode(classPath);
                iResultOutput.rawPrintln("\n");
                iResultOutput.rawPrintln(strEncode);
                iResultOutput.rawPrintln("\n");
            }catch (Throwable t){
                iResultOutput.errorPrintln(BCELConverter.pluginHelper.getThrowableInfo(t));
            }
        }
    }
}