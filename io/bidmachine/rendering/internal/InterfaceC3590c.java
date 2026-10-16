package io.bidmachine.rendering.internal;

import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import io.bidmachine.rendering.model.AdElementParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\bH&¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\r\u001a\u00020\bH&¢\u0006\u0004\b\r\u0010\nR\u0014\u0010\u0015\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Lio/bidmachine/rendering/internal/c;", "", "", "i", "()Z", "Landroid/view/View;", com.mbridge.msdk.foundation.same.report.j.b, "()Landroid/view/View;", "", "c", "()V", "Landroid/view/ViewGroup;", "viewGroup", "a", "(Landroid/view/ViewGroup;)V", "d", InneractiveMediationDefs.GENDER_FEMALE, "m", "Lio/bidmachine/rendering/model/AdElementParams;", "h", "()Lio/bidmachine/rendering/model/AdElementParams;", "adElementParams", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.bidmachine.rendering.internal.c, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC3590c {
    void a();

    default void a(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
    }

    void c();

    default void d() {
    }

    default void f() {
    }

    AdElementParams h();

    boolean i();

    View j();

    void m();
}
