package com.eduardoozika.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Estudante {
    private String nome;
    private String matricula;
    private LocalDate dataNascimento;
    private String endereco;
    private String emailInstitucional;
    private List<Celular> celular;

    public Estudante(String nome, LocalDate dataNascimento, String endereco, String emailInstitucional, List<Celular> celular) {
        if (Vazio(nome) || Vazio(endereco) || Vazio(emailInstitucional) || Vazio(dataNascimento) || Vazio(celular)||idade(dataNascimento))
            throw new IllegalArgumentException("Obrigatoriedade:todos os valores devem ser informados");
        this.nome = nome;
        this.matricula = gerarMatricula();
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.emailInstitucional = emailInstitucional;
        this.celular = celular;
    }

    private boolean idade(LocalDate dataNascimento) {
        int anos = LocalDate.now().compareTo(dataNascimento);
        System.out.println(anos);
        if(anos<15)
            return true;
        return false;
    }

    private String gerarMatricula() {
        String matricula = "";
        Random gen = new Random();
        matricula += gen.nextInt(10);
        return matricula;
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

    public Boolean Vazio(List<Celular> celulares) {
        if (celulares == null)
            return true;
        if (celulares.size() == 0)
            return true;
        return false;
    }
}
