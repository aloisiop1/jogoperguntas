package br.com.etecmam.suaaplicacaotcc;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.List;

public class PerguntaActivity extends AppCompatActivity {

    int pontos = 0;
    int posicao = -1;
    Pergunta pergunta = null;

    WebView p;
    private Button botaoProximo;
    private RadioButton op1, op2, op3, op4;
    private RadioGroup rg;
    List<Pergunta> perguntas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);

        p = findViewById(R.id.pergunta);

        op1 = findViewById(R.id.opcao1);
        op2 = findViewById(R.id.opcao2);
        op3 = findViewById(R.id.opcao3);
        op4 = findViewById(R.id.opcao4);

        rg = findViewById(R.id.grupoRB);

        botaoProximo = findViewById(R.id.botaoProximo);

        ListaDePerguntas ldp =  (ListaDePerguntas) getIntent().getSerializableExtra("lista");
        perguntas = ldp.getPerguntas();

        proximaPergunta();


        botaoProximo.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {

               int sel = -1;

               if(op1.isChecked()) sel = 1;
               if(op2.isChecked()) sel = 2;
               if(op3.isChecked()) sel = 3;
               if(op4.isChecked()) sel = 4;

                if (pergunta.getResposta() == sel) pontos++;

                proximaPergunta();
           }
        });

    }

    void proximaPergunta(){

        posicao++;

        if(posicao < perguntas.size() ){

            pergunta = perguntas.get(posicao);

            p.loadData( "<p style=\"text-align:justify\">" + pergunta.getQuestao() + "</p>",
                    "text/html; charset=utf-8",
                    "utf-8");

            op1.setText(pergunta.getOpcao1());
            op2.setText(pergunta.getOpcao2());
            op3.setText(pergunta.getOpcao3());
            op4.setText(pergunta.getOpcao4());

            op1.setChecked(false);
            op2.setChecked(false);
            op3.setChecked(false);
            op4.setChecked(false);

        }else{
         //   Toast.makeText(this, pontos + "/" + perguntas.size(),Toast.LENGTH_LONG ).show();
            exibirMensagem( pontos, perguntas.size() );
        }

    }

    private void exibirMensagem(int pontos, int size) {

        AlertDialog.Builder builder = new AlertDialog.Builder( this);

        builder.setMessage(pontos + " / " + size)
                .setTitle("TOTAL DE PONTOS");

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
