package br.com.etecmam.suaaplicacaotcc;

import android.content.Intent;
import android.icu.lang.UCharacter;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    ListView lista;
    List<Pergunta> perguntas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        lista = findViewById(R.id.lista_menu);

        List<ItemMenu> itensDoMenu = new ArrayList<>();

        itensDoMenu.add(
                new ItemMenu(1,"@drawable/b", "LÓGICA BÁSICA"));
        itensDoMenu.add(
                new ItemMenu(2,"@drawable/i", "LÓGICA INTERMEDIÁRIA"));
        itensDoMenu.add(
                new ItemMenu(3,"@drawable/a", "LÓGICA AVANÇADA"));

        ItemAdapter adapter = new ItemAdapter(this, itensDoMenu);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ItemMenu item = (ItemMenu) lista.getItemAtPosition(position);
                Intent intent = null;

                if(item.id == 1 ){
                    perguntas = montarListaBasica();

                }else if(item.id == 2 ){
                    perguntas = montarListaIntermediaria();

                }else if(item.id == 3 ){;
                    perguntas = montarListaAvancada();

                }

                intent = new Intent(MenuActivity.this, PerguntaActivity.class);
                intent.putExtra("lista", new ListaDePerguntas(perguntas));
                startActivity(intent);

            }
        });

    }

    public List<Pergunta> montarListaBasica(){

        List<Pergunta> l = new ArrayList<>();

        Pergunta p;

        p = new Pergunta("RESPONDA QUEM DESCOBRIU O NOSSO PAÍS: BRASIL",2);
        p.setOpcao1("PEDRO ALVARES CABRITO");
        p.setOpcao2("PEDRO ALVARES CABRAL");
        p.setOpcao3("PERO VAZ DE CAMINHA");
        p.setOpcao4("MICHAEL JACKSON ");
        l.add(p);

        p = new Pergunta("QUE PAÍS FOI O INVENTOR DA PÓLVORA ? INICIALMENTE UTILIZADA NA CONFECÇÃO DE FOGOS DE ARTIFÍCIO",4);
        p.setOpcao1("BRASIL");
        p.setOpcao2("ALEMANHA");
        p.setOpcao3("JAPÃO");
        p.setOpcao4("CHINA");
        l.add(p);

        p = new Pergunta("QUEM INVENTOU A ESCRITA ?",3);
        p.setOpcao1("INDIANOS");
        p.setOpcao2("GREGOS");
        p.setOpcao3("SUMÉRIOS");
        p.setOpcao4("CHINESES");
        l.add(p);

        return  l;

    }

    public List<Pergunta> montarListaIntermediaria(){

        List<Pergunta> l = new ArrayList<>();

        Pergunta p;

        p = new Pergunta("PERGUNTA I1",1);
        p.setOpcao1("RESPOSTA 1");
        p.setOpcao2("RESPOSTA 2");
        p.setOpcao3("RESPOSTA 3");
        p.setOpcao4("RESPOSTA 4");
        l.add(p);

        p = new Pergunta("PERGUNTA I2",2);
        p.setOpcao1("RESPOSTA 1");
        p.setOpcao2("RESPOSTA 2");
        p.setOpcao3("RESPOSTA 3");
        p.setOpcao4("RESPOSTA 4");
        l.add(p);

        p = new Pergunta("PERGUNTA I3",3);
        p.setOpcao1("RESPOSTA 1");
        p.setOpcao2("RESPOSTA 2");
        p.setOpcao3("RESPOSTA 3");
        p.setOpcao4("RESPOSTA 4");
        l.add(p);

        p = new Pergunta("PERGUNTA I4",4);
        p.setOpcao1("RESPOSTA 1");
        p.setOpcao2("RESPOSTA 2");
        p.setOpcao3("RESPOSTA 3");
        p.setOpcao4("RESPOSTA 4");
        l.add(p);

        return  l;

    }

    public List<Pergunta> montarListaAvancada(){

        List<Pergunta> l = new ArrayList<>();

        Pergunta p;

        p = new Pergunta("PERGUNTA A1",1);
        p.setOpcao1("RESPOSTA 1");
        p.setOpcao2("RESPOSTA 2");
        p.setOpcao3("RESPOSTA 3");
        p.setOpcao4("RESPOSTA 4");
        l.add(p);

        p = new Pergunta("PERGUNTA A2",2);
        p.setOpcao1("RESPOSTA 1");
        p.setOpcao2("RESPOSTA 2");
        p.setOpcao3("RESPOSTA 3");
        p.setOpcao4("RESPOSTA 4");
        l.add(p);

        p = new Pergunta("PERGUNTA A3",3);
        p.setOpcao1("RESPOSTA 1");
        p.setOpcao2("RESPOSTA 2");
        p.setOpcao3("RESPOSTA 3");
        p.setOpcao4("RESPOSTA 4");
        l.add(p);

        return  l;

    }
}
