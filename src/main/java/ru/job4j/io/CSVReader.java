package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    private static List<Integer> indexColumn = new ArrayList<>();

        public static void handle(ArgsName argsName) {
            String delim = argsName.get("delimiter");
            String[] filterValue = argsName.get("filter").split(",");
            String path = argsName.get("path");
            String pathOut = argsName.get("out");
            StringBuilder str = new StringBuilder();
            try (Scanner sc = scanRead(path)) {
                filterColumn(filterValue, sc, str, delim);
                filterLine(sc, str, delim);
                writeInFileOrConsole(pathOut, str);
            }
        }

        public static Scanner scanRead(String pathCsv) {
            Scanner sc = null;
            try (BufferedInputStream in = new BufferedInputStream(
                    new FileInputStream(pathCsv))) {
                sc = new Scanner(in);
                if (!sc.hasNext()) {
                    throw new IllegalArgumentException("File is empty");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sc;
        }

        public static void writeInFileOrConsole(String pathToFile, StringBuilder outString) {
            if (pathToFile == null) {
                throw new IllegalArgumentException("Incorrect value of the 'out' key");
            }
            if ("stdout".equals(pathToFile)) {
                System.out.println(outString);
            } else {
                try (BufferedWriter out = new BufferedWriter(
                        new FileWriter(pathToFile))) {
                    out.write(outString.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public static void filterColumn(String[] f, Scanner scanner
                , StringBuilder firstLine, String del) {
            int ind = 0;
            List<String> filter = List.of(f);
            Scanner line = new Scanner(scanner.nextLine())
                                        .useDelimiter(del);
            String column;
            while (line.hasNext()) {
                if (filter.contains(column = line.next())) {
                    indexColumn.add(ind);
                    firstLine.append(column).append(del);
                }
                ind++;
            }
            firstLine.deleteCharAt(firstLine.lastIndexOf(del))
                    .append(System.lineSeparator());
        }

        public static void filterLine(Scanner sc, StringBuilder csv, String del) {
            int indOut = 0;
            while (sc.hasNext()) {
                Scanner scanLine = new Scanner(sc.nextLine()).useDelimiter(del);
                while (scanLine.hasNext()) {
                    String scanWords = scanLine.next();
                    if (indexColumn.contains(indOut)) {
                        csv.append(scanWords).append(del);
                    }
                    indOut++;
                }
                csv.deleteCharAt(csv.lastIndexOf(del))
                        .append(System.lineSeparator());
                indOut = 0;
            }
        }

        public static void validArgs(String[] args) {
            if (args.length < 4) {
                throw new IllegalArgumentException("Incorrect input data: args");
            }
        }

    public static void main(String[] args) {
        validArgs(args);
        ArgsName pairKeyVal = new ArgsName();
        pairKeyVal.parse(args);
        handle(pairKeyVal);
    }
}
