package Questions.WebScrapper.model;

public class Response {
    private String code;
    private Object data;
    private String message;
    public Response(){}

    public Response(String code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                ", thread='" + Thread.currentThread().getName() + '\'' +
                '}';
    }
}
