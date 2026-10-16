package com.bytedance.adsdk.ugeno.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.bytedance.adsdk.ugeno.DbA.eli;
import com.bytedance.adsdk.ugeno.core.kb;
import com.ironsource.C3207n2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class nlS {
    private JSONObject DbA;
    private List<String> Dfc;
    private String FC;
    private nGm MGA;
    private com.bytedance.adsdk.ugeno.aGH.eli.eli NU;
    private com.bytedance.adsdk.ugeno.DbA.Os<View> Os;
    private FC QX;
    private du aAs;
    private wC aGH;
    private ui aqO;
    private float dV;
    private Context eli;
    private aqO kb;
    private float nGm;
    private boolean nn;
    private Dfc ui;
    private kb wC;
    private boolean du = true;
    private boolean nlS = false;

    public nlS(Context context) {
        this.eli = context;
    }

    public void eli(String str, du duVar) {
        this.aAs = duVar;
        this.FC = str;
        if (duVar != null) {
            this.DbA = duVar.eli();
        }
    }

    public com.bytedance.adsdk.ugeno.DbA.Os<View> eli(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this.DbA = jSONObject2;
        nGm ngm = this.MGA;
        if (ngm != null) {
            ngm.eli();
        }
        kb kbVar = new kb(jSONObject, jSONObject2, jSONObject3);
        this.wC = kbVar;
        kbVar.eli(this.dV, this.nGm);
        this.NU = new com.bytedance.adsdk.ugeno.aGH.eli.eli();
        if (this.ui instanceof com.bytedance.adsdk.ugeno.core.eli.DbA) {
            this.wC.DbA();
            throw null;
        }
        this.Os = eli(this.wC.eli(), (com.bytedance.adsdk.ugeno.DbA.Os<View>) null);
        if (this.QX != null) {
            throw null;
        }
        nGm ngm2 = this.MGA;
        if (ngm2 != null) {
            ngm2.DbA();
            this.Os.eli(this.MGA);
            this.MGA.Os();
        }
        eli(this.Os);
        if (this.MGA != null) {
            dV dVVar = new dV();
            dVVar.eli(0);
            dVVar.eli(this.Os);
            this.MGA.eli(dVVar);
        }
        return this.Os;
    }

    public com.bytedance.adsdk.ugeno.DbA.Os<View> eli(kb.eli eliVar, JSONObject jSONObject, JSONObject jSONObject2) {
        this.DbA = jSONObject;
        nGm ngm = this.MGA;
        if (ngm != null) {
            ngm.eli();
        }
        this.NU = new com.bytedance.adsdk.ugeno.aGH.eli.eli();
        if (this.ui instanceof com.bytedance.adsdk.ugeno.core.eli.DbA) {
            throw null;
        }
        this.Os = eli(eliVar, (com.bytedance.adsdk.ugeno.DbA.Os<View>) null);
        nGm ngm2 = this.MGA;
        if (ngm2 != null) {
            ngm2.DbA();
            this.Os.eli(this.MGA);
        }
        eli(this.Os);
        return this.Os;
    }

    public com.bytedance.adsdk.ugeno.DbA.Os<View> eli(kb.eli eliVar, com.bytedance.adsdk.ugeno.DbA.Os<View> os) {
        eli.C0117eli c0117eli;
        List<kb.eli> Os;
        if (!kb.aGH(eliVar)) {
            return null;
        }
        String Os2 = eliVar.Os();
        DbA eli = aGH.eli(Os2);
        DbA dbA = eli;
        if (eli == null) {
            this.nn = true;
            if (this.Dfc == null) {
                this.Dfc = new ArrayList();
            }
            this.Dfc.add(Os2);
            Os2 = "View";
            eliVar.eli("View");
            DbA eli2 = aGH.eli("View");
            Log.d("UGTemplateEngine", "unknown component; use view widget");
            dbA = eli2;
            if (eli2 == null) {
                Log.d("UGTemplateEngine", "not found component ".concat(String.valueOf("View")));
                return null;
            }
        }
        com.bytedance.adsdk.ugeno.DbA.Os eli3 = dbA.eli(this.eli);
        if (eli3 == null) {
            return null;
        }
        JSONObject aGH = eliVar.aGH();
        eli3.kb(com.bytedance.adsdk.ugeno.Os.DbA.eli(eliVar.eli(), this.DbA));
        eli3.wC(Os2);
        eli3.Os(aGH);
        eli3.eli(eliVar);
        eli3.DbA(this.DbA);
        kb kbVar = this.wC;
        if (kbVar == null) {
            eli3.eli(true);
        } else {
            eli3.eli(kbVar.aGH());
        }
        eli3.eli(this.aAs);
        eli3.eli(this.NU);
        Iterator<String> keys = aGH.keys();
        if (os instanceof com.bytedance.adsdk.ugeno.DbA.eli) {
            com.bytedance.adsdk.ugeno.DbA.eli eliVar2 = (com.bytedance.adsdk.ugeno.DbA.eli) os;
            c0117eli = eliVar2.aAs();
            eli3.eli(eliVar2);
        } else {
            c0117eli = null;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            String eli4 = com.bytedance.adsdk.ugeno.Os.DbA.eli(aGH.optString(next), this.DbA);
            eli3.eli(next, eli4);
            if (this.QX != null) {
                throw null;
            }
            if (c0117eli != null) {
                c0117eli.eli(this.eli, next, eli4);
            }
        }
        if (c0117eli != null) {
            eli3.eli(c0117eli.eli());
        }
        if (eli3 instanceof com.bytedance.adsdk.ugeno.DbA.eli) {
            List<kb.eli> ui = eliVar.ui();
            if (ui == null || ui.size() <= 0) {
                if (TextUtils.equals(eli3.Cp(), "RecyclerLayout") && (Os = this.wC.Os()) != null && Os.size() > 0) {
                    Iterator<kb.eli> it = Os.iterator();
                    while (it.hasNext()) {
                        com.bytedance.adsdk.ugeno.DbA.Os<View> eli5 = eli(it.next(), (com.bytedance.adsdk.ugeno.DbA.Os<View>) eli3);
                        if (eli5 != null && eli5.dZ()) {
                            ((com.bytedance.adsdk.ugeno.DbA.eli) eli3).eli(eli5);
                        }
                    }
                }
                return eli3;
            }
            if (TextUtils.equals(eli3.Cp(), "Swiper") && ui.size() != 1) {
                Log.e("UGTemplateEngine", "Swiper must be only one widget");
            }
            try {
                Collections.sort(ui, new Comparator<kb.eli>() { // from class: com.bytedance.adsdk.ugeno.core.nlS.1
                    @Override // java.util.Comparator
                    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
                    public int compare(kb.eli eliVar3, kb.eli eliVar4) {
                        return eliVar3.aGH().optInt(C3207n2.u, 0) - eliVar4.aGH().optInt(C3207n2.u, 0);
                    }
                });
            } catch (Throwable unused) {
            }
            Iterator<kb.eli> it2 = ui.iterator();
            while (it2.hasNext()) {
                com.bytedance.adsdk.ugeno.DbA.Os<View> eli6 = eli(it2.next(), (com.bytedance.adsdk.ugeno.DbA.Os<View>) eli3);
                if (eli6 != null && !eli6.TfR()) {
                    ((com.bytedance.adsdk.ugeno.DbA.eli) eli3).eli(eli6, eli6.VM());
                }
            }
        }
        this.Os = eli3;
        return eli3;
    }

    public com.bytedance.adsdk.ugeno.DbA.Os<View> eli(JSONObject jSONObject) {
        nGm ngm = this.MGA;
        if (ngm != null) {
            ngm.eli();
        }
        kb kbVar = new kb(jSONObject, this.DbA);
        this.wC = kbVar;
        if (this.ui instanceof com.bytedance.adsdk.ugeno.core.eli.DbA) {
            kbVar.DbA();
            throw null;
        }
        this.Os = DbA(kbVar.eli(), null);
        nGm ngm2 = this.MGA;
        if (ngm2 != null) {
            ngm2.DbA();
            this.Os.eli(this.MGA);
        }
        return this.Os;
    }

    public com.bytedance.adsdk.ugeno.DbA.Os<View> DbA(kb.eli eliVar, com.bytedance.adsdk.ugeno.DbA.Os<View> os) {
        List<kb.eli> Os;
        eli.C0117eli c0117eli = null;
        if (!kb.aGH(eliVar)) {
            return null;
        }
        String Os2 = eliVar.Os();
        DbA eli = aGH.eli(Os2);
        if (eli == null) {
            Log.d("UGTemplateEngine", "not found component ".concat(String.valueOf(Os2)));
            this.nn = true;
            if (this.Dfc == null) {
                this.Dfc = new ArrayList();
            }
            this.Dfc.add(Os2);
            return null;
        }
        com.bytedance.adsdk.ugeno.DbA.Os eli2 = eli.eli(this.eli);
        if (eli2 == null) {
            return null;
        }
        eli2.kb(com.bytedance.adsdk.ugeno.Os.DbA.eli(eliVar.eli(), this.DbA));
        eli2.wC(Os2);
        eli2.Os(eliVar.aGH());
        eli2.eli(eliVar);
        eli2.eli(this.aAs);
        if (os instanceof com.bytedance.adsdk.ugeno.DbA.eli) {
            com.bytedance.adsdk.ugeno.DbA.eli eliVar2 = (com.bytedance.adsdk.ugeno.DbA.eli) os;
            eli2.eli(eliVar2);
            c0117eli = eliVar2.aAs();
        }
        Iterator<String> keys = eliVar.aGH().keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String eli3 = com.bytedance.adsdk.ugeno.Os.DbA.eli(eliVar.aGH().optString(next), this.DbA);
            eli2.eli(next, eli3);
            if (c0117eli != null) {
                c0117eli.eli(this.eli, next, eli3);
            }
        }
        if (eli2 instanceof com.bytedance.adsdk.ugeno.DbA.eli) {
            List<kb.eli> ui = eliVar.ui();
            if (ui == null || ui.size() <= 0) {
                if (TextUtils.equals(eli2.Cp(), "RecyclerLayout") && (Os = this.wC.Os()) != null && Os.size() > 0) {
                    Iterator<kb.eli> it = Os.iterator();
                    while (it.hasNext()) {
                        com.bytedance.adsdk.ugeno.DbA.Os<View> DbA = DbA(it.next(), eli2);
                        if (DbA != null && DbA.dZ()) {
                            ((com.bytedance.adsdk.ugeno.DbA.eli) eli2).eli(DbA);
                        }
                    }
                }
                return eli2;
            }
            if (TextUtils.equals(eli2.Cp(), "Swiper") && ui.size() != 1) {
                Log.e("UGTemplateEngine", "Swiper must be only one widget");
            }
            Iterator<kb.eli> it2 = ui.iterator();
            while (it2.hasNext()) {
                com.bytedance.adsdk.ugeno.DbA.Os<View> DbA2 = DbA(it2.next(), eli2);
                if (DbA2 != null && DbA2.dZ()) {
                    ((com.bytedance.adsdk.ugeno.DbA.eli) eli2).eli(DbA2);
                }
            }
        }
        if (c0117eli != null) {
            eli2.eli(c0117eli.eli());
        }
        this.Os = eli2;
        return eli2;
    }

    public void DbA(JSONObject jSONObject) {
        nGm ngm = this.MGA;
        if (ngm != null) {
            ngm.Os();
        }
        this.DbA = jSONObject;
        eli(this.Os, jSONObject);
        eli(this.Os);
        if (this.MGA != null) {
            dV dVVar = new dV();
            dVVar.eli(0);
            dVVar.eli(this.Os);
            this.MGA.eli(dVVar);
        }
    }

    public void eli(com.bytedance.adsdk.ugeno.DbA.Os os, JSONObject jSONObject) {
        if (os == null) {
            return;
        }
        if (os instanceof com.bytedance.adsdk.ugeno.DbA.eli) {
            os.eli(jSONObject);
            List<com.bytedance.adsdk.ugeno.DbA.Os<View>> FC = ((com.bytedance.adsdk.ugeno.DbA.eli) os).FC();
            if (FC == null || FC.size() <= 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.DbA.Os<View>> it = FC.iterator();
            while (it.hasNext()) {
                eli(it.next(), jSONObject);
            }
            return;
        }
        os.eli(jSONObject);
    }

    private void eli(com.bytedance.adsdk.ugeno.DbA.Os<View> os) {
        List<com.bytedance.adsdk.ugeno.DbA.Os<View>> FC;
        if (os == null) {
            return;
        }
        JSONObject ujq = os.ujq();
        Iterator<String> keys = ujq.keys();
        com.bytedance.adsdk.ugeno.DbA.eli qj = os.qj();
        eli.C0117eli aAs = qj != null ? qj.aAs() : null;
        DbA(os);
        while (keys.hasNext()) {
            String next = keys.next();
            String eli = com.bytedance.adsdk.ugeno.Os.DbA.eli(ujq.optString(next), this.DbA);
            os.eli(next, eli);
            if (aAs != null) {
                aAs.eli(this.eli, next, eli);
            }
        }
        os.eli(this.aGH);
        os.eli(this.ui);
        os.eli(this.kb);
        FC fc = this.QX;
        if (fc != null) {
            os.eli(fc);
        }
        ui uiVar = this.aqO;
        if (uiVar != null) {
            os.eli(uiVar);
        }
        if ((os instanceof com.bytedance.adsdk.ugeno.DbA.eli) && (FC = ((com.bytedance.adsdk.ugeno.DbA.eli) os).FC()) != null && FC.size() > 0) {
            Iterator<com.bytedance.adsdk.ugeno.DbA.Os<View>> it = FC.iterator();
            while (it.hasNext()) {
                eli(it.next());
            }
        }
        if (aAs != null) {
            os.eli(aAs.eli());
        }
        os.DbA();
    }

    private void DbA(com.bytedance.adsdk.ugeno.DbA.Os os) {
        try {
            if (!os.oWW() || os.GB() == null || os.GB().MGA() == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("i18n", os.GB().MGA());
            this.DbA.put("xNode", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void eli(Dfc dfc) {
        com.bytedance.adsdk.ugeno.core.eli.eli ui = com.bytedance.adsdk.ugeno.ui.eli().ui();
        if (ui == null) {
            this.ui = dfc;
        } else {
            if (ui.eli(dfc) == null) {
                this.ui = dfc;
                return;
            }
            throw null;
        }
    }

    public void eli(aqO aqo) {
        this.kb = aqo;
    }

    public void eli(com.bytedance.adsdk.ugeno.DbA.Os os, String str, Object... objArr) {
        List<com.bytedance.adsdk.ugeno.DbA.Os<View>> FC;
        if (os == null) {
            return;
        }
        os.eli(str, objArr);
        if (!(os instanceof com.bytedance.adsdk.ugeno.DbA.eli) || (FC = ((com.bytedance.adsdk.ugeno.DbA.eli) os).FC()) == null || FC.isEmpty()) {
            return;
        }
        Iterator<com.bytedance.adsdk.ugeno.DbA.Os<View>> it = FC.iterator();
        while (it.hasNext()) {
            eli(it.next(), str, objArr);
        }
    }

    public boolean eli() {
        return this.nn;
    }

    public List<String> DbA() {
        return this.Dfc;
    }

    public void eli(ui uiVar) {
        this.aqO = uiVar;
    }
}
