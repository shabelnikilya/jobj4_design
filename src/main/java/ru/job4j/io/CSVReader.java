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
            Scanner sc = scanRead(path);
            filterColumn(filterValue, sc, str, delim);
            filterLine(sc, str, delim);
            writeInFileOrConsole(pathOut, str);
        }

        public static Scanner scanRead(String pathCsv) {
            Scanner sc = null;
            try (BufferedInputStream in = new BufferedInputStream(
                    new FileInputStream(pathCsv))) {
                sc = new Scanner(in);
                if(!sc.hasNext()) {
                    throw new IllegalArgumentException("File is empty");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sc;
        }

        public static void writeInFileOrConsole(String pathToFile, StringBuilder outString) {
            if ("stdout".equals(pathToFile)) {
                System.out.println(outString);
            } else if (pathToFile != null) {
                try (BufferedWriter out = new BufferedWriter(
                        new FileWriter(pathToFile))) {
                    out.write(outString.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                throw new IllegalArgumentException("Invalid key is value - out");
            }
        }

        public static void filterColumn(String[] f, Scanner scanner
                , StringBuilder firstLine, String del) {
            int ind = 0;
            List<String> filter = List.of(f);
            Scanner line = new Scanner(scanner.nextLine())
                                        .useDelimiter(del);
            String col;
            while (line.hasNext()) {
                if (filter.contains(col = line.next())) {
                    indexColumn.add(ind);
                    firstLine.append(col).append(del);
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
                    String a = scanLine.next();
                    if (indexColumn.contains(indOut)) {
                        csv.append(a).append(del);
                    }
                    indOut++;
                }
                csv.deleteCharAt(csv.lastIndexOf(del))
                        .append(System.lineSeparator());
                indOut = 0;
            }
        }

    public static void main(String[] args) {
        if (args.length < 4) {
            throw new IllegalArgumentException("Incorrect input data: args");
        }
        ArgsName a = new ArgsName();
        a.parse(args);
        handle(a);
    }
}
