package com.fyber.inneractive.sdk.config.remote;

import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public Boolean f1122a;
    public Integer b;
    public Integer c;
    public Skip d;
    public Boolean e;
    public TapAction f;
    public Orientation g;
    public Integer h;
    public Integer i;
    public UnitDisplayType j;
    public final ArrayList k = new ArrayList();

    public static j a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        j jVar = new j();
        int optInt = jSONObject.optInt(VastAttributes.MAX_BITRATE, Integer.MIN_VALUE);
        Integer valueOf = Integer.valueOf(optInt);
        int optInt2 = jSONObject.optInt(VastAttributes.MIN_BITRATE, Integer.MIN_VALUE);
        Integer valueOf2 = Integer.valueOf(optInt2);
        int optInt3 = jSONObject.optInt("pivotBitrate", Integer.MIN_VALUE);
        Integer valueOf3 = Integer.valueOf(optInt3);
        int optInt4 = jSONObject.optInt(VastAttributes.PADDING, Integer.MIN_VALUE);
        Integer valueOf4 = Integer.valueOf(optInt4);
        if (optInt == Integer.MIN_VALUE) {
            valueOf = null;
        }
        jVar.b = valueOf;
        if (optInt2 == Integer.MIN_VALUE) {
            valueOf2 = null;
        }
        jVar.c = valueOf2;
        jVar.d = Skip.fromValue(Integer.valueOf(jSONObject.optInt("skip", Integer.MIN_VALUE)));
        jVar.e = jSONObject.has("muted") ? Boolean.valueOf(jSONObject.optBoolean("muted", true)) : null;
        jVar.f1122a = jSONObject.has("autoPlay") ? Boolean.valueOf(jSONObject.optBoolean("autoPlay", true)) : null;
        jVar.g = Orientation.fromValue(jSONObject.optString("orientation"));
        jVar.f = TapAction.fromValue(jSONObject.optString("tap"));
        if (optInt3 == Integer.MIN_VALUE) {
            valueOf3 = null;
        }
        jVar.h = valueOf3;
        jVar.i = optInt4 != Integer.MIN_VALUE ? valueOf4 : null;
        jVar.j = UnitDisplayType.fromValue(jSONObject.optString("unitDisplayType"));
        JSONArray optJSONArray = jSONObject.optJSONArray("filterApi");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                int optInt5 = optJSONArray.optInt(i, Integer.MIN_VALUE);
                if (optInt5 != Integer.MIN_VALUE) {
                    jVar.k.add(Integer.valueOf(optInt5));
                }
            }
        }
        return jVar;
    }
}
