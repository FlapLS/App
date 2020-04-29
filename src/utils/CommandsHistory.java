package utils;

import commands.Command;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Вспомогательный класс для реализации команды history.
 *
 * @author Базанов Евгений.
 */
public class CommandsHistory {
    private final static int size = 7;
    final Queue<Command> history = new LinkedList<>();

    /**
     * Метод, реализуюший выполнение команды history.
     *
     * @param command название команды.
     */
    public void addCommand(Command command) {
        if (history.size() >= size) {
            history.poll();
        }
        history.add(command);
    }


    @Override
    public String toString() {
        return history.stream().map(Command::getCommandName).collect(Collectors.joining("\n"));
    }
}