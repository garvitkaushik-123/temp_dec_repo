package com.bytedance.sdk.component.MGA.eli.eli;

import com.bytedance.sdk.component.MGA.eli.eli.DbA.kb;
import com.bytedance.sdk.component.MGA.eli.wC;
import java.util.List;
import java.util.Queue;

/* loaded from: classes3.dex */
public class MGA implements aGH {
    private com.bytedance.sdk.component.MGA.eli.eli.DbA.ui DbA;
    private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli FC;
    private com.bytedance.sdk.component.MGA.eli.eli.DbA.Os MGA;
    private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli NU;
    private com.bytedance.sdk.component.MGA.eli.eli.DbA.eli Os;
    private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli aAs;
    private com.bytedance.sdk.component.MGA.eli.eli.DbA.DbA aGH;
    private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli du;
    ui eli = wC.kb().aGH();
    private com.bytedance.sdk.component.MGA.eli.eli.DbA.MGA kb;
    private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli nlS;
    private Queue<String> nn;
    private kb ui;
    private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli wC;

    @Override // com.bytedance.sdk.component.MGA.eli.eli.aGH
    public void eli(int i, long j) {
    }

    public MGA(Queue<String> queue) {
        this.nn = queue;
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.eli()) {
            this.wC = wC.kb().nlS();
            this.DbA = new com.bytedance.sdk.component.MGA.eli.eli.DbA.ui(this.wC, queue);
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.ui()) {
            if (wC.kb().aAs() != null) {
                this.aAs = wC.kb().aAs();
            } else {
                this.aAs = wC.kb().NU();
            }
            this.aGH = new com.bytedance.sdk.component.MGA.eli.eli.DbA.DbA(this.aAs, queue);
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.DbA()) {
            this.FC = wC.kb().NU();
            this.Os = new com.bytedance.sdk.component.MGA.eli.eli.DbA.eli(this.FC, queue);
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.Os()) {
            this.du = wC.kb().NU();
            this.ui = new kb(this.du, queue);
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.aGH()) {
            this.nlS = wC.kb().nn();
            this.MGA = new com.bytedance.sdk.component.MGA.eli.eli.DbA.Os(this.nlS, queue);
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.MGA()) {
            this.NU = wC.kb().Dfc();
            this.kb = new com.bytedance.sdk.component.MGA.eli.eli.DbA.MGA(this.NU, queue);
        }
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.aGH
    public void eli(com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar, int i) {
        try {
            byte aGH = eliVar.aGH();
            byte ui = eliVar.ui();
            if (aGH == 0 && ui == 1 && com.bytedance.sdk.component.MGA.eli.DbA.eli.eli()) {
                this.DbA.eli(eliVar);
                return;
            }
            if (aGH == 3 && ui == 2 && com.bytedance.sdk.component.MGA.eli.DbA.eli.ui()) {
                this.aGH.eli(eliVar);
                return;
            }
            if (aGH == 0 && ui == 2 && com.bytedance.sdk.component.MGA.eli.DbA.eli.DbA()) {
                this.Os.eli(eliVar);
                return;
            }
            if (aGH == 1 && ui == 2 && com.bytedance.sdk.component.MGA.eli.DbA.eli.Os()) {
                this.ui.eli(eliVar);
                return;
            }
            if (aGH == 1 && ui == 3 && com.bytedance.sdk.component.MGA.eli.DbA.eli.aGH()) {
                this.MGA.eli(eliVar);
            } else if (aGH == 2 && ui == 3 && com.bytedance.sdk.component.MGA.eli.DbA.eli.MGA()) {
                this.kb.eli(eliVar);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.aGH
    public void eli(int i, List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list) {
        if (list == null || list.size() == 0 || list.get(0) == null) {
            return;
        }
        com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar = list.get(0);
        byte ui = eliVar.ui();
        byte aGH = eliVar.aGH();
        if (aGH == 0 && ui == 1 && com.bytedance.sdk.component.MGA.eli.DbA.eli.eli()) {
            this.DbA.eli(i, list);
            return;
        }
        if (aGH == 3 && ui == 2 && com.bytedance.sdk.component.MGA.eli.DbA.eli.ui()) {
            this.aGH.eli(i, list);
            return;
        }
        if (aGH == 0 && ui == 2 && com.bytedance.sdk.component.MGA.eli.DbA.eli.DbA()) {
            this.Os.eli(i, list);
            return;
        }
        if (aGH == 1 && ui == 2 && com.bytedance.sdk.component.MGA.eli.DbA.eli.Os()) {
            this.ui.eli(i, list);
            return;
        }
        if (aGH == 1 && ui == 3 && com.bytedance.sdk.component.MGA.eli.DbA.eli.aGH()) {
            this.MGA.eli(i, list);
        } else if (aGH == 2 && ui == 3 && com.bytedance.sdk.component.MGA.eli.DbA.eli.MGA()) {
            this.kb.eli(i, list);
        }
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.aGH
    public List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli(int i, int i2, List<String> list) {
        List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli;
        List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli2;
        List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli3;
        List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli4;
        List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli5;
        List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli6;
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.eli() && this.DbA.DbA(i, i2) && (eli6 = this.DbA.eli(i, i2)) != null && eli6.size() != 0) {
            com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.nGm(), 1);
            return eli6;
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.ui() && this.aGH.DbA(i, i2) && (eli5 = this.aGH.eli(i, i2)) != null && eli5.size() != 0) {
            return eli5;
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.DbA() && this.Os.DbA(i, i2) && (eli4 = this.Os.eli(i, i2)) != null && eli4.size() != 0) {
            com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.QX(), 1);
            return eli4;
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.Os() && this.ui.DbA(i, i2) && (eli3 = this.ui.eli(i, i2)) != null && eli3.size() != 0) {
            com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.Xb(), 1);
            return eli3;
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.aGH() && this.MGA.DbA(i, i2) && (eli2 = this.MGA.eli(i, i2)) != null && eli2.size() != 0) {
            com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.bf(), 1);
            return eli2;
        }
        if (!com.bytedance.sdk.component.MGA.eli.DbA.eli.MGA() || !this.kb.DbA(i, i2) || (eli = this.kb.eli(i, i2)) == null || eli.size() == 0) {
            return null;
        }
        return eli;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.aGH
    public boolean eli(int i, boolean z) {
        com.bytedance.sdk.component.MGA.eli.eli.DbA.MGA mga;
        com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar;
        com.bytedance.sdk.component.MGA.eli.eli.DbA.Os os;
        com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar2;
        kb kbVar;
        com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar3;
        com.bytedance.sdk.component.MGA.eli.eli.DbA.eli eliVar4;
        com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar5;
        com.bytedance.sdk.component.MGA.eli.eli.DbA.DbA dbA;
        com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar6;
        com.bytedance.sdk.component.MGA.eli.eli.DbA.ui uiVar;
        com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar7;
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.eli() && (uiVar = this.DbA) != null && (eliVar7 = this.wC) != null && uiVar.DbA(i, eliVar7.eli())) {
            return true;
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.ui() && (dbA = this.aGH) != null && (eliVar6 = this.aAs) != null && dbA.DbA(i, eliVar6.eli())) {
            return true;
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.DbA() && (eliVar4 = this.Os) != null && (eliVar5 = this.FC) != null && eliVar4.DbA(i, eliVar5.eli())) {
            return true;
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.Os() && (kbVar = this.ui) != null && (eliVar3 = this.du) != null && kbVar.DbA(i, eliVar3.eli())) {
            return true;
        }
        if (!com.bytedance.sdk.component.MGA.eli.DbA.eli.aGH() || (os = this.MGA) == null || (eliVar2 = this.nlS) == null || !os.DbA(i, eliVar2.eli())) {
            return com.bytedance.sdk.component.MGA.eli.DbA.eli.MGA() && (mga = this.kb) != null && (eliVar = this.NU) != null && mga.DbA(i, eliVar.eli());
        }
        return true;
    }
}
