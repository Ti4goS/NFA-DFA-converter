package model;

public class Transicao {
    private String from;
    private String to;
    private String read;

    Transicao(String from, String to,String read){
        this.from = from;
        this.to = to;
        this.read = read;
    }

    public String getFrom() {
        return from;
    }

    public String getRead() {
        return read;
    }

    public String getTo() {
        return to;
    }

    
}
