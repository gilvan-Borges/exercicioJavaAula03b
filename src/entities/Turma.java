package entities;



import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Turma {
	private UUID	  idTurma;
	private String	  nome;
	private Date	  dataInicio;
	private Professor professor;
	private Curso 	  curso;
	private List<Aluno>   alunos;

}
