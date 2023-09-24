package Questions.WebScrapper.model;

import java.util.Map;

public class Request {
    private String url;
    private Map<String, String> headers;
    private Map<String, String> params;
    public Request(){}
    public Request(String url, Map<String, String> headers, Map<String, String> params) {
        this.url = url;
        this.headers = headers;
        this.params = params;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
