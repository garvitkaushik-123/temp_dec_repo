package io.adn.sdk.internal.domain.model.privacy;

import kotlin.Metadata;

/* compiled from: PrivacyInfo.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000e"}, d2 = {"Lio/adn/sdk/internal/domain/model/privacy/PrivacyInfo;", "", "<init>", "()V", "hasUserConsent", "", "getHasUserConsent", "()Z", "setHasUserConsent", "(Z)V", "doNotSell", "getDoNotSell", "setDoNotSell", "canUseData", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PrivacyInfo {
    public static final int $stable = 8;
    private boolean doNotSell;
    private boolean hasUserConsent;

    public final boolean getHasUserConsent() {
        return this.hasUserConsent;
    }

    public final void setHasUserConsent(boolean z) {
        this.hasUserConsent = z;
    }

    public final boolean getDoNotSell() {
        return this.doNotSell;
    }

    public final void setDoNotSell(boolean z) {
        this.doNotSell = z;
    }

    public final boolean canUseData() {
        return this.hasUserConsent && !this.doNotSell;
    }
}
