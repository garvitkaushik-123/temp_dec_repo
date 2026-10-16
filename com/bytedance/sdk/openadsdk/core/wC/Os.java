package com.bytedance.sdk.openadsdk.core.wC;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.KM;
import com.bytedance.sdk.openadsdk.core.wC.ui;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class Os {
    private final Context DbA;
    private int FC;
    private int MGA;
    private eli Os;
    private com.bytedance.sdk.component.adexpress.DbA.Dfc aGH;
    com.bytedance.sdk.openadsdk.core.model.ev eli;
    private int kb;
    private Xb ui;
    private ScheduledFuture<?> wC;

    /* renamed from: com.bytedance.sdk.openadsdk.core.wC.Os$Os, reason: collision with other inner class name */
    interface InterfaceC0201Os {
        void DbA(String str);

        void eli();

        void eli(int i, int i2);

        void eli(String str);
    }

    public Os(Context context, Xb xb, com.bytedance.sdk.openadsdk.core.model.ev evVar, String str) {
        this.eli = evVar;
        this.DbA = context;
        this.ui = xb;
        eli(xb);
        this.Os = new eli(context, evVar, this.MGA, this.kb, str, this.FC);
    }

    private void eli(Xb xb) {
        com.bytedance.sdk.openadsdk.core.model.ev evVar = this.eli;
        if (evVar != null && evVar.nie()) {
            this.MGA = -1;
            this.kb = -1;
            return;
        }
        nGm eli2 = com.bytedance.sdk.openadsdk.core.Os.DbA.eli(xb.getExpectExpressWidth(), xb.getExpectExpressHeight());
        this.FC = eli2.eli;
        if (xb.getExpectExpressWidth() > 0 && xb.getExpectExpressHeight() > 0) {
            this.MGA = SSo.DbA(this.DbA, xb.getExpectExpressWidth());
            this.kb = SSo.DbA(this.DbA, xb.getExpectExpressHeight());
        } else {
            int Os = SSo.Os(this.DbA);
            this.MGA = Os;
            this.kb = Float.valueOf(Os / eli2.DbA).intValue();
        }
        int i = this.MGA;
        if (i <= 0 || i <= SSo.Os(this.DbA)) {
            return;
        }
        this.MGA = SSo.Os(this.DbA);
        this.kb = Float.valueOf(this.kb * (SSo.Os(this.DbA) / this.MGA)).intValue();
    }

    public void eli(com.bytedance.sdk.component.adexpress.DbA.Dfc dfc) {
        this.aGH = dfc;
    }

    public void eli() {
        com.bytedance.sdk.openadsdk.core.model.ev evVar = this.eli;
        if (evVar != null && evVar.nie()) {
            this.wC = cyF.eli().schedule(new DbA(this.Os.nlS), com.bytedance.sdk.openadsdk.core.dV.aGH().Vy(), TimeUnit.MILLISECONDS);
        }
        eli eliVar = this.Os;
        if (eliVar != null) {
            eliVar.eli(new com.bytedance.sdk.component.adexpress.DbA.kb() { // from class: com.bytedance.sdk.openadsdk.core.wC.Os.1
                @Override // com.bytedance.sdk.component.adexpress.DbA.kb
                public void eli(View view, com.bytedance.sdk.component.adexpress.DbA.nn nnVar) {
                    if (Os.this.ui == null || view == null) {
                        if (Os.this.aGH != null) {
                            Os.this.aGH.a_(106);
                        }
                    } else if (Os.this.aGH != null) {
                        Os.this.aGH.eli(Os.this.Os, nnVar);
                    }
                    Os.this.Os();
                }

                @Override // com.bytedance.sdk.component.adexpress.DbA.kb
                public void eli(int i, String str) {
                    if (Os.this.aGH != null) {
                        Os.this.aGH.a_(106);
                    }
                    Os.this.Os();
                }
            });
            View ui = this.Os.ui();
            this.ui.removeView(ui);
            if (ui.getParent() != null) {
                ((ViewGroup) ui.getParent()).removeView(ui);
            }
            this.ui.addView(ui, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        com.bytedance.sdk.component.adexpress.DbA.Dfc dfc = this.aGH;
        if (dfc != null) {
            dfc.a_(106);
        }
    }

    public void DbA() {
        eli eliVar = this.Os;
        if (eliVar != null) {
            eliVar.aGH();
            this.Os = null;
        }
        Os();
        this.aGH = null;
        this.ui = null;
    }

    public void eli(KM km) {
        eli eliVar = this.Os;
        if (eliVar != null) {
            eliVar.eli(km);
        }
    }

    public void eli(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        eli eliVar = this.Os;
        if (eliVar != null) {
            eliVar.eli(tTDislikeDialogAbstract);
        }
    }

    public void eli(String str) {
        eli eliVar = this.Os;
        if (eliVar != null) {
            eliVar.eli(str);
        }
    }

    public void eli(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
        eli eliVar = this.Os;
        if (eliVar != null) {
            eliVar.eli(pAGExpressAdWrapperListener);
        }
    }

    public static class eli implements com.bytedance.sdk.component.adexpress.DbA.aGH<View>, ui.DbA {
        private com.bytedance.sdk.openadsdk.Os.Os DbA;
        private PAGExpressAdWrapperListener Dfc;
        private com.bytedance.sdk.openadsdk.core.model.ev FC;
        private final int MGA;
        private int NU;
        private TTDislikeDialogAbstract Os;
        private final int aAs;
        private String aGH;
        private String du;
        AtomicBoolean eli = new AtomicBoolean(false);
        private final int kb;
        private ui nlS;
        private com.bytedance.sdk.component.adexpress.DbA.kb nn;
        private final Context ui;
        private FrameLayout wC;

        @Override // com.bytedance.sdk.component.adexpress.DbA.aGH
        public int Os() {
            return 5;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wC.ui.DbA
        public View eli() {
            return null;
        }

        public eli(Context context, com.bytedance.sdk.openadsdk.core.model.ev evVar, int i, int i2, String str, int i3) {
            this.du = str;
            if (evVar != null && evVar.nie()) {
                this.du = "fullscreen_interstitial_ad";
            }
            this.ui = context;
            this.MGA = i;
            this.kb = i2;
            this.FC = evVar;
            this.aAs = SSo.DbA(context, 3.0f);
            this.NU = i3;
            MGA();
        }

        private void MGA() {
            FrameLayout frameLayout = new FrameLayout(this.ui);
            this.wC = frameLayout;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(this.MGA, this.kb);
            }
            layoutParams.width = this.MGA;
            layoutParams.height = this.kb;
            layoutParams.gravity = 17;
            this.wC.setLayoutParams(layoutParams);
            ui wC = wC();
            this.wC.addView(wC);
            View kb = kb();
            this.wC.addView(kb);
            com.bytedance.sdk.openadsdk.core.model.ev evVar = this.FC;
            if (evVar != null && evVar.nie()) {
                wC.setBackgroundColor(-16777216);
                wC.eli(((Activity) this.ui).findViewById(com.bytedance.sdk.openadsdk.utils.aqO.QYI), FriendlyObstructionPurpose.OTHER);
            }
            wC.eli(kb, FriendlyObstructionPurpose.OTHER);
            Context context = this.ui;
            if (context == null || !(context instanceof Activity)) {
                return;
            }
            View findViewById = ((Activity) context).findViewById(com.bytedance.sdk.openadsdk.utils.aqO.Jt);
            if (findViewById != null) {
                wC.eli(findViewById, FriendlyObstructionPurpose.OTHER);
            }
            View findViewById2 = ((Activity) this.ui).findViewById(com.bytedance.sdk.openadsdk.utils.aqO.Mkx);
            if (findViewById2 != null) {
                wC.eli(findViewById2, FriendlyObstructionPurpose.OTHER);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.DbA.aGH
        public void eli(com.bytedance.sdk.component.adexpress.DbA.kb kbVar) {
            com.bytedance.sdk.openadsdk.core.model.ev evVar;
            if (this.eli.get()) {
                return;
            }
            if (this.ui == null || (evVar = this.FC) == null) {
                kbVar.eli(106, "material null");
                return;
            }
            this.nn = kbVar;
            if (TextUtils.isEmpty(evVar.cmk())) {
                kbVar.eli(106, "dsp data is null");
            } else {
                this.nlS.Xb();
            }
        }

        private View kb() {
            PAGLogoView createPAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(this.ui, this.FC);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            com.bytedance.sdk.openadsdk.core.model.ev evVar = this.FC;
            if (evVar != null && evVar.nie()) {
                layoutParams.leftMargin = SSo.DbA(this.ui, 20.0f);
                layoutParams.bottomMargin = SSo.DbA(this.ui, 20.0f);
                layoutParams.gravity = 8388691;
            } else {
                layoutParams.topMargin = this.aAs;
                layoutParams.leftMargin = this.aAs;
            }
            createPAGLogoViewByMaterial.setLayoutParams(layoutParams);
            createPAGLogoViewByMaterial.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.wC.Os.eli.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebsiteActivity.eli(eli.this.ui, eli.this.FC, eli.this.du);
                }
            });
            return createPAGLogoViewByMaterial;
        }

        private ui wC() {
            ui DbA = aGH.eli().DbA();
            this.nlS = DbA;
            if (DbA == null) {
                this.nlS = new ui(this.ui);
            }
            aGH.eli().Os(this.nlS);
            this.nlS.eli(this.FC, this, this.du);
            this.nlS.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return this.nlS;
        }

        @Override // com.bytedance.sdk.component.adexpress.DbA.aGH
        public View ui() {
            return this.wC;
        }

        public void aGH() {
            this.wC = null;
            this.DbA = null;
            this.Os = null;
            this.nn = null;
            this.FC = null;
            ui uiVar = this.nlS;
            if (uiVar != null) {
                uiVar.aqO();
                aGH.eli().eli(this.nlS);
            }
            this.eli.set(true);
        }

        public void eli(KM km) {
            if (km instanceof com.bytedance.sdk.openadsdk.Os.Os) {
                this.DbA = (com.bytedance.sdk.openadsdk.Os.Os) km;
            }
        }

        public void eli(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
            com.bytedance.sdk.openadsdk.core.model.ev evVar;
            if (tTDislikeDialogAbstract != null && (evVar = this.FC) != null) {
                tTDislikeDialogAbstract.setMaterialMeta(evVar.eu(), this.FC.mS());
            }
            this.Os = tTDislikeDialogAbstract;
        }

        public void eli(String str) {
            this.aGH = str;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wC.ui.DbA
        public View DbA() {
            FrameLayout frameLayout = this.wC;
            if (frameLayout == null) {
                return null;
            }
            return (View) frameLayout.getParent();
        }

        @Override // com.bytedance.sdk.openadsdk.core.wC.ui.DbA
        public void eli(View view, int i) {
            PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.Dfc;
            if (pAGExpressAdWrapperListener != null) {
                pAGExpressAdWrapperListener.onAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wC.ui.DbA
        public void k_() {
            if (this.nn != null) {
                com.bytedance.sdk.component.adexpress.DbA.nn nnVar = new com.bytedance.sdk.component.adexpress.DbA.nn();
                nnVar.eli(true);
                nnVar.eli(SSo.Os(this.ui, this.MGA));
                nnVar.DbA(SSo.Os(this.ui, this.kb));
                this.nn.eli(this.wC, nnVar);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wC.ui.DbA
        public void eli(int i, int i2) {
            com.bytedance.sdk.component.adexpress.DbA.kb kbVar = this.nn;
            if (kbVar != null) {
                kbVar.eli(i, "render fail");
            }
        }

        public void eli(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
            this.Dfc = pAGExpressAdWrapperListener;
        }
    }

    private static class DbA implements Runnable {
        InterfaceC0201Os eli;

        public DbA(InterfaceC0201Os interfaceC0201Os) {
            this.eli = interfaceC0201Os;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC0201Os interfaceC0201Os = this.eli;
            if (interfaceC0201Os != null) {
                interfaceC0201Os.eli(107, 107);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os() {
        try {
            ScheduledFuture<?> scheduledFuture = this.wC;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.wC.cancel(false);
            this.wC = null;
        } catch (Throwable unused) {
        }
    }
}
