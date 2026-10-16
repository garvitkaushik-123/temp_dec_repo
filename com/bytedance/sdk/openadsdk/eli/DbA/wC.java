package com.bytedance.sdk.openadsdk.eli.DbA;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.Vy.DbA.ui;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.FC;
import com.bytedance.sdk.openadsdk.core.Os.kb;
import com.bytedance.sdk.openadsdk.core.aqO;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.GB;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.bytedance.sdk.openadsdk.utils.gG;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class wC extends PAGNativeAd {
    protected final ev DbA;
    private boolean FC;
    protected int MGA;
    protected final Context Os;
    protected eli aGH;
    protected aqO eli;
    protected String kb;
    protected int ui;
    private boolean wC;

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void showPrivacyActivity() {
    }

    public wC(Context context, ev evVar, int i, boolean z) {
        this.DbA = evVar;
        this.Os = context;
        this.ui = i;
        this.MGA = evVar.RTg();
        this.kb = dZ.Os(i);
        if (z) {
            this.aGH = new eli(context, evVar, this.kb);
            this.eli = new aqO(context, this, evVar, eli(i), this.aGH);
        }
    }

    private List<View> eli(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                linkedList.add(list.get(i));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                linkedList.add(list2.get(i2));
            }
        }
        return linkedList;
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
            Xb.Os("TTNativeAdImpl", th.getMessage());
            return null;
        }
    }

    private String eli(int i) {
        if (i == 1) {
            return "banner_ad";
        }
        if (i == 2) {
            return "interaction";
        }
        return "embeded_ad";
    }

    protected boolean kb() {
        ev evVar = this.DbA;
        return (evVar == null || evVar.yw() == 5 || dV.aGH().Os(this.MGA) != 1) ? false : true;
    }

    protected void eli(String str) {
        this.kb = str;
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

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, PAGNativeAdInteractionListener pAGNativeAdInteractionListener) {
        if (viewGroup == null || list == null || list.size() <= 0) {
            return;
        }
        eli(viewGroup, null, list, list2, view, new kb(pAGNativeAdInteractionListener));
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, PAGNativeAdInteractionCallback pAGNativeAdInteractionCallback) {
        registerViewForInteraction(viewGroup, list, list2, view, (PAGNativeAdInteractionListener) pAGNativeAdInteractionCallback);
    }

    public void eli(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, final MGA mga) {
        if (viewGroup == null || list2 == null || list2.size() <= 0) {
            return;
        }
        if (kb()) {
            list3 = eli(list2, list3);
        }
        List<View> list4 = list3;
        if (view != null && mga != null && mga.DbA()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.eli.DbA.wC.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    final String eli = gG.eli();
                    TTDelegateActivity.eli(wC.this.DbA, eli, new kb.eli() { // from class: com.bytedance.sdk.openadsdk.eli.DbA.wC.1.1
                        @Override // com.bytedance.sdk.openadsdk.core.Os.kb.eli
                        public void eli() {
                            mga.eli();
                            FC.DbA().MGA(eli);
                            PAGMediaView eli2 = wC.this.wC().eli();
                            if (eli2 != null) {
                                eli2.close();
                            }
                        }
                    });
                }
            });
        }
        this.eli.eli(viewGroup, list, list2, list4, view, mga);
        ev evVar = this.DbA;
        com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(viewGroup, this.DbA, (evVar == null || evVar.BDs() != 2) ? null : new ui.eli(this.DbA.rH()));
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public PAGNativeAdData getNativeAdData() {
        return new aGH(wC());
    }

    public eli wC() {
        return this.aGH;
    }
}
