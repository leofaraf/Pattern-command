package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis;

    static {
        bis = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        try {
            String line;
            if ((line = bis.readLine()).equals("EXIT")) {
                throw new InterruptOperationException();
            }
            return line;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        System.out.println("Input operation number");
        try {
            String line = readString();
            return Operation.getAllowableOperationByOrdinal(Integer.parseInt(line));
        } catch (IllegalArgumentException e) {
            return askOperation();
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) {
        System.out.println("Input correct two digits: ");
        try {
            String line = readString();
            String[] args = line.split(" ");
            int denomination = Integer.parseInt(args[0]);
            int count = Integer.parseInt(args[1]);
            if (line == null || args.length != 2 || denomination+count < 2) {
                throw new IllegalArgumentException();
            }
            return args;
        } catch (Exception e) {
            System.out.print("Inputted digits is incorrect. ");
            return getValidTwoDigits(currencyCode);
        }
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        System.out.println("Input correct value: ");
        String code = readString();
        if (code.length() != 3) {
            System.out.print("Inputted value is incorrect. ");
            return askCurrencyCode();
        } else {
            return code.toUpperCase();
        }
    }
}
