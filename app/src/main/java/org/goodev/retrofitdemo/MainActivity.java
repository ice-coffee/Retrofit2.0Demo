package org.goodev.retrofitdemo;

import java.util.List;

import org.goodev.retrofitdemo.GitHubClient.Contributor;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListView = getListView();
        GitHubClient.getListData(new Callback<List<Contributor>>()
        {
            @Override
            public void onResponse(Response<List<Contributor>> response, Retrofit retrofit)
            {
                ArrayAdapter<Contributor> adapter = new ArrayAdapter<GitHubClient.Contributor>(getApplicationContext(),
                    android.R.layout.simple_list_item_1, response.body());
                mListView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Throwable t)
            {

            }
        });
    }

}
