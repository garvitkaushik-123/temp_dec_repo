package com.sourcepoint.cmplibrary.model.exposed;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpConfig.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0016\u0010\u0003\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"toMessageType", "Lcom/sourcepoint/cmplibrary/model/exposed/MessageType;", "Lcom/sourcepoint/cmplibrary/model/exposed/MessageSubCategory;", "toTParam", "Lcom/sourcepoint/cmplibrary/model/exposed/TargetingParam;", "Lkotlin/Pair;", "", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SpConfigKt {

    /* compiled from: SpConfig.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageSubCategory.values().length];
            try {
                iArr[MessageSubCategory.OTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessageSubCategory.NATIVE_OTT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final TargetingParam toTParam(Pair<String, String> pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return new TargetingParam(pair.getFirst(), pair.getSecond());
    }

    public static final MessageType toMessageType(MessageSubCategory messageSubCategory) {
        Intrinsics.checkNotNullParameter(messageSubCategory, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[messageSubCategory.ordinal()];
        if (i == 1) {
            return MessageType.LEGACY_OTT;
        }
        if (i == 2) {
            return MessageType.OTT;
        }
        return MessageType.MOBILE;
    }
}
