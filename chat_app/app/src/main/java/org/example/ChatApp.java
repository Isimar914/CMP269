package org.example;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.Socket;
import java.io.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ChatApp extends Application {

    private PrintWriter out;
    private BufferedReader in;
    private Socket socket;
    private String username;
    
    @Override
    public void start(Stage stage) {

        TextArea chTextArea = new TextArea();
        chTextArea.setEditable(false);

        TextField chTextField = new TextField();
        Button sendButton = new Button("Send");

        sendButton.setOnAction(e -> {
            String message = chTextField.getText();
            out.println(message);

            if (message.equalsIgnoreCase("Quit")) {
                Platform.exit();
            }

            chTextField.clear();
        });

        chTextField.setOnAction(e -> sendButton.fire());

        HBox bottomBox = new HBox(chTextField, sendButton);

        BorderPane root = new BorderPane();
        root.setCenter(chTextArea);
        root.setBottom(bottomBox);

        Scene scene = new Scene(root, 400, 250);

        stage.setTitle("Chat Client");
        stage.setScene(scene);

        try {
            socket = new Socket("localhost", 59001);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );

            System.out.println(chTextField.getText());

            // Thread to listen for messages from the server
            new Thread(() -> {
                try {
                    String line;
                    while ((line = in.readLine()) != null) {
                        //System.out.println("GUI received: " + line); //Debugging statement to check incoming messages
                        String message = line;
                        Platform.runLater(() -> chTextArea.appendText(message + "\n"));
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}