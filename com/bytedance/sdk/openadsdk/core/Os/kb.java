package com.bytedance.sdk.openadsdk.core.Os;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.GB;
import com.bytedance.sdk.openadsdk.utils.SSo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class kb extends PAGBannerAd {
    protected ev DbA;
    private int FC;
    private ui MGA;
    protected AdSlot Os;
    private final AtomicBoolean aAs = new AtomicBoolean(false);
    private boolean aGH;
    private List<com.bytedance.sdk.openadsdk.core.Os.eli> du;
    protected Context eli;
    private boolean kb;
    private boolean ui;
    private int wC;

    public interface eli {
        void eli();
    }

    public kb(Context context, ev evVar, AdSlot adSlot) {
        this.wC = 0;
        this.FC = 0;
        this.eli = context;
        this.DbA = evVar;
        this.Os = adSlot;
        this.wC = (int) adSlot.getExpressViewAcceptedWidth();
        this.FC = (int) this.Os.getExpressViewAcceptedHeight();
        eli(this.DbA);
        DbA(evVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
    
        if (r2.aGH().size() > 1) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void eli(ev evVar) {
        com.bytedance.sdk.openadsdk.core.model.eli Os;
        if (evVar == null || (Os = evVar.Os()) == null) {
            return;
        }
        boolean z = Os.aAs();
        this.kb = z;
    }

    public boolean eli() {
        return this.kb;
    }

    private void DbA(ev evVar) {
        com.bytedance.sdk.openadsdk.core.model.eli Os;
        if (evVar == null || (Os = evVar.Os()) == null) {
            return;
        }
        this.du = new ArrayList();
        int size = Os.aGH().size();
        if (this.kb) {
            this.MGA = new ui(Os.kb(), this.eli, this.wC, this.FC);
            for (int i = 0; i < size; i++) {
                this.Os.setExpressViewAccepted(((this.wC - SSo.Os(this.eli, Os.kb().ui())) - SSo.Os(this.eli, Os.kb().MGA())) - (SSo.Os(this.eli, Os.kb().kb()) * 2), this.FC);
                ev evVar2 = Os.aGH().get(i);
                if (i != 0) {
                    eli(i, evVar2);
                }
                com.bytedance.sdk.openadsdk.core.Os.eli eliVar = new com.bytedance.sdk.openadsdk.core.Os.eli(this.eli, evVar2, this.Os, this, true);
                eliVar.eli(i);
                this.du.add(eliVar);
            }
            this.MGA.eli(this.du);
            return;
        }
        this.du.add(new com.bytedance.sdk.openadsdk.core.Os.eli(this.eli, evVar, this.Os, this, false));
    }

    private void eli(int i, ev evVar) {
        if (i != 0) {
            if (!TextUtils.isEmpty(evVar.PfW())) {
                evVar.nn("0");
            }
            Map<String, Object> FYe = evVar.FYe();
            if (FYe == null || !FYe.containsKey("price")) {
                return;
            }
            FYe.put("price", "0");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d) {
        if (this.aGH) {
            return;
        }
        GB.eli(this.DbA, d);
        this.aGH = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d, String str, String str2) {
        if (this.ui) {
            return;
        }
        GB.eli(this.DbA, d, str, str2);
        this.ui = true;
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
            Xb.Os("PAGBannerAdImpl", th.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public void setAdInteractionCallback(final PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback) {
        List<com.bytedance.sdk.openadsdk.core.Os.eli> list = this.du;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.du.size(); i++) {
            this.du.get(i).eli(new PAGBannerAdInteractionCallback() { // from class: com.bytedance.sdk.openadsdk.core.Os.kb.1
                @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback, com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdShowed() {
                    PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback2;
                    if (!kb.this.aAs.compareAndSet(false, true) || (pAGBannerAdInteractionCallback2 = pAGBannerAdInteractionCallback) == null) {
                        return;
                    }
                    pAGBannerAdInteractionCallback2.onAdShowed();
                }

                @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback, com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdClicked() {
                    PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback2 = pAGBannerAdInteractionCallback;
                    if (pAGBannerAdInteractionCallback2 != null) {
                        pAGBannerAdInteractionCallback2.onAdClicked();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback, com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdDismissed() {
                    PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback2 = pAGBannerAdInteractionCallback;
                    if (pAGBannerAdInteractionCallback2 != null) {
                        pAGBannerAdInteractionCallback2.onAdDismissed();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback
                public void onAdShowFailed(PAGErrorModel pAGErrorModel) {
                    PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback2 = pAGBannerAdInteractionCallback;
                    if (pAGBannerAdInteractionCallback2 != null) {
                        pAGBannerAdInteractionCallback2.onAdShowFailed(pAGErrorModel);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public void setAdInteractionListener(final PAGBannerAdInteractionListener pAGBannerAdInteractionListener) {
        List<com.bytedance.sdk.openadsdk.core.Os.eli> list = this.du;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.du.size(); i++) {
            this.du.get(i).eli(new PAGBannerAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.core.Os.kb.2
                @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdShowed() {
                    PAGBannerAdInteractionListener pAGBannerAdInteractionListener2;
                    if (!kb.this.aAs.compareAndSet(false, true) || (pAGBannerAdInteractionListener2 = pAGBannerAdInteractionListener) == null) {
                        return;
                    }
                    pAGBannerAdInteractionListener2.onAdShowed();
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdClicked() {
                    PAGBannerAdInteractionListener pAGBannerAdInteractionListener2 = pAGBannerAdInteractionListener;
                    if (pAGBannerAdInteractionListener2 != null) {
                        pAGBannerAdInteractionListener2.onAdClicked();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdDismissed() {
                    PAGBannerAdInteractionListener pAGBannerAdInteractionListener2 = pAGBannerAdInteractionListener;
                    if (pAGBannerAdInteractionListener2 != null) {
                        pAGBannerAdInteractionListener2.onAdDismissed();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public View getBannerView() {
        try {
            List<com.bytedance.sdk.openadsdk.core.Os.eli> list = this.du;
            if (list != null && !list.isEmpty()) {
                if (this.kb) {
                    return this.MGA.DbA();
                }
                return this.du.get(0).eli();
            }
        } catch (Throwable unused) {
        }
        return new View(this.eli);
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public PAGBannerSize getBannerSize() {
        if (this.Os != null) {
            return new PAGBannerSize(this.wC, this.FC);
        }
        return new PAGBannerSize(0, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public void destroy() {
        try {
            List<com.bytedance.sdk.openadsdk.core.Os.eli> list = this.du;
            if (list == null || list.isEmpty()) {
                return;
            }
            if (this.kb) {
                this.MGA.eli();
            } else {
                this.du.get(0).kb();
            }
        } catch (Throwable unused) {
        }
    }
}
