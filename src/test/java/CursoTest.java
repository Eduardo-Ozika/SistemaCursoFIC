import com.eduardoozika.entity.Celular;
import com.eduardoozika.entity.Curso;
import com.eduardoozika.entity.Estudante;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class CursoTest {
    @Test
    @DisplayName("Cadastra um Curso")
    void DeveriaCadastrarCurso(){
        assertDoesNotThrow(()->{
            new Curso("Sistemas", "10000h","Sistemas para Internet");
        });
    }
    @Test
    @DisplayName("Não Cadastra um estudante sem nome")
    void DeveriaNaoCadastrarCursoSemNome(){
        assertThrowsExactly(IllegalArgumentException.class,()->{
            new Curso(null, "10000h","Sistemas para Internet");
        });
    }
}
