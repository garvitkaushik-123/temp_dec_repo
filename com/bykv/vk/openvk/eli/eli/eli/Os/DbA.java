package com.bykv.vk.openvk.eli.eli.eli.Os;

import android.text.TextUtils;
import io.ktor.http.ContentDisposition;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    private int DbA;
    private String FC;
    private String MGA;
    private int NU;
    private long Os;
    private String aAs;
    private double aGH;
    private double du;
    private int eli;
    private String kb;
    private int nlS;
    private String ui;
    private String wC;
    private float nn = -1.0f;
    private int Dfc = 0;
    private int aqO = 0;
    private int dV = 0;
    private int nGm = 0;
    private int QX = 307200;
    private int Xb = 1;

    public int eli() {
        return this.nlS;
    }

    public void eli(int i) {
        this.nlS = i;
    }

    public int DbA() {
        return this.eli;
    }

    public void DbA(int i) {
        this.eli = i;
    }

    public int Os() {
        return this.DbA;
    }

    public void Os(int i) {
        this.DbA = i;
    }

    public int aGH() {
        return this.NU;
    }

    public void aGH(int i) {
        this.NU = i;
    }

    public long ui() {
        return this.Os;
    }

    public void eli(long j) {
        this.Os = j;
    }

    public double MGA() {
        return this.aGH;
    }

    public void eli(double d) {
        this.aGH = d;
    }

    public double kb() {
        return this.du;
    }

    public float wC() {
        return this.nn;
    }

    public String FC() {
        return this.ui;
    }

    public void eli(String str) {
        this.ui = str;
    }

    public String aAs() {
        return this.MGA;
    }

    public void DbA(String str) {
        this.MGA = str;
    }

    public String du() {
        return this.kb;
    }

    public void Os(String str) {
        this.kb = str;
    }

    public String nlS() {
        return this.wC;
    }

    public void aGH(String str) {
        this.wC = str;
    }

    public String NU() {
        return this.FC;
    }

    public void ui(String str) {
        this.FC = str;
    }

    public String nn() {
        if (TextUtils.isEmpty(this.aAs)) {
            this.aAs = com.bykv.vk.openvk.eli.eli.eli.kb.DbA.eli(this.kb);
        }
        return this.aAs;
    }

    public void MGA(String str) {
        this.aAs = str;
    }

    public int Dfc() {
        if (this.QX < 0) {
            this.QX = 307200;
        }
        long j = this.QX;
        long j2 = this.Os;
        if (j > j2) {
            this.QX = (int) j2;
        }
        return this.QX;
    }

    public void ui(int i) {
        this.QX = i;
    }

    public int aqO() {
        return this.dV;
    }

    public void MGA(int i) {
        this.dV = i;
    }

    public int dV() {
        return this.nGm;
    }

    public void kb(int i) {
        this.nGm = i;
    }

    public JSONObject nGm() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", DbA());
            jSONObject.put("cover_url", aAs());
            jSONObject.put("cover_width", Os());
            jSONObject.put("endcard", nlS());
            jSONObject.put("file_hash", nn());
            jSONObject.put("resolution", FC());
            jSONObject.put(ContentDisposition.Parameters.Size, ui());
            jSONObject.put("video_duration", MGA());
            jSONObject.put("video_url", du());
            jSONObject.put("playable_download_url", NU());
            jSONObject.put("if_playable_loading_show", QX());
            jSONObject.put("remove_loading_page_type", Xb());
            jSONObject.put("fallback_endcard_judge", eli());
            jSONObject.put("video_preload_size", Dfc());
            jSONObject.put("reward_video_cached_type", aqO());
            jSONObject.put("execute_cached_type", dV());
            jSONObject.put("endcard_render", aGH());
            jSONObject.put("replay_time", CMM());
            jSONObject.put("play_speed_ratio", wC());
            if (kb() > 0.0d) {
                jSONObject.put("start", kb());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int QX() {
        return this.Dfc;
    }

    public void wC(int i) {
        this.Dfc = i;
    }

    public int Xb() {
        return this.aqO;
    }

    public void FC(int i) {
        this.aqO = i;
    }

    public boolean bf() {
        return this.dV == 0;
    }

    public void aAs(int i) {
        this.Xb = Math.min(4, Math.max(1, i));
    }

    public int CMM() {
        return this.Xb;
    }
}
