package com.bytedance.adsdk.DbA.Os.DbA;

import android.graphics.Paint;
import com.bytedance.adsdk.DbA.eli.eli.Xb;
import java.util.List;

/* loaded from: classes3.dex */
public class nGm implements Os {
    private final com.bytedance.adsdk.DbA.Os.eli.DbA DbA;
    private final float FC;
    private final com.bytedance.adsdk.DbA.Os.eli.DbA MGA;
    private final List<com.bytedance.adsdk.DbA.Os.eli.DbA> Os;
    private final boolean aAs;
    private final com.bytedance.adsdk.DbA.Os.eli.eli aGH;
    private final String eli;
    private final eli kb;
    private final com.bytedance.adsdk.DbA.Os.eli.aGH ui;
    private final DbA wC;

    public enum eli {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap eli() {
            int i = AnonymousClass1.eli[ordinal()];
            if (i == 1) {
                return Paint.Cap.BUTT;
            }
            if (i == 2) {
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.SQUARE;
        }
    }

    /* renamed from: com.bytedance.adsdk.DbA.Os.DbA.nGm$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] DbA;
        static final /* synthetic */ int[] eli;

        static {
            int[] iArr = new int[DbA.values().length];
            DbA = iArr;
            try {
                iArr[DbA.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                DbA[DbA.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                DbA[DbA.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[eli.values().length];
            eli = iArr2;
            try {
                iArr2[eli.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                eli[eli.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                eli[eli.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum DbA {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join eli() {
            int i = AnonymousClass1.DbA[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public nGm(String str, com.bytedance.adsdk.DbA.Os.eli.DbA dbA, List<com.bytedance.adsdk.DbA.Os.eli.DbA> list, com.bytedance.adsdk.DbA.Os.eli.eli eliVar, com.bytedance.adsdk.DbA.Os.eli.aGH agh, com.bytedance.adsdk.DbA.Os.eli.DbA dbA2, eli eliVar2, DbA dbA3, float f, boolean z) {
        this.eli = str;
        this.DbA = dbA;
        this.Os = list;
        this.aGH = eliVar;
        this.ui = agh;
        this.MGA = dbA2;
        this.kb = eliVar2;
        this.wC = dbA3;
        this.FC = f;
        this.aAs = z;
    }

    @Override // com.bytedance.adsdk.DbA.Os.DbA.Os
    public com.bytedance.adsdk.DbA.eli.eli.Os eli(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.kb kbVar, com.bytedance.adsdk.DbA.Os.Os.eli eliVar) {
        return new Xb(fc, eliVar, this);
    }

    public String eli() {
        return this.eli;
    }

    public com.bytedance.adsdk.DbA.Os.eli.eli DbA() {
        return this.aGH;
    }

    public com.bytedance.adsdk.DbA.Os.eli.aGH Os() {
        return this.ui;
    }

    public com.bytedance.adsdk.DbA.Os.eli.DbA aGH() {
        return this.MGA;
    }

    public List<com.bytedance.adsdk.DbA.Os.eli.DbA> ui() {
        return this.Os;
    }

    public com.bytedance.adsdk.DbA.Os.eli.DbA MGA() {
        return this.DbA;
    }

    public eli kb() {
        return this.kb;
    }

    public DbA wC() {
        return this.wC;
    }

    public float FC() {
        return this.FC;
    }

    public boolean aAs() {
        return this.aAs;
    }
}
