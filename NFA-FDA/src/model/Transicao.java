package model;

public class Transicao {
    private int from;
    private int to;
    private String read;

    public Transicao(int from, int to,String read){
        this.from = from;
        this.to = to;
        this.read = read;
    }

    public int getFrom() {
        return from;
    }

    public String getRead() {
        return read;
    }

    public int getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Transicao [from=" + this.from + ", read=" + this.read + ", to=" + this.to + "]";
    }

    
}
