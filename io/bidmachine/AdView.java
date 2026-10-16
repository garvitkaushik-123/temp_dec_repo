package io.bidmachine;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import io.bidmachine.AdListener;
import io.bidmachine.AdRequest;
import io.bidmachine.AdView;
import io.bidmachine.ViewAd;
import io.bidmachine.ViewAdObject;
import io.bidmachine.models.AuctionResult;
import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
public abstract class AdView<SelfType extends AdView<SelfType, AdType, AdRequestType, AdObjectType, ExternalAdListenerType>, AdType extends ViewAd<AdType, AdRequestType, AdObjectType, ?, AdListener<AdType>>, AdRequestType extends AdRequest<AdRequestType, ?, ?>, AdObjectType extends ViewAdObject<AdRequestType, ?, ?>, ExternalAdListenerType extends AdListener<SelfType>> extends FrameLayout implements IAd<SelfType, AdRequestType> {
    private final AdListener<AdType> adListener;
    private AdType currentAd;
    private ExternalAdListenerType externalListener;
    private boolean isAttachedToWindow;
    private boolean isShowPending;
    private AdType pendingAd;
    private RendererConfiguration rendererConfiguration;

    protected abstract AdType createAd(Context context);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.bidmachine.IAd
    public /* bridge */ /* synthetic */ IAd load(AdRequest request) {
        return load((AdView<SelfType, AdType, AdRequestType, AdObjectType, ExternalAdListenerType>) request);
    }

    public AdView(Context context) {
        this(context, null);
    }

    public AdView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowPending = false;
        this.isAttachedToWindow = false;
        this.adListener = (AdListener<AdType>) new AdListener<AdType>() { // from class: io.bidmachine.AdView.1
            @Override // io.bidmachine.AdListener
            public void onAdLoaded(AdType ad) {
                if (AdView.this.externalListener != null) {
                    AdView.this.externalListener.onAdLoaded(AdView.this);
                }
                AdView.this.performShow();
            }

            @Override // io.bidmachine.AdListener
            public void onAdLoadFailed(AdType ad, BMError error) {
                if (AdView.this.externalListener != null) {
                    AdView.this.externalListener.onAdLoadFailed(AdView.this, error);
                }
            }

            @Override // io.bidmachine.AdListener
            public void onAdImpression(AdType ad) {
                if (AdView.this.externalListener != null) {
                    AdView.this.externalListener.onAdImpression(AdView.this);
                }
            }

            @Override // io.bidmachine.AdListener
            public void onAdShowFailed(AdType ad, BMError error) {
                if (AdView.this.externalListener != null) {
                    AdView.this.externalListener.onAdShowFailed(AdView.this, error);
                }
            }

            @Override // io.bidmachine.AdListener
            public void onAdClicked(AdType ad) {
                if (AdView.this.externalListener != null) {
                    AdView.this.externalListener.onAdClicked(AdView.this);
                }
            }

            @Override // io.bidmachine.AdListener
            public void onAdExpired(AdType ad) {
                if (AdView.this.externalListener != null) {
                    AdView.this.externalListener.onAdExpired(AdView.this);
                }
            }
        };
    }

    public SelfType setListener(ExternalAdListenerType listener) {
        this.externalListener = listener;
        return this;
    }

    @Override // io.bidmachine.IAd
    public SelfType load(AdRequestType request) {
        this.isShowPending = true;
        AdType adtype = this.pendingAd;
        if (adtype != null) {
            adtype.destroy();
        }
        AdType createAd = createAd(getContext());
        this.pendingAd = createAd;
        createAd.setListener(this.adListener);
        this.pendingAd.load(request);
        return this;
    }

    @Override // io.bidmachine.IAd
    public SelfType setRendererConfiguration(RendererConfiguration rendererConfiguration) {
        this.rendererConfiguration = rendererConfiguration;
        return this;
    }

    @Override // io.bidmachine.IAd
    public void destroy() {
        AdType adtype = this.currentAd;
        if (adtype != null) {
            adtype.destroy();
            this.currentAd = null;
        }
        AdType adtype2 = this.pendingAd;
        if (adtype2 != null) {
            adtype2.destroy();
            this.pendingAd = null;
        }
    }

    @Override // io.bidmachine.IAd
    public boolean isLoaded() {
        return isLoaded(this.currentAd) || isLoaded(this.pendingAd);
    }

    private boolean isLoaded(AdType ad) {
        return ad != null && ad.isLoaded();
    }

    @Override // io.bidmachine.IAd
    public boolean isLoading() {
        AdType adtype = this.pendingAd;
        return adtype != null && adtype.isLoading();
    }

    @Override // io.bidmachine.IAd
    public boolean isExpired() {
        AdType adtype = this.pendingAd;
        if (adtype != null) {
            return adtype.isExpired();
        }
        AdType adtype2 = this.currentAd;
        return adtype2 != null && adtype2.isExpired();
    }

    @Override // io.bidmachine.IAd
    public boolean isDestroyed() {
        AdType adtype = this.pendingAd;
        if (adtype != null) {
            return adtype.isDestroyed();
        }
        AdType adtype2 = this.currentAd;
        return adtype2 != null && adtype2.isDestroyed();
    }

    @Override // io.bidmachine.IAd
    public AuctionResult getAuctionResult() {
        AdType adtype = this.currentAd;
        if (adtype != null) {
            return adtype.getAuctionResult();
        }
        AdType adtype2 = this.pendingAd;
        if (adtype2 != null) {
            return adtype2.getAuctionResult();
        }
        return null;
    }

    protected AdType getCurrentAd() {
        return this.currentAd;
    }

    protected AdType getPendingAd() {
        return this.pendingAd;
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (getVisibility() == 0) {
            performShow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isAttachedToWindow = true;
        performShow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        this.isShowPending = true;
        performHide();
    }

    @Override // io.bidmachine.IAd
    public boolean canShow() {
        return canShow(this.currentAd) || canShow(this.pendingAd);
    }

    private boolean canShow(AdType ad) {
        return ad != null && ad.canShow();
    }

    private boolean canPerformShow() {
        return this.isAttachedToWindow && this.isShowPending && getVisibility() != 8;
    }

    private void prepareDisplayRequest() {
        AdType adtype;
        if (this.currentAd == null || ((adtype = this.pendingAd) != null && adtype.isLoaded())) {
            AdType adtype2 = this.currentAd;
            if (adtype2 != null) {
                adtype2.destroy();
            }
            this.currentAd = this.pendingAd;
            this.pendingAd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performShow() {
        if (canPerformShow()) {
            prepareDisplayRequest();
            AdType adtype = this.currentAd;
            if (adtype != null) {
                adtype.setRendererConfiguration(this.rendererConfiguration);
                this.currentAd.show(this);
                this.isShowPending = false;
            }
        }
    }

    private void performHide() {
        AdType adtype = this.currentAd;
        if (adtype != null) {
            adtype.hide();
        }
    }
}
