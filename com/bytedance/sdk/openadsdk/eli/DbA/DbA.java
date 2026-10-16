package com.bytedance.sdk.openadsdk.eli.DbA;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import com.bykv.vk.openvk.eli.eli.eli.aGH.Os;
import com.bytedance.sdk.component.utils.nGm;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.core.aqO;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA;
import com.bytedance.sdk.openadsdk.multipro.DbA.eli;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.List;

/* loaded from: classes3.dex */
public class DbA extends wC implements Os.InterfaceC0109Os, Os.aGH, eli.InterfaceC0210eli {
    private final com.bytedance.sdk.openadsdk.multipro.DbA.eli FC;
    private long NU;
    private boolean aAs;
    private boolean du;
    private AdSlot nlS;
    private Os wC;

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.InterfaceC0109Os
    public void i_() {
    }

    public DbA(Context context, ev evVar, int i, AdSlot adSlot) {
        super(context, evVar, i, true);
        this.aAs = false;
        this.du = true;
        this.ui = i;
        this.nlS = adSlot;
        this.FC = new com.bytedance.sdk.openadsdk.multipro.DbA.eli();
        eli(this.MGA);
        eli("embeded_ad");
        this.aGH.eli(this);
    }

    public DbA(Context context, ev evVar, int i, AdSlot adSlot, eli eliVar, aqO aqo) {
        super(context, evVar, i, false);
        this.aAs = false;
        this.du = true;
        this.aGH = eliVar;
        this.eli = aqo;
        this.ui = i;
        this.nlS = adSlot;
        this.FC = new com.bytedance.sdk.openadsdk.multipro.DbA.eli();
        eli(this.MGA);
        eli("embeded_ad");
        eliVar.eli(this);
    }

    public View ui() {
        com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA mga;
        if (this.DbA != null && this.Os != null) {
            if (ev.ui(this.DbA)) {
                try {
                    mga = new com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA(this.Os, this.DbA, this.eli.eli());
                    if (this.DbA != null && this.DbA.Kv()) {
                        com.bytedance.sdk.openadsdk.core.du.MGA eli = mga.eli((List<Pair<View, FriendlyObstructionPurpose>>) null);
                        if (this.aGH != null) {
                            this.aGH.eli(eli);
                        }
                    }
                    this.eli.eli(mga.getNativeVideoController());
                    if (this.aGH != null) {
                        this.aGH.eli(mga);
                    }
                    mga.setVideoAdClickListenerTTNativeAd(this);
                    mga.setAdCreativeClickListener(new MGA.eli() { // from class: com.bytedance.sdk.openadsdk.eli.DbA.DbA.1
                        @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA.eli
                        public void eli(View view, int i) {
                            if (DbA.this.eli != null) {
                                DbA.this.eli.eli(view, i);
                            }
                        }
                    });
                    mga.setControllerStatusCallBack(new MGA.DbA() { // from class: com.bytedance.sdk.openadsdk.eli.DbA.DbA.2
                        @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA.DbA
                        public void eli(boolean z, long j, long j2, long j3, boolean z2) {
                            DbA.this.FC.eli = z;
                            DbA.this.FC.ui = j;
                            DbA.this.FC.MGA = j2;
                            DbA.this.FC.kb = j3;
                            DbA.this.FC.aGH = z2;
                        }
                    });
                    mga.setVideoAdLoadListener(this);
                    mga.setVideoAdInteractionListener(this);
                    if (5 == this.ui) {
                        mga.setIsAutoPlay(this.aAs ? this.nlS.isAutoPlay() : this.du);
                    } else {
                        mga.setIsAutoPlay(this.du);
                    }
                    mga.eli(dV.aGH().DbA(String.valueOf(this.MGA)), "feedGetAdView");
                } catch (Exception e) {
                    ApmHelper.reportCustomError("", "getAdView null", e);
                }
                if (!ev.ui(this.DbA) && mga != null && mga.eli(0L, true, false)) {
                    return mga;
                }
                ApmHelper.reportCustomError(this.DbA.GR() + "," + mga, "getAdView null", new RuntimeException());
            }
            mga = null;
            if (!ev.ui(this.DbA)) {
            }
            ApmHelper.reportCustomError(this.DbA.GR() + "," + mga, "getAdView null", new RuntimeException());
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0050, code lost:
    
        if (com.bytedance.sdk.openadsdk.utils.dZ.MGA(r0) != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void eli(int i) {
        int DbA = dV.aGH().DbA(i);
        int Os = nGm.Os(dV.eli());
        if (3 == DbA) {
            this.aAs = false;
            this.du = false;
        } else {
            if (1 == DbA && dZ.aGH(Os)) {
                this.aAs = false;
            } else if (2 == DbA) {
                if (dZ.ui(Os) || dZ.aGH(Os) || dZ.MGA(Os)) {
                    this.aAs = false;
                }
            } else if (4 == DbA) {
                this.aAs = true;
            } else if (5 == DbA) {
                if (!dZ.aGH(Os)) {
                }
            }
            this.du = true;
        }
        if (this.aGH != null) {
            this.aGH.eli(this.aAs);
        }
    }

    public void eli(Os os) {
        this.wC = os;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.aGH
    public void eli(int i, int i2) {
        Os os = this.wC;
        if (os != null) {
            os.eli(i, i2);
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.InterfaceC0109Os
    public void g_() {
        Os os = this.wC;
        if (os != null) {
            os.eli(this);
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.InterfaceC0109Os
    public void h_() {
        Os os = this.wC;
        if (os != null) {
            os.DbA(this);
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.InterfaceC0109Os
    public void eli(long j, long j2) {
        this.NU = j;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.InterfaceC0109Os
    public void j_() {
        Os os = this.wC;
        if (os != null) {
            os.Os(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.DbA.eli.InterfaceC0210eli
    public com.bytedance.sdk.openadsdk.multipro.DbA.eli MGA() {
        return this.FC;
    }

    @Override // com.bytedance.sdk.openadsdk.eli.DbA.wC
    protected void eli(String str) {
        super.eli(str);
    }

    @Override // com.bytedance.sdk.openadsdk.eli.DbA.wC, com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void showPrivacyActivity() {
        if (this.aGH != null) {
            this.aGH.nlS();
        }
    }
}
