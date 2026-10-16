package io.bidmachine.rendering.internal.state;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.ironsource.C3061e8;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import io.bidmachine.rendering.internal.o;
import io.bidmachine.rendering.internal.state.a;
import io.bidmachine.util.Tag;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010#\n\u0002\b\b\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rJ\u0015\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\t\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0011J\u000f\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0011J\u000f\u0010\u0018\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0011J\u000f\u0010\u0019\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u0011J\u0017\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u000e\u0010\u0013J\u000f\u0010\u001b\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001b\u0010\u0011J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010 R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010 R\u0014\u0010$\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010 R\u0014\u0010%\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010 R\u0014\u0010&\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010 R\u0014\u0010(\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010 R\u0014\u0010*\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010 R\u0014\u0010+\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010 R\u0014\u0010,\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010 R\u0014\u0010-\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010 R\u0014\u0010.\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010 R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b0/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0011R\u0014\u00103\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0011R\u0014\u00104\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0011R\u0014\u00105\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0011R\u0014\u00106\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0011¨\u00067"}, d2 = {"Lio/bidmachine/rendering/internal/state/d;", "Lio/bidmachine/rendering/internal/state/a;", "", "parent", "<init>", "(Ljava/lang/String;)V", "Lio/bidmachine/rendering/internal/state/a$a;", "event", "", "a", "(Lio/bidmachine/rendering/internal/state/a$a;)V", "Lio/bidmachine/rendering/internal/state/a$b;", "observer", "(Lio/bidmachine/rendering/internal/state/a$b;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "c", "()Z", "isLoaded", "(Z)Z", "l", "()V", "i", InneractiveMediationDefs.GENDER_FEMALE, "e", j.b, "isAppeared", CampaignEx.JSON_KEY_AD_K, "Lio/bidmachine/util/Tag;", "Lio/bidmachine/util/Tag;", "tag", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "loadedFlag", "loadingFlag", "d", "showInitiatedFlag", "destroyedFlag", "loadingResultNotifiedFlag", "g", "shownNotifiedFlag", "h", "failToShowNotifiedFlag", "clickedNotifiedFlag", "finishedNotifiedFlag", "appearedFlag", "expiredNotifiedFlag", "", "m", "Ljava/util/Set;", "observers", "isShowInitiated", C3061e8.m, "isFinished", "isDestroyed", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public class d implements io.bidmachine.rendering.internal.state.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Tag tag;

    /* renamed from: b, reason: from kotlin metadata */
    private final AtomicBoolean loadedFlag;

    /* renamed from: c, reason: from kotlin metadata */
    private final AtomicBoolean loadingFlag;

    /* renamed from: d, reason: from kotlin metadata */
    private final AtomicBoolean showInitiatedFlag;

    /* renamed from: e, reason: from kotlin metadata */
    private final AtomicBoolean destroyedFlag;

    /* renamed from: f, reason: from kotlin metadata */
    private final AtomicBoolean loadingResultNotifiedFlag;

    /* renamed from: g, reason: from kotlin metadata */
    private final AtomicBoolean shownNotifiedFlag;

    /* renamed from: h, reason: from kotlin metadata */
    private final AtomicBoolean failToShowNotifiedFlag;

    /* renamed from: i, reason: from kotlin metadata */
    private final AtomicBoolean clickedNotifiedFlag;

    /* renamed from: j, reason: from kotlin metadata */
    private final AtomicBoolean finishedNotifiedFlag;

    /* renamed from: k, reason: from kotlin metadata */
    private final AtomicBoolean appearedFlag;

    /* renamed from: l, reason: from kotlin metadata */
    private final AtomicBoolean expiredNotifiedFlag;

    /* renamed from: m, reason: from kotlin metadata */
    private final Set<a.b> observers;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"io/bidmachine/rendering/internal/state/d$a", "Lio/bidmachine/rendering/internal/state/a$b;", "Lio/bidmachine/rendering/internal/state/a;", "source", "Lio/bidmachine/rendering/internal/state/a$a;", "event", "", "a", "(Lio/bidmachine/rendering/internal/state/a;Lio/bidmachine/rendering/internal/state/a$a;)V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements a.b {
        a() {
        }

        @Override // io.bidmachine.rendering.internal.state.a.b
        public void a(io.bidmachine.rendering.internal.state.a source, a.EnumC0629a event) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(event, "event");
            o.b(d.this.tag, "Event: " + event, new Object[0]);
        }
    }

    public d(String parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.tag = new Tag("DefaultAdState(" + parent + ')');
        this.loadedFlag = new AtomicBoolean(false);
        this.loadingFlag = new AtomicBoolean(false);
        this.showInitiatedFlag = new AtomicBoolean(false);
        this.destroyedFlag = new AtomicBoolean(false);
        this.loadingResultNotifiedFlag = new AtomicBoolean(false);
        this.shownNotifiedFlag = new AtomicBoolean(false);
        this.failToShowNotifiedFlag = new AtomicBoolean(false);
        this.clickedNotifiedFlag = new AtomicBoolean(false);
        this.finishedNotifiedFlag = new AtomicBoolean(false);
        this.appearedFlag = new AtomicBoolean(false);
        this.expiredNotifiedFlag = new AtomicBoolean(false);
        this.observers = new LinkedHashSet();
        a(new a());
    }

    @Override // io.bidmachine.rendering.internal.state.a
    public boolean b() {
        return this.loadedFlag.get() && !h();
    }

    @Override // io.bidmachine.rendering.internal.state.a
    public boolean c() {
        boolean compareAndSet = this.loadingFlag.compareAndSet(false, true);
        if (compareAndSet) {
            a(a.EnumC0629a.LoadingStarted);
        }
        return compareAndSet;
    }

    @Override // io.bidmachine.rendering.internal.state.a
    public boolean d() {
        return this.showInitiatedFlag.get();
    }

    @Override // io.bidmachine.rendering.internal.state.a
    public boolean e() {
        boolean compareAndSet = this.clickedNotifiedFlag.compareAndSet(false, true);
        if (compareAndSet) {
            a(a.EnumC0629a.Clicked);
        }
        return compareAndSet;
    }

    @Override // io.bidmachine.rendering.internal.state.a
    public boolean f() {
        boolean compareAndSet = this.failToShowNotifiedFlag.compareAndSet(false, true);
        if (compareAndSet) {
            a(a.EnumC0629a.FailedToShow);
        }
        return compareAndSet;
    }

    @Override // io.bidmachine.rendering.internal.state.a
    public boolean g() {
        return this.finishedNotifiedFlag.get();
    }

    @Override // io.bidmachine.rendering.internal.state.a
    public boolean h() {
        return this.destroyedFlag.get();
    }

    @Override // io.bidmachine.rendering.internal.state.a
    public boolean i() {
        boolean compareAndSet = this.shownNotifiedFlag.compareAndSet(false, true);
        if (compareAndSet) {
            a(a.EnumC0629a.Shown);
        }
        return compareAndSet;
    }

    @Override // io.bidmachine.rendering.internal.state.a
    public boolean j() {
        boolean compareAndSet = this.finishedNotifiedFlag.compareAndSet(false, true);
        if (compareAndSet) {
            a(a.EnumC0629a.Finished);
        }
        return compareAndSet;
    }

    @Override // io.bidmachine.rendering.internal.state.a
    public boolean k() {
        boolean compareAndSet = this.expiredNotifiedFlag.compareAndSet(false, true);
        if (compareAndSet) {
            a(a.EnumC0629a.Expired);
        }
        return compareAndSet;
    }

    @Override // io.bidmachine.rendering.internal.state.a
    public void l() {
        this.showInitiatedFlag.set(true);
        a(a.EnumC0629a.ShowInitiated);
    }

    @Override // io.bidmachine.rendering.internal.state.a
    public boolean m() {
        return this.shownNotifiedFlag.get();
    }

    @Override // io.bidmachine.rendering.internal.state.a
    public final void a(a.b observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (h()) {
            return;
        }
        synchronized (this.observers) {
            this.observers.add(observer);
        }
    }

    @Override // io.bidmachine.rendering.internal.state.a
    public final void b(a.b observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        synchronized (this.observers) {
            this.observers.remove(observer);
        }
    }

    @Override // io.bidmachine.rendering.internal.state.a
    public boolean b(boolean isAppeared) {
        boolean compareAndSet = this.appearedFlag.compareAndSet(!isAppeared, isAppeared);
        if (compareAndSet) {
            a(isAppeared ? a.EnumC0629a.Appeared : a.EnumC0629a.Disappeared);
        }
        return compareAndSet;
    }

    @Override // io.bidmachine.rendering.internal.state.a
    public boolean a(boolean isLoaded) {
        boolean z = false;
        this.loadingFlag.set(false);
        this.loadedFlag.set(isLoaded);
        if (this.loadingResultNotifiedFlag.compareAndSet(false, true) && !h()) {
            z = true;
        }
        if (z) {
            a(isLoaded ? a.EnumC0629a.Loaded : a.EnumC0629a.FailedToLoad);
        }
        return z;
    }

    @Override // io.bidmachine.rendering.internal.state.a
    public void a() {
        this.destroyedFlag.set(true);
        this.loadedFlag.set(false);
        this.loadingFlag.set(false);
        this.showInitiatedFlag.set(false);
        this.loadingResultNotifiedFlag.set(false);
        this.shownNotifiedFlag.set(false);
        this.failToShowNotifiedFlag.set(false);
        this.clickedNotifiedFlag.set(false);
        this.finishedNotifiedFlag.set(false);
        this.appearedFlag.set(false);
        this.expiredNotifiedFlag.set(false);
        a(a.EnumC0629a.Destroyed);
        synchronized (this.observers) {
            this.observers.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void a(a.EnumC0629a event) {
        synchronized (this.observers) {
            Iterator<T> it = this.observers.iterator();
            while (it.hasNext()) {
                ((a.b) it.next()).a(this, event);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
