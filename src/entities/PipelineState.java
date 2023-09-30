package entities;

public class PipelineState {
    private String name;
    private int time;

    public PipelineState(String name, int time) { // contém um nome de estágio e o tempo dele
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }
}
