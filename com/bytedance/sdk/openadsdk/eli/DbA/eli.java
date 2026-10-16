package com.bytedance.sdk.openadsdk.eli.DbA;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGImageItem;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoMediaView;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.model.nGm;
import com.bytedance.sdk.openadsdk.core.settings.NU;
import com.bytedance.sdk.openadsdk.core.wC.FC;
import com.bytedance.sdk.openadsdk.core.wC.QX;
import com.bytedance.sdk.openadsdk.core.wC.Xb;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.SSo;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: classes3.dex */
public class eli {
    private final Context DbA;
    private Xb FC;
    private DbA MGA;
    private boolean NU = false;
    private final String Os;
    private PAGMediaView aAs;
    private boolean aGH;
    private com.bytedance.sdk.openadsdk.core.DbA.eli du;
    protected final ev eli;
    private com.bytedance.sdk.openadsdk.eli.DbA.eli.Os kb;
    private com.bytedance.sdk.openadsdk.core.DbA.DbA nlS;
    private WeakReference<com.bytedance.sdk.openadsdk.core.du.MGA> nn;
    private WeakReference<com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA> ui;
    private PAGMediaView wC;

    public eli(Context context, ev evVar, String str) {
        this.DbA = context;
        this.eli = evVar;
        this.Os = str;
    }

    public void eli(DbA dbA) {
        this.MGA = dbA;
    }

    public void eli(com.bytedance.sdk.openadsdk.eli.DbA.eli.Os os) {
        this.kb = os;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA mga) {
        this.ui = new WeakReference<>(mga);
    }

    public void eli(boolean z) {
        this.aGH = z;
    }

    public PAGMediaView eli() {
        return this.wC;
    }

    public Xb DbA() {
        return this.FC;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.DbA.eli eliVar) {
        this.du = eliVar;
    }

    public PAGImageItem Os() {
        ev evVar = this.eli;
        if (evVar == null || evVar.SjY() == null) {
            return null;
        }
        return new PAGImageItem(this.eli.SjY().Os(), this.eli.SjY().DbA(), this.eli.SjY().eli(), (float) this.eli.SjY().aGH());
    }

    public String aGH() {
        ev evVar = this.eli;
        if (evVar != null) {
            return eli(evVar);
        }
        return null;
    }

    private String eli(ev evVar) {
        if (evVar.pu() != null && !TextUtils.isEmpty(evVar.pu().DbA())) {
            return evVar.pu().DbA();
        }
        if (!TextUtils.isEmpty(evVar.kEI())) {
            return evVar.kEI();
        }
        if (!TextUtils.isEmpty(evVar.Pf())) {
            return evVar.Pf();
        }
        return "";
    }

    private String DbA(ev evVar) {
        if (!TextUtils.isEmpty(evVar.Pf())) {
            return evVar.Pf();
        }
        if (!TextUtils.isEmpty(evVar.bU())) {
            return evVar.bU();
        }
        return "";
    }

    public String ui() {
        ev evVar = this.eli;
        if (evVar != null) {
            return DbA(evVar);
        }
        return null;
    }

    public String MGA() {
        ev evVar = this.eli;
        if (evVar != null) {
            return evVar.GMu();
        }
        return null;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.DbA.DbA dbA) {
        this.nlS = dbA;
    }

    public PAGMediaView kb() {
        PAGMediaView FC;
        com.bytedance.sdk.openadsdk.utils.DbA.eli(this.eli);
        if (this.eli.BDs() == 2) {
            FC = nn();
            eli(FC);
        } else {
            FC = FC();
        }
        if (FC != null) {
            FC.setMrcTrackerKey(com.bytedance.sdk.openadsdk.Vy.DbA.ui.DbA(this.eli));
        } else {
            FC = new PAGMediaView(this.DbA) { // from class: com.bytedance.sdk.openadsdk.eli.DbA.eli.1
                @Override // android.view.ViewGroup, android.view.View
                protected void onAttachedToWindow() {
                    super.onAttachedToWindow();
                    com.bytedance.sdk.openadsdk.utils.aGH.eli(this, eli.this.eli);
                }
            };
        }
        if (FC instanceof PAGVideoMediaView) {
            ((PAGVideoMediaView) FC).setMaterialMeta(this.eli);
        }
        this.aAs = FC;
        return FC;
    }

    public PAGMediaView wC() {
        return this.aAs;
    }

    private void eli(PAGMediaView pAGMediaView) {
        if (pAGMediaView == null) {
            return;
        }
        try {
            pAGMediaView.setBackgroundColor(-16777216);
        } catch (Exception unused) {
        }
    }

    private PAGMediaView nn() {
        if (ev.ui(this.eli)) {
            com.bytedance.sdk.openadsdk.eli.DbA.eli.Os os = this.kb;
            if (os == null || !(os instanceof com.bytedance.sdk.openadsdk.eli.DbA.eli.DbA)) {
                return null;
            }
            QX qx = (QX) os.aGH();
            qx.setTag(520093762, Boolean.TRUE);
            if (!this.NU) {
                this.kb.ui();
            }
            this.NU = true;
            return eli(qx);
        }
        com.bytedance.sdk.openadsdk.eli.DbA.eli.Os os2 = this.kb;
        if (os2 == null) {
            return null;
        }
        Xb aGH = os2.aGH();
        aGH.setTag(520093762, Boolean.TRUE);
        if (!this.NU) {
            this.kb.ui();
        }
        this.NU = true;
        return eli(aGH);
    }

    public PAGMediaView FC() {
        if (ev.ui(this.eli)) {
            DbA dbA = this.MGA;
            if (dbA != null) {
                View ui = dbA.ui();
                if (ui != null) {
                    if (ui.getParent() instanceof ViewGroup) {
                        ((ViewGroup) ui.getParent()).removeView(ui);
                    }
                    PAGMediaView pAGMediaView = this.wC;
                    if (pAGMediaView != null) {
                        pAGMediaView.setOnClickListener(null);
                        this.wC.setOnTouchListener(null);
                    }
                    PAGVideoMediaView pAGVideoMediaView = new PAGVideoMediaView(this.DbA, ui, this);
                    pAGVideoMediaView.setTag(520093762, Boolean.TRUE);
                    if (this.du != null && NU.nY().Os(String.valueOf(this.eli.RTg()))) {
                        pAGVideoMediaView.setOnClickListener(this.du);
                        pAGVideoMediaView.setOnTouchListener(this.du);
                    } else {
                        com.bytedance.sdk.openadsdk.core.DbA.Os os = new com.bytedance.sdk.openadsdk.core.DbA.Os() { // from class: com.bytedance.sdk.openadsdk.eli.DbA.eli.2
                            @Override // com.bytedance.sdk.openadsdk.core.DbA.Os
                            protected void eli(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, boolean z) {
                                try {
                                    ((PAGVideoMediaView) view).handleInterruptVideo();
                                } catch (Exception unused) {
                                }
                            }
                        };
                        pAGVideoMediaView.setOnClickListener(os);
                        pAGVideoMediaView.setOnTouchListener(os);
                    }
                    this.wC = pAGVideoMediaView;
                    pAGVideoMediaView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    return pAGVideoMediaView;
                }
                ApmHelper.reportCustomError("adVideoView null", "getMediaView return null", new RuntimeException());
                return null;
            }
            ApmHelper.reportCustomError("mPAGFeedVideoAdImpl null", "getMediaView return null", new RuntimeException());
            return null;
        }
        List<nGm> an = this.eli.an();
        if (an != null && !an.isEmpty()) {
            ImageView imageView = new ImageView(this.DbA);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            nGm ngm = an.get(0);
            if (ngm != null) {
                com.bytedance.sdk.openadsdk.FC.aGH.eli(ngm).Os(1).eli(com.bytedance.sdk.openadsdk.FC.Os.eli(this.eli, ngm.eli(), imageView));
            }
            PAGMediaView eli = eli(imageView);
            if (this.du != null && NU.nY().Os(String.valueOf(this.eli.RTg()))) {
                eli.setOnClickListener(this.du);
                eli.setOnTouchListener(this.du);
            } else {
                eli.setOnClickListener(null);
                eli.setOnTouchListener(null);
            }
            eli.setTag(520093762, Boolean.TRUE);
            PAGMediaView pAGMediaView2 = this.wC;
            if (pAGMediaView2 != null) {
                pAGMediaView2.setOnClickListener(null);
                this.wC.setOnTouchListener(null);
            }
            this.wC = eli;
            return eli;
        }
        ApmHelper.reportCustomError("images empty", "getMediaView return null", new RuntimeException());
        return null;
    }

    private PAGMediaView eli(final View view) {
        int i;
        if (view == null) {
            return null;
        }
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        Xb xb = this.FC;
        if (xb != null) {
            xb.setClickListener(null);
            this.FC.setClickCreativeListener(null);
        }
        com.bytedance.sdk.openadsdk.core.DbA.DbA dbA = this.nlS;
        if (dbA != null && (dbA instanceof FC) && (view instanceof Xb)) {
            ((Xb) view).setClickListener((FC) dbA);
        }
        com.bytedance.sdk.openadsdk.core.DbA.eli eliVar = this.du;
        if (eliVar != null && (eliVar instanceof com.bytedance.sdk.openadsdk.core.wC.wC) && (view instanceof Xb)) {
            ((Xb) view).setClickCreativeListener((com.bytedance.sdk.openadsdk.core.wC.wC) eliVar);
        }
        PAGMediaView pAGMediaView = new PAGMediaView(this.DbA) { // from class: com.bytedance.sdk.openadsdk.eli.DbA.eli.3
            @Override // android.view.View
            public void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                if (view instanceof Xb) {
                    return;
                }
                eli(z);
            }

            private void eli(boolean z) {
                if (this.eli != null) {
                    com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(this.eli), z ? 4 : 8);
                }
                if (eli.this.eli != null) {
                    com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(eli.this.eli, z);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView
            public void setVideoAdListener(PAGVideoAdListener pAGVideoAdListener) {
                super.setVideoAdListener(pAGVideoAdListener);
                eli.this.eli(pAGVideoAdListener);
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                com.bytedance.sdk.openadsdk.utils.aGH.eli(this, eli.this.eli);
            }
        };
        int i2 = -1;
        pAGMediaView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            i2 = layoutParams.width;
            i = layoutParams.height;
        } else {
            i = -1;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, i);
        layoutParams2.gravity = 17;
        pAGMediaView.addView(view, layoutParams2);
        if (view instanceof Xb) {
            this.FC = (Xb) view;
        }
        return pAGMediaView;
    }

    public View aAs() {
        if (dV.eli() == null) {
            return null;
        }
        PAGLogoView pAGLogoView = new PAGLogoView(dV.eli()) { // from class: com.bytedance.sdk.openadsdk.eli.DbA.eli.4
            int eli = 0;
            int DbA = 0;

            @Override // com.bytedance.sdk.openadsdk.core.widget.PAGLogoView, android.widget.LinearLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                if (this.eli == 0) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, Integer.MIN_VALUE), i2);
                    this.eli = getMeasuredWidth();
                    this.DbA = this.containerHeight;
                }
                setMeasuredDimension(this.eli, this.DbA);
            }

            @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
                super.onLayout(z, i, i2, i3, i4);
                try {
                    Object parent = getParent();
                    if (parent == null || this.eli == 0 || this.DbA == 0) {
                        return;
                    }
                    int width = ((View) parent).getWidth();
                    int height = ((View) parent).getHeight();
                    int i5 = this.eli;
                    if (width < i5 || height < this.DbA) {
                        float min = Math.min(height / this.DbA, width / i5);
                        int i6 = (width - this.eli) / 2;
                        if (min != 1.0f) {
                            setScaleX(min);
                            setScaleY(min);
                            setTranslationX(i6);
                        }
                    }
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
        };
        pAGLogoView.initData(this.eli);
        pAGLogoView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.eli.DbA.eli.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                eli.this.nlS();
            }
        });
        return pAGLogoView;
    }

    public View du() {
        ev evVar;
        if (dV.eli() == null || (evVar = this.eli) == null || !evVar.Kv() || !this.eli.nGm()) {
            return null;
        }
        ImageView imageView = new ImageView(dV.eli());
        com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli((int) SSo.eli(dV.eli(), 14.0f, true), imageView, this.eli);
        return imageView;
    }

    public void nlS() {
        Context context = this.DbA;
        if (context != null) {
            TTWebsiteActivity.eli(context, this.eli, this.Os);
        }
    }

    public void eli(PAGVideoAdListener pAGVideoAdListener) {
        com.bytedance.sdk.openadsdk.eli.DbA.eli.Os os;
        if (this.eli.BDs() == 2 && ev.ui(this.eli) && (os = this.kb) != null && (os instanceof com.bytedance.sdk.openadsdk.eli.DbA.eli.DbA)) {
            QX qx = (QX) os.aGH();
            if (qx != null) {
                qx.setVideoAdListener(DbA(pAGVideoAdListener));
                return;
            }
            return;
        }
        DbA dbA = this.MGA;
        if (dbA != null) {
            dbA.eli(DbA(pAGVideoAdListener));
        }
    }

    private Os DbA(final PAGVideoAdListener pAGVideoAdListener) {
        return new Os() { // from class: com.bytedance.sdk.openadsdk.eli.DbA.eli.6
            @Override // com.bytedance.sdk.openadsdk.eli.DbA.Os
            public void eli(int i, int i2) {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoError();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.eli.DbA.Os
            public void eli(PAGNativeAd pAGNativeAd) {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdPlay();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.eli.DbA.Os
            public void DbA(PAGNativeAd pAGNativeAd) {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdPaused();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.eli.DbA.Os
            public void Os(PAGNativeAd pAGNativeAd) {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdComplete();
                }
            }
        };
    }

    public void NU() {
        com.bytedance.sdk.openadsdk.core.du.MGA mga;
        WeakReference<com.bytedance.sdk.openadsdk.core.du.MGA> weakReference = this.nn;
        if (weakReference == null || (mga = weakReference.get()) == null) {
            return;
        }
        mga.eli(13);
    }

    public void eli(com.bytedance.sdk.openadsdk.core.du.MGA mga) {
        this.nn = new WeakReference<>(mga);
    }
}
