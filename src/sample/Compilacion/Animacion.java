package sample.Compilacion;

import java.util.Observable;

public class Animacion extends Observable implements Runnable {

    @Override
    public void run() {
        try{
            while (true){
                this.setChanged();
                this.notifyObservers();
                Thread.sleep(170);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
