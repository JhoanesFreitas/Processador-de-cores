package processor.al.jho.br.model;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.widget.Toast;

import java.util.TimerTask;

import processor.al.jho.br.colorprocessor.Main2Activity;

/**
 * Created by jhoanesfreitas on 04/07/16.
 */
public class CustomTimerTask extends TimerTask{

  private Context context;
  private Main2Activity mActivity;
  private Node node;
  private Handler mHandler = new Handler();

  public CustomTimerTask(Context con, Main2Activity mActivity, Node node) {
    this.context = con;
    this.mActivity = mActivity;
    this.node = node;
  }

  public CustomTimerTask(Context con, Main2Activity mActivity) {
    this.context = con;
    this.mActivity = mActivity;
  }

  public void includeNode(Node node){
    this.node = node;
  }

  @Override
  public void run() {
    // TODO Auto-generated method stub

    new Thread(new Runnable() {
      @Override
      public void run() {
        mHandler.post(new Runnable() {
          @Override
          public void run() {
            mActivity.alter(node);
          }
        });
      }
    }).start();
  }

}
