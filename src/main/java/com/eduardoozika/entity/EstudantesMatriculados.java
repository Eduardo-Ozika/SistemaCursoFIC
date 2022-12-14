package com.eduardoozika.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EstudantesMatriculados {
    LocalDate dataMatricula;
    List<Estudante> estudantes = new ArrayList<>();

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    public Boolean podeMatricular(LocalDate inicioMatricula,LocalDate fimMatricula){
        setDataMatricula(LocalDate.parse("2022-01-20", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        if(this.dataMatricula.isAfter(inicioMatricula)&&this.dataMatricula.isBefore(fimMatricula))
            return true;
        else
            return false;
    }
}
