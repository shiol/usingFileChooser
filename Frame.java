import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    JFileChooser chooser = new JFileChooser();
	JButton button = new JButton("Local");
	public String currentDirectory = "";

    public Frame() {
        setSize(100, 100);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (JFileChooser.DIRECTORY_CHANGED_PROPERTY.equals(evt.getPropertyName())) {
                    currentDirectory = chooser.getSelectedFile().toString();
                    chooser.approveSelection();
                }
            }
        });
		getContentPane().add(chooser);

		button.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
				chooser.showDialog(null, "OK");
		    }
	    });
		getContentPane().add(button);

		addWindowListener(new WindowListener() {

	        @Override
	        public void windowOpened(WindowEvent e) {
	            button.doClick();
	        }

	        @Override
	        public void windowClosing(WindowEvent e) {
	        }

	        @Override
	        public void windowClosed(WindowEvent e) {
	        }

	        @Override
	        public void windowIconified(WindowEvent e) {
	        }

	        @Override
	        public void windowDeiconified(WindowEvent e) {
	        }

	        @Override
	        public void windowActivated(WindowEvent e) {
	        }

	        @Override
	        public void windowDeactivated(WindowEvent e) {
	        }
	    });
	}
}