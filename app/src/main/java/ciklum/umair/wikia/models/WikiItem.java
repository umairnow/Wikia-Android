package ciklum.umair.wikia.models;

/**
 * Created by umair1 on 10/13/15.
 */
public class WikiItem {

    /**
     * id : 304
     * name : RuneScape Wiki
     * hub : Gaming
     * language : en
     * topic : null
     * domain : runescape.wikia.com
     */

    private int id;
    private String name;
    private String hub;
    private String topic;
    private String domain;
    private String wordmark;
    private String title;
    private String url;
    private String headline;
    private String desc;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHub() {
        return hub;
    }

    public void setHub(String hub) {
        this.hub = hub;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getWordmark() {
        return wordmark;
    }

    public void setWordmark(String wordmark) {
        this.wordmark = wordmark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
