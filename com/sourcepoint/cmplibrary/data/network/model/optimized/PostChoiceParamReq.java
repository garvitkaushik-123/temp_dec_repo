package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.ironsource.D5;
import com.sourcepoint.cmplibrary.data.network.util.Env;
import com.sourcepoint.cmplibrary.model.exposed.ActionType;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonObject;

/* compiled from: PostChoiceApiModel.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PostChoiceParamReq;", "", D5.o, "Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "actionType", "Lcom/sourcepoint/cmplibrary/model/exposed/ActionType;", "body", "Lkotlinx/serialization/json/JsonObject;", "(Lcom/sourcepoint/cmplibrary/data/network/util/Env;Lcom/sourcepoint/cmplibrary/model/exposed/ActionType;Lkotlinx/serialization/json/JsonObject;)V", "getActionType", "()Lcom/sourcepoint/cmplibrary/model/exposed/ActionType;", "getBody", "()Lkotlinx/serialization/json/JsonObject;", "getEnv", "()Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PostChoiceParamReq {
    private final ActionType actionType;
    private final JsonObject body;
    private final Env env;

    public PostChoiceParamReq(Env env, ActionType actionType, JsonObject body) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(body, "body");
        this.env = env;
        this.actionType = actionType;
        this.body = body;
    }

    public final Env getEnv() {
        return this.env;
    }

    public final ActionType getActionType() {
        return this.actionType;
    }

    public /* synthetic */ PostChoiceParamReq(Env env, ActionType actionType, JsonObject jsonObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(env, actionType, (i & 4) != 0 ? new JsonObject(MapsKt.emptyMap()) : jsonObject);
    }

    public final JsonObject getBody() {
        return this.body;
    }
}
