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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <b>Controller.java</b> <br>
 * This class acts as the intermediary between this programs GUI (View.java) and the Sequencer logic
 * (Model.java).  It is in charge of taking user input from the GUI and passing it along to the sequencer 
 * as well as taking the ArrayList produced by the sequencer and passing it the GUI to be displayed.  It 
 * first contains an initial constructor that takes in an object of View class and an object of Model class 
 * and copies their information into local objects.  The constructor then calls the addSequenceListener method
 * of the View object.  This method takes an ActionListener as a parameter in order to detect when a button 
 * is pressed in the GUI.  This method call creates a new instance of the inner class SequenceListener which 
 * implements ActionListener.  The purpose of this class is to call on different functions in order to create 
 * and display the sequence eachtime an action event is triggered. In this case an event is triggered when the 
 * "Create Sequence" button is pushed.
 * 
 * @author Justin Henwood 
 * @version 2.0
 * @since 52
 */
public class Controller {

	private View view;
	private Model model;

	/**
	 * <b>Controller constructor</b> <br>
	 * This is the default constructor for the Controller class.  It takes in an object of View class and an 
	 * object of Model class.  It then calls upon the addSequenceListener method of the View object.  This 
	 * method takes an ActionListener as a parameter in order to detect when a button is pressed in the GUI.  
	 * This method call creates a new instance of the inner class SequenceListener which implements 
	 * ActionListener.  The purpose of this class is to call on different functions in order to create and 
	 * display the sequence each time an action event is triggered. In this case an event is triggered when 
	 * the "Create Sequence" button is pushed.
	 * 
	 * @param view Object of View class. Used to display the programs GUI
	 * @param model Object of Model class. Used to create the desired sequence
	 */
	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
		this.view.addSequenceListener(new SequenceListener());
	}

	/**
	 * <b>SequenceListener</b> <br>
	 * This inner class implements ActionListener.  It contains one method, actionPerformed which is called when 
	 * the "Create Button" is pushed in the GUI.  When the button is pushed, the length of sequence specified 
	 * by the user is taken from the GUI and passed to the instance Model which sets the size of the sequence.  
	 * From there, a call to model's createSequence method creates the desired sequence.  Finally, the ArrayList 
	 * containing the the sequence is retrieved from model class and passed to view's printSequence method which 
	 * displays the sequence in a text area.
	 * 
	 * @author Justin Henwood 
	 * @version 2.0
	 * @since 52
	 */
	class SequenceListener implements ActionListener{

		/**
		 * <b>SequenceListener</b> <br>
		 * This method is called when the "Create Button" is pushed in the GUI.  When the button is pushed, the 
		 * length of sequence specified by the user is taken from the GUI and passed to the instance Model which 
		 * sets the size of the sequence.  From there, a call to model's createSequence method creates the desired 
		 * sequence.  Finally, the ArrayList containing the the sequence is retrieved from model class and passed 
		 * to view's printSequence method which displays the sequence in a text area.
		 */
		public void actionPerformed(ActionEvent e) {
			model.setSequenceSize(view.getSequenceSize());
			model.createSequence();
			view.printSequence(model.getSequence());
		}

	}
}
