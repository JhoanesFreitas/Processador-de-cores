package processor.al.jho.br.model;

/**
 * Created by alana on 03/07/16.
 */
public class Node{

    private String nameColor;
    private long time;
    private Node prox;

    public Node(String nameColor, long time) {
        this.nameColor = nameColor;
        this.time = time;
    }

    public String getNameColor() {
        return nameColor;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setNameColor(String nameColor) {
        this.nameColor = nameColor;
    }

    public Node getProx(){
        return prox;
    }

    public void setProx(Node prox){
        this.prox = prox;
    }
}
