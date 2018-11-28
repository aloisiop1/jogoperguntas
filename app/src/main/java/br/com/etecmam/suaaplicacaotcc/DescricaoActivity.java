package br.com.etecmam.suaaplicacaotcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import java.io.Serializable;

public class DescricaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao);

        WebView view = findViewById(R.id.webview_descricao);

        ItemMenu item = (ItemMenu) getIntent().getSerializableExtra("item");

        setTitle( item.getTitulo() );

        view.loadData( "<p style=\"text-align:justify\">" + "" + "</p>",
                "text/html; charset=utf-8",
                "utf-8");


    }
}
