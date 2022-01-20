package com.example.navigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.navigation.model.Movie;

import java.util.List;

public class movieAdapter extends BaseAdapter {
    Context context;
    int  Layout;
    List<Movie> listmovies ;

    public movieAdapter(Context context, int layout, List<Movie> listmovies ) {
        this.context = context;
        Layout = layout;
        this.listmovies  = listmovies ;
    }

    @Override
    public int getCount() {
        return listmovies.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null ) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(Layout, null);
            viewHolder = new ViewHolder();
            viewHolder.txtname = view.findViewById(R.id.name);
//            viewHolder.txttitle = view.findViewById((R.id.tit));
            viewHolder.imgmv = view.findViewById(R.id.img);
//            TextView txtname = view.findViewById(R.id.name);
//            TextView txttitle = view.findViewById((R.id.tit));
//            ImageView imagemv = view.findViewById(R.id.img);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }
             viewHolder.txtname.setText(listmovies.get(i).getTitle());
//             viewHolder.txttitle.setText(listmovies.get(i).getTitle());
             viewHolder.imgmv.setImageResource(listmovies.get(i).getImage());


        return view;
    }
    class ViewHolder {
        TextView txtname, txttitle;
        ImageView imgmv;
    }
}
