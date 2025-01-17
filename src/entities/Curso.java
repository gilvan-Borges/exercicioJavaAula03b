package entities;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Curso {
	private UUID	idCurso;
	private String	titulo;
	private String	cargaHoraria;
}
