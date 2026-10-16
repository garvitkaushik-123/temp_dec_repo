package com.ironsource.unity.androidbridge;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.LevelPlayAdSize;
import com.unity3d.mediation.banner.LevelPlayBannerAdView;
import com.unity3d.mediation.banner.LevelPlayBannerAdViewListener;
import com.unity3d.player.UnityPlayer;

/* loaded from: classes6.dex */
public class BannerAd {
    LevelPlayBannerAdView mBannerAdView;
    int mBannerAdViewVisibilityState = 4;
    Activity mActivity = UnityPlayer.currentActivity;

    public BannerAd(String str, Config config, IUnityBannerAdListener iUnityBannerAdListener) {
        this.mBannerAdView = new LevelPlayBannerAdView(this.mActivity, str, config.config);
        setup(config.description, config.x, config.y, config.displayOnLoad, config.respectSafeArea, iUnityBannerAdListener);
    }

    public BannerAd(String str, LevelPlayAdSize levelPlayAdSize, String str2, float f, float f2, String str3, boolean z, boolean z2, IUnityBannerAdListener iUnityBannerAdListener) {
        LevelPlayBannerAdView levelPlayBannerAdView = new LevelPlayBannerAdView(this.mActivity, str);
        this.mBannerAdView = levelPlayBannerAdView;
        if (levelPlayAdSize != null) {
            levelPlayBannerAdView.setAdSize(levelPlayAdSize);
        }
        if (str3 != null && str3 != "") {
            this.mBannerAdView.setPlacementName(str3);
        }
        setup(str2, f, f2, z, z2, iUnityBannerAdListener);
    }

    private void setup(final String str, final float f, final float f2, boolean z, boolean z2, final IUnityBannerAdListener iUnityBannerAdListener) {
        this.mBannerAdView.setBackgroundColor(0);
        if (z) {
            this.mBannerAdView.setVisibility(0);
            this.mBannerAdViewVisibilityState = 0;
        } else {
            this.mBannerAdView.setVisibility(8);
            this.mBannerAdViewVisibilityState = 8;
        }
        if (z2) {
            this.mBannerAdView.setFitsSystemWindows(true);
            this.mBannerAdView.setSystemUiVisibility(1280);
            this.mBannerAdView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.ironsource.unity.androidbridge.BannerAd$$ExternalSyntheticLambda0
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    WindowInsets lambda$setup$0;
                    lambda$setup$0 = BannerAd.this.lambda$setup$0(str, f, f2, view, windowInsets);
                    return lambda$setup$0;
                }
            });
        }
        setPosition(str, f, f2, z2);
        this.mBannerAdView.setBannerListener(new LevelPlayBannerAdViewListener() { // from class: com.ironsource.unity.androidbridge.BannerAd.1
            @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
            public void onAdLoaded(LevelPlayAdInfo levelPlayAdInfo) {
                IUnityBannerAdListener iUnityBannerAdListener2 = iUnityBannerAdListener;
                if (iUnityBannerAdListener2 != null) {
                    iUnityBannerAdListener2.onAdLoaded(LevelPlayUtils.adInfoToString(levelPlayAdInfo));
                }
            }

            @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
            public void onAdLoadFailed(LevelPlayAdError levelPlayAdError) {
                IUnityBannerAdListener iUnityBannerAdListener2 = iUnityBannerAdListener;
                if (iUnityBannerAdListener2 != null) {
                    iUnityBannerAdListener2.onAdLoadFailed(LevelPlayUtils.adErrorToString(levelPlayAdError));
                }
            }

            @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
            public void onAdDisplayed(LevelPlayAdInfo levelPlayAdInfo) {
                IUnityBannerAdListener iUnityBannerAdListener2 = iUnityBannerAdListener;
                if (iUnityBannerAdListener2 != null) {
                    iUnityBannerAdListener2.onAdDisplayed(LevelPlayUtils.adInfoToString(levelPlayAdInfo));
                }
            }

            @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
            public void onAdDisplayFailed(LevelPlayAdInfo levelPlayAdInfo, LevelPlayAdError levelPlayAdError) {
                IUnityBannerAdListener iUnityBannerAdListener2 = iUnityBannerAdListener;
                if (iUnityBannerAdListener2 != null) {
                    iUnityBannerAdListener2.onAdDisplayFailed(LevelPlayUtils.adInfoToString(levelPlayAdInfo), LevelPlayUtils.adErrorToString(levelPlayAdError));
                }
            }

            @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
            public void onAdClicked(LevelPlayAdInfo levelPlayAdInfo) {
                IUnityBannerAdListener iUnityBannerAdListener2 = iUnityBannerAdListener;
                if (iUnityBannerAdListener2 != null) {
                    iUnityBannerAdListener2.onAdClicked(LevelPlayUtils.adInfoToString(levelPlayAdInfo));
                }
            }

            @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
            public void onAdExpanded(LevelPlayAdInfo levelPlayAdInfo) {
                IUnityBannerAdListener iUnityBannerAdListener2 = iUnityBannerAdListener;
                if (iUnityBannerAdListener2 != null) {
                    iUnityBannerAdListener2.onAdExpanded(LevelPlayUtils.adInfoToString(levelPlayAdInfo));
                }
            }

            @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
            public void onAdCollapsed(LevelPlayAdInfo levelPlayAdInfo) {
                IUnityBannerAdListener iUnityBannerAdListener2 = iUnityBannerAdListener;
                if (iUnityBannerAdListener2 != null) {
                    iUnityBannerAdListener2.onAdCollapsed(LevelPlayUtils.adInfoToString(levelPlayAdInfo));
                }
            }

            @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
            public void onAdLeftApplication(LevelPlayAdInfo levelPlayAdInfo) {
                IUnityBannerAdListener iUnityBannerAdListener2 = iUnityBannerAdListener;
                if (iUnityBannerAdListener2 != null) {
                    iUnityBannerAdListener2.onAdLeftApplication(LevelPlayUtils.adInfoToString(levelPlayAdInfo));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsets lambda$setup$0(String str, float f, float f2, View view, WindowInsets windowInsets) {
        setPosition(str, f, f2, true);
        return windowInsets;
    }

    public void load() {
        this.mBannerAdView.loadAd();
    }

    public void destroy() {
        this.mBannerAdView.destroy();
    }

    public void showAd() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.ironsource.unity.androidbridge.BannerAd.2
            @Override // java.lang.Runnable
            public void run() {
                if (BannerAd.this.mBannerAdView != null) {
                    BannerAd.this.mBannerAdView.setVisibility(0);
                }
                BannerAd.this.mBannerAdViewVisibilityState = 0;
            }
        });
    }

    public void hideAd() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.ironsource.unity.androidbridge.BannerAd.3
            @Override // java.lang.Runnable
            public void run() {
                if (BannerAd.this.mBannerAdView != null) {
                    BannerAd.this.mBannerAdView.setVisibility(8);
                }
                BannerAd.this.mBannerAdViewVisibilityState = 8;
            }
        });
    }

    public void resumeAutoRefresh() {
        this.mBannerAdView.resumeAutoRefresh();
    }

    public void pauseAutoRefresh() {
        this.mBannerAdView.pauseAutoRefresh();
    }

    public String getAdId() {
        return this.mBannerAdView.getAdId();
    }

    /* renamed from: com.ironsource.unity.androidbridge.BannerAd$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ String val$position;
        final /* synthetic */ boolean val$respectSafeArea;
        final /* synthetic */ float val$x;
        final /* synthetic */ float val$y;

        AnonymousClass4(String str, float f, float f2, boolean z) {
            this.val$position = str;
            this.val$x = f;
            this.val$y = f2;
            this.val$respectSafeArea = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BannerAd.this.mBannerAdView.getParent() == null) {
                BannerAd.this.mActivity.addContentView(BannerAd.this.mBannerAdView, new FrameLayout.LayoutParams(-2, -2));
            }
            BannerAd.this.setPositionInternal(this.val$position, this.val$x, this.val$y, this.val$respectSafeArea);
            BannerAd.this.mBannerAdView.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.ironsource.unity.androidbridge.BannerAd.4.1
                @Override // android.view.ViewGroup.OnHierarchyChangeListener
                public void onChildViewRemoved(View view, View view2) {
                }

                @Override // android.view.ViewGroup.OnHierarchyChangeListener
                public void onChildViewAdded(View view, View view2) {
                    BannerAd.this.mActivity.runOnUiThread(new Runnable() { // from class: com.ironsource.unity.androidbridge.BannerAd.4.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (BannerAd.this.mBannerAdView != null) {
                                BannerAd.this.mBannerAdView.setVisibility(BannerAd.this.mBannerAdViewVisibilityState);
                            }
                            BannerAd.this.mBannerAdView.requestLayout();
                        }
                    });
                }
            });
        }
    }

    private void setPosition(String str, float f, float f2, boolean z) {
        this.mActivity.runOnUiThread(new AnonymousClass4(str, f, f2, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00a8, code lost:
    
        if (r9.equals(com.ironsource.unity.androidbridge.AndroidBridgeConstants.BANNER_POSITION_CENTERLEFT) == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setPositionInternal(String str, float f, float f2, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        WindowInsets rootWindowInsets;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mBannerAdView.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        char c = 0;
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = 0;
        layoutParams.bottomMargin = 0;
        if (!z || (rootWindowInsets = this.mActivity.getWindow().getDecorView().getRootWindowInsets()) == null) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            i2 = rootWindowInsets.getSystemWindowInsetLeft();
            i3 = rootWindowInsets.getSystemWindowInsetTop();
            i4 = rootWindowInsets.getSystemWindowInsetRight();
            i = rootWindowInsets.getSystemWindowInsetBottom();
        }
        str.hashCode();
        switch (str.hashCode()) {
            case -1139766756:
                break;
            case -967370073:
                if (str.equals(AndroidBridgeConstants.BANNER_POSITION_CENTERRIGHT)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -913702425:
                if (str.equals(AndroidBridgeConstants.BANNER_POSITION_TOPRIGHT)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 310672626:
                if (str.equals(AndroidBridgeConstants.BANNER_POSITION_BOTTOMLEFT)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 524532444:
                if (str.equals(AndroidBridgeConstants.BANNER_POSITION_TOPLEFT)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1046577809:
                if (str.equals(AndroidBridgeConstants.BANNER_POSITION_BOTTOMRIGHT)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1307084266:
                if (str.equals(AndroidBridgeConstants.BANNER_POSITION_TOPCENTER)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 2014820469:
                if (str.equals(AndroidBridgeConstants.BANNER_POSITION_CENTER)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 2029746065:
                if (str.equals(AndroidBridgeConstants.BANNER_POSITION_CUSTOM)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                layoutParams.gravity = 8388627;
                if (z) {
                    layoutParams.leftMargin = i2;
                    break;
                }
                break;
            case 1:
                layoutParams.gravity = 8388629;
                if (z) {
                    layoutParams.rightMargin = i4;
                    break;
                }
                break;
            case 2:
                layoutParams.gravity = 8388661;
                if (z) {
                    layoutParams.rightMargin = i4;
                    layoutParams.topMargin = i3;
                    break;
                }
                break;
            case 3:
                layoutParams.gravity = 8388691;
                if (z) {
                    layoutParams.leftMargin = i2;
                    layoutParams.bottomMargin = i;
                    break;
                }
                break;
            case 4:
                layoutParams.gravity = 8388659;
                if (z) {
                    layoutParams.leftMargin = i2;
                    layoutParams.topMargin = i3;
                    break;
                }
                break;
            case 5:
                layoutParams.gravity = 8388693;
                if (z) {
                    layoutParams.rightMargin = i4;
                    layoutParams.bottomMargin = i;
                    break;
                }
                break;
            case 6:
                layoutParams.gravity = 49;
                if (z) {
                    layoutParams.topMargin = i3;
                    break;
                }
                break;
            case 7:
                layoutParams.gravity = 17;
                break;
            case '\b':
                layoutParams.gravity = 8388659;
                int round = Math.round(f);
                int round2 = Math.round(f2);
                if (z) {
                    round += i2;
                    round2 += i3;
                }
                layoutParams.leftMargin = round;
                layoutParams.topMargin = round2;
                break;
            default:
                layoutParams.gravity = 81;
                if (z) {
                    layoutParams.bottomMargin = i;
                    break;
                }
                break;
        }
        this.mBannerAdView.setLayoutParams(layoutParams);
    }

    private float pixelsToDp(float f) {
        return f / Resources.getSystem().getDisplayMetrics().density;
    }

    public static class Config {
        final LevelPlayBannerAdView.Config config;
        final String description;
        final boolean displayOnLoad;
        final boolean respectSafeArea;
        final float x;
        final float y;

        private Config(LevelPlayBannerAdView.Config config, String str, float f, float f2, boolean z, boolean z2) {
            this.config = config;
            this.description = str;
            this.x = f;
            this.y = f2;
            this.displayOnLoad = z;
            this.respectSafeArea = z2;
        }

        public static class Builder {
            private LevelPlayBannerAdView.Config.Builder builder = new LevelPlayBannerAdView.Config.Builder();
            private String description;
            private boolean displayOnLoad;
            private boolean respectSafeArea;
            private float x;
            private float y;

            public void setBidFloor(double d) {
                this.builder.setBidFloor(d);
            }

            public void setSize(LevelPlayAdSize levelPlayAdSize) {
                this.builder.setAdSize(levelPlayAdSize);
            }

            public void setPlacementName(String str) {
                this.builder.setPlacementName(str);
            }

            public void setPosition(String str, float f, float f2) {
                this.description = str;
                this.x = f;
                this.y = f2;
            }

            public void setDisplayOnLoad(boolean z) {
                this.displayOnLoad = z;
            }

            public void setRespectSafeArea(boolean z) {
                this.respectSafeArea = z;
            }

            public Config build() {
                return new Config(this.builder.build(), this.description, this.x, this.y, this.displayOnLoad, this.respectSafeArea);
            }
        }
    }
}
