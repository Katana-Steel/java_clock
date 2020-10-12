// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80)
// Source File Name:   the_clock.java
import java.awt.*;

public interface g_clock
{
    void setBG(String s1);
    void setFG(String s1);
    public void setLineWidth(float f);
    public void setZone(int h, String zone);

    public void init(Dimension dimension);
    public Image getBuffer();
    public void run();

}
