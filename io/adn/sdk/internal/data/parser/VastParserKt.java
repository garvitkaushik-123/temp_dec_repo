package io.adn.sdk.internal.data.parser;

import androidx.core.app.NotificationCompat;
import com.ironsource.N6;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.adn.sdk.internal.common.utils.DateKt;
import io.adn.sdk.internal.data.dto.VastAdChildDto;
import io.adn.sdk.internal.data.dto.VastAdDto;
import io.adn.sdk.internal.data.dto.VastAdParametersDto;
import io.adn.sdk.internal.data.dto.VastAdSystemDto;
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
import io.adn.sdk.internal.data.dto.VastPricingDto;
import io.adn.sdk.internal.data.dto.VastVideoClickDto;
import io.adn.sdk.internal.data.dto.VastVideoClicksDto;
import io.adn.sdk.internal.data.dto.VastWrapperDto;
import io.adn.sdk.internal.domain.model.ad.VastOffset;
import io.adn.sdk.internal.domain.model.ad.VastResource;
import io.adn.sdk.internal.domain.model.ad.VastTracking;
import io.adn.sdk.internal.domain.model.ad.VastTrackingEvent;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: VastParser.kt */
@Metadata(d1 = {"\u0000ö\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b8\u001a¨\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022)\b\u0004\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\b\u00072>\b\u0004\u0010\b\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t¢\u0006\u0002\b\u00072)\b\u0004\u0010\u000e\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\b\u0007H\u0082H¢\u0006\u0002\u0010\u000f\u001a\u0016\u0010\u0010\u001a\u0004\u0018\u00010\n*\u00020\u00022\u0006\u0010\f\u001a\u00020\nH\u0002\u001a\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u0019*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0012\u0010\u001e\u001a\u00020\u001f*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010 \u001a\u0004\u0018\u00010!*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0013\u0010\"\u001a\u0004\u0018\u00010#*\u00020\u0002H\u0002¢\u0006\u0002\u0010$\u001a\u0014\u0010%\u001a\u0004\u0018\u00010&*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010'\u001a\u0004\u0018\u00010\n*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010(\u001a\u0004\u0018\u00010)*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a \u0010*\u001a\b\u0012\u0004\u0012\u00020,0+*\u00020\u00022\u0006\u0010-\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010.\u001a\u001c\u0010/\u001a\u0004\u0018\u00010,*\u00020\u00022\u0006\u0010-\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010.\u001a\u001c\u00100\u001a\u0004\u0018\u000101*\u00020\u00022\u0006\u0010-\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010.\u001a\u0014\u00102\u001a\u0004\u0018\u000103*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0014\u00104\u001a\u0004\u0018\u000105*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0018\u00106\u001a\b\u0012\u0004\u0012\u0002070+*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0014\u00108\u001a\u0004\u0018\u000107*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u000e\u00109\u001a\u0004\u0018\u00010:*\u00020\u0002H\u0002\u001a\u000e\u0010;\u001a\u0004\u0018\u00010:*\u00020\nH\u0002\u001a\u0013\u0010<\u001a\u0004\u0018\u00010=*\u00020\nH\u0002¢\u0006\u0002\u0010>\u001a\b\u0010?\u001a\u00020@H\u0002\u001a\b\u0010A\u001a\u00020@H\u0002\u001a\u0013\u0010B\u001a\u0004\u0018\u00010#*\u00020\nH\u0002¢\u0006\u0002\u0010C\u001a\u0014\u0010H\u001a\u0004\u0018\u00010I*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0018\u0010J\u001a\b\u0012\u0004\u0012\u00020K0+*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010L\u001a\u0004\u0018\u00010K*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0018\u0010M\u001a\b\u0012\u0004\u0012\u00020N0+*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010O\u001a\u0004\u0018\u00010N*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u000e\u0010P\u001a\u0004\u0018\u00010Q*\u00020\nH\u0002\u001a\u001c\u0010R\u001a\u0004\u0018\u00010S*\u00020\u00022\u0006\u0010-\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010.\u001a\u0014\u0010T\u001a\u0004\u0018\u00010U*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0018\u0010V\u001a\b\u0012\u0004\u0012\u00020W0+*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010X\u001a\u0004\u0018\u00010W*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010Y\u001a\u0004\u0018\u00010Z*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010[\u001a\u0004\u0018\u00010\\*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010]\u001a\u0004\u0018\u00010^*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010_\u001a\u0004\u0018\u00010`*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0018\u0010a\u001a\b\u0012\u0004\u0012\u0002050+*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010b\u001a\u0004\u0018\u00010\n*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u001a\"\u0018\u0010\u0011\u001a\u00020\u0012*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013\"\u0018\u0010\u0014\u001a\u00020\u0012*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013\"\u0018\u0010\u0015\u001a\u00020\u0012*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013\"\u0018\u0010\u0016\u001a\u00020\u0012*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013\"\u0018\u0010\u0017\u001a\u00020\u0012*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013\"\u0018\u0010D\u001a\n F*\u0004\u0018\u00010E0EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010G\"\u000e\u0010c\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010d\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010g\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010h\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010i\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010j\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010k\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010l\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010m\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010n\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010o\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010p\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010q\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010s\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010u\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010v\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010w\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010x\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010y\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010z\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010{\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010|\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010}\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010~\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u007f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0080\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0081\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0082\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0083\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0084\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0085\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0086\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0087\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0088\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0089\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u008a\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u008b\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u008c\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u008d\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u008e\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u008f\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0090\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0091\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0092\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0093\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0094\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0095\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0096\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0097\u0001\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0098\u0001"}, d2 = {"iterateTag", "", "Lorg/xmlpull/v1/XmlPullParser;", "onCurrentTag", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "onCurrentText", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "trimmedText", "onDirectChildTag", "(Lorg/xmlpull/v1/XmlPullParser;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "attribute", "isStartDocument", "", "(Lorg/xmlpull/v1/XmlPullParser;)Z", "isStartTag", "isText", "isEndTag", "isEndDocument", "parseVast", "Lio/adn/sdk/internal/data/dto/VastDto;", "(Lorg/xmlpull/v1/XmlPullParser;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseVastTag", "parseAdTag", "Lio/adn/sdk/internal/data/dto/VastAdDto;", "parseInLineTag", "Lio/adn/sdk/internal/data/dto/VastInLineDto;", "parseWrapperTag", "Lio/adn/sdk/internal/data/dto/VastWrapperDto;", "parseSequenceAttribute", "", "(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/Integer;", "parseAdSystemTag", "Lio/adn/sdk/internal/data/dto/VastAdSystemDto;", "parseErrorTag", "parsePricingTag", "Lio/adn/sdk/internal/data/dto/VastPricingDto;", "parseCreativesTag", "", "Lio/adn/sdk/internal/data/dto/VastCreativeDto;", "isInLineParent", "(Lorg/xmlpull/v1/XmlPullParser;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseCreativeTag", "parseLinearTag", "Lio/adn/sdk/internal/data/dto/VastLinearDto;", "parseImpressionTag", "Lio/adn/sdk/internal/data/dto/VastImpressionDto;", "parseCompanionTag", "Lio/adn/sdk/internal/data/dto/VastCompanionDto;", "parseExtensionsTag", "Lio/adn/sdk/internal/data/dto/VastExtensionDto;", "parseExtensionTag", "parseSkipOffsetAttribute", "Lio/adn/sdk/internal/domain/model/ad/VastOffset;", "toOffset", "toMillis", "", "(Ljava/lang/String;)Ljava/lang/Long;", "timeFormatterWithoutMillis", "Ljava/text/SimpleDateFormat;", "timeFormatterWithMillis", "toPercents", "(Ljava/lang/String;)Ljava/lang/Integer;", "percentageFormatter", "Ljava/text/NumberFormat;", "kotlin.jvm.PlatformType", "Ljava/text/NumberFormat;", "parseAdParametersTag", "Lio/adn/sdk/internal/data/dto/VastAdParametersDto;", "parseMediaFilesTag", "Lio/adn/sdk/internal/data/dto/VastMediaFileDto;", "parseMediaFileTag", "parseTrackingEventsTag", "Lio/adn/sdk/internal/domain/model/ad/VastTracking;", "parseTrackingTag", "toTrackingEvent", "Lio/adn/sdk/internal/domain/model/ad/VastTrackingEvent;", "parseVideoClicksTag", "Lio/adn/sdk/internal/data/dto/VastVideoClicksDto;", "parseVideoClickTag", "Lio/adn/sdk/internal/data/dto/VastVideoClickDto;", "parseIconsTag", "Lio/adn/sdk/internal/data/dto/VastIconDto;", "parseIconTag", "parseIconClicksTag", "Lio/adn/sdk/internal/data/dto/VastIconClicksDto;", "parseStaticResourceTag", "Lio/adn/sdk/internal/domain/model/ad/VastResource;", "parseHtmlResourceTag", "Lio/adn/sdk/internal/domain/model/ad/VastResource$Html;", "parseIFrameResourceTag", "Lio/adn/sdk/internal/domain/model/ad/VastResource$IFrame;", "parseCompanionAdsTag", "parseTagsTextOnly", "TAG_ERROR", "TAG_AD", "TAG_INLINE", "TAG_WRAPPER", "TAG_VAST_AD_TAG_URI", "TAG_AD_SYSTEM", "TAG_AD_TITLE", "TAG_DESCRIPTION", "TAG_ADVERTISER", "TAG_PRICING", "TAG_IMPRESSION", "TAG_CREATIVES", "TAG_CREATIVE", "TAG_LINEAR", "TAG_UNIVERSAL_AD_ID", "TAG_EXTENSIONS", "TAG_EXTENSION", "TAG_CUSTOM_EVENT", "TAG_AD_PARAMETERS", "TAG_DURATION", "TAG_MEDIA_FILES", "TAG_MEDIA_FILE", "TAG_TRACKING_EVENTS", "TAG_TRACKING", "TAG_VIDEO_CLICKS", "TAG_CLICK_THROUGH", "TAG_CLICK_TRACKING", "TAG_CUSTOM_CLICK", "TAG_ICONS", "TAG_ICON", "TAG_STATIC_RESOURCE", "TAG_IFRAME_RESOURCE", "TAG_HTML_RESOURCE", "TAG_ICON_CLICKS", "TAG_ICON_CLICK_THROUGH", "TAG_ICON_CLICK_TRACKING", "TAG_ICON_VIEW_TRACKING", "TAG_ALT_TEXT", "TAG_COMPANION_ADS", "TAG_COMPANION", "TAG_COMPANION_CLICK_THROUGH", "TAG_COMPANION_CLICK_TRACKING", "ATTRIBUTE_ID", "ATTRIBUTE_API_FRAMEWORK", "ATTRIBUTE_PROGRAM", "ATTRIBUTE_WIDTH", "ATTRIBUTE_HEIGHT", "ATTRIBUTE_OFFSET", "ATTRIBUTE_TYPE", "ATTRIBUTE_DURATION", "ATTRIBUTE_CREATIVE_TYPE", "ATTRIBUTE_EVENT", "CLASS_NAME", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class VastParserKt {
    private static final String ATTRIBUTE_API_FRAMEWORK = "apiFramework";
    private static final String ATTRIBUTE_CREATIVE_TYPE = "creativeType";
    private static final String ATTRIBUTE_DURATION = "duration";
    private static final String ATTRIBUTE_EVENT = "event";
    private static final String ATTRIBUTE_HEIGHT = "height";
    private static final String ATTRIBUTE_ID = "id";
    private static final String ATTRIBUTE_OFFSET = "offset";
    private static final String ATTRIBUTE_PROGRAM = "program";
    private static final String ATTRIBUTE_TYPE = "type";
    private static final String ATTRIBUTE_WIDTH = "width";
    private static final String CLASS_NAME = "VastParser";
    private static final String TAG_AD = "Ad";
    private static final String TAG_ADVERTISER = "Advertiser";
    private static final String TAG_AD_PARAMETERS = "AdParameters";
    private static final String TAG_AD_SYSTEM = "AdSystem";
    private static final String TAG_AD_TITLE = "AdTitle";
    private static final String TAG_ALT_TEXT = "AltText";
    private static final String TAG_CLICK_THROUGH = "ClickThrough";
    private static final String TAG_CLICK_TRACKING = "ClickTracking";
    private static final String TAG_COMPANION = "Companion";
    private static final String TAG_COMPANION_ADS = "CompanionAds";
    private static final String TAG_COMPANION_CLICK_THROUGH = "CompanionClickThrough";
    private static final String TAG_COMPANION_CLICK_TRACKING = "CompanionClickTracking";
    private static final String TAG_CREATIVE = "Creative";
    private static final String TAG_CREATIVES = "Creatives";
    private static final String TAG_CUSTOM_CLICK = "CustomClick";
    private static final String TAG_CUSTOM_EVENT = "CustomEvent";
    private static final String TAG_DESCRIPTION = "Description";
    private static final String TAG_DURATION = "Duration";
    private static final String TAG_ERROR = "Error";
    private static final String TAG_EXTENSION = "Extension";
    private static final String TAG_EXTENSIONS = "Extensions";
    private static final String TAG_HTML_RESOURCE = "HTMLResource";
    private static final String TAG_ICON = "Icon";
    private static final String TAG_ICONS = "Icons";
    private static final String TAG_ICON_CLICKS = "IconClicks";
    private static final String TAG_ICON_CLICK_THROUGH = "IconClickThrough";
    private static final String TAG_ICON_CLICK_TRACKING = "IconClickTracking";
    private static final String TAG_ICON_VIEW_TRACKING = "IconViewTracking";
    private static final String TAG_IFRAME_RESOURCE = "IFrameResource";
    private static final String TAG_IMPRESSION = "Impression";
    private static final String TAG_INLINE = "InLine";
    private static final String TAG_LINEAR = "Linear";
    private static final String TAG_MEDIA_FILE = "MediaFile";
    private static final String TAG_MEDIA_FILES = "MediaFiles";
    private static final String TAG_PRICING = "Pricing";
    private static final String TAG_STATIC_RESOURCE = "StaticResource";
    private static final String TAG_TRACKING = "Tracking";
    private static final String TAG_TRACKING_EVENTS = "TrackingEvents";
    private static final String TAG_UNIVERSAL_AD_ID = "UniversalAdId";
    private static final String TAG_VAST_AD_TAG_URI = "VASTAdTagURI";
    private static final String TAG_VIDEO_CLICKS = "VideoClicks";
    private static final String TAG_WRAPPER = "Wrapper";
    private static final NumberFormat percentageFormatter = NumberFormat.getPercentInstance();

    private static final Object iterateTag(XmlPullParser xmlPullParser, Function2<? super XmlPullParser, ? super Continuation<? super Unit>, ? extends Object> function2, Function3<? super XmlPullParser, ? super String, ? super Continuation<? super Unit>, ? extends Object> function3, Function2<? super XmlPullParser, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super Unit> continuation) {
        String text;
        if (isStartDocument(xmlPullParser)) {
            xmlPullParser.nextTag();
        }
        if (isEndDocument(xmlPullParser)) {
            return Unit.INSTANCE;
        }
        if (!isStartTag(xmlPullParser)) {
            throw new XmlPullParserException("allowed only for START_TAG");
        }
        int depth = xmlPullParser.getDepth();
        while (xmlPullParser.getDepth() >= depth) {
            int depth2 = xmlPullParser.getDepth() - depth;
            if (depth2 == 0) {
                if (isStartTag(xmlPullParser)) {
                    function2.invoke(xmlPullParser, continuation);
                } else if (isText(xmlPullParser) && (text = xmlPullParser.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = xmlPullParser.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    function3.invoke(xmlPullParser, StringsKt.trim((CharSequence) text2).toString(), continuation);
                } else if (isEndTag(xmlPullParser)) {
                    return Unit.INSTANCE;
                }
            } else if (depth2 == 1 && isStartTag(xmlPullParser)) {
                function22.invoke(xmlPullParser, continuation);
            }
            xmlPullParser.next();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String attribute(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null || StringsKt.isBlank(attributeValue)) {
            return null;
        }
        return attributeValue;
    }

    private static final boolean isStartDocument(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 0;
    }

    private static final boolean isStartTag(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 2;
    }

    private static final boolean isText(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 4;
    }

    private static final boolean isEndTag(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 3;
    }

    private static final boolean isEndDocument(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object parseVast(XmlPullParser xmlPullParser, Continuation<? super VastDto> continuation) {
        return parseVastTag(xmlPullParser, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x014b, code lost:
    
        if (isEndTag(r11) != false) goto L64;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Type inference failed for: r12v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v24, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v31, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x009f -> B:15:0x014e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00a7 -> B:15:0x014e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00e3 -> B:15:0x014e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00fa -> B:11:0x00fe). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0110 -> B:15:0x014e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0131 -> B:15:0x014e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x014b -> B:15:0x014e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object parseVastTag(XmlPullParser xmlPullParser, Continuation<? super VastDto> continuation) {
        VastParserKt$parseVastTag$1 vastParserKt$parseVastTag$1;
        int i;
        ArrayList arrayList;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        int depth;
        ArrayList arrayList2;
        String text;
        if (continuation instanceof VastParserKt$parseVastTag$1) {
            vastParserKt$parseVastTag$1 = (VastParserKt$parseVastTag$1) continuation;
            if ((vastParserKt$parseVastTag$1.label & Integer.MIN_VALUE) != 0) {
                vastParserKt$parseVastTag$1.label -= Integer.MIN_VALUE;
                ?? r12 = vastParserKt$parseVastTag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = vastParserKt$parseVastTag$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(r12);
                    arrayList = new ArrayList();
                    objectRef = new Ref.ObjectRef();
                    objectRef2 = new Ref.ObjectRef();
                    if (isStartDocument(xmlPullParser)) {
                        xmlPullParser.nextTag();
                    }
                    if (!isEndDocument(xmlPullParser)) {
                        if (!isStartTag(xmlPullParser)) {
                            throw new XmlPullParserException("allowed only for START_TAG");
                        }
                        depth = xmlPullParser.getDepth();
                        arrayList2 = arrayList;
                        if (xmlPullParser.getDepth() >= depth) {
                        }
                        arrayList = arrayList2;
                    }
                    if (arrayList.isEmpty()) {
                    }
                    return new VastDto(arrayList, (String) objectRef2.element, (String) objectRef.element);
                }
                if (i == 1) {
                    int i2 = vastParserKt$parseVastTag$1.I$0;
                    Ref.ObjectRef objectRef3 = (Ref.ObjectRef) vastParserKt$parseVastTag$1.L$4;
                    XmlPullParser xmlPullParser2 = (XmlPullParser) vastParserKt$parseVastTag$1.L$3;
                    Ref.ObjectRef objectRef4 = (Ref.ObjectRef) vastParserKt$parseVastTag$1.L$2;
                    Ref.ObjectRef objectRef5 = (Ref.ObjectRef) vastParserKt$parseVastTag$1.L$1;
                    ?? r9 = (List) vastParserKt$parseVastTag$1.L$0;
                    ResultKt.throwOnFailure(r12);
                    objectRef3.element = r12;
                    depth = i2;
                    xmlPullParser = xmlPullParser2;
                    objectRef2 = objectRef4;
                    objectRef = objectRef5;
                    arrayList2 = r9;
                    xmlPullParser.next();
                    arrayList2 = arrayList2;
                    if (xmlPullParser.getDepth() >= depth) {
                    }
                    arrayList = arrayList2;
                    if (arrayList.isEmpty()) {
                    }
                    return new VastDto(arrayList, (String) objectRef2.element, (String) objectRef.element);
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = vastParserKt$parseVastTag$1.I$0;
                XmlPullParser xmlPullParser3 = (XmlPullParser) vastParserKt$parseVastTag$1.L$3;
                objectRef2 = (Ref.ObjectRef) vastParserKt$parseVastTag$1.L$2;
                Ref.ObjectRef objectRef6 = (Ref.ObjectRef) vastParserKt$parseVastTag$1.L$1;
                ?? r8 = (List) vastParserKt$parseVastTag$1.L$0;
                ResultKt.throwOnFailure(r12);
                arrayList2 = r8;
                Object obj = r12;
                VastAdDto vastAdDto = (VastAdDto) obj;
                if (vastAdDto != null) {
                    arrayList2.add(vastAdDto);
                }
                Ref.ObjectRef objectRef7 = objectRef6;
                depth = i3;
                xmlPullParser = xmlPullParser3;
                objectRef = objectRef7;
                xmlPullParser.next();
                arrayList2 = arrayList2;
                if (xmlPullParser.getDepth() >= depth) {
                    int depth2 = xmlPullParser.getDepth() - depth;
                    if (depth2 == 0) {
                        if (isStartTag(xmlPullParser)) {
                            objectRef.element = attribute(xmlPullParser, "version");
                        } else if (isText(xmlPullParser) && (text = xmlPullParser.getText()) != null && !StringsKt.isBlank(text)) {
                            String text2 = xmlPullParser.getText();
                            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                            StringsKt.trim((CharSequence) text2).toString();
                        }
                    } else if (depth2 == 1 && isStartTag(xmlPullParser)) {
                        String name = xmlPullParser.getName();
                        if (Intrinsics.areEqual(name, "Error")) {
                            vastParserKt$parseVastTag$1.L$0 = arrayList2;
                            vastParserKt$parseVastTag$1.L$1 = objectRef;
                            vastParserKt$parseVastTag$1.L$2 = objectRef2;
                            vastParserKt$parseVastTag$1.L$3 = xmlPullParser;
                            vastParserKt$parseVastTag$1.L$4 = objectRef2;
                            vastParserKt$parseVastTag$1.I$0 = depth;
                            vastParserKt$parseVastTag$1.label = 1;
                            ?? parseErrorTag = parseErrorTag(xmlPullParser, vastParserKt$parseVastTag$1);
                            if (parseErrorTag != coroutine_suspended) {
                                ArrayList arrayList3 = arrayList2;
                                Ref.ObjectRef objectRef8 = objectRef;
                                Ref.ObjectRef objectRef9 = objectRef2;
                                XmlPullParser xmlPullParser4 = xmlPullParser;
                                int i4 = depth;
                                objectRef9.element = parseErrorTag;
                                depth = i4;
                                xmlPullParser = xmlPullParser4;
                                objectRef2 = objectRef9;
                                objectRef = objectRef8;
                                arrayList2 = arrayList3;
                            }
                            return coroutine_suspended;
                        }
                        if (Intrinsics.areEqual(name, "Ad")) {
                            vastParserKt$parseVastTag$1.L$0 = arrayList2;
                            vastParserKt$parseVastTag$1.L$1 = objectRef;
                            vastParserKt$parseVastTag$1.L$2 = objectRef2;
                            vastParserKt$parseVastTag$1.L$3 = xmlPullParser;
                            vastParserKt$parseVastTag$1.L$4 = null;
                            vastParserKt$parseVastTag$1.I$0 = depth;
                            vastParserKt$parseVastTag$1.label = 2;
                            Object parseAdTag = parseAdTag(xmlPullParser, vastParserKt$parseVastTag$1);
                            if (parseAdTag != coroutine_suspended) {
                                Ref.ObjectRef objectRef10 = objectRef;
                                xmlPullParser3 = xmlPullParser;
                                i3 = depth;
                                objectRef6 = objectRef10;
                                arrayList2 = arrayList2;
                                obj = parseAdTag;
                                VastAdDto vastAdDto2 = (VastAdDto) obj;
                                if (vastAdDto2 != null) {
                                }
                                Ref.ObjectRef objectRef72 = objectRef6;
                                depth = i3;
                                xmlPullParser = xmlPullParser3;
                                objectRef = objectRef72;
                            }
                            return coroutine_suspended;
                        }
                        if (xmlPullParser.getDepth() >= depth) {
                        }
                    }
                    xmlPullParser.next();
                    arrayList2 = arrayList2;
                    if (xmlPullParser.getDepth() >= depth) {
                    }
                }
                arrayList = arrayList2;
                if (arrayList.isEmpty() || objectRef2.element != null) {
                    return new VastDto(arrayList, (String) objectRef2.element, (String) objectRef.element);
                }
                return null;
            }
        }
        vastParserKt$parseVastTag$1 = new VastParserKt$parseVastTag$1(continuation);
        ?? r122 = vastParserKt$parseVastTag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = vastParserKt$parseVastTag$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0161, code lost:
    
        if (isEndTag(r11) != false) goto L70;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0189 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Type inference failed for: r12v25, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v26, types: [T, java.lang.Integer] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00a3 -> B:17:0x0164). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00ab -> B:17:0x0164). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00b2 -> B:17:0x0164). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0101 -> B:11:0x0104). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0112 -> B:16:0x0115). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0120 -> B:17:0x0164). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0147 -> B:17:0x0164). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0161 -> B:17:0x0164). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object parseAdTag(XmlPullParser xmlPullParser, Continuation<? super VastAdDto> continuation) {
        VastParserKt$parseAdTag$1 vastParserKt$parseAdTag$1;
        int i;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        int depth;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        Ref.ObjectRef objectRef6;
        VastAdChildDto vastAdChildDto;
        String text;
        Ref.ObjectRef objectRef7;
        XmlPullParser xmlPullParser2;
        int i2;
        VastAdChildDto inLine;
        if (continuation instanceof VastParserKt$parseAdTag$1) {
            vastParserKt$parseAdTag$1 = (VastParserKt$parseAdTag$1) continuation;
            if ((vastParserKt$parseAdTag$1.label & Integer.MIN_VALUE) != 0) {
                vastParserKt$parseAdTag$1.label -= Integer.MIN_VALUE;
                Object obj = vastParserKt$parseAdTag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = vastParserKt$parseAdTag$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    objectRef = new Ref.ObjectRef();
                    objectRef2 = new Ref.ObjectRef();
                    objectRef3 = new Ref.ObjectRef();
                    if (isStartDocument(xmlPullParser)) {
                        xmlPullParser.nextTag();
                    }
                    if (!isEndDocument(xmlPullParser)) {
                        if (!isStartTag(xmlPullParser)) {
                            throw new XmlPullParserException("allowed only for START_TAG");
                        }
                        depth = xmlPullParser.getDepth();
                        objectRef4 = objectRef;
                        objectRef5 = objectRef2;
                        objectRef6 = objectRef3;
                        if (xmlPullParser.getDepth() >= depth) {
                        }
                        objectRef3 = objectRef6;
                        objectRef2 = objectRef5;
                        objectRef = objectRef4;
                    }
                    vastAdChildDto = (VastAdChildDto) objectRef3.element;
                    if (vastAdChildDto != null) {
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i2 = vastParserKt$parseAdTag$1.I$0;
                        objectRef6 = (Ref.ObjectRef) vastParserKt$parseAdTag$1.L$4;
                        xmlPullParser2 = (XmlPullParser) vastParserKt$parseAdTag$1.L$3;
                        objectRef7 = (Ref.ObjectRef) vastParserKt$parseAdTag$1.L$2;
                        objectRef5 = (Ref.ObjectRef) vastParserKt$parseAdTag$1.L$1;
                        objectRef4 = (Ref.ObjectRef) vastParserKt$parseAdTag$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        VastWrapperDto vastWrapperDto = (VastWrapperDto) obj;
                        inLine = vastWrapperDto == null ? new VastAdChildDto.Wrapper(vastWrapperDto) : null;
                        int i3 = i2;
                        xmlPullParser = xmlPullParser2;
                        T t = inLine;
                        objectRef6.element = t;
                        objectRef6 = objectRef7;
                        depth = i3;
                        xmlPullParser.next();
                        if (xmlPullParser.getDepth() >= depth) {
                            int depth2 = xmlPullParser.getDepth() - depth;
                            if (depth2 == 0) {
                                if (isStartTag(xmlPullParser)) {
                                    objectRef4.element = attribute(xmlPullParser, "id");
                                    objectRef5.element = parseSequenceAttribute(xmlPullParser);
                                } else if (isText(xmlPullParser) && (text = xmlPullParser.getText()) != null && !StringsKt.isBlank(text)) {
                                    String text2 = xmlPullParser.getText();
                                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                                    StringsKt.trim((CharSequence) text2).toString();
                                }
                            } else if (depth2 == 1 && isStartTag(xmlPullParser) && objectRef6.element == 0) {
                                String name = xmlPullParser.getName();
                                if (Intrinsics.areEqual(name, "InLine")) {
                                    vastParserKt$parseAdTag$1.L$0 = objectRef4;
                                    vastParserKt$parseAdTag$1.L$1 = objectRef5;
                                    vastParserKt$parseAdTag$1.L$2 = objectRef6;
                                    vastParserKt$parseAdTag$1.L$3 = xmlPullParser;
                                    vastParserKt$parseAdTag$1.L$4 = objectRef6;
                                    vastParserKt$parseAdTag$1.I$0 = depth;
                                    vastParserKt$parseAdTag$1.label = 1;
                                    Object parseInLineTag = parseInLineTag(xmlPullParser, vastParserKt$parseAdTag$1);
                                    if (parseInLineTag != coroutine_suspended) {
                                        xmlPullParser2 = xmlPullParser;
                                        i2 = depth;
                                        objectRef7 = objectRef6;
                                        inLine = new VastAdChildDto.InLine((VastInLineDto) parseInLineTag);
                                        int i32 = i2;
                                        xmlPullParser = xmlPullParser2;
                                        T t2 = inLine;
                                        objectRef6.element = t2;
                                        objectRef6 = objectRef7;
                                        depth = i32;
                                    }
                                } else if (Intrinsics.areEqual(name, "Wrapper")) {
                                    vastParserKt$parseAdTag$1.L$0 = objectRef4;
                                    vastParserKt$parseAdTag$1.L$1 = objectRef5;
                                    vastParserKt$parseAdTag$1.L$2 = objectRef6;
                                    vastParserKt$parseAdTag$1.L$3 = xmlPullParser;
                                    vastParserKt$parseAdTag$1.L$4 = objectRef6;
                                    vastParserKt$parseAdTag$1.I$0 = depth;
                                    vastParserKt$parseAdTag$1.label = 2;
                                    obj = parseWrapperTag(xmlPullParser, vastParserKt$parseAdTag$1);
                                    if (obj != coroutine_suspended) {
                                        xmlPullParser2 = xmlPullParser;
                                        i2 = depth;
                                        objectRef7 = objectRef6;
                                        VastWrapperDto vastWrapperDto2 = (VastWrapperDto) obj;
                                        inLine = vastWrapperDto2 == null ? new VastAdChildDto.Wrapper(vastWrapperDto2) : null;
                                        int i322 = i2;
                                        xmlPullParser = xmlPullParser2;
                                        T t22 = inLine;
                                        objectRef6.element = t22;
                                        objectRef6 = objectRef7;
                                        depth = i322;
                                    }
                                } else {
                                    t22 = 0;
                                    i322 = depth;
                                    objectRef7 = objectRef6;
                                    objectRef6.element = t22;
                                    objectRef6 = objectRef7;
                                    depth = i322;
                                }
                                return coroutine_suspended;
                            }
                            xmlPullParser.next();
                            if (xmlPullParser.getDepth() >= depth) {
                            }
                        }
                        objectRef3 = objectRef6;
                        objectRef2 = objectRef5;
                        objectRef = objectRef4;
                        vastAdChildDto = (VastAdChildDto) objectRef3.element;
                        if (vastAdChildDto != null) {
                            return new VastAdDto((String) objectRef.element, (Integer) objectRef2.element, vastAdChildDto);
                        }
                        return null;
                    }
                    i2 = vastParserKt$parseAdTag$1.I$0;
                    objectRef6 = (Ref.ObjectRef) vastParserKt$parseAdTag$1.L$4;
                    xmlPullParser2 = (XmlPullParser) vastParserKt$parseAdTag$1.L$3;
                    objectRef7 = (Ref.ObjectRef) vastParserKt$parseAdTag$1.L$2;
                    objectRef5 = (Ref.ObjectRef) vastParserKt$parseAdTag$1.L$1;
                    objectRef4 = (Ref.ObjectRef) vastParserKt$parseAdTag$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    inLine = new VastAdChildDto.InLine((VastInLineDto) obj);
                    int i3222 = i2;
                    xmlPullParser = xmlPullParser2;
                    T t222 = inLine;
                    objectRef6.element = t222;
                    objectRef6 = objectRef7;
                    depth = i3222;
                    xmlPullParser.next();
                    if (xmlPullParser.getDepth() >= depth) {
                    }
                    objectRef3 = objectRef6;
                    objectRef2 = objectRef5;
                    objectRef = objectRef4;
                    vastAdChildDto = (VastAdChildDto) objectRef3.element;
                    if (vastAdChildDto != null) {
                    }
                }
            }
        }
        vastParserKt$parseAdTag$1 = new VastParserKt$parseAdTag$1(continuation);
        Object obj2 = vastParserKt$parseAdTag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = vastParserKt$parseAdTag$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x04c0, code lost:
    
        if (isEndTag(r0) != false) goto L136;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v37, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v49, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v53, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v58 */
    /* JADX WARN: Type inference failed for: r5v65, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v69, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v73, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v78 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v41 */
    /* JADX WARN: Type inference failed for: r6v44 */
    /* JADX WARN: Type inference failed for: r6v47 */
    /* JADX WARN: Type inference failed for: r6v50 */
    /* JADX WARN: Type inference failed for: r6v51 */
    /* JADX WARN: Type inference failed for: r6v53, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v18, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v24, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v51 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v18, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v25, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v52 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x025c -> B:14:0x04c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0264 -> B:14:0x04c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x026d -> B:14:0x04c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0274 -> B:14:0x04c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x027f -> B:14:0x04c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x02b9 -> B:14:0x04c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x02cb -> B:14:0x04c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0301 -> B:14:0x04c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0337 -> B:14:0x04c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x036d -> B:14:0x04c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0395 -> B:12:0x0399). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x03a6 -> B:14:0x04c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x03e8 -> B:14:0x04c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x041d -> B:14:0x04c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0454 -> B:14:0x04c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x048d -> B:14:0x04c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x04a6 -> B:14:0x04c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x04c0 -> B:14:0x04c3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object parseInLineTag(XmlPullParser xmlPullParser, Continuation<? super VastInLineDto> continuation) {
        VastParserKt$parseInLineTag$1 vastParserKt$parseInLineTag$1;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ?? r9;
        List list;
        Ref.ObjectRef objectRef6;
        Ref.ObjectRef objectRef7;
        Ref.ObjectRef objectRef8;
        ArrayList arrayList5;
        int depth;
        XmlPullParser xmlPullParser2;
        Ref.ObjectRef objectRef9;
        Ref.ObjectRef objectRef10;
        XmlPullParser xmlPullParser3;
        ?? r6;
        XmlPullParser xmlPullParser4;
        ?? r5;
        List list2;
        List list3;
        List list4;
        Ref.ObjectRef objectRef11;
        Ref.ObjectRef objectRef12;
        Ref.ObjectRef objectRef13;
        Ref.ObjectRef objectRef14;
        Ref.ObjectRef objectRef15;
        Object obj;
        String str;
        ArrayList arrayList6;
        List list5;
        List list6;
        Object obj2;
        VastImpressionDto vastImpressionDto;
        String text;
        Object obj3;
        ArrayList arrayList7;
        if (continuation instanceof VastParserKt$parseInLineTag$1) {
            vastParserKt$parseInLineTag$1 = (VastParserKt$parseInLineTag$1) continuation;
            if ((vastParserKt$parseInLineTag$1.label & Integer.MIN_VALUE) != 0) {
                vastParserKt$parseInLineTag$1.label -= Integer.MIN_VALUE;
                ?? r0 = vastParserKt$parseInLineTag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (vastParserKt$parseInLineTag$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(r0);
                        objectRef = new Ref.ObjectRef();
                        objectRef2 = new Ref.ObjectRef();
                        objectRef3 = new Ref.ObjectRef();
                        objectRef4 = new Ref.ObjectRef();
                        objectRef5 = new Ref.ObjectRef();
                        ArrayList arrayList8 = new ArrayList();
                        arrayList = new ArrayList();
                        ArrayList arrayList9 = new ArrayList();
                        ArrayList arrayList10 = new ArrayList();
                        if (isStartDocument(xmlPullParser)) {
                            xmlPullParser.nextTag();
                        }
                        if (isEndDocument(xmlPullParser)) {
                            arrayList2 = arrayList8;
                            arrayList3 = arrayList9;
                            arrayList4 = arrayList10;
                            return new VastInLineDto((VastAdSystemDto) objectRef.element, (String) objectRef2.element, (String) objectRef3.element, (String) objectRef4.element, (VastPricingDto) objectRef5.element, arrayList2, arrayList, arrayList3, arrayList4);
                        }
                        if (!isStartTag(xmlPullParser)) {
                            throw new XmlPullParserException("allowed only for START_TAG");
                        }
                        r9 = arrayList8;
                        list = arrayList9;
                        objectRef6 = objectRef;
                        objectRef7 = objectRef2;
                        objectRef8 = objectRef3;
                        arrayList5 = arrayList10;
                        depth = xmlPullParser.getDepth();
                        xmlPullParser2 = xmlPullParser;
                        objectRef9 = objectRef4;
                        objectRef10 = objectRef5;
                        if (xmlPullParser2.getDepth() >= depth) {
                            int depth2 = xmlPullParser2.getDepth() - depth;
                            if (depth2 != 0) {
                                arrayList6 = arrayList5;
                                list6 = list;
                                list5 = r9;
                                if (depth2 == 1) {
                                    arrayList6 = arrayList5;
                                    list6 = list;
                                    list5 = r9;
                                    if (isStartTag(xmlPullParser2)) {
                                        String name = xmlPullParser2.getName();
                                        arrayList6 = arrayList5;
                                        list6 = list;
                                        list5 = r9;
                                        if (name != null) {
                                            arrayList6 = arrayList5;
                                            list6 = list;
                                            list5 = r9;
                                            switch (name.hashCode()) {
                                                case -1692490108:
                                                    arrayList6 = arrayList5;
                                                    list6 = list;
                                                    list5 = r9;
                                                    if (name.equals("Creatives")) {
                                                        vastParserKt$parseInLineTag$1.L$0 = objectRef6;
                                                        vastParserKt$parseInLineTag$1.L$1 = objectRef7;
                                                        vastParserKt$parseInLineTag$1.L$2 = objectRef8;
                                                        vastParserKt$parseInLineTag$1.L$3 = objectRef9;
                                                        vastParserKt$parseInLineTag$1.L$4 = objectRef10;
                                                        vastParserKt$parseInLineTag$1.L$5 = r9;
                                                        vastParserKt$parseInLineTag$1.L$6 = arrayList;
                                                        vastParserKt$parseInLineTag$1.L$7 = list;
                                                        vastParserKt$parseInLineTag$1.L$8 = arrayList5;
                                                        vastParserKt$parseInLineTag$1.L$9 = xmlPullParser2;
                                                        vastParserKt$parseInLineTag$1.L$10 = list;
                                                        vastParserKt$parseInLineTag$1.I$0 = depth;
                                                        vastParserKt$parseInLineTag$1.label = 8;
                                                        Object parseCreativesTag = parseCreativesTag(xmlPullParser2, true, vastParserKt$parseInLineTag$1);
                                                        if (parseCreativesTag != coroutine_suspended) {
                                                            xmlPullParser3 = xmlPullParser2;
                                                            r6 = arrayList5;
                                                            list.addAll((Collection) parseCreativesTag);
                                                            xmlPullParser2 = xmlPullParser3;
                                                            arrayList6 = r6;
                                                            list6 = list;
                                                            list5 = r9;
                                                            break;
                                                        }
                                                        return coroutine_suspended;
                                                    }
                                                    break;
                                                case -1633884078:
                                                    arrayList6 = arrayList5;
                                                    list6 = list;
                                                    list5 = r9;
                                                    if (name.equals("AdSystem")) {
                                                        vastParserKt$parseInLineTag$1.L$0 = objectRef6;
                                                        vastParserKt$parseInLineTag$1.L$1 = objectRef7;
                                                        vastParserKt$parseInLineTag$1.L$2 = objectRef8;
                                                        vastParserKt$parseInLineTag$1.L$3 = objectRef9;
                                                        vastParserKt$parseInLineTag$1.L$4 = objectRef10;
                                                        vastParserKt$parseInLineTag$1.L$5 = r9;
                                                        vastParserKt$parseInLineTag$1.L$6 = arrayList;
                                                        vastParserKt$parseInLineTag$1.L$7 = list;
                                                        vastParserKt$parseInLineTag$1.L$8 = arrayList5;
                                                        vastParserKt$parseInLineTag$1.L$9 = xmlPullParser2;
                                                        vastParserKt$parseInLineTag$1.L$10 = objectRef6;
                                                        vastParserKt$parseInLineTag$1.I$0 = depth;
                                                        vastParserKt$parseInLineTag$1.label = 1;
                                                        ?? parseAdSystemTag = parseAdSystemTag(xmlPullParser2, vastParserKt$parseInLineTag$1);
                                                        if (parseAdSystemTag != coroutine_suspended) {
                                                            xmlPullParser3 = xmlPullParser2;
                                                            r6 = arrayList5;
                                                            objectRef6.element = parseAdSystemTag;
                                                            xmlPullParser2 = xmlPullParser3;
                                                            arrayList6 = r6;
                                                            list6 = list;
                                                            list5 = r9;
                                                            break;
                                                        }
                                                        return coroutine_suspended;
                                                    }
                                                    break;
                                                case -56677412:
                                                    arrayList6 = arrayList5;
                                                    list6 = list;
                                                    list5 = r9;
                                                    if (name.equals("Description")) {
                                                        vastParserKt$parseInLineTag$1.L$0 = objectRef6;
                                                        vastParserKt$parseInLineTag$1.L$1 = objectRef7;
                                                        vastParserKt$parseInLineTag$1.L$2 = objectRef8;
                                                        vastParserKt$parseInLineTag$1.L$3 = objectRef9;
                                                        vastParserKt$parseInLineTag$1.L$4 = objectRef10;
                                                        vastParserKt$parseInLineTag$1.L$5 = r9;
                                                        vastParserKt$parseInLineTag$1.L$6 = arrayList;
                                                        vastParserKt$parseInLineTag$1.L$7 = list;
                                                        vastParserKt$parseInLineTag$1.L$8 = arrayList5;
                                                        vastParserKt$parseInLineTag$1.L$9 = xmlPullParser2;
                                                        vastParserKt$parseInLineTag$1.L$10 = objectRef8;
                                                        vastParserKt$parseInLineTag$1.I$0 = depth;
                                                        vastParserKt$parseInLineTag$1.label = 3;
                                                        ?? parseTagsTextOnly = parseTagsTextOnly(xmlPullParser2, vastParserKt$parseInLineTag$1);
                                                        if (parseTagsTextOnly != coroutine_suspended) {
                                                            xmlPullParser3 = xmlPullParser2;
                                                            r6 = arrayList5;
                                                            objectRef8.element = parseTagsTextOnly;
                                                            xmlPullParser2 = xmlPullParser3;
                                                            arrayList6 = r6;
                                                            list6 = list;
                                                            list5 = r9;
                                                            break;
                                                        }
                                                        return coroutine_suspended;
                                                    }
                                                    break;
                                                case 67232232:
                                                    arrayList6 = arrayList5;
                                                    list6 = list;
                                                    list5 = r9;
                                                    if (name.equals("Error")) {
                                                        vastParserKt$parseInLineTag$1.L$0 = objectRef6;
                                                        vastParserKt$parseInLineTag$1.L$1 = objectRef7;
                                                        vastParserKt$parseInLineTag$1.L$2 = objectRef8;
                                                        vastParserKt$parseInLineTag$1.L$3 = objectRef9;
                                                        vastParserKt$parseInLineTag$1.L$4 = objectRef10;
                                                        vastParserKt$parseInLineTag$1.L$5 = r9;
                                                        vastParserKt$parseInLineTag$1.L$6 = arrayList;
                                                        vastParserKt$parseInLineTag$1.L$7 = list;
                                                        vastParserKt$parseInLineTag$1.L$8 = arrayList5;
                                                        vastParserKt$parseInLineTag$1.L$9 = xmlPullParser2;
                                                        vastParserKt$parseInLineTag$1.L$10 = null;
                                                        vastParserKt$parseInLineTag$1.I$0 = depth;
                                                        vastParserKt$parseInLineTag$1.label = 7;
                                                        Object parseErrorTag = parseErrorTag(xmlPullParser2, vastParserKt$parseInLineTag$1);
                                                        if (parseErrorTag != coroutine_suspended) {
                                                            ArrayList arrayList11 = arrayList5;
                                                            xmlPullParser4 = xmlPullParser2;
                                                            obj = parseErrorTag;
                                                            r5 = arrayList11;
                                                            list2 = list;
                                                            list3 = arrayList;
                                                            list4 = r9;
                                                            objectRef11 = objectRef10;
                                                            objectRef12 = objectRef9;
                                                            objectRef13 = objectRef8;
                                                            objectRef14 = objectRef7;
                                                            objectRef15 = objectRef6;
                                                            str = (String) obj;
                                                            if (str != null) {
                                                                list3.add(str);
                                                            }
                                                            xmlPullParser2 = xmlPullParser4;
                                                            arrayList6 = r5;
                                                            objectRef6 = objectRef15;
                                                            objectRef7 = objectRef14;
                                                            objectRef8 = objectRef13;
                                                            objectRef9 = objectRef12;
                                                            objectRef10 = objectRef11;
                                                            list5 = list4;
                                                            arrayList = list3;
                                                            list6 = list2;
                                                            break;
                                                        }
                                                        return coroutine_suspended;
                                                    }
                                                    break;
                                                case 184043572:
                                                    arrayList6 = arrayList5;
                                                    list6 = list;
                                                    list5 = r9;
                                                    if (name.equals("Extensions")) {
                                                        vastParserKt$parseInLineTag$1.L$0 = objectRef6;
                                                        vastParserKt$parseInLineTag$1.L$1 = objectRef7;
                                                        vastParserKt$parseInLineTag$1.L$2 = objectRef8;
                                                        vastParserKt$parseInLineTag$1.L$3 = objectRef9;
                                                        vastParserKt$parseInLineTag$1.L$4 = objectRef10;
                                                        vastParserKt$parseInLineTag$1.L$5 = r9;
                                                        vastParserKt$parseInLineTag$1.L$6 = arrayList;
                                                        vastParserKt$parseInLineTag$1.L$7 = list;
                                                        vastParserKt$parseInLineTag$1.L$8 = arrayList5;
                                                        vastParserKt$parseInLineTag$1.L$9 = xmlPullParser2;
                                                        vastParserKt$parseInLineTag$1.L$10 = arrayList5;
                                                        vastParserKt$parseInLineTag$1.I$0 = depth;
                                                        vastParserKt$parseInLineTag$1.label = 9;
                                                        Object parseExtensionsTag = parseExtensionsTag(xmlPullParser2, vastParserKt$parseInLineTag$1);
                                                        if (parseExtensionsTag != coroutine_suspended) {
                                                            xmlPullParser3 = xmlPullParser2;
                                                            obj3 = parseExtensionsTag;
                                                            r6 = arrayList5;
                                                            arrayList7 = arrayList5;
                                                            list = list;
                                                            r9 = r9;
                                                            arrayList7.addAll((Collection) obj3);
                                                            xmlPullParser2 = xmlPullParser3;
                                                            arrayList6 = r6;
                                                            list6 = list;
                                                            list5 = r9;
                                                            break;
                                                        }
                                                        return coroutine_suspended;
                                                    }
                                                    break;
                                                case 501930965:
                                                    arrayList6 = arrayList5;
                                                    list6 = list;
                                                    list5 = r9;
                                                    if (name.equals("AdTitle")) {
                                                        vastParserKt$parseInLineTag$1.L$0 = objectRef6;
                                                        vastParserKt$parseInLineTag$1.L$1 = objectRef7;
                                                        vastParserKt$parseInLineTag$1.L$2 = objectRef8;
                                                        vastParserKt$parseInLineTag$1.L$3 = objectRef9;
                                                        vastParserKt$parseInLineTag$1.L$4 = objectRef10;
                                                        vastParserKt$parseInLineTag$1.L$5 = r9;
                                                        vastParserKt$parseInLineTag$1.L$6 = arrayList;
                                                        vastParserKt$parseInLineTag$1.L$7 = list;
                                                        vastParserKt$parseInLineTag$1.L$8 = arrayList5;
                                                        vastParserKt$parseInLineTag$1.L$9 = xmlPullParser2;
                                                        vastParserKt$parseInLineTag$1.L$10 = objectRef7;
                                                        vastParserKt$parseInLineTag$1.I$0 = depth;
                                                        vastParserKt$parseInLineTag$1.label = 2;
                                                        ?? parseTagsTextOnly2 = parseTagsTextOnly(xmlPullParser2, vastParserKt$parseInLineTag$1);
                                                        if (parseTagsTextOnly2 != coroutine_suspended) {
                                                            xmlPullParser3 = xmlPullParser2;
                                                            r6 = arrayList5;
                                                            objectRef7.element = parseTagsTextOnly2;
                                                            xmlPullParser2 = xmlPullParser3;
                                                            arrayList6 = r6;
                                                            list6 = list;
                                                            list5 = r9;
                                                            break;
                                                        }
                                                        return coroutine_suspended;
                                                    }
                                                    break;
                                                case 1349597094:
                                                    arrayList6 = arrayList5;
                                                    list6 = list;
                                                    list5 = r9;
                                                    if (name.equals("Pricing")) {
                                                        vastParserKt$parseInLineTag$1.L$0 = objectRef6;
                                                        vastParserKt$parseInLineTag$1.L$1 = objectRef7;
                                                        vastParserKt$parseInLineTag$1.L$2 = objectRef8;
                                                        vastParserKt$parseInLineTag$1.L$3 = objectRef9;
                                                        vastParserKt$parseInLineTag$1.L$4 = objectRef10;
                                                        vastParserKt$parseInLineTag$1.L$5 = r9;
                                                        vastParserKt$parseInLineTag$1.L$6 = arrayList;
                                                        vastParserKt$parseInLineTag$1.L$7 = list;
                                                        vastParserKt$parseInLineTag$1.L$8 = arrayList5;
                                                        vastParserKt$parseInLineTag$1.L$9 = xmlPullParser2;
                                                        vastParserKt$parseInLineTag$1.L$10 = objectRef10;
                                                        vastParserKt$parseInLineTag$1.I$0 = depth;
                                                        vastParserKt$parseInLineTag$1.label = 5;
                                                        ?? parsePricingTag = parsePricingTag(xmlPullParser2, vastParserKt$parseInLineTag$1);
                                                        if (parsePricingTag != coroutine_suspended) {
                                                            xmlPullParser3 = xmlPullParser2;
                                                            r6 = arrayList5;
                                                            objectRef10.element = parsePricingTag;
                                                            xmlPullParser2 = xmlPullParser3;
                                                            arrayList6 = r6;
                                                            list6 = list;
                                                            list5 = r9;
                                                            break;
                                                        }
                                                        return coroutine_suspended;
                                                    }
                                                    break;
                                                case 2065545547:
                                                    arrayList6 = arrayList5;
                                                    list6 = list;
                                                    list5 = r9;
                                                    if (name.equals("Advertiser")) {
                                                        vastParserKt$parseInLineTag$1.L$0 = objectRef6;
                                                        vastParserKt$parseInLineTag$1.L$1 = objectRef7;
                                                        vastParserKt$parseInLineTag$1.L$2 = objectRef8;
                                                        vastParserKt$parseInLineTag$1.L$3 = objectRef9;
                                                        vastParserKt$parseInLineTag$1.L$4 = objectRef10;
                                                        vastParserKt$parseInLineTag$1.L$5 = r9;
                                                        vastParserKt$parseInLineTag$1.L$6 = arrayList;
                                                        vastParserKt$parseInLineTag$1.L$7 = list;
                                                        vastParserKt$parseInLineTag$1.L$8 = arrayList5;
                                                        vastParserKt$parseInLineTag$1.L$9 = xmlPullParser2;
                                                        vastParserKt$parseInLineTag$1.L$10 = objectRef9;
                                                        vastParserKt$parseInLineTag$1.I$0 = depth;
                                                        vastParserKt$parseInLineTag$1.label = 4;
                                                        ?? parseTagsTextOnly3 = parseTagsTextOnly(xmlPullParser2, vastParserKt$parseInLineTag$1);
                                                        if (parseTagsTextOnly3 != coroutine_suspended) {
                                                            xmlPullParser3 = xmlPullParser2;
                                                            r6 = arrayList5;
                                                            objectRef9.element = parseTagsTextOnly3;
                                                            xmlPullParser2 = xmlPullParser3;
                                                            arrayList6 = r6;
                                                            list6 = list;
                                                            list5 = r9;
                                                            break;
                                                        }
                                                        return coroutine_suspended;
                                                    }
                                                    break;
                                                case 2114088489:
                                                    arrayList6 = arrayList5;
                                                    list6 = list;
                                                    list5 = r9;
                                                    if (name.equals("Impression")) {
                                                        vastParserKt$parseInLineTag$1.L$0 = objectRef6;
                                                        vastParserKt$parseInLineTag$1.L$1 = objectRef7;
                                                        vastParserKt$parseInLineTag$1.L$2 = objectRef8;
                                                        vastParserKt$parseInLineTag$1.L$3 = objectRef9;
                                                        vastParserKt$parseInLineTag$1.L$4 = objectRef10;
                                                        vastParserKt$parseInLineTag$1.L$5 = r9;
                                                        vastParserKt$parseInLineTag$1.L$6 = arrayList;
                                                        vastParserKt$parseInLineTag$1.L$7 = list;
                                                        vastParserKt$parseInLineTag$1.L$8 = arrayList5;
                                                        vastParserKt$parseInLineTag$1.L$9 = xmlPullParser2;
                                                        vastParserKt$parseInLineTag$1.L$10 = null;
                                                        vastParserKt$parseInLineTag$1.I$0 = depth;
                                                        vastParserKt$parseInLineTag$1.label = 6;
                                                        Object parseImpressionTag = parseImpressionTag(xmlPullParser2, vastParserKt$parseInLineTag$1);
                                                        if (parseImpressionTag != coroutine_suspended) {
                                                            ArrayList arrayList12 = arrayList5;
                                                            xmlPullParser4 = xmlPullParser2;
                                                            obj2 = parseImpressionTag;
                                                            r5 = arrayList12;
                                                            list2 = list;
                                                            list3 = arrayList;
                                                            list4 = r9;
                                                            objectRef11 = objectRef10;
                                                            objectRef12 = objectRef9;
                                                            objectRef13 = objectRef8;
                                                            objectRef14 = objectRef7;
                                                            objectRef15 = objectRef6;
                                                            vastImpressionDto = (VastImpressionDto) obj2;
                                                            if (vastImpressionDto != null) {
                                                                list4.add(vastImpressionDto);
                                                            }
                                                            xmlPullParser2 = xmlPullParser4;
                                                            arrayList6 = r5;
                                                            objectRef6 = objectRef15;
                                                            objectRef7 = objectRef14;
                                                            objectRef8 = objectRef13;
                                                            objectRef9 = objectRef12;
                                                            objectRef10 = objectRef11;
                                                            list5 = list4;
                                                            arrayList = list3;
                                                            list6 = list2;
                                                            break;
                                                        }
                                                        return coroutine_suspended;
                                                    }
                                                    break;
                                            }
                                        }
                                    }
                                }
                            } else if (isStartTag(xmlPullParser2)) {
                                arrayList6 = arrayList5;
                                list6 = list;
                                list5 = r9;
                            } else if (!isText(xmlPullParser2) || (text = xmlPullParser2.getText()) == null || StringsKt.isBlank(text)) {
                                arrayList6 = arrayList5;
                                list6 = list;
                                list5 = r9;
                                break;
                            } else {
                                String text2 = xmlPullParser2.getText();
                                Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                                StringsKt.trim((CharSequence) text2).toString();
                                arrayList6 = arrayList5;
                                list6 = list;
                                list5 = r9;
                            }
                            xmlPullParser2.next();
                            arrayList5 = arrayList6;
                            list = list6;
                            r9 = list5;
                            if (xmlPullParser2.getDepth() >= depth) {
                            }
                        }
                        arrayList4 = arrayList5;
                        arrayList3 = list;
                        objectRef5 = objectRef10;
                        objectRef4 = objectRef9;
                        objectRef3 = objectRef8;
                        objectRef2 = objectRef7;
                        objectRef = objectRef6;
                        arrayList2 = r9;
                        return new VastInLineDto((VastAdSystemDto) objectRef.element, (String) objectRef2.element, (String) objectRef3.element, (String) objectRef4.element, (VastPricingDto) objectRef5.element, arrayList2, arrayList, arrayList3, arrayList4);
                    case 1:
                        depth = vastParserKt$parseInLineTag$1.I$0;
                        Ref.ObjectRef objectRef16 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$10;
                        xmlPullParser3 = (XmlPullParser) vastParserKt$parseInLineTag$1.L$9;
                        r6 = (List) vastParserKt$parseInLineTag$1.L$8;
                        list = (List) vastParserKt$parseInLineTag$1.L$7;
                        arrayList = (List) vastParserKt$parseInLineTag$1.L$6;
                        r9 = (List) vastParserKt$parseInLineTag$1.L$5;
                        objectRef10 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$4;
                        objectRef9 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$3;
                        objectRef8 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$2;
                        objectRef7 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$1;
                        objectRef6 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$0;
                        ResultKt.throwOnFailure(r0);
                        objectRef16.element = r0;
                        xmlPullParser2 = xmlPullParser3;
                        arrayList6 = r6;
                        list6 = list;
                        list5 = r9;
                        xmlPullParser2.next();
                        arrayList5 = arrayList6;
                        list = list6;
                        r9 = list5;
                        if (xmlPullParser2.getDepth() >= depth) {
                        }
                        arrayList4 = arrayList5;
                        arrayList3 = list;
                        objectRef5 = objectRef10;
                        objectRef4 = objectRef9;
                        objectRef3 = objectRef8;
                        objectRef2 = objectRef7;
                        objectRef = objectRef6;
                        arrayList2 = r9;
                        return new VastInLineDto((VastAdSystemDto) objectRef.element, (String) objectRef2.element, (String) objectRef3.element, (String) objectRef4.element, (VastPricingDto) objectRef5.element, arrayList2, arrayList, arrayList3, arrayList4);
                    case 2:
                        depth = vastParserKt$parseInLineTag$1.I$0;
                        Ref.ObjectRef objectRef17 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$10;
                        xmlPullParser3 = (XmlPullParser) vastParserKt$parseInLineTag$1.L$9;
                        r6 = (List) vastParserKt$parseInLineTag$1.L$8;
                        list = (List) vastParserKt$parseInLineTag$1.L$7;
                        arrayList = (List) vastParserKt$parseInLineTag$1.L$6;
                        r9 = (List) vastParserKt$parseInLineTag$1.L$5;
                        objectRef10 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$4;
                        objectRef9 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$3;
                        objectRef8 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$2;
                        objectRef7 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$1;
                        objectRef6 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$0;
                        ResultKt.throwOnFailure(r0);
                        objectRef17.element = r0;
                        xmlPullParser2 = xmlPullParser3;
                        arrayList6 = r6;
                        list6 = list;
                        list5 = r9;
                        xmlPullParser2.next();
                        arrayList5 = arrayList6;
                        list = list6;
                        r9 = list5;
                        if (xmlPullParser2.getDepth() >= depth) {
                        }
                        arrayList4 = arrayList5;
                        arrayList3 = list;
                        objectRef5 = objectRef10;
                        objectRef4 = objectRef9;
                        objectRef3 = objectRef8;
                        objectRef2 = objectRef7;
                        objectRef = objectRef6;
                        arrayList2 = r9;
                        return new VastInLineDto((VastAdSystemDto) objectRef.element, (String) objectRef2.element, (String) objectRef3.element, (String) objectRef4.element, (VastPricingDto) objectRef5.element, arrayList2, arrayList, arrayList3, arrayList4);
                    case 3:
                        depth = vastParserKt$parseInLineTag$1.I$0;
                        Ref.ObjectRef objectRef18 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$10;
                        xmlPullParser3 = (XmlPullParser) vastParserKt$parseInLineTag$1.L$9;
                        r6 = (List) vastParserKt$parseInLineTag$1.L$8;
                        list = (List) vastParserKt$parseInLineTag$1.L$7;
                        arrayList = (List) vastParserKt$parseInLineTag$1.L$6;
                        r9 = (List) vastParserKt$parseInLineTag$1.L$5;
                        objectRef10 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$4;
                        objectRef9 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$3;
                        objectRef8 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$2;
                        objectRef7 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$1;
                        objectRef6 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$0;
                        ResultKt.throwOnFailure(r0);
                        objectRef18.element = r0;
                        xmlPullParser2 = xmlPullParser3;
                        arrayList6 = r6;
                        list6 = list;
                        list5 = r9;
                        xmlPullParser2.next();
                        arrayList5 = arrayList6;
                        list = list6;
                        r9 = list5;
                        if (xmlPullParser2.getDepth() >= depth) {
                        }
                        arrayList4 = arrayList5;
                        arrayList3 = list;
                        objectRef5 = objectRef10;
                        objectRef4 = objectRef9;
                        objectRef3 = objectRef8;
                        objectRef2 = objectRef7;
                        objectRef = objectRef6;
                        arrayList2 = r9;
                        return new VastInLineDto((VastAdSystemDto) objectRef.element, (String) objectRef2.element, (String) objectRef3.element, (String) objectRef4.element, (VastPricingDto) objectRef5.element, arrayList2, arrayList, arrayList3, arrayList4);
                    case 4:
                        depth = vastParserKt$parseInLineTag$1.I$0;
                        Ref.ObjectRef objectRef19 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$10;
                        xmlPullParser3 = (XmlPullParser) vastParserKt$parseInLineTag$1.L$9;
                        r6 = (List) vastParserKt$parseInLineTag$1.L$8;
                        list = (List) vastParserKt$parseInLineTag$1.L$7;
                        arrayList = (List) vastParserKt$parseInLineTag$1.L$6;
                        r9 = (List) vastParserKt$parseInLineTag$1.L$5;
                        objectRef10 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$4;
                        objectRef9 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$3;
                        objectRef8 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$2;
                        objectRef7 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$1;
                        objectRef6 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$0;
                        ResultKt.throwOnFailure(r0);
                        objectRef19.element = r0;
                        xmlPullParser2 = xmlPullParser3;
                        arrayList6 = r6;
                        list6 = list;
                        list5 = r9;
                        xmlPullParser2.next();
                        arrayList5 = arrayList6;
                        list = list6;
                        r9 = list5;
                        if (xmlPullParser2.getDepth() >= depth) {
                        }
                        arrayList4 = arrayList5;
                        arrayList3 = list;
                        objectRef5 = objectRef10;
                        objectRef4 = objectRef9;
                        objectRef3 = objectRef8;
                        objectRef2 = objectRef7;
                        objectRef = objectRef6;
                        arrayList2 = r9;
                        return new VastInLineDto((VastAdSystemDto) objectRef.element, (String) objectRef2.element, (String) objectRef3.element, (String) objectRef4.element, (VastPricingDto) objectRef5.element, arrayList2, arrayList, arrayList3, arrayList4);
                    case 5:
                        depth = vastParserKt$parseInLineTag$1.I$0;
                        Ref.ObjectRef objectRef20 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$10;
                        xmlPullParser3 = (XmlPullParser) vastParserKt$parseInLineTag$1.L$9;
                        r6 = (List) vastParserKt$parseInLineTag$1.L$8;
                        list = (List) vastParserKt$parseInLineTag$1.L$7;
                        arrayList = (List) vastParserKt$parseInLineTag$1.L$6;
                        r9 = (List) vastParserKt$parseInLineTag$1.L$5;
                        objectRef10 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$4;
                        objectRef9 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$3;
                        objectRef8 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$2;
                        objectRef7 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$1;
                        objectRef6 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$0;
                        ResultKt.throwOnFailure(r0);
                        objectRef20.element = r0;
                        xmlPullParser2 = xmlPullParser3;
                        arrayList6 = r6;
                        list6 = list;
                        list5 = r9;
                        xmlPullParser2.next();
                        arrayList5 = arrayList6;
                        list = list6;
                        r9 = list5;
                        if (xmlPullParser2.getDepth() >= depth) {
                        }
                        arrayList4 = arrayList5;
                        arrayList3 = list;
                        objectRef5 = objectRef10;
                        objectRef4 = objectRef9;
                        objectRef3 = objectRef8;
                        objectRef2 = objectRef7;
                        objectRef = objectRef6;
                        arrayList2 = r9;
                        return new VastInLineDto((VastAdSystemDto) objectRef.element, (String) objectRef2.element, (String) objectRef3.element, (String) objectRef4.element, (VastPricingDto) objectRef5.element, arrayList2, arrayList, arrayList3, arrayList4);
                    case 6:
                        depth = vastParserKt$parseInLineTag$1.I$0;
                        xmlPullParser4 = (XmlPullParser) vastParserKt$parseInLineTag$1.L$9;
                        r5 = (List) vastParserKt$parseInLineTag$1.L$8;
                        list2 = (List) vastParserKt$parseInLineTag$1.L$7;
                        list3 = (List) vastParserKt$parseInLineTag$1.L$6;
                        list4 = (List) vastParserKt$parseInLineTag$1.L$5;
                        objectRef11 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$4;
                        objectRef12 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$3;
                        objectRef13 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$2;
                        objectRef14 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$1;
                        objectRef15 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$0;
                        ResultKt.throwOnFailure(r0);
                        obj2 = r0;
                        vastImpressionDto = (VastImpressionDto) obj2;
                        if (vastImpressionDto != null) {
                        }
                        xmlPullParser2 = xmlPullParser4;
                        arrayList6 = r5;
                        objectRef6 = objectRef15;
                        objectRef7 = objectRef14;
                        objectRef8 = objectRef13;
                        objectRef9 = objectRef12;
                        objectRef10 = objectRef11;
                        list5 = list4;
                        arrayList = list3;
                        list6 = list2;
                        xmlPullParser2.next();
                        arrayList5 = arrayList6;
                        list = list6;
                        r9 = list5;
                        if (xmlPullParser2.getDepth() >= depth) {
                        }
                        arrayList4 = arrayList5;
                        arrayList3 = list;
                        objectRef5 = objectRef10;
                        objectRef4 = objectRef9;
                        objectRef3 = objectRef8;
                        objectRef2 = objectRef7;
                        objectRef = objectRef6;
                        arrayList2 = r9;
                        return new VastInLineDto((VastAdSystemDto) objectRef.element, (String) objectRef2.element, (String) objectRef3.element, (String) objectRef4.element, (VastPricingDto) objectRef5.element, arrayList2, arrayList, arrayList3, arrayList4);
                    case 7:
                        depth = vastParserKt$parseInLineTag$1.I$0;
                        xmlPullParser4 = (XmlPullParser) vastParserKt$parseInLineTag$1.L$9;
                        r5 = (List) vastParserKt$parseInLineTag$1.L$8;
                        list2 = (List) vastParserKt$parseInLineTag$1.L$7;
                        list3 = (List) vastParserKt$parseInLineTag$1.L$6;
                        list4 = (List) vastParserKt$parseInLineTag$1.L$5;
                        objectRef11 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$4;
                        objectRef12 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$3;
                        objectRef13 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$2;
                        objectRef14 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$1;
                        objectRef15 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$0;
                        ResultKt.throwOnFailure(r0);
                        obj = r0;
                        str = (String) obj;
                        if (str != null) {
                        }
                        xmlPullParser2 = xmlPullParser4;
                        arrayList6 = r5;
                        objectRef6 = objectRef15;
                        objectRef7 = objectRef14;
                        objectRef8 = objectRef13;
                        objectRef9 = objectRef12;
                        objectRef10 = objectRef11;
                        list5 = list4;
                        arrayList = list3;
                        list6 = list2;
                        xmlPullParser2.next();
                        arrayList5 = arrayList6;
                        list = list6;
                        r9 = list5;
                        if (xmlPullParser2.getDepth() >= depth) {
                        }
                        arrayList4 = arrayList5;
                        arrayList3 = list;
                        objectRef5 = objectRef10;
                        objectRef4 = objectRef9;
                        objectRef3 = objectRef8;
                        objectRef2 = objectRef7;
                        objectRef = objectRef6;
                        arrayList2 = r9;
                        return new VastInLineDto((VastAdSystemDto) objectRef.element, (String) objectRef2.element, (String) objectRef3.element, (String) objectRef4.element, (VastPricingDto) objectRef5.element, arrayList2, arrayList, arrayList3, arrayList4);
                    case 8:
                        depth = vastParserKt$parseInLineTag$1.I$0;
                        List list7 = (List) vastParserKt$parseInLineTag$1.L$10;
                        xmlPullParser3 = (XmlPullParser) vastParserKt$parseInLineTag$1.L$9;
                        r6 = (List) vastParserKt$parseInLineTag$1.L$8;
                        list = (List) vastParserKt$parseInLineTag$1.L$7;
                        arrayList = (List) vastParserKt$parseInLineTag$1.L$6;
                        r9 = (List) vastParserKt$parseInLineTag$1.L$5;
                        objectRef10 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$4;
                        objectRef9 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$3;
                        objectRef8 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$2;
                        objectRef7 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$1;
                        objectRef6 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$0;
                        ResultKt.throwOnFailure(r0);
                        list7.addAll((Collection) r0);
                        xmlPullParser2 = xmlPullParser3;
                        arrayList6 = r6;
                        list6 = list;
                        list5 = r9;
                        xmlPullParser2.next();
                        arrayList5 = arrayList6;
                        list = list6;
                        r9 = list5;
                        if (xmlPullParser2.getDepth() >= depth) {
                        }
                        arrayList4 = arrayList5;
                        arrayList3 = list;
                        objectRef5 = objectRef10;
                        objectRef4 = objectRef9;
                        objectRef3 = objectRef8;
                        objectRef2 = objectRef7;
                        objectRef = objectRef6;
                        arrayList2 = r9;
                        return new VastInLineDto((VastAdSystemDto) objectRef.element, (String) objectRef2.element, (String) objectRef3.element, (String) objectRef4.element, (VastPricingDto) objectRef5.element, arrayList2, arrayList, arrayList3, arrayList4);
                    case 9:
                        depth = vastParserKt$parseInLineTag$1.I$0;
                        ?? r4 = (List) vastParserKt$parseInLineTag$1.L$10;
                        xmlPullParser3 = (XmlPullParser) vastParserKt$parseInLineTag$1.L$9;
                        r6 = (List) vastParserKt$parseInLineTag$1.L$8;
                        List list8 = (List) vastParserKt$parseInLineTag$1.L$7;
                        arrayList = (List) vastParserKt$parseInLineTag$1.L$6;
                        List list9 = (List) vastParserKt$parseInLineTag$1.L$5;
                        objectRef10 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$4;
                        objectRef9 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$3;
                        objectRef8 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$2;
                        objectRef7 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$1;
                        objectRef6 = (Ref.ObjectRef) vastParserKt$parseInLineTag$1.L$0;
                        ResultKt.throwOnFailure(r0);
                        obj3 = r0;
                        arrayList7 = r4;
                        list = list8;
                        r9 = list9;
                        arrayList7.addAll((Collection) obj3);
                        xmlPullParser2 = xmlPullParser3;
                        arrayList6 = r6;
                        list6 = list;
                        list5 = r9;
                        xmlPullParser2.next();
                        arrayList5 = arrayList6;
                        list = list6;
                        r9 = list5;
                        if (xmlPullParser2.getDepth() >= depth) {
                        }
                        arrayList4 = arrayList5;
                        arrayList3 = list;
                        objectRef5 = objectRef10;
                        objectRef4 = objectRef9;
                        objectRef3 = objectRef8;
                        objectRef2 = objectRef7;
                        objectRef = objectRef6;
                        arrayList2 = r9;
                        return new VastInLineDto((VastAdSystemDto) objectRef.element, (String) objectRef2.element, (String) objectRef3.element, (String) objectRef4.element, (VastPricingDto) objectRef5.element, arrayList2, arrayList, arrayList3, arrayList4);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        vastParserKt$parseInLineTag$1 = new VastParserKt$parseInLineTag$1(continuation);
        ?? r02 = vastParserKt$parseInLineTag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (vastParserKt$parseInLineTag$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02de, code lost:
    
        if (isEndTag(r0) != false) goto L110;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0310 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0100  */
    /* JADX WARN: Type inference failed for: r0v10, types: [T] */
    /* JADX WARN: Type inference failed for: r0v12, types: [T] */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v22, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v27, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v29, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v24, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v26, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v29, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v31, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v33, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r13v22, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r13v29, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v21, types: [T, java.lang.Boolean] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x027e -> B:14:0x0283). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x028d -> B:15:0x02e1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x02c4 -> B:15:0x02e1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x02de -> B:15:0x02e1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object parseWrapperTag(XmlPullParser xmlPullParser, Continuation<? super VastWrapperDto> continuation) {
        VastParserKt$parseWrapperTag$1 vastParserKt$parseWrapperTag$1;
        int i;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        ArrayList arrayList4;
        int depth;
        Ref.ObjectRef objectRef6;
        ArrayList arrayList5;
        XmlPullParser xmlPullParser2;
        String str;
        Ref.ObjectRef objectRef7;
        Ref.ObjectRef objectRef8;
        ArrayList arrayList6;
        ArrayList arrayList7;
        List list;
        XmlPullParser xmlPullParser3;
        Ref.ObjectRef objectRef9;
        Ref.ObjectRef objectRef10;
        ?? r0;
        Ref.ObjectRef objectRef11;
        Ref.ObjectRef objectRef12;
        Ref.ObjectRef objectRef13;
        ?? r12;
        ?? r11;
        List list2;
        XmlPullParser xmlPullParser4;
        ?? r02;
        XmlPullParser xmlPullParser5;
        Object obj;
        String str2;
        Object obj2;
        VastImpressionDto vastImpressionDto;
        String text;
        if (continuation instanceof VastParserKt$parseWrapperTag$1) {
            vastParserKt$parseWrapperTag$1 = (VastParserKt$parseWrapperTag$1) continuation;
            if ((vastParserKt$parseWrapperTag$1.label & Integer.MIN_VALUE) != 0) {
                vastParserKt$parseWrapperTag$1.label -= Integer.MIN_VALUE;
                Object obj3 = vastParserKt$parseWrapperTag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = vastParserKt$parseWrapperTag$1.label;
                int i2 = 4;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    objectRef = new Ref.ObjectRef();
                    objectRef2 = new Ref.ObjectRef();
                    objectRef3 = new Ref.ObjectRef();
                    ArrayList arrayList8 = new ArrayList();
                    ArrayList arrayList9 = new ArrayList();
                    arrayList = new ArrayList();
                    if (isStartDocument(xmlPullParser)) {
                        xmlPullParser.nextTag();
                    }
                    if (isEndDocument(xmlPullParser)) {
                        arrayList2 = arrayList8;
                        arrayList3 = arrayList9;
                        List list3 = arrayList;
                        str = (String) objectRef.element;
                        if (str != null) {
                        }
                    } else {
                        if (!isStartTag(xmlPullParser)) {
                            throw new XmlPullParserException("allowed only for START_TAG");
                        }
                        objectRef4 = objectRef2;
                        objectRef5 = objectRef3;
                        arrayList4 = arrayList8;
                        depth = xmlPullParser.getDepth();
                        objectRef6 = objectRef;
                        arrayList5 = arrayList9;
                        xmlPullParser2 = xmlPullParser;
                        if (xmlPullParser2.getDepth() >= depth) {
                        }
                        objectRef = objectRef6;
                        objectRef3 = objectRef5;
                        objectRef2 = objectRef4;
                        arrayList3 = arrayList5;
                        arrayList2 = arrayList4;
                        List list32 = arrayList;
                        str = (String) objectRef.element;
                        if (str != null) {
                        }
                    }
                } else if (i == 1) {
                    depth = vastParserKt$parseWrapperTag$1.I$0;
                    objectRef6 = (Ref.ObjectRef) vastParserKt$parseWrapperTag$1.L$7;
                    xmlPullParser4 = (XmlPullParser) vastParserKt$parseWrapperTag$1.L$6;
                    list2 = (List) vastParserKt$parseWrapperTag$1.L$5;
                    r11 = (List) vastParserKt$parseWrapperTag$1.L$4;
                    r12 = (List) vastParserKt$parseWrapperTag$1.L$3;
                    objectRef13 = (Ref.ObjectRef) vastParserKt$parseWrapperTag$1.L$2;
                    objectRef12 = (Ref.ObjectRef) vastParserKt$parseWrapperTag$1.L$1;
                    objectRef11 = (Ref.ObjectRef) vastParserKt$parseWrapperTag$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    r02 = obj3;
                    objectRef6.element = r02;
                    xmlPullParser2 = xmlPullParser4;
                    objectRef6 = objectRef11;
                    objectRef4 = objectRef12;
                    objectRef5 = objectRef13;
                    arrayList4 = r12;
                    arrayList5 = r11;
                    arrayList = list2;
                    xmlPullParser2.next();
                    i2 = 4;
                    arrayList5 = arrayList5;
                    arrayList4 = arrayList4;
                    if (xmlPullParser2.getDepth() >= depth) {
                    }
                    objectRef = objectRef6;
                    objectRef3 = objectRef5;
                    objectRef2 = objectRef4;
                    arrayList3 = arrayList5;
                    arrayList2 = arrayList4;
                    List list322 = arrayList;
                    str = (String) objectRef.element;
                    if (str != null) {
                    }
                } else if (i == 2) {
                    depth = vastParserKt$parseWrapperTag$1.I$0;
                    objectRef10 = (Ref.ObjectRef) vastParserKt$parseWrapperTag$1.L$7;
                    XmlPullParser xmlPullParser6 = (XmlPullParser) vastParserKt$parseWrapperTag$1.L$6;
                    List list4 = (List) vastParserKt$parseWrapperTag$1.L$5;
                    ?? r122 = (List) vastParserKt$parseWrapperTag$1.L$4;
                    ?? r13 = (List) vastParserKt$parseWrapperTag$1.L$3;
                    Ref.ObjectRef objectRef14 = (Ref.ObjectRef) vastParserKt$parseWrapperTag$1.L$2;
                    Ref.ObjectRef objectRef15 = (Ref.ObjectRef) vastParserKt$parseWrapperTag$1.L$1;
                    objectRef9 = (Ref.ObjectRef) vastParserKt$parseWrapperTag$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    objectRef7 = objectRef15;
                    objectRef8 = objectRef14;
                    arrayList6 = r13;
                    arrayList7 = r122;
                    list = list4;
                    xmlPullParser3 = xmlPullParser6;
                    r0 = obj3;
                    objectRef10.element = r0;
                    objectRef6 = objectRef9;
                    xmlPullParser2 = xmlPullParser3;
                    arrayList = list;
                    arrayList5 = arrayList7;
                    arrayList4 = arrayList6;
                    objectRef5 = objectRef8;
                    objectRef4 = objectRef7;
                    xmlPullParser2.next();
                    i2 = 4;
                    arrayList5 = arrayList5;
                    arrayList4 = arrayList4;
                    if (xmlPullParser2.getDepth() >= depth) {
                    }
                    objectRef = objectRef6;
                    objectRef3 = objectRef5;
                    objectRef2 = objectRef4;
                    arrayList3 = arrayList5;
                    arrayList2 = arrayList4;
                    List list3222 = arrayList;
                    str = (String) objectRef.element;
                    if (str != null) {
                    }
                } else if (i == 3) {
                    depth = vastParserKt$parseWrapperTag$1.I$0;
                    xmlPullParser5 = (XmlPullParser) vastParserKt$parseWrapperTag$1.L$6;
                    list2 = (List) vastParserKt$parseWrapperTag$1.L$5;
                    r11 = (List) vastParserKt$parseWrapperTag$1.L$4;
                    r12 = (List) vastParserKt$parseWrapperTag$1.L$3;
                    objectRef13 = (Ref.ObjectRef) vastParserKt$parseWrapperTag$1.L$2;
                    objectRef12 = (Ref.ObjectRef) vastParserKt$parseWrapperTag$1.L$1;
                    objectRef11 = (Ref.ObjectRef) vastParserKt$parseWrapperTag$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    obj2 = obj3;
                    vastImpressionDto = (VastImpressionDto) obj2;
                    if (vastImpressionDto != null) {
                    }
                    xmlPullParser2 = xmlPullParser5;
                    objectRef6 = objectRef11;
                    objectRef4 = objectRef12;
                    objectRef5 = objectRef13;
                    arrayList4 = r12;
                    arrayList5 = r11;
                    arrayList = list2;
                    xmlPullParser2.next();
                    i2 = 4;
                    arrayList5 = arrayList5;
                    arrayList4 = arrayList4;
                    if (xmlPullParser2.getDepth() >= depth) {
                    }
                    objectRef = objectRef6;
                    objectRef3 = objectRef5;
                    objectRef2 = objectRef4;
                    arrayList3 = arrayList5;
                    arrayList2 = arrayList4;
                    List list32222 = arrayList;
                    str = (String) objectRef.element;
                    if (str != null) {
                    }
                } else {
                    if (i != 4) {
                        if (i != 5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        depth = vastParserKt$parseWrapperTag$1.I$0;
                        XmlPullParser xmlPullParser7 = (XmlPullParser) vastParserKt$parseWrapperTag$1.L$6;
                        arrayList = (List) vastParserKt$parseWrapperTag$1.L$5;
                        ?? r123 = (List) vastParserKt$parseWrapperTag$1.L$4;
                        ?? r132 = (List) vastParserKt$parseWrapperTag$1.L$3;
                        objectRef5 = (Ref.ObjectRef) vastParserKt$parseWrapperTag$1.L$2;
                        objectRef4 = (Ref.ObjectRef) vastParserKt$parseWrapperTag$1.L$1;
                        objectRef6 = (Ref.ObjectRef) vastParserKt$parseWrapperTag$1.L$0;
                        ResultKt.throwOnFailure(obj3);
                        XmlPullParser xmlPullParser8 = xmlPullParser7;
                        Object obj4 = obj3;
                        arrayList5 = r123;
                        arrayList4 = r132;
                        arrayList.addAll((List) obj4);
                        xmlPullParser2 = xmlPullParser8;
                        xmlPullParser2.next();
                        i2 = 4;
                        arrayList5 = arrayList5;
                        arrayList4 = arrayList4;
                        if (xmlPullParser2.getDepth() >= depth) {
                            int depth2 = xmlPullParser2.getDepth() - depth;
                            arrayList5 = arrayList5;
                            arrayList4 = arrayList4;
                            if (depth2 == 0) {
                                if (isStartTag(xmlPullParser2)) {
                                    String attribute = attribute(xmlPullParser2, VastAttributes.FOLLOW_ADDITIONAL_WRAPPERS);
                                    if (attribute != null) {
                                        objectRef4.element = Boxing.boxBoolean(Boolean.parseBoolean(attribute));
                                    } else {
                                        objectRef4.element = null;
                                    }
                                } else if (isText(xmlPullParser2) && (text = xmlPullParser2.getText()) != null && !StringsKt.isBlank(text)) {
                                    String text2 = xmlPullParser2.getText();
                                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                                    StringsKt.trim((CharSequence) text2).toString();
                                }
                            } else if (depth2 == 1) {
                                arrayList5 = arrayList5;
                                arrayList4 = arrayList4;
                                if (isStartTag(xmlPullParser2)) {
                                    String name = xmlPullParser2.getName();
                                    if (name != null) {
                                        switch (name.hashCode()) {
                                            case -1692490108:
                                                if (name.equals("Creatives")) {
                                                    vastParserKt$parseWrapperTag$1.L$0 = objectRef6;
                                                    vastParserKt$parseWrapperTag$1.L$1 = objectRef4;
                                                    vastParserKt$parseWrapperTag$1.L$2 = objectRef5;
                                                    vastParserKt$parseWrapperTag$1.L$3 = arrayList4;
                                                    vastParserKt$parseWrapperTag$1.L$4 = arrayList5;
                                                    vastParserKt$parseWrapperTag$1.L$5 = arrayList;
                                                    vastParserKt$parseWrapperTag$1.L$6 = xmlPullParser2;
                                                    vastParserKt$parseWrapperTag$1.L$7 = null;
                                                    vastParserKt$parseWrapperTag$1.I$0 = depth;
                                                    vastParserKt$parseWrapperTag$1.label = 5;
                                                    Object parseCreativesTag = parseCreativesTag(xmlPullParser2, false, vastParserKt$parseWrapperTag$1);
                                                    if (parseCreativesTag != coroutine_suspended) {
                                                        xmlPullParser8 = xmlPullParser2;
                                                        obj4 = parseCreativesTag;
                                                        arrayList5 = arrayList5;
                                                        arrayList4 = arrayList4;
                                                        arrayList.addAll((List) obj4);
                                                        xmlPullParser2 = xmlPullParser8;
                                                        break;
                                                    }
                                                    return coroutine_suspended;
                                                }
                                                break;
                                            case -1633884078:
                                                if (name.equals("AdSystem")) {
                                                    vastParserKt$parseWrapperTag$1.L$0 = objectRef6;
                                                    vastParserKt$parseWrapperTag$1.L$1 = objectRef4;
                                                    vastParserKt$parseWrapperTag$1.L$2 = objectRef5;
                                                    vastParserKt$parseWrapperTag$1.L$3 = arrayList4;
                                                    vastParserKt$parseWrapperTag$1.L$4 = arrayList5;
                                                    vastParserKt$parseWrapperTag$1.L$5 = arrayList;
                                                    vastParserKt$parseWrapperTag$1.L$6 = xmlPullParser2;
                                                    vastParserKt$parseWrapperTag$1.L$7 = objectRef5;
                                                    vastParserKt$parseWrapperTag$1.I$0 = depth;
                                                    vastParserKt$parseWrapperTag$1.label = 2;
                                                    Object parseAdSystemTag = parseAdSystemTag(xmlPullParser2, vastParserKt$parseWrapperTag$1);
                                                    if (parseAdSystemTag != coroutine_suspended) {
                                                        objectRef7 = objectRef4;
                                                        objectRef8 = objectRef5;
                                                        arrayList6 = arrayList4;
                                                        arrayList7 = arrayList5;
                                                        list = arrayList;
                                                        xmlPullParser3 = xmlPullParser2;
                                                        r0 = parseAdSystemTag;
                                                        objectRef9 = objectRef6;
                                                        objectRef10 = objectRef8;
                                                        objectRef10.element = r0;
                                                        objectRef6 = objectRef9;
                                                        xmlPullParser2 = xmlPullParser3;
                                                        arrayList = list;
                                                        arrayList5 = arrayList7;
                                                        arrayList4 = arrayList6;
                                                        objectRef5 = objectRef8;
                                                        objectRef4 = objectRef7;
                                                        break;
                                                    }
                                                    return coroutine_suspended;
                                                }
                                                break;
                                            case -587420703:
                                                if (name.equals("VASTAdTagURI")) {
                                                    vastParserKt$parseWrapperTag$1.L$0 = objectRef6;
                                                    vastParserKt$parseWrapperTag$1.L$1 = objectRef4;
                                                    vastParserKt$parseWrapperTag$1.L$2 = objectRef5;
                                                    vastParserKt$parseWrapperTag$1.L$3 = arrayList4;
                                                    vastParserKt$parseWrapperTag$1.L$4 = arrayList5;
                                                    vastParserKt$parseWrapperTag$1.L$5 = arrayList;
                                                    vastParserKt$parseWrapperTag$1.L$6 = xmlPullParser2;
                                                    vastParserKt$parseWrapperTag$1.L$7 = objectRef6;
                                                    vastParserKt$parseWrapperTag$1.I$0 = depth;
                                                    vastParserKt$parseWrapperTag$1.label = 1;
                                                    Object parseTagsTextOnly = parseTagsTextOnly(xmlPullParser2, vastParserKt$parseWrapperTag$1);
                                                    if (parseTagsTextOnly != coroutine_suspended) {
                                                        xmlPullParser4 = xmlPullParser2;
                                                        r02 = parseTagsTextOnly;
                                                        list2 = arrayList;
                                                        r11 = arrayList5;
                                                        r12 = arrayList4;
                                                        objectRef13 = objectRef5;
                                                        objectRef12 = objectRef4;
                                                        objectRef11 = objectRef6;
                                                        objectRef6.element = r02;
                                                        xmlPullParser2 = xmlPullParser4;
                                                        objectRef6 = objectRef11;
                                                        objectRef4 = objectRef12;
                                                        objectRef5 = objectRef13;
                                                        arrayList4 = r12;
                                                        arrayList5 = r11;
                                                        arrayList = list2;
                                                        break;
                                                    }
                                                    return coroutine_suspended;
                                                }
                                                break;
                                            case 67232232:
                                                if (name.equals("Error")) {
                                                    vastParserKt$parseWrapperTag$1.L$0 = objectRef6;
                                                    vastParserKt$parseWrapperTag$1.L$1 = objectRef4;
                                                    vastParserKt$parseWrapperTag$1.L$2 = objectRef5;
                                                    vastParserKt$parseWrapperTag$1.L$3 = arrayList4;
                                                    vastParserKt$parseWrapperTag$1.L$4 = arrayList5;
                                                    vastParserKt$parseWrapperTag$1.L$5 = arrayList;
                                                    vastParserKt$parseWrapperTag$1.L$6 = xmlPullParser2;
                                                    vastParserKt$parseWrapperTag$1.L$7 = null;
                                                    vastParserKt$parseWrapperTag$1.I$0 = depth;
                                                    vastParserKt$parseWrapperTag$1.label = i2;
                                                    Object parseErrorTag = parseErrorTag(xmlPullParser2, vastParserKt$parseWrapperTag$1);
                                                    if (parseErrorTag != coroutine_suspended) {
                                                        list2 = arrayList;
                                                        r11 = arrayList5;
                                                        r12 = arrayList4;
                                                        objectRef13 = objectRef5;
                                                        objectRef12 = objectRef4;
                                                        objectRef11 = objectRef6;
                                                        xmlPullParser5 = xmlPullParser2;
                                                        obj = parseErrorTag;
                                                        str2 = (String) obj;
                                                        if (str2 != null) {
                                                            r11.add(str2);
                                                        }
                                                        xmlPullParser2 = xmlPullParser5;
                                                        objectRef6 = objectRef11;
                                                        objectRef4 = objectRef12;
                                                        objectRef5 = objectRef13;
                                                        arrayList4 = r12;
                                                        arrayList5 = r11;
                                                        arrayList = list2;
                                                        break;
                                                    }
                                                    return coroutine_suspended;
                                                }
                                                break;
                                            case 2114088489:
                                                if (name.equals("Impression")) {
                                                    vastParserKt$parseWrapperTag$1.L$0 = objectRef6;
                                                    vastParserKt$parseWrapperTag$1.L$1 = objectRef4;
                                                    vastParserKt$parseWrapperTag$1.L$2 = objectRef5;
                                                    vastParserKt$parseWrapperTag$1.L$3 = arrayList4;
                                                    vastParserKt$parseWrapperTag$1.L$4 = arrayList5;
                                                    vastParserKt$parseWrapperTag$1.L$5 = arrayList;
                                                    vastParserKt$parseWrapperTag$1.L$6 = xmlPullParser2;
                                                    vastParserKt$parseWrapperTag$1.L$7 = null;
                                                    vastParserKt$parseWrapperTag$1.I$0 = depth;
                                                    vastParserKt$parseWrapperTag$1.label = 3;
                                                    Object parseImpressionTag = parseImpressionTag(xmlPullParser2, vastParserKt$parseWrapperTag$1);
                                                    if (parseImpressionTag != coroutine_suspended) {
                                                        list2 = arrayList;
                                                        r11 = arrayList5;
                                                        r12 = arrayList4;
                                                        objectRef13 = objectRef5;
                                                        objectRef12 = objectRef4;
                                                        objectRef11 = objectRef6;
                                                        xmlPullParser5 = xmlPullParser2;
                                                        obj2 = parseImpressionTag;
                                                        vastImpressionDto = (VastImpressionDto) obj2;
                                                        if (vastImpressionDto != null) {
                                                            r12.add(vastImpressionDto);
                                                        }
                                                        xmlPullParser2 = xmlPullParser5;
                                                        objectRef6 = objectRef11;
                                                        objectRef4 = objectRef12;
                                                        objectRef5 = objectRef13;
                                                        arrayList4 = r12;
                                                        arrayList5 = r11;
                                                        arrayList = list2;
                                                        break;
                                                    }
                                                    return coroutine_suspended;
                                                }
                                                break;
                                        }
                                    }
                                    arrayList5 = arrayList5;
                                    arrayList4 = arrayList4;
                                }
                            }
                            xmlPullParser2.next();
                            i2 = 4;
                            arrayList5 = arrayList5;
                            arrayList4 = arrayList4;
                            if (xmlPullParser2.getDepth() >= depth) {
                            }
                        }
                        objectRef = objectRef6;
                        objectRef3 = objectRef5;
                        objectRef2 = objectRef4;
                        arrayList3 = arrayList5;
                        arrayList2 = arrayList4;
                        List list322222 = arrayList;
                        str = (String) objectRef.element;
                        if (str != null) {
                            return new VastWrapperDto(str, (Boolean) objectRef2.element, (VastAdSystemDto) objectRef3.element, arrayList2, arrayList3, list322222);
                        }
                        return null;
                    }
                    depth = vastParserKt$parseWrapperTag$1.I$0;
                    xmlPullParser5 = (XmlPullParser) vastParserKt$parseWrapperTag$1.L$6;
                    list2 = (List) vastParserKt$parseWrapperTag$1.L$5;
                    r11 = (List) vastParserKt$parseWrapperTag$1.L$4;
                    r12 = (List) vastParserKt$parseWrapperTag$1.L$3;
                    objectRef13 = (Ref.ObjectRef) vastParserKt$parseWrapperTag$1.L$2;
                    objectRef12 = (Ref.ObjectRef) vastParserKt$parseWrapperTag$1.L$1;
                    objectRef11 = (Ref.ObjectRef) vastParserKt$parseWrapperTag$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    obj = obj3;
                    str2 = (String) obj;
                    if (str2 != null) {
                    }
                    xmlPullParser2 = xmlPullParser5;
                    objectRef6 = objectRef11;
                    objectRef4 = objectRef12;
                    objectRef5 = objectRef13;
                    arrayList4 = r12;
                    arrayList5 = r11;
                    arrayList = list2;
                    xmlPullParser2.next();
                    i2 = 4;
                    arrayList5 = arrayList5;
                    arrayList4 = arrayList4;
                    if (xmlPullParser2.getDepth() >= depth) {
                    }
                    objectRef = objectRef6;
                    objectRef3 = objectRef5;
                    objectRef2 = objectRef4;
                    arrayList3 = arrayList5;
                    arrayList2 = arrayList4;
                    List list3222222 = arrayList;
                    str = (String) objectRef.element;
                    if (str != null) {
                    }
                }
            }
        }
        vastParserKt$parseWrapperTag$1 = new VastParserKt$parseWrapperTag$1(continuation);
        Object obj32 = vastParserKt$parseWrapperTag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = vastParserKt$parseWrapperTag$1.label;
        int i22 = 4;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer parseSequenceAttribute(XmlPullParser xmlPullParser) {
        String attribute = attribute(xmlPullParser, "sequence");
        if (attribute == null) {
            return null;
        }
        Integer intOrNull = StringsKt.toIntOrNull(attribute);
        return Integer.valueOf(intOrNull != null ? intOrNull.intValue() : 999);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object parseErrorTag(XmlPullParser xmlPullParser, Continuation<? super String> continuation) {
        return parseTagsTextOnly(xmlPullParser, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e0, code lost:
    
        if (isEndTag(r7) != false) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006f -> B:14:0x00e3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0077 -> B:14:0x00e3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0086 -> B:14:0x00e3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0099 -> B:10:0x009c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00ad -> B:14:0x00e3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00c6 -> B:14:0x00e3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00e0 -> B:14:0x00e3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object parseCreativesTag(XmlPullParser xmlPullParser, boolean z, Continuation<? super List<VastCreativeDto>> continuation) {
        VastParserKt$parseCreativesTag$1 vastParserKt$parseCreativesTag$1;
        int i;
        int depth;
        List list;
        String text;
        if (continuation instanceof VastParserKt$parseCreativesTag$1) {
            vastParserKt$parseCreativesTag$1 = (VastParserKt$parseCreativesTag$1) continuation;
            if ((vastParserKt$parseCreativesTag$1.label & Integer.MIN_VALUE) != 0) {
                vastParserKt$parseCreativesTag$1.label -= Integer.MIN_VALUE;
                Object obj = vastParserKt$parseCreativesTag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = vastParserKt$parseCreativesTag$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ArrayList arrayList = new ArrayList();
                    if (isStartDocument(xmlPullParser)) {
                        xmlPullParser.nextTag();
                    }
                    if (isEndDocument(xmlPullParser)) {
                        return arrayList;
                    }
                    if (!isStartTag(xmlPullParser)) {
                        throw new XmlPullParserException("allowed only for START_TAG");
                    }
                    depth = xmlPullParser.getDepth();
                    list = arrayList;
                    if (xmlPullParser.getDepth() >= depth) {
                    }
                    return list;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = vastParserKt$parseCreativesTag$1.I$0;
                z = vastParserKt$parseCreativesTag$1.Z$0;
                XmlPullParser xmlPullParser2 = (XmlPullParser) vastParserKt$parseCreativesTag$1.L$1;
                list = (List) vastParserKt$parseCreativesTag$1.L$0;
                ResultKt.throwOnFailure(obj);
                VastCreativeDto vastCreativeDto = (VastCreativeDto) obj;
                if (vastCreativeDto != null) {
                    list.add(vastCreativeDto);
                }
                XmlPullParser xmlPullParser3 = xmlPullParser2;
                depth = i2;
                xmlPullParser = xmlPullParser3;
                xmlPullParser.next();
                if (xmlPullParser.getDepth() >= depth) {
                    int depth2 = xmlPullParser.getDepth() - depth;
                    if (depth2 == 0) {
                        if (!isStartTag(xmlPullParser)) {
                            if (isText(xmlPullParser) && (text = xmlPullParser.getText()) != null && !StringsKt.isBlank(text)) {
                                String text2 = xmlPullParser.getText();
                                Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                                StringsKt.trim((CharSequence) text2).toString();
                            }
                        }
                    } else if (depth2 == 1 && isStartTag(xmlPullParser) && Intrinsics.areEqual(xmlPullParser.getName(), "Creative")) {
                        vastParserKt$parseCreativesTag$1.L$0 = list;
                        vastParserKt$parseCreativesTag$1.L$1 = xmlPullParser;
                        vastParserKt$parseCreativesTag$1.Z$0 = z;
                        vastParserKt$parseCreativesTag$1.I$0 = depth;
                        vastParserKt$parseCreativesTag$1.label = 1;
                        obj = parseCreativeTag(xmlPullParser, z, vastParserKt$parseCreativesTag$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        int i3 = depth;
                        xmlPullParser2 = xmlPullParser;
                        i2 = i3;
                        VastCreativeDto vastCreativeDto2 = (VastCreativeDto) obj;
                        if (vastCreativeDto2 != null) {
                        }
                        XmlPullParser xmlPullParser32 = xmlPullParser2;
                        depth = i2;
                        xmlPullParser = xmlPullParser32;
                    }
                    xmlPullParser.next();
                    if (xmlPullParser.getDepth() >= depth) {
                    }
                }
                return list;
            }
        }
        vastParserKt$parseCreativesTag$1 = new VastParserKt$parseCreativesTag$1(continuation);
        Object obj2 = vastParserKt$parseCreativesTag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = vastParserKt$parseCreativesTag$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01df, code lost:
    
        if (isEndTag(r0) != false) goto L93;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0216 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Type inference failed for: r15v1, types: [T, io.adn.sdk.internal.data.dto.VastCreativeChildDto$Linear] */
    /* JADX WARN: Type inference failed for: r7v20, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r7v22, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v24, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v38, types: [T, java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00ca -> B:19:0x01e2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00d2 -> B:19:0x01e2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00d9 -> B:19:0x01e2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00df -> B:19:0x01e2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00f2 -> B:19:0x01e2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00fc -> B:19:0x01e2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0102 -> B:19:0x01e2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0104 -> B:19:0x01e2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0112 -> B:19:0x01e2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0131 -> B:11:0x0137). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0158 -> B:19:0x01e2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0196 -> B:19:0x01e2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x01c5 -> B:19:0x01e2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x01df -> B:19:0x01e2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object parseCreativeTag(XmlPullParser xmlPullParser, boolean z, Continuation<? super VastCreativeDto> continuation) {
        VastParserKt$parseCreativeTag$1 vastParserKt$parseCreativeTag$1;
        int i;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        int depth;
        Ref.ObjectRef objectRef6;
        Ref.ObjectRef objectRef7;
        Ref.ObjectRef objectRef8;
        Ref.ObjectRef objectRef9;
        Ref.ObjectRef objectRef10;
        XmlPullParser xmlPullParser2;
        VastParserKt$parseCreativeTag$1 vastParserKt$parseCreativeTag$12;
        boolean z2;
        VastCreativeChildDto vastCreativeChildDto;
        Ref.ObjectRef objectRef11;
        XmlPullParser xmlPullParser3;
        boolean z3;
        int i2;
        VastLinearDto vastLinearDto;
        String text;
        String name;
        if (continuation instanceof VastParserKt$parseCreativeTag$1) {
            vastParserKt$parseCreativeTag$1 = (VastParserKt$parseCreativeTag$1) continuation;
            if ((vastParserKt$parseCreativeTag$1.label & Integer.MIN_VALUE) != 0) {
                vastParserKt$parseCreativeTag$1.label -= Integer.MIN_VALUE;
                Object obj = vastParserKt$parseCreativeTag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = vastParserKt$parseCreativeTag$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    objectRef = new Ref.ObjectRef();
                    objectRef2 = new Ref.ObjectRef();
                    objectRef3 = new Ref.ObjectRef();
                    objectRef4 = new Ref.ObjectRef();
                    objectRef5 = new Ref.ObjectRef();
                    if (isStartDocument(xmlPullParser)) {
                        xmlPullParser.nextTag();
                    }
                    if (!isEndDocument(xmlPullParser)) {
                        if (!isStartTag(xmlPullParser)) {
                            throw new XmlPullParserException("allowed only for START_TAG");
                        }
                        depth = xmlPullParser.getDepth();
                        objectRef6 = objectRef;
                        objectRef7 = objectRef2;
                        objectRef8 = objectRef3;
                        objectRef9 = objectRef4;
                        objectRef10 = objectRef5;
                        xmlPullParser2 = xmlPullParser;
                        vastParserKt$parseCreativeTag$12 = vastParserKt$parseCreativeTag$1;
                        z2 = z;
                        if (xmlPullParser2.getDepth() >= depth) {
                        }
                        objectRef5 = objectRef10;
                        objectRef4 = objectRef9;
                        objectRef3 = objectRef8;
                        objectRef2 = objectRef7;
                        objectRef = objectRef6;
                    }
                    vastCreativeChildDto = (VastCreativeChildDto) objectRef5.element;
                    if (vastCreativeChildDto != null) {
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i2 = vastParserKt$parseCreativeTag$1.I$0;
                        z3 = vastParserKt$parseCreativeTag$1.Z$0;
                        objectRef10 = (Ref.ObjectRef) vastParserKt$parseCreativeTag$1.L$6;
                        xmlPullParser3 = (XmlPullParser) vastParserKt$parseCreativeTag$1.L$5;
                        objectRef11 = (Ref.ObjectRef) vastParserKt$parseCreativeTag$1.L$4;
                        objectRef9 = (Ref.ObjectRef) vastParserKt$parseCreativeTag$1.L$3;
                        objectRef8 = (Ref.ObjectRef) vastParserKt$parseCreativeTag$1.L$2;
                        objectRef7 = (Ref.ObjectRef) vastParserKt$parseCreativeTag$1.L$1;
                        objectRef6 = (Ref.ObjectRef) vastParserKt$parseCreativeTag$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (((List) obj).isEmpty()) {
                            obj = null;
                        }
                        List list = (List) obj;
                        objectRef10.element = list == null ? new VastCreativeChildDto.Companions(list) : 0;
                        xmlPullParser2 = xmlPullParser3;
                        objectRef10 = objectRef11;
                        depth = i2;
                        vastParserKt$parseCreativeTag$12 = vastParserKt$parseCreativeTag$1;
                        z2 = z3;
                        xmlPullParser2.next();
                        if (xmlPullParser2.getDepth() >= depth) {
                            int depth2 = xmlPullParser2.getDepth() - depth;
                            if (depth2 == 0) {
                                if (isStartTag(xmlPullParser2)) {
                                    objectRef7.element = parseSequenceAttribute(xmlPullParser2);
                                    objectRef8.element = attribute(xmlPullParser2, VastAttributes.AD_ID);
                                    objectRef9.element = attribute(xmlPullParser2, "apiFramework");
                                } else if (isText(xmlPullParser2) && (text = xmlPullParser2.getText()) != null && !StringsKt.isBlank(text)) {
                                    String text2 = xmlPullParser2.getText();
                                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                                    StringsKt.trim((CharSequence) text2).toString();
                                }
                            } else if (depth2 == 1 && isStartTag(xmlPullParser2) && objectRef10.element == 0 && (name = xmlPullParser2.getName()) != null) {
                                int hashCode = name.hashCode();
                                if (hashCode == -2018804923) {
                                    if (name.equals("Linear")) {
                                        vastParserKt$parseCreativeTag$12.L$0 = objectRef6;
                                        vastParserKt$parseCreativeTag$12.L$1 = objectRef7;
                                        vastParserKt$parseCreativeTag$12.L$2 = objectRef8;
                                        vastParserKt$parseCreativeTag$12.L$3 = objectRef9;
                                        vastParserKt$parseCreativeTag$12.L$4 = objectRef10;
                                        vastParserKt$parseCreativeTag$12.L$5 = xmlPullParser2;
                                        vastParserKt$parseCreativeTag$12.L$6 = objectRef10;
                                        vastParserKt$parseCreativeTag$12.Z$0 = z2;
                                        vastParserKt$parseCreativeTag$12.I$0 = depth;
                                        vastParserKt$parseCreativeTag$12.label = 1;
                                        Object parseLinearTag = parseLinearTag(xmlPullParser2, z2, vastParserKt$parseCreativeTag$12);
                                        if (parseLinearTag != coroutine_suspended) {
                                            xmlPullParser3 = xmlPullParser2;
                                            obj = parseLinearTag;
                                            z3 = z2;
                                            vastParserKt$parseCreativeTag$1 = vastParserKt$parseCreativeTag$12;
                                            i2 = depth;
                                            objectRef11 = objectRef10;
                                            vastLinearDto = (VastLinearDto) obj;
                                            if (vastLinearDto == null) {
                                                objectRef10.element = new VastCreativeChildDto.Linear(vastLinearDto);
                                            } else {
                                                objectRef10.element = null;
                                            }
                                            xmlPullParser2 = xmlPullParser3;
                                            objectRef10 = objectRef11;
                                            depth = i2;
                                            vastParserKt$parseCreativeTag$12 = vastParserKt$parseCreativeTag$1;
                                            z2 = z3;
                                        }
                                        return coroutine_suspended;
                                    }
                                } else if (hashCode == 1150879268) {
                                    if (name.equals("CompanionAds")) {
                                        vastParserKt$parseCreativeTag$12.L$0 = objectRef6;
                                        vastParserKt$parseCreativeTag$12.L$1 = objectRef7;
                                        vastParserKt$parseCreativeTag$12.L$2 = objectRef8;
                                        vastParserKt$parseCreativeTag$12.L$3 = objectRef9;
                                        vastParserKt$parseCreativeTag$12.L$4 = objectRef10;
                                        vastParserKt$parseCreativeTag$12.L$5 = xmlPullParser2;
                                        vastParserKt$parseCreativeTag$12.L$6 = objectRef10;
                                        vastParserKt$parseCreativeTag$12.Z$0 = z2;
                                        vastParserKt$parseCreativeTag$12.I$0 = depth;
                                        vastParserKt$parseCreativeTag$12.label = 2;
                                        Object parseCompanionAdsTag = parseCompanionAdsTag(xmlPullParser2, vastParserKt$parseCreativeTag$12);
                                        if (parseCompanionAdsTag != coroutine_suspended) {
                                            xmlPullParser3 = xmlPullParser2;
                                            obj = parseCompanionAdsTag;
                                            z3 = z2;
                                            vastParserKt$parseCreativeTag$1 = vastParserKt$parseCreativeTag$12;
                                            i2 = depth;
                                            objectRef11 = objectRef10;
                                            if (((List) obj).isEmpty()) {
                                            }
                                            List list2 = (List) obj;
                                            objectRef10.element = list2 == null ? new VastCreativeChildDto.Companions(list2) : 0;
                                            xmlPullParser2 = xmlPullParser3;
                                            objectRef10 = objectRef11;
                                            depth = i2;
                                            vastParserKt$parseCreativeTag$12 = vastParserKt$parseCreativeTag$1;
                                            z2 = z3;
                                        }
                                        return coroutine_suspended;
                                    }
                                } else if (hashCode == 1539775849 && name.equals(TAG_UNIVERSAL_AD_ID) && objectRef6.element == 0) {
                                    objectRef6.element = xmlPullParser2.nextText();
                                }
                                if (xmlPullParser2.getDepth() >= depth) {
                                }
                            }
                            xmlPullParser2.next();
                            if (xmlPullParser2.getDepth() >= depth) {
                            }
                        }
                        objectRef5 = objectRef10;
                        objectRef4 = objectRef9;
                        objectRef3 = objectRef8;
                        objectRef2 = objectRef7;
                        objectRef = objectRef6;
                        vastCreativeChildDto = (VastCreativeChildDto) objectRef5.element;
                        if (vastCreativeChildDto != null) {
                            return new VastCreativeDto((String) objectRef.element, (Integer) objectRef2.element, (String) objectRef3.element, (String) objectRef4.element, vastCreativeChildDto);
                        }
                        return null;
                    }
                    i2 = vastParserKt$parseCreativeTag$1.I$0;
                    z3 = vastParserKt$parseCreativeTag$1.Z$0;
                    objectRef10 = (Ref.ObjectRef) vastParserKt$parseCreativeTag$1.L$6;
                    xmlPullParser3 = (XmlPullParser) vastParserKt$parseCreativeTag$1.L$5;
                    objectRef11 = (Ref.ObjectRef) vastParserKt$parseCreativeTag$1.L$4;
                    objectRef9 = (Ref.ObjectRef) vastParserKt$parseCreativeTag$1.L$3;
                    objectRef8 = (Ref.ObjectRef) vastParserKt$parseCreativeTag$1.L$2;
                    objectRef7 = (Ref.ObjectRef) vastParserKt$parseCreativeTag$1.L$1;
                    objectRef6 = (Ref.ObjectRef) vastParserKt$parseCreativeTag$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    vastLinearDto = (VastLinearDto) obj;
                    if (vastLinearDto == null) {
                    }
                    xmlPullParser2 = xmlPullParser3;
                    objectRef10 = objectRef11;
                    depth = i2;
                    vastParserKt$parseCreativeTag$12 = vastParserKt$parseCreativeTag$1;
                    z2 = z3;
                    xmlPullParser2.next();
                    if (xmlPullParser2.getDepth() >= depth) {
                    }
                    objectRef5 = objectRef10;
                    objectRef4 = objectRef9;
                    objectRef3 = objectRef8;
                    objectRef2 = objectRef7;
                    objectRef = objectRef6;
                    vastCreativeChildDto = (VastCreativeChildDto) objectRef5.element;
                    if (vastCreativeChildDto != null) {
                    }
                }
            }
        }
        vastParserKt$parseCreativeTag$1 = new VastParserKt$parseCreativeTag$1(continuation);
        Object obj2 = vastParserKt$parseCreativeTag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = vastParserKt$parseCreativeTag$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x033e, code lost:
    
        if (isEndTag(r13) != false) goto L108;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x013b  */
    /* JADX WARN: Type inference failed for: r15v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v27, types: [T, io.adn.sdk.internal.domain.model.ad.VastOffset] */
    /* JADX WARN: Type inference failed for: r15v34, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v39, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v9, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r2v27, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v35, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v38 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v40 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v40 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0195 -> B:14:0x0341). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x019d -> B:14:0x0341). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x01a6 -> B:14:0x0341). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x01ac -> B:14:0x0341). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x01b7 -> B:14:0x0341). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x01ef -> B:14:0x0341). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0214 -> B:12:0x0219). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0226 -> B:14:0x0341). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x025d -> B:14:0x0341). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0296 -> B:14:0x0341). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x02d2 -> B:14:0x0341). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0305 -> B:14:0x0341). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x0324 -> B:14:0x0341). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x033e -> B:14:0x0341). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object parseLinearTag(XmlPullParser xmlPullParser, boolean z, Continuation<? super VastLinearDto> continuation) {
        VastParserKt$parseLinearTag$1 vastParserKt$parseLinearTag$1;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int depth;
        List list;
        Ref.ObjectRef objectRef5;
        Ref.ObjectRef objectRef6;
        Ref.ObjectRef objectRef7;
        ArrayList arrayList4;
        List list2;
        int i;
        XmlPullParser xmlPullParser2;
        ?? r5;
        Ref.ObjectRef objectRef8;
        Ref.ObjectRef objectRef9;
        Object obj;
        String str;
        String text;
        List list3;
        List list4;
        ArrayList arrayList5;
        Object obj2;
        ArrayList arrayList6;
        if (continuation instanceof VastParserKt$parseLinearTag$1) {
            vastParserKt$parseLinearTag$1 = (VastParserKt$parseLinearTag$1) continuation;
            if ((vastParserKt$parseLinearTag$1.label & Integer.MIN_VALUE) != 0) {
                vastParserKt$parseLinearTag$1.label -= Integer.MIN_VALUE;
                ?? r15 = vastParserKt$parseLinearTag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (vastParserKt$parseLinearTag$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(r15);
                        objectRef = new Ref.ObjectRef();
                        objectRef2 = new Ref.ObjectRef();
                        objectRef3 = new Ref.ObjectRef();
                        ArrayList arrayList7 = new ArrayList();
                        ArrayList arrayList8 = new ArrayList();
                        objectRef4 = new Ref.ObjectRef();
                        ArrayList arrayList9 = new ArrayList();
                        if (isStartDocument(xmlPullParser)) {
                            xmlPullParser.nextTag();
                        }
                        if (isEndDocument(xmlPullParser)) {
                            arrayList = arrayList7;
                            arrayList2 = arrayList8;
                            arrayList3 = arrayList9;
                            if (z) {
                            }
                            return new VastLinearDto((VastOffset) objectRef.element, (VastAdParametersDto) objectRef2.element, (Long) objectRef3.element, arrayList, arrayList2, (VastVideoClicksDto) objectRef4.element, arrayList3);
                        }
                        if (!isStartTag(xmlPullParser)) {
                            throw new XmlPullParserException("allowed only for START_TAG");
                        }
                        depth = xmlPullParser.getDepth();
                        list = arrayList8;
                        objectRef5 = objectRef4;
                        objectRef6 = objectRef;
                        objectRef7 = objectRef2;
                        arrayList4 = arrayList9;
                        list2 = arrayList7;
                        if (xmlPullParser.getDepth() >= depth) {
                            int depth2 = xmlPullParser.getDepth() - depth;
                            if (depth2 != 0) {
                                arrayList5 = arrayList4;
                                list4 = list;
                                list3 = list2;
                                if (depth2 == 1) {
                                    arrayList5 = arrayList4;
                                    list4 = list;
                                    list3 = list2;
                                    if (isStartTag(xmlPullParser)) {
                                        String name = xmlPullParser.getName();
                                        arrayList5 = arrayList4;
                                        list4 = list;
                                        list3 = list2;
                                        if (name != null) {
                                            arrayList5 = arrayList4;
                                            list4 = list;
                                            list3 = list2;
                                            switch (name.hashCode()) {
                                                case -2049897434:
                                                    arrayList5 = arrayList4;
                                                    list4 = list;
                                                    list3 = list2;
                                                    if (name.equals("VideoClicks")) {
                                                        vastParserKt$parseLinearTag$1.L$0 = objectRef6;
                                                        vastParserKt$parseLinearTag$1.L$1 = objectRef7;
                                                        vastParserKt$parseLinearTag$1.L$2 = objectRef3;
                                                        vastParserKt$parseLinearTag$1.L$3 = list2;
                                                        vastParserKt$parseLinearTag$1.L$4 = list;
                                                        vastParserKt$parseLinearTag$1.L$5 = objectRef5;
                                                        vastParserKt$parseLinearTag$1.L$6 = arrayList4;
                                                        vastParserKt$parseLinearTag$1.L$7 = xmlPullParser;
                                                        vastParserKt$parseLinearTag$1.L$8 = objectRef5;
                                                        vastParserKt$parseLinearTag$1.Z$0 = z;
                                                        vastParserKt$parseLinearTag$1.I$0 = depth;
                                                        vastParserKt$parseLinearTag$1.label = 5;
                                                        ?? parseVideoClicksTag = parseVideoClicksTag(xmlPullParser, z, vastParserKt$parseLinearTag$1);
                                                        if (parseVideoClicksTag != coroutine_suspended) {
                                                            Ref.ObjectRef objectRef10 = objectRef3;
                                                            xmlPullParser2 = xmlPullParser;
                                                            i = depth;
                                                            objectRef8 = objectRef10;
                                                            r5 = arrayList4;
                                                            objectRef5.element = parseVideoClicksTag;
                                                            Ref.ObjectRef objectRef11 = objectRef8;
                                                            depth = i;
                                                            xmlPullParser = xmlPullParser2;
                                                            objectRef3 = objectRef11;
                                                            arrayList5 = r5;
                                                            list4 = list;
                                                            list3 = list2;
                                                            break;
                                                        }
                                                        return coroutine_suspended;
                                                    }
                                                    break;
                                                case -1927368268:
                                                    arrayList5 = arrayList4;
                                                    list4 = list;
                                                    list3 = list2;
                                                    if (name.equals("Duration")) {
                                                        vastParserKt$parseLinearTag$1.L$0 = objectRef6;
                                                        vastParserKt$parseLinearTag$1.L$1 = objectRef7;
                                                        vastParserKt$parseLinearTag$1.L$2 = objectRef3;
                                                        vastParserKt$parseLinearTag$1.L$3 = list2;
                                                        vastParserKt$parseLinearTag$1.L$4 = list;
                                                        vastParserKt$parseLinearTag$1.L$5 = objectRef5;
                                                        vastParserKt$parseLinearTag$1.L$6 = arrayList4;
                                                        vastParserKt$parseLinearTag$1.L$7 = xmlPullParser;
                                                        vastParserKt$parseLinearTag$1.L$8 = objectRef3;
                                                        vastParserKt$parseLinearTag$1.Z$0 = z;
                                                        vastParserKt$parseLinearTag$1.I$0 = depth;
                                                        vastParserKt$parseLinearTag$1.label = 2;
                                                        Object parseTagsTextOnly = parseTagsTextOnly(xmlPullParser, vastParserKt$parseLinearTag$1);
                                                        if (parseTagsTextOnly != coroutine_suspended) {
                                                            r5 = arrayList4;
                                                            objectRef9 = objectRef3;
                                                            xmlPullParser2 = xmlPullParser;
                                                            i = depth;
                                                            objectRef8 = objectRef9;
                                                            list = list;
                                                            list2 = list2;
                                                            obj = parseTagsTextOnly;
                                                            str = (String) obj;
                                                            if (str == null) {
                                                                objectRef9.element = toMillis(str);
                                                            } else {
                                                                objectRef9.element = null;
                                                            }
                                                            Ref.ObjectRef objectRef112 = objectRef8;
                                                            depth = i;
                                                            xmlPullParser = xmlPullParser2;
                                                            objectRef3 = objectRef112;
                                                            arrayList5 = r5;
                                                            list4 = list;
                                                            list3 = list2;
                                                            break;
                                                        }
                                                        return coroutine_suspended;
                                                    }
                                                    break;
                                                case -1348833651:
                                                    arrayList5 = arrayList4;
                                                    list4 = list;
                                                    list3 = list2;
                                                    if (name.equals("AdParameters")) {
                                                        vastParserKt$parseLinearTag$1.L$0 = objectRef6;
                                                        vastParserKt$parseLinearTag$1.L$1 = objectRef7;
                                                        vastParserKt$parseLinearTag$1.L$2 = objectRef3;
                                                        vastParserKt$parseLinearTag$1.L$3 = list2;
                                                        vastParserKt$parseLinearTag$1.L$4 = list;
                                                        vastParserKt$parseLinearTag$1.L$5 = objectRef5;
                                                        vastParserKt$parseLinearTag$1.L$6 = arrayList4;
                                                        vastParserKt$parseLinearTag$1.L$7 = xmlPullParser;
                                                        vastParserKt$parseLinearTag$1.L$8 = objectRef7;
                                                        vastParserKt$parseLinearTag$1.Z$0 = z;
                                                        vastParserKt$parseLinearTag$1.I$0 = depth;
                                                        vastParserKt$parseLinearTag$1.label = 1;
                                                        ?? parseAdParametersTag = parseAdParametersTag(xmlPullParser, vastParserKt$parseLinearTag$1);
                                                        if (parseAdParametersTag != coroutine_suspended) {
                                                            Ref.ObjectRef objectRef12 = objectRef3;
                                                            xmlPullParser2 = xmlPullParser;
                                                            i = depth;
                                                            objectRef8 = objectRef12;
                                                            r5 = arrayList4;
                                                            objectRef7.element = parseAdParametersTag;
                                                            Ref.ObjectRef objectRef1122 = objectRef8;
                                                            depth = i;
                                                            xmlPullParser = xmlPullParser2;
                                                            objectRef3 = objectRef1122;
                                                            arrayList5 = r5;
                                                            list4 = list;
                                                            list3 = list2;
                                                            break;
                                                        }
                                                        return coroutine_suspended;
                                                    }
                                                    break;
                                                case -385055469:
                                                    arrayList5 = arrayList4;
                                                    list4 = list;
                                                    list3 = list2;
                                                    if (name.equals("MediaFiles")) {
                                                        vastParserKt$parseLinearTag$1.L$0 = objectRef6;
                                                        vastParserKt$parseLinearTag$1.L$1 = objectRef7;
                                                        vastParserKt$parseLinearTag$1.L$2 = objectRef3;
                                                        vastParserKt$parseLinearTag$1.L$3 = list2;
                                                        vastParserKt$parseLinearTag$1.L$4 = list;
                                                        vastParserKt$parseLinearTag$1.L$5 = objectRef5;
                                                        vastParserKt$parseLinearTag$1.L$6 = arrayList4;
                                                        vastParserKt$parseLinearTag$1.L$7 = xmlPullParser;
                                                        vastParserKt$parseLinearTag$1.L$8 = list2;
                                                        vastParserKt$parseLinearTag$1.Z$0 = z;
                                                        vastParserKt$parseLinearTag$1.I$0 = depth;
                                                        vastParserKt$parseLinearTag$1.label = 3;
                                                        Object parseMediaFilesTag = parseMediaFilesTag(xmlPullParser, vastParserKt$parseLinearTag$1);
                                                        if (parseMediaFilesTag != coroutine_suspended) {
                                                            Ref.ObjectRef objectRef13 = objectRef3;
                                                            xmlPullParser2 = xmlPullParser;
                                                            i = depth;
                                                            objectRef8 = objectRef13;
                                                            r5 = arrayList4;
                                                            list2.addAll((Collection) parseMediaFilesTag);
                                                            Ref.ObjectRef objectRef11222 = objectRef8;
                                                            depth = i;
                                                            xmlPullParser = xmlPullParser2;
                                                            objectRef3 = objectRef11222;
                                                            arrayList5 = r5;
                                                            list4 = list;
                                                            list3 = list2;
                                                            break;
                                                        }
                                                        return coroutine_suspended;
                                                    }
                                                    break;
                                                case 70476538:
                                                    arrayList5 = arrayList4;
                                                    list4 = list;
                                                    list3 = list2;
                                                    if (name.equals("Icons")) {
                                                        vastParserKt$parseLinearTag$1.L$0 = objectRef6;
                                                        vastParserKt$parseLinearTag$1.L$1 = objectRef7;
                                                        vastParserKt$parseLinearTag$1.L$2 = objectRef3;
                                                        vastParserKt$parseLinearTag$1.L$3 = list2;
                                                        vastParserKt$parseLinearTag$1.L$4 = list;
                                                        vastParserKt$parseLinearTag$1.L$5 = objectRef5;
                                                        vastParserKt$parseLinearTag$1.L$6 = arrayList4;
                                                        vastParserKt$parseLinearTag$1.L$7 = xmlPullParser;
                                                        vastParserKt$parseLinearTag$1.L$8 = arrayList4;
                                                        vastParserKt$parseLinearTag$1.Z$0 = z;
                                                        vastParserKt$parseLinearTag$1.I$0 = depth;
                                                        vastParserKt$parseLinearTag$1.label = 6;
                                                        Object parseIconsTag = parseIconsTag(xmlPullParser, vastParserKt$parseLinearTag$1);
                                                        if (parseIconsTag != coroutine_suspended) {
                                                            Ref.ObjectRef objectRef14 = objectRef3;
                                                            xmlPullParser2 = xmlPullParser;
                                                            i = depth;
                                                            objectRef8 = objectRef14;
                                                            r5 = arrayList4;
                                                            arrayList6 = arrayList4;
                                                            list = list;
                                                            list2 = list2;
                                                            obj2 = parseIconsTag;
                                                            arrayList6.addAll((Collection) obj2);
                                                            Ref.ObjectRef objectRef112222 = objectRef8;
                                                            depth = i;
                                                            xmlPullParser = xmlPullParser2;
                                                            objectRef3 = objectRef112222;
                                                            arrayList5 = r5;
                                                            list4 = list;
                                                            list3 = list2;
                                                            break;
                                                        }
                                                        return coroutine_suspended;
                                                    }
                                                    break;
                                                case 611554000:
                                                    arrayList5 = arrayList4;
                                                    list4 = list;
                                                    list3 = list2;
                                                    if (name.equals("TrackingEvents")) {
                                                        vastParserKt$parseLinearTag$1.L$0 = objectRef6;
                                                        vastParserKt$parseLinearTag$1.L$1 = objectRef7;
                                                        vastParserKt$parseLinearTag$1.L$2 = objectRef3;
                                                        vastParserKt$parseLinearTag$1.L$3 = list2;
                                                        vastParserKt$parseLinearTag$1.L$4 = list;
                                                        vastParserKt$parseLinearTag$1.L$5 = objectRef5;
                                                        vastParserKt$parseLinearTag$1.L$6 = arrayList4;
                                                        vastParserKt$parseLinearTag$1.L$7 = xmlPullParser;
                                                        vastParserKt$parseLinearTag$1.L$8 = list;
                                                        vastParserKt$parseLinearTag$1.Z$0 = z;
                                                        vastParserKt$parseLinearTag$1.I$0 = depth;
                                                        vastParserKt$parseLinearTag$1.label = 4;
                                                        Object parseTrackingEventsTag = parseTrackingEventsTag(xmlPullParser, vastParserKt$parseLinearTag$1);
                                                        if (parseTrackingEventsTag != coroutine_suspended) {
                                                            Ref.ObjectRef objectRef15 = objectRef3;
                                                            xmlPullParser2 = xmlPullParser;
                                                            i = depth;
                                                            objectRef8 = objectRef15;
                                                            r5 = arrayList4;
                                                            list.addAll((Collection) parseTrackingEventsTag);
                                                            Ref.ObjectRef objectRef1122222 = objectRef8;
                                                            depth = i;
                                                            xmlPullParser = xmlPullParser2;
                                                            objectRef3 = objectRef1122222;
                                                            arrayList5 = r5;
                                                            list4 = list;
                                                            list3 = list2;
                                                            break;
                                                        }
                                                        return coroutine_suspended;
                                                    }
                                                    break;
                                            }
                                        }
                                    }
                                }
                            } else if (isStartTag(xmlPullParser)) {
                                objectRef6.element = parseSkipOffsetAttribute(xmlPullParser);
                                arrayList5 = arrayList4;
                                list4 = list;
                                list3 = list2;
                            } else if (!isText(xmlPullParser) || (text = xmlPullParser.getText()) == null || StringsKt.isBlank(text)) {
                                arrayList5 = arrayList4;
                                list4 = list;
                                list3 = list2;
                                break;
                            } else {
                                String text2 = xmlPullParser.getText();
                                Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                                StringsKt.trim((CharSequence) text2).toString();
                                arrayList5 = arrayList4;
                                list4 = list;
                                list3 = list2;
                            }
                            xmlPullParser.next();
                            arrayList4 = arrayList5;
                            list = list4;
                            list2 = list3;
                            if (xmlPullParser.getDepth() >= depth) {
                            }
                        }
                        arrayList3 = arrayList4;
                        arrayList = list2;
                        objectRef2 = objectRef7;
                        objectRef = objectRef6;
                        arrayList2 = list;
                        objectRef4 = objectRef5;
                        if (z || !arrayList.isEmpty()) {
                            return new VastLinearDto((VastOffset) objectRef.element, (VastAdParametersDto) objectRef2.element, (Long) objectRef3.element, arrayList, arrayList2, (VastVideoClicksDto) objectRef4.element, arrayList3);
                        }
                        return null;
                    case 1:
                        i = vastParserKt$parseLinearTag$1.I$0;
                        z = vastParserKt$parseLinearTag$1.Z$0;
                        Ref.ObjectRef objectRef16 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$8;
                        xmlPullParser2 = (XmlPullParser) vastParserKt$parseLinearTag$1.L$7;
                        r5 = (List) vastParserKt$parseLinearTag$1.L$6;
                        objectRef5 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$5;
                        list = (List) vastParserKt$parseLinearTag$1.L$4;
                        list2 = (List) vastParserKt$parseLinearTag$1.L$3;
                        objectRef8 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$2;
                        objectRef7 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$1;
                        objectRef6 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$0;
                        ResultKt.throwOnFailure(r15);
                        objectRef16.element = r15;
                        Ref.ObjectRef objectRef11222222 = objectRef8;
                        depth = i;
                        xmlPullParser = xmlPullParser2;
                        objectRef3 = objectRef11222222;
                        arrayList5 = r5;
                        list4 = list;
                        list3 = list2;
                        xmlPullParser.next();
                        arrayList4 = arrayList5;
                        list = list4;
                        list2 = list3;
                        if (xmlPullParser.getDepth() >= depth) {
                        }
                        arrayList3 = arrayList4;
                        arrayList = list2;
                        objectRef2 = objectRef7;
                        objectRef = objectRef6;
                        arrayList2 = list;
                        objectRef4 = objectRef5;
                        if (z) {
                        }
                        return new VastLinearDto((VastOffset) objectRef.element, (VastAdParametersDto) objectRef2.element, (Long) objectRef3.element, arrayList, arrayList2, (VastVideoClicksDto) objectRef4.element, arrayList3);
                    case 2:
                        i = vastParserKt$parseLinearTag$1.I$0;
                        z = vastParserKt$parseLinearTag$1.Z$0;
                        objectRef9 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$8;
                        xmlPullParser2 = (XmlPullParser) vastParserKt$parseLinearTag$1.L$7;
                        r5 = (List) vastParserKt$parseLinearTag$1.L$6;
                        objectRef5 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$5;
                        List list5 = (List) vastParserKt$parseLinearTag$1.L$4;
                        List list6 = (List) vastParserKt$parseLinearTag$1.L$3;
                        objectRef8 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$2;
                        objectRef7 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$1;
                        objectRef6 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$0;
                        ResultKt.throwOnFailure(r15);
                        list = list5;
                        list2 = list6;
                        obj = r15;
                        str = (String) obj;
                        if (str == null) {
                        }
                        Ref.ObjectRef objectRef112222222 = objectRef8;
                        depth = i;
                        xmlPullParser = xmlPullParser2;
                        objectRef3 = objectRef112222222;
                        arrayList5 = r5;
                        list4 = list;
                        list3 = list2;
                        xmlPullParser.next();
                        arrayList4 = arrayList5;
                        list = list4;
                        list2 = list3;
                        if (xmlPullParser.getDepth() >= depth) {
                        }
                        arrayList3 = arrayList4;
                        arrayList = list2;
                        objectRef2 = objectRef7;
                        objectRef = objectRef6;
                        arrayList2 = list;
                        objectRef4 = objectRef5;
                        if (z) {
                        }
                        return new VastLinearDto((VastOffset) objectRef.element, (VastAdParametersDto) objectRef2.element, (Long) objectRef3.element, arrayList, arrayList2, (VastVideoClicksDto) objectRef4.element, arrayList3);
                    case 3:
                        i = vastParserKt$parseLinearTag$1.I$0;
                        z = vastParserKt$parseLinearTag$1.Z$0;
                        List list7 = (List) vastParserKt$parseLinearTag$1.L$8;
                        xmlPullParser2 = (XmlPullParser) vastParserKt$parseLinearTag$1.L$7;
                        r5 = (List) vastParserKt$parseLinearTag$1.L$6;
                        objectRef5 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$5;
                        list = (List) vastParserKt$parseLinearTag$1.L$4;
                        list2 = (List) vastParserKt$parseLinearTag$1.L$3;
                        objectRef8 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$2;
                        objectRef7 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$1;
                        objectRef6 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$0;
                        ResultKt.throwOnFailure(r15);
                        list7.addAll((Collection) r15);
                        Ref.ObjectRef objectRef1122222222 = objectRef8;
                        depth = i;
                        xmlPullParser = xmlPullParser2;
                        objectRef3 = objectRef1122222222;
                        arrayList5 = r5;
                        list4 = list;
                        list3 = list2;
                        xmlPullParser.next();
                        arrayList4 = arrayList5;
                        list = list4;
                        list2 = list3;
                        if (xmlPullParser.getDepth() >= depth) {
                        }
                        arrayList3 = arrayList4;
                        arrayList = list2;
                        objectRef2 = objectRef7;
                        objectRef = objectRef6;
                        arrayList2 = list;
                        objectRef4 = objectRef5;
                        if (z) {
                        }
                        return new VastLinearDto((VastOffset) objectRef.element, (VastAdParametersDto) objectRef2.element, (Long) objectRef3.element, arrayList, arrayList2, (VastVideoClicksDto) objectRef4.element, arrayList3);
                    case 4:
                        i = vastParserKt$parseLinearTag$1.I$0;
                        z = vastParserKt$parseLinearTag$1.Z$0;
                        List list8 = (List) vastParserKt$parseLinearTag$1.L$8;
                        xmlPullParser2 = (XmlPullParser) vastParserKt$parseLinearTag$1.L$7;
                        r5 = (List) vastParserKt$parseLinearTag$1.L$6;
                        objectRef5 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$5;
                        list = (List) vastParserKt$parseLinearTag$1.L$4;
                        list2 = (List) vastParserKt$parseLinearTag$1.L$3;
                        objectRef8 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$2;
                        objectRef7 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$1;
                        objectRef6 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$0;
                        ResultKt.throwOnFailure(r15);
                        list8.addAll((Collection) r15);
                        Ref.ObjectRef objectRef11222222222 = objectRef8;
                        depth = i;
                        xmlPullParser = xmlPullParser2;
                        objectRef3 = objectRef11222222222;
                        arrayList5 = r5;
                        list4 = list;
                        list3 = list2;
                        xmlPullParser.next();
                        arrayList4 = arrayList5;
                        list = list4;
                        list2 = list3;
                        if (xmlPullParser.getDepth() >= depth) {
                        }
                        arrayList3 = arrayList4;
                        arrayList = list2;
                        objectRef2 = objectRef7;
                        objectRef = objectRef6;
                        arrayList2 = list;
                        objectRef4 = objectRef5;
                        if (z) {
                        }
                        return new VastLinearDto((VastOffset) objectRef.element, (VastAdParametersDto) objectRef2.element, (Long) objectRef3.element, arrayList, arrayList2, (VastVideoClicksDto) objectRef4.element, arrayList3);
                    case 5:
                        i = vastParserKt$parseLinearTag$1.I$0;
                        z = vastParserKt$parseLinearTag$1.Z$0;
                        Ref.ObjectRef objectRef17 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$8;
                        xmlPullParser2 = (XmlPullParser) vastParserKt$parseLinearTag$1.L$7;
                        r5 = (List) vastParserKt$parseLinearTag$1.L$6;
                        objectRef5 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$5;
                        list = (List) vastParserKt$parseLinearTag$1.L$4;
                        list2 = (List) vastParserKt$parseLinearTag$1.L$3;
                        objectRef8 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$2;
                        objectRef7 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$1;
                        objectRef6 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$0;
                        ResultKt.throwOnFailure(r15);
                        objectRef17.element = r15;
                        Ref.ObjectRef objectRef112222222222 = objectRef8;
                        depth = i;
                        xmlPullParser = xmlPullParser2;
                        objectRef3 = objectRef112222222222;
                        arrayList5 = r5;
                        list4 = list;
                        list3 = list2;
                        xmlPullParser.next();
                        arrayList4 = arrayList5;
                        list = list4;
                        list2 = list3;
                        if (xmlPullParser.getDepth() >= depth) {
                        }
                        arrayList3 = arrayList4;
                        arrayList = list2;
                        objectRef2 = objectRef7;
                        objectRef = objectRef6;
                        arrayList2 = list;
                        objectRef4 = objectRef5;
                        if (z) {
                        }
                        return new VastLinearDto((VastOffset) objectRef.element, (VastAdParametersDto) objectRef2.element, (Long) objectRef3.element, arrayList, arrayList2, (VastVideoClicksDto) objectRef4.element, arrayList3);
                    case 6:
                        i = vastParserKt$parseLinearTag$1.I$0;
                        z = vastParserKt$parseLinearTag$1.Z$0;
                        ?? r2 = (List) vastParserKt$parseLinearTag$1.L$8;
                        xmlPullParser2 = (XmlPullParser) vastParserKt$parseLinearTag$1.L$7;
                        r5 = (List) vastParserKt$parseLinearTag$1.L$6;
                        objectRef5 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$5;
                        List list9 = (List) vastParserKt$parseLinearTag$1.L$4;
                        List list10 = (List) vastParserKt$parseLinearTag$1.L$3;
                        objectRef8 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$2;
                        objectRef7 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$1;
                        objectRef6 = (Ref.ObjectRef) vastParserKt$parseLinearTag$1.L$0;
                        ResultKt.throwOnFailure(r15);
                        arrayList6 = r2;
                        list = list9;
                        list2 = list10;
                        obj2 = r15;
                        arrayList6.addAll((Collection) obj2);
                        Ref.ObjectRef objectRef1122222222222 = objectRef8;
                        depth = i;
                        xmlPullParser = xmlPullParser2;
                        objectRef3 = objectRef1122222222222;
                        arrayList5 = r5;
                        list4 = list;
                        list3 = list2;
                        xmlPullParser.next();
                        arrayList4 = arrayList5;
                        list = list4;
                        list2 = list3;
                        if (xmlPullParser.getDepth() >= depth) {
                        }
                        arrayList3 = arrayList4;
                        arrayList = list2;
                        objectRef2 = objectRef7;
                        objectRef = objectRef6;
                        arrayList2 = list;
                        objectRef4 = objectRef5;
                        if (z) {
                        }
                        return new VastLinearDto((VastOffset) objectRef.element, (VastAdParametersDto) objectRef2.element, (Long) objectRef3.element, arrayList, arrayList2, (VastVideoClicksDto) objectRef4.element, arrayList3);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        vastParserKt$parseLinearTag$1 = new VastParserKt$parseLinearTag$1(continuation);
        ?? r152 = vastParserKt$parseLinearTag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (vastParserKt$parseLinearTag$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0623, code lost:
    
        if (isEndTag(r21) != false) goto L151;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:21:0x02fa, B:102:0x05ad], limit reached: 154 */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x064c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x065f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0666  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0690 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0662  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0654  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0561  */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v29, types: [T] */
    /* JADX WARN: Type inference failed for: r0v44, types: [T] */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r0v67 */
    /* JADX WARN: Type inference failed for: r2v31, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35, types: [T] */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39, types: [T] */
    /* JADX WARN: Type inference failed for: r2v41, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v43, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v61, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v97 */
    /* JADX WARN: Type inference failed for: r2v98 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v18, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v28, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Type inference failed for: r6v41 */
    /* JADX WARN: Type inference failed for: r6v42 */
    /* JADX WARN: Type inference failed for: r6v43 */
    /* JADX WARN: Type inference failed for: r6v44 */
    /* JADX WARN: Type inference failed for: r6v45 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v15, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v18, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v41, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0626 -> B:16:0x0628). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x043e -> B:15:0x0445). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x039f -> B:12:0x03a4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x03f9 -> B:16:0x0628). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x04b7 -> B:16:0x0628). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x05a3 -> B:16:0x0628). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object parseCompanionTag(XmlPullParser xmlPullParser, Continuation<? super VastCompanionDto> continuation) {
        VastParserKt$parseCompanionTag$1 vastParserKt$parseCompanionTag$1;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        Ref.ObjectRef objectRef6;
        Ref.ObjectRef objectRef7;
        ArrayList arrayList;
        ArrayList arrayList2;
        Ref.ObjectRef objectRef8;
        ArrayList arrayList3;
        Ref.ObjectRef objectRef9;
        ?? r6;
        Ref.ObjectRef objectRef10;
        Ref.ObjectRef objectRef11;
        Ref.ObjectRef objectRef12;
        ArrayList arrayList4;
        Ref.ObjectRef objectRef13;
        Ref.ObjectRef objectRef14;
        int depth;
        Ref.ObjectRef objectRef15;
        Ref.ObjectRef objectRef16;
        XmlPullParser xmlPullParser2;
        List list;
        ?? r62;
        Ref.ObjectRef objectRef17;
        Ref.ObjectRef objectRef18;
        Ref.ObjectRef objectRef19;
        Ref.ObjectRef objectRef20;
        Object obj;
        XmlPullParser xmlPullParser3;
        Object obj2;
        Object obj3;
        Object obj4;
        XmlPullParser xmlPullParser4;
        ?? r0;
        Ref.ObjectRef objectRef21;
        Ref.ObjectRef objectRef22;
        XmlPullParser xmlPullParser5;
        ?? r02;
        Ref.ObjectRef objectRef23;
        Ref.ObjectRef objectRef24;
        XmlPullParser xmlPullParser6;
        Object obj5;
        Ref.ObjectRef objectRef25;
        List list2;
        ArrayList arrayList5;
        VastResource.IFrame iFrame;
        VastResource vastResource;
        VastResource.Html html;
        XmlPullParser xmlPullParser7;
        String text;
        Object obj6;
        ArrayList arrayList6;
        List list3;
        String str;
        if (continuation instanceof VastParserKt$parseCompanionTag$1) {
            vastParserKt$parseCompanionTag$1 = (VastParserKt$parseCompanionTag$1) continuation;
            if ((vastParserKt$parseCompanionTag$1.label & Integer.MIN_VALUE) != 0) {
                vastParserKt$parseCompanionTag$1.label -= Integer.MIN_VALUE;
                ?? r03 = vastParserKt$parseCompanionTag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (vastParserKt$parseCompanionTag$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(r03);
                        objectRef = new Ref.ObjectRef();
                        objectRef2 = new Ref.ObjectRef();
                        objectRef3 = new Ref.ObjectRef();
                        objectRef4 = new Ref.ObjectRef();
                        objectRef5 = new Ref.ObjectRef();
                        objectRef6 = new Ref.ObjectRef();
                        objectRef7 = new Ref.ObjectRef();
                        arrayList = new ArrayList();
                        arrayList2 = new ArrayList();
                        objectRef8 = new Ref.ObjectRef();
                        arrayList3 = new ArrayList();
                        if (isStartDocument(xmlPullParser)) {
                            xmlPullParser.nextTag();
                        }
                        if (!isEndDocument(xmlPullParser)) {
                            if (!isStartTag(xmlPullParser)) {
                                throw new XmlPullParserException("allowed only for START_TAG");
                            }
                            objectRef9 = objectRef5;
                            r6 = arrayList3;
                            objectRef10 = objectRef6;
                            objectRef11 = objectRef8;
                            objectRef12 = objectRef7;
                            arrayList4 = arrayList2;
                            objectRef13 = objectRef2;
                            objectRef14 = objectRef3;
                            depth = xmlPullParser.getDepth();
                            objectRef15 = objectRef;
                            objectRef16 = objectRef4;
                            xmlPullParser2 = xmlPullParser;
                            if (xmlPullParser2.getDepth() >= depth) {
                                int depth2 = xmlPullParser2.getDepth() - depth;
                                if (depth2 != 0) {
                                    Object obj7 = coroutine_suspended;
                                    if (depth2 != 1) {
                                        xmlPullParser7 = xmlPullParser2;
                                        obj = obj7;
                                        xmlPullParser2 = xmlPullParser7;
                                        xmlPullParser2.next();
                                        coroutine_suspended = obj;
                                        r6 = r6;
                                        arrayList4 = arrayList4;
                                        if (xmlPullParser2.getDepth() >= depth) {
                                        }
                                    } else if (isStartTag(xmlPullParser2)) {
                                        String name = xmlPullParser2.getName();
                                        if (name != null) {
                                            switch (name.hashCode()) {
                                                case -1348833651:
                                                    if (name.equals("AdParameters")) {
                                                        vastParserKt$parseCompanionTag$1.L$0 = objectRef15;
                                                        vastParserKt$parseCompanionTag$1.L$1 = objectRef13;
                                                        vastParserKt$parseCompanionTag$1.L$2 = objectRef14;
                                                        vastParserKt$parseCompanionTag$1.L$3 = objectRef16;
                                                        vastParserKt$parseCompanionTag$1.L$4 = objectRef9;
                                                        vastParserKt$parseCompanionTag$1.L$5 = objectRef10;
                                                        vastParserKt$parseCompanionTag$1.L$6 = objectRef12;
                                                        vastParserKt$parseCompanionTag$1.L$7 = arrayList;
                                                        vastParserKt$parseCompanionTag$1.L$8 = arrayList4;
                                                        vastParserKt$parseCompanionTag$1.L$9 = objectRef11;
                                                        vastParserKt$parseCompanionTag$1.L$10 = r6;
                                                        vastParserKt$parseCompanionTag$1.L$11 = xmlPullParser2;
                                                        vastParserKt$parseCompanionTag$1.L$12 = objectRef12;
                                                        vastParserKt$parseCompanionTag$1.I$0 = depth;
                                                        vastParserKt$parseCompanionTag$1.label = 5;
                                                        Object parseAdParametersTag = parseAdParametersTag(xmlPullParser2, vastParserKt$parseCompanionTag$1);
                                                        obj = obj7;
                                                        if (parseAdParametersTag != obj) {
                                                            objectRef23 = objectRef15;
                                                            xmlPullParser5 = xmlPullParser2;
                                                            r02 = parseAdParametersTag;
                                                            objectRef24 = objectRef12;
                                                            r6 = r6;
                                                            arrayList4 = arrayList4;
                                                            objectRef12.element = r02;
                                                            objectRef12 = objectRef24;
                                                            xmlPullParser2 = xmlPullParser5;
                                                            objectRef15 = objectRef23;
                                                            xmlPullParser2.next();
                                                            coroutine_suspended = obj;
                                                            r6 = r6;
                                                            arrayList4 = arrayList4;
                                                            if (xmlPullParser2.getDepth() >= depth) {
                                                            }
                                                        }
                                                        return obj;
                                                    }
                                                    break;
                                                case -375340334:
                                                    if (name.equals("IFrameResource")) {
                                                        vastParserKt$parseCompanionTag$1.L$0 = objectRef15;
                                                        vastParserKt$parseCompanionTag$1.L$1 = objectRef13;
                                                        vastParserKt$parseCompanionTag$1.L$2 = objectRef14;
                                                        vastParserKt$parseCompanionTag$1.L$3 = objectRef16;
                                                        vastParserKt$parseCompanionTag$1.L$4 = objectRef9;
                                                        vastParserKt$parseCompanionTag$1.L$5 = objectRef10;
                                                        vastParserKt$parseCompanionTag$1.L$6 = objectRef12;
                                                        vastParserKt$parseCompanionTag$1.L$7 = arrayList;
                                                        vastParserKt$parseCompanionTag$1.L$8 = arrayList4;
                                                        vastParserKt$parseCompanionTag$1.L$9 = objectRef11;
                                                        vastParserKt$parseCompanionTag$1.L$10 = r6;
                                                        vastParserKt$parseCompanionTag$1.L$11 = xmlPullParser2;
                                                        vastParserKt$parseCompanionTag$1.L$12 = null;
                                                        vastParserKt$parseCompanionTag$1.I$0 = depth;
                                                        vastParserKt$parseCompanionTag$1.label = 3;
                                                        Object parseIFrameResourceTag = parseIFrameResourceTag(xmlPullParser2, vastParserKt$parseCompanionTag$1);
                                                        obj = obj7;
                                                        if (parseIFrameResourceTag != obj) {
                                                            xmlPullParser3 = xmlPullParser2;
                                                            obj4 = parseIFrameResourceTag;
                                                            Ref.ObjectRef objectRef26 = objectRef14;
                                                            objectRef20 = objectRef15;
                                                            list = r6;
                                                            r62 = arrayList4;
                                                            objectRef17 = objectRef12;
                                                            objectRef18 = objectRef9;
                                                            objectRef19 = objectRef26;
                                                            iFrame = (VastResource.IFrame) obj4;
                                                            if (iFrame != null) {
                                                                r62.add(iFrame);
                                                                Unit unit = Unit.INSTANCE;
                                                            }
                                                            ArrayList arrayList7 = r62;
                                                            r6 = list;
                                                            objectRef15 = objectRef20;
                                                            objectRef14 = objectRef19;
                                                            objectRef9 = objectRef18;
                                                            objectRef12 = objectRef17;
                                                            arrayList4 = arrayList7;
                                                            xmlPullParser2 = xmlPullParser3;
                                                            xmlPullParser2.next();
                                                            coroutine_suspended = obj;
                                                            r6 = r6;
                                                            arrayList4 = arrayList4;
                                                            if (xmlPullParser2.getDepth() >= depth) {
                                                            }
                                                        }
                                                        return obj;
                                                    }
                                                    break;
                                                case -348198615:
                                                    if (name.equals("CompanionClickThrough")) {
                                                        vastParserKt$parseCompanionTag$1.L$0 = objectRef15;
                                                        vastParserKt$parseCompanionTag$1.L$1 = objectRef13;
                                                        vastParserKt$parseCompanionTag$1.L$2 = objectRef14;
                                                        vastParserKt$parseCompanionTag$1.L$3 = objectRef16;
                                                        vastParserKt$parseCompanionTag$1.L$4 = objectRef9;
                                                        vastParserKt$parseCompanionTag$1.L$5 = objectRef10;
                                                        vastParserKt$parseCompanionTag$1.L$6 = objectRef12;
                                                        vastParserKt$parseCompanionTag$1.L$7 = arrayList;
                                                        vastParserKt$parseCompanionTag$1.L$8 = arrayList4;
                                                        vastParserKt$parseCompanionTag$1.L$9 = objectRef11;
                                                        vastParserKt$parseCompanionTag$1.L$10 = r6;
                                                        vastParserKt$parseCompanionTag$1.L$11 = xmlPullParser2;
                                                        vastParserKt$parseCompanionTag$1.L$12 = objectRef11;
                                                        vastParserKt$parseCompanionTag$1.I$0 = depth;
                                                        vastParserKt$parseCompanionTag$1.label = 7;
                                                        ?? parseTagsTextOnly = parseTagsTextOnly(xmlPullParser2, vastParserKt$parseCompanionTag$1);
                                                        obj = obj7;
                                                        if (parseTagsTextOnly != obj) {
                                                            XmlPullParser xmlPullParser8 = xmlPullParser2;
                                                            Ref.ObjectRef objectRef27 = objectRef13;
                                                            Ref.ObjectRef objectRef28 = objectRef14;
                                                            Ref.ObjectRef objectRef29 = objectRef16;
                                                            Ref.ObjectRef objectRef30 = objectRef9;
                                                            Ref.ObjectRef objectRef31 = objectRef10;
                                                            Ref.ObjectRef objectRef32 = objectRef12;
                                                            List list4 = arrayList;
                                                            ArrayList arrayList8 = arrayList4;
                                                            Ref.ObjectRef objectRef33 = objectRef11;
                                                            objectRef11.element = parseTagsTextOnly;
                                                            xmlPullParser2 = xmlPullParser8;
                                                            objectRef11 = objectRef33;
                                                            arrayList4 = arrayList8;
                                                            arrayList = list4;
                                                            objectRef12 = objectRef32;
                                                            objectRef10 = objectRef31;
                                                            objectRef9 = objectRef30;
                                                            objectRef16 = objectRef29;
                                                            objectRef14 = objectRef28;
                                                            objectRef13 = objectRef27;
                                                            xmlPullParser2.next();
                                                            coroutine_suspended = obj;
                                                            r6 = r6;
                                                            arrayList4 = arrayList4;
                                                            if (xmlPullParser2.getDepth() >= depth) {
                                                            }
                                                        }
                                                        return obj;
                                                    }
                                                    break;
                                                case 611554000:
                                                    if (name.equals("TrackingEvents")) {
                                                        vastParserKt$parseCompanionTag$1.L$0 = objectRef15;
                                                        vastParserKt$parseCompanionTag$1.L$1 = objectRef13;
                                                        vastParserKt$parseCompanionTag$1.L$2 = objectRef14;
                                                        vastParserKt$parseCompanionTag$1.L$3 = objectRef16;
                                                        vastParserKt$parseCompanionTag$1.L$4 = objectRef9;
                                                        vastParserKt$parseCompanionTag$1.L$5 = objectRef10;
                                                        vastParserKt$parseCompanionTag$1.L$6 = objectRef12;
                                                        vastParserKt$parseCompanionTag$1.L$7 = arrayList;
                                                        vastParserKt$parseCompanionTag$1.L$8 = arrayList4;
                                                        vastParserKt$parseCompanionTag$1.L$9 = objectRef11;
                                                        vastParserKt$parseCompanionTag$1.L$10 = r6;
                                                        vastParserKt$parseCompanionTag$1.L$11 = xmlPullParser2;
                                                        vastParserKt$parseCompanionTag$1.L$12 = arrayList;
                                                        vastParserKt$parseCompanionTag$1.I$0 = depth;
                                                        vastParserKt$parseCompanionTag$1.label = 6;
                                                        Object parseTrackingEventsTag = parseTrackingEventsTag(xmlPullParser2, vastParserKt$parseCompanionTag$1);
                                                        obj = obj7;
                                                        if (parseTrackingEventsTag != obj) {
                                                            objectRef25 = objectRef15;
                                                            xmlPullParser6 = xmlPullParser2;
                                                            obj5 = parseTrackingEventsTag;
                                                            list2 = arrayList;
                                                            r6 = r6;
                                                            arrayList4 = arrayList4;
                                                            Iterable iterable = (Iterable) obj5;
                                                            ArrayList arrayList9 = new ArrayList();
                                                            for (Object obj8 : iterable) {
                                                                VastParserKt$parseCompanionTag$1 vastParserKt$parseCompanionTag$12 = vastParserKt$parseCompanionTag$1;
                                                                List list5 = list2;
                                                                int i = depth;
                                                                if (((VastTracking) obj8).getEvent() == VastTrackingEvent.CreativeView) {
                                                                    arrayList9.add(obj8);
                                                                }
                                                                vastParserKt$parseCompanionTag$1 = vastParserKt$parseCompanionTag$12;
                                                                depth = i;
                                                                list2 = list5;
                                                            }
                                                            arrayList.addAll(arrayList9);
                                                            xmlPullParser2 = xmlPullParser6;
                                                            objectRef15 = objectRef25;
                                                            arrayList = list2;
                                                            xmlPullParser2.next();
                                                            coroutine_suspended = obj;
                                                            r6 = r6;
                                                            arrayList4 = arrayList4;
                                                            if (xmlPullParser2.getDepth() >= depth) {
                                                            }
                                                        }
                                                        return obj;
                                                    }
                                                    break;
                                                case 676623548:
                                                    if (name.equals("StaticResource")) {
                                                        vastParserKt$parseCompanionTag$1.L$0 = objectRef15;
                                                        vastParserKt$parseCompanionTag$1.L$1 = objectRef13;
                                                        vastParserKt$parseCompanionTag$1.L$2 = objectRef14;
                                                        vastParserKt$parseCompanionTag$1.L$3 = objectRef16;
                                                        vastParserKt$parseCompanionTag$1.L$4 = objectRef9;
                                                        vastParserKt$parseCompanionTag$1.L$5 = objectRef10;
                                                        vastParserKt$parseCompanionTag$1.L$6 = objectRef12;
                                                        vastParserKt$parseCompanionTag$1.L$7 = arrayList;
                                                        vastParserKt$parseCompanionTag$1.L$8 = arrayList4;
                                                        vastParserKt$parseCompanionTag$1.L$9 = objectRef11;
                                                        vastParserKt$parseCompanionTag$1.L$10 = r6;
                                                        vastParserKt$parseCompanionTag$1.L$11 = xmlPullParser2;
                                                        vastParserKt$parseCompanionTag$1.L$12 = null;
                                                        vastParserKt$parseCompanionTag$1.I$0 = depth;
                                                        vastParserKt$parseCompanionTag$1.label = 1;
                                                        Object parseStaticResourceTag = parseStaticResourceTag(xmlPullParser2, vastParserKt$parseCompanionTag$1);
                                                        obj = obj7;
                                                        if (parseStaticResourceTag != obj) {
                                                            xmlPullParser3 = xmlPullParser2;
                                                            obj2 = parseStaticResourceTag;
                                                            Ref.ObjectRef objectRef34 = objectRef14;
                                                            objectRef20 = objectRef15;
                                                            list = r6;
                                                            r62 = arrayList4;
                                                            objectRef17 = objectRef12;
                                                            objectRef18 = objectRef9;
                                                            objectRef19 = objectRef34;
                                                            vastResource = (VastResource) obj2;
                                                            if (vastResource != null) {
                                                                r62.add(vastResource);
                                                                Unit unit2 = Unit.INSTANCE;
                                                            }
                                                            ArrayList arrayList72 = r62;
                                                            r6 = list;
                                                            objectRef15 = objectRef20;
                                                            objectRef14 = objectRef19;
                                                            objectRef9 = objectRef18;
                                                            objectRef12 = objectRef17;
                                                            arrayList4 = arrayList72;
                                                            xmlPullParser2 = xmlPullParser3;
                                                            xmlPullParser2.next();
                                                            coroutine_suspended = obj;
                                                            r6 = r6;
                                                            arrayList4 = arrayList4;
                                                            if (xmlPullParser2.getDepth() >= depth) {
                                                            }
                                                        }
                                                        return obj;
                                                    }
                                                    obj = obj7;
                                                    xmlPullParser2.next();
                                                    coroutine_suspended = obj;
                                                    r6 = r6;
                                                    arrayList4 = arrayList4;
                                                    if (xmlPullParser2.getDepth() >= depth) {
                                                    }
                                                    break;
                                                case 759877206:
                                                    if (name.equals("AltText")) {
                                                        vastParserKt$parseCompanionTag$1.L$0 = objectRef15;
                                                        vastParserKt$parseCompanionTag$1.L$1 = objectRef13;
                                                        vastParserKt$parseCompanionTag$1.L$2 = objectRef14;
                                                        vastParserKt$parseCompanionTag$1.L$3 = objectRef16;
                                                        vastParserKt$parseCompanionTag$1.L$4 = objectRef9;
                                                        vastParserKt$parseCompanionTag$1.L$5 = objectRef10;
                                                        vastParserKt$parseCompanionTag$1.L$6 = objectRef12;
                                                        vastParserKt$parseCompanionTag$1.L$7 = arrayList;
                                                        vastParserKt$parseCompanionTag$1.L$8 = arrayList4;
                                                        vastParserKt$parseCompanionTag$1.L$9 = objectRef11;
                                                        vastParserKt$parseCompanionTag$1.L$10 = r6;
                                                        vastParserKt$parseCompanionTag$1.L$11 = xmlPullParser2;
                                                        vastParserKt$parseCompanionTag$1.L$12 = objectRef9;
                                                        vastParserKt$parseCompanionTag$1.I$0 = depth;
                                                        vastParserKt$parseCompanionTag$1.label = 4;
                                                        Object parseTagsTextOnly2 = parseTagsTextOnly(xmlPullParser2, vastParserKt$parseCompanionTag$1);
                                                        obj = obj7;
                                                        if (parseTagsTextOnly2 != obj) {
                                                            objectRef21 = objectRef15;
                                                            xmlPullParser4 = xmlPullParser2;
                                                            r0 = parseTagsTextOnly2;
                                                            objectRef22 = objectRef9;
                                                            r6 = r6;
                                                            arrayList4 = arrayList4;
                                                            objectRef9.element = r0;
                                                            objectRef9 = objectRef22;
                                                            xmlPullParser2 = xmlPullParser4;
                                                            objectRef15 = objectRef21;
                                                            xmlPullParser2.next();
                                                            coroutine_suspended = obj;
                                                            r6 = r6;
                                                            arrayList4 = arrayList4;
                                                            if (xmlPullParser2.getDepth() >= depth) {
                                                            }
                                                        }
                                                        return obj;
                                                    }
                                                    break;
                                                case 1877773523:
                                                    if (name.equals("CompanionClickTracking")) {
                                                        vastParserKt$parseCompanionTag$1.L$0 = objectRef15;
                                                        vastParserKt$parseCompanionTag$1.L$1 = objectRef13;
                                                        vastParserKt$parseCompanionTag$1.L$2 = objectRef14;
                                                        vastParserKt$parseCompanionTag$1.L$3 = objectRef16;
                                                        vastParserKt$parseCompanionTag$1.L$4 = objectRef9;
                                                        vastParserKt$parseCompanionTag$1.L$5 = objectRef10;
                                                        vastParserKt$parseCompanionTag$1.L$6 = objectRef12;
                                                        vastParserKt$parseCompanionTag$1.L$7 = arrayList;
                                                        vastParserKt$parseCompanionTag$1.L$8 = arrayList4;
                                                        vastParserKt$parseCompanionTag$1.L$9 = objectRef11;
                                                        vastParserKt$parseCompanionTag$1.L$10 = r6;
                                                        vastParserKt$parseCompanionTag$1.L$11 = xmlPullParser2;
                                                        vastParserKt$parseCompanionTag$1.L$12 = null;
                                                        vastParserKt$parseCompanionTag$1.I$0 = depth;
                                                        vastParserKt$parseCompanionTag$1.label = 8;
                                                        Object parseTagsTextOnly3 = parseTagsTextOnly(xmlPullParser2, vastParserKt$parseCompanionTag$1);
                                                        obj = obj7;
                                                        if (parseTagsTextOnly3 != obj) {
                                                            xmlPullParser3 = xmlPullParser2;
                                                            obj6 = parseTagsTextOnly3;
                                                            list3 = r6;
                                                            arrayList6 = arrayList4;
                                                            str = (String) obj6;
                                                            r6 = list3;
                                                            arrayList4 = arrayList6;
                                                            if (str != null) {
                                                                list3.add(str);
                                                                Unit unit3 = Unit.INSTANCE;
                                                                r6 = list3;
                                                                arrayList4 = arrayList6;
                                                            }
                                                            xmlPullParser2 = xmlPullParser3;
                                                            xmlPullParser2.next();
                                                            coroutine_suspended = obj;
                                                            r6 = r6;
                                                            arrayList4 = arrayList4;
                                                            if (xmlPullParser2.getDepth() >= depth) {
                                                            }
                                                        }
                                                        return obj;
                                                    }
                                                    break;
                                                case 1928285401:
                                                    if (name.equals("HTMLResource")) {
                                                        vastParserKt$parseCompanionTag$1.L$0 = objectRef15;
                                                        vastParserKt$parseCompanionTag$1.L$1 = objectRef13;
                                                        vastParserKt$parseCompanionTag$1.L$2 = objectRef14;
                                                        vastParserKt$parseCompanionTag$1.L$3 = objectRef16;
                                                        vastParserKt$parseCompanionTag$1.L$4 = objectRef9;
                                                        vastParserKt$parseCompanionTag$1.L$5 = objectRef10;
                                                        vastParserKt$parseCompanionTag$1.L$6 = objectRef12;
                                                        vastParserKt$parseCompanionTag$1.L$7 = arrayList;
                                                        vastParserKt$parseCompanionTag$1.L$8 = arrayList4;
                                                        vastParserKt$parseCompanionTag$1.L$9 = objectRef11;
                                                        vastParserKt$parseCompanionTag$1.L$10 = r6;
                                                        vastParserKt$parseCompanionTag$1.L$11 = xmlPullParser2;
                                                        vastParserKt$parseCompanionTag$1.L$12 = null;
                                                        vastParserKt$parseCompanionTag$1.I$0 = depth;
                                                        vastParserKt$parseCompanionTag$1.label = 2;
                                                        Object parseHtmlResourceTag = parseHtmlResourceTag(xmlPullParser2, vastParserKt$parseCompanionTag$1);
                                                        obj = obj7;
                                                        if (parseHtmlResourceTag != obj) {
                                                            xmlPullParser3 = xmlPullParser2;
                                                            obj3 = parseHtmlResourceTag;
                                                            Ref.ObjectRef objectRef35 = objectRef14;
                                                            objectRef20 = objectRef15;
                                                            list = r6;
                                                            r62 = arrayList4;
                                                            objectRef17 = objectRef12;
                                                            objectRef18 = objectRef9;
                                                            objectRef19 = objectRef35;
                                                            html = (VastResource.Html) obj3;
                                                            if (html != null) {
                                                                r62.add(html);
                                                                Unit unit4 = Unit.INSTANCE;
                                                            }
                                                            ArrayList arrayList722 = r62;
                                                            r6 = list;
                                                            objectRef15 = objectRef20;
                                                            objectRef14 = objectRef19;
                                                            objectRef9 = objectRef18;
                                                            objectRef12 = objectRef17;
                                                            arrayList4 = arrayList722;
                                                            xmlPullParser2 = xmlPullParser3;
                                                            xmlPullParser2.next();
                                                            coroutine_suspended = obj;
                                                            r6 = r6;
                                                            arrayList4 = arrayList4;
                                                            if (xmlPullParser2.getDepth() >= depth) {
                                                            }
                                                        }
                                                        return obj;
                                                    }
                                                    break;
                                            }
                                        }
                                        obj = obj7;
                                        xmlPullParser2.next();
                                        coroutine_suspended = obj;
                                        r6 = r6;
                                        arrayList4 = arrayList4;
                                        if (xmlPullParser2.getDepth() >= depth) {
                                        }
                                    } else {
                                        obj = obj7;
                                        xmlPullParser7 = xmlPullParser2;
                                        xmlPullParser2 = xmlPullParser7;
                                        xmlPullParser2.next();
                                        coroutine_suspended = obj;
                                        r6 = r6;
                                        arrayList4 = arrayList4;
                                        if (xmlPullParser2.getDepth() >= depth) {
                                        }
                                    }
                                } else {
                                    obj = coroutine_suspended;
                                    if (isStartTag(xmlPullParser2)) {
                                        objectRef15.element = attribute(xmlPullParser2, "id");
                                        String attribute = attribute(xmlPullParser2, "width");
                                        objectRef13.element = attribute != null ? StringsKt.toIntOrNull(attribute) : 0;
                                        String attribute2 = attribute(xmlPullParser2, "height");
                                        objectRef14.element = attribute2 != null ? StringsKt.toIntOrNull(attribute2) : 0;
                                        objectRef16.element = attribute(xmlPullParser2, "type");
                                        objectRef10.element = attribute(xmlPullParser2, "apiFramework");
                                        xmlPullParser7 = xmlPullParser2;
                                        xmlPullParser2 = xmlPullParser7;
                                        xmlPullParser2.next();
                                        coroutine_suspended = obj;
                                        r6 = r6;
                                        arrayList4 = arrayList4;
                                        if (xmlPullParser2.getDepth() >= depth) {
                                        }
                                    } else {
                                        if (!isText(xmlPullParser2) || (text = xmlPullParser2.getText()) == null || StringsKt.isBlank(text)) {
                                            xmlPullParser7 = xmlPullParser2;
                                            break;
                                        } else {
                                            String text2 = xmlPullParser2.getText();
                                            xmlPullParser7 = xmlPullParser2;
                                            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                                            StringsKt.trim((CharSequence) text2).toString();
                                        }
                                        xmlPullParser2 = xmlPullParser7;
                                        xmlPullParser2.next();
                                        coroutine_suspended = obj;
                                        r6 = r6;
                                        arrayList4 = arrayList4;
                                        if (xmlPullParser2.getDepth() >= depth) {
                                        }
                                    }
                                }
                            }
                            Ref.ObjectRef objectRef36 = objectRef9;
                            arrayList3 = r6;
                            objectRef5 = objectRef36;
                            Ref.ObjectRef objectRef37 = objectRef10;
                            objectRef8 = objectRef11;
                            objectRef6 = objectRef37;
                            Ref.ObjectRef objectRef38 = objectRef12;
                            arrayList2 = arrayList4;
                            objectRef7 = objectRef38;
                            objectRef = objectRef15;
                            objectRef4 = objectRef16;
                            objectRef3 = objectRef14;
                            objectRef2 = objectRef13;
                        }
                        List list6 = arrayList;
                        String str2 = (String) objectRef8.element;
                        VastCompanionClicksDto vastCompanionClicksDto = str2 != null ? new VastCompanionClicksDto(str2, arrayList3) : null;
                        arrayList5 = !arrayList2.isEmpty() ? arrayList2 : null;
                        if (arrayList5 != null) {
                            return new VastCompanionDto((String) objectRef.element, (Integer) objectRef2.element, (Integer) objectRef3.element, (String) objectRef4.element, (String) objectRef5.element, (String) objectRef6.element, vastCompanionClicksDto, (VastAdParametersDto) objectRef7.element, list6, arrayList5);
                        }
                        return null;
                    case 1:
                        int i2 = vastParserKt$parseCompanionTag$1.I$0;
                        XmlPullParser xmlPullParser9 = (XmlPullParser) vastParserKt$parseCompanionTag$1.L$11;
                        list = (List) vastParserKt$parseCompanionTag$1.L$10;
                        Ref.ObjectRef objectRef39 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$9;
                        r62 = (List) vastParserKt$parseCompanionTag$1.L$8;
                        List list7 = (List) vastParserKt$parseCompanionTag$1.L$7;
                        objectRef17 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$6;
                        Ref.ObjectRef objectRef40 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$5;
                        objectRef18 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$4;
                        Ref.ObjectRef objectRef41 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$3;
                        objectRef19 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$2;
                        Ref.ObjectRef objectRef42 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$1;
                        objectRef20 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$0;
                        ResultKt.throwOnFailure(r03);
                        objectRef13 = objectRef42;
                        objectRef16 = objectRef41;
                        objectRef10 = objectRef40;
                        arrayList = list7;
                        objectRef11 = objectRef39;
                        obj = coroutine_suspended;
                        xmlPullParser3 = xmlPullParser9;
                        depth = i2;
                        obj2 = r03;
                        vastResource = (VastResource) obj2;
                        if (vastResource != null) {
                        }
                        ArrayList arrayList7222 = r62;
                        r6 = list;
                        objectRef15 = objectRef20;
                        objectRef14 = objectRef19;
                        objectRef9 = objectRef18;
                        objectRef12 = objectRef17;
                        arrayList4 = arrayList7222;
                        xmlPullParser2 = xmlPullParser3;
                        xmlPullParser2.next();
                        coroutine_suspended = obj;
                        r6 = r6;
                        arrayList4 = arrayList4;
                        if (xmlPullParser2.getDepth() >= depth) {
                        }
                        Ref.ObjectRef objectRef362 = objectRef9;
                        arrayList3 = r6;
                        objectRef5 = objectRef362;
                        Ref.ObjectRef objectRef372 = objectRef10;
                        objectRef8 = objectRef11;
                        objectRef6 = objectRef372;
                        Ref.ObjectRef objectRef382 = objectRef12;
                        arrayList2 = arrayList4;
                        objectRef7 = objectRef382;
                        objectRef = objectRef15;
                        objectRef4 = objectRef16;
                        objectRef3 = objectRef14;
                        objectRef2 = objectRef13;
                        List list62 = arrayList;
                        String str22 = (String) objectRef8.element;
                        if (str22 != null) {
                        }
                        if (!arrayList2.isEmpty()) {
                        }
                        if (arrayList5 != null) {
                        }
                        break;
                    case 2:
                        int i3 = vastParserKt$parseCompanionTag$1.I$0;
                        XmlPullParser xmlPullParser10 = (XmlPullParser) vastParserKt$parseCompanionTag$1.L$11;
                        list = (List) vastParserKt$parseCompanionTag$1.L$10;
                        Ref.ObjectRef objectRef43 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$9;
                        r62 = (List) vastParserKt$parseCompanionTag$1.L$8;
                        List list8 = (List) vastParserKt$parseCompanionTag$1.L$7;
                        objectRef17 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$6;
                        Ref.ObjectRef objectRef44 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$5;
                        objectRef18 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$4;
                        Ref.ObjectRef objectRef45 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$3;
                        objectRef19 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$2;
                        Ref.ObjectRef objectRef46 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$1;
                        objectRef20 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$0;
                        ResultKt.throwOnFailure(r03);
                        objectRef13 = objectRef46;
                        objectRef16 = objectRef45;
                        objectRef10 = objectRef44;
                        arrayList = list8;
                        objectRef11 = objectRef43;
                        obj = coroutine_suspended;
                        xmlPullParser3 = xmlPullParser10;
                        depth = i3;
                        obj3 = r03;
                        html = (VastResource.Html) obj3;
                        if (html != null) {
                        }
                        ArrayList arrayList72222 = r62;
                        r6 = list;
                        objectRef15 = objectRef20;
                        objectRef14 = objectRef19;
                        objectRef9 = objectRef18;
                        objectRef12 = objectRef17;
                        arrayList4 = arrayList72222;
                        xmlPullParser2 = xmlPullParser3;
                        xmlPullParser2.next();
                        coroutine_suspended = obj;
                        r6 = r6;
                        arrayList4 = arrayList4;
                        if (xmlPullParser2.getDepth() >= depth) {
                        }
                        Ref.ObjectRef objectRef3622 = objectRef9;
                        arrayList3 = r6;
                        objectRef5 = objectRef3622;
                        Ref.ObjectRef objectRef3722 = objectRef10;
                        objectRef8 = objectRef11;
                        objectRef6 = objectRef3722;
                        Ref.ObjectRef objectRef3822 = objectRef12;
                        arrayList2 = arrayList4;
                        objectRef7 = objectRef3822;
                        objectRef = objectRef15;
                        objectRef4 = objectRef16;
                        objectRef3 = objectRef14;
                        objectRef2 = objectRef13;
                        List list622 = arrayList;
                        String str222 = (String) objectRef8.element;
                        if (str222 != null) {
                        }
                        if (!arrayList2.isEmpty()) {
                        }
                        if (arrayList5 != null) {
                        }
                        break;
                    case 3:
                        int i4 = vastParserKt$parseCompanionTag$1.I$0;
                        XmlPullParser xmlPullParser11 = (XmlPullParser) vastParserKt$parseCompanionTag$1.L$11;
                        list = (List) vastParserKt$parseCompanionTag$1.L$10;
                        Ref.ObjectRef objectRef47 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$9;
                        r62 = (List) vastParserKt$parseCompanionTag$1.L$8;
                        List list9 = (List) vastParserKt$parseCompanionTag$1.L$7;
                        objectRef17 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$6;
                        Ref.ObjectRef objectRef48 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$5;
                        objectRef18 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$4;
                        Ref.ObjectRef objectRef49 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$3;
                        objectRef19 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$2;
                        Ref.ObjectRef objectRef50 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$1;
                        objectRef20 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$0;
                        ResultKt.throwOnFailure(r03);
                        objectRef13 = objectRef50;
                        objectRef16 = objectRef49;
                        objectRef10 = objectRef48;
                        arrayList = list9;
                        objectRef11 = objectRef47;
                        obj = coroutine_suspended;
                        xmlPullParser3 = xmlPullParser11;
                        depth = i4;
                        obj4 = r03;
                        iFrame = (VastResource.IFrame) obj4;
                        if (iFrame != null) {
                        }
                        ArrayList arrayList722222 = r62;
                        r6 = list;
                        objectRef15 = objectRef20;
                        objectRef14 = objectRef19;
                        objectRef9 = objectRef18;
                        objectRef12 = objectRef17;
                        arrayList4 = arrayList722222;
                        xmlPullParser2 = xmlPullParser3;
                        xmlPullParser2.next();
                        coroutine_suspended = obj;
                        r6 = r6;
                        arrayList4 = arrayList4;
                        if (xmlPullParser2.getDepth() >= depth) {
                        }
                        Ref.ObjectRef objectRef36222 = objectRef9;
                        arrayList3 = r6;
                        objectRef5 = objectRef36222;
                        Ref.ObjectRef objectRef37222 = objectRef10;
                        objectRef8 = objectRef11;
                        objectRef6 = objectRef37222;
                        Ref.ObjectRef objectRef38222 = objectRef12;
                        arrayList2 = arrayList4;
                        objectRef7 = objectRef38222;
                        objectRef = objectRef15;
                        objectRef4 = objectRef16;
                        objectRef3 = objectRef14;
                        objectRef2 = objectRef13;
                        List list6222 = arrayList;
                        String str2222 = (String) objectRef8.element;
                        if (str2222 != null) {
                        }
                        if (!arrayList2.isEmpty()) {
                        }
                        if (arrayList5 != null) {
                        }
                        break;
                    case 4:
                        int i5 = vastParserKt$parseCompanionTag$1.I$0;
                        Ref.ObjectRef objectRef51 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$12;
                        xmlPullParser4 = (XmlPullParser) vastParserKt$parseCompanionTag$1.L$11;
                        List list10 = (List) vastParserKt$parseCompanionTag$1.L$10;
                        Ref.ObjectRef objectRef52 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$9;
                        ?? r7 = (List) vastParserKt$parseCompanionTag$1.L$8;
                        List list11 = (List) vastParserKt$parseCompanionTag$1.L$7;
                        Ref.ObjectRef objectRef53 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$6;
                        Ref.ObjectRef objectRef54 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$5;
                        Ref.ObjectRef objectRef55 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$4;
                        Ref.ObjectRef objectRef56 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$3;
                        Ref.ObjectRef objectRef57 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$2;
                        Ref.ObjectRef objectRef58 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$1;
                        Ref.ObjectRef objectRef59 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$0;
                        ResultKt.throwOnFailure(r03);
                        depth = i5;
                        r0 = r03;
                        objectRef21 = objectRef59;
                        objectRef13 = objectRef58;
                        objectRef14 = objectRef57;
                        objectRef16 = objectRef56;
                        objectRef9 = objectRef51;
                        obj = coroutine_suspended;
                        objectRef22 = objectRef55;
                        objectRef10 = objectRef54;
                        objectRef12 = objectRef53;
                        arrayList = list11;
                        arrayList4 = r7;
                        objectRef11 = objectRef52;
                        r6 = list10;
                        objectRef9.element = r0;
                        objectRef9 = objectRef22;
                        xmlPullParser2 = xmlPullParser4;
                        objectRef15 = objectRef21;
                        xmlPullParser2.next();
                        coroutine_suspended = obj;
                        r6 = r6;
                        arrayList4 = arrayList4;
                        if (xmlPullParser2.getDepth() >= depth) {
                        }
                        Ref.ObjectRef objectRef362222 = objectRef9;
                        arrayList3 = r6;
                        objectRef5 = objectRef362222;
                        Ref.ObjectRef objectRef372222 = objectRef10;
                        objectRef8 = objectRef11;
                        objectRef6 = objectRef372222;
                        Ref.ObjectRef objectRef382222 = objectRef12;
                        arrayList2 = arrayList4;
                        objectRef7 = objectRef382222;
                        objectRef = objectRef15;
                        objectRef4 = objectRef16;
                        objectRef3 = objectRef14;
                        objectRef2 = objectRef13;
                        List list62222 = arrayList;
                        String str22222 = (String) objectRef8.element;
                        if (str22222 != null) {
                        }
                        if (!arrayList2.isEmpty()) {
                        }
                        if (arrayList5 != null) {
                        }
                        break;
                    case 5:
                        int i6 = vastParserKt$parseCompanionTag$1.I$0;
                        Ref.ObjectRef objectRef60 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$12;
                        xmlPullParser5 = (XmlPullParser) vastParserKt$parseCompanionTag$1.L$11;
                        List list12 = (List) vastParserKt$parseCompanionTag$1.L$10;
                        Ref.ObjectRef objectRef61 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$9;
                        ?? r72 = (List) vastParserKt$parseCompanionTag$1.L$8;
                        List list13 = (List) vastParserKt$parseCompanionTag$1.L$7;
                        Ref.ObjectRef objectRef62 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$6;
                        Ref.ObjectRef objectRef63 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$5;
                        Ref.ObjectRef objectRef64 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$4;
                        Ref.ObjectRef objectRef65 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$3;
                        Ref.ObjectRef objectRef66 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$2;
                        Ref.ObjectRef objectRef67 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$1;
                        Ref.ObjectRef objectRef68 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$0;
                        ResultKt.throwOnFailure(r03);
                        depth = i6;
                        r02 = r03;
                        objectRef23 = objectRef68;
                        objectRef13 = objectRef67;
                        objectRef14 = objectRef66;
                        objectRef16 = objectRef65;
                        objectRef9 = objectRef64;
                        objectRef10 = objectRef63;
                        objectRef12 = objectRef60;
                        obj = coroutine_suspended;
                        objectRef24 = objectRef62;
                        arrayList = list13;
                        arrayList4 = r72;
                        objectRef11 = objectRef61;
                        r6 = list12;
                        objectRef12.element = r02;
                        objectRef12 = objectRef24;
                        xmlPullParser2 = xmlPullParser5;
                        objectRef15 = objectRef23;
                        xmlPullParser2.next();
                        coroutine_suspended = obj;
                        r6 = r6;
                        arrayList4 = arrayList4;
                        if (xmlPullParser2.getDepth() >= depth) {
                        }
                        Ref.ObjectRef objectRef3622222 = objectRef9;
                        arrayList3 = r6;
                        objectRef5 = objectRef3622222;
                        Ref.ObjectRef objectRef3722222 = objectRef10;
                        objectRef8 = objectRef11;
                        objectRef6 = objectRef3722222;
                        Ref.ObjectRef objectRef3822222 = objectRef12;
                        arrayList2 = arrayList4;
                        objectRef7 = objectRef3822222;
                        objectRef = objectRef15;
                        objectRef4 = objectRef16;
                        objectRef3 = objectRef14;
                        objectRef2 = objectRef13;
                        List list622222 = arrayList;
                        String str222222 = (String) objectRef8.element;
                        if (str222222 != null) {
                        }
                        if (!arrayList2.isEmpty()) {
                        }
                        if (arrayList5 != null) {
                        }
                        break;
                    case 6:
                        int i7 = vastParserKt$parseCompanionTag$1.I$0;
                        List list14 = (List) vastParserKt$parseCompanionTag$1.L$12;
                        xmlPullParser6 = (XmlPullParser) vastParserKt$parseCompanionTag$1.L$11;
                        List list15 = (List) vastParserKt$parseCompanionTag$1.L$10;
                        Ref.ObjectRef objectRef69 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$9;
                        ?? r73 = (List) vastParserKt$parseCompanionTag$1.L$8;
                        List list16 = (List) vastParserKt$parseCompanionTag$1.L$7;
                        Ref.ObjectRef objectRef70 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$6;
                        Ref.ObjectRef objectRef71 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$5;
                        Ref.ObjectRef objectRef72 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$4;
                        Ref.ObjectRef objectRef73 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$3;
                        Ref.ObjectRef objectRef74 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$2;
                        Ref.ObjectRef objectRef75 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$1;
                        Ref.ObjectRef objectRef76 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$0;
                        ResultKt.throwOnFailure(r03);
                        depth = i7;
                        obj5 = r03;
                        objectRef25 = objectRef76;
                        objectRef13 = objectRef75;
                        objectRef14 = objectRef74;
                        objectRef16 = objectRef73;
                        objectRef9 = objectRef72;
                        objectRef10 = objectRef71;
                        objectRef12 = objectRef70;
                        arrayList = list14;
                        obj = coroutine_suspended;
                        list2 = list16;
                        arrayList4 = r73;
                        objectRef11 = objectRef69;
                        r6 = list15;
                        Iterable iterable2 = (Iterable) obj5;
                        ArrayList arrayList92 = new ArrayList();
                        while (r17.hasNext()) {
                        }
                        arrayList.addAll(arrayList92);
                        xmlPullParser2 = xmlPullParser6;
                        objectRef15 = objectRef25;
                        arrayList = list2;
                        xmlPullParser2.next();
                        coroutine_suspended = obj;
                        r6 = r6;
                        arrayList4 = arrayList4;
                        if (xmlPullParser2.getDepth() >= depth) {
                        }
                        Ref.ObjectRef objectRef36222222 = objectRef9;
                        arrayList3 = r6;
                        objectRef5 = objectRef36222222;
                        Ref.ObjectRef objectRef37222222 = objectRef10;
                        objectRef8 = objectRef11;
                        objectRef6 = objectRef37222222;
                        Ref.ObjectRef objectRef38222222 = objectRef12;
                        arrayList2 = arrayList4;
                        objectRef7 = objectRef38222222;
                        objectRef = objectRef15;
                        objectRef4 = objectRef16;
                        objectRef3 = objectRef14;
                        objectRef2 = objectRef13;
                        List list6222222 = arrayList;
                        String str2222222 = (String) objectRef8.element;
                        if (str2222222 != null) {
                        }
                        if (!arrayList2.isEmpty()) {
                        }
                        if (arrayList5 != null) {
                        }
                        break;
                    case 7:
                        depth = vastParserKt$parseCompanionTag$1.I$0;
                        Ref.ObjectRef objectRef77 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$12;
                        XmlPullParser xmlPullParser12 = (XmlPullParser) vastParserKt$parseCompanionTag$1.L$11;
                        r6 = (List) vastParserKt$parseCompanionTag$1.L$10;
                        Ref.ObjectRef objectRef78 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$9;
                        ?? r8 = (List) vastParserKt$parseCompanionTag$1.L$8;
                        List list17 = (List) vastParserKt$parseCompanionTag$1.L$7;
                        Ref.ObjectRef objectRef79 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$6;
                        Ref.ObjectRef objectRef80 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$5;
                        Ref.ObjectRef objectRef81 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$4;
                        Ref.ObjectRef objectRef82 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$3;
                        Ref.ObjectRef objectRef83 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$2;
                        Ref.ObjectRef objectRef84 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$1;
                        Ref.ObjectRef objectRef85 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$0;
                        ResultKt.throwOnFailure(r03);
                        objectRef15 = objectRef85;
                        obj = coroutine_suspended;
                        objectRef77.element = r03;
                        xmlPullParser2 = xmlPullParser12;
                        objectRef11 = objectRef78;
                        arrayList4 = r8;
                        arrayList = list17;
                        objectRef12 = objectRef79;
                        objectRef10 = objectRef80;
                        objectRef9 = objectRef81;
                        objectRef16 = objectRef82;
                        objectRef14 = objectRef83;
                        objectRef13 = objectRef84;
                        xmlPullParser2.next();
                        coroutine_suspended = obj;
                        r6 = r6;
                        arrayList4 = arrayList4;
                        if (xmlPullParser2.getDepth() >= depth) {
                        }
                        Ref.ObjectRef objectRef362222222 = objectRef9;
                        arrayList3 = r6;
                        objectRef5 = objectRef362222222;
                        Ref.ObjectRef objectRef372222222 = objectRef10;
                        objectRef8 = objectRef11;
                        objectRef6 = objectRef372222222;
                        Ref.ObjectRef objectRef382222222 = objectRef12;
                        arrayList2 = arrayList4;
                        objectRef7 = objectRef382222222;
                        objectRef = objectRef15;
                        objectRef4 = objectRef16;
                        objectRef3 = objectRef14;
                        objectRef2 = objectRef13;
                        List list62222222 = arrayList;
                        String str22222222 = (String) objectRef8.element;
                        if (str22222222 != null) {
                        }
                        if (!arrayList2.isEmpty()) {
                        }
                        if (arrayList5 != null) {
                        }
                        break;
                    case 8:
                        depth = vastParserKt$parseCompanionTag$1.I$0;
                        XmlPullParser xmlPullParser13 = (XmlPullParser) vastParserKt$parseCompanionTag$1.L$11;
                        List list18 = (List) vastParserKt$parseCompanionTag$1.L$10;
                        objectRef11 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$9;
                        ?? r82 = (List) vastParserKt$parseCompanionTag$1.L$8;
                        arrayList = (List) vastParserKt$parseCompanionTag$1.L$7;
                        objectRef12 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$6;
                        objectRef10 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$5;
                        objectRef9 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$4;
                        objectRef16 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$3;
                        objectRef14 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$2;
                        objectRef13 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$1;
                        objectRef15 = (Ref.ObjectRef) vastParserKt$parseCompanionTag$1.L$0;
                        ResultKt.throwOnFailure(r03);
                        obj = coroutine_suspended;
                        xmlPullParser3 = xmlPullParser13;
                        obj6 = r03;
                        list3 = list18;
                        arrayList6 = r82;
                        str = (String) obj6;
                        r6 = list3;
                        arrayList4 = arrayList6;
                        if (str != null) {
                        }
                        xmlPullParser2 = xmlPullParser3;
                        xmlPullParser2.next();
                        coroutine_suspended = obj;
                        r6 = r6;
                        arrayList4 = arrayList4;
                        if (xmlPullParser2.getDepth() >= depth) {
                        }
                        Ref.ObjectRef objectRef3622222222 = objectRef9;
                        arrayList3 = r6;
                        objectRef5 = objectRef3622222222;
                        Ref.ObjectRef objectRef3722222222 = objectRef10;
                        objectRef8 = objectRef11;
                        objectRef6 = objectRef3722222222;
                        Ref.ObjectRef objectRef3822222222 = objectRef12;
                        arrayList2 = arrayList4;
                        objectRef7 = objectRef3822222222;
                        objectRef = objectRef15;
                        objectRef4 = objectRef16;
                        objectRef3 = objectRef14;
                        objectRef2 = objectRef13;
                        List list622222222 = arrayList;
                        String str222222222 = (String) objectRef8.element;
                        if (str222222222 != null) {
                        }
                        if (!arrayList2.isEmpty()) {
                        }
                        if (arrayList5 != null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        vastParserKt$parseCompanionTag$1 = new VastParserKt$parseCompanionTag$1(continuation);
        ?? r032 = vastParserKt$parseCompanionTag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (vastParserKt$parseCompanionTag$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00dc, code lost:
    
        if (isEndTag(r7) != false) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006d -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0075 -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0084 -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0095 -> B:10:0x0098). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00a9 -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00c2 -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00dc -> B:14:0x00df). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object parseExtensionsTag(XmlPullParser xmlPullParser, Continuation<? super List<VastExtensionDto>> continuation) {
        VastParserKt$parseExtensionsTag$1 vastParserKt$parseExtensionsTag$1;
        int i;
        int depth;
        List list;
        String text;
        if (continuation instanceof VastParserKt$parseExtensionsTag$1) {
            vastParserKt$parseExtensionsTag$1 = (VastParserKt$parseExtensionsTag$1) continuation;
            if ((vastParserKt$parseExtensionsTag$1.label & Integer.MIN_VALUE) != 0) {
                vastParserKt$parseExtensionsTag$1.label -= Integer.MIN_VALUE;
                Object obj = vastParserKt$parseExtensionsTag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = vastParserKt$parseExtensionsTag$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ArrayList arrayList = new ArrayList();
                    if (isStartDocument(xmlPullParser)) {
                        xmlPullParser.nextTag();
                    }
                    if (isEndDocument(xmlPullParser)) {
                        return arrayList;
                    }
                    if (!isStartTag(xmlPullParser)) {
                        throw new XmlPullParserException("allowed only for START_TAG");
                    }
                    depth = xmlPullParser.getDepth();
                    list = arrayList;
                    if (xmlPullParser.getDepth() >= depth) {
                    }
                    return list;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = vastParserKt$parseExtensionsTag$1.I$0;
                XmlPullParser xmlPullParser2 = (XmlPullParser) vastParserKt$parseExtensionsTag$1.L$1;
                list = (List) vastParserKt$parseExtensionsTag$1.L$0;
                ResultKt.throwOnFailure(obj);
                VastExtensionDto vastExtensionDto = (VastExtensionDto) obj;
                if (vastExtensionDto != null) {
                    list.add(vastExtensionDto);
                }
                XmlPullParser xmlPullParser3 = xmlPullParser2;
                depth = i2;
                xmlPullParser = xmlPullParser3;
                xmlPullParser.next();
                if (xmlPullParser.getDepth() >= depth) {
                    int depth2 = xmlPullParser.getDepth() - depth;
                    if (depth2 == 0) {
                        if (!isStartTag(xmlPullParser)) {
                            if (isText(xmlPullParser) && (text = xmlPullParser.getText()) != null && !StringsKt.isBlank(text)) {
                                String text2 = xmlPullParser.getText();
                                Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                                StringsKt.trim((CharSequence) text2).toString();
                            }
                        }
                    } else if (depth2 == 1 && isStartTag(xmlPullParser) && Intrinsics.areEqual(xmlPullParser.getName(), "Extension")) {
                        vastParserKt$parseExtensionsTag$1.L$0 = list;
                        vastParserKt$parseExtensionsTag$1.L$1 = xmlPullParser;
                        vastParserKt$parseExtensionsTag$1.I$0 = depth;
                        vastParserKt$parseExtensionsTag$1.label = 1;
                        obj = parseExtensionTag(xmlPullParser, vastParserKt$parseExtensionsTag$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        int i3 = depth;
                        xmlPullParser2 = xmlPullParser;
                        i2 = i3;
                        VastExtensionDto vastExtensionDto2 = (VastExtensionDto) obj;
                        if (vastExtensionDto2 != null) {
                        }
                        XmlPullParser xmlPullParser32 = xmlPullParser2;
                        depth = i2;
                        xmlPullParser = xmlPullParser32;
                    }
                    xmlPullParser.next();
                    if (xmlPullParser.getDepth() >= depth) {
                    }
                }
                return list;
            }
        }
        vastParserKt$parseExtensionsTag$1 = new VastParserKt$parseExtensionsTag$1(continuation);
        Object obj2 = vastParserKt$parseExtensionsTag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = vastParserKt$parseExtensionsTag$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x010e, code lost:
    
        if (isEndTag(r10) != false) goto L64;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0127 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0081 -> B:18:0x0111). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0089 -> B:18:0x0111). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0098 -> B:18:0x0111). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00b3 -> B:10:0x00b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00db -> B:18:0x0111). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00f4 -> B:18:0x0111). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x010e -> B:18:0x0111). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object parseExtensionTag(XmlPullParser xmlPullParser, Continuation<? super VastExtensionDto> continuation) {
        VastParserKt$parseExtensionTag$1 vastParserKt$parseExtensionTag$1;
        int i;
        String attribute;
        ArrayList arrayList;
        int depth;
        String str;
        ArrayList arrayList2;
        String text;
        if (continuation instanceof VastParserKt$parseExtensionTag$1) {
            vastParserKt$parseExtensionTag$1 = (VastParserKt$parseExtensionTag$1) continuation;
            if ((vastParserKt$parseExtensionTag$1.label & Integer.MIN_VALUE) != 0) {
                vastParserKt$parseExtensionTag$1.label -= Integer.MIN_VALUE;
                Object obj = vastParserKt$parseExtensionTag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = vastParserKt$parseExtensionTag$1.label;
                if (i == 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i2 = vastParserKt$parseExtensionTag$1.I$0;
                    String attribute2 = (String) vastParserKt$parseExtensionTag$1.L$3;
                    XmlPullParser xmlPullParser2 = (XmlPullParser) vastParserKt$parseExtensionTag$1.L$2;
                    ?? r6 = (List) vastParserKt$parseExtensionTag$1.L$1;
                    str = (String) vastParserKt$parseExtensionTag$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    ArrayList arrayList3 = r6;
                    String str2 = (String) obj;
                    if (str2 != null || StringsKt.isBlank(str2)) {
                        str2 = null;
                    }
                    if (attribute2 != null && str2 != null) {
                        arrayList3.add(new VastCustomEventDto(attribute2, str2));
                    }
                    XmlPullParser xmlPullParser3 = xmlPullParser2;
                    depth = i2;
                    xmlPullParser = xmlPullParser3;
                    ArrayList arrayList4 = arrayList3;
                    xmlPullParser.next();
                    arrayList2 = arrayList4;
                    if (xmlPullParser.getDepth() >= depth) {
                        int depth2 = xmlPullParser.getDepth() - depth;
                        arrayList4 = arrayList2;
                        if (depth2 == 0) {
                            if (isStartTag(xmlPullParser)) {
                                arrayList4 = arrayList2;
                            } else if (!isText(xmlPullParser) || (text = xmlPullParser.getText()) == null || StringsKt.isBlank(text)) {
                                arrayList4 = arrayList2;
                            } else {
                                String text2 = xmlPullParser.getText();
                                Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                                StringsKt.trim((CharSequence) text2).toString();
                                arrayList4 = arrayList2;
                            }
                        } else if (depth2 == 1) {
                            arrayList4 = arrayList2;
                            if (isStartTag(xmlPullParser)) {
                                arrayList4 = arrayList2;
                                if (Intrinsics.areEqual(xmlPullParser.getName(), TAG_CUSTOM_EVENT)) {
                                    attribute2 = attribute(xmlPullParser, "name");
                                    vastParserKt$parseExtensionTag$1.L$0 = str;
                                    vastParserKt$parseExtensionTag$1.L$1 = arrayList2;
                                    vastParserKt$parseExtensionTag$1.L$2 = xmlPullParser;
                                    vastParserKt$parseExtensionTag$1.L$3 = attribute2;
                                    vastParserKt$parseExtensionTag$1.I$0 = depth;
                                    vastParserKt$parseExtensionTag$1.label = 1;
                                    obj = parseTagsTextOnly(xmlPullParser, vastParserKt$parseExtensionTag$1);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    int i3 = depth;
                                    xmlPullParser2 = xmlPullParser;
                                    i2 = i3;
                                    arrayList3 = arrayList2;
                                    String str22 = (String) obj;
                                    if (str22 != null) {
                                    }
                                    str22 = null;
                                    if (attribute2 != null) {
                                        arrayList3.add(new VastCustomEventDto(attribute2, str22));
                                    }
                                    XmlPullParser xmlPullParser32 = xmlPullParser2;
                                    depth = i2;
                                    xmlPullParser = xmlPullParser32;
                                    ArrayList arrayList42 = arrayList3;
                                }
                            }
                        }
                        xmlPullParser.next();
                        arrayList2 = arrayList42;
                        if (xmlPullParser.getDepth() >= depth) {
                        }
                    }
                    arrayList = arrayList2;
                    attribute = str;
                    if (arrayList.isEmpty()) {
                        return new VastExtensionDto(attribute, arrayList);
                    }
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                attribute = attribute(xmlPullParser, "type");
                if (attribute == null) {
                    return null;
                }
                arrayList = new ArrayList();
                if (isStartDocument(xmlPullParser)) {
                    xmlPullParser.nextTag();
                }
                if (!isEndDocument(xmlPullParser)) {
                    if (!isStartTag(xmlPullParser)) {
                        throw new XmlPullParserException("allowed only for START_TAG");
                    }
                    depth = xmlPullParser.getDepth();
                    str = attribute;
                    arrayList2 = arrayList;
                    if (xmlPullParser.getDepth() >= depth) {
                    }
                    arrayList = arrayList2;
                    attribute = str;
                }
                if (arrayList.isEmpty()) {
                }
            }
        }
        vastParserKt$parseExtensionTag$1 = new VastParserKt$parseExtensionTag$1(continuation);
        Object obj2 = vastParserKt$parseExtensionTag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = vastParserKt$parseExtensionTag$1.label;
        if (i == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VastOffset parseSkipOffsetAttribute(XmlPullParser xmlPullParser) {
        String attribute = attribute(xmlPullParser, VastAttributes.SKIP_OFFSET);
        if (attribute != null) {
            return toOffset(attribute);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VastOffset toOffset(String str) {
        Long millis = toMillis(str);
        if (millis != null) {
            return new VastOffset.Time(millis.longValue());
        }
        Integer percents = toPercents(str);
        if (percents != null) {
            return new VastOffset.Percents(percents.intValue());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long toMillis(String str) {
        Object m10241constructorimpl;
        Object m10241constructorimpl2;
        try {
            Result.Companion companion = Result.INSTANCE;
            Date parse = timeFormatterWithMillis().parse(str);
            m10241constructorimpl = Result.m10241constructorimpl(parse != null ? Long.valueOf(parse.getTime()) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = null;
        }
        Long l = (Long) m10241constructorimpl;
        if (l != null) {
            return l;
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            Date parse2 = timeFormatterWithoutMillis().parse(str);
            m10241constructorimpl2 = Result.m10241constructorimpl(parse2 != null ? Long.valueOf(parse2.getTime()) : null);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            m10241constructorimpl2 = Result.m10241constructorimpl(ResultKt.createFailure(th2));
        }
        return (Long) (Result.m10247isFailureimpl(m10241constructorimpl2) ? null : m10241constructorimpl2);
    }

    private static final SimpleDateFormat timeFormatterWithoutMillis() {
        return DateKt.createSimpleDateFormat("HH:mm:ss");
    }

    private static final SimpleDateFormat timeFormatterWithMillis() {
        return DateKt.createSimpleDateFormat("HH:mm:ss.SSS");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final Integer toPercents(String str) {
        Object m10241constructorimpl;
        Number parse;
        Integer num;
        try {
            Result.Companion companion = Result.INSTANCE;
            parse = percentageFormatter.parse(str);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (parse != null) {
            num = Integer.valueOf((int) (parse.floatValue() * 100));
            int intValue = num.intValue();
            if (intValue >= 0 && intValue < 101) {
                m10241constructorimpl = Result.m10241constructorimpl(num);
                return (Integer) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
            }
        }
        num = null;
        m10241constructorimpl = Result.m10241constructorimpl(num);
        return (Integer) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00dc, code lost:
    
        if (isEndTag(r7) != false) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006d -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0075 -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0084 -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0095 -> B:10:0x0098). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00a9 -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00c2 -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00dc -> B:14:0x00df). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object parseMediaFilesTag(XmlPullParser xmlPullParser, Continuation<? super List<VastMediaFileDto>> continuation) {
        VastParserKt$parseMediaFilesTag$1 vastParserKt$parseMediaFilesTag$1;
        int i;
        int depth;
        List list;
        String text;
        if (continuation instanceof VastParserKt$parseMediaFilesTag$1) {
            vastParserKt$parseMediaFilesTag$1 = (VastParserKt$parseMediaFilesTag$1) continuation;
            if ((vastParserKt$parseMediaFilesTag$1.label & Integer.MIN_VALUE) != 0) {
                vastParserKt$parseMediaFilesTag$1.label -= Integer.MIN_VALUE;
                Object obj = vastParserKt$parseMediaFilesTag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = vastParserKt$parseMediaFilesTag$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ArrayList arrayList = new ArrayList();
                    if (isStartDocument(xmlPullParser)) {
                        xmlPullParser.nextTag();
                    }
                    if (isEndDocument(xmlPullParser)) {
                        return arrayList;
                    }
                    if (!isStartTag(xmlPullParser)) {
                        throw new XmlPullParserException("allowed only for START_TAG");
                    }
                    depth = xmlPullParser.getDepth();
                    list = arrayList;
                    if (xmlPullParser.getDepth() >= depth) {
                    }
                    return list;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = vastParserKt$parseMediaFilesTag$1.I$0;
                XmlPullParser xmlPullParser2 = (XmlPullParser) vastParserKt$parseMediaFilesTag$1.L$1;
                list = (List) vastParserKt$parseMediaFilesTag$1.L$0;
                ResultKt.throwOnFailure(obj);
                VastMediaFileDto vastMediaFileDto = (VastMediaFileDto) obj;
                if (vastMediaFileDto != null) {
                    list.add(vastMediaFileDto);
                }
                XmlPullParser xmlPullParser3 = xmlPullParser2;
                depth = i2;
                xmlPullParser = xmlPullParser3;
                xmlPullParser.next();
                if (xmlPullParser.getDepth() >= depth) {
                    int depth2 = xmlPullParser.getDepth() - depth;
                    if (depth2 == 0) {
                        if (!isStartTag(xmlPullParser)) {
                            if (isText(xmlPullParser) && (text = xmlPullParser.getText()) != null && !StringsKt.isBlank(text)) {
                                String text2 = xmlPullParser.getText();
                                Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                                StringsKt.trim((CharSequence) text2).toString();
                            }
                        }
                    } else if (depth2 == 1 && isStartTag(xmlPullParser) && Intrinsics.areEqual(xmlPullParser.getName(), "MediaFile")) {
                        vastParserKt$parseMediaFilesTag$1.L$0 = list;
                        vastParserKt$parseMediaFilesTag$1.L$1 = xmlPullParser;
                        vastParserKt$parseMediaFilesTag$1.I$0 = depth;
                        vastParserKt$parseMediaFilesTag$1.label = 1;
                        obj = parseMediaFileTag(xmlPullParser, vastParserKt$parseMediaFilesTag$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        int i3 = depth;
                        xmlPullParser2 = xmlPullParser;
                        i2 = i3;
                        VastMediaFileDto vastMediaFileDto2 = (VastMediaFileDto) obj;
                        if (vastMediaFileDto2 != null) {
                        }
                        XmlPullParser xmlPullParser32 = xmlPullParser2;
                        depth = i2;
                        xmlPullParser = xmlPullParser32;
                    }
                    xmlPullParser.next();
                    if (xmlPullParser.getDepth() >= depth) {
                    }
                }
                return list;
            }
        }
        vastParserKt$parseMediaFilesTag$1 = new VastParserKt$parseMediaFilesTag$1(continuation);
        Object obj2 = vastParserKt$parseMediaFilesTag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = vastParserKt$parseMediaFilesTag$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00dc, code lost:
    
        if (isEndTag(r7) != false) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006d -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0075 -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0084 -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0095 -> B:10:0x0098). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00a9 -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00c2 -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00dc -> B:14:0x00df). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object parseTrackingEventsTag(XmlPullParser xmlPullParser, Continuation<? super List<VastTracking>> continuation) {
        VastParserKt$parseTrackingEventsTag$1 vastParserKt$parseTrackingEventsTag$1;
        int i;
        int depth;
        List list;
        String text;
        if (continuation instanceof VastParserKt$parseTrackingEventsTag$1) {
            vastParserKt$parseTrackingEventsTag$1 = (VastParserKt$parseTrackingEventsTag$1) continuation;
            if ((vastParserKt$parseTrackingEventsTag$1.label & Integer.MIN_VALUE) != 0) {
                vastParserKt$parseTrackingEventsTag$1.label -= Integer.MIN_VALUE;
                Object obj = vastParserKt$parseTrackingEventsTag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = vastParserKt$parseTrackingEventsTag$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ArrayList arrayList = new ArrayList();
                    if (isStartDocument(xmlPullParser)) {
                        xmlPullParser.nextTag();
                    }
                    if (isEndDocument(xmlPullParser)) {
                        return arrayList;
                    }
                    if (!isStartTag(xmlPullParser)) {
                        throw new XmlPullParserException("allowed only for START_TAG");
                    }
                    depth = xmlPullParser.getDepth();
                    list = arrayList;
                    if (xmlPullParser.getDepth() >= depth) {
                    }
                    return list;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = vastParserKt$parseTrackingEventsTag$1.I$0;
                XmlPullParser xmlPullParser2 = (XmlPullParser) vastParserKt$parseTrackingEventsTag$1.L$1;
                list = (List) vastParserKt$parseTrackingEventsTag$1.L$0;
                ResultKt.throwOnFailure(obj);
                VastTracking vastTracking = (VastTracking) obj;
                if (vastTracking != null) {
                    list.add(vastTracking);
                }
                XmlPullParser xmlPullParser3 = xmlPullParser2;
                depth = i2;
                xmlPullParser = xmlPullParser3;
                xmlPullParser.next();
                if (xmlPullParser.getDepth() >= depth) {
                    int depth2 = xmlPullParser.getDepth() - depth;
                    if (depth2 == 0) {
                        if (!isStartTag(xmlPullParser)) {
                            if (isText(xmlPullParser) && (text = xmlPullParser.getText()) != null && !StringsKt.isBlank(text)) {
                                String text2 = xmlPullParser.getText();
                                Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                                StringsKt.trim((CharSequence) text2).toString();
                            }
                        }
                    } else if (depth2 == 1 && isStartTag(xmlPullParser) && Intrinsics.areEqual(xmlPullParser.getName(), "Tracking")) {
                        vastParserKt$parseTrackingEventsTag$1.L$0 = list;
                        vastParserKt$parseTrackingEventsTag$1.L$1 = xmlPullParser;
                        vastParserKt$parseTrackingEventsTag$1.I$0 = depth;
                        vastParserKt$parseTrackingEventsTag$1.label = 1;
                        obj = parseTrackingTag(xmlPullParser, vastParserKt$parseTrackingEventsTag$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        int i3 = depth;
                        xmlPullParser2 = xmlPullParser;
                        i2 = i3;
                        VastTracking vastTracking2 = (VastTracking) obj;
                        if (vastTracking2 != null) {
                        }
                        XmlPullParser xmlPullParser32 = xmlPullParser2;
                        depth = i2;
                        xmlPullParser = xmlPullParser32;
                    }
                    xmlPullParser.next();
                    if (xmlPullParser.getDepth() >= depth) {
                    }
                }
                return list;
            }
        }
        vastParserKt$parseTrackingEventsTag$1 = new VastParserKt$parseTrackingEventsTag$1(continuation);
        Object obj2 = vastParserKt$parseTrackingEventsTag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = vastParserKt$parseTrackingEventsTag$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VastTrackingEvent toTrackingEvent(String str) {
        switch (str.hashCode()) {
            case -1638835128:
                if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT)) {
                    return VastTrackingEvent.Midpoint;
                }
                return null;
            case -1337830390:
                if (str.equals("thirdQuartile")) {
                    return VastTrackingEvent.ThirdQuartile;
                }
                return null;
            case -1001078227:
                if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                    return VastTrackingEvent.Progress;
                }
                return null;
            case -934426579:
                if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_RESUME)) {
                    return VastTrackingEvent.Resume;
                }
                return null;
            case -934318917:
                if (str.equals("rewind")) {
                    return VastTrackingEvent.Rewind;
                }
                return null;
            case -840405966:
                if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_UNMUTE)) {
                    return VastTrackingEvent.UnMute;
                }
                return null;
            case -599445191:
                if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE)) {
                    return VastTrackingEvent.Complete;
                }
                return null;
            case -37683395:
                if (str.equals("closeLinear")) {
                    return VastTrackingEvent.CloseLinear;
                }
                return null;
            case 3363353:
                if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_MUTE)) {
                    return VastTrackingEvent.Mute;
                }
                return null;
            case 3532159:
                if (str.equals("skip")) {
                    return VastTrackingEvent.Skip;
                }
                return null;
            case 106440182:
                if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_PAUSE)) {
                    return VastTrackingEvent.Pause;
                }
                return null;
            case 109757538:
                if (str.equals("start")) {
                    return VastTrackingEvent.Start;
                }
                return null;
            case 560220243:
                if (str.equals("firstQuartile")) {
                    return VastTrackingEvent.FirstQuartile;
                }
                return null;
            case 1778167540:
                if (str.equals("creativeView")) {
                    return VastTrackingEvent.CreativeView;
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01b3, code lost:
    
        if (isEndTag(r13) != false) goto L87;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Type inference failed for: r15v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v28, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00c1 -> B:15:0x01b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00c9 -> B:15:0x01b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00d2 -> B:15:0x01b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00e5 -> B:15:0x01b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00ef -> B:15:0x01b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0111 -> B:14:0x0116). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0113 -> B:14:0x0116). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0122 -> B:15:0x01b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x013d -> B:12:0x0141). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x014f -> B:15:0x01b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0180 -> B:15:0x01b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0199 -> B:15:0x01b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x01b3 -> B:15:0x01b6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object parseVideoClicksTag(XmlPullParser xmlPullParser, boolean z, Continuation<? super VastVideoClicksDto> continuation) {
        VastParserKt$parseVideoClicksTag$1 vastParserKt$parseVideoClicksTag$1;
        int i;
        Ref.ObjectRef objectRef;
        ArrayList arrayList;
        ArrayList arrayList2;
        int depth;
        Ref.ObjectRef objectRef2;
        Object obj;
        int i2;
        ArrayList arrayList3;
        XmlPullParser xmlPullParser2;
        VastVideoClickDto vastVideoClickDto;
        String text;
        String name;
        ArrayList arrayList4;
        if (continuation instanceof VastParserKt$parseVideoClicksTag$1) {
            vastParserKt$parseVideoClicksTag$1 = (VastParserKt$parseVideoClicksTag$1) continuation;
            if ((vastParserKt$parseVideoClicksTag$1.label & Integer.MIN_VALUE) != 0) {
                vastParserKt$parseVideoClicksTag$1.label -= Integer.MIN_VALUE;
                ?? r15 = vastParserKt$parseVideoClicksTag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = vastParserKt$parseVideoClicksTag$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(r15);
                    objectRef = new Ref.ObjectRef();
                    arrayList = new ArrayList();
                    arrayList2 = new ArrayList();
                    if (isStartDocument(xmlPullParser)) {
                        xmlPullParser.nextTag();
                    }
                    if (!isEndDocument(xmlPullParser)) {
                        if (!isStartTag(xmlPullParser)) {
                            throw new XmlPullParserException("allowed only for START_TAG");
                        }
                        depth = xmlPullParser.getDepth();
                        objectRef2 = objectRef;
                        if (xmlPullParser.getDepth() >= depth) {
                        }
                        objectRef = objectRef2;
                    }
                    if (z) {
                    }
                    return new VastVideoClicksDto((VastVideoClickDto) objectRef.element, arrayList, arrayList2);
                }
                if (i == 1) {
                    int i3 = vastParserKt$parseVideoClicksTag$1.I$0;
                    z = vastParserKt$parseVideoClicksTag$1.Z$0;
                    Ref.ObjectRef objectRef3 = (Ref.ObjectRef) vastParserKt$parseVideoClicksTag$1.L$4;
                    XmlPullParser xmlPullParser3 = (XmlPullParser) vastParserKt$parseVideoClicksTag$1.L$3;
                    List list = (List) vastParserKt$parseVideoClicksTag$1.L$2;
                    ?? r9 = (List) vastParserKt$parseVideoClicksTag$1.L$1;
                    Ref.ObjectRef objectRef4 = (Ref.ObjectRef) vastParserKt$parseVideoClicksTag$1.L$0;
                    ResultKt.throwOnFailure(r15);
                    objectRef3.element = r15;
                    depth = i3;
                    xmlPullParser = xmlPullParser3;
                    arrayList2 = list;
                    arrayList = r9;
                    objectRef2 = objectRef4;
                    xmlPullParser.next();
                    if (xmlPullParser.getDepth() >= depth) {
                    }
                    objectRef = objectRef2;
                    if (z) {
                    }
                    return new VastVideoClicksDto((VastVideoClickDto) objectRef.element, arrayList, arrayList2);
                }
                if (i == 2) {
                    i2 = vastParserKt$parseVideoClicksTag$1.I$0;
                    z = vastParserKt$parseVideoClicksTag$1.Z$0;
                    xmlPullParser2 = (XmlPullParser) vastParserKt$parseVideoClicksTag$1.L$3;
                    arrayList2 = (List) vastParserKt$parseVideoClicksTag$1.L$2;
                    ?? r8 = (List) vastParserKt$parseVideoClicksTag$1.L$1;
                    objectRef2 = (Ref.ObjectRef) vastParserKt$parseVideoClicksTag$1.L$0;
                    ResultKt.throwOnFailure(r15);
                    arrayList3 = r8;
                    obj = r15;
                    vastVideoClickDto = (VastVideoClickDto) obj;
                    arrayList4 = arrayList3;
                    if (vastVideoClickDto != null) {
                    }
                    ArrayList arrayList5 = arrayList4;
                    depth = i2;
                    xmlPullParser = xmlPullParser2;
                    arrayList = arrayList5;
                    xmlPullParser.next();
                    if (xmlPullParser.getDepth() >= depth) {
                    }
                    objectRef = objectRef2;
                    if (z) {
                    }
                    return new VastVideoClicksDto((VastVideoClickDto) objectRef.element, arrayList, arrayList2);
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i2 = vastParserKt$parseVideoClicksTag$1.I$0;
                z = vastParserKt$parseVideoClicksTag$1.Z$0;
                xmlPullParser2 = (XmlPullParser) vastParserKt$parseVideoClicksTag$1.L$3;
                arrayList2 = (List) vastParserKt$parseVideoClicksTag$1.L$2;
                ?? r82 = (List) vastParserKt$parseVideoClicksTag$1.L$1;
                objectRef2 = (Ref.ObjectRef) vastParserKt$parseVideoClicksTag$1.L$0;
                ResultKt.throwOnFailure(r15);
                ArrayList arrayList6 = r82;
                Object obj2 = r15;
                VastVideoClickDto vastVideoClickDto2 = (VastVideoClickDto) obj2;
                arrayList4 = arrayList6;
                if (vastVideoClickDto2 != null) {
                    arrayList2.add(vastVideoClickDto2);
                    arrayList4 = arrayList6;
                }
                ArrayList arrayList52 = arrayList4;
                depth = i2;
                xmlPullParser = xmlPullParser2;
                arrayList = arrayList52;
                xmlPullParser.next();
                if (xmlPullParser.getDepth() >= depth) {
                    int depth2 = xmlPullParser.getDepth() - depth;
                    if (depth2 == 0) {
                        if (!isStartTag(xmlPullParser)) {
                            if (isText(xmlPullParser) && (text = xmlPullParser.getText()) != null && !StringsKt.isBlank(text)) {
                                String text2 = xmlPullParser.getText();
                                Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                                StringsKt.trim((CharSequence) text2).toString();
                            }
                        }
                    } else if (depth2 == 1 && isStartTag(xmlPullParser) && (name = xmlPullParser.getName()) != null) {
                        int hashCode = name.hashCode();
                        if (hashCode == -617879491) {
                            if (name.equals("ClickThrough")) {
                                vastParserKt$parseVideoClicksTag$1.L$0 = objectRef2;
                                vastParserKt$parseVideoClicksTag$1.L$1 = arrayList;
                                vastParserKt$parseVideoClicksTag$1.L$2 = arrayList2;
                                vastParserKt$parseVideoClicksTag$1.L$3 = xmlPullParser;
                                vastParserKt$parseVideoClicksTag$1.L$4 = objectRef2;
                                vastParserKt$parseVideoClicksTag$1.Z$0 = z;
                                vastParserKt$parseVideoClicksTag$1.I$0 = depth;
                                vastParserKt$parseVideoClicksTag$1.label = 1;
                                ?? parseVideoClickTag = parseVideoClickTag(xmlPullParser, vastParserKt$parseVideoClicksTag$1);
                                if (parseVideoClickTag != coroutine_suspended) {
                                    List list2 = arrayList2;
                                    XmlPullParser xmlPullParser4 = xmlPullParser;
                                    int i4 = depth;
                                    Ref.ObjectRef objectRef5 = objectRef2;
                                    ArrayList arrayList7 = arrayList;
                                    objectRef5.element = parseVideoClickTag;
                                    depth = i4;
                                    xmlPullParser = xmlPullParser4;
                                    arrayList2 = list2;
                                    arrayList = arrayList7;
                                    objectRef2 = objectRef5;
                                }
                                return coroutine_suspended;
                            }
                        } else if (hashCode == -135761801) {
                            if (name.equals("CustomClick")) {
                                vastParserKt$parseVideoClicksTag$1.L$0 = objectRef2;
                                vastParserKt$parseVideoClicksTag$1.L$1 = arrayList;
                                vastParserKt$parseVideoClicksTag$1.L$2 = arrayList2;
                                vastParserKt$parseVideoClicksTag$1.L$3 = xmlPullParser;
                                vastParserKt$parseVideoClicksTag$1.L$4 = null;
                                vastParserKt$parseVideoClicksTag$1.Z$0 = z;
                                vastParserKt$parseVideoClicksTag$1.I$0 = depth;
                                vastParserKt$parseVideoClicksTag$1.label = 3;
                                Object parseVideoClickTag2 = parseVideoClickTag(xmlPullParser, vastParserKt$parseVideoClicksTag$1);
                                if (parseVideoClickTag2 != coroutine_suspended) {
                                    ArrayList arrayList8 = arrayList;
                                    xmlPullParser2 = xmlPullParser;
                                    i2 = depth;
                                    arrayList6 = arrayList8;
                                    obj2 = parseVideoClickTag2;
                                    VastVideoClickDto vastVideoClickDto22 = (VastVideoClickDto) obj2;
                                    arrayList4 = arrayList6;
                                    if (vastVideoClickDto22 != null) {
                                    }
                                    ArrayList arrayList522 = arrayList4;
                                    depth = i2;
                                    xmlPullParser = xmlPullParser2;
                                    arrayList = arrayList522;
                                }
                                return coroutine_suspended;
                            }
                        } else if (hashCode == 2107600959 && name.equals("ClickTracking")) {
                            vastParserKt$parseVideoClicksTag$1.L$0 = objectRef2;
                            vastParserKt$parseVideoClicksTag$1.L$1 = arrayList;
                            vastParserKt$parseVideoClicksTag$1.L$2 = arrayList2;
                            vastParserKt$parseVideoClicksTag$1.L$3 = xmlPullParser;
                            vastParserKt$parseVideoClicksTag$1.L$4 = null;
                            vastParserKt$parseVideoClicksTag$1.Z$0 = z;
                            vastParserKt$parseVideoClicksTag$1.I$0 = depth;
                            vastParserKt$parseVideoClicksTag$1.label = 2;
                            Object parseVideoClickTag3 = parseVideoClickTag(xmlPullParser, vastParserKt$parseVideoClicksTag$1);
                            if (parseVideoClickTag3 != coroutine_suspended) {
                                ArrayList arrayList9 = arrayList;
                                xmlPullParser2 = xmlPullParser;
                                i2 = depth;
                                arrayList3 = arrayList9;
                                obj = parseVideoClickTag3;
                                vastVideoClickDto = (VastVideoClickDto) obj;
                                arrayList4 = arrayList3;
                                if (vastVideoClickDto != null) {
                                    arrayList3.add(vastVideoClickDto);
                                    arrayList4 = arrayList3;
                                }
                                ArrayList arrayList5222 = arrayList4;
                                depth = i2;
                                xmlPullParser = xmlPullParser2;
                                arrayList = arrayList5222;
                            }
                            return coroutine_suspended;
                        }
                        if (xmlPullParser.getDepth() >= depth) {
                        }
                    }
                    xmlPullParser.next();
                    if (xmlPullParser.getDepth() >= depth) {
                    }
                }
                objectRef = objectRef2;
                if (z || objectRef.element != null) {
                    return new VastVideoClicksDto((VastVideoClickDto) objectRef.element, arrayList, arrayList2);
                }
                return null;
            }
        }
        vastParserKt$parseVideoClicksTag$1 = new VastParserKt$parseVideoClicksTag$1(continuation);
        ?? r152 = vastParserKt$parseVideoClicksTag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = vastParserKt$parseVideoClicksTag$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00dc, code lost:
    
        if (isEndTag(r7) != false) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006d -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0075 -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0084 -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0095 -> B:10:0x0098). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00a9 -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00c2 -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00dc -> B:14:0x00df). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object parseIconsTag(XmlPullParser xmlPullParser, Continuation<? super List<VastIconDto>> continuation) {
        VastParserKt$parseIconsTag$1 vastParserKt$parseIconsTag$1;
        int i;
        int depth;
        List list;
        String text;
        if (continuation instanceof VastParserKt$parseIconsTag$1) {
            vastParserKt$parseIconsTag$1 = (VastParserKt$parseIconsTag$1) continuation;
            if ((vastParserKt$parseIconsTag$1.label & Integer.MIN_VALUE) != 0) {
                vastParserKt$parseIconsTag$1.label -= Integer.MIN_VALUE;
                Object obj = vastParserKt$parseIconsTag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = vastParserKt$parseIconsTag$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ArrayList arrayList = new ArrayList();
                    if (isStartDocument(xmlPullParser)) {
                        xmlPullParser.nextTag();
                    }
                    if (isEndDocument(xmlPullParser)) {
                        return arrayList;
                    }
                    if (!isStartTag(xmlPullParser)) {
                        throw new XmlPullParserException("allowed only for START_TAG");
                    }
                    depth = xmlPullParser.getDepth();
                    list = arrayList;
                    if (xmlPullParser.getDepth() >= depth) {
                    }
                    return list;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = vastParserKt$parseIconsTag$1.I$0;
                XmlPullParser xmlPullParser2 = (XmlPullParser) vastParserKt$parseIconsTag$1.L$1;
                list = (List) vastParserKt$parseIconsTag$1.L$0;
                ResultKt.throwOnFailure(obj);
                VastIconDto vastIconDto = (VastIconDto) obj;
                if (vastIconDto != null) {
                    list.add(vastIconDto);
                }
                XmlPullParser xmlPullParser3 = xmlPullParser2;
                depth = i2;
                xmlPullParser = xmlPullParser3;
                xmlPullParser.next();
                if (xmlPullParser.getDepth() >= depth) {
                    int depth2 = xmlPullParser.getDepth() - depth;
                    if (depth2 == 0) {
                        if (!isStartTag(xmlPullParser)) {
                            if (isText(xmlPullParser) && (text = xmlPullParser.getText()) != null && !StringsKt.isBlank(text)) {
                                String text2 = xmlPullParser.getText();
                                Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                                StringsKt.trim((CharSequence) text2).toString();
                            }
                        }
                    } else if (depth2 == 1 && isStartTag(xmlPullParser) && Intrinsics.areEqual(xmlPullParser.getName(), "Icon")) {
                        vastParserKt$parseIconsTag$1.L$0 = list;
                        vastParserKt$parseIconsTag$1.L$1 = xmlPullParser;
                        vastParserKt$parseIconsTag$1.I$0 = depth;
                        vastParserKt$parseIconsTag$1.label = 1;
                        obj = parseIconTag(xmlPullParser, vastParserKt$parseIconsTag$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        int i3 = depth;
                        xmlPullParser2 = xmlPullParser;
                        i2 = i3;
                        VastIconDto vastIconDto2 = (VastIconDto) obj;
                        if (vastIconDto2 != null) {
                        }
                        XmlPullParser xmlPullParser32 = xmlPullParser2;
                        depth = i2;
                        xmlPullParser = xmlPullParser32;
                    }
                    xmlPullParser.next();
                    if (xmlPullParser.getDepth() >= depth) {
                    }
                }
                return list;
            }
        }
        vastParserKt$parseIconsTag$1 = new VastParserKt$parseIconsTag$1(continuation);
        Object obj2 = vastParserKt$parseIconsTag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = vastParserKt$parseIconsTag$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0418, code lost:
    
        if (isEndTag(r0) != false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0374, code lost:
    
        if (r0 == r2) goto L91;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x046d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v21, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v36, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v30, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34, types: [T] */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v38, types: [T] */
    /* JADX WARN: Type inference failed for: r5v40, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v44, types: [T] */
    /* JADX WARN: Type inference failed for: r5v48, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v59 */
    /* JADX WARN: Type inference failed for: r5v8, types: [T] */
    /* JADX WARN: Type inference failed for: r5v84 */
    /* JADX WARN: Type inference failed for: r5v85 */
    /* JADX WARN: Type inference failed for: r5v86 */
    /* JADX WARN: Type inference failed for: r6v33, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v27, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v30, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v33, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x03fe -> B:19:0x041b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:104:0x0418 -> B:19:0x041b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0374 -> B:14:0x0377). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0389 -> B:17:0x037e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object parseIconTag(XmlPullParser xmlPullParser, Continuation<? super VastIconDto> continuation) {
        VastParserKt$parseIconTag$1 vastParserKt$parseIconTag$1;
        int i;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        Ref.ObjectRef objectRef6;
        Ref.ObjectRef objectRef7;
        Ref.ObjectRef objectRef8;
        ArrayList arrayList;
        Ref.ObjectRef objectRef9;
        Ref.ObjectRef objectRef10;
        Ref.ObjectRef objectRef11;
        Ref.ObjectRef objectRef12;
        Ref.ObjectRef objectRef13;
        int depth;
        Ref.ObjectRef objectRef14;
        ArrayList arrayList2;
        Ref.ObjectRef objectRef15;
        Ref.ObjectRef objectRef16;
        XmlPullParser xmlPullParser2;
        VastResource vastResource;
        Ref.ObjectRef objectRef17;
        Ref.ObjectRef objectRef18;
        Ref.ObjectRef objectRef19;
        Ref.ObjectRef objectRef20;
        Ref.ObjectRef objectRef21;
        Ref.ObjectRef objectRef22;
        Ref.ObjectRef objectRef23;
        Ref.ObjectRef objectRef24;
        ArrayList arrayList3;
        XmlPullParser xmlPullParser3;
        XmlPullParser xmlPullParser4;
        Object obj;
        ?? r5;
        Ref.ObjectRef objectRef25;
        Ref.ObjectRef objectRef26;
        Ref.ObjectRef objectRef27;
        Ref.ObjectRef objectRef28;
        Ref.ObjectRef objectRef29;
        Ref.ObjectRef objectRef30;
        Ref.ObjectRef objectRef31;
        Ref.ObjectRef objectRef32;
        ArrayList arrayList4;
        XmlPullParser xmlPullParser5;
        XmlPullParser xmlPullParser6;
        Object obj2;
        Ref.ObjectRef objectRef33;
        Ref.ObjectRef objectRef34;
        Ref.ObjectRef objectRef35;
        ArrayList arrayList5;
        XmlPullParser xmlPullParser7;
        Ref.ObjectRef objectRef36;
        Ref.ObjectRef objectRef37;
        Ref.ObjectRef objectRef38;
        Ref.ObjectRef objectRef39;
        String name;
        XmlPullParser xmlPullParser8;
        Ref.ObjectRef objectRef40;
        Ref.ObjectRef objectRef41;
        ArrayList arrayList6;
        XmlPullParser xmlPullParser9;
        XmlPullParser xmlPullParser10;
        Object obj3;
        String text;
        if (continuation instanceof VastParserKt$parseIconTag$1) {
            vastParserKt$parseIconTag$1 = (VastParserKt$parseIconTag$1) continuation;
            if ((vastParserKt$parseIconTag$1.label & Integer.MIN_VALUE) != 0) {
                vastParserKt$parseIconTag$1.label -= Integer.MIN_VALUE;
                ?? r0 = vastParserKt$parseIconTag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = vastParserKt$parseIconTag$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(r0);
                    objectRef = new Ref.ObjectRef();
                    objectRef2 = new Ref.ObjectRef();
                    objectRef3 = new Ref.ObjectRef();
                    objectRef4 = new Ref.ObjectRef();
                    objectRef5 = new Ref.ObjectRef();
                    objectRef6 = new Ref.ObjectRef();
                    objectRef7 = new Ref.ObjectRef();
                    objectRef8 = new Ref.ObjectRef();
                    ArrayList arrayList7 = new ArrayList();
                    if (isStartDocument(xmlPullParser)) {
                        xmlPullParser.nextTag();
                    }
                    if (isEndDocument(xmlPullParser)) {
                        arrayList = arrayList7;
                        vastResource = (VastResource) objectRef8.element;
                        if (vastResource == null) {
                        }
                    } else {
                        if (!isStartTag(xmlPullParser)) {
                            throw new XmlPullParserException("allowed only for START_TAG");
                        }
                        objectRef9 = objectRef2;
                        objectRef10 = objectRef3;
                        objectRef11 = objectRef4;
                        objectRef12 = objectRef5;
                        objectRef13 = objectRef8;
                        depth = xmlPullParser.getDepth();
                        objectRef14 = objectRef6;
                        arrayList2 = arrayList7;
                        objectRef15 = objectRef7;
                        objectRef16 = objectRef;
                        xmlPullParser2 = xmlPullParser;
                        if (xmlPullParser2.getDepth() >= depth) {
                        }
                        objectRef8 = objectRef13;
                        arrayList = arrayList2;
                        objectRef = objectRef16;
                        objectRef7 = objectRef15;
                        objectRef6 = objectRef14;
                        objectRef5 = objectRef12;
                        objectRef4 = objectRef11;
                        objectRef3 = objectRef10;
                        objectRef2 = objectRef9;
                        vastResource = (VastResource) objectRef8.element;
                        if (vastResource == null) {
                        }
                    }
                } else {
                    if (i == 1) {
                        depth = vastParserKt$parseIconTag$1.I$0;
                        objectRef13 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$11;
                        xmlPullParser6 = (XmlPullParser) vastParserKt$parseIconTag$1.L$10;
                        XmlPullParser xmlPullParser11 = (XmlPullParser) vastParserKt$parseIconTag$1.L$9;
                        ?? r7 = (List) vastParserKt$parseIconTag$1.L$8;
                        Ref.ObjectRef objectRef42 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$7;
                        Ref.ObjectRef objectRef43 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$6;
                        Ref.ObjectRef objectRef44 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$5;
                        Ref.ObjectRef objectRef45 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$4;
                        Ref.ObjectRef objectRef46 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$3;
                        Ref.ObjectRef objectRef47 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$2;
                        Ref.ObjectRef objectRef48 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$1;
                        Ref.ObjectRef objectRef49 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$0;
                        ResultKt.throwOnFailure(r0);
                        objectRef30 = objectRef48;
                        objectRef29 = objectRef49;
                        objectRef31 = objectRef46;
                        objectRef28 = objectRef47;
                        objectRef27 = objectRef44;
                        objectRef32 = objectRef45;
                        objectRef25 = objectRef42;
                        objectRef26 = objectRef43;
                        arrayList4 = r7;
                        xmlPullParser5 = xmlPullParser11;
                        obj2 = r0;
                        Ref.ObjectRef objectRef50 = objectRef31;
                        objectRef20 = objectRef32;
                        objectRef11 = objectRef50;
                        xmlPullParser4 = xmlPullParser6;
                        r5 = (VastResource) obj2;
                        xmlPullParser2 = xmlPullParser5;
                        arrayList2 = arrayList4;
                        objectRef16 = objectRef29;
                        objectRef17 = objectRef30;
                        objectRef13.element = r5;
                        objectRef38 = objectRef11;
                        objectRef37 = objectRef28;
                        objectRef9 = objectRef17;
                        objectRef34 = objectRef26;
                        arrayList5 = arrayList2;
                        objectRef36 = objectRef20;
                        objectRef33 = objectRef27;
                        objectRef35 = objectRef25;
                        xmlPullParser7 = xmlPullParser2;
                        xmlPullParser2 = xmlPullParser4;
                        objectRef39 = objectRef16;
                        name = xmlPullParser2.getName();
                        if (Intrinsics.areEqual(name, "IconClicks")) {
                        }
                        return coroutine_suspended;
                    }
                    if (i == 2) {
                        depth = vastParserKt$parseIconTag$1.I$0;
                        objectRef13 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$11;
                        xmlPullParser10 = (XmlPullParser) vastParserKt$parseIconTag$1.L$10;
                        XmlPullParser xmlPullParser12 = (XmlPullParser) vastParserKt$parseIconTag$1.L$9;
                        ?? r72 = (List) vastParserKt$parseIconTag$1.L$8;
                        Ref.ObjectRef objectRef51 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$7;
                        Ref.ObjectRef objectRef52 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$6;
                        Ref.ObjectRef objectRef53 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$5;
                        Ref.ObjectRef objectRef54 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$4;
                        Ref.ObjectRef objectRef55 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$3;
                        Ref.ObjectRef objectRef56 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$2;
                        Ref.ObjectRef objectRef57 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$1;
                        Ref.ObjectRef objectRef58 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$0;
                        ResultKt.throwOnFailure(r0);
                        objectRef40 = objectRef58;
                        objectRef9 = objectRef57;
                        objectRef10 = objectRef56;
                        objectRef11 = objectRef55;
                        objectRef12 = objectRef54;
                        objectRef14 = objectRef53;
                        objectRef15 = objectRef52;
                        objectRef41 = objectRef51;
                        arrayList6 = r72;
                        xmlPullParser9 = xmlPullParser12;
                        obj3 = r0;
                        xmlPullParser4 = xmlPullParser10;
                        objectRef17 = objectRef9;
                        r5 = (VastResource) obj3;
                        xmlPullParser2 = xmlPullParser9;
                        arrayList2 = arrayList6;
                        objectRef28 = objectRef10;
                        objectRef16 = objectRef40;
                        objectRef20 = objectRef12;
                        objectRef27 = objectRef14;
                        objectRef26 = objectRef15;
                        objectRef25 = objectRef41;
                        objectRef13.element = r5;
                        objectRef38 = objectRef11;
                        objectRef37 = objectRef28;
                        objectRef9 = objectRef17;
                        objectRef34 = objectRef26;
                        arrayList5 = arrayList2;
                        objectRef36 = objectRef20;
                        objectRef33 = objectRef27;
                        objectRef35 = objectRef25;
                        xmlPullParser7 = xmlPullParser2;
                        xmlPullParser2 = xmlPullParser4;
                        objectRef39 = objectRef16;
                        name = xmlPullParser2.getName();
                        if (Intrinsics.areEqual(name, "IconClicks")) {
                        }
                        return coroutine_suspended;
                    }
                    if (i == 3) {
                        depth = vastParserKt$parseIconTag$1.I$0;
                        objectRef13 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$11;
                        XmlPullParser xmlPullParser13 = (XmlPullParser) vastParserKt$parseIconTag$1.L$10;
                        XmlPullParser xmlPullParser14 = (XmlPullParser) vastParserKt$parseIconTag$1.L$9;
                        ?? r73 = (List) vastParserKt$parseIconTag$1.L$8;
                        Ref.ObjectRef objectRef59 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$7;
                        Ref.ObjectRef objectRef60 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$6;
                        Ref.ObjectRef objectRef61 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$5;
                        Ref.ObjectRef objectRef62 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$4;
                        Ref.ObjectRef objectRef63 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$3;
                        Ref.ObjectRef objectRef64 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$2;
                        Ref.ObjectRef objectRef65 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$1;
                        Ref.ObjectRef objectRef66 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$0;
                        ResultKt.throwOnFailure(r0);
                        objectRef18 = objectRef64;
                        objectRef17 = objectRef65;
                        objectRef20 = objectRef62;
                        objectRef19 = objectRef63;
                        objectRef22 = objectRef60;
                        objectRef21 = objectRef61;
                        objectRef24 = objectRef66;
                        objectRef23 = objectRef59;
                        arrayList3 = r73;
                        xmlPullParser3 = xmlPullParser14;
                        xmlPullParser4 = xmlPullParser13;
                        obj = r0;
                        r5 = (VastResource) obj;
                        xmlPullParser2 = xmlPullParser3;
                        arrayList2 = arrayList3;
                        objectRef16 = objectRef24;
                        objectRef25 = objectRef23;
                        objectRef26 = objectRef22;
                        objectRef27 = objectRef21;
                        objectRef11 = objectRef19;
                        objectRef28 = objectRef18;
                        objectRef13.element = r5;
                        objectRef38 = objectRef11;
                        objectRef37 = objectRef28;
                        objectRef9 = objectRef17;
                        objectRef34 = objectRef26;
                        arrayList5 = arrayList2;
                        objectRef36 = objectRef20;
                        objectRef33 = objectRef27;
                        objectRef35 = objectRef25;
                        xmlPullParser7 = xmlPullParser2;
                        xmlPullParser2 = xmlPullParser4;
                        objectRef39 = objectRef16;
                        name = xmlPullParser2.getName();
                        if (Intrinsics.areEqual(name, "IconClicks")) {
                        }
                        return coroutine_suspended;
                    }
                    if (i != 4) {
                        if (i != 5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        depth = vastParserKt$parseIconTag$1.I$0;
                        xmlPullParser7 = (XmlPullParser) vastParserKt$parseIconTag$1.L$9;
                        ?? r11 = (List) vastParserKt$parseIconTag$1.L$8;
                        objectRef35 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$7;
                        objectRef34 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$6;
                        objectRef33 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$5;
                        Ref.ObjectRef objectRef67 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$4;
                        objectRef38 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$3;
                        objectRef37 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$2;
                        Ref.ObjectRef objectRef68 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$1;
                        objectRef39 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$0;
                        ResultKt.throwOnFailure(r0);
                        objectRef36 = objectRef67;
                        objectRef9 = objectRef68;
                        Object obj4 = r0;
                        ArrayList arrayList8 = r11;
                        String str = (String) obj4;
                        ArrayList arrayList9 = arrayList8;
                        if (str != null) {
                            arrayList8.add(str);
                            arrayList9 = arrayList8;
                        }
                        Ref.ObjectRef objectRef69 = objectRef34;
                        objectRef11 = objectRef38;
                        objectRef13 = objectRef35;
                        objectRef12 = objectRef36;
                        arrayList2 = arrayList9;
                        objectRef14 = objectRef33;
                        objectRef10 = objectRef37;
                        xmlPullParser8 = xmlPullParser7;
                        objectRef15 = objectRef69;
                        objectRef16 = objectRef39;
                        xmlPullParser2 = xmlPullParser8;
                        xmlPullParser2.next();
                        if (xmlPullParser2.getDepth() >= depth) {
                            int depth2 = xmlPullParser2.getDepth() - depth;
                            if (depth2 == 0) {
                                if (isStartTag(xmlPullParser2)) {
                                    objectRef16.element = attribute(xmlPullParser2, ATTRIBUTE_PROGRAM);
                                    String attribute = attribute(xmlPullParser2, "width");
                                    objectRef9.element = attribute != null ? StringsKt.toIntOrNull(attribute) : 0;
                                    String attribute2 = attribute(xmlPullParser2, "height");
                                    objectRef10.element = attribute2 != null ? StringsKt.toIntOrNull(attribute2) : 0;
                                    objectRef11.element = attribute(xmlPullParser2, "apiFramework");
                                    String attribute3 = attribute(xmlPullParser2, ATTRIBUTE_OFFSET);
                                    objectRef12.element = attribute3 != null ? toOffset(attribute3) : 0;
                                    String attribute4 = attribute(xmlPullParser2, "duration");
                                    if (attribute4 != null) {
                                        objectRef14.element = toMillis(attribute4);
                                    } else {
                                        objectRef14.element = null;
                                    }
                                } else if (isText(xmlPullParser2) && (text = xmlPullParser2.getText()) != null && !StringsKt.isBlank(text)) {
                                    String text2 = xmlPullParser2.getText();
                                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                                    StringsKt.trim((CharSequence) text2).toString();
                                }
                            } else if (depth2 == 1 && isStartTag(xmlPullParser2)) {
                                if (objectRef13.element != null) {
                                    objectRef37 = objectRef10;
                                    objectRef33 = objectRef14;
                                    arrayList5 = arrayList2;
                                    objectRef36 = objectRef12;
                                    objectRef35 = objectRef13;
                                    objectRef38 = objectRef11;
                                    objectRef34 = objectRef15;
                                    xmlPullParser7 = xmlPullParser2;
                                    objectRef39 = objectRef16;
                                    name = xmlPullParser2.getName();
                                    if (Intrinsics.areEqual(name, "IconClicks")) {
                                        vastParserKt$parseIconTag$1.L$0 = objectRef39;
                                        vastParserKt$parseIconTag$1.L$1 = objectRef9;
                                        vastParserKt$parseIconTag$1.L$2 = objectRef37;
                                        vastParserKt$parseIconTag$1.L$3 = objectRef38;
                                        vastParserKt$parseIconTag$1.L$4 = objectRef36;
                                        vastParserKt$parseIconTag$1.L$5 = objectRef33;
                                        vastParserKt$parseIconTag$1.L$6 = objectRef34;
                                        vastParserKt$parseIconTag$1.L$7 = objectRef35;
                                        vastParserKt$parseIconTag$1.L$8 = arrayList5;
                                        vastParserKt$parseIconTag$1.L$9 = xmlPullParser7;
                                        vastParserKt$parseIconTag$1.L$10 = objectRef34;
                                        vastParserKt$parseIconTag$1.L$11 = null;
                                        vastParserKt$parseIconTag$1.I$0 = depth;
                                        vastParserKt$parseIconTag$1.label = 4;
                                        ?? parseIconClicksTag = parseIconClicksTag(xmlPullParser2, vastParserKt$parseIconTag$1);
                                        if (parseIconClicksTag != coroutine_suspended) {
                                            Ref.ObjectRef objectRef70 = objectRef36;
                                            ArrayList arrayList10 = arrayList5;
                                            objectRef14 = objectRef33;
                                            objectRef10 = objectRef37;
                                            xmlPullParser8 = xmlPullParser7;
                                            objectRef15 = objectRef34;
                                            objectRef11 = objectRef38;
                                            objectRef15.element = parseIconClicksTag;
                                            objectRef13 = objectRef35;
                                            objectRef12 = objectRef70;
                                            objectRef16 = objectRef39;
                                            arrayList2 = arrayList10;
                                            xmlPullParser2 = xmlPullParser8;
                                        }
                                    } else if (Intrinsics.areEqual(name, "IconViewTracking")) {
                                        vastParserKt$parseIconTag$1.L$0 = objectRef39;
                                        vastParserKt$parseIconTag$1.L$1 = objectRef9;
                                        vastParserKt$parseIconTag$1.L$2 = objectRef37;
                                        vastParserKt$parseIconTag$1.L$3 = objectRef38;
                                        vastParserKt$parseIconTag$1.L$4 = objectRef36;
                                        vastParserKt$parseIconTag$1.L$5 = objectRef33;
                                        vastParserKt$parseIconTag$1.L$6 = objectRef34;
                                        vastParserKt$parseIconTag$1.L$7 = objectRef35;
                                        vastParserKt$parseIconTag$1.L$8 = arrayList5;
                                        vastParserKt$parseIconTag$1.L$9 = xmlPullParser7;
                                        vastParserKt$parseIconTag$1.L$10 = null;
                                        vastParserKt$parseIconTag$1.L$11 = null;
                                        vastParserKt$parseIconTag$1.I$0 = depth;
                                        vastParserKt$parseIconTag$1.label = 5;
                                        Object parseTagsTextOnly = parseTagsTextOnly(xmlPullParser2, vastParserKt$parseIconTag$1);
                                        obj4 = parseTagsTextOnly;
                                        arrayList8 = arrayList5;
                                    } else {
                                        arrayList9 = arrayList5;
                                        Ref.ObjectRef objectRef692 = objectRef34;
                                        objectRef11 = objectRef38;
                                        objectRef13 = objectRef35;
                                        objectRef12 = objectRef36;
                                        arrayList2 = arrayList9;
                                        objectRef14 = objectRef33;
                                        objectRef10 = objectRef37;
                                        xmlPullParser8 = xmlPullParser7;
                                        objectRef15 = objectRef692;
                                        objectRef16 = objectRef39;
                                        xmlPullParser2 = xmlPullParser8;
                                    }
                                    return coroutine_suspended;
                                }
                                String name2 = xmlPullParser2.getName();
                                if (name2 != null) {
                                    int hashCode = name2.hashCode();
                                    if (hashCode != -375340334) {
                                        if (hashCode == 676623548) {
                                            if (name2.equals("StaticResource")) {
                                                vastParserKt$parseIconTag$1.L$0 = objectRef16;
                                                vastParserKt$parseIconTag$1.L$1 = objectRef9;
                                                vastParserKt$parseIconTag$1.L$2 = objectRef10;
                                                vastParserKt$parseIconTag$1.L$3 = objectRef11;
                                                vastParserKt$parseIconTag$1.L$4 = objectRef12;
                                                vastParserKt$parseIconTag$1.L$5 = objectRef14;
                                                vastParserKt$parseIconTag$1.L$6 = objectRef15;
                                                vastParserKt$parseIconTag$1.L$7 = objectRef13;
                                                vastParserKt$parseIconTag$1.L$8 = arrayList2;
                                                vastParserKt$parseIconTag$1.L$9 = xmlPullParser2;
                                                vastParserKt$parseIconTag$1.L$10 = xmlPullParser2;
                                                vastParserKt$parseIconTag$1.L$11 = objectRef13;
                                                vastParserKt$parseIconTag$1.I$0 = depth;
                                                vastParserKt$parseIconTag$1.label = 1;
                                                Object parseStaticResourceTag = parseStaticResourceTag(xmlPullParser2, vastParserKt$parseIconTag$1);
                                                if (parseStaticResourceTag != coroutine_suspended) {
                                                    objectRef29 = objectRef16;
                                                    objectRef30 = objectRef9;
                                                    arrayList4 = arrayList2;
                                                    objectRef28 = objectRef10;
                                                    xmlPullParser5 = xmlPullParser2;
                                                    objectRef31 = objectRef11;
                                                    obj2 = parseStaticResourceTag;
                                                    objectRef32 = objectRef12;
                                                    xmlPullParser6 = xmlPullParser5;
                                                    objectRef27 = objectRef14;
                                                    objectRef26 = objectRef15;
                                                    objectRef25 = objectRef13;
                                                    Ref.ObjectRef objectRef502 = objectRef31;
                                                    objectRef20 = objectRef32;
                                                    objectRef11 = objectRef502;
                                                    xmlPullParser4 = xmlPullParser6;
                                                    r5 = (VastResource) obj2;
                                                    xmlPullParser2 = xmlPullParser5;
                                                    arrayList2 = arrayList4;
                                                    objectRef16 = objectRef29;
                                                    objectRef17 = objectRef30;
                                                    objectRef13.element = r5;
                                                    objectRef38 = objectRef11;
                                                    objectRef37 = objectRef28;
                                                    objectRef9 = objectRef17;
                                                    objectRef34 = objectRef26;
                                                    arrayList5 = arrayList2;
                                                    objectRef36 = objectRef20;
                                                    objectRef33 = objectRef27;
                                                    objectRef35 = objectRef25;
                                                    xmlPullParser7 = xmlPullParser2;
                                                    xmlPullParser2 = xmlPullParser4;
                                                    objectRef39 = objectRef16;
                                                    name = xmlPullParser2.getName();
                                                    if (Intrinsics.areEqual(name, "IconClicks")) {
                                                    }
                                                }
                                            }
                                        } else if (hashCode == 1928285401 && name2.equals("HTMLResource")) {
                                            vastParserKt$parseIconTag$1.L$0 = objectRef16;
                                            vastParserKt$parseIconTag$1.L$1 = objectRef9;
                                            vastParserKt$parseIconTag$1.L$2 = objectRef10;
                                            vastParserKt$parseIconTag$1.L$3 = objectRef11;
                                            vastParserKt$parseIconTag$1.L$4 = objectRef12;
                                            vastParserKt$parseIconTag$1.L$5 = objectRef14;
                                            vastParserKt$parseIconTag$1.L$6 = objectRef15;
                                            vastParserKt$parseIconTag$1.L$7 = objectRef13;
                                            vastParserKt$parseIconTag$1.L$8 = arrayList2;
                                            vastParserKt$parseIconTag$1.L$9 = xmlPullParser2;
                                            vastParserKt$parseIconTag$1.L$10 = xmlPullParser2;
                                            vastParserKt$parseIconTag$1.L$11 = objectRef13;
                                            vastParserKt$parseIconTag$1.I$0 = depth;
                                            vastParserKt$parseIconTag$1.label = 2;
                                            Object parseHtmlResourceTag = parseHtmlResourceTag(xmlPullParser2, vastParserKt$parseIconTag$1);
                                            if (parseHtmlResourceTag != coroutine_suspended) {
                                                objectRef41 = objectRef13;
                                                objectRef40 = objectRef16;
                                                arrayList6 = arrayList2;
                                                xmlPullParser9 = xmlPullParser2;
                                                obj3 = parseHtmlResourceTag;
                                                xmlPullParser10 = xmlPullParser9;
                                                xmlPullParser4 = xmlPullParser10;
                                                objectRef17 = objectRef9;
                                                r5 = (VastResource) obj3;
                                                xmlPullParser2 = xmlPullParser9;
                                                arrayList2 = arrayList6;
                                                objectRef28 = objectRef10;
                                                objectRef16 = objectRef40;
                                                objectRef20 = objectRef12;
                                                objectRef27 = objectRef14;
                                                objectRef26 = objectRef15;
                                                objectRef25 = objectRef41;
                                                objectRef13.element = r5;
                                                objectRef38 = objectRef11;
                                                objectRef37 = objectRef28;
                                                objectRef9 = objectRef17;
                                                objectRef34 = objectRef26;
                                                arrayList5 = arrayList2;
                                                objectRef36 = objectRef20;
                                                objectRef33 = objectRef27;
                                                objectRef35 = objectRef25;
                                                xmlPullParser7 = xmlPullParser2;
                                                xmlPullParser2 = xmlPullParser4;
                                                objectRef39 = objectRef16;
                                                name = xmlPullParser2.getName();
                                                if (Intrinsics.areEqual(name, "IconClicks")) {
                                                }
                                            }
                                        }
                                        return coroutine_suspended;
                                    }
                                    if (name2.equals("IFrameResource")) {
                                        vastParserKt$parseIconTag$1.L$0 = objectRef16;
                                        vastParserKt$parseIconTag$1.L$1 = objectRef9;
                                        vastParserKt$parseIconTag$1.L$2 = objectRef10;
                                        vastParserKt$parseIconTag$1.L$3 = objectRef11;
                                        vastParserKt$parseIconTag$1.L$4 = objectRef12;
                                        vastParserKt$parseIconTag$1.L$5 = objectRef14;
                                        vastParserKt$parseIconTag$1.L$6 = objectRef15;
                                        vastParserKt$parseIconTag$1.L$7 = objectRef13;
                                        vastParserKt$parseIconTag$1.L$8 = arrayList2;
                                        vastParserKt$parseIconTag$1.L$9 = xmlPullParser2;
                                        vastParserKt$parseIconTag$1.L$10 = xmlPullParser2;
                                        vastParserKt$parseIconTag$1.L$11 = objectRef13;
                                        vastParserKt$parseIconTag$1.I$0 = depth;
                                        vastParserKt$parseIconTag$1.label = 3;
                                        Object parseIFrameResourceTag = parseIFrameResourceTag(xmlPullParser2, vastParserKt$parseIconTag$1);
                                        if (parseIFrameResourceTag != coroutine_suspended) {
                                            objectRef18 = objectRef10;
                                            objectRef17 = objectRef9;
                                            objectRef20 = objectRef12;
                                            objectRef19 = objectRef11;
                                            objectRef22 = objectRef15;
                                            objectRef21 = objectRef14;
                                            objectRef23 = objectRef13;
                                            objectRef24 = objectRef16;
                                            arrayList3 = arrayList2;
                                            xmlPullParser3 = xmlPullParser2;
                                            obj = parseIFrameResourceTag;
                                            xmlPullParser4 = xmlPullParser3;
                                            r5 = (VastResource) obj;
                                            xmlPullParser2 = xmlPullParser3;
                                            arrayList2 = arrayList3;
                                            objectRef16 = objectRef24;
                                            objectRef25 = objectRef23;
                                            objectRef26 = objectRef22;
                                            objectRef27 = objectRef21;
                                            objectRef11 = objectRef19;
                                            objectRef28 = objectRef18;
                                            objectRef13.element = r5;
                                            objectRef38 = objectRef11;
                                            objectRef37 = objectRef28;
                                            objectRef9 = objectRef17;
                                            objectRef34 = objectRef26;
                                            arrayList5 = arrayList2;
                                            objectRef36 = objectRef20;
                                            objectRef33 = objectRef27;
                                            objectRef35 = objectRef25;
                                            xmlPullParser7 = xmlPullParser2;
                                            xmlPullParser2 = xmlPullParser4;
                                            objectRef39 = objectRef16;
                                            name = xmlPullParser2.getName();
                                            if (Intrinsics.areEqual(name, "IconClicks")) {
                                            }
                                        }
                                        return coroutine_suspended;
                                    }
                                    xmlPullParser4 = xmlPullParser2;
                                    objectRef17 = objectRef9;
                                    r5 = 0;
                                    objectRef28 = objectRef10;
                                    objectRef20 = objectRef12;
                                    objectRef27 = objectRef14;
                                    objectRef26 = objectRef15;
                                    objectRef25 = objectRef13;
                                    objectRef13.element = r5;
                                    objectRef38 = objectRef11;
                                    objectRef37 = objectRef28;
                                    objectRef9 = objectRef17;
                                    objectRef34 = objectRef26;
                                    arrayList5 = arrayList2;
                                    objectRef36 = objectRef20;
                                    objectRef33 = objectRef27;
                                    objectRef35 = objectRef25;
                                    xmlPullParser7 = xmlPullParser2;
                                    xmlPullParser2 = xmlPullParser4;
                                    objectRef39 = objectRef16;
                                    name = xmlPullParser2.getName();
                                    if (Intrinsics.areEqual(name, "IconClicks")) {
                                    }
                                    return coroutine_suspended;
                                }
                                xmlPullParser4 = xmlPullParser2;
                                objectRef17 = objectRef9;
                                r5 = 0;
                                objectRef28 = objectRef10;
                                objectRef20 = objectRef12;
                                objectRef27 = objectRef14;
                                objectRef26 = objectRef15;
                                objectRef25 = objectRef13;
                                objectRef13.element = r5;
                                objectRef38 = objectRef11;
                                objectRef37 = objectRef28;
                                objectRef9 = objectRef17;
                                objectRef34 = objectRef26;
                                arrayList5 = arrayList2;
                                objectRef36 = objectRef20;
                                objectRef33 = objectRef27;
                                objectRef35 = objectRef25;
                                xmlPullParser7 = xmlPullParser2;
                                xmlPullParser2 = xmlPullParser4;
                                objectRef39 = objectRef16;
                                name = xmlPullParser2.getName();
                                if (Intrinsics.areEqual(name, "IconClicks")) {
                                }
                                return coroutine_suspended;
                            }
                            xmlPullParser2.next();
                            if (xmlPullParser2.getDepth() >= depth) {
                            }
                        }
                        objectRef8 = objectRef13;
                        arrayList = arrayList2;
                        objectRef = objectRef16;
                        objectRef7 = objectRef15;
                        objectRef6 = objectRef14;
                        objectRef5 = objectRef12;
                        objectRef4 = objectRef11;
                        objectRef3 = objectRef10;
                        objectRef2 = objectRef9;
                        vastResource = (VastResource) objectRef8.element;
                        if (vastResource == null) {
                            return new VastIconDto((String) objectRef.element, (Integer) objectRef2.element, (Integer) objectRef3.element, (String) objectRef4.element, (VastOffset) objectRef5.element, (Long) objectRef6.element, (VastIconClicksDto) objectRef7.element, arrayList, vastResource);
                        }
                        return null;
                    }
                    depth = vastParserKt$parseIconTag$1.I$0;
                    Ref.ObjectRef objectRef71 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$10;
                    xmlPullParser8 = (XmlPullParser) vastParserKt$parseIconTag$1.L$9;
                    ?? r6 = (List) vastParserKt$parseIconTag$1.L$8;
                    Ref.ObjectRef objectRef72 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$7;
                    objectRef15 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$6;
                    objectRef14 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$5;
                    Ref.ObjectRef objectRef73 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$4;
                    objectRef11 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$3;
                    objectRef10 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$2;
                    objectRef9 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$1;
                    Ref.ObjectRef objectRef74 = (Ref.ObjectRef) vastParserKt$parseIconTag$1.L$0;
                    ResultKt.throwOnFailure(r0);
                    objectRef71.element = r0;
                    objectRef13 = objectRef72;
                    objectRef12 = objectRef73;
                    objectRef16 = objectRef74;
                    arrayList2 = r6;
                    xmlPullParser2 = xmlPullParser8;
                    xmlPullParser2.next();
                    if (xmlPullParser2.getDepth() >= depth) {
                    }
                    objectRef8 = objectRef13;
                    arrayList = arrayList2;
                    objectRef = objectRef16;
                    objectRef7 = objectRef15;
                    objectRef6 = objectRef14;
                    objectRef5 = objectRef12;
                    objectRef4 = objectRef11;
                    objectRef3 = objectRef10;
                    objectRef2 = objectRef9;
                    vastResource = (VastResource) objectRef8.element;
                    if (vastResource == null) {
                    }
                }
            }
        }
        vastParserKt$parseIconTag$1 = new VastParserKt$parseIconTag$1(continuation);
        ?? r02 = vastParserKt$parseIconTag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = vastParserKt$parseIconTag$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0131, code lost:
    
        if (isEndTag(r10) != false) goto L64;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Type inference failed for: r11v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v29, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0092 -> B:15:0x0134). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x009a -> B:15:0x0134). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00d3 -> B:15:0x0134). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00e8 -> B:11:0x00ec). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00fe -> B:15:0x0134). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0117 -> B:15:0x0134). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0131 -> B:15:0x0134). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object parseIconClicksTag(XmlPullParser xmlPullParser, Continuation<? super VastIconClicksDto> continuation) {
        VastParserKt$parseIconClicksTag$1 vastParserKt$parseIconClicksTag$1;
        int i;
        Ref.ObjectRef objectRef;
        ArrayList arrayList;
        int depth;
        Ref.ObjectRef objectRef2;
        String str;
        String text;
        if (continuation instanceof VastParserKt$parseIconClicksTag$1) {
            vastParserKt$parseIconClicksTag$1 = (VastParserKt$parseIconClicksTag$1) continuation;
            if ((vastParserKt$parseIconClicksTag$1.label & Integer.MIN_VALUE) != 0) {
                vastParserKt$parseIconClicksTag$1.label -= Integer.MIN_VALUE;
                ?? r11 = vastParserKt$parseIconClicksTag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = vastParserKt$parseIconClicksTag$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(r11);
                    objectRef = new Ref.ObjectRef();
                    arrayList = new ArrayList();
                    if (isStartDocument(xmlPullParser)) {
                        xmlPullParser.nextTag();
                    }
                    if (!isEndDocument(xmlPullParser)) {
                        if (!isStartTag(xmlPullParser)) {
                            throw new XmlPullParserException("allowed only for START_TAG");
                        }
                        depth = xmlPullParser.getDepth();
                        objectRef2 = objectRef;
                        if (xmlPullParser.getDepth() >= depth) {
                        }
                        objectRef = objectRef2;
                    }
                    str = (String) objectRef.element;
                    if (str != null) {
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = vastParserKt$parseIconClicksTag$1.I$0;
                        XmlPullParser xmlPullParser2 = (XmlPullParser) vastParserKt$parseIconClicksTag$1.L$2;
                        ?? r6 = (List) vastParserKt$parseIconClicksTag$1.L$1;
                        objectRef2 = (Ref.ObjectRef) vastParserKt$parseIconClicksTag$1.L$0;
                        ResultKt.throwOnFailure(r11);
                        ArrayList arrayList2 = r6;
                        Object obj = r11;
                        String str2 = (String) obj;
                        if (str2 != null) {
                            arrayList2.add(str2);
                        }
                        ArrayList arrayList3 = arrayList2;
                        depth = i2;
                        xmlPullParser = xmlPullParser2;
                        arrayList = arrayList3;
                        xmlPullParser.next();
                        if (xmlPullParser.getDepth() >= depth) {
                            int depth2 = xmlPullParser.getDepth() - depth;
                            if (depth2 == 0) {
                                if (!isStartTag(xmlPullParser)) {
                                    if (isText(xmlPullParser) && (text = xmlPullParser.getText()) != null && !StringsKt.isBlank(text)) {
                                        String text2 = xmlPullParser.getText();
                                        Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                                        StringsKt.trim((CharSequence) text2).toString();
                                    }
                                }
                            } else if (depth2 == 1 && isStartTag(xmlPullParser)) {
                                String name = xmlPullParser.getName();
                                if (Intrinsics.areEqual(name, "IconClickThrough")) {
                                    vastParserKt$parseIconClicksTag$1.L$0 = objectRef2;
                                    vastParserKt$parseIconClicksTag$1.L$1 = arrayList;
                                    vastParserKt$parseIconClicksTag$1.L$2 = xmlPullParser;
                                    vastParserKt$parseIconClicksTag$1.L$3 = objectRef2;
                                    vastParserKt$parseIconClicksTag$1.I$0 = depth;
                                    vastParserKt$parseIconClicksTag$1.label = 1;
                                    ?? parseTagsTextOnly = parseTagsTextOnly(xmlPullParser, vastParserKt$parseIconClicksTag$1);
                                    if (parseTagsTextOnly != coroutine_suspended) {
                                        int i3 = depth;
                                        XmlPullParser xmlPullParser3 = xmlPullParser;
                                        Ref.ObjectRef objectRef3 = objectRef2;
                                        ArrayList arrayList4 = arrayList;
                                        objectRef3.element = parseTagsTextOnly;
                                        depth = i3;
                                        xmlPullParser = xmlPullParser3;
                                        arrayList = arrayList4;
                                        objectRef2 = objectRef3;
                                    }
                                    return coroutine_suspended;
                                }
                                if (Intrinsics.areEqual(name, "IconClickTracking")) {
                                    vastParserKt$parseIconClicksTag$1.L$0 = objectRef2;
                                    vastParserKt$parseIconClicksTag$1.L$1 = arrayList;
                                    vastParserKt$parseIconClicksTag$1.L$2 = xmlPullParser;
                                    vastParserKt$parseIconClicksTag$1.L$3 = null;
                                    vastParserKt$parseIconClicksTag$1.I$0 = depth;
                                    vastParserKt$parseIconClicksTag$1.label = 2;
                                    Object parseTagsTextOnly2 = parseTagsTextOnly(xmlPullParser, vastParserKt$parseIconClicksTag$1);
                                    if (parseTagsTextOnly2 != coroutine_suspended) {
                                        ArrayList arrayList5 = arrayList;
                                        xmlPullParser2 = xmlPullParser;
                                        i2 = depth;
                                        arrayList2 = arrayList5;
                                        obj = parseTagsTextOnly2;
                                        String str22 = (String) obj;
                                        if (str22 != null) {
                                        }
                                        ArrayList arrayList32 = arrayList2;
                                        depth = i2;
                                        xmlPullParser = xmlPullParser2;
                                        arrayList = arrayList32;
                                    }
                                    return coroutine_suspended;
                                }
                                if (xmlPullParser.getDepth() >= depth) {
                                }
                            }
                            xmlPullParser.next();
                            if (xmlPullParser.getDepth() >= depth) {
                            }
                        }
                        objectRef = objectRef2;
                        str = (String) objectRef.element;
                        if (str != null) {
                            return new VastIconClicksDto(str, arrayList);
                        }
                        return null;
                    }
                    int i4 = vastParserKt$parseIconClicksTag$1.I$0;
                    Ref.ObjectRef objectRef4 = (Ref.ObjectRef) vastParserKt$parseIconClicksTag$1.L$3;
                    XmlPullParser xmlPullParser4 = (XmlPullParser) vastParserKt$parseIconClicksTag$1.L$2;
                    ?? r7 = (List) vastParserKt$parseIconClicksTag$1.L$1;
                    Ref.ObjectRef objectRef5 = (Ref.ObjectRef) vastParserKt$parseIconClicksTag$1.L$0;
                    ResultKt.throwOnFailure(r11);
                    objectRef4.element = r11;
                    depth = i4;
                    xmlPullParser = xmlPullParser4;
                    arrayList = r7;
                    objectRef2 = objectRef5;
                    xmlPullParser.next();
                    if (xmlPullParser.getDepth() >= depth) {
                    }
                    objectRef = objectRef2;
                    str = (String) objectRef.element;
                    if (str != null) {
                    }
                }
            }
        }
        vastParserKt$parseIconClicksTag$1 = new VastParserKt$parseIconClicksTag$1(continuation);
        ?? r112 = vastParserKt$parseIconClicksTag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = vastParserKt$parseIconClicksTag$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object parseHtmlResourceTag(XmlPullParser xmlPullParser, Continuation<? super VastResource.Html> continuation) {
        VastParserKt$parseHtmlResourceTag$1 vastParserKt$parseHtmlResourceTag$1;
        int i;
        String str;
        if (continuation instanceof VastParserKt$parseHtmlResourceTag$1) {
            vastParserKt$parseHtmlResourceTag$1 = (VastParserKt$parseHtmlResourceTag$1) continuation;
            if ((vastParserKt$parseHtmlResourceTag$1.label & Integer.MIN_VALUE) != 0) {
                vastParserKt$parseHtmlResourceTag$1.label -= Integer.MIN_VALUE;
                Object obj = vastParserKt$parseHtmlResourceTag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = vastParserKt$parseHtmlResourceTag$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    vastParserKt$parseHtmlResourceTag$1.label = 1;
                    obj = parseTagsTextOnly(xmlPullParser, vastParserKt$parseHtmlResourceTag$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                str = (String) obj;
                if (str == null) {
                    return new VastResource.Html(str, 0, 2, null);
                }
                return null;
            }
        }
        vastParserKt$parseHtmlResourceTag$1 = new VastParserKt$parseHtmlResourceTag$1(continuation);
        Object obj2 = vastParserKt$parseHtmlResourceTag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = vastParserKt$parseHtmlResourceTag$1.label;
        if (i != 0) {
        }
        str = (String) obj2;
        if (str == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object parseIFrameResourceTag(XmlPullParser xmlPullParser, Continuation<? super VastResource.IFrame> continuation) {
        VastParserKt$parseIFrameResourceTag$1 vastParserKt$parseIFrameResourceTag$1;
        int i;
        String str;
        if (continuation instanceof VastParserKt$parseIFrameResourceTag$1) {
            vastParserKt$parseIFrameResourceTag$1 = (VastParserKt$parseIFrameResourceTag$1) continuation;
            if ((vastParserKt$parseIFrameResourceTag$1.label & Integer.MIN_VALUE) != 0) {
                vastParserKt$parseIFrameResourceTag$1.label -= Integer.MIN_VALUE;
                Object obj = vastParserKt$parseIFrameResourceTag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = vastParserKt$parseIFrameResourceTag$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    vastParserKt$parseIFrameResourceTag$1.label = 1;
                    obj = parseTagsTextOnly(xmlPullParser, vastParserKt$parseIFrameResourceTag$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                str = (String) obj;
                if (str == null) {
                    return new VastResource.IFrame(str, 0, 2, null);
                }
                return null;
            }
        }
        vastParserKt$parseIFrameResourceTag$1 = new VastParserKt$parseIFrameResourceTag$1(continuation);
        Object obj2 = vastParserKt$parseIFrameResourceTag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = vastParserKt$parseIFrameResourceTag$1.label;
        if (i != 0) {
        }
        str = (String) obj2;
        if (str == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00dc, code lost:
    
        if (isEndTag(r7) != false) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006d -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0075 -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0084 -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0095 -> B:10:0x0098). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00a9 -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00c2 -> B:14:0x00df). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00dc -> B:14:0x00df). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object parseCompanionAdsTag(XmlPullParser xmlPullParser, Continuation<? super List<VastCompanionDto>> continuation) {
        VastParserKt$parseCompanionAdsTag$1 vastParserKt$parseCompanionAdsTag$1;
        int i;
        int depth;
        List list;
        String text;
        if (continuation instanceof VastParserKt$parseCompanionAdsTag$1) {
            vastParserKt$parseCompanionAdsTag$1 = (VastParserKt$parseCompanionAdsTag$1) continuation;
            if ((vastParserKt$parseCompanionAdsTag$1.label & Integer.MIN_VALUE) != 0) {
                vastParserKt$parseCompanionAdsTag$1.label -= Integer.MIN_VALUE;
                Object obj = vastParserKt$parseCompanionAdsTag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = vastParserKt$parseCompanionAdsTag$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ArrayList arrayList = new ArrayList();
                    if (isStartDocument(xmlPullParser)) {
                        xmlPullParser.nextTag();
                    }
                    if (isEndDocument(xmlPullParser)) {
                        return arrayList;
                    }
                    if (!isStartTag(xmlPullParser)) {
                        throw new XmlPullParserException("allowed only for START_TAG");
                    }
                    depth = xmlPullParser.getDepth();
                    list = arrayList;
                    if (xmlPullParser.getDepth() >= depth) {
                    }
                    return list;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = vastParserKt$parseCompanionAdsTag$1.I$0;
                XmlPullParser xmlPullParser2 = (XmlPullParser) vastParserKt$parseCompanionAdsTag$1.L$1;
                list = (List) vastParserKt$parseCompanionAdsTag$1.L$0;
                ResultKt.throwOnFailure(obj);
                VastCompanionDto vastCompanionDto = (VastCompanionDto) obj;
                if (vastCompanionDto != null) {
                    list.add(vastCompanionDto);
                }
                XmlPullParser xmlPullParser3 = xmlPullParser2;
                depth = i2;
                xmlPullParser = xmlPullParser3;
                xmlPullParser.next();
                if (xmlPullParser.getDepth() >= depth) {
                    int depth2 = xmlPullParser.getDepth() - depth;
                    if (depth2 == 0) {
                        if (!isStartTag(xmlPullParser)) {
                            if (isText(xmlPullParser) && (text = xmlPullParser.getText()) != null && !StringsKt.isBlank(text)) {
                                String text2 = xmlPullParser.getText();
                                Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                                StringsKt.trim((CharSequence) text2).toString();
                            }
                        }
                    } else if (depth2 == 1 && isStartTag(xmlPullParser) && Intrinsics.areEqual(xmlPullParser.getName(), "Companion")) {
                        vastParserKt$parseCompanionAdsTag$1.L$0 = list;
                        vastParserKt$parseCompanionAdsTag$1.L$1 = xmlPullParser;
                        vastParserKt$parseCompanionAdsTag$1.I$0 = depth;
                        vastParserKt$parseCompanionAdsTag$1.label = 1;
                        obj = parseCompanionTag(xmlPullParser, vastParserKt$parseCompanionAdsTag$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        int i3 = depth;
                        xmlPullParser2 = xmlPullParser;
                        i2 = i3;
                        VastCompanionDto vastCompanionDto2 = (VastCompanionDto) obj;
                        if (vastCompanionDto2 != null) {
                        }
                        XmlPullParser xmlPullParser32 = xmlPullParser2;
                        depth = i2;
                        xmlPullParser = xmlPullParser32;
                    }
                    xmlPullParser.next();
                    if (xmlPullParser.getDepth() >= depth) {
                    }
                }
                return list;
            }
        }
        vastParserKt$parseCompanionAdsTag$1 = new VastParserKt$parseCompanionAdsTag$1(continuation);
        Object obj2 = vastParserKt$parseCompanionAdsTag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = vastParserKt$parseCompanionAdsTag$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object parseAdSystemTag(XmlPullParser xmlPullParser, Continuation<? super VastAdSystemDto> continuation) {
        String str;
        String str2;
        String text;
        if (isStartDocument(xmlPullParser)) {
            xmlPullParser.nextTag();
        }
        if (isEndDocument(xmlPullParser)) {
            str = null;
            str2 = null;
        } else {
            if (!isStartTag(xmlPullParser)) {
                throw new XmlPullParserException("allowed only for START_TAG");
            }
            int depth = xmlPullParser.getDepth();
            str = null;
            str2 = null;
            while (xmlPullParser.getDepth() >= depth) {
                int depth2 = xmlPullParser.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        isStartTag(xmlPullParser);
                    }
                } else if (isStartTag(xmlPullParser)) {
                    str2 = attribute(xmlPullParser, "version");
                } else if (isText(xmlPullParser) && (text = xmlPullParser.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = xmlPullParser.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    str = StringsKt.trim((CharSequence) text2).toString();
                } else if (isEndTag(xmlPullParser)) {
                    break;
                }
                xmlPullParser.next();
            }
        }
        if (str == null && str2 == null) {
            return null;
        }
        return new VastAdSystemDto(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object parsePricingTag(XmlPullParser xmlPullParser, Continuation<? super VastPricingDto> continuation) {
        String str;
        String str2;
        String text;
        if (isStartDocument(xmlPullParser)) {
            xmlPullParser.nextTag();
        }
        if (isEndDocument(xmlPullParser)) {
            str = null;
            str2 = null;
        } else {
            if (!isStartTag(xmlPullParser)) {
                throw new XmlPullParserException("allowed only for START_TAG");
            }
            int depth = xmlPullParser.getDepth();
            str = null;
            str2 = null;
            while (xmlPullParser.getDepth() >= depth) {
                int depth2 = xmlPullParser.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        isStartTag(xmlPullParser);
                    }
                } else if (isStartTag(xmlPullParser)) {
                    str = attribute(xmlPullParser, N6.B);
                    str2 = attribute(xmlPullParser, "currency");
                } else if (isText(xmlPullParser) && (text = xmlPullParser.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = xmlPullParser.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    StringsKt.trim((CharSequence) text2).toString();
                } else if (isEndTag(xmlPullParser)) {
                    break;
                }
                xmlPullParser.next();
            }
        }
        if (str == null && str2 == null) {
            return null;
        }
        return new VastPricingDto(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object parseImpressionTag(XmlPullParser xmlPullParser, Continuation<? super VastImpressionDto> continuation) {
        String str;
        String str2;
        String text;
        if (isStartDocument(xmlPullParser)) {
            xmlPullParser.nextTag();
        }
        if (isEndDocument(xmlPullParser)) {
            str = null;
            str2 = null;
        } else {
            if (!isStartTag(xmlPullParser)) {
                throw new XmlPullParserException("allowed only for START_TAG");
            }
            int depth = xmlPullParser.getDepth();
            str = null;
            str2 = null;
            while (xmlPullParser.getDepth() >= depth) {
                int depth2 = xmlPullParser.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        isStartTag(xmlPullParser);
                    }
                } else if (isStartTag(xmlPullParser)) {
                    str = attribute(xmlPullParser, "id");
                } else if (isText(xmlPullParser) && (text = xmlPullParser.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = xmlPullParser.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    str2 = StringsKt.trim((CharSequence) text2).toString();
                } else if (isEndTag(xmlPullParser)) {
                    break;
                }
                xmlPullParser.next();
            }
        }
        if (str2 != null) {
            return new VastImpressionDto(str, str2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object parseAdParametersTag(XmlPullParser xmlPullParser, Continuation<? super VastAdParametersDto> continuation) {
        String str;
        Boolean bool;
        String text;
        if (isStartDocument(xmlPullParser)) {
            xmlPullParser.nextTag();
        }
        if (isEndDocument(xmlPullParser)) {
            str = null;
            bool = null;
        } else {
            if (!isStartTag(xmlPullParser)) {
                throw new XmlPullParserException("allowed only for START_TAG");
            }
            int depth = xmlPullParser.getDepth();
            str = null;
            bool = null;
            while (xmlPullParser.getDepth() >= depth) {
                int depth2 = xmlPullParser.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        isStartTag(xmlPullParser);
                    }
                } else if (isStartTag(xmlPullParser)) {
                    String attribute = attribute(xmlPullParser, "xmlEncoded");
                    bool = attribute != null ? Boxing.boxBoolean(Boolean.parseBoolean(attribute)) : null;
                } else if (isText(xmlPullParser) && (text = xmlPullParser.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = xmlPullParser.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    str = StringsKt.trim((CharSequence) text2).toString();
                } else if (isEndTag(xmlPullParser)) {
                    break;
                }
                xmlPullParser.next();
            }
        }
        if (str != null) {
            return new VastAdParametersDto(str, bool);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object parseMediaFileTag(XmlPullParser xmlPullParser, Continuation<? super VastMediaFileDto> continuation) {
        Object obj;
        String str;
        String str2;
        Boolean bool;
        String str3;
        Integer num;
        Integer num2;
        String str4;
        Integer num3;
        Integer num4;
        Integer num5;
        Boolean bool2;
        String str5;
        String text;
        if (isStartDocument(xmlPullParser)) {
            xmlPullParser.nextTag();
        }
        if (isEndDocument(xmlPullParser)) {
            obj = null;
            str = null;
            str2 = null;
            bool = null;
            str3 = null;
            num = null;
            num2 = null;
            str4 = null;
            num3 = null;
            num4 = null;
            num5 = null;
            bool2 = null;
            str5 = null;
        } else {
            if (!isStartTag(xmlPullParser)) {
                throw new XmlPullParserException("allowed only for START_TAG");
            }
            int depth = xmlPullParser.getDepth();
            str = null;
            str2 = null;
            bool = null;
            str3 = null;
            num = null;
            num2 = null;
            str4 = null;
            num3 = null;
            num4 = null;
            num5 = null;
            bool2 = null;
            str5 = null;
            while (true) {
                if (xmlPullParser.getDepth() < depth) {
                    obj = null;
                    break;
                }
                int depth2 = xmlPullParser.getDepth() - depth;
                if (depth2 == 0) {
                    obj = null;
                    if (isStartTag(xmlPullParser)) {
                        str2 = attribute(xmlPullParser, "id");
                        bool = Boxing.boxBoolean(Intrinsics.areEqual(attribute(xmlPullParser, "delivery"), "progressive"));
                        str3 = attribute(xmlPullParser, "type");
                        String attribute = attribute(xmlPullParser, "width");
                        num = attribute != null ? StringsKt.toIntOrNull(attribute) : null;
                        String attribute2 = attribute(xmlPullParser, "height");
                        num2 = attribute2 != null ? StringsKt.toIntOrNull(attribute2) : null;
                        str4 = attribute(xmlPullParser, VastAttributes.CODEC);
                        String attribute3 = attribute(xmlPullParser, VastAttributes.BITRATE);
                        num3 = attribute3 != null ? StringsKt.toIntOrNull(attribute3) : null;
                        String attribute4 = attribute(xmlPullParser, VastAttributes.MIN_BITRATE);
                        num4 = attribute4 != null ? StringsKt.toIntOrNull(attribute4) : null;
                        String attribute5 = attribute(xmlPullParser, VastAttributes.MAX_BITRATE);
                        num5 = attribute5 != null ? StringsKt.toIntOrNull(attribute5) : null;
                        String attribute6 = attribute(xmlPullParser, VastAttributes.SCALABLE);
                        bool2 = attribute6 != null ? Boxing.boxBoolean(Boolean.parseBoolean(attribute6)) : null;
                        str5 = attribute(xmlPullParser, "apiFramework");
                    } else if (isText(xmlPullParser) && (text = xmlPullParser.getText()) != null && !StringsKt.isBlank(text)) {
                        String text2 = xmlPullParser.getText();
                        Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                        str = StringsKt.trim((CharSequence) text2).toString();
                    } else if (isEndTag(xmlPullParser)) {
                        break;
                    }
                } else if (depth2 == 1) {
                    isStartTag(xmlPullParser);
                }
                xmlPullParser.next();
            }
        }
        return (str == null || str3 == null || bool == null) ? obj : new VastMediaFileDto(str, str2, bool.booleanValue(), str3, num, num2, str4, num3, num4, num5, bool2, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object parseTrackingTag(XmlPullParser xmlPullParser, Continuation<? super VastTracking> continuation) {
        VastTrackingEvent vastTrackingEvent;
        String str;
        VastOffset vastOffset;
        String text;
        if (isStartDocument(xmlPullParser)) {
            xmlPullParser.nextTag();
        }
        if (isEndDocument(xmlPullParser)) {
            vastTrackingEvent = null;
            str = null;
            vastOffset = null;
        } else {
            if (!isStartTag(xmlPullParser)) {
                throw new XmlPullParserException("allowed only for START_TAG");
            }
            int depth = xmlPullParser.getDepth();
            vastTrackingEvent = null;
            str = null;
            vastOffset = null;
            while (xmlPullParser.getDepth() >= depth) {
                int depth2 = xmlPullParser.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        isStartTag(xmlPullParser);
                    }
                } else if (isStartTag(xmlPullParser)) {
                    String attribute = attribute(xmlPullParser, "event");
                    vastTrackingEvent = attribute != null ? toTrackingEvent(attribute) : null;
                    String attribute2 = attribute(xmlPullParser, ATTRIBUTE_OFFSET);
                    vastOffset = attribute2 != null ? toOffset(attribute2) : null;
                } else if (isText(xmlPullParser) && (text = xmlPullParser.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = xmlPullParser.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    str = StringsKt.trim((CharSequence) text2).toString();
                } else if (isEndTag(xmlPullParser)) {
                    break;
                }
                xmlPullParser.next();
            }
        }
        if (vastTrackingEvent == null || str == null) {
            return null;
        }
        if (vastTrackingEvent == VastTrackingEvent.Progress && vastOffset == null) {
            return null;
        }
        return new VastTracking(vastTrackingEvent, str, vastOffset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object parseVideoClickTag(XmlPullParser xmlPullParser, Continuation<? super VastVideoClickDto> continuation) {
        String str;
        String str2;
        String text;
        if (isStartDocument(xmlPullParser)) {
            xmlPullParser.nextTag();
        }
        if (isEndDocument(xmlPullParser)) {
            str = null;
            str2 = null;
        } else {
            if (!isStartTag(xmlPullParser)) {
                throw new XmlPullParserException("allowed only for START_TAG");
            }
            int depth = xmlPullParser.getDepth();
            str = null;
            str2 = null;
            while (xmlPullParser.getDepth() >= depth) {
                int depth2 = xmlPullParser.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        isStartTag(xmlPullParser);
                    }
                } else if (isStartTag(xmlPullParser)) {
                    str = attribute(xmlPullParser, "id");
                } else if (isText(xmlPullParser) && (text = xmlPullParser.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = xmlPullParser.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    str2 = StringsKt.trim((CharSequence) text2).toString();
                } else if (isEndTag(xmlPullParser)) {
                    break;
                }
                xmlPullParser.next();
            }
        }
        if (str2 != null) {
            return new VastVideoClickDto(str, str2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object parseStaticResourceTag(XmlPullParser xmlPullParser, Continuation<? super VastResource> continuation) {
        String str;
        String str2;
        String text;
        if (isStartDocument(xmlPullParser)) {
            xmlPullParser.nextTag();
        }
        if (isEndDocument(xmlPullParser)) {
            str = null;
            str2 = null;
        } else {
            if (!isStartTag(xmlPullParser)) {
                throw new XmlPullParserException("allowed only for START_TAG");
            }
            int depth = xmlPullParser.getDepth();
            str = null;
            str2 = null;
            while (xmlPullParser.getDepth() >= depth) {
                int depth2 = xmlPullParser.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        isStartTag(xmlPullParser);
                    }
                } else if (isStartTag(xmlPullParser)) {
                    str2 = attribute(xmlPullParser, "creativeType");
                } else if (isText(xmlPullParser) && (text = xmlPullParser.getText()) != null && !StringsKt.isBlank(text)) {
                    String text2 = xmlPullParser.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    str = StringsKt.trim((CharSequence) text2).toString();
                } else if (isEndTag(xmlPullParser)) {
                    break;
                }
                xmlPullParser.next();
            }
        }
        if (str == null || str2 == null || !StringsKt.startsWith(str2, "image/", true)) {
            return null;
        }
        return new VastResource.Image(str, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object parseTagsTextOnly(XmlPullParser xmlPullParser, Continuation<? super String> continuation) {
        String text;
        if (isStartDocument(xmlPullParser)) {
            xmlPullParser.nextTag();
        }
        String str = null;
        if (isEndDocument(xmlPullParser)) {
            return null;
        }
        if (!isStartTag(xmlPullParser)) {
            throw new XmlPullParserException("allowed only for START_TAG");
        }
        int depth = xmlPullParser.getDepth();
        while (xmlPullParser.getDepth() >= depth) {
            int depth2 = xmlPullParser.getDepth() - depth;
            if (depth2 != 0) {
                if (depth2 == 1) {
                    isStartTag(xmlPullParser);
                }
            } else if (isStartTag(xmlPullParser)) {
                continue;
            } else if (isText(xmlPullParser) && (text = xmlPullParser.getText()) != null && !StringsKt.isBlank(text)) {
                String text2 = xmlPullParser.getText();
                Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                str = StringsKt.trim((CharSequence) text2).toString();
            } else if (isEndTag(xmlPullParser)) {
                break;
            }
            xmlPullParser.next();
        }
        return str;
    }
}
