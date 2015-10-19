package ciklum.umair.wikia.activities;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.LruCache;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import ciklum.umair.wikia.R;
import ciklum.umair.wikia.interfaces.ResponseListener;
import ciklum.umair.wikia.models.WikiItem;
import ciklum.umair.wikia.models.WikisResponse;
import ciklum.umair.wikia.networkmanager.NetworkManager;

/**
 * Created by umair1 on 10/16/15.
 */
public class WikiDetailActivity extends Activity implements ResponseListener {

    private NetworkManager networkManager;
    private Integer wikiId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_item_detail);
        this.viewConfigurations();
        this.loadWikia();
    }

    private void viewConfigurations() {
        this.networkManager = new NetworkManager(this, this);
        this.wikiId = getIntent().getIntExtra("wikiId", 0);
    }

    private void loadWikia() {
        this.networkManager.getWikiDetail(this.wikiId);
    }

    /**
     * Call back method for service calls
     */

    @Override
    public void onWikiResponse(WikisResponse wikisResponse) {
        WikiItem item = wikisResponse.getItems().get(0);
        TextView txtHeadline = (TextView) findViewById(R.id.txtHeadline);
        TextView txtUrl = (TextView) findViewById(R.id.txtUrl);
        TextView txtDescription = (TextView) findViewById(R.id.txtDescription);

        txtHeadline.setText(item.getHeadline());
        String link = "<a href='http://"+item.getUrl()+"'>"+item.getUrl();
        txtUrl.setText(Html.fromHtml(link));
        txtUrl.setMovementMethod(LinkMovementMethod.getInstance());
        txtDescription.setText(item.getDesc());
        this.setTitle(item.getTitle());

        ImageView wordMark = (ImageView) findViewById(R.id.ivWordMark);
        ImageView titleImage = (ImageView) findViewById(R.id.ivTitleImage);

        Picasso.with(this).load(item.getWordmark()).placeholder(R.mipmap.ic_wordmark).error(R.mipmap.ic_wordmark).into(wordMark);
        Picasso.with(this).load(item.getImage()).placeholder(R.mipmap.placeholder).error(R.mipmap.placeholder).into(titleImage);
    }
}