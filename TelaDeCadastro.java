import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeCadastro extends JFrame {
    public final JLabel lblNome;
    public final JTextField txtNome;

    public final JLabel lblEmail;
    public final JTextField txtEmail;

    public final JLabel lblSenha;
    public final JPasswordField txtSenha;

    public final JButton btnCadastrar;
    public final JButton btnCancelar;

    public final JLabel lblNotificacoes;

    public TelaDeCadastro() {
        super("Tela de Cadastro");
        setLayout(new GridLayout(5,1,5,5));

        JPanel linhaNome = new JPanel(new GridLayout(1,2));

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        txtNome = new JTextField(10);

        linhaNome.add(lblNome);
        linhaNome.add(txtNome);

        add(linhaNome);

        JPanel linhaEmail = new JPanel(new GridLayout(1,2));

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        txtEmail = new JTextField(10);

        linhaEmail.add(lblEmail);
        linhaEmail.add(txtEmail);

        add(linhaEmail);

        JPanel linhaSenha = new JPanel(new GridLayout(1,2));

        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT);
        txtSenha = new JPasswordField(10);

        linhaSenha.add(lblSenha);
        linhaSenha.add(txtSenha);

        add(linhaSenha);

        JPanel linhaBotoes = new JPanel(new GridLayout(1,2));

        btnCadastrar = new JButton("Cadastrar");
        btnCancelar = new JButton("Cancelar");

        linhaBotoes.add(btnCadastrar);
        linhaBotoes.add(btnCancelar);

        add(linhaBotoes);

        JPanel linhaNotificacoes = new JPanel(new GridLayout(1,1));

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);

        linhaNotificacoes.add(lblNotificacoes);

        add(linhaNotificacoes);

        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        TelaDeCadastro appTelaDeCadastro = new TelaDeCadastro();
        appTelaDeCadastro.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}