package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.ads.zzcfg;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzi {
    public final int zza;
    public final ViewGroup.LayoutParams zzb;
    public final ViewGroup zzc;
    public final Context zzd;

    public zzi(zzcfg zzcfgVar) throws zzg {
        this.zzb = zzcfgVar.getLayoutParams();
        ViewParent parent = zzcfgVar.getParent();
        this.zzd = zzcfgVar.zzE();
        if (!(parent instanceof ViewGroup)) {
            throw new zzg("Could not get the parent of the WebView for an overlay.");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        this.zzc = viewGroup;
        this.zza = viewGroup.indexOfChild(zzcfgVar.zzF());
        viewGroup.removeView(zzcfgVar.zzF());
        zzcfgVar.zzaq(true);
    }
}
