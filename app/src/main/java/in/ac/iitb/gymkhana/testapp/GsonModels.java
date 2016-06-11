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
        private String url;
        @SerializedName("html_url")
        private String htmlUrl;
        @SerializedName("repos_url")
        private String reposUrl;

        public User() {
        }

        public User(String login, int id, String avatarUrl, String url, String htmlUrl, String reposUrl) {
            this.login = login;
            this.id = id;
            this.avatarUrl = avatarUrl;
            this.url = url;
            this.htmlUrl = htmlUrl;
            this.reposUrl = reposUrl;
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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHtmlUrl() {
            return htmlUrl;
        }

        public void setHtmlUrl(String htmlUrl) {
            this.htmlUrl = htmlUrl;
        }

        public String getReposUrl() {
            return reposUrl;
        }

        public void setReposUrl(String reposUrl) {
            this.reposUrl = reposUrl;
        }
    }

    public class SearchResult{
        @SerializedName("total_count")
        private int totalCount;
        @SerializedName("incomplete_results")
        private boolean incompleteResults;
        private List<User> items;

        public SearchResult() {
        }

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
