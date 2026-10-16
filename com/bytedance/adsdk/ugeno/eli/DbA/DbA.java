package com.bytedance.adsdk.ugeno.eli.DbA;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.eli.ui;
import com.bytedance.adsdk.ugeno.kb.wC;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class DbA extends eli {
    public DbA(Context context, com.bytedance.adsdk.ugeno.DbA.Os os, String str, TreeMap<Float, String> treeMap) {
        super(context, os, str, treeMap);
    }

    /* renamed from: com.bytedance.adsdk.ugeno.eli.DbA.DbA$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] eli;

        static {
            int[] iArr = new int[ui.values().length];
            eli = iArr;
            try {
                iArr[ui.TRANSLATE_X.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                eli[ui.TRANSLATE_Y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                eli[ui.SCALE_X.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                eli[ui.SCALE_Y.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                eli[ui.ROTATE_X.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                eli[ui.ROTATE_Y.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                eli[ui.ROTATE_Z.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                eli[ui.ALPHA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                eli[ui.BORDER_RADIUS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.DbA.eli
    public void DbA() {
        float Dfc;
        switch (AnonymousClass1.eli[this.aGH.ordinal()]) {
            case 1:
                Dfc = this.kb.Dfc();
                break;
            case 2:
                Dfc = this.kb.aqO();
                break;
            case 3:
                Dfc = this.kb.dV();
                break;
            case 4:
                Dfc = this.kb.nGm();
                break;
            case 5:
                Dfc = this.kb.QX();
                if (this.kb.du() != null) {
                    this.kb.du().setCameraDistance(10000.0f);
                    break;
                }
                break;
            case 6:
                Dfc = this.kb.Xb();
                if (this.kb.du() != null) {
                    this.kb.du().setCameraDistance(10000.0f);
                    break;
                }
                break;
            case 7:
                Dfc = this.kb.bf();
                break;
            case 8:
                Dfc = this.kb.CMM();
                break;
            case 9:
                Dfc = this.kb.ev();
                break;
            default:
                Dfc = 0.0f;
                break;
        }
        this.ui.add(Keyframe.ofFloat(0.0f, Dfc));
    }

    @Override // com.bytedance.adsdk.ugeno.eli.DbA.eli
    public void eli(float f, String str) {
        float eli;
        if (this.DbA.startsWith(ui.TRANSLATE.eli()) || this.aGH == ui.BORDER_RADIUS) {
            eli = wC.eli(this.eli, com.bytedance.adsdk.ugeno.kb.Os.eli(str, 0.0f));
        } else {
            eli = com.bytedance.adsdk.ugeno.kb.Os.eli(str, 0.0f);
        }
        this.ui.add(Keyframe.ofFloat(f, eli));
    }

    @Override // com.bytedance.adsdk.ugeno.eli.DbA.eli
    public TypeEvaluator MGA() {
        return new FloatEvaluator();
    }
}
