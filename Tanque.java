class Tanque{
  private int [] puntosx;
  private int [] puntosy;
  private int nl;
  private boolean disparo;
  private int indxp;
  private int prx;
  private int pry;
  private int dir;
  Tanque(int []arre1, int []arre2,int n,int in,int puntox,int puntoy){
    puntosx=arre1;
    puntosy=arre2;
    nl=n;
    disparo=false;
    indxp=in;
    prx=puntox;
    pry=puntoy;
    dir=90;
  }
  public int getDir(){
    return dir;
  }
  public void derecha(){
    if(dir==90){
      this.rotar90();
      this.rotar90();
      this.rotar90();
    }
    if(dir==180){
      this.rotar90();
      this.rotar90();
    }
    if(dir==270){
      this.rotar90();
    }
    setProtacion(puntosx[1],Math.abs((puntosy[4]-puntosy[1])));
    dir=360;
  }
  public void izquierda(){
    if(dir==90){
      this.rotar90();
    }
    if(dir==270){
      this.rotar90();
      this.rotar90();
      this.rotar90();
    }
    if(dir==360){
      this.rotar90();
      this.rotar90();
    }
    setProtacion(puntosx[1],Math.abs((puntosy[4]-puntosy[1])));
    dir=180;
  }
  public void izquierda(){
    if(dir==90){//componer no esta terminado
      this.rotar90();
    }
    if(dir==270){
      this.rotar90();
      this.rotar90();
      this.rotar90();
    }
    if(dir==360){
      this.rotar90();
      this.rotar90();
    }
    setProtacion(puntosx[1],Math.abs((puntosy[4]-puntosy[1])));
    dir=180;
  }

  public void rotar90(){
    for (int i=0;i<nl;i++) {
      int[] ps=getNewP(puntosx[i]-prx,puntosy[i]-pry);
      puntosx[i]=ps[0]+prx;
      puntosy[i]=ps[1]+pry;
    }

  }

  public void setProtacion(int p,int p2){
    prx=p;
    pry=p2;
  }

  public int[] getNewP(int x,int y){
    int []ps=new int[2];
    ps[0] = -y;
    ps[1]= x;
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
      System.out.println(+puntosx[i]+","+puntosy[i]);
    }
  }


  public static void main(String[] args) {
    int x=0;
    int y=0;
    int [] vx1 = new int[5];
    vx1[0]=100+x;vx1[1]=50+x;vx1[2]=50+x;vx1[3]=150+x;vx1[4]=150+x;
    int [] vy1 = new int[5];
    vy1[0]=50+y;vy1[1]=100+y;vy1[2]=150+y;vy1[3]=150+y;vy1[4]=100+y;
    Tanque player=new Tanque(vx1,vy1,5,0,vx1[0],vy1[1]);
    player.print();
    player.rotar90();
    System.out.println("________");
    player.print();
    player.rotar90();
    System.out.println("________");
    player.print();
    player.rotar90();
    System.out.println("________");
    player.print();




  }

}
