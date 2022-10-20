import java.awt.*;

public class Line
{
    int x1,x2,y1,y2;

    public Line(int x1, int y1, int x2, int y2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

    }
    public void setStartPosition(int dx, int dy)
    {
        x1 = dx;
        y1 = dy;
    }
    public void moveBy(int dx, int dy)
    {
        x1 += dx;
        y1 += dy;
    }

    public void resizeBy(int dx, int dy)
    {
        x2 += dx;
        y2 += dy;
    }


    public void draw(Graphics g)
    {

        g.drawLine(x1,y1,x2,y2);
        g.setColor(Color.BLACK);
    }
}
