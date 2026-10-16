package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbsy extends NativeAd.Image {
    private final zzbgp zzb;
    private final Drawable zzc;
    private final Uri zzd;
    private final double zze;
    private final int zzf;
    private final int zzg;

    /* JADX WARN: Can't wrap try/catch for region: R(21:0|1|(2:2|3)|(17:5|6|7|8|9|10|11|12|13|14|15|16|17|18|(2:23|24)|20|21)|40|6|7|8|9|10|11|12|13|14|15|16|17|18|(0)|20|21) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004f, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
    
        com.google.android.gms.ads.internal.util.client.zzo.zzh("", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0041, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0042, code lost:
    
        com.google.android.gms.ads.internal.util.client.zzo.zzh("", r2);
        r2 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0031, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0032, code lost:
    
        com.google.android.gms.ads.internal.util.client.zzo.zzh("", r5);
        r2 = 1.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0023, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0024, code lost:
    
        com.google.android.gms.ads.internal.util.client.zzo.zzh("", r5);
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzbsy(zzbgp zzbgpVar) {
        Drawable drawable;
        IObjectWrapper zzf;
        this.zzb = zzbgpVar;
        Map map = null;
        try {
            zzf = zzbgpVar.zzf();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
        if (zzf != null) {
            drawable = (Drawable) ObjectWrapper.unwrap(zzf);
            this.zzc = drawable;
            Uri uri = this.zzb.zze();
            this.zzd = uri;
            double d = this.zzb.zzb();
            this.zze = d;
            int i = -1;
            int i2 = this.zzb.zzd();
            this.zzf = i2;
            i = this.zzb.zzc();
            this.zzg = i;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzek)).booleanValue()) {
                try {
                    map = this.zzb.zzg();
                } catch (RemoteException unused) {
                }
            }
            this.zza = map;
        }
        drawable = null;
        this.zzc = drawable;
        Uri uri2 = this.zzb.zze();
        this.zzd = uri2;
        double d2 = this.zzb.zzb();
        this.zze = d2;
        int i3 = -1;
        int i22 = this.zzb.zzd();
        this.zzf = i22;
        i3 = this.zzb.zzc();
        this.zzg = i3;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzek)).booleanValue()) {
        }
        this.zza = map;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final Drawable getDrawable() {
        return this.zzc;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final double getScale() {
        return this.zze;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final Uri getUri() {
        return this.zzd;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final int zza() {
        return this.zzg;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final int zzb() {
        return this.zzf;
    }
}
