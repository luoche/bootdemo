package com.workec.wyf.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * config
 *
 * @author : wangyafei@ecqun.com
 * @date :  2018-04-18 16:27
 **/
@Component
@ConfigurationProperties(prefix = "web.config")
public class WebConfig {

    private String webTitle;

    private String authorName;

    private String url;

    public String getWebTitle() {
        return webTitle;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
