/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.M_Pcard;
import Model.M_cardStack;
import Model.M_dice;
import Model.M_player;
import View.V_board;
import View.V_menu;
import View.V_playerNames;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author Álvaro
 */
public class C_game {

    private V_board vb;
    private V_menu vm;
    private V_playerNames pn;
    private C_menu menu;
    private M_dice dice = new M_dice();
    private int playerNo;
    private int realPlayerNo;
    private int playerTurn;
    private ArrayList<M_player> players;
    private ImageIcon one;
    private ImageIcon two;
    private ImageIcon three;
    private ImageIcon claw;
    private ImageIcon energy;
    private ImageIcon heart;
    private String[] diesRes;
    private ArrayList<Integer> deathDue;
    private C_playerStats cps;
    private C_playerCards cpc;
    private M_cardStack mcs;
    private M_Pcard rand1;
    private M_Pcard rand2;
    private M_Pcard rand3;
    private boolean extraTurn;
    private boolean FTextraTurn;
    private boolean selfKill;
    private int dieQty = 6;
    private int freezeTimeExcCount;
    private boolean shopTime = false;
    private ActionListener d1al;
    private ActionListener d2al;
    private ActionListener d3al;
    private ActionListener d4al;
    private ActionListener d5al;
    private ActionListener d6al;
    private ActionListener d7al;
    private ActionListener d8al;

    /*cosas a tener en cuenta y known bugs/missing features:
    si muere alguien a veces se salta el turno de un jugador - el bug ocurrira siempre que muera un jugador que tiene una posicion en el array anterior al jugador actual -- fixed
    si un jugador muere sus cartas aun podrian tener efecto, lo ideal seria vaciarle el array de cartas al comprobar que ha muerto -- pre-fixed en deadCheck(), pero hay que tenerlo en cuenta por si hubiera mas edge cases que no cubro actualmente
    - si se acaban las cartas se queda un un loop infinito -- low prio, es muy dificil que se acaben las cartas y puedo simplemente meter mas o w/e
     */
    public C_game(V_menu vm, C_menu cm, V_playerNames vpn) {
        this.mcs = new M_cardStack();
        this.cps = new C_playerStats(vb, this);
        this.cpc = new C_playerCards(vb, this);
        this.vm = vm;
        this.menu = cm;
        this.pn = vpn;
        extraTurn = false;
        FTextraTurn = false;
        selfKill = false;
        freezeTimeExcCount = 0;
        rand1 = mcs.callRandom();
        rand2 = mcs.callRandom();
        rand3 = mcs.callRandom();
        diesRes = new String[8];
        vb = new V_board();
        playerNo = menu.playerNum();
        realPlayerNo = menu.playerNum();
        playerTurn = 0;
        players = new ArrayList<>();
        deathDue = new ArrayList<>();
        one = new ImageIcon("src/one.jpg");
        two = new ImageIcon("src/two.jpg");
        three = new ImageIcon("src/three.jpg");
        energy = new ImageIcon("src/energy.jpg");
        claw = new ImageIcon("src/claw.jpg");
        heart = new ImageIcon("src/heart.jpg");
        d1al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vb.diceR1.isSelected() && vb.diceR1.getIcon() != null) {
                    vb.diceR1.setBorder(new LineBorder(Color.red, 2));
                    vb.diceR1.setBorderPainted(true);
                } else {
                    vb.diceR1.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
                    vb.diceR1.setBorderPainted(false);
                }
            }
        };
        d2al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vb.diceR2.isSelected() && vb.diceR2.getIcon() != null) {
                    vb.diceR2.setBorder(new LineBorder(Color.red, 2));
                    vb.diceR2.setBorderPainted(true);
                } else {
                    vb.diceR2.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
                    vb.diceR2.setBorderPainted(false);
                }
            }
        };
        d3al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vb.diceR3.isSelected() && vb.diceR3.getIcon() != null) {
                    vb.diceR3.setBorder(new LineBorder(Color.red, 2));
                    vb.diceR3.setBorderPainted(true);
                } else {
                    vb.diceR3.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
                    vb.diceR3.setBorderPainted(false);
                }
            }
        };
        d4al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vb.diceR4.isSelected() && vb.diceR4.getIcon() != null) {
                    vb.diceR4.setBorder(new LineBorder(Color.red, 2));
                    vb.diceR4.setBorderPainted(true);
                } else {
                    vb.diceR4.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
                    vb.diceR4.setBorderPainted(false);
                }
            }
        };
        d5al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vb.diceR5.isSelected() && vb.diceR5.getIcon() != null) {
                    vb.diceR5.setBorder(new LineBorder(Color.red, 2));
                    vb.diceR5.setBorderPainted(true);
                } else {
                    vb.diceR5.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
                    vb.diceR5.setBorderPainted(false);
                }
            }
        };
        d6al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vb.diceR6.isSelected() && vb.diceR6.getIcon() != null) {
                    vb.diceR6.setBorder(new LineBorder(Color.red, 2));
                    vb.diceR6.setBorderPainted(true);
                } else {
                    vb.diceR6.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
                    vb.diceR6.setBorderPainted(false);
                }
            }
        };
        d7al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vb.diceR7.isSelected() && vb.diceR7.getIcon() != null) {
                    vb.diceR7.setBorder(new LineBorder(Color.red, 2));
                    vb.diceR7.setBorderPainted(true);
                } else {
                    vb.diceR7.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
                    vb.diceR7.setBorderPainted(false);
                }
            }
        };
        d8al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vb.diceR8.isSelected() && vb.diceR8.getIcon() != null) {
                    vb.diceR8.setBorder(new LineBorder(Color.red, 2));
                    vb.diceR8.setBorderPainted(true);
                } else {
                    vb.diceR8.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
                    vb.diceR8.setBorderPainted(false);
                }
            }
        };
        vb.card1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (shopTime) {
                    Object[] options = {"Si",
                        "No"};
                    int n = JOptionPane.showOptionDialog(vb,
                            "Nombre: " + rand1.getName() + "\nCoste: " + rand1.getCost() + "\nTipo: " + rand1.getType() + "\nEfecto: " + rand1.getEffect() + "\n\n"
                            + "Quieres comprar la carta?",
                            "King of Tokyo - Información de la carta",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options, //the titles of buttons
                            options[0]); //default button title
                    if (n == 0) {
                        for (M_Pcard c : players.get(playerTurn).getCards()) {
                            if (c.getId() == 1) {
                                changeEnrg(players.get(playerTurn), 1);
                            }
                        }
                        if (players.get(playerTurn).getEnergy() >= rand1.getCost()) {
                            cardBought(rand1);
                            mcs.getCodedCardStack().remove(rand1);
                            rand1 = mcs.callRandom();
                            while ((rand1 == rand2) || (rand1 == rand3) && (mcs.getCodedCardStack().size() > 2)) {
                                rand1 = mcs.callRandom();
                            }
                            vb.card1.setText(rand1.getName() + "-" + rand1.getCost());
                            vb.card1.setName(String.valueOf(rand1.getId()));
                        } else {
                            JOptionPane.showMessageDialog(vb, "No tienes suficiente energia para comprar la carta.", "Energia insuficiente", 1);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(vb, "Nombre: " + rand1.getName() + "\nCoste: " + rand1.getCost() + "\nTipo: " + rand1.getType() + "\nEfecto: " + rand1.getEffect(), "King of Tokyo - Card information", 1);
                }
            }
        });
        vb.card2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (shopTime) {
                    Object[] options = {"Si",
                        "No"};
                    int n = JOptionPane.showOptionDialog(vb,
                            "Nombre: " + rand2.getName() + "\nCoste: " + rand2.getCost() + "\nTipo: " + rand2.getType() + "\nEfecto: " + rand2.getEffect() + "\n\n"
                            + "Quieres comprar la carta?",
                            "King of Tokyo - Información de la carta",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options, //the titles of buttons
                            options[0]); //default button title
                    if (n == 0) {
                        for (M_Pcard c : players.get(playerTurn).getCards()) {
                            if (c.getId() == 1) {
                                changeEnrg(players.get(playerTurn), 1);
                            }
                        }
                        if (players.get(playerTurn).getEnergy() >= rand2.getCost()) {
                            cardBought(rand2);
                            mcs.getCodedCardStack().remove(rand2);
                            rand2 = mcs.callRandom();
                            while ((rand2 == rand1) || (rand2 == rand3) && (mcs.getCodedCardStack().size() > 2)) {
                                rand2 = mcs.callRandom();
                            }
                            vb.card2.setText(rand2.getName() + "-" + rand2.getCost());
                            vb.card2.setName(String.valueOf(rand2.getId()));
                        } else {
                            JOptionPane.showMessageDialog(vb, "No tienes suficiente energia para comprar la carta.", "Energia insuficiente", 1);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(vb, "Nombre: " + rand2.getName() + "\nCoste: " + rand2.getCost() + "\nTipo: " + rand2.getType() + "\nEfecto: " + rand2.getEffect(), "King of Tokyo - Card information", 1);
                }
            }
        });
        vb.card3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (shopTime) {
                    Object[] options = {"Si",
                        "No"};
                    int n = JOptionPane.showOptionDialog(vb,
                            "Nombre: " + rand3.getName() + "\nCoste: " + rand3.getCost() + "\nTipo: " + rand3.getType() + "\nEfecto: " + rand3.getEffect() + "\n\n"
                            + "Quieres comprar la carta?",
                            "King of Tokyo - Información de la carta",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options, //the titles of buttons
                            options[0]); //default button title
                    if (n == 0) {
                        for (M_Pcard c : players.get(playerTurn).getCards()) {
                            if (c.getId() == 1) {
                                changeEnrg(players.get(playerTurn), 1);
                            }
                        }
                        if (players.get(playerTurn).getEnergy() >= rand3.getCost()) {
                            cardBought(rand3);
                            mcs.getCodedCardStack().remove(rand3);
                            rand3 = mcs.callRandom();
                            while ((rand3 == rand2) || (rand3 == rand1) && (mcs.getCodedCardStack().size() > 2)) {
                                rand3 = mcs.callRandom();
                            }
                            vb.card3.setText(rand3.getName() + "-" + rand3.getCost());
                            vb.card3.setName(String.valueOf(rand3.getId()));
                        } else {
                            JOptionPane.showMessageDialog(vb, "No tienes suficiente energia para comprar la carta.", "Energia insuficiente", 1);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(vb, "Nombre: " + rand3.getName() + "\nCoste: " + rand3.getCost() + "\nTipo: " + rand3.getType() + "\nEfecto: " + rand3.getEffect(), "King of Tokyo - Card information", 1);
                }
            }
        });
        vb.rolldie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rolldie();
            }
        });
        vb.lockdies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draindies();
            }
        });
        vb.passt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EoT();
            }
        });
        vb.diceR1.addActionListener(d1al);
        vb.diceR2.addActionListener(d2al);
        vb.diceR3.addActionListener(d3al);
        vb.diceR4.addActionListener(d4al);
        vb.diceR5.addActionListener(d5al);
        vb.diceR6.addActionListener(d6al);
        vb.diceR7.addActionListener(d7al);
        vb.diceR8.addActionListener(d8al);
    }

    public ArrayList<M_player> getPlayers() {
        return players;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public void run() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vb.setVisible(true);
                vb.setTitle("King of Tokyo");
                vb.setLocationRelativeTo(null);
                // añadir la imagen de fondo
                JComponent bg = new JComponent() {
                    @Override
                    public void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.drawImage(new ImageIcon("src/bgimg.jpg").getImage(), 0, 0, null);
                    }
                };
                bg.setBounds(0, 0, 750, 600);
                //se le quita le layout para que quede de fondo
                bg.setLayout(null);
                vb.add(bg);
                playerCreation();
                pturn();
                vb.diceR1.setEnabled(false);
                vb.diceR2.setEnabled(false);
                vb.diceR3.setEnabled(false);
                vb.diceR4.setEnabled(false);
                vb.diceR5.setEnabled(false);
                vb.diceR6.setEnabled(false);
                vb.diceR7.setEnabled(false);
                vb.diceR8.setEnabled(false);
                vb.lockdies.setEnabled(false);
                vb.extraT.setVisible(false);
            }
        });
    }

    public void playerCreation() {

        M_player p1 = new M_player(0, pn.p1name.getText());
        M_player p2 = new M_player(1, pn.p2name.getText());
        M_player p3 = new M_player(2, pn.p3name.getText());

        while (rand2 == rand1) {
            rand2 = mcs.callRandom();
        }
        while (rand3 == rand2 || rand3 == rand1) {
            rand3 = mcs.callRandom();
        }

        players.add(p1);
        players.add(p2);
        players.add(p3);

        vb.card1.setText(rand1.getName() + "-" + rand1.getCost());
        vb.card1.setName(String.valueOf(rand1.getId()));
        vb.card2.setText(rand2.getName() + "-" + rand2.getCost());
        vb.card2.setName(String.valueOf(rand2.getId()));
        vb.card3.setText(rand3.getName() + "-" + rand3.getCost());
        vb.card3.setName(String.valueOf(rand3.getId()));

        if (playerNo > 3) {
            M_player p4 = new M_player(3, pn.p4name.getText());
            players.add(p4);
            if (playerNo > 4) {
                M_player p5 = new M_player(4, pn.p5name.getText());
                players.add(p5);
                if (playerNo > 5) {
                    M_player p6 = new M_player(5, pn.p6name.getText());
                    players.add(p6);
                }
            }
        }
        if (playerNo < 4) {
            vb.playerctrlingBay.setText("X");
            vb.playerctrlingBay.setForeground(Color.red);
        }
        cps.run();
        cpc.run();
    }

    public void pturn() {
        resets();
        vb.rolldie.setEnabled(true);
        playerNo = players.size();
        realPlayerNo = players.size();
        // si el turno es mayor que el número de jugadores se reinician los turnos y se hace otra ronda
        if (playerTurn >= players.size() || playerTurn < 0) {
            playerTurn = 0;
        }
        cpc.updateCards();
        // si comienza su turno en tokyo, se le suman 2 puntos de victoria
        if (players.get(playerTurn).isTctrl()) {
            changeWP(players.get(playerTurn), 1);
        }
        winCheck();
        vb.pturn.setText(players.get(playerTurn).getName());
        vb.playerHP.setText(String.valueOf(players.get(playerTurn).getHp()));
        vb.playerVP.setText(String.valueOf(players.get(playerTurn).getWp()));
        vb.playerEnrg.setText(String.valueOf(players.get(playerTurn).getEnergy()));
        vb.rollsA.setText(String.valueOf(players.get(playerTurn).getRollsAvailable()));
        for (M_Pcard card : players.get(playerTurn).getCards()) {
            if (card.getId() == 31) {
                dieQty++;
            }
        }
    }

    public void rolldie() {
        String rollN;
        while (dieQty > 0) {
            switch (dieQty) {
                case 1:
                    vb.diceR1.setEnabled(true);
                    dieQty--;
                    break;
                case 2:
                    vb.diceR2.setEnabled(true);
                    dieQty--;
                    break;
                case 3:
                    vb.diceR3.setEnabled(true);
                    dieQty--;
                    break;
                case 4:
                    vb.diceR4.setEnabled(true);
                    dieQty--;
                    break;
                case 5:
                    vb.diceR5.setEnabled(true);
                    dieQty--;
                    break;
                case 6:
                    vb.diceR6.setEnabled(true);
                    dieQty--;
                    break;
                case 7:
                    vb.diceR7.setEnabled(true);
                    dieQty--;
                    break;
                case 8:
                    vb.diceR8.setEnabled(true);
                    dieQty--;
                    break;
                default:
                    System.out.println("err");
                    break;
            }
        }
        dieQty = 6 - freezeTimeExcCount;
        for (M_Pcard card : players.get(playerTurn).getCards()) {
            if (card.getId() == 31) {
                dieQty++;
            }
        }
        rollN = dice.roll();
        ImageIcon randroll;

        if (!vb.diceR1.isSelected() && vb.diceR1.isEnabled()) {
            randroll = new ImageIcon("src/" + rollN + ".jpg");
            vb.diceR1.setIcon(randroll);
            vb.diceR1.setDisabledIcon(randroll);
            diesRes[0] = rollN;
            rollN = dice.roll();
        } else if (!vb.diceR1.isEnabled() && vb.diceR1.getIcon() == null) {
            diesRes[0] = "na";
        }
        if (!vb.diceR2.isSelected() && vb.diceR2.isEnabled()) {
            randroll = new ImageIcon("src/" + rollN + ".jpg");
            vb.diceR2.setIcon(randroll);
            vb.diceR2.setDisabledIcon(randroll);
            diesRes[1] = rollN;
            rollN = dice.roll();
        } else if (!vb.diceR2.isEnabled() && vb.diceR2.getIcon() == null) {
            diesRes[1] = "na";
        }
        if (!vb.diceR3.isSelected() && vb.diceR3.isEnabled()) {
            randroll = new ImageIcon("src/" + rollN + ".jpg");
            vb.diceR3.setIcon(randroll);
            vb.diceR3.setDisabledIcon(randroll);
            diesRes[2] = rollN;
            rollN = dice.roll();
        } else if (!vb.diceR3.isEnabled() && vb.diceR3.getIcon() == null) {
            diesRes[2] = "na";
        }
        if (!vb.diceR4.isSelected() && vb.diceR4.isEnabled()) {
            randroll = new ImageIcon("src/" + rollN + ".jpg");
            vb.diceR4.setIcon(randroll);
            vb.diceR4.setDisabledIcon(randroll);
            diesRes[3] = rollN;;
            rollN = dice.roll();
        } else if (!vb.diceR4.isEnabled() && vb.diceR4.getIcon() == null) {
            diesRes[3] = "na";
        }
        if (!vb.diceR5.isSelected() && vb.diceR5.isEnabled()) {
            randroll = new ImageIcon("src/" + rollN + ".jpg");
            vb.diceR5.setIcon(randroll);
            vb.diceR5.setDisabledIcon(randroll);
            diesRes[4] = rollN;
            rollN = dice.roll();
        } else if (!vb.diceR5.isEnabled() && vb.diceR5.getIcon() == null) {
            diesRes[4] = "na";
        }
        if (!vb.diceR6.isSelected() && vb.diceR6.isEnabled()) {
            randroll = new ImageIcon("src/" + rollN + ".jpg");
            vb.diceR6.setIcon(randroll);
            vb.diceR6.setDisabledIcon(randroll);
            diesRes[5] = rollN;
            rollN = dice.roll();
        } else if (!vb.diceR6.isEnabled() && vb.diceR6.getIcon() == null) {
            diesRes[5] = "na";
        }
        if (!vb.diceR7.isSelected() && vb.diceR7.isEnabled()) {
            randroll = new ImageIcon("src/" + rollN + ".jpg");
            vb.diceR7.setIcon(randroll);
            vb.diceR7.setDisabledIcon(randroll);
            diesRes[6] = rollN;;
            rollN = dice.roll();
        } else if (!vb.diceR7.isEnabled() && vb.diceR7.getIcon() == null) {
            diesRes[6] = "na";
        }
        if (!vb.diceR8.isSelected() && vb.diceR8.isEnabled()) {
            randroll = new ImageIcon("src/" + rollN + ".jpg");
            vb.diceR8.setIcon(randroll);
            vb.diceR8.setDisabledIcon(randroll);
            diesRes[7] = rollN;
        } else if (!vb.diceR8.isEnabled() && vb.diceR8.getIcon() == null) {
            diesRes[7] = "na";
        }
        players.get(playerTurn).setRollsAvailable(players.get(playerTurn).getRollsAvailable() - 1);
        vb.rollsA.setText(String.valueOf(players.get(playerTurn).getRollsAvailable()));
        if (players.get(playerTurn).getRollsAvailable() <= 0) {
            disableDies();
        }
        vb.lockdies.setEnabled(true);
    }

    public void disableDies() {
        boolean ckthree = false;
        for (M_Pcard card : players.get(playerTurn).getCards()) {
            if (card.getId() == 5) {
                ckthree = true;
            }
        }
        if (!ckthree || !diesRes[0].equals("three")) {
            vb.diceR1.setEnabled(false);
            vb.diceR1.setSelected(false);
            vb.diceR1.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
        }
        if (!ckthree || !diesRes[1].equals("three")) {
            vb.diceR2.setEnabled(false);
            vb.diceR2.setSelected(false);
            vb.diceR2.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
        }
        if (!ckthree || !diesRes[2].equals("three")) {
            vb.diceR3.setEnabled(false);
            vb.diceR3.setSelected(false);
            vb.diceR3.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
        }
        if (!ckthree || !diesRes[3].equals("three")) {
            vb.diceR4.setEnabled(false);
            vb.diceR4.setSelected(false);
            vb.diceR4.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
        }
        if (!ckthree || !diesRes[4].equals("three")) {
            vb.diceR5.setEnabled(false);
            vb.diceR5.setSelected(false);
            vb.diceR5.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
        }
        if (!ckthree || !diesRes[5].equals("three")) {
            vb.diceR6.setEnabled(false);
            vb.diceR6.setSelected(false);
            vb.diceR6.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
        }
        if (!ckthree || !diesRes[6].equals("three")) {
            vb.diceR7.setEnabled(false);
            vb.diceR7.setSelected(false);
            vb.diceR7.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
        }
        if (!ckthree || !diesRes[7].equals("three")) {
            vb.diceR8.setEnabled(false);
            vb.diceR8.setSelected(false);
            vb.diceR8.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
        }
        if (!vb.diceR1.isEnabled() && !vb.diceR2.isEnabled() && !vb.diceR3.isEnabled() && !vb.diceR4.isEnabled() && !vb.diceR5.isEnabled() && !vb.diceR6.isEnabled() && !vb.diceR7.isEnabled() && !vb.diceR8.isEnabled()) {
            vb.rolldie.setEnabled(false);
            players.get(playerTurn).setRollsAvailable(0);
            vb.rollsA.setText(String.valueOf(players.get(playerTurn).getRollsAvailable()));
        } else {
            dieQty = 0;
            players.get(playerTurn).setRollsAvailable(0);
            vb.rollsA.setText(String.valueOf(players.get(playerTurn).getRollsAvailable()));
        }
    }

    public void resets() {
        vb.diceR1.setIcon(null);
        vb.diceR1.setSelected(false);
        vb.diceR1.setBorderPainted(false);
        vb.diceR2.setIcon(null);
        vb.diceR2.setSelected(false);
        vb.diceR2.setBorderPainted(false);
        vb.diceR3.setIcon(null);
        vb.diceR3.setSelected(false);
        vb.diceR3.setBorderPainted(false);
        vb.diceR4.setIcon(null);
        vb.diceR4.setSelected(false);
        vb.diceR4.setBorderPainted(false);
        vb.diceR5.setIcon(null);
        vb.diceR5.setSelected(false);
        vb.diceR5.setBorderPainted(false);
        vb.diceR6.setIcon(null);
        vb.diceR6.setSelected(false);
        vb.diceR6.setBorderPainted(false);
        vb.diceR7.setIcon(null);
        vb.diceR7.setSelected(false);
        vb.diceR7.setBorderPainted(false);
        vb.diceR8.setIcon(null);
        vb.diceR8.setSelected(false);
        vb.diceR8.setBorderPainted(false);
        vb.diceR1.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
        vb.diceR2.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
        vb.diceR3.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
        vb.diceR4.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
        vb.diceR5.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
        vb.diceR6.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
        vb.diceR7.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
        vb.diceR8.setBorder(new LineBorder(new Color(0, 0, 0, 1), 2));
        vb.diceR1.setEnabled(false);
        vb.diceR2.setEnabled(false);
        vb.diceR3.setEnabled(false);
        vb.diceR4.setEnabled(false);
        vb.diceR5.setEnabled(false);
        vb.diceR6.setEnabled(false);
        vb.diceR7.setEnabled(false);
        vb.diceR8.setEnabled(false);
        vb.rollsA.setVisible(true);
        vb.lockdies.setEnabled(false);
        vb.passt.setEnabled(false);
        vb.card1.setBorder(new JLabel().getBorder());
        vb.card2.setBorder(new JLabel().getBorder());
        vb.card3.setBorder(new JLabel().getBorder());
        shopTime = false;
        dieQty = 6 - freezeTimeExcCount;
    }

    public void draindies() {
        int onecount = 0, twocount = 0, threecount = 0, hrtcount = 0, enrgcount = 0, clawcount = 0;
        // recuento de los resultados de las tiradas
        for (int i = 0; i < diesRes.length; i++) {
            if (diesRes[i].equals("one")) {
                onecount++;
            }
            if (diesRes[i].equals("two")) {
                twocount++;
            }
            if (diesRes[i].equals("three")) {
                threecount++;
            }
            if (diesRes[i].equals("heart")) {
                hrtcount++;
            }
            if (diesRes[i].equals("claw")) {
                clawcount++;
            }
            if (diesRes[i].equals("energy")) {
                enrgcount++;
            }
        }
        // si hay 3 o mas '1' se añaden puntos en función de los que haya
        if (onecount >= 3) {
            switch (onecount) {
                case 3:
                    changeWP(players.get(playerTurn), 1);
                    break;
                case 4:
                    changeWP(players.get(playerTurn), 2);
                    break;
                case 5:
                    changeWP(players.get(playerTurn), 3);
                    break;
                case 6:
                    changeWP(players.get(playerTurn), 4);
                    break;
                case 7:
                    changeWP(players.get(playerTurn), 5);
                    break;
                case 8:
                    changeWP(players.get(playerTurn), 6);
                    break;
            }
        }
        // si hay 3 o mas '2' se añaden puntos en función de los que haya
        if (twocount >= 3) {
            switch (twocount) {
                case 3:
                    changeWP(players.get(playerTurn), 2);
                    break;
                case 4:
                    changeWP(players.get(playerTurn), 3);
                    break;
                case 5:
                    changeWP(players.get(playerTurn), 4);
                    break;
                case 6:
                    changeWP(players.get(playerTurn), 5);
                    break;
                case 7:
                    changeWP(players.get(playerTurn), 6);
                    break;
                case 8:
                    changeWP(players.get(playerTurn), 7);
                    break;
            }
        }
        // si hay 3 o mas '3' se añaden puntos en función de los que haya
        if (threecount >= 3) {
            switch (threecount) {
                case 3:
                    changeWP(players.get(playerTurn), 3);
                    break;
                case 4:
                    changeWP(players.get(playerTurn), 4);
                    break;
                case 5:
                    changeWP(players.get(playerTurn), 5);
                    break;
                case 6:
                    changeWP(players.get(playerTurn), 6);
                    break;
                case 7:
                    changeWP(players.get(playerTurn), 7);
                    break;
                case 8:
                    changeWP(players.get(playerTurn), 8);
                    break;
            }
        }
        // se le suma la energia de los dados al jugador actual
        changeEnrg(players.get(playerTurn), enrgcount);
        // solo si está fuera de tokyo y tiene menos de 10 puntos de vida se cura el jugador actual
        if (!players.get(playerTurn).isTctrl()) {
            changeHP(players.get(playerTurn), hrtcount);
            if (players.get(playerTurn).getHp() > 10) {
                players.get(playerTurn).setHp(10);
            }
        }
        // condiciones especiales de las cartas
        for (M_Pcard c : players.get(playerTurn).getCards()) {
            // vigilar que al sumar counts no se haga trigger de otros efectos sin querer
            // si atacas este turno este efecto ocurre, hacer daño con cartas no cuenta como atacar
            if (c.getId() == 2) {
                if (clawcount > 0) {
                    changeWP(players.get(playerTurn), 1);
                }
            }
            if (c.getId() == 26 && clawcount == 1 && enrgcount == 1 && onecount == 1 && twocount == 1 && threecount == 1 && hrtcount == 1) {
                changeWP(players.get(playerTurn), 9);
            }
            if (c.getId() == 47 && onecount > 0 && twocount > 0 && threecount > 0) {
                changeWP(players.get(playerTurn), 2);
            }
            if (c.getId() == 0) {
                clawcount++;
            }
            if (c.getId() == 33 && onecount > 2) {
                freezeTimeExcCount++;
                FTextraTurn = true;
                vb.extraT.setVisible(true);
            }
            if (c.getId() == 36 && onecount > 2) {
                changeWP(players.get(playerTurn), 2);
            }
            if (c.getId() == 51 && twocount > 2) {
                clawcount = clawcount + 2;
            }
            //este cuenta el daño hecho, tiene q ir el ultimo
            if (c.getId() == 73 && clawcount > 2) {
                changeWP(players.get(playerTurn), 2);
            }
        }
        // si el jugador actual controla tokyo hace el daño a los jugadores que están fuera de tokyo y al inrevés
        if (players.get(playerTurn).isTctrl()) {
            for (M_Pcard c : players.get(playerTurn).getCards()) {
                if (c.getId() == 6) {
                    clawcount++;
                }
            }
            for (M_player p : players) {
                if (!p.isTctrl()) {
                    // efecto especial carta 
                    for (M_Pcard c : p.getCards()) {
                        if (c.getId() == 4 && clawcount == 1) {
                            clawcount--;
                        }
                    }
                    p.setHp(p.getHp() - clawcount);
                }
            }
        } else {
            for (M_player p : players) {
                if (p.isTctrl()) {
                    // efecto especial carta 
                    for (M_Pcard c : p.getCards()) {
                        if (c.getId() == 4 && clawcount == 1) {
                            clawcount--;
                        }
                    }
                    p.setHp(p.getHp() - clawcount);
                }
            }
        }
        // actualizo los valores en la mesa
        vb.playerHP.setText(String.valueOf(players.get(playerTurn).getHp()));
        vb.playerVP.setText(String.valueOf(players.get(playerTurn).getWp()));
        vb.playerEnrg.setText(String.valueOf(players.get(playerTurn).getEnergy()));
        vb.lockdies.setEnabled(false);
        vb.rolldie.setEnabled(false);
        vb.rollsA.setText("0");
        cps.updateTable();
        deadCheck();
        winCheck();
        tokyoCtrl();
        shopTime = true;
        vb.card1.setBorder(new LineBorder(Color.blue, 1));
        vb.card2.setBorder(new LineBorder(Color.blue, 1));
        vb.card3.setBorder(new LineBorder(Color.blue, 1));
        vb.cardStack.setBorder(new LineBorder(Color.green, 1));
        vb.passt.setEnabled(true);
        cps.updateTable();
    }

    public void tokyoCtrl() {
        boolean leftTokyo = false;
        // si no hay ningún jugador en la ciudad y el jugador actual no está en la bahía, este entra en la ciudad
        if (vb.playerctrlingCity.getText().isEmpty() && !players.get(playerTurn).getName().equals(vb.playerctrlingBay.getText())) {
            players.get(playerTurn).setTctrl(true);
            changeWP(players.get(playerTurn), 1);
            vb.playerVP.setText(String.valueOf(players.get(playerTurn).getWp()));
            vb.playerctrlingCity.setText(players.get(playerTurn).getName());
            // si no hay ningún jugador en la bahía, el jugador actual no está en la ciudad y hay mas de 4 jugadores en la partida, este entra en la bahía
        } else if (vb.playerctrlingBay.getText().isEmpty() && !players.get(playerTurn).getName().equals(vb.playerctrlingCity.getText()) && realPlayerNo > 4) {
            players.get(playerTurn).setTctrl(true);
            vb.playerctrlingBay.setText(players.get(playerTurn).getName());
            changeWP(players.get(playerTurn), 1);
            vb.playerVP.setText(String.valueOf(players.get(playerTurn).getWp()));
        } else {
            // si la ciudad y la bahía están ocupadas y el jugador tiene una garra en algún dado bloqueado se comprueba si el dueño de la ciudad o de la bahía ceden el control
            // de alguna de estas dos
            boolean hasClaw = false;
            for (int i = 0; i < diesRes.length; i++) {
                if (diesRes[i].equals("claw")) {
                    hasClaw = true;
                }
            }
            if (hasClaw) {
                for (M_player p : players) {
                    if (p.getName().equals(vb.playerctrlingCity.getText()) && !players.get(playerTurn).getName().equals(p.getName()) && !players.get(playerTurn).getName().equals(vb.playerctrlingBay.getText())) {
                        Object[] options = {"Si",
                            "No"};
                        int n = JOptionPane.showOptionDialog(vb,
                                p.getName() + " cedes el control de la ciudad de Tokyo?",
                                p.getName() + " - Control de la ciudad de Tokyo",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options, //the titles of buttons
                                options[0]); //default button title
                        if (n == 0) {
                             //el efecto de esta carta se podria pasar al metodo changeHP ya que hay que comprobar de todos modos si pierde 1 HP
                            for (M_Pcard card : p.getCards()) {
                                if (card.getId() == 6) {
                                    changeHP(players.get(playerTurn), -1);
                                }
                            }
                            p.setTctrl(false);
                            vb.playerctrlingCity.setText("");
                            leftTokyo = true;
                        }
                    } else if (p.getName().equals(vb.playerctrlingBay.getText()) && !players.get(playerTurn).getName().equals(p.getName()) && !players.get(playerTurn).getName().equals(vb.playerctrlingCity.getText())) {
                        Object[] options = {"Si",
                            "No"};
                        int n = JOptionPane.showOptionDialog(vb,
                                p.getName() + " cedes el control de la bahía de Tokyo?",
                                p.getName() + " - Control de la bahía de Tokyo",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options, //the titles of buttons
                                options[0]); //default button title
                        if (n == 0) {
                            for (M_Pcard card : p.getCards()) {
                                if (card.getId() == 6) {
                                    boolean hasArmor = false;
                                    //el efecto de esta carta se podria pasar al metodo changeHP ya que hay que comprobar de todos modos si pierde 1 HP
                                    for (M_Pcard card1 : players.get(playerTurn).getCards()) {
                                        if (card1.getId() == 4) {
                                            hasArmor = true;
                                        }
                                    }
                                    if (!hasArmor) {
                                        changeHP(players.get(playerTurn), -1);
                                    }
                                }
                            }
                            p.setTctrl(false);
                            vb.playerctrlingBay.setText("");
                            leftTokyo = true;
                        }
                    }
                }
                // si alguien ha marchado de tokyo se comprueba si están vacias, comenzando por la ciudad, y se ocupa una de ellas
                if (leftTokyo) {
                    if (vb.playerctrlingCity.getText().isEmpty()) {
                        players.get(playerTurn).setTctrl(true);
                        changeWP(players.get(playerTurn), 1);
                        vb.playerVP.setText(String.valueOf(players.get(playerTurn).getWp()));
                        vb.playerctrlingCity.setText(players.get(playerTurn).getName());
                    }
                    if (vb.playerctrlingBay.getText().isEmpty() && !players.get(playerTurn).isTctrl() && realPlayerNo > 4) {
                        players.get(playerTurn).setTctrl(true);
                        changeWP(players.get(playerTurn), 1);
                        vb.playerVP.setText(String.valueOf(players.get(playerTurn).getWp()));
                        vb.playerctrlingBay.setText(players.get(playerTurn).getName());
                    }
                }
            }
        }
        winCheck();
        cps.updateTable();
    }

    public void deadCheck() {
        for (int i = 0; i < players.size(); i++) {
            // compruebo que el jugador no esté ya en deathDue, asi no puede entrar aqui 2 veces y jodernos la fiesta
            if (players.get(i).getHp() <= 0 && !deathDue.contains(players.get(i).getId())) {
                deathDue.add(players.get(i).getId());
                realPlayerNo--;
                JOptionPane.showMessageDialog(vb, players.get(i).getName() + " ha sido eliminado de la partida.", "Jugador eliminado", 1);
                // le borro el array de cartas para que estas no tengan efecto antes de eliminar al jugador del array de jugadores
                players.get(i).getCards().clear();
                for (M_player p : players) {
                    for (M_Pcard c : p.getCards()) {
                        if (c.getId() == 28) {
                            changeWP(p, 3);
                        }
                    }
                }
                checkBay();
                if (vb.playerctrlingCity.getText().equals(players.get(i).getName())) {
                    vb.playerctrlingCity.setText("");
                }
                if (vb.playerctrlingBay.getText().equals(players.get(i).getName())) {
                    vb.playerctrlingBay.setText("");
                }
                if (players.get(i) == players.get(playerTurn)) {
                    selfKill = true;
                    EoT();
                }
            }
        }
    }

    public void resolveDeath() {
        boolean broken = false;
        if (!deathDue.isEmpty()) {
            for (int i = 0; i < players.size(); i++) {
                for (int j = 0; j < deathDue.size(); j++) {
                    if (players.get(i).getId() == deathDue.get(j)) {
                        // si el jugador que muere está en una posición del array anterior al actual se salta un jugador, esto lo previene
                        if (players.get(i).getId() < players.get(playerTurn).getId()) {
                            playerTurn--;
                        }
                        players.remove(i);
                        resolveDeath();
                        cps.updateTable();
                        broken = true;
                        break;
                    }
                }
                if (broken) {
                    break;
                }
            }
        }
    }

    public void winCheck() {
        int alive = 0;
        int winner = 0;
        if (players.get(playerTurn).getWp() > 19) {
            win(players.get(playerTurn));
        }
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getHp() > 0) {
                alive++;
                winner = i;
            }
        }
        if (alive == 1) {
            win(players.get(winner));
        }
        if (alive == 0) {
            JOptionPane.showMessageDialog(vb, "Se ha producido un empate!.", "King of Tokyo - Empate", 1);
            System.exit(0);
        }
    }

    public void win(M_player p) {
        JOptionPane.showMessageDialog(vb, "El ganador és " + p.getName() + ".", "Ganador", 1);
        System.exit(0);
    }

    public void changeWP(M_player p, int wp) {
        p.setWp(p.getWp() + wp);
    }

    public void changeHP(M_player p, int hp) {
        int OGHP = p.getHp();
        p.setHp(p.getHp() + hp);
        if(OGHP < p.getHp()){
            for (M_Pcard c : p.getCards()) {
                if(c.getId()==55){
                    p.setHp(p.getHp() + 1);
                }
            }
        }
    }

    public void changeEnrg(M_player p, int enrg) {
        p.setEnergy(p.getEnergy() + enrg);
    }

    public void cardBought(M_Pcard card) {
        if (card.getType().equalsIgnoreCase("Keep")) {
            players.get(playerTurn).getCards().add(card);
        }
        changeWP(players.get(playerTurn), card.getWpChange());
        changeHP(players.get(playerTurn), card.getHpChange());
        changeEnrg(players.get(playerTurn), -card.getCost() + card.getEnrgChange());
        checkCardId(card);
        deadCheck();
        winCheck();
        if (players.get(playerTurn).getHp() > 10) {
            players.get(playerTurn).setHp(10);
        }
        vb.playerEnrg.setText(String.valueOf(players.get(playerTurn).getEnergy()));
        vb.playerVP.setText(String.valueOf(players.get(playerTurn).getWp()));
        vb.playerHP.setText(String.valueOf(players.get(playerTurn).getHp()));
        cps.updateTable();
        cpc.updateCards();
    }

    public void EoT() {
        for (M_Pcard c : players.get(playerTurn).getCards()) {
            if (c.getId() == 29) {
                changeWP(players.get(playerTurn), players.get(playerTurn).getEnergy() / 6);
            }
        }
        vb.playerEnrg.setText(String.valueOf(players.get(playerTurn).getEnergy()));
        cps.updateTable();
        winCheck();
        players.get(playerTurn).setRollsAvailable(3);
        for (M_Pcard c : players.get(playerTurn).getCards()) {
            if (c.getId() == 35) {
                players.get(playerTurn).setRollsAvailable(4);
            }
        }
        resolveDeath();
        if (selfKill) {
            selfKill = false;
            playerTurn--;
        }
        if (!extraTurn && !FTextraTurn) {
            playerTurn++;
        }
        if (FTextraTurn) {
            FTextraTurn = false;
            if(!extraTurn){
                vb.extraT.setVisible(false);
            }
        } else {
            freezeTimeExcCount = 0;
            if (extraTurn) {
                extraTurn = false;
                vb.extraT.setVisible(false);
            }
        }
        pturn();
    }

    public void checkCardId(M_Pcard card) {
        //drop from high altitude
        if (card.getId() == 10) {
            if (!vb.playerctrlingCity.getText().isEmpty() && !players.get(playerTurn).isTctrl()) {
                for (M_player p : players) {
                    if (p.getName().equals(vb.playerctrlingCity.getText())) {
                        p.setTctrl(false);
                        vb.playerctrlingCity.setText(players.get(playerTurn).getName());
                        players.get(playerTurn).setTctrl(true);
                        changeWP(players.get(playerTurn), 1);
                    }
                }
            }
        }
        if (card.getId() == 12) {
            for (M_player p : players) {
                if (p != players.get(playerTurn)) {
                    changeWP(p, -5);
                    if (p.getWp() < 0) {
                        p.setWp(0);
                    }
                }
            }
        }
        if (card.getId() == 13) {
            for (M_player p : players) {
                if (p != players.get(playerTurn)) {
                    changeHP(p, -2);
                }
            }
        }
        if (card.getId() == 14) {
            extraTurn = true;
            vb.extraT.setVisible(true);
        }
        if (card.getId() == 15) {
            for (M_player p : players) {
                if (p != players.get(playerTurn)) {
                    changeHP(p, -3);
                }
            }
        }
        if (card.getId() == 17) {
            for (M_player p : players) {
                changeHP(p, -3);
            }
        }
        if (card.getId() == 23) {
            for (M_player p : players) {
                if (p != players.get(playerTurn)) {
                    changeEnrg(p, -(p.getEnergy() / 2));
                }
            }
        }
        if (card.getId() == 25) {
            changeWP(players.get(playerTurn), players.get(playerTurn).getCards().size());
            changeHP(players.get(playerTurn), -players.get(playerTurn).getCards().size());
        }
        for (M_Pcard card1 : players.get(playerTurn).getCards()) {
            if (card1.getId() == 27) {
                changeWP(players.get(playerTurn), 1);
            }
        }
    }

    public void checkBay() {
        if (realPlayerNo < 5) {
            if (!vb.playerctrlingBay.getText().isEmpty()) {
                for (M_player p : players) {
                    if (p.getName().equals(vb.playerctrlingBay.getText())) {
                        p.setTctrl(false);
                        vb.playerctrlingBay.setText("X");
                        vb.playerctrlingBay.setForeground(Color.red);
                        JOptionPane.showMessageDialog(vb, "La bahía de Tokyo ha sido destruida.", "King of Tokyo - Bahía de Tokyo", 1);
                    }
                }
            }
        }
    }
}
