package button;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ButtonFrame extends JFrame {
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	//increments with change button click
	int numClick = 0;
	
	public ButtonFrame() {
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		setTitle("Color Generator");
		//create buttons
		JButton changeButton = new JButton("Change");
		JButton resetButton = new JButton("Reset");
		JButton closeButton = new JButton("Close");
		
		buttonPanel = new JPanel();
		
		//add buttons to panel
		buttonPanel.add(changeButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(closeButton);
		
		//add panel to frame
		add(buttonPanel);
		
		//create button actions

		ChangeAction changeAction = new ChangeAction();
		ResetAction resetAction = new ResetAction(Color.GRAY);
		CloseAction closeAction = new CloseAction();
		
		//associate actions with buttons		
		changeButton.addActionListener(changeAction);
		resetButton.addActionListener(resetAction);
		closeButton.addActionListener(closeAction);
	}
	
	/* An action listener that sets the panel's background color */
	private class ChangeAction implements ActionListener
	{
		private Color backgroundColor;
	
		public ChangeAction()
		{
			if (numClick % 4 == 0) {
				backgroundColor = Color.BLACK;
			} else if (numClick % 4 == 1) {
				backgroundColor = Color.GREEN;
			} else if (numClick % 4 == 2) {
				backgroundColor = Color.ORANGE;
			} else if (numClick % 4 == 3) {
				backgroundColor = Color.PINK;
			}
			numClick++;

		}
		
		public void actionPerformed(ActionEvent event)
		{
			buttonPanel.setBackground(backgroundColor);
		}
	}
	
	private class CloseAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.exit(0);
		}
	}
	
	private class ResetAction implements ActionListener
	{
		private Color backgroundColor;
		
		public ResetAction(Color c)
		{
			backgroundColor = c;
			//numClick = 0;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			buttonPanel.setBackground(backgroundColor);
		}
	}
}
