package com.google.android.gms.ads.internal.overlay;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzbde;
import io.bidmachine.rendering.model.EventTaskParams;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzu extends FrameLayout implements View.OnClickListener {
    private final ImageButton zza;
    private final zzah zzb;

    public zzu(Context context, zzt zztVar, zzah zzahVar) {
        super(context);
        this.zzb = zzahVar;
        setOnClickListener(this);
        ImageButton imageButton = new ImageButton(context);
        this.zza = imageButton;
        zzc();
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(this);
        zzbb.zzb();
        int zzC = com.google.android.gms.ads.internal.util.client.zzf.zzC(context, zztVar.zza);
        zzbb.zzb();
        int zzC2 = com.google.android.gms.ads.internal.util.client.zzf.zzC(context, 0);
        zzbb.zzb();
        int zzC3 = com.google.android.gms.ads.internal.util.client.zzf.zzC(context, zztVar.zzb);
        zzbb.zzb();
        imageButton.setPadding(zzC, zzC2, zzC3, com.google.android.gms.ads.internal.util.client.zzf.zzC(context, zztVar.zzc));
        imageButton.setContentDescription("Interstitial close button");
        zzbb.zzb();
        int zzC4 = com.google.android.gms.ads.internal.util.client.zzf.zzC(context, zztVar.zzd + zztVar.zza + zztVar.zzb);
        zzbb.zzb();
        addView(imageButton, new FrameLayout.LayoutParams(zzC4, com.google.android.gms.ads.internal.util.client.zzf.zzC(context, zztVar.zzd + zztVar.zzc), 17));
        long longValue = ((Long) zzbd.zzc().zzb(zzbde.zzbp)).longValue();
        if (longValue <= 0) {
            return;
        }
        zzs zzsVar = ((Boolean) zzbd.zzc().zzb(zzbde.zzbq)).booleanValue() ? new zzs(this) : null;
        imageButton.setAlpha(0.0f);
        imageButton.animate().alpha(1.0f).setDuration(longValue).setListener(zzsVar);
    }

    private final void zzc() {
        String str = (String) zzbd.zzc().zzb(zzbde.zzbo);
        if (!PlatformVersion.isAtLeastLollipop() || TextUtils.isEmpty(str) || EventTaskParams.STATE_GROUP_DEFAULT.equals(str)) {
            this.zza.setImageResource(R.drawable.btn_dialog);
            return;
        }
        Resources zze = com.google.android.gms.ads.internal.zzv.zzp().zze();
        if (zze == null) {
            this.zza.setImageResource(R.drawable.btn_dialog);
            return;
        }
        Drawable drawable = null;
        try {
            if ("white".equals(str)) {
                drawable = zze.getDrawable(com.google.android.gms.ads.impl.R.drawable.admob_close_button_white_circle_black_cross);
            } else if ("black".equals(str)) {
                drawable = zze.getDrawable(com.google.android.gms.ads.impl.R.drawable.admob_close_button_black_circle_white_cross);
            }
        } catch (Resources.NotFoundException unused) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Close button resource not found, falling back to default.");
        }
        if (drawable == null) {
            this.zza.setImageResource(R.drawable.btn_dialog);
            return;
        }
        ImageButton imageButton = this.zza;
        imageButton.setImageDrawable(drawable);
        imageButton.setScaleType(ImageView.ScaleType.CENTER);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zzah zzahVar = this.zzb;
        if (zzahVar != null) {
            zzahVar.zzj();
        }
    }

    public final void zzb(boolean z) {
        if (!z) {
            this.zza.setVisibility(0);
            return;
        }
        ImageButton imageButton = this.zza;
        imageButton.setVisibility(8);
        if (((Long) zzbd.zzc().zzb(zzbde.zzbp)).longValue() > 0) {
            imageButton.animate().cancel();
            imageButton.clearAnimation();
        }
    }
}
