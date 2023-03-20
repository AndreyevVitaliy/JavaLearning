package Zehn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.border.Border;

public class main extends JFrame {

    ArrayList<int[]> listOfMoves = new ArrayList<>();
    final private JButton[][] cells = new JButton[10][10];

    private int currentPlayer = 1;
    public int lastRow = -1, lastColumn = -1;
    public Border lastBorder;
    public boolean userError = false;
    public boolean possibleMoves = true;

    public main() {
        // Создаем окно с заголовком
        super("Game");

        setFocusable(true);
        addKeyListener(new FormKeyAdapter());

        // Устанавливаем менеджер компоновки для размещения элементов на форме
        setLayout(new GridLayout(10, 10, 2, 2));

        // Создаем ячейки поля и добавляем их на форму
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JButton cell = new JButton("");
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                //добавляем обработки для обработки событий мыши
                cell.addMouseListener(new ButtonsArrayMouseAdapter());

                //добавляем обработчик для обработки нажатий кнопок клавиатуры
                cell.addKeyListener(new ButtonArrayKeyAdapter());

                //каждую кнопку добавляем в массив
                cells[i][j] = cell;
                add(cell);
            }
        }

        // Устанавливаем размер окна и делаем его видимым
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    class ButtonsArrayMouseAdapter extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            formMousePressed(e);
        }

        //меняем цвет рамки кнопки при наведении на нее мыши
        @Override
        public void mouseEntered(MouseEvent e) {
            formMouseEntered(e);
        }

        //возвращаем стандартный цвет рамки
        @Override
        public void mouseReleased(MouseEvent e) {
            formMouseReleased(e);
        }

        //возвращаем стандартный цвет рамки
        @Override
        public void mouseExited(MouseEvent e) {

            formMouseExited(e);
        }
    }

    class ButtonArrayKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            formKeyPressed(e);
        }
    }

    class FormKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            formKeyPressed(e);
        }
    }

    private void formMousePressed(MouseEvent e) {
        JButton clickedCell = (JButton) e.getSource();
        //проверям состояние ячейки. Она должна быть не пустая и с текстом не черного цвета
        if (!clickedCell.getText().isEmpty()) {
            if (clickedCell.getForeground() != Color.GRAY) {
                return;
            }
        } else {
            if (currentPlayer != 1) {//если начало игры, позволяем поставить первую цифру на пустую ячейку
                userError = true;
                clickedCell.setBorder(BorderFactory.createLineBorder(Color.RED));
                return;//иначе не делаем никаких действий
            }

        }

        //Очищаем ячейки, которые раньше были потенциальными значениями закрашены
        changeCellsValue(true);

        int row = -1, column = -1;
        // Находим координаты кликнутой ячейки
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (cells[i][j] == clickedCell) {
                    row = i;
                    column = j;
                    break;
                }
            }
            if (row >= 0) {
                break;
            }
        }

        //сохраняем значение кнопки, которая была нажата последней
        lastRow = row;
        lastColumn = column;

        //закрашивам потенциально возможные ходы 
        changeCellsValue(false);

        //возвращаем базовые настройки цвета для ячейки 
        lastBorder = BorderFactory.createLineBorder(Color.BLACK);

        clickedCell.setText(String.valueOf(currentPlayer++));
        clickedCell.setForeground(Color.BLACK);

        listOfMoves.add(new int[]{lastRow, lastColumn});

        // Проверяем, закончена ли игра
        if (checkGameOver()) {
            JOptionPane.showMessageDialog(null, "Игра окончена!");
            resetGame();
        }
    }

    private void formMouseEntered(MouseEvent e) {
        JButton movedCell = (JButton) e.getSource();
        lastBorder = movedCell.getBorder();
        movedCell.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }

    private void formMouseExited(MouseEvent e) {
        JButton movedCell = (JButton) e.getSource();
        movedCell.setBorder(lastBorder);
        lastBorder = BorderFactory.createLineBorder(Color.BLACK);
    }

    private void formMouseReleased(MouseEvent e) {
        JButton movedCell = (JButton) e.getSource();
        movedCell.setBorder(lastBorder);
        lastBorder = BorderFactory.createLineBorder(Color.BLACK);
    }

    private void changeCellsValue(boolean reverseExecution) {

        possibleMoves = false;
        //меняем ячейки вокруг в зависимости от состояния хода
        changeCellValue(-1, 2, reverseExecution);
        changeCellValue(-1, -2, reverseExecution);
        changeCellValue(-2, -1, reverseExecution);
        changeCellValue(-2, 1, reverseExecution);
        changeCellValue(1, 2, reverseExecution);
        changeCellValue(1, -2, reverseExecution);
        changeCellValue(2, 1, reverseExecution);
        changeCellValue(2, -1, reverseExecution);

    }

    /**
     * Метод позволяет обрабатывать доступные для хода пользователя ячейки
     *
     * @param i сдвиг по оси Х
     * @param j сдвиг по оси Y
     * @param reverseExecution указывает на варинт работы. true -
     * возвращает за закрашенные ячейки в исходной состоние, false - закрашивает
     * ячейки, которые являются потенциальными ходами пользователя
     */
    private void changeCellValue(int i, int j, boolean reverseExecution) {
        if (reverseExecution == false) {

            if ((lastRow + i >= 0 && lastRow + i <= 9) && (lastColumn + j >= 0 && lastColumn + j <= 9)) {
                if (cells[lastRow + i][lastColumn + j].getText().isEmpty()) {
                    //cells[lastRow + i][lastColumn + j].setBorder(BorderFactory.createLineBorder(Color.GREEN));
                    cells[lastRow + i][lastColumn + j].setText("" + (currentPlayer + 1));
                    cells[lastRow + i][lastColumn + j].setForeground(Color.GRAY);
                    possibleMoves = true;
                }
            }
        } else {
            if ((lastRow + i >= 0 && lastRow + i <= 9) && (lastColumn + j >= 0 && lastColumn + j <= 9)) {
                if (cells[lastRow + i][lastColumn + j].getText().equals("" + (currentPlayer))) {
                    //cells[lastRow + i][lastColumn + j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    cells[lastRow + i][lastColumn + j].setText("");
                    cells[lastRow + i][lastColumn + j].setForeground(Color.BLACK);
                }
            }
        }
    }

    private void formKeyPressed(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_Z:
                makeMoveBack();
            default:
        }
    }

    private void makeMoveBack() {

        //если в списке один ход, его не позволяем менять
        if (listOfMoves.size() == 1) {
            return;
        }

        //получаем индексы предпоследнего хода
        int idxRow = listOfMoves.get(listOfMoves.size() - 1)[0];
        int idxColumn = listOfMoves.get(listOfMoves.size() - 1)[1];

        //очищаем возможные ходы последнего хода
        changeCellsValue(true);

        //возвращаемся на два хода назад и устанавливаем предпослений ход как основной
        lastRow = listOfMoves.get(listOfMoves.size() - 2)[0];
        lastColumn = listOfMoves.get(listOfMoves.size() - 2)[1];

        //получаем значение цифры, которую должны стереть с карты
        int prevNumber = (int) Integer.parseInt(cells[idxRow][idxColumn].getText());

        //уменьшаем значение текущего хода на 1, чтобы вокруг предыдущего 
        //нарисовать новый список возможных ходов
        currentPlayer = prevNumber - 1;
        cells[idxRow][idxColumn].setText("");

        //рисуем вновь список возможных ходов
        changeCellsValue(false);

        //устанавливаем потенциальное значение будущих вариантов ходов
        currentPlayer++;
//        

        //удаляем последний ход из списка ходов
        listOfMoves.remove(listOfMoves.size() - 1);

    }

    // Проверяем, закончена ли игра
    private boolean checkGameOver() {
        boolean returnValue = false;
        if (possibleMoves == false) {
            returnValue = true;
        }
        return returnValue;
    }

    // Сброс игры
    private void resetGame() {
        currentPlayer = 1;
        listOfMoves.clear();
        lastRow = -1; lastColumn = -1;
        lastBorder = null;
        userError = false;
        possibleMoves = true;
        
    }

    public static void main(String[] args) {
        new main();
    }
}
