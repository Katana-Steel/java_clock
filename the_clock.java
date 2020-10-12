// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80)
// Source File Name:   the_clock.java

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class the_clock implements g_clock
{

    Graphics2D g;
    BufferedImage buffer;
    Long t;
    Long s;
    Long c;
    double cl;
    double st;
    double ti;
    Dimension dim;
    RenderingHints render;
    private static String bgc = "#BBBBBB";
    private static String fgc = "#000000";
    private static float lw = 1.2F;
    SimpleTimeZone tz;
    clock_2d cl2d;

    public the_clock()
    {
    }

    private String t()
    {
        GregorianCalendar gregoriancalendar = new GregorianCalendar(tz);
        int i = gregoriancalendar.get(GregorianCalendar.HOUR_OF_DAY);
        int j = gregoriancalendar.get(GregorianCalendar.MINUTE);
        int k = gregoriancalendar.get(GregorianCalendar.SECOND);
        int l = gregoriancalendar.get(GregorianCalendar.MILLISECOND);
        cl = (double)(i * 60 * 60) + (double)(j * 60) + (double)k;
        cl += (double)l / 1000.0;
        cl = (cl / 86400.0) * 200000.0;  // convert seconds to 2x 10 "hours" a day
        c = (long)cl % 100;   //  get the clicks
        st = cl / 100D;
        s = (long)st % 100L;  //  get the strokes
        ti = st / 100D;
        t = (long)ti % 20L; // and the ticks
        return (new StringBuilder()).append(t.toString()).append("t:").append(s.toString()).append("s:").append(c.toString()).append("c").toString();
    }

    private void p_rim()
    {
        cl2d.p_rim(36.0);
    }

    private void draw_clock()
    {
        cl2d.fastRot = cl * 3.6;
        cl2d.longRot = s.doubleValue() * 3.6;
        cl2d.shortRot = ti * 36.0;
        cl2d.draw_clock();
    }

    public void setBG(String s1)
    {
        bgc = s1;
    }

    public void setFG(String s1)
    {
        fgc = s1;
    }

    public void setLineWidth(float f)
    {
        lw = f;
        if(g != null)
        {
            g.setStroke(new BasicStroke(lw, 1, 1));
        }
    }

    public void setZone(int h, String zone)
    {
        SimpleTimeZone pdt = new SimpleTimeZone(h*60*60*1000, zone);

        // set up rules for daylight savings time
        pdt.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
        pdt.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
        tz = pdt;
    }

    public void init(Dimension dimension)
    {
        dim = dimension;
        if(buffer != null)
        {
            buffer = null;
            g = null;
            render = null;
        }
        buffer = new BufferedImage(dim.width+5, dim.height, 2);
        g = buffer.createGraphics();
        g.setStroke(new BasicStroke(lw, 1, 1));
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        render.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        render.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        render.put(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        render.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        render.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_DISABLE);
        g.setRenderingHints(render);
        cl2d = new clock_2d(g, dim);
    }

    public Image getBuffer()
    {
        return buffer;
    }

    public void run()
    {
        g.setBackground(Color.decode(bgc));
        g.setColor(Color.decode(fgc));
        cl2d.time = t();
        g.clearRect(0, 0, dim.width+5, dim.height);
        p_rim();
        draw_clock();
    }

}
