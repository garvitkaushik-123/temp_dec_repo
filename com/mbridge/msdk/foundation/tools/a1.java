package com.mbridge.msdk.foundation.tools;

import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.ironsource.C3040d4;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.ktor.http.ContentDisposition;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TouchEventReporter.java */
/* loaded from: classes6.dex */
public class a1 {

    /* compiled from: TouchEventReporter.java */
    class a implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        JSONArray f4350a = new JSONArray();
        final /* synthetic */ View b;
        final /* synthetic */ String c;
        final /* synthetic */ View.OnTouchListener d;

        a(View view, String str, View.OnTouchListener onTouchListener) {
            this.b = view;
            this.c = str;
            this.d = onTouchListener;
        }

        private void a() {
            this.f4350a = new JSONArray();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                a1.b(this.f4350a, motionEvent);
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                a();
                a1.b(this.f4350a, motionEvent);
                a1.b(this.b, motionEvent, this.f4350a, this.c);
            } else if (actionMasked == 1) {
                a1.b(this.b, motionEvent, this.f4350a, this.c);
                a();
            } else if (actionMasked == 3) {
                a();
            }
            View.OnTouchListener onTouchListener = this.d;
            if (onTouchListener == null) {
                return false;
            }
            onTouchListener.onTouch(view, motionEvent);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(View view, MotionEvent motionEvent, JSONArray jSONArray, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("targetView", a(view, motionEvent));
            jSONObject.put("eventList", jSONArray);
        } catch (JSONException e) {
            Log.e("TouchEventReporter", "JSON build error", e);
        }
        com.mbridge.msdk.foundation.same.report.metrics.c b = com.mbridge.msdk.foundation.same.report.metrics.d.b().b(str);
        if (b != null) {
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("eventList", jSONObject);
            b.b("m_check_local_c", eVar);
        }
    }

    public static void a(View view, String str, int i) {
        a(view, str, i, (View.OnTouchListener) null);
    }

    public static void a(View view, String str, int i, View.OnTouchListener onTouchListener) {
        if (i != 0) {
            if (view == null) {
                return;
            }
            view.setOnTouchListener(new a(view, str, onTouchListener));
            return;
        }
        try {
            com.mbridge.msdk.foundation.same.report.metrics.c b = com.mbridge.msdk.foundation.same.report.metrics.d.b().b(str);
            if (b != null) {
                b.a(b.o() + "m_check_local_c");
            }
        } catch (Exception e) {
            p0.b("TouchEventReporter", e.getMessage());
        }
        if (onTouchListener == null || view == null) {
            return;
        }
        view.setOnTouchListener(onTouchListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(JSONArray jSONArray, MotionEvent motionEvent) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C3040d4.h.j0, a(motionEvent));
            jSONObject.put("eventTime", String.valueOf(motionEvent.getEventTime()));
            jSONObject.put("downTime", String.valueOf(motionEvent.getDownTime()));
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < motionEvent.getPointerCount(); i++) {
                JSONObject jSONObject2 = new JSONObject();
                if (Build.VERSION.SDK_INT >= 29) {
                    jSONObject2.put(VastAttributes.HORIZONTAL_POSITION, String.valueOf(motionEvent.getRawX(i)));
                    jSONObject2.put(VastAttributes.VERTICAL_POSITION, String.valueOf(motionEvent.getRawY(i)));
                } else {
                    jSONObject2.put(VastAttributes.HORIZONTAL_POSITION, String.valueOf(motionEvent.getRawX()));
                    jSONObject2.put(VastAttributes.VERTICAL_POSITION, String.valueOf(motionEvent.getRawY()));
                }
                jSONObject2.put("pressure", String.valueOf(motionEvent.getPressure(i)));
                jSONObject2.put(ContentDisposition.Parameters.Size, String.valueOf(motionEvent.getSize(i)));
                jSONObject2.put("id", motionEvent.getPointerId(i));
                jSONArray2.put(jSONObject2);
            }
            jSONObject.put("point", jSONArray2);
            jSONArray.put(jSONObject);
        } catch (Exception e) {
            Log.e("TouchEventReporter", "collectEvent JSON error", e);
        }
    }

    private static String a(View view, MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (view instanceof ViewGroup) {
            view = a((ViewGroup) view, (int) rawX, (int) rawY);
        }
        return a(view);
    }

    private static String a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            return "down";
        }
        if (actionMasked == 1) {
            return "up";
        }
        if (actionMasked == 2) {
            return "move";
        }
        if (actionMasked == 3) {
            return "cancel";
        }
        if (actionMasked == 5) {
            return "pointer_down_" + motionEvent.getPointerId(motionEvent.getActionIndex());
        }
        if (actionMasked != 6) {
            return "other_" + motionEvent.getActionMasked();
        }
        return "pointer_up_" + motionEvent.getPointerId(motionEvent.getActionIndex());
    }

    private static View a(ViewGroup viewGroup, int i, int i2) {
        View a2;
        int[] iArr = new int[2];
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getLocationOnScreen(iArr);
                int i3 = iArr[0];
                int i4 = iArr[1];
                int width = childAt.getWidth() + i3;
                int height = childAt.getHeight() + i4;
                if (i >= i3 && i <= width && i2 >= i4 && i2 <= height) {
                    return (!(childAt instanceof ViewGroup) || (a2 = a((ViewGroup) childAt, i, i2)) == null) ? childAt : a2;
                }
            }
        }
        return viewGroup;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(View view) {
        String str;
        if (view == null) {
            return "UnknownView";
        }
        if (view.getId() != -1) {
            str = view.getResources().getResourceEntryName(view.getId());
            return view.getClass().getSimpleName() + "#" + str + "#" + (view.getContentDescription() != null ? view.getContentDescription().toString() : "");
        }
        str = "";
        return view.getClass().getSimpleName() + "#" + str + "#" + (view.getContentDescription() != null ? view.getContentDescription().toString() : "");
    }
}
