package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbqv extends zzbqe {
    private final NativeAdMapper zza;

    public zzbqv(NativeAdMapper nativeAdMapper) {
        this.zza = nativeAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final boolean zzA() {
        return this.zza.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final boolean zzB() {
        return this.zza.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final double zze() {
        NativeAdMapper nativeAdMapper = this.zza;
        if (nativeAdMapper.getStarRating() != null) {
            return nativeAdMapper.getStarRating().doubleValue();
        }
        return -1.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final float zzf() {
        return this.zza.getMediaContentAspectRatio();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final float zzg() {
        return this.zza.getCurrentTime();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final float zzh() {
        return this.zza.getDuration();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final Bundle zzi() {
        return this.zza.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final com.google.android.gms.ads.internal.client.zzed zzj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final zzbgi zzk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final zzbgp zzl() {
        NativeAd.Image icon = this.zza.getIcon();
        if (icon != null) {
            return new zzbgc(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.zzb(), icon.zza(), null);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final IObjectWrapper zzm() {
        View adChoicesContent = this.zza.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final IObjectWrapper zzn() {
        View zza = this.zza.zza();
        if (zza == null) {
            return null;
        }
        return ObjectWrapper.wrap(zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final IObjectWrapper zzo() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzp() {
        return this.zza.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzq() {
        return this.zza.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzr() {
        return this.zza.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzs() {
        return this.zza.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzt() {
        return this.zza.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzu() {
        return this.zza.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final List zzv() {
        List<NativeAd.Image> images = this.zza.getImages();
        ArrayList arrayList = new ArrayList();
        if (images != null) {
            for (NativeAd.Image image : images) {
                arrayList.add(new zzbgc(image.getDrawable(), image.getUri(), image.getScale(), image.zzb(), image.zza(), null));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zza.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzx() {
        this.zza.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzy(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        HashMap hashMap = (HashMap) ObjectWrapper.unwrap(iObjectWrapper2);
        HashMap hashMap2 = (HashMap) ObjectWrapper.unwrap(iObjectWrapper3);
        this.zza.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), hashMap, hashMap2);
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzz(IObjectWrapper iObjectWrapper) {
        this.zza.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
