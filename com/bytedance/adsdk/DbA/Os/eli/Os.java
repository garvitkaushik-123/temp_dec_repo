package com.bytedance.adsdk.DbA.Os.eli;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class Os extends nn<com.bytedance.adsdk.DbA.Os.DbA.aGH, com.bytedance.adsdk.DbA.Os.DbA.aGH> {
    @Override // com.bytedance.adsdk.DbA.Os.eli.nn, com.bytedance.adsdk.DbA.Os.eli.NU
    public /* bridge */ /* synthetic */ boolean DbA() {
        return super.DbA();
    }

    @Override // com.bytedance.adsdk.DbA.Os.eli.nn, com.bytedance.adsdk.DbA.Os.eli.NU
    public /* bridge */ /* synthetic */ List Os() {
        return super.Os();
    }

    @Override // com.bytedance.adsdk.DbA.Os.eli.nn
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public Os(List<com.bytedance.adsdk.DbA.kb.eli<com.bytedance.adsdk.DbA.Os.DbA.aGH>> list) {
        super(eli(list));
    }

    private static List<com.bytedance.adsdk.DbA.kb.eli<com.bytedance.adsdk.DbA.Os.DbA.aGH>> eli(List<com.bytedance.adsdk.DbA.kb.eli<com.bytedance.adsdk.DbA.Os.DbA.aGH>> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, eli(list.get(i)));
        }
        return list;
    }

    private static com.bytedance.adsdk.DbA.kb.eli<com.bytedance.adsdk.DbA.Os.DbA.aGH> eli(com.bytedance.adsdk.DbA.kb.eli<com.bytedance.adsdk.DbA.Os.DbA.aGH> eliVar) {
        com.bytedance.adsdk.DbA.Os.DbA.aGH agh = eliVar.eli;
        com.bytedance.adsdk.DbA.Os.DbA.aGH agh2 = eliVar.DbA;
        if (agh == null || agh2 == null || agh.eli().length == agh2.eli().length) {
            return eliVar;
        }
        float[] eli = eli(agh.eli(), agh2.eli());
        return eliVar.eli(agh.eli(eli), agh2.eli(eli));
    }

    static float[] eli(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f = Float.NaN;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            float f2 = fArr3[i2];
            if (f2 != f) {
                fArr3[i] = f2;
                i++;
                f = fArr3[i2];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i);
    }

    @Override // com.bytedance.adsdk.DbA.Os.eli.NU
    public com.bytedance.adsdk.DbA.eli.DbA.eli<com.bytedance.adsdk.DbA.Os.DbA.aGH, com.bytedance.adsdk.DbA.Os.DbA.aGH> eli() {
        return new com.bytedance.adsdk.DbA.eli.DbA.ui(this.eli);
    }
}
