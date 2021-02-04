package me.gv7.woodpecker.plugin;

import me.gv7.woodpecker.plugin.converter.BCELToClassConverter;
import me.gv7.woodpecker.plugin.converter.ClassToBCELConverter;
import java.util.ArrayList;
import java.util.List;

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
}