package com.bytedance.sdk.openadsdk.core.du;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.du.DbA.DbA;
import com.bytedance.sdk.openadsdk.core.du.DbA.Os;
import com.bytedance.sdk.openadsdk.core.du.DbA.eli;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH {
    private String CMM;
    private boolean Dfc;
    private boolean QX;
    private boolean Xb;
    private long aqO;
    private String bf;
    private ev dV;
    private boolean nGm;
    private final AtomicBoolean NU = new AtomicBoolean(false);
    private final AtomicBoolean nn = new AtomicBoolean(false);
    public List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> eli = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> DbA = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> Os = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> aGH = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> ui = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> MGA = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> kb = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> wC = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> FC = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> aAs = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.du.DbA.DbA> du = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.du.DbA.eli> nlS = new ArrayList();

    public void eli(com.bytedance.sdk.openadsdk.core.du.eli.eli eliVar) {
        if (!eli(-1L, this.eli, eliVar, this.Dfc ? null : new Os.DbA("error", this.dV, 0.0f)) || this.Dfc) {
            return;
        }
        com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.dV, this.bf, "track_error", (JSONObject) null);
    }

    public void eli(long j) {
        if (this.NU.compareAndSet(false, true)) {
            if (!eli(j, this.DbA, null, new Os.DbA(this.Dfc ? "show_impression" : "impression", this.dV)) || this.Dfc) {
                return;
            }
            com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.dV, this.bf, "track_impression", (JSONObject) null);
        }
    }

    public void DbA(long j) {
        if (!eli(j, this.Os, null, this.Dfc ? null : new Os.DbA(CampaignEx.JSON_NATIVE_VIDEO_PAUSE, this.dV, j)) || this.Dfc) {
            return;
        }
        com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.dV, this.bf, "track_pause", (JSONObject) null);
    }

    public void Os(long j) {
        if (!eli(j, this.aGH, null, this.Dfc ? null : new Os.DbA(CampaignEx.JSON_NATIVE_VIDEO_RESUME, this.dV, j)) || this.Dfc) {
            return;
        }
        com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.dV, this.bf, "track_resume", (JSONObject) null);
    }

    public void aGH(long j) {
        if (!eli(j, this.ui, null, new Os.DbA(this.Dfc ? "video_progress" : CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, this.dV, 1.0f)) || this.Dfc) {
            return;
        }
        com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.dV, this.bf, "track_complete", (JSONObject) null);
    }

    public void ui(long j) {
        if (this.nn.compareAndSet(false, true)) {
            eli(j, this.MGA, (com.bytedance.sdk.openadsdk.core.du.eli.eli) null);
        }
    }

    public void MGA(long j) {
        if (!eli(j, this.kb, null, this.Dfc ? null : new Os.DbA("skip", this.dV)) || this.Dfc) {
            return;
        }
        com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.dV, this.bf, "track_skip", (JSONObject) null);
    }

    public void kb(long j) {
        if (!eli(j, this.wC, null, new Os.DbA(this.Dfc ? "click" : "clickTracking", this.dV)) || this.Dfc) {
            return;
        }
        com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.dV, this.bf, "track_video_click", (JSONObject) null);
    }

    public void wC(long j) {
        if (!eli(j, this.FC, null, this.Dfc ? null : new Os.DbA(CampaignEx.JSON_NATIVE_VIDEO_MUTE, this.dV, j)) || this.Dfc) {
            return;
        }
        com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.dV, this.bf, "track_mute", (JSONObject) null);
    }

    public void FC(long j) {
        if (!eli(j, this.aAs, null, this.Dfc ? null : new Os.DbA(CampaignEx.JSON_NATIVE_VIDEO_UNMUTE, this.dV, j)) || this.Dfc) {
            return;
        }
        com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.dV, this.bf, "track_unmute", (JSONObject) null);
    }

    public void eli(long j, long j2, MGA mga) {
        Os.DbA dbA;
        if (System.currentTimeMillis() - this.aqO >= 1000 && j >= 0 && j2 > 0) {
            this.aqO = System.currentTimeMillis();
            float f = j / j2;
            List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> eli = eli(j, f);
            float f2 = 0.25f;
            if (f >= 0.25f && !this.nGm) {
                eli("firstQuartile");
                this.nGm = true;
                if (mga != null) {
                    eli(mga, 6);
                }
                if (!this.Dfc) {
                    dbA = new Os.DbA("firstQuartile", this.dV, 0.25f);
                    f = f2;
                }
                f = f2;
                dbA = null;
            } else {
                f2 = 0.5f;
                if (f >= 0.5f && !this.QX) {
                    eli(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT);
                    this.QX = true;
                    if (mga != null) {
                        eli(mga, 7);
                    }
                    if (!this.Dfc) {
                        dbA = new Os.DbA(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT, this.dV, 0.5f);
                        f = f2;
                    }
                    f = f2;
                    dbA = null;
                } else {
                    f2 = 0.75f;
                    if (f >= 0.75f && !this.Xb) {
                        eli("thirdQuartile");
                        this.Xb = true;
                        if (mga != null) {
                            eli(mga, 8);
                        }
                        if (!this.Dfc) {
                            dbA = new Os.DbA("thirdQuartile", this.dV, 0.75f);
                            f = f2;
                        }
                        f = f2;
                    }
                    dbA = null;
                }
            }
            if (f < 0.03f) {
                f = 0.0f;
            }
            if (!this.Dfc && !eli.isEmpty()) {
                com.bytedance.sdk.openadsdk.core.du.DbA.Os os = eli.get(0);
                if ((os instanceof com.bytedance.sdk.openadsdk.core.du.DbA.eli) && ((com.bytedance.sdk.openadsdk.core.du.DbA.eli) os).eli() == 0) {
                    com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.dV, this.bf, "track_start", (JSONObject) null);
                    dbA = new Os.DbA("start", this.dV, f);
                }
            }
            if (eli.isEmpty()) {
                return;
            }
            if (dbA == null) {
                dbA = new Os.DbA("video_progress", this.dV, f);
            }
            eli(j, eli, null, dbA);
        }
    }

    private void eli(final MGA mga, final int i) {
        com.bytedance.sdk.component.utils.FC.DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.du.aGH.1
            @Override // java.lang.Runnable
            public void run() {
                MGA mga2 = mga;
                if (mga2 != null) {
                    mga2.eli(i);
                }
            }
        });
    }

    private void eli(String str) {
        try {
            if (this.Dfc) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event", str);
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.dV, this.bf, "vast_play_track", jSONObject);
            } else if ("firstQuartile".equals(str)) {
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.dV, this.bf, "track_first_quartile", (JSONObject) null);
            } else if (CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT.equals(str)) {
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.dV, this.bf, "track_midpoint", (JSONObject) null);
            } else if ("thirdQuartile".equals(str)) {
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.dV, this.bf, "track_third_quartile", (JSONObject) null);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean eli(long j, List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list, com.bytedance.sdk.openadsdk.core.du.eli.eli eliVar, Os.DbA dbA) {
        com.bykv.vk.openvk.eli.eli.eli.Os.DbA nY;
        ev evVar = this.dV;
        String str = null;
        if (evVar != null && (nY = evVar.nY()) != null) {
            str = nY.du();
        }
        return com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(this.dV, list, eliVar, j, str, dbA, DbA());
    }

    private String DbA() {
        if (this.CMM == null) {
            this.CMM = UUID.randomUUID().toString();
        }
        return this.CMM;
    }

    private boolean eli(long j, List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list, com.bytedance.sdk.openadsdk.core.du.eli.eli eliVar) {
        return eli(j, list, eliVar, null);
    }

    public List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> eli(long j, float f) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.du.size(); i++) {
            com.bytedance.sdk.openadsdk.core.du.DbA.DbA dbA = this.du.get(i);
            if (dbA.eli(f)) {
                arrayList.add(dbA);
            }
        }
        for (int i2 = 0; i2 < this.nlS.size(); i2++) {
            com.bytedance.sdk.openadsdk.core.du.DbA.eli eliVar = this.nlS.get(i2);
            if (eliVar.eli(j)) {
                arrayList.add(eliVar);
            }
        }
        return arrayList;
    }

    public void eli(List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list) {
        this.DbA.addAll(list);
    }

    public void DbA(List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list) {
        this.Os.addAll(list);
    }

    public void Os(List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list) {
        this.aGH.addAll(list);
    }

    public void aGH(List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list) {
        this.ui.addAll(list);
    }

    public void ui(List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list) {
        this.MGA.addAll(list);
    }

    public void MGA(List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list) {
        this.kb.addAll(list);
    }

    public void kb(List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list) {
        this.wC.addAll(list);
    }

    public void wC(List<com.bytedance.sdk.openadsdk.core.du.DbA.DbA> list) {
        this.du.addAll(list);
        Collections.sort(this.du);
    }

    public void FC(List<com.bytedance.sdk.openadsdk.core.du.DbA.eli> list) {
        this.nlS.addAll(list);
        Collections.sort(this.nlS);
    }

    public void aAs(List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list) {
        this.eli.addAll(list);
    }

    public void du(List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list) {
        this.FC.addAll(list);
    }

    public void nlS(List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list) {
        this.aAs.addAll(list);
    }

    public JSONObject eli() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorTrackers", com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(this.eli));
        jSONObject.put("impressionTrackers", com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(this.DbA));
        jSONObject.put("pauseTrackers", com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(this.Os));
        jSONObject.put("resumeTrackers", com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(this.aGH));
        jSONObject.put("completeTrackers", com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(this.ui));
        jSONObject.put("closeTrackers", com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(this.MGA));
        jSONObject.put("skipTrackers", com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(this.kb));
        jSONObject.put("clickTrackers", com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(this.wC));
        jSONObject.put("muteTrackers", com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(this.FC));
        jSONObject.put("unMuteTrackers", com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(this.aAs));
        jSONObject.put("fractionalTrackers", Os());
        jSONObject.put("absoluteTrackers", aGH());
        return jSONObject;
    }

    private JSONArray Os() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<com.bytedance.sdk.openadsdk.core.du.DbA.DbA> it = this.du.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().DbA());
        }
        return jSONArray;
    }

    private JSONArray aGH() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<com.bytedance.sdk.openadsdk.core.du.DbA.eli> it = this.nlS.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().DbA());
        }
        return jSONArray;
    }

    public void eli(JSONObject jSONObject) {
        aAs(com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(jSONObject.optJSONArray("errorTrackers")));
        eli(com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(jSONObject.optJSONArray("impressionTrackers")));
        DbA(com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(jSONObject.optJSONArray("pauseTrackers"), true));
        Os(com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(jSONObject.optJSONArray("resumeTrackers"), true));
        aGH(com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(jSONObject.optJSONArray("completeTrackers")));
        ui(com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(jSONObject.optJSONArray("closeTrackers")));
        MGA(com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(jSONObject.optJSONArray("skipTrackers")));
        kb(com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(jSONObject.optJSONArray("clickTrackers")));
        du(com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(jSONObject.optJSONArray("muteTrackers"), true));
        nlS(com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(jSONObject.optJSONArray("unMuteTrackers"), true));
        wC(com.bytedance.sdk.openadsdk.core.du.DbA.Os.DbA(jSONObject.optJSONArray("fractionalTrackers")));
        FC(com.bytedance.sdk.openadsdk.core.du.DbA.Os.Os(jSONObject.optJSONArray("absoluteTrackers")));
    }

    public void eli(ev evVar) {
        this.dV = evVar;
        this.bf = evVar.aGH();
        this.Dfc = evVar.Kv();
    }

    public void eli(String str, long j) {
        if (TextUtils.isEmpty(str) || j < 0) {
            return;
        }
        FC(Collections.singletonList(new eli.C0189eli(str, j).eli()));
    }

    public void eli(String str, float f) {
        if (TextUtils.isEmpty(str) || f < 0.0f) {
            return;
        }
        wC(Collections.singletonList(new DbA.eli(str, f).eli()));
    }

    public void eli(aGH agh) {
        aAs(agh.eli);
        eli(agh.DbA);
        DbA(agh.Os);
        Os(agh.aGH);
        aGH(agh.ui);
        ui(agh.MGA);
        MGA(agh.kb);
        kb(agh.wC);
        du(agh.FC);
        nlS(agh.aAs);
        wC(agh.du);
        FC(agh.nlS);
    }
}
