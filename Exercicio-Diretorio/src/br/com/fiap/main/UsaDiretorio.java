package br.com.fiap.main;

import br.com.fiap.bean.Diretorio;

import javax.swing.*;

public class UsaDiretorio {
    public static void main(String[] args) {
    Diretorio diretorio = new Diretorio();
    int opcao = 0;
    do {
        try {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("1 - Criar diretório\n2 - Listar diretório\n3 - Excluir diretório\n4 - Sair"));
            switch (opcao) {
                case 1:
                    diretorio.criaDiretorio();
                    break;
                case 2:
                    diretorio.listaDiretorio();
                    break;
                case 3:
                    diretorio.excluiDiretorio();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saindo...", "Fim de programa", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }while (opcao != 4);
    }
}