package com.fyber.inneractive.sdk.mraid;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.e1;
import com.fyber.inneractive.sdk.web.i0;
import com.fyber.inneractive.sdk.web.j1;
import java.util.LinkedHashMap;

/* loaded from: classes4.dex */
public final class r extends e {
    public r(LinkedHashMap linkedHashMap, i0 i0Var, e1 e1Var) {
        super(linkedHashMap, i0Var, e1Var);
    }

    @Override // com.fyber.inneractive.sdk.mraid.f
    public final void a() {
        String str = (String) this.b.get("uri");
        if (TextUtils.isEmpty(str)) {
            this.c.a(k.PLAY_VIDEO, "Video can't be played with null or empty URL");
            return;
        }
        j1 j1Var = ((IAmraidWebViewController) this.c).g;
        if (j1Var != null) {
            ((com.fyber.inneractive.sdk.web.b0) j1Var).a(str);
        }
    }

    @Override // com.fyber.inneractive.sdk.mraid.e
    public final String c() {
        return (String) this.b.get("uri");
    }
}
