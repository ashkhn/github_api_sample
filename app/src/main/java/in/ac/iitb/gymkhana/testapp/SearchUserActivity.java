package in.ac.iitb.gymkhana.testapp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchUserActivity extends AppCompatActivity implements Callback<GsonModels.SearchResult>{

    private String searchQuery;
    private String queryFromBundle;
    private Bundle queryBundle;

    private RecyclerView searchResultView;
    private UserListAdapter userListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);
        if(getIntent()!=null){
            searchQuery = getIntent().getStringExtra(Constants.KEY_SEARCH_QUERY);
            queryBundle = getIntent().getBundleExtra(Constants.KEY_QUERY_BUNDLE);
            queryFromBundle = queryBundle.getString(Constants.KEY_SEARCH_QUERY);
        }
        searchResultView = (RecyclerView) findViewById(R.id.search_results_list);
        Toast.makeText(SearchUserActivity.this,
                "Search string is " + searchQuery,Toast.LENGTH_SHORT).show();
        RetrofitInterface retrofitInterface = ServiceGenerator.createService(RetrofitInterface.class);
        retrofitInterface.getSearchResults(searchQuery).enqueue(this);
    }

    @Override
    public void onResponse(Call<GsonModels.SearchResult> call, Response<GsonModels.SearchResult> response) {
        if(response.isSuccessful()){
            GsonModels.SearchResult result = response.body();
            Toast.makeText(SearchUserActivity.this,
                    "No of responses "+
                    String.valueOf(result.getTotalCount())
                    ,Toast.LENGTH_SHORT).show();
            userListAdapter = new UserListAdapter(result.getItems());
            searchResultView.setAdapter(userListAdapter);
            searchResultView.setLayoutManager(new LinearLayoutManager(this));

        }else{
            Toast.makeText(SearchUserActivity.this,"Response Code:" +
            String.valueOf(response.code()),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailure(Call<GsonModels.SearchResult> call, Throwable t) {
        Toast.makeText(SearchUserActivity.this,
                "Network error occurred",Toast.LENGTH_LONG).show();
    }
}
