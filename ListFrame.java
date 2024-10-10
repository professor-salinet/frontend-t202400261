import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.basic.*;

public class ListFrame extends JFrame 
{
   private JTextField txtExemplo;

   private final JList<String> colorJList;
   private static final String[] colorNames = {"Black", "Blue", "Cyan",
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
      "Orange", "Pink", "Red", "White", "Yellow"};
   private static final Color[] colors = {Color.BLACK, Color.BLUE,
      Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, 
      Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, 
      Color.RED, Color.WHITE, Color.YELLOW};

   private final JList<String> sizeJList;
   private static final String[] sizeNames = {"Small", "Medium", "Big"};

   private final JList<String> styleJList;
   private static final String[] styleNames = {"Normal", "Negrito", "Itálico"};
   private static final Font[] styles = {
      new Font("Serif", Font.PLAIN, 14),
      new Font("Serif", Font.BOLD, 14),
      new Font("Serif", Font.ITALIC, 14)
   };

   private final JScrollPane colorJScrollPane;

   public ListFrame()
   {
      super("List Test");
      setLayout(new FlowLayout()); 

      txtExemplo = new JTextField("Exemplo", 30);
      add(txtExemplo);

      colorJList = new JList<String>(colorNames);

      // Component c;
      // for (int i = 0; i < colors.length; i++) {
      //    c = new ListCellRenderer(colorJList, colorJList.getModel().getElementAt(i), i, false, false);
      //    c.setBackground(colors[i]);
      //    colorJList.add(c));
      // }

      colorJList.setCellRenderer(new ListCellRenderer());
      colorJList.setVisibleRowCount(5);
      colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      colorJScrollPane = new JScrollPane(colorJList);
      add(colorJScrollPane);

      colorJList.addListSelectionListener(
         new ListSelectionListener()
         {
            @Override
            public void valueChanged(ListSelectionEvent event)
            {
               getContentPane().setBackground(
                  colors[colorJList.getSelectedIndex()]);
            } 
         } 
      );

      sizeJList = new JList<String>(sizeNames);
      sizeJList.setVisibleRowCount(3);

      sizeJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      add(new JScrollPane(sizeJList));

      sizeJList.addListSelectionListener(
         new ListSelectionListener()
         {
            @Override
            public void valueChanged(ListSelectionEvent event)
            {
               switch (sizeJList.getSelectedIndex()) {
                  case 0:
                     setSize(350, 170);
                     break;

                  case 1:
                     setSize(550, 370);
                     break;

                  case 2:
                     setSize(750, 570);
                     break;

                  default:
                     setSize(350,170);
                     break;
               }
            } 
         } 
      );

      styleJList = new JList<String>(styleNames);

      styleJList.setVisibleRowCount(4);
     
      styleJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      add(new JScrollPane(styleJList));

      styleJList.addListSelectionListener(
         new ListSelectionListener()
         {
            @Override
            public void valueChanged(ListSelectionEvent event)
            {
               txtExemplo.setFont(
                  styles[styleJList.getSelectedIndex()]);
            } 
         } 
      );
   }

   private static class ListCellRenderer extends DefaultListCellRenderer {
      public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus, Color color) {
         Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
         c.setBackground(color);
         return c;
      }
  }
}