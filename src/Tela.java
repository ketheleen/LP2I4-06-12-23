/*
    Autores:
    Ketheleen Cristine Simão dos Santos CB3011836
    Lucas Henrique de Souza Santos CB3012212
 */

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela implements ActionListener {
    private Conexao conexao = new Conexao();
    private Aluno aluno;
    private JFrame tela = new JFrame();
    private JLabel labelNome = new JLabel("Nome:");
    private JLabel labelIdade = new JLabel("Idade:");
    private JLabel labelPeso = new JLabel("Peso");
    private JLabel labelAltura = new JLabel("Altura");
    private JLabel labelObjetivo = new JLabel("Objetivo");
    private JTextField textoNome = new JTextField(10);
    private JTextField textoIdade = new JTextField(10);
    private JTextField textoPeso = new JTextField(10);
    private JTextField textoAltura = new JTextField(10);
    private JTextField textoObjetivo = new JTextField(10);
    private JButton buttonIncluir = new JButton();
    private JButton buttonLimpar = new JButton();
    private JButton buttonApresentar = new JButton();
    private JButton buttonSair = new JButton();
    private JPanel panel = new JPanel();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();

    Tela() {
        tela.setSize(400, 280);
        tela.setLocation(200, 200);
        tela.setTitle("TpFinal - Lp2I4");
        tela.add(panel);
        panel.add(panel1);
        panel1.setLayout(new GridLayout(5, 2, 10, 10));
        panel1.add(labelNome);
        panel1.add(textoNome);
        panel1.add(labelIdade);
        panel1.add(textoIdade);
        panel1.add(labelPeso);
        panel1.add(textoPeso);
        panel1.add(labelAltura);
        panel1.add(textoAltura);
        panel1.add(labelObjetivo);
        panel1.add(textoObjetivo);
        panel.add(panel2);
        panel2.add(buttonIncluir);
        buttonIncluir.setText("Incluir");
        buttonIncluir.addActionListener(this);
        panel2.add(buttonLimpar);
        buttonLimpar.setText("Limpar");
        buttonLimpar.addActionListener(this);
        panel2.add(buttonApresentar);
        buttonApresentar.setText("Apresentar");
        buttonApresentar.addActionListener(this);
        panel2.add(buttonSair);
        buttonSair.setText("Sair");
        buttonSair.addActionListener(this);
        tela.setVisible(true);
    }

    public void clean() {
        textoNome.setText("");
        textoIdade.setText("");
        textoAltura.setText("");
        textoPeso.setText("");
        textoObjetivo.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        String x = e.getActionCommand();
        if ("Incluir".equals(x)) {
            conexao.incluir(textoNome.getText(), Integer.parseInt(textoIdade.getText()), Float.parseFloat(textoPeso.getText()), Float.parseFloat(textoAltura.getText()), textoObjetivo.getText());
        }
        if ("Limpar".equals(x)) {
            clean();
        }

        if ("Apresentar".equals(x)) {
            aluno = new Aluno(textoNome.getText(), Integer.parseInt(textoIdade.getText()), Float.parseFloat(textoPeso.getText()), Float.parseFloat(textoAltura.getText()), textoObjetivo.getText());
            Gson gson = new Gson();
            String y = gson.toJson(aluno);

            y = y.replace("{", "{\n     ");
            y = y.replace(",", ",\n     ");
            y = y.replace("}", "\n}");

            JOptionPane.showMessageDialog(null, y, "Json", JOptionPane.INFORMATION_MESSAGE);
        }
        if ("Sair".equals(x)) {
            tela.dispose();
        }
    }

    public static void main(String[] args) {
        Tela tela = new Tela();
    }
}