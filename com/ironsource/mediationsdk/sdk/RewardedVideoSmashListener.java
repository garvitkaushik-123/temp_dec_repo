package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Map;

/* loaded from: classes6.dex */
public interface RewardedVideoSmashListener {
    void onRewardedVideoAdClicked();

    default void onRewardedVideoAdClicked(Map<String, Object> map) {
        onRewardedVideoAdClicked();
    }

    void onRewardedVideoAdClosed();

    default void onRewardedVideoAdClosed(Map<String, Object> map) {
        onRewardedVideoAdClosed();
    }

    void onRewardedVideoAdEnded();

    default void onRewardedVideoAdEnded(Map<String, Object> map) {
        onRewardedVideoAdEnded();
    }

    void onRewardedVideoAdOpened();

    default void onRewardedVideoAdOpened(Map<String, Object> map) {
        onRewardedVideoAdOpened();
    }

    void onRewardedVideoAdRewarded();

    default void onRewardedVideoAdRewarded(Map<String, Object> map) {
        onRewardedVideoAdRewarded();
    }

    void onRewardedVideoAdShowFailed(IronSourceError ironSourceError);

    default void onRewardedVideoAdShowFailed(IronSourceError ironSourceError, Map<String, Object> map) {
        onRewardedVideoAdShowFailed(ironSourceError);
    }

    void onRewardedVideoAdStarted();

    default void onRewardedVideoAdStarted(Map<String, Object> map) {
        onRewardedVideoAdStarted();
    }

    void onRewardedVideoAdVisible();

    default void onRewardedVideoAdVisible(Map<String, Object> map) {
        onRewardedVideoAdVisible();
    }

    void onRewardedVideoAvailabilityChanged(boolean z);

    default void onRewardedVideoAvailabilityChanged(boolean z, Map<String, Object> map) {
        onRewardedVideoAvailabilityChanged(z);
    }

    void onRewardedVideoInitFailed(IronSourceError ironSourceError);

    default void onRewardedVideoInitFailed(IronSourceError ironSourceError, Map<String, Object> map) {
        onRewardedVideoInitFailed(ironSourceError);
    }

    void onRewardedVideoInitSuccess();

    default void onRewardedVideoInitSuccess(Map<String, Object> map) {
        onRewardedVideoInitSuccess();
    }

    void onRewardedVideoLoadFailed(IronSourceError ironSourceError);

    default void onRewardedVideoLoadFailed(IronSourceError ironSourceError, Map<String, Object> map) {
        onRewardedVideoLoadFailed(ironSourceError);
    }

    void onRewardedVideoLoadSuccess();

    default void onRewardedVideoLoadSuccess(Map<String, Object> map) {
        onRewardedVideoLoadSuccess();
    }
}
