package com.unity3d.services.ads.gmascar.utils;

import com.ironsource.C3033ce;
import com.unity3d.ads.AdFormat;
import com.unity3d.ads.TokenConfiguration;
import com.unity3d.ads.core.extensions.AdFormatExtensions;
import com.unity3d.scar.adapter.common.scarads.UnityAdFormat;
import com.unity3d.services.core.configuration.IExperiments;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScarAdFormatProvider.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/unity3d/services/ads/gmascar/utils/ScarAdFormatProvider;", "Lcom/unity3d/services/ads/gmascar/utils/IScarAdFormatProvider;", "tokenConfiguration", "Lcom/unity3d/ads/TokenConfiguration;", C3033ce.d, "Lcom/unity3d/services/core/configuration/IExperiments;", "(Lcom/unity3d/ads/TokenConfiguration;Lcom/unity3d/services/core/configuration/IExperiments;)V", "getExperiments", "()Lcom/unity3d/services/core/configuration/IExperiments;", "getTokenConfiguration", "()Lcom/unity3d/ads/TokenConfiguration;", "buildAdFormatList", "", "Lcom/unity3d/scar/adapter/common/scarads/UnityAdFormat;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ScarAdFormatProvider implements IScarAdFormatProvider {
    private final IExperiments experiments;
    private final TokenConfiguration tokenConfiguration;

    /* compiled from: ScarAdFormatProvider.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdFormat.values().length];
            try {
                iArr[AdFormat.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ScarAdFormatProvider(TokenConfiguration tokenConfiguration, IExperiments experiments) {
        Intrinsics.checkNotNullParameter(experiments, "experiments");
        this.tokenConfiguration = tokenConfiguration;
        this.experiments = experiments;
    }

    public final TokenConfiguration getTokenConfiguration() {
        return this.tokenConfiguration;
    }

    public final IExperiments getExperiments() {
        return this.experiments;
    }

    @Override // com.unity3d.services.ads.gmascar.utils.IScarAdFormatProvider
    public List<UnityAdFormat> buildAdFormatList() {
        ArrayList arrayList = new ArrayList();
        TokenConfiguration tokenConfiguration = this.tokenConfiguration;
        if (tokenConfiguration == null) {
            arrayList.add(UnityAdFormat.REWARDED);
            arrayList.add(UnityAdFormat.INTERSTITIAL);
            if (this.experiments.isScarBannerHbEnabled()) {
                arrayList.add(UnityAdFormat.BANNER);
                return arrayList;
            }
        } else {
            if (WhenMappings.$EnumSwitchMapping$0[tokenConfiguration.getAdFormat().ordinal()] == 1) {
                if (this.experiments.isScarBannerHbEnabled()) {
                    arrayList.add(UnityAdFormat.BANNER);
                }
            } else {
                arrayList.add(AdFormatExtensions.toUnityAdFormat(this.tokenConfiguration.getAdFormat()));
                return arrayList;
            }
        }
        return arrayList;
    }
}
