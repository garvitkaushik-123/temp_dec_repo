package com.bytedance.sdk.openadsdk.eli.DbA.eli;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.core.aAs.aGH;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.wC.QX;
import com.bytedance.sdk.openadsdk.core.wC.Xb;
import com.bytedance.sdk.openadsdk.eli.DbA.wC;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class Os extends wC {
    protected AdSlot FC;
    protected Xb aAs;
    protected String du;
    private boolean nlS;
    protected final Context wC;

    public Os(Context context, ev evVar, AdSlot adSlot) {
        super(context, evVar, 5, true);
        this.du = "embeded_ad";
        this.nlS = false;
        this.DbA.Dfc(1);
        this.aGH.eli(this);
        this.wC = context;
        this.FC = adSlot;
        eli();
        DbA();
    }

    protected void eli() {
        this.aAs = new Xb(this.wC, this.DbA, this.FC, this.du);
        Os();
    }

    private void DbA() {
        Xb xb = this.aAs;
        if (xb != null) {
            xb.setBackupListener(new com.bytedance.sdk.component.adexpress.DbA.Os() { // from class: com.bytedance.sdk.openadsdk.eli.DbA.eli.Os.1
                @Override // com.bytedance.sdk.component.adexpress.DbA.Os
                public boolean eli(ViewGroup viewGroup, int i) {
                    eli eliVar = new eli(Os.this.aAs.getContext());
                    eliVar.setExtraFuncationHelper(Os.this.aGH);
                    eliVar.eli(Os.this.aAs);
                    return true;
                }
            });
        }
    }

    protected void Os() {
        Xb xb = this.aAs;
        if (xb != null) {
            xb.setExpressInteractionListener(new PAGExpressAdWrapperListener() { // from class: com.bytedance.sdk.openadsdk.eli.DbA.eli.Os.2
                @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
                public void onAdClicked() {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onAdDismissed() {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onAdShow(View view, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onRenderFail(View view, String str, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onRenderSuccess(View view, float f, float f2) {
                    if (!Os.this.aAs.bf()) {
                        Os.this.eli(f, f2);
                        if (Os.this.nlS) {
                            Os.this.aAs.nGm();
                            return;
                        }
                        return;
                    }
                    com.bytedance.sdk.openadsdk.eli.DbA.DbA dbA = new com.bytedance.sdk.openadsdk.eli.DbA.DbA(Os.this.wC, Os.this.DbA, 5, Os.this.FC, Os.this.aGH, Os.this.eli);
                    Os os = Os.this;
                    if (os instanceof DbA) {
                        dbA.eli(((QX) os.aGH()).getVideoAdListener());
                    }
                    Os.this.aGH.eli((com.bytedance.sdk.openadsdk.core.DbA.eli) Os.this.aAs.getClickCreativeListener());
                    PAGMediaView FC = Os.this.aGH.FC();
                    if (FC == null) {
                        FC = new PAGMediaView(Os.this.wC);
                    }
                    Os.this.aAs.addView(FC);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(float f, float f2) {
        Xb xb = this.aAs;
        if (xb != null && aGH.eli(xb.getDynamicShowType())) {
            ViewGroup.LayoutParams layoutParams = this.aAs.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            } else {
                layoutParams.width = -1;
                layoutParams.height = -1;
            }
            this.aAs.setLayoutParams(layoutParams);
            return;
        }
        int DbA = SSo.DbA(this.wC, f);
        int DbA2 = SSo.DbA(this.wC, f2);
        ViewGroup.LayoutParams layoutParams2 = this.aAs.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new ViewGroup.LayoutParams(DbA, DbA2);
        } else {
            layoutParams2.width = DbA;
            layoutParams2.height = DbA2;
        }
        this.aAs.setLayoutParams(layoutParams2);
    }

    public Xb aGH() {
        return this.aAs;
    }

    public void eli(boolean z) {
        this.nlS = z;
    }

    public void ui() {
        Xb xb = this.aAs;
        if (xb != null) {
            xb.QX();
        }
    }
}
