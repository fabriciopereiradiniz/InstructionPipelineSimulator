package entities;

import java.util.List;

public class Pipeline {
	private String[][] matriz;

	public Pipeline(int instructions, int time) {
		matriz = new String[instructions][time]; // Instancia uma matriz de [instrucoes]x[tempo] que vai receber os estágios

	}

	public void fill(List<PipelineState> pipelineStates) {
		int numRows = matriz.length;
		int numCols = matriz[0].length;
		int incrementador = 0;

		for (int i = 0; i < numRows; i++) { // Preenche tudo com x primeiro pra ficar mais fácil
			for (int j = 0; j < numCols; j++) {
				matriz[i][j] = "X";
			}
		}

		for (int i = 0; i < numRows; i++) { // Aqui fica a lógica de preenchimento dos estágios
			int k = 0;
			for (int j = 0; j < numCols; j++) {
				if (k < pipelineStates.size()) {
					if (j + incrementador + pipelineStates.get(k).getTime() <= numCols) { 
						for (int m = 0; m < pipelineStates.get(k).getTime(); m++) {
							matriz[i][j + incrementador + m] = pipelineStates.get(k).getName();
						}
						j += pipelineStates.get(k).getTime() - 1;
					}
					k++;
				}
			}
			incrementador++;
		}
	}

	public void print() { // Printa a matriz!
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				String value = matriz[i][j];
				if (value != null) {
					System.out.print(value + " ");
				} else {
					System.out.print("null ");
				}
			}
			System.out.println();
		}
	}
}
