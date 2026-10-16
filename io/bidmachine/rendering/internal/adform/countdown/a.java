package io.bidmachine.rendering.internal.adform.countdown;

import android.content.Context;
import android.view.View;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.rendering.internal.adform.c;
import io.bidmachine.rendering.internal.o;
import io.bidmachine.rendering.internal.view.b;
import io.bidmachine.rendering.model.AdElementParams;
import io.bidmachine.rendering.utils.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0018B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u0015J\u000f\u0010\u001b\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001b\u0010\u0015J\u000f\u0010\u001c\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u001c\u0010\u0015R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lio/bidmachine/rendering/internal/adform/countdown/a;", "Lio/bidmachine/rendering/internal/adform/a;", "Landroid/content/Context;", "context", "Lio/bidmachine/rendering/internal/repository/a;", "repository", "Lio/bidmachine/rendering/model/AdElementParams;", "adElementParams", "Lio/bidmachine/rendering/internal/adform/c;", "adFormListener", "Lio/bidmachine/rendering/internal/event/b;", "eventCallback", "Lio/bidmachine/rendering/internal/detector/brokencreative/a;", "brokenCreativeDetector", "<init>", "(Landroid/content/Context;Lio/bidmachine/rendering/internal/repository/a;Lio/bidmachine/rendering/model/AdElementParams;Lio/bidmachine/rendering/internal/adform/c;Lio/bidmachine/rendering/internal/event/b;Lio/bidmachine/rendering/internal/detector/brokencreative/a;)V", "Landroid/view/View;", "v", "()Landroid/view/View;", "", "c", "()V", "", "value", "a", "(Ljava/lang/String;)V", "d", InneractiveMediationDefs.GENDER_FEMALE, VastAttributes.HORIZONTAL_POSITION, "Lio/bidmachine/rendering/internal/view/b;", "r", "Lio/bidmachine/rendering/internal/view/b;", "circleCountdownView", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class a extends io.bidmachine.rendering.internal.adform.a {

    /* renamed from: r, reason: from kotlin metadata */
    private final b circleCountdownView;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/bidmachine/rendering/internal/adform/countdown/a$a;", "Lio/bidmachine/rendering/internal/view/b$d;", "<init>", "(Lio/bidmachine/rendering/internal/adform/countdown/a;)V", "", "a", "()V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: io.bidmachine.rendering.internal.adform.countdown.a$a, reason: collision with other inner class name */
    private final class C0605a implements b.d {
        public C0605a() {
        }

        @Override // io.bidmachine.rendering.internal.view.b.d
        public void a() {
            a.this.o().a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, io.bidmachine.rendering.internal.repository.a repository, AdElementParams adElementParams, c adFormListener, io.bidmachine.rendering.internal.event.b eventCallback, io.bidmachine.rendering.internal.detector.brokencreative.a aVar) {
        super(context, repository, adElementParams, adFormListener, eventCallback, aVar);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(adElementParams, "adElementParams");
        Intrinsics.checkNotNullParameter(adFormListener, "adFormListener");
        Intrinsics.checkNotNullParameter(eventCallback, "eventCallback");
        b bVar = new b(context);
        bVar.setListener(new C0605a());
        this.circleCountdownView = bVar;
    }

    @Override // io.bidmachine.rendering.internal.y, io.bidmachine.rendering.internal.x
    public void a(String value) {
        if (Utils.toIntOrNull(value) == null) {
            o.a("Can't obtain time to start", new Object[0]);
        } else {
            this.circleCountdownView.setDuration(r4.intValue());
            this.circleCountdownView.f();
        }
    }

    @Override // io.bidmachine.rendering.internal.InterfaceC3590c
    public void c() {
        getAdFormListener().b(this);
    }

    @Override // io.bidmachine.rendering.internal.adform.a, io.bidmachine.rendering.internal.InterfaceC3590c
    public void d() {
        this.circleCountdownView.e();
        super.d();
    }

    @Override // io.bidmachine.rendering.internal.adform.a, io.bidmachine.rendering.internal.InterfaceC3590c
    public void f() {
        super.f();
        this.circleCountdownView.g();
    }

    @Override // io.bidmachine.rendering.internal.adform.a
    public View v() {
        return this.circleCountdownView;
    }

    @Override // io.bidmachine.rendering.internal.adform.a
    protected void x() {
        this.circleCountdownView.b();
    }
}
