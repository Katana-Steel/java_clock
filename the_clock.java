// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80)
// Source File Name:   the_clock.java

import java.awt.*;
import java.awt.font.TextLayout;
import java.awt.geom.*;
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
    String t_ime;
    RenderingHints render;
    private static String bgc = "#BBBBBB";
    private static String fgc = "#000000";
    private static float lw = 1.2F;
    SimpleTimeZone tz;

    public the_clock()
    {
    }

    private String t()
    {
        GregorianCalendar gregoriancalendar = new GregorianCalendar(tz);
        int i = gregoriancalendar.get(11);
        int j = gregoriancalendar.get(12);
        int k = gregoriancalendar.get(13);
        int l = gregoriancalendar.get(14);
        cl = (double)(i * 60 * 60) + (double)(j * 60) + (double)k;
        cl += (double)l / 1000D;
        cl = (cl / 86400D) * 200000D;
        c = new Long((long)cl % 100L);
        st = cl / 100D;
        s = new Long((long)st % 100L);
        ti = st / 100D;
        t = new Long((long)ti % 20L);
        return (new StringBuilder()).append(t.toString()).append("t:").append(s.toString()).append("s:").append(c.toString()).append("c").toString();
    }

    private void p_rim()
    {
        double d = (double)dim.height - 40D;
        double d1 = (double)dim.width - 15D;
        double d2 = d1 / 2D;
        double d3 = d2 + 5D;
        g.draw(new java.awt.geom.Ellipse2D.Double(5D, 5D, d1, d1));
        double d4 = 0.0D;
        g.draw(new java.awt.geom.Line2D.Double(Math.sin(Math.toRadians(d4)) * (d2 * 0.80000000000000004D) + d3, d3 - Math.cos(Math.toRadians(d4)) * (d2 * 0.80000000000000004D), Math.sin(Math.toRadians(d4)) * (d2 * 0.90000000000000002D) + d3, d3 - Math.cos(Math.toRadians(d4)) * (d2 * 0.90000000000000002D)));
        d4 += 36D;
        g.draw(new java.awt.geom.Line2D.Double(Math.sin(Math.toRadians(d4)) * (d2 * 0.80000000000000004D) + d3, d3 - Math.cos(Math.toRadians(d4)) * (d2 * 0.80000000000000004D), Math.sin(Math.toRadians(d4)) * (d2 * 0.90000000000000002D) + d3, d3 - Math.cos(Math.toRadians(d4)) * (d2 * 0.90000000000000002D)));
        d4 += 36D;
        g.draw(new java.awt.geom.Line2D.Double(Math.sin(Math.toRadians(d4)) * (d2 * 0.80000000000000004D) + d3, d3 - Math.cos(Math.toRadians(d4)) * (d2 * 0.80000000000000004D), Math.sin(Math.toRadians(d4)) * (d2 * 0.90000000000000002D) + d3, d3 - Math.cos(Math.toRadians(d4)) * (d2 * 0.90000000000000002D)));
        d4 += 36D;
        g.draw(new java.awt.geom.Line2D.Double(Math.sin(Math.toRadians(d4)) * (d2 * 0.80000000000000004D) + d3, d3 - Math.cos(Math.toRadians(d4)) * (d2 * 0.80000000000000004D), Math.sin(Math.toRadians(d4)) * (d2 * 0.90000000000000002D) + d3, d3 - Math.cos(Math.toRadians(d4)) * (d2 * 0.90000000000000002D)));
        d4 += 36D;
        g.draw(new java.awt.geom.Line2D.Double(Math.sin(Math.toRadians(d4)) * (d2 * 0.80000000000000004D) + d3, d3 - Math.cos(Math.toRadians(d4)) * (d2 * 0.80000000000000004D), Math.sin(Math.toRadians(d4)) * (d2 * 0.90000000000000002D) + d3, d3 - Math.cos(Math.toRadians(d4)) * (d2 * 0.90000000000000002D)));
        d4 += 36D;
        g.draw(new java.awt.geom.Line2D.Double(Math.sin(Math.toRadians(d4)) * (d2 * 0.80000000000000004D) + d3, d3 - Math.cos(Math.toRadians(d4)) * (d2 * 0.80000000000000004D), Math.sin(Math.toRadians(d4)) * (d2 * 0.90000000000000002D) + d3, d3 - Math.cos(Math.toRadians(d4)) * (d2 * 0.90000000000000002D)));
        d4 += 36D;
        g.draw(new java.awt.geom.Line2D.Double(Math.sin(Math.toRadians(d4)) * (d2 * 0.80000000000000004D) + d3, d3 - Math.cos(Math.toRadians(d4)) * (d2 * 0.80000000000000004D), Math.sin(Math.toRadians(d4)) * (d2 * 0.90000000000000002D) + d3, d3 - Math.cos(Math.toRadians(d4)) * (d2 * 0.90000000000000002D)));
        d4 += 36D;
        g.draw(new java.awt.geom.Line2D.Double(Math.sin(Math.toRadians(d4)) * (d2 * 0.80000000000000004D) + d3, d3 - Math.cos(Math.toRadians(d4)) * (d2 * 0.80000000000000004D), Math.sin(Math.toRadians(d4)) * (d2 * 0.90000000000000002D) + d3, d3 - Math.cos(Math.toRadians(d4)) * (d2 * 0.90000000000000002D)));
        d4 += 36D;
        g.draw(new java.awt.geom.Line2D.Double(Math.sin(Math.toRadians(d4)) * (d2 * 0.80000000000000004D) + d3, d3 - Math.cos(Math.toRadians(d4)) * (d2 * 0.80000000000000004D), Math.sin(Math.toRadians(d4)) * (d2 * 0.90000000000000002D) + d3, d3 - Math.cos(Math.toRadians(d4)) * (d2 * 0.90000000000000002D)));
        d4 += 36D;
        g.draw(new java.awt.geom.Line2D.Double(Math.sin(Math.toRadians(d4)) * (d2 * 0.80000000000000004D) + d3, d3 - Math.cos(Math.toRadians(d4)) * (d2 * 0.80000000000000004D), Math.sin(Math.toRadians(d4)) * (d2 * 0.90000000000000002D) + d3, d3 - Math.cos(Math.toRadians(d4)) * (d2 * 0.90000000000000002D)));
    }

    private void draw_clock()
    {
        double d = (double)dim.height - 40;
        double d1 = (double)dim.width - 15;
        double d2 = cl * 3.6;
        double d3 = s.doubleValue() * 3.6;
        double d4 = ti * 36;
        double d5 = d1 / 2;
        double d6 = d5 + 5;
        g.draw(new java.awt.geom.Line2D.Double(d6, d6, Math.sin(Math.toRadians(d3)) * (d5 * 0.90000000000000002D) + d6, d6 - Math.cos(Math.toRadians(d3)) * (d5 * 0.90000000000000002D)));
        g.draw(new java.awt.geom.Line2D.Double(d6, d6, Math.sin(Math.toRadians(d2)) * (d5 * 0.94999999999999996D) + d6, d6 - Math.cos(Math.toRadians(d2)) * (d5 * 0.94999999999999996D)));
        g.draw(new java.awt.geom.Line2D.Double(d6, d6, Math.sin(Math.toRadians(d4)) * (d5 * 0.59999999999999998D) + d6, d6 - Math.cos(Math.toRadians(d4)) * (d5 * 0.59999999999999998D)));
        Font font = Font.decode("Courier New-plain-14");
        java.awt.font.FontRenderContext fontrendercontext = g.getFontRenderContext();
        TextLayout textlayout = new TextLayout(t_ime, font, fontrendercontext);
        float f = ((float)(d1 / 2) + 5) - (float)(textlayout.getBounds().getWidth() / 2);
        textlayout.draw(g, f, (float)(d + 30));
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
    }

    public Image getBuffer()
    {
        return buffer;
    }

    public void run()
    {
        g.setBackground(Color.decode(bgc));
        g.setColor(Color.decode(fgc));
        t_ime = t();
        g.clearRect(0, 0, dim.width+5, dim.height);
        p_rim();
        draw_clock();
    }

}
