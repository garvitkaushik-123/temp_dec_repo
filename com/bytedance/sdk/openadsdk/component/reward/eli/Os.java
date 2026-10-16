package com.bytedance.sdk.openadsdk.component.reward.eli;

import android.R;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.common.Dfc;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.Xb;

/* loaded from: classes3.dex */
public class Os {
    private com.bytedance.sdk.openadsdk.common.Dfc DbA;
    private TTAdDislikeToast Os;
    private final eli eli;

    public Os(eli eliVar) {
        this.eli = eliVar;
    }

    public void eli(com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA) {
        if (this.eli.SSo.isFinishing()) {
            return;
        }
        if (this.eli.nlS.get() || (this.eli.yKf != null && this.eli.yKf.dZ().CMM())) {
            if (this.Os == null) {
                this.Os = new TTAdDislikeToast(this.eli.SSo);
                ((FrameLayout) this.eli.SSo.findViewById(R.id.content)).addView(this.Os);
            }
            this.Os.show(TTAdDislikeToast.getDislikeTip());
            this.eli.nlS.set(true);
            return;
        }
        if (this.DbA == null) {
            try {
                DbA(dbA);
            } catch (Throwable th) {
                ApmHelper.reportCustomError("initDislike error", "RewardFullDislikeManager", th);
            }
        }
        com.bytedance.sdk.openadsdk.common.Dfc dfc = this.DbA;
        if (dfc != null) {
            dfc.eli();
        }
    }

    public void eli() {
        TTAdDislikeToast tTAdDislikeToast = this.Os;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.hide();
        }
    }

    public void DbA() {
        TTAdDislikeToast tTAdDislikeToast = this.Os;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.onDestroy();
        }
    }

    private void DbA(final com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA) {
        if (this.DbA == null) {
            com.bytedance.sdk.openadsdk.common.Dfc dfc = new com.bytedance.sdk.openadsdk.common.Dfc(this.eli.SSo, this.eli.DbA);
            this.DbA = dfc;
            dfc.setCallback(new Dfc.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.Os.1
                @Override // com.bytedance.sdk.openadsdk.common.Dfc.eli
                public void eli(View view) {
                    Os.this.eli.du.set(true);
                    String str = "landing_page";
                    if (!Xb.DbA(Os.this.eli.DbA) && !Xb.aGH(Os.this.eli.DbA) && !Xb.ui(Os.this.eli.DbA)) {
                        if (Os.this.eli.aAs.get()) {
                            if (!KM.DbA(Os.this.eli.DbA)) {
                                if (!Os.this.eli.DbA.XxP()) {
                                    str = "endcard";
                                }
                            } else {
                                str = "playable";
                            }
                        } else {
                            str = "video_player";
                        }
                    }
                    Os.this.DbA.setDislikeSource(str);
                    if (Os.this.eli.ev.ui) {
                        if (Os.this.eli.ujq != null) {
                            Os.this.eli.ujq.eli(8, false);
                            return;
                        }
                        return;
                    }
                    dbA.aqO();
                    if (Os.this.eli.ev.MGA()) {
                        Os.this.eli.ev.bf();
                    }
                    if ((Os.this.eli.yKf instanceof com.bytedance.sdk.openadsdk.activity.ui) && !Os.this.eli.yKf.eU()) {
                        Os.this.eli.yKf.dZ().DbA(Os.this.eli.yKf, 2);
                    }
                    com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(Os.this.eli.DbA, 8);
                    Os.this.eli.gG.nn();
                }

                @Override // com.bytedance.sdk.openadsdk.common.Dfc.eli
                public void DbA(View view) {
                    Os.this.eli.du.set(false);
                    if (Os.this.eli.ev.ui) {
                        if (Os.this.eli.ujq != null) {
                            Os.this.eli.ujq.eli(0, true);
                            return;
                        }
                        return;
                    }
                    Os.this.eli.ev.eli(dbA);
                    if (Os.this.eli.ev.FC()) {
                        Os.this.eli.ev.Xb();
                    }
                    if ((Os.this.eli.yKf instanceof com.bytedance.sdk.openadsdk.activity.ui) && !Os.this.eli.yKf.eU()) {
                        Os.this.eli.yKf.dZ().DbA(Os.this.eli.yKf, 1);
                    }
                    com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(Os.this.eli.DbA, 4);
                    Os.this.eli.gG.ui(0);
                }

                @Override // com.bytedance.sdk.openadsdk.common.Dfc.eli
                public void eli(FilterWord filterWord) {
                    if (Os.this.eli.nlS.get() || filterWord == null || filterWord.hasSecondOptions()) {
                        return;
                    }
                    Os.this.eli.nlS.set(true);
                    if (Os.this.eli.yKf != null) {
                        Os.this.eli.yKf.dZ().DbA(true);
                    }
                    Os.this.Os();
                }
            });
            ((FrameLayout) this.eli.SSo.findViewById(R.id.content)).addView(this.DbA);
        }
        if (this.Os == null) {
            this.Os = new TTAdDislikeToast(this.eli.SSo);
            ((FrameLayout) this.eli.SSo.findViewById(R.id.content)).addView(this.Os);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os() {
        TTAdDislikeToast tTAdDislikeToast = this.Os;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.show(TTAdDislikeToast.getDislikeSendTip());
        }
    }
}
