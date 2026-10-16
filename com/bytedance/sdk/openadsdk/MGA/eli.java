package com.bytedance.sdk.openadsdk.MGA;

import com.bytedance.sdk.openadsdk.core.Os;
import com.bytedance.sdk.openadsdk.core.nn;
import com.ironsource.C3040d4;

/* loaded from: classes3.dex */
public class eli {
    private static volatile eli eli;
    private boolean DbA;
    private int Dfc;
    private int[] FC;
    private int[] MGA;
    private boolean NU;
    private boolean Os;
    private boolean aAs;
    private boolean aGH;
    private boolean aqO;
    private boolean dV;
    private boolean du;
    private int[] kb;
    private int[] nlS;
    private boolean nn;
    private int[] ui;
    private int[] wC;

    private eli() {
        DbA();
    }

    public static eli eli() {
        if (eli == null) {
            synchronized (Os.class) {
                if (eli == null) {
                    eli = new eli();
                }
            }
        }
        return eli;
    }

    public void DbA() {
        nn.DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.MGA.eli.1
            @Override // java.lang.Runnable
            public void run() {
                eli.this.nn = com.bytedance.sdk.openadsdk.bf.eli.eli("feature_switch", false);
                if (eli.this.nn) {
                    try {
                        eli.this.dV = com.bytedance.sdk.openadsdk.bf.eli.eli("exclude_banner_native", false);
                        eli.this.Dfc = com.bytedance.sdk.openadsdk.bf.eli.eli("feature_timer_interval", 10000);
                        eli.this.aqO = com.bytedance.sdk.openadsdk.bf.eli.eli("enable_feature_cids", true);
                        String[] split = com.bytedance.sdk.openadsdk.bf.eli.eli("pag_ad_show_cnt", "1,3,5&session").split(C3040d4.i.c);
                        String[] split2 = com.bytedance.sdk.openadsdk.bf.eli.eli("pag_ad_click_cnt", "1,3,5&session").split(C3040d4.i.c);
                        String[] split3 = com.bytedance.sdk.openadsdk.bf.eli.eli("pag_video_play_cnt", "1,3,5&session").split(C3040d4.i.c);
                        String[] split4 = com.bytedance.sdk.openadsdk.bf.eli.eli("pag_dislike_cnt", "1,3,5session").split(",");
                        eli eliVar = eli.this;
                        eliVar.DbA = eliVar.eli(split);
                        eli eliVar2 = eli.this;
                        eliVar2.Os = eliVar2.eli(split2);
                        eli eliVar3 = eli.this;
                        eliVar3.aGH = eliVar3.eli(split3);
                        eli eliVar4 = eli.this;
                        eliVar4.ui = eliVar4.DbA(split);
                        eli eliVar5 = eli.this;
                        eliVar5.MGA = eliVar5.DbA(split2);
                        eli eliVar6 = eli.this;
                        eliVar6.kb = eliVar6.DbA(split3);
                        eli eliVar7 = eli.this;
                        eliVar7.nlS = eliVar7.Os(split4);
                        String[] split5 = com.bytedance.sdk.openadsdk.bf.eli.eli("pag_landingPage_stay_time", "1,3,5&session").split(C3040d4.i.c);
                        String[] split6 = com.bytedance.sdk.openadsdk.bf.eli.eli("pag_video_stay_time", "1,3,5&session").split(C3040d4.i.c);
                        eli eliVar8 = eli.this;
                        eliVar8.aAs = eliVar8.eli(split5);
                        eli eliVar9 = eli.this;
                        eliVar9.du = eliVar9.eli(split6);
                        eli eliVar10 = eli.this;
                        eliVar10.wC = eliVar10.DbA(split5);
                        eli eliVar11 = eli.this;
                        eliVar11.FC = eliVar11.DbA(split6);
                        eli.this.NU = com.bytedance.sdk.openadsdk.bf.eli.eli("pag_video_30p_session", true);
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eli(String[] strArr) {
        if (strArr.length == 2) {
            return "session".equals(strArr[1]);
        }
        if (strArr.length == 1) {
            return "session".equals(strArr[0]);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] DbA(String[] strArr) {
        if (strArr.length > 0) {
            return Os(strArr[0].split(","));
        }
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] Os(String[] strArr) {
        int length = strArr.length;
        int[] iArr = new int[length];
        int i = 0;
        for (String str : strArr) {
            try {
                int parseInt = Integer.parseInt(str);
                iArr[i] = parseInt;
                if (parseInt > 0) {
                    i++;
                }
            } catch (NumberFormatException unused) {
            }
        }
        if (i == length) {
            return iArr;
        }
        int[] iArr2 = new int[i];
        System.arraycopy(iArr, 0, iArr2, 0, i);
        return iArr2;
    }

    public boolean Os() {
        return this.nn;
    }

    public int aGH() {
        return this.Dfc;
    }

    public boolean ui() {
        return this.aqO;
    }

    public boolean MGA() {
        return this.DbA;
    }

    public boolean kb() {
        return this.Os;
    }

    public boolean wC() {
        return this.aGH;
    }

    public int[] FC() {
        return this.ui;
    }

    public int[] aAs() {
        return this.MGA;
    }

    public int[] du() {
        return this.kb;
    }

    public int[] nlS() {
        return this.wC;
    }

    public int[] NU() {
        return this.FC;
    }

    public boolean nn() {
        return this.aAs;
    }

    public boolean Dfc() {
        return this.du;
    }

    public int[] aqO() {
        return this.nlS;
    }

    public boolean dV() {
        return this.NU;
    }

    public boolean nGm() {
        return this.dV;
    }
}
