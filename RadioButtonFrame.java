import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonFrame extends JFrame 
{
   private JTextField textField;

   private Font plainFont;
   private Font boldFont;
   private Font italicFont;
   private Font boldItalicFont;

   private Color blackColor;
   private Color redColor;
   private Color blueColor;
   private Color yellowColor;

   private JRadioButton plainJRadioButton;
   private JRadioButton boldJRadioButton;
   private JRadioButton italicJRadioButton;
   private JRadioButton boldItalicJRadioButton;

   private JRadioButton blackJRadioButton;
   private JRadioButton redJRadioButton;
   private JRadioButton blueJRadioButton;
   private JRadioButton yellowJRadioButton;

   private ButtonGroup radioGroup;
   private ButtonGroup colorRadioGroup;

   public RadioButtonFrame()
   {
      super("RadioButton Test");
      setLayout(new FlowLayout()); 

      textField = new JTextField("Watch the font style change", 25);
      add(textField);

      plainJRadioButton = new JRadioButton("Plain", true);
      boldJRadioButton = new JRadioButton("Bold", false);
      italicJRadioButton = new JRadioButton("Italic", false);
      boldItalicJRadioButton = new JRadioButton("Bold/Italic", false);
      add(plainJRadioButton);
      add(boldJRadioButton);
      add(italicJRadioButton);
      add(boldItalicJRadioButton);

      radioGroup = new ButtonGroup();
      radioGroup.add(plainJRadioButton);
      radioGroup.add(boldJRadioButton);
      radioGroup.add(italicJRadioButton);
      radioGroup.add(boldItalicJRadioButton);

      plainFont = new Font("Serif", Font.PLAIN, 14);
      boldFont = new Font("Serif", Font.BOLD, 14);
      italicFont = new Font("Serif", Font.ITALIC, 14);
      boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
      textField.setFont(plainFont);

      plainJRadioButton.addItemListener(
         new RadioButtonHandler(plainFont));
      boldJRadioButton.addItemListener(
         new RadioButtonHandler(boldFont));
      italicJRadioButton.addItemListener(
         new RadioButtonHandler(italicFont));
      boldItalicJRadioButton.addItemListener(
         new RadioButtonHandler(boldItalicFont));

      blackJRadioButton = new JRadioButton("Black", true);
      redJRadioButton = new JRadioButton("Red", false);
      blueJRadioButton = new JRadioButton("Blue", false);
      yellowJRadioButton = new JRadioButton("Yellow", false);
      add(blackJRadioButton);
      add(redJRadioButton);
      add(blueJRadioButton);
      add(yellowJRadioButton);

      colorRadioGroup = new ButtonGroup();
      colorRadioGroup.add(blackJRadioButton);
      colorRadioGroup.add(redJRadioButton);
      colorRadioGroup.add(blueJRadioButton);
      colorRadioGroup.add(yellowJRadioButton);

      blackColor = Color.BLACK;
      redColor = Color.RED;
      blueColor = Color.BLUE;
      yellowColor = Color.YELLOW;

      textField.setForeground(blackColor);

      blackJRadioButton.addItemListener(
         new ColorRadioButtonHandler(blackColor));
      redJRadioButton.addItemListener(
         new ColorRadioButtonHandler(redColor));
      blueJRadioButton.addItemListener(
         new ColorRadioButtonHandler(blueColor));
      yellowJRadioButton.addItemListener(
         new ColorRadioButtonHandler(yellowColor));
   } 

   private class RadioButtonHandler implements ItemListener 
   {
      // public ItemListener() {
      private Font font;

      public RadioButtonHandler(Font f)
      {
         font = f; 
      } 
   
      @Override
      public void itemStateChanged(ItemEvent event)
      {
         textField.setFont(font); 
      } 
   } 

   private class ColorRadioButtonHandler implements ItemListener 
   {
      private Color color;

      public ColorRadioButtonHandler(Color c)
      {
         color = c; 
      } 
   
      @Override
      public void itemStateChanged(ItemEvent event)
      {
         textField.setForeground(color); 
      } 
   } 
}