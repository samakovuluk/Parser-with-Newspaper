package sample;

import sun.tools.jar.CommandLine;

import java.io.*;
import java.util.Arrays;

public class aa {

    public static void op() throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec(new String[]{"cmd.exe","/c","start python C:\\Users\\USK\\Desktop\\aa\\parser\\banan.py"});
        Runtime runtime = Runtime.getRuntime();
        Process p = runtime.exec("python C:\\Users\\USK\\Desktop\\aa\\parser\\banan.py");
        /*
        try {
            // Execute command
            String command = "cmd /c start cmd.exe";
            Process child = Runtime.getRuntime().exec(command);

            // Get output stream to write from it
            OutputStream out = child.getOutputStream();

            out.write("python C:\\Users\\USK\\Desktop\\aa\\parser\\banan.py".getBytes());
            out.flush();

            out.close();
        } catch (IOException e) {
        }*/
    }

}
