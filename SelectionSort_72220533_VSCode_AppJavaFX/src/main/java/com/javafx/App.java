package com.javafx;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos; 
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    final Text sceneTitle = new Text("Pengurutan Metode Selection Sort");
    final Text idText = new Text("Dibuat oleh: \nPatrik Kurniawan Saputra-72220533\nYogyakarta, 17 April 2023");
    final Label inputLabel = new Label("Masukkan data (int)");
    final Label availLabel = new Label("Banyaknya elemen yang tersedia");
    final Label filledLabel = new Label("Banyaknya elemen yang terisi");
    final Label isiLabel = new Label("Isi Array");
    final TextField inputTextField = new TextField();
    final TextField availTextField = new TextField();
    final TextField filledTextField = new TextField();
    final TextField isiTextField = new TextField();
    final TextArea processTextArea = new TextArea();
    final Button inpButton = new Button("Masukkan ke Array");
    final Button btnProcess = new Button("Process Selection Sort");
    final Button btnClose = new Button("Close");
    final HBox closeBox = new HBox();

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Selection Sort");
        GridPane grid = new GridPane();
        grid.add(sceneTitle, 0, 0, 4, 1);
        grid.add(inputLabel, 0, 1, 2, 1);
        grid.add(inputTextField, 2, 1);
        inputTextField.setMaxWidth(50);
        grid.add(inpButton, 3, 1);
        grid.add(availLabel, 0, 2, 2, 1);
        grid.add(availTextField, 2, 2);
        availTextField.setMaxWidth(50);
        grid.add(filledLabel, 0, 3, 2, 1);
        grid.add(filledTextField, 2, 3);
        filledTextField.setMaxWidth(50);
        grid.add(isiLabel, 0, 4);
        grid.add(isiTextField, 1, 4, 3, 1);
        isiTextField.setMinWidth(400);
        grid.add(btnProcess, 0, 5, 2, 1);
        grid.add(processTextArea, 0, 6, 4, 1);
        processTextArea.setMinHeight(250);
        closeBox.getChildren().addAll(btnClose);
        closeBox.setAlignment(Pos.CENTER_RIGHT);
        grid.add(closeBox,3,7);
        grid.add(idText,0,7,2,1);
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setPadding(new Insets(10,5,5,5));
        sceneTitle.setFont(Font.font("Arial Rounded MT Bold", FontWeight.BOLD,20));
        Selection data = new Selection(10);
        inpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                data.addData(Integer.parseInt(inputTextField.getText()));
                availTextField.setText(Integer.toString(data.getMaxElement()));
                filledTextField.setText(Integer.toString(data.getJumlah()));
                isiTextField.setText(data.getData());
                processTextArea.setText(data.getProses());
                inputTextField.clear();
                inputTextField.requestFocus();
            }
        }); 

        btnProcess.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                data.selectionSort();
                processTextArea.setText(data.getProses());
            }
        });

        btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                System.exit(0);
            }
        });

        //grid.setGridLinseVisible(true);
        Scene scene = new Scene(grid,500,500);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}