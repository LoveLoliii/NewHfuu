package Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.com.newhfuu.R;

import java.util.List;

import entity.Menu;

/**
 * Created by LLLLLLL on 5/20/2016.
 */
public class MenuAdapter extends ArrayAdapter<Menu>{

    private int resourceId;

    public MenuAdapter(Context context, int resource, List<Menu> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Menu menu = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.menu_image);
            viewHolder.textView = (TextView) view.findViewById(R.id.menu_text);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(menu.getImageId());
        viewHolder.textView.setText(menu.getName());
        return view;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
