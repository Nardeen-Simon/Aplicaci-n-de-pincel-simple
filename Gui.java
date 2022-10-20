import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame
{

    Drawing drw = new Drawing();
    JPanel canvas = new JPanel();
    public Gui()
    {
        JMenuBar mb= new JMenuBar();
        JMenu graphicsMenu=new JMenu("File");
        JMenu helpMenu=new JMenu("Help");
        mb.add(graphicsMenu);
        mb.add(helpMenu);
        setJMenuBar(mb);
        JMenuItem item1=new JMenuItem("New");
        JMenuItem item2=new JMenuItem("Need`s help??");
        graphicsMenu.add(item1);
        helpMenu.add(item2);
        item1.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

            }
        });
        setIconImage(new ImageIcon("./images/brushIcon.png").getImage());
        setTitle("Paint Brush");
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        prepareCanvas();
    }

    public void prepareCanvas()
    {
        JLabel name = new JLabel();
        canvas.setLayout(null);
        canvas.setBounds(50,0,600,800);
        canvas.setBackground(Color.LIGHT_GRAY);
        name.setBounds(300,520,300,50);

        toolsPanel();
        drw.setLayout(null);
        drw.setBackground(Color.WHITE);
        drw.setBounds(100,30,600,900);

        canvas.add(name);
        canvas.add(drw);
        add(canvas);
    }

    public void toolsPanel()
    {
        JPanel toolPanel = new JPanel();

        JLabel toolTitle = new JLabel("  Brush Tools");
        JButton pencilBtn = new JButton("Pencil");
        JButton inkBtn = new JButton("Ink");
        JButton OvalBtn = new JButton("Oval");
        JButton RectangleBtn = new JButton("Rectangle");
        JButton eraseBtn = new JButton("Erase");
        JButton clearBtn = new JButton("Clear");

        toolPanel.setLayout(null);
        toolPanel.setBounds(0,0,80,700);
        toolPanel.setBackground(new Color(168, 202, 255));

        toolTitle.setBounds(0,10,80,60);
        pencilBtn.setBounds(0,100,80,100);
        inkBtn.setBounds(0,200,80,100);
        OvalBtn.setBounds(0,300,80,100);
        RectangleBtn.setBounds(0,400,80,100);
        eraseBtn.setBounds(0,500,80,100);
        clearBtn.setBounds(0,600,80,100);


        drw.isPencil = true;
        drw.isOval =true;
        drw.isRect =true;
        drw.isInk = true;
//        drw.isErasing = true;

        pencilBtn.addActionListener((actionEvent)-> {
            System.out.println("Pencil");
            drw.isPencil = true;
            drw.isInk = false;
            drw.isErasing = false;
            drw.isOval = false;
            drw.isRect = false;
        });

        inkBtn.addActionListener((actionEvent)-> {
            System.out.println("Ink");
            drw.drawCircle(10,10);
            drw.isInk = true;
            drw.isPencil = false;
            drw.isErasing = false;
        });
        OvalBtn.addActionListener((actionEvent)-> {
            System.out.println("Oval");
            drw.drawCircle(30,50);
            drw.isPencil = false;
            drw.isInk = false;
            drw.isErasing = false;
            drw.isOval = true;
            drw.isRect = false;
        });
        RectangleBtn.addActionListener((actionEvent)-> {
            System.out.println("Rectangle");
            drw.isPencil = false;
            drw.isInk = false;
            drw.isErasing = false;
            drw.isOval = false;
            drw.isRect = true;
        });
        eraseBtn.addActionListener((actionEvent)-> {
            System.out.println("Erase");
            drw.drawCircle(30,30);
            drw.isInk = false;
            drw.isPencil = false;
            drw.isErasing = true;
            drw.isOval = false;
            drw.isRect = false;
        });
        clearBtn.addActionListener((actionEvent)-> repaint());


        toolPanel.add(toolTitle);
        toolPanel.add(pencilBtn);
        toolPanel.add(inkBtn);
        toolPanel.add(OvalBtn);
        toolPanel.add(RectangleBtn);
        toolPanel.add(eraseBtn);
        toolPanel.add(clearBtn);

        canvas.add(toolPanel);

    }

    public void drawPanel()
    {
        JPanel drawPanel = new JPanel();

        drawPanel.setLayout(null);
        drawPanel.setBounds(100,10,150,150);
        drawPanel.setBackground(Color.WHITE);

        canvas.add(drawPanel);

    }


}
