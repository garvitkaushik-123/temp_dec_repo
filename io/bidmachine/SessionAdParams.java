package io.bidmachine;

import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.Value;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.models.ISessionAdParams;
import io.bidmachine.models.RequestParams;

@Deprecated
/* loaded from: classes7.dex */
public final class SessionAdParams extends RequestParams<SessionAdParams> implements ISessionAdParams<SessionAdParams> {
    private Integer sessionDuration;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ISessionAdParams
    public SessionAdParams setSessionDuration(Integer sessionDuration) {
        if (sessionDuration == null || sessionDuration.intValue() >= 0) {
            this.sessionDuration = sessionDuration;
            return this;
        }
        Logger.e("session duration shouldn't be negative");
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ISessionAdParams
    @Deprecated
    public SessionAdParams setImpressionCount(Integer impressionCount) {
        Logger.w("The method setImpressionCount is no longer supported and has no effect.");
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ISessionAdParams
    @Deprecated
    public SessionAdParams setClickRate(Float clickRate) {
        Logger.w("The method setClickRate is no longer supported and has no effect.");
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ISessionAdParams
    @Deprecated
    public SessionAdParams setIsUserClickedOnLastAd(Boolean isUserClickedOnLastAd) {
        Logger.w("The method setIsUserClickedOnLastAd is no longer supported and has no effect.");
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ISessionAdParams
    @Deprecated
    public SessionAdParams setCompletionRate(Float completionRate) {
        Logger.w("The method setCompletionRate is no longer supported and has no effect.");
        return this;
    }

    @Override // io.bidmachine.models.RequestParams
    public void merge(SessionAdParams instance) {
        this.sessionDuration = (Integer) Utils.oneOf(this.sessionDuration, instance.sessionDuration);
    }

    void fillUserExtension(Struct.Builder userExtBuilder) {
        if (this.sessionDuration != null) {
            userExtBuilder.putFields("sessionduration", Value.newBuilder().setNumberValue(this.sessionDuration.intValue()).build());
        }
    }

    Integer getSessionDuration() {
        return this.sessionDuration;
    }

    void clear() {
        this.sessionDuration = null;
    }
}
