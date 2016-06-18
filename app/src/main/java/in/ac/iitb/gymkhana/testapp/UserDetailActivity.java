package in.ac.iitb.gymkhana.testapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetailActivity extends AppCompatActivity
        implements Callback<GsonModels.UserDetails>{

    private String userLogin;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        if(getIntent()!=null){
            userLogin = getIntent().getStringExtra(Constants.KEY_USER_LOGIN);
        }
        progressDialog = new ProgressDialog(UserDetailActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(true);
        progressDialog.setMessage("Requesting user details");
        RetrofitInterface retrofitInterface = ServiceGenerator.createService(RetrofitInterface.class);
        retrofitInterface.getUserDetails(userLogin).enqueue(this);
        progressDialog.show();
    }

    @Override
    public void onResponse(Call<GsonModels.UserDetails> call, Response<GsonModels.UserDetails> response) {
        if(response.isSuccessful()){
            GsonModels.UserDetails userDetails = response.body();
            //TODO set views
        }
        else {
            Toast.makeText(UserDetailActivity.this, "Response code" + response.code(), Toast.LENGTH_SHORT).show();
        }
        progressDialog.dismiss();
    }

    @Override
    public void onFailure(Call<GsonModels.UserDetails> call, Throwable t) {
        //Handle failure
    }
}
