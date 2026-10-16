package com.bytedance.sdk.openadsdk.core.settings;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    public int CMM;
    public int DbA;
    public int Dfc;
    public int FC;
    public boolean GB;
    public int KM;
    public int MGA;
    public int NU;
    public int Os;
    public int QX;
    public int Ue;
    public boolean VM;
    public int Vy;
    public int Xb;
    public int aAs;
    public int aGH;
    public int aqO;
    public boolean bf;
    public int dV;
    public int du;
    public String eli;
    public List<String> ev;
    public int gG;
    public int kb;
    public int nGm;
    public int nlS;
    public int nn;
    public JSONObject nro;
    public boolean oWW;
    public int qj;
    public int ui;
    public int ujq;
    public int wC;

    private static boolean eli(int i) {
        return i == 1 || i == 2;
    }

    public DbA(JSONObject jSONObject) {
        this.DbA = 1;
        this.Os = 1;
        this.aGH = 2;
        this.ui = 1;
        this.MGA = 100;
        this.kb = 0;
        this.wC = 2;
        this.FC = 1;
        this.aAs = 3;
        this.du = 30;
        this.nlS = 30;
        this.NU = 1;
        this.nn = 1;
        this.Dfc = 2;
        this.aqO = 1500;
        this.dV = 2;
        this.nGm = 3500;
        this.QX = 0;
        this.Xb = 5;
        this.bf = false;
        this.CMM = 0;
        this.Vy = 2;
        this.gG = -1;
        this.ujq = 0;
        this.Ue = 0;
        this.KM = 5;
        this.VM = true;
        this.GB = false;
        this.oWW = false;
        this.qj = -1;
        new JSONObject();
        this.nro = jSONObject;
        if (jSONObject == null) {
            return;
        }
        this.eli = jSONObject.optString("code_id");
        this.DbA = jSONObject.optInt("auto_play", 1);
        this.qj = jSONObject.optInt("endcard_close_time", -1);
        this.Os = jSONObject.optInt("voice_control", 1);
        this.aGH = jSONObject.optInt("rv_preload", 2);
        this.ui = jSONObject.optInt("nv_preload", 1);
        this.MGA = Math.min(100, Math.max(0, jSONObject.optInt("proportion_watching", 100)));
        this.kb = jSONObject.optInt("skip_time_displayed", 0);
        this.wC = jSONObject.optInt("video_skip_result", 2);
        this.FC = jSONObject.optInt("reg_creative_control", 1);
        this.aAs = jSONObject.optInt("play_bar_show_time", 3);
        int optInt = jSONObject.optInt("rv_skip_time", 30);
        this.du = optInt;
        if (optInt < 0) {
            this.du = 30;
        }
        this.NU = jSONObject.optInt("voice_control", 2);
        this.nn = jSONObject.optInt("if_show_win", 1);
        this.Dfc = jSONObject.optInt("sp_preload", 2);
        this.aqO = jSONObject.optInt("stop_time", 1500);
        this.dV = jSONObject.optInt("native_playable_delay", 2);
        this.nGm = jSONObject.optInt("time_out_control", -1);
        this.gG = jSONObject.optInt("playable_close_time", -1);
        this.QX = jSONObject.optInt("playable_reward_type", 0);
        this.CMM = jSONObject.optInt("reward_is_callback", 0);
        int optInt2 = jSONObject.optInt("iv_skip_time", 5);
        this.Xb = optInt2;
        if (optInt2 < 0) {
            this.Xb = 5;
        }
        eli(jSONObject.optJSONArray("parent_tpl_ids"));
        this.Vy = jSONObject.optInt("slot_type", 2);
        this.bf = jSONObject.optBoolean("close_on_click", false);
        this.ujq = jSONObject.optInt("allow_system_back", 0);
        this.Ue = jSONObject.optInt("splash_skip_time", 0);
        this.KM = jSONObject.optInt("splash_image_count_down_time", 5);
        this.GB = jSONObject.optBoolean("splash_count_down_time_off", false);
        this.oWW = jSONObject.optBoolean("splash_close_on_click", false);
        this.VM = jSONObject.optBoolean("allow_mediaview_click", true);
        if (!eli(this.Os)) {
            this.Os = 1;
        }
        if (!eli(this.NU)) {
            this.NU = 1;
        }
        this.nlS = jSONObject.optInt("multi_rv_skip_time", 30);
    }

    public DbA(String str, int i) {
        this.DbA = 1;
        this.Os = 1;
        this.aGH = 2;
        this.ui = 1;
        this.MGA = 100;
        this.kb = 0;
        this.wC = 2;
        this.FC = 1;
        this.aAs = 3;
        this.du = 30;
        this.nlS = 30;
        this.NU = 1;
        this.nn = 1;
        this.Dfc = 2;
        this.aqO = 1500;
        this.dV = 2;
        this.nGm = 3500;
        this.QX = 0;
        this.Xb = 5;
        this.bf = false;
        this.CMM = 0;
        this.Vy = 2;
        this.gG = -1;
        this.ujq = 0;
        this.Ue = 0;
        this.KM = 5;
        this.VM = true;
        this.GB = false;
        this.oWW = false;
        this.qj = -1;
        this.nro = new JSONObject();
        this.eli = str;
        this.Os = i;
    }

    public void eli(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        this.ev = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                this.ev.add(jSONArray.get(i).toString());
            } catch (Exception unused) {
                return;
            }
        }
    }
}
