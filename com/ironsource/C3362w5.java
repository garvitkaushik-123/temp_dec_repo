package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.w5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3362w5 {

    /* renamed from: a, reason: collision with root package name */
    public static final C3362w5 f3920a = new C3362w5();

    private C3362w5() {
    }

    static /* synthetic */ IronSourceError a(C3362w5 c3362w5, Z7 z7, IronSourceError ironSourceError, int i, Object obj) {
        if ((i & 2) != 0) {
            ironSourceError = null;
        }
        return c3362w5.a(z7, ironSourceError);
    }

    public final IronSourceError b() {
        return a(this, Z7.ISErrorInitHttpRequestFailed, null, 2, null);
    }

    public final IronSourceError c() {
        return a(this, Z7.ISErrorInitInvalidResponse, null, 2, null);
    }

    public final IronSourceError d() {
        return a(this, Z7.ISErrorLoadADMDecryptionFailure, null, 2, null);
    }

    public final IronSourceError e() {
        return a(this, Z7.ISErrorLoadADMEmptyServerData, null, 2, null);
    }

    public final IronSourceError f() {
        return a(this, Z7.ISErrorLoadADMEmptyWaterfall, null, 2, null);
    }

    public final IronSourceError g() {
        return a(this, Z7.ISErrorLoadADMInvalidConfigurationForRequestedNetwork, null, 2, null);
    }

    public final IronSourceError h() {
        return a(this, Z7.ISErrorLoadADMInvalidJSON, null, 2, null);
    }

    public final IronSourceError i() {
        return a(this, Z7.ISErrorLoadADMNoAuctionID, null, 2, null);
    }

    public final IronSourceError j() {
        return a(this, Z7.ISErrorLoadADMNoConfigurationForRequestedNetwork, null, 2, null);
    }

    public final IronSourceError k() {
        return a(this, Z7.ISErrorLoadBannerNetworkViewIsNull, null, 2, null);
    }

    public final IronSourceError l() {
        return a(this, Z7.ISErrorLoadBannerNotSupportedSize, null, 2, null);
    }

    public final IronSourceError m() {
        return a(this, Z7.ISErrorLoadBannerSizeIsNull, null, 2, null);
    }

    public final IronSourceError n() {
        return a(this, Z7.ISErrorLoadBiddingInNonBidding, null, 2, null);
    }

    public final IronSourceError o() {
        return a(this, Z7.ISErrorLoadInstanceNotInInitResponse, null, 2, null);
    }

    public final IronSourceError p() {
        return a(this, Z7.ISErrorLoadNoAdFormatConfigurations, null, 2, null);
    }

    public final IronSourceError q() {
        return a(this, Z7.ISErrorLoadNullADM, null, 2, null);
    }

    public final IronSourceError r() {
        return a(this, Z7.ISErrorLoadSDKNotInitialized, null, 2, null);
    }

    public final IronSourceError s() {
        return a(this, Z7.ISErrorLoadTimedOut, null, 2, null);
    }

    public final IronSourceError t() {
        return a(this, Z7.ISErrorShowNotReadyToShowAd, null, 2, null);
    }

    private final IronSourceError a(Z7 z7, IronSourceError ironSourceError) {
        String c;
        if (ironSourceError != null) {
            c = z7.c() + " Underlying network error: '" + ironSourceError.getErrorCode() + ":" + ironSourceError.getErrorMessage() + "'";
        } else {
            c = z7.c();
        }
        return new IronSourceError(z7.b(), c);
    }

    public final IronSourceError b(IronSourceError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return a(Z7.ISErrorLoadNetworkFailed, error);
    }

    public final IronSourceError c(String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        return a(Z7.ISErrorLoadNetworkFailed, description);
    }

    public final IronSourceError d(String str) {
        return a(Z7.ISErrorRewardedLoadNoConfig, str);
    }

    public static /* synthetic */ IronSourceError b(C3362w5 c3362w5, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return c3362w5.b(str);
    }

    public final IronSourceError c(IronSourceError networkError) {
        Intrinsics.checkNotNullParameter(networkError, "networkError");
        return a(Z7.ISErrorShowNetworkFailed, networkError);
    }

    public static /* synthetic */ IronSourceError c(C3362w5 c3362w5, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return c3362w5.d(str);
    }

    public final IronSourceError b(String str) {
        return a(Z7.ISErrorInterstitialLoadNoConfig, str);
    }

    private final IronSourceError a(Z7 z7, String str) {
        if (str == null || str.length() == 0) {
            str = z7.c();
        }
        return new IronSourceError(z7.b(), str);
    }

    public final IronSourceError a(IronSourceError networkError) {
        Intrinsics.checkNotNullParameter(networkError, "networkError");
        return a(Z7.ISErrorInitNetworkFailed, networkError);
    }

    public final IronSourceError a() {
        return a(this, Z7.ISErrorInitDecryptionFailure, null, 2, null);
    }

    public static /* synthetic */ IronSourceError a(C3362w5 c3362w5, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return c3362w5.a(str);
    }

    public final IronSourceError a(String str) {
        return a(Z7.ISErrorBannerLoadNoConfig, str);
    }
}
