import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TelaDeLogin extends JFrame {
    private final JLabel lblLogin;
    private final JTextField txtLogin;
    private final JLabel lblSenha;
    private final JPasswordField txtSenha;
    private final JButton btnLogar;
    private final JLabel lblNotificacoes;

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

        lblNotificacoes = new JLabel("Notificações");
        add(lblNotificacoes);
    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                Connection conexao = MySQLConnector.conectar();
                String strSqlLogin = "select * from `db_senac`.`tbl_senac` where email = '" + txtLogin.getText() + "' and senha = '" + String.valueOf(txtSenha.getPassword()) + "';";
                Statement stmSqlLogin = conexao.createStatement();
                ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin);
                if (rstSqlLogin.next()) {
                    // aqui vamos notificar o usuario que o login e senha foram encontrados
                } else {
                    // aqui vamos notificar o usuario que o login e senha não foram encontrados
                }
            } catch (Exception e) {
                System.err.println("Ops! Deu ruim, se liga no erro: " + e);
            }
        }
    }

    public static void main(String[] args) {
        TelaDeLogin appTelaDeLogin = new TelaDeLogin();
        appTelaDeLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);
        appTelaDeLogin.setSize(150,200);
        appTelaDeLogin.setVisible(true);
    }
}