package in.ac.iitb.gymkhana.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private EditText searchQueryEt;
    private Button searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        searchQueryEt = (EditText) findViewById(R.id.search_query);
        searchBtn = (Button) findViewById(R.id.search_btn);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textContent = searchQueryEt.getText().toString();
                if(textContent.isEmpty()){
                    //Show error
                    Toast.makeText(HomeActivity.this,"Search query is empty",Toast.LENGTH_SHORT).show();
                }else{
                    //Perform search
                    Toast.makeText(HomeActivity.this,"Search query is "+ textContent,Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
