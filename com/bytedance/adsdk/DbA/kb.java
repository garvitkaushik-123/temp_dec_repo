package com.bytedance.adsdk.DbA;

import android.graphics.Rect;
import android.util.LongSparseArray;
import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class kb {
    private List<com.bytedance.adsdk.DbA.Os.Os.ui> FC;
    private List<com.bytedance.adsdk.DbA.Os.MGA> MGA;
    private float NU;
    private Map<String, List<com.bytedance.adsdk.DbA.Os.Os.ui>> Os;
    private DbA QX;
    private Rect aAs;
    private Map<String, aAs> aGH;
    private Os aqO;
    private float du;
    private SparseArray<com.bytedance.adsdk.DbA.Os.aGH> kb;
    private eli nGm;
    private float nlS;
    private boolean nn;
    private Map<String, com.bytedance.adsdk.DbA.Os.Os> ui;
    private LongSparseArray<com.bytedance.adsdk.DbA.Os.Os.ui> wC;
    private final nGm eli = new nGm();
    private final HashSet<String> DbA = new HashSet<>();
    private int Dfc = 0;
    private String dV = "";

    public static class DbA {
        public int[][] DbA;
        public JSONArray Os;
        public String eli;
    }

    public static class Os {
        public String DbA;
        public String MGA;
        public String Os;
        public String aGH;
        public int eli;
        public JSONArray kb;
        public int[] ui;
    }

    public static class eli {
        public Map<String, Object> DbA;
        public String MGA;
        public Map<String, Object> Os;
        public int aGH;
        public int eli;
        public JSONArray kb;
        public int ui;
    }

    public void eli(Rect rect, float f, float f2, float f3, List<com.bytedance.adsdk.DbA.Os.Os.ui> list, LongSparseArray<com.bytedance.adsdk.DbA.Os.Os.ui> longSparseArray, Map<String, List<com.bytedance.adsdk.DbA.Os.Os.ui>> map, Map<String, aAs> map2, SparseArray<com.bytedance.adsdk.DbA.Os.aGH> sparseArray, Map<String, com.bytedance.adsdk.DbA.Os.Os> map3, List<com.bytedance.adsdk.DbA.Os.MGA> list2, Os os, String str, eli eliVar, DbA dbA) {
        this.aAs = rect;
        this.du = f;
        this.nlS = f2;
        this.NU = f3;
        this.FC = list;
        this.wC = longSparseArray;
        this.Os = map;
        this.aGH = map2;
        this.kb = sparseArray;
        this.ui = map3;
        this.MGA = list2;
        this.aqO = os;
        this.dV = str;
        this.nGm = eliVar;
        this.QX = dbA;
    }

    public void eli(String str) {
        this.DbA.add(str);
    }

    public void eli(boolean z) {
        this.nn = z;
    }

    public void eli(int i) {
        this.Dfc += i;
    }

    public boolean eli() {
        return this.nn;
    }

    public int DbA() {
        return this.Dfc;
    }

    public void DbA(boolean z) {
        this.eli.eli(z);
    }

    public nGm Os() {
        return this.eli;
    }

    public com.bytedance.adsdk.DbA.Os.Os.ui eli(long j) {
        return this.wC.get(j);
    }

    public Rect aGH() {
        return this.aAs;
    }

    public float ui() {
        return (long) ((dV() / this.NU) * 1000.0f);
    }

    public float MGA() {
        return this.du;
    }

    public float kb() {
        return this.nlS;
    }

    public float eli(float f) {
        return com.bytedance.adsdk.DbA.MGA.ui.eli(this.du, this.nlS, f);
    }

    public Os wC() {
        return this.aqO;
    }

    public String FC() {
        return this.dV;
    }

    public DbA aAs() {
        return this.QX;
    }

    public eli du() {
        return this.nGm;
    }

    public float nlS() {
        return this.NU;
    }

    public List<com.bytedance.adsdk.DbA.Os.Os.ui> NU() {
        return this.FC;
    }

    public List<com.bytedance.adsdk.DbA.Os.Os.ui> DbA(String str) {
        return this.Os.get(str);
    }

    public SparseArray<com.bytedance.adsdk.DbA.Os.aGH> nn() {
        return this.kb;
    }

    public Map<String, com.bytedance.adsdk.DbA.Os.Os> Dfc() {
        return this.ui;
    }

    public com.bytedance.adsdk.DbA.Os.MGA Os(String str) {
        int size = this.MGA.size();
        for (int i = 0; i < size; i++) {
            com.bytedance.adsdk.DbA.Os.MGA mga = this.MGA.get(i);
            if (mga.eli(str)) {
                return mga;
            }
        }
        return null;
    }

    public Map<String, aAs> aqO() {
        return this.aGH;
    }

    public float dV() {
        return this.nlS - this.du;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.bytedance.adsdk.DbA.Os.Os.ui> it = this.FC.iterator();
        while (it.hasNext()) {
            sb.append(it.next().eli("\t"));
        }
        return sb.toString();
    }
}
