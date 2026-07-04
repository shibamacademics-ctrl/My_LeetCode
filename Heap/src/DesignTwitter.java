import java.util.*;

class Tweet implements Comparable<Tweet> {
    int time;
    int tweetId;

    Tweet(int t, int id) {
        time = t;
        tweetId = id;
    }

    @Override
    public int compareTo(Tweet that) {
        return that.time - this.time; // Descending order
    }
}

class User {
    int userId;
    HashSet<Integer> followers;
    LinkedList<Tweet> tweets;

    User(int userId) {
        this.userId = userId;
        followers = new HashSet<>();
        followers.add(userId); // Follow self
        tweets = new LinkedList<>();
    }

    public void addTweet(Tweet t) {
        tweets.addFirst(t);
    }

    public void addFollower(int followeeId) {
        followers.add(followeeId);
    }

    public void removeFollower(int followeeId) {
        if (followeeId != userId) { // Cannot unfollow self
            followers.remove(followeeId);
        }
    }
}

class Twitter {
    HashMap<Integer, User> userMap;
    int timeCounter;

    public Twitter() {
        userMap = new HashMap<>();
        timeCounter = 0;
    }

    public void postTweet(int userId, int tweetId) {
        timeCounter++;

        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }

        User user = userMap.get(userId);
        user.addTweet(new Tweet(timeCounter, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {

        if (!userMap.containsKey(userId)) {
            return new ArrayList<>();
        }

        PriorityQueue<Tweet> pq = new PriorityQueue<>();

        User user = userMap.get(userId);

        for (int followeeId : user.followers) {
            User followee = userMap.get(followeeId);

            if (followee == null)
                continue;

            int count = 0;

            for (Tweet tweet : followee.tweets) {
                pq.offer(tweet);
                count++;

                if (count == 10)
                    break;
            }
        }

        List<Integer> res = new ArrayList<>();

        while (!pq.isEmpty() && res.size() < 10) {
            res.add(pq.poll().tweetId);
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {

        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }

        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }

        userMap.get(followerId).addFollower(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (!userMap.containsKey(followerId))
            return;

        userMap.get(followerId).removeFollower(followeeId);
    }
}

public class DesignTwitter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Twitter twitter = new Twitter();

        int q = sc.nextInt();

        while (q-- > 0) {

            String op = sc.next();

            switch (op) {

                case "post":
                    int userId = sc.nextInt();
                    int tweetId = sc.nextInt();
                    twitter.postTweet(userId, tweetId);
                    break;

                case "follow":
                    int follower = sc.nextInt();
                    int followee = sc.nextInt();
                    twitter.follow(follower, followee);
                    break;

                case "unfollow":
                    follower = sc.nextInt();
                    followee = sc.nextInt();
                    twitter.unfollow(follower, followee);
                    break;

                case "feed":
                    userId = sc.nextInt();
                    List<Integer> feed = twitter.getNewsFeed(userId);

                    if (feed.isEmpty()) {
                        System.out.println("[]");
                    } else {
                        for (int id : feed)
                            System.out.print(id + " ");
                        System.out.println();
                    }
                    break;

                default:
                    System.out.println("Invalid command");
            }
        }

        sc.close();
    }
}