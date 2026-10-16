package com.bytedance.adsdk.ugeno.DbA;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.DbA.eli;
import com.bytedance.adsdk.ugeno.aGH;
import com.bytedance.adsdk.ugeno.aGH.FC;
import com.bytedance.adsdk.ugeno.core.DbA.aGH;
import com.bytedance.adsdk.ugeno.core.DbA.ui;
import com.bytedance.adsdk.ugeno.core.Dfc;
import com.bytedance.adsdk.ugeno.core.IAnimation;
import com.bytedance.adsdk.ugeno.core.NU;
import com.bytedance.adsdk.ugeno.core.aAs;
import com.bytedance.adsdk.ugeno.core.aqO;
import com.bytedance.adsdk.ugeno.core.du;
import com.bytedance.adsdk.ugeno.core.kb;
import com.bytedance.adsdk.ugeno.core.nGm;
import com.bytedance.adsdk.ugeno.core.nn;
import com.bytedance.adsdk.ugeno.core.wC;
import com.bytedance.adsdk.ugeno.eli;
import com.bytedance.adsdk.ugeno.eli.MGA;
import com.bytedance.adsdk.ugeno.kb.eli;
import com.ironsource.C3040d4;
import com.ironsource.D5;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.ktor.util.date.GMTDateParser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class Os<T extends View> implements View.OnTouchListener, aGH, Dfc.DbA, Dfc.eli {
    protected float BDs;
    protected int BH;
    private boolean Bnk;
    private boolean CH;
    protected boolean CMM;
    protected float Ca;
    protected boolean Cp;
    protected MGA DE;
    private JSONObject Daf;
    protected Context DbA;
    protected float Dfc;
    private boolean Eh;
    protected du FC;
    protected boolean FS;
    protected float GB;
    protected float GMY;
    private boolean GMu;
    private boolean GR;
    protected float Gjg;
    protected aqO HN;
    protected com.bytedance.adsdk.ugeno.core.MGA Hm;
    private boolean ID;
    private com.bytedance.adsdk.ugeno.core.eli Ib;
    protected float KM;
    protected float Kp;
    protected eli<ViewGroup> MGA;
    protected float MQ;
    protected com.bytedance.adsdk.ugeno.eli.eli Mc;
    protected boolean ND;
    protected float NU;
    private String OJ;
    protected JSONObject Os;
    private nGm Pf;
    protected float PfW;
    protected boolean QI;
    private GradientDrawable QMZ;
    private boolean QW;
    protected float QX;
    private float QxD;
    protected eli.C0126eli RY;
    protected ImageView.ScaleType SSo;

    @Deprecated
    private com.bytedance.adsdk.ugeno.core.DbA.DbA SjY;
    protected boolean TfR;

    @Deprecated
    private com.bytedance.adsdk.ugeno.core.DbA.Os TiA;
    private boolean Tju;
    protected float Ue;
    protected float Uv;
    protected float VM;
    protected boolean Vy;
    protected float WfR;
    protected float XU;
    protected float Xb;

    @Deprecated
    private com.bytedance.adsdk.ugeno.core.DbA.MGA XlF;
    protected Map<Integer, NU> XxP;
    protected int Yw;
    private boolean ZLD;
    protected float Za;
    protected boolean aAs;
    protected JSONObject aGH;

    @Deprecated
    private aGH.eli an;
    protected float aqO;
    private boolean bU;
    protected float bf;
    private boolean cvo;
    protected boolean cyF;

    @Deprecated
    private ui dM;
    protected float dV;
    protected String dZ;
    protected String du;
    protected float eEH;
    protected int eU;
    private boolean eli;
    private com.bytedance.adsdk.ugeno.aGH.eli.eli eu;
    protected boolean ev;
    protected wC gAc;
    protected boolean gG;
    protected ViewGroup.LayoutParams gHb;
    private boolean hg;
    protected float ikX;
    protected Dfc iuv;
    protected boolean jh;
    private boolean kEI;
    protected eli<ViewGroup> kb;
    private aAs lYL;
    private boolean lkd;
    private long mS;
    protected boolean mm;
    protected float nGm;
    private boolean nY;
    protected String nlS;
    protected float nn;
    protected boolean nro;
    protected boolean oWW;
    protected boolean oc;
    protected float ow;
    private boolean pu;
    protected FC qWy;
    protected boolean qj;
    protected String qyC;
    protected float rH;
    protected float rQ;
    protected float rn;
    protected float tGZ;
    protected boolean tLO;
    private String tpZ;
    protected T ui;
    protected float ujq;
    private boolean umh;
    private boolean vb;
    protected kb.eli wC;
    protected float yKf;
    private boolean yw;

    protected void FS() {
    }

    public T eli() {
        return null;
    }

    protected void jh() {
    }

    public Os(Context context) {
        this(context, null);
    }

    public Os(Context context, eli<ViewGroup> eliVar) {
        this.NU = -2.0f;
        this.nn = -2.0f;
        this.qyC = "solid";
        this.BH = 0;
        this.tLO = true;
        this.GMY = 0.0f;
        this.rH = 0.0f;
        this.eEH = 0.0f;
        this.PfW = 1.0f;
        this.Ca = 1.0f;
        this.yKf = 1.0f;
        this.rn = 0.0f;
        this.Gjg = 0.0f;
        this.XU = 0.0f;
        this.Kp = 0.0f;
        this.MQ = 1.0f;
        this.yw = true;
        this.cvo = true;
        this.pu = false;
        this.Eh = false;
        this.GR = false;
        this.QxD = 12.0f;
        this.DbA = context;
        this.MGA = eliVar;
        this.XxP = new HashMap();
        this.QMZ = new GradientDrawable();
        this.ui = eli();
    }

    public T du() {
        return this.ui;
    }

    public void DbA(JSONObject jSONObject) {
        this.aGH = jSONObject;
        NU();
    }

    public void eli(JSONObject jSONObject) {
        this.aGH = jSONObject;
        NU();
        JSONObject jSONObject2 = this.Os;
        if (jSONObject2 == null) {
            return;
        }
        Iterator<String> keys = jSONObject2.keys();
        eli<ViewGroup> eliVar = this.MGA;
        eli.C0117eli aAs = eliVar instanceof eli ? eliVar.aAs() : null;
        while (keys.hasNext()) {
            String next = keys.next();
            String eli = com.bytedance.adsdk.ugeno.Os.DbA.eli(this.Os.optString(next), jSONObject);
            eli(next, eli);
            if (aAs != null) {
                aAs.eli(this.DbA, next, eli);
            }
        }
        if (aAs != null) {
            eli(aAs.eli());
        }
        if (this.Daf == null || this.aGH == null) {
            return;
        }
        try {
            if (oWW()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("i18n", this.Daf);
                this.aGH.put("xNode", jSONObject3);
                return;
            }
            this.aGH.put("i18n", this.Daf);
        } catch (JSONException unused) {
        }
    }

    public JSONObject nlS() {
        return this.aGH;
    }

    public void NU() {
        this.GR = this.aGH.optBoolean("gesture_through_enable", false);
        Log.d("GesThrough_UGenWidget", "mGestureThroughEnabled: " + this.GR);
    }

    public void DbA() {
        Ue();
        nn();
        Os(this.BH);
        Os();
        aGH();
        FC fc = this.qWy;
        if (fc != null) {
            fc.eli();
            this.qWy.DbA();
            this.qWy.Os();
        }
        this.ui.setOnTouchListener(this);
        aAs();
        ViewGroup viewGroup = (ViewGroup) this.ui.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(!this.yw);
        }
        com.bytedance.adsdk.ugeno.eli.eli eliVar = this.Mc;
        if (eliVar != null) {
            eliVar.aGH();
        }
        MGA mga = this.DE;
        if (mga != null) {
            mga.eli();
        }
        FC fc2 = this.qWy;
        if (fc2 != null) {
            fc2.aGH();
        }
        if (this.iuv == null || !DbA(22)) {
            return;
        }
        this.iuv.eli(this.XxP.get(22), this, this);
    }

    protected void nn() {
        this.ui.setPadding((int) (this.qj ? this.Ue : this.ujq), (int) (this.Cp ? this.VM : this.ujq), (int) (this.nro ? this.KM : this.ujq), (int) (this.cyF ? this.GB : this.ujq));
    }

    private void Os() {
        if (this.eli) {
            this.ui.setTranslationX(this.rH);
        }
        if (this.vb) {
            this.ui.setTranslationY(this.eEH);
        }
        if (this.hg) {
            this.ui.setScaleX(this.Ca);
        }
        if (this.Bnk) {
            this.ui.setScaleY(this.yKf);
        }
        if (this.QW) {
            this.ui.setRotation(this.rn);
        }
        if (this.nY) {
            this.ui.setRotationX(this.Gjg);
        }
        if (this.kEI) {
            this.ui.setRotationY(-this.XU);
        }
        if (this.Tju) {
            this.ui.setAlpha(this.MQ);
        }
        float f = this.Kp;
        if (f != 0.0f) {
            this.ui.setRotation(f);
        }
        if (this.QW || this.nY || this.kEI) {
            this.ui.setCameraDistance(10000.0f);
        }
    }

    public float Dfc() {
        return this.rH;
    }

    public float aqO() {
        return this.eEH;
    }

    public float dV() {
        return this.Ca;
    }

    public float nGm() {
        return this.yKf;
    }

    public float QX() {
        return this.Gjg;
    }

    public float Xb() {
        return this.XU;
    }

    public float bf() {
        return this.Kp;
    }

    public float CMM() {
        return this.MQ;
    }

    public float ev() {
        return this.Za;
    }

    @Deprecated
    private void aGH() {
        com.bytedance.adsdk.ugeno.core.DbA.aGH aGH;
        this.ui.setVisibility(this.BH);
        float f = this.Kp;
        if (f != 0.0f) {
            this.ui.setRotation(f);
        }
        kb.eli eliVar = this.wC;
        if (eliVar != null && TextUtils.isEmpty(eliVar.DbA())) {
            this.ui.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.adsdk.ugeno.DbA.Os.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (Os.this.gAc != null) {
                        boolean unused = Os.this.cvo;
                    }
                }
            });
        } else if (DbA(1) && !this.ZLD) {
            this.ui.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.adsdk.ugeno.DbA.Os.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Log.d("GesThrough_UGenWidget", "UGenWidget onClick handling");
                    if (Os.this.iuv == null || !Os.this.cvo) {
                        return;
                    }
                    Dfc dfc = Os.this.iuv;
                    NU nu = Os.this.XxP.get(1);
                    Os os = Os.this;
                    dfc.eli(nu, os, os);
                }
            });
        }
        if (this.iuv != null && DbA(4)) {
            if (DbA(1)) {
                Log.d("GesThrough_UGenWidget", "onSlide & onTap, view.id: " + nro());
                this.ID = true;
                this.dM = new ui(this.DbA, this.XxP.get(4), this.XxP.get(1), this.ID, QI());
            } else {
                Log.d("GesThrough_UGenWidget", "onSlide only, view.id: " + nro());
                this.dM = new ui(this.DbA, this.XxP.get(4), this.ID, QI());
            }
        }
        if (this.iuv != null && DbA(1) && this.ZLD) {
            Log.d("GesThrough_UGenWidget", "onTap only, mOnlyTap: " + this.ZLD + ", view.id: " + nro());
            this.TiA = new com.bytedance.adsdk.ugeno.core.DbA.Os(this.DbA, this.XxP.get(1));
        }
        FC();
        if (this.iuv != null && DbA(3) && (aGH = com.bytedance.adsdk.ugeno.ui.eli().aGH()) != null) {
            this.an = aGH.eli(this.DbA, this);
            new Object() { // from class: com.bytedance.adsdk.ugeno.DbA.Os.3
            };
        }
        if (this.iuv != null && DbA(9)) {
            com.bytedance.adsdk.ugeno.core.DbA.MGA mga = new com.bytedance.adsdk.ugeno.core.DbA.MGA(this.DbA, this.XxP.get(9), this);
            this.XlF = mga;
            mga.eli(this.iuv);
        }
        if (DbA(10)) {
            com.bytedance.adsdk.ugeno.core.DbA.DbA dbA = new com.bytedance.adsdk.ugeno.core.DbA.DbA(this.DbA, this.XxP.get(10), this);
            this.SjY = dbA;
            dbA.eli(this.iuv);
        }
    }

    private void FC() {
        NU nu;
        if (this.iuv == null || !DbA(18) || (nu = this.XxP.get(18)) == null) {
            return;
        }
        JSONObject Os = nu.Os();
        if (Os != null) {
            try {
                Os.put("rotateZ", com.bytedance.adsdk.ugeno.Os.DbA.eli(Os.optString("rotateZ"), this.aGH));
            } catch (JSONException unused) {
            }
        }
        this.iuv.eli(nu, this, this);
    }

    private void aAs() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.du);
        this.ui.setContentDescription(sb);
    }

    public void eli(nGm ngm) {
        this.Pf = ngm;
    }

    @Override // com.bytedance.adsdk.ugeno.aGH
    public void kb() {
        if (this.Ib != null) {
            aAs aas = new aAs(this.ui, this.Ib);
            this.lYL = aas;
            aas.eli();
        }
        com.bytedance.adsdk.ugeno.eli.eli eliVar = this.Mc;
        if (eliVar != null) {
            eliVar.eli();
        }
        MGA mga = this.DE;
        if (mga != null) {
            mga.DbA();
        }
        FC fc = this.qWy;
        if (fc != null) {
            fc.ui();
        }
        if (this.SjY != null && DbA(10)) {
            this.SjY.eli();
        }
        if (this.XlF != null && DbA(9)) {
            this.XlF.eli();
        }
        ui uiVar = this.dM;
        if (uiVar != null) {
            uiVar.eli();
        }
        this.mS = System.currentTimeMillis();
    }

    @Override // com.bytedance.adsdk.ugeno.aGH
    public void wC() {
        aAs aas = this.lYL;
        if (aas != null) {
            aas.DbA();
        }
        com.bytedance.adsdk.ugeno.eli.eli eliVar = this.Mc;
        if (eliVar != null) {
            eliVar.Os();
        }
        MGA mga = this.DE;
        if (mga != null) {
            mga.Os();
        }
    }

    public Dfc Vy() {
        return this.iuv;
    }

    public long gG() {
        return this.mS;
    }

    public boolean DbA(int i) {
        Map<Integer, NU> map = this.XxP;
        return map != null && map.containsKey(Integer.valueOf(i));
    }

    public void Os(int i) {
        ViewParent viewParent = (ViewGroup) this.ui.getParent();
        if (viewParent instanceof DbA) {
            ((DbA) viewParent).Os(this.ui, i);
        } else {
            this.ui.setVisibility(i);
        }
    }

    public void eli(aqO aqo) {
        this.HN = aqo;
    }

    public void eli(Dfc dfc) {
        this.iuv = dfc;
    }

    public void Os(JSONObject jSONObject) {
        this.Os = jSONObject;
    }

    public JSONObject ujq() {
        return this.Os;
    }

    protected void Ue() {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        if (TextUtils.isEmpty(this.dZ)) {
            if (this.ND) {
                eli(this.RY);
                return;
            } else {
                this.QMZ.setColor(this.eU);
                aGH(this.eU);
                return;
            }
        }
        if (this.dZ.startsWith("local://")) {
            String replace = this.dZ.replace("local://", "");
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = this.FS ? Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565;
                options.inPurgeable = true;
                options.inInputShareable = true;
                Bitmap decodeStream = BitmapFactory.decodeStream(this.DbA.getResources().openRawResource(com.bytedance.adsdk.ugeno.kb.aGH.DbA(this.DbA, replace)), null, options);
                if (this.FS) {
                    Bitmap eli = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, decodeStream, (int) this.Uv);
                    if (eli != null) {
                        bitmapDrawable2 = new BitmapDrawable(this.DbA.getResources(), eli);
                        eli(bitmapDrawable2);
                        return;
                    }
                    bitmapDrawable = new BitmapDrawable(this.DbA.getResources(), decodeStream);
                } else {
                    bitmapDrawable = new BitmapDrawable(this.DbA.getResources(), decodeStream);
                }
                bitmapDrawable2 = bitmapDrawable;
                eli(bitmapDrawable2);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        KM();
    }

    protected void KM() {
        com.bytedance.adsdk.ugeno.ui.eli().DbA().eli(this.FC, this.dZ, new eli.InterfaceC0124eli() { // from class: com.bytedance.adsdk.ugeno.DbA.Os.4
            @Override // com.bytedance.adsdk.ugeno.eli.InterfaceC0124eli
            public void eli(final Bitmap bitmap) {
                if (bitmap == null) {
                    return;
                }
                if (Os.this.FS) {
                    final Bitmap eli = com.bytedance.adsdk.ugeno.kb.wC.eli(Os.this.DbA, bitmap, (int) Os.this.Uv);
                    if (eli != null) {
                        com.bytedance.adsdk.ugeno.kb.wC.eli(new Runnable() { // from class: com.bytedance.adsdk.ugeno.DbA.Os.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Os.this.eli(new BitmapDrawable(eli));
                            }
                        });
                        return;
                    }
                    return;
                }
                com.bytedance.adsdk.ugeno.kb.wC.eli(new Runnable() { // from class: com.bytedance.adsdk.ugeno.DbA.Os.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Os.this.eli(new BitmapDrawable(bitmap));
                    }
                });
            }
        });
    }

    protected void eli(eli.C0126eli c0126eli) {
        if (c0126eli == null) {
            return;
        }
        this.QMZ.setShape(0);
        if (c0126eli != null) {
            this.QMZ.setOrientation(c0126eli.eli);
            if (Build.VERSION.SDK_INT >= 29) {
                this.QMZ.setColors(c0126eli.DbA, c0126eli.Os);
            } else {
                this.QMZ.setColors(c0126eli.DbA);
            }
        }
        oc();
        mm();
        this.ui.setBackground(this.QMZ);
    }

    protected void aGH(int i) {
        this.QMZ.setShape(0);
        this.QMZ.setColor(i);
        oc();
        mm();
        this.ui.setBackground(this.QMZ);
    }

    private void mm() {
        if (TextUtils.equals("dashed", this.qyC)) {
            GradientDrawable gradientDrawable = this.QMZ;
            float f = this.rQ;
            gradientDrawable.setStroke((int) f, this.Yw, 3.0f * f, f);
        } else {
            if (TextUtils.equals("dotted", this.qyC)) {
                GradientDrawable gradientDrawable2 = this.QMZ;
                float f2 = this.rQ;
                gradientDrawable2.setStroke((int) f2, this.Yw, f2 / 2.0f, f2);
                return;
            }
            this.QMZ.setStroke((int) this.rQ, this.Yw);
        }
    }

    private void oc() {
        float f = this.TfR ? this.ikX : this.Za;
        float f2 = this.QI ? this.WfR : this.Za;
        float f3 = this.mm ? this.tGZ : this.Za;
        float f4 = this.oc ? this.ow : this.Za;
        this.QMZ.setCornerRadii(new float[]{f, f, f2, f2, f4, f4, f3, f3});
    }

    protected void eli(Drawable drawable) {
        this.ui.setBackground(drawable);
    }

    public void eli(ViewGroup.LayoutParams layoutParams) {
        T t = this.ui;
        if (t != null) {
            t.setLayoutParams(layoutParams);
        }
        this.gHb = layoutParams;
    }

    public ViewGroup.LayoutParams VM() {
        return this.gHb;
    }

    public void eli(boolean z, boolean z2) {
        if (this.ui != null) {
            eli(this.gHb);
            if (z) {
                ui((int) this.NU);
            }
            if (z2) {
                MGA((int) this.nn);
            }
        }
    }

    public void eli(kb.eli eliVar) {
        this.wC = eliVar;
    }

    public kb.eli GB() {
        return this.wC;
    }

    public Os<T> aGH(String str) {
        return eli(str);
    }

    protected Os<T> eli(String str) {
        if (TextUtils.isEmpty(this.du) || !TextUtils.equals(this.du, str)) {
            return null;
        }
        return this;
    }

    public Os<T> ui(String str) {
        return DbA(str);
    }

    protected Os<T> DbA(String str) {
        if (TextUtils.isEmpty(this.nlS) || !TextUtils.equals(this.nlS, str)) {
            return null;
        }
        return this;
    }

    public Os<T> MGA(String str) {
        return Os(str);
    }

    protected Os<T> Os(String str) {
        if (aAs(str) != null) {
            return this;
        }
        return null;
    }

    public void eli(boolean z) {
        this.aAs = z;
    }

    public boolean oWW() {
        return this.aAs;
    }

    public eli qj() {
        return this.MGA;
    }

    public void eli(eli eliVar) {
        this.MGA = eliVar;
    }

    public void kb(String str) {
        this.du = str;
    }

    public String nro() {
        return this.du;
    }

    public void wC(String str) {
        this.nlS = str;
    }

    public String Cp() {
        return this.nlS;
    }

    public int cyF() {
        return (int) this.NU;
    }

    public int eU() {
        return (int) this.nn;
    }

    public void eli(du duVar) {
        this.FC = duVar;
    }

    public boolean dZ() {
        return this.tLO;
    }

    public void eli(wC wCVar) {
        this.gAc = wCVar;
    }

    public int SSo() {
        return this.eU;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void eli(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1964681502:
                if (str.equals("clickable")) {
                    c = 0;
                    break;
                }
                break;
            case -1901681170:
                if (str.equals("onRenderSuccess")) {
                    c = 1;
                    break;
                }
                break;
            case -1721943862:
                if (str.equals("translateX")) {
                    c = 2;
                    break;
                }
                break;
            case -1721943861:
                if (str.equals("translateY")) {
                    c = 3;
                    break;
                }
                break;
            case -1501175880:
                if (str.equals("paddingLeft")) {
                    c = 4;
                    break;
                }
                break;
            case -1375815020:
                if (str.equals("minWidth")) {
                    c = 5;
                    break;
                }
                break;
            case -1351184668:
                if (str.equals("onDelay")) {
                    c = 6;
                    break;
                }
                break;
            case -1337252761:
                if (str.equals("onShake")) {
                    c = 7;
                    break;
                }
                break;
            case -1337126126:
                if (str.equals("onSlide")) {
                    c = '\b';
                    break;
                }
                break;
            case -1336288090:
                if (str.equals("onTimer")) {
                    c = '\t';
                    break;
                }
                break;
            case -1335874424:
                if (str.equals("onTwist")) {
                    c = '\n';
                    break;
                }
                break;
            case -1332194002:
                if (str.equals("background")) {
                    c = 11;
                    break;
                }
                break;
            case -1291329255:
                if (str.equals("events")) {
                    c = '\f';
                    break;
                }
                break;
            case -1267206133:
                if (str.equals(VastAttributes.OPACITY)) {
                    c = '\r';
                    break;
                }
                break;
            case -1228066334:
                if (str.equals("borderTopLeftRadius")) {
                    c = 14;
                    break;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    c = 15;
                    break;
                }
                break;
            case -1081309778:
                if (str.equals(VastAttributes.MARGIN)) {
                    c = 16;
                    break;
                }
                break;
            case -1044792121:
                if (str.equals("marginTop")) {
                    c = 17;
                    break;
                }
                break;
            case -1013407967:
                if (str.equals("onDown")) {
                    c = 18;
                    break;
                }
                break;
            case -933876756:
                if (str.equals("backgroundDrawable")) {
                    c = 19;
                    break;
                }
                break;
            case -925180581:
                if (str.equals("rotate")) {
                    c = 20;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 21;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 22;
                    break;
                }
                break;
            case -806339567:
                if (str.equals(VastAttributes.PADDING)) {
                    c = 23;
                    break;
                }
                break;
            case -681357156:
                if (str.equals("triggerFunc")) {
                    c = 24;
                    break;
                }
                break;
            case -289173127:
                if (str.equals("marginBottom")) {
                    c = 25;
                    break;
                }
                break;
            case -133587431:
                if (str.equals("minHeight")) {
                    c = 26;
                    break;
                }
                break;
            case 3355:
                if (str.equals("id")) {
                    c = 27;
                    break;
                }
                break;
            case 3176990:
                if (str.equals("i18n")) {
                    c = 28;
                    break;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    c = 29;
                    break;
                }
                break;
            case 87811796:
                if (str.equals("backgroundImageBlur")) {
                    c = 30;
                    break;
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    c = 31;
                    break;
                }
                break;
            case 94750088:
                if (str.equals("click")) {
                    c = ' ';
                    break;
                }
                break;
            case 105871684:
                if (str.equals("onTap")) {
                    c = '!';
                    break;
                }
                break;
            case 108285963:
                if (str.equals("ratio")) {
                    c = '\"';
                    break;
                }
                break;
            case 109250890:
                if (str.equals("scale")) {
                    c = '#';
                    break;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    c = Typography.dollar;
                    break;
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    c = '%';
                    break;
                }
                break;
            case 314070383:
                if (str.equals("animations")) {
                    c = Typography.amp;
                    break;
                }
                break;
            case 320386138:
                if (str.equals("onLoadMore")) {
                    c = '\'';
                    break;
                }
                break;
            case 333432965:
                if (str.equals("borderTopRightRadius")) {
                    c = '(';
                    break;
                }
                break;
            case 529642498:
                if (str.equals("overflow")) {
                    c = ')';
                    break;
                }
                break;
            case 581268560:
                if (str.equals("borderBottomLeftRadius")) {
                    c = GMTDateParser.ANY;
                    break;
                }
                break;
            case 588239831:
                if (str.equals("borderBottomRightRadius")) {
                    c = '+';
                    break;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    c = AbstractJsonLexerKt.COMMA;
                    break;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    c = '-';
                    break;
                }
                break;
            case 737768677:
                if (str.equals("borderStyle")) {
                    c = '.';
                    break;
                }
                break;
            case 741115130:
                if (str.equals("borderWidth")) {
                    c = '/';
                    break;
                }
                break;
            case 843948038:
                if (str.equals("onExposure")) {
                    c = '0';
                    break;
                }
                break;
            case 975087886:
                if (str.equals("marginRight")) {
                    c = '1';
                    break;
                }
                break;
            case 1052832078:
                if (str.equals("translate")) {
                    c = '2';
                    break;
                }
                break;
            case 1087723621:
                if (str.equals("onAnimation")) {
                    c = '3';
                    break;
                }
                break;
            case 1118509956:
                if (str.equals("animation")) {
                    c = '4';
                    break;
                }
                break;
            case 1151851515:
                if (str.equals("animatorSet")) {
                    c = '5';
                    break;
                }
                break;
            case 1158381436:
                if (str.equals("onPullToRefresh")) {
                    c = '6';
                    break;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    c = '7';
                    break;
                }
                break;
            case 1292595405:
                if (str.equals("backgroundImage")) {
                    c = '8';
                    break;
                }
                break;
            case 1301532860:
                if (str.equals("backgroundScale")) {
                    c = '9';
                    break;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    c = AbstractJsonLexerKt.COLON;
                    break;
                }
                break;
            case 1384173149:
                if (str.equals("rotateX")) {
                    c = ';';
                    break;
                }
                break;
            case 1384173150:
                if (str.equals("rotateY")) {
                    c = Typography.less;
                    break;
                }
                break;
            case 1384173151:
                if (str.equals("rotateZ")) {
                    c = D5.T;
                    break;
                }
                break;
            case 1490730380:
                if (str.equals("onScroll")) {
                    c = Typography.greater;
                    break;
                }
                break;
            case 1671308008:
                if (str.equals("disable")) {
                    c = '?';
                    break;
                }
                break;
            case 1685004456:
                if (str.equals("onLongTap")) {
                    c = '@';
                    break;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c = 'A';
                    break;
                }
                break;
            case 1970934485:
                if (str.equals("marginLeft")) {
                    c = 'B';
                    break;
                }
                break;
            case 1997542747:
                if (str.equals("availability")) {
                    c = 'C';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.cvo = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, true);
                break;
            case 1:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
            case 18:
            case '!':
            case '\'':
            case '0':
            case '3':
            case '6':
            case '>':
            case '@':
                DbA(str, str2);
                break;
            case 2:
                this.eli = true;
                this.rH = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f));
                break;
            case 3:
                this.vb = true;
                this.eEH = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f));
                break;
            case 4:
                this.Ue = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, str2);
                this.qj = true;
                break;
            case 5:
                this.Xb = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f);
                break;
            case 11:
            case '7':
                if (com.bytedance.adsdk.ugeno.kb.eli.Os(str2)) {
                    this.ND = true;
                    this.RY = com.bytedance.adsdk.ugeno.kb.eli.DbA(str2);
                    break;
                } else {
                    this.eU = com.bytedance.adsdk.ugeno.kb.eli.eli(str2, 0);
                    this.ND = false;
                    break;
                }
            case '\f':
                this.qWy = FC.eli(this, str2);
                break;
            case '\r':
                this.Tju = true;
                this.MQ = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 1.0f);
                break;
            case 14:
                this.ikX = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, str2);
                this.TfR = true;
                break;
            case 15:
                if (TextUtils.equals(str2, "match_parent")) {
                    this.nn = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.nn = -2.0f;
                } else {
                    this.nn = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, str2);
                }
                this.Eh = true;
                break;
            case 16:
                this.Dfc = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, str2);
                break;
            case 17:
                this.nGm = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, str2);
                this.Vy = true;
                break;
            case 19:
            case '8':
                this.dZ = str2;
                break;
            case 20:
                this.QW = true;
                this.rn = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f);
                break;
            case 21:
                this.hg = true;
                this.Ca = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f);
                break;
            case 22:
                this.Bnk = true;
                this.yKf = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f);
                break;
            case 23:
                this.ujq = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, str2);
                this.oWW = true;
                break;
            case 24:
                this.tpZ = str2;
                break;
            case 25:
                this.QX = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, str2);
                this.gG = true;
                break;
            case 26:
                this.bf = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f);
                break;
            case 27:
                this.du = str2;
                break;
            case 28:
                this.Daf = com.bytedance.adsdk.ugeno.kb.DbA.eli(str2, (JSONObject) null);
                break;
            case 29:
                this.nlS = str2;
                break;
            case 30:
                float eli = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f);
                this.Uv = eli;
                if (eli > 0.0f) {
                    this.FS = true;
                    break;
                }
                break;
            case 31:
                this.VM = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, str2);
                this.Cp = true;
                break;
            case ' ':
                this.OJ = str2;
                break;
            case '\"':
                this.BDs = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f);
                break;
            case '#':
                this.hg = true;
                this.Bnk = true;
                float[] Os = com.bytedance.adsdk.ugeno.eli.aGH.Os(str2);
                this.Ca = Os[0];
                this.yKf = Os[1];
                break;
            case '$':
                if (TextUtils.equals(str2, "match_parent")) {
                    this.NU = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.NU = -2.0f;
                } else {
                    this.NU = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, str2);
                }
                this.pu = true;
                break;
            case '%':
                this.GB = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, str2);
                this.cyF = true;
                break;
            case '&':
                List<com.bytedance.adsdk.ugeno.eli.Os> eli2 = com.bytedance.adsdk.ugeno.eli.aGH.eli(str2, this.aGH);
                if (eli2 != null && !eli2.isEmpty()) {
                    this.DE = new MGA(this.DbA, this, eli2);
                    break;
                }
                break;
            case '(':
                this.WfR = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, str2);
                this.QI = true;
                break;
            case ')':
                this.yw = nlS(str2);
                break;
            case '*':
                this.tGZ = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, str2);
                this.mm = true;
                break;
            case '+':
                this.ow = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, str2);
                this.oc = true;
                break;
            case ',':
                this.KM = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, str2);
                this.nro = true;
                break;
            case '-':
                this.Yw = com.bytedance.adsdk.ugeno.kb.eli.eli(str2);
                break;
            case '.':
                this.qyC = str2;
                break;
            case '/':
                this.rQ = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, str2);
                break;
            case '1':
                this.dV = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, str2);
                this.ev = true;
                break;
            case '2':
                this.eli = true;
                this.vb = true;
                float[] Os2 = com.bytedance.adsdk.ugeno.eli.aGH.Os(str2);
                this.rH = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, Os2[0]);
                this.eEH = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, Os2[1]);
                break;
            case '4':
                try {
                    this.Mc = new com.bytedance.adsdk.ugeno.eli.eli(this.DbA, this, com.bytedance.adsdk.ugeno.eli.aGH.eli(new JSONObject(str2), this.aGH));
                    break;
                } catch (JSONException unused) {
                    return;
                }
            case '5':
                this.Ib = com.bytedance.adsdk.ugeno.core.eli.eli(str2, this);
                break;
            case '9':
                this.jh = true;
                this.SSo = du(str2);
                break;
            case ':':
                this.Za = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, str2);
                break;
            case ';':
                this.nY = true;
                this.Gjg = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f);
                break;
            case '<':
                this.kEI = true;
                this.XU = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f);
                break;
            case '=':
                this.Kp = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f);
                break;
            case '?':
                this.CH = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, false);
                break;
            case 'A':
                if (TextUtils.equals(VastAttributes.VISIBLE, str2)) {
                    this.BH = 0;
                } else if (TextUtils.equals("invisible", str2)) {
                    this.BH = 4;
                } else if (TextUtils.equals("gone", str2) || TextUtils.equals("hidden", str2)) {
                    this.BH = 8;
                }
                this.ui.setVisibility(this.BH);
                break;
            case 'B':
                this.aqO = com.bytedance.adsdk.ugeno.kb.wC.eli(this.DbA, str2);
                this.CMM = true;
                break;
            case 'C':
                this.tLO = !TextUtils.equals(str2, "unavailable");
                break;
        }
    }

    private ImageView.ScaleType du(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                this.SSo = ImageView.ScaleType.CENTER;
                break;
            case "fit":
                this.SSo = ImageView.ScaleType.FIT_CENTER;
                break;
            case "crop":
                this.SSo = ImageView.ScaleType.CENTER_CROP;
                break;
            default:
                this.SSo = ImageView.ScaleType.FIT_XY;
                break;
        }
        return this.SSo;
    }

    private boolean nlS(String str) {
        return TextUtils.isEmpty(str) || !TextUtils.equals(str, "hidden");
    }

    protected void DbA(String str, String str2) {
        if (TextUtils.isEmpty(str2) || this.XxP == null) {
            return;
        }
        try {
            int eli = nn.eli(str).eli();
            NU nu = new NU();
            nu.eli(eli);
            nu.eli(this);
            JSONObject jSONObject = new JSONObject(str2);
            if (eli == 3) {
                try {
                    this.QxD = Float.parseFloat(com.bytedance.adsdk.ugeno.Os.DbA.eli(jSONObject.optString("shakeAmplitude"), this.aGH));
                } catch (NumberFormatException unused) {
                    this.QxD = 12.0f;
                }
            }
            if (!(this.iuv instanceof com.bytedance.adsdk.ugeno.core.eli.DbA)) {
                eli(eli, jSONObject, nu);
                return;
            }
            throw null;
        } catch (JSONException unused2) {
        }
    }

    @Deprecated
    protected void eli(int i, JSONObject jSONObject, NU nu) {
        JSONObject optJSONObject = jSONObject.optJSONObject("success");
        if (optJSONObject != null) {
            NU nu2 = new NU();
            nu2.eli(optJSONObject);
            nu2.eli(this);
            nu.eli(nu2);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(C3040d4.f.e);
        if (optJSONObject2 != null) {
            NU nu3 = new NU();
            nu3.eli(optJSONObject2);
            nu3.eli(this);
            nu.DbA(nu3);
        }
        nu.eli(jSONObject);
        this.XxP.put(Integer.valueOf(i), nu);
    }

    @Override // com.bytedance.adsdk.ugeno.aGH
    public void ui() {
        if (this.Pf == null || this.bU) {
            return;
        }
        this.bU = true;
    }

    @Override // com.bytedance.adsdk.ugeno.aGH
    public void MGA() {
        if (this.Pf == null || this.lkd) {
            return;
        }
        this.lkd = true;
    }

    @Override // com.bytedance.adsdk.ugeno.aGH
    public int[] eli(int i, int i2) {
        if (this.BDs > 0.0f) {
            if (this.pu) {
                int size = View.MeasureSpec.getSize(i);
                float f = this.BDs;
                if (f != 0.0f) {
                    i2 = View.MeasureSpec.makeMeasureSpec((int) (size / f), 1073741824);
                }
            } else if (this.Eh) {
                int size2 = View.MeasureSpec.getSize(i2);
                float f2 = this.BDs;
                if (f2 != 0.0f) {
                    i = View.MeasureSpec.makeMeasureSpec((int) (size2 * f2), 1073741824);
                }
            }
        }
        if (this.Pf != null && !this.GMu) {
            this.GMu = true;
        }
        return new int[]{i, i2};
    }

    @Override // com.bytedance.adsdk.ugeno.aGH
    public void eli(int i, int i2, int i3, int i4) {
        if (this.Pf == null || this.umh) {
            return;
        }
        this.umh = true;
    }

    @Override // com.bytedance.adsdk.ugeno.aGH
    public void eli(Canvas canvas, IAnimation iAnimation) {
        aAs aas = this.lYL;
        if (aas != null) {
            aas.eli(canvas, iAnimation);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.aGH
    public void eli(Canvas canvas) {
        if (this instanceof eli) {
            return;
        }
        com.bytedance.adsdk.ugeno.eli.eli eliVar = this.Mc;
        if (eliVar != null) {
            eliVar.eli(canvas);
        }
        MGA mga = this.DE;
        if (mga != null) {
            mga.eli(canvas);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.aGH
    public void DbA(Canvas canvas) {
        if (this instanceof eli) {
            com.bytedance.adsdk.ugeno.eli.eli eliVar = this.Mc;
            if (eliVar != null) {
                eliVar.DbA(canvas);
            }
            MGA mga = this.DE;
            if (mga != null) {
                mga.DbA(canvas);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.aGH
    public void DbA(int i, int i2, int i3, int i4) {
        aAs aas = this.lYL;
        if (aas != null) {
            aas.eli(i, i2);
        }
        com.bytedance.adsdk.ugeno.eli.eli eliVar = this.Mc;
        if (eliVar != null) {
            eliVar.eli(i, i2);
        }
        MGA mga = this.DE;
        if (mga != null) {
            mga.eli(i, i2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.core.Dfc.DbA
    public void eli(NU nu) {
        eli<ViewGroup> eliVar;
        Os<T> aGH;
        if (nu == null || nu.Os() == null || !TextUtils.equals(nu.Os().optString("type"), "onDismiss")) {
            return;
        }
        String optString = nu.Os().optString("nodeId");
        Os(8);
        this.kb = (eli) DbA(this);
        if (TextUtils.isEmpty(optString) || (eliVar = this.kb) == null || (aGH = eliVar.aGH(optString)) == null) {
            return;
        }
        aGH.Os(8);
    }

    public void eli(com.bytedance.adsdk.ugeno.aGH.eli.eli eliVar) {
        this.eu = eliVar;
    }

    public com.bytedance.adsdk.ugeno.aGH.eli.eli Uv() {
        return this.eu;
    }

    public Os DbA(Os os) {
        return (os.qj() == null && (os instanceof eli)) ? os : DbA(os.qj());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ui uiVar;
        Dfc dfc;
        com.bytedance.adsdk.ugeno.core.DbA.Os os;
        Log.d("GesThrough_UGenWidget", "UGenWidget onTouch event: " + motionEvent.toString());
        int action = motionEvent.getAction();
        if (action == 0) {
            FS();
        } else if (action == 1 || action == 3) {
            jh();
        }
        aqO aqo = this.HN;
        if (aqo != null) {
            aqo.eli(this, motionEvent);
        }
        if (DbA(17) && motionEvent.getAction() == 0) {
            this.iuv.eli(this.XxP.get(17), this, this);
        }
        if (DbA(1) && this.ZLD && (dfc = this.iuv) != null && (os = this.TiA) != null) {
            return os.eli(dfc, this, motionEvent);
        }
        Dfc dfc2 = this.iuv;
        if (dfc2 != null && (uiVar = this.dM) != null) {
            return uiVar.eli(dfc2, this, motionEvent, QI());
        }
        FC fc = this.qWy;
        if (fc != null) {
            return fc.eli(motionEvent);
        }
        return false;
    }

    public boolean Za() {
        return this.BDs > 0.0f;
    }

    public float ikX() {
        T t = this.ui;
        if (t instanceof com.bytedance.adsdk.ugeno.eli.kb) {
            return ((com.bytedance.adsdk.ugeno.eli.kb) t).getRipple();
        }
        return 0.0f;
    }

    public float tGZ() {
        T t = this.ui;
        if (t instanceof com.bytedance.adsdk.ugeno.eli.kb) {
            return ((com.bytedance.adsdk.ugeno.eli.kb) t).getShine();
        }
        return 0.0f;
    }

    public float WfR() {
        T t = this.ui;
        if (t instanceof com.bytedance.adsdk.ugeno.eli.kb) {
            return ((com.bytedance.adsdk.ugeno.eli.kb) t).getStretch();
        }
        return 0.0f;
    }

    public float ow() {
        T t = this.ui;
        if (t instanceof com.bytedance.adsdk.ugeno.eli.kb) {
            return ((com.bytedance.adsdk.ugeno.eli.kb) t).getRubIn();
        }
        return 0.0f;
    }

    public void ui(int i) {
        if (oWW()) {
            T t = this.ui;
            if (t instanceof DbA) {
                ((DbA) t).eli(i);
                return;
            }
            ViewParent viewParent = (ViewGroup) t.getParent();
            if (viewParent instanceof DbA) {
                ((DbA) viewParent).eli(this.ui, i);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.ui.getLayoutParams();
        layoutParams.width = i;
        this.ui.setLayoutParams(layoutParams);
    }

    public void MGA(int i) {
        if (oWW()) {
            T t = this.ui;
            if (t instanceof DbA) {
                ((DbA) t).DbA(i);
                return;
            }
            ViewParent viewParent = (ViewGroup) t.getParent();
            if (viewParent instanceof DbA) {
                ((DbA) viewParent).DbA(this.ui, i);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.ui.getLayoutParams();
        layoutParams.height = i;
        this.ui.setLayoutParams(layoutParams);
    }

    public boolean TfR() {
        return this.CH;
    }

    public List<com.bytedance.adsdk.ugeno.aGH.aGH.Os> FC(String str) {
        FC fc;
        if (TextUtils.isEmpty(str) || (fc = this.qWy) == null) {
            return null;
        }
        return fc.eli(str);
    }

    public void eli(String str, Object... objArr) {
        List<com.bytedance.adsdk.ugeno.aGH.aGH.Os> FC = FC(str);
        if (FC == null || FC.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.aGH.aGH.Os os : FC) {
            os.eli(this.qWy);
            os.eli(objArr);
        }
    }

    public void eli(com.bytedance.adsdk.ugeno.core.ui uiVar) {
        FC fc = this.qWy;
        if (fc != null) {
            fc.eli(uiVar);
        }
    }

    public com.bytedance.adsdk.ugeno.eli.eli aAs(String str) {
        com.bytedance.adsdk.ugeno.eli.eli eliVar = this.Mc;
        if (eliVar != null && TextUtils.equals(str, eliVar.ui())) {
            return this.Mc;
        }
        MGA mga = this.DE;
        if (mga != null) {
            return mga.eli(str);
        }
        return null;
    }

    public void eli(com.bytedance.adsdk.ugeno.core.MGA mga) {
        this.Hm = mga;
    }

    public boolean QI() {
        return this.GR;
    }
}
