package com.inmobi.media;

import io.bidmachine.rendering.model.EventTaskParams;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.x7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2938x7 {
    public static int a(String str, JSONObject jSONObject) {
        return (str == null || !jSONObject.has(str)) ? jSONObject.getInt(EventTaskParams.STATE_GROUP_DEFAULT) : jSONObject.getInt(str);
    }
}
