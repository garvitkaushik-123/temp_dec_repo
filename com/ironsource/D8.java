package com.ironsource;

import android.app.Activity;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public interface D8 {

    public interface a {
        void onNativeAdClicked();

        void onNativeAdLoadFailed(String str);

        void onNativeAdLoadSuccess(B8 b8);

        void onNativeAdShown();
    }

    void a();

    void a(Activity activity, JSONObject jSONObject);

    void a(a aVar);

    void a(E8 e8);

    a b();

    B8 c();
}
