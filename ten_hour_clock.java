// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80)
// Source File Name:   ten_hour_clock.java

import java.awt.*;
import java.awt.event.*;

public class ten_hour_clock extends Panel
    implements Runnable, WindowListener, ComponentListener
{
    private static final long serialVersionUID = 15;
    g_clock clockT;
    boolean ten;
    Thread tt;
    Graphics g;
    Boolean running;
    Boolean suspended;
    static Frame win;
    Dimension di;

    public ten_hour_clock()
    {
        ten = false;
        di = new Dimension(200,230);
    }

    public Dimension getPreferredSize()
    {
        return di;
    }

    public void init()
    {
        init(1,"GMT+1");
    }

    public void init(int h, String z)
    {
        if(ten) clockT = new the_clock();
        else clockT = new the_clock_onetwo();
        clockT.setZone(h,z);
        clockT.init(di);
        g = getGraphics();
        running = Boolean.valueOf(true);
        suspended = Boolean.valueOf(false);
        tt = new Thread(this);
        tt.start();
    }

    public void destroy()
    {
        running = Boolean.valueOf(false);
        clockT = null;
    }

    public void run()
    {
        while(running.booleanValue())
        {
            try
            {
                for(; suspended.booleanValue(); wait()) { }
                try
                {
                    clockT.run();
                    java.awt.Image image = clockT.getBuffer();
                    g.drawImage(image, 0, 0, this);
                }
                catch(NullPointerException nullpointerexception) { }
                catch(IllegalArgumentException illegalargumentexception) { }
                Thread.sleep(0L, 54);
            }
            catch(InterruptedException interruptedexception)
            {
                System.out.println(interruptedexception);
            }
        }
    }

    public void windowClosing(WindowEvent windowevent)
    {
        running = Boolean.valueOf(false);
        suspended = Boolean.valueOf(false);
        Window window = windowevent.getWindow();
        window.setVisible(false);
        window.dispose();
        clockT = null;
        System.exit(0);
    }

    public void cmdl(String as[])
    {
        for(int i = 0; i < as.length; i++)
        {
            if(as[i].equals(new String("-f")))
            {
                if(as.length > i + 1)
                {
                    String s = as[++i];
                    clockT.setFG(s);
                } else
                {
                    System.out.println("-f needs a value");
                }
                continue;
            }
            if(as[i].equals(new String("-b")))
            {
                if(as.length > i + 1)
                {
                    String s1 = as[++i];
                    clockT.setBG(s1);
                } else
                {
                    System.out.println("-b needs a value");
                }
                continue;
            }
            if(!as[i].equals(new String("-l")))
            {
                continue;
            }
            if(as.length > i + 1)
            {
                String s2 = as[++i];
                Float float1 = Float.parseFloat(s2);
                if(float1 != null)
                {
                    clockT.setLineWidth(float1.floatValue());
                }
            } else
            {
                System.out.println("-l needs a value");
            }
        }

    }

    public void windowDeactivated(WindowEvent windowevent)
    {
    }

    public void windowActivated(WindowEvent windowevent)
    {
    }

    public void windowClosed(WindowEvent windowevent)
    {
        // Window window = windowevent.getWindow();
    }

    public void windowDeiconified(WindowEvent windowevent)
    {
    }

    public void windowIconified(WindowEvent windowevent)
    {
    }

    public void windowOpened(WindowEvent windowevent)
    {
    }

    public void componentResized(ComponentEvent componentevent)
    {
        if(componentevent.getID() == 101)
        {
            clockT.init(di);
        }
    }

    public void componentMoved(ComponentEvent componentevent)
    {
    }

    public void componentShown(ComponentEvent componentevent)
    {
    }

    public void componentHidden(ComponentEvent componentevent)
    {
    }

    private void detect_ten_hour_system(String[] as)
    {
        for(int i = 0; i < as.length; i++)
        {
            if(as[i].equals(new String("-10")))
            {
                ten = true;
                break;
            }
        }
    }

    private static Integer[] get_zones(String[] as)
    {
        String tmp;
        for(int i = 0; i < as.length; i++)
        {
            if(as[i].equals(new String("-z")))
            {
                tmp = as[i+1];
                String[] zones = tmp.split(",");
                int n = zones.length;
                Integer[] r = new Integer[n];
                for(int j=0;j<n;j++)
                {
                    r[j] = Integer.parseInt(zones[j]);
                    r[j] -= j;
                }
                return r;
            }
        }
        Integer[] ret = {1};
        return ret;
    }

    private static boolean usage(String[] as)
    {
        boolean r = false;
        for(int i = 0; i < as.length; i++)
        {
            if(as[i].equals(new String("-?")))
            {
                r = true;
                break;
            }
            if(as[i].equals(new String("--usage")))
            {
                r = true;
                break;
            }
            if(as[i].equals(new String("-h")))
            {
                r = true;
                break;
            }
        }
        if(r)
        {
            System.out.println("by adding either: -? -h or -usage, you got this message:");
            System.out.println("  -f #<rr><gg><bb> \t\tSets the forground color");
            System.out.println("  -b #<rr><gg><bb> \t\tSets the background color");
            System.out.println("  -l <double> \t\t\tSets the line width");
            System.out.println("  -z <int>,<int>,...,<int> \tMakes one clock per number with the number as the timezone.");
            System.out.println("  -10 \t\t\t\tWell see what happens... I mean what could possibly happen.");
        }
        return r;
    }

    public static void main(String args[])
    {
        if(usage(args)) return;
        win = new Frame("Katana's Clock");
        win.setBounds(10, 10, 780, 270);
        ten_hour_clock[] clocks;
        FlowLayout lay = new FlowLayout(FlowLayout.CENTER);
        lay.setVgap(2);
        lay.setHgap(2);
        win.setLayout(lay);
        Integer[] offs = get_zones(args);
        int n = offs.length;
        clocks = new ten_hour_clock[n];
        for(int i=0;i<n;i++) {

            clocks[i] = new ten_hour_clock();
            win.addWindowListener(clocks[i]);
            win.add(clocks[i]);
            clocks[i].detect_ten_hour_system(args);
        }
        win.validate();
        win.setVisible(true);
        for(Integer i=0;i<n;i++) {
            clocks[i].addComponentListener(clocks[i]);
            String z = "GMT";
            Integer iz = i+offs[i];
            if(iz > 0) {
                z += "+" + iz.toString();
            } else if(iz < 0) {
                z += iz.toString();
            }
            System.out.println(z);
            clocks[i].init(iz.intValue(),z);
            clocks[i].cmdl(args);
        }
    }
}
