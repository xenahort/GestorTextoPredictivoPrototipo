/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortextopredictivo;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author jcsp0003
 */
public class PopUpMenu {

    private final JPopupMenu Pmenu;
    private final javax.swing.JTextArea jt;

    public PopUpMenu(javax.swing.JTextArea jt, Font font) {
        this.jt = jt;
        JMenuItem menuItem;

        Pmenu = new JPopupMenu();
        menuItem = new JMenuItem("Predicción 1");
        Pmenu.add(menuItem);
        menuItem.addActionListener(new ActionListenerImpl(jt));
        menuItem = new JMenuItem("Predicción 2");
        Pmenu.add(menuItem);
        menuItem.addActionListener(new ActionListenerImpl(jt));
        menuItem = new JMenuItem("Predicción 3");
        Pmenu.add(menuItem);
        menuItem.addActionListener(new ActionListenerImpl(jt));
        menuItem = new JMenuItem("Predicción 4");
        Pmenu.add(menuItem);
        menuItem.addActionListener(new ActionListenerImpl(jt));
        menuItem = new JMenuItem("Predicción 5");
        Pmenu.add(menuItem);
        menuItem.addActionListener(new ActionListenerImpl(jt));
    }

    public void colocar(Component e, int x, int y, ArrayList<Ocurrencia> predicciones) {
        this.Pmenu.setVisible(false);
        this.Pmenu.removeAll();

        JMenuItem menuItem;
        for (int i = 0; i < predicciones.size(); i++) {
            menuItem = new JMenuItem(predicciones.get(i).getPrediccion());
            Pmenu.add(menuItem);
            menuItem.addActionListener(new ActionListenerImpl(jt));
        }

        this.Pmenu.show(e, x, y);
        this.jt.requestFocus();
    }

    private static class ActionListenerImpl implements ActionListener {

        private final javax.swing.JTextArea jt;

        public ActionListenerImpl(javax.swing.JTextArea jt) {
            this.jt = jt;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder sb = new StringBuilder(jt.getText());
            sb.insert(jt.getCaretPosition(), e.getActionCommand() + " ");
            jt.setText(sb.toString());
        }
    }
}
