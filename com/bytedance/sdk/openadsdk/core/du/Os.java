package com.bytedance.sdk.openadsdk.core.du;

import com.bytedance.sdk.openadsdk.core.du.DbA.Os;
import com.bytedance.sdk.openadsdk.core.du.Os.eli;
import com.bytedance.sdk.openadsdk.core.model.ev;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os {
    protected int DbA;
    protected List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> MGA;
    protected eli.EnumC0190eli Os;
    private String aAs;
    protected eli.DbA aGH;
    protected int eli;
    protected List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> kb;
    private ev nlS;
    protected String ui;
    protected String wC;
    private final AtomicBoolean du = new AtomicBoolean(false);
    protected String FC = "endcard_click";

    public Os(int i, int i2, eli.EnumC0190eli enumC0190eli, eli.DbA dbA, String str, List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list, List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list2, String str2) {
        this.MGA = new ArrayList();
        this.kb = new ArrayList();
        this.eli = i;
        this.DbA = i2;
        this.Os = enumC0190eli;
        this.aGH = dbA;
        this.ui = str;
        this.MGA = list;
        this.kb = list2;
        this.wC = str2;
    }

    public int DbA() {
        return this.eli;
    }

    public int Os() {
        return this.DbA;
    }

    public void eli(long j) {
        com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(null, this.MGA, null, j, this.aAs, new Os.DbA(this.FC, this.nlS), null);
    }

    public void DbA(long j) {
        if (this.du.compareAndSet(false, true)) {
            com.bytedance.sdk.openadsdk.core.du.DbA.Os.DbA((ev) null, this.kb, (com.bytedance.sdk.openadsdk.core.du.eli.eli) null, j, this.aAs, (String) null);
        }
    }

    public static float eli(int i, int i2, int i3, int i4, eli.DbA dbA, eli.EnumC0190eli enumC0190eli) {
        if (i2 == 0 || i4 == 0) {
            return 0.0f;
        }
        float f = i;
        float f2 = i3;
        return eli(dbA, enumC0190eli) / ((Math.abs((f / i2) - (f2 / i4)) + Math.abs((f - f2) / f)) + 1.0f);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.du.Os$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] eli;

        static {
            int[] iArr = new int[eli.DbA.values().length];
            eli = iArr;
            try {
                iArr[eli.DbA.STATIC_RESOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                eli[eli.DbA.HTML_RESOURCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                eli[eli.DbA.IFRAME_RESOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static float eli(eli.DbA dbA, eli.EnumC0190eli enumC0190eli) {
        int i = AnonymousClass1.eli[dbA.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return i != 3 ? 0.0f : 1.0f;
            }
            return 1.2f;
        }
        if (eli.EnumC0190eli.JAVASCRIPT.equals(enumC0190eli)) {
            return 1.0f;
        }
        return eli.EnumC0190eli.IMAGE.equals(enumC0190eli) ? 0.8f : 0.0f;
    }

    public String aGH() {
        int i = AnonymousClass1.eli[this.aGH.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return this.ui;
            }
            if (i != 3) {
                return null;
            }
            return "<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=\"" + this.eli + "\" height=\"" + this.DbA + "\" src=\"" + this.ui + "\"></iframe>";
        }
        if (this.Os == eli.EnumC0190eli.IMAGE) {
            return "<html><head></head><body style=\"margin:0;padding:0\"><img src=\"" + this.ui + "\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" /></body></html>";
        }
        if (this.Os == eli.EnumC0190eli.JAVASCRIPT) {
            return "<script src=\"" + this.ui + "\"></script>";
        }
        return null;
    }

    public String ui() {
        if (this.aGH == eli.DbA.STATIC_RESOURCE && this.Os == eli.EnumC0190eli.IMAGE) {
            return this.ui;
        }
        return null;
    }

    public String MGA() {
        return this.ui;
    }

    public void eli(String str) {
        this.aAs = str;
    }

    public static Os DbA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("width");
        int optInt2 = jSONObject.optInt("height");
        String optString = jSONObject.optString("creativeType", eli.EnumC0190eli.NONE.toString());
        String optString2 = jSONObject.optString("resourceType", eli.DbA.HTML_RESOURCE.toString());
        String optString3 = jSONObject.optString("contentUrl");
        String optString4 = jSONObject.optString("clickThroughUri");
        JSONArray optJSONArray = jSONObject.optJSONArray("clickTrackers");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("creativeViewTrackers");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(new Os.eli(optJSONArray.optString(i)).eli());
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
            arrayList2.add(new Os.eli(optJSONArray2.optString(i2)).eli());
        }
        return new Os(optInt, optInt2, eli.EnumC0190eli.valueOf(optString), eli.DbA.valueOf(optString2), optString3, arrayList, arrayList2, optString4);
    }

    public JSONObject eli() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", this.eli);
        jSONObject.put("height", this.DbA);
        jSONObject.put("creativeType", this.Os.toString());
        jSONObject.put("resourceType", this.aGH.toString());
        jSONObject.put("contentUrl", this.ui);
        jSONObject.put("clickThroughUri", this.wC);
        jSONObject.put("clickTrackers", com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(this.MGA));
        jSONObject.put("creativeViewTrackers", com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(this.kb));
        return jSONObject;
    }

    public void eli(ev evVar) {
        this.nlS = evVar;
    }
}
