package model;

/**
 * Estado
 */
public class Estado {

    private int id;
    private String name;
    private String label;
    private Boolean initialState;
    private Boolean finalState;

    Estado(int id, String name,String label, Boolean initialState, Boolean finalState){
        this.id = id;
        this.name = name;
        this.label = label;
        this.initialState = initialState;
        this.finalState = finalState;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public Boolean getInitialState() {
        return initialState;
    }

    public Boolean getFinalState() {
        return finalState;
    }

    

}