package factoreum;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Build extends MouseAdapter {

    private static Build ourInstance = new Build();

    private static Build single_instance = null;

    public static Build getInstance()
    {
        if (single_instance == null)
            single_instance = new Build();

        return single_instance;
    }

    public Color c2 = new Color(255, 172, 23);
    private TYPE type;
    private Handler handler = Handler.getInstance();
    private GUI gui = GUI.getInstance();
    private int n = 0;

    public static final int[] x = {20,125, 230, 335, 440, 545}, y = {60, 165, 270, 375, 480, 585};

    public void mouseClicked(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (gui.boardField[gui.fx][gui.fy] == -1){
            if (mousePos(mx, my, 665, 130, 265, 35)) {
                handler.addMachine(new Solar(x[gui.fx], y[gui.fy], 20, 1, TYPE.Solar, n));
                gui.boardField[gui.fx][gui.fy] = n;
                n++;
            } else if (mousePos(mx, my, 665, 180, 265, 35)) {
                handler.addMachine(new FuelGen(x[gui.fx], y[gui.fy], 20, 1, TYPE.Fuel, n));
                gui.boardField[gui.fx][gui.fy] = n;
                n++;
            } else if (mousePos(mx, my, 665, 230, 265, 35)) {
                handler.addMachine(new NuclearGen(x[gui.fx], y[gui.fy], 20, 1, TYPE.Nuclear, n));
                gui.boardField[gui.fx][gui.fy] = n;
                n++;
            } else if (mousePos(mx, my, 665, 280, 265, 35)) {
                handler.addMachine(new Miner(x[gui.fx], y[gui.fy], 20, 1, TYPE.Miner, n));
                gui.boardField[gui.fx][gui.fy] = n;
                n++;
            } else if (mousePos(mx, my, 665, 330, 265, 35)) {
                handler.addMachine(new AdvancedMiner(x[gui.fx], y[gui.fy], 20, 1, TYPE.AdvancedMiner, n));
                gui.boardField[gui.fx][gui.fy] = n;
                n++;
            } else if (mousePos(mx, my, 665, 380, 265, 35)) {
                handler.addMachine(new CoolingSystem(x[gui.fx], y[gui.fy], 20, 1, TYPE.Cooler, n));
                gui.boardField[gui.fx][gui.fy] = n;
                n++;
            } else if (mousePos(mx, my, 665, 430, 265, 35)) {
                handler.addMachine(new Crafter(x[gui.fx], y[gui.fy], 20, 1, TYPE.Crafter, n));
                gui.boardField[gui.fx][gui.fy] = n;
                n++;
            }
        }

    }

    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }


    private boolean mousePos(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }

    public void tick() {

    }

    public void render(Graphics gr) {

        gr.setFont(new Font("arial", Font.PLAIN, 20));
        gr.setColor(Color.white);
        gr.drawString("Solar generator",                                   670, 155);
        gr.drawRect(                                                           665, 130, 265, 35);
        gr.drawString("Fuel generator",                                    670, 205);
        gr.drawRect(                                                           665, 180, 265, 35);
        gr.drawString("Nuclear reactor",                                   670, 255);
        gr.drawRect(                                                           665, 230, 265, 35);
        gr.drawString("Miner",                                              670, 305);
        gr.drawRect(                                                           665, 280, 265, 35);
        gr.drawString("Advanced miner",                                    670, 355);
        gr.drawRect(                                                           665, 330, 265, 35);
        gr.drawString("Cooling system",                                   670, 405);
        gr.drawRect(                                                           665, 380, 265, 35);
        gr.drawString("Crafter",                                            670, 455);
        gr.drawRect(                                                           665, 430, 265, 35);

    }

}
