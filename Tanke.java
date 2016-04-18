import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Random;

public class Tanke extends JFrame{
  AffineTransform identidad;
  private JPanel contentPane;
  private int movx=0;
  private int movy=0;
  private int disx=0;
  private int disy=0;
  private Tanque player;
  public ArrayList<Tanque> enemigos;
  private int direccion=0;
  public MoverEnemigos mov;
  public int getX(){
    return movx;
  }
  public int getY(){
    return movy;
  }

    /**
     * Launch the application.
     */
     private void suma(){

       switch(direccion) {

                         case 1: {
                              player.arriba();
                              //System.out.println("_____________________");
                              //player.print();
                               movy-=5;
                               player.sumarApuntosX(movx);
                               player.sumarApuntosY(movy);
                               movx=0;
                               movy=0;

                               direccion=0;

                               break;
                         }
                         case 2: {
                              player.abajo();
                              //System.out.println("_____________________");
                                 //player.print();
                               movy +=5;
                               player.sumarApuntosX(movx);
                               player.sumarApuntosY(movy);
                               movx=0;
                               movy=0;
                               direccion=0;

                               break;
                         }
                         case 3: {
                              player.izquierda();
                              //System.out.println("_____________________");
                                //player.print();
                               movx -=5;
                               player.sumarApuntosX(movx);
                               player.sumarApuntosY(movy);
                               movx=0;
                               movy=0;
                               direccion=0;

                               break;
                         }
                         case 4: {

                              player.derecha();
                              //System.out.println("_____________________");
                                //player.print();
                               movx +=5;
                               player.sumarApuntosX(movx);
                               player.sumarApuntosY(movy);
                               movx=0;
                               movy=0;
                               direccion=0;

                               break;

                         }
                 }

     }

    public static void main(String[] args) throws InterruptedException{
      Tanke frame = new Tanke();
      frame.setVisible(true);
        while(frame.getX()<800 && frame.getY()<600){
          frame.suma();
          frame.mov.setEnemigos(frame.enemigos);
          frame.repaint();
          Thread.sleep(10);
        }
      }

        public Tanke() {
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setBounds(100, 100, 450, 300);
          contentPane = new JPanel();
          contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
          setContentPane(contentPane);
          contentPane.setLayout(null);
          setBounds(0,0,800,600);
          KeyListener listener = new MyKeyListener();
		      this.addKeyListener(listener);
		      this.setFocusable(true);
          int [] vx1 = new int[5];
          vx1[0]=100;vx1[1]=50;vx1[2]=50;vx1[3]=150;vx1[4]=150;
          int [] vy1 = new int[5];
          vy1[0]=50;vy1[1]=100;vy1[2]=150;vy1[3]=150;vy1[4]=100;
          player=new Tanque(vx1,vy1,5,0);
          enemigos=new ArrayList<Tanque>();
          int [] vx2 = new int[5];
          vx2[0]=400;vx2[1]=350;vx2[2]=350;vx2[3]=450;vx2[4]=450;
          int [] vy2 = new int[5];
          vy2[0]=350;vy2[1]=400;vy2[2]=450;vy2[3]=450;vy2[4]=400;
          Tanque ene1=new Tanque(vx2,vy2,5,0);
          enemigos.add(ene1);
          mov=new MoverEnemigos(enemigos);
          mov.start();

      }
      public void paint (Graphics g){

          Graphics2D g2 = (Graphics2D) g;
          super.paint(g2);

          g2.setColor (Color.blue);
          //g.drawLine (0, 70, 100, 70);
          //g.fillRoundRect(150, 70, 50, 70);
          //g.drawRoundRect (250, 70, 50, 70, 6, 6);
          //g.drawOval (350, 70, 50, 70);

          if(player.getDisparar()==true){
            //System.out.println("disparo");
            Disparo d=new Disparo(player.getElementX(),player.getElementY(),player.getDir(),player);
            player.addDisparo(d);
            g2.fillOval(d.getX(),d.getY(),20,20);
            d.start();
            player.setDisparar(false);

          }
          for (int h=0;h<enemigos.size();h++) {
            if(enemigos.get(h).getDisparar()==true){
              Disparo j=new Disparo(enemigos.get(h).getElementX(),enemigos.get(h).getElementY(),enemigos.get(h).getDir(),enemigos.get(h));
              enemigos.get(h).addDisparo(j);
              g2.fillOval(j.getX(),j.getY(),20,20);
              j.start();
              enemigos.get(h).setDisparar(false);
            }
          }
          if(player.getDisparos().size()>0){
              ArrayList<Disparo> di=player.getDisparos();
              for(int i=0;i<di.size();i++){
                //System.out.println("disparo");
                g2.fillOval(di.get(i).getX(),di.get(i).getY(),20,20);
              }


          }
          for (int m=0;m<enemigos.size();m++ ) {
            if (enemigos.get(m).getDisparos().size()>0) {
              ArrayList<Disparo> di=enemigos.get(m).getDisparos();
              for(int i=0;i<di.size();i++){
                //System.out.println("disparo");
                g2.fillOval(di.get(i).getX(),di.get(i).getY(),20,20);
              }
            }

          }
          //player.setDisparar(false);

          //g2.rotate(Math.toRadians(90.0));
          g2.fillPolygon (player.getPuntosX(),player.getPuntosY(),player.getNL());
          for (int ene=0;ene<enemigos.size();ene ++) {
            Tanque e=enemigos.get(ene);
            //System.out.println("___________________");
            //e.print();
            g2.fillPolygon (e.getPuntosX(),e.getPuntosY(),e.getNL());

          }
          //g.setColor (Color.red);
          //g.fillRect (150, 270, 50, 70);
          //g.fillRoundRect (250, 270, 50, 70, 6, 6);
          //g.fillOval (350, 270, 50, 70);
          //int [] vx2 = {500, 550, 450};
          //int [] vy2 = {270, 320, 320};
          //g.fillPolygon (vx2, vy2, 3);
      }

  public class MyKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_UP){
                 direccion = 1;
             //Presiono flecha abajo
             } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

                 direccion = 2;
             //Presiono flecha izquierda
             } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

                 direccion = 3;
             //Presiono flecha derecha
             } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

                 direccion = 4;
             }
             else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
               player.setDisparar(true);
             }
    }

		@Override
		public void keyReleased(KeyEvent e) {
	}
}

}
