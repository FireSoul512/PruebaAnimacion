package sample.Compilacion;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Cuadrado extends Rectangle {
    private Timeline timeline = null;
    private double lienzoX;
    private double lienzoY;
    private double speed = 1;
    private double speedH = 1;
    private double speedV = 1;

    public Cuadrado(int x, int y, int lado, int lienzoX, int lienzoY){
        this.lienzoX = lienzoX;
        this.lienzoY = lienzoY;
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.setHeight(lado);
        this.setWidth(lado);
        this.setFill(Color.ORANGE);
        this.setStroke(Color.BLACK);
    }

    private String variable;
    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }

    public void diagonal(int horizontal, int vertical){
        //Horizontal: 1 = derecha, 2 = izquierda
        //Vertical: 1 = abajo, 2 arriba
        if (horizontal == 1 && vertical == 1) {
            speedH = 1;
            speedV = 1;
        } else if (horizontal == 1 && vertical > 1){
            speedH = 1;
            speedV = -1;
        } else if (horizontal > 1 && vertical == 1){
            speedH = -1;
            speedV = 1;
        } else {
            speedH = -1;
            speedV = -1;
        }
        Cuadrado tri = this;
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae){
                        if (tri.getLayoutY() < 0 || tri.getLayoutY() > lienzoY || tri.getLayoutX() < 0 || tri.getLayoutX() > lienzoX) {
                            speedH *= -1;
                            speedV *= -1;
                        }
                        tri.setLayoutY(tri.getLayoutY() + speedV);
                        tri.setLayoutX(tri.getLayoutX() + speedH);
                    }
                })
        );
    }

    public void rotacion(int grados){
        this.setRotate(grados);
    }

    public void mover(int x, int y){
        this.setLayoutX(x);
        this.setLayoutY(y);
    }

    public void reboteVertical(int direccion){
        // Arriba 1, Abajo 2 o mas
        if (direccion == 1){
            speed = -1;
        } else {
            speed = 1;
        }
        Cuadrado tri = this;
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
        Cuadrado tri = this;
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

    public void animar(int cruz){
        switch (cruz){
            case 1: animarHorizontal(1); break;
            case 2: animarHorizontal(2); break;
            case 3: animarVertical(1); break;
            case 4: animarVertical(2); break;
        }
    }

    private void animarHorizontal(int direccion){
        if (direccion == 1){
            speed = 1;
        } else {
            speed = -1;
        }
        Cuadrado tri = this;
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae){
                        if (tri.getLayoutX() > 0 && tri.getLayoutX() < lienzoX) {
                            tri.setLayoutX(tri.getLayoutX() + speed);
                        }
                    }
                })
        );
    }

    private void animarVertical(int direccion){
        if (direccion == 1){
            speed = 1;
        } else {
            speed = -1;
        }
        Cuadrado tri = this;
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae){
                        if (tri.getLayoutY() > 0 && tri.getLayoutY() < lienzoY) {
                            tri.setLayoutY(tri.getLayoutY() + speed);
                        }
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
