package processor.al.jho.br.colormanager;

import android.util.Log;

import processor.al.jho.br.model.Node;

/**
 * Created by jhoanesfreitas on 04/07/16.
 */
public class ColorNodeManager{

  Node r = null, f = null;

  public boolean enqueue(String color, long time){

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

  public Node dequeue(){
    Node rec = f;

    if(f == null){
      Log.d("f", "entrou!");
      r = null;
      return null;
    }

    f = f.getProx();

    return rec;
  }
}
