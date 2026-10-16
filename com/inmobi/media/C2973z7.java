package com.inmobi.media;

import android.view.MotionEvent;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.inmobi.media.z7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2973z7 {

    /* renamed from: a, reason: collision with root package name */
    public final GestureDetectorOnGestureListenerC2634ec f2772a;
    public final String b;
    public float c;
    public float d;
    public float e;
    public float f;
    public int g;
    public int h;
    public float i;
    public JSONArray j;
    public MotionEvent k;
    public int l;

    public C2973z7(GestureDetectorOnGestureListenerC2634ec mListener) {
        Intrinsics.checkNotNullParameter(mListener, "mListener");
        this.f2772a = mListener;
        this.b = "z7";
        this.l = Integer.MAX_VALUE;
        this.g = -1;
        this.h = -1;
    }

    public final void a(MotionEvent endEvent) {
        float f;
        float f2;
        float f3;
        Intrinsics.checkNotNullParameter(endEvent, "event");
        int actionMasked = endEvent.getActionMasked();
        if (actionMasked == 0) {
            String TAG = this.b;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            endEvent.toString();
            this.g = endEvent.getPointerId(endEvent.getActionIndex());
            this.j = new JSONArray();
            JSONArray jSONArray = new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(B2.c(endEvent.getX())), Integer.valueOf(B2.c(endEvent.getY()))}));
            JSONArray jSONArray2 = this.j;
            if (jSONArray2 != null) {
                jSONArray2.put(jSONArray);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            String TAG2 = this.b;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            endEvent.toString();
            this.g = -1;
            JSONArray jSONArray3 = this.j;
            if (jSONArray3 == null || jSONArray3.length() <= 5) {
                return;
            }
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2772a;
            Intrinsics.checkNotNullParameter(this, "movementGestureDetector");
            if (gestureDetectorOnGestureListenerC2634ec.e || !gestureDetectorOnGestureListenerC2634ec.getRenderingConfig().getSupportedGestures().contains(2)) {
                InterfaceC2971z5 interfaceC2971z5 = gestureDetectorOnGestureListenerC2634ec.i;
                if (interfaceC2971z5 != null) {
                    String TAG3 = GestureDetectorOnGestureListenerC2634ec.a1;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    ((A5) interfaceC2971z5).c(TAG3, "Pan gesture is disabled from config");
                }
            } else {
                InterfaceC2971z5 interfaceC2971z52 = gestureDetectorOnGestureListenerC2634ec.i;
                if (interfaceC2971z52 != null) {
                    String str = GestureDetectorOnGestureListenerC2634ec.a1;
                    StringBuilder a2 = H6.a(str, "TAG", "onPanDetected\n ");
                    JSONArray jSONArray4 = this.j;
                    ((A5) interfaceC2971z52).a(str, StringsKt.trimIndent(a2.append(jSONArray4 != null ? Integer.valueOf(jSONArray4.length()) : null).append(" \n ").append(this.j).toString()));
                }
                gestureDetectorOnGestureListenerC2634ec.c("window.imraidview.onGestureDetected('2', '" + this.j + "');");
            }
            this.j = new JSONArray();
            return;
        }
        if (actionMasked == 2) {
            float f4 = 0.0f;
            JSONArray jSONArray5 = this.j;
            int i = this.g;
            if (i == -1 || this.h == -1) {
                if (i == -1 || jSONArray5 == null || jSONArray5.length() <= 0 || jSONArray5.length() >= 50) {
                    return;
                }
                try {
                    int c = B2.c(endEvent.getX());
                    int c2 = B2.c(endEvent.getY());
                    JSONArray jSONArray6 = jSONArray5.getJSONArray(jSONArray5.length() - 1);
                    JSONArray jSONArray7 = new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(c), Integer.valueOf(c2)}));
                    float f5 = jSONArray6.getInt(0) - jSONArray7.getInt(0);
                    float f6 = jSONArray6.getInt(1) - jSONArray7.getInt(1);
                    if (((int) Math.sqrt((f6 * f6) + (f5 * f5))) > 100) {
                        jSONArray5.put(jSONArray7);
                        return;
                    }
                    return;
                } catch (JSONException unused) {
                    return;
                }
            }
            int findPointerIndex = endEvent.findPointerIndex(i);
            int findPointerIndex2 = endEvent.findPointerIndex(this.h);
            if (findPointerIndex >= 0) {
                f2 = endEvent.getX(findPointerIndex);
                f = endEvent.getY(findPointerIndex);
            } else {
                S5 s5 = S5.f2425a;
                C2640f2 event = new C2640f2(new IllegalArgumentException("Index for mPtrID1=" + this.g + " is " + findPointerIndex + " | Pointer count=" + endEvent.getPointerCount()));
                Intrinsics.checkNotNullParameter(event, "event");
                S5.d.a(event);
                f = 0.0f;
                f2 = 0.0f;
            }
            if (findPointerIndex2 >= 0) {
                float x = endEvent.getX(findPointerIndex2);
                f4 = endEvent.getY(findPointerIndex2);
                f3 = x;
            } else {
                S5 s52 = S5.f2425a;
                C2640f2 event2 = new C2640f2(new IllegalArgumentException("Index for mPtrID1=" + this.h + " is " + findPointerIndex2 + " | Pointer count=" + endEvent.getPointerCount()));
                Intrinsics.checkNotNullParameter(event2, "event");
                S5.d.a(event2);
                f3 = 0.0f;
            }
            float degrees = ((float) Math.toDegrees(((float) Math.atan2(this.d - this.f, this.c - this.e)) - ((float) Math.atan2(f4 - f, f3 - f2)))) % 360;
            if (degrees < -180.0f) {
                degrees += 360.0f;
            }
            if (degrees > 180.0f) {
                degrees -= 360.0f;
            }
            this.i = Math.abs(degrees);
            return;
        }
        if (actionMasked == 3) {
            String TAG4 = this.b;
            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
            endEvent.toString();
            this.g = -1;
            this.h = -1;
            return;
        }
        if (actionMasked == 5) {
            String TAG5 = this.b;
            Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
            endEvent.toString();
            this.h = endEvent.getPointerId(endEvent.getActionIndex());
            this.k = MotionEvent.obtain(endEvent);
            int findPointerIndex3 = endEvent.findPointerIndex(this.g);
            int findPointerIndex4 = endEvent.findPointerIndex(this.h);
            if (findPointerIndex3 >= 0) {
                this.e = endEvent.getX(findPointerIndex3);
                this.f = endEvent.getY(findPointerIndex3);
            } else {
                S5 s53 = S5.f2425a;
                C2640f2 event3 = new C2640f2(new IllegalArgumentException("Index for mPtrID1=" + this.g + " is " + findPointerIndex3 + " | Pointer count=" + endEvent.getPointerCount()));
                Intrinsics.checkNotNullParameter(event3, "event");
                S5.d.a(event3);
            }
            if (findPointerIndex4 >= 0) {
                this.c = endEvent.getX(findPointerIndex4);
                this.d = endEvent.getY(findPointerIndex4);
            } else {
                S5 s54 = S5.f2425a;
                C2640f2 event4 = new C2640f2(new IllegalArgumentException("Index for mPtrID2=" + this.h + " is " + findPointerIndex4 + " | Pointer count=" + endEvent.getPointerCount()));
                Intrinsics.checkNotNullParameter(event4, "event");
                S5.d.a(event4);
            }
            float f7 = this.e - this.c;
            float f8 = this.f - this.d;
            this.l = (int) Math.sqrt((f8 * f8) + (f7 * f7));
            return;
        }
        if (actionMasked != 6) {
            return;
        }
        String TAG6 = this.b;
        Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
        endEvent.toString();
        this.h = -1;
        if (this.i > 30.0f) {
            MotionEvent initialEvent = this.k;
            if (initialEvent != null) {
                GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = this.f2772a;
                Intrinsics.checkNotNullParameter(this, "movementGestureDetector");
                Intrinsics.checkNotNullParameter(initialEvent, "initialEvent");
                Intrinsics.checkNotNullParameter(endEvent, "endEvent");
                if (gestureDetectorOnGestureListenerC2634ec2.e || !gestureDetectorOnGestureListenerC2634ec2.getRenderingConfig().getSupportedGestures().contains(3)) {
                    InterfaceC2971z5 interfaceC2971z53 = gestureDetectorOnGestureListenerC2634ec2.i;
                    if (interfaceC2971z53 != null) {
                        String TAG7 = GestureDetectorOnGestureListenerC2634ec.a1;
                        Intrinsics.checkNotNullExpressionValue(TAG7, "TAG");
                        ((A5) interfaceC2971z53).c(TAG7, "Rotation gesture is disabled from config");
                    }
                } else {
                    InterfaceC2971z5 interfaceC2971z54 = gestureDetectorOnGestureListenerC2634ec2.i;
                    if (interfaceC2971z54 != null) {
                        String str2 = GestureDetectorOnGestureListenerC2634ec.a1;
                        ((A5) interfaceC2971z54).a(str2, StringsKt.trimIndent(H6.a(str2, "TAG", " Rotation detected ").append(this.i).append(" \n ").append(initialEvent).append(" \n ").append(endEvent).toString()));
                    }
                    JSONArray jSONArray8 = new JSONArray();
                    jSONArray8.put(new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(B2.c(initialEvent.getX())), Integer.valueOf(B2.c(initialEvent.getY()))})));
                    jSONArray8.put(new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(B2.c(initialEvent.getX(1))), Integer.valueOf(B2.c(initialEvent.getY(1)))})));
                    jSONArray8.put(new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(B2.c(endEvent.getX())), Integer.valueOf(B2.c(endEvent.getY()))})));
                    jSONArray8.put(new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(B2.c(endEvent.getX(1))), Integer.valueOf(B2.c(endEvent.getY(1)))})));
                    gestureDetectorOnGestureListenerC2634ec2.c("window.imraidview.onGestureDetected('3', '" + jSONArray8 + "');");
                }
            }
            this.i = 0.0f;
        }
        float x2 = endEvent.getX() - endEvent.getX(1);
        float y = endEvent.getY() - endEvent.getY(1);
        if (Math.abs(((int) Math.sqrt((y * y) + (x2 * x2))) - this.l) > 500) {
            MotionEvent initialEvent2 = this.k;
            if (initialEvent2 != null) {
                GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec3 = this.f2772a;
                Intrinsics.checkNotNullParameter(this, "movementGestureDetector");
                Intrinsics.checkNotNullParameter(initialEvent2, "initialEvent");
                Intrinsics.checkNotNullParameter(endEvent, "endEvent");
                if (gestureDetectorOnGestureListenerC2634ec3.e || !gestureDetectorOnGestureListenerC2634ec3.getRenderingConfig().getSupportedGestures().contains(4)) {
                    InterfaceC2971z5 interfaceC2971z55 = gestureDetectorOnGestureListenerC2634ec3.i;
                    if (interfaceC2971z55 != null) {
                        String TAG8 = GestureDetectorOnGestureListenerC2634ec.a1;
                        Intrinsics.checkNotNullExpressionValue(TAG8, "TAG");
                        ((A5) interfaceC2971z55).c(TAG8, "Pinch gesture is disabled from config");
                    }
                } else {
                    InterfaceC2971z5 interfaceC2971z56 = gestureDetectorOnGestureListenerC2634ec3.i;
                    if (interfaceC2971z56 != null) {
                        String TAG9 = GestureDetectorOnGestureListenerC2634ec.a1;
                        Intrinsics.checkNotNullExpressionValue(TAG9, "TAG");
                        ((A5) interfaceC2971z56).a(TAG9, StringsKt.trimIndent(" onScaleDetected\n " + initialEvent2 + " \n " + endEvent));
                    }
                    JSONArray jSONArray9 = new JSONArray();
                    float f9 = 2;
                    jSONArray9.put(new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(B2.c((endEvent.getX(1) + endEvent.getX()) / f9)), Integer.valueOf(B2.c((endEvent.getY(1) + endEvent.getY()) / f9))})));
                    gestureDetectorOnGestureListenerC2634ec3.c("window.imraidview.onGestureDetected('4', '" + jSONArray9 + "');");
                }
            }
            this.l = Integer.MAX_VALUE;
        }
    }
}
