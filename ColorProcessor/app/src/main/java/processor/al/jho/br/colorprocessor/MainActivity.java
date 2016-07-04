package processor.al.jho.br.colorprocessor;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import processor.al.jho.br.colormanager.ColorNodeManager;
import processor.al.jho.br.model.Node;

public class MainActivity extends AppCompatActivity{

  private EditText etCor, etTime;
  private TextView viewCor, viewTempo;
  private ImageView layout;
  private ColorNodeManager colorNodeManager;

  Editable cor, tempo;

  private String nameColor = "";
  private long time = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ViewGroup container;

    LayoutInflater inflater = getLayoutInflater();
    container = (ViewGroup) toolbar.getParent();

    etCor = (EditText) findViewById(R.id.etCor);
    etTime = (EditText) findViewById(R.id.etTime);

    View view = getLayoutInflater().inflate(R.layout.nome_tempo_layout, container, false);
<<<<<<< HEAD
    TextView viewCor = (TextView) view.findViewById(R.id.tvColor2);
    TextView viewTempo = (TextView) view.findViewById(R.id.tvTime2);

=======
    viewCor = (TextView) view.findViewById(R.id.tvColor2);
    viewTempo = (TextView) view.findViewById(R.id.tvTime2);

    //TextView viewCor = (TextView) view.findViewById(R.id.tvColor2);
    //TextView viewTempo = (TextView) view.findViewById(R.id.tvTime2);
      
>>>>>>> 008e215408f6564fcfdb1aed2681c3883285cff1
    View viewLayout = getLayoutInflater().inflate(R.layout.processor_color_layout, container, false);
    layout = (ImageView) viewLayout.findViewById(R.id.llColor);
    viewTempo = (TextView) viewLayout.findViewById(R.id.tvTitle3);

    colorNodeManager = new ColorNodeManager();
  }

  public void onClick(View view){
    if(view.getId() == R.id.btOk){
      colorNodeManager.allocNode(etCor.getText().toString(), Integer.parseInt(etTime.getText().toString()));
      trace("Feito!");
    }else{
      if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
        viewTempo.setText("Iuiuiuiu...");
        layout.setBackground(getResources().getDrawable(android.R.color.black));
        layout.setVisibility(View.INVISIBLE);
        trace("FeitoA!");
      }
    }
  }

  public void rescueValues(){
    cor = this.etCor.getText();
    tempo = this.etTime.getText();
  }

  private void trace(String msg){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
  }
}
