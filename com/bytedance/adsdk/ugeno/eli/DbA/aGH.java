package com.bytedance.adsdk.ugeno.eli.DbA;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.eli.ui;
import com.bytedance.adsdk.ugeno.kb.wC;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class aGH extends eli {
    private List<Keyframe> wC;

    public aGH(Context context, com.bytedance.adsdk.ugeno.DbA.Os os, String str, Map<Float, String> map) {
        super(context, os, str, map);
        this.wC = new ArrayList();
    }

    /* renamed from: com.bytedance.adsdk.ugeno.eli.DbA.aGH$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] eli;

        static {
            int[] iArr = new int[ui.values().length];
            eli = iArr;
            try {
                iArr[ui.TRANSLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                eli[ui.SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.DbA.eli
    public void DbA() {
        Keyframe ofFloat;
        Keyframe ofFloat2;
        int i = AnonymousClass1.eli[this.aGH.ordinal()];
        if (i == 1) {
            ofFloat = Keyframe.ofFloat(0.0f, this.kb.Dfc());
            ofFloat2 = Keyframe.ofFloat(0.0f, this.kb.aqO());
        } else if (i != 2) {
            ofFloat = null;
            ofFloat2 = null;
        } else {
            ofFloat = Keyframe.ofFloat(0.0f, this.kb.dV());
            ofFloat2 = Keyframe.ofFloat(0.0f, this.kb.nGm());
        }
        if (ofFloat != null) {
            this.ui.add(ofFloat);
        }
        if (ofFloat2 != null) {
            this.wC.add(ofFloat2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.DbA.eli
    public void eli(float f, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() != 2) {
                return;
            }
            float optDouble = (float) jSONArray.optDouble(0);
            float optDouble2 = (float) jSONArray.optDouble(1);
            if (this.aGH == ui.TRANSLATE) {
                optDouble = wC.eli(this.eli, optDouble);
                optDouble2 = wC.eli(this.eli, optDouble2);
            }
            this.ui.add(Keyframe.ofFloat(f, optDouble));
            this.wC.add(Keyframe.ofFloat(f, optDouble2));
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.DbA.eli
    public List<PropertyValuesHolder> ui() {
        String DbA = this.aGH.DbA();
        aGH();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(DbA + "X", (Keyframe[]) this.ui.toArray(new Keyframe[0]));
        this.MGA.add(ofKeyframe);
        PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe(DbA + "Y", (Keyframe[]) this.wC.toArray(new Keyframe[0]));
        this.MGA.add(ofKeyframe2);
        TypeEvaluator MGA = MGA();
        if (MGA != null) {
            ofKeyframe.setEvaluator(MGA);
            ofKeyframe2.setEvaluator(MGA);
        }
        return this.MGA;
    }

    @Override // com.bytedance.adsdk.ugeno.eli.DbA.eli
    public TypeEvaluator MGA() {
        return new FloatEvaluator();
    }
}
