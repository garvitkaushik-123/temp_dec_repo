package com.bytedance.sdk.openadsdk.core.aAs.ui.DbA;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* loaded from: classes3.dex */
public class eli extends com.bytedance.adsdk.ugeno.aGH.aGH.Os {
    private String du;

    public eli(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.aGH.aGH.Os
    public boolean eli(Object... objArr) {
        com.bytedance.adsdk.ugeno.DbA.Os DbA;
        if (this.ui != null && this.ui.size() > 0) {
            String str = this.ui.get("id");
            this.du = this.ui.get("state");
            if (TextUtils.isEmpty(str) || (DbA = this.DbA.DbA(this.DbA)) == null) {
                return false;
            }
            com.bytedance.adsdk.ugeno.DbA.Os aGH = DbA.aGH(str);
            if (aGH instanceof com.bytedance.sdk.openadsdk.core.aAs.DbA.eli.eli) {
                ((com.bytedance.sdk.openadsdk.core.aAs.DbA.eli.eli) aGH).eli(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.aAs.ui.DbA.eli.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (!TextUtils.equals(eli.this.du, CampaignEx.JSON_NATIVE_VIDEO_COMPLETE) || eli.this.eli == null) {
                            return;
                        }
                        eli.this.eli.eli(eli.this.DbA, eli.this.MGA, eli.this.Os.DbA());
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (!TextUtils.equals(eli.this.du, "start") || eli.this.eli == null) {
                            return;
                        }
                        eli.this.eli.eli(eli.this.DbA, eli.this.MGA, eli.this.Os.DbA());
                    }
                });
            }
        }
        return false;
    }
}
