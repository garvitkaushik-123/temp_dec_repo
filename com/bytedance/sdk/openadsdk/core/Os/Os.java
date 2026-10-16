package com.bytedance.sdk.openadsdk.core.Os;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.Vy.DbA.ui;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.wC.QX;

/* loaded from: classes3.dex */
public class Os extends aGH {
    private int FC;
    private int aAs;
    private com.bytedance.sdk.openadsdk.eli.eli.DbA wC;

    public Os(Context context, ev evVar, AdSlot adSlot, boolean z) {
        super(context, evVar, adSlot, z);
        this.FC = 1;
        this.aAs = -1;
    }

    public void eli(com.bytedance.sdk.openadsdk.eli.eli.DbA dbA) {
        if (this.DbA != null) {
            ((QX) this.DbA).aqO();
            this.wC = dbA;
            this.aAs = 3;
        }
    }

    public void eli() {
        if (this.DbA != null) {
            ((QX) this.DbA).Dfc();
            this.aAs = 2;
        }
    }

    public void DbA() {
        if (this.DbA != null) {
            ((QX) this.DbA).dV();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Os.aGH
    protected void Os() {
        this.DbA = new QX(this.eli, this.Os, this.aGH, this.MGA, this.kb) { // from class: com.bytedance.sdk.openadsdk.core.Os.Os.1
            @Override // com.bytedance.sdk.openadsdk.core.wC.Xb
            protected ui.eli Os(int i) {
                return Os.this.eli(super.Os(i));
            }
        };
        com.bytedance.sdk.openadsdk.core.nlS.DbA.Os videoController = ((QX) this.DbA).getVideoController();
        if (videoController != null) {
            videoController.aGH(this.FC);
        }
        addView(this.DbA, new ViewGroup.LayoutParams(-1, -1));
        if (this.ui != null) {
            setExpressInteractionListener(this.ui);
        }
        if (this.DbA != null) {
            ((QX) this.DbA).setVideoAdListener(new com.bytedance.sdk.openadsdk.eli.DbA.Os() { // from class: com.bytedance.sdk.openadsdk.core.Os.Os.2
                @Override // com.bytedance.sdk.openadsdk.eli.DbA.Os
                public void DbA(PAGNativeAd pAGNativeAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.eli.DbA.Os
                public void eli(int i, int i2) {
                }

                @Override // com.bytedance.sdk.openadsdk.eli.DbA.Os
                public void eli(PAGNativeAd pAGNativeAd) {
                    if (Os.this.aAs != 3) {
                        if (Os.this.aAs == 2) {
                            Os.this.eli();
                        }
                    } else {
                        Os os = Os.this;
                        os.eli(os.wC);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.eli.DbA.Os
                public void Os(PAGNativeAd pAGNativeAd) {
                    if (Os.this.wC != null) {
                        Os.this.wC.eli();
                    }
                }
            });
        }
    }

    public com.bytedance.sdk.openadsdk.multipro.DbA.eli getVideoModel() {
        if (this.DbA != null) {
            return ((QX) this.DbA).getVideoModel();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Os.aGH
    public void aGH() {
        com.bytedance.sdk.openadsdk.core.nlS.DbA.Os videoController;
        if ((this.DbA instanceof QX) && (videoController = ((QX) this.DbA).getVideoController()) != null) {
            this.FC = videoController.Uv();
        }
        super.aGH();
    }
}
