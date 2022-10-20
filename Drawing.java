import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class Drawing extends JPanel implements MouseMotionListener, MouseListener {

    int mx, my;

    Graphics g;

    BufferedImage offscreen;
    Graphics offscreen_g;

    int x, y, z, q;

    boolean isInk = false, isPencil = false, isErasing = false, isOval=false, isRect=false;

    Circle c1;
    public Drawing() {

        offscreen = new BufferedImage(1000,700,BufferedImage.TYPE_4BYTE_ABGR_PRE);
        offscreen_g = offscreen.getGraphics();

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }


    public void drawCircle(int w, int h)
    {
        c1 = new Circle(x,y,w,h);

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        int nx = e.getX();
        int ny = e.getY();
        x = nx;
        y = ny;

        if(isInk) {
            c1.setStartPosition(x,y);
            c1.draw(offscreen_g);
        }

        if(isPencil) {
            offscreen_g.drawLine(x,y,z,q);
        }
        if(isOval) {
            offscreen_g.drawOval(x,y,z,q);
        }
        if(isRect) {
            offscreen_g.drawRect(x,y,z,q);
        }
        if(isErasing)
        {
            c1.setStartPosition(x,y);
            c1.erasedraw(offscreen_g);
        }
        z = x;
        q = y;

        mx = nx;
        my = ny;
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException ex) {
//            throw new RuntimeException(ex);
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mx = e.getX();
        my = e.getY();

        x = mx;
        y = my;

        offscreen_g = getGraphics();

        z = x;
        q = y;

    }

    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}
}
