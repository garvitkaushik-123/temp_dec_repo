package adn.analytics;

import adn.analytics.Analytics;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.ironsource.C3040d4;
import com.ironsource.C3057e4;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnalyticsDataKt.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ladn/analytics/AnalyticsDataKt;", "", "<init>", "()V", "Dsl", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnalyticsDataKt {
    public static final AnalyticsDataKt INSTANCE = new AnalyticsDataKt();

    private AnalyticsDataKt() {
    }

    /* compiled from: AnalyticsDataKt.kt */
    @Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001c\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\t\n\u0002\be\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b \b\u0007\u0018\u0000 Ø\u00032\u00020\u0001:\u0012Ø\u0003Ù\u0003Ú\u0003Û\u0003Ü\u0003Ý\u0003Þ\u0003ß\u0003à\u0003B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0010J\u0006\u0010\u0017\u001a\u00020\u0012J\u0006\u0010\u001b\u001a\u00020\u0010J\u0006\u0010\u001c\u001a\u00020\u0012J\u0006\u0010 \u001a\u00020\u0010J\u0006\u0010!\u001a\u00020\u0012J\u0006\u0010%\u001a\u00020\u0010J\u0006\u0010&\u001a\u00020\u0012J\u0006\u0010-\u001a\u00020\u0010J\u0006\u0010.\u001a\u00020\u0012J\u0006\u00102\u001a\u00020\u0010J\u0006\u00103\u001a\u00020\u0012J\u0006\u00107\u001a\u00020\u0010J\u0006\u00108\u001a\u00020\u0012J\u0006\u0010<\u001a\u00020\u0010J\u0006\u0010=\u001a\u00020\u0012J\u0006\u0010A\u001a\u00020\u0010J\u0006\u0010B\u001a\u00020\u0012J\u0006\u0010F\u001a\u00020\u0010J\u0006\u0010G\u001a\u00020\u0012J\u0006\u0010N\u001a\u00020\u0010J\u0006\u0010O\u001a\u00020\u0012J\u0006\u0010V\u001a\u00020\u0010J\u0006\u0010W\u001a\u00020\u0012J\u0006\u0010[\u001a\u00020\u0010J\u0006\u0010\\\u001a\u00020\u0012J\u0006\u0010`\u001a\u00020\u0010J\u0006\u0010a\u001a\u00020\u0012J\u0006\u0010h\u001a\u00020\u0010J\u0006\u0010i\u001a\u00020\u0012J\u0006\u0010p\u001a\u00020\u0010J\u0006\u0010q\u001a\u00020\u0012J\u0006\u0010u\u001a\u00020\u0010J\u0006\u0010v\u001a\u00020\u0012J\u0006\u0010z\u001a\u00020\u0010J\u0006\u0010{\u001a\u00020\u0012J\u0006\u0010\u007f\u001a\u00020\u0010J\u0007\u0010\u0080\u0001\u001a\u00020\u0012J\u0007\u0010\u0084\u0001\u001a\u00020\u0010J\u0007\u0010\u0085\u0001\u001a\u00020\u0012J\u0007\u0010\u0089\u0001\u001a\u00020\u0010J\u0007\u0010\u008a\u0001\u001a\u00020\u0012J\u0007\u0010\u0091\u0001\u001a\u00020\u0010J\u0007\u0010\u0092\u0001\u001a\u00020\u0012J\u0007\u0010\u0099\u0001\u001a\u00020\u0010J\u0007\u0010\u009a\u0001\u001a\u00020\u0012J\u0007\u0010 \u0001\u001a\u00020\u0010J\u0007\u0010¡\u0001\u001a\u00020\u0012J\u0007\u0010¥\u0001\u001a\u00020\u0010J\u0007\u0010¦\u0001\u001a\u00020\u0012J\u0007\u0010ª\u0001\u001a\u00020\u0010J\u0007\u0010«\u0001\u001a\u00020\u0012J\u0007\u0010¯\u0001\u001a\u00020\u0010J\u0007\u0010°\u0001\u001a\u00020\u0012J\u0007\u0010·\u0001\u001a\u00020\u0010J\u0007\u0010¸\u0001\u001a\u00020\u0012J+\u0010Â\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030¿\u00010½\u00012\u0007\u0010\b\u001a\u00030¾\u0001H\u0007¢\u0006\u0003\bÃ\u0001J,\u0010Ä\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030¿\u00010½\u00012\u0007\u0010\b\u001a\u00030¾\u0001H\u0087\n¢\u0006\u0003\bÅ\u0001J3\u0010Æ\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030¿\u00010½\u00012\u000f\u0010Ç\u0001\u001a\n\u0012\u0005\u0012\u00030¾\u00010È\u0001H\u0007¢\u0006\u0003\bÉ\u0001J4\u0010Ä\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030¿\u00010½\u00012\u000f\u0010Ç\u0001\u001a\n\u0012\u0005\u0012\u00030¾\u00010È\u0001H\u0087\n¢\u0006\u0003\bÊ\u0001J5\u0010Ë\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030¿\u00010½\u00012\u0007\u0010Ì\u0001\u001a\u00020'2\u0007\u0010\b\u001a\u00030¾\u0001H\u0087\u0002¢\u0006\u0003\bÍ\u0001J\"\u0010Î\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030¿\u00010½\u0001H\u0007¢\u0006\u0003\bÏ\u0001J+\u0010Â\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030Ñ\u00010½\u00012\u0007\u0010\b\u001a\u00030¾\u0001H\u0007¢\u0006\u0003\bÓ\u0001J,\u0010Ä\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030Ñ\u00010½\u00012\u0007\u0010\b\u001a\u00030¾\u0001H\u0087\n¢\u0006\u0003\bÔ\u0001J3\u0010Æ\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030Ñ\u00010½\u00012\u000f\u0010Ç\u0001\u001a\n\u0012\u0005\u0012\u00030¾\u00010È\u0001H\u0007¢\u0006\u0003\bÕ\u0001J4\u0010Ä\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030Ñ\u00010½\u00012\u000f\u0010Ç\u0001\u001a\n\u0012\u0005\u0012\u00030¾\u00010È\u0001H\u0087\n¢\u0006\u0003\bÖ\u0001J5\u0010Ë\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030Ñ\u00010½\u00012\u0007\u0010Ì\u0001\u001a\u00020'2\u0007\u0010\b\u001a\u00030¾\u0001H\u0087\u0002¢\u0006\u0003\b×\u0001J\"\u0010Î\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030Ñ\u00010½\u0001H\u0007¢\u0006\u0003\bØ\u0001J+\u0010Â\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030Ú\u00010½\u00012\u0007\u0010\b\u001a\u00030¾\u0001H\u0007¢\u0006\u0003\bÜ\u0001J,\u0010Ä\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030Ú\u00010½\u00012\u0007\u0010\b\u001a\u00030¾\u0001H\u0087\n¢\u0006\u0003\bÝ\u0001J3\u0010Æ\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030Ú\u00010½\u00012\u000f\u0010Ç\u0001\u001a\n\u0012\u0005\u0012\u00030¾\u00010È\u0001H\u0007¢\u0006\u0003\bÞ\u0001J4\u0010Ä\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030Ú\u00010½\u00012\u000f\u0010Ç\u0001\u001a\n\u0012\u0005\u0012\u00030¾\u00010È\u0001H\u0087\n¢\u0006\u0003\bß\u0001J5\u0010Ë\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030Ú\u00010½\u00012\u0007\u0010Ì\u0001\u001a\u00020'2\u0007\u0010\b\u001a\u00030¾\u0001H\u0087\u0002¢\u0006\u0003\bà\u0001J\"\u0010Î\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030Ú\u00010½\u0001H\u0007¢\u0006\u0003\bá\u0001J\u0007\u0010å\u0001\u001a\u00020\u0010J\u0007\u0010æ\u0001\u001a\u00020\u0012J\u0007\u0010ê\u0001\u001a\u00020\u0010J\u0007\u0010î\u0001\u001a\u00020\u0010J\u0007\u0010ï\u0001\u001a\u00020\u0012J+\u0010Â\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030ñ\u0001\u0012\u0005\u0012\u00030ò\u00010½\u00012\u0007\u0010\b\u001a\u00030ñ\u0001H\u0007¢\u0006\u0003\bô\u0001J,\u0010Ä\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030ñ\u0001\u0012\u0005\u0012\u00030ò\u00010½\u00012\u0007\u0010\b\u001a\u00030ñ\u0001H\u0087\n¢\u0006\u0003\bõ\u0001J3\u0010Æ\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030ñ\u0001\u0012\u0005\u0012\u00030ò\u00010½\u00012\u000f\u0010Ç\u0001\u001a\n\u0012\u0005\u0012\u00030ñ\u00010È\u0001H\u0007¢\u0006\u0003\bö\u0001J4\u0010Ä\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030ñ\u0001\u0012\u0005\u0012\u00030ò\u00010½\u00012\u000f\u0010Ç\u0001\u001a\n\u0012\u0005\u0012\u00030ñ\u00010È\u0001H\u0087\n¢\u0006\u0003\b÷\u0001J5\u0010Ë\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030ñ\u0001\u0012\u0005\u0012\u00030ò\u00010½\u00012\u0007\u0010Ì\u0001\u001a\u00020'2\u0007\u0010\b\u001a\u00030ñ\u0001H\u0087\u0002¢\u0006\u0003\bø\u0001J\"\u0010Î\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030ñ\u0001\u0012\u0005\u0012\u00030ò\u00010½\u0001H\u0007¢\u0006\u0003\bù\u0001J\u0007\u0010ý\u0001\u001a\u00020\u0010J\u0007\u0010þ\u0001\u001a\u00020\u0012J\u0007\u0010\u0082\u0002\u001a\u00020\u0010J\u0007\u0010\u0083\u0002\u001a\u00020\u0012J\u0007\u0010\u0087\u0002\u001a\u00020\u0010J\u0007\u0010\u0088\u0002\u001a\u00020\u0012J\u0007\u0010\u008c\u0002\u001a\u00020\u0010J\u0007\u0010\u008d\u0002\u001a\u00020\u0012J\u0007\u0010\u0091\u0002\u001a\u00020\u0010J\u0007\u0010\u0092\u0002\u001a\u00020\u0012J\u0007\u0010\u0096\u0002\u001a\u00020\u0010J\u0007\u0010\u0097\u0002\u001a\u00020\u0012J\u0007\u0010\u009e\u0002\u001a\u00020\u0010J\u0007\u0010\u009f\u0002\u001a\u00020\u0012J\u0007\u0010£\u0002\u001a\u00020\u0010J\u0007\u0010¤\u0002\u001a\u00020\u0012J\u0007\u0010¨\u0002\u001a\u00020\u0010J\u0007\u0010©\u0002\u001a\u00020\u0012J\u0007\u0010\u00ad\u0002\u001a\u00020\u0010J\u0007\u0010®\u0002\u001a\u00020\u0012J\u0007\u0010²\u0002\u001a\u00020\u0010J\u0007\u0010³\u0002\u001a\u00020\u0012J\u0007\u0010·\u0002\u001a\u00020\u0010J\u0007\u0010¸\u0002\u001a\u00020\u0012J\u0007\u0010¼\u0002\u001a\u00020\u0010J\u0007\u0010À\u0002\u001a\u00020\u0010J\u0007\u0010Ä\u0002\u001a\u00020\u0010J\u0007\u0010Å\u0002\u001a\u00020\u0012J\u0007\u0010É\u0002\u001a\u00020\u0010J\u0007\u0010Ê\u0002\u001a\u00020\u0012J\u0007\u0010Î\u0002\u001a\u00020\u0010J\u0007\u0010Ò\u0002\u001a\u00020\u0010J\u0007\u0010Ö\u0002\u001a\u00020\u0010J\u0007\u0010Ú\u0002\u001a\u00020\u0010J\u0007\u0010Þ\u0002\u001a\u00020\u0010J\u0007\u0010â\u0002\u001a\u00020\u0010J\u0007\u0010ã\u0002\u001a\u00020\u0012J\u0007\u0010ç\u0002\u001a\u00020\u0010J\u0007\u0010è\u0002\u001a\u00020\u0012J\u0007\u0010ì\u0002\u001a\u00020\u0010J\u0007\u0010í\u0002\u001a\u00020\u0012J\u0007\u0010ñ\u0002\u001a\u00020\u0010J\u0007\u0010ò\u0002\u001a\u00020\u0012J\u0007\u0010ö\u0002\u001a\u00020\u0010J\u0007\u0010÷\u0002\u001a\u00020\u0012J\u0007\u0010û\u0002\u001a\u00020\u0010J\u0007\u0010ü\u0002\u001a\u00020\u0012J)\u0010Â\u0001\u001a\u00020\u0010*\u0010\u0012\u0004\u0012\u00020\t\u0012\u0005\u0012\u00030þ\u00020½\u00012\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0003\b\u0080\u0003J*\u0010Ä\u0001\u001a\u00020\u0010*\u0010\u0012\u0004\u0012\u00020\t\u0012\u0005\u0012\u00030þ\u00020½\u00012\u0006\u0010\b\u001a\u00020\tH\u0087\n¢\u0006\u0003\b\u0081\u0003J1\u0010Æ\u0001\u001a\u00020\u0010*\u0010\u0012\u0004\u0012\u00020\t\u0012\u0005\u0012\u00030þ\u00020½\u00012\u000e\u0010Ç\u0001\u001a\t\u0012\u0004\u0012\u00020\t0È\u0001H\u0007¢\u0006\u0003\b\u0082\u0003J2\u0010Ä\u0001\u001a\u00020\u0010*\u0010\u0012\u0004\u0012\u00020\t\u0012\u0005\u0012\u00030þ\u00020½\u00012\u000e\u0010Ç\u0001\u001a\t\u0012\u0004\u0012\u00020\t0È\u0001H\u0087\n¢\u0006\u0003\b\u0083\u0003J3\u0010Ë\u0001\u001a\u00020\u0010*\u0010\u0012\u0004\u0012\u00020\t\u0012\u0005\u0012\u00030þ\u00020½\u00012\u0007\u0010Ì\u0001\u001a\u00020'2\u0006\u0010\b\u001a\u00020\tH\u0087\u0002¢\u0006\u0003\b\u0084\u0003J!\u0010Î\u0001\u001a\u00020\u0010*\u0010\u0012\u0004\u0012\u00020\t\u0012\u0005\u0012\u00030þ\u00020½\u0001H\u0007¢\u0006\u0003\b\u0085\u0003J\u0007\u0010\u0089\u0003\u001a\u00020\u0010J\u0007\u0010\u008d\u0003\u001a\u00020\u0010J\u0007\u0010\u008e\u0003\u001a\u00020\u0012J\u0007\u0010\u0092\u0003\u001a\u00020\u0010J\u0007\u0010\u0093\u0003\u001a\u00020\u0012J\u0007\u0010\u0097\u0003\u001a\u00020\u0010J\u0007\u0010\u0098\u0003\u001a\u00020\u0012J\u0007\u0010\u009c\u0003\u001a\u00020\u0010J\u0007\u0010\u009d\u0003\u001a\u00020\u0012J\u0007\u0010¡\u0003\u001a\u00020\u0010J\u0007\u0010¢\u0003\u001a\u00020\u0012J\u0007\u0010¦\u0003\u001a\u00020\u0010J\u0007\u0010§\u0003\u001a\u00020\u0012J\u0007\u0010«\u0003\u001a\u00020\u0010J\u0007\u0010¬\u0003\u001a\u00020\u0012J+\u0010Â\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030¯\u00030½\u00012\u0007\u0010\b\u001a\u00030®\u0003H\u0007¢\u0006\u0003\b±\u0003J,\u0010Ä\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030¯\u00030½\u00012\u0007\u0010\b\u001a\u00030®\u0003H\u0087\n¢\u0006\u0003\b²\u0003J3\u0010Æ\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030¯\u00030½\u00012\u000f\u0010Ç\u0001\u001a\n\u0012\u0005\u0012\u00030®\u00030È\u0001H\u0007¢\u0006\u0003\b³\u0003J4\u0010Ä\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030¯\u00030½\u00012\u000f\u0010Ç\u0001\u001a\n\u0012\u0005\u0012\u00030®\u00030È\u0001H\u0087\n¢\u0006\u0003\b´\u0003J5\u0010Ë\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030¯\u00030½\u00012\u0007\u0010Ì\u0001\u001a\u00020'2\u0007\u0010\b\u001a\u00030®\u0003H\u0087\u0002¢\u0006\u0003\bµ\u0003J\"\u0010Î\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030¯\u00030½\u0001H\u0007¢\u0006\u0003\b¶\u0003J+\u0010Â\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030¸\u00030½\u00012\u0007\u0010\b\u001a\u00030®\u0003H\u0007¢\u0006\u0003\bº\u0003J,\u0010Ä\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030¸\u00030½\u00012\u0007\u0010\b\u001a\u00030®\u0003H\u0087\n¢\u0006\u0003\b»\u0003J3\u0010Æ\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030¸\u00030½\u00012\u000f\u0010Ç\u0001\u001a\n\u0012\u0005\u0012\u00030®\u00030È\u0001H\u0007¢\u0006\u0003\b¼\u0003J4\u0010Ä\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030¸\u00030½\u00012\u000f\u0010Ç\u0001\u001a\n\u0012\u0005\u0012\u00030®\u00030È\u0001H\u0087\n¢\u0006\u0003\b½\u0003J5\u0010Ë\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030¸\u00030½\u00012\u0007\u0010Ì\u0001\u001a\u00020'2\u0007\u0010\b\u001a\u00030®\u0003H\u0087\u0002¢\u0006\u0003\b¾\u0003J\"\u0010Î\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030¸\u00030½\u0001H\u0007¢\u0006\u0003\b¿\u0003J+\u0010Â\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030Á\u00030½\u00012\u0007\u0010\b\u001a\u00030®\u0003H\u0007¢\u0006\u0003\bÃ\u0003J,\u0010Ä\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030Á\u00030½\u00012\u0007\u0010\b\u001a\u00030®\u0003H\u0087\n¢\u0006\u0003\bÄ\u0003J3\u0010Æ\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030Á\u00030½\u00012\u000f\u0010Ç\u0001\u001a\n\u0012\u0005\u0012\u00030®\u00030È\u0001H\u0007¢\u0006\u0003\bÅ\u0003J4\u0010Ä\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030Á\u00030½\u00012\u000f\u0010Ç\u0001\u001a\n\u0012\u0005\u0012\u00030®\u00030È\u0001H\u0087\n¢\u0006\u0003\bÆ\u0003J5\u0010Ë\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030Á\u00030½\u00012\u0007\u0010Ì\u0001\u001a\u00020'2\u0007\u0010\b\u001a\u00030®\u0003H\u0087\u0002¢\u0006\u0003\bÇ\u0003J\"\u0010Î\u0001\u001a\u00020\u0010*\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030Á\u00030½\u0001H\u0007¢\u0006\u0003\bÈ\u0003J\u0007\u0010Ì\u0003\u001a\u00020\u0010J\u0007\u0010Í\u0003\u001a\u00020\u0012J\u0007\u0010Ñ\u0003\u001a\u00020\u0010J\u0007\u0010Ò\u0003\u001a\u00020\u0012J\u0007\u0010Ö\u0003\u001a\u00020\u0010J\u0007\u0010×\u0003\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR$\u0010\u0018\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR$\u0010\u001d\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR$\u0010\"\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR$\u0010(\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010/\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010*\"\u0004\b1\u0010,R$\u00104\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b5\u0010\f\"\u0004\b6\u0010\u000eR$\u00109\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b:\u0010\f\"\u0004\b;\u0010\u000eR$\u0010>\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u0010*\"\u0004\b@\u0010,R$\u0010C\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bD\u0010*\"\u0004\bE\u0010,R$\u0010I\u001a\u00020H2\u0006\u0010\b\u001a\u00020H8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0017\u0010P\u001a\u0004\u0018\u00010H*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bQ\u0010RR$\u0010S\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010*\"\u0004\bU\u0010,R$\u0010X\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bY\u0010*\"\u0004\bZ\u0010,R$\u0010]\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010*\"\u0004\b_\u0010,R$\u0010c\u001a\u00020b2\u0006\u0010\b\u001a\u00020b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0017\u0010j\u001a\u0004\u0018\u00010b*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bk\u0010lR$\u0010m\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bn\u0010*\"\u0004\bo\u0010,R$\u0010r\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bs\u0010*\"\u0004\bt\u0010,R$\u0010w\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bx\u0010*\"\u0004\by\u0010,R$\u0010|\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b}\u0010*\"\u0004\b~\u0010,R'\u0010\u0081\u0001\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0082\u0001\u0010*\"\u0005\b\u0083\u0001\u0010,R'\u0010\u0086\u0001\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0087\u0001\u0010*\"\u0005\b\u0088\u0001\u0010,R+\u0010\u008c\u0001\u001a\u00030\u008b\u00012\u0007\u0010\b\u001a\u00030\u008b\u00018G@GX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001b\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u008b\u0001*\u00020\u00008F¢\u0006\b\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R+\u0010\u0096\u0001\u001a\u00030\u008b\u00012\u0007\u0010\b\u001a\u00030\u008b\u00018G@GX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0097\u0001\u0010\u008e\u0001\"\u0006\b\u0098\u0001\u0010\u0090\u0001R\u001b\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u008b\u0001*\u00020\u00008F¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u0095\u0001R'\u0010\u009d\u0001\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009e\u0001\u0010\f\"\u0005\b\u009f\u0001\u0010\u000eR'\u0010¢\u0001\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b£\u0001\u0010\f\"\u0005\b¤\u0001\u0010\u000eR'\u0010§\u0001\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¨\u0001\u0010\f\"\u0005\b©\u0001\u0010\u000eR'\u0010¬\u0001\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u00ad\u0001\u0010*\"\u0005\b®\u0001\u0010,R+\u0010²\u0001\u001a\u00030±\u00012\u0007\u0010\b\u001a\u00030±\u00018G@GX\u0086\u000e¢\u0006\u0010\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R\u001b\u0010¹\u0001\u001a\u0005\u0018\u00010±\u0001*\u00020\u00008F¢\u0006\b\u001a\u0006\bº\u0001\u0010»\u0001R#\u0010¼\u0001\u001a\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030¿\u00010½\u00018F¢\u0006\b\u001a\u0006\bÀ\u0001\u0010Á\u0001R#\u0010Ð\u0001\u001a\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030Ñ\u00010½\u00018F¢\u0006\b\u001a\u0006\bÒ\u0001\u0010Á\u0001R#\u0010Ù\u0001\u001a\u0011\u0012\u0005\u0012\u00030¾\u0001\u0012\u0005\u0012\u00030Ú\u00010½\u00018F¢\u0006\b\u001a\u0006\bÛ\u0001\u0010Á\u0001R'\u0010â\u0001\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bã\u0001\u0010*\"\u0005\bä\u0001\u0010,R'\u0010ç\u0001\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bè\u0001\u0010*\"\u0005\bé\u0001\u0010,R'\u0010ë\u0001\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bì\u0001\u0010\f\"\u0005\bí\u0001\u0010\u000eR#\u0010ð\u0001\u001a\u0011\u0012\u0005\u0012\u00030ñ\u0001\u0012\u0005\u0012\u00030ò\u00010½\u00018F¢\u0006\b\u001a\u0006\bó\u0001\u0010Á\u0001R'\u0010ú\u0001\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bû\u0001\u0010*\"\u0005\bü\u0001\u0010,R'\u0010ÿ\u0001\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0080\u0002\u0010*\"\u0005\b\u0081\u0002\u0010,R'\u0010\u0084\u0002\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0085\u0002\u0010\f\"\u0005\b\u0086\u0002\u0010\u000eR'\u0010\u0089\u0002\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008a\u0002\u0010*\"\u0005\b\u008b\u0002\u0010,R'\u0010\u008e\u0002\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008f\u0002\u0010*\"\u0005\b\u0090\u0002\u0010,R'\u0010\u0093\u0002\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0094\u0002\u0010*\"\u0005\b\u0095\u0002\u0010,R+\u0010\u0099\u0002\u001a\u00030\u0098\u00022\u0007\u0010\b\u001a\u00030\u0098\u00028G@GX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u009a\u0002\u0010\u009b\u0002\"\u0006\b\u009c\u0002\u0010\u009d\u0002R+\u0010 \u0002\u001a\u00030\u0098\u00022\u0007\u0010\b\u001a\u00030\u0098\u00028G@GX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¡\u0002\u0010\u009b\u0002\"\u0006\b¢\u0002\u0010\u009d\u0002R'\u0010¥\u0002\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¦\u0002\u0010*\"\u0005\b§\u0002\u0010,R'\u0010ª\u0002\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b«\u0002\u0010\f\"\u0005\b¬\u0002\u0010\u000eR'\u0010¯\u0002\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b°\u0002\u0010\f\"\u0005\b±\u0002\u0010\u000eR'\u0010´\u0002\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bµ\u0002\u0010*\"\u0005\b¶\u0002\u0010,R'\u0010¹\u0002\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bº\u0002\u0010*\"\u0005\b»\u0002\u0010,R'\u0010½\u0002\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¾\u0002\u0010*\"\u0005\b¿\u0002\u0010,R'\u0010Á\u0002\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÂ\u0002\u0010\f\"\u0005\bÃ\u0002\u0010\u000eR'\u0010Æ\u0002\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÇ\u0002\u0010\f\"\u0005\bÈ\u0002\u0010\u000eR'\u0010Ë\u0002\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÌ\u0002\u0010\f\"\u0005\bÍ\u0002\u0010\u000eR'\u0010Ï\u0002\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÐ\u0002\u0010\f\"\u0005\bÑ\u0002\u0010\u000eR'\u0010Ó\u0002\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÔ\u0002\u0010*\"\u0005\bÕ\u0002\u0010,R'\u0010×\u0002\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bØ\u0002\u0010\f\"\u0005\bÙ\u0002\u0010\u000eR'\u0010Û\u0002\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÜ\u0002\u0010\f\"\u0005\bÝ\u0002\u0010\u000eR'\u0010ß\u0002\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bà\u0002\u0010*\"\u0005\bá\u0002\u0010,R'\u0010ä\u0002\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bå\u0002\u0010*\"\u0005\bæ\u0002\u0010,R'\u0010é\u0002\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bê\u0002\u0010*\"\u0005\bë\u0002\u0010,R'\u0010î\u0002\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bï\u0002\u0010*\"\u0005\bð\u0002\u0010,R'\u0010ó\u0002\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bô\u0002\u0010*\"\u0005\bõ\u0002\u0010,R'\u0010ø\u0002\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bù\u0002\u0010*\"\u0005\bú\u0002\u0010,R\"\u0010ý\u0002\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0005\u0012\u00030þ\u00020½\u00018F¢\u0006\b\u001a\u0006\bÿ\u0002\u0010Á\u0001R'\u0010\u0086\u0003\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0087\u0003\u0010\f\"\u0005\b\u0088\u0003\u0010\u000eR'\u0010\u008a\u0003\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008b\u0003\u0010*\"\u0005\b\u008c\u0003\u0010,R'\u0010\u008f\u0003\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0090\u0003\u0010\f\"\u0005\b\u0091\u0003\u0010\u000eR'\u0010\u0094\u0003\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0095\u0003\u0010\f\"\u0005\b\u0096\u0003\u0010\u000eR'\u0010\u0099\u0003\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009a\u0003\u0010\f\"\u0005\b\u009b\u0003\u0010\u000eR'\u0010\u009e\u0003\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009f\u0003\u0010\f\"\u0005\b \u0003\u0010\u000eR'\u0010£\u0003\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¤\u0003\u0010\f\"\u0005\b¥\u0003\u0010\u000eR'\u0010¨\u0003\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b©\u0003\u0010\f\"\u0005\bª\u0003\u0010\u000eR#\u0010\u00ad\u0003\u001a\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030¯\u00030½\u00018F¢\u0006\b\u001a\u0006\b°\u0003\u0010Á\u0001R#\u0010·\u0003\u001a\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030¸\u00030½\u00018F¢\u0006\b\u001a\u0006\b¹\u0003\u0010Á\u0001R#\u0010À\u0003\u001a\u0011\u0012\u0005\u0012\u00030®\u0003\u0012\u0005\u0012\u00030Á\u00030½\u00018F¢\u0006\b\u001a\u0006\bÂ\u0003\u0010Á\u0001R'\u0010É\u0003\u001a\u00020'2\u0006\u0010\b\u001a\u00020'8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÊ\u0003\u0010*\"\u0005\bË\u0003\u0010,R'\u0010Î\u0003\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÏ\u0003\u0010\f\"\u0005\bÐ\u0003\u0010\u000eR+\u0010Ó\u0003\u001a\u00030\u0098\u00022\u0007\u0010\b\u001a\u00030\u0098\u00028G@GX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÔ\u0003\u0010\u009b\u0002\"\u0006\bÕ\u0003\u0010\u009d\u0002¨\u0006á\u0003"}, d2 = {"Ladn/analytics/AnalyticsDataKt$Dsl;", "", "_builder", "Ladn/analytics/Analytics$AnalyticsData$Builder;", "<init>", "(Ladn/analytics/Analytics$AnalyticsData$Builder;)V", "_build", "Ladn/analytics/Analytics$AnalyticsData;", "value", "", "unityVersion", "getUnityVersion", "()Ljava/lang/String;", "setUnityVersion", "(Ljava/lang/String;)V", "clearUnityVersion", "", "hasUnityVersion", "", "vsauceVersion", "getVsauceVersion", "setVsauceVersion", "clearVsauceVersion", "hasVsauceVersion", JsonStorageKeyNames.SESSION_ID_KEY, "getSessionId", "setSessionId", "clearSessionId", "hasSessionId", "installDate", "getInstallDate", "setInstallDate", "clearInstallDate", "hasInstallDate", "sessionStartDate", "getSessionStartDate", "setSessionStartDate", "clearSessionStartDate", "hasSessionStartDate", "", "appOpenCountSinceInstall", "getAppOpenCountSinceInstall", "()I", "setAppOpenCountSinceInstall", "(I)V", "clearAppOpenCountSinceInstall", "hasAppOpenCountSinceInstall", "sessionCountSinceInstall", "getSessionCountSinceInstall", "setSessionCountSinceInstall", "clearSessionCountSinceInstall", "hasSessionCountSinceInstall", "vanUserId", "getVanUserId", "setVanUserId", "clearVanUserId", "hasVanUserId", "mmpId", "getMmpId", "setMmpId", "clearMmpId", "hasMmpId", "gameCountSinceInstall", "getGameCountSinceInstall", "setGameCountSinceInstall", "clearGameCountSinceInstall", "hasGameCountSinceInstall", "gameCount", "getGameCount", "setGameCount", "clearGameCount", "hasGameCount", "Ladn/analytics/Analytics$PerformanceMetrics;", "perfMetrics", "getPerfMetrics", "()Ladn/analytics/Analytics$PerformanceMetrics;", "setPerfMetrics", "(Ladn/analytics/Analytics$PerformanceMetrics;)V", "clearPerfMetrics", "hasPerfMetrics", "perfMetricsOrNull", "getPerfMetricsOrNull", "(Ladn/analytics/AnalyticsDataKt$Dsl;)Ladn/analytics/Analytics$PerformanceMetrics;", "gameCountSuccess", "getGameCountSuccess", "setGameCountSuccess", "clearGameCountSuccess", "hasGameCountSuccess", "playTime", "getPlayTime", "setPlayTime", "clearPlayTime", "hasPlayTime", "totalTime", "getTotalTime", "setTotalTime", "clearTotalTime", "hasTotalTime", "Ladn/analytics/Analytics$Attribution;", C3057e4.c, "getAttribution", "()Ladn/analytics/Analytics$Attribution;", "setAttribution", "(Ladn/analytics/Analytics$Attribution;)V", "clearAttribution", "hasAttribution", "attributionOrNull", "getAttributionOrNull", "(Ladn/analytics/AnalyticsDataKt$Dsl;)Ladn/analytics/Analytics$Attribution;", "fsLoadIndex", "getFsLoadIndex", "setFsLoadIndex", "clearFsLoadIndex", "hasFsLoadIndex", "rvLoadIndex", "getRvLoadIndex", "setRvLoadIndex", "clearRvLoadIndex", "hasRvLoadIndex", "fsCountSinceInstall", "getFsCountSinceInstall", "setFsCountSinceInstall", "clearFsCountSinceInstall", "hasFsCountSinceInstall", "rvCountSinceInstall", "getRvCountSinceInstall", "setRvCountSinceInstall", "clearRvCountSinceInstall", "hasRvCountSinceInstall", "fsClickCountSinceInstall", "getFsClickCountSinceInstall", "setFsClickCountSinceInstall", "clearFsClickCountSinceInstall", "hasFsClickCountSinceInstall", "rvClickCountSinceInstall", "getRvClickCountSinceInstall", "setRvClickCountSinceInstall", "clearRvClickCountSinceInstall", "hasRvClickCountSinceInstall", "Ladn/analytics/Analytics$RevenueGeneration;", "revGen", "getRevGen", "()Ladn/analytics/Analytics$RevenueGeneration;", "setRevGen", "(Ladn/analytics/Analytics$RevenueGeneration;)V", "clearRevGen", "hasRevGen", "revGenOrNull", "getRevGenOrNull", "(Ladn/analytics/AnalyticsDataKt$Dsl;)Ladn/analytics/Analytics$RevenueGeneration;", "revGenSinceInstall", "getRevGenSinceInstall", "setRevGenSinceInstall", "clearRevGenSinceInstall", "hasRevGenSinceInstall", "revGenSinceInstallOrNull", "getRevGenSinceInstallOrNull", "vanImpressionId", "getVanImpressionId", "setVanImpressionId", "clearVanImpressionId", "hasVanImpressionId", "vanFsImpressionId", "getVanFsImpressionId", "setVanFsImpressionId", "clearVanFsImpressionId", "hasVanFsImpressionId", "vanRvImpressionId", "getVanRvImpressionId", "setVanRvImpressionId", "clearVanRvImpressionId", "hasVanRvImpressionId", "countReq", "getCountReq", "setCountReq", "clearCountReq", "hasCountReq", "Ladn/analytics/Analytics$LastClick;", "hasLastClick", "getHasLastClick", "()Ladn/analytics/Analytics$LastClick;", "setHasLastClick", "(Ladn/analytics/Analytics$LastClick;)V", "clearHasLastClick", "hasHasLastClick", "hasLastClickOrNull", "getHasLastClickOrNull", "(Ladn/analytics/AnalyticsDataKt$Dsl;)Ladn/analytics/Analytics$LastClick;", "lastXSessionDesc", "Lcom/google/protobuf/kotlin/DslList;", "Ladn/analytics/Analytics$AdInfo;", "Ladn/analytics/AnalyticsDataKt$Dsl$LastXSessionDescProxy;", "getLastXSessionDesc", "()Lcom/google/protobuf/kotlin/DslList;", "add", "addLastXSessionDesc", "plusAssign", "plusAssignLastXSessionDesc", "addAll", "values", "", "addAllLastXSessionDesc", "plusAssignAllLastXSessionDesc", "set", FirebaseAnalytics.Param.INDEX, "setLastXSessionDesc", "clear", "clearLastXSessionDesc", "prevXSessionDesc", "Ladn/analytics/AnalyticsDataKt$Dsl$PrevXSessionDescProxy;", "getPrevXSessionDesc", "addPrevXSessionDesc", "plusAssignPrevXSessionDesc", "addAllPrevXSessionDesc", "plusAssignAllPrevXSessionDesc", "setPrevXSessionDesc", "clearPrevXSessionDesc", "firstXSessionDesc", "Ladn/analytics/AnalyticsDataKt$Dsl$FirstXSessionDescProxy;", "getFirstXSessionDesc", "addFirstXSessionDesc", "plusAssignFirstXSessionDesc", "addAllFirstXSessionDesc", "plusAssignAllFirstXSessionDesc", "setFirstXSessionDesc", "clearFirstXSessionDesc", "hasSkipPriorRv", "getHasSkipPriorRv", "setHasSkipPriorRv", "clearHasSkipPriorRv", "hasHasSkipPriorRv", "adsConsentGiven", "getAdsConsentGiven", "setAdsConsentGiven", "clearAdsConsentGiven", "idfaAuthorizationStatus", "getIdfaAuthorizationStatus", "setIdfaAuthorizationStatus", "clearIdfaAuthorizationStatus", "hasIdfaAuthorizationStatus", "purchaseSinceInstall", "Ladn/analytics/Analytics$Purchase;", "Ladn/analytics/AnalyticsDataKt$Dsl$PurchaseSinceInstallProxy;", "getPurchaseSinceInstall", "addPurchaseSinceInstall", "plusAssignPurchaseSinceInstall", "addAllPurchaseSinceInstall", "plusAssignAllPurchaseSinceInstall", "setPurchaseSinceInstall", "clearPurchaseSinceInstall", "isPremium", "getIsPremium", "setIsPremium", "clearIsPremium", "hasIsPremium", "airplaneModeEnable", "getAirplaneModeEnable", "setAirplaneModeEnable", "clearAirplaneModeEnable", "hasAirplaneModeEnable", "connectivity", "getConnectivity", "setConnectivity", "clearConnectivity", "hasConnectivity", BidTokenRepositoryKt.BATTERY, "getBattery", "setBattery", "clearBattery", "hasBattery", "batterySaverEnable", "getBatterySaverEnable", "setBatterySaverEnable", "clearBatterySaverEnable", "hasBatterySaverEnable", "battCharge", "getBattCharge", "setBattCharge", "clearBattCharge", "hasBattCharge", "", "availableDiskSpace", MRAIDPresenter.GET_AVAILABLE_DISK_SPACE, "()J", "setAvailableDiskSpace", "(J)V", "clearAvailableDiskSpace", "hasAvailableDiskSpace", "totalDiskSpace", "getTotalDiskSpace", "setTotalDiskSpace", "clearTotalDiskSpace", "hasTotalDiskSpace", "doNotDist", "getDoNotDist", "setDoNotDist", "clearDoNotDist", "hasDoNotDist", "gaid", "getGaid", "setGaid", "clearGaid", "hasGaid", "appsetId", "getAppsetId", "setAppsetId", "clearAppsetId", "hasAppsetId", "limitAdTracking", "getLimitAdTracking", "setLimitAdTracking", "clearLimitAdTracking", "hasLimitAdTracking", "globalTokenIndex", "getGlobalTokenIndex", "setGlobalTokenIndex", "clearGlobalTokenIndex", "tokenIndex", "getTokenIndex", "setTokenIndex", "clearTokenIndex", "utcDate", "getUtcDate", "setUtcDate", "clearUtcDate", "hasUtcDate", "localDate", "getLocalDate", "setLocalDate", "clearLocalDate", "hasLocalDate", "sdkVersion", "getSdkVersion", "setSdkVersion", "clearSdkVersion", C3040d4.i.W, "getAppVersion", "setAppVersion", "clearAppVersion", "testMode", "getTestMode", "setTestMode", "clearTestMode", "deviceModel", "getDeviceModel", "setDeviceModel", "clearDeviceModel", "deviceManufacturer", "getDeviceManufacturer", "setDeviceManufacturer", "clearDeviceManufacturer", "bluetooth", "getBluetooth", "setBluetooth", "clearBluetooth", "hasBluetooth", "darkModeEnable", "getDarkModeEnable", "setDarkModeEnable", "clearDarkModeEnable", "hasDarkModeEnable", BidTokenRepositoryKt.HEADSET, "getHeadset", "setHeadset", "clearHeadset", "hasHeadset", "soundEnable", "getSoundEnable", "setSoundEnable", "clearSoundEnable", "hasSoundEnable", BidTokenRepositoryKt.PPI, "getPpi", "setPpi", "clearPpi", "hasPpi", "isWalking", "getIsWalking", "setIsWalking", "clearIsWalking", "hasIsWalking", "keyboardLang", "Ladn/analytics/AnalyticsDataKt$Dsl$KeyboardLangProxy;", "getKeyboardLang", "addKeyboardLang", "plusAssignKeyboardLang", "addAllKeyboardLang", "plusAssignAllKeyboardLang", "setKeyboardLang", "clearKeyboardLang", "orientation", "getOrientation", "setOrientation", "clearOrientation", "doNotSell", "getDoNotSell", "setDoNotSell", "clearDoNotSell", "hasDoNotSell", "prevSessionStartDate", "getPrevSessionStartDate", "setPrevSessionStartDate", "clearPrevSessionStartDate", "hasPrevSessionStartDate", "date", "getDate", "setDate", "clearDate", "hasDate", "idfv", "getIdfv", "setIdfv", "clearIdfv", "hasIdfv", "idfa", "getIdfa", "setIdfa", "clearIdfa", "hasIdfa", "appstoreId", "getAppstoreId", "setAppstoreId", "clearAppstoreId", "hasAppstoreId", "pluginVersion", "getPluginVersion", "setPluginVersion", "clearPluginVersion", "hasPluginVersion", "countWonReq", "Ladn/analytics/Analytics$CountInfo;", "Ladn/analytics/AnalyticsDataKt$Dsl$CountWonReqProxy;", "getCountWonReq", "addCountWonReq", "plusAssignCountWonReq", "addAllCountWonReq", "plusAssignAllCountWonReq", "setCountWonReq", "clearCountWonReq", "countClick", "Ladn/analytics/AnalyticsDataKt$Dsl$CountClickProxy;", "getCountClick", "addCountClick", "plusAssignCountClick", "addAllCountClick", "plusAssignAllCountClick", "setCountClick", "clearCountClick", "countImp", "Ladn/analytics/AnalyticsDataKt$Dsl$CountImpProxy;", "getCountImp", "addCountImp", "plusAssignCountImp", "addAllCountImp", "plusAssignAllCountImp", "setCountImp", "clearCountImp", "appsetIdScope", "getAppsetIdScope", "setAppsetIdScope", "clearAppsetIdScope", "hasAppsetIdScope", "extraSignals", "getExtraSignals", "setExtraSignals", "clearExtraSignals", "hasExtraSignals", "bootTime", "getBootTime", "setBootTime", "clearBootTime", "hasBootTime", "Companion", "LastXSessionDescProxy", "PrevXSessionDescProxy", "FirstXSessionDescProxy", "PurchaseSinceInstallProxy", "KeyboardLangProxy", "CountWonReqProxy", "CountClickProxy", "CountImpProxy", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Analytics.AnalyticsData.Builder _builder;

        public /* synthetic */ Dsl(Analytics.AnalyticsData.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(Analytics.AnalyticsData.Builder builder) {
            this._builder = builder;
        }

        /* compiled from: AnalyticsDataKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¨\u0006\b"}, d2 = {"Ladn/analytics/AnalyticsDataKt$Dsl$Companion;", "", "<init>", "()V", "_create", "Ladn/analytics/AnalyticsDataKt$Dsl;", "builder", "Ladn/analytics/Analytics$AnalyticsData$Builder;", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(Analytics.AnalyticsData.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ Analytics.AnalyticsData _build() {
            Analytics.AnalyticsData build = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            return build;
        }

        public final String getUnityVersion() {
            String unityVersion = this._builder.getUnityVersion();
            Intrinsics.checkNotNullExpressionValue(unityVersion, "getUnityVersion(...)");
            return unityVersion;
        }

        public final void setUnityVersion(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setUnityVersion(value);
        }

        public final void clearUnityVersion() {
            this._builder.clearUnityVersion();
        }

        public final boolean hasUnityVersion() {
            return this._builder.hasUnityVersion();
        }

        public final String getVsauceVersion() {
            String vsauceVersion = this._builder.getVsauceVersion();
            Intrinsics.checkNotNullExpressionValue(vsauceVersion, "getVsauceVersion(...)");
            return vsauceVersion;
        }

        public final void setVsauceVersion(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setVsauceVersion(value);
        }

        public final void clearVsauceVersion() {
            this._builder.clearVsauceVersion();
        }

        public final boolean hasVsauceVersion() {
            return this._builder.hasVsauceVersion();
        }

        public final String getSessionId() {
            String sessionId = this._builder.getSessionId();
            Intrinsics.checkNotNullExpressionValue(sessionId, "getSessionId(...)");
            return sessionId;
        }

        public final void setSessionId(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setSessionId(value);
        }

        public final void clearSessionId() {
            this._builder.clearSessionId();
        }

        public final boolean hasSessionId() {
            return this._builder.hasSessionId();
        }

        public final String getInstallDate() {
            String installDate = this._builder.getInstallDate();
            Intrinsics.checkNotNullExpressionValue(installDate, "getInstallDate(...)");
            return installDate;
        }

        public final void setInstallDate(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setInstallDate(value);
        }

        public final void clearInstallDate() {
            this._builder.clearInstallDate();
        }

        public final boolean hasInstallDate() {
            return this._builder.hasInstallDate();
        }

        public final String getSessionStartDate() {
            String sessionStartDate = this._builder.getSessionStartDate();
            Intrinsics.checkNotNullExpressionValue(sessionStartDate, "getSessionStartDate(...)");
            return sessionStartDate;
        }

        public final void setSessionStartDate(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setSessionStartDate(value);
        }

        public final void clearSessionStartDate() {
            this._builder.clearSessionStartDate();
        }

        public final boolean hasSessionStartDate() {
            return this._builder.hasSessionStartDate();
        }

        public final int getAppOpenCountSinceInstall() {
            return this._builder.getAppOpenCountSinceInstall();
        }

        public final void setAppOpenCountSinceInstall(int i) {
            this._builder.setAppOpenCountSinceInstall(i);
        }

        public final void clearAppOpenCountSinceInstall() {
            this._builder.clearAppOpenCountSinceInstall();
        }

        public final boolean hasAppOpenCountSinceInstall() {
            return this._builder.hasAppOpenCountSinceInstall();
        }

        public final int getSessionCountSinceInstall() {
            return this._builder.getSessionCountSinceInstall();
        }

        public final void setSessionCountSinceInstall(int i) {
            this._builder.setSessionCountSinceInstall(i);
        }

        public final void clearSessionCountSinceInstall() {
            this._builder.clearSessionCountSinceInstall();
        }

        public final boolean hasSessionCountSinceInstall() {
            return this._builder.hasSessionCountSinceInstall();
        }

        public final String getVanUserId() {
            String vanUserId = this._builder.getVanUserId();
            Intrinsics.checkNotNullExpressionValue(vanUserId, "getVanUserId(...)");
            return vanUserId;
        }

        public final void setVanUserId(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setVanUserId(value);
        }

        public final void clearVanUserId() {
            this._builder.clearVanUserId();
        }

        public final boolean hasVanUserId() {
            return this._builder.hasVanUserId();
        }

        public final String getMmpId() {
            String mmpId = this._builder.getMmpId();
            Intrinsics.checkNotNullExpressionValue(mmpId, "getMmpId(...)");
            return mmpId;
        }

        public final void setMmpId(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setMmpId(value);
        }

        public final void clearMmpId() {
            this._builder.clearMmpId();
        }

        public final boolean hasMmpId() {
            return this._builder.hasMmpId();
        }

        public final int getGameCountSinceInstall() {
            return this._builder.getGameCountSinceInstall();
        }

        public final void setGameCountSinceInstall(int i) {
            this._builder.setGameCountSinceInstall(i);
        }

        public final void clearGameCountSinceInstall() {
            this._builder.clearGameCountSinceInstall();
        }

        public final boolean hasGameCountSinceInstall() {
            return this._builder.hasGameCountSinceInstall();
        }

        public final int getGameCount() {
            return this._builder.getGameCount();
        }

        public final void setGameCount(int i) {
            this._builder.setGameCount(i);
        }

        public final void clearGameCount() {
            this._builder.clearGameCount();
        }

        public final boolean hasGameCount() {
            return this._builder.hasGameCount();
        }

        public final Analytics.PerformanceMetrics getPerfMetrics() {
            Analytics.PerformanceMetrics perfMetrics = this._builder.getPerfMetrics();
            Intrinsics.checkNotNullExpressionValue(perfMetrics, "getPerfMetrics(...)");
            return perfMetrics;
        }

        public final void setPerfMetrics(Analytics.PerformanceMetrics value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setPerfMetrics(value);
        }

        public final void clearPerfMetrics() {
            this._builder.clearPerfMetrics();
        }

        public final boolean hasPerfMetrics() {
            return this._builder.hasPerfMetrics();
        }

        public final Analytics.PerformanceMetrics getPerfMetricsOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return AnalyticsDataKtKt.getPerfMetricsOrNull(dsl._builder);
        }

        public final int getGameCountSuccess() {
            return this._builder.getGameCountSuccess();
        }

        public final void setGameCountSuccess(int i) {
            this._builder.setGameCountSuccess(i);
        }

        public final void clearGameCountSuccess() {
            this._builder.clearGameCountSuccess();
        }

        public final boolean hasGameCountSuccess() {
            return this._builder.hasGameCountSuccess();
        }

        public final int getPlayTime() {
            return this._builder.getPlayTime();
        }

        public final void setPlayTime(int i) {
            this._builder.setPlayTime(i);
        }

        public final void clearPlayTime() {
            this._builder.clearPlayTime();
        }

        public final boolean hasPlayTime() {
            return this._builder.hasPlayTime();
        }

        public final int getTotalTime() {
            return this._builder.getTotalTime();
        }

        public final void setTotalTime(int i) {
            this._builder.setTotalTime(i);
        }

        public final void clearTotalTime() {
            this._builder.clearTotalTime();
        }

        public final boolean hasTotalTime() {
            return this._builder.hasTotalTime();
        }

        public final Analytics.Attribution getAttribution() {
            Analytics.Attribution attribution = this._builder.getAttribution();
            Intrinsics.checkNotNullExpressionValue(attribution, "getAttribution(...)");
            return attribution;
        }

        public final void setAttribution(Analytics.Attribution value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setAttribution(value);
        }

        public final void clearAttribution() {
            this._builder.clearAttribution();
        }

        public final boolean hasAttribution() {
            return this._builder.hasAttribution();
        }

        public final Analytics.Attribution getAttributionOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return AnalyticsDataKtKt.getAttributionOrNull(dsl._builder);
        }

        public final int getFsLoadIndex() {
            return this._builder.getFsLoadIndex();
        }

        public final void setFsLoadIndex(int i) {
            this._builder.setFsLoadIndex(i);
        }

        public final void clearFsLoadIndex() {
            this._builder.clearFsLoadIndex();
        }

        public final boolean hasFsLoadIndex() {
            return this._builder.hasFsLoadIndex();
        }

        public final int getRvLoadIndex() {
            return this._builder.getRvLoadIndex();
        }

        public final void setRvLoadIndex(int i) {
            this._builder.setRvLoadIndex(i);
        }

        public final void clearRvLoadIndex() {
            this._builder.clearRvLoadIndex();
        }

        public final boolean hasRvLoadIndex() {
            return this._builder.hasRvLoadIndex();
        }

        public final int getFsCountSinceInstall() {
            return this._builder.getFsCountSinceInstall();
        }

        public final void setFsCountSinceInstall(int i) {
            this._builder.setFsCountSinceInstall(i);
        }

        public final void clearFsCountSinceInstall() {
            this._builder.clearFsCountSinceInstall();
        }

        public final boolean hasFsCountSinceInstall() {
            return this._builder.hasFsCountSinceInstall();
        }

        public final int getRvCountSinceInstall() {
            return this._builder.getRvCountSinceInstall();
        }

        public final void setRvCountSinceInstall(int i) {
            this._builder.setRvCountSinceInstall(i);
        }

        public final void clearRvCountSinceInstall() {
            this._builder.clearRvCountSinceInstall();
        }

        public final boolean hasRvCountSinceInstall() {
            return this._builder.hasRvCountSinceInstall();
        }

        public final int getFsClickCountSinceInstall() {
            return this._builder.getFsClickCountSinceInstall();
        }

        public final void setFsClickCountSinceInstall(int i) {
            this._builder.setFsClickCountSinceInstall(i);
        }

        public final void clearFsClickCountSinceInstall() {
            this._builder.clearFsClickCountSinceInstall();
        }

        public final boolean hasFsClickCountSinceInstall() {
            return this._builder.hasFsClickCountSinceInstall();
        }

        public final int getRvClickCountSinceInstall() {
            return this._builder.getRvClickCountSinceInstall();
        }

        public final void setRvClickCountSinceInstall(int i) {
            this._builder.setRvClickCountSinceInstall(i);
        }

        public final void clearRvClickCountSinceInstall() {
            this._builder.clearRvClickCountSinceInstall();
        }

        public final boolean hasRvClickCountSinceInstall() {
            return this._builder.hasRvClickCountSinceInstall();
        }

        public final Analytics.RevenueGeneration getRevGen() {
            Analytics.RevenueGeneration revGen = this._builder.getRevGen();
            Intrinsics.checkNotNullExpressionValue(revGen, "getRevGen(...)");
            return revGen;
        }

        public final void setRevGen(Analytics.RevenueGeneration value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setRevGen(value);
        }

        public final void clearRevGen() {
            this._builder.clearRevGen();
        }

        public final boolean hasRevGen() {
            return this._builder.hasRevGen();
        }

        public final Analytics.RevenueGeneration getRevGenOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return AnalyticsDataKtKt.getRevGenOrNull(dsl._builder);
        }

        public final Analytics.RevenueGeneration getRevGenSinceInstall() {
            Analytics.RevenueGeneration revGenSinceInstall = this._builder.getRevGenSinceInstall();
            Intrinsics.checkNotNullExpressionValue(revGenSinceInstall, "getRevGenSinceInstall(...)");
            return revGenSinceInstall;
        }

        public final void setRevGenSinceInstall(Analytics.RevenueGeneration value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setRevGenSinceInstall(value);
        }

        public final void clearRevGenSinceInstall() {
            this._builder.clearRevGenSinceInstall();
        }

        public final boolean hasRevGenSinceInstall() {
            return this._builder.hasRevGenSinceInstall();
        }

        public final Analytics.RevenueGeneration getRevGenSinceInstallOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return AnalyticsDataKtKt.getRevGenSinceInstallOrNull(dsl._builder);
        }

        public final String getVanImpressionId() {
            String vanImpressionId = this._builder.getVanImpressionId();
            Intrinsics.checkNotNullExpressionValue(vanImpressionId, "getVanImpressionId(...)");
            return vanImpressionId;
        }

        public final void setVanImpressionId(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setVanImpressionId(value);
        }

        public final void clearVanImpressionId() {
            this._builder.clearVanImpressionId();
        }

        public final boolean hasVanImpressionId() {
            return this._builder.hasVanImpressionId();
        }

        public final String getVanFsImpressionId() {
            String vanFsImpressionId = this._builder.getVanFsImpressionId();
            Intrinsics.checkNotNullExpressionValue(vanFsImpressionId, "getVanFsImpressionId(...)");
            return vanFsImpressionId;
        }

        public final void setVanFsImpressionId(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setVanFsImpressionId(value);
        }

        public final void clearVanFsImpressionId() {
            this._builder.clearVanFsImpressionId();
        }

        public final boolean hasVanFsImpressionId() {
            return this._builder.hasVanFsImpressionId();
        }

        public final String getVanRvImpressionId() {
            String vanRvImpressionId = this._builder.getVanRvImpressionId();
            Intrinsics.checkNotNullExpressionValue(vanRvImpressionId, "getVanRvImpressionId(...)");
            return vanRvImpressionId;
        }

        public final void setVanRvImpressionId(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setVanRvImpressionId(value);
        }

        public final void clearVanRvImpressionId() {
            this._builder.clearVanRvImpressionId();
        }

        public final boolean hasVanRvImpressionId() {
            return this._builder.hasVanRvImpressionId();
        }

        public final int getCountReq() {
            return this._builder.getCountReq();
        }

        public final void setCountReq(int i) {
            this._builder.setCountReq(i);
        }

        public final void clearCountReq() {
            this._builder.clearCountReq();
        }

        public final boolean hasCountReq() {
            return this._builder.hasCountReq();
        }

        public final Analytics.LastClick getHasLastClick() {
            Analytics.LastClick hasLastClick = this._builder.getHasLastClick();
            Intrinsics.checkNotNullExpressionValue(hasLastClick, "getHasLastClick(...)");
            return hasLastClick;
        }

        public final void setHasLastClick(Analytics.LastClick value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setHasLastClick(value);
        }

        public final void clearHasLastClick() {
            this._builder.clearHasLastClick();
        }

        public final boolean hasHasLastClick() {
            return this._builder.hasHasLastClick();
        }

        public final Analytics.LastClick getHasLastClickOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return AnalyticsDataKtKt.getHasLastClickOrNull(dsl._builder);
        }

        /* compiled from: AnalyticsDataKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ladn/analytics/AnalyticsDataKt$Dsl$LastXSessionDescProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "<init>", "()V", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class LastXSessionDescProxy extends DslProxy {
            private LastXSessionDescProxy() {
            }
        }

        public final /* synthetic */ DslList getLastXSessionDesc() {
            List<Analytics.AdInfo> lastXSessionDescList = this._builder.getLastXSessionDescList();
            Intrinsics.checkNotNullExpressionValue(lastXSessionDescList, "getLastXSessionDescList(...)");
            return new DslList(lastXSessionDescList);
        }

        public final /* synthetic */ void addLastXSessionDesc(DslList dslList, Analytics.AdInfo value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addLastXSessionDesc(value);
        }

        public final /* synthetic */ void plusAssignLastXSessionDesc(DslList<Analytics.AdInfo, LastXSessionDescProxy> dslList, Analytics.AdInfo value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addLastXSessionDesc(dslList, value);
        }

        public final /* synthetic */ void addAllLastXSessionDesc(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllLastXSessionDesc(values);
        }

        public final /* synthetic */ void plusAssignAllLastXSessionDesc(DslList<Analytics.AdInfo, LastXSessionDescProxy> dslList, Iterable<Analytics.AdInfo> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllLastXSessionDesc(dslList, values);
        }

        public final /* synthetic */ void setLastXSessionDesc(DslList dslList, int i, Analytics.AdInfo value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setLastXSessionDesc(i, value);
        }

        public final /* synthetic */ void clearLastXSessionDesc(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearLastXSessionDesc();
        }

        /* compiled from: AnalyticsDataKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ladn/analytics/AnalyticsDataKt$Dsl$PrevXSessionDescProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "<init>", "()V", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class PrevXSessionDescProxy extends DslProxy {
            private PrevXSessionDescProxy() {
            }
        }

        public final /* synthetic */ DslList getPrevXSessionDesc() {
            List<Analytics.AdInfo> prevXSessionDescList = this._builder.getPrevXSessionDescList();
            Intrinsics.checkNotNullExpressionValue(prevXSessionDescList, "getPrevXSessionDescList(...)");
            return new DslList(prevXSessionDescList);
        }

        public final /* synthetic */ void addPrevXSessionDesc(DslList dslList, Analytics.AdInfo value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addPrevXSessionDesc(value);
        }

        public final /* synthetic */ void plusAssignPrevXSessionDesc(DslList<Analytics.AdInfo, PrevXSessionDescProxy> dslList, Analytics.AdInfo value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addPrevXSessionDesc(dslList, value);
        }

        public final /* synthetic */ void addAllPrevXSessionDesc(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllPrevXSessionDesc(values);
        }

        public final /* synthetic */ void plusAssignAllPrevXSessionDesc(DslList<Analytics.AdInfo, PrevXSessionDescProxy> dslList, Iterable<Analytics.AdInfo> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllPrevXSessionDesc(dslList, values);
        }

        public final /* synthetic */ void setPrevXSessionDesc(DslList dslList, int i, Analytics.AdInfo value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setPrevXSessionDesc(i, value);
        }

        public final /* synthetic */ void clearPrevXSessionDesc(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearPrevXSessionDesc();
        }

        /* compiled from: AnalyticsDataKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ladn/analytics/AnalyticsDataKt$Dsl$FirstXSessionDescProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "<init>", "()V", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class FirstXSessionDescProxy extends DslProxy {
            private FirstXSessionDescProxy() {
            }
        }

        public final /* synthetic */ DslList getFirstXSessionDesc() {
            List<Analytics.AdInfo> firstXSessionDescList = this._builder.getFirstXSessionDescList();
            Intrinsics.checkNotNullExpressionValue(firstXSessionDescList, "getFirstXSessionDescList(...)");
            return new DslList(firstXSessionDescList);
        }

        public final /* synthetic */ void addFirstXSessionDesc(DslList dslList, Analytics.AdInfo value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addFirstXSessionDesc(value);
        }

        public final /* synthetic */ void plusAssignFirstXSessionDesc(DslList<Analytics.AdInfo, FirstXSessionDescProxy> dslList, Analytics.AdInfo value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addFirstXSessionDesc(dslList, value);
        }

        public final /* synthetic */ void addAllFirstXSessionDesc(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllFirstXSessionDesc(values);
        }

        public final /* synthetic */ void plusAssignAllFirstXSessionDesc(DslList<Analytics.AdInfo, FirstXSessionDescProxy> dslList, Iterable<Analytics.AdInfo> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllFirstXSessionDesc(dslList, values);
        }

        public final /* synthetic */ void setFirstXSessionDesc(DslList dslList, int i, Analytics.AdInfo value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setFirstXSessionDesc(i, value);
        }

        public final /* synthetic */ void clearFirstXSessionDesc(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearFirstXSessionDesc();
        }

        public final int getHasSkipPriorRv() {
            return this._builder.getHasSkipPriorRv();
        }

        public final void setHasSkipPriorRv(int i) {
            this._builder.setHasSkipPriorRv(i);
        }

        public final void clearHasSkipPriorRv() {
            this._builder.clearHasSkipPriorRv();
        }

        public final boolean hasHasSkipPriorRv() {
            return this._builder.hasHasSkipPriorRv();
        }

        public final int getAdsConsentGiven() {
            return this._builder.getAdsConsentGiven();
        }

        public final void setAdsConsentGiven(int i) {
            this._builder.setAdsConsentGiven(i);
        }

        public final void clearAdsConsentGiven() {
            this._builder.clearAdsConsentGiven();
        }

        public final String getIdfaAuthorizationStatus() {
            String idfaAuthorizationStatus = this._builder.getIdfaAuthorizationStatus();
            Intrinsics.checkNotNullExpressionValue(idfaAuthorizationStatus, "getIdfaAuthorizationStatus(...)");
            return idfaAuthorizationStatus;
        }

        public final void setIdfaAuthorizationStatus(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setIdfaAuthorizationStatus(value);
        }

        public final void clearIdfaAuthorizationStatus() {
            this._builder.clearIdfaAuthorizationStatus();
        }

        public final boolean hasIdfaAuthorizationStatus() {
            return this._builder.hasIdfaAuthorizationStatus();
        }

        /* compiled from: AnalyticsDataKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ladn/analytics/AnalyticsDataKt$Dsl$PurchaseSinceInstallProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "<init>", "()V", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class PurchaseSinceInstallProxy extends DslProxy {
            private PurchaseSinceInstallProxy() {
            }
        }

        public final /* synthetic */ DslList getPurchaseSinceInstall() {
            List<Analytics.Purchase> purchaseSinceInstallList = this._builder.getPurchaseSinceInstallList();
            Intrinsics.checkNotNullExpressionValue(purchaseSinceInstallList, "getPurchaseSinceInstallList(...)");
            return new DslList(purchaseSinceInstallList);
        }

        public final /* synthetic */ void addPurchaseSinceInstall(DslList dslList, Analytics.Purchase value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addPurchaseSinceInstall(value);
        }

        public final /* synthetic */ void plusAssignPurchaseSinceInstall(DslList<Analytics.Purchase, PurchaseSinceInstallProxy> dslList, Analytics.Purchase value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addPurchaseSinceInstall(dslList, value);
        }

        public final /* synthetic */ void addAllPurchaseSinceInstall(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllPurchaseSinceInstall(values);
        }

        public final /* synthetic */ void plusAssignAllPurchaseSinceInstall(DslList<Analytics.Purchase, PurchaseSinceInstallProxy> dslList, Iterable<Analytics.Purchase> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllPurchaseSinceInstall(dslList, values);
        }

        public final /* synthetic */ void setPurchaseSinceInstall(DslList dslList, int i, Analytics.Purchase value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setPurchaseSinceInstall(i, value);
        }

        public final /* synthetic */ void clearPurchaseSinceInstall(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearPurchaseSinceInstall();
        }

        public final int getIsPremium() {
            return this._builder.getIsPremium();
        }

        public final void setIsPremium(int i) {
            this._builder.setIsPremium(i);
        }

        public final void clearIsPremium() {
            this._builder.clearIsPremium();
        }

        public final boolean hasIsPremium() {
            return this._builder.hasIsPremium();
        }

        public final int getAirplaneModeEnable() {
            return this._builder.getAirplaneModeEnable();
        }

        public final void setAirplaneModeEnable(int i) {
            this._builder.setAirplaneModeEnable(i);
        }

        public final void clearAirplaneModeEnable() {
            this._builder.clearAirplaneModeEnable();
        }

        public final boolean hasAirplaneModeEnable() {
            return this._builder.hasAirplaneModeEnable();
        }

        public final String getConnectivity() {
            String connectivity = this._builder.getConnectivity();
            Intrinsics.checkNotNullExpressionValue(connectivity, "getConnectivity(...)");
            return connectivity;
        }

        public final void setConnectivity(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setConnectivity(value);
        }

        public final void clearConnectivity() {
            this._builder.clearConnectivity();
        }

        public final boolean hasConnectivity() {
            return this._builder.hasConnectivity();
        }

        public final int getBattery() {
            return this._builder.getBattery();
        }

        public final void setBattery(int i) {
            this._builder.setBattery(i);
        }

        public final void clearBattery() {
            this._builder.clearBattery();
        }

        public final boolean hasBattery() {
            return this._builder.hasBattery();
        }

        public final int getBatterySaverEnable() {
            return this._builder.getBatterySaverEnable();
        }

        public final void setBatterySaverEnable(int i) {
            this._builder.setBatterySaverEnable(i);
        }

        public final void clearBatterySaverEnable() {
            this._builder.clearBatterySaverEnable();
        }

        public final boolean hasBatterySaverEnable() {
            return this._builder.hasBatterySaverEnable();
        }

        public final int getBattCharge() {
            return this._builder.getBattCharge();
        }

        public final void setBattCharge(int i) {
            this._builder.setBattCharge(i);
        }

        public final void clearBattCharge() {
            this._builder.clearBattCharge();
        }

        public final boolean hasBattCharge() {
            return this._builder.hasBattCharge();
        }

        public final long getAvailableDiskSpace() {
            return this._builder.getAvailableDiskSpace();
        }

        public final void setAvailableDiskSpace(long j) {
            this._builder.setAvailableDiskSpace(j);
        }

        public final void clearAvailableDiskSpace() {
            this._builder.clearAvailableDiskSpace();
        }

        public final boolean hasAvailableDiskSpace() {
            return this._builder.hasAvailableDiskSpace();
        }

        public final long getTotalDiskSpace() {
            return this._builder.getTotalDiskSpace();
        }

        public final void setTotalDiskSpace(long j) {
            this._builder.setTotalDiskSpace(j);
        }

        public final void clearTotalDiskSpace() {
            this._builder.clearTotalDiskSpace();
        }

        public final boolean hasTotalDiskSpace() {
            return this._builder.hasTotalDiskSpace();
        }

        public final int getDoNotDist() {
            return this._builder.getDoNotDist();
        }

        public final void setDoNotDist(int i) {
            this._builder.setDoNotDist(i);
        }

        public final void clearDoNotDist() {
            this._builder.clearDoNotDist();
        }

        public final boolean hasDoNotDist() {
            return this._builder.hasDoNotDist();
        }

        public final String getGaid() {
            String gaid = this._builder.getGaid();
            Intrinsics.checkNotNullExpressionValue(gaid, "getGaid(...)");
            return gaid;
        }

        public final void setGaid(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setGaid(value);
        }

        public final void clearGaid() {
            this._builder.clearGaid();
        }

        public final boolean hasGaid() {
            return this._builder.hasGaid();
        }

        public final String getAppsetId() {
            String appsetId = this._builder.getAppsetId();
            Intrinsics.checkNotNullExpressionValue(appsetId, "getAppsetId(...)");
            return appsetId;
        }

        public final void setAppsetId(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setAppsetId(value);
        }

        public final void clearAppsetId() {
            this._builder.clearAppsetId();
        }

        public final boolean hasAppsetId() {
            return this._builder.hasAppsetId();
        }

        public final int getLimitAdTracking() {
            return this._builder.getLimitAdTracking();
        }

        public final void setLimitAdTracking(int i) {
            this._builder.setLimitAdTracking(i);
        }

        public final void clearLimitAdTracking() {
            this._builder.clearLimitAdTracking();
        }

        public final boolean hasLimitAdTracking() {
            return this._builder.hasLimitAdTracking();
        }

        public final int getGlobalTokenIndex() {
            return this._builder.getGlobalTokenIndex();
        }

        public final void setGlobalTokenIndex(int i) {
            this._builder.setGlobalTokenIndex(i);
        }

        public final void clearGlobalTokenIndex() {
            this._builder.clearGlobalTokenIndex();
        }

        public final int getTokenIndex() {
            return this._builder.getTokenIndex();
        }

        public final void setTokenIndex(int i) {
            this._builder.setTokenIndex(i);
        }

        public final void clearTokenIndex() {
            this._builder.clearTokenIndex();
        }

        public final String getUtcDate() {
            String utcDate = this._builder.getUtcDate();
            Intrinsics.checkNotNullExpressionValue(utcDate, "getUtcDate(...)");
            return utcDate;
        }

        public final void setUtcDate(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setUtcDate(value);
        }

        public final void clearUtcDate() {
            this._builder.clearUtcDate();
        }

        public final boolean hasUtcDate() {
            return this._builder.hasUtcDate();
        }

        public final String getLocalDate() {
            String localDate = this._builder.getLocalDate();
            Intrinsics.checkNotNullExpressionValue(localDate, "getLocalDate(...)");
            return localDate;
        }

        public final void setLocalDate(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setLocalDate(value);
        }

        public final void clearLocalDate() {
            this._builder.clearLocalDate();
        }

        public final boolean hasLocalDate() {
            return this._builder.hasLocalDate();
        }

        public final String getSdkVersion() {
            String sdkVersion = this._builder.getSdkVersion();
            Intrinsics.checkNotNullExpressionValue(sdkVersion, "getSdkVersion(...)");
            return sdkVersion;
        }

        public final void setSdkVersion(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setSdkVersion(value);
        }

        public final void clearSdkVersion() {
            this._builder.clearSdkVersion();
        }

        public final String getAppVersion() {
            String appVersion = this._builder.getAppVersion();
            Intrinsics.checkNotNullExpressionValue(appVersion, "getAppVersion(...)");
            return appVersion;
        }

        public final void setAppVersion(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setAppVersion(value);
        }

        public final void clearAppVersion() {
            this._builder.clearAppVersion();
        }

        public final int getTestMode() {
            return this._builder.getTestMode();
        }

        public final void setTestMode(int i) {
            this._builder.setTestMode(i);
        }

        public final void clearTestMode() {
            this._builder.clearTestMode();
        }

        public final String getDeviceModel() {
            String deviceModel = this._builder.getDeviceModel();
            Intrinsics.checkNotNullExpressionValue(deviceModel, "getDeviceModel(...)");
            return deviceModel;
        }

        public final void setDeviceModel(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setDeviceModel(value);
        }

        public final void clearDeviceModel() {
            this._builder.clearDeviceModel();
        }

        public final String getDeviceManufacturer() {
            String deviceManufacturer = this._builder.getDeviceManufacturer();
            Intrinsics.checkNotNullExpressionValue(deviceManufacturer, "getDeviceManufacturer(...)");
            return deviceManufacturer;
        }

        public final void setDeviceManufacturer(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setDeviceManufacturer(value);
        }

        public final void clearDeviceManufacturer() {
            this._builder.clearDeviceManufacturer();
        }

        public final int getBluetooth() {
            return this._builder.getBluetooth();
        }

        public final void setBluetooth(int i) {
            this._builder.setBluetooth(i);
        }

        public final void clearBluetooth() {
            this._builder.clearBluetooth();
        }

        public final boolean hasBluetooth() {
            return this._builder.hasBluetooth();
        }

        public final int getDarkModeEnable() {
            return this._builder.getDarkModeEnable();
        }

        public final void setDarkModeEnable(int i) {
            this._builder.setDarkModeEnable(i);
        }

        public final void clearDarkModeEnable() {
            this._builder.clearDarkModeEnable();
        }

        public final boolean hasDarkModeEnable() {
            return this._builder.hasDarkModeEnable();
        }

        public final int getHeadset() {
            return this._builder.getHeadset();
        }

        public final void setHeadset(int i) {
            this._builder.setHeadset(i);
        }

        public final void clearHeadset() {
            this._builder.clearHeadset();
        }

        public final boolean hasHeadset() {
            return this._builder.hasHeadset();
        }

        public final int getSoundEnable() {
            return this._builder.getSoundEnable();
        }

        public final void setSoundEnable(int i) {
            this._builder.setSoundEnable(i);
        }

        public final void clearSoundEnable() {
            this._builder.clearSoundEnable();
        }

        public final boolean hasSoundEnable() {
            return this._builder.hasSoundEnable();
        }

        public final int getPpi() {
            return this._builder.getPpi();
        }

        public final void setPpi(int i) {
            this._builder.setPpi(i);
        }

        public final void clearPpi() {
            this._builder.clearPpi();
        }

        public final boolean hasPpi() {
            return this._builder.hasPpi();
        }

        public final int getIsWalking() {
            return this._builder.getIsWalking();
        }

        public final void setIsWalking(int i) {
            this._builder.setIsWalking(i);
        }

        public final void clearIsWalking() {
            this._builder.clearIsWalking();
        }

        public final boolean hasIsWalking() {
            return this._builder.hasIsWalking();
        }

        /* compiled from: AnalyticsDataKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ladn/analytics/AnalyticsDataKt$Dsl$KeyboardLangProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "<init>", "()V", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class KeyboardLangProxy extends DslProxy {
            private KeyboardLangProxy() {
            }
        }

        public final DslList<String, KeyboardLangProxy> getKeyboardLang() {
            List<String> keyboardLangList = this._builder.getKeyboardLangList();
            Intrinsics.checkNotNullExpressionValue(keyboardLangList, "getKeyboardLangList(...)");
            return new DslList<>(keyboardLangList);
        }

        public final /* synthetic */ void addKeyboardLang(DslList dslList, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addKeyboardLang(value);
        }

        public final /* synthetic */ void plusAssignKeyboardLang(DslList<String, KeyboardLangProxy> dslList, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addKeyboardLang(dslList, value);
        }

        public final /* synthetic */ void addAllKeyboardLang(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllKeyboardLang(values);
        }

        public final /* synthetic */ void plusAssignAllKeyboardLang(DslList<String, KeyboardLangProxy> dslList, Iterable<String> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllKeyboardLang(dslList, values);
        }

        public final /* synthetic */ void setKeyboardLang(DslList dslList, int i, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setKeyboardLang(i, value);
        }

        public final /* synthetic */ void clearKeyboardLang(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearKeyboardLang();
        }

        public final String getOrientation() {
            String orientation = this._builder.getOrientation();
            Intrinsics.checkNotNullExpressionValue(orientation, "getOrientation(...)");
            return orientation;
        }

        public final void setOrientation(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setOrientation(value);
        }

        public final void clearOrientation() {
            this._builder.clearOrientation();
        }

        public final int getDoNotSell() {
            return this._builder.getDoNotSell();
        }

        public final void setDoNotSell(int i) {
            this._builder.setDoNotSell(i);
        }

        public final void clearDoNotSell() {
            this._builder.clearDoNotSell();
        }

        public final boolean hasDoNotSell() {
            return this._builder.hasDoNotSell();
        }

        public final String getPrevSessionStartDate() {
            String prevSessionStartDate = this._builder.getPrevSessionStartDate();
            Intrinsics.checkNotNullExpressionValue(prevSessionStartDate, "getPrevSessionStartDate(...)");
            return prevSessionStartDate;
        }

        public final void setPrevSessionStartDate(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setPrevSessionStartDate(value);
        }

        public final void clearPrevSessionStartDate() {
            this._builder.clearPrevSessionStartDate();
        }

        public final boolean hasPrevSessionStartDate() {
            return this._builder.hasPrevSessionStartDate();
        }

        public final String getDate() {
            String date = this._builder.getDate();
            Intrinsics.checkNotNullExpressionValue(date, "getDate(...)");
            return date;
        }

        public final void setDate(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setDate(value);
        }

        public final void clearDate() {
            this._builder.clearDate();
        }

        public final boolean hasDate() {
            return this._builder.hasDate();
        }

        public final String getIdfv() {
            String idfv = this._builder.getIdfv();
            Intrinsics.checkNotNullExpressionValue(idfv, "getIdfv(...)");
            return idfv;
        }

        public final void setIdfv(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setIdfv(value);
        }

        public final void clearIdfv() {
            this._builder.clearIdfv();
        }

        public final boolean hasIdfv() {
            return this._builder.hasIdfv();
        }

        public final String getIdfa() {
            String idfa = this._builder.getIdfa();
            Intrinsics.checkNotNullExpressionValue(idfa, "getIdfa(...)");
            return idfa;
        }

        public final void setIdfa(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setIdfa(value);
        }

        public final void clearIdfa() {
            this._builder.clearIdfa();
        }

        public final boolean hasIdfa() {
            return this._builder.hasIdfa();
        }

        public final String getAppstoreId() {
            String appstoreId = this._builder.getAppstoreId();
            Intrinsics.checkNotNullExpressionValue(appstoreId, "getAppstoreId(...)");
            return appstoreId;
        }

        public final void setAppstoreId(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setAppstoreId(value);
        }

        public final void clearAppstoreId() {
            this._builder.clearAppstoreId();
        }

        public final boolean hasAppstoreId() {
            return this._builder.hasAppstoreId();
        }

        public final String getPluginVersion() {
            String pluginVersion = this._builder.getPluginVersion();
            Intrinsics.checkNotNullExpressionValue(pluginVersion, "getPluginVersion(...)");
            return pluginVersion;
        }

        public final void setPluginVersion(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setPluginVersion(value);
        }

        public final void clearPluginVersion() {
            this._builder.clearPluginVersion();
        }

        public final boolean hasPluginVersion() {
            return this._builder.hasPluginVersion();
        }

        /* compiled from: AnalyticsDataKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ladn/analytics/AnalyticsDataKt$Dsl$CountWonReqProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "<init>", "()V", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class CountWonReqProxy extends DslProxy {
            private CountWonReqProxy() {
            }
        }

        public final /* synthetic */ DslList getCountWonReq() {
            List<Analytics.CountInfo> countWonReqList = this._builder.getCountWonReqList();
            Intrinsics.checkNotNullExpressionValue(countWonReqList, "getCountWonReqList(...)");
            return new DslList(countWonReqList);
        }

        public final /* synthetic */ void addCountWonReq(DslList dslList, Analytics.CountInfo value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addCountWonReq(value);
        }

        public final /* synthetic */ void plusAssignCountWonReq(DslList<Analytics.CountInfo, CountWonReqProxy> dslList, Analytics.CountInfo value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addCountWonReq(dslList, value);
        }

        public final /* synthetic */ void addAllCountWonReq(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllCountWonReq(values);
        }

        public final /* synthetic */ void plusAssignAllCountWonReq(DslList<Analytics.CountInfo, CountWonReqProxy> dslList, Iterable<Analytics.CountInfo> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllCountWonReq(dslList, values);
        }

        public final /* synthetic */ void setCountWonReq(DslList dslList, int i, Analytics.CountInfo value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setCountWonReq(i, value);
        }

        public final /* synthetic */ void clearCountWonReq(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearCountWonReq();
        }

        /* compiled from: AnalyticsDataKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ladn/analytics/AnalyticsDataKt$Dsl$CountClickProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "<init>", "()V", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class CountClickProxy extends DslProxy {
            private CountClickProxy() {
            }
        }

        public final /* synthetic */ DslList getCountClick() {
            List<Analytics.CountInfo> countClickList = this._builder.getCountClickList();
            Intrinsics.checkNotNullExpressionValue(countClickList, "getCountClickList(...)");
            return new DslList(countClickList);
        }

        public final /* synthetic */ void addCountClick(DslList dslList, Analytics.CountInfo value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addCountClick(value);
        }

        public final /* synthetic */ void plusAssignCountClick(DslList<Analytics.CountInfo, CountClickProxy> dslList, Analytics.CountInfo value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addCountClick(dslList, value);
        }

        public final /* synthetic */ void addAllCountClick(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllCountClick(values);
        }

        public final /* synthetic */ void plusAssignAllCountClick(DslList<Analytics.CountInfo, CountClickProxy> dslList, Iterable<Analytics.CountInfo> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllCountClick(dslList, values);
        }

        public final /* synthetic */ void setCountClick(DslList dslList, int i, Analytics.CountInfo value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setCountClick(i, value);
        }

        public final /* synthetic */ void clearCountClick(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearCountClick();
        }

        /* compiled from: AnalyticsDataKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ladn/analytics/AnalyticsDataKt$Dsl$CountImpProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "<init>", "()V", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class CountImpProxy extends DslProxy {
            private CountImpProxy() {
            }
        }

        public final /* synthetic */ DslList getCountImp() {
            List<Analytics.CountInfo> countImpList = this._builder.getCountImpList();
            Intrinsics.checkNotNullExpressionValue(countImpList, "getCountImpList(...)");
            return new DslList(countImpList);
        }

        public final /* synthetic */ void addCountImp(DslList dslList, Analytics.CountInfo value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addCountImp(value);
        }

        public final /* synthetic */ void plusAssignCountImp(DslList<Analytics.CountInfo, CountImpProxy> dslList, Analytics.CountInfo value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addCountImp(dslList, value);
        }

        public final /* synthetic */ void addAllCountImp(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllCountImp(values);
        }

        public final /* synthetic */ void plusAssignAllCountImp(DslList<Analytics.CountInfo, CountImpProxy> dslList, Iterable<Analytics.CountInfo> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllCountImp(dslList, values);
        }

        public final /* synthetic */ void setCountImp(DslList dslList, int i, Analytics.CountInfo value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setCountImp(i, value);
        }

        public final /* synthetic */ void clearCountImp(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearCountImp();
        }

        public final int getAppsetIdScope() {
            return this._builder.getAppsetIdScope();
        }

        public final void setAppsetIdScope(int i) {
            this._builder.setAppsetIdScope(i);
        }

        public final void clearAppsetIdScope() {
            this._builder.clearAppsetIdScope();
        }

        public final boolean hasAppsetIdScope() {
            return this._builder.hasAppsetIdScope();
        }

        public final String getExtraSignals() {
            String extraSignals = this._builder.getExtraSignals();
            Intrinsics.checkNotNullExpressionValue(extraSignals, "getExtraSignals(...)");
            return extraSignals;
        }

        public final void setExtraSignals(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setExtraSignals(value);
        }

        public final void clearExtraSignals() {
            this._builder.clearExtraSignals();
        }

        public final boolean hasExtraSignals() {
            return this._builder.hasExtraSignals();
        }

        public final long getBootTime() {
            return this._builder.getBootTime();
        }

        public final void setBootTime(long j) {
            this._builder.setBootTime(j);
        }

        public final void clearBootTime() {
            this._builder.clearBootTime();
        }

        public final boolean hasBootTime() {
            return this._builder.hasBootTime();
        }
    }
}
