package fr.greg.testfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        stage.setTitle("TOUCH MY TRALALA");
        stage.setWidth(600); //largeur
        stage.setHeight(400); //hauteur
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen(); // A declarer apres le show

        //On essaie de faire disparaitre otherStage au bout d'un temps donné
        // Si on ne veut pas geler l'app, on ne doit pas faire nos thread au niveau de JavaFX
        //Application Thread, on créé un nouveau Thread
        // Car c"est JavaFX App Thread qui gère le start().
        // Si on veut faire des actions qui prennent du temps il ne faut pas les faire au niveau de ce Thread
        // Donc on créé un new Thread que l'on démarre
        Stage otherStage = new Stage();
        otherStage.setTitle("une autre fenetre");
        otherStage.setWidth(200);
        otherStage.setHeight(150);
        otherStage.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                otherStage.close();

            }
        });




        System.out.println(Thread.currentThread().getName());


    }

    public static void main(String[] args) {
        HelloApplication.launch(args);
    }
}