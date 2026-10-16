package io.bidmachine.unified;

/* loaded from: classes8.dex */
public abstract class UnifiedParams {
    private final UnifiedMediationParams mediationParams;

    public abstract boolean isValid(UnifiedAdCallback callback);

    public UnifiedParams(UnifiedMediationParams mediationParams) {
        this.mediationParams = mediationParams;
    }

    public UnifiedMediationParams getMediationParams() {
        return this.mediationParams;
    }
}
