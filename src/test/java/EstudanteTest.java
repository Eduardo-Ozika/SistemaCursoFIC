import com.eduardoozika.entity.Celular;
import com.eduardoozika.entity.Estudante;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class EstudanteTest {
    @Test
    @DisplayName("Cadastra um estudante")
    void DeveriaCadastrarEstudante(){
        LocalDate date = LocalDate.parse("2002-07-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Celular celular = new Celular("63981371158");
        List<Celular> celulares = new ArrayList<>();
        celulares.add(celular);
        assertDoesNotThrow(()->{
            new Estudante("Eduardo", date,"704 sul","eduardo.vicente@estudante.ifto.edu.br",celulares);
        });
    }
    @Test
    @DisplayName("Não Cadastra um estudante sem nome")
    void DeveriaNaoCadastrarEstudanteSemNome(){
        LocalDate date = LocalDate.parse("22-07-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Celular celular = new Celular("63981371158");
        List<Celular> celulares = new ArrayList<>();
        celulares.add(celular);
        assertThrowsExactly(java.lang.IllegalArgumentException.class,()->{
            new Estudante(" ", date,"704 sul","eduardo.vicente@estudante.ifto.edu.br",celulares);
        });
    }@Test
    @DisplayName("Não Cadastra um estudante com menos de 15 anos")
    void DeveriaNaoCadastrarEstudanteComMenosDe15Anos(){
        LocalDate date = LocalDate.parse("22-07-2010", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Celular celular = new Celular("63981371158");
        List<Celular> celulares = new ArrayList<>();
        celulares.add(celular);
        assertThrowsExactly(java.lang.IllegalArgumentException.class,()->{
            new Estudante("Eduardo", date,"704 sul","eduardo.vicente@estudante.ifto.edu.br",celulares);
        });
    }
    @Test
    @DisplayName("Não Cadastra um estudante sem data de aniversario")
    void DeveriaNaoCadastrarEstudanteSemData() {
        Celular celular = new Celular("63981371158");
        List<Celular> celulares = new ArrayList<>();
        celulares.add(celular);
        assertThrowsExactly(java.lang.IllegalArgumentException.class, () -> {
            new Estudante("Eduardo", null, "704 sul", "eduardo.vicente@estudante.ifto.edu.br", celulares);
        });
    }
    @Test
    @DisplayName("Não Cadastra um estudante sem ao menos um celular")
    void DeveriaNaoCadastrarEstudanteSemCelular(){
        LocalDate date = LocalDate.parse("22-07-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        List<Celular> celulares = new ArrayList<>();
        assertThrowsExactly(java.lang.IllegalArgumentException.class,()->{
            new Estudante("Eduardo", date,"704 sul","eduardo.vicente@estudante.ifto.edu.br",celulares);
        });
    }
    @Test
    @DisplayName("Não Cadastra um estudante sem uma lista")
    void DeveriaNaoCadastrarEstudanteSemListaDeCelular(){
        LocalDate date = LocalDate.parse("22-07-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        assertThrowsExactly(java.lang.IllegalArgumentException.class,()->{
            new Estudante("Eduardo", date,"704 sul","eduardo.vicente@estudante.ifto.edu.br",null);
        });
    }
}
