package TacToe;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    public int pole[][] = new int[3][3];

    public ArrayList<Integer> xListCircle = new ArrayList<>();
    public ArrayList<Integer> yListCircle = new ArrayList<>();

    public ArrayList<Integer> xListCross = new ArrayList<>();
    public ArrayList<Integer> yListCross = new ArrayList<>();

    public int player = 1;

    Game() {
        JFrame frame = new JFrame("MyGame");
        JPanel panel = new JPanel();

        frame.setSize(600, 650);

        MouseListener mouseListener = new MouseListener();
        panel.addMouseListener(mouseListener);

        for (int i = 0; i <= pole.length - 1; i++) {
            for (int j = 0; j <= pole[i].length - 1; j++) {
                pole[i][j] = 0;
            }
        }

        frame.add(panel);
        //frame.add(new DrawingLines());
        frame.add(new DrawCircleOnClick());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);

    }

    public static void showArray(int array[][]) {

        String result = "{";

        for (int i = 0; i < array.length; i++) {

            result = result + "{";

            for (int j = 0; j < array[i].length; j++) {

                result = result + array[i][j];
                if (j < array[i].length - 1) {
                    result = result + ", ";
                }

            }
            result = result + "}";
            if (i < array.length - 1) {
                result = result + ", ";
            }

        }
        result = result + "}";
        System.out.println(result);

    }
    
    
    public class DrawCircleOnClick extends JPanel {

        private int x = -1;
        private int y = -1;

        public DrawCircleOnClick() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    x = identifyCell(e.getX());
                    y = identifyCell(e.getY());
                    
                    System.out.println(x);
                    System.out.println(y);

                    pole[y][x] = player;
                    
                    showArray(pole);
                    player = (player==1)?2:1; //меняем игрока при каждом нажатии
                    repaint();
                    
                }
            });
        }

        private int identifyCell(int param) {
            if (param < 200) {
                param = 0;
            } else if (param >= 200 && param < 400) {
                param = 1;
            } else {
                param = 2;
            }

            return param;
        }

        private int identifyCellbyNumber(int param) {
           
            switch (param){
                    case 0: return 100; 
                    case 1: return 300; 
                    case 2: return 500; 
                    default: return -1;
            }
            
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (int i = 0; i <= pole.length - 1; i++) {
                for (int j = 0; j <= pole[i].length - 1; j++) {

                    int param = pole[i][j];
                    y = identifyCellbyNumber(i);
                    x = identifyCellbyNumber(j);
                    if (x >= 0 && y >= 0) {
                        if (param == 1) {
                            g.drawOval(x - 75, y - 75, 150, 150);
                        } else if (param == 2) {
                            g.drawLine(x - 75, y - 75, x + 75, y + 75);
                            g.drawLine(x + 75, y - 75, x - 75, y + 75);
                        }

//                         
                    }

                }

            }

            g.setColor(Color.BLUE);
            g.drawLine(200, 0, 200, 600);
            g.drawLine(400, 0, 400, 600);

            g.drawLine(0, 200, 600, 200);
            g.drawLine(0, 400, 600, 400);

        }

    }

    public static void main(String[] args) {

        Game game = new Game();

    }

    public static class MouseListener extends MouseAdapter {

        private int mouseX;
        private int mouseY;

        @Override
        public void mousePressed(MouseEvent e) {
            int button = e.getButton();
            int x = e.getX();
            int y = e.getY();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            mouseX = e.getX();
            mouseY
                    = e.getY();
        }

        public int getMouseX() {
            return mouseX;
        }

        public int getMouseY() {
            return mouseY;
        }

    }

}
