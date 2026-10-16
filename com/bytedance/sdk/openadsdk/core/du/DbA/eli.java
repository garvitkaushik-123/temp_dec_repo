package com.bytedance.sdk.openadsdk.core.du.DbA;

import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.openadsdk.core.du.DbA.Os;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli extends Os implements Comparable<eli> {
    public long eli;

    protected eli(long j, String str, Os.EnumC0188Os enumC0188Os, Boolean bool) {
        super(str, enumC0188Os, bool);
        this.eli = j;
    }

    public long eli() {
        return this.eli;
    }

    public static int eli(String str) {
        if (TextUtils.isEmpty(str)) {
            return Integer.MIN_VALUE;
        }
        String[] split = str.split(":");
        if (split.length == 3) {
            try {
                return (int) ((Integer.parseInt(split[0]) * Constants.ONE_HOUR) + (Integer.parseInt(split[1]) * 60000) + (Float.parseFloat(split[2]) * 1000.0f));
            } catch (Throwable unused) {
            }
        }
        return Integer.MIN_VALUE;
    }

    public boolean eli(long j) {
        return this.eli <= j && !ui();
    }

    @Override // java.lang.Comparable
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    public int compareTo(eli eliVar) {
        if (eliVar == null) {
            return 1;
        }
        long j = this.eli;
        long j2 = eliVar.eli;
        if (j > j2) {
            return 1;
        }
        return j < j2 ? -1 : 0;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.du.DbA.eli$eli, reason: collision with other inner class name */
    public static class C0189eli {
        private final long DbA;
        private Os.EnumC0188Os Os = Os.EnumC0188Os.TRACKING_URL;
        private final String eli;

        public C0189eli(String str, long j) {
            this.eli = str;
            this.DbA = j;
        }

        public eli eli() {
            return new eli(this.DbA, this.eli, this.Os, Boolean.FALSE);
        }
    }

    public JSONObject DbA() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("content", Os());
        jSONObject.put("trackingMilliseconds", this.eli);
        return jSONObject;
    }

    public String toString() {
        return super.toString();
    }
}
