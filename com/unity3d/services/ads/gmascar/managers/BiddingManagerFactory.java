package com.unity3d.services.ads.gmascar.managers;

import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.ads.TokenConfiguration;
import com.unity3d.services.ads.gmascar.GMA;
import com.unity3d.services.ads.gmascar.utils.ScarAdFormatProvider;
import com.unity3d.services.core.configuration.IExperiments;

/* loaded from: classes7.dex */
public class BiddingManagerFactory {
    private static BiddingManagerFactory instance;

    private BiddingManagerFactory() {
    }

    public static BiddingManagerFactory getInstance() {
        if (instance == null) {
            instance = new BiddingManagerFactory();
        }
        return instance;
    }

    public BiddingBaseManager createManager(IUnityAdsTokenListener iUnityAdsTokenListener, IExperiments iExperiments) {
        return createManager(iUnityAdsTokenListener, null, iExperiments);
    }

    public BiddingBaseManager createManager(IUnityAdsTokenListener iUnityAdsTokenListener, TokenConfiguration tokenConfiguration, IExperiments iExperiments) {
        if (GMA.getInstance().hasSCARBiddingSupport()) {
            return getExperiment(iUnityAdsTokenListener, tokenConfiguration, iExperiments);
        }
        return new BiddingDisabledManager(iUnityAdsTokenListener);
    }

    private BiddingBaseManager getExperiment(IUnityAdsTokenListener iUnityAdsTokenListener, TokenConfiguration tokenConfiguration, IExperiments iExperiments) {
        if (iExperiments == null || iExperiments.getScarBiddingManager() == null) {
            return new BiddingDisabledManager(iUnityAdsTokenListener);
        }
        ScarBiddingManagerType fromName = ScarBiddingManagerType.fromName(iExperiments.getScarBiddingManager());
        ScarAdFormatProvider scarAdFormatProvider = new ScarAdFormatProvider(tokenConfiguration, iExperiments);
        if (AnonymousClass1.$SwitchMap$com$unity3d$services$ads$gmascar$managers$ScarBiddingManagerType[fromName.ordinal()] == 1) {
            return new BiddingEagerManager(scarAdFormatProvider, iUnityAdsTokenListener);
        }
        return new BiddingDisabledManager(iUnityAdsTokenListener);
    }

    /* renamed from: com.unity3d.services.ads.gmascar.managers.BiddingManagerFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$ads$gmascar$managers$ScarBiddingManagerType;

        static {
            int[] iArr = new int[ScarBiddingManagerType.values().length];
            $SwitchMap$com$unity3d$services$ads$gmascar$managers$ScarBiddingManagerType = iArr;
            try {
                iArr[ScarBiddingManagerType.EAGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$unity3d$services$ads$gmascar$managers$ScarBiddingManagerType[ScarBiddingManagerType.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
