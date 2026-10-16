package com.sourcepoint.cmplibrary.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Either.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/Either;", "R", "", "()V", "Left", "Right", "Lcom/sourcepoint/cmplibrary/core/Either$Left;", "Lcom/sourcepoint/cmplibrary/core/Either$Right;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class Either<R> {
    public /* synthetic */ Either(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: Either.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/Either$Right;", "R", "Lcom/sourcepoint/cmplibrary/core/Either;", "r", "(Ljava/lang/Object;)V", "getR", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/sourcepoint/cmplibrary/core/Either$Right;", "equals", "", "other", "", "hashCode", "", "toString", "", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Right<R> extends Either<R> {
        private final R r;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Right copy$default(Right right, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = right.r;
            }
            return right.copy(obj);
        }

        public final R component1() {
            return this.r;
        }

        public final Right<R> copy(R r) {
            return new Right<>(r);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Right) && Intrinsics.areEqual(this.r, ((Right) other).r);
        }

        public int hashCode() {
            R r = this.r;
            if (r == null) {
                return 0;
            }
            return r.hashCode();
        }

        public String toString() {
            return "Right(r=" + this.r + ")";
        }

        public Right(R r) {
            super(null);
            this.r = r;
        }

        public final R getR() {
            return this.r;
        }
    }

    private Either() {
    }

    /* compiled from: Either.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/Either$Left;", "Lcom/sourcepoint/cmplibrary/core/Either;", "", "t", "", "(Ljava/lang/Throwable;)V", "getT", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Left extends Either {
        private final Throwable t;

        public static /* synthetic */ Left copy$default(Left left, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = left.t;
            }
            return left.copy(th);
        }

        /* renamed from: component1, reason: from getter */
        public final Throwable getT() {
            return this.t;
        }

        public final Left copy(Throwable t) {
            Intrinsics.checkNotNullParameter(t, "t");
            return new Left(t);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Left) && Intrinsics.areEqual(this.t, ((Left) other).t);
        }

        public int hashCode() {
            return this.t.hashCode();
        }

        public String toString() {
            return "Left(t=" + this.t + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Left(Throwable t) {
            super(null);
            Intrinsics.checkNotNullParameter(t, "t");
            this.t = t;
        }

        public final Throwable getT() {
            return this.t;
        }
    }
}
