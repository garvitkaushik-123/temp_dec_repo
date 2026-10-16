package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcqm extends FrameLayout implements ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalLayoutListener {
    private final Context zza;
    private View zzb;

    private zzcqm(Context context) {
        super(context);
        this.zza = context;
    }

    public static zzcqm zza(Context context, View view, zzfca zzfcaVar) {
        Resources resources;
        DisplayMetrics displayMetrics;
        zzcqm zzcqmVar = new zzcqm(context);
        List list = zzfcaVar.zzu;
        if (!list.isEmpty() && (resources = zzcqmVar.zza.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            zzfcb zzfcbVar = (zzfcb) list.get(0);
            zzcqmVar.setLayoutParams(new FrameLayout.LayoutParams((int) (zzfcbVar.zza * displayMetrics.density), (int) (zzfcbVar.zzb * displayMetrics.density)));
        }
        zzcqmVar.zzb = view;
        zzcqmVar.addView(view);
        com.google.android.gms.ads.internal.zzv.zzz();
        zzcas.zzb(zzcqmVar, zzcqmVar);
        com.google.android.gms.ads.internal.zzv.zzz();
        zzcas.zza(zzcqmVar, zzcqmVar);
        JSONObject jSONObject = zzfcaVar.zzah;
        RelativeLayout relativeLayout = new RelativeLayout(zzcqmVar.zza);
        JSONObject optJSONObject = jSONObject.optJSONObject("header");
        if (optJSONObject != null) {
            zzcqmVar.zzc(optJSONObject, relativeLayout, 10);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("footer");
        if (optJSONObject2 != null) {
            zzcqmVar.zzc(optJSONObject2, relativeLayout, 12);
        }
        zzcqmVar.addView(relativeLayout);
        return zzcqmVar;
    }

    private final int zzb(double d) {
        com.google.android.gms.ads.internal.client.zzbb.zzb();
        return com.google.android.gms.ads.internal.util.client.zzf.zzC(this.zza, (int) d);
    }

    private final void zzc(JSONObject jSONObject, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(this.zza);
        textView.setTextColor(-1);
        textView.setBackgroundColor(-16777216);
        textView.setGravity(17);
        textView.setText(jSONObject.optString("text", ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int zzb = zzb(jSONObject.optDouble(VastAttributes.PADDING, 0.0d));
        textView.setPadding(0, zzb, 0, zzb);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzb(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i);
        relativeLayout.addView(textView, layoutParams);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        getLocationInWindow(new int[2]);
        this.zzb.setY(-r0[1]);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        getLocationInWindow(new int[2]);
        this.zzb.setY(-r0[1]);
    }
}
