package com.unity3d.ads.core.extensions;

import com.unity3d.ads.AdFormat;
import com.unity3d.scar.adapter.common.scarads.UnityAdFormat;
import gatewayprotocol.v1.InitializationResponseOuterClass;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdFormatExtensions.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\f\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0001¨\u0006\u0005"}, d2 = {"toProtoAdFormat", "Lgatewayprotocol/v1/InitializationResponseOuterClass$AdFormat;", "Lcom/unity3d/ads/AdFormat;", "toUnityAdFormat", "Lcom/unity3d/scar/adapter/common/scarads/UnityAdFormat;", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdFormatExtensions {

    /* compiled from: AdFormatExtensions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[InitializationResponseOuterClass.AdFormat.values().length];
            try {
                iArr[InitializationResponseOuterClass.AdFormat.AD_FORMAT_REWARDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InitializationResponseOuterClass.AdFormat.AD_FORMAT_INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InitializationResponseOuterClass.AdFormat.AD_FORMAT_BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AdFormat.values().length];
            try {
                iArr2[AdFormat.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[AdFormat.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[AdFormat.REWARDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final UnityAdFormat toUnityAdFormat(InitializationResponseOuterClass.AdFormat adFormat) {
        Intrinsics.checkNotNullParameter(adFormat, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[adFormat.ordinal()];
        if (i == 1) {
            return UnityAdFormat.REWARDED;
        }
        if (i == 2) {
            return UnityAdFormat.INTERSTITIAL;
        }
        if (i != 3) {
            return null;
        }
        return UnityAdFormat.BANNER;
    }

    public static final InitializationResponseOuterClass.AdFormat toProtoAdFormat(AdFormat adFormat) {
        Intrinsics.checkNotNullParameter(adFormat, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[adFormat.ordinal()];
        if (i == 1) {
            return InitializationResponseOuterClass.AdFormat.AD_FORMAT_BANNER;
        }
        if (i == 2) {
            return InitializationResponseOuterClass.AdFormat.AD_FORMAT_INTERSTITIAL;
        }
        if (i == 3) {
            return InitializationResponseOuterClass.AdFormat.AD_FORMAT_REWARDED;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final UnityAdFormat toUnityAdFormat(AdFormat adFormat) {
        Intrinsics.checkNotNullParameter(adFormat, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[adFormat.ordinal()];
        if (i == 1) {
            return UnityAdFormat.BANNER;
        }
        if (i == 2) {
            return UnityAdFormat.INTERSTITIAL;
        }
        if (i == 3) {
            return UnityAdFormat.REWARDED;
        }
        throw new NoWhenBranchMatchedException();
    }
}
