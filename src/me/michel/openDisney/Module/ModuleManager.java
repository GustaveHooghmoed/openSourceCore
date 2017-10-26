package me.michel.openDisney.Module;

import me.michel.openDisney.Module.Modules.Park.ParkModule;
import me.michel.openDisney.Module.Modules.Studio.StudioModule;

import java.util.ArrayList;

public class ModuleManager {

    private ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager() {
        registerModules();
        loadModules();
    }

    private void registerModules() {
        modules.add(new ParkModule());
        modules.add(new StudioModule());
    }

    public void loadModules() {
        for (Module m : modules) {
            m.load();
        }
    }

    public void reloadModules() {
        for (Module m : modules) {
            m.reload();
        }
    }

    public void unloadModules() {
        for (Module m : modules) {
            m.unload();
        }
    }

    public Module getModule(int id) {
        return modules.get(id);
    }

    public void unloadModule(Module m) {
        m.unload();
    }

    public void loadModule(Module m) {
        m.load();
    }

    public void reloadModule(Module m) {
        m.reload();
    }

}
