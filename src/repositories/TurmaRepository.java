package repositories;

import java.io.File;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import entities.Turma;

public class TurmaRepository {
	
	public void criarDiretorio(String caminho) {

		var file = new File(caminho);
		if (!file.exists()) {

			file.mkdir();
			System.out.println("PASTA CRIADO COM SUCESSO!");
		} else {
			System.out.println("PASTA JÀ EXISTENTE!");
		}
	}

	public void exportarDados(Turma turma) {

		try {

			var diretorio = "c:\\arquivos_xml";
			criarDiretorio(diretorio);

			
			var xmlMapper = new XmlMapper();
			xmlMapper.writeValue(new File(diretorio + "\\turma_" + turma.getIdTurma() + ".xml"), turma);

			System.out.println("\nARQUIVO XML GRAVADO COM SUCESSO!");

		} catch (Exception e) {
			System.out.println("\nERRO:" + e.getMessage());
		}

	}
}
