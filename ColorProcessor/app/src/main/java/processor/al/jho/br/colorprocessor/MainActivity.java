package processor.al.jho.br.colorprocessor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private EditText etCor, etTime;
    private Button btOk;

    Editable cor, tempo;

    private AllocNode nameColor, time;

      @Override
      protected void onCreate(Bundle savedInstanceState){
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          EditText etCor = (EditText) findViewById(R.id.etCor);
          EditText etTime = (EditText) findViewById(R.id.etTime);

          Button btOk = (Button) findViewById(R.id.btOk);

          TextView viewCor = (TextView) findViewById(R.id.viewCor);
          TextView viewTempo = (TextView) findViewById(R.id.viewTempo);

      }

    public void rescueValues() {
        cor = this.etCor.getText();
        tempo = this.etTime.getText();


    }

    public AllocNode allocateNewNode() {
        AllocNode node = new AllocNode(nameColor, time);

        nameColor = (AllocNode) cor;
        time = (AllocNode) tempo;

        node.setNameColor(nameColor);
        node.setTime(time);

        return node;
    }
}
