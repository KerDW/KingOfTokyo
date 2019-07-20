/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.V_menu;
import View.V_playerNames;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Álvaro
 */
public class C_playerNames implements ActionListener {

    private V_menu vm = new V_menu();
    private C_menu menu = new C_menu();
    private V_playerNames pn = new V_playerNames();
    private int playerNo;

    public C_playerNames(V_menu vm, C_menu cm) {
        this.vm = vm;
        this.menu = cm;
        pn = new V_playerNames();
        playerNo = menu.playerNum();
        pn.done.addActionListener(this);
    }

    public void run() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                pn.setVisible(true);
                pn.setTitle("King of Tokyo - Name selection");
                pn.setLocationRelativeTo(null); // Place the window in position 0, in the center.
                switch(playerNo){
                    case 6:
                        break;
                    case 5:
                        pn.p6name.setVisible(false);
                        pn.p6nameL.setVisible(false);
                        break;
                    case 4:
                        pn.p6name.setVisible(false);
                        pn.p6nameL.setVisible(false);
                        pn.p5name.setVisible(false);
                        pn.p5nameL.setVisible(false);
                        break;
                    default:
                        pn.p6name.setVisible(false);
                        pn.p6nameL.setVisible(false);
                        pn.p5name.setVisible(false);
                        pn.p5nameL.setVisible(false);
                        pn.p4name.setVisible(false);
                        pn.p4nameL.setVisible(false);
                        break;
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean gucci = true;

        pn.p1name.setText(pn.p1name.getText().trim());
        pn.p2name.setText(pn.p2name.getText().trim());
        pn.p3name.setText(pn.p3name.getText().trim());
        pn.p4name.setText(pn.p4name.getText().trim());
        pn.p5name.setText(pn.p5name.getText().trim());
        pn.p6name.setText(pn.p6name.getText().trim());

        switch (playerNo) {
            case 6:
                if (pn.p6name.getText().isEmpty() || pn.p5name.getText().isEmpty() || pn.p4name.getText().isEmpty() || pn.p1name.getText().isEmpty() || pn.p2name.getText().isEmpty() || pn.p3name.getText().isEmpty()) {
                    System.out.println("err6");
                    gucci = false;
                }
                break;
            case 5:
                if (pn.p5name.getText().isEmpty() || pn.p4name.getText().isEmpty() || pn.p1name.getText().isEmpty() || pn.p2name.getText().isEmpty() || pn.p3name.getText().isEmpty()) {
                    System.out.println("err5");
                    gucci = false;
                }
                break;
            case 4:
                if (pn.p4name.getText().isEmpty() || pn.p1name.getText().isEmpty() || pn.p2name.getText().isEmpty() || pn.p3name.getText().isEmpty()) {
                    System.out.println("err4");
                    gucci = false;
                }
                break;
            default:
                if (pn.p1name.getText().isEmpty() || pn.p2name.getText().isEmpty() || pn.p3name.getText().isEmpty()) {
                    System.out.println("err123");
                    gucci = false;
                }
                break;
        }
        if (gucci) {
            C_game game = new C_game(vm, menu, pn);
            pn.setVisible(false);
            game.run();
        }
    }
}
