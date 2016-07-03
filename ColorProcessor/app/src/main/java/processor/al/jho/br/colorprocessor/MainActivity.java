package processor.al.jho.br.colorprocessor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

  private EditText etCor, etTime;
  private LinearLayout layout;

  Editable cor, tempo;

  private AllocNode nameColor, time;

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ViewGroup container;

    LayoutInflater inflater = getLayoutInflater();
    container = (ViewGroup) inflater.getFilter();

    EditText etCor = (EditText) findViewById(R.id.etCor);
    EditText etTime = (EditText) findViewById(R.id.etTime);

    View view = getLayoutInflater().inflate(R.layout.nome_tempo_layout, container, false);
    TextView viewCor = (TextView) view.findViewById(R.id.tvColor2);
    TextView viewTempo = (TextView) view.findViewById(R.id.tvTime2);

    View viewLayout = getLayoutInflater().inflate(R.layout.processor_color_layout, container, false);
    layout = (LinearLayout) viewLayout.findViewById(R.id.llColor);

  }

  public void onClick(View view){

  }

  public void rescueValues(){
    cor = this.etCor.getText();
    tempo = this.etTime.getText();
  }

  public AllocNode allocateNewNode(){
    AllocNode node = new AllocNode(nameColor, time);

    nameColor = (AllocNode) cor;
    time = (AllocNode) tempo;

    node.setNameColor(nameColor);
    node.setTime(time);

    return node;
  }
}
