package com.fyber.inneractive.sdk.measurement;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.flow.r0;
import com.fyber.inneractive.sdk.network.z;
import com.iab.omid.library.fyber.adsession.AdEvents;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.iab.omid.library.fyber.adsession.VerificationScriptResource;
import com.iab.omid.library.fyber.adsession.media.MediaEvents;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public AdSession f1269a;
    public AdEvents b;
    public MediaEvents c;
    public boolean d = false;
    public boolean e = false;
    public r0 f;

    public final void a(Throwable th) {
        String simpleName = th.getClass().getSimpleName();
        String str = "OpenMeasurementNativeVideoTracker - " + th.getMessage();
        r0 r0Var = this.f;
        z.a(simpleName, str, r0Var != null ? r0Var.f1249a : null, r0Var != null ? r0Var.b : null);
    }

    public final ArrayList a(List list) {
        VerificationScriptResource createVerificationScriptResourceWithoutParameters;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            VerificationScriptResource verificationScriptResource = null;
            try {
                if (hVar.f1271a != null) {
                    if (!TextUtils.isEmpty(hVar.e) && !TextUtils.isEmpty(hVar.d)) {
                        createVerificationScriptResourceWithoutParameters = VerificationScriptResource.createVerificationScriptResourceWithParameters(hVar.e, hVar.f1271a, hVar.d);
                    } else {
                        createVerificationScriptResourceWithoutParameters = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(hVar.f1271a);
                    }
                    verificationScriptResource = createVerificationScriptResourceWithoutParameters;
                }
            } catch (Throwable th) {
                a(th);
            }
            if (verificationScriptResource != null) {
                arrayList.add(verificationScriptResource);
            }
        }
        return arrayList;
    }
}
