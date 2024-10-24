import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TelaDePesquisa extends JFrame {
    public final JTextField txtPesquisa;
    public final JButton btnPesquisar;

    public final JLabel lblId;
    public final JTextField txtId;

    public final JLabel lblNome;
    public final JTextField txtNome;

    public final JLabel lblEmail;
    public final JTextField txtEmail;

    public final JButton btnPrimeiro;
    public final JButton btnAnterior;
    public final JButton btnProximo;
    public final JButton btnUltimo;

    public final JLabel lblNotificacoes;

    public TelaDePesquisa() {
        super("Tela de Pesquisa");
        setLayout(new GridLayout(7,1,5,5));

        JPanel linhaInputPesquisa = new JPanel(new GridLayout(1,1));
        txtPesquisa = new JTextField(20);
        linhaInputPesquisa.add(txtPesquisa);
        add(linhaInputPesquisa);

        JPanel linhaBotaoPesquisar = new JPanel(new GridLayout(1,1));
        btnPesquisar = new JButton("Pesquisar");
        linhaBotaoPesquisar.add(btnPesquisar);
        add(linhaBotaoPesquisar);

        JPanel linhaId = new JPanel(new GridLayout(1,2));
        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        txtId = new JTextField(10);
        txtId.setEditable(false);
        linhaId.add(lblId);
        linhaId.add(txtId);
        add(linhaId);

        JPanel linhaNome = new JPanel(new GridLayout(1,2));
        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        txtNome = new JTextField(10);
        txtNome.setEditable(false);
        linhaNome.add(lblNome);
        linhaNome.add(txtNome);
        add(linhaNome);

        JPanel linhaEmail = new JPanel(new GridLayout(1,2));
        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        txtEmail = new JTextField(10);
        txtEmail.setEditable(false);
        linhaEmail.add(lblEmail);
        linhaEmail.add(txtEmail);
        add(linhaEmail);

        JPanel linhaBotoes = new JPanel(new GridLayout(1,4));
        btnPrimeiro = new JButton("<<");
        btnAnterior = new JButton("<");
        btnProximo = new JButton(">");
        btnUltimo = new JButton(">>");
        linhaBotoes.add(btnPrimeiro);
        linhaBotoes.add(btnAnterior);
        linhaBotoes.add(btnProximo);
        linhaBotoes.add(btnUltimo);
        add(linhaBotoes);

        JPanel linhaNotificacoes = new JPanel(new GridLayout(1,1));
        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        linhaNotificacoes.add(lblNotificacoes);
        add(linhaNotificacoes);

        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        TelaDePesquisa appTelaDePesquisa = new TelaDePesquisa();
        appTelaDePesquisa.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}