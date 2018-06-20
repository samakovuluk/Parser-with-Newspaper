package sample;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sun.font.TrueTypeFont;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class hController implements Initializable{
    Member myNum= new Member();


    public ProgressIndicator pogo;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pogo.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
        System.out.println(pogo.lookup(".percentage"));

        myNum.numberProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue){
              pogo.setProgress(100);
                System.out.println("apppppppppppppppp");
            }
        });

        pogo.setProgress(1);





      // pogo.progressProperty().bind(myNum.numberProperty());



    }

    public static Stage stage = new Stage();
    private Controller mainWindow;
    public void home() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("progress.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage.setScene(new Scene(root1));
        stage.show();
        File f = new File(aa.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        f= new File(new File(new File(f.getParent()).getParent()).getParent());
        System.out.println(f);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //wait(500);
        findFile("oa.txt",f);










    }
    public boolean findFile(String name,File file) throws InterruptedException {
        File[] list = file.listFiles();

        for (File fil : list)
        {
            System.out.println(fil);
            if (name.equalsIgnoreCase(fil.getName()))
            {

                System.out.println("asaaaaaaaa");

                myNum.setNumber(myNum.getNumber()+1);
                System.out.println(fil.getParentFile());

                ont();
                return true;

            }
        }
        return false;
    }
    public void ont(){
        System.out.println("----------------");

        myNum.setNumber(myNum.getNumber()+1);

    }



}
