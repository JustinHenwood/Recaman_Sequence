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

/**
 * <b>RecamanSequence.java</b> <br>
 * This class contains method main and is the starting point for this program.  This class creates two 
 * objects: The first is an object of class model and the second is an object of class view.  These 
 * objects handle the Sequencer and GUI respectively.  Then an instance of controller class is called 
 * and which take in the model and view objects as parameters.  Controller class houses the main logic 
 * this program.
 * 
 * @author Justin Henwood 
 * @version 2.0
 * @since 52
 */
public class RecamanSequence {
	
	/**
	 * <b>main</b> <br>
	 * This method is the starting point for the program.  It first creates and object of model which 
	 * contains the sequencing algorithm.  Next it creates an object of view which houses GUI logic and 
	 * by extension, the programs input/output.  Finally, the object of both model and view are put into 
	 * an instance of Controller class as arguments.  This class is in charge of taking input from the GUI
	 * and passing it to the model.  As well as taking a calculated sequence and passing it to the GUI's 
	 * output.
	 * @param args method main array of type String
	 */
	public static void main (String [] args) {
		Model model = new Model();
		View view = new View();
		new Controller(view, model);
	}
	
}
