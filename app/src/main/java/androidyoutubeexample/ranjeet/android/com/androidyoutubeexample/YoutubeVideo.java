package androidyoutubeexample.ranjeet.android.com.androidyoutubeexample;

/**
 * Created by ranjeet on 7/10/16.
 */


public class YoutubeVideo {

    String id, title, url, desc, channel, pub_on_date, theme, sub_theme;

    public YoutubeVideo(String id, String title, String url, String desc, String channel, String pub_on_date, String theme, String sub_theme){
        this.id = id;
        this.title = title;
        this.url = url;
        this.desc = desc;
        this.channel = channel;
        this.pub_on_date = pub_on_date;
        this.theme = theme;
        this.sub_theme = sub_theme;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getPub_on_date() {
        return pub_on_date;
    }

    public void setPub_on_date(String pub_on_date) {
        this.pub_on_date = pub_on_date;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getSub_theme() {
        return sub_theme;
    }

    public void setSub_theme(String sub_theme) {
        this.sub_theme = sub_theme;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
