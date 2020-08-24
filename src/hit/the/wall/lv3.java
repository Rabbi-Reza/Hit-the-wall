 
 
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
 

public class lv3 extends JFrame implements Runnable {
   
    final static float WINDOW_WIDTH = 300;
 
    final static float WINDOW_HEIGHT = 180;
    private float x1 =  WINDOW_WIDTH / 2;
 
    private float y1 =  WINDOW_HEIGHT / 2;
 
    private float xVelocity1 = -4;
 
    private float yVelocity1 = 4;
 
    private float size1 = 5;
 
    //private int playerScore = 0;
   // private int computerScore = 0;
   
    //private BufferedImage Img;
    
        public Start start;
        public GameOver gameover;
        public lv3 lv3;
         public Exit exit;
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
         
        
          public void update() {
 
        x1 = x1 + xVelocity1;
 
        y1 = y1 + yVelocity1;
 
        if (x1 < 0) {
 
            xVelocity1 = (float) .51;
 
            //computerScore = computerScore + 1;
 
        } else if (x1 + size1 >  WINDOW_WIDTH - 6) {
 
            xVelocity1 = (float) -.61;
 
            //playerScore = playerScore + 1;
 
        }
 
       if (y1 < 0) {
 
            yVelocity1 = (float) .41;
 
        } else if (y1 + size1 >  WINDOW_HEIGHT - 6) {
 
            yVelocity1 =    (float) -0.5;
 
        }
  
    }
            
            
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
            
            
           public lv3 ()  {
                
         
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
                  setTitle(" Level 3 ");
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
      private void reverseDirection() {
 
        xVelocity1 = -xVelocity1;
 
    }
 
 
 
    private void reverseDirectionY() {
 
        yVelocity1 = -yVelocity1;
 
    }      
    
    public void paintComponent(Graphics g){
       update();
         
        
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
            Rectangle r5 = new Rectangle(450,25,300,50);
             Rectangle r6 = new Rectangle(0,100,550,50);
              Rectangle r7 = new Rectangle(150,75,100,25);
               Rectangle r8 = new Rectangle(350,175,75,50);
                Rectangle r9 = new Rectangle(525,200,275,50);
                 Rectangle r10 = new Rectangle(300,250,150,200);
                  Rectangle r11 = new Rectangle(450,300,150,100);
                   Rectangle r12 = new Rectangle(125,225,122,122);
                    Rectangle r13 = new Rectangle(0,450,175,80);
                     Rectangle r14 = new Rectangle(250,450,255,80);
                      Rectangle r15 = new Rectangle(600,450,100,80);
                       Rectangle r16 = new Rectangle(0,600,400,50);
                        Rectangle r17 = new Rectangle(440,600,50,50);
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
                    g.setColor(Color.red);
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
                     g.drawString(" Go to green Area       to finish the level !! ",90, 630); 
                 
                } 
                 
                //For Main menu
                  g.setColor(Color.BLACK);
                     g.setFont(font1);
                     g.drawString(" PRESS ' S ' for ",20, 480); 
                     g.drawString(" Start Menu. ",30, 510); 
                //control this
                g.setColor(Color.GREEN);
                g.drawString(" For Moving !! ", 320, 400);
                g.drawImage(face4, 330, 420, this);
                
                
                //lv1 
                     g.setFont(font);
                       g.setColor(Color.green);
                    g.drawString(" Level 3 ", 550, 235);
                    //Start 
                   g.drawImage(face3, 13, 50, this); 
                    //passed
                if(r1.intersects(r2)){
                     
                       //Next level ( lv 2 )
                          new lv1().setVisible(false);
                                      this.dispose();
        
                                  exit = new Exit();
                                  exit.setVisible(true);
                                   
                     
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
            // Moveing      
           g.setColor(Color.gray);
        Rectangle r41 = new Rectangle(300, (int) (y1+100),10,30);
         Rectangle r42 = new Rectangle((int) (y1+100),450, 10,10);
          Rectangle r43 = new Rectangle((int) (y1+450),520, 30,5);
          Rectangle r44 = new Rectangle(530, (int) (y1+118),10,30);
          Rectangle r45 = new Rectangle((int) (y1  ),320, 70,10);
          Rectangle r46 = new Rectangle(390, (int) (y1+500),7,30);
          Rectangle r47 = new Rectangle((int) (y1+510),350, 20,9);
          Rectangle r48 = new Rectangle(220, (int) (y1+600),17,30);
          Rectangle r49 = new Rectangle(440, (int) (y1+500),7,30);
          
        g.fillRect(r41.x, r41.y, r41.width, r41.height);
        g.fillRect(r42.x, r42.y, r42.width, r42.height);
          g.fillRect(r43.x, r43.y, r43.width, r43.height);
          g.fillRect(r44.x, r44.y, r44.width, r44.height);
           g.fillRect(r45.x, r45.y, r45.width, r45.height);
             g.fillRect(r46.x, r46.y, r46.width, r46.height);
             g.fillRect(r47.x, r47.y, r47.width, r47.height);
               g.fillRect(r48.x, r48.y, r48.width, r48.height);
                 g.fillRect(r49.x, r49.y, r49.width, r49.height);
                  
                //Collition
                 if(r1.intersects(r4)|| r1.intersects(r41)|| r1.intersects(r42)|| r1.intersects(r43)|| r1.intersects(r44)|| r1.intersects(r45) || r1.intersects(r46) ||r1.intersects(r47)|| r1.intersects(r48)||r1.intersects(r49)|| r1.intersects(r5)|| r1.intersects(r6)|| r1.intersects(r7)|| r1.intersects(r8)|| r1.intersects(r9)|| r1.intersects(r10)|| r1.intersects(r11)|| r1.intersects(r12)|| r1.intersects(r13)|| r1.intersects(r14)|| r1.intersects(r15) || r1.intersects(r16)|| r1.intersects(r17)|| r1.intersects(r18)|| r1.intersects(r19)|| r1.intersects(r20)|| r1.intersects(r21) ) {
                    
                     if(life == 4 || life == 1 || life == 3 || life == 2 ){
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
 
    
     public int getX() {
 
        return (int) x1;
 
    }
 
    public int getY() {
 
        return (int) y1;
 
    }
    
 
}  
      
 
