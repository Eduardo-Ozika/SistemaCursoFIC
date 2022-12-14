import com.eduardoozika.entity.Celular;
import com.eduardoozika.entity.Estudante;
import com.eduardoozika.entity.TurmaCurso;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class EstudantesMatriculadosTest {
    @Test
    @DisplayName("Deveria Cadastrar um Estudante")
    void DeveriaCadastrarUmaEstudantenaTurma(){
        LocalDate inicioAulas = LocalDate.parse("2022-02-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate fimAulas = LocalDate.parse("2022-07-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate inicioMatriculas = LocalDate.parse("2021-12-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate fimMatriculas = LocalDate.parse("2022-01-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        TurmaCurso turma1 = new TurmaCurso("108sul", 2, inicioAulas, fimAulas,inicioMatriculas,fimMatriculas);

        LocalDate date = LocalDate.parse("2002-07-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Celular celular = new Celular("63981371158");
        List<Celular> celulares = new ArrayList<>();
        celulares.add(celular);
        Estudante estudante = new Estudante("Eduardo", date,"704 sul","eduardo.vicente@estudante.ifto.edu.br",celulares);
        assertDoesNotThrow(()->{
            turma1.AddEstudante(estudante);
        });
    }
}
