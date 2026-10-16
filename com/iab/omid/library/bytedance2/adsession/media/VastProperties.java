package com.iab.omid.library.bytedance2.adsession.media;

import com.iab.omid.library.bytedance2.utils.d;
import com.iab.omid.library.bytedance2.utils.g;
import com.ironsource.C3040d4;
import io.bidmachine.unified.UnifiedMediationParams;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class VastProperties {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f1921a;
    private final Float b;
    private final boolean c;
    private final Position d;

    private VastProperties(boolean z, Float f, boolean z2, Position position) {
        this.f1921a = z;
        this.b = f;
        this.c = z2;
        this.d = position;
    }

    public static VastProperties createVastPropertiesForNonSkippableMedia(boolean z, Position position) {
        g.a(position, "Position is null");
        return new VastProperties(false, null, z, position);
    }

    public static VastProperties createVastPropertiesForSkippableMedia(float f, boolean z, Position position) {
        g.a(position, "Position is null");
        return new VastProperties(true, Float.valueOf(f), z, position);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f1921a);
            if (this.f1921a) {
                jSONObject.put(UnifiedMediationParams.KEY_SKIP_OFFSET, this.b);
            }
            jSONObject.put("autoPlay", this.c);
            jSONObject.put(C3040d4.h.L, this.d);
            return jSONObject;
        } catch (JSONException e) {
            d.a("VastProperties: JSON error", e);
            return jSONObject;
        }
    }

    public Position getPosition() {
        return this.d;
    }

    public Float getSkipOffset() {
        return this.b;
    }

    public boolean isAutoPlay() {
        return this.c;
    }

    public boolean isSkippable() {
        return this.f1921a;
    }
}
