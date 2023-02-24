package TacToe;

import java.awt.BasicStroke;
import java.awt.Button;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.RepaintManager;

public class Game {

    public int pole[][] = new int[3][3];
    public int victory[] = {-1, -1, -1};

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

        Button btnClear = new Button("Clear");
        //panel.add(btnClear);

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(1);

                for (int i = 0; i <= pole.length - 1; i++) {
                    for (int j = 0; j <= pole[i].length - 1; j++) {
                        pole[i][j] = 0;
                    }
                }
                frame.repaint();

            }
        });

        btnClear.setBounds(50, 50, 120, 80);

        frame.add(btnClear);

        //frame.add(new DrawingLines());
        frame.add(new DrawCircleOnClick());
        //frame.add(panel);
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

                    pole[y][x] = player;

                    //showArray(pole);
                    player *= -1; //меняем игрока при каждом нажатии
                    gameIsEnd();
                    repaint();
                    victoryMessage();

                }
            });
        }

        private void victoryMessage() {

            if (victory[0] > -1) {
                JOptionPane.showMessageDialog(null, "Выиграли " + ((victory[2] < -2) ? "крестики" : "нолики"));
            }

        }

        private void gameIsEnd() {

            for (int i = 0; i <= pole.length - 1; i++) {
                int tempSumX = pole[i][0] + pole[i][1] + pole[i][2];
                int tempSumY = pole[0][i] + pole[1][i] + pole[2][i];

                if (tempSumX == 3 || tempSumX == -3) {
                    //System.out.println("Выигрышь по горизонтали, " + (i + 1) + " строка. " + ((tempSumX == 3) ? "круги" : "крестики"));
                    victory[0] = i;
                    victory[1] = 0;
                    victory[2] = tempSumX;
                    break;
                }

                if (tempSumY == 3 || tempSumY == -3) {
                    //System.out.println("Выигрышь по вертикали, " + (i + 1) + " столбец. " + ((tempSumY == 3) ? "круги" : "крестики"));
                    victory[0] = i;
                    victory[1] = 1;
                    victory[2] = tempSumY;
                    break;
                }

                int diagonalXY = pole[0][0] + pole[1][1] + pole[2][2];
                int diagonalYX = pole[2][0] + pole[1][1] + pole[0][2];

                if (diagonalXY == 3 || diagonalXY == -3) {
                    //System.out.println("Выигрышь по вертикали, " + (i + 1) + " столбец. " + ((tempSumY == 3) ? "круги" : "крестики"));
                    victory[0] = i;
                    victory[1] = 2;
                    victory[2] = diagonalXY;
                    break;
                }
                if (diagonalYX == 3 || diagonalYX == -3) {
                    //System.out.println("Выигрышь по вертикали, " + (i + 1) + " столбец. " + ((tempSumY == 3) ? "круги" : "крестики"));
                    victory[0] = i;
                    victory[1] = 3;
                    victory[2] = diagonalYX;
                    break;
                }

            }
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

            switch (param) {
                case 0:
                    //System.out.println(1);
                    return 100;
                case 1:
                    return 300;
                case 2:
                    return 500;
                default:
                    return -1;
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
                            g.setColor(Color.RED);
                            g.drawOval(x - 75, y - 75, 150, 150);
                        } else if (param == -1) {
                            g.setColor(Color.BLACK);
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

            g.setColor(Color.MAGENTA);
            if (victory[0] > -1) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setStroke(new BasicStroke(5));
                int param = identifyCellbyNumber(victory[0]);
                //System.out.println(param);
                if (victory[1] == 1) {

                    // устанавливаем толщину линии в 5 пикселей
                    //g2d.drawLine(10, 10, 200, 10); // рисуем линию
                    g2d.drawLine(param, 50, param, 550);

                } else if (victory[1] == 0) {
                    g2d.drawLine(50, param, 550, param);
                } else if (victory[1] == 2) {
                    g2d.drawLine(50, 50, 550, 550);
                } else if (victory[1] == 3) {
                    g2d.drawLine(550, 50, 50, 550);
                }
                victory[0] = -1;
                victory[1] = -1;
                victory[2] = -1;

            }

        }

    }

    public static void main(String[] args) {

        Game game = new Game();

    }

    public static class MouseListener extends MouseAdapter {

        private int mouseX;
        private int mouseY;

//        @Override
//        public void mousePressed(MouseEvent e) {
//            int button = e.getButton();
//            int x = e.getX();
//            int y = e.getY();
//        }
//        @Override
//        public void mouseMoved(MouseEvent e) {
//            mouseX = e.getX();
//            mouseY  = e.getY();
//        }
//
//        public int getMouseX() {
//            return mouseX;
//        }
//
//        public int getMouseY() {
//            return mouseY;
//        }
    }

}
