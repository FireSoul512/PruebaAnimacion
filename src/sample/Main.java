package sample;

import javafx.application.Application;
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
        Cuadrado cad = new Cuadrado(300, 300, 50, 500, 500);
        Circulo cir = new Circulo(200,200, 50, 500, 500);
        lienzo.agregarFigura(cir);
        cir.reboteVertical(2);
        cad.diagonal(1,1);
        lienzo.agregarFigura(cad);
        lienzo.run();
        cad.animacion();
        cir.animacion();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
