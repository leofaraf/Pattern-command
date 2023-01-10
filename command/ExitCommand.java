package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task33.task3310.Helper;

class ExitCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Exit? (y / n)");
        if (ConsoleHelper.readString().equals("y")) {
            ConsoleHelper.writeMessage("Bye!");
        }
    }
}
