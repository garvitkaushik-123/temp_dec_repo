package com.bytedance.sdk.openadsdk.core.du;

import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MGA {
    private kb DbA;
    final Set<Pair<View, FriendlyObstructionPurpose>> eli = new HashSet();

    private MGA() {
        ui.eli(dV.eli());
    }

    private Handler ui() {
        return com.bytedance.sdk.component.utils.FC.DbA();
    }

    public static MGA eli() {
        return new MGA();
    }

    public void eli(final WebView webView) {
        if (webView == null || this.DbA != null) {
            return;
        }
        if (com.bykv.vk.openvk.eli.eli.DbA.DbA.eli.eli()) {
            DbA(webView);
        } else {
            ui().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.du.MGA.1
                @Override // java.lang.Runnable
                public void run() {
                    MGA.this.DbA(webView);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(WebView webView) {
        try {
            if (this.DbA == null) {
                this.DbA = wC.eli(webView);
            }
        } catch (Throwable th) {
            Xb.Os("createWebViewSession failed : ".concat(String.valueOf(th)), new Object[0]);
            HashMap hashMap = new HashMap();
            hashMap.put("scene", "createWebViewSession");
            hashMap.put(PglCryptUtils.KEY_MESSAGE, th.getMessage());
            ui.eli(hashMap);
        }
    }

    public void eli(final View view, final ev evVar) {
        if (this.DbA != null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.model.aGH UCq = evVar.UCq();
        final Set<aAs> DbA = UCq != null ? UCq.DbA() : null;
        if (view == null || DbA == null) {
            return;
        }
        if (com.bykv.vk.openvk.eli.eli.DbA.DbA.eli.eli()) {
            eli(view, DbA, evVar);
        } else {
            ui().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.du.MGA.3
                @Override // java.lang.Runnable
                public void run() {
                    MGA.this.eli(view, (Set<aAs>) DbA, evVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(View view, Set<aAs> set, ev evVar) {
        try {
            if (this.DbA == null) {
                this.DbA = wC.eli(view, set);
                if (evVar.Kv()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, evVar.aGH(), "track_create", (JSONObject) null);
            }
        } catch (Throwable th) {
            Xb.Os("createVideoSession failed : ".concat(String.valueOf(th)), new Object[0]);
            HashMap hashMap = new HashMap();
            hashMap.put("scene", "createVideoSession");
            hashMap.put(PglCryptUtils.KEY_MESSAGE, th.getMessage());
            ui.eli(hashMap);
        }
    }

    public void DbA() {
        if (com.bykv.vk.openvk.eli.eli.DbA.DbA.eli.eli()) {
            MGA();
        } else {
            ui().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.du.MGA.4
                @Override // java.lang.Runnable
                public void run() {
                    MGA.this.MGA();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MGA() {
        if (this.DbA != null) {
            try {
                eli((View) null, (FriendlyObstructionPurpose) null);
                this.DbA.DbA();
            } catch (Throwable unused) {
            }
        }
    }

    public void eli(final boolean z, final float f) {
        if (com.bykv.vk.openvk.eli.eli.DbA.DbA.eli.eli()) {
            DbA(z, f);
        } else {
            ui().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.du.MGA.5
                @Override // java.lang.Runnable
                public void run() {
                    MGA.this.DbA(z, f);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(boolean z, float f) {
        if (this.DbA != null) {
            try {
                eli((View) null, (FriendlyObstructionPurpose) null);
                this.DbA.eli(z, f);
            } catch (Throwable unused) {
            }
        }
    }

    public void Os() {
        if (com.bykv.vk.openvk.eli.eli.DbA.DbA.eli.eli()) {
            kb();
        } else {
            ui().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.du.MGA.6
                @Override // java.lang.Runnable
                public void run() {
                    MGA.this.kb();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kb() {
        kb kbVar = this.DbA;
        if (kbVar != null) {
            try {
                kbVar.aGH();
            } catch (Throwable unused) {
            }
        }
    }

    public void aGH() {
        if (com.bykv.vk.openvk.eli.eli.DbA.DbA.eli.eli()) {
            wC();
        } else {
            ui().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.du.MGA.7
                @Override // java.lang.Runnable
                public void run() {
                    MGA.this.wC();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wC() {
        kb kbVar = this.DbA;
        if (kbVar != null) {
            try {
                kbVar.Os();
            } catch (Throwable unused) {
            }
        }
    }

    public void eli(final View view, final FriendlyObstructionPurpose friendlyObstructionPurpose) {
        if (com.bykv.vk.openvk.eli.eli.DbA.DbA.eli.eli()) {
            DbA(view, friendlyObstructionPurpose);
        } else {
            ui().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.du.MGA.8
                @Override // java.lang.Runnable
                public void run() {
                    MGA.this.DbA(view, friendlyObstructionPurpose);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
        kb kbVar = this.DbA;
        try {
            if (kbVar == null) {
                if (view == null || friendlyObstructionPurpose == null) {
                    return;
                }
                this.eli.add(new Pair<>(view, friendlyObstructionPurpose));
                return;
            }
            if (view != null && friendlyObstructionPurpose != null) {
                kbVar.eli(view, friendlyObstructionPurpose);
            }
            if (this.eli.size() > 0) {
                kbVar.eli(this.eli);
                this.eli.clear();
            }
        } catch (Throwable unused) {
        }
    }

    public void eli(final long j, final boolean z) {
        if (com.bykv.vk.openvk.eli.eli.DbA.DbA.eli.eli()) {
            DbA(j, z);
        } else {
            ui().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.du.MGA.9
                @Override // java.lang.Runnable
                public void run() {
                    MGA.this.DbA(j, z);
                }
            });
        }
    }

    public void DbA(long j, boolean z) {
        kb kbVar = this.DbA;
        if (kbVar != null) {
            try {
                kbVar.eli(j / 1000.0f, z);
            } catch (Throwable unused) {
            }
        }
    }

    public void eli(final boolean z) {
        if (com.bykv.vk.openvk.eli.eli.DbA.DbA.eli.eli()) {
            DbA(z);
        } else {
            ui().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.du.MGA.10
                @Override // java.lang.Runnable
                public void run() {
                    MGA.this.DbA(z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(boolean z) {
        kb kbVar = this.DbA;
        if (kbVar != null) {
            try {
                kbVar.eli(z);
            } catch (Throwable unused) {
            }
        }
    }

    public void eli(final int i) {
        if (com.bykv.vk.openvk.eli.eli.DbA.DbA.eli.eli()) {
            DbA(i);
        } else {
            ui().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.du.MGA.2
                @Override // java.lang.Runnable
                public void run() {
                    MGA.this.DbA(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(int i) {
        kb kbVar = this.DbA;
        if (kbVar != null) {
            try {
                kbVar.DbA(i);
            } catch (Throwable unused) {
            }
        }
    }
}
