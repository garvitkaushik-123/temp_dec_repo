package com.bytedance.adsdk.DbA;

import android.graphics.Bitmap;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class aAs {
    private final int DbA;
    private final int[][] FC;
    private final String MGA;
    private final String Os;
    private final JSONArray aAs;
    private final String aGH;
    private Bitmap du;
    private final int eli;
    private final List<eli> kb;
    private final String ui;
    private final String wC;

    public static class eli {
        public int DbA;
        public int MGA;
        public String Os;
        public String aGH;
        public int eli;
        public String kb;
        public int ui;
    }

    public aAs(int i, int i2, String str, String str2, String str3, String str4, List<eli> list, String str5, int[][] iArr, JSONArray jSONArray) {
        this.eli = i;
        this.DbA = i2;
        this.Os = str;
        this.aGH = str2;
        this.ui = str3;
        this.MGA = str4;
        this.kb = list;
        this.wC = str5;
        this.FC = iArr;
        this.aAs = jSONArray;
    }

    public int eli() {
        return this.eli;
    }

    public int DbA() {
        return this.DbA;
    }

    public List<eli> Os() {
        return this.kb;
    }

    public String aGH() {
        return this.MGA;
    }

    public String ui() {
        return this.wC;
    }

    public int[][] MGA() {
        return this.FC;
    }

    public JSONArray kb() {
        return this.aAs;
    }

    public String wC() {
        return this.Os;
    }

    public String FC() {
        return this.aGH;
    }

    public String aAs() {
        return this.ui;
    }

    public Bitmap du() {
        return this.du;
    }

    public void eli(Bitmap bitmap) {
        this.du = bitmap;
    }
}
