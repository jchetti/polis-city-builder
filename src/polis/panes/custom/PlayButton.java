package polis.panes.custom;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

public class PlayButton extends Button {

    private final Queue<String> pics;

    public PlayButton() throws FileNotFoundException {
        setMaxSize(50,60);
        setFocusTraversable(false);
        setGraphic(new ImageView(new Image(new FileInputStream("resources/polis/buttons/play.png"))));

        this.pics = new LinkedList<>();
        pics.add("pause.png");
        pics.add("play.png");

        setOnAction(e -> {
            try {
                clicked();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
    }

    public void clicked() throws FileNotFoundException {
        String next = pics.poll();
        setGraphic(new ImageView(new Image(new FileInputStream("resources/polis/buttons/" + next))));
        pics.add(next);
    }

}
