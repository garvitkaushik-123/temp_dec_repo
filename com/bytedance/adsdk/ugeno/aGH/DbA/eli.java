package com.bytedance.adsdk.ugeno.aGH.DbA;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.aGH.MGA;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class eli {
    public static final HashSet<String> eli = new HashSet<>(Arrays.asList("convert", "dislike", "openAppPermission", "openAppPolicy", "openPrivacy", "openAppFunction", "close", "skip", "videoControl", "pauseVideo", "resumeVideo", "muteVideo", "preventEvent"));
    protected MGA.eli DbA;
    protected Map<String, String> MGA;
    protected com.bytedance.adsdk.ugeno.DbA.Os Os;
    protected String aGH;
    protected String kb;
    protected String ui;
    protected String wC;

    public abstract void eli();

    public eli(com.bytedance.adsdk.ugeno.DbA.Os os, String str, MGA.eli eliVar) {
        this.Os = os;
        this.DbA = eliVar;
        this.kb = str;
        ui();
    }

    private void ui() {
        MGA.eli eliVar = this.DbA;
        if (eliVar == null) {
            return;
        }
        this.aGH = eliVar.eli();
        this.ui = this.DbA.DbA();
        Map<String, String> Os = this.DbA.Os();
        this.MGA = Os;
        if (Os == null || Os.isEmpty() || !this.MGA.containsKey("emitCustomEvent")) {
            return;
        }
        this.wC = this.MGA.get("emitCustomEvent");
    }

    public void DbA() {
        Os();
    }

    public void Os() {
        if (aGH()) {
            MGA.eli eliVar = new MGA.eli();
            eliVar.eli("custom");
            eliVar.DbA("emit");
            HashMap hashMap = new HashMap();
            hashMap.put("name", this.wC);
            eliVar.eli(hashMap);
            new DbA(this.Os, this.ui, eliVar).eli();
        }
    }

    public boolean aGH() {
        return !TextUtils.isEmpty(this.wC);
    }

    /* renamed from: com.bytedance.adsdk.ugeno.aGH.DbA.eli$eli, reason: collision with other inner class name */
    public static class C0122eli {
        public static eli eli(com.bytedance.adsdk.ugeno.DbA.Os os, String str, MGA.eli eliVar) {
            if (eliVar == null) {
                return null;
            }
            com.bytedance.adsdk.ugeno.aGH.DbA eli = com.bytedance.adsdk.ugeno.aGH.aGH.eli(eliVar.DbA());
            if (eli == null) {
                return new Os(os, str, eliVar);
            }
            eli eli2 = eli.eli(os, str, eliVar);
            return eli2 == null ? new Os(os, str, eliVar) : eli2;
        }
    }
}
