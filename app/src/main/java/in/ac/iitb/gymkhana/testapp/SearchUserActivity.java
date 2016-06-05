package in.ac.iitb.gymkhana.testapp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SearchUserActivity extends AppCompatActivity {

    private String searchQuery;
    private String queryFromBundle;
    private Bundle queryBundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);
        if(getIntent()!=null){
            searchQuery = getIntent().getStringExtra(Constants.KEY_SEARCH_QUERY);
            queryBundle = getIntent().getBundleExtra(Constants.KEY_QUERY_BUNDLE);
            queryFromBundle = queryBundle.getString(Constants.KEY_SEARCH_QUERY);
        }
        Toast.makeText(SearchUserActivity.this,"Search string is " + searchQuery,Toast.LENGTH_SHORT).show();
    }
}
