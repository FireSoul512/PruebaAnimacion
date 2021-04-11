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
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
        lienzo.prueba(500, 500);
        Triangulo tri = new Triangulo(200, 360, 100, 100);
        Triangulo tri2 = new Triangulo(200, 100, 100, 100);
        lienzo.agregarAlgo(tri);
        lienzo.agregarAlgo(tri2);
        lienzo.agregarAlgo(new Triangulo(200, 300, 100, 100));
        lienzo.agregarAlgo(new Triangulo(300, 300, 100, 100));
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
