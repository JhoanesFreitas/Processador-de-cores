package processor.al.jho.br.colorprocessor;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Delayed;

import constants.Constants;
import processor.al.jho.br.colormanager.ColorNodeManager;
import processor.al.jho.br.model.Node;

public class Main2Activity extends AppCompatActivity {


  private EditText etCor, etTime;
  private TextView viewCor, viewTempo;
  private ListView item;
  private ArrayList list;
  private ImageView layout;
  private ColorNodeManager colorNodeManager;
  private Node node;

  int cont = 0;

  Editable cor, tempo;

  private String nameColor = "";
  private long time = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    etCor = (EditText) findViewById(R.id.etCor);
    etTime = (EditText) findViewById(R.id.etTime);

    viewCor = (TextView) findViewById(R.id.tvColor2);
    viewTempo = (TextView) findViewById(R.id.tvTime2);

    layout = (ImageView) findViewById(R.id.llColor);
    item = (ListView) findViewById(R.id.tvItem);

    colorNodeManager = new ColorNodeManager();

    list = new ArrayList();

  }

  public void onClick(View view){
    if(view.getId() == R.id.btOk){
      colorNodeManager.enqueue(etCor.getText().toString(), Long.valueOf(etTime.getText().toString()));

      list.add(etCor.getText().toString());

      ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
          android.R.layout.simple_list_item_1, android.R.id.text1, list);

      item.setAdapter(adapter);

      etCor.setText("");
      etTime.setText("");

      trace("Feito!");
    } else{
      if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
        int cont = 0;
        node = colorNodeManager.dequeue();
        while(colorNodeManager.isEmpty() || node == null){

          if(node != null){

            if(cont == 0){
              alter(node);
              cont++;
            }
            //Log.d("time", node.getNameColor());

            new CountDownTimer(node.getTime() * 1000, 1000){
              @Override public void onTick(long millisUntilFinished){
                Log.d("time", "seconds remaining: " + millisUntilFinished / 1000);
                //trace("seconds remaining: " + millisUntilFinished / 1000);
              }

              @Override public void onFinish(){
                node = colorNodeManager.dequeue();
                alter(node);
                if(node != null)
                  Log.d("time", node.getNameColor());

                //trace("Done!");
              }
            }.start();
          }
        }
      }
    }
  }

  @TargetApi(Build.VERSION_CODES.JELLY_BEAN) public void alter(Node node){
    switch(node.getNameColor()){
      case Constants.BLACK:
        layout.setBackground(getResources().getDrawable(android.R.color.black));
        break;
      case Constants.BLUE:
        layout.setBackground(getResources().getDrawable(android.R.color.holo_blue_dark));
        break;
      case Constants.GREEN:
        layout.setBackground(getResources().getDrawable(android.R.color.holo_green_dark));
        break;
      case Constants.GREY:
        layout.setBackground(getResources().getDrawable(android.R.color.darker_gray));
        break;
      case Constants.PURPLE:
        layout.setBackground(getResources().getDrawable(android.R.color.holo_purple));
        break;
      case Constants.RED:
        layout.setBackground(getResources().getDrawable(android.R.color.holo_red_dark));
        break;
      default:
        break;
    }

    viewCor.setText(node.getNameColor());
    viewTempo.setText(String.valueOf(node.getTime()));

  }

  public void rescueValues(){
    cor = this.etCor.getText();
    tempo = this.etTime.getText();
  }

  private void trace(String msg){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
  }

}