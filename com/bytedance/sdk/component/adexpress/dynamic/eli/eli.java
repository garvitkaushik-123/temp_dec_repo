package com.bytedance.sdk.component.adexpress.dynamic.eli;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.DbA.NU;
import com.bytedance.sdk.component.adexpress.DbA.aGH;
import com.bytedance.sdk.component.adexpress.DbA.du;
import com.bytedance.sdk.component.adexpress.DbA.kb;
import com.bytedance.sdk.component.adexpress.DbA.nn;
import com.bytedance.sdk.component.adexpress.Os;
import com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.dynamic.ui.wC;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.utils.FC;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli implements aGH<DynamicRootView>, du {
    private wC DbA;
    private NU MGA;
    private Context Os;
    private kb aGH;
    private DynamicRootView eli;
    private ScheduledFuture<?> kb;
    private com.bytedance.sdk.component.adexpress.DbA.wC ui;
    private AtomicBoolean wC = new AtomicBoolean(false);

    public eli(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, wC wCVar, NU nu, com.bytedance.sdk.component.adexpress.dynamic.MGA.eli eliVar) {
        this.Os = context;
        DynamicRootView dynamicRootView = new DynamicRootView(context, themeStatusBroadcastReceiver, z, nu, eliVar);
        this.eli = dynamicRootView;
        this.DbA = wCVar;
        this.MGA = nu;
        dynamicRootView.setRenderListener(this);
        this.MGA = nu;
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aGH
    public void eli(kb kbVar) {
        this.aGH = kbVar;
        int MGA = this.MGA.MGA();
        if (MGA < 0) {
            this.eli.callBackRenderFail(this.DbA instanceof com.bytedance.sdk.component.adexpress.dynamic.ui.kb ? 127 : Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, "time is ".concat(String.valueOf(MGA)));
            return;
        }
        this.kb = com.bytedance.sdk.component.adexpress.aGH.aGH.eli(new RunnableC0141eli(2), MGA, TimeUnit.MILLISECONDS);
        if (Looper.getMainLooper() == Looper.myLooper() && this.MGA.FC() <= 0) {
            MGA();
        } else {
            FC.DbA().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.eli.eli.1
                @Override // java.lang.Runnable
                public void run() {
                    eli.this.MGA();
                }
            }, this.MGA.FC());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MGA() {
        this.MGA.ui().DbA(Os());
        JSONObject Os = this.MGA.Os();
        if (!com.bytedance.sdk.component.adexpress.eli.DbA.DbA.eli(Os)) {
            this.eli.callBackRenderFail(this.DbA instanceof com.bytedance.sdk.component.adexpress.dynamic.ui.kb ? Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE : 113, "data null is " + (Os == null));
        } else {
            this.DbA.eli(new com.bytedance.sdk.component.adexpress.dynamic.MGA.DbA() { // from class: com.bytedance.sdk.component.adexpress.dynamic.eli.eli.2
                @Override // com.bytedance.sdk.component.adexpress.dynamic.MGA.DbA
                public void eli(final com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
                    eli.this.wC();
                    eli.this.MGA.ui().Os(eli.this.Os());
                    eli.this.eli(wCVar);
                    eli.this.DbA(wCVar);
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                        eli.this.Os(wCVar);
                    } else {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.eli.eli.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                eli.this.Os(wCVar);
                            }
                        });
                    }
                    if (eli.this.eli == null || wCVar == null) {
                        return;
                    }
                    eli.this.eli.setBgColor(wCVar.eli());
                    eli.this.eli.setBgMaterialCenterCalcColor(wCVar.DbA());
                }
            });
            this.DbA.eli(this.MGA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> du;
        if (wCVar == null || (du = wCVar.du()) == null || du.size() <= 0) {
            return;
        }
        Collections.sort(du, new Comparator<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.eli.eli.3
            @Override // java.util.Comparator
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public int compare(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar2, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar3) {
                MGA ui = wCVar2.aAs().ui();
                MGA ui2 = wCVar3.aAs().ui();
                if (ui == null || ui2 == null) {
                    return 0;
                }
                return ui.MQ() >= ui2.MQ() ? 1 : -1;
            }
        });
        for (com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar2 : du) {
            if (wCVar2 != null) {
                eli(wCVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        float f;
        float f2;
        List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> du;
        if (wCVar == null) {
            return;
        }
        List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> du2 = wCVar.du();
        if (du2 == null || du2.size() <= 0) {
            f = 0.0f;
        } else {
            f = 0.0f;
            for (com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar2 : du2) {
                if (wCVar2.kb() > wCVar.kb() - wCVar2.FC() || (du = wCVar2.du()) == null || du.size() <= 0) {
                    f2 = 0.0f;
                } else {
                    f2 = 0.0f;
                    for (com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar3 : du) {
                        if (wCVar3.aAs().DbA().equals("logo-union")) {
                            f2 = wCVar3.aAs().MGA();
                            f = (((-f2) + wCVar.kb()) - wCVar2.kb()) + wCVar2.aAs().ui().nY();
                        }
                    }
                }
                DbA(wCVar2);
                if (f2 <= -15.0f) {
                    wCVar2.MGA(wCVar2.FC() - f2);
                    wCVar2.aGH(wCVar2.kb() + f2);
                    for (com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar4 : wCVar2.du()) {
                        wCVar4.aGH(wCVar4.kb() - f2);
                    }
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.aGH.wC nlS = wCVar.nlS();
        if (nlS == null) {
            return;
        }
        float MGA = wCVar.MGA() - nlS.MGA();
        float kb = wCVar.kb() - nlS.kb();
        wCVar.Os(MGA);
        wCVar.aGH(kb);
        if (f > 0.0f) {
            wCVar.aGH(wCVar.kb() - f);
            wCVar.MGA(wCVar.FC() + f);
            for (com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar5 : wCVar.du()) {
                wCVar5.aGH(wCVar5.kb() + f);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aGH
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    public DynamicRootView ui() {
        return aGH();
    }

    public void DbA() {
        eli(ui());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void eli(View view) {
        if (view == 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                eli(viewGroup.getChildAt(i));
                i++;
            }
        }
        if (view instanceof Cp) {
            ((Cp) view).DbA();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aGH
    public int Os() {
        return this.DbA instanceof com.bytedance.sdk.component.adexpress.dynamic.ui.kb ? 3 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        if (wCVar == null) {
            this.eli.callBackRenderFail(this.DbA instanceof com.bytedance.sdk.component.adexpress.dynamic.ui.kb ? Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE : 113, "layoutUnit is null");
            return;
        }
        this.MGA.ui().aGH(Os());
        try {
            this.eli.render(wCVar, Os());
        } catch (Exception e) {
            this.eli.callBackRenderFail(this.DbA instanceof com.bytedance.sdk.component.adexpress.dynamic.ui.kb ? 128 : Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, "exception is " + e.getMessage());
        }
    }

    public DynamicRootView aGH() {
        return this.eli;
    }

    public void eli(com.bytedance.sdk.component.adexpress.DbA.wC wCVar) {
        this.ui = wCVar;
    }

    private boolean kb() {
        DynamicRootView dynamicRootView = this.eli;
        return (dynamicRootView == null || dynamicRootView.getChildCount() == 0) ? false : true;
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.du
    public void eli(nn nnVar) {
        if (this.wC.get()) {
            return;
        }
        this.wC.set(true);
        if (nnVar.DbA() && kb()) {
            this.eli.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.aGH.eli(ui(), nnVar);
            return;
        }
        this.aGH.eli(nnVar.aAs(), nnVar.FC());
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.du
    public void eli(View view, int i, Os os) {
        com.bytedance.sdk.component.adexpress.DbA.wC wCVar = this.ui;
        if (wCVar != null) {
            wCVar.eli(view, i, os);
        }
    }

    /* renamed from: com.bytedance.sdk.component.adexpress.dynamic.eli.eli$eli, reason: collision with other inner class name */
    private class RunnableC0141eli implements Runnable {
        private int DbA;

        public RunnableC0141eli(int i) {
            this.DbA = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.DbA == 2) {
                eli.this.eli.callBackRenderFail(eli.this.DbA instanceof com.bytedance.sdk.component.adexpress.dynamic.ui.kb ? 127 : Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wC() {
        try {
            ScheduledFuture<?> scheduledFuture = this.kb;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.kb.cancel(false);
            this.kb = null;
        } catch (Throwable unused) {
        }
    }
}
