package barracksWars.core.commands;

import barracksWars.interfaces.CommandInterpreter;
import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        String className =UNITS_PACKAGE_NAME+ parseCommandToClassName(commandName);

        Executable command =null;
        try {
            Class clazz = Class.forName(className);
            Constructor<Command> declaredConstructor = clazz.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
            declaredConstructor.setAccessible(true);
             command = declaredConstructor.newInstance(data, repository, unitFactory);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return command;

//        switch (commandName) {
//            case "add":
//                return new AddCommand(data, repository, unitFactory);
//
//            case "report":
//                return new ReportCommand(data, repository, unitFactory);
//
//            case "fight":
//                return new FightCommand(data, repository, unitFactory);
//            case "retire":
//                return new RetireCommand(data, repository, unitFactory);
//            default:
//                throw new RuntimeException("Invalid command!");
//        }

    }

    private String parseCommandToClassName(String commandName) {
        String command=commandName.substring(0, 1).toUpperCase();
        return command + commandName.substring(1) + "Command";

    }
}
