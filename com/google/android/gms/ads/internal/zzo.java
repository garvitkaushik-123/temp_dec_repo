package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.zzbk;
import com.google.android.gms.internal.ads.zzfdx;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
final class zzo extends WebViewClient {
    final /* synthetic */ zzu zza;

    zzo(zzu zzuVar) {
        Objects.requireNonNull(zzuVar);
        this.zza = zzuVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        zzbk zzbkVar;
        zzbk zzbkVar2;
        zzbk zzbkVar3;
        zzbk zzbkVar4;
        zzu zzuVar = this.zza;
        zzbkVar = zzuVar.zzg;
        if (zzbkVar != null) {
            try {
                zzbkVar2 = zzuVar.zzg;
                zzbkVar2.zzf(zzfdx.zzd(1, null, null));
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            }
        }
        zzu zzuVar2 = this.zza;
        zzbkVar3 = zzuVar2.zzg;
        if (zzbkVar3 != null) {
            try {
                zzbkVar4 = zzuVar2.zzg;
                zzbkVar4.zze(0);
            } catch (RemoteException e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        zzbk zzbkVar;
        zzbk zzbkVar2;
        zzbk zzbkVar3;
        zzbk zzbkVar4;
        zzbk zzbkVar5;
        zzbk zzbkVar6;
        zzbk zzbkVar7;
        zzbk zzbkVar8;
        zzbk zzbkVar9;
        zzbk zzbkVar10;
        zzbk zzbkVar11;
        zzbk zzbkVar12;
        zzbk zzbkVar13;
        zzu zzuVar = this.zza;
        if (str.startsWith(zzuVar.zzr())) {
            return false;
        }
        if (str.startsWith("gmsg://noAdLoaded")) {
            zzbkVar10 = zzuVar.zzg;
            if (zzbkVar10 != null) {
                try {
                    zzbkVar11 = zzuVar.zzg;
                    zzbkVar11.zzf(zzfdx.zzd(3, null, null));
                } catch (RemoteException e) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
                }
            }
            zzu zzuVar2 = this.zza;
            zzbkVar12 = zzuVar2.zzg;
            if (zzbkVar12 != null) {
                try {
                    zzbkVar13 = zzuVar2.zzg;
                    zzbkVar13.zze(3);
                } catch (RemoteException e2) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e2);
                }
            }
            this.zza.zzX(0);
            return true;
        }
        if (str.startsWith("gmsg://scriptLoadFailed")) {
            zzu zzuVar3 = this.zza;
            zzbkVar6 = zzuVar3.zzg;
            if (zzbkVar6 != null) {
                try {
                    zzbkVar7 = zzuVar3.zzg;
                    zzbkVar7.zzf(zzfdx.zzd(1, null, null));
                } catch (RemoteException e3) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e3);
                }
            }
            zzu zzuVar4 = this.zza;
            zzbkVar8 = zzuVar4.zzg;
            if (zzbkVar8 != null) {
                try {
                    zzbkVar9 = zzuVar4.zzg;
                    zzbkVar9.zze(0);
                } catch (RemoteException e4) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e4);
                }
            }
            this.zza.zzX(0);
            return true;
        }
        if (str.startsWith("gmsg://adResized")) {
            zzu zzuVar5 = this.zza;
            zzbkVar4 = zzuVar5.zzg;
            if (zzbkVar4 != null) {
                try {
                    zzbkVar5 = zzuVar5.zzg;
                    zzbkVar5.zzi();
                } catch (RemoteException e5) {
                    int i5 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e5);
                }
            }
            zzu zzuVar6 = this.zza;
            zzuVar6.zzX(zzuVar6.zzb(str));
            return true;
        }
        if (str.startsWith("gmsg://")) {
            return true;
        }
        zzu zzuVar7 = this.zza;
        zzbkVar = zzuVar7.zzg;
        if (zzbkVar != null) {
            try {
                zzbkVar2 = zzuVar7.zzg;
                zzbkVar2.zzc();
                zzbkVar3 = zzuVar7.zzg;
                zzbkVar3.zzh();
            } catch (RemoteException e6) {
                int i6 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e6);
            }
        }
        zzu zzuVar8 = this.zza;
        zzu.zzx(zzuVar8, zzu.zzp(zzuVar8, str));
        return true;
    }
}
