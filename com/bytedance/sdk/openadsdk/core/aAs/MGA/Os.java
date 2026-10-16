package com.bytedance.sdk.openadsdk.core.aAs.MGA;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.aGH.MGA;
import com.bytedance.adsdk.ugeno.core.Dfc;
import com.bytedance.adsdk.ugeno.core.NU;
import com.bytedance.adsdk.ugeno.core.aqO;
import com.bytedance.adsdk.ugeno.core.nlS;
import com.bytedance.sdk.component.adexpress.DbA.nn;
import com.bytedance.sdk.component.adexpress.DbA.wC;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.aqO;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.wC.Xb;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os implements Dfc, aqO, com.bytedance.sdk.component.adexpress.DbA.aGH<View>, com.bytedance.sdk.component.adexpress.dynamic.aGH {
    private static float GB = 0.0f;
    private static long KM = 0;
    private static float VM = 0.0f;
    protected static int bf = 24;
    private static float oWW;
    private static float qj;
    protected WeakReference<View> CMM;
    private Xb Cp;
    protected Context DbA;
    protected float Dfc;
    protected com.bytedance.sdk.openadsdk.core.wC.Dfc FC;
    protected eli MGA;
    protected com.bytedance.adsdk.ugeno.DbA.Os NU;
    protected com.bytedance.adsdk.ugeno.DbA.Os<View> Os;
    protected long QX;
    private final boolean Ue;
    protected nn aAs;
    protected JSONObject aGH;
    protected float aqO;
    protected float dV;
    protected nlS eli;
    protected String ev;
    protected JSONObject gG;
    protected FrameLayout kb;
    protected long nGm;
    protected com.bytedance.adsdk.ugeno.DbA.Os nlS;
    protected float nn;
    private aGH nro;
    protected ev ui;
    private com.bytedance.sdk.component.adexpress.DbA.kb ujq;
    protected wC wC;
    protected boolean Xb = true;
    public SparseArray<Os.eli> Vy = new SparseArray<>();
    private String cyF = "";
    private final com.bytedance.sdk.component.wC.wC eU = new com.bytedance.sdk.component.wC.wC("ugen_render_template") { // from class: com.bytedance.sdk.openadsdk.core.aAs.MGA.Os.1
        @Override // java.lang.Runnable
        public void run() {
            Os os = Os.this;
            os.aGH = os.eli();
            if (Os.this.Cp == null) {
                Os.this.cyF = "expressView is null";
            } else {
                Os os2 = Os.this;
                os2.cyF = os2.Cp.getUgenTemplateErrorReason();
            }
            com.bytedance.sdk.openadsdk.core.nn.Os().post(Os.this.dZ);
        }
    };
    private final Runnable dZ = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.aAs.MGA.Os.2
        @Override // java.lang.Runnable
        public void run() {
            if (Os.this.ujq != null) {
                Os os = Os.this;
                os.DbA(os.ujq);
            }
        }
    };
    private boolean SSo = false;
    protected AtomicBoolean du = new AtomicBoolean(false);

    public void eli(long j, long j2) {
    }

    @Override // com.bytedance.adsdk.ugeno.core.Dfc
    public void eli(com.bytedance.adsdk.ugeno.DbA.Os os, String str, MGA.eli eliVar) {
    }

    public com.bytedance.adsdk.ugeno.DbA.Os kb() {
        return null;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.aGH
    public void onvideoComplate() {
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.aGH
    public void setTimeUpdate(int i) {
    }

    static {
        if (dV.eli() != null) {
            bf = dV.DbA();
        }
    }

    public Os(Context context, ev evVar, boolean z, eli eliVar, ViewGroup viewGroup) {
        this.DbA = context;
        this.Ue = z;
        this.eli = new nlS(context);
        this.ui = evVar;
        this.MGA = eliVar;
        this.kb = new FrameLayout(context);
        if (viewGroup instanceof Xb) {
            this.Cp = (Xb) viewGroup;
        }
        this.ev = eliVar.aGH();
        this.gG = DbA();
        this.nro = new aGH(this.DbA, this.ui, this.ev, this.gG);
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aGH
    public void eli(com.bytedance.sdk.component.adexpress.DbA.kb kbVar) {
        this.ujq = kbVar;
        cyF.DbA(this.eU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(com.bytedance.sdk.component.adexpress.DbA.kb kbVar) {
        this.MGA.qj().eli();
        if (this.aGH == null) {
            kbVar.eli(Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, "ugen template is null real reason is " + this.cyF);
            return;
        }
        if (this.gG == null) {
            kbVar.eli(Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, "ugen data is null");
            return;
        }
        int aGH = aGH();
        if (this.eli.eli()) {
            List<String> DbA = this.eli.DbA();
            if (DbA == null) {
                kbVar.eli(138, "unknow widget");
                return;
            } else {
                kbVar.eli(138, "unknow widget;" + DbA.toString());
                return;
            }
        }
        if (aGH != 0) {
            kbVar.eli(aGH, "ugen render fail");
            return;
        }
        if (this.Os != null) {
            DbA dbA = new DbA();
            this.aAs = dbA;
            dbA.eli(true);
            this.aAs.eli(Os());
            setSoundMute(this.Ue);
            aAs();
            com.bytedance.adsdk.ugeno.DbA.Os wC = wC();
            this.nlS = wC;
            if (wC != null && (wC instanceof com.bytedance.sdk.openadsdk.core.aAs.DbA.aGH.DbA)) {
                ((DbA) this.aAs).eli((FrameLayout) ((com.bytedance.sdk.openadsdk.core.aAs.DbA.aGH.DbA) wC).aGH());
            }
            com.bytedance.adsdk.ugeno.DbA.Os FC = FC();
            aGH agh = this.nro;
            if (agh != null) {
                agh.eli();
            }
            if (FC != null && FC.du() != null) {
                this.CMM = new WeakReference<>(FC.du());
            }
            com.bytedance.adsdk.ugeno.DbA.Os MGA = MGA();
            this.NU = MGA;
            if (MGA != null && (MGA instanceof com.bytedance.adsdk.ugeno.FC.DbA.DbA)) {
                ((DbA) this.aAs).DbA((FrameLayout) MGA.du());
            }
            if (KM.Os(this.ui)) {
                com.bytedance.adsdk.ugeno.DbA.Os kb = kb();
                if (kb instanceof com.bytedance.sdk.openadsdk.core.aAs.DbA.DbA.DbA) {
                    ((DbA) this.aAs).Os(((com.bytedance.sdk.openadsdk.core.aAs.DbA.DbA.DbA) kb).aGH());
                }
            }
            int cyF = this.Os.cyF();
            int eU = this.Os.eU();
            this.kb.removeAllViews();
            this.kb.addView(this.Os.du(), new FrameLayout.LayoutParams(cyF, eU));
            float VM2 = this.MGA.VM();
            float GB2 = this.MGA.GB();
            float DbA2 = SSo.DbA(this.DbA, VM2);
            float DbA3 = SSo.DbA(this.DbA, GB2);
            if (Os() != 7) {
                this.kb.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else if (GB2 <= 0.0f) {
                this.kb.setLayoutParams(new FrameLayout.LayoutParams((int) DbA2, -2));
            } else {
                this.kb.setLayoutParams(new FrameLayout.LayoutParams((int) DbA2, (int) DbA3));
            }
            if (GB2 <= 0.0f || VM2 <= 0.0f) {
                this.kb.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                int Os = SSo.Os(this.DbA, this.kb.getMeasuredWidth());
                int Os2 = SSo.Os(this.DbA, this.kb.getMeasuredHeight());
                this.aAs.eli(Os);
                this.aAs.DbA(Os2);
            } else {
                this.aAs.eli(VM2);
                this.aAs.DbA(GB2);
            }
            if (this.du.get()) {
                kbVar.eli(Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, "ugen render timeout");
                return;
            } else {
                this.eli.eli(this.Os, "renderDidFinish", new Object[0]);
                kbVar.eli(this.kb, this.aAs);
                return;
            }
        }
        kbVar.eli(138, "ugen render error");
    }

    protected JSONObject eli() {
        return this.MGA.Os();
    }

    protected JSONObject DbA() {
        return this.MGA.oWW();
    }

    protected int aGH() {
        this.eli.eli((Dfc) this);
        this.eli.eli((aqO) this);
        com.bytedance.adsdk.ugeno.DbA.Os<View> eli = this.eli.eli(this.aGH);
        this.Os = eli;
        aGH agh = this.nro;
        if (agh != null && eli != null) {
            agh.eli(eli);
        }
        this.MGA.qj().DbA();
        this.MGA.qj().Os();
        this.eli.DbA(this.gG);
        return 0;
    }

    public void eli(boolean z) {
        this.du.set(z);
    }

    public void eli(wC wCVar) {
        this.wC = wCVar;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.wC.Dfc dfc) {
        this.FC = dfc;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.widget.ui uiVar) {
        aGH agh = this.nro;
        if (agh != null) {
            agh.eli(uiVar);
        }
    }

    public com.bytedance.adsdk.ugeno.DbA.Os MGA() {
        com.bytedance.adsdk.ugeno.DbA.Os<View> os = this.Os;
        if (os == null) {
            return null;
        }
        return os.ui("PlayableComponent");
    }

    @Override // com.bytedance.adsdk.ugeno.core.Dfc
    public void eli(NU nu, Dfc.DbA dbA, Dfc.eli eliVar) {
        if (nu == null) {
            return;
        }
        if (nu.DbA() == 1 || nu.DbA() == 4) {
            eli(nu);
        }
        if (nu.DbA() == 10) {
            eli(nu.Os());
        }
        if (dbA == null || nu.aGH() == null) {
            return;
        }
        dbA.eli(nu.aGH());
    }

    private void eli(JSONObject jSONObject) {
        com.bytedance.adsdk.ugeno.DbA.Os<View> aGH;
        if (this.Os == null || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("type");
        String optString2 = jSONObject.optString("nodeId");
        if (TextUtils.isEmpty(optString2) || (aGH = this.Os.aGH(optString2)) == null) {
            return;
        }
        if (TextUtils.equals(optString, "onShow")) {
            aGH.Os(0);
        } else if (TextUtils.equals(optString, "onDismiss")) {
            aGH.Os(8);
        }
    }

    private void eli(NU nu) {
        JSONObject jSONObject;
        boolean z;
        int i;
        aGH agh;
        aGH agh2;
        aGH agh3;
        if (this.wC == null) {
            return;
        }
        String optString = nu.Os().optString("type");
        if ("swiperLeft".equals(optString) && (agh3 = this.nro) != null) {
            agh3.DbA();
            return;
        }
        if ("swiperRight".equals(optString) && (agh2 = this.nro) != null) {
            agh2.Os();
            return;
        }
        if (!"swiperClick".equals(optString) || (agh = this.nro) == null) {
            jSONObject = null;
            z = false;
            i = 0;
        } else {
            z = agh.eli(nu);
            jSONObject = this.nro.aGH();
            i = 2;
        }
        optString.hashCode();
        switch (optString) {
            case "privacy":
                i = 7;
                break;
            case "feedback":
                i = 3;
                break;
            case "mute":
                i = 5;
                break;
            case "skip":
                i = 6;
                break;
            case "video":
                i = 4;
                break;
            case "creative":
                i = 2;
                break;
        }
        com.bytedance.adsdk.ugeno.DbA.Os eli = nu.eli();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        WeakReference<View> weakReference = this.CMM;
        if (weakReference != null) {
            int[] eli2 = SSo.eli(weakReference.get());
            if (eli2 != null) {
                iArr = eli2;
            }
            int[] Os = SSo.Os(this.CMM.get());
            if (Os != null) {
                iArr2 = Os;
            }
        }
        this.wC.eli(nu.eli().du(), i, new aqO.eli().aGH(this.nn).Os(this.Dfc).DbA(this.aqO).eli(this.dV).DbA(this.nGm).eli(this.QX).aGH(iArr[0]).ui(iArr[1]).MGA(iArr2[0]).kb(iArr2[1]).eli(this.Vy).eli(nu.DbA() != 1 || this.Xb).eli(eli == null ? "" : eli.Cp() + "_" + eli.nro()).DbA(z).DbA(jSONObject).eli());
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0058, code lost:
    
        if (com.bytedance.sdk.openadsdk.core.aAs.MGA.Os.qj <= r2) goto L16;
     */
    @Override // com.bytedance.adsdk.ugeno.core.aqO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void eli(com.bytedance.adsdk.ugeno.DbA.Os os, MotionEvent motionEvent) {
        int i;
        int action = motionEvent.getAction();
        int i2 = 1;
        if (action == 0) {
            this.nGm = System.currentTimeMillis();
            this.nn = motionEvent.getRawX();
            this.Dfc = motionEvent.getRawY();
            this.Xb = true;
            KM = System.currentTimeMillis();
            com.bytedance.sdk.openadsdk.core.FC.Os.eli(motionEvent);
            i = 0;
        } else {
            int i3 = -1;
            if (action != 1) {
                if (action == 2) {
                    oWW += Math.abs(motionEvent.getX() - VM);
                    qj += Math.abs(motionEvent.getY() - GB);
                    VM = motionEvent.getX();
                    GB = motionEvent.getY();
                    if (System.currentTimeMillis() - KM > 200) {
                        float f = oWW;
                        int i4 = bf;
                        if (f <= i4) {
                        }
                        if (Math.abs(motionEvent.getRawX() - this.nn) < bf || Math.abs(motionEvent.getRawY() - this.Dfc) >= bf) {
                            this.Xb = false;
                        }
                        i3 = i2;
                    }
                    i2 = 2;
                    if (Math.abs(motionEvent.getRawX() - this.nn) < bf) {
                    }
                    this.Xb = false;
                    i3 = i2;
                }
                i = i3;
            }
            this.aqO = motionEvent.getRawX();
            this.dV = motionEvent.getRawY();
            if (Math.abs(this.aqO - this.nn) >= bf || Math.abs(this.dV - this.Dfc) >= bf) {
                this.Xb = false;
            }
            this.QX = System.currentTimeMillis();
            i = i3;
        }
        this.Vy.put(motionEvent.getActionMasked(), new Os.eli(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
    }

    public void setTime(CharSequence charSequence, int i, int i2, boolean z) {
        if (this.Os == null) {
            return;
        }
        boolean z2 = i == 1;
        eli(charSequence, z2, i2, z);
        DbA(charSequence, z2, i2, z);
    }

    private void eli(CharSequence charSequence, boolean z, int i, boolean z2) {
        com.bytedance.adsdk.ugeno.DbA.Os<View> aGH;
        int i2;
        com.bytedance.adsdk.ugeno.DbA.Os<View> os = this.Os;
        if (os == null || (aGH = os.aGH("countdown")) == null) {
            return;
        }
        View du = aGH.du();
        if (du instanceof TextView) {
            try {
                i2 = Integer.parseInt((String) charSequence);
            } catch (Exception unused) {
                com.bytedance.sdk.component.utils.Xb.Os("UGenRender", "parse duration exception", charSequence);
                i2 = 0;
            }
            if (z2 || i2 <= 0 || this.SSo) {
                du.setVisibility(8);
                return;
            }
            du.setVisibility(0);
            if (!z && this.MGA.eli() && com.bytedance.sdk.component.adexpress.aGH.MGA.DbA(this.MGA.aGH())) {
                ((TextView) du).setText(String.format(com.bytedance.sdk.component.utils.ev.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), "tt_reward_full_skip"), Integer.valueOf(i)));
            } else if (!"open_ad".equals(this.MGA.aGH()) && this.MGA.eli()) {
                this.SSo = true;
                du.setVisibility(8);
            } else {
                ((TextView) du).setText(((Object) charSequence) + "s");
            }
        }
    }

    private void DbA(CharSequence charSequence, boolean z, int i, boolean z2) {
        com.bytedance.adsdk.ugeno.DbA.Os<View> aGH;
        View du;
        com.bytedance.adsdk.ugeno.DbA.Os<View> os = this.Os;
        if (os == null || (aGH = os.aGH("skip")) == null || (du = aGH.du()) == null) {
            return;
        }
        int i2 = 0;
        if (!z && !z2) {
            i2 = 8;
        }
        du.setVisibility(i2);
    }

    private void aAs() {
        com.bytedance.adsdk.ugeno.DbA.Os<View> aGH;
        if (this.Os == null) {
            return;
        }
        if (this.ui.fI() && (aGH = this.Os.aGH("tvskip")) != null) {
            aGH.Os(8);
        }
        com.bytedance.adsdk.ugeno.DbA.Os<View> aGH2 = this.Os.aGH("skip");
        if (aGH2 != null && (aGH2 instanceof com.bytedance.adsdk.ugeno.FC.aGH.Os)) {
            if (!com.bytedance.sdk.openadsdk.core.settings.NU.nY().NU(String.valueOf(this.ui.RTg())) || this.ui.mm() == 5 || this.ui.mm() == 6 || this.ui.bBQ() == 3) {
                ((com.bytedance.adsdk.ugeno.FC.aGH.Os) aGH2).nlS("local://tt_close_btn");
                aGH2.DbA();
            }
        }
    }

    protected com.bytedance.adsdk.ugeno.DbA.Os wC() {
        com.bytedance.adsdk.ugeno.DbA.Os<View> os = this.Os;
        if (os == null) {
            return null;
        }
        return os.aGH("video");
    }

    protected com.bytedance.adsdk.ugeno.DbA.Os FC() {
        com.bytedance.adsdk.ugeno.DbA.Os<View> os = this.Os;
        if (os == null) {
            return null;
        }
        return os.aGH("feedback");
    }

    public void setSoundMute(boolean z) {
        com.bytedance.adsdk.ugeno.DbA.Os<View> aGH;
        com.bytedance.adsdk.ugeno.DbA.Os<View> os = this.Os;
        if (os == null || (aGH = os.aGH(CampaignEx.JSON_NATIVE_VIDEO_MUTE)) == null) {
            return;
        }
        if (z) {
            ((com.bytedance.adsdk.ugeno.FC.aGH.Os) aGH).nlS("local://tt_reward_full_mute");
        } else {
            ((com.bytedance.adsdk.ugeno.FC.aGH.Os) aGH).nlS("local://tt_reward_full_unmute");
        }
        aGH.DbA();
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aGH
    public View ui() {
        return this.kb;
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aGH
    public int Os() {
        return this.ui.rH();
    }
}
