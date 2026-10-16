package com.sourcepoint.cmplibrary.model;

import com.sourcepoint.cmplibrary.data.network.converter.ExceptionUtilsKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.choice.ChoiceTypeParam;
import com.sourcepoint.cmplibrary.model.exposed.ActionType;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConsentActionImpl.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0002*\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"privacyManagerTab", "Lcom/sourcepoint/cmplibrary/model/PMTab;", "Lcom/sourcepoint/cmplibrary/model/ConsentActionImpl;", "toChoiceTypeParam", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceTypeParam;", "Lcom/sourcepoint/cmplibrary/model/exposed/ActionType;", "toConsentAction", "Lcom/sourcepoint/cmplibrary/model/NativeConsentAction;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConsentActionImplKt {

    /* compiled from: ConsentActionImpl.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ActionType.values().length];
            try {
                iArr[ActionType.ACCEPT_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ActionType.REJECT_ALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final PMTab privacyManagerTab(ConsentActionImpl consentActionImpl) {
        PMTab pMTab;
        Intrinsics.checkNotNullParameter(consentActionImpl, "<this>");
        String pmTab = consentActionImpl.getPmTab();
        if (pmTab != null) {
            PMTab[] values = PMTab.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    pMTab = null;
                    break;
                }
                pMTab = values[i];
                if (Intrinsics.areEqual(pMTab.getKey(), pmTab)) {
                    break;
                }
                i++;
            }
            if (pMTab != null) {
                return pMTab;
            }
        }
        return PMTab.DEFAULT;
    }

    public static final ConsentActionImpl toConsentAction(NativeConsentAction nativeConsentAction) {
        ActionType actionType;
        Intrinsics.checkNotNullParameter(nativeConsentAction, "<this>");
        ActionType[] values = ActionType.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                actionType = null;
                break;
            }
            actionType = values[i];
            if (actionType.getCode() == nativeConsentAction.getActionType().getCode()) {
                break;
            }
            i++;
        }
        ActionType actionType2 = actionType;
        if (actionType2 != null) {
            return new ConsentActionImpl(nativeConsentAction.getCampaignType(), null, null, actionType2, null, null, null, false, null, null, null, null, null, 8054, null);
        }
        ExceptionUtilsKt.failParam("toConsentAction");
        throw new KotlinNothingValueException();
    }

    public static final ChoiceTypeParam toChoiceTypeParam(ActionType actionType) {
        Intrinsics.checkNotNullParameter(actionType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[actionType.ordinal()];
        if (i == 1) {
            return ChoiceTypeParam.CONSENT_ALL;
        }
        if (i == 2) {
            return ChoiceTypeParam.REJECT_ALL;
        }
        throw new RuntimeException("ChoiceTypeParam doesn't match the ActionType");
    }
}
