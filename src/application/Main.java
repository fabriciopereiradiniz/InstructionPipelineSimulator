package application;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Pipeline;
import entities.PipelineState;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a quantidade de instruções:");
        int numInstructions = sc.nextInt();
        System.out.println("Digite a quantidade de tempo:");
        int numTime = sc.nextInt();
        System.out.println("Digite a quantidade de estados da pipeline:");

        ArrayList<PipelineState> pipelineStates = new ArrayList<>(); // Instancia um arraylist que recebe os pipelinestates (name/time)
        int numStates = sc.nextInt();

        for (int i = 0; i < numStates; i++) { // Aqui basicamente preenche, bem básico
            System.out.println("Digite o nome do " + (i + 1) + "º estado da pipeline:");
            String name = sc.next();
            System.out.println("Digite o tempo do " + (i + 1) + "º estado da pipeline:");
            int time = sc.nextInt();
            pipelineStates.add(new PipelineState(name, time));
        }

        Pipeline pipeline = new Pipeline(numInstructions, numTime); // Instancia uma pipeline que recebe o num de isntrucoes e tempo ( dá uma grid de matriz )
        pipeline.fill(pipelineStates); // aqui utilizando o pipelinestates que você recebeu lá em cima você passa os names e times pra pipeline
        pipeline.print(); // printa tudo

        sc.close();
    }
}
