package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.7N, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class C7N extends AbstractC1977hU {
    public static String[] A02 = {"ZvwGPtqIyq", "yiAZi4T0ry", "MW2e2TOPDP9pjEe4rTD", "HlrRgmhjIEURNOsi3rdB558cP", "dU7euze3hj2U1ev62XjIRTQ2vrQriAnf", "8gl08jl5gi3EpiFcU", "SXjkVQ4wGxN0zpwvt09Xfw5qzXSeRw0d", "Y5nQdyuIxyo1Orqk0oN6DnQ8XCev4LBn"};
    public AbstractC1273Qm A00;
    public AbstractC1273Qm A01;

    private int A00(R2 r2, View view, AbstractC1273Qm abstractC1273Qm) {
        int containerCenter;
        int A0F = abstractC1273Qm.A0F(view) + (abstractC1273Qm.A0D(view) / 2);
        if (r2.A1V()) {
            int A0A = abstractC1273Qm.A0A();
            int childCenter = abstractC1273Qm.A0B();
            containerCenter = A0A + (childCenter / 2);
        } else {
            int childCenter2 = abstractC1273Qm.A06();
            containerCenter = childCenter2 / 2;
        }
        return A0F - containerCenter;
    }

    private View A01(R2 r2, AbstractC1273Qm abstractC1273Qm) {
        int i;
        int A0Y = r2.A0Y();
        if (A0Y == 0) {
            return null;
        }
        View view = null;
        if (r2.A1V()) {
            int A0A = abstractC1273Qm.A0A();
            int childCount = abstractC1273Qm.A0B();
            i = A0A + (childCount / 2);
        } else {
            int childCount2 = abstractC1273Qm.A06();
            i = childCount2 / 2;
        }
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < A0Y; i3++) {
            View A0v = r2.A0v(i3);
            int A0F = abstractC1273Qm.A0F(A0v);
            int childCount3 = abstractC1273Qm.A0D(A0v);
            int childCount4 = Math.abs((A0F + (childCount3 / 2)) - i);
            if (childCount4 < i2) {
                i2 = childCount4;
                String[] strArr = A02;
                String str = strArr[0];
                String str2 = strArr[1];
                int length = str.length();
                int childCount5 = str2.length();
                if (length != childCount5) {
                    throw new RuntimeException();
                }
                A02[5] = "j4bRVUHHACnikA";
                view = A0v;
            }
        }
        return view;
    }

    private View A02(R2 r2, AbstractC1273Qm abstractC1273Qm) {
        int A0Y = r2.A0Y();
        if (A0Y == 0) {
            return null;
        }
        View view = null;
        int i = Integer.MAX_VALUE;
        if (A02[7].charAt(21) == '9') {
            throw new RuntimeException();
        }
        A02[7] = "DwjJFjjR1ioErHTPj2QZ0AbXqU5bWHnc";
        for (int childCount = 0; childCount < A0Y; childCount++) {
            View A0v = r2.A0v(childCount);
            int A0F = abstractC1273Qm.A0F(A0v);
            if (A0F < i) {
                i = A0F;
                view = A0v;
            }
        }
        return view;
    }

    private AbstractC1273Qm A03(R2 r2) {
        if (this.A00 == null || this.A00.A02 != r2) {
            this.A00 = AbstractC1273Qm.A00(r2);
        }
        return this.A00;
    }

    private AbstractC1273Qm A04(R2 r2) {
        if (this.A01 == null || this.A01.A02 != r2) {
            this.A01 = AbstractC1273Qm.A01(r2);
        }
        return this.A01;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.instagram.common.viewpoint.core.AbstractC1977hU
    public final int A0C(R2 r2, int i, int i2) {
        int A0r;
        int centerPosition;
        int A0b = r2.A0b();
        if (A0b == 0) {
            return -1;
        }
        View view = null;
        if (r2.A23()) {
            view = A02(r2, A04(r2));
        } else if (r2.A22()) {
            view = A02(r2, A03(r2));
        }
        if (view == null || (A0r = r2.A0r(view)) == -1) {
            return -1;
        }
        if (r2.A22()) {
            centerPosition = i > 0 ? 1 : 0;
        } else {
            centerPosition = i2 > 0 ? 1 : 0;
        }
        boolean z = false;
        if (r2 instanceof RE) {
            int itemCount = A0b - 1;
            PointF A56 = ((RE) r2).A56(itemCount);
            if (A56 != null) {
                z = A56.x < 0.0f || A56.y < 0.0f;
            }
        }
        return z ? centerPosition != 0 ? A0r - 1 : A0r : centerPosition != 0 ? A0r + 1 : A0r;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1977hU
    public final View A0D(R2 r2) {
        if (r2.A23()) {
            return A01(r2, A04(r2));
        }
        if (r2.A22()) {
            View A01 = A01(r2, A03(r2));
            if (A02[4].charAt(24) != 'v') {
                throw new RuntimeException();
            }
            A02[5] = "ku3zp";
            return A01;
        }
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1977hU
    public final C1998hq A0E(R2 r2) {
        if (!(r2 instanceof RE)) {
            return null;
        }
        final Context context = super.A00.getContext();
        return new C1998hq(context) { // from class: com.facebook.ads.redexgen.X.7O
            @Override // com.instagram.common.viewpoint.core.C1998hq, com.instagram.common.viewpoint.core.RF
            public final void A0I(View view, RH rh, RD rd) {
                int[] A0H = C7N.this.A0H(((AbstractC1977hU) C7N.this).A00.getLayoutManager(), view);
                int time = A0H[0];
                int dy = A0H[1];
                int dx = A0M(Math.max(Math.abs(time), Math.abs(dy)));
                if (dx > 0) {
                    rd.A04(time, dy, dx, ((C1998hq) this).A04);
                }
            }

            @Override // com.instagram.common.viewpoint.core.C1998hq
            public final float A0J(DisplayMetrics displayMetrics) {
                return 100.0f / displayMetrics.densityDpi;
            }

            @Override // com.instagram.common.viewpoint.core.C1998hq
            public final int A0L(int i) {
                return Math.min(100, super.A0L(i));
            }
        };
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1977hU
    public final int[] A0H(R2 r2, View view) {
        int[] iArr = new int[2];
        if (r2.A22()) {
            iArr[0] = A00(r2, view, A03(r2));
        } else {
            iArr[0] = 0;
        }
        if (r2.A23()) {
            iArr[1] = A00(r2, view, A04(r2));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }
}
