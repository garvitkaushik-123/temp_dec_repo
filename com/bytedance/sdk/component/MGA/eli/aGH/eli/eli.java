package com.bytedance.sdk.component.MGA.eli.aGH.eli;

import android.text.TextUtils;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli implements com.bytedance.sdk.component.MGA.eli.aGH.eli {
    private DbA DbA;
    private String FC;
    private long MGA;
    private byte Os;
    private byte aAs;
    private byte aGH;
    private String du;
    protected JSONObject eli;
    private long kb;
    private int nlS;
    private long ui;
    private String wC;

    public eli(String str, JSONObject jSONObject) {
        this.FC = str;
        this.eli = jSONObject;
    }

    public eli(String str, DbA dbA) {
        this.FC = str;
        this.DbA = dbA;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli
    public DbA eli() {
        return this.DbA;
    }

    private eli() {
    }

    public String du() {
        return this.du;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli
    public synchronized JSONObject kb() {
        DbA dbA;
        if (this.eli == null && (dbA = this.DbA) != null) {
            this.eli = dbA.eli(du());
        }
        return this.eli;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli
    public void eli(JSONObject jSONObject) {
        this.eli = jSONObject;
    }

    public static com.bytedance.sdk.component.MGA.eli.aGH.eli Os(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("type");
            int optInt2 = jSONObject.optInt(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY);
            eli eliVar = new eli();
            eliVar.eli((byte) optInt);
            eliVar.DbA((byte) optInt2);
            eliVar.eli(jSONObject.optJSONObject("event"));
            eliVar.eli(jSONObject.optString("localId"));
            eliVar.DbA(jSONObject.optString("genTime"));
            eliVar.eli(jSONObject.optInt("channel"));
            return eliVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    public void Os(byte b) {
        this.aAs = b;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli
    public byte DbA() {
        return this.aAs;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli
    public String Os() {
        return this.FC;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli
    public byte aGH() {
        return this.Os;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli
    public void eli(byte b) {
        this.Os = b;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli
    public void eli(String str) {
        this.FC = str;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli
    public void DbA(String str) {
        this.wC = str;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli
    public void eli(long j) {
        this.ui = j;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli
    public long wC() {
        return this.ui;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli
    public void DbA(long j) {
        this.MGA = j;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli
    public long FC() {
        return this.MGA;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli
    public void Os(long j) {
        this.kb = j;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli
    public int aAs() {
        return this.nlS;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli
    public void eli(int i) {
        this.nlS = i;
    }

    public String nlS() {
        return this.wC;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli
    public void DbA(byte b) {
        this.aGH = b;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli
    public byte ui() {
        return this.aGH;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli
    public String MGA() {
        if (TextUtils.isEmpty(this.FC)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.FC);
            jSONObject.put("event", kb());
            jSONObject.put("genTime", nlS());
            jSONObject.put(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, (int) this.aGH);
            jSONObject.put("type", (int) this.Os);
            jSONObject.put("channel", this.nlS);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }
}
