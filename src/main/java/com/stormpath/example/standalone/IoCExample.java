package com.stormpath.example.standalone;

import java.util.ArrayList;
import java.util.List;

public class IoCExample {

    public static void main(String[] args) {
        new ComputerProcessor()
            .addComputer(new Doubler())
            .addComputer(new Squarer())
            .computeAll(8);
    }

    static class ComputerProcessor {

        private List<Computer> computers = new ArrayList<>();

        public ComputerProcessor addComputer(Computer c) {
            computers.add(c);
            return ComputerProcessor.this;
        }

        public void computeAll(long value) {
            for (Computer c : computers) {
                String name = c.getClass().getSimpleName();
                System.out.println("Computer: " + name + ", value: " + value + " computed value: " + c.compute(value));
            }
        }
    }

    interface Computer {

        long compute(long value);
    }

    static class Doubler implements Computer {

        public long compute(long value) {
            return value*2;
        }
    }

    static class Squarer implements Computer {

        public long compute(long value) {
            return value*value;
        }
    }
}