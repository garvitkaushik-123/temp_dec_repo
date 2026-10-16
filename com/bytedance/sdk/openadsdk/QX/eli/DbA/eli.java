package com.bytedance.sdk.openadsdk.QX.eli.DbA;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.core.settings.NU;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.cyF;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    private static volatile eli aGH;
    private AtomicLong eli = new AtomicLong(0);
    private int DbA = 0;
    private String Os = "";

    public static eli eli() {
        if (aGH == null) {
            synchronized (eli.class) {
                if (aGH == null) {
                    eli eliVar = new eli();
                    aGH = eliVar;
                    eliVar.Os();
                }
            }
        }
        return aGH;
    }

    private eli() {
    }

    public String DbA() {
        if (Os()) {
            return this.Os;
        }
        return "";
    }

    public void eli(String str) {
        this.Os = str;
    }

    public void eli(boolean z) {
        if (this.DbA == 1 || !TextUtils.isEmpty(DbA())) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (z || this.eli.get() <= elapsedRealtime) {
            this.eli.set(elapsedRealtime + 300000);
            cyF.eli((wC) new DeviceUtils.Os());
        }
    }

    public void eli(int i) {
        this.DbA = i;
    }

    public boolean Os() {
        return NU.nY().ujq("gaid");
    }

    public void eli(JSONObject jSONObject) {
        if (!Os() || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("gaid", this.Os);
        } catch (JSONException unused) {
        }
    }
}
