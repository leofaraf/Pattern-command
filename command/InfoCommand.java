package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.Collection;

class InfoCommand implements Command {
    private static final String INFO_FORMAT = "%s - %d";

    @Override
    public void execute() {
        boolean hasMoney = false;
        for (CurrencyManipulator manipulator: CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            if (manipulator.hasMoney()) {
                hasMoney = true;
                ConsoleHelper.writeMessage(String.format(INFO_FORMAT, manipulator.getCurrencyCode(), manipulator.getTotalAmount()));
            }
        }
        if (!hasMoney) {
            ConsoleHelper.writeMessage("No money available.");
        }
    }
}
