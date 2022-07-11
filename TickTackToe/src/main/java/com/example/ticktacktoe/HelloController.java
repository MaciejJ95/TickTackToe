package com.example.ticktacktoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class HelloController {
    private String symbol = "X";

    @FXML
    private GridPane gridBoard;

        protected String[] checkButtons(){
            int i = 0;
            String[] arrayOfSymbols = new String[9];
            for (Node node : gridBoard.getChildren()) {
                if (node instanceof Button) {
                    Button button = (Button) node;
                    arrayOfSymbols[i]=button.getText();
                    i++;
                }
            }
            return arrayOfSymbols;
        }
    @FXML
    protected void onButtonClick(ActionEvent event) {

        if (event.getSource() instanceof Button) {
            Button button = (Button) event.getSource();
            if ("".equals(((Button) event.getSource()).getText())) {
                button.setText(symbol);
                if ("X".equals(symbol)) {
                    symbol = "O";
                } else {
                    symbol = "X";
                }
            }String[] table = checkButtons();
            xWinner(table);
            oWinner(table);
            nobodyWin(table);

        }
    }
    protected void xWinner(String[] arrayOfSymbols){
            if(("X".equals(arrayOfSymbols[0])&&("X".equals(arrayOfSymbols[1]))&&"X".equals(arrayOfSymbols[2]))||
                    ("X".equals(arrayOfSymbols[3])&&("X".equals(arrayOfSymbols[4]))&&"X".equals(arrayOfSymbols[5]))||
                    ("X".equals(arrayOfSymbols[6])&&("X".equals(arrayOfSymbols[7]))&&"X".equals(arrayOfSymbols[8]))||
                    ("X".equals(arrayOfSymbols[0])&&("X".equals(arrayOfSymbols[3]))&&"X".equals(arrayOfSymbols[6]))||
                    ("X".equals(arrayOfSymbols[1])&&("X".equals(arrayOfSymbols[4]))&&"X".equals(arrayOfSymbols[7]))||
                    ("X".equals(arrayOfSymbols[2])&&("X".equals(arrayOfSymbols[5]))&&"X".equals(arrayOfSymbols[8]))||
                    ("X".equals(arrayOfSymbols[0])&&("X".equals(arrayOfSymbols[4]))&&"X".equals(arrayOfSymbols[8]))||
                    ("X".equals(arrayOfSymbols[2])&&("X".equals(arrayOfSymbols[4]))&&"X".equals(arrayOfSymbols[6]))
            )
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Koniec gry");
                alert.setHeaderText("Wygrał X");
                arrayOfSymbols = new String[9];
                alert.showAndWait();
                resetPanel();


            }
    }
    protected boolean oWinner(String[] arrayOfSymbols){
        if(("O".equals(arrayOfSymbols[0])&&("O".equals(arrayOfSymbols[1]))&&"O".equals(arrayOfSymbols[2]))||
                ("O".equals(arrayOfSymbols[3])&&("O".equals(arrayOfSymbols[4]))&&"O".equals(arrayOfSymbols[5]))||
                ("O".equals(arrayOfSymbols[6])&&("O".equals(arrayOfSymbols[7]))&&"O".equals(arrayOfSymbols[8]))||
                ("O".equals(arrayOfSymbols[0])&&("O".equals(arrayOfSymbols[3]))&&"O".equals(arrayOfSymbols[6]))||
                ("O".equals(arrayOfSymbols[1])&&("O".equals(arrayOfSymbols[4]))&&"O".equals(arrayOfSymbols[7]))||
                ("O".equals(arrayOfSymbols[2])&&("O".equals(arrayOfSymbols[5]))&&"O".equals(arrayOfSymbols[8]))||
                ("O".equals(arrayOfSymbols[0])&&("O".equals(arrayOfSymbols[4]))&&"O".equals(arrayOfSymbols[8]))||
                ("O".equals(arrayOfSymbols[2])&&("O".equals(arrayOfSymbols[4]))&&"O".equals(arrayOfSymbols[6]))
        )
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Koniec gry");
            alert.setHeaderText("Wygrał O");
            arrayOfSymbols = new String[9];
            alert.showAndWait();;
            resetPanel();
            return true;
        }return false;
    }
    protected void nobodyWin(String[] arrayOfSymbols){
            if(!("".equals(arrayOfSymbols[0])||("".equals(arrayOfSymbols[1])||("".equals(arrayOfSymbols[2])))||
                    "".equals(arrayOfSymbols[3])||("".equals(arrayOfSymbols[4])||("".equals(arrayOfSymbols[5])))||
                    "".equals(arrayOfSymbols[6])||("".equals(arrayOfSymbols[7])||("".equals(arrayOfSymbols[8]))))){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Koniec gry");
                alert.setHeaderText("Remis");
                arrayOfSymbols = new String[9];
                alert.showAndWait();;
                resetPanel();
            }
    }
    protected void resetPanel(){
        for (Node node : gridBoard.getChildren()) {
            if (node instanceof Button) {
                Button button = (Button) node;
                button.setText("");
            }
        }

    }

}