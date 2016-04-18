import java.util.ArrayList;
import java.util.Random;

public class MoverEnemigos extends Thread{
  ArrayList<Tanque> enemigos;
  boolean bandera;
  int movX;
  int movY;
  MoverEnemigos(ArrayList<Tanque> en){
    enemigos=en;
    bandera=true;
    movX=0;
    movY=0;
  }
  public void setEnemigos(ArrayList<Tanque> en){
    enemigos=en;
  }
  @Override
  public void run(){
    try {
      while(bandera){
      Random direc=new Random();

      for (int i=0;i<enemigos.size();i++) {
        int n=direc.nextInt(10);
        System.out.println(n);
        switch (n) {
          case 0:{
            enemigos.get(i).arriba();
            movY=-5;
            movX=0;
            break;
          }
          case 1:{
            enemigos.get(i).abajo();
            movY=5;
            movX=0;
            break;
          }
          case 2:{
            enemigos.get(i).derecha();
            movX=5;
            movY=0;
            break;
          }
          case 3:{
            enemigos.get(i).izquierda();
            movX=-5;
            movY=0;
            break;
          }
          case 4:{
            enemigos.get(i).setDisparar(true);
          }
          case 5:{
            enemigos.get(i).setDisparar(true);
          }
          case 6:{
            enemigos.get(i).setDisparar(true);
          }

    }
    enemigos.get(i).sumarApuntosX(movX);
    enemigos.get(i).sumarApuntosY(movY);

  }
  sleep(500);
}
}
    catch (Exception e) {
      e.printStackTrace();
    }
  }

}
