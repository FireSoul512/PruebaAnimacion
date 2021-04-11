package sample.Compilacion;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Circulo extends Circle {
    public Circulo(int x, int y, int rad){
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.setRadius(rad);
        this.setFill(Color.BLUE);
        this.setStroke(Color.BLACK);
    }

    public void rebotar(){

    }
}
