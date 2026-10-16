package com.ironsource;

import com.ironsource.Za;
import com.unity3d.mediation.LevelPlayAdInfo;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: com.ironsource.za, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3418za {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(Za<LevelPlayAdInfo> za) {
        if (za instanceof Za.b) {
            return "success";
        }
        if (za instanceof Za.a) {
            return AnalyticsConstants.EVENT_FAILURE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
