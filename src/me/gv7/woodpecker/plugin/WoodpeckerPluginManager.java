package me.gv7.woodpecker.plugin;

public class WoodpeckerPluginManager implements IPluginManager{
    public void registerPluginManagerCallbacks(IPluginManagerCallbacks pluginManagerCallbacks) {
        BCELConverter classToBCEL_plugin = new BCELConverter();
        pluginManagerCallbacks.registerPlugin(classToBCEL_plugin);
    }
}
