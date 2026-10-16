package com.bytedance.adsdk.ugeno.eli.eli;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class eli {
    protected com.bytedance.adsdk.ugeno.DbA.Os DbA;
    private String Os;
    protected JSONObject eli;

    public abstract void DbA();

    public abstract void DbA(Canvas canvas);

    public abstract List<PropertyValuesHolder> Os();

    public abstract void eli(int i, int i2);

    public abstract void eli(Canvas canvas);

    public eli(com.bytedance.adsdk.ugeno.DbA.Os os, JSONObject jSONObject) {
        this.eli = jSONObject;
        this.DbA = os;
        eli();
    }

    public void eli() {
        this.Os = this.eli.optString("type");
        DbA();
    }

    public String aGH() {
        return this.Os;
    }

    /* renamed from: com.bytedance.adsdk.ugeno.eli.eli.eli$eli, reason: collision with other inner class name */
    public static class C0125eli {
        public static eli eli(com.bytedance.adsdk.ugeno.DbA.Os os, JSONObject jSONObject) {
            if (os == null || jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("type");
            optString.hashCode();
            switch (optString) {
                case "stretch":
                    return new ui(os, jSONObject);
                case "ripple":
                    return new DbA(os, jSONObject);
                case "rub_in":
                    return new Os(os, jSONObject);
                case "shine":
                    return new aGH(os, jSONObject);
                default:
                    return null;
            }
        }
    }
}
