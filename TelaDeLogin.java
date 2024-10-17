import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeLogin extends JFrame {
    private final JLabel lblLogin;
    private final JTextField txtLogin;
    private final JLabel lblSenha;
    private final JPasswordField txtSenha;
    private final JButton btnLogar;

    public TelaDeLogin() {
        super("Tel de Login");
        setLayout(new FlowLayout());

        lblLogin = new JLabel("Login:");
        add(lblLogin);

        txtLogin = new JTextField(10);
        add(txtLogin);

        lblSenha = new JLabel("Senha:");
        add(lblSenha);

        txtSenha = new JPasswordField(10);
        add(txtSenha);

        btnLogar = new JButton("Logar");
        add(btnLogar);
    }
}