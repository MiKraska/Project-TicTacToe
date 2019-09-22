package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    static GameBoardTile[] board = new GameBoardTile[9];
    private static int boardState;

    @Override
    public void start(Stage stage) {
        BorderPane window = new BorderPane();

        GridPane pane = new GridPane();
        for (int i = 0; i < board.length; i++) {
            board[i] = new GameBoardTile();
            pane.add(board[i].getButton(), i / 3, i % 3);
        }

        window.setCenter(pane);
        stage.setScene(new Scene(window));
        stage.setTitle("Tic Tac Toe");
        stage.show();
    }

    private static boolean checkIfGameEnded() {
        return boardState >= 8;
    }

    static void increaseBoardState() {
        boardState++;
    }

    static boolean checkBoardState() {
        if (board[0].getButton().getText().equals(board[3].getButton().getText())
                && board[0].getButton().getText().equals(board[6].getButton().getText())
                && !board[0].getButton().getText().isEmpty()) {
            gameEnd((board[0].getButton().getText()));
            return true;
        } else if (board[1].getButton().getText().equals(board[4].getButton().getText())
                && board[1].getButton().getText().equals(board[7].getButton().getText())
                && !board[1].getButton().getText().isEmpty()) {
            gameEnd((board[1].getButton().getText()));
            return true;
        } else if (board[2].getButton().getText().equals(board[5].getButton().getText())
                && board[2].getButton().getText().equals(board[8].getButton().getText())
                && !board[2].getButton().getText().isEmpty()) {
            gameEnd((board[2].getButton().getText()));
            return true;
        } else if (board[0].getButton().getText().equals(board[1].getButton().getText())
                && board[0].getButton().getText().equals(board[2].getButton().getText())
                && !board[0].getButton().getText().isEmpty()) {
            gameEnd((board[0].getButton().getText()));
            return true;
        } else if (board[3].getButton().getText().equals(board[4].getButton().getText())
                && board[3].getButton().getText().equals(board[5].getButton().getText())
                && !board[3].getButton().getText().isEmpty()) {
            gameEnd((board[3].getButton().getText()));
            return true;
        } else if (board[6].getButton().getText().equals(board[7].getButton().getText())
                && board[6].getButton().getText().equals(board[8].getButton().getText())
                && !board[6].getButton().getText().isEmpty()) {
            gameEnd((board[6].getButton().getText()));
            return true;
        } else if (board[0].getButton().getText().equals(board[4].getButton().getText())
                && board[0].getButton().getText().equals(board[8].getButton().getText())
                && !board[0].getButton().getText().isEmpty()) {
            gameEnd((board[0].getButton().getText()));
            return true;
        } else if (board[2].getButton().getText().equals(board[4].getButton().getText())
                && board[2].getButton().getText().equals(board[6].getButton().getText())
                && !board[2].getButton().getText().isEmpty()) {
            gameEnd((board[2].getButton().getText()));
            return true;
        } else if (checkIfGameEnded()) {
            gameEnd("It's a tie!");
            return true;
        }
        return false;
    }

    private static void gameEnd(String message) {
        if(message.equals("O")){
            message = "Computer won!";
        } else
            message = "You won!";

        for (GameBoardTile gameBoardTile : board) {
            gameBoardTile.getButton().setDisable(true);
        }

        Stage stage = new Stage();
        Label label = new Label(message);
        label.setStyle("-fx-font-weight: bolder;");

        HBox box = new HBox(5);
        box.getChildren().addAll(label);
        box.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(box));
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
