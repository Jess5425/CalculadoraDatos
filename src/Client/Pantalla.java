package src.Client;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class Pantalla extends JFrame {
    private JPanel PanelVisual = new JPanel();
    private JLabel labelOperation = new JLabel();
    private JLabel LabelResult = new JLabel();
    private JPanel PanelNum = new JPanel();

    //De aquí empieza lo nuevo
    public String cadenaNumeros = "";
    public String operacion = "nula";
    public boolean activado = true;
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;



    public Pantalla(Socket socket) {
        
        this.socket = socket; // Guarda una referencia al socket
        try {
            this.out = new PrintWriter(socket.getOutputStream(), true);
            //this.in = new BufferedReader(new InputStreamReader(socket.getInputStream));
            System.out.println("Se incio");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("error: " + e.getMessage());
        }

    }



    public Pantalla() {
        initComponents();
        setLocationRelativeTo(null);


    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Este es el panel donde salen los resultados y las operaciones que se van haciendo.

        PanelVisual.setBackground(new Color(202, 235, 236));
        PanelVisual.setLayout(new BorderLayout());
        PanelVisual.setPreferredSize(new Dimension(100, 110));

        labelOperation.setFont(new Font("Rockwell", Font.BOLD, 28));
        labelOperation.setForeground(new Color(102, 102, 102));
        labelOperation.setHorizontalAlignment(SwingConstants.RIGHT);
        labelOperation.setText("");

        LabelResult.setFont(new Font("Rockwell", Font.BOLD, 48));
        LabelResult.setHorizontalAlignment(SwingConstants.RIGHT);
        LabelResult.setText("");

        PanelVisual.add(labelOperation, BorderLayout.NORTH);
        PanelVisual.add(LabelResult, BorderLayout.SOUTH);

        add(PanelVisual, BorderLayout.NORTH);

        PanelNum.setBackground(new Color(255, 255, 255));
        PanelNum.setLayout(null);
        PanelNum.setPreferredSize(new Dimension(330, 330));

        add(PanelNum, BorderLayout.CENTER);

        //Botones numericos
        addButton("1", 85, 205, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                addNumber("1");
            }
        });
        addButton("2", 145, 205, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                addNumber("2");
            }
        });
        addButton("3", 205, 205, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber("3");
            }
        });
        addButton("4", 85, 145, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber("4");
            }
        });
        addButton("5", 145, 145, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber("5");
            }
        });
        addButton("6", 205, 145, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber("6");
            }
        });
        addButton("7", 85, 85, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber("7");
            }
        });
        addButton("8", 145, 85, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber("8");
            }
        });
        addButton("9", 205, 85, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber("9");
            }
        });
        addButton("0", 145, 265, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber("0");
            }
        });

        //Botones de operacion
        addButton("+", 25, 25, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                addNumber("+");
            }
        });

        addButton("-", 85, 25, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber("-");
            }
        });
        addButton("/", 145, 25, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber("/");
            }
        });
        addButton("*", 205, 25, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber("*");
            }
        });
        addButton("%", 25, 85, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber("+");
            }
        });
        addButton("#", 25, 145, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber("#");
            }
        });
        addButton("&", 265, 205, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber("&");
            }
        });
        addButton("|", 265, 145, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber("|");
            }
        });
        addButton("~", 265, 85, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber("~");
            }
        });
        addButton("^", 265, 25, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber("^");
            }
        });
        addButton("(", 265, 265, 20, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber("(");
            }
        });
        addButton(")", 287, 265, 20, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber(")");
            }
        });
        addButton("=", 205, 265, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getActionCommand().equals("=")) {
                    String expression = labelOperation.getText();
                    if (out != null) {
                        out.println(expression); // Envía la expresión al servidor
                        try {
                            String result = in.readLine(); // Espera la respuesta del servidor
                            LabelResult.setText(result); // Muestra el resultado
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                addNumber("=");
            }
        });
        addButton(".", 85, 265, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber(".");
            }
        });
        addButton("Sc", 25, 265, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber("Sc");
            }
        });
        addButton("C", 25, 205, 40, 39, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addNumber("C");
            }
        });



        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Pantalla frame = new Pantalla();
            frame.setVisible(true);
        });
    }

    public void addNumber(String digito) {
        labelOperation.setText(labelOperation.getText() + digito);
    }

    public void addButton(String text, int x, int y, int width, int height, ActionListener listener) {
        JButton button = new JButton(text);
        button.setFont(new Font("Rockwell", Font.PLAIN, 18));
        button.setBackground(new Color(210, 241, 233));
        button.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        button.setFocusPainted(false);
        button.setBounds(x, y, width, height);
        button.addActionListener(listener);
        PanelNum.add(button);

        PanelNum.revalidate();
        PanelNum.repaint();

    }
}