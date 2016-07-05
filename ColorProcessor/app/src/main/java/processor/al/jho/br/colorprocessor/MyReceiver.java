package processor.al.jho.br.colorprocessor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

import processor.al.jho.br.model.Node;

/**
 * Created by jhoanesfreitas on 04/07/16.
 */
public class MyReceiver extends BroadcastReceiver{

  private TimerTask timerTask;
  private Timer timer;
  private Node node;
  private long t;
  private long tEnd;
  private long tMed;
  private double sec = 0;

  @Override public void onReceive(Context context, Intent intent){

    tEnd = System.currentTimeMillis();
    tMed = tMed - getT();
    sec = tMed / 1000.0;

    Log.d("receiver", "Entrou! " + sec);

    if(sec >= node.getTime() * 1000){
      Log.d("receiver", "Entrou! " + sec);
      timerTask.cancel();
      timer.cancel();
    }
  }

  public long getT(){
    return t;
  }

  public void setT(long t){
    this.t = t;
  }

  public Node getNode(){
    return node;
  }

  public void setNode(Node node){
    this.node = node;
  }

  public TimerTask getTimerTask(){
    return timerTask;
  }

  public void setTimerTask(TimerTask timerTask){
    this.timerTask = timerTask;
  }

  public Timer getTimer(){
    return timer;
  }

  public void setTimer(Timer timer){
    this.timer = timer;
  }
}
