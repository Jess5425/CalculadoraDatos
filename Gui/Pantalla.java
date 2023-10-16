/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui;

/**
 *
 * @author jessj
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.BevelBorder;



public class Pantalla extends JFrame {

    private JPanel PanelVisual = new JPanel();
    private JLabel labelOperation = new JLabel();
    private JLabel LabelResult = new JLabel();
    private JPanel PanelNum = new JPanel();


    public Pantalla() {
        initComponents();
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
        labelOperation.setText("10+5");

        LabelResult.setFont(new Font("Rockwell", Font.BOLD, 48));
        LabelResult.setHorizontalAlignment(SwingConstants.RIGHT);
        LabelResult.setText("15");

        PanelVisual.add(labelOperation, BorderLayout.NORTH);
        PanelVisual.add(LabelResult, BorderLayout.SOUTH);

        add(PanelVisual, BorderLayout.NORTH);

        PanelNum.setBackground(new Color(255, 255, 255));
        PanelNum.setLayout(null);
        PanelNum.setPreferredSize(new Dimension(330, 330));

        add(PanelNum, BorderLayout.CENTER);

        pack();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Pantalla frame = new Pantalla();
            frame.setVisible(true);
        });
    }



// ... AGREGAR BOTONES


    JButton btnSuma = new JButton("+");{
        btnSuma.setFont(new Font("Rockwell", Font.PLAIN, 18));
        btnSuma.setBackground(new Color(210, 241, 233));
        btnSuma.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
        btnSuma.setBorderPainted(false);
        btnSuma.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        btnSuma.setFocusPainted(false);
        btnSuma.setBounds(25,25,40,39);
        btnSuma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Maneja el evento del botón aquí
            }
        });
        PanelNum.add(btnSuma);

        JButton btnResta = new JButton("-");{
            btnResta.setFont(new Font("Rockwell", Font.PLAIN, 18));
            btnResta.setBackground(new Color(210, 241, 233));
            btnResta.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
            btnResta.setBorderPainted(false);
            btnResta.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            btnResta.setFocusPainted(false);
            btnResta.setBounds(85,25,40,39);
            btnResta.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    // Maneja el evento del botón aquí
                }
            });
            PanelNum.add(btnResta);

            JButton btnDivi = new JButton("/");{
                btnDivi.setFont(new Font("Rockwell", Font.PLAIN, 18));
                btnDivi.setBackground(new Color(210, 241, 233));
                btnDivi.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                btnDivi.setBorderPainted(false);
                btnDivi.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                btnDivi.setFocusPainted(false);
                btnDivi.setBounds(145,25,40,39);
                btnDivi.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        // Maneja el evento del botón aquí
                    }
                });
                PanelNum.add(btnDivi);


                JButton btnMulti = new JButton("*");{
                    btnMulti.setFont(new Font("Rockwell", Font.PLAIN, 18));
                    btnMulti.setBackground(new Color(210, 241, 233));
                    btnMulti.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                    btnMulti.setBorderPainted(false);
                    btnMulti.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    btnMulti.setFocusPainted(false);
                    btnMulti.setBounds(205,25,40,39);
                    btnMulti.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            // Maneja el evento del botón aquí
                        }
                    });
                    PanelNum.add(btnMulti);


                    JButton btnXor = new JButton("Xor");{
                        btnXor.setFont(new Font("Rockwell", Font.PLAIN, 18));
                        btnXor.setBackground(new Color(210, 241, 233));
                        btnXor.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                        btnXor.setBorderPainted(false);
                        btnXor.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        btnXor.setFocusPainted(false);
                        btnXor.setBounds(265,25,40,39);
                        btnXor.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                                // Maneja el evento del botón aquí
                            }
                        });
                        PanelNum.add(btnXor);


                        JButton btn7 = new JButton("7");{
                            btn7.setFont(new Font("Rockwell", Font.PLAIN, 18));
                            btn7.setBackground(new Color(210, 241, 233));
                            btn7.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                            btn7.setBorderPainted(false);
                            btn7.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            btn7.setFocusPainted(false);
                            btn7.setBounds(85,85,40,39);
                            btn7.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent evt) {
                                    // Maneja el evento del botón aquí
                                }
                            });
                            PanelNum.add(btn7);


                            JButton btnPorce = new JButton("%");{
                                btnPorce.setFont(new Font("Rockwell", Font.PLAIN, 18));
                                btnPorce.setBackground(new Color(210, 241, 233));
                                btnPorce.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                                btnPorce.setBorderPainted(false);
                                btnPorce.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                btnPorce.setFocusPainted(false);

                                btnPorce.setBounds(25,85,40,39);
                                btnPorce.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent evt) {
                                        // Maneja el evento del botón aquí
                                    }
                                });
                                PanelNum.add(btnPorce);

                                JButton btn8 = new JButton("8");{
                                    btn8.setFont(new Font("Rockwell", Font.PLAIN, 18));
                                    btn8.setBackground(new Color(210, 241, 233));
                                    btn8.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                                    btn8.setBorderPainted(false);
                                    btn8.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                    btn8.setFocusPainted(false);

                                    btn8.setBounds(145,85,40,39);
                                    btn8.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent evt) {
                                            // Maneja el evento del botón aquí
                                        }
                                    });
                                    PanelNum.add(btn8);

                                    JButton btn9 = new JButton("9");{
                                        btn9.setFont(new Font("Rockwell", Font.PLAIN, 18));
                                        btn9.setBackground(new Color(210, 241, 233));
                                        btn9.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                                        btn9.setBorderPainted(false);
                                        btn9.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                        btn9.setFocusPainted(false);

                                        btn9.setBounds(205,85,40,39);
                                        btn9.addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent evt) {
                                                // Maneja el evento del botón aquí
                                            }
                                        });
                                        PanelNum.add(btn9);

                                        JButton btnNot = new JButton("Not");{
                                            btnNot.setFont(new Font("Rockwell", Font.PLAIN, 18));
                                            btnNot.setBackground(new Color(210, 241, 233));
                                            btnNot.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                                            btnNot.setBorderPainted(false);
                                            btnNot.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                            btnNot.setFocusPainted(false);

                                            btnNot.setBounds(265,85,40,39);
                                            btnNot.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent evt) {
                                                    // Maneja el evento del botón aquí
                                                }
                                            });
                                            PanelNum.add(btnNot);

                                            JButton btnExpo = new JButton("**");{
                                                btnExpo.setFont(new Font("Rockwell", Font.PLAIN, 18));
                                                btnExpo.setBackground(new Color(210, 241, 233));
                                                btnExpo.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                                                btnExpo.setBorderPainted(false);
                                                btnExpo.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                btnExpo.setFocusPainted(false);

                                                btnExpo.setBounds(25,145,40,39);
                                                btnExpo.addActionListener(new ActionListener() {
                                                    public void actionPerformed(ActionEvent evt) {
                                                        // Maneja el evento del botón aquí
                                                    }
                                                });
                                                PanelNum.add(btnExpo);

                                                JButton btn4 = new JButton("4");{
                                                    btn4.setFont(new Font("Rockwell", Font.PLAIN, 18));
                                                    btn4.setBackground(new Color(210, 241, 233));
                                                    btn4.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                                                    btn4.setBorderPainted(false);
                                                    btn4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                    btn4.setFocusPainted(false);

                                                    btn4.setBounds(85,145,40,39);
                                                    btn4.addActionListener(new ActionListener() {
                                                        public void actionPerformed(ActionEvent evt) {
                                                            // Maneja el evento del botón aquí
                                                        }
                                                    });
                                                    PanelNum.add(btn4);

                                                    JButton btn5 = new JButton("5");{
                                                        btn5.setFont(new Font("Rockwell", Font.PLAIN, 18));
                                                        btn5.setBackground(new Color(210, 241, 233));
                                                        btn5.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                                                        btn5.setBorderPainted(false);
                                                        btn5.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                        btn5.setFocusPainted(false);

                                                        btn5.setBounds(145,145,40,39);
                                                        btn5.addActionListener(new ActionListener() {
                                                            public void actionPerformed(ActionEvent evt) {
                                                                // Maneja el evento del botón aquí
                                                            }
                                                        });
                                                        PanelNum.add(btn5);

                                                        JButton btn6 = new JButton("6");{
                                                            btn6.setFont(new Font("Rockwell", Font.PLAIN, 18));
                                                            btn6.setBackground(new Color(210, 241, 233));
                                                            btn6.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                                                            btn6.setBorderPainted(false);
                                                            btn6.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                            btn6.setFocusPainted(false);

                                                            btn6.setBounds(205,145,40,39);
                                                            btn6.addActionListener(new ActionListener() {
                                                                public void actionPerformed(ActionEvent evt) {
                                                                    // Maneja el evento del botón aquí
                                                                }
                                                            });
                                                            PanelNum.add(btn6);


                                                            JButton btnOr = new JButton("Or");{
                                                                btnOr.setFont(new Font("Rockwell", Font.PLAIN, 18));
                                                                btnOr.setBackground(new Color(210, 241, 233));
                                                                btnOr.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                                                                btnOr.setBorderPainted(false);
                                                                btnOr.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                btnOr.setFocusPainted(false);

                                                                btnOr.setBounds(265,145,40,39);
                                                                btnOr.addActionListener(new ActionListener() {
                                                                    public void actionPerformed(ActionEvent evt) {
                                                                        // Maneja el evento del botón aquí
                                                                    }
                                                                });
                                                                PanelNum.add(btnOr);

                                                                JButton btnElim = new JButton("C");{
                                                                    btnElim.setFont(new Font("Rockwell", Font.PLAIN, 18));
                                                                    btnElim.setBackground(new Color(210, 241, 233));
                                                                    btnElim.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                                                                    btnElim.setBorderPainted(false);
                                                                    btnElim.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                    btnElim.setFocusPainted(false);

                                                                    btnElim.setBounds(25,205,40,39);
                                                                    btnElim.addActionListener(new ActionListener() {
                                                                        public void actionPerformed(ActionEvent evt) {
                                                                            // Maneja el evento del botón aquí
                                                                        }
                                                                    });
                                                                    PanelNum.add(btnElim);

                                                                    JButton btn1 = new JButton("1");{
                                                                        btn1.setFont(new Font("Rockwell", Font.PLAIN, 18));
                                                                        btn1.setBackground(new Color(210, 241, 233));
                                                                        btn1.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                                                                        btn1.setBorderPainted(false);
                                                                        btn1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                        btn1.setFocusPainted(false);

                                                                        btn1.setBounds(85,205,40,39);
                                                                        btn1.addActionListener(new ActionListener() {
                                                                            public void actionPerformed(ActionEvent evt) {
                                                                                // Maneja el evento del botón aquí
                                                                            }
                                                                        });
                                                                        PanelNum.add(btn1);

                                                                        JButton btn2 = new JButton("2");{
                                                                            btn2.setFont(new Font("Rockwell", Font.PLAIN, 18));
                                                                            btn2.setBackground(new Color(210, 241, 233));
                                                                            btn2.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                                                                            btn2.setBorderPainted(false);
                                                                            btn2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                            btn2.setFocusPainted(false);

                                                                            btn2.setBounds(145,205,40,39);
                                                                            btn2.addActionListener(new ActionListener() {
                                                                                public void actionPerformed(ActionEvent evt) {
                                                                                    // Maneja el evento del botón aquí
                                                                                }
                                                                            });
                                                                            PanelNum.add(btn2);

                                                                            JButton btn3 = new JButton("3");{
                                                                                btn3.setFont(new Font("Rockwell", Font.PLAIN, 18));
                                                                                btn3.setBackground(new Color(210, 241, 233));
                                                                                btn3.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                                                                                btn3.setBorderPainted(false);
                                                                                btn3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                                btn3.setFocusPainted(false);

                                                                                btn3.setBounds(205,205,40,39);
                                                                                btn3.addActionListener(new ActionListener() {
                                                                                    public void actionPerformed(ActionEvent evt) {
                                                                                        // Maneja el evento del botón aquí
                                                                                    }
                                                                                });
                                                                                PanelNum.add(btn3);

                                                                                JButton btnAnd = new JButton("And");{
                                                                                    btnAnd.setFont(new Font("Rockwell", Font.PLAIN, 18));
                                                                                    btnAnd.setBackground(new Color(210, 241, 233));
                                                                                    btnAnd.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                                                                                    btnAnd.setBorderPainted(false);
                                                                                    btnAnd.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                                    btnAnd.setFocusPainted(false);

                                                                                    btnAnd.setBounds(265,205,40,39);
                                                                                    btnAnd.addActionListener(new ActionListener() {
                                                                                        public void actionPerformed(ActionEvent evt) {
                                                                                            // Maneja el evento del botón aquí
                                                                                        }
                                                                                    });
                                                                                    PanelNum.add(btnAnd);

                                                                                    JButton btnScan = new JButton("Scan");{
                                                                                        btnScan.setFont(new Font("Rockwell", Font.PLAIN, 16));
                                                                                        btnScan.setBackground(new Color(210, 241, 233));
                                                                                        btnScan.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                                                                                        btnScan.setBorderPainted(false);
                                                                                        btnScan.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                                        btnScan.setFocusPainted(false);

                                                                                        btnScan.setBounds(25,265,40,39);
                                                                                        btnScan.addActionListener(new ActionListener() {
                                                                                            public void actionPerformed(ActionEvent evt) {
                                                                                                // Maneja el evento del botón aquí
                                                                                            }
                                                                                        });
                                                                                        PanelNum.add(btnScan);

                                                                                        JButton btnPunto = new JButton(".");{
                                                                                            btnPunto.setFont(new Font("Rockwell", Font.PLAIN, 18));
                                                                                            btnPunto.setBackground(new Color(210, 241, 233));
                                                                                            btnPunto.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                                                                                            btnPunto.setBorderPainted(false);
                                                                                            btnPunto.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                                            btnPunto.setFocusPainted(false);

                                                                                            btnPunto.setBounds(85,265,40,39);
                                                                                            btnPunto.addActionListener(new ActionListener() {
                                                                                                public void actionPerformed(ActionEvent evt) {
                                                                                                    // Maneja el evento del botón aquí
                                                                                                }
                                                                                            });
                                                                                            PanelNum.add(btnPunto);

                                                                                            JButton btn0 = new JButton("0");{
                                                                                                btn0.setFont(new Font("Rockwell", Font.PLAIN, 18));
                                                                                                btn0.setBackground(new Color(210, 241, 233));
                                                                                                btn0.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                                                                                                btn0.setBorderPainted(false);
                                                                                                btn0.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                                                btn0.setFocusPainted(false);

                                                                                                btn0.setBounds(145,265,40,39);
                                                                                                btn0.addActionListener(new ActionListener() {
                                                                                                    public void actionPerformed(ActionEvent evt) {
                                                                                                        // Maneja el evento del botón aquí
                                                                                                    }
                                                                                                });
                                                                                                PanelNum.add(btn0);



                                                                                                JButton btnIgual = new JButton("=");{
                                                                                                    btnIgual.setFont(new Font("Rockwell", Font.PLAIN, 18));
                                                                                                    btnIgual.setBackground(new Color(210, 241, 233));
                                                                                                    btnIgual.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
                                                                                                    btnIgual.setBorderPainted(false);
                                                                                                    btnIgual.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                                                                                    btnIgual.setFocusPainted(false);

                                                                                                    btnIgual.setBounds(205,265,40,39);
                                                                                                    btnIgual.addActionListener(new ActionListener() {
                                                                                                        public void actionPerformed(ActionEvent evt) {
                                                                                                            // Maneja el evento del botón aquí
                                                                                                        }
                                                                                                    });
                                                                                                    PanelNum.add(btnIgual);


                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }

                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

