package gui;

import application.Main;
import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;
import util.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FrameCadastro extends JFrame implements ActionListener {

    private final JTextField txtNome;
    private final JTextField txtTelefone;
    private final JTextField txtDoc;

    private final JComboBox<String> opcaoPessoa;

    //Construtor frame
    public FrameCadastro() {

        //Configs frame
        setTitle("Cadastro");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(400, 500);

        //Instanciando panel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.lightGray);
        GridBagConstraints gbc = new GridBagConstraints();


        //Adicionando componentes ao panel
        JLabel title = new JLabel("Cadastrar Pessoas");
        title.setFont(new Font("JetBrains Mono", Font.ITALIC, 25));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weighty = 1;
        panel.add(title, gbc);

        JLabel lblNome = new JLabel("Nome: ");
        lblNome.setFont(new Font("JetBrains Mono", Font.BOLD, 16));
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(lblNome, gbc);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setFont(new Font("JetBrains Mono", Font.BOLD, 16));
        gbc.gridy = 3;
        panel.add(lblTelefone, gbc);

        JLabel lblDoc = new JLabel("CPF/CNPJ:");
        lblDoc.setFont(new Font("JetBrains Mono", Font.BOLD, 16));
        gbc.gridy = 5;
        panel.add(lblDoc, gbc);

        txtNome = new JTextField(20);
        txtNome.setBorder(null);
        txtNome.setFont(new Font("JetBrains Mono", Font.BOLD, 16));
        txtNome.setForeground(Color.DARK_GRAY);
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel.add(txtNome, gbc);

        txtTelefone = new JTextField(20);
        txtTelefone.setBorder(null);
        txtTelefone.setFont(new Font("JetBrains Mono", Font.BOLD, 16));
        txtTelefone.setForeground(Color.DARK_GRAY);
        gbc.gridy = 4;
        panel.add(txtTelefone, gbc);

        txtDoc = new JTextField(20);
        txtDoc.setBorder(null);
        txtDoc.setFont(new Font("JetBrains Mono", Font.BOLD, 16));
        txtDoc.setForeground(Color.DARK_GRAY);
        gbc.gridy = 6;
        panel.add(txtDoc, gbc);

        BasicComboBoxRenderer.UIResource uiResource = new BasicComboBoxRenderer.UIResource();
        uiResource.setHorizontalAlignment(SwingConstants.CENTER);

        String[] tipos = {"Pessoa Física", "Pessoa Jurídica"};
        opcaoPessoa = new JComboBox(tipos);
        opcaoPessoa.setRenderer(uiResource);
        opcaoPessoa.setForeground(Color.WHITE);
        opcaoPessoa.setBackground(Color.darkGray);
        opcaoPessoa.setFont(new Font("JetBrains Mono", Font.BOLD, 16));
        opcaoPessoa.setBorder(null);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 7;
        panel.add(opcaoPessoa, gbc);

        JButton btn = new JButton("Cadastrar");
        btn.setFont(new Font("JetBrains Mono", Font.BOLD, 16));
        btn.setMargin(new Insets(10, 10, 20, 20));
        btn.setBackground(Color.DARK_GRAY);
        btn.setForeground(Color.WHITE);
        btn.setFocusable(false);
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btn, gbc);
        btn.addActionListener(this);

        //Adicionando panel ao frame
        add(panel);
        setVisible(true);
    }

    //Implementando actionlistener
    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            cadastrarPessoa(e, Main.pessoas);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Algo deu errado: " + ex.getMessage(), "Vc é burro?", JOptionPane.ERROR_MESSAGE);
        }

    }

    //Método de cadastro
    private void cadastrarPessoa(ActionEvent e, List<Pessoa> pessoas) throws Exception {

        String tipoPessoa = (String) opcaoPessoa.getSelectedItem();
        String nome = txtNome.getText();
        Validador.validarNome(nome);
        String telefone = txtTelefone.getText();
        Validador.validarTelefone(telefone);
        telefone = Formatador.formatarTelefone(telefone);
        String documento = txtDoc.getText();
        Validador.validarDoc(documento, tipoPessoa);

        Pessoa novaPessoa;
        if ("Pessoa Física".equals(tipoPessoa)) {
            novaPessoa = new PessoaFisica(nome, telefone, documento);
        } else {
            novaPessoa = new PessoaJuridica(nome, telefone, documento);
        }

        pessoas.add(novaPessoa);
        JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!", "Deu certo!", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(" ************************");
        System.out.println(" Pessoas Cadastradas");
        System.out.println(" ************************");

        for (Pessoa pessoa: Main.pessoas){
            pessoa.seApresentar();
        }
    }
}