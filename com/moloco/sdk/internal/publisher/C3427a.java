package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.AdFormatType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* renamed from: com.moloco.sdk.internal.publisher.a, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3427a implements r {
    public static final C0439a d = new C0439a(null);
    public static final int e = 8;
    public static final String f = "AdCreateLoadTimeoutManager";

    /* renamed from: a, reason: collision with root package name */
    public final AdFormatType f5490a;
    public final long b;
    public long c;

    /* renamed from: com.moloco.sdk.internal.publisher.a$a, reason: collision with other inner class name */
    public static final class C0439a {
        public /* synthetic */ C0439a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public C0439a() {
        }
    }

    public /* synthetic */ C3427a(AdFormatType adFormatType, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(adFormatType, j);
    }

    public final long a(long j) {
        long createAdObjectStartTime = j - getCreateAdObjectStartTime();
        long duration = DurationKt.toDuration(Duration.m11585getInWholeMillisecondsimpl(this.b) - createAdObjectStartTime, DurationUnit.MILLISECONDS);
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, f, this.f5490a + " timeout: " + ((Object) Duration.m11616toStringimpl(this.b)) + " , create ad duration: " + createAdObjectStartTime + " ms (createTime: " + getCreateAdObjectStartTime() + " ms, loadStartTime: " + j + " ms). Return value: " + ((Object) Duration.m11616toStringimpl(duration)), false, 4, null);
        return duration;
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public long getCreateAdObjectStartTime() {
        return this.c;
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public void setCreateAdObjectStartTime(long j) {
        this.c = j;
    }

    public C3427a(AdFormatType adFormatType, long j) {
        Intrinsics.checkNotNullParameter(adFormatType, "adFormatType");
        this.f5490a = adFormatType;
        this.b = j;
    }
}
