package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzen;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfc;
import com.google.android.gms.internal.ads.zzbun;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public abstract class BaseAdView extends ViewGroup {

    @NotOnlyInitialized
    protected final zzen zza;

    protected BaseAdView(Context context, int i) {
        super(context);
        this.zza = new zzen(this, i);
    }

    public void destroy() {
        zzbde.zza(getContext());
        if (((Boolean) zzbfc.zze.zze()).booleanValue()) {
            if (((Boolean) zzbd.zzc().zzb(zzbde.zzlB)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.zze
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseAdView baseAdView = BaseAdView.this;
                        try {
                            baseAdView.zza.zzm();
                        } catch (IllegalStateException e) {
                            zzbun.zza(baseAdView.getContext()).zzh(e, "BaseAdView.destroy");
                        }
                    }
                });
                return;
            }
        }
        this.zza.zzm();
    }

    public AdListener getAdListener() {
        return this.zza.zzb();
    }

    public AdSize getAdSize() {
        return this.zza.zzc();
    }

    public String getAdUnitId() {
        return this.zza.zzk();
    }

    public OnPaidEventListener getOnPaidEventListener() {
        return this.zza.zzd();
    }

    public long getPlacementId() {
        return this.zza.zza();
    }

    public ResponseInfo getResponseInfo() {
        return this.zza.zze();
    }

    public boolean isCollapsible() {
        return this.zza.zzC();
    }

    public boolean isLoading() {
        return this.zza.zzD();
    }

    public void loadAd(final AdRequest adRequest) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbde.zza(getContext());
        if (((Boolean) zzbfc.zzf.zze()).booleanValue()) {
            if (((Boolean) zzbd.zzc().zzb(zzbde.zzlE)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.zzg
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseAdView baseAdView = BaseAdView.this;
                        try {
                            baseAdView.zza.zzn(adRequest.zza);
                        } catch (IllegalStateException e) {
                            zzbun.zza(baseAdView.getContext()).zzh(e, "BaseAdView.loadAd");
                        }
                    }
                });
                return;
            }
        }
        this.zza.zzn(adRequest.zza);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i5 = ((i3 - i) - measuredWidth) / 2;
        int i6 = ((i4 - i2) - measuredHeight) / 2;
        childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        AdSize adSize;
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzo.zzh("Unable to retrieve ad size.", e);
                adSize = null;
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
                i4 = widthInPixels;
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public void pause() {
        zzbde.zza(getContext());
        if (((Boolean) zzbfc.zzg.zze()).booleanValue()) {
            if (((Boolean) zzbd.zzc().zzb(zzbde.zzlC)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.zzf
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseAdView baseAdView = BaseAdView.this;
                        try {
                            baseAdView.zza.zzo();
                        } catch (IllegalStateException e) {
                            zzbun.zza(baseAdView.getContext()).zzh(e, "BaseAdView.pause");
                        }
                    }
                });
                return;
            }
        }
        this.zza.zzo();
    }

    public void resume() {
        zzbde.zza(getContext());
        if (((Boolean) zzbfc.zzh.zze()).booleanValue()) {
            if (((Boolean) zzbd.zzc().zzb(zzbde.zzlA)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.zzd
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseAdView baseAdView = BaseAdView.this;
                        try {
                            baseAdView.zza.zzq();
                        } catch (IllegalStateException e) {
                            zzbun.zza(baseAdView.getContext()).zzh(e, "BaseAdView.resume");
                        }
                    }
                });
                return;
            }
        }
        this.zza.zzq();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdListener(AdListener adListener) {
        zzen zzenVar = this.zza;
        zzenVar.zzs(adListener);
        if (adListener == 0) {
            zzenVar.zzr(null);
            return;
        }
        if (adListener instanceof com.google.android.gms.ads.internal.client.zza) {
            zzenVar.zzr((com.google.android.gms.ads.internal.client.zza) adListener);
        }
        if (adListener instanceof AppEventListener) {
            zzenVar.zzw((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.zza.zzt(adSize);
    }

    public void setAdUnitId(String str) {
        this.zza.zzv(str);
    }

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zza.zzy(onPaidEventListener);
    }

    public void setPlacementId(long j) {
        this.zza.zzz(j);
    }

    protected BaseAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.zza = new zzen(this, attributeSet, false, i);
    }

    protected BaseAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.zza = new zzen(this, attributeSet, false, i2);
    }

    protected BaseAdView(Context context, AttributeSet attributeSet, int i, int i2, boolean z) {
        super(context, attributeSet, i);
        this.zza = new zzen(this, attributeSet, z, i2);
    }

    protected BaseAdView(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.zza = new zzen(this, attributeSet, z);
    }
}
