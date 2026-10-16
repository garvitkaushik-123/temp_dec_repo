package com.bytedance.adsdk.ugeno.eli.DbA;

import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.eli.ui;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class Os extends eli {
    public Os(Context context, com.bytedance.adsdk.ugeno.DbA.Os os, String str, TreeMap<Float, String> treeMap) {
        super(context, os, str, treeMap);
    }

    @Override // com.bytedance.adsdk.ugeno.eli.DbA.eli
    public void DbA() {
        if (this.aGH == ui.BACKGROUND_COLOR) {
            this.ui.add(Keyframe.ofInt(0.0f, this.kb.SSo()));
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.DbA.eli
    public void eli(float f, String str) {
        Keyframe ofInt;
        if (this.aGH == ui.BACKGROUND_COLOR) {
            ofInt = Keyframe.ofInt(f, com.bytedance.adsdk.ugeno.kb.eli.eli(str));
        } else {
            ofInt = Keyframe.ofInt(f, com.bytedance.adsdk.ugeno.kb.Os.eli(str, 0));
        }
        this.ui.add(ofInt);
    }

    @Override // com.bytedance.adsdk.ugeno.eli.DbA.eli
    public TypeEvaluator MGA() {
        if (this.aGH == ui.BACKGROUND_COLOR) {
            return new ArgbEvaluator();
        }
        return new IntEvaluator();
    }
}
