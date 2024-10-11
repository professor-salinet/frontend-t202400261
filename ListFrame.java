import java.awt.*;
// import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
// import javax.swing.plaf.basic.*;
import java.util.*;

public class ListFrame extends JFrame {
    private JTextField txtExemplo;

    private final JList<String> colorJList;
    private static final String[] colorNames = { "Black", "Blue", "Cyan",
            "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
            "Orange", "Pink", "Red", "White", "Yellow" };
    private static final Color[] colors = { Color.BLACK, Color.BLUE,
            Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
            Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
            Color.RED, Color.WHITE, Color.YELLOW };

    private final JList<String> sizeJList;
    private static final String[] sizeNames = { "Small", "Medium", "Big" };

    private final JList<String> styleJList;
    private static final String[] styleNames = { "Normal", "Negrito", "Itálico" };
    private static final Font[] styles = {
            new Font("Serif", Font.PLAIN, 14),
            new Font("Serif", Font.BOLD, 14),
            new Font("Serif", Font.ITALIC, 14)
    };

    private final JScrollPane colorJScrollPane;

    public ListFrame() {
        super("List Test");
        setLayout(new FlowLayout());

        txtExemplo = new JTextField("Exemplo", 30);
        add(txtExemplo);

        colorJList = new JList<String>(colorNames);

        JList<User> coloredList = new JList(
            new Vector<User>() {
                {
                    add(new User(colorNames[0], colors[0]));
                    add(new User(colorNames[1], colors[1]));
                    add(new User(colorNames[2], colors[2]));
                    add(new User(colorNames[3], colors[3]));
                    add(new User(colorNames[4], colors[4]));
                    add(new User(colorNames[5], colors[5]));
                    add(new User(colorNames[6], colors[6]));
                    add(new User(colorNames[7], colors[7]));
                    add(new User(colorNames[8], colors[8]));
                    add(new User(colorNames[9], colors[9]));
                    add(new User(colorNames[10], colors[10]));
                    add(new User(colorNames[11], colors[11]));
                    add(new User(colorNames[12], colors[12]));
                }
            }
        );

        colorJList.setCellRenderer(
            new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    // if (value instanceof User) {
                        User nextUser = (User) value;
                        setText(nextUser.name);

                        if (nextUser.name == "Black") {
                            setBackground(Color.BLACK);
                            setForeground(Color.WHITE);
                        }

                        if (nextUser.name == "Blue") {
                            setBackground(Color.BLUE);
                        }

                        if (nextUser.name == "Cyan") {
                            setBackground(Color.CYAN);
                        }
        
                        if (nextUser.name == "Dark Gray") {
                            setBackground(Color.DARK_GRAY);
                        }
        
                        if (nextUser.name == "Gray") {
                            setBackground(Color.GRAY);
                        }

                        if (nextUser.name == "Green") {
                            setBackground(Color.GREEN);
                        }

                        if (nextUser.name == "Light Gray") {
                            setBackground(Color.LIGHT_GRAY);
                        }

                        if (nextUser.name == "Magenta") {
                            setBackground(Color.MAGENTA);
                        }

                        if (nextUser.name == "Orange") {
                            setBackground(Color.ORANGE);
                        }

                        if (nextUser.name == "Pink") {
                            setBackground(Color.PINK);
                        }

                        if (nextUser.name == "Red") {
                            setBackground(Color.RED);
                        }

                        if (nextUser.name == "White") {
                            setBackground(Color.WHITE);
                        }

                        if (nextUser.name == "Yellow") {
                            setBackground(Color.YELLOW);
                        }
                        // if (isSelected) {
                        //         setBackground(getBackground().darker());
                        // }
                    // } else {
                    //     setText("whodat?");
                    // }
                    return c;
                }
            }
        );

        colorJList.setVisibleRowCount(5);
        colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        colorJScrollPane = new JScrollPane(colorJList);
        add(colorJScrollPane);

        colorJList.addListSelectionListener(
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent event) {
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
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent event) {
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
                            setSize(350, 170);
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
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent event) {
                    txtExemplo.setFont(
                            styles[styleJList.getSelectedIndex()]);
                }
            }
        );
    }

    static class User {
        String name = "NN";
        Color color = Color.WHITE;

        public User(String name, Color color) {
            this.name = name;
            this.color = color;
        }
    }
}