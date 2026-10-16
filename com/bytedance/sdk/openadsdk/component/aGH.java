package com.bytedance.sdk.openadsdk.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.sdk.component.utils.DbA;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.Ue;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.GB;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.gG;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class aGH extends PAGAppOpenAd {
    private final ev DbA;
    private boolean FC;
    private final AdSlot Os;
    private com.bytedance.sdk.openadsdk.eli.aGH.DbA aGH;
    private final Context eli;
    private final boolean kb;
    private boolean wC;
    private final AtomicBoolean ui = new AtomicBoolean(false);
    private final String MGA = gG.eli();

    public aGH(Context context, ev evVar, boolean z, AdSlot adSlot) {
        this.eli = context;
        this.DbA = evVar;
        this.kb = z;
        this.Os = adSlot;
    }

    @Override // com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd
    public void setAdInteractionListener(PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener) {
        this.aGH = new ui(pAGAppOpenAdInteractionListener);
        eli();
    }

    @Override // com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd
    public void setAdInteractionCallback(PAGAppOpenAdInteractionCallback pAGAppOpenAdInteractionCallback) {
        this.aGH = new ui(pAGAppOpenAdInteractionCallback);
        eli();
    }

    private void eli() {
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            cyF.Os(new wC("AppOpenAd_registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.component.aGH.1
                @Override // java.lang.Runnable
                public void run() {
                    IListenerManager asInterface;
                    com.bytedance.sdk.openadsdk.multipro.aidl.eli eli = com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli();
                    if (aGH.this.aGH == null || (asInterface = com.bytedance.sdk.openadsdk.multipro.aidl.eli.DbA.asInterface(eli.eli(7))) == null) {
                        return;
                    }
                    try {
                        asInterface.registerAppOpenAdListener(aGH.this.MGA, new com.bytedance.sdk.openadsdk.multipro.aidl.DbA.eli(aGH.this.aGH));
                        aGH.this.aGH = null;
                    } catch (RemoteException e) {
                        Xb.Os("TTAppOpenAdImpl", e.getMessage());
                    }
                }
            }, 5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd
    public void show(Activity activity) {
        int i;
        if (activity != null && activity.isFinishing()) {
            activity = null;
        }
        if (this.ui.getAndSet(true)) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Cannot be called in a child thread ---- TTAppOpenAdImpl.showAppOpenAd");
        }
        IPMiBroadcastReceiver.eli(this.eli, this.DbA);
        Context context = activity != null ? activity : this.eli;
        if (context == null) {
            context = dV.eli();
        }
        try {
            i = activity.getWindowManager().getDefaultDisplay().getRotation();
        } catch (Exception unused) {
            i = 0;
        }
        Intent intent = new Intent(context, (Class<?>) TTAppOpenAdActivity.class);
        intent.putExtra("orientation_angle", i);
        intent.putExtra(FirebaseAnalytics.Param.AD_SOURCE, this.kb ? 1 : 2);
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.DbA.iOb().toString());
            intent.putExtra(TTAdConstant.MULTI_PROCESS_META_MD5, this.MGA);
        } else {
            Ue.eli().ui();
            intent.putExtra("meta_index", Ue.eli().eli(this.DbA));
            Ue.eli().eli(this.aGH);
            this.aGH = null;
        }
        intent.putExtra("start_show_time", SystemClock.elapsedRealtime());
        com.bytedance.sdk.component.utils.DbA.eli(context, intent, new DbA.InterfaceC0150DbA() { // from class: com.bytedance.sdk.openadsdk.component.aGH.2
            @Override // com.bytedance.sdk.component.utils.DbA.InterfaceC0150DbA
            public void eli() {
            }

            @Override // com.bytedance.sdk.component.utils.DbA.InterfaceC0150DbA
            public void eli(Throwable th) {
            }
        });
        nn.DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.aGH.3
            @Override // java.lang.Runnable
            public void run() {
                if (aGH.this.Os != null) {
                    try {
                        if (aGH.this.DbA == null || ev.kb(aGH.this.DbA) || aGH.this.DbA.JF()) {
                            return;
                        }
                        MGA eli = MGA.eli(aGH.this.eli);
                        eli.MGA(Integer.parseInt(aGH.this.Os.getCodeId()));
                        eli.eli(aGH.this.Os);
                    } catch (Throwable unused2) {
                    }
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d) {
        if (this.wC) {
            return;
        }
        GB.eli(this.DbA, d);
        this.wC = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d, String str, String str2) {
        if (this.FC) {
            return;
        }
        GB.eli(this.DbA, d, str, str2);
        this.FC = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        ev evVar = this.DbA;
        if (evVar != null) {
            return evVar.FYe();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Object getExtraInfo(String str) {
        ev evVar = this.DbA;
        if (evVar == null || evVar.FYe() == null) {
            return null;
        }
        try {
            return this.DbA.FYe().get(str);
        } catch (Throwable th) {
            Xb.Os("TTAppOpenAdImpl", th.getMessage());
            return null;
        }
    }
}
