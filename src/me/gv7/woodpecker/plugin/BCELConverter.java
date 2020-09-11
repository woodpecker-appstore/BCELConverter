package me.gv7.woodpecker.plugin;

import me.gv7.woodpecker.plugin.converter.BCELToClassConverter;
import me.gv7.woodpecker.plugin.converter.ClassToBCELConverter;
import java.util.ArrayList;
import java.util.List;

public class BCELConverter implements IPlugin {
    public static IExtenderCallbacks callbacks;
    public static IPluginHelper pluginHelper;
    @Override
    public void PluginMain(IExtenderCallbacks callbacks) {
        this.callbacks = callbacks;
        this.pluginHelper = callbacks.getPluginHelper();
        callbacks.setPluginName("Class BCEL converter");
        callbacks.setPluginVersion("0.1.0");
        callbacks.setPluginAutor("c0ny1");
        List<IPayloadGenerator> payloadGeneratorList = new ArrayList<IPayloadGenerator>();
        payloadGeneratorList.add(new ClassToBCELConverter());
        payloadGeneratorList.add(new BCELToClassConverter());
        callbacks.registerPayloadGenerator(payloadGeneratorList);
    }
}