package com.moloco.sdk.publisher;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.MolocoAdError;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/moloco/sdk/publisher/RewardedInterstitialAdSample;", "Landroid/app/Activity;", "<init>", "()V", "rewardedInterstitialAd", "Lcom/moloco/sdk/publisher/RewardedInterstitialAd;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "persistentState", "Landroid/os/PersistableBundle;", "onDestroy", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
final class RewardedInterstitialAdSample extends Activity {
    private RewardedInterstitialAd rewardedInterstitialAd;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(RewardedInterstitialAdSample rewardedInterstitialAdSample, RewardedInterstitialAd rewardedInterstitialAd, MolocoAdError.AdCreateError adCreateError) {
        if (rewardedInterstitialAd == null) {
            rewardedInterstitialAdSample.finish();
            return Unit.INSTANCE;
        }
        rewardedInterstitialAdSample.rewardedInterstitialAd = rewardedInterstitialAd;
        rewardedInterstitialAd.load("bid response", new AdLoad.Listener() { // from class: com.moloco.sdk.publisher.RewardedInterstitialAdSample$onCreate$1$1
            @Override // com.moloco.sdk.publisher.AdLoad.Listener
            public void onAdLoadFailed(MolocoAdError molocoAdError) {
                Intrinsics.checkNotNullParameter(molocoAdError, "molocoAdError");
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            @Override // com.moloco.sdk.publisher.AdLoad.Listener
            public void onAdLoadSuccess(MolocoAd molocoAd) {
                Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }
        });
        rewardedInterstitialAd.isLoaded();
        rewardedInterstitialAd.show(new RewardedInterstitialAdShowListener() { // from class: com.moloco.sdk.publisher.RewardedInterstitialAdSample$onCreate$1$2
            @Override // com.moloco.sdk.publisher.AdShowListener
            public void onAdClicked(MolocoAd molocoAd) {
                Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            @Override // com.moloco.sdk.publisher.AdShowListener
            public void onAdHidden(MolocoAd molocoAd) {
                Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            @Override // com.moloco.sdk.publisher.AdShowListener
            public void onAdShowFailed(MolocoAdError molocoAdError) {
                Intrinsics.checkNotNullParameter(molocoAdError, "molocoAdError");
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            @Override // com.moloco.sdk.publisher.AdShowListener
            public void onAdShowSuccess(MolocoAd molocoAd) {
                Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
            public void onRewardedVideoCompleted(MolocoAd molocoAd) {
                Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
            public void onRewardedVideoStarted(MolocoAd molocoAd) {
                Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
            public void onUserRewarded(MolocoAd molocoAd) {
                Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }
        });
        rewardedInterstitialAd.load("an_another_bid_response", null);
        return Unit.INSTANCE;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Moloco.createRewardedInterstitial(new MediationInfo("MY_MEDIATION"), "MOLOCO_ADUNIT_ID", null, new Function2() { // from class: com.moloco.sdk.publisher.RewardedInterstitialAdSample$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit onCreate$lambda$0;
                onCreate$lambda$0 = RewardedInterstitialAdSample.onCreate$lambda$0(RewardedInterstitialAdSample.this, (RewardedInterstitialAd) obj, (MolocoAdError.AdCreateError) obj2);
                return onCreate$lambda$0;
            }
        });
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        RewardedInterstitialAd rewardedInterstitialAd = this.rewardedInterstitialAd;
        if (rewardedInterstitialAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rewardedInterstitialAd");
            rewardedInterstitialAd = null;
        }
        rewardedInterstitialAd.destroy();
    }
}
