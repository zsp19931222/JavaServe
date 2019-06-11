package example.user;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import example.server.core.Request;
import example.server.core.Response;
import example.server.core.Servlet;

public class RegisterServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        //关注业务逻辑
        String uname = request.getParameter("uname");
        String[] favs = request.getParameterValues("fav");
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < 5; i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", i + uname);
            jsonArray.add(jsonObject);
        }
        response.print(jsonArray.toJSONString());
    }
}
