package br.com.fiap.bean;

import javax.swing.*;
import java.io.File;

public class Diretorio {
    private File dir;

    public Diretorio() {
    }

    public File getDir() {
        return dir;
    }

    public void setDir(File dir) {
        this.dir = dir;
    }

    public boolean criaDiretorio() {
        boolean ret = false;
        try {
            String path = JOptionPane.showInputDialog("Digite o caminho do diretório:");
            dir = new File(path);
            if (!dir.exists()) {
                dir.mkdir();
                JOptionPane.showMessageDialog(null, "Diretório " + dir.getName() + " criado com sucesso!");
                ret = true;
                System.out.println(ret);
            } else {
                JOptionPane.showMessageDialog(null, "Diretório " + dir.getName() + " já existe!", "Erro", JOptionPane.ERROR_MESSAGE);
                System.out.println(ret);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public void listaDiretorio() {
        try {
            String path = JOptionPane.showInputDialog("Digite o caminho da pasta (utilize / entre as pastas:");
            dir = new File(path);
            if (dir.isDirectory()) {
                JOptionPane.showMessageDialog(null, "Conteudo da pasta: " + path);
                String[] lista = dir.list();
                if (lista != null) {
                    String listaCompleta = "";
                    for (String item : lista) {
                        listaCompleta += item + "\n";
                        System.out.println(item);
                    }
                    JOptionPane.showMessageDialog(null, listaCompleta);
                }
            } else {
                JOptionPane.showMessageDialog(null, "O caminho informado não é um diretório", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void excluiDiretorio() {
        try {
            String path = JOptionPane.showInputDialog("Digite o caminho do diretório que deseja excluir:");
            String msg = "";
            dir = new File(path);
            if (dir.isDirectory()) {
                int escolha = JOptionPane.showConfirmDialog(null, "Deseja excluir o diretório " + dir.getName() + "?", "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (escolha == 0) {
                    if (dir.delete()) {
                        msg = dir.getName() + " excluído com sucesso!";
                        JOptionPane.showMessageDialog(null, msg);
                    } else {
                        if (excluirFilhos(dir)) {
                            msg = dir.getName() + " excluído com sucesso!";
                            JOptionPane.showMessageDialog(null, msg);
                        } else {
                            msg = "Falha! " + dir.getName() + " não foi excluído!";
                            JOptionPane.showMessageDialog(null, msg);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean excluirFilhos(File dir) {
        if (dir.isDirectory()) {
            String[] conteudo = dir.list();
            for (String item : conteudo) {
                boolean sucesso = excluirFilhos(new File(dir, item));
                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Arquivo " + item + " excluído com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Arquivo " + item + " não foi excluído!");
                    return false;
                }
            }

        }
        return dir.delete();
    }
}


