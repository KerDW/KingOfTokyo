/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.M_player;
import View.V_board;
import View.V_playerStats;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Álvaro
 */
public class C_playerStats {

    private V_playerStats vps;
    private V_board vb;
    private C_game cg;

    public C_playerStats(V_board vb, C_game cg) {
        this.vb = vb;
        this.cg = cg;
        this.vps = new V_playerStats();
    }

    public void run() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vps.setVisible(true);
                vps.setTitle("King of Tokyo - Player stats");
                vps.setLocation(590,50); // Place the window in position 0, in the center.
                updateTable();
            }
        });
    }

    public void updateTable() {
        DefaultTableModel dtm = new DefaultTableModel(0, 0) {
            @Override
            public Class<?> getColumnClass(int column) {
                Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
                };
                return types[column];
            }
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        String header[] = {"Jugador", "Vidas", "Ptos victoria", "Energia", "Control Tokyo"};
        dtm.setColumnIdentifiers(header);
        vps.tabla.getTableHeader().setEnabled(false);
        vps.tabla.setModel(dtm);
        for (M_player p : cg.getPlayers()) {
            if(p.getHp()>0){
            Object[] item = {p.getName(), p.getHp(), p.getWp(), p.getEnergy(), p.isTctrl()};
            dtm.addRow(item);
            }
        }
    }

}
