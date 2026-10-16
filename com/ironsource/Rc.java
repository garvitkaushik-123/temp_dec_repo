package com.ironsource;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Rc {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3032a;
    private String b;
    private boolean c;
    private int d;
    private int[] e;
    private int[] f;

    public Rc() {
        this(false, null, false, 0, null, null, 63, null);
    }

    public final boolean a() {
        return this.f3032a;
    }

    public final String b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final int[] e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rc)) {
            return false;
        }
        Rc rc = (Rc) obj;
        return this.f3032a == rc.f3032a && Intrinsics.areEqual(this.b, rc.b) && this.c == rc.c && this.d == rc.d && Intrinsics.areEqual(this.e, rc.e) && Intrinsics.areEqual(this.f, rc.f);
    }

    public final int[] f() {
        return this.f;
    }

    public final boolean g() {
        return this.c;
    }

    public final int h() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        boolean z = this.f3032a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = ((r0 * 31) + this.b.hashCode()) * 31;
        boolean z2 = this.c;
        int hashCode2 = (((hashCode + (z2 ? 1 : z2 ? 1 : 0)) * 31) + Integer.hashCode(this.d)) * 31;
        int[] iArr = this.e;
        int hashCode3 = (hashCode2 + (iArr == null ? 0 : Arrays.hashCode(iArr))) * 31;
        int[] iArr2 = this.f;
        return hashCode3 + (iArr2 != null ? Arrays.hashCode(iArr2) : 0);
    }

    public final boolean i() {
        return this.f3032a;
    }

    public final String j() {
        return this.b;
    }

    public final int[] k() {
        return this.f;
    }

    public final int[] l() {
        return this.e;
    }

    public String toString() {
        return "PixelSettings(pixelEventsEnabled=" + this.f3032a + ", pixelEventsUrl=" + this.b + ", pixelEventsCompression=" + this.c + ", pixelEventsCompressionLevel=" + this.d + ", pixelOptOut=" + Arrays.toString(this.e) + ", pixelOptIn=" + Arrays.toString(this.f) + ")";
    }

    public Rc(boolean z, String pixelEventsUrl, boolean z2, int i, int[] iArr, int[] iArr2) {
        Intrinsics.checkNotNullParameter(pixelEventsUrl, "pixelEventsUrl");
        this.f3032a = z;
        this.b = pixelEventsUrl;
        this.c = z2;
        this.d = i;
        this.e = iArr;
        this.f = iArr2;
    }

    public final Rc a(boolean z, String pixelEventsUrl, boolean z2, int i, int[] iArr, int[] iArr2) {
        Intrinsics.checkNotNullParameter(pixelEventsUrl, "pixelEventsUrl");
        return new Rc(z, pixelEventsUrl, z2, i, iArr, iArr2);
    }

    public final void b(boolean z) {
        this.f3032a = z;
    }

    public static /* synthetic */ Rc a(Rc rc, boolean z, String str, boolean z2, int i, int[] iArr, int[] iArr2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = rc.f3032a;
        }
        if ((i2 & 2) != 0) {
            str = rc.b;
        }
        if ((i2 & 4) != 0) {
            z2 = rc.c;
        }
        if ((i2 & 8) != 0) {
            i = rc.d;
        }
        if ((i2 & 16) != 0) {
            iArr = rc.e;
        }
        if ((i2 & 32) != 0) {
            iArr2 = rc.f;
        }
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        return rc.a(z, str, z2, i, iArr3, iArr4);
    }

    public final void b(int[] iArr) {
        this.e = iArr;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void a(int[] iArr) {
        this.f = iArr;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ Rc(boolean r2, java.lang.String r3, boolean r4, int r5, int[] r6, int[] r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L5
            r2 = 1
        L5:
            r9 = r8 & 2
            if (r9 == 0) goto Lb
            java.lang.String r3 = "https://o-sdk.mediation.unity3d.com/mediation?adUnit=3"
        Lb:
            r9 = r8 & 4
            if (r9 == 0) goto L10
            r4 = 0
        L10:
            r9 = r8 & 8
            if (r9 == 0) goto L15
            r5 = -1
        L15:
            r9 = r8 & 16
            r0 = 0
            if (r9 == 0) goto L1b
            r6 = r0
        L1b:
            r8 = r8 & 32
            if (r8 == 0) goto L27
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L2e
        L27:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L2e:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.Rc.<init>(boolean, java.lang.String, boolean, int, int[], int[], int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
