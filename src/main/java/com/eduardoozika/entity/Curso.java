package com.eduardoozika.entity;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private String cargaHoraria;
    private String Descricao;
    private List<TurmaCurso> turmas = new ArrayList<>();

    public Curso(String nome, String cargaHoraria, String descricao) {
        if (Vazio(nome) || Vazio(cargaHoraria) || Vazio(descricao))
            throw new IllegalArgumentException("Obrigatoriedade:todos os valores devem ser informados");
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        Descricao = descricao;
    }

    public Boolean Vazio(String string) {
        if(string==null)
            return true;
        if (string.trim().isEmpty())
            return true;
        return false;
    }
}
