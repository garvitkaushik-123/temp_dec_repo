package io.bidmachine.models;

/* loaded from: classes7.dex */
public interface ISessionAdParams<SelfType> {
    @Deprecated
    SelfType setClickRate(Float clickRate);

    @Deprecated
    SelfType setCompletionRate(Float completionRate);

    @Deprecated
    SelfType setImpressionCount(Integer impressionCount);

    @Deprecated
    SelfType setIsUserClickedOnLastAd(Boolean isUserClickedOnLastAd);

    SelfType setSessionDuration(Integer sessionDuration);
}
