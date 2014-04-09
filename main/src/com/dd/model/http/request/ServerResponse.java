package com.dd.model.http.request;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public interface ServerResponse {

    public void onError(@NotNull ServerError serverError);
    public void onSuccess(@NotNull JSONObject jsonObject);
}
