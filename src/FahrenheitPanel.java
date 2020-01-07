import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FahrenheitPanel extends JPanel {
    private JLabel inputLabel, outputLabel, resultLabel;
    private JTextField fahrenheit;
    private JButton CButton, FButton;

    public FahrenheitPanel(){
        inputLabel = new JLabel("Enter Fahrenheit or Celsius Temperature: ");
        outputLabel = new JLabel("Fahrenheit/Celsius Conversion: ");
        resultLabel = new JLabel("---");
        CButton = new JButton("Celsius Conversion");
        FButton = new JButton("Fahrenheit Conversion");

        fahrenheit = new JTextField(5);
        add(inputLabel);
        add(fahrenheit);
        add(outputLabel);
        add(resultLabel);
        add(CButton);
        add(FButton);

        setPreferredSize(new Dimension(500, 75));
        TempListener buttonListener = new TempListener();
        CButton.addActionListener(buttonListener);
        FButton.addActionListener(buttonListener);

    }
    public class TempListener implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            int fahrenheitTemp, celsiusTemp;
            String text = fahrenheit.getText();
            if(event.getSource() == CButton){
                celsiusTemp = Integer.parseInt(text);
                resultLabel.setText(Integer.toString((celsiusTemp-32) * 5/9));
            } else if (event.getSource() == FButton){
                fahrenheitTemp = Integer.parseInt(text);
                resultLabel.setText(Integer.toString((fahrenheitTemp*9/5) + 32));
            }

        }
    }
}

