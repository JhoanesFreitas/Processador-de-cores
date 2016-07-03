package processor.al.jho.br.colorprocessor;

/**
 * Created by alana on 03/07/16.
 */
public class AllocNode {

    private AllocNode nameColor;
    private AllocNode time;

    public AllocNode(AllocNode nameColor, AllocNode time) {
        this.nameColor = nameColor;
        this.time = time;
    }

    public AllocNode getNameColor() {
        return nameColor;
    }

    public AllocNode getTime() {
        return time;
    }

    public void setTime(AllocNode time) {
        this.time = time;
    }

    public void setNameColor(AllocNode nameColor) {
        this.nameColor = nameColor;
    }
}
