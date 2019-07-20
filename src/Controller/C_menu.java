/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.V_menu;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Álvaro
 */
public class C_menu implements KeyListener {

    private V_menu vm;
    
    public C_menu(){
        this.vm = new V_menu();
        vm.pnum.addKeyListener(this);
    }

    public void run() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vm.setVisible(true);
                vm.setTitle("King of Tokyo - Menu");
                vm.setLocationRelativeTo(null);
            }
        });
    }

    public int playerNum() {
        try {
            if (Integer.parseInt(this.vm.pnum.getText()) < 3 || Integer.parseInt(this.vm.pnum.getText()) > 6) {
                System.out.println("error wrong No");
                return -1;
            } else {
                return Integer.parseInt(this.vm.pnum.getText());
            }
        } catch (NumberFormatException nfm) {
            System.out.println("error nfe");
            return -1;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER && playerNum() != -1) {
            C_playerNames pns = new C_playerNames(vm, this);
            vm.setVisible(false);
            pns.run();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
