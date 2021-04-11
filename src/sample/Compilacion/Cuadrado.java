package sample.Compilacion;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cuadrado extends Rectangle {
    public Cuadrado(int x, int y, int lado){
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.setHeight(lado);
        this.setWidth(lado);
        this.setFill(Color.ORANGE);
        this.setStroke(Color.BLACK);
    }

}
