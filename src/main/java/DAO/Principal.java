/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.Calendar;
import javax.swing.JOptionPane;
import model.ModelAluno;

/**
 *
 * @author Cpd01
 */
public class Principal {

    public static void main(String[] args) {

        
        // Teste para saber se está salvando no Banco
        
        /*     ModelTurma modelTurma = new ModelTurma();
        modelTurma.setTurmaNome("2 Maternal");
        modelTurma.setTurmaDescricao("Texto descrição");
        modelTurma.setTurmaStatus("Ativo");
        
        DaoTurma daoTurma = new DaoTurma();
        daoTurma.salvarAluno(modelTurma);
        JOptionPane.showMessageDialog(null, "Salvou!");*/
        
        
        
        
        // Teste para saber se está salvando no Banco
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();

        ModelAluno aluno = new ModelAluno();
        aluno.setAluEscolaOrigem("escola origem");
        aluno.setPesNome("Neto");
        aluno.setAluObs("obs");
        aluno.setAluStatus("status");
        aluno.setPesCpf(0645);
        aluno.setPesDtnasc(calendar.getTime());
        aluno.setPesRg("rg");
        aluno.setPesFiliacao("filiacao");
        aluno.setPesNaturalidade("naturalidade");

        DaoAluno daoAluno = new DaoAluno();
        daoAluno.salvarAluno(aluno);
        JOptionPane.showMessageDialog(null, "Salvou!");

    }

}
