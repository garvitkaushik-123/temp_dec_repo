package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbgq extends NativeAd.Image {
    private final zzbgp zza;
    private final Drawable zzb;
    private final Uri zzc;
    private final double zzd;
    private final int zze;
    private final int zzf;

    /* JADX WARN: Can't wrap try/catch for region: R(19:0|1|(2:2|3)|(15:5|6|7|8|9|10|11|12|13|14|15|16|17|18|19)|34|6|7|8|9|10|11|12|13|14|15|16|17|18|19) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004f, code lost:
    
        com.google.android.gms.ads.internal.util.client.zzo.zzh("", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:
    
        com.google.android.gms.ads.internal.util.client.zzo.zzh("", r1);
        r1 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0030, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0031, code lost:
    
        com.google.android.gms.ads.internal.util.client.zzo.zzh("", r4);
        r1 = 1.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0023, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0024, code lost:
    
        com.google.android.gms.ads.internal.util.client.zzo.zzh("", r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzbgq(zzbgp zzbgpVar) {
        Drawable drawable;
        IObjectWrapper zzf;
        this.zza = zzbgpVar;
        Uri uri = null;
        try {
            zzf = zzbgpVar.zzf();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
        if (zzf != null) {
            drawable = (Drawable) ObjectWrapper.unwrap(zzf);
            this.zzb = drawable;
            uri = this.zza.zze();
            this.zzc = uri;
            double d = this.zza.zzb();
            this.zzd = d;
            int i = -1;
            int i2 = this.zza.zzd();
            this.zze = i2;
            i = this.zza.zzc();
            this.zzf = i;
        }
        drawable = null;
        this.zzb = drawable;
        uri = this.zza.zze();
        this.zzc = uri;
        double d2 = this.zza.zzb();
        this.zzd = d2;
        int i3 = -1;
        int i22 = this.zza.zzd();
        this.zze = i22;
        i3 = this.zza.zzc();
        this.zzf = i3;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Drawable getDrawable() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final double getScale() {
        return this.zzd;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Uri getUri() {
        return this.zzc;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int zzb() {
        return this.zze;
    }
}
