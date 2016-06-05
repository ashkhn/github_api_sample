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
            searchQuery = getIntent().getStringExtra("search_query");
            queryBundle = getIntent().getBundleExtra("query_bundle");
            queryFromBundle = queryBundle.getString("search_query");
        }
        Toast.makeText(SearchUserActivity.this,"Search string is " + searchQuery,Toast.LENGTH_SHORT).show();
    }
}
