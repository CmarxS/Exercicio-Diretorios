package br.com.fiap.main;

import br.com.fiap.bean.Pessoa;

import javax.swing.*;
import java.io.IOException;

public class UsaPessoa {
    public static void main(String[] args) {
        String aux, codigo, nome, email, path;
        int opcao;
        Pessoa pessoa;
        do {
            try {
                aux = JOptionPane.showInputDialog("""
                        Faça sua escolha:
                        1- Cadastrar
                        2- Consultar""");
                opcao = Integer.parseInt(aux);
                path = JOptionPane.showInputDialog("Digite o caminho da pasta");
                pessoa = new Pessoa();
                switch (opcao) {
                    case 1:
                        codigo = JOptionPane.showInputDialog("Digite o código");
                        nome = JOptionPane.showInputDialog("Digite o nome");
                        email = JOptionPane.showInputDialog("Digite o email");
                        pessoa.setCodigo(codigo);
                        pessoa.setNome(nome);
                        pessoa.setEmail(email);
                        JOptionPane.showMessageDialog(null, pessoa.gravar(path), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 2:
                        codigo = JOptionPane.showInputDialog("Digite o código");
                        pessoa.setCodigo(codigo);
                        pessoa = pessoa.ler(path);
                        if (pessoa == null) {
                            JOptionPane.showMessageDialog(null, "Caminho e/ou código informado inexistentes!", "Falha", JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Exibindo dados " + "\nCaminho: " + path
                                    + "\nArquivo: " + path + "/" + pessoa.getCodigo() + ".txt" + "\nCodigo: " + pessoa.getCodigo() + "\nNome: " + pessoa.getNome() + "\nE-mail: " + pessoa.getEmail());
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Escolha incorreta", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro de conversão\n " + e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao acessar\n " + e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
        } while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de programa...", "Fim", JOptionPane.WARNING_MESSAGE);
    }
}
