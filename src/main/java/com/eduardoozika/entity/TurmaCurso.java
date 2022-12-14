package com.eduardoozika.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TurmaCurso {
    private String local;
    private int vagas;
    private int vagasDisponiveis;
    private LocalDate inicioAulas;
    private LocalDate fimAulas;
    private LocalDate inicioMatriculas;
    private LocalDate fimMatriculas;
    private EstudantesMatriculados estudantesMatriculados;

    public TurmaCurso(String local, int vagas, LocalDate inicioAulas, LocalDate fimAulas, LocalDate inicioMatriculas, LocalDate fimMatriculas) {
        if (Vazio(local) || Vazio(vagas) || Vazio(inicioAulas) || Vazio(fimAulas) || Vazio(inicioAulas)|| Vazio(fimMatriculas))
            throw new IllegalArgumentException("Obrigatoriedade:todos os valores devem ser informados");
        this.local = local;
        this.vagas = vagas;
        this.vagasDisponiveis = vagas;
        this.inicioAulas = inicioAulas;
        this.fimAulas = fimAulas;
        this.inicioMatriculas = inicioMatriculas;
        this.fimMatriculas = fimMatriculas;
        this.estudantesMatriculados = new EstudantesMatriculados();
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public String getPeriodoMatricula() {
        return " inicio: "+inicioMatriculas+" fim: " +fimMatriculas;
    }
    public void AddEstudante(Estudante estudante){
        if(this.vagasDisponiveis>0 &&this.estudantesMatriculados.podeMatricular(this.inicioMatriculas,this.fimMatriculas)){
            this.estudantesMatriculados.getEstudantes().add(estudante);
            vagasDisponiveis--;
            System.out.println(vagasDisponiveis);
        }else
            throw new IllegalArgumentException("Nao esta no periodo coreto da matricula"+getPeriodoMatricula());
    }
    public Boolean Vazio(String string) {
        if(string==null)
            return true;
        if (string.trim().isEmpty())
            return true;
        return false;
    }
    public Boolean Vazio(LocalDate dataNascimento) {
        if (dataNascimento == null)
            return true;
        return false;
    }
    public Boolean Vazio(int vagas){
        if (vagas == 0)
            return true;
        return false;
    }
}
