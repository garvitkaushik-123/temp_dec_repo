package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.sourcepoint.cmplibrary.exception.CampaignType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessagesApiModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toCategoryId", "", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MessagesApiModelKt {

    /* compiled from: MessagesApiModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CampaignType.values().length];
            try {
                iArr[CampaignType.GDPR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CampaignType.CCPA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CampaignType.USNAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int toCategoryId(CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(campaignType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[campaignType.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                if (i == 3) {
                    return 6;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return i2;
    }
}
