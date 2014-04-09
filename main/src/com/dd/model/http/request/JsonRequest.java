package com.dd.model.http.request;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.dd.utils.L;

import org.json.JSONObject;

public class JsonRequest extends JsonObjectRequest {


    public JsonRequest(final RequestParams params) {
        super(params.url, params.jsonObject, resolveSuccess(params.listener),
                resolveError(params.listener));
        L.d("JsonRequest url: " + params.url);
        L.d("JsonRequest jsonObject: " + params.jsonObject);
    }

    private static Response.Listener<JSONObject> resolveSuccess(final ServerResponse listener) {
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                L.v("onResponse: " + jsonObject);
                if (listener != null) {
                    listener.onSuccess(jsonObject);
                }
            }
        };
    }

    private static Response.ErrorListener resolveError(final ServerResponse listener) {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                ServerError serverError = new ServerError();

                if (error.networkResponse != null) {
                    String data = new String(error.networkResponse.data);
                    serverError = ServerError.fromJSONString(data);
                    if (serverError.getCode() == ServerError.CODE_UNDEFINED) {
                        serverError.setCode(error.networkResponse.statusCode);
                    }
                }

                L.i("ServerError.code " + serverError.getCode());
                L.i("ServerError.message " + serverError.getMessage());

                if (listener != null) {
                    listener.onError(serverError);
                }

            }
        };
    }

}
