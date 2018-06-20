package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.control.TextField;
import static sample.Controller.clearTheFile;

public class aController {
    public static Stage stage = new Stage();

    ToggleGroup group = new ToggleGroup();
    public TextField edaa;
    public RadioButton top;
    public RadioButton ever;
    public ComboBox tsor;
    public ComboBox esor;
    public ComboBox tlan;
    public ComboBox elan;
    public ComboBox tcon;
    public ComboBox tcat;
    public ComboBox edom;
   // public TextField eda;


    @FXML
    public void initialize() {
        tsor.getItems().addAll("None",
                "google news","bbc-news", "the-verge", "abc-news", "crypto coins news",
                "ary news","associated press","wired","aftenposten","australian financial review","axios",
                "bbc news","bild","blasting news","bloomberg","business insider","engadget","google news"
        );

        esor.getItems().addAll("None",
                "google news","bbc-news", "the-verge", "abc-news", "crypto coins news",
                "ary news","associated press","wired","aftenposten","australian financial review","axios",
                "bbc news","bild","blasting news","bloomberg","business insider","engadget"
        );

        tlan.getItems().addAll("None",
                "ar","en","cn","de","es","fr","he","it","nl","no","pt","ru","sv","ud"
        );

        elan.getItems().addAll("None",
                "ar","en","cn","de","es","fr","he","it","nl","no","pt","ru","sv","ud"
        );

        tcon.getItems().addAll("None",
                "ae","ar","at","au","be","bg","br","ca","ch","cn","co","cu","cz","de","eg","fr","gb","gr","hk",
                "hu","id","ie","il","in","it","jp","kr","lt","lv","ma","mx","my","ng","nl","no","nz","ph","pl",
                "pt","ro","rs","ru","sa","se","sg","si","sk","th","tr","tw","ua","us","ve","za"
        );
        tcat.getItems().addAll("None","business", "entertainment", "general", "health", "science", "sports", "technology");
        edom.getItems().addAll("None",
                "bbc.co.uk", "techcrunch.com", "engadget.com"
        );
    }
    public void home() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("advanced.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage.setScene(new Scene(root1));
        stage.show();
        System.out.println(group.getSelectedToggle());
    }
    public static void clearTheFile() throws IOException {
        FileWriter fwOb = new FileWriter("out.txt", false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }

    public void onok() throws IOException {
        RadioButton chk = (RadioButton)group.getSelectedToggle(); // Cast object to radio button

        stage.hide();
        Main.mainLoginScene.show();
        if(chk==null){
            System.out.println("11111111111");
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
        if(chk==ever){

            File file = new File("out.txt");
            clearTheFile();
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            FileWriter fw = null;
            try {
                fw = new FileWriter(file, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter pw = new PrintWriter(fw);
            pw.println("2");
            if(esor.getValue()==null)
                pw.println("sources:None");
            else
                pw.println("sources:"+esor.getValue());

            if(elan.getValue()==null)
                pw.println("language:None");
            else
                pw.println("language:"+elan.getValue());

            if(edaa.getText().length()>0)
                pw.println("date:"+edaa.getText());
            else
                pw.println("date:None");

            if(edom.getValue()==null)
                pw.println("domain:None");
            else
                pw.println("domain:"+edom.getValue());

            System.out.println(esor.getValue());
            System.out.println(edaa.getText());



            /*
             * python program
             *
             * */
            pw.close();
        }
        if(chk==top){

            File file = new File("out.txt");
            clearTheFile();

            FileWriter fw = null;
            try {
                fw = new FileWriter(file, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter pw = new PrintWriter(fw);
            pw.println("3");
            if(tsor.getValue()==null)
                pw.println("sources:None");
            else
                pw.println("sources:"+tsor.getValue());

            if(tlan.getValue()==null)
                pw.println("language:None");
            else
                pw.println("language:"+tlan.getValue());

            if(tcon.getValue()==null)
                pw.println("country:None");
            else
                pw.println("country:"+tcon.getValue());


            if(tcat.getValue()==null)
                pw.println("category:None");
            else
                pw.println("category:"+tcat.getValue());

            /*
             * python program
             *
             * */
            pw.close();
        }




    }
    public void onto(){ top.setToggleGroup(group);


    }
    public void onev(){ ever.setToggleGroup(group);

    }

}
