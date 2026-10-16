package com.bytedance.sdk.component.MGA.eli.eli;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.MGA.eli.eli.eli.eli.kb;
import com.bytedance.sdk.component.MGA.eli.wC;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class Os implements aGH {
    private com.bytedance.sdk.component.MGA.eli.eli.eli.eli.eli DbA;
    private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli FC;
    private com.bytedance.sdk.component.MGA.eli.eli.eli.eli.ui MGA;
    private com.bytedance.sdk.component.MGA.eli.eli.eli.eli.DbA Os;
    private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli aAs;
    private kb aGH;
    private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli du;
    private com.bytedance.sdk.component.MGA.eli.eli.eli.eli.aGH eli;
    private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli kb;
    private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli nlS;
    private com.bytedance.sdk.component.MGA.eli.eli.eli.eli.MGA ui;
    private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli wC;

    public Os() {
        Context MGA = wC.kb().MGA();
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.eli()) {
            this.kb = wC.kb().nlS();
            this.eli = new com.bytedance.sdk.component.MGA.eli.eli.eli.eli.aGH(MGA, this.kb);
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.ui()) {
            if (wC.kb().aAs() != null) {
                this.FC = wC.kb().aAs();
            } else {
                this.FC = wC.kb().NU();
            }
            this.Os = new com.bytedance.sdk.component.MGA.eli.eli.eli.eli.DbA(MGA, this.FC);
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.DbA()) {
            this.wC = wC.kb().NU();
            this.DbA = new com.bytedance.sdk.component.MGA.eli.eli.eli.eli.eli(MGA, this.wC);
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.Os()) {
            this.aAs = wC.kb().NU();
            this.aGH = new kb(MGA, this.aAs);
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.aGH()) {
            this.du = wC.kb().nn();
            this.ui = new com.bytedance.sdk.component.MGA.eli.eli.eli.eli.MGA(MGA, this.du);
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.MGA()) {
            this.nlS = wC.kb().Dfc();
            this.MGA = new com.bytedance.sdk.component.MGA.eli.eli.eli.eli.ui(MGA, this.nlS);
        }
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.aGH
    public void eli(com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar, int i) {
        if (eliVar == null) {
            return;
        }
        try {
            eliVar.DbA(System.currentTimeMillis());
            if (eliVar.aGH() == 0 && eliVar.ui() == 1) {
                if (com.bytedance.sdk.component.MGA.eli.DbA.eli.eli()) {
                    this.eli.eli(eliVar);
                    return;
                }
                return;
            }
            if (eliVar.aGH() == 3 && eliVar.ui() == 2) {
                if (com.bytedance.sdk.component.MGA.eli.DbA.eli.ui()) {
                    this.Os.eli(eliVar);
                    return;
                }
                return;
            }
            if (eliVar.aGH() == 0 && eliVar.ui() == 2) {
                if (com.bytedance.sdk.component.MGA.eli.DbA.eli.DbA()) {
                    this.DbA.eli(eliVar);
                    return;
                }
                return;
            }
            if (eliVar.aGH() == 1 && eliVar.ui() == 2) {
                if (com.bytedance.sdk.component.MGA.eli.DbA.eli.Os()) {
                    this.aGH.eli(eliVar);
                }
            } else if (eliVar.aGH() == 1 && eliVar.ui() == 3) {
                if (com.bytedance.sdk.component.MGA.eli.DbA.eli.aGH()) {
                    this.ui.eli(eliVar);
                }
            } else if (eliVar.aGH() == 2 && eliVar.ui() == 3 && com.bytedance.sdk.component.MGA.eli.DbA.eli.MGA()) {
                this.MGA.eli(eliVar);
            }
        } catch (Throwable unused) {
            com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.nro(), 1);
        }
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.aGH
    public void eli(int i, List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list) {
        if (list == null || list.size() == 0 || list.get(0) == null) {
            return;
        }
        com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar = list.get(0);
        if (i == 200 || i == -1) {
            com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.oc(), list.size());
            if (i != 200) {
                com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.Yw(), list.size());
            }
            if (eliVar.aGH() == 0 && eliVar.ui() == 1) {
                if (com.bytedance.sdk.component.MGA.eli.DbA.eli.eli()) {
                    this.eli.DbA(list);
                    return;
                }
                return;
            }
            if (eliVar.aGH() == 3 && eliVar.ui() == 2) {
                if (com.bytedance.sdk.component.MGA.eli.DbA.eli.ui()) {
                    this.Os.DbA(list);
                    return;
                }
                return;
            }
            if (eliVar.aGH() == 0 && eliVar.ui() == 2) {
                if (com.bytedance.sdk.component.MGA.eli.DbA.eli.DbA()) {
                    this.DbA.DbA(list);
                    return;
                }
                return;
            }
            if (eliVar.aGH() == 1 && eliVar.ui() == 2) {
                if (com.bytedance.sdk.component.MGA.eli.DbA.eli.Os()) {
                    this.aGH.DbA(list);
                }
            } else if (eliVar.aGH() == 1 && eliVar.ui() == 3) {
                if (com.bytedance.sdk.component.MGA.eli.DbA.eli.aGH()) {
                    this.ui.DbA(list);
                }
            } else if (eliVar.aGH() == 2 && eliVar.ui() == 3 && com.bytedance.sdk.component.MGA.eli.DbA.eli.MGA()) {
                this.MGA.DbA(list);
            }
        }
    }

    public List<com.bytedance.sdk.component.MGA.eli.aGH.eli> DbA(com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar, int i) {
        if (eliVar.aGH() == 0 && eliVar.ui() == 1 && com.bytedance.sdk.component.MGA.eli.DbA.eli.eli()) {
            if (this.kb.DbA() <= i) {
                return null;
            }
            List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli = this.eli.eli(this.kb.DbA() - i, "_id");
            if (eli != null && eli.size() != 0) {
                com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.Ue(), 1);
            }
            return eli;
        }
        if (eliVar.aGH() == 3 && eliVar.ui() == 2 && com.bytedance.sdk.component.MGA.eli.DbA.eli.ui()) {
            if (this.FC.DbA() > i) {
                return this.Os.eli(this.FC.DbA() - i, "_id");
            }
        } else if (eliVar.aGH() == 0 && eliVar.ui() == 2 && com.bytedance.sdk.component.MGA.eli.DbA.eli.DbA()) {
            if (this.wC.DbA() > i) {
                List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli2 = this.DbA.eli(this.wC.DbA() - i, "_id");
                if (eli2 != null && eli2.size() != 0) {
                    com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.KM(), 1);
                }
                return eli2;
            }
        } else if (eliVar.aGH() == 1 && eliVar.ui() == 2 && com.bytedance.sdk.component.MGA.eli.DbA.eli.Os()) {
            if (this.aAs.DbA() > i) {
                List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli3 = this.aGH.eli(this.aAs.DbA() - i, "_id");
                if (eli3 != null && eli3.size() != 0) {
                    com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.VM(), 1);
                }
                return eli3;
            }
        } else if (eliVar.aGH() == 1 && eliVar.ui() == 3 && com.bytedance.sdk.component.MGA.eli.DbA.eli.aGH()) {
            if (this.du.DbA() > i) {
                List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli4 = this.ui.eli(this.du.DbA() - i, "_id");
                if (eli4 != null && eli4.size() != 0) {
                    com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.GB(), 1);
                }
                return eli4;
            }
        } else if (eliVar.aGH() == 2 && eliVar.ui() == 3 && com.bytedance.sdk.component.MGA.eli.DbA.eli.MGA() && this.nlS.DbA() > i) {
            return this.MGA.eli(this.nlS.DbA() - i, "_id");
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.aGH
    public List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli(int i, int i2, List<String> list) {
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.eli()) {
            List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli = this.eli.eli("_id");
            if (eli(eli, list)) {
                eli.size();
                com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.ev(), 1);
                return eli;
            }
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.ui()) {
            List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli2 = this.Os.eli("_id");
            if (eli(eli2, list)) {
                eli2.size();
                return eli2;
            }
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.DbA()) {
            List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli3 = this.DbA.eli("_id");
            if (eli(eli3, list)) {
                eli3.size();
                com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.Vy(), 1);
                return eli3;
            }
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.Os()) {
            List<com.bytedance.sdk.component.MGA.eli.aGH.eli> DbA = this.aGH.DbA("_id");
            if (eli(DbA, list)) {
                DbA.size();
                com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.gG(), 1);
                return DbA;
            }
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.aGH()) {
            List<com.bytedance.sdk.component.MGA.eli.aGH.eli> DbA2 = this.ui.DbA("_id");
            if (eli(DbA2, list)) {
                DbA2.size();
                com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.ujq(), 1);
                return DbA2;
            }
        }
        if (!com.bytedance.sdk.component.MGA.eli.DbA.eli.MGA()) {
            return null;
        }
        List<com.bytedance.sdk.component.MGA.eli.aGH.eli> DbA3 = this.MGA.DbA("_id");
        if (!eli(DbA3, list)) {
            return null;
        }
        DbA3.size();
        return DbA3;
    }

    private boolean eli(List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list, List<String> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            try {
                Iterator<com.bytedance.sdk.component.MGA.eli.aGH.eli> it = list.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.MGA.eli.aGH.eli next = it.next();
                    if (next != null) {
                        String Os = next.Os();
                        if (!TextUtils.isEmpty(Os) && list2.contains(Os)) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        return (list == null || list.isEmpty()) ? false : true;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.aGH
    public boolean eli(int i, boolean z) {
        com.bytedance.sdk.component.MGA.eli.eli.eli.eli.ui uiVar;
        com.bytedance.sdk.component.MGA.eli.eli.eli.eli.MGA mga;
        kb kbVar;
        com.bytedance.sdk.component.MGA.eli.eli.eli.eli.eli eliVar;
        com.bytedance.sdk.component.MGA.eli.eli.eli.eli.DbA dbA;
        com.bytedance.sdk.component.MGA.eli.eli.eli.eli.aGH agh;
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.eli() && (agh = this.eli) != null && agh.eli(i)) {
            com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.nn(), 1);
            return true;
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.ui() && (dbA = this.Os) != null && dbA.eli(i)) {
            return true;
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.DbA() && (eliVar = this.DbA) != null && eliVar.eli(i)) {
            com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.Dfc(), 1);
            return true;
        }
        if (com.bytedance.sdk.component.MGA.eli.DbA.eli.Os() && (kbVar = this.aGH) != null && kbVar.eli(i)) {
            com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.aqO(), 1);
            return true;
        }
        if (!com.bytedance.sdk.component.MGA.eli.DbA.eli.aGH() || (mga = this.ui) == null || !mga.eli(i)) {
            return com.bytedance.sdk.component.MGA.eli.DbA.eli.MGA() && (uiVar = this.MGA) != null && uiVar.eli(i);
        }
        com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.dV(), 1);
        return true;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.aGH
    public void eli(int i, long j) {
        com.bytedance.sdk.component.MGA.eli.eli.eli.eli.aGH agh = this.eli;
        if (agh != null) {
            agh.eli(i, j);
        }
        com.bytedance.sdk.component.MGA.eli.eli.eli.eli.DbA dbA = this.Os;
        if (dbA != null) {
            dbA.eli(i, j);
        }
        com.bytedance.sdk.component.MGA.eli.eli.eli.eli.eli eliVar = this.DbA;
        if (eliVar != null) {
            eliVar.eli(i, j);
        }
        kb kbVar = this.aGH;
        if (kbVar != null) {
            kbVar.eli(i, j);
        }
        com.bytedance.sdk.component.MGA.eli.eli.eli.eli.MGA mga = this.ui;
        if (mga != null) {
            mga.eli(i, j);
        }
        com.bytedance.sdk.component.MGA.eli.eli.eli.eli.ui uiVar = this.MGA;
        if (uiVar != null) {
            uiVar.eli(i, j);
        }
    }
}
