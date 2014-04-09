package com.dd.model.http.request;

import com.dd.utils.L;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerError {

    public static final int CODE_UNDEFINED = -1;
    public static final String MESSAGE_UNDEFINED = "Unknown error";

    private int code;
    private String message;

    public ServerError() {
        code = CODE_UNDEFINED;
        message = MESSAGE_UNDEFINED;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @NotNull
    public static ServerError fromJSONString(@Nullable String jsonString) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            L.d(e.toString());
        }

        return fromJSON(jsonObject);
    }

    @NotNull
    public static ServerError fromJSON(@Nullable JSONObject jsonObject) {
        ServerError serverError = new ServerError();

        if (jsonObject == null) {
            return serverError;
        }

        int code = jsonObject.optInt("Code", CODE_UNDEFINED);
        String message = jsonObject.optString("Message", MESSAGE_UNDEFINED);

        serverError.setCode(code);
        serverError.setMessage(message);

        return serverError;
    }
}