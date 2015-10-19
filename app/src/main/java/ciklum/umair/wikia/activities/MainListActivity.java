package ciklum.umair.wikia.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.vilyever.abslistviewloadmore.AbsListView_VDLoadMore;

import java.util.ArrayList;

import ciklum.umair.wikia.R;
import ciklum.umair.wikia.adapters.LVAdapter;
import ciklum.umair.wikia.interfaces.ResponseListener;
import ciklum.umair.wikia.models.WikiItem;
import ciklum.umair.wikia.models.WikisResponse;
import ciklum.umair.wikia.networkmanager.NetworkManager;

public class MainListActivity extends AppCompatActivity implements ResponseListener, AdapterView.OnItemClickListener {

    private ListView listView;
    private LVAdapter lvAdapter;
    private NetworkManager networkManager;
    private ProgressBar progressBar;

    private Integer pageNumber = 1;
    private boolean shouldLoadMore = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main_list);
        this.viewConfiguraitons();
        this.loadWikia();
    }

    private void viewConfiguraitons() {
        this.listView = (ListView) this.findViewById(R.id.listView);
        this.networkManager = new NetworkManager(this, this);
        this.progressBar = (ProgressBar) this.findViewById(R.id.progressBar);
        this.lvAdapter = new LVAdapter(this, new ArrayList<WikiItem>());
        this.listView.setAdapter(this.lvAdapter);
        this.listView.setOnItemClickListener(this);
    }

    private void loadWikia() {
        this.networkManager.getWikia(this.pageNumber);
        AbsListView_VDLoadMore.addLoadMoreDelegate(this.listView, new AbsListView_VDLoadMore.LoadMoreDelegate() {
            @Override
            public void requireLoadMoreFromAbsListView(AbsListView absListView) {
                if (shouldLoadMore) {
                    progressBar.setVisibility(View.VISIBLE);
                    networkManager.getWikia(pageNumber);
                }
            }
        });
    }

    /**
     * Call back method for service calls
     */
    @Override
    public void onWikiResponse(WikisResponse wikisResponse) {
        this.pageNumber = wikisResponse.getCurrentBatch() + 1;
        this.shouldLoadMore = wikisResponse.isNextAvailable();
        this.lvAdapter.addAll(wikisResponse.getItems());
        this.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        WikiItem item = this.lvAdapter.getItem(position);
        Intent intent = new Intent(this, WikiDetailActivity.class);
        intent.putExtra("wikiId", item.getId());
        startActivity(intent);
    }
}
