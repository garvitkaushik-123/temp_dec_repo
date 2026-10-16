package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;

/* loaded from: classes6.dex */
public final class k<L extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x> {

    /* renamed from: a, reason: collision with root package name */
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<L> f5514a;
    public com.moloco.sdk.internal.ortb.model.r b;
    public j c;
    public Job d;
    public String e;
    public String f;
    public boolean g;

    public k() {
        this(null, null, null, null, null, null, false, 127, null);
    }

    public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<L> c) {
        this.f5514a = c;
    }

    public final j b() {
        return this.c;
    }

    public final String c() {
        return this.f;
    }

    public final String d() {
        return this.e;
    }

    public final com.moloco.sdk.internal.ortb.model.r e() {
        return this.b;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<L> f() {
        return this.f5514a;
    }

    public final boolean g() {
        return this.g;
    }

    public k(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<L> c, com.moloco.sdk.internal.ortb.model.r rVar, j jVar, Job job, String str, String str2, boolean z) {
        this.f5514a = c;
        this.b = rVar;
        this.c = jVar;
        this.d = job;
        this.e = str;
        this.f = str2;
        this.g = z;
    }

    public final void a(com.moloco.sdk.internal.ortb.model.r rVar) {
        this.b = rVar;
    }

    public final void b(String str) {
        this.e = str;
    }

    public final void a(j jVar) {
        this.c = jVar;
    }

    public final Job a() {
        return this.d;
    }

    public final void a(Job job) {
        this.d = job;
    }

    public final void a(String str) {
        this.f = str;
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public /* synthetic */ k(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C c, com.moloco.sdk.internal.ortb.model.r rVar, j jVar, Job job, String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : c, (i & 2) != 0 ? null : rVar, (i & 4) != 0 ? null : jVar, (i & 8) != 0 ? null : job, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? false : z);
    }
}
