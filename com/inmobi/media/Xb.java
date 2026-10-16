package com.inmobi.media;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Xb extends WebChromeClient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureDetectorOnGestureListenerC2634ec f2484a;

    public Xb(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec) {
        this.f2484a = gestureDetectorOnGestureListenerC2634ec;
    }

    public static final void a(JsResult result, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.confirm();
    }

    public static final boolean a(View view, MotionEvent motionEvent) {
        return true;
    }

    public static final void b(JsResult result, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.confirm();
    }

    public static final void c(JsResult result, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.cancel();
    }

    @Override // android.webkit.WebChromeClient
    public final Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
        return defaultVideoPoster == null ? Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888) : defaultVideoPoster;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage cm) {
        Intrinsics.checkNotNullParameter(cm, "cm");
        String str = cm.message() + " -- From line " + cm.lineNumber() + " of " + cm.sourceId();
        InterfaceC2971z5 interfaceC2971z5 = this.f2484a.i;
        if (interfaceC2971z5 == null) {
            return true;
        }
        String str2 = GestureDetectorOnGestureListenerC2634ec.a1;
        ((A5) interfaceC2971z5).c(str2, I6.a(str2, "access$getTAG$cp(...)", "Console message:", str));
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        a();
        super.onHideCustomView();
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(result, "result");
        InterfaceC2971z5 interfaceC2971z5 = this.f2484a.i;
        if (interfaceC2971z5 != null) {
            String str = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((A5) interfaceC2971z5).a(str, "jsAlert called with: " + message + url);
        }
        if (!GestureDetectorOnGestureListenerC2634ec.a(this.f2484a, result)) {
            return true;
        }
        Activity fullScreenActivity = this.f2484a.getFullScreenActivity();
        if (fullScreenActivity != null) {
            new AlertDialog.Builder(fullScreenActivity).setMessage(message).setTitle(url).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.inmobi.media.Xb$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Xb.a(result, dialogInterface, i);
                }
            }).setCancelable(false).create().show();
            return true;
        }
        result.cancel();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(result, "result");
        InterfaceC2971z5 interfaceC2971z5 = this.f2484a.i;
        if (interfaceC2971z5 != null) {
            String str = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((A5) interfaceC2971z5).a(str, "jsConfirm called with: " + message + url);
        }
        if (!GestureDetectorOnGestureListenerC2634ec.a(this.f2484a, result)) {
            return true;
        }
        if (this.f2484a.getFullScreenActivity() != null) {
            new AlertDialog.Builder(this.f2484a.getFullScreenActivity()).setMessage(message).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.inmobi.media.Xb$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Xb.b(result, dialogInterface, i);
                }
            }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.inmobi.media.Xb$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Xb.c(result, dialogInterface, i);
                }
            }).create().show();
            return true;
        }
        result.cancel();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(result, "result");
        InterfaceC2971z5 interfaceC2971z5 = this.f2484a.i;
        if (interfaceC2971z5 != null) {
            String str = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((A5) interfaceC2971z5).a(str, "jsPrompt called with: " + message + url);
        }
        if (!GestureDetectorOnGestureListenerC2634ec.a(this.f2484a, result)) {
            return true;
        }
        if (this.f2484a.getFullScreenActivity() != null) {
            return false;
        }
        result.cancel();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        InterfaceC2971z5 interfaceC2971z5 = this.f2484a.i;
        if (interfaceC2971z5 != null) {
            String str = GestureDetectorOnGestureListenerC2634ec.a1;
            ((A5) interfaceC2971z5).c(str, X8.a(str, "access$getTAG$cp(...)", "webview progress changed - ", i));
        }
        super.onProgressChanged(webView, i);
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.f2484a.q.get() != null) {
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2484a;
            gestureDetectorOnGestureListenerC2634ec.O = view;
            gestureDetectorOnGestureListenerC2634ec.P = callback;
            if (view != null) {
                view.setOnTouchListener(new View.OnTouchListener() { // from class: com.inmobi.media.Xb$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view2, MotionEvent motionEvent) {
                        return Xb.a(view2, motionEvent);
                    }
                });
            }
            Activity activity = (Activity) this.f2484a.q.get();
            FrameLayout frameLayout = activity != null ? (FrameLayout) activity.findViewById(R.id.content) : null;
            View view2 = this.f2484a.O;
            if (view2 != null) {
                view2.setBackgroundColor(-16777216);
            }
            if (frameLayout != null) {
                frameLayout.addView(this.f2484a.O, new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
            }
            View view3 = this.f2484a.O;
            if (view3 != null) {
                view3.requestFocus();
            }
            final GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = this.f2484a;
            View view4 = gestureDetectorOnGestureListenerC2634ec2.O;
            View.OnKeyListener onKeyListener = new View.OnKeyListener() { // from class: com.inmobi.media.Xb$$ExternalSyntheticLambda6
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view5, int i, KeyEvent keyEvent) {
                    return Xb.a(GestureDetectorOnGestureListenerC2634ec.this, this, view5, i, keyEvent);
                }
            };
            if (view4 != null) {
                view4.setOnKeyListener(onKeyListener);
            }
            if (view4 != null) {
                view4.setFocusable(true);
            }
            if (view4 != null) {
                view4.setFocusableInTouchMode(true);
            }
            if (view4 != null) {
                view4.requestFocus();
            }
        }
    }

    public static final void b(GeolocationPermissions.Callback callback, String origin, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(origin, "$origin");
        callback.invoke(origin, false, false);
    }

    public static final boolean a(GestureDetectorOnGestureListenerC2634ec this$0, Xb this$1, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        if (4 != keyEvent.getKeyCode() || keyEvent.getAction() != 0) {
            return false;
        }
        InterfaceC2971z5 interfaceC2971z5 = this$0.i;
        if (interfaceC2971z5 != null) {
            String str = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((A5) interfaceC2971z5).a(str, "Back pressed when HTML5 video is playing.");
        }
        this$1.a();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(final String origin, final GeolocationPermissions.Callback callback) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.f2484a.q.get() != null) {
            new AlertDialog.Builder((Context) this.f2484a.q.get()).setTitle("Location Permission").setMessage("Allow location access").setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.inmobi.media.Xb$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Xb.a(callback, origin, dialogInterface, i);
                }
            }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.inmobi.media.Xb$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Xb.b(callback, origin, dialogInterface, i);
                }
            }).create().show();
        }
        super.onGeolocationPermissionsShowPrompt(origin, callback);
    }

    public final void a() {
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2484a;
        if (gestureDetectorOnGestureListenerC2634ec.O == null) {
            return;
        }
        WebChromeClient.CustomViewCallback customViewCallback = gestureDetectorOnGestureListenerC2634ec.P;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = this.f2484a;
        gestureDetectorOnGestureListenerC2634ec2.P = null;
        View view = gestureDetectorOnGestureListenerC2634ec2.O;
        if ((view != null ? view.getParent() : null) != null) {
            View view2 = this.f2484a.O;
            ViewParent parent = view2 != null ? view2.getParent() : null;
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(this.f2484a.O);
            }
            this.f2484a.O = null;
        }
    }

    public static final void a(GeolocationPermissions.Callback callback, String origin, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(origin, "$origin");
        callback.invoke(origin, true, false);
    }
}
