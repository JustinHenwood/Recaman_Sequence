/**
 * <b>Recamán Sequence</b> <br>
 * This program generates a Recamán Sequence with the given number of digits in the sequence specified 
 * by the user.  This program contains a GUI and utilizes the MVC design pattern.  The user enters the 
 * sequence length in a text box and selects the generate sequence button.  From there, an algorithm 
 * stores the sequence numbers in an Array List and then displays the full sequence in a Text Area within 
 * the GUI.
 * 
 * @author Justin Henwood 
 * <b>Date: </b> 2018-08-17 <br>
 */
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * <b>View.java</b> <br>
 * This class contains the logic for the programs GUI.  This class creates a basic GUI which allows the 
 * user to enter the desired length of a Recaman Sequence. This value is passed to Controller class and 
 * then Model class where it is used to create the sequence.  When the fully formed sequence is returned, 
 * it is displayed in a non-editable JTextArea.  This class contains a constructor which creates the a JPanel 
 * and adds the various GUI components to the JPanel as well as some basic set up for the frame.  This class 
 * also contains three methods, the first of which is called addSequenceListener which adds an ActioListener  
 * to startBtn.  The second method gets the desired sequence length as specified by the user from a TextField 
 * and uses it to create a sequence of that length.  The last method is printSequence which accepts an ArrayList 
 * as a parameter and displays its contents in a JTextArea.
 * 
 * @author Justin Henwood
 * @version 2.0
 * @since 52
 */
public class View extends JFrame {
	private JButton startBtn = new JButton("Create Sequence");
	private JLabel instruction = new JLabel("Enter how many numbers you would like in your Recaman Sequence (> 0, < 1000)");
	private JFormattedTextField enterNum = new JFormattedTextField();
	private JTextArea output = new JTextArea("", 10, 30);

	private int sequenceSize = 0;

	/**
	 * <b>View</b> <br>
	 * Constructor that sets name, bounds, defaultCloseOperation, and visibility of JFrame as well as adding 
	 * components such as buttons, labels, textfields, and textareas to a JPanel.
	 */
	public View() {
		super("Recaman Sequence"); 

		JPanel panel = new JPanel();

		this.setBounds(700,300,500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.add(instruction);

		enterNum.setValue(new Double(sequenceSize));
		enterNum.setColumns(10);
		panel.add(enterNum);

		panel.add(startBtn);

		output.setEditable(false);

		panel.add(new JScrollPane(output));


		this.add(panel);
		setVisible(true); 
	}


	/**
	 * <b>addSequenceListener</b> <br>
	 * This method is called when the user selects the startBtn Button.
	 * 
	 * @param listenForStartButton ActionListener that listens for a click on startBtn
	 */
	void addSequenceListener(ActionListener listenForStartButton){
		startBtn.addActionListener(listenForStartButton);
	}

	/**
	 * <b>getSequenceSize</b> <br>
	 * This method returns the value entered into the TextField by the user to indicate the desired length of 
	 * the sequence.
	 * 
	 * @return Desired sequence length from Text Field specified by user.
	 */
	public int getSequenceSize() {
		int sequenceLength = 0;

		try {
			sequenceLength = Integer.parseInt(enterNum.getText());

			if (sequenceLength < 0) {
				return 0;
			}else {
				return sequenceLength;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Value must be less than 1000 and greater than 0", "Invalid Input", JOptionPane.WARNING_MESSAGE);
			return 0;
		}
	}

	/**
	 * <b>printSequence</b> <br>
	 * This method accepts accepts an ArrayList as a parameter and displays its contents in a non-editable 
	 * JTextArea.
	 * 
	 * @param sequence ArrayList of type Integer that stores the fully formed Recaman Sequence
	 */
	public void printSequence(ArrayList<Integer> sequence) {
		output.setText("");
		for (int i = 0; i < sequence.size(); i++) {
			output.append(sequence.get(i).toString() + "\n");
		}
	}

}
