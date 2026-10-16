package com.bytedance.sdk.openadsdk.core.DbA;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.nGm;
import com.bytedance.sdk.openadsdk.core.Cp;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.FC;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.wC.Xb;
import com.bytedance.sdk.openadsdk.core.wC.wC;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli extends DbA {
    private WeakReference<InterfaceC0172eli> Cp;
    private boolean DbA;
    private boolean Os;
    private boolean cyF;
    private int eU;
    private boolean eli;

    /* renamed from: com.bytedance.sdk.openadsdk.core.DbA.eli$eli, reason: collision with other inner class name */
    public interface InterfaceC0172eli {
        long getVideoProgress();
    }

    public boolean DbA() {
        return false;
    }

    public boolean Os() {
        return false;
    }

    public eli(Context context, ev evVar, String str, int i) {
        super(context, evVar, str, i);
        this.eli = true;
        this.DbA = false;
        this.Os = false;
        this.cyF = false;
    }

    public void eli(boolean z) {
        this.eli = z;
    }

    public void DbA(boolean z) {
        this.DbA = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:156:0x0372, code lost:
    
        if (r3.booleanValue() != false) goto L205;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v21, types: [android.content.Context] */
    @Override // com.bytedance.sdk.openadsdk.core.DbA.DbA, com.bytedance.sdk.openadsdk.core.DbA.Os
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void eli(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, boolean z) {
        String str;
        com.bytedance.sdk.openadsdk.core.du.eli io2;
        com.bytedance.sdk.openadsdk.core.du.aGH eli;
        boolean z2;
        JSONObject jSONObject;
        int i;
        JSONObject jSONObject2;
        View view2;
        Activity eli2;
        boolean z3;
        if (!eli(view, 2, f, f2, f3, f4, sparseArray, z)) {
            ev evVar = this.MGA;
            evVar.du(true);
            evVar.oI();
            if (!evVar.Dfc()) {
                evVar.Os(true);
            }
            if (ev.ui(evVar)) {
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, this.kb, evVar.apl());
            }
            if (this.nn != null) {
                if (this.dV == null) {
                    this.dV = new HashMap();
                }
                this.dV.put("duration", Long.valueOf(this.nn.MGA()));
            }
            int ptH = evVar.ptH();
            evVar.FS(0);
            if (this.aqO != null) {
                this.aqO.eli(ptH > 0 ? ptH : 0);
            }
            if (this.dV != null) {
                this.dV.remove("dsp_click_type");
                this.dV.remove("click_probability_jump");
                this.dV.remove("auto_click");
            }
            boolean Kv = evVar.Kv();
            if (ptH > 0) {
                if (this.dV == null) {
                    this.dV = new HashMap();
                }
                if (Kv && ptH < 11) {
                    this.dV.put("dsp_click_type", Integer.valueOf(ptH));
                }
                if (ptH >= 11 && evVar.MKR() == 0) {
                    this.dV.put("click_probability_jump", Integer.valueOf(FC.eli(ptH)));
                }
            }
            com.bytedance.sdk.openadsdk.core.model.aGH UCq = evVar.UCq();
            if (Kv || UCq != null) {
                WeakReference<InterfaceC0172eli> weakReference = this.Cp;
                long videoProgress = (weakReference == null || weakReference.get() == null) ? 0L : this.Cp.get().getVideoProgress();
                if (!Kv && UCq != null && (eli = UCq.eli()) != null) {
                    eli.kb(videoProgress);
                }
                if (Kv) {
                    if (view != null) {
                        Object tag = view.getTag(570425345);
                        if (tag instanceof String) {
                            str = (String) tag;
                            io2 = evVar.io();
                            if (io2 != null) {
                                io2.ui(str);
                                if (!TextUtils.isEmpty(str)) {
                                    eli(str);
                                }
                                if ("VAST_ICON".equals(str)) {
                                    com.bytedance.sdk.openadsdk.core.du.DbA DbA = io2.DbA();
                                    if (DbA != null) {
                                        DbA.eli(videoProgress);
                                    }
                                } else if ("VAST_END_CARD".equals(str)) {
                                    com.bytedance.sdk.openadsdk.core.du.Os Os = io2.Os();
                                    if (Os != null) {
                                        Os.eli(videoProgress);
                                    }
                                } else {
                                    com.bytedance.sdk.openadsdk.core.du.aGH eli3 = io2.eli();
                                    if (eli3 != null) {
                                        eli3.kb(videoProgress);
                                    }
                                }
                            }
                        }
                    }
                    str = "VAST_ACTION_BUTTON";
                    io2 = evVar.io();
                    if (io2 != null) {
                    }
                }
            }
            if (aAs() && aGH(view) && !this.Os) {
                super.eli(view, f, f2, f3, f4, sparseArray, z);
                return;
            }
            if (this.aGH == null) {
                this.aGH = dV.eli();
            }
            if (this.aGH != null && eli(view, z)) {
                JSONObject eli4 = Xb.eli(view);
                if (this.ui != null) {
                    i = this.ui.nlS;
                    jSONObject = this.ui.NU;
                    jSONObject2 = this.ui.dV;
                    z2 = this.ui.nGm;
                } else {
                    z2 = false;
                    jSONObject = eli4;
                    i = -1;
                    jSONObject2 = null;
                }
                this.du = eli(f, f2, f3, f4, sparseArray, this.gG, this.ujq, this.FC == null ? aGH() : this.FC.get(), this.aAs == null ? ui() : this.aAs.get(), MGA(), SSo.wC(this.aGH), SSo.aAs(this.aGH), SSo.FC(this.aGH), i, jSONObject, jSONObject2);
                if (z2) {
                    com.bytedance.sdk.openadsdk.aGH.Os.eli("click", evVar, this.du, this.kb, true, this.dV, z ? 1 : 2);
                    return;
                }
                int yw = evVar.yw();
                if (yw != 2 && yw != 3) {
                    if (yw != 4) {
                        if (yw == 5) {
                            String DbA2 = DbA(this.kb);
                            if (!TextUtils.isEmpty(DbA2)) {
                                com.bytedance.sdk.openadsdk.aGH.Os.eli("click_call", evVar, this.du, DbA2, true, this.dV, z ? 1 : 2);
                            }
                            com.bytedance.sdk.openadsdk.aGH.Os.eli("click", evVar, this.du, this.kb, dZ.DbA(view.getContext(), evVar.lYL()), this.dV, z ? 1 : 2);
                        } else if (yw != 8) {
                            view2 = view;
                            yw = -1;
                            if (this.nlS == null) {
                                this.nlS.eli(view2, yw);
                                return;
                            }
                            return;
                        }
                    } else if (KM.DbA(evVar) && (this.NU != null || this.nGm != null)) {
                        eli2 = view != null ? com.bytedance.sdk.component.utils.DbA.eli(view) : null;
                        boolean eli5 = Cp.eli(eli2 == null ? this.aGH : eli2, evVar, this.wC, this.NU, this.nGm, this.kb, this.aqO, true, ptH);
                        if (this.eli) {
                            com.bytedance.sdk.openadsdk.aGH.Os.eli("click", evVar, this.du, this.kb, eli5, this.dV, z ? 1 : 2);
                        }
                    } else if (this.aqO != null) {
                        this.aqO.Os(evVar);
                        Map<String, Object> map = this.dV;
                        if (evVar.Dfc() && !evVar.nn()) {
                            map.put("auto_click", Boolean.TRUE);
                            evVar.aGH(false);
                        }
                        if (this.eli) {
                            com.bytedance.sdk.openadsdk.aGH.Os.eli("click", evVar, this.du, this.kb, true, map, z ? 1 : 2);
                        }
                    }
                    view2 = view;
                    if (this.nlS == null) {
                    }
                }
                if (yw == 3) {
                    String dM = evVar.dM();
                    if (!TextUtils.isEmpty(dM) && dM.contains("play.google.com/store")) {
                        if (com.bytedance.sdk.openadsdk.QX.eli.eli.aGH.eli(this.aGH, dM, dM.substring(dM.indexOf("?id=") + 4), this.kb, evVar)) {
                            if (this.eli) {
                                com.bytedance.sdk.openadsdk.aGH.Os.eli("click", evVar, this.du, this.kb, true, this.dV, z ? 1 : 2);
                            }
                            view2 = view;
                            if (this.nlS == null) {
                            }
                        }
                    }
                }
                if (this.NU != null || this.DbA) {
                    com.bytedance.sdk.openadsdk.aGH.Os.eli("click_button", evVar, this.du, this.kb, true, this.dV, z ? 1 : 2);
                }
                if (view != null) {
                    try {
                        if (view.getId() != 520093726) {
                            view2 = view;
                            try {
                                if (!(view2 instanceof com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA)) {
                                }
                            } catch (Exception unused) {
                            }
                        } else {
                            view2 = view;
                        }
                        Cp.eli(true);
                    } catch (Exception unused2) {
                        view2 = view;
                    }
                    eli2 = view2 != null ? com.bytedance.sdk.component.utils.DbA.eli(view2) : null;
                    Context context = eli2 == null ? this.aGH : eli2;
                    if (com.bytedance.sdk.openadsdk.core.model.Xb.Os(evVar) && this.cyF) {
                        z3 = false;
                    } else {
                        boolean eli6 = Cp.eli(context, evVar, this.wC, this.NU, this.nGm, this.kb, this.aqO, true, ptH);
                        Cp.eli(false);
                        z3 = eli6;
                    }
                    if (this.eli) {
                        com.bytedance.sdk.openadsdk.aGH.Os.eli("click", evVar, this.du, this.kb, z3, this.dV, z ? 1 : 2);
                    }
                    if (this.nlS == null) {
                    }
                } else {
                    view2 = view;
                }
                Boolean bool = (Boolean) view2.getTag(520093762);
                Boolean bool2 = bool;
            }
        }
    }

    protected boolean eli() {
        ev evVar = this.MGA;
        if (evVar == null) {
            return true;
        }
        int DbA = dV.aGH().DbA(evVar.RTg());
        int Os = nGm.Os(dV.eli());
        if (DbA == 1) {
            return dZ.aGH(Os);
        }
        if (DbA == 2) {
            return dZ.ui(Os) || dZ.aGH(Os) || dZ.MGA(Os);
        }
        if (DbA != 3) {
            return DbA != 5 || dZ.aGH(Os) || dZ.MGA(Os);
        }
        return false;
    }

    private boolean wC() {
        ev evVar = this.MGA;
        return ev.ui(evVar) && evVar.GMY() == 1;
    }

    private boolean aGH(View view) {
        if (view == null) {
            return false;
        }
        if ((view instanceof com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA) || view.getId() == aqO.yw || view.getId() == aqO.Uv || view.getId() == aqO.FS || view.getId() == aqO.jh || view.getId() == aqO.Za || view.getId() == 520093726 || view.getId() == aqO.XlF) {
            return true;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                if (aGH(viewGroup.getChildAt(i))) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    private boolean FC() {
        return this instanceof wC;
    }

    private boolean aAs() {
        ev evVar = this.MGA;
        if (evVar == null || FC()) {
            return false;
        }
        if (evVar.GR() != 5 && evVar.GR() != 15) {
            return false;
        }
        if (this.eU == 0) {
            this.eU = evVar.cK();
        }
        DbA();
        eli();
        Os();
        if (this.eU == 5 && wC() && eli() && !DbA() && !Os()) {
            return false;
        }
        int i = this.eU;
        return i == 1 || i == 2 || i == 5;
    }

    private String DbA(String str) {
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return "banner_call";
            case "open_ad":
                return "open_ad";
            case "embeded_ad":
                return "feed_call";
            case "interaction":
                return "interaction_call";
            case "slide_banner_ad":
                return "banner_call";
            default:
                return "";
        }
    }

    public void Os(boolean z) {
        this.Os = z;
    }

    public void eli(InterfaceC0172eli interfaceC0172eli) {
        this.Cp = new WeakReference<>(interfaceC0172eli);
    }

    public void aGH(boolean z) {
        this.cyF = z;
    }
}
