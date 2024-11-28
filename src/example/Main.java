package org.example;

import org.example.dto.SubclasseDTO;
import org.example.servico.CnaeApiService;

import javax.swing.*;
import java.awt.*;

public class Main{

    public static void main(String[] args) {
        // Criação da janela principal
        JFrame frame = new JFrame("Consulta Subclasse CNAE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Painel para entrada de dados
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        JLabel label = new JLabel("Código da Subclasse CNAE:");
        JTextField textField = new JTextField(20);
        JButton searchButton = new JButton("Buscar");
        inputPanel.add(label);
        inputPanel.add(textField);
        inputPanel.add(searchButton);

        // Área para exibição das informações
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setPreferredSize(new Dimension(480, 250));

        // Adicionando os componentes à janela principal
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Lógica do botão de busca
        searchButton.addActionListener(e -> {
            String subclasseId = textField.getText().trim();
            if (subclasseId.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Por favor, insira o código da subclasse.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                CnaeApiService cnaeApiService = new CnaeApiService();
                SubclasseDTO subclasseDTO = cnaeApiService.buscarSubclassePorId(subclasseId);

                // Exibindo as informações
                outputArea.setText(" INFORMAÇÕES DA SUBCLASSE\n");
                outputArea.append("--------------------------------------------------\n");
                outputArea.append(" ID: " + subclasseDTO.getId() + "\n");
                outputArea.append(" Descrição: " + subclasseDTO.getDescricao() + "\n");
                outputArea.append(" Classe: " + subclasseDTO.getClasse().getDescricao() + "\n");
                outputArea.append(" Grupo: " + subclasseDTO.getClasse().getGrupo().getDescricao() + "\n");
                outputArea.append(" Divisão: " + subclasseDTO.getClasse().getGrupo().getDivisao().getDescricao() + "\n");
                outputArea.append(" Seção: " + subclasseDTO.getClasse().getGrupo().getDivisao().getSecao().getDescricao() + "\n");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao buscar informações da subclasse: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Exibindo a janela
        frame.setVisible(true);
    }
}
