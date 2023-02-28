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
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RepaintManager;

public class Game {

    public int pole[][] = new int[3][3];
    public int victory[] = {-1, -1, -1};

    private JFrame frame;
    private JLabel lblText;
    private JButton btnClear;
    private JButton btnClear1;

    /**
     * Принимает значения: 1 - нолики, -1 - крестики.
     *
     * Переменная необходима для изменения игрока во время игры
     */
    public int player = 1; //принимает значения 1 - нолики, -1 крестики. Необходимо

    public Game() {
        frame = new JFrame("MyGame");
        frame.setSize(600, 700);

        lblText = new JLabel();

        clearGamePole();

        btnClear = new JButton("Очистить");
        btnClear1 = new JButton("Очистить2");
        
        
        ButtonListener btnListener = new ButtonListener();
        btnClear.addActionListener(btnListener);
        btnClear1.addActionListener(btnListener);
        

        lblText.setBounds(200, 600, 300, 50);
        btnClear.setBounds(50, 600, 120, 50);
        btnClear1.setBounds(250, 600, 120, 50);


        frame.add(btnClear);
        frame.add(btnClear1);
        frame.add(lblText);
        frame.add(new DrawCircleOnClick());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }

    public class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == btnClear) { //Нажатие на кнопку 
                System.out.println(1);
                clearGamePole();
                frame.repaint();
            } else {
                System.out.println("Другая кнопка");
            }

        }
    }

    /**
     * Метод необходим для очистки результатов игры и подготовки поля к новой
     * игре
     */
    public void clearGamePole() {

        //Очищаем игровое поле
        for (int i = 0; i <= pole.length - 1; i++) {
            for (int j = 0; j <= pole[i].length - 1; j++) {
                pole[i][j] = 0;
            }
        }

        //восстанавливаем игрока
        player = 1;

        //Очищаем информацию о победе
        victory[0] = -1;
        victory[1] = -1;
        victory[2] = -1;

        //Восстанавливаем форму
        //frame.repaint();
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

                    pole[y][x] = player; //  записываем значение игрока в массив
                    player *= -1; //меняем игрока при каждом нажатии

                    isEnd();
                    repaint();
                    victoryMessage();

                }
            });
        }

        private void victoryMessage() {

            if (victory[0] > -1) {
                JOptionPane.showMessageDialog(frame, "Выиграли " + ((victory[2] < -2) ? "крестики" : "нолики"));
                lblText.setText("Выиграли " + ((victory[2] < -2) ? "крестики" : "нолики"));
                clearGamePole();
            }

        }

        /**
         * Метод определяет исходя из состояния массива закончена ли игра или
         * нет
         */
        private void isEnd() {

            for (int i = 0; i <= pole.length - 1; i++) {
                int tempSumX = pole[i][0] + pole[i][1] + pole[i][2];
                int tempSumY = pole[0][i] + pole[1][i] + pole[2][i];

                if (tempSumX == 3 || tempSumX == -3) {
                    victory[0] = i;
                    victory[1] = 0;
                    victory[2] = tempSumX;
                    break;
                }

                if (tempSumY == 3 || tempSumY == -3) {
                    victory[0] = i;
                    victory[1] = 1;
                    victory[2] = tempSumY;
                    break;
                }

                int diagonalXY = pole[0][0] + pole[1][1] + pole[2][2];
                int diagonalYX = pole[2][0] + pole[1][1] + pole[0][2];

                if (diagonalXY == 3 || diagonalXY == -3) {
                    victory[0] = i;
                    victory[1] = 2;
                    victory[2] = diagonalXY;
                    break;
                }
                if (diagonalYX == 3 || diagonalYX == -3) {
                    victory[0] = i;
                    victory[1] = 3;
                    victory[2] = diagonalYX;
                    break;
                }

            }
        }

        /**
         * Метод определяет по координатам ячейку в которой необходимо
         * нарисовать объект
         *
         * @param param - принимает значение координат мыши
         * @return возвращает значение колонки илии строки. Нумерация начинается
         * с 0.
         */
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

        /**
         * Метод принимает значение номер колоки или строки игрового поля и
         * возвращает соответствующие им координаты для рисования объекта
         *
         * @param param принимает значение номер колонки или строки. Нумерация
         * начинается с 0
         * @return возвращает значение в пикселях для каждой колонки или строки
         * игрового поля
         */
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

            //определяется положение нолики или крестика в зависимости 
            //от нажатия кноки мыши
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

            //блок рисует сетку на поле
            g.setColor(Color.BLUE);
            g.drawLine(200, 0, 200, 600);
            g.drawLine(400, 0, 400, 600);

            g.drawLine(0, 200, 600, 200);
            g.drawLine(0, 400, 600, 400);

            g.setColor(Color.MAGENTA);
            if (victory[0] > -1) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setStroke(new BasicStroke(5)); // устанавливаем толщину линии в 5 пикселей
                int param = identifyCellbyNumber(victory[0]);

                if (victory[1] == 1) { //выигрышь по вертикали
                    g2d.drawLine(param, 50, param, 550);
                } else if (victory[1] == 0) { //выигрышь по горизонтали
                    g2d.drawLine(50, param, 550, param);
                } else if (victory[1] == 2) { //выигрышь по диагонали слева направа
                    g2d.drawLine(50, 50, 550, 550);
                } else if (victory[1] == 3) { //выигрышь по диагонали справа налево
                    g2d.drawLine(550, 50, 50, 550);
                }

            }

            lblText.setText("Текущий ход: " + ((player == 1) ? "нолики" : "крестики"));
        }

    }

    public static void main(String[] args) {

        Game game = new Game();

    }

//    public static class MouseListener extends MouseAdapter {
//
//        private int mouseX;
//        private int mouseY;
//
////        @Override
////        public void mousePressed(MouseEvent e) {
////            int button = e.getButton();
////            int x = e.getX();
////            int y = e.getY();
////        }
////        @Override
////        public void mouseMoved(MouseEvent e) {
////            mouseX = e.getX();
////            mouseY  = e.getY();
////        }
////
////        public int getMouseX() {
////            return mouseX;
////        }
////
////        public int getMouseY() {
////            return mouseY;
////        }
//    }
}
