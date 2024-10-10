import javax.swing.*;

public class MultipleSelectionTest
{
   public static void main(String[] args)
   { 
      MultipleSelectionFrame multipleSelectionFrame =
         new MultipleSelectionFrame(); 
      multipleSelectionFrame.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE);
      multipleSelectionFrame.setSize(350, 300); 
      multipleSelectionFrame.setVisible(true); 
   } 
}