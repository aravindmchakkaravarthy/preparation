package leetcode.design.medium;

import java.util.*;

/**
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 * <p>
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * Example:
 * <p>
 * Twitter twitter = new Twitter();
 * <p>
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * <p>
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 * <p>
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 * <p>
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 * <p>
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 */
public class Twitter {

    private int timestamp = 0;

    class Tweet{
        int id;
        int time;
        Tweet next;
        Tweet(int id){
            this.id = id++;
            time=timestamp++;
        }
    }

    class User{
        int id;
        Set<Integer> followed;
        Tweet head;

        User(int id){
            this.id = id;
            this.followed = new HashSet<>();
            follow(id);
        }

        void follow(int id){
            followed.add(id);
        }

        void unfollow(int id){
            followed.remove(id);
        }

        void post(int id){
            Tweet tweet = new Tweet(id);
            tweet.next = head;
            head = tweet;
        }
    }

    Map<Integer, User> userMap;

    Twitter(){
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId){
        userMap.putIfAbsent(userId, new User(userId));
        userMap.get(userId).post(tweetId);

    }

    public void follow(int followerId, int followeeId){
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId){
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.get(followerId).unfollow(followeeId);
    }

    public List<Integer> getNewsFeed(int userId){
        List<Integer> newsFeed = new ArrayList<>();
        if(!userMap.containsKey(userId)) return newsFeed;
        Set<Integer> users = userMap.get(userId).followed;

        PriorityQueue<Tweet> q = new PriorityQueue<>((a,b)->b.time-a.time);
        for(int id: users){
            Tweet tweet = userMap.get(id).head;
            if(tweet != null){
                q.add(tweet);
            }
        }
        int n = 0;
        while(!q.isEmpty() && n<10){
            Tweet tweet = q.poll();
            newsFeed.add(tweet.id);
            n++;
            if(tweet.next != null){
                q.add(tweet.next);
            }
        }
        return newsFeed;
    }




    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 10);
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        twitter.unfollow(1, 2);
        twitter.follow(2, 1);

        System.out.println(twitter.getNewsFeed(1));
        System.out.println(twitter.getNewsFeed(2));
    }
}
