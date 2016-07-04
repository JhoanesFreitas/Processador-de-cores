package processor.al.jho.br.colormanager;

import processor.al.jho.br.model.Node;

/**
 * Created by jhoanesfreitas on 04/07/16.
 */
public class ColorNodeManager{

  Node r = null, f = null;

  public boolean allocNode(String color, long time){

    Node node = new Node(color, time);

    if(r == null && f == null){
      node.setProx(null);
      r = node;
      f = node;
    }else if(f.getProx() == null){
      r = node;
      r.setProx(null);
      f.setProx(r);
    }else{
      r.setProx(node);
      r = node;
      r.setProx(null);
    }
    return true;
  }

  public boolean isEmpty(){
    return f == null;
  }

  public Node unAlloc(){
    Node rec = f;
    f = f.getProx();

    if(f == null)
      return null;

    return rec;
  }
}
