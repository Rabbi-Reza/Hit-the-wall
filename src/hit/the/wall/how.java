 
package hit.the.wall;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

 
public class how extends JFrame{
              Image bulb,hrt; 
    private Image dbImage;
         private Graphics dbg;
         int rectX , rectY;
         public Start start;
         
     Font font4 = new Font("Arial", Font.BOLD | Font.ITALIC , 30);
     
     
     public how(){
         setTitle(" How To Play !!  ");
                  setSize(630,600);
                  setResizable(false);
                  setVisible(true);
                   setBackground(Color.BLACK);
             setLocation(10, 10);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                addMouseMotionListener(new AL());
                
                Image image = new ImageIcon("src/hit/the/wall/resources/images/blub.gif" ).getImage();
                Image imagem = new ImageIcon("src/hit/the/wall/resources/images/hrt.gif" ).getImage();
                
                bulb = image;
                hrt = imagem;
     }
     
        public void paint(Graphics g){
        
        // double Buffer
        dbImage = createImage(getWidth(),getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage,0,0,this);
        
    }

    private void paintComponent(Graphics g) {
        //Write  
        g.setFont(font4);
          
          g.setColor(Color.white);
          
                      g.drawString(" To Complete Every Level , ", 105, 100);
                       g.drawString("  you have to start your journey ", 75, 170);
                        g.drawString(" from the Blue area to Green Area.", 50, 250);
                         g.drawString(" Everytime You hit the wall , ", 88, 320);
                          g.drawString(" Life will reduce. ",200, 370);
                           g.drawString(" You have 4 lives !!",160, 450);
                            g.drawString(" If all 4 life lost ... Then it will Gameover !!",10, 500);
                             g.drawString("  !!!  Enjoy   !!!",385, 570);
                    
                             //Image
                  g.drawImage(bulb, 50, 53, this);
                     g.drawImage(bulb, 490, 54, this);
                      g.drawImage(bulb, 54, 390, this);
                       g.drawImage(hrt, 500, 390, this);
                     
               //Shift main menu              
         Rectangle r1 = new Rectangle(rectX,rectY,2,2);
         Rectangle r2 = new Rectangle(80,530,190,50);
        
          
                g.setColor(Color.RED);
                g.fillRect(r2.x, r2.y, r2.width, r2.height);
                g.setColor(Color.BLUE);
                g.fillRect(r1.x, r1.y, r1.width, r1.height);
                 
                 g.setColor(Color.GREEN);
          g.drawString(" Go to Start",90, 560);
                
             //Collision 
                if(r1.intersects(r2)){
                    
                      new how().setVisible(false);
                       this.dispose();
        
                start = new Start();
                 start.setVisible(true);
              
                
                }
                 
                repaint();
    }
     
      public class AL extends MouseAdapter{
        
      
    @Override
    public void mouseMoved(MouseEvent e) {
        
        rectX = e.getX() ;
        rectY = e.getY() ;
     
        e.consume();
      }
    }
    
}
