package stackoverflowqa;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class LinePanel extends JPanel {
   
    private int x1 = 20, y1 = 10;
    private int x2 = 300, y2 = 700;
    
    // set custom coordinates
    public LinePanel(int x1,int x2,int y1,int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public LinePanel() {
    }
    
    @Override
    public void paint(Graphics g) {

        drawLine(x1, y1, x2, y2, g);
        //g.drawLine(x1, y1, x2, y2, g);  

    }

    private void drawPoint(int x, int y, Graphics g) {
        g.drawLine(x,y,x,y);
   }
    
    private void drawLine(int x1,int y1,int x2,int y2,Graphics g){

        int dx = x2 - x1;
        int dy = y2 - y1;
        int xi = 1;
        int D = 2*dx - dy;
        int x = x1;

        for(int y = y1; y <y2; y++) {
            drawPoint(x,y,g);
            if(D > 0) {
                x = x + xi;
                D = D - 2 * dy;
            }
                D = D + 2 * dx;
            }
        }
        
        public static void run() {
            
                 JFrame frame = new JFrame("Draw a Line");
                frame.add(new LinePanel(100,800,100,800));
                frame.setSize(800,1000);
                frame.setLocationRelativeTo(null); // center frame on screen
                frame.setDefaultCloseOperation(1);
                frame.setVisible(true);
        }
    
}
