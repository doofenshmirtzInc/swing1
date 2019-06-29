package swing2;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel{
	
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton submitButton;
	private FormListener formListener;
	 
	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		nameField = new JTextField(10); //int represents number of characters long the field will be
		occupationField = new JTextField(10);
		
		submitButton = new JButton("Submit");
		
		submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = nameField.getText();
				String occupation = occupationField.getText();
				
				FormEvent ev = new FormEvent(this, name, occupation); //this refers to FormPanel
				
				if(formListener != null) {
					formListener.formEventOccurred(ev);
				}
			}
			
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		//GridBagConstraints is used in conjunction with GridBagLayout
		GridBagConstraints gc = new GridBagConstraints();
		
		//initial set-up of the GridBag layout
		//necessary when going to be used otherwise will cause problems
		
		
		//******************First Row**********************
		
		gc.weightx = 1;  //weight of x coordinate relative to other x coordinates
		gc.weighty = .1;  //weight of y coordinate relative to other y coordinates
		
		gc.gridx = 0;  //position in x
		gc.gridy = 0;  //position in y
		gc.insets = new Insets(0, 0, 0, 5); //allows for insertion of pixels around object
											//this line inserts 5 pixels after nameLabel
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;  //where the added objects are anchored in reference to the
													//they are on
		add(nameLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		add(nameField, gc);
		
		//*******************Second Row****************************
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.insets = new Insets(0, 0, 0, 5);
		add(occupationLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		add(occupationField, gc);
		
		//**********************Third Row*****************************
		
		gc.weightx = 1;
		gc.weighty = 2;
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(submitButton, gc);
	}
	
	
	public void setFormListener(FormListener listener) {
		this.formListener = listener;
	}
}
