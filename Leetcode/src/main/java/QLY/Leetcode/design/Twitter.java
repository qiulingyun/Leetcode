package QLY.Leetcode.design;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/design-twitter/
 * 355. 设计推特
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近 10 条推文。
 *
 * 实现 Twitter 类：
 * Twitter() 初始化简易版推特对象
 * void postTweet(int userId, int tweetId) 根据给定的 tweetId 和 userId 创建一条新推文。每次调用此函数都会使用一个不同的 tweetId 。
 * List<Integer> getNewsFeed(int userId) 检索当前用户新闻推送中最近  10 条推文的 ID 。新闻推送中的每一项都必须是由用户关注的人或者是用户自己发布的推文。推文必须 按照时间顺序由最近到最远排序 。
 * void follow(int followerId, int followeeId) ID 为 followerId 的用户开始关注 ID 为 followeeId 的用户。
 * void unfollow(int followerId, int followeeId) ID 为 followerId 的用户不再关注 ID 为 followeeId 的用户。
 */
public class Twitter {

    private final Map<Integer, HashSet<Integer>> followeesMap;
    private final Map<Integer, LinkedList<TwitterContext>> tweetMap;
    private int time;
    private static final int SHOW_NUM = 10;
    private static final class TwitterContext{
        public int twitterId;
        public int createTime;

        public TwitterContext(int twitterId, int createTime) {
            this.twitterId = twitterId;
            this.createTime = createTime;
        }
    }

    public Twitter() {
        this.followeesMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
        this.time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        LinkedList<TwitterContext> tweets = tweetMap.getOrDefault(userId, new LinkedList<>());
        tweets.addFirst(new TwitterContext(tweetId, time++));
        tweetMap.putIfAbsent(userId, tweets);
    }

    public List<Integer> getNewsFeed(int userId) {
        HashSet<Integer> followees = followeesMap.getOrDefault(userId, new HashSet<>(Set.of(userId)));
        followeesMap.putIfAbsent(userId, followees);
        List<LinkedList<TwitterContext>> allTweets = new ArrayList<>();
        for (int followee: followees) {
            if (tweetMap.containsKey(followee)){
                allTweets.add(tweetMap.get(followee));
            }
        }
        PriorityQueue<ListIterator<TwitterContext>> queue = new PriorityQueue<>((a,b)->{
            if (a.hasNext() && b.hasNext()){
                int res = b.next().createTime - a.next().createTime;
                a.previous();
                b.previous();
                return res;
            }else if (a.hasNext()){
                return -1;
            }
            return 1;
        });
        allTweets.forEach(twitterContextLinkedList -> {
            ListIterator<TwitterContext> twitterContextListIterator = twitterContextLinkedList.listIterator();
            if (twitterContextListIterator.hasNext())
                queue.add(twitterContextListIterator);
        });

        List<Integer> results = new ArrayList<>();
        while (results.size() < SHOW_NUM && !queue.isEmpty()){
            ListIterator<TwitterContext> top = queue.poll();
            results.add(top.next().twitterId);
            if (top.hasNext())
                queue.add(top);
        }
        return results;
    }

    public void follow(int followerId, int followeeId) {
        HashSet<Integer> followees = followeesMap.getOrDefault(followerId, new HashSet<>(Set.of(followerId)));
        followees.add(followeeId);
        followeesMap.putIfAbsent(followerId, followees);

    }

    public void unfollow(int followerId, int followeeId) {
        if (followeesMap.containsKey(followerId)){
            followeesMap.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 5)
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);    // 用户 1 关注了用户 2
        twitter.postTweet(2, 6); // 用户 2 发送了一个新推文 (推文 id = 6)
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);  // 用户 1 取消关注了用户 2
        System.out.println(twitter.getNewsFeed(1));

    }
}
