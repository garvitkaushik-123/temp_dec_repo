package io.bidmachine;

import android.content.Context;
import android.view.ViewGroup;
import io.bidmachine.AdListener;
import io.bidmachine.AdRequest;
import io.bidmachine.ViewAd;
import io.bidmachine.ViewAdObject;
import io.bidmachine.core.Logger;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.unified.UnifiedAdRequestParams;
import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
public abstract class ViewAd<AdType extends ViewAd<AdType, AdRequestType, AdObjectType, UnifiedAdRequestParamsType, AdListenerType>, AdRequestType extends AdRequest<AdRequestType, ?, UnifiedAdRequestParamsType>, AdObjectType extends ViewAdObject<AdRequestType, ?, UnifiedAdRequestParamsType>, UnifiedAdRequestParamsType extends UnifiedAdRequestParams, AdListenerType extends AdListener<AdType>> extends BidMachineAd<AdType, AdRequestType, AdObjectType, AdObjectParams, UnifiedAdRequestParamsType, AdListenerType> {
    @Override // io.bidmachine.BidMachineAd
    public boolean isDuplicateShowDisabled() {
        return false;
    }

    protected ViewAd(Context context, AdsType adsType) {
        super(context, adsType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void show(ViewGroup container) {
        ViewAdObject viewAdObject = (ViewAdObject) prepareShow();
        if (viewAdObject == null) {
            return;
        }
        try {
            viewAdObject.show(container, this.rendererConfiguration);
        } catch (Throwable th) {
            Logger.w(th);
            processShowFail(BMError.throwable("Exception showing view ad object", th));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void hide() {
        ViewAdObject viewAdObject = (ViewAdObject) getLoadedAdObject();
        if (viewAdObject == null) {
            return;
        }
        viewAdObject.hide();
    }
}
