package com.bytedance.adsdk.DbA.eli.eli;

import android.graphics.PointF;
import com.bytedance.adsdk.DbA.eli.DbA.eli;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class dV implements eli.InterfaceC0115eli, QX {
    private final String DbA;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> Os;
    private com.bytedance.adsdk.DbA.Os.DbA.nn aGH;
    private final com.bytedance.adsdk.DbA.FC eli;

    @Override // com.bytedance.adsdk.DbA.eli.eli.Os
    public void eli(List<Os> list, List<Os> list2) {
    }

    public dV(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.Os.Os.eli eliVar, com.bytedance.adsdk.DbA.Os.DbA.NU nu) {
        this.eli = fc;
        this.DbA = nu.eli();
        com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eli = nu.DbA().eli();
        this.Os = eli;
        eliVar.eli(eli);
        eli.eli(this);
    }

    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.InterfaceC0115eli
    public void eli() {
        this.eli.invalidateSelf();
    }

    public com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> DbA() {
        return this.Os;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x009e, code lost:
    
        if (r7 == (r0.size() - 1)) goto L27;
     */
    @Override // com.bytedance.adsdk.DbA.eli.eli.QX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.bytedance.adsdk.DbA.Os.DbA.nn eli(com.bytedance.adsdk.DbA.Os.DbA.nn nnVar) {
        List<com.bytedance.adsdk.DbA.Os.eli> list;
        boolean z;
        List<com.bytedance.adsdk.DbA.Os.eli> Os = nnVar.Os();
        if (Os.size() > 2) {
            float floatValue = this.Os.kb().floatValue();
            if (floatValue != 0.0f) {
                com.bytedance.adsdk.DbA.Os.DbA.nn DbA = DbA(nnVar);
                DbA.eli(nnVar.eli().x, nnVar.eli().y);
                List<com.bytedance.adsdk.DbA.Os.eli> Os2 = DbA.Os();
                boolean DbA2 = nnVar.DbA();
                int i = 0;
                int i2 = 0;
                while (i < Os.size()) {
                    com.bytedance.adsdk.DbA.Os.eli eliVar = Os.get(i);
                    com.bytedance.adsdk.DbA.Os.eli eliVar2 = Os.get(eli(i - 1, Os.size()));
                    com.bytedance.adsdk.DbA.Os.eli eliVar3 = Os.get(eli(i - 2, Os.size()));
                    PointF Os3 = (i != 0 || DbA2) ? eliVar2.Os() : nnVar.eli();
                    PointF DbA3 = (i != 0 || DbA2) ? eliVar2.DbA() : Os3;
                    PointF eli = eliVar.eli();
                    PointF Os4 = eliVar3.Os();
                    PointF Os5 = eliVar.Os();
                    boolean z2 = !nnVar.DbA() && i == 0;
                    if (DbA3.equals(Os3) && eli.equals(Os3) && !z2) {
                        float f = Os3.x - Os4.x;
                        float f2 = Os3.y - Os4.y;
                        float f3 = Os5.x - Os3.x;
                        float f4 = Os5.y - Os3.y;
                        list = Os;
                        z = DbA2;
                        float hypot = (float) Math.hypot(f, f2);
                        float hypot2 = (float) Math.hypot(f3, f4);
                        float min = Math.min(floatValue / hypot, 0.5f);
                        float min2 = Math.min(floatValue / hypot2, 0.5f);
                        float f5 = Os3.x + ((Os4.x - Os3.x) * min);
                        float f6 = Os3.y + ((Os4.y - Os3.y) * min);
                        float f7 = Os3.x + ((Os5.x - Os3.x) * min2);
                        float f8 = Os3.y + ((Os5.y - Os3.y) * min2);
                        float f9 = f5 - ((f5 - Os3.x) * 0.5519f);
                        float f10 = f6 - ((f6 - Os3.y) * 0.5519f);
                        float f11 = f7 - ((f7 - Os3.x) * 0.5519f);
                        float f12 = f8 - ((f8 - Os3.y) * 0.5519f);
                        com.bytedance.adsdk.DbA.Os.eli eliVar4 = Os2.get(eli(i2 - 1, Os2.size()));
                        com.bytedance.adsdk.DbA.Os.eli eliVar5 = Os2.get(i2);
                        eliVar4.DbA(f5, f6);
                        eliVar4.Os(f5, f6);
                        if (i == 0) {
                            DbA.eli(f5, f6);
                        }
                        eliVar5.eli(f9, f10);
                        com.bytedance.adsdk.DbA.Os.eli eliVar6 = Os2.get(i2 + 1);
                        eliVar5.DbA(f11, f12);
                        eliVar5.Os(f7, f8);
                        eliVar6.eli(f7, f8);
                        i2 += 2;
                    } else {
                        list = Os;
                        z = DbA2;
                        com.bytedance.adsdk.DbA.Os.eli eliVar7 = Os2.get(eli(i2 - 1, Os2.size()));
                        com.bytedance.adsdk.DbA.Os.eli eliVar8 = Os2.get(i2);
                        eliVar7.DbA(eliVar2.DbA().x, eliVar2.DbA().y);
                        eliVar7.Os(eliVar2.Os().x, eliVar2.Os().y);
                        eliVar8.eli(eliVar.eli().x, eliVar.eli().y);
                        i2++;
                    }
                    i++;
                    Os = list;
                    DbA2 = z;
                }
                return DbA;
            }
        }
        return nnVar;
    }

    private com.bytedance.adsdk.DbA.Os.DbA.nn DbA(com.bytedance.adsdk.DbA.Os.DbA.nn nnVar) {
        List<com.bytedance.adsdk.DbA.Os.eli> Os = nnVar.Os();
        boolean DbA = nnVar.DbA();
        int size = Os.size() - 1;
        int i = 0;
        while (size >= 0) {
            com.bytedance.adsdk.DbA.Os.eli eliVar = Os.get(size);
            com.bytedance.adsdk.DbA.Os.eli eliVar2 = Os.get(eli(size - 1, Os.size()));
            PointF Os2 = (size != 0 || DbA) ? eliVar2.Os() : nnVar.eli();
            i = (((size != 0 || DbA) ? eliVar2.DbA() : Os2).equals(Os2) && eliVar.eli().equals(Os2) && !(!nnVar.DbA() && size == 0 && size == Os.size() - 1)) ? i + 2 : i + 1;
            size--;
        }
        com.bytedance.adsdk.DbA.Os.DbA.nn nnVar2 = this.aGH;
        if (nnVar2 == null || nnVar2.Os().size() != i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new com.bytedance.adsdk.DbA.Os.eli());
            }
            this.aGH = new com.bytedance.adsdk.DbA.Os.DbA.nn(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.aGH.eli(DbA);
        return this.aGH;
    }

    private static int eli(int i, int i2) {
        return i - (DbA(i, i2) * i2);
    }

    private static int DbA(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }
}
