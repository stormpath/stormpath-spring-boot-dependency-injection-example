package com.stormpath.example.standalone;

import java.util.ArrayList;
import java.util.List;

// DON'T DO THIS
public class BadExample {

    public static void main(String[] args) {
        new ComputerProcessor()
            .addComputer(new Doubler())
            .addComputer(new Squarer())
            .computeAll(8);
    }

    static class ComputerProcessor {

        private List computers = new ArrayList();

        public ComputerProcessor addComputer(Object o) {
            computers.add(o);
            return ComputerProcessor.this;
        }

        public void computeAll(long value) {
            for (Object o : computers) {
                long computedValue = -1;

                if (o instanceof Doubler) {
                    computedValue = ((Doubler) o).computeDouble(value);
                } else if (o instanceof Squarer) {
                    computedValue = ((Squarer) o).computeSquare(value);
                }
                String name = o.getClass().getSimpleName();
                System.out.println("Computer: " + name + ", value: " + value + " computed value: " + computedValue);
            }
        }
    }

    static class Doubler {

        public long computeDouble(long value) {
            return value*2;
        }
    }

    static class Squarer {

        public long computeSquare(long value) {
            return value*value;
        }
    }
}