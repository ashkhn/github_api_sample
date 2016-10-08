package in.ac.iitb.gymkhana.testapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetailActivity extends AppCompatActivity
        implements Callback<GsonModels.UserDetails>{

    private String userLogin;
    private String userAvatarUrl;

    private ProgressDialog progressDialog;
    private ImageView userProfilePic;
    private TextView userNameTv;
    private TextView userHandleTv;
    private TextView userBioTv;
    private TextView userLocationTv;
    private TextView userEmailTv;

    private LinearLayout detailsLl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        if(getIntent()!=null){
            userLogin = getIntent().getStringExtra(Constants.KEY_USER_LOGIN);
            userAvatarUrl = getIntent().getStringExtra(Constants.KEY_USER_AVATAR);
        }

        userProfilePic = (ImageView) findViewById(R.id.user_profile_pic);
        userNameTv = (TextView) findViewById(R.id.user_name);
        userHandleTv = (TextView) findViewById(R.id.user_handle);
        userBioTv = (TextView) findViewById(R.id.user_bio);
        userLocationTv = (TextView) findViewById(R.id.user_location);
        userEmailTv = (TextView) findViewById(R.id.user_email);
        detailsLl = (LinearLayout) findViewById(R.id.details);


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
            Picasso.with(this).load(userAvatarUrl).into(userProfilePic);
            userNameTv.setText(userDetails.getName());
            userHandleTv.setText(userLogin);
            userBioTv.setText(userDetails.getBio());
            userLocationTv.setText(userDetails.getLocation());
            userEmailTv.setText(userDetails.getEmail());
            detailsLl.setVisibility(View.VISIBLE);
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
