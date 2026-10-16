package com.bytedance.sdk.openadsdk.core.wC;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.DbA.NU;
import com.bytedance.sdk.component.adexpress.DbA.aAs;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.Vy.DbA.ui;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.Cp;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import com.bytedance.sdk.openadsdk.core.DbA.eli;
import com.bytedance.sdk.openadsdk.core.Os.kb;
import com.bytedance.sdk.openadsdk.core.aAs.MGA.eli;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nro;
import com.bytedance.sdk.openadsdk.core.qj;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.moloco.sdk.internal.services.init.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Xb extends com.bytedance.sdk.openadsdk.core.ui.Os implements com.bytedance.sdk.component.adexpress.DbA.Dfc, com.bytedance.sdk.component.adexpress.DbA.wC, com.bytedance.sdk.component.adexpress.dynamic.aGH, eli.InterfaceC0172eli, Dfc {
    private final SparseArray<Os.eli> BDs;
    private int BH;
    public boolean CMM;
    private String Cp;
    private float DE;
    private int DbA;
    protected boolean Dfc;
    protected final Context FC;
    private final ViewTreeObserver.OnScrollChangedListener FS;
    private float GB;
    private long GMY;
    public com.bytedance.sdk.component.adexpress.DbA.aGH<? extends View> KM;
    private wC MGA;
    private float Mc;
    public FrameLayout NU;
    private com.bytedance.sdk.openadsdk.Os.Os Os;
    private com.bytedance.sdk.component.adexpress.DbA.aqO QI;
    protected String QX;
    private final AtomicBoolean SSo;
    private List<com.bytedance.sdk.component.adexpress.DbA.aAs> TfR;
    protected com.bytedance.sdk.component.adexpress.DbA.DbA Ue;
    private Os Uv;
    private float VM;
    boolean Vy;
    private Vy WfR;
    protected HashSet<String> Xb;
    private com.bytedance.sdk.component.adexpress.DbA.FC Yw;
    private final Runnable Za;
    protected String aAs;
    private TTDislikeDialogAbstract aGH;
    protected com.bytedance.sdk.component.adexpress.DbA.Os aqO;
    protected ViewGroup bf;
    private kb.eli cyF;
    boolean dV;
    private CMM dZ;
    protected AdSlot du;
    private boolean eU;
    private boolean eli;
    int ev;
    public com.bytedance.sdk.openadsdk.aGH.kb gG;
    private float gHb;
    private final Runnable ikX;
    private final Runnable jh;
    private FC kb;
    private com.bytedance.sdk.component.adexpress.DbA.MGA mm;
    protected int nGm;
    protected com.bytedance.sdk.openadsdk.core.model.ev nlS;
    protected boolean nn;
    private com.bytedance.sdk.openadsdk.core.aAs.Os.DbA nro;
    private com.bytedance.sdk.openadsdk.aGH.aGH.ui oWW;
    private com.bytedance.sdk.openadsdk.core.aAs.DbA.kb oc;
    private aAs.eli ow;
    private String qj;
    private com.bytedance.sdk.component.adexpress.DbA.NU qyC;
    private com.bytedance.sdk.openadsdk.core.Os.FC rH;
    private com.bytedance.sdk.openadsdk.core.aAs.MGA.Os rQ;
    private ThemeStatusBroadcastReceiver tGZ;
    private float tLO;
    private PAGExpressAdWrapperListener ui;
    long ujq;
    private String wC;

    public void DbA() {
    }

    public void DbA(int i) {
    }

    protected boolean DbA(com.bytedance.sdk.component.adexpress.DbA.nn nnVar) {
        return true;
    }

    public boolean DbA(JSONObject jSONObject) {
        return false;
    }

    protected boolean FC() {
        return true;
    }

    public void MGA() {
    }

    public long Os() {
        return 0L;
    }

    protected void Os(JSONObject jSONObject) {
    }

    public long aGH() {
        return 0L;
    }

    public void du() {
    }

    public void eli() {
    }

    public void eli(int i) {
    }

    public void eli(int i, com.bytedance.sdk.component.adexpress.DbA.nn nnVar) {
    }

    public void eli(int i, String str) {
    }

    protected void eli(NU.eli eliVar) {
    }

    public void eli(String str, JSONObject jSONObject) {
    }

    public void eli(boolean z, String str) {
    }

    public boolean eli(JSONObject jSONObject) {
        return false;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.aGH
    public void onvideoComplate() {
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.aGH
    public void setTimeUpdate(int i) {
    }

    public int ui() {
        return 0;
    }

    protected boolean wC() {
        return true;
    }

    public void setJsbLandingPageOpenListener(com.bytedance.sdk.openadsdk.core.widget.ui uiVar) {
        if (this.WfR != null && getJsObject() != null) {
            getJsObject().eli(uiVar);
        }
        com.bytedance.sdk.openadsdk.core.aAs.MGA.Os os = this.rQ;
        if (os != null) {
            os.eli(uiVar);
        }
    }

    public com.bytedance.sdk.openadsdk.aGH.kb getAdShowTime() {
        return this.gG;
    }

    public void setClosedListenerKey(String str) {
        this.Cp = str;
        Os os = this.Uv;
        if (os != null) {
            os.eli(str);
        }
    }

    public Os getBrandBannerController() {
        return this.Uv;
    }

    public String getClosedListenerKey() {
        return this.Cp;
    }

    public void setBannerClickClosedListener(kb.eli eliVar) {
        this.cyF = eliVar;
    }

    public Xb(Context context, com.bytedance.sdk.openadsdk.core.model.ev evVar, AdSlot adSlot, String str) {
        super(context);
        this.eli = true;
        this.DbA = 0;
        this.aAs = "embeded_ad";
        this.wC = null;
        this.Dfc = false;
        this.dV = true;
        this.nGm = -1;
        this.qj = "";
        this.CMM = false;
        this.eU = true;
        this.ev = -1;
        this.gG = new com.bytedance.sdk.openadsdk.aGH.kb();
        this.ujq = 0L;
        this.SSo = new AtomicBoolean(false);
        this.FS = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.wC.Xb.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (Xb.this.dV && Xb.this.FC()) {
                    Xb.this.ujq();
                    Xb xb = Xb.this;
                    xb.removeCallbacks(xb.jh);
                    Xb xb2 = Xb.this;
                    xb2.postDelayed(xb2.jh, 500L);
                }
            }
        };
        this.jh = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wC.Xb.2
            @Override // java.lang.Runnable
            public void run() {
                if (nro.eli(Xb.this, 0, 5, false)) {
                    Xb xb = Xb.this;
                    xb.MGA(xb.getVisibility());
                } else {
                    Xb.this.MGA(8);
                }
            }
        };
        this.Za = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wC.Xb.3
            @Override // java.lang.Runnable
            public void run() {
                Xb.this.MGA(0);
            }
        };
        this.ikX = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wC.Xb.4
            @Override // java.lang.Runnable
            public void run() {
                Xb.this.MGA(8);
            }
        };
        this.BH = 8;
        this.BDs = new SparseArray<>();
        this.tLO = -1.0f;
        this.gHb = -1.0f;
        this.Mc = -1.0f;
        this.DE = -1.0f;
        this.GMY = 0L;
        this.aAs = str;
        this.FC = context;
        this.nlS = evVar;
        this.du = adSlot;
        this.CMM = false;
        kb();
    }

    public Xb(Context context, com.bytedance.sdk.openadsdk.core.model.ev evVar, AdSlot adSlot, String str, boolean z, boolean z2) {
        super(context);
        this.eli = true;
        this.DbA = 0;
        this.aAs = "embeded_ad";
        this.wC = null;
        this.Dfc = false;
        this.dV = true;
        this.nGm = -1;
        this.qj = "";
        this.CMM = false;
        this.eU = true;
        this.ev = -1;
        this.gG = new com.bytedance.sdk.openadsdk.aGH.kb();
        this.ujq = 0L;
        this.SSo = new AtomicBoolean(false);
        this.FS = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.wC.Xb.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (Xb.this.dV && Xb.this.FC()) {
                    Xb.this.ujq();
                    Xb xb = Xb.this;
                    xb.removeCallbacks(xb.jh);
                    Xb xb2 = Xb.this;
                    xb2.postDelayed(xb2.jh, 500L);
                }
            }
        };
        this.jh = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wC.Xb.2
            @Override // java.lang.Runnable
            public void run() {
                if (nro.eli(Xb.this, 0, 5, false)) {
                    Xb xb = Xb.this;
                    xb.MGA(xb.getVisibility());
                } else {
                    Xb.this.MGA(8);
                }
            }
        };
        this.Za = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wC.Xb.3
            @Override // java.lang.Runnable
            public void run() {
                Xb.this.MGA(0);
            }
        };
        this.ikX = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wC.Xb.4
            @Override // java.lang.Runnable
            public void run() {
                Xb.this.MGA(8);
            }
        };
        this.BH = 8;
        this.BDs = new SparseArray<>();
        this.tLO = -1.0f;
        this.gHb = -1.0f;
        this.Mc = -1.0f;
        this.DE = -1.0f;
        this.GMY = 0L;
        this.aAs = str;
        this.FC = context;
        this.nlS = evVar;
        this.du = adSlot;
        this.CMM = z;
        this.eU = z2;
        kb();
    }

    protected void kb() {
        this.Xb = new HashSet<>();
        this.tGZ = new ThemeStatusBroadcastReceiver();
        AdSlot adSlot = this.du;
        if (adSlot != null) {
            this.VM = adSlot.getExpressViewAcceptedWidth();
            this.GB = this.du.getExpressViewAcceptedHeight();
            NU();
            this.wC = this.du.getCodeId();
            if (TextUtils.equals(this.aAs, "fullscreen_interstitial_ad")) {
                this.ev = this.nlS.Fxk();
            } else if (TextUtils.equals(this.aAs, "rewarded_video")) {
                this.ev = this.nlS.YO();
            } else if (TextUtils.equals(this.aAs, "open_ad")) {
                com.bytedance.sdk.openadsdk.core.model.ev evVar = this.nlS;
                if (evVar != null && evVar.eli() >= 0) {
                    this.ev = this.nlS.eli();
                } else {
                    this.ev = com.bytedance.sdk.openadsdk.core.dV.aGH().bf(this.wC);
                }
                if (this.ev < 0) {
                    this.ev = 5;
                }
            }
        }
        setBackgroundColor(0);
        if (this.nlS.Jt()) {
            this.Uv = new Os(this.FC, this, this.nlS, this.aAs);
            return;
        }
        nn();
        this.TfR = new ArrayList();
        Dfc();
        com.bytedance.sdk.component.adexpress.DbA.aqO aqo = this.QI;
        if (aqo != null) {
            this.WfR = (Vy) aqo.DbA();
        }
        qj jsObject = getJsObject();
        if (jsObject != null) {
            jsObject.MGA(this.aAs);
        }
    }

    private void NU() {
        ev.eli RY = this.nlS.RY();
        if (!TextUtils.equals(this.aAs, "embeded_ad") || RY == null) {
            return;
        }
        String aAs = RY.aAs();
        if (TextUtils.isEmpty(aAs)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(aAs);
            int optInt = jSONObject.optInt("width");
            int optInt2 = jSONObject.optInt("height");
            if (optInt == 0 || optInt2 == 0) {
                return;
            }
            this.GB = optInt2;
            this.VM = optInt;
        } catch (Exception unused) {
        }
    }

    public com.bytedance.sdk.component.FC.MGA getWebView() {
        Vy vy = this.WfR;
        if (vy == null) {
            return null;
        }
        return vy.eli();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(26:0|1|(2:2|3)|(2:5|(22:7|8|9|10|(2:12|(13:14|15|16|(2:22|23)|47|25|(1:27)(1:45)|28|(1:44)|32|(3:40|(1:42)|43)(1:36)|37|38))|50|15|16|(4:18|20|22|23)|47|25|(0)(0)|28|(1:30)|44|32|(1:34)|40|(0)|43|37|38))|53|8|9|10|(0)|50|15|16|(0)|47|25|(0)(0)|28|(0)|44|32|(0)|40|(0)|43|37|38) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007f, code lost:
    
        if (r12.nlS.bBQ() != 3) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0083, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004b A[Catch: Exception -> 0x0083, TRY_LEAVE, TryCatch #1 {Exception -> 0x0083, blocks: (B:10:0x0043, B:12:0x004b), top: B:9:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066 A[Catch: Exception -> 0x0084, TryCatch #0 {Exception -> 0x0084, blocks: (B:16:0x005a, B:18:0x0066, B:20:0x006f, B:22:0x0078), top: B:15:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void nn() {
        long j;
        boolean z;
        NU.eli eliVar;
        ev.eli RY;
        this.oWW = new com.bytedance.sdk.openadsdk.aGH.nGm(1, this.aAs, this.nlS);
        this.Yw = new NU(this.oWW, this.aAs, this.nlS, this.wC);
        final boolean qWy = this.nlS.qWy();
        try {
            RY = this.nlS.RY();
        } catch (Exception unused) {
        }
        if (RY != null) {
            String FC = RY.FC();
            if (!TextUtils.isEmpty(FC)) {
                j = new JSONObject(FC).optLong("render_delay_time");
                if (!com.bytedance.sdk.openadsdk.core.model.ev.ui(this.nlS)) {
                    if (com.bytedance.sdk.openadsdk.core.dV.aGH().nlS(this.wC) == 1) {
                        z = true;
                        if (com.bytedance.sdk.openadsdk.core.settings.NU.nY().NU(this.wC) && this.nlS.mm() != 5 && this.nlS.mm() != 6) {
                        }
                        z = true;
                        long min = Math.min(Math.max(j, 0L), 10000L);
                        int renderTimeout = getRenderTimeout();
                        double MGA = this.nlS.nY() != null ? this.nlS.nY().MGA() * this.nlS.nY().CMM() : 0.0d;
                        int i = this.ev;
                        this.Vy = i == -1 && i < ((int) MGA);
                        if (!com.bytedance.sdk.openadsdk.core.aAs.aGH.eli(this.nlS) || com.bytedance.sdk.openadsdk.core.aAs.aGH.DbA(this.nlS)) {
                            eli.C0181eli c0181eli = new eli.C0181eli();
                            if (com.bytedance.sdk.openadsdk.core.aAs.aGH.eli(this.nlS)) {
                                c0181eli.eli(com.bytedance.sdk.openadsdk.core.aAs.aGH.eli(this.nlS, this.aAs));
                            }
                            c0181eli.eli((com.bytedance.adsdk.ugeno.core.nGm) this.Yw);
                            c0181eli.eli(this.VM);
                            c0181eli.DbA(this.GB);
                            eliVar = c0181eli;
                        } else {
                            eliVar = new NU.eli();
                        }
                        eliVar.ui(qWy);
                        eliVar.eli(this.aAs).DbA(this.nlS.umh()).Os(this.nlS.WA()).aGH(this.nlS.eu()).eli(this.Yw).aGH(this.nlS.UJ()).eli(renderTimeout).DbA(this.nlS.iiz()).Os(this.eU).DbA(this.nlS.Ca()).eli(min).Os(this.nlS.yw()).eli(com.bytedance.sdk.openadsdk.core.wC.eli.DbA.DbA(this.nlS)).aGH(z).ui(this.ev).eli(this.Vy).eli(MGA).MGA(com.bytedance.sdk.openadsdk.core.settings.NU.nY().GMY()).MGA(com.bytedance.sdk.openadsdk.bf.eli.eli("inject_data_reuse_open", 0)).kb(this.nlS.EM().eli()).wC(this.nlS.EM().DbA()).eli(new com.bytedance.sdk.component.adexpress.DbA.ui() { // from class: com.bytedance.sdk.openadsdk.core.wC.Xb.5
                            @Override // com.bytedance.sdk.component.adexpress.DbA.ui
                            public JSONObject eli() {
                                try {
                                    if (Xb.this.nlS == null) {
                                        Xb.this.qj = "material is null";
                                        return null;
                                    }
                                    if (qWy) {
                                        Xb.this.dZ = new CMM();
                                        JSONObject eli = com.bytedance.sdk.openadsdk.core.wC.eli.DbA.eli(Xb.this.VM, Xb.this.GB, Xb.this.Dfc, Xb.this.nlS, Xb.this.aAs, Xb.this.dZ);
                                        Xb.this.qj = com.bytedance.sdk.openadsdk.core.wC.eli.DbA.eli();
                                        return eli;
                                    }
                                    if (com.bytedance.sdk.openadsdk.core.aAs.aGH.eli(Xb.this.nlS)) {
                                        Xb.this.dZ = new CMM();
                                        JSONObject eli2 = com.bytedance.sdk.openadsdk.core.aAs.aGH.eli(Xb.this.nlS, Xb.this.dZ);
                                        Xb.this.qj = com.bytedance.sdk.openadsdk.core.aAs.aGH.eli();
                                        return eli2;
                                    }
                                    JSONObject eli3 = com.bytedance.sdk.openadsdk.core.wC.eli.DbA.eli(Xb.this.VM, Xb.this.GB, Xb.this.Dfc, Xb.this.nlS);
                                    Xb.this.Os(eli3);
                                    return eli3;
                                } catch (Throwable unused2) {
                                    return null;
                                }
                            }
                        });
                        eli(eliVar);
                        this.qyC = eliVar.eli();
                    }
                }
                z = false;
                if (com.bytedance.sdk.openadsdk.core.settings.NU.nY().NU(this.wC)) {
                }
                z = true;
                long min2 = Math.min(Math.max(j, 0L), 10000L);
                int renderTimeout2 = getRenderTimeout();
                if (this.nlS.nY() != null) {
                }
                int i2 = this.ev;
                this.Vy = i2 == -1 && i2 < ((int) MGA);
                if (!com.bytedance.sdk.openadsdk.core.aAs.aGH.eli(this.nlS)) {
                }
                eli.C0181eli c0181eli2 = new eli.C0181eli();
                if (com.bytedance.sdk.openadsdk.core.aAs.aGH.eli(this.nlS)) {
                }
                c0181eli2.eli((com.bytedance.adsdk.ugeno.core.nGm) this.Yw);
                c0181eli2.eli(this.VM);
                c0181eli2.DbA(this.GB);
                eliVar = c0181eli2;
                eliVar.ui(qWy);
                eliVar.eli(this.aAs).DbA(this.nlS.umh()).Os(this.nlS.WA()).aGH(this.nlS.eu()).eli(this.Yw).aGH(this.nlS.UJ()).eli(renderTimeout2).DbA(this.nlS.iiz()).Os(this.eU).DbA(this.nlS.Ca()).eli(min2).Os(this.nlS.yw()).eli(com.bytedance.sdk.openadsdk.core.wC.eli.DbA.DbA(this.nlS)).aGH(z).ui(this.ev).eli(this.Vy).eli(MGA).MGA(com.bytedance.sdk.openadsdk.core.settings.NU.nY().GMY()).MGA(com.bytedance.sdk.openadsdk.bf.eli.eli("inject_data_reuse_open", 0)).kb(this.nlS.EM().eli()).wC(this.nlS.EM().DbA()).eli(new com.bytedance.sdk.component.adexpress.DbA.ui() { // from class: com.bytedance.sdk.openadsdk.core.wC.Xb.5
                    @Override // com.bytedance.sdk.component.adexpress.DbA.ui
                    public JSONObject eli() {
                        try {
                            if (Xb.this.nlS == null) {
                                Xb.this.qj = "material is null";
                                return null;
                            }
                            if (qWy) {
                                Xb.this.dZ = new CMM();
                                JSONObject eli = com.bytedance.sdk.openadsdk.core.wC.eli.DbA.eli(Xb.this.VM, Xb.this.GB, Xb.this.Dfc, Xb.this.nlS, Xb.this.aAs, Xb.this.dZ);
                                Xb.this.qj = com.bytedance.sdk.openadsdk.core.wC.eli.DbA.eli();
                                return eli;
                            }
                            if (com.bytedance.sdk.openadsdk.core.aAs.aGH.eli(Xb.this.nlS)) {
                                Xb.this.dZ = new CMM();
                                JSONObject eli2 = com.bytedance.sdk.openadsdk.core.aAs.aGH.eli(Xb.this.nlS, Xb.this.dZ);
                                Xb.this.qj = com.bytedance.sdk.openadsdk.core.aAs.aGH.eli();
                                return eli2;
                            }
                            JSONObject eli3 = com.bytedance.sdk.openadsdk.core.wC.eli.DbA.eli(Xb.this.VM, Xb.this.GB, Xb.this.Dfc, Xb.this.nlS);
                            Xb.this.Os(eli3);
                            return eli3;
                        } catch (Throwable unused2) {
                            return null;
                        }
                    }
                });
                eli(eliVar);
                this.qyC = eliVar.eli();
            }
        }
        j = 0;
        if (!com.bytedance.sdk.openadsdk.core.model.ev.ui(this.nlS)) {
        }
        z = false;
        if (com.bytedance.sdk.openadsdk.core.settings.NU.nY().NU(this.wC)) {
        }
        z = true;
        long min22 = Math.min(Math.max(j, 0L), 10000L);
        int renderTimeout22 = getRenderTimeout();
        if (this.nlS.nY() != null) {
        }
        int i22 = this.ev;
        this.Vy = i22 == -1 && i22 < ((int) MGA);
        if (!com.bytedance.sdk.openadsdk.core.aAs.aGH.eli(this.nlS)) {
        }
        eli.C0181eli c0181eli22 = new eli.C0181eli();
        if (com.bytedance.sdk.openadsdk.core.aAs.aGH.eli(this.nlS)) {
        }
        c0181eli22.eli((com.bytedance.adsdk.ugeno.core.nGm) this.Yw);
        c0181eli22.eli(this.VM);
        c0181eli22.DbA(this.GB);
        eliVar = c0181eli22;
        eliVar.ui(qWy);
        eliVar.eli(this.aAs).DbA(this.nlS.umh()).Os(this.nlS.WA()).aGH(this.nlS.eu()).eli(this.Yw).aGH(this.nlS.UJ()).eli(renderTimeout22).DbA(this.nlS.iiz()).Os(this.eU).DbA(this.nlS.Ca()).eli(min22).Os(this.nlS.yw()).eli(com.bytedance.sdk.openadsdk.core.wC.eli.DbA.DbA(this.nlS)).aGH(z).ui(this.ev).eli(this.Vy).eli(MGA).MGA(com.bytedance.sdk.openadsdk.core.settings.NU.nY().GMY()).MGA(com.bytedance.sdk.openadsdk.bf.eli.eli("inject_data_reuse_open", 0)).kb(this.nlS.EM().eli()).wC(this.nlS.EM().DbA()).eli(new com.bytedance.sdk.component.adexpress.DbA.ui() { // from class: com.bytedance.sdk.openadsdk.core.wC.Xb.5
            @Override // com.bytedance.sdk.component.adexpress.DbA.ui
            public JSONObject eli() {
                try {
                    if (Xb.this.nlS == null) {
                        Xb.this.qj = "material is null";
                        return null;
                    }
                    if (qWy) {
                        Xb.this.dZ = new CMM();
                        JSONObject eli = com.bytedance.sdk.openadsdk.core.wC.eli.DbA.eli(Xb.this.VM, Xb.this.GB, Xb.this.Dfc, Xb.this.nlS, Xb.this.aAs, Xb.this.dZ);
                        Xb.this.qj = com.bytedance.sdk.openadsdk.core.wC.eli.DbA.eli();
                        return eli;
                    }
                    if (com.bytedance.sdk.openadsdk.core.aAs.aGH.eli(Xb.this.nlS)) {
                        Xb.this.dZ = new CMM();
                        JSONObject eli2 = com.bytedance.sdk.openadsdk.core.aAs.aGH.eli(Xb.this.nlS, Xb.this.dZ);
                        Xb.this.qj = com.bytedance.sdk.openadsdk.core.aAs.aGH.eli();
                        return eli2;
                    }
                    JSONObject eli3 = com.bytedance.sdk.openadsdk.core.wC.eli.DbA.eli(Xb.this.VM, Xb.this.GB, Xb.this.Dfc, Xb.this.nlS);
                    Xb.this.Os(eli3);
                    return eli3;
                } catch (Throwable unused2) {
                    return null;
                }
            }
        });
        eli(eliVar);
        this.qyC = eliVar.eli();
    }

    public String getUgenTemplateErrorReason() {
        return this.qj;
    }

    protected int getRenderTimeout() {
        return com.bytedance.sdk.openadsdk.core.dV.aGH().Vy();
    }

    private void Dfc() {
        if (this.nlS.cK() == 1 && this.nlS.Kv()) {
            com.bytedance.sdk.component.adexpress.DbA.MGA mga = new com.bytedance.sdk.component.adexpress.DbA.MGA(this.FC, this.qyC, new bf(this, this.tGZ, this.qyC));
            this.mm = mga;
            this.TfR.add(mga);
            this.ow = new com.bytedance.sdk.component.adexpress.DbA.nlS(this.TfR, this.Yw);
            return;
        }
        if (GB()) {
            aqO();
            return;
        }
        try {
            dV();
            this.WfR = new Vy(this.FC, this.qyC, this.tGZ, this.oWW, this.nlS);
            com.bytedance.sdk.component.adexpress.DbA.aqO aqo = new com.bytedance.sdk.component.adexpress.DbA.aqO(this.FC, this.qyC, this.WfR, this);
            this.QI = aqo;
            this.TfR.add(aqo);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.Xb.eli("NativeExpressView", "NativeExpressView dynamicRender fail", e);
        }
        com.bytedance.sdk.component.adexpress.DbA.MGA mga2 = new com.bytedance.sdk.component.adexpress.DbA.MGA(this.FC, this.qyC, new bf(this, this.tGZ, this.qyC));
        this.mm = mga2;
        this.TfR.add(mga2);
        this.ow = new com.bytedance.sdk.component.adexpress.DbA.nlS(this.TfR, this.Yw);
    }

    private void aqO() {
        this.DbA = this.nlS.rH();
        try {
            dV();
            gG();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.Xb.eli("NativeExpressView", "NativeExpressView dynamicRender fail", e);
        }
        boolean z = this.nlS.eEH() == 1;
        this.eli = z;
        if (z) {
            com.bytedance.sdk.component.adexpress.DbA.MGA mga = new com.bytedance.sdk.component.adexpress.DbA.MGA(this.FC, this.qyC, new bf(this, this.tGZ, this.qyC));
            this.mm = mga;
            this.TfR.add(mga);
        }
        new StringBuilder("initRender: mRenderSequenceType is ").append(this.DbA).append(", mInterceptors is ").append(this.TfR);
        this.ow = new com.bytedance.sdk.component.adexpress.DbA.nlS(this.TfR, this.Yw);
    }

    private void dV() {
        if (com.bytedance.sdk.openadsdk.core.nn.ui()) {
            return;
        }
        nlS.eli();
    }

    private void gG() {
        com.bytedance.sdk.openadsdk.core.model.ev evVar = this.nlS;
        if (evVar == null || evVar.cK() != 1 || this.nlS.BDs() == 2) {
            com.bytedance.sdk.openadsdk.core.MGA.eli.eli eliVar = new com.bytedance.sdk.openadsdk.core.MGA.eli.eli();
            int i = this.DbA;
            if (i != 0) {
                if (i == 3) {
                    com.bytedance.sdk.component.adexpress.dynamic.ui.kb kbVar = new com.bytedance.sdk.component.adexpress.dynamic.ui.kb();
                    com.bytedance.sdk.component.adexpress.DbA.DbA dbA = new com.bytedance.sdk.component.adexpress.DbA.DbA(this.FC.getApplicationContext(), this.qyC, this.tGZ, this.CMM, kbVar, this, eliVar, new MGA(this.FC, this.tGZ, this.CMM, kbVar, this.qyC, eliVar));
                    this.Ue = dbA;
                    this.TfR.add(dbA);
                    return;
                }
                if (i == 7) {
                    this.rQ = new com.bytedance.sdk.openadsdk.core.aAs.MGA.Os(this.FC, this.nlS, this.CMM, (com.bytedance.sdk.openadsdk.core.aAs.MGA.eli) this.qyC, this);
                    com.bytedance.sdk.openadsdk.core.aAs.DbA.kb kbVar2 = new com.bytedance.sdk.openadsdk.core.aAs.DbA.kb(this.FC, this.rQ, this, this.qyC);
                    this.oc = kbVar2;
                    kbVar2.eli(this);
                    this.TfR.add(this.oc);
                    return;
                }
                if (i != 9) {
                    if (i != 10) {
                        return;
                    }
                    this.rQ = new com.bytedance.sdk.openadsdk.core.aAs.MGA.MGA(this.FC, this.nlS, this.CMM, (com.bytedance.sdk.openadsdk.core.aAs.MGA.eli) this.qyC, this);
                    com.bytedance.sdk.openadsdk.core.aAs.DbA.kb kbVar3 = new com.bytedance.sdk.openadsdk.core.aAs.DbA.kb(this.FC, this.rQ, this, this.qyC);
                    this.oc = kbVar3;
                    kbVar3.eli(this);
                    this.TfR.add(this.oc);
                    return;
                }
            }
            this.WfR = new Vy(this.FC, this.qyC, this.tGZ, this.oWW, this.nlS);
            com.bytedance.sdk.component.adexpress.DbA.aqO aqo = new com.bytedance.sdk.component.adexpress.DbA.aqO(this.FC, this.qyC, this.WfR, this);
            this.QI = aqo;
            this.TfR.add(aqo);
        }
    }

    public void setOuterDislike(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        eli eliVar;
        com.bytedance.sdk.component.adexpress.DbA.aGH<? extends View> agh = this.KM;
        if (agh != null && (agh instanceof bf) && (eliVar = (eli) agh.ui()) != null) {
            eliVar.setDislikeOuter(tTDislikeDialogAbstract);
        }
        Os os = this.Uv;
        if (os != null) {
            os.eli(tTDislikeDialogAbstract);
        }
        this.aGH = tTDislikeDialogAbstract;
    }

    public void setDislike(com.bytedance.sdk.openadsdk.Os.Os os) {
        eli eliVar;
        com.bytedance.sdk.component.adexpress.DbA.aGH<? extends View> agh = this.KM;
        if (agh != null && (agh instanceof bf) && (eliVar = (eli) agh.ui()) != null) {
            eliVar.setDislikeInner(os);
        }
        Os os2 = this.Uv;
        if (os2 != null) {
            os2.eli(os);
        }
        this.Os = os;
    }

    public void setExpressInteractionListener(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
        this.ui = pAGExpressAdWrapperListener;
        Os os = this.Uv;
        if (os != null) {
            os.eli(pAGExpressAdWrapperListener);
        }
    }

    public void setClickCreativeListener(wC wCVar) {
        this.MGA = wCVar;
        if (wCVar != null) {
            wCVar.eli((eli.InterfaceC0172eli) this);
        }
    }

    public wC getClickCreativeListener() {
        return this.MGA;
    }

    public FC getClickListener() {
        return this.kb;
    }

    public void setClickListener(FC fc) {
        this.kb = fc;
    }

    public void setBackupListener(com.bytedance.sdk.component.adexpress.DbA.Os os) {
        this.aqO = os;
        com.bytedance.sdk.component.adexpress.DbA.MGA mga = this.mm;
        if (mga != null) {
            mga.eli(os);
        }
    }

    public void nGm() {
        com.bytedance.sdk.openadsdk.core.model.aGH UCq;
        com.bytedance.sdk.openadsdk.core.du.aGH eli;
        com.bytedance.sdk.component.adexpress.DbA.aGH<? extends View> agh = this.KM;
        if (agh instanceof Vy) {
            if (agh == null) {
                return;
            }
            ((Vy) agh).wC();
            com.bytedance.sdk.component.utils.FC.DbA().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wC.Xb.6
                @Override // java.lang.Runnable
                public void run() {
                    Xb.this.ui(1);
                }
            }, (this.nlS != null ? r0.bf().aGH() : 5) * 1000);
        } else if (agh instanceof com.bytedance.sdk.openadsdk.core.aAs.MGA.MGA) {
            ((com.bytedance.sdk.openadsdk.core.aAs.MGA.MGA) agh).du();
        }
        com.bytedance.sdk.openadsdk.core.model.ev evVar = this.nlS;
        if (evVar != null && (UCq = evVar.UCq()) != null && (eli = UCq.eli()) != null) {
            eli.eli(0L);
        }
        if ((this.KM instanceof com.bytedance.sdk.openadsdk.core.aAs.MGA.MGA) && com.bytedance.sdk.openadsdk.core.model.dV.eli(this.nlS)) {
            eli(this.KM);
        }
    }

    public void ui(int i) {
        if (com.bytedance.sdk.openadsdk.core.model.Xb.Os(this.nlS)) {
            com.bytedance.sdk.component.adexpress.DbA.aGH<? extends View> agh = this.KM;
            if (agh instanceof Vy) {
                ((Vy) agh).DbA(i);
            }
        }
    }

    public void MGA(int i) {
        com.bytedance.sdk.component.adexpress.DbA.aGH<? extends View> agh = this.KM;
        if (agh == null || !(agh instanceof Vy)) {
            return;
        }
        ((Vy) agh).eli(i);
        this.BH = i;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        eli(i, true, false);
    }

    public void eli(int i, boolean z, boolean z2) {
        this.dV = z;
        removeCallbacks(this.ikX);
        removeCallbacks(this.Za);
        if (i == 0) {
            if (z2) {
                this.Za.run();
                return;
            } else {
                postDelayed(this.Za, 50L);
                return;
            }
        }
        if (z2) {
            this.ikX.run();
        } else {
            postDelayed(this.ikX, 50L);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ujq();
        com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(this.nlS, z);
        if (z) {
            com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(this.nlS, 4);
        } else {
            com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(this.nlS, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ujq() {
        if (this.SSo.get()) {
            this.gG.eli(System.currentTimeMillis(), nro.eli(this));
        }
    }

    public void QX() {
        if (this.nlS == null) {
            return;
        }
        this.ujq = SystemClock.elapsedRealtime();
        if (this.nlS.Jt()) {
            Os os = this.Uv;
            if (os == null) {
                a_(106);
                return;
            } else {
                os.eli((com.bytedance.sdk.component.adexpress.DbA.Dfc) this);
                this.Uv.eli();
                return;
            }
        }
        this.oWW.eli();
        aAs.eli eliVar = this.ow;
        if (eliVar != null) {
            eliVar.eli(this);
        }
        try {
            this.ow.eli();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b4  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i;
        SparseArray<Os.eli> sparseArray;
        wC wCVar = this.MGA;
        int i2 = 0;
        if (wCVar != null) {
            wCVar.DbA(motionEvent.getDeviceId());
            this.MGA.eli(motionEvent.getSource());
            this.MGA.Os(motionEvent.getToolType(0));
        }
        FC fc = this.kb;
        if (fc != null) {
            fc.DbA(motionEvent.getDeviceId());
            this.kb.eli(motionEvent.getSource());
            this.kb.Os(motionEvent.getToolType(0));
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            i2 = 3;
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    this.Mc += Math.abs(motionEvent.getX() - this.tLO);
                    this.DE += Math.abs(motionEvent.getY() - this.gHb);
                    this.tLO = motionEvent.getX();
                    this.gHb = motionEvent.getY();
                    i = (System.currentTimeMillis() - this.GMY <= 200 || (this.Mc <= 8.0f && this.DE <= 8.0f)) ? 2 : 1;
                    sparseArray = this.BDs;
                    if (sparseArray != null) {
                        sparseArray.put(motionEvent.getActionMasked(), new Os.eli(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
                    }
                    return super.dispatchTouchEvent(motionEvent);
                }
                i2 = actionMasked != 3 ? -1 : 4;
            }
        } else {
            this.tLO = motionEvent.getRawX();
            this.gHb = motionEvent.getRawY();
            this.GMY = System.currentTimeMillis();
            com.bytedance.sdk.openadsdk.core.FC.Os.eli(motionEvent);
        }
        i = i2;
        sparseArray = this.BDs;
        if (sparseArray != null) {
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void eli(View view, int i, com.bytedance.sdk.component.adexpress.Os os) {
        View view2;
        JSONObject jSONObject;
        com.bytedance.sdk.component.utils.Xb.eli("ClickCreativeListener", "trigger Class2 method1", Integer.valueOf(i));
        if (i == -1 || os == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (KM.Os(this.nlS)) {
            hashMap.put("click_scence", 3);
        } else {
            hashMap.put("click_scence", 1);
        }
        com.bytedance.sdk.openadsdk.core.model.aqO aqo = (com.bytedance.sdk.openadsdk.core.model.aqO) os;
        if (com.bytedance.sdk.openadsdk.core.model.Xb.Os(this.nlS)) {
            try {
                JSONObject jSONObject2 = aqo.dV;
                if (jSONObject2 != null) {
                    int optInt = jSONObject2.optInt("click_type", 0);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("click_type", optInt);
                    hashMap.put("pag_json_data", jSONObject3.toString());
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.Xb.Os(th.toString(), new Object[0]);
            }
        }
        wC wCVar = this.MGA;
        if (wCVar != null) {
            wCVar.aGH(getDynamicShowType());
            this.MGA.eli(hashMap);
        }
        FC fc = this.kb;
        if (fc != null) {
            fc.aGH(getDynamicShowType());
            this.kb.eli(hashMap);
        }
        float f = aqo.eli;
        float f2 = aqo.DbA;
        float f3 = aqo.Os;
        float f4 = aqo.aGH;
        boolean z = aqo.Dfc;
        SparseArray<Os.eli> sparseArray = aqo.nn;
        if (sparseArray == null || sparseArray.size() == 0) {
            sparseArray = this.BDs;
        }
        SparseArray<Os.eli> sparseArray2 = sparseArray;
        String str = aqo.du;
        if (view == null) {
            view2 = this;
        } else {
            r6 = view != this ? eli(view) : null;
            view2 = view;
        }
        if (aqo != null) {
            aqo.nlS = i;
            if (r6 != null && aqo.NU == null) {
                aqo.NU = r6;
            }
        }
        if (i != 13) {
            switch (i) {
                case 1:
                    FrameLayout frameLayout = this.NU;
                    if (frameLayout != null) {
                        frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                    }
                    com.bytedance.sdk.openadsdk.core.model.ev evVar = this.nlS;
                    if (evVar == null || evVar.rQ() != 1 || z) {
                        FC fc2 = this.kb;
                        if (fc2 != null) {
                            fc2.eli(aqo);
                            this.kb.eli(str);
                            this.kb.eli(view2, f, f2, f3, f4, sparseArray2, z);
                        }
                        if (this.ui != null && !aqo.nGm) {
                            this.ui.onAdClicked();
                            break;
                        }
                    }
                    break;
                case 2:
                    if (aqo.aqO > 0) {
                        Cp.eli(true);
                    }
                    wC wCVar2 = this.MGA;
                    if (wCVar2 != null) {
                        wCVar2.eli(aqo);
                        this.MGA.eli(str);
                        if (com.bytedance.sdk.openadsdk.core.model.Xb.Os(this.nlS) && (jSONObject = aqo.dV) != null) {
                            this.MGA.aGH(jSONObject.optBoolean("is_ceiling_page", false));
                        }
                        this.MGA.eli(view2, f, f2, f3, f4, sparseArray2, z);
                    }
                    if (this.ui != null && !aqo.nGm) {
                        this.ui.onAdClicked();
                    }
                    Cp.eli(false);
                    com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(this.nlS, 9);
                    break;
                case 3:
                    TTDislikeDialogAbstract tTDislikeDialogAbstract = this.aGH;
                    if (tTDislikeDialogAbstract != null) {
                        tTDislikeDialogAbstract.show();
                        break;
                    } else {
                        com.bytedance.sdk.openadsdk.Os.Os os2 = this.Os;
                        if (os2 != null) {
                            os2.eli();
                            break;
                        } else {
                            TTDelegateActivity.eli(this.nlS, this.Cp);
                            break;
                        }
                    }
                case 4:
                    FrameLayout frameLayout2 = this.NU;
                    if (frameLayout2 != null) {
                        frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                    }
                    com.bytedance.sdk.openadsdk.core.model.ev evVar2 = this.nlS;
                    if (evVar2 == null || evVar2.rQ() != 1 || z) {
                        dZ.Os(this.nlS);
                        if ("embeded_ad".equals(this.aAs) && Ue() && !this.nn && dZ.Os(this.nlS)) {
                            wC wCVar3 = this.MGA;
                            if (wCVar3 != null) {
                                wCVar3.eli(aqo);
                                this.MGA.eli(str);
                                this.MGA.eli(view2, f, f2, f3, f4, sparseArray2, z);
                            }
                        } else {
                            FC fc3 = this.kb;
                            if (fc3 != null) {
                                fc3.eli(aqo);
                                this.kb.eli(str);
                                this.kb.eli(view2, f, f2, f3, f4, sparseArray2, z);
                            }
                        }
                        if (this.ui != null && !aqo.nGm) {
                            this.ui.onAdClicked();
                            break;
                        }
                    }
                    break;
                case 5:
                    eli(!this.CMM, "dynamicClick");
                    break;
                case 6:
                    eli();
                    break;
                case 7:
                    TTWebsiteActivity.eli(this.FC, this.nlS, this.aAs);
                    break;
            }
            return;
        }
        int i2 = aqo.QX;
        if (i2 >= 0) {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("switch", i2);
                eli(jSONObject4);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.DbA.eli.InterfaceC0172eli
    public long getVideoProgress() {
        com.bytedance.sdk.openadsdk.core.Os.FC fc = this.rH;
        if (fc != null) {
            return fc.getVideoProgress();
        }
        return 0L;
    }

    public static JSONObject eli(View view) {
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put("left", iArr[0]);
            jSONObject.put("top", iArr[1]);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean Ue() {
        return com.bytedance.sdk.openadsdk.core.model.ev.ui(this.nlS);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ujq();
        KM();
        getViewTreeObserver().addOnScrollChangedListener(this.FS);
        com.bytedance.sdk.openadsdk.core.FC.DbA().eli(this.Cp, this.cyF);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ujq();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
    }

    private void KM() {
        List<com.bytedance.sdk.component.adexpress.DbA.aAs> list = this.TfR;
        if (list == null) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.DbA.aAs> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private void VM() {
        List<com.bytedance.sdk.component.adexpress.DbA.aAs> list = this.TfR;
        if (list == null) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.DbA.aAs> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public void aAs() {
        Vy vy = this.WfR;
        if (vy == null || vy.ui() == null) {
            return;
        }
        this.WfR.MGA();
    }

    public void nlS() {
        try {
            Os os = this.Uv;
            if (os != null) {
                os.DbA();
            }
            CMM();
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            List<com.bytedance.sdk.component.adexpress.DbA.aAs> list = this.TfR;
            if (list != null) {
                Iterator<com.bytedance.sdk.component.adexpress.DbA.aAs> it = list.iterator();
                while (it.hasNext()) {
                    it.next().eli();
                }
            }
            com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(this.nlS);
            com.bytedance.sdk.openadsdk.Vy.eli.Os.DbA(this.nlS);
            this.Os = null;
            this.aGH = null;
            this.du = null;
            this.nlS = null;
            this.ui = null;
            this.MGA = null;
            this.aqO = null;
            this.kb = null;
            com.bytedance.sdk.openadsdk.core.aAs.Os.DbA dbA = this.nro;
            if (dbA != null) {
                dbA.Os();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.eli("NativeExpressView", "detach error", th);
        }
    }

    public void Xb() {
        try {
            FrameLayout frameLayout = this.NU;
            if (frameLayout == null || frameLayout.getParent() == null) {
                return;
            }
            removeView(this.NU);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnScrollChangedListener(this.FS);
        com.bytedance.sdk.openadsdk.core.FC.DbA().MGA(this.Cp);
        VM();
        eli(8, true, true);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
    }

    public void eli(com.bytedance.sdk.component.adexpress.DbA.aGH<? extends View> agh, com.bytedance.sdk.component.adexpress.DbA.nn nnVar) {
        com.bytedance.sdk.openadsdk.core.model.ev evVar;
        this.SSo.set(true);
        this.KM = agh;
        new Object[]{"render type is  ", Integer.valueOf(agh.Os())};
        if (this.BH != getWindowVisibility() && wC()) {
            MGA(getWindowVisibility());
        }
        if (agh.Os() == 3 && (evVar = this.nlS) != null && evVar.mm() == 1) {
            this.nlS.wC(0);
        }
        if (agh.Os() != 1) {
            View ui = agh.ui();
            if (ui.getParent() != null) {
                ((ViewGroup) ui.getParent()).removeView(ui);
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < getChildCount(); i++) {
                arrayList.add(getChildAt(i));
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2) instanceof com.bytedance.sdk.component.FC.MGA) {
                    removeView((View) arrayList.get(i2));
                }
            }
            if (com.bytedance.sdk.openadsdk.core.model.Xb.Os(this.nlS)) {
                addView(agh.ui(), new FrameLayout.LayoutParams(-1, -1));
            } else {
                addView(agh.ui());
            }
        }
        com.bytedance.sdk.openadsdk.core.model.ev evVar2 = this.nlS;
        if (evVar2 != null) {
            com.bytedance.sdk.openadsdk.Dfc.Os.eli(evVar2.kb(), this.ujq, this.aAs, agh.Os());
        }
        com.bytedance.sdk.component.adexpress.DbA.FC fc = this.Yw;
        if (fc != null) {
            ((NU) fc).du();
        }
        PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.ui;
        if (pAGExpressAdWrapperListener != null) {
            pAGExpressAdWrapperListener.onRenderSuccess(this, (float) nnVar.Os(), (float) nnVar.aGH());
        }
        if ((this.KM instanceof com.bytedance.sdk.openadsdk.core.aAs.MGA.MGA) && com.bytedance.sdk.openadsdk.core.model.dV.eli(this.nlS)) {
            Vy();
        }
        if (DbA(nnVar)) {
            com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(this, this.nlS, Os(getDynamicShowType()));
        }
        CMM cmm = this.dZ;
        if (cmm != null) {
            cmm.eli(this.nlS, this.aAs);
        }
    }

    protected ui.eli Os(int i) {
        return new ui.eli(i);
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.Dfc
    public void a_(int i) {
        com.bytedance.sdk.component.adexpress.DbA.FC fc = this.Yw;
        if (fc != null) {
            if (!this.eli) {
                fc.wC();
            }
            this.Yw.FC();
            ((NU) this.Yw).du();
        }
        PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.ui;
        if (pAGExpressAdWrapperListener != null) {
            pAGExpressAdWrapperListener.onRenderFail(this, com.bytedance.sdk.openadsdk.core.wC.eli(i), i);
        }
        CMM cmm = this.dZ;
        if (cmm != null) {
            cmm.eli(this.nlS, this.aAs);
        }
    }

    public boolean bf() {
        com.bytedance.sdk.component.adexpress.DbA.aGH<? extends View> agh = this.KM;
        return agh != null && (agh instanceof bf);
    }

    public int getDynamicShowType() {
        com.bytedance.sdk.component.adexpress.DbA.aGH<? extends View> agh = this.KM;
        if (agh != null) {
            return agh.Os();
        }
        return 0;
    }

    public JSONObject eli(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        if (!(this.KM instanceof Vy)) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            int renderEngineCacheType = getRenderEngineCacheType();
            if (evVar != null) {
                if (evVar.RY() != null && evVar.RY().nlS()) {
                    jSONObject.put("engine_version", evVar.RY().du());
                } else if (evVar.hg() != null) {
                    jSONObject.put("engine_version", "v3");
                } else {
                    jSONObject.put("engine_version", i.f5703a);
                }
            }
            jSONObject.put("engine_type", renderEngineCacheType);
            return jSONObject;
        } catch (Exception e) {
            e.getMessage();
            return jSONObject;
        }
    }

    public int getRenderEngineCacheType() {
        aAs Dfc;
        com.bytedance.sdk.component.adexpress.DbA.aGH<? extends View> agh = this.KM;
        if (!(agh instanceof Vy) || (Dfc = ((Vy) agh).Dfc()) == null) {
            return 0;
        }
        return Dfc.eli();
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.VM).intValue();
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.GB).intValue();
    }

    public qj getJsObject() {
        Vy vy = this.WfR;
        if (vy != null) {
            return vy.aqO();
        }
        return null;
    }

    private boolean GB() {
        return TextUtils.equals(this.aAs, "fullscreen_interstitial_ad") || TextUtils.equals(this.aAs, "rewarded_video") || TextUtils.equals("open_ad", this.aAs) || Vy.DbA(this.aAs) || TextUtils.equals(this.aAs, "embeded_ad");
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.aGH
    public void setTime(CharSequence charSequence, int i, int i2, boolean z) {
        try {
            int parseInt = Integer.parseInt(String.valueOf(charSequence));
            DbA(parseInt, i);
            com.bytedance.sdk.openadsdk.core.aAs.Os.DbA dbA = this.nro;
            if (dbA != null) {
                dbA.eli(parseInt);
            }
        } catch (NumberFormatException unused) {
        }
    }

    public void setSoundMute(boolean z) {
        this.CMM = z;
        com.bytedance.sdk.component.adexpress.DbA.DbA dbA = this.Ue;
        if (dbA != null && dbA.DbA() != null) {
            this.Ue.DbA().setSoundMute(z);
        }
        com.bytedance.sdk.component.adexpress.DbA.aGH<? extends View> agh = this.KM;
        if (agh instanceof com.bytedance.sdk.openadsdk.core.aAs.MGA.Os) {
            ((com.bytedance.sdk.openadsdk.core.aAs.MGA.Os) agh).setSoundMute(z);
        }
    }

    protected void DbA(int i, int i2) {
        int i3;
        if (TextUtils.equals(this.aAs, "banner_ad")) {
            return;
        }
        int i4 = this.ev;
        int i5 = ((i2 < i4 || i4 < 0 || !(this.Vy || TextUtils.equals(this.aAs, "open_ad"))) && !((i == 0 && TextUtils.equals(this.aAs, "open_ad")) || ui() == 5)) ? 0 : 1;
        if (i2 <= this.ev) {
            com.bytedance.sdk.openadsdk.core.model.ev evVar = this.nlS;
            if (evVar != null && evVar.nY() != null) {
                i3 = (int) (Math.min(this.ev, this.nlS.nY().MGA() * this.nlS.nY().CMM()) - i2);
            } else {
                i3 = this.ev - i2;
            }
        } else {
            i3 = 0;
        }
        com.bytedance.sdk.component.adexpress.DbA.DbA dbA = this.Ue;
        if (dbA != null && dbA.DbA() != null) {
            this.Ue.DbA().setTime(String.valueOf(i), i5, i3, false);
        }
        com.bytedance.sdk.component.adexpress.DbA.aGH<? extends View> agh = this.KM;
        if (agh instanceof com.bytedance.sdk.openadsdk.core.aAs.MGA.Os) {
            ((com.bytedance.sdk.openadsdk.core.aAs.MGA.Os) agh).setTime(String.valueOf(i), i5, i3, false);
        }
    }

    public void CMM() {
        com.bytedance.sdk.openadsdk.core.model.aGH UCq;
        com.bytedance.sdk.openadsdk.core.du.aGH eli;
        com.bytedance.sdk.openadsdk.core.model.ev evVar = this.nlS;
        if (evVar == null || (UCq = evVar.UCq()) == null || (eli = UCq.eli()) == null) {
            return;
        }
        eli.ui(getVideoProgress());
    }

    public void setVastVideoHelper(com.bytedance.sdk.openadsdk.core.Os.FC fc) {
        this.rH = fc;
    }

    public boolean ev() {
        return this.SSo.get();
    }

    public void DbA(int i, String str) {
        qj aqO;
        com.bytedance.sdk.component.adexpress.DbA.aGH<? extends View> agh = this.KM;
        if (agh == null || !(agh instanceof Vy) || (aqO = ((Vy) agh).aqO()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time", i);
            jSONObject.put("flag", str);
            aqO.eli("onVideoPaused", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void Vy() {
        com.bytedance.sdk.openadsdk.core.aAs.Os.DbA dbA = new com.bytedance.sdk.openadsdk.core.aAs.Os.DbA(this.FC, this.nlS);
        this.nro = dbA;
        dbA.eli(this);
        this.nro.eli(new com.bytedance.sdk.openadsdk.core.aAs.Os.eli() { // from class: com.bytedance.sdk.openadsdk.core.wC.Xb.7
        });
    }

    public void eli(com.bytedance.sdk.component.adexpress.DbA.aGH agh) {
        if (this.nro == null) {
            return;
        }
        try {
            if (agh instanceof com.bytedance.sdk.openadsdk.core.aAs.MGA.MGA) {
                ViewGroup viewGroup = (ViewGroup) ((com.bytedance.sdk.openadsdk.core.aAs.MGA.MGA) agh).MGA().du();
                this.bf = viewGroup;
                if (viewGroup != null) {
                    this.nro.eli();
                    View DbA = this.nro.DbA();
                    if (DbA != null) {
                        ViewGroup viewGroup2 = (ViewGroup) DbA.getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(DbA);
                        }
                        this.bf.addView(DbA, new ViewGroup.LayoutParams(-1, -1));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void setVideoFrameChangeListener(com.bytedance.sdk.openadsdk.nlS.kb kbVar) {
        if (this.WfR == null || getJsObject() == null) {
            return;
        }
        getJsObject().eli(kbVar);
    }

    public void setVideoBusiness(com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA) {
        Vy vy = this.WfR;
        if (vy != null) {
            vy.eli(dbA);
        }
    }

    public void kb(int i) {
        com.bytedance.sdk.component.adexpress.DbA.aGH<? extends View> agh = this.KM;
        if ((agh instanceof com.bytedance.sdk.openadsdk.core.aAs.MGA.MGA) && i == 4) {
            ((com.bytedance.sdk.openadsdk.core.aAs.MGA.MGA) agh).aAs();
        }
    }
}
