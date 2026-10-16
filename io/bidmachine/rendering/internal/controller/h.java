package io.bidmachine.rendering.internal.controller;

import android.content.Context;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C3061e8;
import com.ironsource.C3207n2;
import com.ironsource.D5;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import io.bidmachine.iab.vast.tags.VastTagName;
import io.bidmachine.rendering.Rendering;
import io.bidmachine.rendering.internal.InterfaceC3590c;
import io.bidmachine.rendering.internal.v;
import io.bidmachine.rendering.internal.w;
import io.bidmachine.rendering.internal.x;
import io.bidmachine.rendering.internal.y;
import io.bidmachine.rendering.model.AdElementParams;
import io.bidmachine.rendering.model.AdPhaseParams;
import io.bidmachine.rendering.model.AnimationEventType;
import io.bidmachine.rendering.model.BrokenCreativeDetectorParams;
import io.bidmachine.rendering.model.BrokenCreativeEvent;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.MethodParams;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.rendering.utils.NetworkRequest;
import io.bidmachine.rendering.utils.Tag;
import io.bidmachine.rendering.utils.UiUtils;
import io.bidmachine.rendering.utils.UrlHandler;
import io.bidmachine.rendering.utils.VisibilityChanger;
import io.bidmachine.rendering.utils.taskmanager.CancelableTask;
import io.bidmachine.util.taskmanager.TaskManager;
import io.bidmachine.util.taskmanager.coroutine.CoroutineTaskManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 ¤\u00012\u00020\u0001:\u0007\u0013H',_DOB7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0013\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u0013\u0010\u001dJ\u0017\u0010\u0013\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\u0013\u0010 J\u001f\u0010\u0013\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0002¢\u0006\u0004\b\u0013\u0010$J'\u0010\u0013\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010%\u001a\u00020!H\u0002¢\u0006\u0004\b\u0013\u0010&J\u000f\u0010'\u001a\u00020\u001cH\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0013\u001a\u00020\u00172\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b\u0013\u0010+J\u000f\u0010,\u001a\u00020\u001cH\u0016¢\u0006\u0004\b,\u0010(J\u0017\u0010\u0013\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0013\u0010.J\u000f\u0010/\u001a\u00020\u001cH\u0016¢\u0006\u0004\b/\u0010(J\u000f\u0010\u0013\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u0013\u0010(J\u000f\u00100\u001a\u00020!H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0017H\u0007¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u001cH\u0007¢\u0006\u0004\b4\u0010(J\u000f\u00105\u001a\u00020\u001cH\u0007¢\u0006\u0004\b5\u0010(J\u0017\u0010\u0013\u001a\u0002072\u0006\u00106\u001a\u00020!H\u0007¢\u0006\u0004\b\u0013\u00108J+\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020=092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0010092\u0006\u0010<\u001a\u00020;H\u0007¢\u0006\u0004\b\u0013\u0010>J\u001f\u0010\u0013\u001a\u00020@2\u0006\u0010?\u001a\u00020\u00102\u0006\u0010<\u001a\u00020;H\u0007¢\u0006\u0004\b\u0013\u0010AJ\u001f\u0010\u0013\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020@2\u0006\u0010<\u001a\u00020;H\u0007¢\u0006\u0004\b\u0013\u0010CJ\u000f\u0010D\u001a\u00020\u001cH\u0007¢\u0006\u0004\bD\u0010(J!\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020@2\b\b\u0002\u0010E\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0013\u0010FJ\u001f\u0010H\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020=2\u0006\u0010G\u001a\u00020\u0017H\u0007¢\u0006\u0004\bH\u0010IJ%\u0010H\u001a\u00020\u001c2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020=092\u0006\u0010G\u001a\u00020\u0017H\u0007¢\u0006\u0004\bH\u0010KJ\u001f\u0010\u0013\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020=2\u0006\u0010G\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0013\u0010IJ%\u0010\u0013\u001a\u00020\u001c2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020=092\u0006\u0010G\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0013\u0010KJ)\u0010\u0013\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020=2\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010LH\u0007¢\u0006\u0004\b\u0013\u0010MJ\u001d\u0010\u0013\u001a\u00020\u001c2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020=0LH\u0007¢\u0006\u0004\b\u0013\u0010NJ\u000f\u0010O\u001a\u00020\u001cH\u0007¢\u0006\u0004\bO\u0010(J3\u0010\u0013\u001a\u00020\u001c\"\b\b\u0000\u0010Q*\u00020P2\u0006\u0010\u0016\u001a\u00020P2\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010LH\u0007¢\u0006\u0004\b\u0013\u0010RJ'\u0010H\u001a\u00020\u001c\"\b\b\u0000\u0010Q*\u00020P2\f\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000LH\u0007¢\u0006\u0004\bH\u0010NJ\u000f\u0010S\u001a\u00020\u001cH\u0007¢\u0006\u0004\bS\u0010(J\u0017\u0010\u0013\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020TH\u0007¢\u0006\u0004\b\u0013\u0010VJ\u0019\u0010H\u001a\u0004\u0018\u00010X2\u0006\u0010W\u001a\u00020!H\u0007¢\u0006\u0004\bH\u0010YR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010ZR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010[R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010\\R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010]R\u001c\u0010a\u001a\n ^*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010d\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010cR\u001a\u0010h\u001a\u00020e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bO\u0010f\u001a\u0004\b_\u0010gR$\u0010o\u001a\u0004\u0018\u00010i8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\b\u0013\u0010nR \u0010v\u001a\u00020p8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bq\u0010r\u0012\u0004\bu\u0010(\u001a\u0004\bs\u0010tR\u0017\u0010|\u001a\u00020w8\u0006¢\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{R\u001e\u0010\u0082\u0001\u001a\u00020}8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001e\u0010\u0085\u0001\u001a\u00020P8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010\u007f\u001a\u0005\b~\u0010\u0084\u0001R&\u0010\u008b\u0001\u001a\u00030\u0086\u00018\u0006X\u0087\u0004¢\u0006\u0016\n\u0005\bl\u0010\u0087\u0001\u0012\u0005\b\u008a\u0001\u0010(\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R%\u0010\u008f\u0001\u001a\u0010\u0012\u0004\u0012\u00020=\u0012\u0005\u0012\u00030\u008d\u00010\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u008e\u0001R*\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020=0L8\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b2\u0010\u0090\u0001\u0012\u0005\b\u0092\u0001\u0010(\u001a\u0005\bq\u0010\u0091\u0001R*\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020=0L8\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b4\u0010\u0090\u0001\u0012\u0005\b\u0094\u0001\u0010(\u001a\u0005\bx\u0010\u0091\u0001R,\u0010\u0098\u0001\u001a\t\u0012\u0005\u0012\u00030\u0096\u00010L8\u0006X\u0087\u0004¢\u0006\u0016\n\u0005\b5\u0010\u0090\u0001\u0012\u0005\b\u0097\u0001\u0010(\u001a\u0006\b\u0083\u0001\u0010\u0091\u0001R%\u0010\u009c\u0001\u001a\u00030\u0099\u00018FX\u0087\u0084\u0002¢\u0006\u0014\n\u0004\bS\u0010\u007f\u0012\u0005\b\u009b\u0001\u0010(\u001a\u0005\bj\u0010\u009a\u0001R\u001b\u0010\u009f\u0001\u001a\u00030\u009d\u0001*\u00020\u00008BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bj\u0010\u009e\u0001R\u001b\u0010¢\u0001\u001a\u00030 \u0001*\u00020\u00008BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bO\u0010¡\u0001R\u0015\u0010£\u0001\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u00103¨\u0006¥\u0001"}, d2 = {"Lio/bidmachine/rendering/internal/controller/h;", "Lio/bidmachine/rendering/internal/controller/e;", "Landroid/content/Context;", "context", "Lio/bidmachine/rendering/model/AdPhaseParams;", "adPhaseParams", "Lio/bidmachine/rendering/utils/Tag;", "tag", "Lio/bidmachine/rendering/internal/state/c;", "adState", "Lio/bidmachine/rendering/internal/controller/f;", "adPhaseControllerListener", "Lio/bidmachine/rendering/internal/animation/b;", "adAnimationController", "<init>", "(Landroid/content/Context;Lio/bidmachine/rendering/model/AdPhaseParams;Lio/bidmachine/rendering/utils/Tag;Lio/bidmachine/rendering/internal/state/c;Lio/bidmachine/rendering/internal/controller/f;Lio/bidmachine/rendering/internal/animation/b;)V", "Lio/bidmachine/rendering/model/AdElementParams;", "adElementParams", "Lio/bidmachine/rendering/internal/detector/brokencreative/a;", "a", "(Lio/bidmachine/rendering/model/AdElementParams;)Lio/bidmachine/rendering/internal/detector/brokencreative/a;", "Lio/bidmachine/rendering/utils/VisibilityChanger;", "item", "", C3061e8.k, "isSkip", "Ljava/lang/Runnable;", "action", "", "(Lio/bidmachine/rendering/utils/VisibilityChanger;ZZLjava/lang/Runnable;)V", "Lio/bidmachine/rendering/model/BrokenCreativeEvent;", "brokenCreativeEvent", "(Lio/bidmachine/rendering/model/BrokenCreativeEvent;)V", "", "eventTaskName", "targetElementName", "(Ljava/lang/String;Ljava/lang/String;)V", "className", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "c", "()V", "Landroid/view/ViewGroup;", "container", "(Landroid/view/ViewGroup;)Z", "d", "isFinishing", "(Z)V", "onShown", "toString", "()Ljava/lang/String;", "o", "()Z", "p", CampaignEx.JSON_KEY_AD_Q, "sourceName", "Lio/bidmachine/rendering/internal/event/b;", "(Ljava/lang/String;)Lio/bidmachine/rendering/internal/event/b;", "", "elementsParams", "Lio/bidmachine/rendering/internal/adform/c;", "adFormListener", "Lio/bidmachine/rendering/internal/c;", "(Ljava/util/List;Lio/bidmachine/rendering/internal/adform/c;)Ljava/util/List;", "elementParams", "Lio/bidmachine/rendering/internal/adform/a;", "(Lio/bidmachine/rendering/model/AdElementParams;Lio/bidmachine/rendering/internal/adform/c;)Lio/bidmachine/rendering/internal/adform/a;", "adForm", "(Lio/bidmachine/rendering/internal/adform/a;Lio/bidmachine/rendering/internal/adform/c;)V", InneractiveMediationDefs.GENDER_FEMALE, "allowPostponed", "(Lio/bidmachine/rendering/internal/adform/a;Z)Z", "animated", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lio/bidmachine/rendering/internal/c;Z)V", FirebaseAnalytics.Param.ITEMS, "(Ljava/util/List;Z)V", "", "(Lio/bidmachine/rendering/internal/c;Ljava/util/List;)V", "(Ljava/util/List;)V", "g", "Lio/bidmachine/rendering/internal/y;", "T", "(Lio/bidmachine/rendering/internal/y;Ljava/util/List;)V", "r", "Lio/bidmachine/rendering/model/Error;", "error", "(Lio/bidmachine/rendering/model/Error;)V", "name", "", "(Ljava/lang/String;)Ljava/lang/Object;", "Lio/bidmachine/rendering/utils/Tag;", "Lio/bidmachine/rendering/internal/state/c;", "Lio/bidmachine/rendering/internal/controller/f;", "Lio/bidmachine/rendering/internal/animation/b;", "kotlin.jvm.PlatformType", "e", "Landroid/content/Context;", "applicationContext", "Lio/bidmachine/rendering/internal/repository/a;", "Lio/bidmachine/rendering/internal/repository/a;", "repository", "Lio/bidmachine/rendering/internal/d;", "Lio/bidmachine/rendering/internal/d;", "()Lio/bidmachine/rendering/internal/d;", "adPhase", "Lio/bidmachine/rendering/internal/controller/g;", "h", "Lio/bidmachine/rendering/internal/controller/g;", "m", "()Lio/bidmachine/rendering/internal/controller/g;", "(Lio/bidmachine/rendering/internal/controller/g;)V", "presentListener", "Lio/bidmachine/rendering/internal/event/f;", "i", "Lio/bidmachine/rendering/internal/event/f;", "getEventTaskExecutor", "()Lio/bidmachine/rendering/internal/event/f;", "getEventTaskExecutor$annotations", "eventTaskExecutor", "Lio/bidmachine/rendering/internal/detector/brokencreative/b;", com.mbridge.msdk.foundation.same.report.j.b, "Lio/bidmachine/rendering/internal/detector/brokencreative/b;", "getBrokenCreativeDetectorListener", "()Lio/bidmachine/rendering/internal/detector/brokencreative/b;", "brokenCreativeDetectorListener", "Lio/bidmachine/rendering/internal/groups/b;", CampaignEx.JSON_KEY_AD_K, "Lkotlin/Lazy;", D5.q, "()Lio/bidmachine/rendering/internal/groups/b;", "stateGroupController", "l", "()Lio/bidmachine/rendering/internal/y;", "internalTargetObject", "Lio/bidmachine/util/taskmanager/TaskManager;", "Lio/bidmachine/util/taskmanager/TaskManager;", "getLoadAdTaskManager", "()Lio/bidmachine/util/taskmanager/TaskManager;", "getLoadAdTaskManager$annotations", "loadAdTaskManager", "", "Lio/bidmachine/rendering/utils/taskmanager/CancelableTask;", "Ljava/util/Map;", "loadAdTaskMap", "Ljava/util/List;", "()Ljava/util/List;", "getAdsList$annotations", "adsList", "getControlsList$annotations", "controlsList", "Lio/bidmachine/rendering/internal/p;", "getMethodsList$annotations", "methodsList", "Lio/bidmachine/rendering/internal/adform/b;", "()Lio/bidmachine/rendering/internal/adform/b;", "getAdFormFactory$annotations", "adFormFactory", "Lkotlinx/coroutines/CoroutineScope;", "(Lio/bidmachine/rendering/internal/controller/h;)Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lio/bidmachine/rendering/internal/h;", "(Lio/bidmachine/rendering/internal/controller/h;)Lio/bidmachine/rendering/internal/h;", "coroutineDispatchers", "isLoaded", "s", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class h implements io.bidmachine.rendering.internal.controller.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Tag tag;

    /* renamed from: b, reason: from kotlin metadata */
    private final io.bidmachine.rendering.internal.state.c adState;

    /* renamed from: c, reason: from kotlin metadata */
    private final io.bidmachine.rendering.internal.controller.f adPhaseControllerListener;

    /* renamed from: d, reason: from kotlin metadata */
    private final io.bidmachine.rendering.internal.animation.b adAnimationController;

    /* renamed from: e, reason: from kotlin metadata */
    private final Context applicationContext;

    /* renamed from: f, reason: from kotlin metadata */
    private final io.bidmachine.rendering.internal.repository.a repository;

    /* renamed from: g, reason: from kotlin metadata */
    private final io.bidmachine.rendering.internal.d adPhase;

    /* renamed from: h, reason: from kotlin metadata */
    private io.bidmachine.rendering.internal.controller.g presentListener;

    /* renamed from: i, reason: from kotlin metadata */
    private final io.bidmachine.rendering.internal.event.f eventTaskExecutor;

    /* renamed from: j, reason: from kotlin metadata */
    private final io.bidmachine.rendering.internal.detector.brokencreative.b brokenCreativeDetectorListener;

    /* renamed from: k, reason: from kotlin metadata */
    private final Lazy stateGroupController;

    /* renamed from: l, reason: from kotlin metadata */
    private final Lazy internalTargetObject;

    /* renamed from: m, reason: from kotlin metadata */
    private final TaskManager loadAdTaskManager;

    /* renamed from: n, reason: from kotlin metadata */
    private final Map<InterfaceC3590c, CancelableTask> loadAdTaskMap;

    /* renamed from: o, reason: from kotlin metadata */
    private final List<InterfaceC3590c> adsList;

    /* renamed from: p, reason: from kotlin metadata */
    private final List<InterfaceC3590c> controlsList;

    /* renamed from: q, reason: from kotlin metadata */
    private final List<io.bidmachine.rendering.internal.p> methodsList;

    /* renamed from: r, reason: from kotlin metadata */
    private final Lazy adFormFactory;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b¢\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\r\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\r\u0010\fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\u0007\u0010\f¨\u0006\u000e"}, d2 = {"Lio/bidmachine/rendering/internal/controller/h$b;", "Lio/bidmachine/rendering/internal/adform/c;", "<init>", "(Lio/bidmachine/rendering/internal/controller/h;)V", "Lio/bidmachine/rendering/internal/adform/a;", "adForm", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lio/bidmachine/rendering/internal/adform/a;)V", "Lio/bidmachine/rendering/model/Error;", "error", "c", "(Lio/bidmachine/rendering/internal/adform/a;Lio/bidmachine/rendering/model/Error;)V", "a", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private abstract class b implements io.bidmachine.rendering.internal.adform.c {
        public b() {
        }

        @Override // io.bidmachine.rendering.internal.adform.c
        public void a(io.bidmachine.rendering.internal.adform.a adForm) {
            Intrinsics.checkNotNullParameter(adForm, "adForm");
            io.bidmachine.rendering.internal.o.b(h.this.tag, "AdsElement (" + adForm + ") - onAdFormShown", new Object[0]);
        }

        @Override // io.bidmachine.rendering.internal.adform.c
        public void b(io.bidmachine.rendering.internal.adform.a adForm) {
            Intrinsics.checkNotNullParameter(adForm, "adForm");
            io.bidmachine.rendering.internal.o.b(h.this.tag, "AdsElement (" + adForm + ") - onAdFormLoaded", new Object[0]);
            h.this.loadAdTaskMap.remove(adForm);
        }

        @Override // io.bidmachine.rendering.internal.adform.c
        public void c(io.bidmachine.rendering.internal.adform.a adForm, Error error) {
            Intrinsics.checkNotNullParameter(adForm, "adForm");
            Intrinsics.checkNotNullParameter(error, "error");
            io.bidmachine.rendering.internal.o.a(h.this.tag, "AdsElement (" + adForm + ") - onAdFormFailToLoad - " + error, new Object[0]);
            h.this.loadAdTaskMap.remove(adForm);
        }

        @Override // io.bidmachine.rendering.internal.adform.c
        public void a(io.bidmachine.rendering.internal.adform.a adForm, Error error) {
            Intrinsics.checkNotNullParameter(adForm, "adForm");
            Intrinsics.checkNotNullParameter(error, "error");
            io.bidmachine.rendering.internal.o.a(h.this.tag, "AdsElement (" + adForm + ") - onAdFormFailToShow - " + error, new Object[0]);
        }

        @Override // io.bidmachine.rendering.internal.adform.c
        public void b(io.bidmachine.rendering.internal.adform.a adForm, Error error) {
            Intrinsics.checkNotNullParameter(adForm, "adForm");
            Intrinsics.checkNotNullParameter(error, "error");
            io.bidmachine.rendering.internal.o.a(h.this.tag, "AdsElement (" + adForm + ") - onAdFormExpired - " + error, new Object[0]);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/bidmachine/rendering/internal/controller/h$c;", "Lio/bidmachine/rendering/internal/detector/brokencreative/b;", "<init>", "(Lio/bidmachine/rendering/internal/controller/h;)V", "Lio/bidmachine/rendering/model/BrokenCreativeEvent;", "brokenCreativeEvent", "", "a", "(Lio/bidmachine/rendering/model/BrokenCreativeEvent;)V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private final class c implements io.bidmachine.rendering.internal.detector.brokencreative.b {
        public c() {
        }

        @Override // io.bidmachine.rendering.internal.detector.brokencreative.b
        public void a(BrokenCreativeEvent brokenCreativeEvent) {
            Intrinsics.checkNotNullParameter(brokenCreativeEvent, "brokenCreativeEvent");
            h.this.a(brokenCreativeEvent);
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\u000fJ!\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\r\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\r\u0010\u0014J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\nJ!\u0010\f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\f\u0010\u0014J!\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J/\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u0015\u0010\u001bJ\u001f\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0015\u0010\u001dJ!\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u001fJ\u001f\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\u0015\u0010\"J\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010#\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\nJ\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b\u0015\u0010&J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\nR\u0014\u0010)\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010(¨\u0006*"}, d2 = {"Lio/bidmachine/rendering/internal/controller/h$f;", "Lio/bidmachine/rendering/internal/event/f;", "Landroid/content/Context;", "context", "<init>", "(Lio/bidmachine/rendering/internal/controller/h;Landroid/content/Context;)V", "", "url", "", "h", "(Ljava/lang/String;)V", "g", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "d", "e", "()V", "targetElementName", "", "senderId", "c", "(Ljava/lang/String;Ljava/lang/Integer;)V", "a", "", "maxProgressMs", "currentProgressMs", "", "percent", "(Ljava/lang/String;JJF)V", "timeMs", "(Ljava/lang/String;J)V", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "", "lockVisibility", "(Ljava/lang/String;Z)V", InneractiveMediationDefs.GENDER_FEMALE, "Lio/bidmachine/rendering/model/PrivacySheetParams;", "privacySheetParams", "(Lio/bidmachine/rendering/model/PrivacySheetParams;)V", "stateGroups", "Landroid/content/Context;", "applicationContext", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private final class f implements io.bidmachine.rendering.internal.event.f {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Context applicationContext;
        final /* synthetic */ h b;

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        public static final class a implements io.bidmachine.rendering.internal.n {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f6995a;

            public a(Object obj) {
                this.f6995a = obj;
            }

            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                ((io.bidmachine.rendering.internal.g) this.f6995a).b();
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        public static final class b implements io.bidmachine.rendering.internal.n {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f6996a;

            public b(Object obj) {
                this.f6996a = obj;
            }

            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                ((io.bidmachine.rendering.internal.g) this.f6996a).b();
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        public static final class c implements io.bidmachine.rendering.internal.n {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f6997a;

            public c(Object obj) {
                this.f6997a = obj;
            }

            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                ((io.bidmachine.rendering.internal.g) this.f6997a).b();
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        public static final class d implements io.bidmachine.rendering.internal.n {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f6998a;

            public d(Object obj) {
                this.f6998a = obj;
            }

            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                ((io.bidmachine.rendering.internal.g) this.f6998a).b();
            }
        }

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "io.bidmachine.rendering.internal.controller.DefaultAdPhaseController$EventTaskExecutorImpl$hide$$inlined$executeAction$1", f = "DefaultAdPhaseController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f6999a;
            final /* synthetic */ h b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ Class e;
            final /* synthetic */ String f;
            final /* synthetic */ h g;
            final /* synthetic */ Integer h;

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            public static final class a implements io.bidmachine.rendering.internal.n {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Object f7000a;
                final /* synthetic */ h b;
                final /* synthetic */ Integer c;

                public a(Object obj, h hVar, Integer num) {
                    this.f7000a = obj;
                    this.b = hVar;
                    this.c = num;
                }

                @Override // io.bidmachine.util.SafeRunnable
                public final void onRun() {
                    VisibilityChanger visibilityChanger = (VisibilityChanger) this.f7000a;
                    this.b.a(visibilityChanger, false, this.c != null, (Runnable) new C0616f(visibilityChanger));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(h hVar, String str, String str2, Class cls, String str3, Continuation continuation, h hVar2, Integer num) {
                super(2, continuation);
                this.b = hVar;
                this.c = str;
                this.d = str2;
                this.e = cls;
                this.f = str3;
                this.g = hVar2;
                this.h = num;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new e(this.b, this.c, this.d, this.e, this.f, continuation, this.g, this.h);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f6999a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Object b = this.b.b(this.c);
                if (b == null) {
                    this.b.a(this.d, this.c);
                } else if (!this.e.isInstance(b)) {
                    this.b.a(this.d, this.c, this.f);
                } else if (this.e.isInstance(b)) {
                    UiUtils.onUiThread(new a(b, this.g, this.h));
                }
                return Unit.INSTANCE;
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onRun"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: io.bidmachine.rendering.internal.controller.h$f$f, reason: collision with other inner class name */
        static final class C0616f implements io.bidmachine.rendering.internal.n {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ VisibilityChanger f7001a;

            C0616f(VisibilityChanger visibilityChanger) {
                this.f7001a = visibilityChanger;
            }

            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                this.f7001a.setVisibility(false);
            }
        }

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "io.bidmachine.rendering.internal.controller.DefaultAdPhaseController$EventTaskExecutorImpl$lockVisibility$$inlined$executeAction$1", f = "DefaultAdPhaseController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f7002a;
            final /* synthetic */ h b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ Class e;
            final /* synthetic */ String f;
            final /* synthetic */ boolean g;

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            public static final class a implements io.bidmachine.rendering.internal.n {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Object f7003a;
                final /* synthetic */ boolean b;

                public a(Object obj, boolean z) {
                    this.f7003a = obj;
                    this.b = z;
                }

                @Override // io.bidmachine.util.SafeRunnable
                public final void onRun() {
                    ((VisibilityChanger) this.f7003a).lockVisibility(this.b);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public g(h hVar, String str, String str2, Class cls, String str3, Continuation continuation, boolean z) {
                super(2, continuation);
                this.b = hVar;
                this.c = str;
                this.d = str2;
                this.e = cls;
                this.f = str3;
                this.g = z;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new g(this.b, this.c, this.d, this.e, this.f, continuation, this.g);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7002a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Object b = this.b.b(this.c);
                if (b == null) {
                    this.b.a(this.d, this.c);
                } else if (!this.e.isInstance(b)) {
                    this.b.a(this.d, this.c, this.f);
                } else if (this.e.isInstance(b)) {
                    UiUtils.onUiThread(new a(b, this.g));
                }
                return Unit.INSTANCE;
            }
        }

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "io.bidmachine.rendering.internal.controller.DefaultAdPhaseController$EventTaskExecutorImpl$mute$$inlined$executeAction$1", f = "DefaultAdPhaseController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: io.bidmachine.rendering.internal.controller.h$f$h, reason: collision with other inner class name */
        public static final class C0617h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f7004a;
            final /* synthetic */ h b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ Class e;
            final /* synthetic */ String f;
            final /* synthetic */ Integer g;

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            /* renamed from: io.bidmachine.rendering.internal.controller.h$f$h$a */
            public static final class a implements io.bidmachine.rendering.internal.n {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Object f7005a;
                final /* synthetic */ Integer b;

                public a(Object obj, Integer num) {
                    this.f7005a = obj;
                    this.b = num;
                }

                @Override // io.bidmachine.util.SafeRunnable
                public final void onRun() {
                    ((io.bidmachine.rendering.internal.q) this.f7005a).b(this.b);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0617h(h hVar, String str, String str2, Class cls, String str3, Continuation continuation, Integer num) {
                super(2, continuation);
                this.b = hVar;
                this.c = str;
                this.d = str2;
                this.e = cls;
                this.f = str3;
                this.g = num;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0617h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0617h(this.b, this.c, this.d, this.e, this.f, continuation, this.g);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7004a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Object b = this.b.b(this.c);
                if (b == null) {
                    this.b.a(this.d, this.c);
                } else if (!this.e.isInstance(b)) {
                    this.b.a(this.d, this.c, this.f);
                } else if (this.e.isInstance(b)) {
                    UiUtils.onUiThread(new a(b, this.g));
                }
                return Unit.INSTANCE;
            }
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"io/bidmachine/rendering/internal/controller/h$f$i", "Lio/bidmachine/rendering/internal/m;", "", "input", "", "a", "(Z)V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class i implements io.bidmachine.rendering.internal.m<Boolean> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ h f7006a;

            i(h hVar) {
                this.f7006a = hVar;
            }

            public void a(boolean input) {
                io.bidmachine.rendering.internal.controller.g presentListener = this.f7006a.getPresentListener();
                if (presentListener != null) {
                    presentListener.c();
                }
            }

            @Override // io.bidmachine.util.SafeExecutable
            public /* bridge */ /* synthetic */ void onExecute(Object obj) {
                a(((Boolean) obj).booleanValue());
            }
        }

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "io.bidmachine.rendering.internal.controller.DefaultAdPhaseController$EventTaskExecutorImpl$progress$$inlined$executeAction$1", f = "DefaultAdPhaseController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f7007a;
            final /* synthetic */ h b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ Class e;
            final /* synthetic */ String f;
            final /* synthetic */ long g;
            final /* synthetic */ long h;
            final /* synthetic */ float i;

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            public static final class a implements io.bidmachine.rendering.internal.n {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Object f7008a;
                final /* synthetic */ long b;
                final /* synthetic */ long c;
                final /* synthetic */ float d;

                public a(Object obj, long j, long j2, float f) {
                    this.f7008a = obj;
                    this.b = j;
                    this.c = j2;
                    this.d = f;
                }

                @Override // io.bidmachine.util.SafeRunnable
                public final void onRun() {
                    ((io.bidmachine.rendering.internal.s) this.f7008a).a(this.b, this.c, this.d);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public j(h hVar, String str, String str2, Class cls, String str3, Continuation continuation, long j, long j2, float f) {
                super(2, continuation);
                this.b = hVar;
                this.c = str;
                this.d = str2;
                this.e = cls;
                this.f = str3;
                this.g = j;
                this.h = j2;
                this.i = f;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new j(this.b, this.c, this.d, this.e, this.f, continuation, this.g, this.h, this.i);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7007a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Object b = this.b.b(this.c);
                if (b == null) {
                    this.b.a(this.d, this.c);
                } else if (!this.e.isInstance(b)) {
                    this.b.a(this.d, this.c, this.f);
                } else if (this.e.isInstance(b)) {
                    UiUtils.onUiThread(new a(b, this.g, this.h, this.i));
                }
                return Unit.INSTANCE;
            }
        }

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "io.bidmachine.rendering.internal.controller.DefaultAdPhaseController$EventTaskExecutorImpl$repeat$$inlined$executeAction$1", f = "DefaultAdPhaseController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class k extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f7009a;
            final /* synthetic */ h b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ Class e;
            final /* synthetic */ String f;

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            public static final class a implements io.bidmachine.rendering.internal.n {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Object f7010a;

                public a(Object obj) {
                    this.f7010a = obj;
                }

                @Override // io.bidmachine.util.SafeRunnable
                public final void onRun() {
                    ((io.bidmachine.rendering.internal.t) this.f7010a).k();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public k(h hVar, String str, String str2, Class cls, String str3, Continuation continuation) {
                super(2, continuation);
                this.b = hVar;
                this.c = str;
                this.d = str2;
                this.e = cls;
                this.f = str3;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((k) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new k(this.b, this.c, this.d, this.e, this.f, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7009a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Object b = this.b.b(this.c);
                if (b == null) {
                    this.b.a(this.d, this.c);
                } else if (!this.e.isInstance(b)) {
                    this.b.a(this.d, this.c, this.f);
                } else if (this.e.isInstance(b)) {
                    UiUtils.onUiThread(new a(b));
                }
                return Unit.INSTANCE;
            }
        }

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "io.bidmachine.rendering.internal.controller.DefaultAdPhaseController$EventTaskExecutorImpl$schedule$$inlined$executeAction$1", f = "DefaultAdPhaseController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class l extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f7011a;
            final /* synthetic */ h b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ Class e;
            final /* synthetic */ String f;
            final /* synthetic */ long g;

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            public static final class a implements io.bidmachine.rendering.internal.n {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Object f7012a;
                final /* synthetic */ long b;

                public a(Object obj, long j) {
                    this.f7012a = obj;
                    this.b = j;
                }

                @Override // io.bidmachine.util.SafeRunnable
                public final void onRun() {
                    ((io.bidmachine.rendering.internal.v) this.f7012a).a(this.b);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public l(h hVar, String str, String str2, Class cls, String str3, Continuation continuation, long j) {
                super(2, continuation);
                this.b = hVar;
                this.c = str;
                this.d = str2;
                this.e = cls;
                this.f = str3;
                this.g = j;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((l) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new l(this.b, this.c, this.d, this.e, this.f, continuation, this.g);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7011a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Object b = this.b.b(this.c);
                if (b == null) {
                    this.b.a(this.d, this.c);
                } else if (!this.e.isInstance(b)) {
                    this.b.a(this.d, this.c, this.f);
                } else if (this.e.isInstance(b)) {
                    UiUtils.onUiThread(new a(b, this.g));
                }
                return Unit.INSTANCE;
            }
        }

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "io.bidmachine.rendering.internal.controller.DefaultAdPhaseController$EventTaskExecutorImpl$show$$inlined$executeAction$1", f = "DefaultAdPhaseController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class m extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f7013a;
            final /* synthetic */ h b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ Class e;
            final /* synthetic */ String f;
            final /* synthetic */ h g;
            final /* synthetic */ Integer h;

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            public static final class a implements io.bidmachine.rendering.internal.n {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Object f7014a;
                final /* synthetic */ h b;
                final /* synthetic */ Integer c;

                public a(Object obj, h hVar, Integer num) {
                    this.f7014a = obj;
                    this.b = hVar;
                    this.c = num;
                }

                @Override // io.bidmachine.util.SafeRunnable
                public final void onRun() {
                    VisibilityChanger visibilityChanger = (VisibilityChanger) this.f7014a;
                    this.b.a(visibilityChanger, true, this.c != null, (Runnable) new n(visibilityChanger));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public m(h hVar, String str, String str2, Class cls, String str3, Continuation continuation, h hVar2, Integer num) {
                super(2, continuation);
                this.b = hVar;
                this.c = str;
                this.d = str2;
                this.e = cls;
                this.f = str3;
                this.g = hVar2;
                this.h = num;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((m) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new m(this.b, this.c, this.d, this.e, this.f, continuation, this.g, this.h);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7013a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Object b = this.b.b(this.c);
                if (b == null) {
                    this.b.a(this.d, this.c);
                } else if (!this.e.isInstance(b)) {
                    this.b.a(this.d, this.c, this.f);
                } else if (this.e.isInstance(b)) {
                    UiUtils.onUiThread(new a(b, this.g, this.h));
                }
                return Unit.INSTANCE;
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onRun"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class n implements io.bidmachine.rendering.internal.n {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ VisibilityChanger f7015a;

            n(VisibilityChanger visibilityChanger) {
                this.f7015a = visibilityChanger;
            }

            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                this.f7015a.setVisibility(true);
            }
        }

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "io.bidmachine.rendering.internal.controller.DefaultAdPhaseController$EventTaskExecutorImpl$simulateClick$$inlined$executeAction$1", f = "DefaultAdPhaseController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class o extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f7016a;
            final /* synthetic */ h b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ Class e;
            final /* synthetic */ String f;

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            public static final class a implements io.bidmachine.rendering.internal.n {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Object f7017a;

                public a(Object obj) {
                    this.f7017a = obj;
                }

                @Override // io.bidmachine.util.SafeRunnable
                public final void onRun() {
                    ((InterfaceC3590c) this.f7017a).m();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public o(h hVar, String str, String str2, Class cls, String str3, Continuation continuation) {
                super(2, continuation);
                this.b = hVar;
                this.c = str;
                this.d = str2;
                this.e = cls;
                this.f = str3;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((o) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new o(this.b, this.c, this.d, this.e, this.f, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7016a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Object b = this.b.b(this.c);
                if (b == null) {
                    this.b.a(this.d, this.c);
                } else if (!this.e.isInstance(b)) {
                    this.b.a(this.d, this.c, this.f);
                } else if (this.e.isInstance(b)) {
                    UiUtils.onUiThread(new a(b));
                }
                return Unit.INSTANCE;
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        public static final class p implements io.bidmachine.rendering.internal.n {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f7018a;

            public p(Object obj) {
                this.f7018a = obj;
            }

            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                ((w) this.f7018a).e();
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        public static final class q implements io.bidmachine.rendering.internal.n {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f7019a;

            public q(Object obj) {
                this.f7019a = obj;
            }

            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                ((w) this.f7019a).e();
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        public static final class r implements io.bidmachine.rendering.internal.n {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f7020a;

            public r(Object obj) {
                this.f7020a = obj;
            }

            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                ((w) this.f7020a).e();
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        public static final class s implements io.bidmachine.rendering.internal.n {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f7021a;

            public s(Object obj) {
                this.f7021a = obj;
            }

            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                ((w) this.f7021a).e();
            }
        }

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "io.bidmachine.rendering.internal.controller.DefaultAdPhaseController$EventTaskExecutorImpl$start$$inlined$executeAction$1", f = "DefaultAdPhaseController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class t extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f7022a;
            final /* synthetic */ h b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ Class e;
            final /* synthetic */ String f;
            final /* synthetic */ String g;

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            public static final class a implements io.bidmachine.rendering.internal.n {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Object f7023a;
                final /* synthetic */ String b;

                public a(Object obj, String str) {
                    this.f7023a = obj;
                    this.b = str;
                }

                @Override // io.bidmachine.util.SafeRunnable
                public final void onRun() {
                    ((x) this.f7023a).a(this.b);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public t(h hVar, String str, String str2, Class cls, String str3, Continuation continuation, String str4) {
                super(2, continuation);
                this.b = hVar;
                this.c = str;
                this.d = str2;
                this.e = cls;
                this.f = str3;
                this.g = str4;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((t) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new t(this.b, this.c, this.d, this.e, this.f, continuation, this.g);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7022a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Object b = this.b.b(this.c);
                if (b == null) {
                    this.b.a(this.d, this.c);
                } else if (!this.e.isInstance(b)) {
                    this.b.a(this.d, this.c, this.f);
                } else if (this.e.isInstance(b)) {
                    UiUtils.onUiThread(new a(b, this.g));
                }
                return Unit.INSTANCE;
            }
        }

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "io.bidmachine.rendering.internal.controller.DefaultAdPhaseController$EventTaskExecutorImpl$unlockVisibility$$inlined$executeAction$1", f = "DefaultAdPhaseController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class u extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f7024a;
            final /* synthetic */ h b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ Class e;
            final /* synthetic */ String f;

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            public static final class a implements io.bidmachine.rendering.internal.n {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Object f7025a;

                public a(Object obj) {
                    this.f7025a = obj;
                }

                @Override // io.bidmachine.util.SafeRunnable
                public final void onRun() {
                    ((VisibilityChanger) this.f7025a).unlockVisibility();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public u(h hVar, String str, String str2, Class cls, String str3, Continuation continuation) {
                super(2, continuation);
                this.b = hVar;
                this.c = str;
                this.d = str2;
                this.e = cls;
                this.f = str3;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((u) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new u(this.b, this.c, this.d, this.e, this.f, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7024a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Object b = this.b.b(this.c);
                if (b == null) {
                    this.b.a(this.d, this.c);
                } else if (!this.e.isInstance(b)) {
                    this.b.a(this.d, this.c, this.f);
                } else if (this.e.isInstance(b)) {
                    UiUtils.onUiThread(new a(b));
                }
                return Unit.INSTANCE;
            }
        }

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "io.bidmachine.rendering.internal.controller.DefaultAdPhaseController$EventTaskExecutorImpl$unmute$$inlined$executeAction$1", f = "DefaultAdPhaseController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class v extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f7026a;
            final /* synthetic */ h b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ Class e;
            final /* synthetic */ String f;
            final /* synthetic */ Integer g;

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            public static final class a implements io.bidmachine.rendering.internal.n {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Object f7027a;
                final /* synthetic */ Integer b;

                public a(Object obj, Integer num) {
                    this.f7027a = obj;
                    this.b = num;
                }

                @Override // io.bidmachine.util.SafeRunnable
                public final void onRun() {
                    ((io.bidmachine.rendering.internal.q) this.f7027a).a(this.b);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public v(h hVar, String str, String str2, Class cls, String str3, Continuation continuation, Integer num) {
                super(2, continuation);
                this.b = hVar;
                this.c = str;
                this.d = str2;
                this.e = cls;
                this.f = str3;
                this.g = num;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((v) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new v(this.b, this.c, this.d, this.e, this.f, continuation, this.g);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7026a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Object b = this.b.b(this.c);
                if (b == null) {
                    this.b.a(this.d, this.c);
                } else if (!this.e.isInstance(b)) {
                    this.b.a(this.d, this.c, this.f);
                } else if (this.e.isInstance(b)) {
                    UiUtils.onUiThread(new a(b, this.g));
                }
                return Unit.INSTANCE;
            }
        }

        public f(h hVar, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.b = hVar;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            this.applicationContext = applicationContext;
        }

        private final void h(String url) {
            io.bidmachine.rendering.internal.controller.g presentListener = this.b.getPresentListener();
            if (presentListener != null) {
                presentListener.a();
            }
            UrlHandler.openUrl(this.applicationContext, url, new i(this.b));
        }

        @Override // io.bidmachine.rendering.internal.event.f
        public void a(String targetElementName, Integer senderId) {
            Intrinsics.checkNotNullParameter(targetElementName, "targetElementName");
            h hVar = this.b;
            BuildersKt__Builders_commonKt.launch$default(hVar.h(hVar), hVar.g(hVar).b(), null, new e(hVar, targetElementName, "hide", VisibilityChanger.class, "VisibilityChanger", null, hVar, senderId), 2, null);
        }

        @Override // io.bidmachine.rendering.internal.event.f
        public void b(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            h(url);
        }

        @Override // io.bidmachine.rendering.internal.event.f
        public void c(String targetElementName, Integer senderId) {
            Intrinsics.checkNotNullParameter(targetElementName, "targetElementName");
            h hVar = this.b;
            BuildersKt__Builders_commonKt.launch$default(hVar.h(hVar), hVar.g(hVar).b(), null, new C0617h(hVar, targetElementName, CampaignEx.JSON_NATIVE_VIDEO_MUTE, io.bidmachine.rendering.internal.q.class, "Mutable", null, senderId), 2, null);
        }

        @Override // io.bidmachine.rendering.internal.event.f
        public void d(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            io.bidmachine.rendering.internal.controller.g presentListener = this.b.getPresentListener();
            if (presentListener != null) {
                presentListener.d();
            }
            h(url);
        }

        @Override // io.bidmachine.rendering.internal.event.f
        public void e() {
            h hVar = this.b;
            for (InterfaceC3590c interfaceC3590c : hVar.i()) {
                if (w.class.isInstance(interfaceC3590c)) {
                    UiUtils.onUiThread(new p(interfaceC3590c));
                }
            }
            for (InterfaceC3590c interfaceC3590c2 : hVar.j()) {
                if (w.class.isInstance(interfaceC3590c2)) {
                    UiUtils.onUiThread(new q(interfaceC3590c2));
                }
            }
            for (io.bidmachine.rendering.internal.p pVar : hVar.l()) {
                if (w.class.isInstance(pVar)) {
                    UiUtils.onUiThread(new r(pVar));
                }
            }
            y k2 = hVar.k();
            if (w.class.isInstance(k2)) {
                UiUtils.onUiThread(new s(k2));
            }
        }

        @Override // io.bidmachine.rendering.internal.event.f
        public void f(String targetElementName) {
            Intrinsics.checkNotNullParameter(targetElementName, "targetElementName");
            h hVar = this.b;
            BuildersKt__Builders_commonKt.launch$default(hVar.h(hVar), hVar.g(hVar).b(), null, new o(hVar, targetElementName, "simulateClick", InterfaceC3590c.class, "AdElement", null), 2, null);
        }

        @Override // io.bidmachine.rendering.internal.event.f
        public void g(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            new NetworkRequest.Builder(url, NetworkRequest.Method.Get).setUserAgent(Rendering.getUserAgent()).send();
        }

        @Override // io.bidmachine.rendering.internal.event.f
        public void b() {
            h hVar = this.b;
            for (InterfaceC3590c interfaceC3590c : hVar.i()) {
                if (io.bidmachine.rendering.internal.g.class.isInstance(interfaceC3590c)) {
                    UiUtils.onUiThread(new a(interfaceC3590c));
                }
            }
            for (InterfaceC3590c interfaceC3590c2 : hVar.j()) {
                if (io.bidmachine.rendering.internal.g.class.isInstance(interfaceC3590c2)) {
                    UiUtils.onUiThread(new b(interfaceC3590c2));
                }
            }
            for (io.bidmachine.rendering.internal.p pVar : hVar.l()) {
                if (io.bidmachine.rendering.internal.g.class.isInstance(pVar)) {
                    UiUtils.onUiThread(new c(pVar));
                }
            }
            y k2 = hVar.k();
            if (io.bidmachine.rendering.internal.g.class.isInstance(k2)) {
                UiUtils.onUiThread(new d(k2));
            }
        }

        @Override // io.bidmachine.rendering.internal.event.f
        public void a(String targetElementName, long maxProgressMs, long currentProgressMs, float percent) {
            Intrinsics.checkNotNullParameter(targetElementName, "targetElementName");
            h hVar = this.b;
            BuildersKt__Builders_commonKt.launch$default(hVar.h(hVar), hVar.g(hVar).b(), null, new j(hVar, targetElementName, NotificationCompat.CATEGORY_PROGRESS, io.bidmachine.rendering.internal.s.class, VastTagName.PROGRESS, null, maxProgressMs, currentProgressMs, percent), 2, null);
        }

        @Override // io.bidmachine.rendering.internal.event.f
        public void c(String targetElementName) {
            Intrinsics.checkNotNullParameter(targetElementName, "targetElementName");
            h hVar = this.b;
            BuildersKt__Builders_commonKt.launch$default(hVar.h(hVar), hVar.g(hVar).b(), null, new k(hVar, targetElementName, "repeat", io.bidmachine.rendering.internal.t.class, "Repeatable", null), 2, null);
        }

        @Override // io.bidmachine.rendering.internal.event.f
        public void d(String targetElementName, Integer senderId) {
            Intrinsics.checkNotNullParameter(targetElementName, "targetElementName");
            h hVar = this.b;
            BuildersKt__Builders_commonKt.launch$default(hVar.h(hVar), hVar.g(hVar).b(), null, new v(hVar, targetElementName, CampaignEx.JSON_NATIVE_VIDEO_UNMUTE, io.bidmachine.rendering.internal.q.class, "Mutable", null, senderId), 2, null);
        }

        @Override // io.bidmachine.rendering.internal.event.f
        public void a(String targetElementName, long timeMs) {
            Intrinsics.checkNotNullParameter(targetElementName, "targetElementName");
            h hVar = this.b;
            BuildersKt__Builders_commonKt.launch$default(hVar.h(hVar), hVar.g(hVar).b(), null, new l(hVar, targetElementName, "schedule", io.bidmachine.rendering.internal.v.class, "Schedule", null, timeMs), 2, null);
        }

        @Override // io.bidmachine.rendering.internal.event.f
        public void a(String targetElementName, String value) {
            Intrinsics.checkNotNullParameter(targetElementName, "targetElementName");
            h hVar = this.b;
            BuildersKt__Builders_commonKt.launch$default(hVar.h(hVar), hVar.g(hVar).b(), null, new t(hVar, targetElementName, "start", x.class, "Startable", null, value), 2, null);
        }

        @Override // io.bidmachine.rendering.internal.event.f
        public void a(String targetElementName, boolean lockVisibility) {
            Intrinsics.checkNotNullParameter(targetElementName, "targetElementName");
            h hVar = this.b;
            BuildersKt__Builders_commonKt.launch$default(hVar.h(hVar), hVar.g(hVar).b(), null, new g(hVar, targetElementName, "lockVisibility", VisibilityChanger.class, "VisibilityChanger", null, lockVisibility), 2, null);
        }

        @Override // io.bidmachine.rendering.internal.event.f
        public void a(PrivacySheetParams privacySheetParams) {
            Intrinsics.checkNotNullParameter(privacySheetParams, "privacySheetParams");
            io.bidmachine.rendering.internal.controller.g presentListener = this.b.getPresentListener();
            if (presentListener != null) {
                presentListener.a(privacySheetParams);
            }
        }

        @Override // io.bidmachine.rendering.internal.event.f
        public void a(String stateGroups) {
            Intrinsics.checkNotNullParameter(stateGroups, "stateGroups");
            this.b.n().a(stateGroups);
        }

        @Override // io.bidmachine.rendering.internal.event.f
        public void e(String targetElementName) {
            Intrinsics.checkNotNullParameter(targetElementName, "targetElementName");
            h hVar = this.b;
            BuildersKt__Builders_commonKt.launch$default(hVar.h(hVar), hVar.g(hVar).b(), null, new u(hVar, targetElementName, "unlockVisibility", VisibilityChanger.class, "VisibilityChanger", null), 2, null);
        }

        @Override // io.bidmachine.rendering.internal.event.f
        public void b(String targetElementName, Integer senderId) {
            Intrinsics.checkNotNullParameter(targetElementName, "targetElementName");
            h hVar = this.b;
            BuildersKt__Builders_commonKt.launch$default(hVar.h(hVar), hVar.g(hVar).b(), null, new m(hVar, targetElementName, C3207n2.v, VisibilityChanger.class, "VisibilityChanger", null, hVar, senderId), 2, null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/bidmachine/rendering/internal/controller/h$g;", "Lio/bidmachine/rendering/internal/y;", "Lio/bidmachine/rendering/internal/event/b;", "eventCallback", "<init>", "(Lio/bidmachine/rendering/internal/controller/h;Lio/bidmachine/rendering/internal/event/b;)V", "", "p", "()Ljava/lang/String;", "", "senderId", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/lang/Integer;)V", "a", "e", "()V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private final class g extends y {
        final /* synthetic */ h c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(h hVar, io.bidmachine.rendering.internal.event.b eventCallback) {
            super(eventCallback);
            Intrinsics.checkNotNullParameter(eventCallback, "eventCallback");
            this.c = hVar;
        }

        @Override // io.bidmachine.rendering.internal.y, io.bidmachine.rendering.internal.q
        public void a(Integer senderId) {
            o().a(senderId);
        }

        @Override // io.bidmachine.rendering.internal.y, io.bidmachine.rendering.internal.q
        public void b(Integer senderId) {
            o().b(senderId);
        }

        @Override // io.bidmachine.rendering.internal.y, io.bidmachine.rendering.internal.w
        public void e() {
            io.bidmachine.rendering.internal.controller.g presentListener = this.c.getPresentListener();
            if (presentListener != null) {
                presentListener.e();
            }
        }

        @Override // io.bidmachine.rendering.internal.y
        public String p() {
            return o().getSourceName();
        }

        @Override // io.bidmachine.rendering.internal.y, io.bidmachine.rendering.internal.g
        public void b() {
            io.bidmachine.rendering.internal.controller.g presentListener = this.c.getPresentListener();
            if (presentListener != null) {
                presentListener.b();
            }
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/bidmachine/rendering/internal/adform/b;", "a", "()Lio/bidmachine/rendering/internal/adform/b;"}, k = 3, mv = {1, 7, 1})
    /* renamed from: io.bidmachine.rendering.internal.controller.h$h, reason: collision with other inner class name */
    static final class C0618h extends Lambda implements Function0<io.bidmachine.rendering.internal.adform.b> {
        C0618h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.bidmachine.rendering.internal.adform.b invoke() {
            Context applicationContext = h.this.applicationContext;
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            return new io.bidmachine.rendering.internal.adform.b(applicationContext, h.this.repository);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1})
    static final class i extends Lambda implements Function0<Integer> {
        i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            ViewGroup viewGroup = h.this.getAdPhase().getCom.mbridge.msdk.MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW java.lang.String();
            if (viewGroup != null) {
                return Integer.valueOf(viewGroup.getId());
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00060\u0000R\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/bidmachine/rendering/internal/controller/h$g;", "Lio/bidmachine/rendering/internal/controller/h;", "a", "()Lio/bidmachine/rendering/internal/controller/h$g;"}, k = 3, mv = {1, 7, 1})
    static final class j extends Lambda implements Function0<g> {
        j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g invoke() {
            h hVar = h.this;
            return new g(hVar, hVar.a(AnalyticsConstants.SOURCE_SYSTEM_TYPE));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.controller.DefaultAdPhaseController$load$1", f = "DefaultAdPhaseController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class k extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f7031a;

        k(Continuation<? super k> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((k) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return h.this.new k(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7031a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (h.this.o()) {
                h.this.p();
                h.this.q();
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class l implements io.bidmachine.rendering.internal.n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f7032a;

        public l(Object obj) {
            this.f7032a = obj;
        }

        @Override // io.bidmachine.util.SafeRunnable
        public final void onRun() {
            ((v) this.f7032a).pause();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class m implements io.bidmachine.rendering.internal.n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f7033a;

        public m(Object obj) {
            this.f7033a = obj;
        }

        @Override // io.bidmachine.util.SafeRunnable
        public final void onRun() {
            ((v) this.f7033a).pause();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class n implements io.bidmachine.rendering.internal.n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f7034a;

        public n(Object obj) {
            this.f7034a = obj;
        }

        @Override // io.bidmachine.util.SafeRunnable
        public final void onRun() {
            ((v) this.f7034a).pause();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class o implements io.bidmachine.rendering.internal.n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f7035a;

        public o(Object obj) {
            this.f7035a = obj;
        }

        @Override // io.bidmachine.util.SafeRunnable
        public final void onRun() {
            ((v) this.f7035a).pause();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class p implements io.bidmachine.rendering.internal.n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f7036a;

        public p(Object obj) {
            this.f7036a = obj;
        }

        @Override // io.bidmachine.util.SafeRunnable
        public final void onRun() {
            ((v) this.f7036a).l();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class q implements io.bidmachine.rendering.internal.n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f7037a;

        public q(Object obj) {
            this.f7037a = obj;
        }

        @Override // io.bidmachine.util.SafeRunnable
        public final void onRun() {
            ((v) this.f7037a).l();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class r implements io.bidmachine.rendering.internal.n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f7038a;

        public r(Object obj) {
            this.f7038a = obj;
        }

        @Override // io.bidmachine.util.SafeRunnable
        public final void onRun() {
            ((v) this.f7038a).l();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "onRun", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class s implements io.bidmachine.rendering.internal.n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f7039a;

        public s(Object obj) {
            this.f7039a = obj;
        }

        @Override // io.bidmachine.util.SafeRunnable
        public final void onRun() {
            ((v) this.f7039a).l();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/bidmachine/rendering/internal/groups/a;", "a", "()Lio/bidmachine/rendering/internal/groups/a;"}, k = 3, mv = {1, 7, 1})
    static final class t extends Lambda implements Function0<io.bidmachine.rendering.internal.groups.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdPhaseParams f7040a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(AdPhaseParams adPhaseParams) {
            super(0);
            this.f7040a = adPhaseParams;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.bidmachine.rendering.internal.groups.a invoke() {
            return new io.bidmachine.rendering.internal.groups.a(this.f7040a.getStateGroups());
        }
    }

    public h(Context context, AdPhaseParams adPhaseParams, Tag tag, io.bidmachine.rendering.internal.state.c adState, io.bidmachine.rendering.internal.controller.f adPhaseControllerListener, io.bidmachine.rendering.internal.animation.b adAnimationController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adPhaseParams, "adPhaseParams");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(adState, "adState");
        Intrinsics.checkNotNullParameter(adPhaseControllerListener, "adPhaseControllerListener");
        Intrinsics.checkNotNullParameter(adAnimationController, "adAnimationController");
        this.tag = tag;
        this.adState = adState;
        this.adPhaseControllerListener = adPhaseControllerListener;
        this.adAnimationController = adAnimationController;
        Context applicationContext = context.getApplicationContext();
        this.applicationContext = applicationContext;
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        io.bidmachine.rendering.internal.repository.b bVar = new io.bidmachine.rendering.internal.repository.b(applicationContext, h(this), g(this));
        this.repository = bVar;
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        this.adPhase = new io.bidmachine.rendering.internal.d(applicationContext, bVar, adPhaseParams);
        this.eventTaskExecutor = new f(this, context);
        this.brokenCreativeDetectorListener = new c();
        this.stateGroupController = LazyKt.lazy(new t(adPhaseParams));
        this.internalTargetObject = LazyKt.lazy(new j());
        this.loadAdTaskManager = new CoroutineTaskManager(h(this).getCoroutineContext().plus(g(this).c()));
        this.loadAdTaskMap = new ConcurrentHashMap();
        this.adsList = new CopyOnWriteArrayList();
        this.controlsList = new CopyOnWriteArrayList();
        this.methodsList = new CopyOnWriteArrayList();
        this.adFormFactory = LazyKt.lazy(new C0618h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final y k() {
        return (y) this.internalTargetObject.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final io.bidmachine.rendering.internal.groups.b n() {
        return (io.bidmachine.rendering.internal.groups.b) this.stateGroupController.getValue();
    }

    public final void g() {
        io.bidmachine.rendering.internal.o.b(this.tag, "Destroy AdPhase", new Object[0]);
        this.adAnimationController.a(getAdPhase());
        final io.bidmachine.rendering.internal.d adPhase = getAdPhase();
        UiUtils.onUiThread(new io.bidmachine.rendering.internal.n() { // from class: io.bidmachine.rendering.internal.controller.h$$ExternalSyntheticLambda4
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                io.bidmachine.rendering.internal.d.this.a();
            }
        });
    }

    public final io.bidmachine.rendering.internal.adform.b h() {
        return (io.bidmachine.rendering.internal.adform.b) this.adFormFactory.getValue();
    }

    public final List<InterfaceC3590c> i() {
        return this.adsList;
    }

    public final List<InterfaceC3590c> j() {
        return this.controlsList;
    }

    public final List<io.bidmachine.rendering.internal.p> l() {
        return this.methodsList;
    }

    /* renamed from: m, reason: from getter */
    public io.bidmachine.rendering.internal.controller.g getPresentListener() {
        return this.presentListener;
    }

    public final boolean o() {
        List<AdElementParams> adsList = getAdPhase().getAdPhaseParams().getAdsList();
        if (adsList.isEmpty()) {
            a(new Error("AdPhase does not contain any ads part"));
            return false;
        }
        if (b()) {
            r();
            return false;
        }
        if (!this.adState.c()) {
            return false;
        }
        this.adsList.addAll(a(adsList, new a()));
        if (!this.adsList.isEmpty()) {
            return true;
        }
        a(new Error("No supported ads found for the given parameters"));
        return false;
    }

    @Override // io.bidmachine.rendering.internal.controller.e
    public void onShown() {
        if (this.adState.i()) {
            io.bidmachine.rendering.internal.o.b(this.tag, "AdPhase - onShown", new Object[0]);
            b((List<? extends InterfaceC3590c>) this.adsList, true);
            b((List<? extends InterfaceC3590c>) this.controlsList, true);
            k().o().k();
        }
    }

    public final void p() {
        this.controlsList.addAll(a(getAdPhase().getAdPhaseParams().getControlsList(), new e()));
    }

    public final void q() {
        List<MethodParams> methodParamsList = getAdPhase().getAdPhaseParams().getMethodParamsList();
        List<io.bidmachine.rendering.internal.p> list = this.methodsList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(methodParamsList, 10));
        for (MethodParams methodParams : methodParamsList) {
            arrayList.add(new io.bidmachine.rendering.internal.p(methodParams, a(methodParams.getName())));
        }
        list.addAll(arrayList);
    }

    public final void r() {
        if (this.adState.a(true)) {
            this.adPhaseControllerListener.a(this);
        }
    }

    public String toString() {
        String tag = this.tag.toString();
        Intrinsics.checkNotNullExpressionValue(tag, "tag.toString()");
        return tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope h(h hVar) {
        return hVar.adState.o();
    }

    @Override // io.bidmachine.rendering.internal.controller.e
    public void c() {
        io.bidmachine.rendering.internal.o.b(this.tag, "AdPhase - load", new Object[0]);
        BuildersKt__Builders_commonKt.launch$default(h(this), g(this).c(), null, new k(null), 2, null);
    }

    @Override // io.bidmachine.rendering.internal.controller.e
    public void d() {
        io.bidmachine.rendering.internal.o.b(this.tag, "AdPhase - performShow", new Object[0]);
        for (InterfaceC3590c interfaceC3590c : i()) {
            if (v.class.isInstance(interfaceC3590c)) {
                UiUtils.onUiThread(new p(interfaceC3590c));
            }
        }
        for (InterfaceC3590c interfaceC3590c2 : j()) {
            if (v.class.isInstance(interfaceC3590c2)) {
                UiUtils.onUiThread(new q(interfaceC3590c2));
            }
        }
        for (io.bidmachine.rendering.internal.p pVar : l()) {
            if (v.class.isInstance(pVar)) {
                UiUtils.onUiThread(new r(pVar));
            }
        }
        y k2 = k();
        if (v.class.isInstance(k2)) {
            UiUtils.onUiThread(new s(k2));
        }
        if (this.adState.m()) {
            b((List<? extends InterfaceC3590c>) this.adsList, false);
            b((List<? extends InterfaceC3590c>) this.controlsList, false);
        }
        this.adState.l();
    }

    @Override // io.bidmachine.rendering.internal.controller.e
    /* renamed from: e, reason: from getter */
    public io.bidmachine.rendering.internal.d getAdPhase() {
        return this.adPhase;
    }

    public final void f() {
        io.bidmachine.rendering.internal.o.b(this.tag, "Cancel loading AdElements", new Object[0]);
        Iterator<Map.Entry<InterfaceC3590c, CancelableTask>> it = this.loadAdTaskMap.entrySet().iterator();
        while (it.hasNext()) {
            this.loadAdTaskManager.cancel(it.next().getValue());
        }
        this.loadAdTaskMap.clear();
    }

    @Override // io.bidmachine.rendering.internal.controller.e
    public boolean b() {
        return this.adState.b();
    }

    public final void b(final InterfaceC3590c item, boolean animated) {
        Intrinsics.checkNotNullParameter(item, "item");
        io.bidmachine.rendering.internal.o.b(this.tag, "Show AdElement - " + item.getAdElementParams().getName() + ", animated: " + animated, new Object[0]);
        io.bidmachine.rendering.internal.n nVar = new io.bidmachine.rendering.internal.n() { // from class: io.bidmachine.rendering.internal.controller.h$$ExternalSyntheticLambda2
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                h.b(InterfaceC3590c.this);
            }
        };
        if (animated) {
            io.bidmachine.rendering.internal.animation.b.a(this.adAnimationController, item, AnimationEventType.Appear, false, nVar, null, 20, null);
        } else {
            nVar.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final io.bidmachine.rendering.internal.h g(h hVar) {
        return hVar.adState.getCoroutineDispatchers();
    }

    @Override // io.bidmachine.rendering.internal.controller.e
    public void a(io.bidmachine.rendering.internal.controller.g gVar) {
        this.presentListener = gVar;
    }

    @Override // io.bidmachine.rendering.internal.controller.e
    public boolean a(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return getAdPhase().a(container, this.adsList, this.controlsList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(InterfaceC3590c item) {
        Intrinsics.checkNotNullParameter(item, "$item");
        item.d();
    }

    @Override // io.bidmachine.rendering.internal.controller.e
    public void a(boolean isFinishing) {
        io.bidmachine.rendering.internal.o.b(this.tag, "AdPhase - performHide, isFinishing: " + isFinishing, new Object[0]);
        for (InterfaceC3590c interfaceC3590c : i()) {
            if (v.class.isInstance(interfaceC3590c)) {
                UiUtils.onUiThread(new l(interfaceC3590c));
            }
        }
        for (InterfaceC3590c interfaceC3590c2 : j()) {
            if (v.class.isInstance(interfaceC3590c2)) {
                UiUtils.onUiThread(new m(interfaceC3590c2));
            }
        }
        for (io.bidmachine.rendering.internal.p pVar : l()) {
            if (v.class.isInstance(pVar)) {
                UiUtils.onUiThread(new n(pVar));
            }
        }
        y k2 = k();
        if (v.class.isInstance(k2)) {
            UiUtils.onUiThread(new o(k2));
        }
        a(this.adsList, isFinishing);
        a(this.controlsList, isFinishing);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\b\u0010\r¨\u0006\u000e"}, d2 = {"Lio/bidmachine/rendering/internal/controller/h$e;", "Lio/bidmachine/rendering/internal/controller/h$b;", "Lio/bidmachine/rendering/internal/controller/h;", "<init>", "(Lio/bidmachine/rendering/internal/controller/h;)V", "Lio/bidmachine/rendering/internal/adform/a;", "adForm", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lio/bidmachine/rendering/internal/adform/a;)V", "Lio/bidmachine/rendering/model/Error;", "error", "c", "(Lio/bidmachine/rendering/internal/adform/a;Lio/bidmachine/rendering/model/Error;)V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private final class e extends b {
        public e() {
            super();
        }

        @Override // io.bidmachine.rendering.internal.controller.h.b, io.bidmachine.rendering.internal.adform.c
        public void b(io.bidmachine.rendering.internal.adform.a adForm) {
            Intrinsics.checkNotNullParameter(adForm, "adForm");
            super.b(adForm);
            if (!h.this.a(adForm, true)) {
                c(adForm, new Error("Failed to setup ad element (" + adForm + ')'));
            }
            if (h.this.loadAdTaskMap.isEmpty()) {
                h.this.r();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.h.b, io.bidmachine.rendering.internal.adform.c
        public void c(io.bidmachine.rendering.internal.adform.a adForm, Error error) {
            Intrinsics.checkNotNullParameter(adForm, "adForm");
            Intrinsics.checkNotNullParameter(error, "error");
            super.c(adForm, error);
            h hVar = h.this;
            hVar.a((InterfaceC3590c) adForm, hVar.j());
        }

        @Override // io.bidmachine.rendering.internal.controller.h.b, io.bidmachine.rendering.internal.adform.c
        public void b(io.bidmachine.rendering.internal.adform.a adForm, Error error) {
            Intrinsics.checkNotNullParameter(adForm, "adForm");
            Intrinsics.checkNotNullParameter(error, "error");
            super.b(adForm, error);
            h hVar = h.this;
            hVar.a((InterfaceC3590c) adForm, hVar.j());
        }
    }

    public final void b(List<? extends InterfaceC3590c> items, boolean animated) {
        Intrinsics.checkNotNullParameter(items, "items");
        io.bidmachine.rendering.internal.o.b(this.tag, "Show AdElements, animated: " + animated, new Object[0]);
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            b((InterfaceC3590c) it.next(), animated);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\b\u0010\r¨\u0006\u000e"}, d2 = {"Lio/bidmachine/rendering/internal/controller/h$a;", "Lio/bidmachine/rendering/internal/controller/h$b;", "Lio/bidmachine/rendering/internal/controller/h;", "<init>", "(Lio/bidmachine/rendering/internal/controller/h;)V", "Lio/bidmachine/rendering/internal/adform/a;", "adForm", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lio/bidmachine/rendering/internal/adform/a;)V", "Lio/bidmachine/rendering/model/Error;", "error", "c", "(Lio/bidmachine/rendering/internal/adform/a;Lio/bidmachine/rendering/model/Error;)V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private final class a extends b {
        public a() {
            super();
        }

        @Override // io.bidmachine.rendering.internal.controller.h.b, io.bidmachine.rendering.internal.adform.c
        public void b(io.bidmachine.rendering.internal.adform.a adForm) {
            Intrinsics.checkNotNullParameter(adForm, "adForm");
            super.b(adForm);
            if (!h.a(h.this, adForm, false, 2, (Object) null)) {
                c(adForm, new Error("Failed to setup ad element (" + adForm + ')'));
            } else if (h.this.loadAdTaskMap.isEmpty()) {
                h.this.r();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.h.b, io.bidmachine.rendering.internal.adform.c
        public void c(io.bidmachine.rendering.internal.adform.a adForm, Error error) {
            Intrinsics.checkNotNullParameter(adForm, "adForm");
            Intrinsics.checkNotNullParameter(error, "error");
            super.c(adForm, error);
            h.this.a(error);
        }

        @Override // io.bidmachine.rendering.internal.controller.h.b, io.bidmachine.rendering.internal.adform.c
        public void b(io.bidmachine.rendering.internal.adform.a adForm, Error error) {
            Intrinsics.checkNotNullParameter(adForm, "adForm");
            Intrinsics.checkNotNullParameter(error, "error");
            super.b(adForm, error);
            h.this.a(error);
        }
    }

    @Override // io.bidmachine.rendering.internal.controller.e
    public void a() {
        io.bidmachine.rendering.internal.o.b(this.tag, "AdPhase - destroy", new Object[0]);
        f();
        a(this.adsList);
        a(this.controlsList);
        g();
        b(this.methodsList);
        a(this, k(), (List) null, 2, (Object) null);
        a((io.bidmachine.rendering.internal.controller.g) null);
        this.adState.a();
    }

    public final io.bidmachine.rendering.internal.event.b a(String sourceName) {
        Intrinsics.checkNotNullParameter(sourceName, "sourceName");
        return new io.bidmachine.rendering.internal.event.c(sourceName, new io.bidmachine.rendering.internal.groups.c(n()), new io.bidmachine.rendering.internal.animation.c(this.adAnimationController, new i()), new io.bidmachine.rendering.internal.event.a(this.eventTaskExecutor, sourceName), h(this), g(this), getAdPhase().getAdPhaseParams().getEventTypeMap(sourceName));
    }

    private final io.bidmachine.rendering.internal.detector.brokencreative.a a(AdElementParams adElementParams) {
        BrokenCreativeDetectorParams brokenCreativeDetectorParams = adElementParams.getBrokenCreativeDetectorParams();
        if (brokenCreativeDetectorParams != null) {
            return new io.bidmachine.rendering.internal.detector.brokencreative.a(getAdPhase().getAdPhaseParams().getSequence(), adElementParams.getName(), brokenCreativeDetectorParams, this.brokenCreativeDetectorListener);
        }
        return null;
    }

    public final io.bidmachine.rendering.internal.adform.a a(AdElementParams elementParams, io.bidmachine.rendering.internal.adform.c adFormListener) {
        Intrinsics.checkNotNullParameter(elementParams, "elementParams");
        Intrinsics.checkNotNullParameter(adFormListener, "adFormListener");
        io.bidmachine.rendering.internal.o.b(this.tag, "Create AdElement - " + elementParams.getName(), new Object[0]);
        return h().a(elementParams, adFormListener, a(elementParams.getName()), a(elementParams));
    }

    public final void a(io.bidmachine.rendering.internal.adform.a adForm, io.bidmachine.rendering.internal.adform.c adFormListener) {
        Intrinsics.checkNotNullParameter(adForm, "adForm");
        Intrinsics.checkNotNullParameter(adFormListener, "adFormListener");
        io.bidmachine.rendering.internal.o.b(this.tag, "Load AdElement - " + adForm.getAdElementParams().getName(), new Object[0]);
        d dVar = new d(adForm);
        this.loadAdTaskMap.put(adForm, dVar);
        try {
            this.loadAdTaskManager.execute(dVar);
        } catch (Throwable th) {
            adFormListener.c(adForm, Error.INSTANCE.create(th));
        }
    }

    public static /* synthetic */ boolean a(h hVar, io.bidmachine.rendering.internal.adform.a aVar, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return hVar.a(aVar, z);
    }

    public final boolean a(io.bidmachine.rendering.internal.adform.a item, boolean allowPostponed) {
        Intrinsics.checkNotNullParameter(item, "item");
        boolean B = item.B();
        if (B) {
            this.adAnimationController.a(item, allowPostponed, AnimationEventType.Appear);
        }
        return B;
    }

    public final void a(final InterfaceC3590c item, boolean animated) {
        Intrinsics.checkNotNullParameter(item, "item");
        io.bidmachine.rendering.internal.o.b(this.tag, "Hide AdElement - " + item.getAdElementParams().getName() + ", animated: " + animated, new Object[0]);
        io.bidmachine.rendering.internal.n nVar = new io.bidmachine.rendering.internal.n() { // from class: io.bidmachine.rendering.internal.controller.h$$ExternalSyntheticLambda3
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                h.a(InterfaceC3590c.this);
            }
        };
        if (animated) {
            io.bidmachine.rendering.internal.animation.b.a(this.adAnimationController, item, AnimationEventType.Disappear, false, null, nVar, 12, null);
        } else {
            nVar.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InterfaceC3590c item) {
        Intrinsics.checkNotNullParameter(item, "$item");
        item.f();
    }

    public final void a(List<? extends InterfaceC3590c> items, boolean animated) {
        Intrinsics.checkNotNullParameter(items, "items");
        io.bidmachine.rendering.internal.o.b(this.tag, "Hide AdElements, animated: " + animated, new Object[0]);
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            a((InterfaceC3590c) it.next(), animated);
        }
    }

    public final <T extends y> void b(List<T> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        io.bidmachine.rendering.internal.o.b(this.tag, "Destroy TargetObjects", new Object[0]);
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            a((y) it.next(), items);
        }
        items.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(VisibilityChanger item, boolean isVisible, boolean isSkip, Runnable action) {
        if ((item instanceof InterfaceC3590c) && this.adState.d() && !this.adState.h()) {
            this.adAnimationController.b((InterfaceC3590c) item, isVisible ? AnimationEventType.Appear : AnimationEventType.Disappear, isSkip, isVisible ? action : null, isVisible ? null : action);
        } else {
            action.run();
        }
    }

    public final void a(final InterfaceC3590c item, List<InterfaceC3590c> items) {
        Intrinsics.checkNotNullParameter(item, "item");
        io.bidmachine.rendering.internal.o.b(this.tag, "Destroy AdElement - " + item.getAdElementParams().getName(), new Object[0]);
        this.adAnimationController.a(item);
        if (items != null) {
            items.remove(item);
        }
        UiUtils.onUiThread(new io.bidmachine.rendering.internal.n() { // from class: io.bidmachine.rendering.internal.controller.h$$ExternalSyntheticLambda1
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                InterfaceC3590c.this.a();
            }
        });
    }

    public final void a(List<InterfaceC3590c> item) {
        Intrinsics.checkNotNullParameter(item, "item");
        io.bidmachine.rendering.internal.o.b(this.tag, "Destroy AdElements", new Object[0]);
        Iterator<T> it = item.iterator();
        while (it.hasNext()) {
            a((InterfaceC3590c) it.next(), item);
        }
        item.clear();
    }

    public final Object b(String name) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(name, "name");
        if (StringsKt.isBlank(name)) {
            return null;
        }
        Iterator<T> it = this.adsList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (StringsKt.equals(((InterfaceC3590c) obj).getAdElementParams().getName(), name, true)) {
                break;
            }
        }
        Object obj3 = (InterfaceC3590c) obj;
        if (obj3 == null) {
            Iterator<T> it2 = this.controlsList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it2.next();
                if (StringsKt.equals(((InterfaceC3590c) obj2).getAdElementParams().getName(), name, true)) {
                    break;
                }
            }
            obj3 = (InterfaceC3590c) obj2;
            if (obj3 == null) {
                Iterator<T> it3 = this.methodsList.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj3 = null;
                        break;
                    }
                    obj3 = it3.next();
                    if (StringsKt.equals(((io.bidmachine.rendering.internal.p) obj3).q().getName(), name, true)) {
                        break;
                    }
                }
            }
        }
        if (obj3 != null) {
            return obj3;
        }
        if (Intrinsics.areEqual(k().p(), name)) {
            return k();
        }
        return null;
    }

    public static /* synthetic */ void a(h hVar, y yVar, List list, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            list = null;
        }
        hVar.a(yVar, list);
    }

    public final <T extends y> void a(final y item, List<T> items) {
        Intrinsics.checkNotNullParameter(item, "item");
        io.bidmachine.rendering.internal.o.b(this.tag, "Destroy TargetObject - " + item.p(), new Object[0]);
        if (items != null) {
            TypeIntrinsics.asMutableCollection(items).remove(item);
        }
        UiUtils.onUiThread(new io.bidmachine.rendering.internal.n() { // from class: io.bidmachine.rendering.internal.controller.h$$ExternalSyntheticLambda0
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                y.this.a();
            }
        });
    }

    public final void a(Error error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (this.adState.a(false)) {
            this.adPhaseControllerListener.a(this, error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(BrokenCreativeEvent brokenCreativeEvent) {
        io.bidmachine.rendering.internal.controller.g presentListener;
        if (this.adState.h() || (presentListener = getPresentListener()) == null) {
            return;
        }
        presentListener.a(brokenCreativeEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String eventTaskName, String targetElementName) {
        io.bidmachine.rendering.internal.o.a(this.tag, "EventTask - " + eventTaskName + ", target object (" + targetElementName + ") not found", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String eventTaskName, String targetElementName, String className) {
        io.bidmachine.rendering.internal.o.a(this.tag, "EventTask - " + eventTaskName + ", target object (" + targetElementName + ") not " + className, new Object[0]);
    }

    public final List<InterfaceC3590c> a(List<AdElementParams> elementsParams, io.bidmachine.rendering.internal.adform.c adFormListener) {
        Intrinsics.checkNotNullParameter(elementsParams, "elementsParams");
        Intrinsics.checkNotNullParameter(adFormListener, "adFormListener");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(elementsParams, 10));
        Iterator<T> it = elementsParams.iterator();
        while (it.hasNext()) {
            arrayList.add(a((AdElementParams) it.next(), adFormListener));
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            a((io.bidmachine.rendering.internal.adform.a) it2.next(), adFormListener);
        }
        return arrayList;
    }
}
