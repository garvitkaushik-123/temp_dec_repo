package com.bytedance.adsdk.DbA.Os.Os;

import com.bytedance.adsdk.DbA.Os.eli.du;
import com.bytedance.adsdk.DbA.Os.eli.nlS;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class ui {
    private final boolean CMM;
    private final com.bytedance.adsdk.DbA.kb DbA;
    private final float Dfc;
    private final nlS FC;
    private final long MGA;
    private final float NU;
    private final String Os;
    private final com.bytedance.adsdk.DbA.Os.eli.DbA QX;
    private final com.bytedance.adsdk.DbA.ui.aAs Vy;
    private final List<com.bytedance.adsdk.DbA.kb.eli<Float>> Xb;
    private final int aAs;
    private final long aGH;
    private final float aqO;
    private final DbA bf;
    private final com.bytedance.adsdk.DbA.Os.eli.aAs dV;
    private final int du;
    private final List<com.bytedance.adsdk.DbA.Os.DbA.Os> eli;
    private final com.bytedance.adsdk.DbA.Os.DbA.eli ev;
    private final String kb;
    private final du nGm;
    private final int nlS;
    private final float nn;
    private final eli ui;
    private final List<com.bytedance.adsdk.DbA.Os.DbA.wC> wC;

    public enum DbA {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public enum eli {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public ui(List<com.bytedance.adsdk.DbA.Os.DbA.Os> list, com.bytedance.adsdk.DbA.kb kbVar, String str, long j, eli eliVar, long j2, String str2, List<com.bytedance.adsdk.DbA.Os.DbA.wC> list2, nlS nls, int i, int i2, int i3, float f, float f2, float f3, float f4, com.bytedance.adsdk.DbA.Os.eli.aAs aas, du duVar, List<com.bytedance.adsdk.DbA.kb.eli<Float>> list3, DbA dbA, com.bytedance.adsdk.DbA.Os.eli.DbA dbA2, boolean z, com.bytedance.adsdk.DbA.Os.DbA.eli eliVar2, com.bytedance.adsdk.DbA.ui.aAs aas2) {
        this.eli = list;
        this.DbA = kbVar;
        this.Os = str;
        this.aGH = j;
        this.ui = eliVar;
        this.MGA = j2;
        this.kb = str2;
        this.wC = list2;
        this.FC = nls;
        this.aAs = i;
        this.du = i2;
        this.nlS = i3;
        this.NU = f;
        this.nn = f2;
        this.Dfc = f3;
        this.aqO = f4;
        this.dV = aas;
        this.nGm = duVar;
        this.Xb = list3;
        this.bf = dbA;
        this.QX = dbA2;
        this.CMM = z;
        this.ev = eliVar2;
        this.Vy = aas2;
    }

    com.bytedance.adsdk.DbA.kb eli() {
        return this.DbA;
    }

    float DbA() {
        return this.NU;
    }

    float Os() {
        return this.nn / this.DbA.dV();
    }

    List<com.bytedance.adsdk.DbA.kb.eli<Float>> aGH() {
        return this.Xb;
    }

    public long ui() {
        return this.aGH;
    }

    public String MGA() {
        return this.Os;
    }

    public String kb() {
        return this.kb;
    }

    float wC() {
        return this.Dfc;
    }

    float FC() {
        return this.aqO;
    }

    List<com.bytedance.adsdk.DbA.Os.DbA.wC> aAs() {
        return this.wC;
    }

    public eli du() {
        return this.ui;
    }

    DbA nlS() {
        return this.bf;
    }

    long NU() {
        return this.MGA;
    }

    List<com.bytedance.adsdk.DbA.Os.DbA.Os> nn() {
        return this.eli;
    }

    nlS Dfc() {
        return this.FC;
    }

    int aqO() {
        return this.nlS;
    }

    int dV() {
        return this.du;
    }

    int nGm() {
        return this.aAs;
    }

    com.bytedance.adsdk.DbA.Os.eli.aAs QX() {
        return this.dV;
    }

    du Xb() {
        return this.nGm;
    }

    com.bytedance.adsdk.DbA.Os.eli.DbA bf() {
        return this.QX;
    }

    public String toString() {
        return eli("");
    }

    public boolean CMM() {
        return this.CMM;
    }

    public com.bytedance.adsdk.DbA.Os.DbA.eli ev() {
        return this.ev;
    }

    public com.bytedance.adsdk.DbA.ui.aAs Vy() {
        return this.Vy;
    }

    public String eli(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(MGA()).append("\n");
        ui eli2 = this.DbA.eli(NU());
        if (eli2 != null) {
            sb.append("\t\tParents: ").append(eli2.MGA());
            ui eli3 = this.DbA.eli(eli2.NU());
            while (eli3 != null) {
                sb.append("->").append(eli3.MGA());
                eli3 = this.DbA.eli(eli3.NU());
            }
            sb.append(str).append("\n");
        }
        if (!aAs().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(aAs().size()).append("\n");
        }
        if (nGm() != 0 && dV() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(nGm()), Integer.valueOf(dV()), Integer.valueOf(aqO())));
        }
        if (!this.eli.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            Iterator<com.bytedance.adsdk.DbA.Os.DbA.Os> it = this.eli.iterator();
            while (it.hasNext()) {
                sb.append(str).append("\t\t").append(it.next()).append("\n");
            }
        }
        return sb.toString();
    }
}
