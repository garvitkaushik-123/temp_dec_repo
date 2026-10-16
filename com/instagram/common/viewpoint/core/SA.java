package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.facebook.ads.MediaView;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.NativeBannerAdApi;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import java.util.List;

/* loaded from: assets/audience_network/classes2.dex */
public final class SA implements NativeBannerAdApi {
    public static byte[] A01;
    public static String[] A02 = {"068yMtBHtCdtzUYBTQD9IwnMWW1doBJF", "2l8Hok5ewW", "SqMVYGMc7AyphtDxx4DkXGESiOtqp3Wk", "n7xht10RjuH04nLwyOxbbpbZUJ6bFNP5", "hemUdCIRyaFDmP64bLQtQG29khNbMpFH", "0krrnlsRXu", "j9YMm5Kfv7iMZif7VGfsQGY8YQ9Z0I42", "SiUubuHC3Y"};
    public final UK A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = copyOfRange[i4];
            if (A02[0].charAt(2) != '8') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[2] = "SDJ7CqIuYGJEmotuvG7btG7Q2tCK4c6p";
            strArr[6] = "3TZdd6KNeaSFSkmrHNZK7GULPPfkGOEa";
            copyOfRange[i4] = (byte) ((b - i3) - 50);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-50, -54, -55, -3, -20, -15, -19, -10, -21, -19, -42, -19, -4, -1, -9, -6, -13};
    }

    static {
        A01();
    }

    public SA(NativeAdBaseApi nativeAdBaseApi) {
        this.A00 = UK.A0L(nativeAdBaseApi);
        this.A00.A1i(EnumC1404Vq.A05);
    }

    private void A02(ImageView imageView, NativeAdBaseApi nativeAdBaseApi) {
        UK A0L = UK.A0L(nativeAdBaseApi);
        C1951h4 c1951h4 = new C1951h4(this, imageView, A0L);
        C1391Vb adIcon = A0L.getAdIcon();
        if (adIcon != null) {
            Bitmap A0N = A0L.A14().A0N(adIcon.getUrl());
            Context context = imageView.getContext();
            String[] strArr = A02;
            if (strArr[2].charAt(21) == strArr[6].charAt(21)) {
                A02[4] = "oesEo3u5gOmbsNZfXjsimFyw8pPXYbZZ";
                C1929gi A03 = C1302Rp.A03(context);
                if (A0N != null) {
                    Drawable A05 = UK.A05(A03, A0N, A0L.A1t(), A0L.A1I());
                    UK.A0f(A05, imageView);
                    imageView.post(new C1950h3(this, A0L, A05));
                    return;
                } else {
                    C1951h4 c1951h42 = null;
                    S7 loadImageTask = new S7(A03, c1951h4, A0L.A1t(), c1951h42);
                    loadImageTask.execute(new S9(adIcon.getUrl(), A0L.A1I(), c1951h42));
                    return;
                }
            }
        } else {
            InterfaceC1359Tv A1A = A0L.A1A();
            AdErrorType adErrorType = AdErrorType.NATIVE_AD_IS_NOT_LOADED;
            if (A02[4].charAt(17) != 't') {
                A02[4] = "aFZFEDb6phUkMJAuumeHd9ws0nVx9tBY";
                A0L.A16().A0F().A3N(-1L, adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
                if (A1A != null) {
                    A1A.ADp(C1401Vm.A00(adErrorType));
                }
                Log.e(A00(0, 17, 86), adErrorType.getDefaultErrorMessage());
                return;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.internal.api.NativeBannerAdApi
    public final void registerViewForInteraction(View view, ImageView imageView) {
        registerViewForInteraction(view, imageView, (List<View>) null);
    }

    @Override // com.facebook.ads.internal.api.NativeBannerAdApi
    public final void registerViewForInteraction(View view, ImageView imageView, List<View> list) {
        if (imageView != null) {
            A02(imageView, this.A00);
        }
        if (list != null) {
            UK uk = this.A00;
            if (A02[1].length() != 10) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[5] = "ll9cTRtW3a";
            strArr[7] = "WGLVGgKdvO";
            uk.A1T(view, imageView, list);
            return;
        }
        this.A00.A1S(view, imageView);
    }

    @Override // com.facebook.ads.internal.api.NativeBannerAdApi
    public final void registerViewForInteraction(View view, MediaView mediaView) {
        registerViewForInteraction(view, mediaView, (List<View>) null);
    }

    @Override // com.facebook.ads.internal.api.NativeBannerAdApi
    public final void registerViewForInteraction(View view, MediaView mediaView, List<View> clickableViews) {
        if (mediaView != null) {
            ((C1959hC) mediaView.getMediaViewApi()).A0X(this.A00, true);
        }
        if (clickableViews != null) {
            this.A00.A1W(view, mediaView, clickableViews, true);
        } else {
            this.A00.A1X(view, mediaView, true);
        }
    }
}
