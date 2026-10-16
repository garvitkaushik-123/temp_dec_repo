package com.moloco.sdk.xenoss.sdkdevkit.android.core;

import com.moloco.sdk.internal.MolocoLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class c implements UserAgentService {
    public static final int c = 8;

    /* renamed from: a, reason: collision with root package name */
    public final String f6353a = "WebBrowserUserAgentService";
    public final Lazy b = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.core.c$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return c.a(c.this);
        }
    });

    public final String a() {
        return (String) this.b.getValue();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.UserAgentService
    public String invoke() {
        return a();
    }

    public static final String a(c cVar) {
        try {
            String property = System.getProperty("http.agent");
            if (property != null) {
                if (!StringsKt.isBlank(property)) {
                    return property;
                }
            }
            return "";
        } catch (Exception e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, cVar.f6353a, e.toString(), null, false, 12, null);
            return "";
        }
    }
}
