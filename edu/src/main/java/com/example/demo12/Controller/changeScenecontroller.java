package com.example.demo12.Controller;

import com.example.demo12.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class changeScenecontroller {
    public static void changeMenu(String menu) {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(menu + ".fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.stage.setScene(scene);
        Main.stage.setResizable(false);
        Main.stage.show();
    }


}
