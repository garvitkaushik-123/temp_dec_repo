package com.mbridge.msdk.dycreator.subjectfactory;

import com.mbridge.msdk.dycreator.viewobserver.c;
import com.mbridge.msdk.dycreator.viewobserver.d;
import com.mbridge.msdk.dycreator.viewobserver.f;
import com.mbridge.msdk.dycreator.viewobserver.h;

/* compiled from: SubjectFactory.java */
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f4173a;

    /* compiled from: SubjectFactory.java */
    /* renamed from: com.mbridge.msdk.dycreator.subjectfactory.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0325a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4174a;

        static {
            int[] iArr = new int[b.values().length];
            f4174a = iArr;
            try {
                iArr[b.VIEW_OBSERVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4174a[b.CLICK_OBSERVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4174a[b.EFFECT_OBSERVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4174a[b.REPORT_OBSERVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: SubjectFactory.java */
    public enum b {
        VIEW_OBSERVER,
        CLICK_OBSERVER,
        EFFECT_OBSERVER,
        REPORT_OBSERVER
    }

    private a() {
    }

    public static a a() {
        if (f4173a == null) {
            synchronized (a.class) {
                if (f4173a == null) {
                    f4173a = new a();
                }
            }
        }
        return f4173a;
    }

    public <T extends com.mbridge.msdk.dycreator.viewobserver.a> T a(b bVar) {
        int i = C0325a.f4174a[bVar.ordinal()];
        if (i == 1) {
            return new d();
        }
        if (i == 2) {
            return new c();
        }
        if (i == 3) {
            return new f();
        }
        if (i != 4) {
            return null;
        }
        return new h();
    }
}
