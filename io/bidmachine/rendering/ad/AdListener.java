package io.bidmachine.rendering.ad;

import com.ironsource.C3355vf;
import io.bidmachine.rendering.model.BrokenCreativeEvent;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.PrivacySheetParams;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\fH&¢\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\fH&¢\u0006\u0002\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0014H&¢\u0006\u0002\u0010\u0015J\u001d\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u0018H&¢\u0006\u0002\u0010\u0019ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Lio/bidmachine/rendering/ad/AdListener;", "Ad", "", "onAdAppeared", "", "ad", "(Ljava/lang/Object;)V", C3355vf.f, "onAdDisappeared", "onAdExpired", "onAdFailToLoad", "error", "Lio/bidmachine/rendering/model/Error;", "(Ljava/lang/Object;Lio/bidmachine/rendering/model/Error;)V", "onAdFailToShow", "onAdFinished", C3355vf.j, "onAdShown", "onBrokenCreativeEvent", "brokenCreativeEvent", "Lio/bidmachine/rendering/model/BrokenCreativeEvent;", "(Ljava/lang/Object;Lio/bidmachine/rendering/model/BrokenCreativeEvent;)V", "onOpenPrivacySheet", "privacySheetParams", "Lio/bidmachine/rendering/model/PrivacySheetParams;", "(Ljava/lang/Object;Lio/bidmachine/rendering/model/PrivacySheetParams;)V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public interface AdListener<Ad> {
    void onAdAppeared(Ad ad);

    void onAdClicked(Ad ad);

    void onAdDisappeared(Ad ad);

    void onAdExpired(Ad ad);

    void onAdFailToLoad(Ad ad, Error error);

    void onAdFailToShow(Ad ad, Error error);

    void onAdFinished(Ad ad);

    void onAdLoaded(Ad ad);

    void onAdShown(Ad ad);

    void onBrokenCreativeEvent(Ad ad, BrokenCreativeEvent brokenCreativeEvent);

    void onOpenPrivacySheet(Ad ad, PrivacySheetParams privacySheetParams);
}
