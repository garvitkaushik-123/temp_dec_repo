package com.bytedance.sdk.openadsdk.component;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.component.FC.ui;
import com.bytedance.sdk.openadsdk.component.MGA;
import com.bytedance.sdk.openadsdk.core.DbA.DbA;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.model.nGm;
import com.bytedance.sdk.openadsdk.core.ui.wC;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.aqO;
import com.bytedance.sdk.openadsdk.core.widget.dV;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.dV;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os {
    private float CMM;
    protected final ev DbA;
    private PAGLogoView Dfc;
    protected View FC;
    private View KM;
    protected final int MGA;
    private RelativeLayout NU;
    protected final boolean Os;
    private wC QX;
    private aqO Ue;
    private com.bytedance.sdk.openadsdk.component.wC.Os Vy;
    private wC Xb;
    protected com.bytedance.sdk.openadsdk.core.ui.aGH aAs;
    protected final FrameLayout aGH;
    private wC aqO;
    private float bf;
    private ImageView dV;
    protected wC du;
    protected final Activity eli;
    private final com.bytedance.sdk.openadsdk.component.FC.wC ev = new com.bytedance.sdk.openadsdk.component.FC.wC();
    private wC gG;
    protected int kb;
    private dV nGm;
    protected final com.bytedance.sdk.openadsdk.component.wC.eli nlS;
    private ImageView nn;
    protected final com.bytedance.sdk.openadsdk.component.eli ui;
    private com.bytedance.sdk.openadsdk.core.ui.aGH ujq;
    protected FrameLayout wC;

    public int aGH() {
        return -1;
    }

    public JSONObject eli(JSONObject jSONObject) {
        return null;
    }

    public void ui() {
    }

    public Os(Activity activity, ev evVar, FrameLayout frameLayout, com.bytedance.sdk.openadsdk.component.eli eliVar, int i, boolean z, com.bytedance.sdk.openadsdk.component.wC.eli eliVar2) {
        this.eli = activity;
        this.DbA = evVar;
        this.aGH = frameLayout;
        this.kb = i;
        this.Os = z;
        this.ui = eliVar;
        this.MGA = evVar.RTg();
        this.nlS = eliVar2;
    }

    public void eli(ViewGroup viewGroup) {
        com.bytedance.sdk.openadsdk.component.FC.Os agh = new com.bytedance.sdk.openadsdk.component.FC.aGH(this.eli, this.DbA);
        int ow = this.DbA.ow();
        if (ow == 5) {
            agh = new com.bytedance.sdk.openadsdk.component.FC.MGA(this.eli, this.DbA);
        } else if (ow == 4) {
            agh = new com.bytedance.sdk.openadsdk.component.FC.ui(this.eli, this.DbA);
        }
        com.bytedance.sdk.openadsdk.component.FC.Os os = agh;
        this.NU = os;
        viewGroup.addView(os);
        this.dV = os.getBackImage();
        this.wC = os.getVideoContainer();
        this.nn = os.getImageView();
        this.aqO = os.getClickButton();
        this.Dfc = os.getAdLogo();
        this.gG = os.getAdTitleTextView();
        this.ujq = os.getAdIconView();
        this.Ue = os.getScoreBar();
        this.KM = os.getOverlayLayout();
        if (this.DbA.gG()) {
            this.nGm = os.getIconOnlyView();
            this.QX = os.getTitle();
            this.Xb = os.getContent();
        }
        if (os.getDspAdChoice() != null) {
            os.getDspAdChoice().eli(14, this.DbA);
        }
        if (!this.DbA.Jt()) {
            this.ev.eli(os, this.DbA, this.CMM, this.bf, this.Os);
        }
        this.FC = os.getTopDisLike();
        this.aAs = os.getTopSkip();
        this.du = os.getTopCountDown();
        if (os instanceof com.bytedance.sdk.openadsdk.component.FC.ui) {
            ((com.bytedance.sdk.openadsdk.component.FC.ui) os).setRenderListener(new ui.eli() { // from class: com.bytedance.sdk.openadsdk.component.Os.1
                @Override // com.bytedance.sdk.openadsdk.component.FC.ui.eli
                public void eli(View view, int i) {
                    Os.this.ui.ui();
                }
            });
        }
    }

    public void eli() {
        this.Dfc.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.Os.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.eli(Os.this.eli, Os.this.DbA, "open_ad");
                } catch (Throwable th) {
                    Xb.Os("AppOpenAdNativeManager", th.getMessage());
                }
            }
        });
        MGA();
        if (this.DbA.Jt()) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.eli.eli eli2 = com.bytedance.sdk.openadsdk.component.eli.DbA.eli(this.DbA, this.eli, this.nlS);
        eli2.eli(new DbA.eli() { // from class: com.bytedance.sdk.openadsdk.component.Os.3
            @Override // com.bytedance.sdk.openadsdk.core.DbA.DbA.eli
            public void eli(View view, int i) {
                Os.this.ui.ui();
            }
        });
        eli2.eli(this.Vy);
        if (this.DbA.WfR() == 1) {
            this.NU.setOnClickListener(eli2);
            this.NU.setOnTouchListener(eli2);
        }
        this.aqO.setOnClickListener(eli2);
        this.aqO.setOnTouchListener(eli2);
    }

    protected void MGA() {
        this.FC.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.Os.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Os.this.ui != null) {
                    Os.this.ui.DbA(view);
                }
            }
        });
        this.aAs.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.Os.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Os.this.ui != null) {
                    Os.this.ui.eli(view);
                }
            }
        });
    }

    public void DbA() {
        if (!this.DbA.Jt()) {
            wC();
        } else {
            this.ui.Os();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void wC() {
        boolean z;
        aqO aqo;
        View view;
        this.ev.eli();
        this.aqO.setText(this.DbA.GMu());
        if (this.DbA.gG()) {
            FC();
            return;
        }
        if (this.Os) {
            DbA(0);
            eli(8);
            if (eli(this.wC)) {
                this.ui.Os();
            } else {
                this.ui.aGH();
            }
            MGA.eli(this.DbA, new eli(this.eli, this), 25);
        } else {
            DbA(8);
            eli(0);
            aAs();
            this.ui.Os();
        }
        boolean z2 = true;
        if (this.gG != null) {
            if (!TextUtils.isEmpty(this.DbA.kEI())) {
                this.gG.setText(this.DbA.kEI());
            } else if (this.DbA.pu() != null) {
                this.gG.setText(this.DbA.pu().DbA());
            }
            z = true;
            if (this.ujq != null) {
                com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.DbA.SjY(), this.ujq, this.DbA);
            }
            aqo = this.Ue;
            if (aqo != null) {
                SSo.eli((TextView) null, aqo, this.DbA);
                if (this.DbA.pu() == null || this.DbA.pu().aGH() < 0.0d) {
                    this.Ue.setVisibility(8);
                }
                view = this.KM;
                if (view != null) {
                    view.setVisibility(z2 ? 0 : 8);
                    return;
                }
                return;
            }
            z2 = z;
            view = this.KM;
            if (view != null) {
            }
        }
        z = false;
        if (this.ujq != null) {
        }
        aqo = this.Ue;
        if (aqo != null) {
        }
        z2 = z;
        view = this.KM;
        if (view != null) {
        }
    }

    protected boolean eli(FrameLayout frameLayout) {
        com.bytedance.sdk.openadsdk.component.wC.Os os = new com.bytedance.sdk.openadsdk.component.wC.Os(this.eli);
        this.Vy = os;
        return os.eli(frameLayout, this.ui, this.DbA);
    }

    private void DbA(int i) {
        SSo.eli((View) this.wC, i);
    }

    private void FC() {
        if (this.QX != null) {
            if (this.DbA.pu() != null && !TextUtils.isEmpty(this.DbA.pu().DbA())) {
                this.QX.setText(this.DbA.pu().DbA());
            } else if (!TextUtils.isEmpty(this.DbA.kEI())) {
                this.QX.setText(this.DbA.kEI());
            } else {
                this.QX.setVisibility(8);
            }
        }
        if (this.Xb != null) {
            if (!TextUtils.isEmpty(this.DbA.Pf())) {
                this.Xb.setText(this.DbA.Pf());
            } else {
                this.Xb.setVisibility(8);
            }
        }
        if (this.nGm != null && this.DbA.SjY() != null && !TextUtils.isEmpty(this.DbA.SjY().eli())) {
            com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.DbA.SjY().eli(), this.DbA.SjY().DbA(), this.DbA.SjY().Os(), this.nGm, this.DbA);
        }
        this.ui.Os();
    }

    private void aAs() {
        nGm ngm = this.DbA.an().get(0);
        com.bytedance.sdk.openadsdk.utils.dV.eli(new com.bytedance.sdk.openadsdk.nGm.eli(ngm.eli(), ngm.kb()), ngm.DbA(), ngm.Os(), new DbA(this), com.bytedance.sdk.openadsdk.component.kb.eli.DbA(TextUtils.isEmpty(ngm.kb()) ? com.bytedance.sdk.component.utils.ui.eli(ngm.eli()) : ngm.kb()).getParent(), 25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(Object obj) {
        try {
            if (obj instanceof Bitmap) {
                this.dV.setImageDrawable(new BitmapDrawable(com.bytedance.sdk.openadsdk.core.dV.eli().getResources(), (Bitmap) obj));
            }
        } catch (Throwable unused) {
            Xb.Os("AppOpenAdNativeManager", "open_ad", "bindBackGroundImage error");
        }
    }

    void eli(com.bytedance.sdk.openadsdk.nGm.eli.DbA dbA) {
        if (dbA.DbA() != null) {
            this.nn.setImageBitmap(dbA.DbA());
            return;
        }
        Drawable aGH = dbA.aGH();
        if (aGH != null) {
            this.nn.setScaleType(ImageView.ScaleType.FIT_CENTER);
            if (aGH instanceof AnimatedImageDrawable) {
                ((AnimatedImageDrawable) aGH).start();
            }
            this.nn.setImageDrawable(aGH);
            return;
        }
        if (this.DbA.an() == null || this.DbA.an().get(0) == null) {
            return;
        }
        Drawable eli2 = com.bytedance.sdk.openadsdk.utils.dV.eli(dbA.Os(), this.DbA.an().get(0).DbA());
        this.nn.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.nn.setImageDrawable(eli2);
    }

    void eli(int i) {
        SSo.eli((View) this.nn, i);
    }

    public static class eli implements MGA.Os {
        private final WeakReference<Os> DbA;
        WeakReference<Activity> eli;

        eli(Activity activity, Os os) {
            this.eli = new WeakReference<>(activity);
            this.DbA = new WeakReference<>(os);
        }

        @Override // com.bytedance.sdk.openadsdk.component.MGA.Os
        public void eli(Object obj) {
            Os os;
            if (this.eli.get() == null || this.eli.get().isFinishing() || (os = this.DbA.get()) == null) {
                return;
            }
            os.eli(obj);
        }
    }

    public void eli(float f, float f2) {
        this.CMM = f;
        this.bf = f2;
    }

    public void eli(int i, boolean z) {
        wC wCVar;
        if (this.aAs == null || (wCVar = this.du) == null) {
            return;
        }
        if (z) {
            if (wCVar.getVisibility() != 8) {
                this.du.setVisibility(8);
            }
            if (this.aAs.getVisibility() != 0) {
                this.aAs.setVisibility(0);
                return;
            }
            return;
        }
        this.du.setText(i + "s");
        if (this.du.getVisibility() != 0) {
            this.du.setVisibility(0);
        }
    }

    public com.bytedance.sdk.openadsdk.component.wC.Os kb() {
        return this.Vy;
    }

    public void Os() {
        com.bytedance.sdk.openadsdk.component.wC.Os os = this.Vy;
        if (os != null) {
            os.nlS();
        }
    }

    public static class DbA implements dV.eli {
        private final WeakReference<Os> eli;

        @Override // com.bytedance.sdk.openadsdk.utils.dV.eli
        public void eli() {
        }

        public DbA(Os os) {
            this.eli = new WeakReference<>(os);
        }

        @Override // com.bytedance.sdk.openadsdk.utils.dV.eli
        public void eli(com.bytedance.sdk.openadsdk.nGm.eli.DbA dbA) {
            Os os;
            if (!dbA.ui() || (os = this.eli.get()) == null) {
                return;
            }
            os.eli(dbA);
            if (dbA.DbA() != null) {
                os.eli(dbA.eli());
            }
        }
    }
}
