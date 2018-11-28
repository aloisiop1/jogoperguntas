package br.com.etecmam.suaaplicacaotcc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    final Context contexto;

    List<ItemMenu> itens;

    public ItemAdapter(Context contexto, List<ItemMenu> itens){
        this.contexto = contexto;
        this.itens = itens;
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return itens.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ItemMenu item = itens.get(position);

        LayoutInflater inflater = LayoutInflater.from(contexto);
        View view = inflater.inflate(R.layout.menu_item, null);

        ImageView imagem = view.findViewById(R.id.item_imagem);
        TextView titulo = view.findViewById(R.id.item_titulo);

        titulo.setText( item.getTitulo() );

        Resources resources = contexto.getResources();

        int idFoto = resources.getIdentifier(item.getImagem(), "drawable",contexto.getPackageName() );
        Drawable drawable = resources.getDrawable(idFoto);

        imagem.setImageDrawable(drawable);

        return view;
    }
}
