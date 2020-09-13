/**
 * create by
 * @author hujin 2020/9/5
 */

class Tweet {
    String username
    String text
    int retweets
    int favorites
    Date createdOn

    Tweet(String username, String text) {
        this.username = username
        this.text = text
        retweets = 0
        favorites = 0
        createdOn = new Date()
    }

    void addToRetweets() {
        retweets += 1
    }

    void addToFavorites() {
        favorites += 1
    }
}

def tweet = new Tweet("@john.doe", "Hello, twitter")
println tweet