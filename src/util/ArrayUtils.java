package util;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ArrayUtils {
    private static final Random RND = new Random();

    public static int[] toPrimitive(Integer[] arr) {

        if (arr == null) {
            return null;
        }

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            result[i] = arr[i];
        }

        return result;
    }

    public static double[] toPrimitive(Double[] arr) {

        if (arr == null) {
            return null;
        }

        double[] result = new double[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static int[] toIntArray(String str) {
        Scanner scanner = new Scanner(str);
        scanner.useLocale(Locale.ROOT);
        scanner.useDelimiter("(\\s|[,;])+");
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }

        Integer[] arr = list.toArray(new Integer[0]);

        return ArrayUtils.toPrimitive(arr);
    }

    public static double[] toDoubleArray(String str) {
        Scanner scanner = new Scanner(str);
        scanner.useLocale(Locale.ROOT);
        scanner.useDelimiter("(\\s|[,;])+");
        List<Double> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextDouble());
        }

        Double[] arr = list.toArray(new Double[0]);

        return ArrayUtils.toPrimitive(arr);
    }

    public static String toString(int[] arr, String itemFormat) {
        if (arr == null) {
            return null;
        }
        if (itemFormat == null || itemFormat.length() == 0) {
            itemFormat = "%s";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(String.format(Locale.ROOT, itemFormat, arr[i]));
        }
        return sb.toString();
    }

    public static String toString(double[] arr, String itemFormat) {

        if (arr == null) {
            return null;
        }

        if (itemFormat == null || itemFormat.length() == 0) {
            itemFormat = "%s";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {

            if (i > 0) {
                sb.append(", ");
            }

            sb.append(String.format(Locale.ROOT, itemFormat, arr[i]));
        }
        return sb.toString();
    }

    public static int[] readIntArrayFromConsole(String arrName) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            try {
                if (arrName == null || arrName.length() == 0) {
                    arrName = "";
                } else {
                    arrName = " " + arrName;
                }
                System.out.printf("Введите массив%s:%n", arrName);
                String line = scanner.nextLine();
                return toIntArray(line);
            }
            catch(Exception e) {
                System.out.print("Вы ошиблись, попробуйте еще раз! ");
            }
        }
    }

    public static double[] readDoubleArrayFromConsole(String arrName) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                if (arrName == null || arrName.length() == 0) {
                    arrName = "";
                } else {
                    arrName = " " + arrName;
                }
                System.out.printf("Введите массив%s:%n", arrName);
                String line = scanner.nextLine();
                return toDoubleArray(line);
            }
            catch(Exception e) {
                System.out.print("Вы ошиблись, попробуйте еще раз! ");
            }
        }
    }

    public static int[][] toIntArray2(String[] lines) {
        int[][] arr2 = new int[lines.length][];
        for (int r = 0; r < lines.length; r++) {
            arr2[r] = toIntArray(lines[r]);
        }
        return arr2;
    }

    public static double[][] toDoubleArray2(String[] lines) {
        double[][] arr2 = new double[lines.length][];
        for (int r = 0; r < lines.length; r++) {
            arr2[r] = toDoubleArray(lines[r]);
        }
        return arr2;
    }

    public static String[] readLinesFromConsole() {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line == null || line.trim().length() == 0)
                break;
            lines.add(line);
        }
        return lines.toArray(new String[0]);
    }

    public static int[][] readIntArray2FromConsole(String arrName, boolean checkMatrix) {

        while (true) {
            try {

                if (arrName == null || arrName.length() == 0) {
                    arrName = "";
                } else {
                    arrName = " " + arrName;
                }
                System.out.printf("Введите двумерный массив%s:%n", arrName);
                int[][] arr2 = toIntArray2(readLinesFromConsole());

                if (checkMatrix) {
                    for (int i = 1; i < arr2.length; i++)
                        if (arr2[i].length != arr2[0].length) {
                            throw new Exception("Строки с разным кол-вом элементов");
                        }
                }
                return arr2;
            }
            catch(Exception e) {
                System.out.print("Вы ошиблись, попробуйте еще раз! ");
            }
        }
    }

    public static int[][] readIntArray2FromConsole(boolean checkMatrix) {
        return readIntArray2FromConsole(null, checkMatrix);
    }

    public static double[][] readDoubleArray2FromConsole(String arrName, boolean checkMatrix) {
        while (true) {
            try {
                if (arrName == null || arrName.length() == 0) {
                    arrName = "";
                } else {
                    arrName = " " + arrName;
                }
                System.out.printf("Введите двумерный массив%s:%n", arrName);
                double[][] arr2 = toDoubleArray2(readLinesFromConsole());
                if (checkMatrix) {
                    for (int i = 1; i < arr2.length; i++)
                        if (arr2[i].length == arr2[0].length) {
                            throw new Exception("Строки с разным кол-вом элементов");
                        }
                }
                return arr2;
            }
            catch(Exception e) {
                System.out.print("Вы ошиблись, попробуйте еще раз! ");
            }
        }
    }

    public static String toString(int[][] arr2, String itemFormat) {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < arr2.length; r++) {
            if (r > 0) {
                sb.append(System.lineSeparator());
            }
            sb.append(toString(arr2[r], itemFormat));
        }
        return sb.toString();
    }

    public static String toString(int[][] arr2) {
        return toString(arr2, null);
    }

    public static String toString(double[][] arr2, String itemFormat) {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < arr2.length; r++) {
            if (r > 0) {
                sb.append(System.lineSeparator());
            }
            sb.append(toString(arr2[r], itemFormat));
        }
        return sb.toString();
    }

    public static String[] readLinesFromFile(String fileName) throws FileNotFoundException {
        List<String> lines;
        try (Scanner scanner = new Scanner(new File(fileName), "UTF-8")) {
            lines = new ArrayList<>();
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }

        }
        return lines.toArray(new String[0]);
    }

    public static int[][] readIntArray2FromFile(String fileName) {
        try {
            return toIntArray2(readLinesFromFile(fileName));
        }
        catch(FileNotFoundException e) {
            return null;
        }
    }

    public static void writeArrayToFile(String fileName, int[] arr, String itemFormat)
            throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(toString(arr, itemFormat));
        }
    }

    public static void writeArrayToFile(String fileName, double[] arr, String itemFormat)
            throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(toString(arr, itemFormat));
        }
    }

    public static void writeArrayToFile(String fileName, int[][] arr2, String itemFormat)
            throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(toString(arr2, itemFormat));
        }
    }

    public static void writeArrayToFile(String fileName, int[][] arr2)
            throws FileNotFoundException {
        writeArrayToFile(fileName, arr2, null);
    }

    public static void writeArrayToFile(String fileName, double[][] arr2, String itemFormat)
            throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(toString(arr2, itemFormat));
        }
    }

    public static int[] createRandomIntArray(int length, int minValue, int maxValue) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++)
            arr[i] = minValue + RND.nextInt(maxValue - minValue);
        return arr;
    }

    public static int[][] createRandomIntMatrix(int rowCount, int colCount, int minValue, int maxValue) {
        int[][] matrix = new int[rowCount][];
        for (int r = 0; r < rowCount; r++)
            matrix[r] = createRandomIntArray(colCount, minValue, maxValue);
        return matrix;
    }

    public static int[][] createRandomIntMatrix(int rowCount, int colCount, int maxValue) {
        return createRandomIntMatrix(rowCount, colCount, 0, maxValue);
    }
}