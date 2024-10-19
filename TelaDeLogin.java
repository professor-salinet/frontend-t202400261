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

        ButtonHandler buttonHandler = new ButtonHandler();
        btnLogar.addActionListener(buttonHandler);

        txtSenha.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    if (String.valueOf(txtSenha.getPassword()).trim().length() > 0) {
                        if (e.getKeyCode() == 10) {
                            System.out.println("Você teclou Enter");
                            logar();
                        }
                    }
                }
            }
        );
    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            logar();
            // aqui será invocado o método de logar
        }
    }

    public void logar() {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlLogin = "select * from `db_senac`.`tbl_senac` where email = '" + txtLogin.getText() + "' and senha = '" + String.valueOf(txtSenha.getPassword()) + "';";
            Statement stmSqlLogin = conexao.createStatement();
            ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin);
            if (rstSqlLogin.next()) {
                notificarUsuario("Login realizado com sucesso.");
                // aqui vamos notificar o usuario que o login e senha foram encontrados
            } else {
                notificarUsuario("Não foi possível encontrar o login e/ou senha digitados. Por favor, verifique e tente novamente.");
                // aqui vamos notificar o usuario que o login e senha não foram encontrados
            }
        } catch (Exception e) {
            notificarUsuario("Houve um problema e não será possível realizar o login neste momento. Por favor, tente novamente mais tarde.");
            System.err.println("Ops! Deu ruim, se liga no erro: " + e);
        }
    }

    public String setHtmlFormat(String txt) {
        return "<html><body>" + txt + "</body></html>";
    }

    public void notificarUsuario(String strTexto) {
        lblNotificacoes.setText(setHtmlFormat(strTexto));
    }

    public static void main(String[] args) {
        TelaDeLogin appTelaDeLogin = new TelaDeLogin();
        appTelaDeLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);
        appTelaDeLogin.setSize(150,200);
        appTelaDeLogin.setVisible(true);
    }
}