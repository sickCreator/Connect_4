package com.sajal.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {
    private Controller controller;
    /*public static void main(String[] args){
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }
*/
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("start");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        GridPane rootGridPane = loader.load();
        controller = loader.getController();
        controller.createPlayground();
        MenuBar menuBar=createMenu();
        menuBar.prefWidthProperty().bind(stage.widthProperty());
        Pane menuPane= (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);
        Scene scene = new Scene(rootGridPane);

        stage.setScene(scene);
        stage.setTitle("Connect Four");
        stage.setResizable(false);
        stage.show();
    }

    public MenuBar createMenu(){
        Menu fileMenu=new Menu("File");
        MenuItem newGame=new MenuItem("New Game");
        newGame.setOnAction(actionEvent -> controller.resetGame());
        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        MenuItem restGame=new MenuItem("Reset Game");
        restGame.setOnAction(actionEvent -> controller.resetGame());
        MenuItem exitGame=new MenuItem("Exit Game");
        exitGame.setOnAction(actionEvent -> exitGame());
        fileMenu.getItems().addAll(newGame,restGame,separatorMenuItem,exitGame);
        Menu helpMenu=new Menu("Help");
        MenuItem aboutGame=new MenuItem("About Game");
        SeparatorMenuItem separator=new SeparatorMenuItem();
        MenuItem aboutDev=new MenuItem("About Dev");
        aboutGame.setOnAction(actionEvent -> aboutApp());
        aboutDev.setOnAction(actionEvent -> aboutMe());
        helpMenu.getItems().addAll(aboutGame,aboutDev);
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;

    }

    private void aboutMe() {
        Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("About Developer");
        alertDialog.setHeaderText("Sajal Pathak");
        alertDialog.setContentText("IamLegend");
        alertDialog.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {
    }

    private void aboutApp() {
        Alert alertDialog=new Alert(Alert.AlertType.INFORMATION, "Content here", ButtonType.OK);
        alertDialog.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alertDialog.setTitle("About Connect4");
        alertDialog.setHeaderText("How to Play");
        alertDialog.setContentText("Rules Of The Game"+
                "Connect Four is a two-player connection game" +
                " in which the players first choose a color and then" +
                " take turns dropping colored discs from the top " +
                "into a seven-column, six-row vertically suspended " +
                "grid. The pieces fall straight down, occupying " +
                "the next available space within the column. " +
                "The objective of the game is to be the first " +
                "to form a horizontal, vertical, or diagonal line " +
                "of four of one's own discs. Connect Four is a" +
                " solved game. The first player can always win by" +
                " playing the right moves.");
        alertDialog.show();
        /*ButtonType yesBtn=new ButtonType("Yes");
        ButtonType noBtn=new ButtonType("No");
        alertDialog.getButtonTypes().setAll(yesBtn,noBtn);
        Optional<ButtonType> clickedButton=alertDialog.showAndWait();
        if(clickedButton.isPresent() && clickedButton.get()==yesBtn){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }*/
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }


}
