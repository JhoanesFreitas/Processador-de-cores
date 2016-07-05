package processor.al.jho.br.colorprocessor;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.view.ViewCompat;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;
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
  private LinearLayout linearLayout;

  int contA = 0;
  int contB = 0;

  private String nameColor = "";
  private long time = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    linearLayout = (LinearLayout) findViewById(R.id.a);

    etCor = (EditText) findViewById(R.id.etCor);
    etTime = (EditText) findViewById(R.id.etTime);

    viewCor = (TextView) findViewById(R.id.tvColor2);
    viewTempo = (TextView) findViewById(R.id.tvTime2);

    layout = (ImageView) findViewById(R.id.llColor);
    //item = (ListView) findViewById(R.id.tvItem);

    colorNodeManager = new ColorNodeManager();

    list = new ArrayList();

  }

  public void onClick(View view) {
    if (view.getId() == R.id.btOk) {

      if (etCor.length() > 0 && etTime.length() > 0) {

        if (etCor.getText().toString().toUpperCase().equals("VERMELHO") || etCor.getText().toString().toUpperCase().equals("VERDE"))
          colorNodeManager.enqueue(String.valueOf(etCor.getText().toString().toUpperCase().charAt(0)
                  + "" + etCor.getText().toString().toUpperCase().charAt(3)), Long.valueOf(etTime.getText().toString()));
        else
          colorNodeManager.enqueue(String.valueOf(etCor.getText().toString().toUpperCase().charAt(0)), Long.valueOf(etTime.getText().toString()));

        list.add(etCor.getText().toString().toUpperCase());

        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, android.R.id.text1, list);*/


        //item.setAdapter(adapter);

        TextView textView = new TextView(this);
        textView.setId(contA++);
        textView.setText(etCor.getText().toString().toUpperCase() + " | " + etTime.getText().toString() + " » ");
        linearLayout.addView(textView);

        etCor.setText("");
        etTime.setText("");

        trace("Feito!");
      } else {
        trace("Cor e/ou tempo não adicionado(s)!");
      }
    } else {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        view.setVisibility(View.INVISIBLE);
        node = colorNodeManager.dequeue();

          if (node != null)
            nodeLoc(node.getTime(), view);
          else
            trace("Fila vazia!");
        }
      }
    }


  private void nodeLoc(long timeEnd, final View view){

    new CountDownTimer(node.getTime() * 1000, 1000){

      int cont = 0;

      @Override public void onTick(long millisUntilFinished){
        Log.d("time", "seconds remaining: " + millisUntilFinished / 1000);
        timeRecov(millisUntilFinished / 1000);

        /*if(colorNodeManager.isEmpty()){
          this.cancel();
        }*/

        if(node != null && cont == 0){
          TextView tv = (TextView) findViewById(contB++);
          tv.setVisibility(View.GONE);
          alter(node);
          cont++;
        }
        //trace("seconds remaining: " + millisUntilFinished / 1000);
      }

      @Override public void onFinish(){
        if(node != null){
          node = colorNodeManager.dequeue();
          this.cancel();

          if(node != null){
            nodeLoc(node.getTime(), view);
            Log.d("time", node.getNameColor());
          }else{
            view.setVisibility(View.VISIBLE);
          }
        }
      }
    }.start();

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

    viewCor.setText(list.get((int) time++).toString());
    timeRecov(node.getTime());

  }

  private void timeRecov(long timeR){
    viewTempo.setText(String.valueOf(timeR));
  }

  private void trace(String msg){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
  }

}