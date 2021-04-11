package sample;

import javafx.application.Application;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import sample.Compilacion.Circulo;
import sample.Compilacion.Cuadrado;
import sample.Compilacion.Lienzo;
import sample.Compilacion.Triangulo;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Lienzo lienzo = new Lienzo();
        lienzo.prueba(500, 500);
        Triangulo tri = new Triangulo(200, 360, 100, 100, 500, 500);
        Triangulo tri2 = new Triangulo(200, 100, 100, 100, 500, 500);
        lienzo.agregarFigura(tri);
        lienzo.agregarFigura(tri2);
        tri2.reboteHorizontal(1);
        tri.reboteVertical(2);
        lienzo.run();
        System.out.println("Entro");
        tri.animacion();
        System.out.println("Entro 2");
        tri2.animacion();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
