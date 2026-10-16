package io.bidmachine.nativead;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import io.bidmachine.AdObjectImpl;
import io.bidmachine.AdProcessCallback;
import io.bidmachine.ContextProvider;
import io.bidmachine.ImageData;
import io.bidmachine.ImageDataImpl;
import io.bidmachine.LabelData;
import io.bidmachine.MediaAssetType;
import io.bidmachine.PrivacySheetData;
import io.bidmachine.RendererConfiguration;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.iab.vast.VastRequest;
import io.bidmachine.internal.utils.visibility.VisibilityTrackerHolder;
import io.bidmachine.internal.utils.visibility.VisibilityTrackerListener;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.nativead.utils.ImageHelper;
import io.bidmachine.nativead.view.MediaView;
import io.bidmachine.nativead.view.NativeMediaView;
import io.bidmachine.rendering.utils.UrlHandler;
import io.bidmachine.rendering.view.WatermarkView;
import io.bidmachine.unified.UnifiedNativeAd;
import io.bidmachine.unified.UnifiedNativeAdCallback;
import io.bidmachine.unified.UnifiedNativeAdRequestParams;
import io.bidmachine.util.SafeExecutable;
import io.bidmachine.util.ViewUtils;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.ViewHelper;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes6.dex */
public final class NativeAdObject extends AdObjectImpl<NativeRequest, AdObjectParams, UnifiedNativeAd, UnifiedNativeAdCallback, UnifiedNativeAdRequestParams> implements NativeData, NativeMediaPrivateData, NativeContainer, NativeInteractor, View.OnClickListener {
    static final float DEFAULT_RATING = -1.0f;
    private static final int ICON_VIEW_ID = 100;
    private static final String INSTALL = "Install";
    private static final int MEDIA_VIEW_ID = 200;
    private static final WeakHashMap<ViewGroup, WeakHashMap<View, View.OnClickListener>> clickStorage = new WeakHashMap<>(3);
    private ViewGroup container;
    private ImageDataImpl iconImageData;
    private boolean isImpressionTracked;
    private ImageDataImpl mainImageData;
    private MediaView mediaView;
    private NativeNetworkAdapter nativeNetworkAdapter;
    private ProgressDialog progressDialog;
    private Handler progressDialogCanceller;
    private Runnable progressRunnable;
    private View providerView;
    private VastRequest vastRequest;
    private Uri videoUri;
    private boolean viewRegistered;
    private final VisibilityTrackerHolder visibilityTrackerHolder;
    private AutoLayoutListener watermarkAutoLayoutListener;
    private View watermarkView;

    @Override // io.bidmachine.nativead.NativeInteractor
    public void dispatchVideoPlayFinished() {
    }

    NativeAdObject(ContextProvider contextProvider, AdProcessCallback processCallback, NativeRequest adRequest, AdObjectParams adObjectParams, UnifiedNativeAd unifiedAd) {
        super(contextProvider, processCallback, adRequest, adObjectParams, unifiedAd);
        this.visibilityTrackerHolder = new VisibilityTrackerHolder();
    }

    public void setNativeNetworkAdapter(NativeNetworkAdapter nativeNetworkAdapter) {
        this.nativeNetworkAdapter = nativeNetworkAdapter;
        if (nativeNetworkAdapter != null) {
            this.iconImageData = new ImageDataImpl(nativeNetworkAdapter.getIcon());
            this.mainImageData = new ImageDataImpl(nativeNetworkAdapter.getMainImage());
        }
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public String getTitle() {
        NativeNetworkAdapter nativeNetworkAdapter = this.nativeNetworkAdapter;
        if (nativeNetworkAdapter != null) {
            return nativeNetworkAdapter.getTitle();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public String getDescription() {
        NativeNetworkAdapter nativeNetworkAdapter = this.nativeNetworkAdapter;
        if (nativeNetworkAdapter != null) {
            return nativeNetworkAdapter.getDescription();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public String getCallToAction() {
        NativeNetworkAdapter nativeNetworkAdapter = this.nativeNetworkAdapter;
        String callToAction = nativeNetworkAdapter != null ? nativeNetworkAdapter.getCallToAction() : null;
        return TextUtils.isEmpty(callToAction) ? "Install" : callToAction;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public float getRating() {
        NativeNetworkAdapter nativeNetworkAdapter = this.nativeNetworkAdapter;
        if (nativeNetworkAdapter != null) {
            return nativeNetworkAdapter.getRating();
        }
        return -1.0f;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public ImageData getIcon() {
        return this.iconImageData;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public ImageData getMainImage() {
        return this.mainImageData;
    }

    @Override // io.bidmachine.nativead.NativeData
    public String getClickUrl() {
        NativeNetworkAdapter nativeNetworkAdapter = this.nativeNetworkAdapter;
        if (nativeNetworkAdapter != null) {
            return nativeNetworkAdapter.getClickUrl();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativeData
    public String getVideoUrl() {
        NativeNetworkAdapter nativeNetworkAdapter = this.nativeNetworkAdapter;
        if (nativeNetworkAdapter != null) {
            return nativeNetworkAdapter.getVideoUrl();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativeData
    public String getVideoAdm() {
        NativeNetworkAdapter nativeNetworkAdapter = this.nativeNetworkAdapter;
        if (nativeNetworkAdapter != null) {
            return nativeNetworkAdapter.getVideoAdm();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativeData
    public LabelData getAdLabelData() {
        NativeNetworkAdapter nativeNetworkAdapter = this.nativeNetworkAdapter;
        if (nativeNetworkAdapter != null) {
            return nativeNetworkAdapter.getAdLabelData();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativeData
    public PrivacySheetData getPrivacySheetData() {
        NativeNetworkAdapter nativeNetworkAdapter = this.nativeNetworkAdapter;
        if (nativeNetworkAdapter != null) {
            return nativeNetworkAdapter.getPrivacySheetData();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativeMediaPublicData
    public Drawable getIconDrawable() {
        ImageDataImpl imageDataImpl = this.iconImageData;
        if (imageDataImpl != null) {
            return imageDataImpl.getImage();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativeMediaPrivateData
    public void setIconBitmap(Bitmap iconBitmap) {
        ImageDataImpl imageDataImpl = this.iconImageData;
        if (imageDataImpl != null) {
            imageDataImpl.setImage(new BitmapDrawable(getApplicationContext().getResources(), iconBitmap));
        }
    }

    @Override // io.bidmachine.nativead.NativeMediaPublicData
    public Uri getIconUri() {
        ImageDataImpl imageDataImpl = this.iconImageData;
        if (imageDataImpl != null) {
            return imageDataImpl.getLocalUri();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativeMediaPrivateData
    public void setIconUri(Uri iconUri) {
        ImageDataImpl imageDataImpl = this.iconImageData;
        if (imageDataImpl != null) {
            imageDataImpl.setLocalUri(iconUri);
        }
    }

    @Override // io.bidmachine.nativead.NativeMediaPublicData
    public Drawable getImageDrawable() {
        ImageDataImpl imageDataImpl = this.mainImageData;
        if (imageDataImpl != null) {
            return imageDataImpl.getImage();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativeMediaPrivateData
    public void setImageBitmap(Bitmap imageBitmap) {
        ImageDataImpl imageDataImpl = this.mainImageData;
        if (imageDataImpl != null) {
            imageDataImpl.setImage(new BitmapDrawable(getApplicationContext().getResources(), imageBitmap));
        }
    }

    @Override // io.bidmachine.nativead.NativeMediaPublicData
    public Uri getImageUri() {
        ImageDataImpl imageDataImpl = this.mainImageData;
        if (imageDataImpl != null) {
            return imageDataImpl.getLocalUri();
        }
        return null;
    }

    @Override // io.bidmachine.nativead.NativeMediaPrivateData
    public void setImageUri(Uri imageUri) {
        ImageDataImpl imageDataImpl = this.mainImageData;
        if (imageDataImpl != null) {
            imageDataImpl.setLocalUri(imageUri);
        }
    }

    @Override // io.bidmachine.nativead.NativeMediaPrivateData
    public void setVideoUri(Uri videoUri) {
        this.videoUri = videoUri;
    }

    @Override // io.bidmachine.nativead.NativeMediaPublicData
    public Uri getVideoUri() {
        return this.videoUri;
    }

    @Override // io.bidmachine.nativead.NativeMediaPrivateData
    public void setVastRequest(VastRequest vastRequest) {
        this.vastRequest = vastRequest;
    }

    @Override // io.bidmachine.nativead.NativeMediaPrivateData
    public VastRequest getVastRequest() {
        return this.vastRequest;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public boolean hasVideo() {
        if (this.videoUri != null) {
            return true;
        }
        NativeNetworkAdapter nativeNetworkAdapter = this.nativeNetworkAdapter;
        return nativeNetworkAdapter != null && nativeNetworkAdapter.hasVideo();
    }

    @Override // io.bidmachine.models.AdObject
    public UnifiedNativeAdCallback createUnifiedCallback(AdProcessCallback processCallback) {
        return new UnifiedNativeAdCallbackImpl(processCallback);
    }

    @Override // io.bidmachine.nativead.NativeContainer
    public View getProviderView(Context context) {
        NativeNetworkAdapter nativeNetworkAdapter;
        if (this.providerView == null && (nativeNetworkAdapter = this.nativeNetworkAdapter) != null) {
            this.providerView = nativeNetworkAdapter.createProviderView(context);
        }
        return this.providerView;
    }

    @Override // io.bidmachine.nativead.NativeContainer
    public void registerView(ViewGroup nativeAdView, View imageView, NativeMediaView nativeMediaView, Set<View> clickableViews) {
        registerView(nativeAdView, imageView, nativeMediaView, clickableViews, null);
    }

    void registerView(ViewGroup nativeAdView, View imageView, NativeMediaView nativeMediaView, Set<View> clickableViews, RendererConfiguration rendererConfiguration) {
        try {
            if (!isNativeAdViewValid(nativeAdView, imageView, nativeMediaView)) {
                getProcessCallback().processShowFail(BMError.internal("Native ad views are invalid"));
                return;
            }
            configureClickableView(nativeAdView, clickableViews);
            ImageView configureIconView = configureIconView(imageView);
            configureMediaView(nativeMediaView);
            this.container = nativeAdView;
            if (!this.isImpressionTracked) {
                getProcessCallback().processStartVisibilityTracker();
                this.visibilityTrackerHolder.startTracking(nativeAdView, getParams().getVisibilityParams(), new VisibilityTrackerListener() { // from class: io.bidmachine.nativead.NativeAdObject.1
                    @Override // io.bidmachine.internal.utils.visibility.VisibilityTrackerListener
                    public boolean onViewShown() {
                        return NativeAdObject.this.dispatchShown();
                    }

                    @Override // io.bidmachine.internal.utils.visibility.VisibilityTrackerListener
                    public void onViewTrackingFinished() {
                        NativeAdObject.this.isImpressionTracked = true;
                        NativeAdObject.this.dispatchImpression();
                    }
                });
                dispatchFillAd();
            }
            MediaView mediaView = this.mediaView;
            if (mediaView != null) {
                mediaView.onViewAppearOnScreen();
                this.mediaView.startVideoVisibilityCheckerTimer();
            }
            NativeNetworkAdapter nativeNetworkAdapter = this.nativeNetworkAdapter;
            if (nativeNetworkAdapter != null) {
                nativeNetworkAdapter.registerNative(nativeAdView, configureIconView, nativeMediaView, clickableViews);
            }
            configureWatermark(nativeAdView, rendererConfiguration);
            View view = this.watermarkView;
            if (view != null) {
                view.bringToFront();
            }
            this.viewRegistered = true;
        } catch (Throwable th) {
            Logger.w(th);
            unregisterView();
            getProcessCallback().processShowFail(BMError.throwable("Exception registering view for native ad object", th));
        }
    }

    @Override // io.bidmachine.nativead.NativeContainer
    public void unregisterView() {
        try {
            this.visibilityTrackerHolder.stopTracking();
            ViewGroup viewGroup = this.container;
            if (viewGroup != null) {
                removeWatermarkAutoLayout(viewGroup);
                deConfigureClickableView(this.container);
                this.container = null;
            }
            MediaView mediaView = this.mediaView;
            if (mediaView != null) {
                mediaView.stopVideoVisibilityCheckerTimer();
                this.mediaView.release();
                this.mediaView = null;
            }
            NativeNetworkAdapter nativeNetworkAdapter = this.nativeNetworkAdapter;
            if (nativeNetworkAdapter != null) {
                nativeNetworkAdapter.unregisterNative();
            }
            removeWatermark();
            this.viewRegistered = false;
        } catch (Throwable th) {
            Logger.w(th);
        }
    }

    @Override // io.bidmachine.AdObjectImpl, io.bidmachine.models.AdObject
    public void onDestroy() {
        try {
            super.onDestroy();
            unregisterView();
            ImageDataImpl imageDataImpl = this.iconImageData;
            if (imageDataImpl != null) {
                imageDataImpl.destroy();
                this.iconImageData = null;
            }
            ImageDataImpl imageDataImpl2 = this.mainImageData;
            if (imageDataImpl2 != null) {
                imageDataImpl2.destroy();
                this.mainImageData = null;
            }
            Uri uri = this.videoUri;
            if (uri != null && uri.getPath() != null) {
                File file = new File(this.videoUri.getPath());
                if (file.exists()) {
                    file.delete();
                }
                this.videoUri = null;
            }
            NativeNetworkAdapter nativeNetworkAdapter = this.nativeNetworkAdapter;
            if (nativeNetworkAdapter != null) {
                nativeNetworkAdapter.destroy();
            }
        } catch (Throwable th) {
            Logger.w(th);
        }
    }

    boolean isNativeAdViewValid(ViewGroup nativeAdView, View imageView, NativeMediaView nativeMediaView) {
        if (nativeAdView == null) {
            Logger.d("NativeAdView cannot be null. NativeAd is NOT registered");
            return false;
        }
        if (imageView == null && nativeMediaView == null) {
            Logger.d("ImageView or NativeMediaView cannot be null. NativeAd is NOT registered");
            return false;
        }
        if (imageView != null && !ViewHelper.belongTo(nativeAdView, imageView)) {
            Logger.d("ImageView should belong to NativeAdView");
        }
        if (nativeMediaView == null || ViewHelper.belongTo(nativeAdView, nativeMediaView)) {
            return true;
        }
        Logger.d("NativeMediaView should belong to NativeAdView");
        return true;
    }

    private void configureClickableView(ViewGroup nativeAdView, Set<View> clickableViews) {
        deConfigureClickableView(nativeAdView);
        if (clickableViews == null || clickableViews.isEmpty()) {
            return;
        }
        WeakHashMap<View, View.OnClickListener> weakHashMap = new WeakHashMap<>();
        clickStorage.put(nativeAdView, weakHashMap);
        for (View view : clickableViews) {
            if (view != null) {
                view.setOnClickListener(this);
                weakHashMap.put(view, this);
            }
        }
    }

    private void deConfigureClickableView(ViewGroup nativeAdView) {
        WeakHashMap<View, View.OnClickListener> weakHashMap = clickStorage.get(nativeAdView);
        if (weakHashMap != null) {
            for (Map.Entry<View, View.OnClickListener> entry : weakHashMap.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    entry.getKey().setOnClickListener(null);
                }
            }
            clickStorage.remove(nativeAdView);
        }
    }

    private ImageView configureIconView(View view) {
        ImageView imageView;
        if (view instanceof ImageView) {
            imageView = (ImageView) view;
        } else if (view instanceof ViewGroup) {
            ImageView imageView2 = new ImageView(view.getContext());
            imageView2.setId(100);
            imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ViewGroup viewGroup = (ViewGroup) view;
            viewGroup.removeAllViews();
            viewGroup.addView(imageView2, new ViewGroup.LayoutParams(-1, -1));
            imageView = imageView2;
        } else {
            imageView = null;
        }
        if (imageView != null && this.iconImageData != null) {
            ImageHelper.fillImageView(imageView.getContext(), imageView, this.iconImageData.getLocalUri(), this.iconImageData.getImage());
        }
        return imageView;
    }

    private void configureMediaView(NativeMediaView nativeMediaView) {
        if (nativeMediaView == null) {
            return;
        }
        View createMediaView = createMediaView(nativeMediaView.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        ViewUtils.addSingleViewSafely(nativeMediaView, createMediaView, layoutParams);
    }

    private View createMediaView(Context context) {
        View createCustomMediaView;
        NativeNetworkAdapter nativeNetworkAdapter = this.nativeNetworkAdapter;
        if (nativeNetworkAdapter != null && (createCustomMediaView = nativeNetworkAdapter.createCustomMediaView(context)) != null) {
            return createCustomMediaView;
        }
        MediaView mediaView = new MediaView(context);
        mediaView.setId(200);
        NativeAdRequestParameters adRequestParameters = getAdRequest().getAdRequestParameters();
        if (adRequestParameters.containsAssetType(MediaAssetType.Image) || adRequestParameters.containsAssetType(MediaAssetType.Video)) {
            mediaView.setNativeAdObject(this);
        }
        this.mediaView = mediaView;
        return mediaView;
    }

    private void configureWatermark(ViewGroup container, RendererConfiguration rendererConfiguration) {
        Drawable watermarkDrawable;
        removeWatermarkAutoLayout(container);
        removeWatermark();
        if (rendererConfiguration == null || (watermarkDrawable = rendererConfiguration.getWatermarkDrawable(getApplicationContext())) == null) {
            return;
        }
        WatermarkView watermarkView = new WatermarkView(container.getContext().getApplicationContext());
        watermarkView.setLayoutParams(ViewUtils.createMatchParentParams());
        watermarkView.setWatermark(watermarkDrawable);
        this.watermarkView = watermarkView;
        AutoLayoutListener autoLayoutListener = new AutoLayoutListener(watermarkView);
        this.watermarkAutoLayoutListener = autoLayoutListener;
        container.addOnLayoutChangeListener(autoLayoutListener);
        container.addView(watermarkView);
    }

    private void removeWatermarkAutoLayout(ViewGroup container) {
        AutoLayoutListener autoLayoutListener = this.watermarkAutoLayoutListener;
        if (autoLayoutListener != null) {
            container.removeOnLayoutChangeListener(autoLayoutListener);
            this.watermarkAutoLayoutListener = null;
        }
    }

    private void removeWatermark() {
        View view = this.watermarkView;
        if (view != null) {
            ViewUtils.removeFromParent(view);
            this.watermarkView = null;
        }
    }

    private void showProgressDialog(Activity activity) {
        if (this.container != null && mayShowProgressDialog() && Utils.canAddWindowToActivity(activity)) {
            this.container.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: io.bidmachine.nativead.NativeAdObject.2
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View v) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View v) {
                    v.removeOnAttachStateChangeListener(this);
                    NativeAdObject.this.hideProgressDialog();
                }
            });
            ProgressDialog show = ProgressDialog.show(activity, "", "Loading...");
            this.progressDialog = show;
            show.setProgressStyle(0);
            this.progressDialog.setCancelable(false);
            this.progressRunnable = new Runnable() { // from class: io.bidmachine.nativead.NativeAdObject.3
                @Override // java.lang.Runnable
                public void run() {
                    NativeAdObject.this.hideProgressDialog();
                }
            };
            Handler handler = new Handler(Looper.getMainLooper());
            this.progressDialogCanceller = handler;
            handler.postDelayed(this.progressRunnable, 5000L);
        }
    }

    private boolean mayShowProgressDialog() {
        ProgressDialog progressDialog = this.progressDialog;
        return progressDialog == null || !progressDialog.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgressDialog() {
        Handler handler;
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.progressDialog.dismiss();
            this.progressDialog = null;
        }
        Runnable runnable = this.progressRunnable;
        if (runnable == null || (handler = this.progressDialogCanceller) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.progressDialogCanceller = null;
        this.progressRunnable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAsset(Context context, NativeData nativeData) {
        new AssetLoader(getAdRequest().getAdRequestParameters(), getProcessCallback(), nativeData, this).downloadNativeAdsImages(context);
    }

    @Override // io.bidmachine.nativead.NativeContainer
    public boolean isViewRegistered() {
        return this.viewRegistered;
    }

    @Override // io.bidmachine.nativead.NativeInteractor
    public void dispatchFillAd() {
        getProcessCallback().processFillAd();
    }

    @Override // io.bidmachine.nativead.NativeInteractor
    public boolean dispatchShown() {
        return getProcessCallback().processVisibilityTrackerShown();
    }

    @Override // io.bidmachine.nativead.NativeInteractor
    public void dispatchImpression() {
        getProcessCallback().processVisibilityTrackerImpression();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dispatchClick();
    }

    @Override // io.bidmachine.AdObjectImpl, io.bidmachine.models.AdObject
    public void onClicked() {
        super.onClicked();
        String clickUrl = getClickUrl();
        if (TextUtils.isEmpty(clickUrl)) {
            return;
        }
        showProgressDialog(getActivity());
        UrlHandler.openUrl(getApplicationContext(), clickUrl, new SafeExecutable() { // from class: io.bidmachine.nativead.NativeAdObject$$ExternalSyntheticLambda0
            @Override // io.bidmachine.util.SafeExecutable
            public final void onExecute(Object obj) {
                NativeAdObject.this.m9906lambda$onClicked$0$iobidmachinenativeadNativeAdObject((Boolean) obj);
            }
        });
    }

    /* renamed from: lambda$onClicked$0$io-bidmachine-nativead-NativeAdObject, reason: not valid java name */
    /* synthetic */ void m9906lambda$onClicked$0$iobidmachinenativeadNativeAdObject(Boolean bool) throws Throwable {
        hideProgressDialog();
    }

    @Override // io.bidmachine.nativead.NativeInteractor
    public void dispatchClick() {
        getProcessCallback().processClicked();
    }

    private static class AutoLayoutListener implements View.OnLayoutChangeListener {
        private int prevContainerHeight;
        private int prevContainerWidth;
        private final WeakReference<View> weakChildView;

        public AutoLayoutListener(View childView) {
            this.weakChildView = new WeakReference<>(childView);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View container, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            View view;
            if (container == null) {
                return;
            }
            int i = right - left;
            int i2 = bottom - top;
            if ((i == this.prevContainerWidth && i2 == this.prevContainerHeight) || (view = this.weakChildView.get()) == null) {
                return;
            }
            this.prevContainerWidth = i;
            this.prevContainerHeight = i2;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
                return;
            }
            layoutParams.width = i;
            layoutParams.height = i2;
            view.requestLayout();
        }
    }

    private final class UnifiedNativeAdCallbackImpl extends AdObjectImpl.BaseUnifiedAdCallback implements UnifiedNativeAdCallback {
        UnifiedNativeAdCallbackImpl(AdProcessCallback processCallback) {
            super(processCallback);
        }

        @Override // io.bidmachine.unified.UnifiedNativeAdCallback
        public void onAdLoaded(NativeNetworkAdapter nativeNetworkAdapter) {
            try {
                NativeAdObject.this.setNativeNetworkAdapter(nativeNetworkAdapter);
                if (NativeAdObject.this.getAdRequest().getAdRequestParameters().isValidateAssets() && !nativeNetworkAdapter.isValid()) {
                    this.processCallback.processLoadFail(BMError.incorrectContent("Native ad does not contain all required assets"));
                } else if (nativeNetworkAdapter.isNetworkControlLoadingAssets()) {
                    this.processCallback.processLoadSuccess();
                } else {
                    NativeAdObject nativeAdObject = NativeAdObject.this;
                    nativeAdObject.loadAsset(nativeAdObject.getApplicationContext(), nativeNetworkAdapter);
                }
            } catch (Exception e) {
                Logger.w(e);
                this.processCallback.processLoadFail(BMError.throwable("Exception loading native ad assets", e));
            }
        }
    }
}
