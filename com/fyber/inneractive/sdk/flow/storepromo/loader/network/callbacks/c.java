package com.fyber.inneractive.sdk.flow.storepromo.loader.network.callbacks;

import com.fyber.inneractive.sdk.flow.storepromo.loader.g;
import com.fyber.inneractive.sdk.network.e0;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class c implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final g f1231a;
    public boolean b = false;
    public final String c;

    public c(g gVar, String str) {
        this.f1231a = gVar;
        this.c = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0076, code lost:
    
        if ((r3 - r4) < 2) goto L21;
     */
    @Override // com.fyber.inneractive.sdk.network.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Object obj, Exception exc, boolean z) {
        String str = (String) obj;
        boolean z2 = false;
        if (this.b) {
            IAlog.a("StorePromoTemplateCallback: onNetworkResult: the cached response was applied and this one being cached", new Object[0]);
            return;
        }
        IAlog.a("StorePromoTemplateCallback: onNetworkResult: fromCache: " + z, new Object[0]);
        this.b = true;
        if (str != null && exc == null) {
            g gVar = this.f1231a;
            gVar.getClass();
            IAlog.a("StorePromoResourcesLoader: onTemplateDownloaded", new Object[0]);
            gVar.d.c = str;
            gVar.a(null, false, null, null);
            return;
        }
        String str2 = "Unable download store promo template, error: " + (exc != null ? exc.getMessage() != null ? exc.getMessage() : exc.toString() : "");
        g gVar2 = this.f1231a;
        com.fyber.inneractive.sdk.flow.storepromo.events.a aVar = com.fyber.inneractive.sdk.flow.storepromo.events.a.DOWNLOAD_RESOURCE_ERROR;
        String str3 = this.c;
        if (com.fyber.inneractive.sdk.flow.storepromo.loader.network.b.TEMPLATE_FAILURE == com.fyber.inneractive.sdk.flow.storepromo.loader.network.b.SCREENSHOT_FAILURE) {
            int i = gVar2.f;
            int i2 = gVar2.g + 1;
            gVar2.g = i2;
        }
        z2 = true;
        gVar2.a(aVar, z2, str2, str3);
    }
}
