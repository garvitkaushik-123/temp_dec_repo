package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoMediaView;
import com.bytedance.sdk.openadsdk.core.DbA.DbA;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import com.bytedance.sdk.openadsdk.core.kb;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.Uv;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aqO {
    private com.bytedance.sdk.openadsdk.QX.eli.eli.MGA DbA;
    private final String MGA;
    private com.bytedance.sdk.openadsdk.core.DbA.DbA NU;
    private final Context Os;
    private final com.bytedance.sdk.openadsdk.eli.DbA.eli aAs;
    private final PAGNativeAd aGH;
    private com.bykv.vk.openvk.eli.eli.eli.aGH.Os du;
    private final com.bytedance.sdk.openadsdk.core.model.ev eli;
    private com.bytedance.sdk.openadsdk.eli.DbA.MGA kb;
    private com.bytedance.sdk.openadsdk.core.DbA.eli nn;
    private long wC;
    private List<View> ui = new ArrayList();
    private final com.bytedance.sdk.openadsdk.aGH.kb FC = new com.bytedance.sdk.openadsdk.aGH.kb();
    private final AtomicBoolean nlS = new AtomicBoolean(false);

    public com.bytedance.sdk.openadsdk.aGH.kb eli() {
        return this.FC;
    }

    public aqO(Context context, PAGNativeAd pAGNativeAd, com.bytedance.sdk.openadsdk.core.model.ev evVar, String str, com.bytedance.sdk.openadsdk.eli.DbA.eli eliVar) {
        this.aGH = pAGNativeAd;
        this.eli = evVar;
        this.Os = context;
        this.MGA = str;
        this.aAs = eliVar;
        if (evVar.yw() == 4) {
            this.DbA = com.bytedance.sdk.openadsdk.QX.eli.eli.kb.eli(context, str);
        }
    }

    public void eli(View view, int i) {
        com.bytedance.sdk.openadsdk.eli.DbA.MGA mga = this.kb;
        if (mga != null) {
            mga.onAdClicked();
        }
    }

    public void eli(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.bytedance.sdk.openadsdk.eli.DbA.MGA mga) {
        eli(viewGroup, list, list2, list3, mga);
        eli(viewGroup, view);
        eli(viewGroup, list2, list3);
    }

    private void eli(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.eli.DbA.MGA mga) {
        this.kb = mga;
        viewGroup.addOnLayoutChangeListener(new eli(this.FC, viewGroup));
        this.ui = list;
        eli(list2, (com.bytedance.sdk.openadsdk.core.DbA.Os) null);
        if (list != null) {
            for (View view : this.ui) {
                if (view != null) {
                    view.setTag(520093762, Boolean.TRUE);
                }
            }
            if (list3 != null) {
                list3.addAll(list);
            }
        }
        eli(list3, (com.bytedance.sdk.openadsdk.core.DbA.Os) null);
    }

    private void eli(List<View> list, com.bytedance.sdk.openadsdk.core.DbA.Os os) {
        if (com.bytedance.sdk.component.utils.NU.DbA(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(os);
                    view.setOnTouchListener(os);
                }
            }
        }
    }

    private kb DbA(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.eli.DbA.MGA mga) {
        this.kb = mga;
        viewGroup.addOnLayoutChangeListener(new eli(this.FC, viewGroup));
        this.ui = list;
        kb aGH = aGH(viewGroup);
        if (aGH == null) {
            aGH = new kb(this.Os, viewGroup, false);
            viewGroup.addView(aGH);
        }
        aGH.eli();
        aGH.setRefClickViews(list2);
        if (list != null) {
            for (View view : this.ui) {
                if (view != null) {
                    view.setTag(520093762, Boolean.TRUE);
                }
            }
            if (list3 != null) {
                list3.addAll(list);
            }
        }
        aGH.setRefCreativeViews(list3);
        return aGH;
    }

    public void eli(com.bykv.vk.openvk.eli.eli.eli.aGH.Os os) {
        this.du = os;
        com.bytedance.sdk.openadsdk.core.DbA.DbA dbA = this.NU;
        if (dbA != null) {
            dbA.eli(os);
        }
        com.bytedance.sdk.openadsdk.core.DbA.eli eliVar = this.nn;
        if (eliVar != null) {
            eliVar.eli(os);
        }
    }

    private static class eli implements View.OnLayoutChangeListener {
        private final ViewGroup DbA;
        private final com.bytedance.sdk.openadsdk.aGH.kb eli;

        public eli(com.bytedance.sdk.openadsdk.aGH.kb kbVar, ViewGroup viewGroup) {
            this.eli = kbVar;
            this.DbA = viewGroup;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.eli.eli(System.currentTimeMillis(), nro.eli(this.DbA));
        }
    }

    private void eli(ViewGroup viewGroup, View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("click_scence", 1);
        Context eli2 = viewGroup != null ? com.bytedance.sdk.component.utils.DbA.eli(viewGroup) : null;
        if (eli2 == null) {
            eli2 = this.Os;
        }
        if (this.eli.BDs() == 2) {
            com.bytedance.sdk.openadsdk.core.model.ev evVar = this.eli;
            String str = this.MGA;
            this.NU = new com.bytedance.sdk.openadsdk.core.wC.FC(eli2, evVar, str, dZ.eli(str));
        } else {
            com.bytedance.sdk.openadsdk.core.model.ev evVar2 = this.eli;
            String str2 = this.MGA;
            this.NU = new com.bytedance.sdk.openadsdk.core.DbA.DbA(eli2, evVar2, str2, dZ.eli(str2));
        }
        this.NU.eli(viewGroup);
        this.NU.eli(this.du);
        this.NU.DbA(view);
        this.NU.eli(this.DbA);
        this.NU.eli(this.aGH);
        this.NU.eli(hashMap);
        this.NU.eli(new DbA.eli() { // from class: com.bytedance.sdk.openadsdk.core.aqO.1
            @Override // com.bytedance.sdk.openadsdk.core.DbA.DbA.eli
            public void eli(View view2, int i) {
                if (aqO.this.kb != null) {
                    aqO.this.kb.onAdClicked();
                }
            }
        });
        if (this.eli.BDs() == 2) {
            Context context = this.Os;
            com.bytedance.sdk.openadsdk.core.model.ev evVar3 = this.eli;
            String str3 = this.MGA;
            this.nn = new com.bytedance.sdk.openadsdk.core.wC.wC(context, evVar3, str3, dZ.eli(str3));
        } else {
            Context context2 = this.Os;
            com.bytedance.sdk.openadsdk.core.model.ev evVar4 = this.eli;
            String str4 = this.MGA;
            this.nn = new com.bytedance.sdk.openadsdk.core.DbA.eli(context2, evVar4, str4, dZ.eli(str4));
        }
        this.nn.eli(viewGroup);
        this.nn.eli(this.du);
        this.nn.DbA(view);
        this.nn.eli(this.DbA);
        this.nn.eli(this.aGH);
        this.nn.eli(hashMap);
        this.nn.eli(new DbA.eli() { // from class: com.bytedance.sdk.openadsdk.core.aqO.2
            @Override // com.bytedance.sdk.openadsdk.core.DbA.DbA.eli
            public void eli(View view2, int i) {
                if (aqO.this.kb != null) {
                    aqO.this.kb.onAdClicked();
                }
                com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(aqO.this.eli, 9);
                aqO.this.aAs.NU();
            }
        });
    }

    private void eli(ViewGroup viewGroup, kb kbVar, List<View> list, List<View> list2) {
        com.bytedance.sdk.openadsdk.core.DbA.DbA dbA = this.NU;
        if (dbA == null || this.nn == null) {
            return;
        }
        kbVar.eli(list, dbA);
        kbVar.eli(list2, this.nn);
        eli(this.NU, this.nn);
        eli(kbVar, viewGroup);
    }

    private void eli(ViewGroup viewGroup, List<View> list, List<View> list2) {
        com.bytedance.sdk.openadsdk.core.DbA.DbA dbA = this.NU;
        if (dbA == null || this.nn == null) {
            return;
        }
        eli(list, dbA);
        eli(list2, this.nn);
        eli(this.NU, this.nn);
        eli(viewGroup);
    }

    private void eli(com.bytedance.sdk.openadsdk.core.DbA.DbA dbA, com.bytedance.sdk.openadsdk.core.DbA.eli eliVar) {
        if (this.eli.BDs() == 2) {
            DbA(dbA, eliVar);
        } else {
            eli(eliVar);
        }
    }

    private void DbA(com.bytedance.sdk.openadsdk.core.DbA.DbA dbA, com.bytedance.sdk.openadsdk.core.DbA.eli eliVar) {
        com.bytedance.sdk.openadsdk.eli.DbA.eli eliVar2 = this.aAs;
        if (eliVar2 != null && eliVar2.DbA() != null) {
            com.bytedance.sdk.openadsdk.core.wC.Xb DbA = this.aAs.DbA();
            if ((dbA instanceof com.bytedance.sdk.openadsdk.core.wC.FC) && (eliVar instanceof com.bytedance.sdk.openadsdk.core.wC.wC)) {
                DbA.setClickListener((com.bytedance.sdk.openadsdk.core.wC.FC) dbA);
                DbA.setClickCreativeListener((com.bytedance.sdk.openadsdk.core.wC.wC) eliVar);
            }
            DbA.setJsbLandingPageOpenListener(new com.bytedance.sdk.openadsdk.core.widget.ui() { // from class: com.bytedance.sdk.openadsdk.core.aqO.3
                @Override // com.bytedance.sdk.openadsdk.core.widget.ui
                public void eli() {
                    if (aqO.this.kb != null) {
                        aqO.this.kb.onAdClicked();
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.eli.DbA.eli eliVar3 = this.aAs;
        if (eliVar3 != null && eliVar3.eli() != null) {
            this.aAs.eli().setOnClickListener(eliVar);
            this.aAs.eli().setOnTouchListener(eliVar);
        }
        com.bytedance.sdk.openadsdk.eli.DbA.eli eliVar4 = this.aAs;
        if (eliVar4 != null) {
            eliVar4.eli(eliVar);
            this.aAs.eli(dbA);
        }
    }

    private void eli(com.bytedance.sdk.openadsdk.core.DbA.eli eliVar) {
        if (com.bytedance.sdk.openadsdk.core.settings.NU.nY().Os(String.valueOf(this.eli.RTg()))) {
            com.bytedance.sdk.openadsdk.eli.DbA.eli eliVar2 = this.aAs;
            if (eliVar2 != null && eliVar2.eli() != null) {
                this.aAs.eli().setOnClickListener(eliVar);
                this.aAs.eli().setOnTouchListener(eliVar);
            }
            com.bytedance.sdk.openadsdk.eli.DbA.eli eliVar3 = this.aAs;
            if (eliVar3 != null) {
                eliVar3.eli(eliVar);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.eli.DbA.eli eliVar4 = this.aAs;
        if (eliVar4 != null && eliVar4.eli() != null) {
            PAGMediaView eli2 = this.aAs.eli();
            com.bytedance.sdk.openadsdk.core.DbA.Os os = new com.bytedance.sdk.openadsdk.core.DbA.Os() { // from class: com.bytedance.sdk.openadsdk.core.aqO.4
                @Override // com.bytedance.sdk.openadsdk.core.DbA.Os
                protected void eli(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, boolean z) {
                    if (view instanceof PAGVideoMediaView) {
                        ((PAGVideoMediaView) view).handleInterruptVideo();
                    }
                }
            };
            eli2.setOnClickListener(os);
            eli2.setOnTouchListener(os);
        }
        com.bytedance.sdk.openadsdk.eli.DbA.eli eliVar5 = this.aAs;
        if (eliVar5 != null) {
            eliVar5.eli((com.bytedance.sdk.openadsdk.core.DbA.eli) null);
        }
    }

    private void eli(kb kbVar, final ViewGroup viewGroup) {
        kbVar.setCallback(new kb.eli() { // from class: com.bytedance.sdk.openadsdk.core.aqO.5
            @Override // com.bytedance.sdk.openadsdk.core.kb.eli
            public void eli(boolean z) {
                aqO.this.eli(z, viewGroup);
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.eli
            public void eli() {
                aqO.this.DbA(viewGroup);
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.eli
            public void DbA() {
                aqO.this.DbA();
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.eli
            public void eli(View view) {
                aqO.this.DbA(viewGroup, view);
            }
        });
    }

    private void eli(final ViewGroup viewGroup) {
        Uv.eli(viewGroup, true, 5, false, new Uv.DbA() { // from class: com.bytedance.sdk.openadsdk.core.aqO.6
            @Override // com.bytedance.sdk.openadsdk.utils.Uv.DbA
            public void eli(boolean z) {
                aqO.this.eli(z, viewGroup);
            }

            @Override // com.bytedance.sdk.openadsdk.utils.Uv.DbA
            public void eli() {
                aqO.this.DbA(viewGroup);
            }

            @Override // com.bytedance.sdk.openadsdk.utils.Uv.DbA
            public void DbA() {
                aqO.this.DbA();
            }

            @Override // com.bytedance.sdk.openadsdk.utils.Uv.DbA
            public void eli(View view, boolean z) {
                if (!z) {
                    com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(aqO.this.eli, 8);
                } else {
                    com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(aqO.this.eli, 4);
                    aqO.this.DbA(viewGroup, view);
                }
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(boolean z, ViewGroup viewGroup) {
        if (z && this.eli.ip() && !this.eli.CMM()) {
            this.eli.MGA(true);
            com.bytedance.sdk.openadsdk.core.model.ev evVar = this.eli;
            com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, this.MGA, evVar.nU());
        }
        if (!z && this.wC > 0) {
            String valueOf = String.valueOf(SystemClock.elapsedRealtime() - this.wC);
            this.FC.eli(System.currentTimeMillis(), nro.eli(viewGroup));
            com.bytedance.sdk.openadsdk.aGH.Os.eli(valueOf, this.eli, this.MGA, this.FC);
            this.wC = 0L;
            return;
        }
        this.FC.eli(System.currentTimeMillis(), nro.eli(viewGroup));
        this.wC = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(ViewGroup viewGroup) {
        this.FC.eli(System.currentTimeMillis(), nro.eli(viewGroup));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA() {
        if (this.wC > 0) {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(String.valueOf(SystemClock.elapsedRealtime() - this.wC), this.eli, this.MGA, this.FC);
            this.wC = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(ViewGroup viewGroup, View view) {
        com.bytedance.sdk.openadsdk.core.du.aGH eli2;
        if (this.nlS.get()) {
            return;
        }
        this.nlS.set(true);
        if (this.aGH instanceof com.bytedance.sdk.openadsdk.eli.DbA.eli.Os) {
            com.bytedance.sdk.openadsdk.core.wC.Xb DbA = this.aAs.DbA();
            if (DbA != null) {
                DbA.nGm();
            }
            ((com.bytedance.sdk.openadsdk.eli.DbA.eli.Os) this.aGH).eli(true);
        }
        this.FC.eli(System.currentTimeMillis(), nro.eli(viewGroup));
        this.wC = SystemClock.elapsedRealtime();
        Os(viewGroup);
        com.bytedance.sdk.openadsdk.eli.DbA.MGA mga = this.kb;
        if (mga != null) {
            mga.eli(this.aGH);
        }
        if (this.eli.Zo()) {
            dZ.eli(this.eli, view);
        }
        com.bytedance.sdk.openadsdk.core.model.aGH UCq = this.eli.UCq();
        if (UCq == null || (eli2 = UCq.eli()) == null) {
            return;
        }
        eli2.eli(0L);
    }

    private void Os(ViewGroup viewGroup) {
        com.bytedance.sdk.openadsdk.core.model.ev evVar;
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.ui != null) {
                JSONArray jSONArray = new JSONArray();
                for (View view : this.ui) {
                    if (view != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("width", view.getWidth());
                            jSONObject2.put("height", view.getHeight());
                            jSONObject2.put("alpha", view.getAlpha());
                        } catch (Throwable unused) {
                        }
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("image_view", jSONArray.toString());
            }
            if (viewGroup != null) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("width", viewGroup.getWidth());
                    jSONObject3.put("height", viewGroup.getHeight());
                    jSONObject3.put("alpha", viewGroup.getAlpha());
                } catch (Throwable unused2) {
                }
                jSONObject.put("root_view", jSONObject3.toString());
            }
            if (this.aAs.wC() != null) {
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("width", SSo.Os(this.Os, r11.getWidth()) * 1.0f);
                    jSONObject4.put("height", SSo.Os(this.Os, r11.getHeight()) * 1.0f);
                } catch (Throwable unused3) {
                }
                jSONObject.put("media_view", jSONObject4.toString());
            }
            com.bytedance.sdk.openadsdk.core.wC.Xb DbA = this.aAs.DbA();
            if (DbA != null && (evVar = this.eli) != null) {
                jSONObject.put("dynamic_show_type", evVar.rH());
                DbA.eli(jSONObject, this.eli);
            }
            com.bytedance.sdk.openadsdk.aGH.Os.eli(this.eli, this.MGA, jSONObject);
            com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(this.eli);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.Xb.eli("InteractionManager", "onShowFun json error", e);
        }
    }

    private kb aGH(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof kb) {
                return (kb) childAt;
            }
        }
        return null;
    }
}
