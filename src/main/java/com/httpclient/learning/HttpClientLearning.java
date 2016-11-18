package com.httpclient.learning;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * learning HttpClient api
 * Created by yaguang.wang on 2016/11/18.
 */
public class HttpClientLearning<T> {
    private CloseableHttpClient client = HttpClients.createDefault();
    public static final ResponseHandler<String> DEFAULT_STRING_RESPONSE;

    static {
        DEFAULT_STRING_RESPONSE = getDefaultStringResponse();
    }

    public T get(String httpUrl, ResponseHandler<T> responseHandler) throws IOException {
        HttpGet httpGet = new HttpGet(httpUrl);
        System.out.println("Executing request " + httpGet.getRequestLine());
        try {
            return client.execute(httpGet, responseHandler);
        } catch (IOException e) {
            e.printStackTrace();
            client.close();
        }
        System.out.println("---------------------------------------------------");
        throw new GetUnFoundedException("Get failed");
    }

    private static ResponseHandler<String> getDefaultStringResponse() {
        return new ResponseHandler<String>() {
            public String handleResponse(HttpResponse httpResponse) throws  IOException {
                int status = httpResponse.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = httpResponse.getEntity();
                    return entity != null ? EncodingUtils.getString(EntityUtils.toString(entity).getBytes(), "UTF-8") : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status:" + status);
                }
            }
        };
    }
}
