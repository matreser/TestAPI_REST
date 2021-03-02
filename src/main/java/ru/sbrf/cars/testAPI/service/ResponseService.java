package ru.sbrf.cars.testAPI.service;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ResponseService {

    public String handleResponse(String address) throws IOException, JSONException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpget = getHttpGet(address);
        String response = "";

        try {
            JSONObject JObject = new JSONObject(EntityUtils.toString(httpClient.execute(httpget).getEntity()));
            response = JObject.toString();
        } catch (JSONException e) {
            JSONArray JObject = new JSONArray(EntityUtils.toString(httpClient.execute(httpget).getEntity()));
            response = JObject.toString();
        }
        System.out.println(response);
        return response;
    }

    public String makePost(String address) throws IOException, JSONException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = getHttpPost(address);
        String response = "";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tbCodeLocal", "string");
        jsonObject.put("osbCodeLocal", "string");
        jsonObject.put("vspCodeLocal", "string");
        jsonObject.put("tbCodeGlobal", "string");
        jsonObject.put("osbCodeGlobal", "string");
        jsonObject.put("vspCodeGlobal", "string");
        jsonObject.put("shortName", "string");
        jsonObject.put("fullName", "string");
        jsonObject.put("departmentType", "TB");
        StringEntity params = new StringEntity(jsonObject.toString());
        httpPost.setEntity(params);
        try {
            JSONObject JObject = new JSONObject(EntityUtils.toString(httpClient.execute(httpPost).getEntity()));
            response = JObject.toString();
        } catch (JSONException e) {
            JSONArray JObject = new JSONArray(EntityUtils.toString(httpClient.execute(httpPost).getEntity()));
            response = JObject.toString();
        }
        System.out.println(response);
        return response;

    }

    private HttpGet getHttpGet(String address) {
        HttpGet http = new HttpGet(address);
        http.setHeader("Sec-Fetch-User", "?1");
        http.setHeader("Content-Type", "application/json");
        http.setHeader("User-Login", "qwe");
        http.setHeader("User-Current-Sector-Code", "123");
        http.setHeader("User-Roles", "TestAllPermission");
        http.setHeader("Sec-Fetch-Dest", "empty");
        http.setHeader("Sec-Fetch-Mode", "cors");
        http.setHeader("Sec-Fetch-Site", "same-origin");
        http.setHeader("x-real-ip", "127.0.0.1");
        return http;
    }

    private HttpPost getHttpPost(String address) {
        HttpPost http = new HttpPost(address);
        http.setHeader("Sec-Fetch-User", "?1");
        http.setHeader("Content-Type", "application/json");
        http.setHeader("User-Login", "qwe");
        http.setHeader("User-First-Name", "qwe");
        http.setHeader("User-Second-Name", "qwe");
        http.setHeader("User-Last-Name", "qwe");
        http.setHeader("User-Current-Sector-Code", "123");
        http.setHeader("User-Roles", "TestAllPermission");
        http.setHeader("Sec-Fetch-Dest", "empty");
        http.setHeader("Sec-Fetch-Mode", "cors");
        http.setHeader("Sec-Fetch-Site", "same-origin");
        http.setHeader("x-real-ip", "127.0.0.1");
        return http;
    }
}


