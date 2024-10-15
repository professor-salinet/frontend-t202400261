import java.awt.*;
import java.util.*;
import javax.swing.*;

public class ColoredList {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                    JFrame f = new JFrame("Users");
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.setSize(300, 300);

                    JList<User> list = new JList(new Vector<User>() {
                        {
                            add(new User("Black", Color.BLACK));
                            add(new User("Blue", Color.BLUE));
                            add(new User("Cyan", Color.CYAN));
                            add(new User("Dark Gray", Color.DARK_GRAY));
                            add(new User("Gray", Color.GRAY));
                            add(new User("Green", Color.GREEN));
                            add(new User("Light Gray", Color.LIGHT_GRAY));
                            add(new User("Magenta", Color.MAGENTA));
                            add(new User("Orange", Color.ORANGE));
                            add(new User("Pink", Color.PINK));
                            add(new User("Red", Color.RED));
                            add(new User("White", Color.WHITE));
                            add(new User("Yellow", Color.YELLOW));
                        }
                    });

                    list.setCellRenderer(new DefaultListCellRenderer() {

                        @Override
                        public Component getListCellRendererComponent(JList list, Object value, int index,
                                boolean isSelected, boolean cellHasFocus) {
                            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                            if (value instanceof User) {
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
                                    setForeground(Color.WHITE);
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

                                if (isSelected) {
                                        setBackground(getBackground().darker());
                                }
                            } else {
                                setText("whodat?");
                            }
                            return c;
                        }

                    });
                    f.add(new JScrollPane(list), BorderLayout.CENTER);
                    f.setVisible(true);
            }
        });
    }

    static class User {
        String name = "NN";
        Color color = Color.ORANGE;

        public User(String name, Color color) {
            this.name = name;
            this.color = color;
        }
    }
}