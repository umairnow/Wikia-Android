package ciklum.umair.wikia.adapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ciklum.umair.wikia.R;
import ciklum.umair.wikia.models.WikiItem;

/**
 * Created by umair1 on 10/13/15.
 */
public class LVAdapter extends ArrayAdapter<WikiItem> {

    private final Context context;
    private List<WikiItem> items;

    public LVAdapter(Context context, List<WikiItem> wikiItems) {
        super(context, R.layout.wiki_item_row, wikiItems);
        this.context = context;
        this.items = wikiItems;
    }

    public void addAll(List<WikiItem> collection) {
        items.addAll(collection);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.wiki_item_row, parent, false);
        TextView txtName = (TextView) rowView.findViewById(R.id.txtName);
        TextView txtDomain = (TextView) rowView.findViewById(R.id.txtDomain);
        TextView txtTopic = (TextView) rowView.findViewById(R.id.txtTopic);
        TextView txtHub = (TextView) rowView.findViewById(R.id.txtHub);

        WikiItem item = this.items.get(position);
        txtName.setText(item.getName());
        String link = "<a href='http://"+item.getDomain()+"'>"+item.getDomain();
        txtDomain.setText(Html.fromHtml(link));
        txtHub.setText(item.getHub());
        if (item.getTopic() != null) {
            txtTopic.setVisibility(View.VISIBLE);
            txtTopic.setText(item.getTopic());
        } else {
            txtTopic.setVisibility(View.GONE);
        }
        return rowView;
    }

}
