package com.wiktor.demoretrofit2.Lesson1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wiktor.demoretrofit2.R;

import java.util.List;

public class Adapter extends ArrayAdapter <PojoLesson1> {
    private Context context;
    private List <PojoLesson1> values;

    public Adapter(Context context, List <PojoLesson1> values) {
        super(context, R.layout.post_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.post_item, parent, false);
        }

        TextView textView = row.findViewById(R.id.postitem_post);

        PojoLesson1 item = values.get(position);
        String message = item.getName();
        textView.setText(message);

        return row;
    }
}

