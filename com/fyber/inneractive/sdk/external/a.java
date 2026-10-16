package com.fyber.inneractive.sdk.external;

import android.content.Context;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.OnFyberMarketplaceInitializedListener;
import com.fyber.inneractive.sdk.network.u;
import com.fyber.inneractive.sdk.network.w;

/* loaded from: classes4.dex */
public final class a implements IAConfigManager.OnConfigurationReadyAndValidListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1163a;
    public final /* synthetic */ OnFyberMarketplaceInitializedListener b;

    public a(Context context, OnFyberMarketplaceInitializedListener onFyberMarketplaceInitializedListener) {
        this.f1163a = context;
        this.b = onFyberMarketplaceInitializedListener;
    }

    @Override // com.fyber.inneractive.sdk.config.IAConfigManager.OnConfigurationReadyAndValidListener
    public final void onConfigurationReadyAndValid(IAConfigManager iAConfigManager, boolean z, Exception exc) {
        if (this.f1163a.getApplicationContext() != null) {
            IAConfigManager.removeListener(this);
            InneractiveAdManager.e = null;
            if (z) {
                InneractiveAdManager.a(this.b, OnFyberMarketplaceInitializedListener.FyberInitStatus.SUCCESSFULLY, null);
            } else {
                InneractiveAdManager.a(this.b, exc instanceof InvalidAppIdException ? OnFyberMarketplaceInitializedListener.FyberInitStatus.INVALID_APP_ID : OnFyberMarketplaceInitializedListener.FyberInitStatus.FAILED, exc.getLocalizedMessage());
            }
            if (d.f1165a.f1155a == null || !IAConfigManager.d() || d.f1165a.d) {
                return;
            }
            d.f1165a.d = true;
            new w(u.IA_IAB_GDPR_TCF_PURPOSE_1_DISABLED).a((String) null);
        }
    }
}
