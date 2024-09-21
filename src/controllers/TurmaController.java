package controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.JOptionPane;

import entities.Aluno;
import entities.Curso;
import entities.Professor;
import entities.Turma;
import repositories.TurmaRepository;

public class TurmaController {

	public void cadastrarTurma() {

		var turma = obterDadosTurma();
		turma.setCurso(obterDadosCurso());
		turma.setProfessor(obterDadosProfessor());
		
		
		var numAlunos = Integer.parseInt(JOptionPane.showInputDialog("INFORME O NUMERO DE ALUNOS"));
		if(numAlunos >0) {
			
			var lista = new ArrayList<Aluno>();
			
			for(var i = 0; i< numAlunos; i++) {
				JOptionPane.showMessageDialog(null, "PREECHIMENTO DO " + (i+1) + "º ALUNO:");
				lista.add(obterDadosAluno());
			}
			
			turma.setAlunos(lista);
		}
		
		var turmaRepository = new TurmaRepository();
		turmaRepository.exportarDados(turma);
	}

	private Turma obterDadosTurma() {
		
		var turma = new Turma();
		
		try {
			
			turma.setIdTurma(UUID.randomUUID());
			turma.setNome(JOptionPane.showInputDialog("INFORME O NOME DA TURMA:"));
			turma.setDataInicio(
					new SimpleDateFormat("dd/MM/yyyy").parse(JOptionPane.showInputDialog("INFORME A DATA DE INICIO:")));

		} catch (Exception e) {
			System.out.println("\nERRO CADASTRAR A TURMA");
		}
		
		return turma;
		
	}


	private Professor obterDadosProfessor() {

		var professor = new Professor();

		professor.setIdProfessor(UUID.randomUUID());
		professor.setNome(JOptionPane.showInputDialog("INFORME O NOME DO PROFESSOR:"));
		professor.setTelefone(JOptionPane.showInputDialog("INFORME O TELEFONE DO PROFESSOR:"));
		professor.setEmail(JOptionPane.showInputDialog("INFORME O EMAIL DO PROFESSOR:"));
		
		return professor;
	}
	
	
	private Curso obterDadosCurso() {

		var curso = new Curso();

		curso.setIdCurso(UUID.randomUUID());
		curso.setTitulo(JOptionPane.showInputDialog("INFORME O TITULO DO CURSO:"));
		curso.setCargaHoraria(JOptionPane.showInputDialog("INFORME A CARGA HORARIA:"));

		return curso;
	}
		
	private Aluno obterDadosAluno() {

		var aluno = new Aluno();

		aluno.setIdAluno(UUID.randomUUID());
		aluno.setNome(JOptionPane.showInputDialog("INFORME O NOME DO ALUNO:"));
		aluno.setEmail(JOptionPane.showInputDialog("INFORME O EMAIL DO ALUNO:"));

		return aluno;
	}

}
