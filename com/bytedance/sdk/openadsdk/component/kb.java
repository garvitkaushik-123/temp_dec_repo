package com.bytedance.sdk.openadsdk.component;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.utils.Ue;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.component.MGA;
import com.bytedance.sdk.openadsdk.core.CMM;
import com.bytedance.sdk.openadsdk.core.Xb;
import com.bytedance.sdk.openadsdk.core.bf;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.GB;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.model.ujq;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.core.wC;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.eU;
import com.google.android.gms.games.GamesActivityResultCodes;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class kb implements Ue.eli {
    private final CMM<com.bytedance.sdk.openadsdk.aGH.eli> DbA;
    private AdSlot MGA;
    private final MGA Os;
    private final Context eli;
    private PAGAppOpenAdLoadListener kb;
    private int wC;
    private final AtomicBoolean aGH = new AtomicBoolean(false);
    private int ui = 0;
    private volatile int FC = 0;
    private final GB aAs = new GB();

    public kb(Context context) {
        if (context != null) {
            this.eli = context.getApplicationContext();
        } else {
            this.eli = dV.eli();
        }
        this.DbA = dV.Os();
        this.Os = MGA.eli(this.eli);
    }

    public static kb eli(Context context) {
        return new kb(context);
    }

    public void eli(AdSlot adSlot, com.bytedance.sdk.openadsdk.common.MGA mga, int i) {
        if (mga == null) {
            return;
        }
        if (i <= 0) {
            i = 3500;
        }
        this.MGA = adSlot;
        this.aAs.eli = !TextUtils.isEmpty(adSlot.getBidAdm());
        if (mga instanceof PAGAppOpenAdLoadListener) {
            this.kb = (PAGAppOpenAdLoadListener) mga;
        }
        this.ui = eli(this.MGA);
        this.wC = i;
        this.aAs.eli(eU.DbA());
        if (this.aAs.eli) {
            DbA(this.MGA);
        } else {
            new Ue(nn.DbA().getLooper(), this).sendEmptyMessageDelayed(1, i);
            eli();
        }
    }

    private void DbA(AdSlot adSlot) {
        this.FC = 1;
        if (com.bytedance.sdk.openadsdk.utils.DbA.eli()) {
            Os(adSlot);
        } else {
            aGH(adSlot);
        }
    }

    private void Os(final AdSlot adSlot) {
        final eU DbA = eU.DbA();
        ujq ujqVar = new ujq();
        ujqVar.du = this.aAs;
        ujqVar.aGH = 1;
        ujqVar.FC = 2;
        this.DbA.eli(adSlot, ujqVar, 3, (Xb) new bf() { // from class: com.bytedance.sdk.openadsdk.component.kb.1
            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(int i, String str) {
                kb.this.FC = 3;
                kb.this.eli(new com.bytedance.sdk.openadsdk.component.ui.DbA(2, 100, i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
                kb.this.eli(eliVar, os, adSlot, DbA);
            }
        });
    }

    private void aGH(final AdSlot adSlot) {
        final eU DbA = eU.DbA();
        ujq ujqVar = new ujq();
        ujqVar.du = this.aAs;
        ujqVar.aGH = 1;
        ujqVar.FC = 2;
        this.DbA.eli(adSlot, ujqVar, 3, new CMM.eli() { // from class: com.bytedance.sdk.openadsdk.component.kb.2
            @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(int i, String str) {
                kb.this.FC = 3;
                kb.this.eli(new com.bytedance.sdk.openadsdk.component.ui.DbA(2, 100, i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
                kb.this.eli(eliVar, os, adSlot, DbA);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(final com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os, AdSlot adSlot, eU eUVar) {
        this.FC = 2;
        if (eliVar == null || eliVar.aGH() == null || eliVar.aGH().size() == 0) {
            this.FC = 3;
            eli(new com.bytedance.sdk.openadsdk.component.ui.DbA(2, 100, 20001, wC.eli(20001)));
            os.eli(-3);
            os.Os(3);
            com.bytedance.sdk.openadsdk.core.model.Os.eli(os);
            return;
        }
        final ev evVar = eliVar.aGH().get(0);
        long TfR = evVar.TfR();
        this.aAs.DbA = TfR;
        boolean kb = ev.kb(evVar);
        if (evVar.gG()) {
            eli(new com.bytedance.sdk.openadsdk.component.ui.DbA(1, 100, evVar, eliVar));
            return;
        }
        if (kb || evVar.JF()) {
            eli(new com.bytedance.sdk.openadsdk.component.ui.DbA(1, 100, evVar, eliVar));
            if (ev.ui(evVar)) {
                eli(evVar, adSlot, false, eliVar);
                return;
            } else {
                eli(evVar, false, eliVar);
                return;
            }
        }
        if (ev.ui(evVar)) {
            int aAs = dV.aGH().aAs();
            if (aAs == 1 || aAs == 3) {
                this.aAs.DbA = -1L;
                this.aAs.eli(3);
                eli(new com.bytedance.sdk.openadsdk.component.ui.DbA(1, 100, evVar, eliVar));
                eli(evVar, adSlot, false, eliVar);
                return;
            }
            eli(evVar, adSlot, !this.aAs.eli, eliVar);
            if (this.aAs.eli) {
                com.bytedance.sdk.openadsdk.Dfc.Os.eli(evVar, eUVar.aGH());
                new Object[]{"onAdLoad: invoke callback after ", Long.valueOf(TfR), "ms for bidding"};
                if (TfR == 0) {
                    this.aAs.eli(2);
                    eli(new com.bytedance.sdk.openadsdk.component.ui.DbA(1, 100, evVar, eliVar));
                    return;
                } else {
                    nn.DbA().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.kb.3
                        @Override // java.lang.Runnable
                        public void run() {
                            kb.this.aAs.eli(2);
                            kb.this.eli(new com.bytedance.sdk.openadsdk.component.ui.DbA(1, 100, evVar, eliVar));
                        }
                    }, TfR);
                    return;
                }
            }
            return;
        }
        this.aAs.DbA = -1L;
        this.aAs.eli(3);
        eli(new com.bytedance.sdk.openadsdk.component.ui.DbA(1, 100, evVar, eliVar));
        eli(evVar, false, eliVar);
    }

    private void eli() {
        cyF.DbA(new com.bytedance.sdk.component.wC.wC("tryGetAppOpenAdFromCache") { // from class: com.bytedance.sdk.openadsdk.component.kb.4
            @Override // java.lang.Runnable
            public void run() {
                if (com.bytedance.sdk.openadsdk.utils.DbA.eli()) {
                    kb.this.DbA();
                } else {
                    kb.this.Os();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA() {
        final eU DbA = eU.DbA();
        ujq ujqVar = new ujq();
        ujqVar.du = this.aAs;
        ujqVar.aGH = 1;
        ujqVar.FC = 2;
        this.FC = 1;
        this.DbA.eli(this.MGA, ujqVar, 3, (Xb) new bf() { // from class: com.bytedance.sdk.openadsdk.component.kb.5
            boolean eli = false;

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.Xb
            public String eli() {
                return kb.this.Os.Os(kb.this.ui);
            }

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.Xb
            public boolean eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
                ev MGA;
                if (eliVar != null && eliVar.ui() && (MGA = eliVar.MGA()) != null) {
                    boolean ui = ev.ui(MGA);
                    if (MGA.gG() || !ui) {
                        this.eli = true;
                    } else if (!TextUtils.isEmpty(kb.this.Os.eli(MGA))) {
                        this.eli = true;
                    } else {
                        this.eli = false;
                        com.bytedance.sdk.openadsdk.component.aGH.eli.DbA(eliVar.MGA());
                    }
                    com.bytedance.sdk.openadsdk.core.du.Os.aGH.eli(MGA);
                }
                return this.eli;
            }

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(int i, String str) {
                kb.this.FC = 3;
                kb.this.eli(new com.bytedance.sdk.openadsdk.component.ui.DbA(2, 100, i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.core.bf, com.bytedance.sdk.openadsdk.core.CMM.eli
            public void eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, com.bytedance.sdk.openadsdk.core.model.Os os) {
                if (this.eli) {
                    kb.this.eli(new com.bytedance.sdk.openadsdk.component.ui.DbA(1, 101, eliVar.MGA(), (com.bytedance.sdk.openadsdk.core.model.eli) null));
                } else {
                    kb kbVar = kb.this;
                    kbVar.eli(eliVar, os, kbVar.MGA, DbA);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os() {
        ev aGH = this.Os.aGH(this.ui);
        if (aGH != null) {
            if (aGH.XU() == null) {
                aGH.eli(this.MGA);
            }
            com.bytedance.sdk.openadsdk.core.du.Os.aGH.eli(aGH);
            boolean ui = ev.ui(aGH);
            if (aGH.gG() || !ui) {
                eli(new com.bytedance.sdk.openadsdk.component.ui.DbA(1, 101, aGH, (com.bytedance.sdk.openadsdk.core.model.eli) null));
                return;
            } else if (!TextUtils.isEmpty(this.Os.eli(aGH))) {
                eli(new com.bytedance.sdk.openadsdk.component.ui.DbA(1, 101, aGH, (com.bytedance.sdk.openadsdk.core.model.eli) null));
                return;
            } else {
                eli(false);
                com.bytedance.sdk.openadsdk.component.aGH.eli.DbA(aGH);
                return;
            }
        }
        eli(false);
    }

    private void eli(boolean z) {
        if (z) {
            this.Os.MGA(this.ui);
        }
        DbA(this.MGA);
    }

    private void eli(final ev evVar, AdSlot adSlot, final boolean z, final com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        this.Os.eli(evVar, adSlot, this.aAs, new MGA.DbA() { // from class: com.bytedance.sdk.openadsdk.component.kb.6
            @Override // com.bytedance.sdk.openadsdk.component.MGA.DbA
            public void eli() {
                Log.d("TTAppOpenAdLoadManager", "preLoadSuccess: video load success");
                if (z) {
                    kb.this.FC = 4;
                    com.bytedance.sdk.openadsdk.component.ui.DbA dbA = new com.bytedance.sdk.openadsdk.component.ui.DbA(1, 100, evVar, eliVar);
                    dbA.eli(true);
                    kb.this.eli(dbA);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.MGA.DbA
            public void eli(int i, String str) {
                if (z) {
                    kb.this.FC = 5;
                    kb.this.eli(new com.bytedance.sdk.openadsdk.component.ui.DbA(2, 100, GamesActivityResultCodes.RESULT_LICENSE_FAILED, wC.eli(GamesActivityResultCodes.RESULT_LICENSE_FAILED)));
                }
            }
        });
    }

    private void eli(final ev evVar, final boolean z, final com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        this.Os.eli(evVar, this.aAs, new MGA.eli() { // from class: com.bytedance.sdk.openadsdk.component.kb.7
            @Override // com.bytedance.sdk.openadsdk.component.MGA.eli
            public void eli(com.bytedance.sdk.openadsdk.nGm.eli.DbA dbA) {
                Log.d("TTAppOpenAdLoadManager", "preLoadSuccess: image load success");
                if (z) {
                    kb.this.FC = 4;
                    com.bytedance.sdk.openadsdk.component.ui.DbA dbA2 = new com.bytedance.sdk.openadsdk.component.ui.DbA(1, 100, evVar, eliVar);
                    dbA2.eli(true);
                    kb.this.eli(dbA2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.MGA.eli
            public void eli() {
                Log.d("TTAppOpenAdLoadManager", "preLoadFail: image load fail");
                if (z) {
                    kb.this.FC = 5;
                    kb.this.eli(new com.bytedance.sdk.openadsdk.component.ui.DbA(2, 100, GamesActivityResultCodes.RESULT_LICENSE_FAILED, wC.eli(GamesActivityResultCodes.RESULT_LICENSE_FAILED)));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(com.bytedance.sdk.openadsdk.component.ui.DbA dbA) {
        int DbA = dbA.DbA();
        int Os = dbA.Os();
        if (this.aGH.get()) {
            return;
        }
        if (DbA != 1) {
            if (DbA == 2 || DbA == 3) {
                PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener = this.kb;
                if (pAGAppOpenAdLoadListener != null) {
                    pAGAppOpenAdLoadListener.onError(dbA.ui(), dbA.MGA());
                }
                this.aGH.set(true);
                if (DbA == 3) {
                    com.bytedance.sdk.openadsdk.component.aGH.eli.eli(this.FC, this.wC);
                    return;
                }
                return;
            }
            return;
        }
        if (Os == 100 && !this.aAs.eli) {
            this.Os.eli(new com.bytedance.sdk.openadsdk.component.ui.eli(this.ui, dbA.aGH(), dbA.eli()));
        }
        if (this.kb != null) {
            this.kb.onAdLoaded(new aGH(this.eli, dbA.aGH(), Os == 101, this.MGA));
        }
        this.aGH.set(true);
        if (Os == 101) {
            com.bytedance.sdk.openadsdk.component.aGH.eli.eli(dbA.aGH(), this.aAs.eli().aGH());
        } else if (Os == 100) {
            com.bytedance.sdk.openadsdk.component.aGH.eli.eli(dbA.aGH(), 0, this.aAs);
        }
    }

    public int eli(AdSlot adSlot) {
        try {
            return Integer.parseInt(adSlot.getCodeId());
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.component.utils.Ue.eli
    public void eli(Message message) {
        if (message.what != 1 || this.aGH.get()) {
            return;
        }
        eli(new com.bytedance.sdk.openadsdk.component.ui.DbA(3, 102, 10002, wC.eli(10002)));
    }
}
