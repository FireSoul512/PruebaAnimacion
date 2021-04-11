package sample.Compilacion;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class Triangulo extends Polygon{
    private Timeline timeline = null;
    private double lienzoX;
    private double lienzoY;
    private double speed = 1;

    public Triangulo(int x, int y, int base, int altura, double lienzoX, double lienzoY){
        this.getPoints().addAll(new Double[]{
                -50.0, 40.0, 50.0, 40.0, 0.0, -60.0
        });
        this.lienzoX=lienzoX;
        this.lienzoY=lienzoY;
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.setScaleX((double)base/100);
        this.setScaleY((double) altura/100);
        this.setFill(Color.YELLOW);
        this.setStroke(Color.BLACK);

    }

    public void reboteVertical(int direccion){
        // Arriba 1, Abajo 2 o mas
        if (direccion == 1){
            speed = -1;
        } else {
            speed = 1;
        }
        Triangulo tri = this;
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae){
                        if (tri.getLayoutY() < 0 || tri.getLayoutY() > lienzoY) {
                            speed *= -1;
                        }
                        tri.setLayoutY(tri.getLayoutY() + speed);
                    }
                })
        );
    }

    public void reboteHorizontal(int direccion){
        //Izquierda 1, Derecha 2 o mas
        if (direccion == 1){
            speed = -1;
        } else {
            speed = 1;
        }
        Triangulo tri = this;
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae){
                        if (tri.getLayoutX() < 0 || tri.getLayoutX() > lienzoX) {
                            speed *= -1;
                        }
                        tri.setLayoutX(tri.getLayoutX() + speed);
                    }
                })
        );
    }

    public void animacion(){
        if (timeline == null){
            System.out.println("No hay nada ;v");
        } else {
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        }
    }
}
