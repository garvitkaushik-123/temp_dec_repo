package com.bytedance.sdk.openadsdk.core.DbA;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.Cp;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import com.bytedance.sdk.openadsdk.core.FC;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.aqO;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.model.nlS;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA extends Os {
    private static int Cp = Integer.MIN_VALUE;
    private WeakReference<Activity> DbA;
    protected boolean Dfc;
    protected WeakReference<View> FC;
    protected final ev MGA;
    protected PAGNativeAd NU;
    private boolean Os;
    protected com.bytedance.sdk.openadsdk.core.wC.DbA QX;
    protected int Xb;
    protected WeakReference<View> aAs;
    protected Context aGH;
    protected com.bytedance.sdk.openadsdk.QX.eli.eli.MGA aqO;
    protected Map<String, Object> dV;
    protected nlS du;
    private String eli;
    protected final String kb;
    protected com.bytedance.sdk.openadsdk.core.Os.eli nGm;
    protected eli nlS;
    protected com.bykv.vk.openvk.eli.eli.eli.aGH.Os nn;
    public aqO ui;
    protected final int wC;

    public interface eli {
        void eli(View view, int i);
    }

    public boolean eli(nlS nls, Map<String, Object> map) {
        return false;
    }

    public void eli(com.bytedance.sdk.openadsdk.QX.eli.eli.MGA mga) {
        this.aqO = mga;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.wC.DbA dbA) {
        this.QX = dbA;
    }

    public void eli(PAGNativeAd pAGNativeAd) {
        this.NU = pAGNativeAd;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.Os.eli eliVar) {
        this.nGm = eliVar;
    }

    public void ui(boolean z) {
        this.Dfc = z;
    }

    public void eli(com.bykv.vk.openvk.eli.eli.eli.aGH.Os os) {
        this.nn = os;
    }

    public DbA(Context context, ev evVar, String str, int i) {
        this.Dfc = false;
        this.Xb = 0;
        this.Os = false;
        this.aGH = context;
        this.MGA = evVar;
        this.kb = str;
        this.wC = i;
    }

    public DbA(Context context, ev evVar, String str, int i, boolean z) {
        this(context, evVar, str, i);
        this.Os = z;
    }

    public void eli(eli eliVar) {
        this.nlS = eliVar;
    }

    public void eli(Activity activity) {
        if (activity == null) {
            return;
        }
        this.DbA = new WeakReference<>(activity);
    }

    public void eli(View view) {
        if (view == null) {
            return;
        }
        this.FC = new WeakReference<>(view);
    }

    public void DbA(View view) {
        if (view == null) {
            return;
        }
        this.aAs = new WeakReference<>(view);
    }

    public View aGH() {
        WeakReference<Activity> weakReference = this.DbA;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.DbA.get().findViewById(R.id.content);
    }

    public View ui() {
        WeakReference<Activity> weakReference = this.DbA;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        View findViewById = this.DbA.get().findViewById(520093713);
        return findViewById == null ? this.DbA.get().findViewById(520093713) : findViewById;
    }

    public void eli(Map<String, Object> map) {
        Map<String, Object> map2 = this.dV;
        if (map2 != null) {
            map2.putAll(map);
            map.putAll(this.dV);
        }
        this.dV = map;
    }

    public void eli(int i) {
        this.VM = i;
    }

    public void DbA(int i) {
        this.KM = i;
    }

    public void Os(int i) {
        this.Ue = i;
    }

    public void aGH(int i) {
        this.Xb = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.content.Context] */
    @Override // com.bytedance.sdk.openadsdk.core.DbA.Os
    public void eli(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, boolean z) {
        int i;
        boolean z2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        com.bytedance.sdk.openadsdk.core.du.aGH eli2;
        if (this.aGH == null) {
            this.aGH = dV.eli();
        }
        if ((this.Os || !eli(view, 1, f, f2, f3, f4, sparseArray, z)) && this.aGH != null) {
            aqO aqo = this.ui;
            if (aqo != null) {
                i = aqo.nlS;
                jSONObject = this.ui.NU;
                jSONObject2 = this.ui.dV;
                z2 = this.ui.nGm;
            } else {
                i = -1;
                z2 = false;
                jSONObject = null;
                jSONObject2 = null;
            }
            long j = this.gG;
            long j2 = this.ujq;
            WeakReference<View> weakReference = this.FC;
            View view2 = weakReference == null ? null : weakReference.get();
            WeakReference<View> weakReference2 = this.aAs;
            nlS eli3 = eli(f, f2, f3, f4, sparseArray, j, j2, view2, weakReference2 == null ? null : weakReference2.get(), MGA(), SSo.wC(this.aGH), SSo.aAs(this.aGH), SSo.FC(this.aGH), i, jSONObject, jSONObject2);
            this.du = eli3;
            if (eli(eli3, this.dV)) {
                return;
            }
            if (this.nn != null) {
                if (this.dV == null) {
                    this.dV = new HashMap();
                }
                this.dV.put("duration", Long.valueOf(this.nn.MGA()));
            }
            ev evVar = this.MGA;
            if (this.Os || z2) {
                com.bytedance.sdk.openadsdk.aGH.Os.eli("click", evVar, this.du, this.kb, true, this.dV, z ? 1 : 2);
                com.bytedance.sdk.openadsdk.core.model.aGH UCq = evVar.UCq();
                if (UCq == null || evVar.Kv() || (eli2 = UCq.eli()) == null) {
                    return;
                }
                com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.nn;
                eli2.kb(os != null ? os.MGA() : 0L);
                return;
            }
            eli eliVar = this.nlS;
            if (eliVar != null) {
                eliVar.eli(view, -1);
            }
            if (eli(view, z)) {
                boolean DbA = KM.DbA(evVar);
                String eli4 = DbA ? this.kb : dZ.eli(this.wC);
                if (view != null) {
                    try {
                        Boolean bool = (Boolean) view.getTag(520093762);
                        Boolean bool2 = bool;
                        if (bool.booleanValue()) {
                            Cp.eli(true);
                        }
                    } catch (Exception unused) {
                    }
                }
                Activity eli5 = view != null ? com.bytedance.sdk.component.utils.DbA.eli(view) : null;
                boolean eli6 = Cp.eli(eli5 == null ? this.aGH : eli5, evVar, this.wC, this.NU, this.nGm, eli4, this.aqO, DbA, 0);
                Cp.eli(false);
                if (eli6 || evVar == null || evVar.Eh() == null || evVar.Eh().Os() != 2) {
                    if (evVar != null && !eli6 && TextUtils.isEmpty(evVar.dM()) && com.bytedance.sdk.openadsdk.aGH.DbA.eli(this.kb)) {
                        com.bytedance.sdk.openadsdk.QX.eli.eli.kb.eli(this.aGH, this.kb).Os(evVar);
                    }
                    com.bytedance.sdk.openadsdk.aGH.Os.eli("click", evVar, this.du, this.kb, eli6, this.dV, z ? 1 : 2);
                }
            }
        }
    }

    public boolean eli(View view, boolean z) {
        return eli(view, this.MGA, z);
    }

    public static boolean eli(View view, ev evVar, boolean z) {
        if (view != null && evVar != null) {
            try {
                String valueOf = String.valueOf(view.getTag(com.bytedance.sdk.component.adexpress.dynamic.eli.Xb));
                if (view.getTag(com.bytedance.sdk.component.adexpress.dynamic.eli.Xb) != null && !TextUtils.isEmpty(valueOf)) {
                    if ("click".equals(valueOf)) {
                        return z;
                    }
                    return true;
                }
            } catch (Exception unused) {
            }
            if (Os(view)) {
                return evVar.Yw() != 1 || z;
            }
            if (evVar.rQ() == 1 && !z) {
                return false;
            }
        }
        return true;
    }

    protected nlS eli(float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, long j, long j2, View view, View view2, String str, float f5, int i, float f6, int i2, JSONObject jSONObject, JSONObject jSONObject2) {
        return new nlS.eli().MGA(f).ui(f2).aGH(f3).Os(f4).DbA(j).eli(j2).DbA(SSo.eli(view)).eli(SSo.eli(view2)).Os(SSo.Os(view)).aGH(SSo.Os(view2)).aGH(this.Ue).ui(this.KM).MGA(this.VM).eli(sparseArray).DbA(FC.DbA().eli() ? 1 : 2).eli(str).eli(f5).Os(i).DbA(f6).eli(i2).eli(jSONObject).DbA(jSONObject2).eli();
    }

    protected boolean eli(View view, int i, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, boolean z) {
        if (this.QX == null) {
            return false;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        WeakReference<View> weakReference = this.aAs;
        if (weakReference != null) {
            iArr = SSo.eli(weakReference.get());
            iArr2 = SSo.Os(this.aAs.get());
        }
        this.QX.eli(view, i, new aqO.eli().aGH(f).Os(f2).DbA(f3).eli(f4).DbA(this.gG).eli(this.ujq).aGH(iArr[0]).ui(iArr[1]).MGA(iArr2[0]).kb(iArr2[1]).eli(sparseArray).eli(z).eli());
        return true;
    }

    public static boolean Os(View view) {
        return 520093705 == view.getId() || 520093707 == view.getId() || 520093703 == view.getId() || eli(view.getContext()) == view.getId() || com.bytedance.sdk.openadsdk.utils.aqO.XxP == view.getId() || com.bytedance.sdk.openadsdk.utils.aqO.ILu == view.getId();
    }

    private static int eli(Context context) {
        if (Cp == Integer.MIN_VALUE) {
            Cp = com.bytedance.sdk.component.utils.ev.ui(context, "btn_native_creative");
        }
        return Cp;
    }

    public String MGA() {
        return this.eli;
    }

    public void eli(String str) {
        this.eli = str;
    }
}
