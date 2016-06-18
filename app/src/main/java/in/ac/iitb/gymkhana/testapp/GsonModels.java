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

    public class UserDetails{

        private String name;
        private String company;
        private String location;
        private String email;
        private String bio;
        private int followers;
        private int following;
        @SerializedName("public_repos")
        private int publicRepos;
        @SerializedName("public_gists")
        private int publicGists;

        public UserDetails(String name, String company, String location, String email, String bio, int followers, int following, int publicRepos, int publicGists) {
            this.name = name;
            this.company = company;
            this.location = location;
            this.email = email;
            this.bio = bio;
            this.followers = followers;
            this.following = following;
            this.publicRepos = publicRepos;
            this.publicGists = publicGists;
        }

        public UserDetails() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public int getFollowers() {
            return followers;
        }

        public void setFollowers(int followers) {
            this.followers = followers;
        }

        public int getFollowing() {
            return following;
        }

        public void setFollowing(int following) {
            this.following = following;
        }

        public int getPublicRepos() {
            return publicRepos;
        }

        public void setPublicRepos(int publicRepos) {
            this.publicRepos = publicRepos;
        }

        public int getPublicGists() {
            return publicGists;
        }

        public void setPublicGists(int publicGists) {
            this.publicGists = publicGists;
        }
    }


}
