/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author nguyen van cuong
 */
public class CloseTabButton extends JPanel implements ActionListener {
  private JTabbedPane pane;
  public CloseTabButton(JTabbedPane pane, int index) {
    this.pane = pane;
    setOpaque(false);
    add(new JLabel(
        pane.getTitleAt(index),
        pane.getIconAt(index),
        JLabel.LEFT));
    Icon closeIcon = new CloseIcon();
    JButton btClose = new JButton(closeIcon);
    btClose.setPreferredSize(new Dimension(
        closeIcon.getIconWidth(), closeIcon.getIconHeight()));
    add(btClose);
    btClose.addActionListener(this);
    pane.setTabComponentAt(index, this);
  }
  public void actionPerformed(ActionEvent e) {
    int i = pane.indexOfTabComponent(this);
    if (i != -1) {
      pane.remove(i);
    }
  }
}
class CloseIcon implements Icon {
  public void paintIcon(Component c, Graphics g, int x, int y) {
    g.setColor(Color.RED);
    g.drawLine(6, 6, getIconWidth() - 7, getIconHeight() - 7);
    g.drawLine(getIconWidth() - 7, 6, 6, getIconHeight() - 7);
  }
  public int getIconWidth() {
    return 17;
  }
  public int getIconHeight() {
    return 17;
  }
}
