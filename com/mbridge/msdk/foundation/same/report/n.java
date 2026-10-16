package com.mbridge.msdk.foundation.same.report;

import com.mbridge.msdk.tracker.network.q;
import com.mbridge.msdk.tracker.network.v;
import com.mbridge.msdk.tracker.w;
import java.io.UnsupportedEncodingException;

/* compiled from: StringReportResponseHandler.java */
/* loaded from: classes6.dex */
public class n extends w {
    @Override // com.mbridge.msdk.tracker.w
    protected v<String> a(q qVar) {
        String str;
        try {
            str = new String(qVar.b, com.mbridge.msdk.tracker.network.toolbox.f.a(qVar.c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(qVar.b);
        }
        return v.a(str, com.mbridge.msdk.tracker.network.toolbox.f.a(qVar));
    }
}
