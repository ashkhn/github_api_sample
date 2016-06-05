package in.ac.iitb.gymkhana.testapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by akash on 5/6/16.
 */

public class GsonModels {
    public class User{
        private String login;
        private int id;
        @SerializedName("avatar_url")
        private String avatarUrl;

        public User(String login, int id, String avatarUrl) {
            this.login = login;
            this.id = id;
            this.avatarUrl = avatarUrl;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }
    }

    public class SearchResult{
        @SerializedName("total_count")
        private int totalCount;
        @SerializedName("incomplete_results")
        private boolean incompleteResults;
        private List<User> items;

        public SearchResult(int totalCount, boolean incompleteResults, List<User> items) {
            this.totalCount = totalCount;
            this.incompleteResults = incompleteResults;
            this.items = items;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public boolean isIncompleteResults() {
            return incompleteResults;
        }

        public void setIncompleteResults(boolean incompleteResults) {
            this.incompleteResults = incompleteResults;
        }

        public List<User> getItems() {
            return items;
        }

        public void setItems(List<User> items) {
            this.items = items;
        }
    }
}
