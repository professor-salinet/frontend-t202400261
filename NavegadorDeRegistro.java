import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class NavegadorDeRegistro extends TelaDePesquisa {
    public static String registroDePesquisa = "";
    public static String clausulasDePesquisaComWhere = "";
    public static String clausulasDePesquisaSemWhere = "";

    public static void registrarPesquisa() {
        registroDePesquisa = txtPesquisa.getText().trim();
        if (registroDePesquisa.length() > 0) {
            clausulasDePesquisaComWhere = " where `nome` like '%" + registroDePesquisa + "%' or `email` like '%" + registroDePesquisa + "%'";
            clausulasDePesquisaSemWhere = " and (`nome` like '%" + registroDePesquisa + "%' or `email` like '%" + registroDePesquisa + "%')";
        }
        vaParaPrimeiroRegistro();
    }

    public static void inicializacaoDeRegistros() {
        vaParaPrimeiroRegistro();
    }

    public static void vaParaPrimeiroRegistro() {
        try {
            String strSqlInicializacao = "select * from `db_senac`.`tbl_senac` " + clausulasDePesquisaComWhere + " order by `id` asc;";
            Connection conexao = MySQLConnector.conectar();
            Statement stmSqlInicializacao = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlInicializacao = stmSqlInicializacao.executeQuery(strSqlInicializacao);

            int qtdResultados = 0;
            while (rstSqlInicializacao.next()) {
                qtdResultados++;
            }

            if (rstSqlInicializacao.first()) {
                txtId.setText(rstSqlInicializacao.getString("id"));
                txtNome.setText(rstSqlInicializacao.getString("nome"));
                txtEmail.setText(rstSqlInicializacao.getString("email"));
                notificarUsuario("Foram encontrados \"" + qtdResultados + "\" registros. Primeiro registro posicionado com sucesso!");
                habilitarAvancar();
            } else {
                limparCampos();
                desabilitarTodos();
                notificarUsuario("Não foram encontrados registros.");
            }
            stmSqlInicializacao.close();
        } catch (Exception e) {
            notificarUsuario("Ops! Houve um problema no servidor e não será possível inicializar os registros no momento. Por favor, retorne novamente mais tarde.");
            System.err.println("Erro: " + e);
        }
    }

    public static void vaParaProximoRegistro() {
        try {
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where `id` > " + txtId.getText() + clausulasDePesquisaSemWhere + " order by `id` asc;";
            Connection conexao = MySQLConnector.conectar();
            Statement stmSqlProximoRegistro = conexao.createStatement();
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            if (rstSqlProximoRegistro.next()) {
                txtId.setText(rstSqlProximoRegistro.getString("id"));
                txtNome.setText(rstSqlProximoRegistro.getString("nome"));
                txtEmail.setText(rstSqlProximoRegistro.getString("email"));
                notificarUsuario("Próximo registro posicionado com sucesso!");
                habilitarTodos();
            } else {
                habilitarVoltar();
                notificarUsuario("Não foram encontrados registros adiante.");
            }
            stmSqlProximoRegistro.close();
        } catch (Exception e) {
            notificarUsuario("Ops! Houve um problema no servidor e não será possível inicializar os registros no momento. Por favor, retorne novamente mais tarde.");
            System.err.println("Erro: " + e);
        }
    }

    public static void vaParaUltimoRegistro() {
        try {
            String strSqlUltimoRegistro = "select * from `db_senac`.`tbl_senac` " + clausulasDePesquisaComWhere + " order by `id` desc;";
            Connection conexao = MySQLConnector.conectar();
            Statement stmSqlUltimoRegistro = conexao.createStatement();
            ResultSet rstSqlUltimoRegistro = stmSqlUltimoRegistro.executeQuery(strSqlUltimoRegistro);
            if (rstSqlUltimoRegistro.next()) {
                txtId.setText(rstSqlUltimoRegistro.getString("id"));
                txtNome.setText(rstSqlUltimoRegistro.getString("nome"));
                txtEmail.setText(rstSqlUltimoRegistro.getString("email"));
                notificarUsuario("Último registro posicionado com sucesso!");
                habilitarVoltar();
            } else {
                notificarUsuario("Não foram encontrados registros.");
            }
            stmSqlUltimoRegistro.close();
        } catch (Exception e) {
            notificarUsuario("Ops! Houve um problema no servidor e não será possível inicializar os registros no momento. Por favor, retorne novamente mais tarde.");
            System.err.println("Erro: " + e);
        }
    }

    public static void vaParaRegistroAnterior() {
        try {
            String strSqlRegistroAnterior = "select * from `db_senac`.`tbl_senac` where `id` < " + txtId.getText() + clausulasDePesquisaSemWhere + " order by `id` desc;";
            Connection conexao = MySQLConnector.conectar();
            Statement stmSqlRegistroAnterior = conexao.createStatement();
            ResultSet rstSqlRegistroAnterior = stmSqlRegistroAnterior.executeQuery(strSqlRegistroAnterior);
            if (rstSqlRegistroAnterior.next()) {
                txtId.setText(rstSqlRegistroAnterior.getString("id"));
                txtNome.setText(rstSqlRegistroAnterior.getString("nome"));
                txtEmail.setText(rstSqlRegistroAnterior.getString("email"));
                notificarUsuario("Registro anterior posicionado com sucesso!");
                habilitarTodos();
            } else {
                habilitarAvancar();
                notificarUsuario("Não foram encontrados registros anteriores.");
            }
            stmSqlRegistroAnterior.close();
        } catch (Exception e) {
            notificarUsuario("Ops! Houve um problema no servidor e não será possível inicializar os registros no momento. Por favor, retorne novamente mais tarde.");
            System.err.println("Erro: " + e);
        }
    }
}
