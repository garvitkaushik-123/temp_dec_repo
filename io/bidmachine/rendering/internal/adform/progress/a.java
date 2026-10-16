package io.bidmachine.rendering.internal.adform.progress;

import android.content.Context;
import android.view.View;
import io.bidmachine.rendering.internal.event.b;
import io.bidmachine.rendering.internal.view.c;
import io.bidmachine.rendering.model.AdElementParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lio/bidmachine/rendering/internal/adform/progress/a;", "Lio/bidmachine/rendering/internal/adform/a;", "Landroid/content/Context;", "context", "Lio/bidmachine/rendering/internal/repository/a;", "repository", "Lio/bidmachine/rendering/model/AdElementParams;", "adElementParams", "Lio/bidmachine/rendering/internal/adform/c;", "adFormListener", "Lio/bidmachine/rendering/internal/event/b;", "eventCallback", "Lio/bidmachine/rendering/internal/detector/brokencreative/a;", "brokenCreativeDetector", "<init>", "(Landroid/content/Context;Lio/bidmachine/rendering/internal/repository/a;Lio/bidmachine/rendering/model/AdElementParams;Lio/bidmachine/rendering/internal/adform/c;Lio/bidmachine/rendering/internal/event/b;Lio/bidmachine/rendering/internal/detector/brokencreative/a;)V", "Landroid/view/View;", "v", "()Landroid/view/View;", "", "c", "()V", "", "maxProgressMs", "currentProgressMs", "", "percent", "a", "(JJF)V", "Lio/bidmachine/rendering/internal/view/c;", "r", "Lio/bidmachine/rendering/internal/view/c;", "linearProgressView", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class a extends io.bidmachine.rendering.internal.adform.a {

    /* renamed from: r, reason: from kotlin metadata */
    private final c linearProgressView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, io.bidmachine.rendering.internal.repository.a repository, AdElementParams adElementParams, io.bidmachine.rendering.internal.adform.c adFormListener, b eventCallback, io.bidmachine.rendering.internal.detector.brokencreative.a aVar) {
        super(context, repository, adElementParams, adFormListener, eventCallback, aVar);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(adElementParams, "adElementParams");
        Intrinsics.checkNotNullParameter(adFormListener, "adFormListener");
        Intrinsics.checkNotNullParameter(eventCallback, "eventCallback");
        this.linearProgressView = new c(context);
    }

    @Override // io.bidmachine.rendering.internal.y, io.bidmachine.rendering.internal.s
    public void a(long maxProgressMs, long currentProgressMs, float percent) {
        this.linearProgressView.a(maxProgressMs, currentProgressMs, percent);
    }

    @Override // io.bidmachine.rendering.internal.InterfaceC3590c
    public void c() {
        getAdFormListener().b(this);
    }

    @Override // io.bidmachine.rendering.internal.adform.a
    public View v() {
        return this.linearProgressView;
    }
}
