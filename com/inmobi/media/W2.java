package com.inmobi.media;

import com.inmobi.commons.core.configs.Config;
import com.unity3d.services.UnityAdsConstants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class W2 {

    /* renamed from: a, reason: collision with root package name */
    public final Config f2468a;
    public final int b;
    public R2 c;

    public W2(JSONObject jSONObject, Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.f2468a = config;
        int i = -1;
        this.b = -1;
        if (jSONObject != null) {
            try {
                int i2 = jSONObject.getInt("status");
                if (i2 == 200) {
                    i = 200;
                } else if (i2 != 304) {
                    int i3 = 404;
                    if (i2 != 404) {
                        i3 = 500;
                        if (i2 != 500) {
                        }
                    }
                    i = i3;
                } else {
                    i = 304;
                }
                this.b = i;
                if (i != 200) {
                    if (i == 304) {
                        Intrinsics.checkNotNullExpressionValue("a3", "access$getTAG$cp(...)");
                        config.getType();
                        return;
                    } else {
                        R2 r2 = new R2((byte) 1, UnityAdsConstants.Messages.MSG_INTERNAL_ERROR);
                        Intrinsics.checkNotNullExpressionValue("a3", "access$getTAG$cp(...)");
                        config.getType();
                        this.c = r2;
                        return;
                    }
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                G2 g2 = Config.Companion;
                String type = config.getType();
                Intrinsics.checkNotNull(jSONObject2);
                String accountId$media_release = config.getAccountId$media_release();
                long currentTimeMillis = System.currentTimeMillis();
                g2.getClass();
                Config a2 = G2.a(type, jSONObject2, accountId$media_release, currentTimeMillis);
                if (a2 == null) {
                    this.c = new R2((byte) 3, "The received config has failed backend contract.");
                } else {
                    this.f2468a = a2;
                }
                Intrinsics.checkNotNullExpressionValue("a3", "access$getTAG$cp(...)");
                this.f2468a.getType();
                this.f2468a.isValid();
                if (this.f2468a.isValid()) {
                    return;
                }
                R2 r22 = new R2((byte) 2, "The received config has failed validation.");
                Intrinsics.checkNotNullExpressionValue("a3", "access$getTAG$cp(...)");
                this.f2468a.getType();
                this.c = r22;
            } catch (JSONException e) {
                String localizedMessage = e.getLocalizedMessage();
                R2 r23 = new R2((byte) 2, localizedMessage == null ? "Exception in config validation" : localizedMessage);
                this.f2468a.getType();
                this.c = r23;
            }
        }
    }
}
