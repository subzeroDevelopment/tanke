public class Disparo extends Thread{
  private int x;
  private int y;
  private int direccion;
  private Tanque tanque;
  Disparo(int px,int py,int dir,Tanque tan){
    x=px;
    y=py;
    direccion=dir;
    tanque=tan;
  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }

  public void run(){
    try{
    while((x>0 && x<800) && (y>0 && y<600)){
      //System.out.println("Hola desde Hilo");
      if(direccion==90){
        y-=1;
      }
      if(direccion==180){
        x+=1;
      }
      if(direccion==360){
        x-=1;
      }
      if(direccion==270){
        y+=1;
      }
      sleep(10);
    }
    tanque.removeDisparo(this);
  }
  catch (Exception e) {

  }
}

}
