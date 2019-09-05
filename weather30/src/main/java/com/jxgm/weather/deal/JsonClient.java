package com.jxgm.weather.deal;

import java.util.*;
import java.util.concurrent.*;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JsonClient {
    final String APIURL = "http://www.tianqiapi.com/api/?version=v1&cityid=";
    final String appid = "68364224";
    final String appsecret = "2BgyEsir";

    OkHttpClient client = new OkHttpClient();

    public String visit(String url) throws IOException {
        Request request = new Request.Builder()
            .url(url)
            .build();

        try (Response response = this.client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public String getUrl(String citycode) {
        return APIURL+citycode+"&appid="+appid+"&appsecret="+appsecret;
    }
}