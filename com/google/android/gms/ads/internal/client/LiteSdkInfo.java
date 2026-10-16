package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbpm;
import com.google.android.gms.internal.ads.zzbpq;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public class LiteSdkInfo extends zzcx {
    public LiteSdkInfo(Context context) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public zzbpq getAdapterCreator() {
        return new zzbpm();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public zzfd getLiteSdkVersion() {
        return new zzfd(ModuleDescriptor.MODULE_VERSION, ModuleDescriptor.MODULE_VERSION, "24.5.0");
    }
}
