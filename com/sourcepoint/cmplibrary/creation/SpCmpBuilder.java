package com.sourcepoint.cmplibrary.creation;

import android.app.Activity;
import com.sourcepoint.cmplibrary.SpClient;
import com.sourcepoint.cmplibrary.SpConsentLib;
import com.sourcepoint.cmplibrary.data.network.converter.ExceptionUtilsKt;
import com.sourcepoint.cmplibrary.model.exposed.SpConfig;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpCmpBuilder.kt */
@SpDSL
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\u001f\u0010\u001e\u001a\u00020\u001f2\u0017\u0010 \u001a\u0013\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001f0!¢\u0006\u0002\b#R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006$"}, d2 = {"Lcom/sourcepoint/cmplibrary/creation/SpCmpBuilder;", "", "()V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "authId", "", "getAuthId", "()Ljava/lang/String;", "setAuthId", "(Ljava/lang/String;)V", "spClient", "Lcom/sourcepoint/cmplibrary/SpClient;", "getSpClient", "()Lcom/sourcepoint/cmplibrary/SpClient;", "setSpClient", "(Lcom/sourcepoint/cmplibrary/SpClient;)V", "spConfig", "Lcom/sourcepoint/cmplibrary/model/exposed/SpConfig;", "getSpConfig", "()Lcom/sourcepoint/cmplibrary/model/exposed/SpConfig;", "setSpConfig", "(Lcom/sourcepoint/cmplibrary/model/exposed/SpConfig;)V", "build", "Lcom/sourcepoint/cmplibrary/SpConsentLib;", "build$cmplibrary_release", "config", "", "dsl", "Lkotlin/Function1;", "Lcom/sourcepoint/cmplibrary/creation/SpConfigDataBuilder;", "Lkotlin/ExtensionFunctionType;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SpCmpBuilder {
    public Activity activity;
    private String authId;
    public SpClient spClient;
    public SpConfig spConfig;

    public final SpConfig getSpConfig() {
        SpConfig spConfig = this.spConfig;
        if (spConfig != null) {
            return spConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("spConfig");
        return null;
    }

    public final void setSpConfig(SpConfig spConfig) {
        Intrinsics.checkNotNullParameter(spConfig, "<set-?>");
        this.spConfig = spConfig;
    }

    public final String getAuthId() {
        return this.authId;
    }

    public final void setAuthId(String str) {
        this.authId = str;
    }

    public final Activity getActivity() {
        Activity activity = this.activity;
        if (activity != null) {
            return activity;
        }
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        return null;
    }

    public final void setActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<set-?>");
        this.activity = activity;
    }

    public final SpClient getSpClient() {
        SpClient spClient = this.spClient;
        if (spClient != null) {
            return spClient;
        }
        Intrinsics.throwUninitializedPropertyAccessException("spClient");
        return null;
    }

    public final void setSpClient(SpClient spClient) {
        Intrinsics.checkNotNullParameter(spClient, "<set-?>");
        this.spClient = spClient;
    }

    public final void config(Function1<? super SpConfigDataBuilder, Unit> dsl) {
        Intrinsics.checkNotNullParameter(dsl, "dsl");
        SpConfigDataBuilder spConfigDataBuilder = new SpConfigDataBuilder();
        dsl.invoke(spConfigDataBuilder);
        setSpConfig(spConfigDataBuilder.build());
    }

    public final SpConsentLib build$cmplibrary_release() {
        if (this.activity == null) {
            ExceptionUtilsKt.genericFail("activity param must be initialised!!!");
            throw new KotlinNothingValueException();
        }
        if (this.spConfig == null) {
            ExceptionUtilsKt.genericFail("spConfig param must be initialised!!!");
            throw new KotlinNothingValueException();
        }
        return FactoryKt.makeConsentLib(getSpConfig(), getActivity(), getSpClient());
    }
}
