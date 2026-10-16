package com.bytedance.sdk.openadsdk.aqO;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Xb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli implements Comparable<eli> {
    private final String DbA;
    private int Os;
    private int kb;
    private long nn;
    private int ui;
    private final ArrayList<Long> eli = new ArrayList<>();
    private final ArrayList<Long> aGH = new ArrayList<>();
    private final ArrayList<Long> MGA = new ArrayList<>();
    private final ArrayList<Long> wC = new ArrayList<>();
    private final HashMap<String, DbA> FC = new HashMap<>();
    private int aAs = 0;
    private int du = 0;
    private final HashMap<String, DbA> nlS = new HashMap<>();
    private int NU = 0;
    private final ArrayList<String> Dfc = new ArrayList<>();

    public eli(String str) {
        this.DbA = str;
    }

    public void eli(String str, String str2) {
        DbA dbA;
        DbA dbA2;
        DbA dbA3;
        DbA dbA4;
        DbA dbA5;
        DbA dbA6;
        str.hashCode();
        switch (str) {
            case "landingContinue":
                if (!TextUtils.isEmpty(str2) && (dbA = this.nlS.get(str2)) != null) {
                    dbA.aGH(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingPause":
                if (!TextUtils.isEmpty(str2) && (dbA2 = this.nlS.get(str2)) != null) {
                    dbA2.Os(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingStart":
                if (!TextUtils.isEmpty(str2) && this.nlS.get(str2) == null) {
                    DbA dbA7 = new DbA();
                    this.nlS.put(str2, dbA7);
                    dbA7.eli(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "feed_over":
            case "feed_break":
            case "videoForceBreak":
            case "play_error":
                if (!TextUtils.isEmpty(str2) && (dbA3 = this.FC.get(str2)) != null && dbA3.eli() != DbA.ui) {
                    dbA3.DbA(SystemClock.elapsedRealtime());
                    if (com.bytedance.sdk.openadsdk.MGA.eli.eli().Dfc()) {
                        this.aAs = (int) (this.aAs + dbA3.eli(this.nn, SystemClock.elapsedRealtime()));
                        break;
                    }
                }
                break;
            case "feed_play":
                this.MGA.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (com.bytedance.sdk.openadsdk.MGA.eli.eli().wC()) {
                    this.kb++;
                }
                if (!TextUtils.isEmpty(str2) && this.FC.get(str2) == null) {
                    DbA dbA8 = new DbA();
                    this.FC.put(str2, dbA8);
                    dbA8.eli(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "show":
                this.eli.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (com.bytedance.sdk.openadsdk.MGA.eli.eli().MGA()) {
                    this.Os++;
                    break;
                }
                break;
            case "click":
                if (!this.Dfc.contains(str2)) {
                    if (this.Dfc.size() > 50) {
                        this.Dfc.subList(0, 25).clear();
                    }
                    this.Dfc.add(str2);
                    this.aGH.add(Long.valueOf(SystemClock.elapsedRealtime()));
                    if (com.bytedance.sdk.openadsdk.MGA.eli.eli().kb()) {
                        this.ui++;
                        break;
                    }
                }
                break;
            case "feed_continue":
                if (!TextUtils.isEmpty(str2) && (dbA4 = this.FC.get(str2)) != null) {
                    dbA4.aGH(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "feed_pause":
                if (!TextUtils.isEmpty(str2) && (dbA5 = this.FC.get(str2)) != null) {
                    dbA5.Os(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingFinish":
                if (!TextUtils.isEmpty(str2) && (dbA6 = this.nlS.get(str2)) != null && dbA6.eli() != DbA.ui) {
                    dbA6.DbA(SystemClock.elapsedRealtime());
                    if (com.bytedance.sdk.openadsdk.MGA.eli.eli().nn()) {
                        this.NU = (int) (this.NU + dbA6.eli(this.nn, SystemClock.elapsedRealtime()));
                        break;
                    }
                }
                break;
            case "videoPercent30":
                if (com.bytedance.sdk.openadsdk.MGA.eli.eli().dV()) {
                    this.du++;
                    break;
                }
                break;
            case "dislike":
                this.wC.add(Long.valueOf(SystemClock.elapsedRealtime()));
                break;
        }
    }

    public JSONObject eli(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            eli(jSONObject2, jSONObject);
            DbA(jSONObject2, jSONObject);
            return jSONObject2;
        } catch (Throwable th) {
            Xb.Os(th.getMessage(), new Object[0]);
            return jSONObject2;
        }
    }

    private void eli(String str, JSONObject jSONObject, ArrayList<Long> arrayList, int[] iArr, long j, JSONObject jSONObject2) throws JSONException {
        int size = arrayList.size() - 1;
        int i = 0;
        for (int i2 : iArr) {
            long j2 = j - (i2 * 60000);
            while (size >= 0 && arrayList.get(size).longValue() >= j2) {
                i++;
                size--;
            }
            if (i != 0) {
                jSONObject.put(str + i2, i);
                int optInt = jSONObject2.optInt(str + i2) + i;
                if (optInt != 0) {
                    jSONObject2.put(str + i2, optInt);
                }
            }
        }
        while (size >= 0) {
            arrayList.remove(0);
            size--;
        }
    }

    private void eli(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        int i;
        int i2;
        int i3;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        eli("show_c_", jSONObject, this.eli, com.bytedance.sdk.openadsdk.MGA.eli.eli().FC(), elapsedRealtime, jSONObject2);
        eli("click_c_", jSONObject, this.aGH, com.bytedance.sdk.openadsdk.MGA.eli.eli().aAs(), elapsedRealtime, jSONObject2);
        eli("v_play_c_", jSONObject, this.MGA, com.bytedance.sdk.openadsdk.MGA.eli.eli().du(), elapsedRealtime, jSONObject2);
        eli("dislike_c_", jSONObject, this.wC, com.bytedance.sdk.openadsdk.MGA.eli.eli().aqO(), elapsedRealtime, jSONObject2);
        if (com.bytedance.sdk.openadsdk.MGA.eli.eli().MGA() && (i3 = this.Os) != 0) {
            jSONObject.put("show_c_s", i3);
            int optInt = jSONObject2.optInt("show_c_s") + this.Os;
            if (optInt != 0) {
                jSONObject2.put("show_c_s", optInt);
            }
        }
        if (com.bytedance.sdk.openadsdk.MGA.eli.eli().kb() && (i2 = this.ui) != 0) {
            jSONObject.put("click_c_s", i2);
            int optInt2 = jSONObject2.optInt("click_c_s") + this.ui;
            if (optInt2 != 0) {
                jSONObject2.put("click_c_s", optInt2);
            }
        }
        if (!com.bytedance.sdk.openadsdk.MGA.eli.eli().wC() || (i = this.kb) == 0) {
            return;
        }
        jSONObject.put("v_play_c_s", i);
        int optInt3 = jSONObject2.optInt("v_play_c_s") + this.kb;
        if (optInt3 != 0) {
            jSONObject2.put("v_play_c_s", optInt3);
        }
    }

    private void DbA(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        int i;
        int i2;
        int i3;
        int[] iArr;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        int[] nlS = com.bytedance.sdk.openadsdk.MGA.eli.eli().nlS();
        if (nlS != null) {
            int i4 = 0;
            while (i4 < nlS.length) {
                int i5 = nlS[i4];
                long j = 60000;
                long j2 = elapsedRealtime - (i5 * 60000);
                Iterator<String> it = this.nlS.keySet().iterator();
                long j3 = 0;
                while (it.hasNext()) {
                    long j4 = j;
                    String next = it.next();
                    Iterator<String> it2 = it;
                    DbA dbA = this.nlS.get(next);
                    if (dbA != null) {
                        long eli = dbA.eli(j2, elapsedRealtime);
                        j3 += eli;
                        if (eli <= 0 && i4 == nlS.length - 1) {
                            hashSet.add(next);
                        }
                    }
                    it = it2;
                    j = j4;
                }
                if (j3 != 0) {
                    jSONObject.put("lp_stay_t_".concat(String.valueOf(i5)), j3);
                    iArr = nlS;
                    long optInt = jSONObject2.optInt("lp_stay_t_".concat(String.valueOf(i5))) + j3;
                    if (optInt != 0) {
                        jSONObject2.put("lp_stay_t_".concat(String.valueOf(i5)), optInt);
                    }
                } else {
                    iArr = nlS;
                }
                i4++;
                nlS = iArr;
            }
        }
        int[] NU = com.bytedance.sdk.openadsdk.MGA.eli.eli().NU();
        if (NU != null) {
            int i6 = 0;
            while (i6 < NU.length) {
                int i7 = NU[i6];
                long j5 = elapsedRealtime - (i7 * 60000);
                long j6 = 0;
                int i8 = 0;
                for (String str : this.FC.keySet()) {
                    HashSet hashSet3 = hashSet;
                    int i9 = i7;
                    DbA dbA2 = this.FC.get(str);
                    if (dbA2 != null) {
                        long eli2 = dbA2.eli(j5, elapsedRealtime);
                        j6 += eli2;
                        if (eli2 > 20000) {
                            i8++;
                        }
                        if (eli2 <= 0 && i6 == NU.length - 1) {
                            hashSet2.add(str);
                        }
                    }
                    i7 = i9;
                    hashSet = hashSet3;
                }
                HashSet hashSet4 = hashSet;
                int i10 = i7;
                if (j6 != 0) {
                    jSONObject.put("v_stay_t_".concat(String.valueOf(i10)), j6);
                    long optInt2 = jSONObject2.optInt("v_stay_t_".concat(String.valueOf(i10))) + j6;
                    if (optInt2 != 0) {
                        jSONObject2.put("v_stay_t_".concat(String.valueOf(i10)), optInt2);
                    }
                }
                if (i8 != 0) {
                    jSONObject.put("v_20s_play_c_".concat(String.valueOf(i10)), i8);
                    int optInt3 = jSONObject2.optInt("v_20s_play_c_".concat(String.valueOf(i10))) + i8;
                    if (optInt3 != 0) {
                        jSONObject2.put("v_20s_play_c_".concat(String.valueOf(i10)), optInt3);
                    }
                }
                i6++;
                hashSet = hashSet4;
            }
        }
        HashSet hashSet5 = hashSet;
        if (!hashSet5.isEmpty()) {
            Iterator it3 = hashSet5.iterator();
            while (it3.hasNext()) {
                this.nlS.remove((String) it3.next());
            }
        }
        if (!hashSet2.isEmpty()) {
            Iterator it4 = hashSet2.iterator();
            while (it4.hasNext()) {
                this.FC.remove((String) it4.next());
            }
        }
        if (com.bytedance.sdk.openadsdk.MGA.eli.eli().Dfc() && (i3 = this.aAs) != 0) {
            jSONObject.put("v_stay_t_s", i3);
            int optInt4 = jSONObject2.optInt("v_stay_t_s") + this.aAs;
            if (optInt4 != 0) {
                jSONObject2.put("v_stay_t_s", optInt4);
            }
        }
        if (com.bytedance.sdk.openadsdk.MGA.eli.eli().nn() && (i2 = this.NU) != 0) {
            jSONObject.put("lp_stay_t_s", i2);
            int optInt5 = jSONObject2.optInt("lp_stay_t_s") + this.NU;
            if (optInt5 != 0) {
                jSONObject2.put("lp_stay_t_s", optInt5);
            }
        }
        if (!com.bytedance.sdk.openadsdk.MGA.eli.eli().dV() || (i = this.du) == 0) {
            return;
        }
        jSONObject.put("v_30p_play_c_s", i);
        int optInt6 = jSONObject2.optInt("v_30p_play_c_s") + this.du;
        if (optInt6 != 0) {
            jSONObject2.put("v_30p_play_c_s", optInt6);
        }
    }

    public void eli() {
        this.nn = SystemClock.elapsedRealtime();
        this.du = 0;
        this.ui = 0;
        this.Os = 0;
        this.NU = 0;
        this.aAs = 0;
        this.kb = 0;
    }

    public String DbA() {
        return this.DbA;
    }

    @Override // java.lang.Comparable
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    public int compareTo(eli eliVar) {
        return eliVar.Os - this.Os;
    }
}
