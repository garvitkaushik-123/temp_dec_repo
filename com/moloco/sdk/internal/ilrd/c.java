package com.moloco.sdk.internal.ilrd;

import com.moloco.sdk.IlrdRequest;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes6.dex */
public interface c {

    public interface a {

        /* renamed from: com.moloco.sdk.internal.ilrd.c$a$a, reason: collision with other inner class name */
        public static final class C0433a implements a {
            public static final int b = 0;

            /* renamed from: a, reason: collision with root package name */
            public final IlrdRequest.LevelPlayImpression f5417a;

            public C0433a(IlrdRequest.LevelPlayImpression impression) {
                Intrinsics.checkNotNullParameter(impression, "impression");
                this.f5417a = impression;
            }

            public final IlrdRequest.LevelPlayImpression a() {
                return this.f5417a;
            }

            public final IlrdRequest.LevelPlayImpression b() {
                return this.f5417a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0433a) && Intrinsics.areEqual(this.f5417a, ((C0433a) obj).f5417a);
            }

            public int hashCode() {
                return this.f5417a.hashCode();
            }

            public String toString() {
                return "LevelPlay(impression=" + this.f5417a + ')';
            }

            public final C0433a a(IlrdRequest.LevelPlayImpression impression) {
                Intrinsics.checkNotNullParameter(impression, "impression");
                return new C0433a(impression);
            }

            public static /* synthetic */ C0433a a(C0433a c0433a, IlrdRequest.LevelPlayImpression levelPlayImpression, int i, Object obj) {
                if ((i & 1) != 0) {
                    levelPlayImpression = c0433a.f5417a;
                }
                return c0433a.a(levelPlayImpression);
            }
        }

        public static final class b implements a {
            public static final int b = 0;

            /* renamed from: a, reason: collision with root package name */
            public final IlrdRequest.MaxImpression f5418a;

            public b(IlrdRequest.MaxImpression impression) {
                Intrinsics.checkNotNullParameter(impression, "impression");
                this.f5418a = impression;
            }

            public final IlrdRequest.MaxImpression a() {
                return this.f5418a;
            }

            public final IlrdRequest.MaxImpression b() {
                return this.f5418a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && Intrinsics.areEqual(this.f5418a, ((b) obj).f5418a);
            }

            public int hashCode() {
                return this.f5418a.hashCode();
            }

            public String toString() {
                return "Max(impression=" + this.f5418a + ')';
            }

            public final b a(IlrdRequest.MaxImpression impression) {
                Intrinsics.checkNotNullParameter(impression, "impression");
                return new b(impression);
            }

            public static /* synthetic */ b a(b bVar, IlrdRequest.MaxImpression maxImpression, int i, Object obj) {
                if ((i & 1) != 0) {
                    maxImpression = bVar.f5418a;
                }
                return bVar.a(maxImpression);
            }
        }
    }

    com.moloco.sdk.internal.ilrd.model.a a();

    Object b();

    SharedFlow<a> c();

    StateFlow<g> getState();
}
