package stackoverflowqa;
import java.applet.Applet;   // runs with appletviewer
import java.awt.*;

public class AppletLine extends Applet{

    private int x1 = 20, y1 = 10;
    private int x2 = 300, y2 = 700;

    @Override
    public void paint(Graphics g) {

        drawLine(x1, y1, x2, y2, g);
        //g.drawLine(x1, y1, x2, y2, g);  

    }

    private void drawPoint(int x, int y, Graphics g) {
        g.drawLine(x,y,x,y);
   }

   @Override
    public void init() {
        this.setSize(500,700);
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
}
