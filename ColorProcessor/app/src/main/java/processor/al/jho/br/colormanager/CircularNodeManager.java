package processor.al.jho.br.colormanager;

import processor.al.jho.br.model.Node;

/**
 * Created by alana on 12/07/16.
 */
public class CircularNodeManager {

    int r = 0, f = 0;

    public void enqueueCircular(String color, long time) {

        Node node = new Node(color, time);

        int i;

        i = (f % r) + 1;

        if (i != r) {
            r = i;
            node.setProx(node);
        }
        if (f == 0) {
            f = 1;
        }
    }

    public int dequeue() {

        int rec = f;

        if (f != 0) {
            rec = f;
            if (f == r) {
                f = r = 0;
            } else {
                f = (f % r) + 1;
            }
        }

        return rec;
    }
}