package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import javafx.scene.control.*;

import javafx.scene.control.Label;

public class Controller {
    public Button btok;
    public TextField tex;
    public Label label;
    boolean t=false;

    public hController controller=new hController();
    public aController acontroller=new aController();

    public static void clearTheFile() throws IOException {
        FileWriter fwOb = new FileWriter("out.txt", false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }
    public void onbtok() throws Exception {
        System.out.println("sadsad");
        if(t==false){
            File file = new File("out.txt");
            clearTheFile();

            FileWriter fw = null;
            try {
                fw = new FileWriter(file, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter pw = new PrintWriter(fw);
            pw.println("1");
            /*
             * python program
             *
             * */
            pw.close();
        }


        if(tex.getLength()>0)
        {
            aa.op();
            System.out.println("ok");
            label.setVisible(false);
            String p;
            p=tex.getText();
            File file = new File("out.txt");
            FileWriter fw = null;
            try {
                fw = new FileWriter(file, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter pw = new PrintWriter(fw);

            pw.println("q:"+p);
            /*
            * python program
            *
            * */
            pw.close();
            Main.mainLoginScene.hide();

            controller.home();
        }
        else{
            System.out.println("no");
            label.setVisible(true);
        }

    }
    public void ontex(){
        label.setVisible(false);
    }
    public void findFile(String name,File file)
    {
        File[] list = file.listFiles();

            for (File fil : list)
            {
                System.out.println(fil);
                 if (name.equalsIgnoreCase(fil.getName()))
                {
                    System.out.println("asaaaaaaaa");
                    System.out.println(fil.getParentFile());

                }
            }
    }



    public void onadv() throws Exception {
        Main.mainLoginScene.hide();
        if(t==false){
            acontroller.home();
            t=true;}
        else
            acontroller.stage.show();


    }
}
