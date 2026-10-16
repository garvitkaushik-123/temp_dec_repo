package io.bidmachine.models;

import com.ironsource.C3040d4;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ICustomParams.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001d\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\bJ\u001d\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH&¢\u0006\u0002\u0010\nJ\u001d\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000bH&¢\u0006\u0002\u0010\fJ\u001d\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH&¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u00028\u00002\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012H&¢\u0006\u0002\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Lio/bidmachine/models/ICustomParams;", "SelfType", "", "addParam", C3040d4.h.W, "", "value", "", "(Ljava/lang/String;Z)Ljava/lang/Object;", "", "(Ljava/lang/String;D)Ljava/lang/Object;", "", "(Ljava/lang/String;F)Ljava/lang/Object;", "", "(Ljava/lang/String;I)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "addParams", "params", "", "(Ljava/util/Map;)Ljava/lang/Object;", "bidmachine-android-sdk_bh_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public interface ICustomParams<SelfType> {
    SelfType addParam(String key, double value);

    SelfType addParam(String key, float value);

    SelfType addParam(String key, int value);

    SelfType addParam(String key, String value);

    SelfType addParam(String key, boolean value);

    SelfType addParams(Map<String, String> params);
}
