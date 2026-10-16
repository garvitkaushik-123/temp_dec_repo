package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.publisher.AdShowListener;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;

/* loaded from: classes6.dex */
public final class t<T extends AdShowListener> {
    public static final int f = 8;

    /* renamed from: a, reason: collision with root package name */
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> f5580a;
    public com.moloco.sdk.internal.ortb.model.r b;
    public j c;
    public Job d;
    public y e;

    public t() {
        this(null, null, null, null, null, 31, null);
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> a() {
        return this.f5580a;
    }

    public final Job b() {
        return this.d;
    }

    public final j c() {
        return this.c;
    }

    public final y d() {
        return this.e;
    }

    public final com.moloco.sdk.internal.ortb.model.r e() {
        return this.b;
    }

    public t(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> lVar, com.moloco.sdk.internal.ortb.model.r rVar, j jVar, Job job, y yVar) {
        this.f5580a = lVar;
        this.b = rVar;
        this.c = jVar;
        this.d = job;
        this.e = yVar;
    }

    public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> lVar) {
        this.f5580a = lVar;
    }

    public final void a(com.moloco.sdk.internal.ortb.model.r rVar) {
        this.b = rVar;
    }

    public final void a(j jVar) {
        this.c = jVar;
    }

    public final void a(Job job) {
        this.d = job;
    }

    public final void a(y yVar) {
        this.e = yVar;
    }

    public /* synthetic */ t(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l lVar, com.moloco.sdk.internal.ortb.model.r rVar, j jVar, Job job, y yVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : lVar, (i & 2) != 0 ? null : rVar, (i & 4) != 0 ? null : jVar, (i & 8) != 0 ? null : job, (i & 16) != 0 ? null : yVar);
    }
}
