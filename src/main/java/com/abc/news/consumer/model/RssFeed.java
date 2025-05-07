package com.abc.news.consumer.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "rss")
public class RssFeed {

    private Channel channel;

    @XmlElement(name = "channel")
    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public static class Channel {
        private String title;
        private String link;
        private String description;
        private List<Item> items;

        @XmlElement
        public String getTitle() { return title; }

        public void setTitle(String title) { this.title = title; }

        @XmlElement
        public String getLink() { return link; }

        public void setLink(String link) { this.link = link; }

        @XmlElement
        public String getDescription() { return description; }

        public void setDescription(String description) { this.description = description; }

        @XmlElement(name = "item")
        public List<Item> getItems() { return items; }

        public void setItems(List<Item> items) { this.items = items; }
    }

    public static class Item {
        private String title;
        private String link;
        private String description;
        private String pubDate;
        private MediaContent mediaContent;

        @XmlElement
        public String getTitle() { return title; }

        public void setTitle(String title) { this.title = title; }

        @XmlElement
        public String getLink() { return link; }

        public void setLink(String link) { this.link = link; }

        @XmlElement
        public String getDescription() { return description; }

        public void setDescription(String description) { this.description = description; }

        @XmlElement
        public String getPubDate() { return pubDate; }

        public void setPubDate(String pubDate) { this.pubDate = pubDate; }

        @XmlElement(name = "content", namespace = "http://search.yahoo.com/mrss/")
        public MediaContent getMediaContent() { return mediaContent; }
        public void setMediaContent(MediaContent mediaContent) { this.mediaContent = mediaContent; }
    }

    public static class MediaContent {
        private String url;
        private String medium;
        private int height;
        private int width;

        @XmlAttribute
        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }

        @XmlAttribute
        public String getMedium() { return medium; }
        public void setMedium(String medium) { this.medium = medium; }

        @XmlAttribute
        public int getHeight() { return height; }
        public void setHeight(int height) { this.height = height; }

        @XmlAttribute
        public int getWidth() { return width; }
        public void setWidth(int width) { this.width = width; }
    }
}
