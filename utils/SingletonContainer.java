package utils;

import Commands.*;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class SingletonContainer {
    private static Map<String, Command> commandsByNames;

    private SingletonContainer() {
    }

    private static void init() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        commandsByNames = new HashMap<>();

        File file = new File("E:\\Repositories\\Live-Code\\src\\Commands");

        File[] files = file.listFiles();

        for (File f : files) {

            if (f.getName().equals("Command.java")) {
                continue;
            }

            Class clazz = Class.forName(("Commands." + f.getName()).replaceAll(".java", ""));

            Constructor ctor = clazz.getDeclaredConstructor();

            Command command = (Command) ctor.newInstance();

            commandsByNames.put(f.getName().replaceAll(".java", ""), command);
        }
    }

    public static Map<String, Command> getCommands() {
        if (commandsByNames == null) {
            try {
                init();
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        return commandsByNames;
    }
}
