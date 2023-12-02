/*
    Autores:
    Ketheleen Cristine Simão dos Santos CB3011836
    Lucas Henrique de Souza Santos CB3012212
 */

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    private Connection Con = null;
    private Statement Stmt = null;

    public Conexao() {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AULA_JAVA", "root", "123456");
            Stmt = Con.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO VERIFIQUE A CONEXÃO COM O BANCO DE DADOS");
        }
    }

    public void incluir(String nome, int idade, float peso, float altura, String objetivo) {
        try {
            Stmt.executeUpdate("INSERT INTO ALUNOS (NOME, IDADE, PESO, ALTURA, OBJETIVO) VALUES (" + "'" + nome + "'" + "," + idade + "," + peso + "," + altura + ",'" + objetivo + "');");
            JOptionPane.showMessageDialog(null, "ENVIADO");
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO: OS DADOS NÃO FORAM ENVIADOS PARA O BANCO DE DADOS.");
        }
    }
}