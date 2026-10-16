package io.bidmachine.ads.networks.gam;

import android.content.Context;
import io.bidmachine.AdsFormat;
import io.bidmachine.ExpirationHandler;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.Tag;
import io.bidmachine.utils.lazy.LazyValue;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public abstract class InternalGAMAd implements ExpirationHandler.Listener {
    private final AdsFormat adsFormat;
    private final ExpirationHandler expirationHandler;
    private final GAMLoader gamLoader;
    private final GAMUnitData gamUnitData;
    private volatile Status status = Status.Idle;
    private final Tag tag;
    private WeakReference<InternalGAMAdPresentListener> weakAdPresentListener;

    enum Status {
        Idle,
        Loading,
        Loaded,
        Showing,
        Shown,
        Expired
    }

    protected abstract void destroyAd() throws Throwable;

    protected abstract void loadAd(Context applicationContext, final InternalLoadListener loadListener) throws Throwable;

    InternalGAMAd(GAMLoader gamLoader, AdsFormat adsFormat, GAMUnitData gamUnitData) {
        this.tag = new Tag(gamLoader.getNetworkName() + "Ad");
        this.gamLoader = gamLoader;
        this.adsFormat = adsFormat;
        this.gamUnitData = gamUnitData;
        this.expirationHandler = new ExpirationHandler(gamLoader.getExpirationTimeMs(), this);
    }

    public GAMLoader getGamLoader() {
        return this.gamLoader;
    }

    public AdsFormat getAdsFormat() {
        return this.adsFormat;
    }

    public GAMUnitData getGamUnitData() {
        return this.gamUnitData;
    }

    public String getAdUnitId() {
        return getGamUnitData().getAdUnitId();
    }

    public float getScope() {
        return getGamUnitData().getScore();
    }

    public InternalGAMAdPresentListener getAdPresentListener() {
        WeakReference<InternalGAMAdPresentListener> weakReference = this.weakAdPresentListener;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void setAdPresentListener(InternalGAMAdPresentListener adPresentListener) {
        this.weakAdPresentListener = new WeakReference<>(adPresentListener);
    }

    /* renamed from: lambda$onAdLoaded$0$io-bidmachine-ads-networks-gam-InternalGAMAd, reason: not valid java name */
    /* synthetic */ String m9654lambda$onAdLoaded$0$iobidmachineadsnetworksgamInternalGAMAd() {
        return String.format("onAdLoaded (%s)", this.gamUnitData);
    }

    public void onAdLoaded() {
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam.InternalGAMAd$$ExternalSyntheticLambda3
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return InternalGAMAd.this.m9654lambda$onAdLoaded$0$iobidmachineadsnetworksgamInternalGAMAd();
            }
        });
        setStatus(Status.Loaded);
        this.expirationHandler.start();
    }

    /* renamed from: lambda$onAdShown$1$io-bidmachine-ads-networks-gam-InternalGAMAd, reason: not valid java name */
    /* synthetic */ String m9655lambda$onAdShown$1$iobidmachineadsnetworksgamInternalGAMAd() {
        return String.format("onAdShown (%s)", this.gamUnitData);
    }

    public void onAdShown() {
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam.InternalGAMAd$$ExternalSyntheticLambda0
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return InternalGAMAd.this.m9655lambda$onAdShown$1$iobidmachineadsnetworksgamInternalGAMAd();
            }
        });
        this.gamLoader.onGAMAdShown(this);
        setStatus(Status.Shown);
        this.expirationHandler.stop();
    }

    @Override // io.bidmachine.ExpirationHandler.Listener
    public void onExpired() {
        if (isShown()) {
            return;
        }
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam.InternalGAMAd$$ExternalSyntheticLambda1
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return InternalGAMAd.this.m9656lambda$onExpired$2$iobidmachineadsnetworksgamInternalGAMAd();
            }
        });
        setStatus(Status.Expired);
        InternalGAMAdPresentListener adPresentListener = getAdPresentListener();
        if (adPresentListener != null) {
            adPresentListener.onAdExpired();
        }
        destroy(true);
        this.gamLoader.load(this.adsFormat);
    }

    /* renamed from: lambda$onExpired$2$io-bidmachine-ads-networks-gam-InternalGAMAd, reason: not valid java name */
    /* synthetic */ String m9656lambda$onExpired$2$iobidmachineadsnetworksgamInternalGAMAd() {
        return String.format("onExpired (%s)", this.gamUnitData);
    }

    public void destroy() {
        destroy(isShown());
    }

    private void destroy(boolean canRemoveAd) {
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam.InternalGAMAd$$ExternalSyntheticLambda2
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return InternalGAMAd.this.m9651lambda$destroy$3$iobidmachineadsnetworksgamInternalGAMAd();
            }
        });
        WeakReference<InternalGAMAdPresentListener> weakReference = this.weakAdPresentListener;
        if (weakReference != null) {
            weakReference.clear();
            this.weakAdPresentListener = null;
        }
        this.expirationHandler.stop();
        this.gamLoader.onGAMAdDestroy(this, canRemoveAd);
    }

    /* renamed from: lambda$destroy$3$io-bidmachine-ads-networks-gam-InternalGAMAd, reason: not valid java name */
    /* synthetic */ String m9651lambda$destroy$3$iobidmachineadsnetworksgamInternalGAMAd() {
        return String.format("destroy (%s)", this.gamUnitData);
    }

    /* renamed from: lambda$load$4$io-bidmachine-ads-networks-gam-InternalGAMAd, reason: not valid java name */
    /* synthetic */ String m9652lambda$load$4$iobidmachineadsnetworksgamInternalGAMAd() {
        return String.format("load (%s)", this.gamUnitData);
    }

    final void load(Context context, final InternalLoadListener loadListener) {
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam.InternalGAMAd$$ExternalSyntheticLambda4
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return InternalGAMAd.this.m9652lambda$load$4$iobidmachineadsnetworksgamInternalGAMAd();
            }
        });
        final Context applicationContext = context.getApplicationContext();
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.gam.InternalGAMAd$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                InternalGAMAd.this.m9653lambda$load$5$iobidmachineadsnetworksgamInternalGAMAd(applicationContext, loadListener);
            }
        });
    }

    /* renamed from: lambda$load$5$io-bidmachine-ads-networks-gam-InternalGAMAd, reason: not valid java name */
    /* synthetic */ void m9653lambda$load$5$iobidmachineadsnetworksgamInternalGAMAd(Context context, InternalLoadListener internalLoadListener) {
        try {
            setStatus(Status.Loading);
            loadAd(context, internalLoadListener);
        } catch (Throwable th) {
            Logger.w(th);
            internalLoadListener.onAdLoadFailed(this, BMError.throwable("Exception loading InternalGAM object", th));
        }
    }

    final void release() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.gam.InternalGAMAd$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                InternalGAMAd.this.m9657lambda$release$6$iobidmachineadsnetworksgamInternalGAMAd();
            }
        });
    }

    /* renamed from: lambda$release$6$io-bidmachine-ads-networks-gam-InternalGAMAd, reason: not valid java name */
    /* synthetic */ void m9657lambda$release$6$iobidmachineadsnetworksgamInternalGAMAd() {
        try {
            destroyAd();
        } catch (Throwable th) {
            Logger.w(th);
        }
    }

    void setStatus(Status status) {
        this.status = status;
    }

    boolean isLoaded() {
        return this.status == Status.Loaded;
    }

    boolean isShown() {
        Status status = this.status;
        return status != null && status.ordinal() >= Status.Shown.ordinal();
    }

    boolean isExpired() {
        return this.status == Status.Expired;
    }

    public String toString() {
        return this.tag + ", " + getGamUnitData();
    }
}
