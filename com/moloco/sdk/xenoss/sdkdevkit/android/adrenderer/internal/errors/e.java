package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class e {

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5835a;

        static {
            int[] iArr = new int[d.values().length];
            try {
                iArr[d.f5834a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[d.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[d.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[d.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[d.g.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[d.h.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[d.i.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[d.j.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[d.k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[d.l.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[d.m.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[d.n.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            f5835a = iArr;
        }
    }

    public static final d a(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        switch (a.f5835a[dVar.ordinal()]) {
            case 1:
                return d.k;
            case 2:
                return d.l;
            case 3:
                return d.m;
            case 4:
                return d.n;
            case 5:
                return d.e;
            case 6:
                return d.k;
            case 7:
                return d.l;
            case 8:
                return d.m;
            case 9:
                return d.n;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                return dVar;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final d b(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        switch (a.f5835a[dVar.ordinal()]) {
            case 1:
                return d.f;
            case 2:
                return d.g;
            case 3:
                return d.h;
            case 4:
                return d.i;
            case 5:
                return d.e;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return dVar;
            case 11:
                return d.f;
            case 12:
                return d.g;
            case 13:
                return d.h;
            case 14:
                return d.i;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
