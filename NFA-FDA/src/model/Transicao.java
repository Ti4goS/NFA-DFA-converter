package model;

public class Transicao {
    private Estado from;
    private Estado to;
    private String read;

    public Transicao(Estado from, Estado to,String read){
        this.from = from;
        this.to = to;
        this.read = read;
    }

    public Estado getFrom() {
        return from;
    }

    public String getRead() {
        return read;
    }

    public Estado getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Transicao [from=" + this.from.getId() + ", read=" + this.read + ", to=" + this.to.getId() + "]";
    }

    
}
