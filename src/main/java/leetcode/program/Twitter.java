package leetcode.program;

import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class Twitter {

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        List<Pair<Integer, Integer>> tweetList = userTweetMap.getOrDefault(userId, new ArrayList());
        tweetList.add(new Pair(tweetId, Seq++));
        userTweetMap.put(userId, tweetList);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {

        List<Integer> lst = userFolloweeMap.getOrDefault(userId, new ArrayList<>());
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<>(10,
            ( o1,  o2) -> o1.getValue().compareTo(o2.getValue()));
        for(Integer x : lst){
            addToQueue(x, pq);
        }
        if(!lst.contains(userId)) addToQueue(userId, pq);
        List<Integer> answer = new ArrayList<Integer>();
        int count = 0;
        while(!pq.isEmpty() && count < 10){
            answer.add(0, pq.poll().getKey());
            count++;
        }
        return answer;
    }

    private void addToQueue(Integer x,  Queue<Pair<Integer, Integer>> pq)
    {
        List<Pair<Integer, Integer>> msgList = userTweetMap.get(x);
        if (msgList == null) return;
        Integer msgSize = msgList.size();
        int count = 0;
        while( msgSize > 0 && count < 10){
            pq.add(msgList.get(msgSize-1));
            if(pq.size()>10) pq.poll();
            msgSize--;
            count++;
        }
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        List<Integer> followList = userFolloweeMap.getOrDefault(followerId, new ArrayList());
        if(!followList.contains(followeeId)) {
            followList.add(followeeId);
            userFolloweeMap.put(followerId, followList);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Integer Ier = Integer.valueOf(followerId);
        Integer Ied = Integer.valueOf(followeeId);
        List<Integer> followList = userFolloweeMap.get(followerId);
        if(followList != null && followList.contains(followeeId)){
            followList.remove(Ied);
        }
    }

    /* each user has a tweet list */
    private Map<Integer, List<Pair<Integer, Integer>>> userTweetMap = new ConcurrentHashMap<>();
    /* each user has a followee list including himself */
    private Map<Integer, List<Integer>> userFolloweeMap = new ConcurrentHashMap<>();
    private static Integer Seq = new Integer(0);

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        twitter.postTweet(1,5);
        twitter.postTweet(2,3);
        twitter.postTweet(1,101);
        twitter.postTweet(2,13);
        twitter.postTweet(2,10);
        twitter.postTweet(1,2);
        twitter.postTweet(1,94);
        twitter.postTweet(2,505);
        twitter.postTweet(1,333);
        twitter.postTweet(2,22);
        twitter.postTweet(1,11);
        twitter.postTweet(1,205);
        twitter.postTweet(2,203);
        twitter.postTweet(1,201);
        twitter.postTweet(2,213);
        twitter.postTweet(1,200);
        twitter.postTweet(2,202);
        twitter.postTweet(1,204);
        twitter.postTweet(2,208);
        twitter.postTweet(2,233);
        twitter.postTweet(1,222);
        twitter.postTweet(2,211);

        twitter.getNewsFeed(1);
        twitter.follow(1,2);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1,2);
        System.out.println(twitter.getNewsFeed(1));



    }
}
