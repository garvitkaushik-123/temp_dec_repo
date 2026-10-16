package com.bytedance.adsdk.ugeno.eli;

import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os {
    private long DbA;
    private int FC = 1;
    private eli MGA;
    private int Os;
    private JSONObject aAs;
    private String aGH;
    private Map<String, TreeMap<Float, String>> eli;
    private String kb;
    private long ui;
    private String wC;

    public static class eli {
        public String DbA;
        public String eli;
    }

    public JSONObject eli() {
        return this.aAs;
    }

    public void eli(JSONObject jSONObject) {
        this.aAs = jSONObject;
    }

    public Map<String, TreeMap<Float, String>> DbA() {
        return this.eli;
    }

    public void eli(Map<String, TreeMap<Float, String>> map) {
        this.eli = map;
    }

    public long Os() {
        return this.DbA;
    }

    public void eli(long j) {
        this.DbA = j;
    }

    public int aGH() {
        return this.Os;
    }

    public void eli(int i) {
        this.Os = i;
    }

    public String ui() {
        return this.aGH;
    }

    public void eli(String str) {
        this.aGH = str;
    }

    public long MGA() {
        return this.ui;
    }

    public void DbA(long j) {
        this.ui = j;
    }

    public eli kb() {
        return this.MGA;
    }

    public void eli(eli eliVar) {
        this.MGA = eliVar;
    }

    public String wC() {
        return this.kb;
    }

    public void DbA(String str) {
        this.kb = str;
    }

    public String FC() {
        return this.wC;
    }

    public void Os(String str) {
        this.wC = str;
    }

    public int aAs() {
        return this.FC;
    }

    public void DbA(int i) {
        this.FC = i;
    }

    public String toString() {
        return "AnimationModel{mKeyFramesMap=" + this.eli + ", mDuration=" + this.DbA + ", mPlayCount=" + this.Os + ", mPlayDirection=" + this.aGH + ", mDelay=" + this.ui + ", mName=" + this.wC + ", mPlayState=" + this.FC + ", mTransformOrigin='" + this.MGA + "', mTimingFunction='" + this.kb + "'}";
    }
}
