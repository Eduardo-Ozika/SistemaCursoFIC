import com.eduardoozika.entity.Celular;
import com.eduardoozika.entity.Curso;
import com.eduardoozika.entity.Estudante;
import com.eduardoozika.entity.TurmaCurso;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class TurmaCursoTest {
    @Test
    @DisplayName("Cadastra uma Turma")
    void DeveriaCadastrarUmaTurma(){
        LocalDate inicioAulas = LocalDate.parse("2022-02-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate fimAulas = LocalDate.parse("2022-07-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate inicioMatriculas = LocalDate.parse("2021-12-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate fimMatriculas = LocalDate.parse("2022-01-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        assertDoesNotThrow(()->{
            new TurmaCurso("108sul", 2, inicioAulas, fimAulas,inicioMatriculas,fimMatriculas);
        });
    }
    @Test
    @DisplayName("Não Deveria Cadastrar uma Turma sem data")
    void DeveriaNaoCadastrarCursoSemData(){
        LocalDate fimAulas = LocalDate.parse("2022-07-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate inicioMatriculas = LocalDate.parse("2021-12-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate fimMatriculas = LocalDate.parse("2022-01-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        assertThrowsExactly(IllegalArgumentException.class,()->{
            new TurmaCurso("108sul", 2, null, fimAulas,inicioMatriculas,fimMatriculas);
        });
    }
    @Test
    @DisplayName("Não Deveria Cadastrar uma Turma sem local")
    void DeveriaNaoCadastrarCursoSemLocal(){
        LocalDate fimAulas = LocalDate.parse("2022-07-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate inicioMatriculas = LocalDate.parse("2021-12-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate fimMatriculas = LocalDate.parse("2022-01-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        assertThrowsExactly(IllegalArgumentException.class,()->{
            new TurmaCurso("", 2, null, fimAulas,inicioMatriculas,fimMatriculas);
        });
    }

}
