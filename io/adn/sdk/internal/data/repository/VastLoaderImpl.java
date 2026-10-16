package io.adn.sdk.internal.data.repository;

import com.unity3d.services.core.di.ServiceProvider;
import io.adn.sdk.internal.common.utils.ListKt;
import io.adn.sdk.internal.data.api.remote.RemoteDataSource;
import io.adn.sdk.internal.data.dto.VastAdChildDto;
import io.adn.sdk.internal.data.dto.VastAdDto;
import io.adn.sdk.internal.data.dto.VastCompanionClicksDto;
import io.adn.sdk.internal.data.dto.VastCompanionDto;
import io.adn.sdk.internal.data.dto.VastCreativeChildDto;
import io.adn.sdk.internal.data.dto.VastCreativeDto;
import io.adn.sdk.internal.data.dto.VastCustomEventDto;
import io.adn.sdk.internal.data.dto.VastDto;
import io.adn.sdk.internal.data.dto.VastExtensionDto;
import io.adn.sdk.internal.data.dto.VastIconClicksDto;
import io.adn.sdk.internal.data.dto.VastIconDto;
import io.adn.sdk.internal.data.dto.VastImpressionDto;
import io.adn.sdk.internal.data.dto.VastInLineDto;
import io.adn.sdk.internal.data.dto.VastLinearDto;
import io.adn.sdk.internal.data.dto.VastMediaFileDto;
import io.adn.sdk.internal.data.dto.VastVideoClickDto;
import io.adn.sdk.internal.data.dto.VastVideoClicksDto;
import io.adn.sdk.internal.data.dto.VastWrapperDto;
import io.adn.sdk.internal.data.parser.VastParser;
import io.adn.sdk.internal.data.repository.VastLoaderImpl;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.model.ad.VastAdEntity;
import io.adn.sdk.internal.domain.model.ad.VastCreative;
import io.adn.sdk.internal.domain.model.ad.VastExtension;
import io.adn.sdk.internal.domain.model.ad.VastIcon;
import io.adn.sdk.internal.domain.model.ad.VastLinearTracking;
import io.adn.sdk.internal.domain.model.ad.VastOffset;
import io.adn.sdk.internal.domain.model.ad.VastProgressTracking;
import io.adn.sdk.internal.domain.model.ad.VastResource;
import io.adn.sdk.internal.domain.model.ad.VastTracking;
import io.adn.sdk.internal.domain.model.ad.VastTrackingEvent;
import io.adn.sdk.internal.domain.repository.VastLoader;
import io.adn.sdk.internal.domain.repository.VastTracker;
import io.bidmachine.ads.networks.vast.VastAdapter;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.iab.vast.tags.VastTagName;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: VastLoader.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 A2\u00020\u0001:\u0004>?@AB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096B¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\"\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0082@¢\u0006\u0002\u0010\u0018J \u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0082@¢\u0006\u0002\u0010\u001cJ$\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u001fH\u0082@¢\u0006\u0002\u0010 J\u001a\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002JB\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\r2\u0006\u0010)\u001a\u00020*2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u001f2\b\u0010-\u001a\u0004\u0018\u00010.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0\u001fH\u0002J\u0012\u00100\u001a\u0002012\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0018\u00102\u001a\u0004\u0018\u0001032\f\u00104\u001a\b\u0012\u0004\u0012\u0002050\u001fH\u0002J\u0018\u00106\u001a\u0004\u0018\u0001072\f\u00108\u001a\b\u0012\u0004\u0012\u0002090\u001fH\u0002J\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u001f2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B²\u0006\n\u0010C\u001a\u000201X\u008a\u0084\u0002"}, d2 = {"Lio/adn/sdk/internal/data/repository/VastLoaderImpl;", "Lio/adn/sdk/internal/domain/repository/VastLoader;", "parser", "Lio/adn/sdk/internal/data/parser/VastParser;", ServiceProvider.NAMED_REMOTE, "Lio/adn/sdk/internal/data/api/remote/RemoteDataSource;", "vastTracker", "Lio/adn/sdk/internal/domain/repository/VastTracker;", "<init>", "(Lio/adn/sdk/internal/data/parser/VastParser;Lio/adn/sdk/internal/data/api/remote/RemoteDataSource;Lio/adn/sdk/internal/domain/repository/VastTracker;)V", "invoke", "Lio/adn/sdk/internal/domain/model/ad/VastAdEntity;", "adm", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackVastError", "", "exception", "Lio/adn/sdk/internal/data/repository/VastException;", "loadVastAd", VastAdapter.KEY, "Lio/adn/sdk/internal/data/dto/VastDto;", "wrapperChainParams", "Lio/adn/sdk/internal/data/repository/VastLoaderImpl$WrapperChainParams;", "(Lio/adn/sdk/internal/data/dto/VastDto;Lio/adn/sdk/internal/data/repository/VastLoaderImpl$WrapperChainParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadVastWrapperAd", "wrapper", "Lio/adn/sdk/internal/data/dto/VastWrapperDto;", "(Lio/adn/sdk/internal/data/dto/VastWrapperDto;Lio/adn/sdk/internal/data/repository/VastLoaderImpl$WrapperChainParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAndParseVastDocument", "errorUrls", "", "(Lio/adn/sdk/internal/data/dto/VastWrapperDto;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadVastInlineAd", "inline", "Lio/adn/sdk/internal/data/dto/VastInLineDto;", "aggregatedWrapperChainData", "Lio/adn/sdk/internal/data/repository/VastLoaderImpl$AggregatedWrapperChainAdData;", "prepareLinear", "Lio/adn/sdk/internal/domain/model/ad/VastCreative$Linear;", "creativeId", "linear", "Lio/adn/sdk/internal/data/dto/VastLinearDto;", "wrapperLinearTrackingList", "Lio/adn/sdk/internal/domain/model/ad/VastTracking;", "wrapperVideoClicks", "Lio/adn/sdk/internal/data/dto/VastVideoClicksDto;", "aggregatedErrorUrls", "prepareWrapperDataForInline", "Lio/adn/sdk/internal/data/repository/VastLoaderImpl$PreparedWrapperDataForInline;", "prepareCompanion", "Lio/adn/sdk/internal/domain/model/ad/VastCreative$Companion;", "companions", "Lio/adn/sdk/internal/data/dto/VastCompanionDto;", "prepareIcon", "Lio/adn/sdk/internal/domain/model/ad/VastIcon;", "icons", "Lio/adn/sdk/internal/data/dto/VastIconDto;", "prepareExtension", "Lio/adn/sdk/internal/domain/model/ad/VastExtension;", "extensions", "Lio/adn/sdk/internal/data/dto/VastExtensionDto;", "WrapperChainParams", "AggregatedWrapperChainAdData", "PreparedWrapperDataForInline", VastTagName.VAST, "adn-sdk_release", "preparedWrapperDataForInline"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class VastLoaderImpl implements VastLoader {
    private static final int WRAPPER_DEPTH_MAX = 4;
    private final VastParser parser;
    private final RemoteDataSource remote;
    private final VastTracker vastTracker;
    private static final VAST VAST = new VAST(null);
    public static final int $stable = 8;

    public VastLoaderImpl(VastParser parser, RemoteDataSource remote, VastTracker vastTracker) {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(remote, "remote");
        Intrinsics.checkNotNullParameter(vastTracker, "vastTracker");
        this.parser = parser;
        this.remote = remote;
        this.vastTracker = vastTracker;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|1|(2:3|(6:5|6|7|(1:(1:(5:11|12|13|14|(1:16)(3:18|(1:20)|21))(2:22|23))(4:24|25|26|27))(5:39|40|41|(1:43)|32)|28|(1:30)(2:33|34)))|49|6|7|(0)(0)|28|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007c, code lost:
    
        if (r10 == r0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0032, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0033, code lost:
    
        r10 = r0;
        r9 = r9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:12:0x002e, B:13:0x007f, B:28:0x0069, B:30:0x006f, B:33:0x0086, B:34:0x008d), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0086 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:12:0x002e, B:13:0x007f, B:28:0x0069, B:30:0x006f, B:33:0x0086, B:34:0x008d), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    @Override // io.adn.sdk.internal.domain.repository.VastLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(String str, Continuation<? super VastAdEntity> continuation) {
        VastLoaderImpl$invoke$1 vastLoaderImpl$invoke$1;
        int i;
        Throwable th;
        VastLoaderImpl vastLoaderImpl;
        Object m10241constructorimpl;
        VastLoaderImpl vastLoaderImpl2;
        Throwable m10244exceptionOrNullimpl;
        VastLoaderImpl vastLoaderImpl3;
        VastLoaderImpl vastLoaderImpl4;
        VastDto vastDto;
        VastLoaderImpl vastLoaderImpl5;
        if (continuation instanceof VastLoaderImpl$invoke$1) {
            vastLoaderImpl$invoke$1 = (VastLoaderImpl$invoke$1) continuation;
            if ((vastLoaderImpl$invoke$1.label & Integer.MIN_VALUE) != 0) {
                vastLoaderImpl$invoke$1.label -= Integer.MIN_VALUE;
                VastLoaderImpl$invoke$1 vastLoaderImpl$invoke$12 = vastLoaderImpl$invoke$1;
                Object obj = vastLoaderImpl$invoke$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = vastLoaderImpl$invoke$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        VastLoaderImpl vastLoaderImpl6 = this;
                        VastParser vastParser = this.parser;
                        vastLoaderImpl$invoke$12.L$0 = this;
                        vastLoaderImpl$invoke$12.L$1 = this;
                        vastLoaderImpl$invoke$12.label = 1;
                        obj = vastParser.parse(str, vastLoaderImpl$invoke$12);
                        if (obj != coroutine_suspended) {
                            VastLoaderImpl vastLoaderImpl7 = this;
                            vastLoaderImpl3 = vastLoaderImpl7;
                            vastLoaderImpl4 = vastLoaderImpl7;
                        }
                        return coroutine_suspended;
                    } catch (Throwable th2) {
                        th = th2;
                        vastLoaderImpl = this;
                        Result.Companion companion2 = Result.INSTANCE;
                        m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                        vastLoaderImpl2 = vastLoaderImpl;
                        m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                        if (m10244exceptionOrNullimpl == null) {
                        }
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        VastLoaderImpl vastLoaderImpl8 = (VastLoaderImpl) vastLoaderImpl$invoke$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        vastLoaderImpl5 = vastLoaderImpl8;
                        m10241constructorimpl = Result.m10241constructorimpl((VastAdEntity) obj);
                        vastLoaderImpl2 = vastLoaderImpl5;
                        m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                        if (m10244exceptionOrNullimpl == null) {
                            return m10241constructorimpl;
                        }
                        if (m10244exceptionOrNullimpl instanceof VastException) {
                            vastLoaderImpl2.trackVastError((VastException) m10244exceptionOrNullimpl);
                        }
                        throw m10244exceptionOrNullimpl;
                    }
                    VastLoaderImpl vastLoaderImpl9 = (VastLoaderImpl) vastLoaderImpl$invoke$12.L$1;
                    VastLoaderImpl vastLoaderImpl10 = (VastLoaderImpl) vastLoaderImpl$invoke$12.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        vastLoaderImpl3 = vastLoaderImpl9;
                        vastLoaderImpl4 = vastLoaderImpl10;
                    } catch (Throwable th3) {
                        th = th3;
                        vastLoaderImpl = vastLoaderImpl10;
                        Result.Companion companion22 = Result.INSTANCE;
                        m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                        vastLoaderImpl2 = vastLoaderImpl;
                        m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                        if (m10244exceptionOrNullimpl == null) {
                        }
                    }
                }
                vastDto = (VastDto) obj;
                if (vastDto != null) {
                    throw new VastException(AdError.VastXmlParsingError, null, 2, null);
                }
                vastLoaderImpl$invoke$12.L$0 = vastLoaderImpl4;
                vastLoaderImpl$invoke$12.L$1 = null;
                vastLoaderImpl$invoke$12.label = 2;
                obj = loadVastAd$default(vastLoaderImpl3, vastDto, null, vastLoaderImpl$invoke$12, 2, null);
                vastLoaderImpl5 = vastLoaderImpl4;
            }
        }
        vastLoaderImpl$invoke$1 = new VastLoaderImpl$invoke$1(this, continuation);
        VastLoaderImpl$invoke$1 vastLoaderImpl$invoke$122 = vastLoaderImpl$invoke$1;
        Object obj2 = vastLoaderImpl$invoke$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = vastLoaderImpl$invoke$122.label;
        if (i != 0) {
        }
        vastDto = (VastDto) obj2;
        if (vastDto != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VastLoader.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lio/adn/sdk/internal/data/repository/VastLoaderImpl$WrapperChainParams;", "", "wrapperDepth", "", "usedVastAdTagUrls", "", "", VastAttributes.FOLLOW_ADDITIONAL_WRAPPERS, "", "aggregatedWrapperChainData", "Lio/adn/sdk/internal/data/repository/VastLoaderImpl$AggregatedWrapperChainAdData;", "<init>", "(ILjava/util/Set;ZLio/adn/sdk/internal/data/repository/VastLoaderImpl$AggregatedWrapperChainAdData;)V", "getWrapperDepth", "()I", "getUsedVastAdTagUrls", "()Ljava/util/Set;", "getFollowAdditionalWrappers", "()Z", "getAggregatedWrapperChainData", "()Lio/adn/sdk/internal/data/repository/VastLoaderImpl$AggregatedWrapperChainAdData;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    static final /* data */ class WrapperChainParams {
        private final AggregatedWrapperChainAdData aggregatedWrapperChainData;
        private final boolean followAdditionalWrappers;
        private final Set<String> usedVastAdTagUrls;
        private final int wrapperDepth;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WrapperChainParams copy$default(WrapperChainParams wrapperChainParams, int i, Set set, boolean z, AggregatedWrapperChainAdData aggregatedWrapperChainAdData, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = wrapperChainParams.wrapperDepth;
            }
            if ((i2 & 2) != 0) {
                set = wrapperChainParams.usedVastAdTagUrls;
            }
            if ((i2 & 4) != 0) {
                z = wrapperChainParams.followAdditionalWrappers;
            }
            if ((i2 & 8) != 0) {
                aggregatedWrapperChainAdData = wrapperChainParams.aggregatedWrapperChainData;
            }
            return wrapperChainParams.copy(i, set, z, aggregatedWrapperChainAdData);
        }

        /* renamed from: component1, reason: from getter */
        public final int getWrapperDepth() {
            return this.wrapperDepth;
        }

        public final Set<String> component2() {
            return this.usedVastAdTagUrls;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getFollowAdditionalWrappers() {
            return this.followAdditionalWrappers;
        }

        /* renamed from: component4, reason: from getter */
        public final AggregatedWrapperChainAdData getAggregatedWrapperChainData() {
            return this.aggregatedWrapperChainData;
        }

        public final WrapperChainParams copy(int wrapperDepth, Set<String> usedVastAdTagUrls, boolean followAdditionalWrappers, AggregatedWrapperChainAdData aggregatedWrapperChainData) {
            Intrinsics.checkNotNullParameter(usedVastAdTagUrls, "usedVastAdTagUrls");
            Intrinsics.checkNotNullParameter(aggregatedWrapperChainData, "aggregatedWrapperChainData");
            return new WrapperChainParams(wrapperDepth, usedVastAdTagUrls, followAdditionalWrappers, aggregatedWrapperChainData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WrapperChainParams)) {
                return false;
            }
            WrapperChainParams wrapperChainParams = (WrapperChainParams) other;
            return this.wrapperDepth == wrapperChainParams.wrapperDepth && Intrinsics.areEqual(this.usedVastAdTagUrls, wrapperChainParams.usedVastAdTagUrls) && this.followAdditionalWrappers == wrapperChainParams.followAdditionalWrappers && Intrinsics.areEqual(this.aggregatedWrapperChainData, wrapperChainParams.aggregatedWrapperChainData);
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.wrapperDepth) * 31) + this.usedVastAdTagUrls.hashCode()) * 31) + Boolean.hashCode(this.followAdditionalWrappers)) * 31) + this.aggregatedWrapperChainData.hashCode();
        }

        public String toString() {
            return "WrapperChainParams(wrapperDepth=" + this.wrapperDepth + ", usedVastAdTagUrls=" + this.usedVastAdTagUrls + ", followAdditionalWrappers=" + this.followAdditionalWrappers + ", aggregatedWrapperChainData=" + this.aggregatedWrapperChainData + ')';
        }

        public WrapperChainParams(int i, Set<String> usedVastAdTagUrls, boolean z, AggregatedWrapperChainAdData aggregatedWrapperChainData) {
            Intrinsics.checkNotNullParameter(usedVastAdTagUrls, "usedVastAdTagUrls");
            Intrinsics.checkNotNullParameter(aggregatedWrapperChainData, "aggregatedWrapperChainData");
            this.wrapperDepth = i;
            this.usedVastAdTagUrls = usedVastAdTagUrls;
            this.followAdditionalWrappers = z;
            this.aggregatedWrapperChainData = aggregatedWrapperChainData;
        }

        public final int getWrapperDepth() {
            return this.wrapperDepth;
        }

        public final Set<String> getUsedVastAdTagUrls() {
            return this.usedVastAdTagUrls;
        }

        public final boolean getFollowAdditionalWrappers() {
            return this.followAdditionalWrappers;
        }

        public final AggregatedWrapperChainAdData getAggregatedWrapperChainData() {
            return this.aggregatedWrapperChainData;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VastLoader.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00030\u0003¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u0015\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00030\u0003HÆ\u0003J?\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00030\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lio/adn/sdk/internal/data/repository/VastLoaderImpl$AggregatedWrapperChainAdData;", "", "impressions", "", "Lio/adn/sdk/internal/data/dto/VastImpressionDto;", "errorUrls", "", "creativesPerWrapper", "Lio/adn/sdk/internal/data/dto/VastCreativeDto;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getImpressions", "()Ljava/util/List;", "getErrorUrls", "getCreativesPerWrapper", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    static final /* data */ class AggregatedWrapperChainAdData {
        private final List<List<VastCreativeDto>> creativesPerWrapper;
        private final List<String> errorUrls;
        private final List<VastImpressionDto> impressions;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AggregatedWrapperChainAdData copy$default(AggregatedWrapperChainAdData aggregatedWrapperChainAdData, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = aggregatedWrapperChainAdData.impressions;
            }
            if ((i & 2) != 0) {
                list2 = aggregatedWrapperChainAdData.errorUrls;
            }
            if ((i & 4) != 0) {
                list3 = aggregatedWrapperChainAdData.creativesPerWrapper;
            }
            return aggregatedWrapperChainAdData.copy(list, list2, list3);
        }

        public final List<VastImpressionDto> component1() {
            return this.impressions;
        }

        public final List<String> component2() {
            return this.errorUrls;
        }

        public final List<List<VastCreativeDto>> component3() {
            return this.creativesPerWrapper;
        }

        public final AggregatedWrapperChainAdData copy(List<VastImpressionDto> impressions, List<String> errorUrls, List<? extends List<VastCreativeDto>> creativesPerWrapper) {
            Intrinsics.checkNotNullParameter(impressions, "impressions");
            Intrinsics.checkNotNullParameter(errorUrls, "errorUrls");
            Intrinsics.checkNotNullParameter(creativesPerWrapper, "creativesPerWrapper");
            return new AggregatedWrapperChainAdData(impressions, errorUrls, creativesPerWrapper);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AggregatedWrapperChainAdData)) {
                return false;
            }
            AggregatedWrapperChainAdData aggregatedWrapperChainAdData = (AggregatedWrapperChainAdData) other;
            return Intrinsics.areEqual(this.impressions, aggregatedWrapperChainAdData.impressions) && Intrinsics.areEqual(this.errorUrls, aggregatedWrapperChainAdData.errorUrls) && Intrinsics.areEqual(this.creativesPerWrapper, aggregatedWrapperChainAdData.creativesPerWrapper);
        }

        public int hashCode() {
            return (((this.impressions.hashCode() * 31) + this.errorUrls.hashCode()) * 31) + this.creativesPerWrapper.hashCode();
        }

        public String toString() {
            return "AggregatedWrapperChainAdData(impressions=" + this.impressions + ", errorUrls=" + this.errorUrls + ", creativesPerWrapper=" + this.creativesPerWrapper + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AggregatedWrapperChainAdData(List<VastImpressionDto> impressions, List<String> errorUrls, List<? extends List<VastCreativeDto>> creativesPerWrapper) {
            Intrinsics.checkNotNullParameter(impressions, "impressions");
            Intrinsics.checkNotNullParameter(errorUrls, "errorUrls");
            Intrinsics.checkNotNullParameter(creativesPerWrapper, "creativesPerWrapper");
            this.impressions = impressions;
            this.errorUrls = errorUrls;
            this.creativesPerWrapper = creativesPerWrapper;
        }

        public final List<VastImpressionDto> getImpressions() {
            return this.impressions;
        }

        public final List<String> getErrorUrls() {
            return this.errorUrls;
        }

        public final List<List<VastCreativeDto>> getCreativesPerWrapper() {
            return this.creativesPerWrapper;
        }
    }

    private final void trackVastError(VastException exception) {
        List<String> errorUrls = exception.getErrorUrls();
        if (errorUrls != null) {
            this.vastTracker.trackError(errorUrls, exception.errorCode());
        }
    }

    static /* synthetic */ Object loadVastAd$default(VastLoaderImpl vastLoaderImpl, VastDto vastDto, WrapperChainParams wrapperChainParams, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            wrapperChainParams = null;
        }
        return vastLoaderImpl.loadVastAd(vastDto, wrapperChainParams, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadVastAd(VastDto vastDto, WrapperChainParams wrapperChainParams, Continuation<? super VastAdEntity> continuation) {
        AggregatedWrapperChainAdData aggregatedWrapperChainData;
        List plus = ListKt.plus((wrapperChainParams == null || (aggregatedWrapperChainData = wrapperChainParams.getAggregatedWrapperChainData()) == null) ? null : aggregatedWrapperChainData.getErrorUrls(), vastDto.getErrorUrl());
        VastAdDto vastAdDto = (VastAdDto) CollectionsKt.firstOrNull(CollectionsKt.sortedWith(vastDto.getAds(), new Comparator() { // from class: io.adn.sdk.internal.data.repository.VastLoaderImpl$loadVastAd$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((VastAdDto) t).getSequence(), ((VastAdDto) t2).getSequence());
            }
        }));
        if (vastAdDto == null) {
            throw new VastException(AdError.VastWrapperNoAdsError, plus);
        }
        WrapperChainParams copy$default = wrapperChainParams != null ? WrapperChainParams.copy$default(wrapperChainParams, 0, null, false, AggregatedWrapperChainAdData.copy$default(wrapperChainParams.getAggregatedWrapperChainData(), null, plus, null, 5, null), 7, null) : null;
        VastAdChildDto child = vastAdDto.getChild();
        if (child instanceof VastAdChildDto.Wrapper) {
            return loadVastWrapperAd(((VastAdChildDto.Wrapper) child).getWrapper(), copy$default, continuation);
        }
        if (!(child instanceof VastAdChildDto.InLine)) {
            throw new NoWhenBranchMatchedException();
        }
        return loadVastInlineAd(((VastAdChildDto.InLine) child).getInline(), copy$default != null ? copy$default.getAggregatedWrapperChainData() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadVastWrapperAd(VastWrapperDto vastWrapperDto, WrapperChainParams wrapperChainParams, Continuation<? super VastAdEntity> continuation) {
        VastLoaderImpl$loadVastWrapperAd$1 vastLoaderImpl$loadVastWrapperAd$1;
        int i;
        int wrapperDepth;
        List<String> plus;
        Object loadAndParseVastDocument;
        VastLoaderImpl vastLoaderImpl;
        Set<String> usedVastAdTagUrls;
        AggregatedWrapperChainAdData aggregatedWrapperChainData;
        AggregatedWrapperChainAdData aggregatedWrapperChainData2;
        AggregatedWrapperChainAdData aggregatedWrapperChainData3;
        VastWrapperDto vastWrapperDto2 = vastWrapperDto;
        WrapperChainParams wrapperChainParams2 = wrapperChainParams;
        if (continuation instanceof VastLoaderImpl$loadVastWrapperAd$1) {
            vastLoaderImpl$loadVastWrapperAd$1 = (VastLoaderImpl$loadVastWrapperAd$1) continuation;
            if ((vastLoaderImpl$loadVastWrapperAd$1.label & Integer.MIN_VALUE) != 0) {
                vastLoaderImpl$loadVastWrapperAd$1.label -= Integer.MIN_VALUE;
                Object obj = vastLoaderImpl$loadVastWrapperAd$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = vastLoaderImpl$loadVastWrapperAd$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    wrapperDepth = wrapperChainParams2 != null ? wrapperChainParams2.getWrapperDepth() + 1 : 0;
                    plus = ListKt.plus((List) ((wrapperChainParams2 == null || (aggregatedWrapperChainData = wrapperChainParams2.getAggregatedWrapperChainData()) == null) ? null : aggregatedWrapperChainData.getErrorUrls()), (List) vastWrapperDto2.getErrorUrls());
                    if (wrapperDepth > 4 || ((wrapperChainParams2 != null && (usedVastAdTagUrls = wrapperChainParams2.getUsedVastAdTagUrls()) != null && usedVastAdTagUrls.contains(vastWrapperDto2.getVastAdTagUrl())) || (wrapperChainParams2 != null && !wrapperChainParams2.getFollowAdditionalWrappers()))) {
                        throw new VastException(AdError.VastWrapperLimitError, plus);
                    }
                    vastLoaderImpl$loadVastWrapperAd$1.L$0 = this;
                    vastLoaderImpl$loadVastWrapperAd$1.L$1 = vastWrapperDto2;
                    vastLoaderImpl$loadVastWrapperAd$1.L$2 = wrapperChainParams2;
                    vastLoaderImpl$loadVastWrapperAd$1.L$3 = plus;
                    vastLoaderImpl$loadVastWrapperAd$1.I$0 = wrapperDepth;
                    vastLoaderImpl$loadVastWrapperAd$1.label = 1;
                    loadAndParseVastDocument = loadAndParseVastDocument(vastWrapperDto2, plus, vastLoaderImpl$loadVastWrapperAd$1);
                    if (loadAndParseVastDocument != coroutine_suspended) {
                        vastLoaderImpl = this;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                int i2 = vastLoaderImpl$loadVastWrapperAd$1.I$0;
                List<String> list = (List) vastLoaderImpl$loadVastWrapperAd$1.L$3;
                WrapperChainParams wrapperChainParams3 = (WrapperChainParams) vastLoaderImpl$loadVastWrapperAd$1.L$2;
                VastWrapperDto vastWrapperDto3 = (VastWrapperDto) vastLoaderImpl$loadVastWrapperAd$1.L$1;
                vastLoaderImpl = (VastLoaderImpl) vastLoaderImpl$loadVastWrapperAd$1.L$0;
                ResultKt.throwOnFailure(obj);
                wrapperDepth = i2;
                vastWrapperDto2 = vastWrapperDto3;
                loadAndParseVastDocument = obj;
                plus = list;
                wrapperChainParams2 = wrapperChainParams3;
                VastDto vastDto = (VastDto) loadAndParseVastDocument;
                List plus2 = ListKt.plus((List) ((wrapperChainParams2 != null || (aggregatedWrapperChainData3 = wrapperChainParams2.getAggregatedWrapperChainData()) == null) ? null : aggregatedWrapperChainData3.getImpressions()), (List) vastWrapperDto2.getImpressions());
                List plus3 = ListKt.plus((List) ((wrapperChainParams2 != null || (aggregatedWrapperChainData2 = wrapperChainParams2.getAggregatedWrapperChainData()) == null) ? null : aggregatedWrapperChainData2.getCreativesPerWrapper()), CollectionsKt.listOf(vastWrapperDto2.getCreatives()));
                Set plus4 = VAST.plus(wrapperChainParams2 == null ? wrapperChainParams2.getUsedVastAdTagUrls() : null, vastWrapperDto2.getVastAdTagUrl());
                Boolean followAdditionalWrappers = vastWrapperDto2.getFollowAdditionalWrappers();
                WrapperChainParams wrapperChainParams4 = new WrapperChainParams(wrapperDepth, plus4, followAdditionalWrappers != null ? followAdditionalWrappers.booleanValue() : true, new AggregatedWrapperChainAdData(plus2, plus, plus3));
                vastLoaderImpl$loadVastWrapperAd$1.L$0 = null;
                vastLoaderImpl$loadVastWrapperAd$1.L$1 = null;
                vastLoaderImpl$loadVastWrapperAd$1.L$2 = null;
                vastLoaderImpl$loadVastWrapperAd$1.L$3 = null;
                vastLoaderImpl$loadVastWrapperAd$1.label = 2;
                Object loadVastAd = vastLoaderImpl.loadVastAd(vastDto, wrapperChainParams4, vastLoaderImpl$loadVastWrapperAd$1);
                return loadVastAd != coroutine_suspended ? coroutine_suspended : loadVastAd;
            }
        }
        vastLoaderImpl$loadVastWrapperAd$1 = new VastLoaderImpl$loadVastWrapperAd$1(this, continuation);
        Object obj2 = vastLoaderImpl$loadVastWrapperAd$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = vastLoaderImpl$loadVastWrapperAd$1.label;
        if (i != 0) {
        }
        VastDto vastDto2 = (VastDto) loadAndParseVastDocument;
        List plus22 = ListKt.plus((List) ((wrapperChainParams2 != null || (aggregatedWrapperChainData3 = wrapperChainParams2.getAggregatedWrapperChainData()) == null) ? null : aggregatedWrapperChainData3.getImpressions()), (List) vastWrapperDto2.getImpressions());
        List plus32 = ListKt.plus((List) ((wrapperChainParams2 != null || (aggregatedWrapperChainData2 = wrapperChainParams2.getAggregatedWrapperChainData()) == null) ? null : aggregatedWrapperChainData2.getCreativesPerWrapper()), CollectionsKt.listOf(vastWrapperDto2.getCreatives()));
        Set plus42 = VAST.plus(wrapperChainParams2 == null ? wrapperChainParams2.getUsedVastAdTagUrls() : null, vastWrapperDto2.getVastAdTagUrl());
        Boolean followAdditionalWrappers2 = vastWrapperDto2.getFollowAdditionalWrappers();
        WrapperChainParams wrapperChainParams42 = new WrapperChainParams(wrapperDepth, plus42, followAdditionalWrappers2 != null ? followAdditionalWrappers2.booleanValue() : true, new AggregatedWrapperChainAdData(plus22, plus, plus32));
        vastLoaderImpl$loadVastWrapperAd$1.L$0 = null;
        vastLoaderImpl$loadVastWrapperAd$1.L$1 = null;
        vastLoaderImpl$loadVastWrapperAd$1.L$2 = null;
        vastLoaderImpl$loadVastWrapperAd$1.L$3 = null;
        vastLoaderImpl$loadVastWrapperAd$1.label = 2;
        Object loadVastAd2 = vastLoaderImpl.loadVastAd(vastDto2, wrapperChainParams42, vastLoaderImpl$loadVastWrapperAd$1);
        if (loadVastAd2 != coroutine_suspended2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008f, code lost:
    
        if (r9 == r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadAndParseVastDocument(VastWrapperDto vastWrapperDto, List<String> list, Continuation<? super VastDto> continuation) {
        VastLoaderImpl$loadAndParseVastDocument$1 vastLoaderImpl$loadAndParseVastDocument$1;
        int i;
        VastLoaderImpl vastLoaderImpl;
        Object m10241constructorimpl;
        List<String> list2;
        if (continuation instanceof VastLoaderImpl$loadAndParseVastDocument$1) {
            vastLoaderImpl$loadAndParseVastDocument$1 = (VastLoaderImpl$loadAndParseVastDocument$1) continuation;
            if ((vastLoaderImpl$loadAndParseVastDocument$1.label & Integer.MIN_VALUE) != 0) {
                vastLoaderImpl$loadAndParseVastDocument$1.label -= Integer.MIN_VALUE;
                Object obj = vastLoaderImpl$loadAndParseVastDocument$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = vastLoaderImpl$loadAndParseVastDocument$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        VastLoaderImpl vastLoaderImpl2 = this;
                        RemoteDataSource remoteDataSource = this.remote;
                        String vastAdTagUrl = vastWrapperDto.getVastAdTagUrl();
                        vastLoaderImpl$loadAndParseVastDocument$1.L$0 = this;
                        vastLoaderImpl$loadAndParseVastDocument$1.L$1 = list;
                        vastLoaderImpl$loadAndParseVastDocument$1.label = 1;
                        obj = remoteDataSource.loadAdContent(vastAdTagUrl, vastLoaderImpl$loadAndParseVastDocument$1);
                        if (obj != coroutine_suspended) {
                            vastLoaderImpl = this;
                        }
                    } catch (Throwable th) {
                        th = th;
                        vastLoaderImpl = this;
                        Result.Companion companion2 = Result.INSTANCE;
                        m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                        List<String> list3 = list;
                        VastLoaderImpl vastLoaderImpl3 = vastLoaderImpl;
                        list2 = list3;
                        if (Result.m10244exceptionOrNullimpl(m10241constructorimpl) == null) {
                        }
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list2 = (List) vastLoaderImpl$loadAndParseVastDocument$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    VastDto vastDto = (VastDto) obj;
                    if (vastDto != null) {
                        return vastDto;
                    }
                    throw new VastException(AdError.VastWrapperError, list2);
                }
                list = (List) vastLoaderImpl$loadAndParseVastDocument$1.L$1;
                vastLoaderImpl = (VastLoaderImpl) vastLoaderImpl$loadAndParseVastDocument$1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th2) {
                    th = th2;
                    Result.Companion companion22 = Result.INSTANCE;
                    m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                    List<String> list32 = list;
                    VastLoaderImpl vastLoaderImpl32 = vastLoaderImpl;
                    list2 = list32;
                    if (Result.m10244exceptionOrNullimpl(m10241constructorimpl) == null) {
                    }
                }
                m10241constructorimpl = Result.m10241constructorimpl((String) obj);
                List<String> list322 = list;
                VastLoaderImpl vastLoaderImpl322 = vastLoaderImpl;
                list2 = list322;
                if (Result.m10244exceptionOrNullimpl(m10241constructorimpl) == null) {
                    throw new VastException(AdError.VastWrapperXmlLoadError, list2);
                }
                VastParser vastParser = vastLoaderImpl322.parser;
                vastLoaderImpl$loadAndParseVastDocument$1.L$0 = list2;
                vastLoaderImpl$loadAndParseVastDocument$1.L$1 = null;
                vastLoaderImpl$loadAndParseVastDocument$1.label = 2;
                obj = vastParser.parse((String) m10241constructorimpl, vastLoaderImpl$loadAndParseVastDocument$1);
            }
        }
        vastLoaderImpl$loadAndParseVastDocument$1 = new VastLoaderImpl$loadAndParseVastDocument$1(this, continuation);
        Object obj2 = vastLoaderImpl$loadAndParseVastDocument$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = vastLoaderImpl$loadAndParseVastDocument$1.label;
        if (i != 0) {
        }
        m10241constructorimpl = Result.m10241constructorimpl((String) obj2);
        List<String> list3222 = list;
        VastLoaderImpl vastLoaderImpl3222 = vastLoaderImpl;
        list2 = list3222;
        if (Result.m10244exceptionOrNullimpl(m10241constructorimpl) == null) {
        }
    }

    private final VastAdEntity loadVastInlineAd(VastInLineDto inline, final AggregatedWrapperChainAdData aggregatedWrapperChainData) {
        VastCreative prepareCompanion;
        List<String> plus = ListKt.plus((List) (aggregatedWrapperChainData != null ? aggregatedWrapperChainData.getErrorUrls() : null), (List) inline.getErrorUrls());
        if (inline.getCreatives().isEmpty()) {
            throw new VastException(AdError.NoCreativesError, plus);
        }
        Lazy lazy = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.data.repository.VastLoaderImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VastLoaderImpl.PreparedWrapperDataForInline prepareWrapperDataForInline;
                prepareWrapperDataForInline = VastLoaderImpl.this.prepareWrapperDataForInline(aggregatedWrapperChainData);
                return prepareWrapperDataForInline;
            }
        });
        List<VastCreativeDto> creatives = inline.getCreatives();
        ArrayList arrayList = new ArrayList();
        for (Object obj : creatives) {
            if (!VAST.getHasApiFramework((VastCreativeDto) obj)) {
                arrayList.add(obj);
            }
        }
        List<VastCreativeDto> sortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: io.adn.sdk.internal.data.repository.VastLoaderImpl$loadVastInlineAd$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((VastCreativeDto) t).getSequence(), ((VastCreativeDto) t2).getSequence());
            }
        });
        ArrayList arrayList2 = new ArrayList();
        for (VastCreativeDto vastCreativeDto : sortedWith) {
            VastCreativeChildDto child = vastCreativeDto.getChild();
            if (child instanceof VastCreativeChildDto.Linear) {
                prepareCompanion = prepareLinear(vastCreativeDto.getId(), ((VastCreativeChildDto.Linear) vastCreativeDto.getChild()).getLinear(), loadVastInlineAd$lambda$7(lazy).getLinearTrackingList(), loadVastInlineAd$lambda$7(lazy).getVideoClicks(), plus);
            } else {
                if (!(child instanceof VastCreativeChildDto.Companions)) {
                    throw new NoWhenBranchMatchedException();
                }
                prepareCompanion = prepareCompanion(((VastCreativeChildDto.Companions) vastCreativeDto.getChild()).getCompanions());
            }
            if (prepareCompanion != null) {
                arrayList2.add(prepareCompanion);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.isEmpty()) {
            throw new VastException(AdError.NoCreativesError, plus);
        }
        List plus2 = ListKt.plus((List) (aggregatedWrapperChainData != null ? aggregatedWrapperChainData.getImpressions() : null), (List) inline.getImpressions());
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(plus2, 10));
        Iterator it = plus2.iterator();
        while (it.hasNext()) {
            arrayList4.add(((VastImpressionDto) it.next()).getImpressionUrl());
        }
        return new VastAdEntity(arrayList3, arrayList4, plus, prepareExtension(inline.getExtensions()));
    }

    private static final PreparedWrapperDataForInline loadVastInlineAd$lambda$7(Lazy<PreparedWrapperDataForInline> lazy) {
        return lazy.getValue();
    }

    private final VastCreative.Linear prepareLinear(String creativeId, VastLinearDto linear, List<VastTracking> wrapperLinearTrackingList, VastVideoClicksDto wrapperVideoClicks, List<String> aggregatedErrorUrls) {
        VastVideoClickDto clickThrough;
        List<VastMediaFileDto> mediaFiles = linear.getMediaFiles();
        ArrayList arrayList = new ArrayList();
        for (Object obj : mediaFiles) {
            VastMediaFileDto vastMediaFileDto = (VastMediaFileDto) obj;
            if (!VAST.getHasApiFramework(vastMediaFileDto) && vastMediaFileDto.isProgressiveDelivery()) {
                arrayList.add(obj);
            }
        }
        VastMediaFileDto vastMediaFileDto2 = (VastMediaFileDto) CollectionsKt.firstOrNull((List) arrayList);
        if (vastMediaFileDto2 == null) {
            throw new VastException(AdError.VastLinearNotSupportedMediaError, aggregatedErrorUrls);
        }
        VastVideoClicksDto videoClicks = linear.getVideoClicks();
        String url = (videoClicks == null || (clickThrough = videoClicks.getClickThrough()) == null) ? null : clickThrough.getUrl();
        List plus = ListKt.plus((List) linear.getTrackingList(), (List) wrapperLinearTrackingList);
        VastVideoClicksDto videoClicks2 = linear.getVideoClicks();
        VastVideoClickDto clickThrough2 = videoClicks2 != null ? videoClicks2.getClickThrough() : null;
        VastVideoClicksDto videoClicks3 = linear.getVideoClicks();
        List plus2 = ListKt.plus((List) (videoClicks3 != null ? videoClicks3.getClickTrackingList() : null), (List) (wrapperVideoClicks != null ? wrapperVideoClicks.getClickTrackingList() : null));
        VastVideoClicksDto videoClicks4 = linear.getVideoClicks();
        VastVideoClicksDto vastVideoClicksDto = new VastVideoClicksDto(clickThrough2, plus2, ListKt.plus((List) (videoClicks4 != null ? videoClicks4.getCustomClickList() : null), (List) (wrapperVideoClicks != null ? wrapperVideoClicks.getCustomClickList() : null)));
        VastOffset skipOffset = linear.getSkipOffset();
        String mediaFileUrl = vastMediaFileDto2.getMediaFileUrl();
        VAST vast = VAST;
        return new VastCreative.Linear(creativeId, skipOffset, mediaFileUrl, url, vast.toClickTrackUrls(vastVideoClicksDto), vast.createLinearTracking(plus), prepareIcon(linear.getIcons()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PreparedWrapperDataForInline prepareWrapperDataForInline(AggregatedWrapperChainAdData aggregatedWrapperChainData) {
        List<List<VastCreativeDto>> creativesPerWrapper;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        if (aggregatedWrapperChainData != null && (creativesPerWrapper = aggregatedWrapperChainData.getCreativesPerWrapper()) != null) {
            Iterator<T> it = creativesPerWrapper.iterator();
            while (it.hasNext()) {
                List list = (List) it.next();
                ArrayList arrayList6 = new ArrayList();
                ArrayList arrayList7 = new ArrayList();
                ArrayList arrayList8 = new ArrayList();
                for (Object obj : list) {
                    if (!VAST.getHasApiFramework((VastCreativeDto) obj)) {
                        arrayList8.add(obj);
                    }
                }
                for (VastCreativeDto vastCreativeDto : CollectionsKt.sortedWith(arrayList8, new Comparator() { // from class: io.adn.sdk.internal.data.repository.VastLoaderImpl$prepareWrapperDataForInline$lambda$17$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((VastCreativeDto) t).getSequence(), ((VastCreativeDto) t2).getSequence());
                    }
                })) {
                    VastCreativeChildDto child = vastCreativeDto.getChild();
                    if (child instanceof VastCreativeChildDto.Linear) {
                        VastLinearDto linear = ((VastCreativeChildDto.Linear) vastCreativeDto.getChild()).getLinear();
                        CollectionsKt.addAll(arrayList, linear.getTrackingList());
                        VastVideoClicksDto videoClicks = linear.getVideoClicks();
                        if (videoClicks != null) {
                            CollectionsKt.addAll(arrayList2, videoClicks.getClickTrackingList());
                            CollectionsKt.addAll(arrayList3, videoClicks.getCustomClickList());
                        }
                        CollectionsKt.addAll(arrayList6, linear.getIcons());
                    } else {
                        if (!(child instanceof VastCreativeChildDto.Companions)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        CollectionsKt.addAll(arrayList7, ((VastCreativeChildDto.Companions) vastCreativeDto.getChild()).getCompanions());
                    }
                }
                arrayList4.add(arrayList6);
                arrayList5.add(arrayList7);
            }
        }
        return new PreparedWrapperDataForInline(arrayList, new VastVideoClicksDto(null, arrayList2, arrayList3), arrayList4, arrayList5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VastLoader.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001BG\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00030\u0003\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00030\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, d2 = {"Lio/adn/sdk/internal/data/repository/VastLoaderImpl$PreparedWrapperDataForInline;", "", "linearTrackingList", "", "Lio/adn/sdk/internal/domain/model/ad/VastTracking;", "videoClicks", "Lio/adn/sdk/internal/data/dto/VastVideoClicksDto;", "iconsPerWrapper", "Lio/adn/sdk/internal/data/dto/VastIconDto;", "companionsPerWrapper", "Lio/adn/sdk/internal/data/dto/VastCompanionDto;", "<init>", "(Ljava/util/List;Lio/adn/sdk/internal/data/dto/VastVideoClicksDto;Ljava/util/List;Ljava/util/List;)V", "getLinearTrackingList", "()Ljava/util/List;", "getVideoClicks", "()Lio/adn/sdk/internal/data/dto/VastVideoClicksDto;", "getIconsPerWrapper", "getCompanionsPerWrapper", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    static final class PreparedWrapperDataForInline {
        private final List<List<VastCompanionDto>> companionsPerWrapper;
        private final List<List<VastIconDto>> iconsPerWrapper;
        private final List<VastTracking> linearTrackingList;
        private final VastVideoClicksDto videoClicks;

        /* JADX WARN: Multi-variable type inference failed */
        public PreparedWrapperDataForInline(List<VastTracking> linearTrackingList, VastVideoClicksDto vastVideoClicksDto, List<? extends List<VastIconDto>> iconsPerWrapper, List<? extends List<VastCompanionDto>> companionsPerWrapper) {
            Intrinsics.checkNotNullParameter(linearTrackingList, "linearTrackingList");
            Intrinsics.checkNotNullParameter(iconsPerWrapper, "iconsPerWrapper");
            Intrinsics.checkNotNullParameter(companionsPerWrapper, "companionsPerWrapper");
            this.linearTrackingList = linearTrackingList;
            this.videoClicks = vastVideoClicksDto;
            this.iconsPerWrapper = iconsPerWrapper;
            this.companionsPerWrapper = companionsPerWrapper;
        }

        public final List<VastTracking> getLinearTrackingList() {
            return this.linearTrackingList;
        }

        public final VastVideoClicksDto getVideoClicks() {
            return this.videoClicks;
        }

        public final List<List<VastIconDto>> getIconsPerWrapper() {
            return this.iconsPerWrapper;
        }

        public final List<List<VastCompanionDto>> getCompanionsPerWrapper() {
            return this.companionsPerWrapper;
        }
    }

    private final VastCreative.Companion prepareCompanion(List<VastCompanionDto> companions) {
        Object obj;
        List<String> emptyList;
        Iterator<T> it = companions.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            VastCompanionDto vastCompanionDto = (VastCompanionDto) obj;
            if (!VAST.getHasApiFramework(vastCompanionDto) && !vastCompanionDto.getResources().isEmpty()) {
                break;
            }
        }
        VastCompanionDto vastCompanionDto2 = (VastCompanionDto) obj;
        if (vastCompanionDto2 == null) {
            return null;
        }
        String id = vastCompanionDto2.getId();
        List<VastResource> resources = vastCompanionDto2.getResources();
        String type = vastCompanionDto2.getType();
        VastCompanionClicksDto clicks = vastCompanionDto2.getClicks();
        String clickThroughUrl = clicks != null ? clicks.getClickThroughUrl() : null;
        VastCompanionClicksDto clicks2 = vastCompanionDto2.getClicks();
        if (clicks2 == null || (emptyList = clicks2.getClickTrackingUrls()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        List<String> list = emptyList;
        List<VastTracking> creativeViewTrackingList = vastCompanionDto2.getCreativeViewTrackingList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(creativeViewTrackingList, 10));
        Iterator<T> it2 = creativeViewTrackingList.iterator();
        while (it2.hasNext()) {
            arrayList.add(((VastTracking) it2.next()).getUrl());
        }
        return new VastCreative.Companion(id, resources, type, clickThroughUrl, list, arrayList);
    }

    private final VastIcon prepareIcon(List<VastIconDto> icons) {
        Object obj;
        List<String> emptyList;
        Iterator<T> it = icons.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!VAST.getHasApiFramework((VastIconDto) obj)) {
                break;
            }
        }
        VastIconDto vastIconDto = (VastIconDto) obj;
        if (vastIconDto == null) {
            return null;
        }
        VastResource resource = vastIconDto.getResource();
        Integer widthPx = vastIconDto.getWidthPx();
        int intValue = widthPx != null ? widthPx.intValue() : 0;
        Integer heightPx = vastIconDto.getHeightPx();
        int intValue2 = heightPx != null ? heightPx.intValue() : 0;
        VastIconClicksDto clicks = vastIconDto.getClicks();
        String clickThroughUrl = clicks != null ? clicks.getClickThroughUrl() : null;
        VastIconClicksDto clicks2 = vastIconDto.getClicks();
        if (clicks2 == null || (emptyList = clicks2.getClickTrackingUrlList()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        return new VastIcon(resource, intValue, intValue2, clickThroughUrl, emptyList, vastIconDto.getViewTrackingUrlList(), vastIconDto.getDurationMillis(), vastIconDto.getOffset());
    }

    private final List<VastExtension> prepareExtension(List<VastExtensionDto> extensions) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = extensions.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((VastExtensionDto) it.next()).getCustomEvents());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : arrayList) {
            String name = ((VastCustomEventDto) obj).getName();
            Object obj2 = linkedHashMap.get(name);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(name, obj2);
            }
            ((List) obj2).add(obj);
        }
        ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList3.add(((VastCustomEventDto) it2.next()).getUrl());
            }
            arrayList2.add(new VastExtension(str, arrayList3));
        }
        return arrayList2;
    }

    /* compiled from: VastLoader.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J,\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t*\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\t*\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\rH\u0002J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\t*\u0004\u0018\u00010\u0013H\u0002J0\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H!0 \"\u0004\b\u0000\u0010!*\n\u0012\u0004\u0012\u0002H!\u0018\u00010 2\b\u0010\"\u001a\u0004\u0018\u0001H!H\u0082\u0002¢\u0006\u0002\u0010#R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\u00020\u0015*\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0014\u001a\u00020\u0015*\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u001aR\u0018\u0010\u0014\u001a\u00020\u0015*\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u001cR\u0018\u0010\u0014\u001a\u00020\u0015*\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u001e¨\u0006$"}, d2 = {"Lio/adn/sdk/internal/data/repository/VastLoaderImpl$VAST;", "", "<init>", "()V", "WRAPPER_DEPTH_MAX", "", "createLinearTracking", "Lio/adn/sdk/internal/domain/model/ad/VastLinearTracking;", "trackingList", "", "Lio/adn/sdk/internal/domain/model/ad/VastTracking;", "toUrls", "", "", "Lio/adn/sdk/internal/domain/model/ad/VastTrackingEvent;", "eventType", "toLinearProgressTracking", "Lio/adn/sdk/internal/domain/model/ad/VastProgressTracking;", "toClickTrackUrls", "Lio/adn/sdk/internal/data/dto/VastVideoClicksDto;", "hasApiFramework", "", "Lio/adn/sdk/internal/data/dto/VastCreativeDto;", "getHasApiFramework", "(Lio/adn/sdk/internal/data/dto/VastCreativeDto;)Z", "Lio/adn/sdk/internal/data/dto/VastCompanionDto;", "(Lio/adn/sdk/internal/data/dto/VastCompanionDto;)Z", "Lio/adn/sdk/internal/data/dto/VastMediaFileDto;", "(Lio/adn/sdk/internal/data/dto/VastMediaFileDto;)Z", "Lio/adn/sdk/internal/data/dto/VastIconDto;", "(Lio/adn/sdk/internal/data/dto/VastIconDto;)Z", "plus", "", "T", "item", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class VAST {
        public /* synthetic */ VAST(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private VAST() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final VastLinearTracking createLinearTracking(List<VastTracking> trackingList) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : trackingList) {
                VastTrackingEvent event = ((VastTracking) obj).getEvent();
                Object obj2 = linkedHashMap.get(event);
                if (obj2 == null) {
                    obj2 = (List) new ArrayList();
                    linkedHashMap.put(event, obj2);
                }
                ((List) obj2).add(obj);
            }
            return new VastLinearTracking(toUrls(linkedHashMap, VastTrackingEvent.CreativeView), toUrls(linkedHashMap, VastTrackingEvent.Start), toUrls(linkedHashMap, VastTrackingEvent.FirstQuartile), toUrls(linkedHashMap, VastTrackingEvent.Midpoint), toUrls(linkedHashMap, VastTrackingEvent.ThirdQuartile), toUrls(linkedHashMap, VastTrackingEvent.Complete), toUrls(linkedHashMap, VastTrackingEvent.Mute), toUrls(linkedHashMap, VastTrackingEvent.UnMute), toUrls(linkedHashMap, VastTrackingEvent.Pause), toUrls(linkedHashMap, VastTrackingEvent.Resume), toUrls(linkedHashMap, VastTrackingEvent.Rewind), toUrls(linkedHashMap, VastTrackingEvent.Skip), toUrls(linkedHashMap, VastTrackingEvent.CloseLinear), toLinearProgressTracking(linkedHashMap));
        }

        private final List<String> toUrls(Map<VastTrackingEvent, ? extends List<VastTracking>> map, VastTrackingEvent vastTrackingEvent) {
            List<VastTracking> list = map.get(vastTrackingEvent);
            if (list == null) {
                return CollectionsKt.emptyList();
            }
            List<VastTracking> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((VastTracking) it.next()).getUrl());
            }
            return arrayList;
        }

        private final List<VastProgressTracking> toLinearProgressTracking(Map<VastTrackingEvent, ? extends List<VastTracking>> map) {
            List<VastTracking> list = map.get(VastTrackingEvent.Progress);
            if (list == null) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (VastTracking vastTracking : list) {
                VastProgressTracking vastProgressTracking = vastTracking.getOffset() == null ? null : new VastProgressTracking(vastTracking.getUrl(), vastTracking.getOffset());
                if (vastProgressTracking != null) {
                    arrayList.add(vastProgressTracking);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<String> toClickTrackUrls(VastVideoClicksDto vastVideoClicksDto) {
            List<VastVideoClickDto> clickTrackingList;
            if (vastVideoClicksDto == null || (clickTrackingList = vastVideoClicksDto.getClickTrackingList()) == null) {
                return CollectionsKt.emptyList();
            }
            List<VastVideoClickDto> list = clickTrackingList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((VastVideoClickDto) it.next()).getUrl());
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getHasApiFramework(VastCreativeDto vastCreativeDto) {
            String apiFramework = vastCreativeDto.getApiFramework();
            return !(apiFramework == null || StringsKt.isBlank(apiFramework));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getHasApiFramework(VastCompanionDto vastCompanionDto) {
            String apiFramework = vastCompanionDto.getApiFramework();
            return !(apiFramework == null || StringsKt.isBlank(apiFramework));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getHasApiFramework(VastMediaFileDto vastMediaFileDto) {
            String apiFramework = vastMediaFileDto.getApiFramework();
            return !(apiFramework == null || StringsKt.isBlank(apiFramework));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getHasApiFramework(VastIconDto vastIconDto) {
            String apiFramework = vastIconDto.getApiFramework();
            return !(apiFramework == null || StringsKt.isBlank(apiFramework));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <T> Set<T> plus(Set<? extends T> set, T t) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (set != null) {
                CollectionsKt.addAll(linkedHashSet, set);
            }
            if (t != null) {
                linkedHashSet.add(t);
            }
            return linkedHashSet;
        }
    }
}
