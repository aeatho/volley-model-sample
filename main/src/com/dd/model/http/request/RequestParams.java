package com.dd.model.http.request;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class RequestParams {

    protected String url;
    protected JSONObject jsonObject;
    protected String accessToken;
    protected ServerResponse listener;

    public RequestParams listener(@NotNull ServerResponse listener) {
        this.listener = listener;
        return this;
    }

    public RequestParams json(@Nullable JSONObject JSONObject) {
        jsonObject = JSONObject;
        return this;
    }

    public RequestParams driverToken(@Nullable String driverToken) {
        this.accessToken = driverToken;
        return this;
    }

    public RequestParams url(@NotNull String url) {
        this.url = url;
        return this;
    }
}
