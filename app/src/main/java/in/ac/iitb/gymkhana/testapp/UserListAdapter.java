package in.ac.iitb.gymkhana.testapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by akash on 12/6/16.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    private List<GsonModels.User> userList;
    private Context context;
    private ItemClickListener clickListener;

    public UserListAdapter(List<GsonModels.User> userList, ItemClickListener listener) {
        this.userList = userList;
        this.clickListener = listener;
    }

    @Override
    public UserListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View userView = inflater.inflate(R.layout.search_list_item,parent,false);

        final ViewHolder userViewHolder = new ViewHolder(userView);
        userView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(v,userViewHolder.getAdapterPosition());
            }
        });
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(UserListAdapter.ViewHolder holder, int position) {
        GsonModels.User currentUser = userList.get(position);
        holder.userLogin.setText(currentUser.getLogin());
        Picasso.with(context).load(currentUser.getAvatarUrl())
                .into(holder.userProfilePic);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView userProfilePic;
        private TextView userLogin;

        public ViewHolder(View itemView) {
            super(itemView);

            userProfilePic = (ImageView) itemView.findViewById(R.id.user_profile_pic);
            userLogin = (TextView) itemView.findViewById(R.id.user_login);
        }
    }
}
