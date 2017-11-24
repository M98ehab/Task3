package com.mohamed.task3.Model;

import java.util.List;

/**
 * Created by mohamed on 11/23/2017.
 */





    public class RssObject
    {
        public String status;
        public Feed feed;
        public List<item> items;

        public RssObject(String status, Feed feed, List<item> items) {
            this.status = status;
            this.feed = feed;
            this.items = items;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Feed getFeed() {
            return feed;
        }

        public void setFeed(Feed feed) {
            this.feed = feed;
        }

        public List<item> getItems() {
            return items;
        }

        public void setItems(List<item> items) {
            this.items = items;
        }
    }

