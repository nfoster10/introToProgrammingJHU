import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;

public class LoanCalculator extends Application
{
	private TextField annualInteretRateText;
	private TextField numberOfYearsText;
	private TextField loanAmountText;
	private TextField monthlyPaymentText;
	private TextField totalPaymentText;

	public static void main(String [] args)
	{
		launch(args);
	}

	public void start(Stage loanCalculatorGUI)
	{
		loanCalculatorGUI.setTitle("Loan Calculator");
		GridPane rootNode = new GridPane(); // create a root node to layout stuff
		rootNode.setPadding(new Insets(40));
		rootNode.setHgap(5);
		rootNode.setVgap(5);
		Scene myScene = new Scene(rootNode, 400, 250); // create a scene 

		Label annualInteretRateLabel = new Label ("Annual Interest Rate:  "); // create a label
		annualInteretRateText = new TextField();
		rootNode.add( annualInteretRateLabel, 0, 0);
		rootNode.add( annualInteretRateText, 1, 0); // add the label to the scene graph

		Label numberOfYearsLabel = new Label("Number of Years: "); // create a label
		numberOfYearsText = new TextField();
		rootNode.add( numberOfYearsLabel, 0, 1);
		rootNode.add( numberOfYearsText, 1, 1); // add the label to the scene graph

		Label loanAmountLabel = new Label("Loan Amount: "); // create a label
		loanAmountText = new TextField();
		rootNode.add( loanAmountLabel, 0, 2);
		rootNode.add( loanAmountText, 1, 2); // add the label to the scene graph

		Label monthlyPaymentLabel = new Label("Monthly Payment: ");
		monthlyPaymentText = new TextField("");
		monthlyPaymentText.setEditable(false);
		rootNode.add( monthlyPaymentLabel, 0, 3);
		rootNode.add( monthlyPaymentText, 1, 3); // add the label to the scene graph

		Label totalPaymentLabel = new Label      ("Total Payment: ");
		totalPaymentText = new TextField("");
		totalPaymentText.setEditable(false);
		rootNode.add( totalPaymentLabel, 0, 4);
		rootNode.add( totalPaymentText, 1, 4); // add the label to the scene graph

		Button calculateButton = new Button("Calculate");
		rootNode.add(calculateButton, 1, 5);
		rootNode.setHalignment(calculateButton, HPos.RIGHT);

		calculateButton.setOnAction(new LoanCalculatorCalculateButtonHandler());

		loanCalculatorGUI.setScene( myScene ); // set the scene on the stage 
		loanCalculatorGUI.show(); // show the stage & its scene
	}

	private class LoanCalculatorCalculateButtonHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent buttonPress)
		{
			Double monthlyPayment;
			Double totalPayment;

			try {
				double annualInteretRate = Double.parseDouble(annualInteretRateText.getText());
				annualInteretRate = annualInteretRate > 1 ? annualInteretRate / 100 : annualInteretRate;
				int numberOfYears = Integer.parseInt(numberOfYearsText.getText());
				double loanAmount = Double.parseDouble(loanAmountText.getText());

				monthlyPayment = (double) 0;
				totalPayment = 0.0;

				monthlyPayment = (annualInteretRate * loanAmount) / (1 - Math.pow((1+annualInteretRate), -(12*numberOfYears)));
				totalPayment = monthlyPayment * 12 * numberOfYears;
			}
			catch (NumberFormatException e){
				monthlyPaymentText.setText("INVALID INPUTS");
				totalPaymentText.setText("INVALID INPUTS");
				return;
			}

			monthlyPaymentText.setText(String.format("%.2f", monthlyPayment));
			totalPaymentText.setText(String.format("%.2f", totalPayment));
		}
	}
}