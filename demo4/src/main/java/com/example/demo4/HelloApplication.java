package com.example.demo4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



import java.awt.*;
import java.io.IOException;
import java.time.format.DateTimeFormatterBuilder;

import static sun.security.util.KnownOIDs.Title;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane mygrid = new GridPane();
        Scene myScore = new Scene(mygrid, 800, 300);

        Label header = new Label("Enter a number in the 1st box and only 'c' for celsius or 'f' for fahrenheit in the 2nd box.");
        //box1= header titler
        //header = instructions
        //userinpt 1&2 = boxes
        //t1b= button

        TextField userinput1 = new TextField();
        TextField userinput2 = new TextField();
        Label box1 = new Label(" Welcome to my temperature converter! ");
        Label resultLabel = new Label();


        mygrid.add(box1, 3,0);
        box1.setStyle("-fc-font-family: Courier; -fx-font-size: 30px; -fx-font-weight: bold;");
        mygrid.add(header,3,3);
        header.setStyle("-fc-font-family: Courier; -fx-font-size: 20px; ");
        //-fx-padding: 0 0 0 450px"

        mygrid.add(userinput1,3,5);
        userinput1.setStyle("-fc-font-family: Courier; -fx-font-size: 20px;");

        mygrid.add(userinput2,3,7);
        userinput2.setStyle("-fc-font-family: Courier; -fx-font-size: 20px;");

        //mygrid.add(dia,3,3);
        Button t1b = new Button ("Submit");

        mygrid.add(t1b, 3,9);
        t1b.setStyle("-fx-pref-width: 100px; -fx-pref-height: 50px;");

        t1b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    float number = Float.parseFloat(userinput1.getText());
                    String degree = userinput2.getText();

                    if ("f".equalsIgnoreCase(String.valueOf(degree))) {
                        float ans = (number - 32) * 5 / 9;
                        header.setText("Your converted temperature is " + ans + "°C.");

                    }
                   else if ("c".equalsIgnoreCase(String.valueOf(degree))) {
                        float ans = (number * 9 / 5) + 32;
                        header.setText("Your converted temperature is " + ans + "°F.");

                    }else {
                        throw new Exception();
                    }

                } catch (NumberFormatException number) {
                    header.setText("Oops! Please enter a numerical value in the first box ex.2,67,8..." + "\n Reminder: Enter a number in the 1st box and only 'c' for celsius or 'f' for fahrenheit in the 2nd box.");

                }catch(Exception degree) {

                    if(!"f".equalsIgnoreCase(String.valueOf(userinput2)) || !"c".equalsIgnoreCase(String.valueOf(userinput2)))
                        header.setText("Oops! Please enter only 'c' or 'f' in the second box." + "\n Reminder: Enter a number in the 1st box and only 'c' for celsius or 'f' for fahrenheit in the 2nd box.");
                }

            }



            }

        );



        stage.setScene(myScore);
        stage.show();
       /* FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        */
    }

    public static void main(String[] args) {
        launch();
    }
}