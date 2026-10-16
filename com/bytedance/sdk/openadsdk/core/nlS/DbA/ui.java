package com.bytedance.sdk.openadsdk.core.nlS.DbA;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.Ue;
import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.QX.eli.eli.kb;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.DbA.DbA;
import com.bytedance.sdk.openadsdk.core.DbA.eli;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA;
import com.bytedance.sdk.openadsdk.core.settings.NU;
import com.bytedance.sdk.openadsdk.core.widget.QX;
import com.bytedance.sdk.openadsdk.core.widget.nGm;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.bytedance.sdk.openadsdk.utils.du;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ui implements com.bykv.vk.openvk.eli.eli.eli.MGA.eli, com.bykv.vk.openvk.eli.eli.eli.aGH.DbA<ev>, Ue.eli, eli.InterfaceC0172eli, QX.DbA, nGm.eli {
    boolean CMM;
    boolean Cp;
    protected final int DbA;
    TextView Dfc;
    View FC;
    com.bytedance.sdk.openadsdk.QX.eli.eli.MGA GB;
    eli KM;
    View MGA;
    com.bytedance.sdk.openadsdk.core.widget.eli NU;
    ViewGroup Os;
    int QX;
    QX Ue;
    boolean VM;
    int Vy;
    int Xb;
    View aAs;
    com.bykv.vk.openvk.eli.eli.eli.MGA.DbA aGH;
    TextView aqO;
    boolean bf;
    private MGA.eli cyF;
    int dV;
    private final String dZ;
    ImageView du;
    private long eU;
    protected final int eli;
    int ev;
    ev gG;
    View kb;
    int nGm;
    View nlS;
    TextView nn;
    com.bytedance.sdk.openadsdk.core.DbA.eli nro;
    com.bykv.vk.openvk.eli.eli.eli.aGH.Os oWW;
    com.bytedance.sdk.openadsdk.core.DbA.eli qj;
    ImageView ui;
    Context ujq;
    ImageView wC;

    public void DbA(ViewGroup viewGroup) {
    }

    public void DbA(boolean z) {
    }

    public boolean DbA(int i) {
        return false;
    }

    public void MGA() {
    }

    public void Os(boolean z) {
    }

    public boolean aAs() {
        return false;
    }

    public void eli(int i) {
    }

    public void eli(long j) {
    }

    public void eli(long j, long j2) {
    }

    public void eli(Message message) {
    }

    public void eli(View view, boolean z) {
    }

    public void eli(ViewGroup viewGroup) {
    }

    public void eli(String str) {
    }

    public void ui() {
    }

    public /* bridge */ /* synthetic */ void eli(Object obj, WeakReference weakReference, boolean z) {
        eli((ev) obj, (WeakReference<Context>) weakReference, z);
    }

    public ui(Context context, ViewGroup viewGroup, boolean z, int i, ev evVar, com.bykv.vk.openvk.eli.eli.eli.aGH.Os os, boolean z2) {
        this.eli = 228;
        this.DbA = 160;
        this.bf = true;
        this.VM = true;
        this.Cp = true;
        this.dZ = Build.MODEL;
        if (this instanceof aGH) {
            return;
        }
        this.ujq = dV.eli().getApplicationContext();
        aGH(z2);
        this.Os = viewGroup;
        this.bf = z;
        this.Vy = i;
        this.oWW = os;
        this.gG = evVar;
        aGH(8);
        eli(context, this.Os);
        aGH();
        nlS();
    }

    public ui(Context context, ViewGroup viewGroup, boolean z, int i, ev evVar, com.bykv.vk.openvk.eli.eli.eli.aGH.Os os) {
        this(context, viewGroup, z, i, evVar, os, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void nlS() {
        String str;
        int i;
        String str2;
        int i2;
        com.bytedance.sdk.openadsdk.QX.eli.eli.MGA mga;
        com.bytedance.sdk.openadsdk.core.DbA.eli eliVar;
        String str3 = this.VM ? "embeded_ad" : "embeded_ad_landingpage";
        if (this.gG.Txb()) {
            str2 = "rewarded_video";
            i2 = 7;
        } else if (this.gG.Bno()) {
            str2 = "fullscreen_interstitial_ad";
            i2 = 5;
        } else if (this.gG.FtK()) {
            str2 = "banner_ad";
            i2 = 2;
        } else {
            str = str3;
            i = 1;
            if (this.gG.yw() == 4) {
                this.GB = kb.eli(this.ujq, str);
            }
            com.bytedance.sdk.openadsdk.core.DbA.eli eliVar2 = new com.bytedance.sdk.openadsdk.core.DbA.eli(this.ujq, this.gG, str, i);
            this.qj = eliVar2;
            eliVar2.eli(this);
            this.qj.DbA(true);
            if (!this.VM) {
                this.qj.eli(true);
            } else {
                this.qj.eli(false);
                this.qj.Os(true);
            }
            this.qj.eli(this.oWW);
            this.qj.ui(true);
            this.qj.eli(new DbA.eli() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.ui.1
                @Override // com.bytedance.sdk.openadsdk.core.DbA.DbA.eli
                public void eli(View view, int i3) {
                    if (ui.this.cyF != null) {
                        ui.this.cyF.eli(view, i3);
                    }
                }
            });
            mga = this.GB;
            if (mga != null && (eliVar = this.qj) != null) {
                eliVar.eli(mga);
            }
            if (gG()) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.core.DbA.eli(this.ujq, this.gG, str, i) { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.ui.2
                @Override // com.bytedance.sdk.openadsdk.core.DbA.eli
                public boolean DbA() {
                    boolean eli = ui.this.Ue != null ? ui.this.Ue.eli() : false;
                    ui.this.ui.getVisibility();
                    return eli || ui.this.ui.getVisibility() == 0;
                }

                @Override // com.bytedance.sdk.openadsdk.core.DbA.eli
                public boolean Os() {
                    if (ui.this.aAs != null && ui.this.aAs.getVisibility() == 0) {
                        return true;
                    }
                    if (ui.this.nlS != null && ui.this.nlS.getVisibility() == 0) {
                        return true;
                    }
                    if (ui.this.NU == null || ui.this.NU.getVisibility() != 0) {
                        return ui.this.nn != null && ui.this.nn.getVisibility() == 0;
                    }
                    return true;
                }
            };
            this.nro = eliVar3;
            eliVar3.eli(new DbA.eli() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.ui.3
                @Override // com.bytedance.sdk.openadsdk.core.DbA.DbA.eli
                public void eli(View view, int i3) {
                    if (ui.this.cyF != null) {
                        ui.this.cyF.eli(view, i3);
                    }
                }
            });
            this.nro.DbA(true);
            this.nro.eli(this.VM);
            this.nro.eli(this.oWW);
            this.nro.ui(true);
            com.bytedance.sdk.openadsdk.QX.eli.eli.MGA mga2 = this.GB;
            if (mga2 != null) {
                this.nro.eli(mga2);
            }
            this.nro.eli(this);
            return;
        }
        str = str2;
        i = i2;
        if (this.gG.yw() == 4) {
        }
        com.bytedance.sdk.openadsdk.core.DbA.eli eliVar22 = new com.bytedance.sdk.openadsdk.core.DbA.eli(this.ujq, this.gG, str, i);
        this.qj = eliVar22;
        eliVar22.eli(this);
        this.qj.DbA(true);
        if (!this.VM) {
        }
        this.qj.eli(this.oWW);
        this.qj.ui(true);
        this.qj.eli(new DbA.eli() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.ui.1
            @Override // com.bytedance.sdk.openadsdk.core.DbA.DbA.eli
            public void eli(View view, int i3) {
                if (ui.this.cyF != null) {
                    ui.this.cyF.eli(view, i3);
                }
            }
        });
        mga = this.GB;
        if (mga != null) {
            eliVar.eli(mga);
        }
        if (gG()) {
        }
    }

    private boolean gG() {
        return ev.ui(this.gG) && (!com.bytedance.sdk.openadsdk.core.aAs.aGH.eli(this.gG.rH()) ? this.gG.RY() == null : this.gG.hg() == null) && this.gG.GMY() == 1;
    }

    public void eli(MGA.eli eliVar) {
        this.cyF = eliVar;
    }

    public void eli(PAGNativeAd pAGNativeAd) {
        com.bytedance.sdk.openadsdk.core.DbA.eli eliVar = this.qj;
        if (eliVar != null) {
            eliVar.eli(pAGNativeAd);
        }
        com.bytedance.sdk.openadsdk.core.DbA.eli eliVar2 = this.nro;
        if (eliVar2 != null) {
            eliVar2.eli(pAGNativeAd);
        }
    }

    public com.bykv.vk.openvk.eli.eli.eli.MGA.DbA NU() {
        return this.aGH;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v20, types: [com.bykv.vk.openvk.eli.eli.eli.MGA.aGH] */
    void eli(Context context, View view) {
        com.bykv.vk.openvk.eli.eli.eli.MGA.Os os;
        System.currentTimeMillis();
        ev evVar = this.gG;
        if ((evVar == null || ((!evVar.Dg() && !this.gG.FtK()) || NU.nY().XxP())) && view != null) {
            view.setKeepScreenOn(true);
        }
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os2 = this.oWW;
        if (os2 != null && os2.Dfc()) {
            os = new com.bykv.vk.openvk.eli.eli.eli.MGA.aGH(this.ujq);
        } else {
            os = new com.bykv.vk.openvk.eli.eli.eli.MGA.Os(this.ujq);
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(os, 0, layoutParams);
        }
        SSo.eli((View) os, 8);
        this.aGH = os;
        this.ui = (ImageView) view.findViewById(aqO.XlF);
        this.MGA = view.findViewById(aqO.QMZ);
        this.kb = view.findViewById(aqO.Ib);
        this.wC = (ImageView) view.findViewById(aqO.OJ);
        this.FC = view.findViewById(aqO.Tju);
        System.currentTimeMillis();
    }

    void eli(View view, Context context) {
        View view2;
        if (view == null || context == null || (view2 = this.FC) == null || view2.getParent() == null || this.aAs != null) {
            return;
        }
        this.aAs = this.FC;
        this.du = (ImageView) view.findViewById(aqO.CH);
        this.nlS = view.findViewById(aqO.yw);
        this.NU = (com.bytedance.sdk.openadsdk.core.widget.eli) view.findViewById(aqO.Uv);
        this.nn = (TextView) view.findViewById(aqO.FS);
        this.Dfc = (TextView) view.findViewById(aqO.jh);
        this.aqO = (TextView) view.findViewById(aqO.Za);
    }

    void nn() {
        if (this.KM == null || this.Ue != null) {
            return;
        }
        System.currentTimeMillis();
        QX qx = new QX();
        this.Ue = qx;
        qx.eli(this.ujq, this.Os);
        this.Ue.eli(this.KM, this);
        System.currentTimeMillis();
    }

    public boolean eli(int i, com.bykv.vk.openvk.eli.eli.eli.Os.DbA dbA, boolean z) {
        QX qx = this.Ue;
        return qx == null || qx.eli(i, dbA, z);
    }

    public void Dfc() {
        QX qx = this.Ue;
        if (qx != null) {
            qx.eli(false);
        }
    }

    public void eli(com.bykv.vk.openvk.eli.eli.eli.aGH.eli eliVar) {
        if (eliVar instanceof eli) {
            this.KM = (eli) eliVar;
            nn();
        }
    }

    boolean aqO() {
        return this.KM != null;
    }

    void aGH() {
        this.aGH.eli(this);
        this.ui.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.ui.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ui.this.aqO()) {
                    if (ui.this.aqO == null || ui.this.aqO.getVisibility() != 0) {
                        ui.this.KM.eli(ui.this, view);
                    }
                }
            }
        });
    }

    public void Os(int i) {
        SSo.eli((View) this.Os, 0);
        com.bykv.vk.openvk.eli.eli.eli.MGA.DbA dbA = this.aGH;
        if (dbA != null) {
            dbA.setVisibility(i);
        }
    }

    public void aGH(boolean z) {
        this.VM = z;
        if (z) {
            com.bytedance.sdk.openadsdk.core.DbA.eli eliVar = this.qj;
            if (eliVar != null) {
                eliVar.eli(true);
            }
            com.bytedance.sdk.openadsdk.core.DbA.eli eliVar2 = this.nro;
            if (eliVar2 != null) {
                eliVar2.eli(true);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.DbA.eli eliVar3 = this.qj;
        if (eliVar3 != null) {
            eliVar3.eli(false);
        }
        com.bytedance.sdk.openadsdk.core.DbA.eli eliVar4 = this.nro;
        if (eliVar4 != null) {
            eliVar4.eli(false);
        }
    }

    public void eli(int i, int i2) {
        if (i == -1) {
            i = SSo.Os(this.ujq);
        }
        if (i <= 0) {
            return;
        }
        this.dV = i;
        if (bf() || aAs() || (this.Vy & 8) == 8) {
            this.nGm = i2;
        } else {
            this.nGm = ui(i);
        }
        DbA(this.dV, this.nGm);
    }

    public void DbA(boolean z, boolean z2) {
        ImageView imageView = this.ui;
        if (imageView != null) {
            if (z) {
                imageView.setImageDrawable(du.eli(this.ujq, "tt_play_movebar_textpage"));
            } else {
                imageView.setImageDrawable(du.eli(this.ujq, "tt_stop_movebar_textpage"));
            }
        }
    }

    public void DbA(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.Os.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (i == -1 || i == -2 || i > 0) {
            layoutParams.width = i;
        }
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.height = i2;
        }
        this.Os.setLayoutParams(layoutParams);
    }

    private int ui(int i) {
        if (this.QX <= 0 || this.Xb <= 0) {
            return 0;
        }
        int DbA = SSo.DbA(this.ujq, 228.0f);
        int DbA2 = SSo.DbA(this.ujq, 160.0f);
        int i2 = (int) (this.Xb * ((i * 1.0f) / this.QX));
        return i2 > DbA ? DbA : i2 < DbA2 ? DbA2 : i2;
    }

    public void Os(int i, int i2) {
        this.QX = i;
        this.Xb = i2;
    }

    public void Os(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.Os.getParent() == null) {
            viewGroup.addView(this.Os);
        }
        aGH(0);
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.DbA
    public View Os() {
        return this.Os;
    }

    public void kb() {
        ev evVar;
        SSo.MGA(this.MGA);
        SSo.MGA(this.kb);
        if (this.wC != null && (evVar = this.gG) != null && evVar.nY() != null && this.gG.nY().aAs() != null) {
            SSo.MGA(this.wC);
            com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.gG.nY().aAs(), this.gG.nY().Os(), this.gG.nY().DbA(), this.wC, this.gG);
        }
        if (this.ui.getVisibility() == 0) {
            SSo.eli((View) this.ui, 8);
        }
    }

    public void dV() {
        SSo.MGA(this.MGA);
        SSo.MGA(this.kb);
        if (this.ui.getVisibility() == 0) {
            SSo.eli((View) this.ui, 8);
        }
    }

    public void eli() {
        eli(false, this.bf);
        QX();
    }

    public void nGm() {
        SSo.eli((View) this.Os, 0);
        com.bykv.vk.openvk.eli.eli.eli.MGA.DbA dbA = this.aGH;
        if (dbA != null) {
            SSo.eli(dbA.getView(), 0);
        }
    }

    void QX() {
        try {
            SSo.eli(this.aAs, 8);
            SSo.eli((View) this.du, 8);
            SSo.eli(this.nlS, 8);
            SSo.eli((View) this.NU, 8);
            SSo.eli((View) this.nn, 8);
            SSo.eli((View) this.Dfc, 8);
            SSo.eli((View) this.aqO, 8);
        } catch (Exception unused) {
        }
    }

    public void Xb() {
        ImageView imageView = this.du;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        com.bytedance.sdk.openadsdk.core.widget.eli eliVar = this.NU;
        if (eliVar != null) {
            eliVar.setImageBitmap(null);
        }
    }

    private void MGA(int i) {
        SSo.eli(this.nlS, i);
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.DbA
    public void eli(boolean z) {
        this.Cp = z;
    }

    public void eli(ev evVar, WeakReference<Context> weakReference, boolean z) {
        final ev evVar2;
        String str;
        ev evVar3;
        ev evVar4;
        if (evVar == null) {
            return;
        }
        eli(false, this.bf);
        eli(this.Os, dV.eli());
        View view = this.aAs;
        if (view != null) {
            SSo.eli(view, 0);
        }
        ImageView imageView = this.du;
        if (imageView != null) {
            SSo.eli((View) imageView, 0);
        }
        SSo.eli(this.nlS, 0);
        if (this.du == null || (evVar4 = this.gG) == null || evVar4.nY() == null || this.gG.nY().aAs() == null) {
            evVar2 = evVar;
        } else {
            evVar2 = evVar;
            com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.gG.nY().aAs(), this.gG.nY().Os(), this.gG.nY().DbA(), this.du, evVar2);
        }
        if (!TextUtils.isEmpty(evVar2.kEI())) {
            str = evVar2.kEI();
        } else if (!TextUtils.isEmpty(evVar2.Pf())) {
            str = evVar2.Pf();
        } else if (TextUtils.isEmpty(evVar2.bU())) {
            str = "";
        } else {
            str = evVar2.bU();
        }
        if (this.NU != null && (evVar3 = this.gG) != null && evVar3.SjY() != null && this.gG.SjY().eli() != null) {
            SSo.eli((View) this.NU, 0);
            SSo.eli((View) this.nn, 4);
            ev evVar5 = this.gG;
            if (evVar5 != null && evVar5.Kv()) {
                com.bytedance.sdk.openadsdk.FC.aGH.eli(this.gG.SjY()).Os(1).eli(new com.bytedance.sdk.openadsdk.FC.DbA(evVar2, this.gG.SjY().eli(), new com.bytedance.sdk.component.ui.aqO() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.ui.5
                    @Override // com.bytedance.sdk.component.ui.aqO
                    public void eli(com.bytedance.sdk.component.ui.du duVar) {
                        Object DbA = duVar.DbA();
                        if (DbA != null) {
                            if (DbA instanceof Bitmap) {
                                if (ui.this.NU != null) {
                                    ui.this.NU.setImageBitmap((Bitmap) DbA);
                                }
                            } else if ((DbA instanceof Drawable) && ui.this.NU != null) {
                                if (DbA instanceof AnimatedImageDrawable) {
                                    ((AnimatedImageDrawable) DbA).start();
                                }
                                ui.this.NU.setImageDrawable((Drawable) DbA);
                            }
                            com.bytedance.sdk.openadsdk.aGH.Os.DbA(ui.this.gG, ui.this.gG != null ? dZ.Os(evVar2.cK()) : null, "load_vast_icon_success", (JSONObject) null);
                        }
                    }

                    @Override // com.bytedance.sdk.component.ui.aqO
                    public void eli(int i, String str2, Throwable th) {
                        ui.this.eli(i, str2, evVar2);
                    }
                }));
                if (this.gG.io() != null && this.gG.io().DbA() != null) {
                    this.gG.io().DbA().DbA(0L);
                }
            } else {
                com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.gG.SjY(), this.NU, evVar2);
            }
            ev evVar6 = this.gG;
            if (evVar6 != null && evVar6.Kv()) {
                try {
                    this.NU.setTag(570425345, "VAST_ICON");
                } catch (Throwable unused) {
                }
            }
            ev evVar7 = this.gG;
            if (evVar7 != null && evVar7.io() != null && this.gG.io().DbA() != null) {
                final com.bytedance.sdk.openadsdk.core.du.DbA DbA = this.gG.io().DbA();
                com.bytedance.sdk.openadsdk.core.widget.eli eliVar = this.NU;
                if (eliVar != null) {
                    eliVar.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.ui.6
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.openadsdk.core.du.DbA dbA;
                            if (ui.this.NU == null || !ui.this.NU.isShown() || (dbA = DbA) == null) {
                                return;
                            }
                            dbA.DbA(ui.this.getVideoProgress());
                        }
                    });
                }
            }
            if (gG()) {
                this.NU.setOnClickListener(this.nro);
                this.NU.setOnTouchListener(this.nro);
            } else {
                this.NU.setOnClickListener(this.qj);
                this.NU.setOnTouchListener(this.qj);
            }
        } else if (!TextUtils.isEmpty(str)) {
            SSo.eli((View) this.NU, 4);
            SSo.eli((View) this.nn, 0);
            TextView textView = this.nn;
            if (textView != null) {
                textView.setText(str.substring(0, 1));
                if (gG()) {
                    this.nn.setOnClickListener(this.nro);
                    this.nn.setOnTouchListener(this.nro);
                } else {
                    this.nn.setOnClickListener(this.qj);
                    this.nn.setOnTouchListener(this.qj);
                }
            }
        }
        if (this.Dfc != null && !TextUtils.isEmpty(str)) {
            this.Dfc.setText(str);
            this.Dfc.setTag(570425345, "VAST_TITLE");
        }
        SSo.eli((View) this.Dfc, 0);
        SSo.eli((View) this.aqO, 0);
        String GMu = evVar2.GMu();
        if (TextUtils.isEmpty(GMu)) {
            int yw = evVar2.yw();
            if (yw != 2 && yw != 3) {
                if (yw == 4) {
                    GMu = com.bytedance.sdk.component.utils.ev.eli(this.ujq, "tt_video_download_apk");
                } else if (yw == 5) {
                    GMu = com.bytedance.sdk.component.utils.ev.eli(this.ujq, "tt_video_dial_phone");
                } else if (yw != 8) {
                    GMu = com.bytedance.sdk.component.utils.ev.eli(this.ujq, "tt_video_mobile_go_detail");
                }
            }
            GMu = com.bytedance.sdk.component.utils.ev.eli(this.ujq, "tt_video_mobile_go_detail");
        }
        TextView textView2 = this.aqO;
        if (textView2 != null) {
            textView2.setText(GMu);
            this.aqO.setOnClickListener(this.qj);
            this.aqO.setOnTouchListener(this.qj);
        }
        if (this.Cp) {
            return;
        }
        MGA(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(final int i, final String str, final ev evVar) {
        com.bytedance.sdk.openadsdk.aGH.Os.eli(new wC("load_vast_icon_fail") { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.ui.7
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(AndroidBridgeConstants.ERROR_CODE, i);
                    jSONObject.put("description", i + ":" + str);
                    jSONObject.put("url", ui.this.gG.SjY().eli());
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(ui.this.gG, ui.this.gG != null ? dZ.Os(evVar.cK()) : null, "load_vast_icon_fail", jSONObject);
            }
        });
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.DbA
    public void DbA() {
        SSo.ui(this.MGA);
        SSo.ui(this.kb);
        ImageView imageView = this.wC;
        if (imageView != null) {
            SSo.ui(imageView);
        }
    }

    public void wC() {
        SSo.ui(this.MGA);
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.MGA.eli
    public void eli(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.aGH.getHolder()) {
            return;
        }
        this.CMM = true;
        if (aqO()) {
            this.KM.eli(this, surfaceHolder);
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.MGA.eli
    public void eli(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder != this.aGH.getHolder()) {
            return;
        }
        aqO();
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.MGA.eli
    public void DbA(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.aGH.getHolder()) {
            return;
        }
        this.CMM = false;
        if (aqO()) {
            this.KM.DbA(this, surfaceHolder);
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.MGA.eli
    public void eli(SurfaceTexture surfaceTexture, int i, int i2) {
        this.CMM = true;
        if (aqO()) {
            this.KM.eli(this, surfaceTexture);
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.MGA.eli
    public boolean eli(SurfaceTexture surfaceTexture) {
        this.CMM = false;
        if (!aqO()) {
            return true;
        }
        this.KM.DbA(this, surfaceTexture);
        return true;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.MGA.eli
    public void DbA(SurfaceTexture surfaceTexture) {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.oWW;
        if (os != null) {
            os.eli(surfaceTexture);
        }
    }

    public void FC() {
        aGH(8);
        if (Vy()) {
            this.aGH.setVisibility(8);
        }
        ImageView imageView = this.wC;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        aGH(8);
        SSo.eli(this.aAs, 8);
        SSo.eli((View) this.du, 8);
        SSo.eli(this.nlS, 8);
        SSo.eli((View) this.NU, 8);
        SSo.eli((View) this.nn, 8);
        SSo.eli((View) this.Dfc, 8);
        QX qx = this.Ue;
        if (qx != null) {
            qx.eli(true);
        }
    }

    public boolean bf() {
        return this.bf;
    }

    public void eli(boolean z, boolean z2, boolean z3) {
        SSo.eli((View) this.ui, (!z || this.MGA.getVisibility() == 0) ? 8 : 0);
    }

    public void eli(boolean z, boolean z2) {
        SSo.eli((View) this.ui, 8);
    }

    public void du() {
        eli(true, false);
    }

    public boolean CMM() {
        return this.CMM;
    }

    public void aGH(int i) {
        this.ev = i;
        SSo.eli((View) this.Os, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.nGm.eli
    public boolean ev() {
        QX qx = this.Ue;
        return qx != null && qx.eli();
    }

    boolean Vy() {
        return (this.Vy & 4) != 4 || this.bf;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.DbA
    public void eli(Drawable drawable) {
        ViewGroup viewGroup = this.Os;
        if (viewGroup != null) {
            viewGroup.setBackgroundDrawable(drawable);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.DbA.eli.InterfaceC0172eli
    public long getVideoProgress() {
        if (this.eU <= 0) {
            ev evVar = this.gG;
            if (evVar != null && evVar.nY() != null) {
                this.eU = (long) (this.gG.nY().MGA() * 1000.0d);
            }
            com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.oWW;
            if (os != null) {
                this.eU = os.FC();
            }
        }
        return this.eU;
    }
}
