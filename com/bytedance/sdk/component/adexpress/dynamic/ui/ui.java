package com.bytedance.sdk.component.adexpress.dynamic.ui;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.DbA.NU;
import com.bytedance.sdk.component.adexpress.dynamic.ui.DbA;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ui {
    protected DbA DbA;
    private com.bytedance.sdk.component.adexpress.dynamic.aGH.wC Os;
    private eli aGH;
    public com.bytedance.sdk.component.adexpress.dynamic.aGH.DbA eli;

    static class eli {
        float DbA;
        float Os;
        float eli;

        eli() {
        }
    }

    public ui(double d, int i, double d2, String str, NU nu) {
        this.DbA = new DbA(d, i, d2, str, nu);
    }

    public void eli(eli eliVar) {
        this.aGH = eliVar;
    }

    public void eli() {
        this.DbA.eli();
    }

    public void eli(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar, float f, float f2) {
        if (wCVar != null) {
            this.Os = wCVar;
        }
        com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar2 = this.Os;
        float wC = wCVar2.wC();
        float FC = wCVar2.FC();
        float f3 = TextUtils.equals(wCVar2.aAs().ui().Ue(), "fixed") ? FC : 65536.0f;
        this.DbA.eli();
        this.DbA.Os(wCVar2, wC, f3);
        DbA.Os eli2 = this.DbA.eli(wCVar2);
        com.bytedance.sdk.component.adexpress.dynamic.aGH.DbA dbA = new com.bytedance.sdk.component.adexpress.dynamic.aGH.DbA();
        dbA.eli = f;
        dbA.DbA = f2;
        if (eli2 != null) {
            wC = eli2.eli;
        }
        dbA.Os = wC;
        if (eli2 != null) {
            FC = eli2.DbA;
        }
        dbA.aGH = FC;
        dbA.ui = "root";
        dbA.FC = 1280.0f;
        dbA.MGA = wCVar2;
        dbA.MGA.Os(dbA.eli);
        dbA.MGA.aGH(dbA.DbA);
        dbA.MGA.ui(dbA.Os);
        dbA.MGA.MGA(dbA.aGH);
        com.bytedance.sdk.component.adexpress.dynamic.aGH.DbA eli3 = eli(dbA, 0.0f);
        this.eli = eli3;
        eli(eli3);
    }

    public void eli(com.bytedance.sdk.component.adexpress.dynamic.aGH.DbA dbA) {
        if (dbA == null) {
            return;
        }
        dbA.MGA.aAs().DbA();
        float f = dbA.Os;
        float f2 = dbA.aGH;
        float f3 = dbA.eli;
        float f4 = dbA.DbA;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.aGH.DbA>> list = dbA.kb;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (List<com.bytedance.sdk.component.adexpress.dynamic.aGH.DbA> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.aGH.DbA> it = list2.iterator();
                while (it.hasNext()) {
                    eli(it.next());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x027b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.bytedance.sdk.component.adexpress.dynamic.aGH.DbA eli(com.bytedance.sdk.component.adexpress.dynamic.aGH.DbA dbA, float f) {
        float f2;
        float f3;
        int i;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC>> list;
        float f4;
        float f5;
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> it;
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> it2;
        float f6;
        String str;
        com.bytedance.sdk.component.adexpress.dynamic.aGH.FC fc;
        float f7;
        com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar = dbA.MGA;
        if (wCVar != null) {
            wCVar.bf();
            List<List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC>> dV = wCVar.dV();
            if (dV != null && dV.size() > 0) {
                com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA ui = wCVar.aAs().ui();
                float dV2 = ui.dV();
                float aqO = ui.aqO();
                float nn = ui.nn();
                float Dfc = ui.Dfc();
                float nlS = ui.nlS();
                String Uv = ui.Uv();
                String FS = ui.FS();
                float f8 = dbA.eli + Dfc;
                float f9 = dbA.DbA + dV2;
                float f10 = (dbA.Os - Dfc) - aqO;
                float f11 = 2.0f;
                float f12 = nlS * 2.0f;
                float f13 = f10 - f12;
                float f14 = ((dbA.aGH - dV2) - nn) - f12;
                com.bytedance.sdk.component.adexpress.dynamic.aGH.FC fc2 = new com.bytedance.sdk.component.adexpress.dynamic.aGH.FC(f8, f9);
                if (dbA.kb == null) {
                    dbA.kb = new ArrayList();
                }
                Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC>> it3 = dV.iterator();
                float f15 = 0.0f;
                while (it3.hasNext()) {
                    float f16 = f11;
                    DbA.Os eli2 = this.DbA.eli(it3.next());
                    if (eli2 != null) {
                        f15 += eli2.DbA;
                    }
                    f11 = f16;
                }
                float f17 = f11;
                String str2 = "space-between";
                String str3 = "space-around";
                int i2 = 1;
                if (f15 < f14) {
                    if (TextUtils.equals(FS, "center")) {
                        f3 = (f14 - f15) / f17;
                    } else if (TextUtils.equals(FS, "flex-end")) {
                        f3 = f14 - f15;
                    } else if (TextUtils.equals(FS, "space-around")) {
                        f3 = aAs.eli((f14 - f15) / (dV.size() + 1));
                        f2 = f3;
                        fc2.DbA += f3;
                        float f18 = f;
                        i = 0;
                        while (i < dV.size()) {
                            List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> list2 = dV.get(i);
                            i++;
                            int i3 = i2;
                            if (i >= dbA.kb.size()) {
                                list = dV;
                                int i4 = 0;
                                for (int size = (i - dbA.kb.size()) + 1; i4 < size; size = size) {
                                    dbA.kb.add(new ArrayList());
                                    i4++;
                                }
                            } else {
                                list = dV;
                            }
                            Iterator<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> it4 = list2.iterator();
                            float f19 = 0.0f;
                            while (true) {
                                Iterator<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> it5 = it4;
                                if (!it4.hasNext()) {
                                    break;
                                }
                                com.bytedance.sdk.component.adexpress.dynamic.aGH.wC next = it5.next();
                                com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA ui2 = next.aAs().ui();
                                float f20 = f19;
                                String KM = ui2.KM();
                                float f21 = f2;
                                int Yw = ui2.Yw();
                                float f22 = f18;
                                if (TextUtils.equals(KM, "flex") || Yw == i3 || Yw == 2) {
                                    it4 = it5;
                                    f18 = f22;
                                    f19 = f20;
                                } else {
                                    DbA.Os eli3 = this.DbA.eli(next);
                                    f19 = eli3 != null ? f20 + eli3.eli : f20;
                                    it4 = it5;
                                    f18 = f22;
                                }
                                f2 = f21;
                                i3 = 1;
                            }
                            float f23 = f2;
                            float f24 = f18;
                            float max = Math.max(f13 - f19, 0.0f);
                            Iterator<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> it6 = list2.iterator();
                            float f25 = 0.0f;
                            while (it6.hasNext()) {
                                com.bytedance.sdk.component.adexpress.dynamic.aGH.wC next2 = it6.next();
                                com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA ui3 = next2.aAs().ui();
                                Iterator<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> it7 = it6;
                                float f26 = f25;
                                if (ui3.Yw() == 1 || ui3.Yw() == 2) {
                                    it6 = it7;
                                    f25 = f26;
                                } else {
                                    DbA.Os eli4 = this.DbA.eli(next2);
                                    f25 = eli4 != null ? f26 + eli4.eli : f26;
                                    it6 = it7;
                                }
                            }
                            float f27 = f25;
                            if (f27 < f13) {
                                if (TextUtils.equals(Uv, "center")) {
                                    f4 = (f13 - f27) / f17;
                                } else if (TextUtils.equals(Uv, "flex-end")) {
                                    f4 = f13 - f27;
                                } else {
                                    if (TextUtils.equals(Uv, str3)) {
                                        f4 = aAs.eli((f13 - f27) / (list2.size() + 1));
                                        f5 = f4;
                                    } else if (TextUtils.equals(Uv, str2) && list2.size() > 1) {
                                        f5 = aAs.eli((f13 - f27) / (list2.size() - 1.0f));
                                        f4 = 0.0f;
                                    }
                                    fc2.eli += f4;
                                    it = list2.iterator();
                                    float f28 = 0.0f;
                                    while (it.hasNext()) {
                                        Iterator<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> it8 = it;
                                        com.bytedance.sdk.component.adexpress.dynamic.aGH.wC next3 = it.next();
                                        float f29 = f5;
                                        float f30 = this.DbA.eli(next3) != null ? this.DbA.eli(next3).DbA : 0.0f;
                                        com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA ui4 = next3.aAs().ui();
                                        f28 = Math.max(f28, (ui4.Yw() == 1 || ui4.Yw() == 2) ? 0.0f : f30);
                                        it = it8;
                                        f5 = f29;
                                    }
                                    float f31 = f5;
                                    it2 = list2.iterator();
                                    while (it2.hasNext()) {
                                        com.bytedance.sdk.component.adexpress.dynamic.aGH.wC next4 = it2.next();
                                        Iterator<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> it9 = it2;
                                        DbA.Os eli5 = this.DbA.eli(next4);
                                        String str4 = str2;
                                        com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA ui5 = next4.aAs().ui();
                                        String str5 = Uv;
                                        float ikX = ui5.ikX();
                                        float ow = ui5.ow();
                                        float tGZ = ui5.tGZ();
                                        float WfR = ui5.WfR();
                                        float f32 = eli5 == null ? 0.0f : eli5.eli;
                                        float f33 = eli5 == null ? 0.0f : eli5.DbA;
                                        float f34 = f32;
                                        float f35 = TextUtils.equals(wCVar.Os(), "root") ? i : f24;
                                        float f36 = f28;
                                        com.bytedance.sdk.component.adexpress.dynamic.aGH.FC eli6 = ui5.Yw() == 1 ? eli(dbA, ui5, (f34 - ow) - WfR, (f33 - ikX) - tGZ) : fc2;
                                        if (ui5.Yw() == 2) {
                                            f6 = f13;
                                            str = str3;
                                            fc = eli(ui5, this.DbA.eli(this.Os), new DbA.Os((f34 - ow) - WfR, (f33 - ikX) - tGZ));
                                        } else {
                                            f6 = f13;
                                            str = str3;
                                            fc = eli6;
                                        }
                                        String XU = ui.XU();
                                        if (f36 > f33 && !TextUtils.equals(XU, "flex-start")) {
                                            XU.hashCode();
                                            if (XU.equals("center")) {
                                                f7 = (f36 - f33) / f17;
                                            } else if (XU.equals("flex-end")) {
                                                f7 = f36 - f33;
                                            }
                                            com.bytedance.sdk.component.adexpress.dynamic.aGH.DbA dbA2 = new com.bytedance.sdk.component.adexpress.dynamic.aGH.DbA();
                                            dbA2.eli = fc.eli + WfR;
                                            dbA2.DbA = fc.DbA + ikX + f7;
                                            dbA2.Os = (f34 - ow) - WfR;
                                            dbA2.aGH = (f33 - ikX) - tGZ;
                                            dbA2.ui = dbA.ui + "." + next4.Os();
                                            dbA2.wC = dbA;
                                            dbA2.MGA = next4;
                                            dbA2.FC = max;
                                            dbA2.aAs = list2;
                                            dbA2.MGA.Os(dbA2.eli);
                                            dbA2.MGA.aGH(dbA2.DbA);
                                            dbA2.MGA.ui(dbA2.Os);
                                            dbA2.MGA.MGA(dbA2.aGH);
                                            dbA.kb.get(i).add(eli(dbA2, f35));
                                            if (ui5.Yw() != 1 && ui5.Yw() != 2) {
                                                fc2.eli += f34 + f31;
                                            }
                                            f24 = f35;
                                            Uv = str5;
                                            str2 = str4;
                                            f28 = f36;
                                            f13 = f6;
                                            str3 = str;
                                            it2 = it9;
                                        }
                                        f7 = 0.0f;
                                        com.bytedance.sdk.component.adexpress.dynamic.aGH.DbA dbA22 = new com.bytedance.sdk.component.adexpress.dynamic.aGH.DbA();
                                        dbA22.eli = fc.eli + WfR;
                                        dbA22.DbA = fc.DbA + ikX + f7;
                                        dbA22.Os = (f34 - ow) - WfR;
                                        dbA22.aGH = (f33 - ikX) - tGZ;
                                        dbA22.ui = dbA.ui + "." + next4.Os();
                                        dbA22.wC = dbA;
                                        dbA22.MGA = next4;
                                        dbA22.FC = max;
                                        dbA22.aAs = list2;
                                        dbA22.MGA.Os(dbA22.eli);
                                        dbA22.MGA.aGH(dbA22.DbA);
                                        dbA22.MGA.ui(dbA22.Os);
                                        dbA22.MGA.MGA(dbA22.aGH);
                                        dbA.kb.get(i).add(eli(dbA22, f35));
                                        if (ui5.Yw() != 1) {
                                            fc2.eli += f34 + f31;
                                        }
                                        f24 = f35;
                                        Uv = str5;
                                        str2 = str4;
                                        f28 = f36;
                                        f13 = f6;
                                        str3 = str;
                                        it2 = it9;
                                    }
                                    fc2.eli = f8;
                                    fc2.DbA += f28 + f23;
                                    i2 = 1;
                                    dV = list;
                                    f18 = f24;
                                    f2 = f23;
                                }
                                f5 = 0.0f;
                                fc2.eli += f4;
                                it = list2.iterator();
                                float f282 = 0.0f;
                                while (it.hasNext()) {
                                }
                                float f312 = f5;
                                it2 = list2.iterator();
                                while (it2.hasNext()) {
                                }
                                fc2.eli = f8;
                                fc2.DbA += f282 + f23;
                                i2 = 1;
                                dV = list;
                                f18 = f24;
                                f2 = f23;
                            }
                            f4 = 0.0f;
                            f5 = 0.0f;
                            fc2.eli += f4;
                            it = list2.iterator();
                            float f2822 = 0.0f;
                            while (it.hasNext()) {
                            }
                            float f3122 = f5;
                            it2 = list2.iterator();
                            while (it2.hasNext()) {
                            }
                            fc2.eli = f8;
                            fc2.DbA += f2822 + f23;
                            i2 = 1;
                            dV = list;
                            f18 = f24;
                            f2 = f23;
                        }
                    } else if (TextUtils.equals(FS, "space-between") && dV.size() > 1) {
                        f2 = aAs.eli((f14 - f15) / (dV.size() - 1));
                        f3 = 0.0f;
                        fc2.DbA += f3;
                        float f182 = f;
                        i = 0;
                        while (i < dV.size()) {
                        }
                    }
                    f2 = 0.0f;
                    fc2.DbA += f3;
                    float f1822 = f;
                    i = 0;
                    while (i < dV.size()) {
                    }
                }
                f2 = 0.0f;
                f3 = 0.0f;
                fc2.DbA += f3;
                float f18222 = f;
                i = 0;
                while (i < dV.size()) {
                }
            }
        }
        return dbA;
    }

    private com.bytedance.sdk.component.adexpress.dynamic.aGH.FC eli(com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA mga, DbA.Os os, DbA.Os os2) {
        float Ca = mga.Ca();
        float rn = mga.rn();
        float yKf = mga.yKf();
        float Gjg = mga.Gjg();
        boolean BH = mga.BH();
        boolean BDs = mga.BDs();
        boolean tLO = mga.tLO();
        boolean gHb = mga.gHb();
        if (!BH) {
            if (BDs) {
                Ca = ((this.aGH.eli != 0.0f ? Math.min(this.aGH.eli, os.eli) : os.eli) - yKf) - os2.eli;
            } else {
                Ca = 0.0f;
            }
        }
        if (!tLO) {
            if (gHb) {
                rn = ((this.aGH.DbA != 0.0f ? this.aGH.DbA : os.DbA) - Gjg) - os2.DbA;
            } else {
                rn = 0.0f;
            }
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.aGH.FC(Ca, rn);
    }

    private com.bytedance.sdk.component.adexpress.dynamic.aGH.FC eli(com.bytedance.sdk.component.adexpress.dynamic.aGH.DbA dbA, com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA mga, float f, float f2) {
        float f3;
        float f4;
        float f5 = dbA.eli;
        float f6 = dbA.DbA;
        float Ca = mga.Ca();
        float rn = mga.rn();
        float yKf = mga.yKf();
        float Gjg = mga.Gjg();
        boolean BH = mga.BH();
        boolean BDs = mga.BDs();
        boolean tLO = mga.tLO();
        boolean gHb = mga.gHb();
        String qyC = mga.qyC();
        float f7 = dbA.Os;
        float f8 = dbA.aGH;
        if (TextUtils.equals(qyC, "0")) {
            if (BH) {
                f5 = dbA.eli + Ca;
            } else if (BDs) {
                f5 = ((dbA.eli + f7) - yKf) - f;
            }
            if (tLO) {
                f4 = dbA.DbA;
                f6 = f4 + rn;
            } else if (gHb) {
                f3 = dbA.DbA;
                f6 = ((f3 + f8) - Gjg) - f2;
            }
        } else if (TextUtils.equals(qyC, "1")) {
            f5 = dbA.eli + ((f7 - f) / 2.0f);
            if (tLO) {
                f4 = dbA.DbA;
                f6 = f4 + rn;
            } else if (gHb) {
                f3 = dbA.DbA;
                f6 = ((f3 + f8) - Gjg) - f2;
            }
        } else if (TextUtils.equals(qyC, "2")) {
            f6 = dbA.DbA + ((f8 - f2) / 2.0f);
            if (BH) {
                f5 = dbA.eli + Ca;
            } else if (BDs) {
                f5 = ((dbA.eli + f7) - yKf) - f;
            }
        } else if (TextUtils.equals(qyC, "3")) {
            f5 = dbA.eli + ((f7 - f) / 2.0f);
            f6 = dbA.DbA + ((f8 - f2) / 2.0f);
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.aGH.FC(f5, f6);
    }
}
