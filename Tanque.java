class Tanque{
  private int [] puntosx;
  private int [] puntosy;
  private int nl;
  private boolean disparo;
  private int indxp;
  Tanque(int []arre1, int []arre2,int n,int in){
    puntosx=arre1;
    puntosy=arre2;
    nl=n;
    disparo=false;
    indxp=in;
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


  public static void main(String[] args) {
    int [][] ar=new int[2][5];
    ar[0][0]=120;
    ar[1][0]=120;
    ar[0][1]=120;
    ar[1][1]=170;
    ar[0][2]=170;
    ar[1][2]=170;
    ar[0][3]=170;
    ar[1][3]=120;
    ar[0][4]=145;
    ar[1][4]=80;

  }

}
