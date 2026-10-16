package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.a1;
import com.fyber.inneractive.sdk.util.z0;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class t0 implements z0 {

    /* renamed from: a, reason: collision with root package name */
    public Boolean f1126a;
    public Integer b;
    public Integer c;
    public Boolean d;
    public Orientation e;
    public Integer f;
    public Integer g;
    public Skip h;
    public TapAction i;
    public UnitDisplayType j;
    public List k;

    public t0() {
        Boolean bool = Boolean.TRUE;
        this.f1126a = bool;
        this.b = 5000;
        this.c = 0;
        this.d = bool;
        this.f = 0;
        this.g = 2048;
        this.h = Skip.fromValue(0);
        this.k = new ArrayList();
    }

    @Override // com.fyber.inneractive.sdk.util.z0
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        a1.a(jSONObject, "autoPlay", this.f1126a);
        a1.a(jSONObject, VastAttributes.MAX_BITRATE, this.b);
        a1.a(jSONObject, VastAttributes.MIN_BITRATE, this.c);
        a1.a(jSONObject, "muted", this.d);
        a1.a(jSONObject, "orientation", this.e);
        a1.a(jSONObject, VastAttributes.PADDING, this.f);
        a1.a(jSONObject, "pivotBitrate", this.g);
        a1.a(jSONObject, "skip", this.h);
        a1.a(jSONObject, "tapAction", this.i);
        a1.a(jSONObject, "unitDisplayType", this.j);
        JSONArray jSONArray = new JSONArray();
        List<Integer> list = this.k;
        if (list != null) {
            for (Integer num : list) {
                if (num != null) {
                    jSONArray.put(num);
                }
            }
        }
        a1.a(jSONObject, "filterApi", jSONArray);
        return jSONObject;
    }
}
