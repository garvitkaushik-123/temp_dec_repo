package com.fyber.inneractive.sdk.bidder;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;

/* loaded from: classes4.dex */
public abstract class h {
    public static TokenParametersOuterClass$TokenParameters.NullableString a(String str) {
        y newBuilder = TokenParametersOuterClass$TokenParameters.NullableString.newBuilder();
        if (!TextUtils.isEmpty(str)) {
            newBuilder.c();
            ((TokenParametersOuterClass$TokenParameters.NullableString) newBuilder.b).setData(str);
        }
        return (TokenParametersOuterClass$TokenParameters.NullableString) newBuilder.a();
    }

    public static TokenParametersOuterClass$TokenParameters.NullableBool a(Boolean bool) {
        v newBuilder = TokenParametersOuterClass$TokenParameters.NullableBool.newBuilder();
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            newBuilder.c();
            ((TokenParametersOuterClass$TokenParameters.NullableBool) newBuilder.b).setData(booleanValue);
        }
        return (TokenParametersOuterClass$TokenParameters.NullableBool) newBuilder.a();
    }

    public static TokenParametersOuterClass$TokenParameters.NullableUInt32 a(int i) {
        z newBuilder = TokenParametersOuterClass$TokenParameters.NullableUInt32.newBuilder();
        if (i > 0) {
            newBuilder.c();
            ((TokenParametersOuterClass$TokenParameters.NullableUInt32) newBuilder.b).setData(i);
        }
        return (TokenParametersOuterClass$TokenParameters.NullableUInt32) newBuilder.a();
    }
}
