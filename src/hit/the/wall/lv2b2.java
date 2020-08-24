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
 

public class lv2b2 extends JFrame implements Runnable {
    
    //private BufferedImage Img;
       public lv3 lv3;
       public Exit exit; 
       public lv2b1 lv2b1;
       public GameOver gameover;
            int x,y,xDirection,yDirection;
         private Image dbImage;
         private Graphics dbg;
            int rectX , rectY, life, flag ,hit,pass;
              Image face1,face2,face,face3,face4 ,hrt;
           
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
            
        }
    }
            
            
           public lv2b2 ()  {
        
               //Load Images
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
                  setTitle(" Level 2 ");
                  setSize(700,600);
                  setResizable(false);
                  setVisible(true);
                   setBackground(Color.cyan);
            
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   setLocation(10, 10);
               addKeyListener(new AL());
               
                 x = 406;
                 y = 392;
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
       
           
          //For main
         Rectangle r1 = new Rectangle(x,y ,10,10);
         // start & end
         Rectangle r2 = new Rectangle(0,530,70,45);
          Rectangle r3 = new Rectangle(0,50,75,50);
            
          //walls
           Rectangle r4 = new Rectangle(0,25,625,25);
            Rectangle r5 = new Rectangle(450,25,300,50);
             Rectangle r6 = new Rectangle(0,120, 200,40);
              Rectangle r7 = new Rectangle(200,175,100,125);
               Rectangle r8 = new Rectangle(450,120,75, 118);
               Rectangle r9 = new Rectangle(425,300,120,70);
                 Rectangle r10 = new Rectangle(350,300, 50,200);
                  Rectangle r11 = new Rectangle(350,280,150,100);
                   Rectangle r12 = new Rectangle(550,133,27,22);
                    Rectangle r13 = new Rectangle(400,100,70,18 );
                     Rectangle r14 = new Rectangle(0,500,455,30);
                      Rectangle r15 = new Rectangle(450,450,170,23);
                       Rectangle r16 = new Rectangle(400,500,200,50);
                        Rectangle r17 = new Rectangle(100,600,500,500);
                         Rectangle r18 = new Rectangle(490,380,220,40);
                          Rectangle r19 = new Rectangle(0,75,15,575);
                            Rectangle r20 = new Rectangle(685,0,15,700);
                             Rectangle r24 = new Rectangle(602,153,27,82);
                              Rectangle r21= new Rectangle(520,230,140 ,8);
                              Rectangle r31= new Rectangle(0,233,427 ,18);
                              //new walls
                               Rectangle r25 = new Rectangle(380,250,27,45);
                                Rectangle r26 = new Rectangle(550,230,27,45);
                                 Rectangle r27 = new Rectangle(540,320,45,30);
                                  Rectangle r28 = new Rectangle(670,260,27,45);
                                   Rectangle r29 = new Rectangle(620,300,27,25);
                                    Rectangle r30 = new Rectangle(320, 70,205, 82);
                                      Rectangle r44= new Rectangle( 0 ,575,725,28);
                             //shifts
                               Rectangle r22= new Rectangle(525,200,30,30);
                                Rectangle r23= new Rectangle( 400 ,380,25,28);
                    
            //wall property
               
                g.setColor(Color.GRAY);
                g.fillRect(r4.x, r4.y, r4.width, r4.height);
                 g.fillRect(r44.x, r44.y, r44.width, r44.height);
                 
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
                                    g.fillRect(r24.x, r24.y, r24.width, r24.height);  
                                     g.fillRect(r25.x, r25.y, r25.width, r25.height);
                                      g.fillRect(r26.x, r26.y, r26.width, r26.height);
                                       g.fillRect(r27.x, r27.y, r27.width, r27.height);
                                        g.fillRect(r28.x, r28.y, r28.width, r28.height);
                                         g.fillRect(r29.x, r29.y, r29.width, r29.height);
                                           g.fillRect(r30.x, r30.y, r30.width, r30.height);
                                           g.fillRect(r31.x, r31.y, r31.width , r31.height);
                        // shift
                                 g.setColor(Color.green);
                                     g.fillRect(r22.x, r22.y, r22.width, r22.height);
                                     g.setColor(Color.blue);
                                 g.fillRect(r23.x, r23.y, r23.width, r23.height);
                 
                     //Start
                 g.setColor(Color.GREEN);
                 g.fillRect(r2.x, r2.y, r2.width, r2.height);
                    //End
                  g.setColor(Color.blue);
                  g.fillRect(r3.x, r3.y, r3.width, r3.height);
                  
                 //Main control
                    g.setColor(Color.RED);
                    g.fillOval(r1.x, r1.y, r1.width, r1.height);
                
              //End
                     g.drawImage(face, 10, 543, this);
               
                     
                if(r1.intersects(r23)){
                     
                     hit =0;
                      if(flag == 1){
                         
                                  //Gameover page
                                      new lv1().setVisible(false);
                                      this.dispose();
        
                                       gameover = new GameOver();
                                       gameover.setVisible(true);
                         
                      }
                     
                      g.setColor(Color.orange);
                     g.setFont(font1);
                     g.drawString(" Go to green Area to finish the level !! ",100, 630); 
                } 
                //shift property
                if(r1.intersects(r2)){
                    
                    new lv2b2().setVisible(false);
                                      this.dispose();
                                      //level 3
        
                                  
                                   lv3 = new lv3();
                                  lv3.setVisible(true);
                                  Thread t1 = new Thread(lv3);
                                  t1.start();
          
                }
                  g.setColor(Color.black);
                 g.drawString("Start  ", 60, 140);
                   g.setColor(Color.green);
                 g.setFont(font);
                 
                g.drawString(" Level 2 ", 373, 135);
                //control this
               
                 
                //Start         
                    g.drawImage(face3, 355, 366, this); 
                  
                    //passed
                   if(r1.intersects(r2)){
                    
                     life = 4;
                     pass = 1;
                                           }
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
                   if(life == 2 ){
                      g.drawImage(hrt, 540, 26, this);
                      g.drawImage(hrt, 620, 26, this);
                       
                  }
                    if(life == 1){
                      g.drawImage(hrt, 580, 26, this);
                    
                  }
                   
                //Collition
                 if(r1.intersects(r44)||r1.intersects(r31)||r1.intersects(r30)||r1.intersects(r21)||r1.intersects(r29)|| r1.intersects(r24) || r1.intersects(r4) || r1.intersects(r5)|| r1.intersects(r6)|| r1.intersects(r7)|| r1.intersects(r8)|| r1.intersects(r9)|| r1.intersects(r10)|| r1.intersects(r11)|| r1.intersects(r12)|| r1.intersects(r13)|| r1.intersects(r14)|| r1.intersects(r15) || r1.intersects(r16)|| r1.intersects(r17)|| r1.intersects(r18)|| r1.intersects(r19)|| r1.intersects(r20)|| r1.intersects(r25) || r1.intersects(r26)|| r1.intersects(r27)|| r1.intersects(r28) ) {
                    
                     if(life == 4 ||life == 1 || life == 3 || life == 2 ){
                         hit = 1 ;
                     }
                           x = 406;
                           y = 392;
                                        life = life - 1;
                    
                     if(life == 0){
                    
                         flag =1;
                               life = 4;
                }    
                     else
                         flag =0;
                   
                }
           
         repaint();
    }
 
}  
