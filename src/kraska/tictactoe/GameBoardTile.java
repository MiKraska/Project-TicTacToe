package kraska.tictactoe;

import javafx.scene.control.Button;

import java.util.Random;

public class GameBoardTile {
    private Button tile = new Button();
    private boolean didCompMoved = false;

    GameBoardTile() {
        int SQUARE_SIZE = 100;
        tile.setMinHeight(SQUARE_SIZE);
        tile.setMinWidth(SQUARE_SIZE);
        tile.setOnMouseClicked(e -> {
            if (tile.getText().isEmpty()) {
                tile.setText("X");
                tile.setStyle("-fx-text-fill: black;");
                Main.increaseBoardState();
                if (!Main.checkBoardState()) {
                    compMove();
                }
            }
        });
    }

    private void compMove() {
        Random random = new Random();
        while (!didCompMoved) {
            int randomButton = random.nextInt(9);
            if (Main.board[randomButton].getButton().getText().isEmpty()) {
                Main.board[randomButton].getButton().setText("O");
                Main.board[randomButton].getButton().setStyle("-fx-text-fill: darkred;");
                Main.checkBoardState();
                Main.increaseBoardState();
                didCompMoved = true;
            }
        }
    }

    Button getButton() {
        return tile;
    }
}
