package com.tiktok.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class TTKeyValueStore {
    private final SharedPreferences preferences;

    public TTKeyValueStore(Context ctx) {
        this.preferences = ctx.getApplicationContext().getSharedPreferences(TTConst.TTSDK_KEY_VALUE_STORE, 0);
    }

    public String get(String key) {
        return this.preferences.getString(key, null);
    }

    public void set(String key, Object value) {
        this.preferences.edit().putString(key, value.toString()).apply();
    }

    public void set(HashMap<String, Object> data) {
        SharedPreferences.Editor edit = this.preferences.edit();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            edit.putString(entry.getKey(), entry.getValue().toString());
        }
        edit.apply();
    }
}
