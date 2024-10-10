import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MultipleSelectionFrame extends JFrame 
{
   private final JList<String> colorJList; 
   private final JList<String> copyJList; 
   private JButton copyJButton; 
   private static final String[] colorNames = {"Black", "Blue", "Cyan",
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", 
      "Pink", "Red", "White", "Yellow"};

   private final JList<String> fruitJList;
   private final JList<String> copyFruitJList;
   private JButton copyFruitJButton; 
   private static final String[] fruitNames = {"Banana", "Bacate", "Cerola",
      "Damasco", "Goiaba", "Graviola", "Laranja", "Maçã", "Nectarina", 
      "Ponka", "Romã", "Morango", "Melancia"};
      
   public MultipleSelectionFrame()
   {
      super("Multiple Selection Lists");
      setLayout(new FlowLayout());

      colorJList = new JList<String>(colorNames);
      colorJList.setVisibleRowCount(5);
      colorJList.setSelectionMode(
         ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      add(new JScrollPane(colorJList));

      copyJButton = new JButton("Copy >>>"); 
      copyJButton.addActionListener(
         new ActionListener() 
         {  
            
            @Override
            public void actionPerformed(ActionEvent event)
            {
               
               copyJList.setListData(
                  colorJList.getSelectedValuesList().toArray(
                     new String[0]));
            }
         } 
      ); 

      add(copyJButton); 

      copyJList = new JList<String>(); 
      copyJList.setVisibleRowCount(5); 
      copyJList.setFixedCellWidth(100); 
      copyJList.setFixedCellHeight(15); 
      copyJList.setSelectionMode(
         ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      add(new JScrollPane(copyJList));

      fruitJList = new JList<String>(fruitNames);
      fruitJList.setVisibleRowCount(5);
      fruitJList.setSelectionMode(
         ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      add(new JScrollPane(fruitJList));

      copyFruitJButton = new JButton("Copy >>>"); 
      copyFruitJButton.addActionListener(
         new ActionListener() 
         {  
            
            @Override
            public void actionPerformed(ActionEvent event)
            {
               
               copyFruitJList.setListData(
                  fruitJList.getSelectedValuesList().toArray(
                     new String[0]));
            }
         } 
      ); 

      add(copyFruitJButton); 

      copyFruitJList = new JList<String>(); 
      copyFruitJList.setVisibleRowCount(5); 
      copyFruitJList.setFixedCellWidth(100); 
      copyFruitJList.setFixedCellHeight(15); 
      copyFruitJList.setSelectionMode(
         ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      add(new JScrollPane(copyFruitJList));
   }
} 
