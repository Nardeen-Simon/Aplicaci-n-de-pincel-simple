import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle
{
    int x,y,w,h;

    public Circle(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void setStartPosition(int dx, int dy)
    {
        x = dx - (w/2);
        y = dy - (h/2);
    }

    public void draw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(x,y,w,h);

        g2d.setColor(Color.black);
        g2d.fill(circle);
    }
    public void erasedraw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(x,y,w,h);

        g2d.setColor(Color.white);
        g2d.fill(circle);
    }

}
