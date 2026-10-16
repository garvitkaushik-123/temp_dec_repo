package com.applovin.impl;

import android.net.Uri;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class i1 {

    /* renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f482a;

    public i1(com.applovin.impl.sdk.k kVar) {
        this.f482a = kVar;
    }

    public void a(Uri uri) {
        com.applovin.impl.sdk.o.g("DeepLinkManager", "Processing incoming URL: " + uri);
        if (CollectionUtils.atLeastOneValueMatch(uri.getQueryParameterNames(), Arrays.asList("aleid", "alart"))) {
            String queryParameter = uri.getQueryParameter("alart");
            if (StringUtils.isValidString(queryParameter)) {
                this.f482a.x0().b(queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("aleid");
            if (StringUtils.isValidString(queryParameter2)) {
                this.f482a.x0().c(queryParameter2);
            }
        }
    }
}
