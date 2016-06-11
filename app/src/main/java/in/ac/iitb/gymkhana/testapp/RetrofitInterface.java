package in.ac.iitb.gymkhana.testapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by akash on 11/6/16.
 */

public interface RetrofitInterface {
    @GET("/search/users")
    Call<GsonModels.SearchResult> getSearchResults(@Query("q") String searchQuery);

}
