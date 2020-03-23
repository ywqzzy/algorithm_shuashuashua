package design;

import java.util.*;

public class 设计推特 {
    class Twitter {
        Map<Integer, Set<Integer>> followees;
        Map<Integer, List<Integer>> userTweets;
        Map<Integer, Integer> tweetsTime;
        int time = 0;
        /** Initialize your data structure here. */
        public Twitter() {
            followees = new HashMap<>();
            userTweets = new HashMap<>();
            tweetsTime = new HashMap<>();
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            if(!tweetsTime.containsKey(tweetId)) {
                userTweets.putIfAbsent(userId, new ArrayList<>());
                userTweets.get(userId).add(tweetId);
                tweetsTime.putIfAbsent(tweetId, time++);
            }
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            Set<Integer> subscribedUsers = followees.getOrDefault(userId, new HashSet<>());
            subscribedUsers.add(userId);
            int size = subscribedUsers.size();
            PriorityQueue<int[]> tweetQueue = new PriorityQueue<>(size,
                    Collections.reverseOrder(
                            Comparator.comparingInt(ut -> tweetsTime.get(userTweets.get(ut[0]).get(ut[1])))));
            for (Integer subscribedUser : subscribedUsers) {
                List<Integer> tweets = userTweets.get(subscribedUser);
                if (tweets != null && !tweets.isEmpty()) {
                    tweetQueue.add(new int[]{subscribedUser, tweets.size() - 1});
                }
            }
            int tweetsNum = 10;
            List<Integer> feed = new ArrayList<>(tweetsNum);
            while(tweetsNum-- > 0 && !tweetQueue.isEmpty()) {
                int[] poll = tweetQueue.poll();
                int user = poll[0];
                int tweetIndex = poll[1];
                List<Integer> tweets = userTweets.get(user);
                feed.add(tweets.get(tweetIndex));
                if(tweetIndex > 0) tweetQueue.add((new int[]{user, tweetIndex - 1}));
            }
            subscribedUsers.remove(userId);
            return feed;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if(followeeId != followerId) {
                followees.putIfAbsent(followerId, new HashSet<>());
                followees.get(followerId).add(followeeId);
            }
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if(followeeId != followerId) {
                followees.putIfAbsent(followerId, new HashSet<>());
                followees.get(followerId).remove(followeeId);
            }
        }
    }

}
