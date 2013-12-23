package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Edwin on 19/12/13.
 */
public class ToolBar extends JToolBar implements ActionListener {
    public ToolBar() {
        super();

        // Initialisation de la toolbar
        setFloatable(false);
        setBackground(Color.DARK_GRAY);
        setSize(0, 25);
        setPreferredSize(getSize());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
