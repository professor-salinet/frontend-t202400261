import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuFrame extends JFrame 
{
   private final Color[] colorValues = 
      {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN};

   private final JRadioButtonMenuItem[] colorItems;
   private final JRadioButtonMenuItem[] fonts;
   private final JRadioButtonMenuItem[] sizes;
   
   private final JCheckBoxMenuItem[] styleItems;

   private final JLabel displayJLabel;

   private final ButtonGroup fontButtonGroup;
   private final ButtonGroup colorButtonGroup;
   private final ButtonGroup sizeButtonGroup;

   private final int[] fontSizes = {12, 24, 48, 72};
  
   public MenuFrame()
   {
      super("Using JMenus");     

      JMenu fileMenu = new JMenu("File");
      fileMenu.setMnemonic('F');

      JMenuItem aboutItem = new JMenuItem("About...");
      aboutItem.setMnemonic('A');
      fileMenu.add(aboutItem);
      aboutItem.addActionListener(
         new ActionListener()
         {  
            @Override
            public void actionPerformed(ActionEvent event)
            {
               JOptionPane.showMessageDialog(MenuFrame.this,
                  "This is an example\nof using menus",
                  "About", JOptionPane.PLAIN_MESSAGE);
            } 
         } 
      ); 

      JMenuItem exitItem = new JMenuItem("Exit");
      exitItem.setMnemonic('x');
      fileMenu.add(exitItem);
      exitItem.addActionListener(
         new ActionListener()
         {  
            @Override
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            } 
         }
      ); 

      JMenuBar bar = new JMenuBar();
      setJMenuBar(bar);
      bar.add(fileMenu);

      JMenu formatMenu = new JMenu("Format");
      formatMenu.setMnemonic('r');
     
      String[] colors = {"Black", "Blue", "Red", "Green"};

      JMenu colorMenu = new JMenu("Color");
      colorMenu.setMnemonic('C');
     
      colorItems = new JRadioButtonMenuItem[colors.length];
      colorButtonGroup = new ButtonGroup();
      ItemHandler itemHandler = new ItemHandler();
     
      for (int count = 0; count < colors.length; count++) 
      {
         colorItems[count] = 
            new JRadioButtonMenuItem(colors[count]);
         colorMenu.add(colorItems[count]);
         colorButtonGroup.add(colorItems[count]);
         colorItems[count].addActionListener(itemHandler);
      }

      colorItems[0].setSelected(true);

      formatMenu.add(colorMenu);
      formatMenu.addSeparator();
     
      String[] fontNames = {"Serif", "Monospaced", "SansSerif"};
      JMenu fontMenu = new JMenu("Font");
      fontMenu.setMnemonic('n');
     
      fonts = new JRadioButtonMenuItem[fontNames.length];
      fontButtonGroup = new ButtonGroup();
     
      for (int count = 0; count < fonts.length; count++) 
      {
         fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
         fontMenu.add(fonts[count]);
         fontButtonGroup.add(fonts[count]);
         fonts[count].addActionListener(itemHandler);
      } 

      fonts[0].setSelected(true);
      fontMenu.addSeparator();

      String[] styleNames = {"Bold", "Italic"};
      styleItems = new JCheckBoxMenuItem[styleNames.length];
      StyleHandler styleHandler = new StyleHandler();

      for (int count = 0; count < styleNames.length; count++) 
      {
         styleItems[count] = 
            new JCheckBoxMenuItem(styleNames[count]);
         fontMenu.add(styleItems[count]);
         styleItems[count].addItemListener(styleHandler);
      }

      fontMenu.addSeparator();

      sizes = new JRadioButtonMenuItem[fontSizes.length];
      sizeButtonGroup = new ButtonGroup();

      for (int count = 0; count < fontSizes.length; count++) 
      {
         sizes[count] = 
            new JRadioButtonMenuItem(String.valueOf(fontSizes[count]));
         fontMenu.add(sizes[count]);
         sizeButtonGroup.add(sizes[count]);
         sizes[count].addActionListener(itemHandler);
      }

      sizes[3].setSelected(true);

      formatMenu.add(fontMenu);
      bar.add(formatMenu);
     
      displayJLabel = new JLabel("Sample Text", SwingConstants.CENTER);
      displayJLabel.setForeground(colorValues[0]);
      displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72));

      getContentPane().setBackground(Color.CYAN);
      add(displayJLabel, BorderLayout.CENTER);
      setSize(500, 200); // linha de código injetada do MenuTest.java
      setVisible(true); // linha de código injetada do MenuTest.java
   }

  
   private class ItemHandler implements ActionListener 
   {
      @Override
      public void actionPerformed(ActionEvent event)
      {
         // for (int count = 0; count < colorItems.length; count++)
         // {
         //    if (colorItems[count].isSelected()) 
         //    {
         //       displayJLabel.setForeground(colorValues[count]);
         //       break;
         //    } 
         // }
         definirCor();

         // for (int count = 0; count < fonts.length; count++)
         // {
         //    if (event.getSource() == fonts[count]) 
         //    {
         //       displayJLabel.setFont(
         //          new Font(fonts[count].getText(), style, displayJLabel.getFont().getSize()));
         //    }
         // }
         definirFonte();

         // for (int count = 0; count < sizes.length; count++)
         // {
         //    if (sizes[count].isSelected()) 
         //    {
         //       displayJLabel.setFont(
         //          new Font(displayJLabel.getFont().getName(), style, fontSizes[count]));
         //    }
         // }
         definirTamanho();

         repaint();
      } 
   }

   public void definirTamanho() {
      for (int count = 0; count < sizes.length; count++)
      {
         if (sizes[count].isSelected())
         {
            displayJLabel.setFont(
               new Font(displayJLabel.getFont().getName(), displayJLabel.getFont().getStyle(), fontSizes[count]));
         }
      }
   }

   public void definirFonte() {
      for (int count = 0; count < fonts.length; count++)
      {
         if (fonts[count].isSelected()) 
         {
            displayJLabel.setFont(
               new Font(fonts[count].getText(), displayJLabel.getFont().getStyle(), displayJLabel.getFont().getSize()));
         }
      }
   }

   public void definirCor() {
      for (int count = 0; count < colorItems.length; count++)
      {
         if (colorItems[count].isSelected())
         {
            displayJLabel.setForeground(colorValues[count]);
            break;
         } 
      }
   }
   
   private class StyleHandler implements ItemListener 
   {
     
      @Override
      public void itemStateChanged(ItemEvent e)
      {
         String name = displayJLabel.getFont().getName();
         Font font;

        
         if (styleItems[0].isSelected() && 
              styleItems[1].isSelected())
            font = new Font(name, Font.BOLD + Font.ITALIC, displayJLabel.getFont().getSize());
         else if (styleItems[0].isSelected())
            font = new Font(name, Font.BOLD, displayJLabel.getFont().getSize());
         else if (styleItems[1].isSelected())
            font = new Font(name, Font.ITALIC, displayJLabel.getFont().getSize());
         else
            font = new Font(name, Font.PLAIN, displayJLabel.getFont().getSize());

         displayJLabel.setFont(font);

         definirCor();
         definirFonte();
         definirTamanho();

         repaint();
      } 
   }
}