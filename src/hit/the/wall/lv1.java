 
package hit.the.wall;

 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
 

public class lv1 extends JFrame implements Runnable {
    
  
    
    //private BufferedImage Img;
    
        public Start start;
        public GameOver gameover;
        public lv2 lv2;
           int x,y,xDirection,yDirection;
           int rectX , rectY, life, flag ,hit,pass ,st;
             private Image dbImage;
             private Graphics dbg;
            
               Image face1,face2,face,face3,face4 ,hrt ;
           
            int size;
            int xVelocity ;
            
              Font font3 = new Font("Arial", Font.BOLD  , 17);
              Font font1 = new Font("Arial", Font.BOLD | Font.ITALIC , 15);  
              Font font4 = new Font("Arial", Font.BOLD | Font.ITALIC , 45); 
              Font font = new Font("Arial", Font.BOLD | Font.ITALIC , 30);
           
            
            
            
             public void run(){
        
        try {
            while(true){
                move();
                
                Thread.sleep(7);
            }
            
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    
    public void move(){
        
        x += xDirection;
        y += yDirection;
       
        //Border
        if(x <= 3)
               x = 3;
        if(x >= 680)
               x = 680;
        if(y <= 25)
                y = 25;
        if(y >= 680)
               y = 680;
        
            
    }
    
    public void setXDirection(int xdir){
        xDirection = xdir; 
    }
     
     public void setYDirection(int ydir){
       yDirection = ydir; 
    }
     
     
    public class AL extends KeyAdapter{
        
        public void keyPressed(KeyEvent e){
            int keyCode = e.getKeyCode();
            
            if (keyCode == e.VK_LEFT){
                
                setXDirection(-1);
                
            }
            if (keyCode == e.VK_RIGHT){
                 
                setXDirection(+1);
            }
            if (keyCode == e.VK_UP){
                
                setYDirection(-1);
            }
            if (keyCode == e.VK_DOWN){
                
                setYDirection(+1);
            }
            
            if (keyCode == e.VK_S){
                
                st = 1;
            }
        }
        
       
        public void keyReleased(KeyEvent e){
             int keyCode = e.getKeyCode();
            
            if (keyCode == e.VK_LEFT){
               setXDirection(0);
            }
            if (keyCode == e.VK_RIGHT){
               setXDirection(0);
            }
            if (keyCode == e.VK_UP){
                setYDirection(0);
            }
            if (keyCode == e.VK_DOWN){
                 setYDirection(0);
            }
            if (keyCode == e.VK_S){
                
                st = 0;
            }
            
        }

        
    }
            
            
           public lv1 ()  {
        
               //Image               
                 Image imagem = new ImageIcon("src/hit/the/wall/resources/images/hrt.gif" ).getImage();
                 Image imagel = new ImageIcon("src/hit/the/wall/resources/images/key.gif" ).getImage();
                 Image imagek = new ImageIcon("src/hit/the/wall/resources/images/arrow.gif" ).getImage();
                 Image imagej = new ImageIcon("src/hit/the/wall/resources/images/here.gif" ).getImage();
                 
                          
                          hrt = imagem;
                         face = imagej ;
                         face3 = imagek ;
                         face4 = imagel ;
             
                  
                    //Life
                     life = 4;
                   //Game Properties
                  setTitle(" Level 1 ");
                  setSize(700,700);
                  setResizable(false);
                  setVisible(true);
                   setBackground(Color.cyan);
                setLocation(10, 10);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
               addKeyListener(new AL());
               
               
               x = 62;
               y = 64;
               flag = 0;
               pass = 0;
               hit = 0;
    }
    @Override
           public void paint(Graphics g){
        
        // double Buffer
        dbImage = createImage(getWidth(),getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage,0,0,this);
        
    }
            
    
    public void paintComponent(Graphics g){
       
            if(st == 1){
        
        new lv1().setVisible(false);
                 this.dispose();
        
                start = new Start();
               start.setVisible(true);
    }
          //For main
         Rectangle r1 = new Rectangle(x,y ,10,10);
         // start & end
         Rectangle r2 = new Rectangle(0,650,70,50);
          Rectangle r3 = new Rectangle(0,25,75,75);
            
          //walls
           Rectangle r4 = new Rectangle(75,25,625,25);
            Rectangle r5 = new Rectangle(450,25,250,50);
             Rectangle r6 = new Rectangle(160,100,300,50);
              Rectangle r7 = new Rectangle(200,25,100,125);
               Rectangle r8 = new Rectangle(250,175,75,50);
                Rectangle r9 = new Rectangle(525,100,275,50);
                 Rectangle r10 = new Rectangle(300,250,150,200);
                  Rectangle r11 = new Rectangle(500,300,150,100);
                   Rectangle r12 = new Rectangle(15,225,222, 22);
                    Rectangle r13 = new Rectangle(0,450,175,80);
                     Rectangle r14 = new Rectangle(180,350,255,80);
                      Rectangle r15 = new Rectangle(200,480,400,40);
                       Rectangle r16 = new Rectangle(0,600,300,50);
                        Rectangle r17 = new Rectangle(340,600,90,50);
                         Rectangle r18 = new Rectangle(490,580,220,180);
                          Rectangle r19 = new Rectangle(0,75,15,575);
                            Rectangle r20 = new Rectangle(685,0,15,700);
                             Rectangle r21= new Rectangle(80,125,75,50);
                              
      
            //wall property
               
                g.setColor(Color.GRAY);
                g.fillRect(r4.x, r4.y, r4.width, r4.height);
                 g.fillRect(r5.x, r5.y, r5.width, r5.height);
                  g.fillRect(r6.x, r6.y, r6.width, r6.height);
                   g.fillRect(r7.x, r7.y, r7.width, r7.height);
                    g.fillRect(r8.x, r8.y, r8.width, r8.height);
                     g.fillRect(r9.x, r9.y, r9.width, r9.height);
                      g.fillRect(r10.x, r10.y, r10.width, r10.height);
                       g.fillRect(r11.x, r11.y, r11.width, r11.height);
                        g.fillRect(r12.x, r12.y, r12.width, r12.height);
                         g.fillRect(r13.x, r13.y, r13.width, r13.height);
                          g.fillRect(r14.x, r14.y, r14.width, r14.height);
                           g.fillRect(r15.x, r15.y, r15.width, r15.height);
                            g.fillRect(r16.x, r16.y, r16.width, r16.height);
                             g.fillRect(r17.x, r17.y, r17.width, r17.height);
                              g.fillRect(r18.x, r18.y, r18.width, r18.height);
                               g.fillRect(r19.x, r19.y, r19.width, r19.height);
                                g.fillRect(r20.x, r20.y, r20.width, r20.height);
                                 g.fillRect(r21.x, r21.y, r21.width, r21.height);
            
                
                     //Start
                g.setColor(Color.GREEN);
                g.fillRect(r2.x, r2.y, r2.width, r2.height);
                    //End
                 g.setColor(Color.blue);
                 g.fillRect(r3.x, r3.y, r3.width, r3.height);
                 
                 //Main control
                    g.setColor(Color.RED);
                    g.fillOval(r1.x, r1.y, r1.width, r1.height);
                    //end 
                      g.drawImage(face, 10, 660, this);
                    // Hit 
                if(r1.intersects(r3)){
                    
                     hit =0;
                      if(flag == 1){
                             
                                  //Gameover page
                                      new lv1().setVisible(false);
                                      this.dispose();
        
                                       gameover = new GameOver();
                                       gameover.setVisible(true);
                         
                      }
                    g.setColor(Color.magenta);
                     g.setFont(font);
                    g.drawString(" Start ",350, 350);
                      g.setColor(Color.orange);
                     g.setFont(font1);
                     g.drawString(" Go to green Area to finish the level !! ",30, 630); 
                 
                } 
                 
                //For Main menu
                  g.setColor(Color.BLACK);
                     g.setFont(font1);
                     g.drawString(" PRESS ' S ' for ",20, 480); 
                     g.drawString(" Start Menu. ",30, 510); 
                //control this
                g.setColor(Color.GREEN);
                g.drawString(" For Moving !! ", 320, 440);
                g.drawImage(face4, 330, 350, this);
                
                //Start 
                   g.drawImage(face3, 13, 50, this);
                //lv1 
                     g.setFont(font);
                       g.setColor(Color.green);
                    g.drawString(" Level 1 ", 550, 135);
                    
                    //passed
                if(r1.intersects(r2)){
                     
                       //Next level ( lv 2 )
                          new lv1().setVisible(false);
                                      this.dispose();
        
                                  lv2 = new lv2();
                                  lv2.setVisible(true);
                                  Thread t1 = new Thread(lv2);
                                  t1.start();
                     
                     life = 4;
                    
                     pass = 1;
                }
                
 
                  if(pass == 0)  
                  g.drawString(" Life : " + life , 550, 650);
                   if(life ==4 && pass == 0){
                      g.drawImage(hrt, 460, 26, this);
                      g.drawImage(hrt, 520, 26, this);
                      g.drawImage(hrt, 580, 26, this);
                      g.drawImage(hrt, 640, 26, this);
                  }
                  if(life ==3 && pass == 0){
                      g.drawImage(hrt, 520, 26, this);
                      g.drawImage(hrt, 580, 26, this);
                      g.drawImage(hrt, 640, 26, this);
                  }
                   if(life ==2 ){
                      g.drawImage(hrt, 540, 26, this);
                      g.drawImage(hrt, 620, 26, this);
                       
                  }
                    if(life ==1){
                      g.drawImage(hrt, 580, 26, this);
                    
                  }
                  
           
                  
                //Collition
                 if(r1.intersects(r4) || r1.intersects(r5)|| r1.intersects(r6)|| r1.intersects(r7)|| r1.intersects(r8)|| r1.intersects(r9)|| r1.intersects(r10)|| r1.intersects(r11)|| r1.intersects(r12)|| r1.intersects(r13)|| r1.intersects(r14)|| r1.intersects(r15) || r1.intersects(r16)|| r1.intersects(r17)|| r1.intersects(r18)|| r1.intersects(r19)|| r1.intersects(r20)|| r1.intersects(r21) ) {
                    
                     if(life == 4 ||life == 1 || life == 3 || life == 2 ){
                         hit = 1 ;
                                           }
                      
                          x = 62;
                          y = 64;
             
                    life = life - 1;
                    
                     if(life == 0){
                    
                         flag =1;
                        //life = 3;
                }    
                     else
                         flag =0;
                   
                }
           
         repaint();
    }
 
  
}  
      
 
