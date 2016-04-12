class Tanque{
  private int [][] puntos;

  Tanque(int [][] arre){
    puntos=arre;
  }

  public int[][] getPuntos(){
    return puntos;
  }

  public void setPuntos(int [][] arre){
    puntos=arre;
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

    Tanque n=new Tanque(ar);
    int [][]s=n.getPuntos();
    for (int i=0;i<2;i++) {
      for (int j=0;j<5;j++) {
        System.out.print(s[i][j]+" ");
      }
      System.out.println();
    }

  }

}
