package processor.al.jho.br.colorprocessor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import processor.al.jho.br.model.Node;

public class MainActivity extends AppCompatActivity{

  private EditText etCor, etTime;
  private TextView viewCor, viewTempo;
  private LinearLayout layout;

  Editable cor, tempo;

  private String nameColor = "";
  private long time = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ViewGroup container;

    LayoutInflater inflater = getLayoutInflater();
    container = (ViewGroup) inflater.getFilter();

    etCor = (EditText) findViewById(R.id.etCor);
    etTime = (EditText) findViewById(R.id.etTime);

    View view = getLayoutInflater().inflate(R.layout.nome_tempo_layout, container, false);
    viewCor = (TextView) view.findViewById(R.id.tvColor2);
    viewTempo = (TextView) view.findViewById(R.id.tvTime2);

    //TextView viewCor = (TextView) view.findViewById(R.id.tvColor2);
    //TextView viewTempo = (TextView) view.findViewById(R.id.tvTime2);
      
    View viewLayout = getLayoutInflater().inflate(R.layout.processor_color_layout, container, false);
    layout = (LinearLayout) viewLayout.findViewById(R.id.llColor);

  }

  public void onClick(View view){
    if(view.getId() == R.id.btOk){

    }else{

    }
  }

  public void rescueValues(){
    cor = this.etCor.getText();
    tempo = this.etTime.getText();
  }

  public Node allocateNewNode(){
    Node node = new Node(etCor.getText().toString(), Integer.parseInt(etTime.getText().toString()));

    //nameColor = cor;

    //node.setNameColor(nameColor);
    //node.setTime(time);

    return node;
  }
}
