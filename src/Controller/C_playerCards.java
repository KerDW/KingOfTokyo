/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.M_Pcard;
import View.V_board;
import View.V_playerCards;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Álvaro
 */
public class C_playerCards {

    private V_playerCards vpc;
    private V_board vb;
    private C_game cg;

    public C_playerCards(V_board vb, C_game cg) {
        this.vb = vb;
        this.cg = cg;
        this.vpc = new V_playerCards();
    }

    public void run() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vpc.setVisible(true);
                vpc.setTitle("King of Tokyo - Player cards");
                vpc.setLocation(0,0); // Place the window in position 0, in the center.
                updateCards();
            }
        });
    }

    public void updateCards() {
        DefaultTableModel dtm = new DefaultTableModel(0, 0) {
            @Override
            public Class<?> getColumnClass(int column) {
                Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class
                };
                return types[column];
            }
            boolean[] canEdit = new boolean[]{
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        String header[] = {"Nombre", "Efecto"};
        dtm.setColumnIdentifiers(header);
        vpc.tabla.getTableHeader().setEnabled(false);
        vpc.tabla.setModel(dtm);
        for (M_Pcard c : cg.getPlayers().get(cg.getPlayerTurn()).getCards()) {
            Object[] item = {c.getName(), c.getEffect()};
            dtm.addRow(item);
        }
    }

}
