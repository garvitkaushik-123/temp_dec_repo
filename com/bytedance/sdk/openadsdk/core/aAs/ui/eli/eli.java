package com.bytedance.sdk.openadsdk.core.aAs.ui.eli;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.DbA.Os;
import com.bytedance.adsdk.ugeno.aGH.MGA;

/* loaded from: classes3.dex */
public class eli extends com.bytedance.adsdk.ugeno.aGH.DbA.eli {
    @Override // com.bytedance.adsdk.ugeno.aGH.DbA.eli
    public void DbA() {
    }

    public eli(Os os, String str, MGA.eli eliVar) {
        super(os, str, eliVar);
    }

    @Override // com.bytedance.adsdk.ugeno.aGH.DbA.eli
    public void eli() {
        Os DbA;
        if (this.MGA == null || this.MGA.isEmpty()) {
            return;
        }
        String str = this.MGA.get("id");
        if (TextUtils.isEmpty(str) || (DbA = this.Os.DbA(this.Os)) == null) {
            return;
        }
        Os aGH = DbA.aGH(str);
        if (aGH instanceof com.bytedance.sdk.openadsdk.core.aAs.DbA.eli.eli) {
            com.bytedance.sdk.openadsdk.core.aAs.DbA.eli.eli eliVar = (com.bytedance.sdk.openadsdk.core.aAs.DbA.eli.eli) aGH;
            eliVar.aGH();
            eliVar.eli(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.aAs.ui.eli.eli.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    eli.this.Os();
                }
            });
        }
    }
}
