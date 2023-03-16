
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class main extends JFrame {

    private int[][] field = new int[10][10];
    private JButton[][] cells = new JButton[10][10];
    private int currentPlayer = 1;
    public int lastRow = -1, lastColumn = -1;
    public Border lastBorder;
    public boolean userError = false;
    public boolean possibleMoves = true;

    public main() {
        // Создаем окно с заголовком
        super("Game");

        // Устанавливаем менеджер компоновки для размещения элементов на форме
        setLayout(new GridLayout(10, 10));

        // Создаем ячейки поля и добавляем их на форму
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JButton cell = new JButton("");
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                cell.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
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

                        //восстанавливаем цвет ячейки на базовый
                        lastBorder = BorderFactory.createLineBorder(Color.BLACK);

                        clickedCell.setText(String.valueOf(currentPlayer++));
                        clickedCell.setFont(new Font(null, 1, 15));

//                        }
                        // Проверяем, закончена ли игра
                        if (checkGameOver()) {
                            JOptionPane.showMessageDialog(null, "Игра окончена!");
                            resetGame();
                        }
                    }

                    public void changeCellsValue(boolean reverseExecution) {

                        possibleMoves = false;
                        //указывем новые потенциальные значения
                        changeCellValue(-1, 2, reverseExecution);
                        changeCellValue(-1, -2, reverseExecution);
                        changeCellValue(-2, -1, reverseExecution);
                        changeCellValue(-2, 1, reverseExecution);
                        changeCellValue(1, 2, reverseExecution);
                        changeCellValue(1, -2, reverseExecution);
                        changeCellValue(2, 1, reverseExecution);
                        changeCellValue(2, -1, reverseExecution);

                    }

                    public void changeCellValue(int i, int j, boolean reverseExecution) {
                        if (reverseExecution == false) {

                            if ((lastRow + i >= 0 && lastRow + i <= 9) && (lastColumn + j >= 0 && lastColumn + j <= 9)) {
                                if (cells[lastRow + i][lastColumn + j].getText() == "") {
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

                    //меняем цвет рамки кнопки при наведении на нее мыши
                    @Override
                    public void mouseEntered(MouseEvent e) {

                        JButton movedCell = (JButton) e.getSource();
                        lastBorder = movedCell.getBorder();
                        movedCell.setBorder(BorderFactory.createLineBorder(Color.WHITE));
//                      
//                        
//                        
                    }

                    //возвращаем стандартный цвет рамки
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        JButton movedCell = (JButton) e.getSource();
                        movedCell.setBorder(lastBorder);
                        lastBorder = BorderFactory.createLineBorder(Color.BLACK);

                    }

                    //возвращаем стандартный цвет рамки
                    @Override
                    public void mouseExited(MouseEvent e) {
                        JButton movedCell = (JButton) e.getSource();
                        movedCell.setBorder(lastBorder);
                        lastBorder = BorderFactory.createLineBorder(Color.BLACK);

                    }

                });
                cells[i][j] = cell;
                add(cell);
            }
        }

        // Устанавливаем размер окна и делаем его видимым
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
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
        JOptionPane.showMessageDialog(null, "Выбери любой сектор для начала игры. Твоя задача заполнить все ячейки цифрами");
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(new main(), "Выбери любой сектор для начала игры. Твоя задача заполнить все ячейки цифрами");
    }
}
