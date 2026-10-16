package com.sourcepoint.cmplibrary.creation;

import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.exposed.SpConfig;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpConfigDataBuilder.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u001a-\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b*\u00020\t2\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0086\u0004¨\u0006\f"}, d2 = {"config", "Lcom/sourcepoint/cmplibrary/model/exposed/SpConfig;", "dsl", "Lkotlin/Function1;", "Lcom/sourcepoint/cmplibrary/creation/SpConfigDataBuilder;", "", "Lkotlin/ExtensionFunctionType;", "to", "", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "", "Lcom/sourcepoint/cmplibrary/creation/ConfigOption;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SpConfigDataBuilderKt {
    public static final SpConfig config(Function1<? super SpConfigDataBuilder, Unit> dsl) {
        Intrinsics.checkNotNullParameter(dsl, "dsl");
        SpConfigDataBuilder spConfigDataBuilder = new SpConfigDataBuilder();
        dsl.invoke(spConfigDataBuilder);
        return spConfigDataBuilder.build();
    }

    public static final Map<CampaignType, Set<ConfigOption>> to(CampaignType campaignType, Set<? extends ConfigOption> config) {
        Intrinsics.checkNotNullParameter(campaignType, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        return MapsKt.mapOf(new Pair(campaignType, config));
    }
}
