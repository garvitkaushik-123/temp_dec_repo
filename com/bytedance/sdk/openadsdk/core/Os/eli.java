package com.bytedance.sdk.openadsdk.core.Os;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.DbA.DbA;
import com.bytedance.sdk.openadsdk.core.Os.kb;
import com.bytedance.sdk.openadsdk.core.kb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.wC.QX;
import com.bytedance.sdk.openadsdk.core.wC.Xb;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.Uv;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.bytedance.sdk.openadsdk.utils.gG;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    protected AdSlot DbA;
    private boolean FC;
    private final Context MGA;
    private long QX;
    private com.bytedance.sdk.openadsdk.QX.eli.eli.MGA aAs;
    private ev aGH;
    private Xb du;
    protected aGH eli;
    private kb nlS;
    private boolean nn;
    private PAGBannerAdWrapperListener ui;
    private final boolean wC;
    private String Os = "banner_ad";
    private long kb = 0;
    private final AtomicBoolean NU = new AtomicBoolean(false);
    private final int Dfc = 1;
    private final int aqO = 0;
    private int dV = -1;
    private final View.OnAttachStateChangeListener nGm = new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.Os.eli.1
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (eli.this.dV == 0 || eli.this.FC) {
                return;
            }
            eli eliVar = eli.this;
            eliVar.eli(eliVar.eli.getCurView(), eli.this.aGH);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (eli.this.nn) {
                eli.this.dV = 0;
            } else {
                eli.this.MGA();
            }
        }
    };

    public eli(Context context, ev evVar, AdSlot adSlot, kb kbVar, boolean z) {
        this.nn = false;
        this.MGA = context;
        this.aGH = evVar;
        this.DbA = adSlot;
        this.nlS = kbVar;
        this.nn = z;
        eli(context, evVar, adSlot);
        this.wC = false;
        this.FC = false;
    }

    public void eli(int i) {
        aGH agh = this.eli;
        if (agh != null) {
            agh.setCurrentIndex(i);
        }
    }

    public void eli(PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback) {
        wC wCVar = new wC(pAGBannerAdInteractionCallback);
        this.ui = wCVar;
        this.eli.setExpressInteractionListener(wCVar);
    }

    public void eli(PAGBannerAdInteractionListener pAGBannerAdInteractionListener) {
        wC wCVar = new wC(pAGBannerAdInteractionListener);
        this.ui = wCVar;
        this.eli.setExpressInteractionListener(wCVar);
    }

    public View eli() {
        com.bytedance.sdk.openadsdk.utils.DbA.eli(this.aGH);
        IPMiBroadcastReceiver.eli(this.MGA, this.aGH);
        return this.eli;
    }

    private void eli(Context context, ev evVar, AdSlot adSlot) {
        if (evVar.nY() != null) {
            Os os = new Os(context, evVar, adSlot, this.nn);
            this.eli = os;
            os.addOnAttachStateChangeListener(this.nGm);
        } else {
            aGH agh = new aGH(context, evVar, adSlot, this.nn);
            this.eli = agh;
            agh.addOnAttachStateChangeListener(this.nGm);
        }
    }

    public boolean DbA() {
        return this.eli instanceof Os;
    }

    public com.bytedance.sdk.openadsdk.multipro.DbA.eli Os() {
        aGH agh = this.eli;
        if (agh instanceof Os) {
            return ((Os) agh).getVideoModel();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(boolean z, ev evVar) {
        if (!z) {
            new Object[]{"banner_ad", "Lose focus, stop timing"};
        } else {
            if (this.aGH.ip() && !this.aGH.CMM()) {
                this.aGH.MGA(true);
                ev evVar2 = this.aGH;
                com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar2, this.Os, evVar2.nU());
            }
            new Object[]{"banner_ad", "Get focus, start timing"};
        }
        cyF.DbA(new C0174eli(z, evVar, this), 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAs() {
        nlS();
    }

    public void aGH() {
        DbA(this.aGH);
        this.kb = 0L;
    }

    public void ui() {
        this.kb = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(View view, Xb xb, ev evVar, String str, kb.eli eliVar) {
        com.bytedance.sdk.openadsdk.core.FC.DbA().eli(str, eliVar);
        this.kb = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            if (xb != null) {
                jSONObject.put("dynamic_show_type", xb.getDynamicShowType());
                xb.eli(jSONObject, evVar);
            }
            if (view != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("width", view.getWidth());
                    jSONObject2.put("height", view.getHeight());
                    jSONObject2.put("alpha", view.getAlpha());
                } catch (Throwable unused) {
                }
                jSONObject.put("root_view", jSONObject2.toString());
            }
            com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, this.Os, jSONObject);
            com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(evVar);
        } catch (JSONException unused2) {
            com.bytedance.sdk.component.utils.Xb.Os("PAGBannerAdImpl", "onShowFun json error");
        }
        PAGBannerAdWrapperListener pAGBannerAdWrapperListener = this.ui;
        if (pAGBannerAdWrapperListener != null) {
            pAGBannerAdWrapperListener.onAdShow(view, evVar.yw());
        }
        if (evVar.Zo()) {
            dZ.eli(evVar, view);
        }
    }

    private com.bytedance.sdk.openadsdk.QX.eli.eli.MGA eli(ev evVar) {
        if (evVar.yw() == 4) {
            return com.bytedance.sdk.openadsdk.QX.eli.eli.kb.eli(this.MGA, this.Os);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(final Xb xb, final ev evVar) {
        eli eliVar;
        ev evVar2;
        final Xb xb2;
        com.bytedance.sdk.openadsdk.core.kb kbVar;
        if (xb == null || evVar == null) {
            return;
        }
        this.aGH = evVar;
        this.aAs = eli(evVar);
        this.du = xb;
        final String eli = gG.eli();
        final kb.eli du = du();
        xb.setClosedListenerKey(eli);
        xb.setBannerClickClosedListener(du);
        xb.setBackupListener(new com.bytedance.sdk.component.adexpress.DbA.Os() { // from class: com.bytedance.sdk.openadsdk.core.Os.eli.2
            @Override // com.bytedance.sdk.component.adexpress.DbA.Os
            public boolean eli(ViewGroup viewGroup, int i) {
                try {
                    xb.Xb();
                    if (eli.this.aGH.Kv()) {
                        FC fc = new FC(xb.getContext());
                        fc.setClosedListenerKey(eli);
                        fc.eli(eli.this.aGH, xb, eli.this.aAs);
                        fc.setAdInteractionListener(eli.this.ui);
                        xb.setVastVideoHelper(fc);
                        return true;
                    }
                    DbA dbA = new DbA(xb.getContext());
                    dbA.setClosedListenerKey(eli);
                    dbA.eli(eli.this.aGH, xb, eli.this.aAs);
                    dbA.setAdInteractionListener(eli.this.ui);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        if (!this.wC) {
            com.bytedance.sdk.openadsdk.core.kb eli2 = eli(xb);
            if (eli2 == null) {
                eli2 = new com.bytedance.sdk.openadsdk.core.kb(this.MGA, xb, this.nlS.eli());
                xb.addView(eli2);
            }
            eli2.setAdType(1);
            xb2 = xb;
            eli2.setCallback(new kb.eli() { // from class: com.bytedance.sdk.openadsdk.core.Os.eli.3
                @Override // com.bytedance.sdk.openadsdk.core.kb.eli
                public void eli(boolean z) {
                    eli.this.eli(z, evVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.kb.eli
                public void eli() {
                    if (eli.this.dV != 0) {
                        eli.this.aAs();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.kb.eli
                public void DbA() {
                    eli eliVar2 = eli.this;
                    eliVar2.DbA(eliVar2.aGH);
                }

                @Override // com.bytedance.sdk.openadsdk.core.kb.eli
                public void eli(View view) {
                    if (eli.this.NU.compareAndSet(false, true)) {
                        eli.this.eli(view, xb2, evVar, eli, du);
                    }
                    if (eli.this.eli == null || eli.this.eli.getCurView() == null) {
                        return;
                    }
                    eli.this.eli.getCurView().aAs();
                    eli.this.eli.getCurView().nGm();
                    eli.this.eli.setIsShow(true);
                }
            });
            kbVar = eli2;
            eliVar = this;
            evVar2 = evVar;
        } else {
            boolean eli3 = this.nlS.eli();
            Uv.DbA dbA = new Uv.DbA() { // from class: com.bytedance.sdk.openadsdk.core.Os.eli.4
                @Override // com.bytedance.sdk.openadsdk.utils.Uv.DbA
                public void eli(boolean z) {
                    eli.this.eli(z, evVar);
                }

                @Override // com.bytedance.sdk.openadsdk.utils.Uv.DbA
                public void eli() {
                    if (eli.this.dV != 0) {
                        eli.this.aAs();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.utils.Uv.DbA
                public void DbA() {
                    eli eliVar2 = eli.this;
                    eliVar2.DbA(eliVar2.aGH);
                }

                @Override // com.bytedance.sdk.openadsdk.utils.Uv.DbA
                public void eli(View view, boolean z) {
                    if (!z) {
                        com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(eli.this.aGH, 8);
                        return;
                    }
                    com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(eli.this.aGH, 4);
                    if (eli.this.NU.compareAndSet(false, true)) {
                        eli.this.eli(view, xb, evVar, eli, du);
                    }
                    if (eli.this.eli == null || eli.this.eli.getCurView() == null) {
                        return;
                    }
                    eli.this.eli.getCurView().aAs();
                    eli.this.eli.getCurView().nGm();
                    eli.this.eli.setIsShow(true);
                }
            };
            eliVar = this;
            evVar2 = evVar;
            Uv.eli(xb, true, 1, eli3, dbA, null);
            xb2 = xb;
            kbVar = null;
        }
        Context eli4 = xb2 != null ? com.bytedance.sdk.component.utils.DbA.eli(xb2) : null;
        if (eli4 == null) {
            eli4 = eliVar.MGA;
        }
        com.bytedance.sdk.openadsdk.core.wC.FC fc = new com.bytedance.sdk.openadsdk.core.wC.FC(eli4, evVar2, eliVar.Os, 2);
        fc.eli(xb2);
        fc.eli(this);
        fc.eli(eliVar.aAs);
        fc.eli(new DbA.eli() { // from class: com.bytedance.sdk.openadsdk.core.Os.eli.5
            @Override // com.bytedance.sdk.openadsdk.core.DbA.DbA.eli
            public void eli(View view, int i) {
                if (eli.this.ui != null) {
                    eli.this.ui.onAdClicked();
                }
            }
        });
        xb2.setClickListener(fc);
        com.bytedance.sdk.openadsdk.core.wC.wC wCVar = new com.bytedance.sdk.openadsdk.core.wC.wC(eliVar.MGA, evVar2, eliVar.Os, 2);
        wCVar.eli((View) xb2);
        wCVar.eli(this);
        wCVar.eli(new DbA.eli() { // from class: com.bytedance.sdk.openadsdk.core.Os.eli.6
            @Override // com.bytedance.sdk.openadsdk.core.DbA.DbA.eli
            public void eli(View view, int i) {
                if (eli.this.ui != null) {
                    eli.this.ui.onAdClicked();
                }
            }
        });
        Xb xb3 = eliVar.du;
        if (xb3 instanceof QX) {
            wCVar.eli(((QX) xb3).getVideoController());
        }
        wCVar.eli(eliVar.aAs);
        xb2.setClickCreativeListener(wCVar);
        if (eliVar.wC) {
            return;
        }
        kbVar.setNeedCheckingShow(true);
    }

    private kb.eli du() {
        return new kb.eli() { // from class: com.bytedance.sdk.openadsdk.core.Os.eli.7
            @Override // com.bytedance.sdk.openadsdk.core.Os.kb.eli
            public void eli() {
                int width = eli.this.du.getWidth();
                int height = eli.this.du.getHeight();
                View eli = eli(((double) height) >= Math.floor((((double) width) * 450.0d) / 600.0d));
                eli.this.du.CMM();
                eli.this.du.removeAllViews();
                eli.this.du.addView(eli, new ViewGroup.LayoutParams(width, height));
                eli.this.du.setClickCreativeListener(null);
                eli.this.du.setClickListener(null);
                if (eli.this.ui != null) {
                    eli.this.ui.onAdDismissed();
                }
                eli.this.FC = true;
            }

            private View eli(boolean z) {
                com.bytedance.sdk.openadsdk.core.ui.Os os = new com.bytedance.sdk.openadsdk.core.ui.Os(eli.this.MGA);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                os.setBackgroundColor(-1);
                os.setLayoutParams(layoutParams);
                View view = new View(eli.this.MGA);
                ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                view.setAlpha(0.3f);
                view.setBackgroundColor(Color.parseColor("#F3F7F8"));
                os.addView(view, layoutParams2);
                com.bytedance.sdk.openadsdk.core.ui.Os os2 = new com.bytedance.sdk.openadsdk.core.ui.Os(eli.this.MGA);
                ViewGroup.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
                if (z) {
                    os2.setBackground(com.bytedance.sdk.component.utils.ev.Os(eli.this.MGA, "tt_ad_closed_background_300_250"));
                } else {
                    os2.setBackground(com.bytedance.sdk.component.utils.ev.Os(eli.this.MGA, "tt_ad_closed_background_320_50"));
                }
                os.addView(os2, layoutParams3);
                PAGLogoView createPAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(eli.this.MGA, eli.this.aGH);
                createPAGLogoViewByMaterial.setId(520093739);
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
                if (z) {
                    int DbA = SSo.DbA(eli.this.MGA, 16.0f);
                    layoutParams4.width = SSo.DbA(eli.this.MGA, 77.0f);
                    layoutParams4.height = SSo.DbA(eli.this.MGA, 14.0f);
                    layoutParams4.leftMargin = DbA;
                    layoutParams4.topMargin = DbA;
                } else {
                    int DbA2 = SSo.DbA(eli.this.MGA, 8.0f);
                    layoutParams4.width = SSo.DbA(eli.this.MGA, 45.0f);
                    layoutParams4.height = SSo.DbA(eli.this.MGA, 8.18f);
                    layoutParams4.leftMargin = DbA2;
                    layoutParams4.topMargin = DbA2;
                }
                os2.addView(createPAGLogoViewByMaterial, layoutParams4);
                com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(eli.this.MGA);
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams5.gravity = 17;
                wCVar.setAlpha(0.5f);
                wCVar.setLines(1);
                wCVar.setText(com.bytedance.sdk.component.utils.ev.eli(eli.this.MGA, "tt_ad_is_closed"));
                if (z) {
                    wCVar.setTextSize(18.0f);
                } else {
                    wCVar.setTextSize(12.0f);
                }
                os2.addView(wCVar, layoutParams5);
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Os.eli.7.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TTWebsiteActivity.eli(eli.this.MGA, eli.this.aGH, eli.this.Os);
                    }
                };
                createPAGLogoViewByMaterial.setOnClickListener(onClickListener);
                wCVar.setOnClickListener(onClickListener);
                return os;
            }
        };
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.Os.eli$eli, reason: collision with other inner class name */
    private static class C0174eli extends com.bytedance.sdk.component.wC.wC {
        ev DbA;
        WeakReference<eli> Os;
        boolean eli;

        C0174eli(boolean z, ev evVar, eli eliVar) {
            super("ReportWindowFocusChangedAdShow");
            this.eli = z;
            this.DbA = evVar;
            this.Os = new WeakReference<>(eliVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<eli> weakReference = this.Os;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.Os.get().DbA(this.eli, this.DbA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(boolean z, ev evVar) {
        try {
            if (z) {
                this.kb = System.currentTimeMillis();
            } else {
                if (this.kb <= 0 || this.du == null) {
                    return;
                }
                String valueOf = String.valueOf(System.currentTimeMillis() - this.kb);
                this.kb = 0L;
                com.bytedance.sdk.openadsdk.aGH.Os.eli(valueOf, evVar, this.Os, this.du.getAdShowTime());
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.Xb.Os("PAGBannerAdImpl", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(ev evVar) {
        if (this.kb <= 0 || evVar == null) {
            return;
        }
        try {
            if (this.du != null) {
                String valueOf = String.valueOf(System.currentTimeMillis() - this.kb);
                this.kb = 0L;
                com.bytedance.sdk.openadsdk.aGH.Os.eli(valueOf, evVar, this.Os, this.du.getAdShowTime());
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.Xb.Os("PAGBannerAdImpl", e.getMessage());
        }
    }

    private com.bytedance.sdk.openadsdk.core.kb eli(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            try {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof com.bytedance.sdk.openadsdk.core.kb) {
                    return (com.bytedance.sdk.openadsdk.core.kb) childAt;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public void MGA() {
        this.dV = 1;
        this.eli.aGH();
    }

    public void kb() {
        if (this.eli != null) {
            try {
                MGA();
                this.eli.removeOnAttachStateChangeListener(this.nGm);
            } catch (Throwable unused) {
            }
        }
    }

    public void eli(final com.bytedance.sdk.openadsdk.eli.eli.DbA dbA) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.QX > 500) {
            this.QX = currentTimeMillis;
            aGH agh = this.eli;
            if (agh instanceof Os) {
                agh.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Os.eli.8
                    @Override // java.lang.Runnable
                    public void run() {
                        ((Os) eli.this.eli).eli(dbA);
                    }
                }, 500L);
            }
        }
    }

    public void wC() {
        aGH agh = this.eli;
        if (agh instanceof Os) {
            ((Os) agh).DbA();
        }
    }

    public void FC() {
        aGH agh = this.eli;
        if (agh instanceof Os) {
            ((Os) agh).eli();
        }
    }

    private void nlS() {
        this.aGH.eli(SystemClock.elapsedRealtime());
        this.eli.ui();
    }
}
