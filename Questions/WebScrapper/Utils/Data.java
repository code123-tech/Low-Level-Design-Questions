package Questions.WebScrapper.Utils;

import Questions.WebScrapper.model.Request;
import Questions.WebScrapper.model.Response;

public class Data {
    public static final Request[] requests = {
            new Request("abc.com", null, null),
            new Request("def.com", null, null),
            new Request("ghi.com", null, null),
            new Request("jkl.com", null, null),
            new Request("mno.com", null, null),
            new Request("pqr.com", null, null),
            new Request("stu.com", null, null),
            new Request("vwx.com", null, null),
            new Request("yza.com", null, null),
            new Request("bcd.com", null, null),
            new Request("efg.com", null, null),
            new Request("hij.com", null, null),
            new Request("klm.com", null, null),
            new Request("nop.com", null, null),
            new Request("qrs.com", null, null),
            new Request("tuv.com", null, null),
            new Request("wxy.com", null, null),
            new Request("zab.com", null, null)
    };

    public static Response fetchResponse(Request request) {
        return new Response("200","data fetched from " + request.getUrl(), "success");
    }
}
