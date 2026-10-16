package com.bytedance.adsdk.ugeno.eli.DbA;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.eli.ui;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public abstract class eli {
    protected String DbA;
    protected Map<Float, String> Os;
    protected ui aGH;
    protected Context eli;
    protected com.bytedance.adsdk.ugeno.DbA.Os kb;
    protected List<PropertyValuesHolder> MGA = new ArrayList();
    protected List<Keyframe> ui = new ArrayList();

    public abstract void DbA();

    public abstract TypeEvaluator MGA();

    public abstract void eli(float f, String str);

    public eli(Context context, com.bytedance.adsdk.ugeno.DbA.Os os, String str, Map<Float, String> map) {
        this.eli = context;
        this.DbA = str;
        this.Os = map;
        this.aGH = ui.eli(this.DbA);
        this.kb = os;
    }

    public boolean eli() {
        Map<Float, String> map = this.Os;
        if (map == null || map.size() <= 0) {
            return false;
        }
        return this.Os.containsKey(Float.valueOf(0.0f));
    }

    public void Os() {
        Map<Float, String> map = this.Os;
        if (map == null || map.size() <= 0) {
            return;
        }
        Map<Float, String> map2 = this.Os;
        if (map2 instanceof TreeMap) {
            float floatValue = ((Float) ((TreeMap) map2).lastKey()).floatValue();
            if (floatValue != 100.0f) {
                eli(100.0f, this.Os.get(Float.valueOf(floatValue)));
            }
        }
    }

    public void aGH() {
        Map<Float, String> map = this.Os;
        if (map == null || map.size() <= 0) {
            return;
        }
        if (!eli()) {
            DbA();
        }
        for (Map.Entry<Float, String> entry : this.Os.entrySet()) {
            if (entry != null) {
                eli(entry.getKey().floatValue() / 100.0f, entry.getValue());
            }
        }
        Os();
    }

    public List<PropertyValuesHolder> ui() {
        String DbA = this.aGH.DbA();
        aGH();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(DbA, (Keyframe[]) this.ui.toArray(new Keyframe[0]));
        TypeEvaluator MGA = MGA();
        if (MGA != null) {
            ofKeyframe.setEvaluator(MGA);
        }
        this.MGA.add(ofKeyframe);
        return this.MGA;
    }
}
