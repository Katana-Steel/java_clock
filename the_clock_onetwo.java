// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80)
// Source File Name:   the_clock.java

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class the_clock_onetwo implements g_clock
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
    clock_2d clock;

    public the_clock_onetwo()
    {
    }

    private String t()
    {
        Calendar gregoriancalendar = new GregorianCalendar(tz);
        c = (long)gregoriancalendar.get(Calendar.SECOND);
        s = (long)gregoriancalendar.get(Calendar.MINUTE);
        t = (long)gregoriancalendar.get(Calendar.HOUR_OF_DAY);
        int m = gregoriancalendar.get(Calendar.MILLISECOND);
        cl = (double)(t*60*60) + (double)(s*60) + (double)c + ((double)m/1000.0);
        ti = cl / (60*60);
        return (new StringBuilder()).append(t.toString()).append(":").append(s.toString()).append(":").append(c.toString()).append("").toString();
    }

    private void p_rim()
    {
        clock.p_rim(30.0);
    }

    private void draw_clock()
    {
        clock.fastRot = cl * 6.0;
        clock.longRot = s.doubleValue() * 6.0;
        clock.shortRot = ti * 30D;
        clock.draw_clock();
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
        dim.width = dimension.width;
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
        clock = new clock_2d(g, dim);
    }

    public Image getBuffer()
    {
        return buffer;
    }

    public void run()
    {
        g.setBackground(Color.decode(bgc));
        g.setColor(Color.decode(fgc));
        clock.time = t();
        g.clearRect(0, 0, dim.width+5, dim.height);
        p_rim();
        draw_clock();
    }

}
