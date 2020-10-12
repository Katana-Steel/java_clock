import java.awt.*;
import java.awt.geom.*;
import java.awt.font.TextLayout;

public class clock_2d {
    Graphics2D g;
    Dimension dim;

    double fastRot;
    double longRot;
    double shortRot;
    double spacing = 0.0;
    String time;

    public clock_2d(Graphics2D gui, Dimension d){
        g = gui;
        dim = d;
    }

    private void DrawHand(double center, double rotation, double length, double start)
    {
        double rx = Math.sin(Math.toRadians(rotation));
        double ry = Math.cos(Math.toRadians(rotation));
        g.draw(new Line2D.Double(
            center + (start * rx),  center - (ry * start),
            center + (rx * length), center - (ry * length)
        ));
    }

    public void p_rim(double sep)
    {
        double width = (double)dim.width - 11;
        double halfWidth = width / 2;
        double center = halfWidth + 5;
        g.draw(new Ellipse2D.Double(5D, 5D, width, width));
        for (double rotation = 0.0D; rotation < 360.0; rotation += sep){
            DrawHand(center, rotation, halfWidth * 0.90, halfWidth * 0.80);
        }
    }

    public void draw_clock()
    {
        double height = (double)dim.height - 40;
        double width = (double)dim.width - 11;
        double halfWidth = width / 2D;
        double center = halfWidth + 5D;
        DrawHand(center, fastRot,  halfWidth * 0.95, halfWidth * spacing);  // second hand
        DrawHand(center, longRot,  halfWidth * 0.90, halfWidth * spacing);  // "long" minute hand
        DrawHand(center, shortRot, halfWidth * 0.60, halfWidth * spacing); // "short" hour hand
        Font font = Font.decode("Courier New-plain-14");
        java.awt.font.FontRenderContext fontrendercontext = g.getFontRenderContext();
        TextLayout textlayout = new TextLayout(time, font, fontrendercontext);
        float f = ((float)(width / 2D) + 5F) - (float)(textlayout.getBounds().getWidth() / 2D);
        textlayout.draw(g, f, (float)(height + 30D));
    }

}
