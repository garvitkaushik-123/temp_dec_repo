package com.bytedance.sdk.component.adexpress.dynamic.ui;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.DbA.NU;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    private NU FC;
    private int MGA;
    private double kb;
    private double ui;
    private String wC;
    public Map<String, Os> eli = new HashMap();
    public Map<String, Os> DbA = new HashMap();
    public Map<String, Os> Os = new HashMap();
    private double aGH = Math.random();

    public DbA(double d, int i, double d2, String str, NU nu) {
        this.ui = d;
        this.MGA = i;
        this.kb = d2;
        this.wC = str;
        this.FC = nu;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Os eli(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar, float f, float f2) {
        float f3;
        if (TextUtils.isEmpty(wCVar.aAs().Os()) && wCVar.aAs().ui().Mc() == null) {
            return new Os(0.0f, 0.0f);
        }
        if (TextUtils.equals(wCVar.aAs().DbA(), "creative-playable-bait")) {
            return new Os(0.0f, 0.0f);
        }
        float wC = wCVar.wC();
        float FC = wCVar.FC();
        com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA ui = wCVar.aAs().ui();
        String KM = ui.KM();
        String Ue = ui.Ue();
        float NU = wCVar.NU();
        float nn = wCVar.nn();
        float Dfc = wCVar.Dfc();
        float aqO = wCVar.aqO();
        if (TextUtils.equals(KM, "fixed")) {
            f = Math.min(wC, f);
            if (TextUtils.equals(Ue, "auto")) {
                f3 = DbA(wCVar, f - Dfc, f2 - aqO).DbA;
                FC = f3 + aqO;
            }
            if (TextUtils.equals(Ue, "scale")) {
                float round = Math.round((f - NU) / FC) + nn;
                if (round > f2) {
                    f = Math.round((f2 - nn) * FC) + NU;
                } else {
                    f2 = round;
                }
            } else if (TextUtils.equals(Ue, "fixed")) {
                f2 = Math.min(FC + nn, f2);
            } else if (!TextUtils.equals(Ue, "flex")) {
                f2 = FC;
            }
            Os os = new Os();
            os.eli = f;
            os.DbA = f2;
            return os;
        }
        if (TextUtils.equals(KM, "auto")) {
            Os DbA = DbA(wCVar, f - Dfc, f2 - aqO);
            f = DbA.eli + Dfc;
            if (TextUtils.equals(Ue, "auto")) {
                f3 = DbA.DbA;
                FC = f3 + aqO;
            }
            if (TextUtils.equals(Ue, "scale")) {
            }
            Os os2 = new Os();
            os2.eli = f;
            os2.DbA = f2;
            return os2;
        }
        if (!TextUtils.equals(KM, "flex")) {
            f = wC;
        } else if (TextUtils.equals(Ue, "auto")) {
            f3 = DbA(wCVar, f - Dfc, f2 - aqO).DbA;
            FC = f3 + aqO;
        }
        if (TextUtils.equals(Ue, "scale")) {
        }
        Os os22 = new Os();
        os22.eli = f;
        os22.DbA = f2;
        return os22;
    }

    public Os DbA(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar, float f, float f2) {
        Os os = new Os();
        if (wCVar.aAs().ui() == null) {
            return os;
        }
        Os ui = ui(wCVar, f, f2);
        float f3 = ui.eli;
        float f4 = ui.DbA;
        os.eli = Math.min(f3, f);
        os.DbA = Math.min(f4, f2);
        return os;
    }

    private Os ui(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar, float f, float f2) {
        String str = wCVar.Os() + "_" + f + "_" + f2;
        if (this.Os.containsKey(str)) {
            return this.Os.get(str);
        }
        Os MGA = MGA(wCVar, f, f2);
        this.Os.put(str, MGA);
        return MGA;
    }

    private Os MGA(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar, float f, float f2) {
        new Os();
        com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA ui = wCVar.aAs().ui();
        wCVar.aAs().Os();
        ui.mm();
        float nGm = ui.nGm();
        int QI = ui.QI();
        double TfR = ui.TfR();
        int oc = ui.oc();
        boolean jh = ui.jh();
        boolean rQ = ui.rQ();
        int Za = ui.Za();
        C0142DbA c0142DbA = new C0142DbA();
        c0142DbA.eli = nGm;
        c0142DbA.DbA = QI;
        c0142DbA.Os = oc;
        c0142DbA.aGH = TfR;
        c0142DbA.ui = f;
        return eli(wCVar.aAs().Os(), c0142DbA, jh, rQ, Za, wCVar);
    }

    private Os eli(String str, C0142DbA c0142DbA, boolean z, boolean z2, int i, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        return du.eli(str, wCVar.aAs().DbA(), C0142DbA.eli(c0142DbA).toString(), z, z2, i, wCVar, this.ui, this.MGA, this.kb, this.wC, this.FC);
    }

    public Os Os(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar, float f, float f2) {
        if (wCVar == null) {
            return null;
        }
        Os eli2 = eli(wCVar);
        if (eli2 != null && (eli2.eli != 0.0f || eli2.DbA != 0.0f)) {
            return eli2;
        }
        Os aGH = aGH(wCVar, f, f2);
        eli(wCVar, aGH);
        return aGH;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Os aGH(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar, float f, float f2) {
        float min;
        float f3;
        float f4;
        Os os = new Os();
        float f5 = 0.0f;
        if (f2 <= 0.0f || f <= 0.0f) {
            os.eli = 0.0f;
            os.DbA = 0.0f;
            return os;
        }
        if (wCVar.nGm()) {
            return eli(wCVar, f, f2);
        }
        float wC = wCVar.wC();
        float FC = wCVar.FC();
        float Dfc = wCVar.Dfc();
        float aqO = wCVar.aqO();
        com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA ui = wCVar.aAs().ui();
        String KM = ui.KM();
        String Ue = ui.Ue();
        float min2 = ((TextUtils.equals(KM, "flex") || TextUtils.equals(KM, "auto")) ? f : Math.min(wC, f)) - Dfc;
        if (TextUtils.equals(Ue, "scale")) {
            min = Math.round(min2 / FC) + aqO;
            if (min > f2) {
                min2 = Math.round((f2 - aqO) * FC);
                min = f2;
            }
            float f6 = min - aqO;
            List<List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC>> dV = wCVar.dV();
            float f7 = 0.0f;
            float f8 = 0.0f;
            for (List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> list : dV) {
                float f9 = f5;
                float f10 = Dfc;
                Os DbA = DbA(list, min2, f6);
                if (DbA(list)) {
                    f4 = f9 + 1.0f;
                } else {
                    f7 = Math.max(f7, DbA.eli);
                    f4 = f9;
                }
                float f11 = f4;
                float f12 = min2;
                if (wCVar.aAs().DbA().equals("carousel")) {
                    f8 = Math.max(wCVar.FC(), DbA.DbA);
                } else {
                    f8 += DbA.DbA;
                }
                Dfc = f10;
                f5 = f11;
                min2 = f12;
            }
            float f13 = f5;
            float f14 = min2;
            float f15 = Dfc;
            if (!TextUtils.equals(KM, "auto")) {
                f3 = f14;
            } else if (f13 == dV.size()) {
                f3 = f;
            } else {
                for (List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> list2 : dV) {
                    Os(list2);
                    DbA(list2, f7, f6);
                }
                f3 = f7;
            }
            if (TextUtils.equals(Ue, "auto")) {
                if (f8 <= f2) {
                    f6 = f8;
                } else {
                    eli(dV, f3, f6);
                }
            } else if ((TextUtils.equals(Ue, "fixed") || TextUtils.equals(Ue, "flex")) && f6 < f8) {
                eli(dV, f3, f6);
            }
            os.eli = Math.min(f3 + f15, f);
            os.DbA = Math.min(f6 + aqO, f2);
            return os;
        }
        if (!TextUtils.equals(Ue, "auto") && !TextUtils.equals(Ue, "flex")) {
            min = Math.min(FC, f2);
            float f62 = min - aqO;
            List<List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC>> dV2 = wCVar.dV();
            float f72 = 0.0f;
            float f82 = 0.0f;
            while (r14.hasNext()) {
            }
            float f132 = f5;
            float f142 = min2;
            float f152 = Dfc;
            if (!TextUtils.equals(KM, "auto")) {
            }
            if (TextUtils.equals(Ue, "auto")) {
            }
            os.eli = Math.min(f3 + f152, f);
            os.DbA = Math.min(f62 + aqO, f2);
            return os;
        }
        min = f2;
        float f622 = min - aqO;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC>> dV22 = wCVar.dV();
        float f722 = 0.0f;
        float f822 = 0.0f;
        while (r14.hasNext()) {
        }
        float f1322 = f5;
        float f1422 = min2;
        float f1522 = Dfc;
        if (!TextUtils.equals(KM, "auto")) {
        }
        if (TextUtils.equals(Ue, "auto")) {
        }
        os.eli = Math.min(f3 + f1522, f);
        os.DbA = Math.min(f622 + aqO, f2);
        return os;
    }

    private void eli(List<List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC>> list, float f, float f2) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC>> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (eli(it.next(), false)) {
                z = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> list2 : list) {
            eli eliVar = new eli();
            boolean eli2 = eli(list2, !z);
            eliVar.eli = eli2 ? 1.0f : DbA(list2, f, f2).DbA;
            eliVar.DbA = !eli2;
            arrayList.add(eliVar);
        }
        List<eli> eli3 = aAs.eli(f2, arrayList);
        for (int i = 0; i < list.size(); i++) {
            if (((eli) arrayList.get(i)).eli != eli3.get(i).eli) {
                List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> list3 = list.get(i);
                Os(list3);
                DbA(list3, f, eli3.get(i).eli);
            }
        }
    }

    private boolean DbA(List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> list) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC>> dV;
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().aAs().ui().KM(), "flex")) {
                return true;
            }
        }
        while (true) {
            boolean z = false;
            for (com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar : list) {
                if (TextUtils.equals(wCVar.aAs().ui().KM(), "auto") && (dV = wCVar.dV()) != null) {
                    int i = 0;
                    for (List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> list2 : dV) {
                        i++;
                        if (!DbA(list2)) {
                            break;
                        }
                        if (i == list2.size()) {
                            z = true;
                        }
                    }
                }
            }
            return z;
        }
    }

    private Os DbA(List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> list, float f, float f2) {
        Os eli2 = eli(list);
        if (eli2 != null && (eli2.eli != 0.0f || eli2.DbA != 0.0f)) {
            return eli2;
        }
        Os Os2 = Os(list, f, f2);
        eli(list, Os2);
        return Os2;
    }

    private Os Os(List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> list, float f, float f2) {
        float f3;
        aGH(list);
        Os os = new Os();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA ui = wCVar.aAs().ui();
            if (ui.Yw() == 1 || ui.Yw() == 2) {
                arrayList.add(wCVar);
            }
            if (ui.Yw() != 1 && ui.Yw() != 2) {
                arrayList2.add(wCVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Os((com.bytedance.sdk.component.adexpress.dynamic.aGH.wC) it.next(), f, f2);
        }
        if (arrayList2.size() <= 0) {
            return os;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Float.valueOf(Os(it2.next(), f, f2).eli));
        }
        ArrayList arrayList4 = new ArrayList();
        int i = 0;
        while (true) {
            if (i >= arrayList2.size()) {
                break;
            }
            com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar2 = arrayList2.get(i);
            String KM = wCVar2.aAs().ui().KM();
            float wC = wCVar2.wC();
            boolean equals = TextUtils.equals(KM, "flex");
            if (TextUtils.equals(KM, "auto")) {
                List<List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC>> dV = wCVar2.dV();
                if (dV != null && dV.size() > 0) {
                    Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC>> it3 = dV.iterator();
                    while (it3.hasNext()) {
                        if (DbA(it3.next())) {
                            equals = true;
                            break;
                        }
                    }
                }
                equals = false;
            }
            eli eliVar = new eli();
            if (!equals) {
                wC = ((Float) arrayList3.get(i)).floatValue();
            }
            eliVar.eli = wC;
            eliVar.DbA = !equals;
            if (equals) {
                f3 = ((Float) arrayList3.get(i)).floatValue();
            }
            eliVar.Os = f3;
            arrayList4.add(eliVar);
            i++;
        }
        eli(arrayList4, f, arrayList2);
        List<eli> eli2 = aAs.eli(f, arrayList4);
        float f4 = 0.0f;
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            f4 += eli2.get(i2).eli;
            if (((Float) arrayList3.get(i2)).floatValue() != eli2.get(i2).eli) {
                aGH(arrayList2.get(i2));
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> it4 = arrayList2.iterator();
        int i3 = 0;
        boolean z = false;
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            i3++;
            if (!DbA(it4.next())) {
                z = false;
                break;
            }
            if (i3 == arrayList2.size()) {
                z = true;
            }
        }
        f3 = z ? f2 : 0.0f;
        ArrayList arrayList5 = new ArrayList();
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar3 = arrayList2.get(i4);
            Os Os2 = Os(wCVar3, eli2.get(i4).eli, f2);
            if (!DbA(wCVar3)) {
                f3 = Math.max(f3, Os2.DbA);
            }
            arrayList5.add(Os2);
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            arrayList6.add(Float.valueOf(((Os) it5.next()).DbA));
        }
        if (!z) {
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar4 = arrayList2.get(i5);
                if (DbA(wCVar4) && ((Float) arrayList6.get(i5)).floatValue() != f3) {
                    aGH(wCVar4);
                    Os(wCVar4, eli2.get(i5).eli, f3);
                }
            }
        }
        os.eli = f4;
        os.DbA = f3;
        return os;
    }

    private boolean DbA(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        if (wCVar == null) {
            return false;
        }
        if (TextUtils.equals(wCVar.aAs().ui().Ue(), "flex")) {
            return true;
        }
        return Os(wCVar);
    }

    private boolean Os(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC>> dV;
        if (!wCVar.nGm() && TextUtils.equals(wCVar.aAs().ui().Ue(), "auto") && (dV = wCVar.dV()) != null && dV.size() > 0) {
            if (dV.size() == 1) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> it = dV.get(0).iterator();
                while (it.hasNext()) {
                    if (!DbA(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC>> it2 = dV.iterator();
            while (it2.hasNext()) {
                if (eli(it2.next(), true)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean eli(List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> list, boolean z) {
        for (com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA ui = wCVar.aAs().ui();
            String Ue = ui.Ue();
            if (TextUtils.equals(Ue, "flex") || (z && ((TextUtils.equals(ui.KM(), "flex") && TextUtils.equals(ui.Ue(), "scale") && com.bytedance.sdk.component.adexpress.dynamic.aGH.ui.eli.get(wCVar.aAs().DbA()).intValue() == 7) || TextUtils.equals(Ue, "flex")))) {
                return true;
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> it = list.iterator();
        while (it.hasNext()) {
            if (Os(it.next())) {
                return true;
            }
        }
        return false;
    }

    private void eli(List<eli> list, float f, List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> list2) {
        float f2 = 0.0f;
        for (eli eliVar : list) {
            if (eliVar.DbA) {
                f2 += eliVar.eli;
            }
        }
        if (f2 > f) {
            int i = 0;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (list.get(i2).DbA && list2.get(i2).CMM()) {
                    i++;
                }
            }
            if (i > 0) {
                float ceil = (float) (Math.ceil(((f2 - f) / i) * 1000.0f) / 1000.0d);
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    eli eliVar2 = list.get(i3);
                    if (eliVar2.DbA && list2.get(i3).CMM()) {
                        eliVar2.eli -= ceil;
                    }
                }
            }
        }
    }

    public void eli() {
        this.Os.clear();
        this.eli.clear();
        this.DbA.clear();
    }

    public Os eli(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        return this.eli.get(ui(wCVar));
    }

    public Os eli(List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> list) {
        return this.DbA.get(aGH(list));
    }

    private void aGH(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        this.eli.remove(ui(wCVar));
        List<List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC>> dV = wCVar.dV();
        if (dV == null || dV.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC>> it = dV.iterator();
        while (it.hasNext()) {
            Os(it.next());
        }
    }

    private void Os(List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.DbA.remove(aGH(list));
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> it = list.iterator();
        while (it.hasNext()) {
            aGH(it.next());
        }
    }

    private String ui(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        return wCVar.Os();
    }

    private String aGH(List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String Os2 = list.get(i).Os();
            if (i < list.size() - 1) {
                sb.append(Os2).append("-");
            } else {
                sb.append(Os2);
            }
        }
        return sb.toString();
    }

    private void eli(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar, Os os) {
        this.eli.put(ui(wCVar), os);
    }

    private void eli(List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> list, Os os) {
        this.DbA.put(aGH(list), os);
    }

    static class Os {
        float DbA;
        float eli;

        public Os() {
        }

        public Os(float f, float f2) {
            this.eli = f;
            this.DbA = f2;
        }

        public String toString() {
            return "UnitSize{width=" + this.eli + ", height=" + this.DbA + AbstractJsonLexerKt.END_OBJ;
        }
    }

    /* renamed from: com.bytedance.sdk.component.adexpress.dynamic.ui.DbA$DbA, reason: collision with other inner class name */
    static class C0142DbA {
        int DbA;
        int Os;
        double aGH;
        float eli;
        float ui;

        C0142DbA() {
        }

        static JSONObject eli(C0142DbA c0142DbA) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fontSize", c0142DbA.eli);
                jSONObject.put("letterSpacing", c0142DbA.DbA);
                jSONObject.put("lineHeight", c0142DbA.aGH);
                jSONObject.put("maxWidth", c0142DbA.ui);
                jSONObject.put("fontWeight", c0142DbA.Os);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    static class eli implements Cloneable {
        boolean DbA;
        float Os;
        float eli;

        eli() {
        }

        public Object clone() {
            try {
                return (eli) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }
    }
}
