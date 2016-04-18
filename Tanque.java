import java.util.ArrayList;

public class Tanque{
  private int [] puntosx;
  private int [] puntosy;
  private int nl;
  private boolean disparo;
  private int indxp;
  private int prx;
  private int pry;
  private int dir;
  private ArrayList<Disparo> disparos;
  Tanque(int []arre1, int []arre2,int n,int in){
    puntosx=arre1;
    puntosy=arre2;
    nl=n;
    disparo=false;
    indxp=in;
    setProtacion(Math.abs((puntosx[4]-puntosx[1])),puntosy[1]);
    //Systm.out.println("points rotation: "+prx+","+pry);
    dir=90;
    disparos=new ArrayList<Disparo>();
  }
  public void addDisparo(Disparo di){
    disparos.add(di);
  }
  public void removeDisparo(Disparo di){
    if(disparos.size()>0){
      disparos.remove(di);
    }
  }
  public ArrayList<Disparo> getDisparos(){
    return disparos;
  }
  public int getDir(){
    return dir;
  }
  public void izquierda(){
    //System.out.println("points rotation: "+prx+","+pry);
    if(dir==90){
      this.rotar(270);
    }
    if(dir==180){
      this.rotar(180);
    }
    if(dir==270){
      this.rotar(90);
    }
    setProtacion(puntosx[1],(puntosy[4]+puntosy[1])/2);
    dir=360;
  }
  public void derecha(){
    //System.out.println("points rotation: "+prx+","+pry);
    if(dir==90){
      this.rotar(90);
    }
    if(dir==270){
      this.rotar(270);
    }
    if(dir==360){
      this.rotar(180);
    }
    setProtacion(puntosx[1],(puntosy[4]+puntosy[1])/2);
    dir=180;
  }
  public void arriba(){
    //System.out.println("points rotation: "+prx+","+pry);
    if(dir==180){
      this.rotar(270);
    }
    if(dir==270){
      this.rotar(180);

    }
    if(dir==360){
      this.rotar(90);
    }
    setProtacion((puntosx[4]+puntosx[1])/2,puntosy[1]);
    dir=90;
  }
  public void abajo(){
    //System.out.println("points rotation: "+prx+","+pry);
    if(dir==90){
      this.rotar(180);
    }
    if(dir==180){
      this.rotar(90);
    }
    if(dir==360){
      this.rotar(270);
    }
    setProtacion((puntosx[4]+puntosx[1])/2,puntosy[1]);
    dir=270;
  }

  public void rotar(int ang){
    for (int i=0;i<nl;i++) {
      int[] ps=getNewP(puntosx[i]-prx,puntosy[i]-pry,ang);
      puntosx[i]=ps[0]+prx;
      puntosy[i]=ps[1]+pry;
    }
  }

  public void setProtacion(int p,int p2){
    prx=p;
    pry=p2;
  }

  public int[] getNewP(int x,int y,int a){
    int []ps=new int[2];
    if(a==90){
      ps[0] = -y;
      ps[1]= x;
    }
    if(a==180){
      ps[0] =-x;
      ps[1]=-y;
    }
    if(a==270){
      ps[0] =y;
      ps[1]= -x;
    }

    return ps;
  }

  public int  getElementX(){
    if(indxp<puntosx.length){
            return puntosx[indxp];
    }
    return -1;

  }
  public int  getElementY(){
    if(indxp<puntosy.length){
       return puntosy[indxp];
    }
    return -1;

  }

  public int getPunta(){
    return indxp;
  }

  public boolean getDisparar(){
    return disparo;
  }

  void setDisparar(boolean n){
    disparo=n;
  }
  void sumarApuntosX(int i){
    for (int t=0;t<nl;t++) {
      puntosx[t]=puntosx[t]+i;
    }
  }

  void sumarApuntosY(int i){
    for (int t=0;t<nl;t++) {
      puntosy[t]=puntosy[t]+i;
    }
  }


  public int[] getPuntosX(){
    return puntosx;
  }
  public int[] getPuntosY(){
    return puntosy;
  }
  public int getNL(){
    return nl;
  }
  public void print(){
    for (int i=0;i<nl;i++) {
      System.out.println(+puntosx[i]+","+puntosy[i]+"  "+dir+"  protx:"+prx+" proty:"+pry);
    }
  }


  public static void main(String[] args) {
    int x=0;
    int y=0;
    int [] vx1 = new int[5];
    vx1[0]=100+x;vx1[1]=50+x;vx1[2]=50+x;vx1[3]=150+x;vx1[4]=150+x;
    int [] vy1 = new int[5];
    vy1[0]=50+y;vy1[1]=100+y;vy1[2]=150+y;vy1[3]=150+y;vy1[4]=100+y;
    Tanque player=new Tanque(vx1,vy1,5,0);
    player.print();
    player.derecha();
    System.out.println("________");
    player.print();
    player.abajo();
    System.out.println("________");
    player.print();
    player.izquierda();
    System.out.println("________");
    player.arriba();
    System.out.println("________");
    player.print();




  }

}
