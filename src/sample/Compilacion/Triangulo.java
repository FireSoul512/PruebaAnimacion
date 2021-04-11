package sample.Compilacion;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.util.Observable;
import java.util.Observer;

public class Triangulo extends Polygon implements Observer {
    public Triangulo(int x, int y, int base, int altura){
        this.getPoints().addAll(new Double[]{
                -50.0, 40.0, 50.0, 40.0, 0.0, -60.0
        });
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.setScaleX((double)base/100);
        this.setScaleY((double) altura/100);
        this.setFill(Color.YELLOW);
        this.setStroke(Color.BLACK);

    }

    public void animacion(){
        Animacion animacion = new Animacion();
        animacion.addObserver(this);
        new Thread(animacion).start();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (this.getLayoutX() < 500){
            this.setLayoutX(this.getLayoutX()+10);
        }
    }
}
