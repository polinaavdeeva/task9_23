package ru.vsu.cs.avdeeva_p_a;

import util.ArrayUtils;
import java.io.PrintStream;
import java.util.Locale;

public class Main {
    
    public static class CmdParams {
        public String inputFile;
        public String outputFile;
        public boolean error;
        public boolean help;
        public boolean window;
    }

    public static CmdParams parseArgs(String[] args) {
        CmdParams params = new CmdParams();
        if (args.length > 0) {

            if (args[0].equals("--help")) {
                params.help = true;
                return params;
            }

            if (args[0].equals("--window")) {
                params.window = true;
                return params;
            }

            if (args.length < 2) {
                params.help = true;
                params.error = true;
                return params;
            }

            params.inputFile = args[1];

            if (args.length > 2) {
                params.outputFile = args[2];
            }

        } else {
            params.help = true;
            params.error = true;
        }
        return params;
    }

    public static void winMain() throws Exception {
        Locale.setDefault(Locale.ROOT);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        CmdParams params = parseArgs(args);

        if (params.help) {
            PrintStream out = params.error ? System.err : System.out;
            out.println("Usage:");
            out.println("  <cmd> args <input-file> (<output-file>)");
            out.println("  --start  // finding quantity");
            out.println("  <cmd> --help");
            out.println("  <cmd> --window  // show window");
            System.exit(params.error ? 1 : 0);
        }

        if (params.window) {
            winMain();
        } else {
            int[][] arr = ArrayUtils.readIntArray2FromFile(params.inputFile);

            if (arr == null) {
                System.err.printf("Can't read array from \"%s\"%n", params.inputFile);
                System.exit(2);
            }

            FindingQuantity.findQuantityOfElem(arr);

            PrintStream out = (params.outputFile != null) ? new PrintStream(params.outputFile) : System.out;
            out.println(ArrayUtils.toString(arr));
            out.close();
        }
    }
}
