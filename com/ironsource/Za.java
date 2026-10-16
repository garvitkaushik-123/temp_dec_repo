package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public interface Za<T> {

    public static final class a<T> implements Za<T> {

        /* renamed from: a, reason: collision with root package name */
        private final IronSourceError f3163a;

        public a(IronSourceError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.f3163a = error;
        }

        public final IronSourceError a() {
            return this.f3163a;
        }

        public final IronSourceError b() {
            return this.f3163a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.f3163a, ((a) obj).f3163a);
        }

        public int hashCode() {
            return this.f3163a.hashCode();
        }

        public String toString() {
            return "Failure(error=" + this.f3163a + ")";
        }

        public final a<T> a(IronSourceError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new a<>(error);
        }

        public static /* synthetic */ a a(a aVar, IronSourceError ironSourceError, int i, Object obj) {
            if ((i & 1) != 0) {
                ironSourceError = aVar.f3163a;
            }
            return aVar.a(ironSourceError);
        }
    }

    public static final class b<T> implements Za<T> {

        /* renamed from: a, reason: collision with root package name */
        private final T f3164a;

        public b(T t) {
            this.f3164a = t;
        }

        public final T a() {
            return this.f3164a;
        }

        public final T b() {
            return this.f3164a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual(this.f3164a, ((b) obj).f3164a);
        }

        public int hashCode() {
            T t = this.f3164a;
            if (t == null) {
                return 0;
            }
            return t.hashCode();
        }

        public String toString() {
            return "Success(value=" + this.f3164a + ")";
        }

        public final b<T> a(T t) {
            return new b<>(t);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ b a(b bVar, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = bVar.f3164a;
            }
            return bVar.a(obj);
        }
    }
}
