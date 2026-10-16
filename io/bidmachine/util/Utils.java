package io.bidmachine.util;

import android.app.DownloadManager;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Rect;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import com.google.firebase.messaging.Constants;
import com.ironsource.C3040d4;
import com.ironsource.V5;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000Ì\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\b\u0018\u00010\fH\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0001H\u0007J\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u0013H\u0007J\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001f\u001a\u00020\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u0013H\u0007J\u001c\u0010 \u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u0013H\u0007J\u001c\u0010 \u001a\u0004\u0018\u00010\u00152\u0006\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u0013H\u0007J\u0018\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020\u0011H\u0007J\u001c\u0010%\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u0013H\u0007J\u0012\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010(H\u0007J3\u0010)\u001a\u0004\u0018\u0001H\b\"\n\b\u0000\u0010\b*\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010\u00152\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0,H\u0007¢\u0006\u0002\u0010-J\u0012\u0010.\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u000100H\u0007J\u0014\u00101\u001a\u0004\u0018\u00010\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0007J\u0014\u00102\u001a\u0004\u0018\u00010\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0007J\u0012\u00103\u001a\u0004\u0018\u0001042\u0006\u0010#\u001a\u00020$H\u0007J\u0012\u00105\u001a\u0004\u0018\u0001062\u0006\u0010#\u001a\u00020$H\u0007J\u0012\u00107\u001a\u0004\u0018\u0001082\u0006\u0010#\u001a\u00020$H\u0007J\u001a\u00109\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$2\b\b\u0001\u0010:\u001a\u00020\u0013H\u0007J\u0012\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010#\u001a\u00020$H\u0007J\u0012\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010#\u001a\u00020$H\u0007J\u0012\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010#\u001a\u00020$H\u0007J\u0012\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010#\u001a\u00020$H\u0007J\u0012\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010#\u001a\u00020$H\u0007J\u0018\u0010E\u001a\u00020\u00112\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020GH\u0007J\u0012\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010#\u001a\u00020$H\u0007J\u0012\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010#\u001a\u00020$H\u0007J\u0012\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010#\u001a\u00020$H\u0007J\u0014\u0010O\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010\u0015H\u0007J\u0014\u0010R\u001a\u0004\u0018\u00010\u00152\b\u0010Q\u001a\u0004\u0018\u00010\u0015H\u0007J\u0012\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010#\u001a\u00020$H\u0007J\u0010\u0010U\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J+\u0010V\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\b\u0010W\u001a\u0004\u0018\u0001H\b2\f\u0010X\u001a\b\u0012\u0004\u0012\u0002H\b0YH\u0007¢\u0006\u0002\u0010ZJ\b\u0010[\u001a\u00020\\H\u0007J\u0012\u0010]\u001a\u00020\\2\b\u0010^\u001a\u0004\u0018\u00010PH\u0007J\u0010\u0010_\u001a\u00020\\2\u0006\u0010`\u001a\u00020\u0015H\u0007J\u001a\u0010a\u001a\u00020\\2\u0006\u0010#\u001a\u00020$2\b\u0010b\u001a\u0004\u0018\u00010\u0015H\u0007J\u0012\u0010c\u001a\u00020\\2\b\u0010`\u001a\u0004\u0018\u00010\u0015H\u0007J\u001a\u0010d\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010e\u001a\u00020\u0015H\u0007J\u0019\u0010f\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010gJ>\u0010h\u001a\u00020\u0007\"\u0004\b\u0000\u0010i\"\u0004\b\u0001\u0010j2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002Hi\u0012\u0004\u0012\u0002Hj0k2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002Hi\u0012\u0004\u0012\u0002Hj\u0018\u00010lH\u0007J\u0018\u0010m\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020\u0011H\u0007J\u0018\u0010m\u001a\u00020\u00132\u0006\u0010n\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0007J\u001a\u0010o\u001a\u0004\u0018\u00010\u00152\u0006\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020\u0015H\u0007J\u0018\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020xH\u0007J\u0012\u0010y\u001a\u0004\u0018\u00010\u00152\u0006\u0010u\u001a\u00020vH\u0007J\u0010\u0010z\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J#\u0010{\u001a\u0004\u0018\u00010|2\u0006\u0010}\u001a\u00020~2\u0006\u0010#\u001a\u00020$2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0007J\u001c\u0010\u0081\u0001\u001a\u0004\u0018\u00010|2\u0006\u0010#\u001a\u00020$2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0007J-\u0010\u0082\u0001\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\b\u0018\u00010\fH\u0007J?\u0010\u0082\u0001\u001a\u00020\u0007\"\u0004\b\u0000\u0010i\"\u0004\b\u0001\u0010j2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002Hi\u0012\u0004\u0012\u0002Hj0k2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002Hi\u0012\u0004\u0012\u0002Hj\u0018\u00010lH\u0007JA\u0010\u0083\u0001\u001a\u00020\u0007\"\u0006\b\u0000\u0010\b\u0018\u00012\u000e\u0010\u0084\u0001\u001a\t\u0012\u0004\u0012\u0002H\b0\u0085\u00012\u001d\u0010\u0086\u0001\u001a\u0018\u0012\u0004\u0012\u0002H\b\u0018\u00010\u0087\u0001j\u000b\u0012\u0004\u0012\u0002H\b\u0018\u0001`\u0088\u0001H\u0087\bJ\u0019\u0010\u0089\u0001\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020\u0011H\u0007J(\u0010\u008a\u0001\u001a\u0004\u0018\u00010\\2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u000b\b\u0002\u0010\u008b\u0001\u001a\u0004\u0018\u00010\\H\u0007¢\u0006\u0003\u0010\u008c\u0001J\u001b\u0010\u008d\u0001\u001a\u0004\u0018\u00010\\2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010\u008e\u0001J\u0011\u0010\u008f\u0001\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J*\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u00012\f\b\u0002\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0007¢\u0006\u0003\u0010\u0092\u0001J\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0091\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010\u0094\u0001J(\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u000b\b\u0002\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0003\u0010\u0096\u0001J\u001b\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010\u0098\u0001J\u0015\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007J(\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u000b\b\u0002\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0003\u0010\u009b\u0001J\u001b\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010\u009d\u0001J\u0018\u0010\u009e\u0001\u001a\u00030\u009f\u00012\f\u0010\u0084\u0001\u001a\u0007\u0012\u0002\b\u00030 \u0001H\u0007J\u001b\u0010¡\u0001\u001a\u00030¢\u00012\u000f\u0010£\u0001\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030lH\u0007J\u001a\u0010¤\u0001\u001a\t\u0012\u0004\u0012\u00020\u00010 \u00012\b\u0010¥\u0001\u001a\u00030\u009f\u0001H\u0007J(\u0010¦\u0001\u001a\u0004\u0018\u00010t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u000b\b\u0002\u0010\u008b\u0001\u001a\u0004\u0018\u00010tH\u0007¢\u0006\u0003\u0010§\u0001J\u001b\u0010¨\u0001\u001a\u0004\u0018\u00010t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010©\u0001J\u001f\u0010ª\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010l2\b\u0010«\u0001\u001a\u00030¢\u0001H\u0007J\u0015\u0010¬\u0001\u001a\u0004\u0018\u00010\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007J\"\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u000b\b\u0002\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0015H\u0007J\u0015\u0010®\u0001\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0007J\u0011\u0010¯\u0001\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\"\u0010°\u0001\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$2\u0007\u0010±\u0001\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0011H\u0007J$\u0010²\u0001\u001a\u00020t2\u0006\u0010u\u001a\u00020v2\u0006\u0010'\u001a\u00020(2\t\b\u0002\u0010³\u0001\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006´\u0001"}, d2 = {"Lio/bidmachine/util/Utils;", "", "()V", "HEX_ARRAY", "", "UPPER_HEX_ARRAY", "addAll", "", "T", "to", "", Constants.MessagePayloadKeys.FROM, "", "applyMD5", "", "bytes", "blueToRatio", "", "color", "", "capitalize", "", "value", "closeSafely", "closeable", "Ljava/io/Closeable;", "createHandlerWithMyOrMainLooper", "Landroid/os/Handler;", "createHexHashCode", "decodeBase64", "flags", "base64", "decodeBase64ToString", "data", "dpToPx", "context", "Landroid/content/Context;", "encodeToStringBase64", "finalize", "outputStream", "Ljava/io/OutputStream;", "find", "Lio/bidmachine/util/KeyHolder;", C3040d4.h.W, "", "(Ljava/lang/String;[Lio/bidmachine/util/KeyHolder;)Lio/bidmachine/util/KeyHolder;", "flushSafely", "flushable", "Ljava/io/Flushable;", "fromJsonElementToObjectOrNull", "fromObjectToJsonElementOrNull", "getAudioManager", "Landroid/media/AudioManager;", "getBluetoothManager", "Landroid/bluetooth/BluetoothManager;", "getClipboardManager", "Landroid/content/ClipboardManager;", "getColorCompat", "id", "getConnectivityManager", "Landroid/net/ConnectivityManager;", "getDownloadManager", "Landroid/app/DownloadManager;", "getInputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "getLocation", "Landroid/location/Location;", "getLocationManager", "Landroid/location/LocationManager;", "getNotOverlappedAreaPercent", "mainRect", "Landroid/graphics/Rect;", "coverRect", "getPowerManager", "Landroid/os/PowerManager;", "getSensorManager", "Landroid/hardware/SensorManager;", "getTelephonyManager", "Landroid/telephony/TelephonyManager;", "getValidUri", "Landroid/net/Uri;", "urlString", "getValidUrl", "getWindowManager", "Landroid/view/WindowManager;", "greenToRatio", "ifNotNull", "obj", "action", "Lio/bidmachine/util/Executable;", "(Ljava/lang/Object;Lio/bidmachine/util/Executable;)V", "isExternalMemoryAvailable", "", "isHttpUri", "uri", "isHttpUrl", "url", "isPermissionGranted", "permission", "isUrlValid", "notEmptyOrDefault", "defaultValue", "parseColorSafely", "(Ljava/lang/String;)Ljava/lang/Integer;", "putAll", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "", "pxToDp", "density", "readAssetFile", "assetManager", "Landroid/content/res/AssetManager;", V5.c.b, "readIntoFile", "", "inputStream", "Ljava/io/InputStream;", C3040d4.h.b, "Ljava/io/File;", "readSafely", "redToRatio", "registerBroadcastReceiver", "Landroid/content/Intent;", "receiver", "Landroid/content/BroadcastReceiver;", "intentFilter", "Landroid/content/IntentFilter;", "registerSystemReceiver", "set", "sort", "list", "Ljava/util/concurrent/CopyOnWriteArrayList;", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "spToPx", "toBooleanOrDefault", "fallback", "(Ljava/lang/Object;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "toBooleanOrNull", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "toCamelCase", "toDoubleOrDefault", "", "(Ljava/lang/Object;Ljava/lang/Double;)Ljava/lang/Double;", "toDoubleOrNull", "(Ljava/lang/Object;)Ljava/lang/Double;", "toFloatOrDefault", "(Ljava/lang/Object;Ljava/lang/Float;)Ljava/lang/Float;", "toFloatOrNull", "(Ljava/lang/Object;)Ljava/lang/Float;", "toHexString", "toIntOrDefault", "(Ljava/lang/Object;Ljava/lang/Integer;)Ljava/lang/Integer;", "toIntOrNull", "(Ljava/lang/Object;)Ljava/lang/Integer;", "toJsonArray", "Lorg/json/JSONArray;", "", "toJsonObject", "Lorg/json/JSONObject;", "map", "toList", "jsonArray", "toLongOrDefault", "(Ljava/lang/Object;Ljava/lang/Long;)Ljava/lang/Long;", "toLongOrNull", "(Ljava/lang/Object;)Ljava/lang/Long;", "toMap", "jsonObject", "toSignatureHexString", "toStringOrDefault", "toStringOrNull", "toUnderScore", "unitToPx", "unit", "write", "bufferSize", "bidmachine-android-sdk_ca_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class Utils {
    private static final char[] HEX_ARRAY;
    public static final Utils INSTANCE = new Utils();
    private static final char[] UPPER_HEX_ARRAY;

    @JvmStatic
    public static final byte[] decodeBase64(String base64) {
        Intrinsics.checkNotNullParameter(base64, "base64");
        return decodeBase64$default(base64, 0, 2, (Object) null);
    }

    @JvmStatic
    public static final byte[] decodeBase64(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return decodeBase64$default(bytes, 0, 2, (Object) null);
    }

    @JvmStatic
    public static final String decodeBase64ToString(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return decodeBase64ToString$default(data, 0, 2, (Object) null);
    }

    @JvmStatic
    public static final String decodeBase64ToString(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return decodeBase64ToString$default(bytes, 0, 2, (Object) null);
    }

    @JvmStatic
    public static final String encodeToStringBase64(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return encodeToStringBase64$default(bytes, 0, 2, null);
    }

    @JvmStatic
    public static final int pxToDp(float density, float value) {
        return (int) ((value / density) + 0.5f);
    }

    private Utils() {
    }

    static {
        char[] charArray = "0123456789abcdef".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        HEX_ARRAY = charArray;
        char[] charArray2 = "0123456789ABCDEF".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray2, "this as java.lang.String).toCharArray()");
        UPPER_HEX_ARRAY = charArray2;
    }

    @JvmStatic
    public static final boolean isPermissionGranted(Context context, String permission) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.isPermissionGranted(context, permission);
    }

    @JvmStatic
    public static final boolean isExternalMemoryAvailable() {
        return Intrinsics.areEqual(Environment.getExternalStorageState(), "mounted");
    }

    @JvmStatic
    public static final byte[] applyMD5(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return UtilsKt.applyMD5(bytes);
    }

    @JvmStatic
    public static final String toStringOrNull(Object value) {
        return toStringOrDefault(value, null);
    }

    @JvmStatic
    public static final String toStringOrDefault(Object value, String fallback) {
        return UtilsKt.toStringOrDefault(value, fallback);
    }

    public static /* synthetic */ String toStringOrDefault$default(Object obj, String str, int i, Object obj2) {
        if ((i & 2) != 0) {
            str = null;
        }
        return toStringOrDefault(obj, str);
    }

    @JvmStatic
    public static final Boolean toBooleanOrNull(Object value) {
        return toBooleanOrDefault(value, null);
    }

    @JvmStatic
    public static final Boolean toBooleanOrDefault(Object value, Boolean fallback) {
        return UtilsKt.toBooleanOrDefault(value, fallback);
    }

    public static /* synthetic */ Boolean toBooleanOrDefault$default(Object obj, Boolean bool, int i, Object obj2) {
        if ((i & 2) != 0) {
            bool = null;
        }
        return toBooleanOrDefault(obj, bool);
    }

    @JvmStatic
    public static final Integer toIntOrNull(Object value) {
        return toIntOrDefault(value, null);
    }

    @JvmStatic
    public static final Integer toIntOrDefault(Object value, Integer fallback) {
        return UtilsKt.toIntOrDefault(value, fallback);
    }

    public static /* synthetic */ Integer toIntOrDefault$default(Object obj, Integer num, int i, Object obj2) {
        if ((i & 2) != 0) {
            num = null;
        }
        return toIntOrDefault(obj, num);
    }

    @JvmStatic
    public static final Long toLongOrNull(Object value) {
        return toLongOrDefault(value, null);
    }

    @JvmStatic
    public static final Long toLongOrDefault(Object value, Long fallback) {
        return UtilsKt.toLongOrDefault(value, fallback);
    }

    public static /* synthetic */ Long toLongOrDefault$default(Object obj, Long l, int i, Object obj2) {
        if ((i & 2) != 0) {
            l = null;
        }
        return toLongOrDefault(obj, l);
    }

    @JvmStatic
    public static final Float toFloatOrNull(Object value) {
        return toFloatOrDefault(value, null);
    }

    @JvmStatic
    public static final Float toFloatOrDefault(Object value, Float fallback) {
        return UtilsKt.toFloatOrDefault(value, fallback);
    }

    public static /* synthetic */ Float toFloatOrDefault$default(Object obj, Float f, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = null;
        }
        return toFloatOrDefault(obj, f);
    }

    @JvmStatic
    public static final Double toDoubleOrNull(Object value) {
        return toDoubleOrDefault(value, null);
    }

    @JvmStatic
    public static final Double toDoubleOrDefault(Object value, Double fallback) {
        return UtilsKt.toDoubleOrDefault(value, fallback);
    }

    public static /* synthetic */ Double toDoubleOrDefault$default(Object obj, Double d, int i, Object obj2) {
        if ((i & 2) != 0) {
            d = null;
        }
        return toDoubleOrDefault(obj, d);
    }

    @JvmStatic
    public static final List<Object> toList(JSONArray jsonArray) {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        return UtilsKt.toList(jsonArray);
    }

    @JvmStatic
    public static final Map<String, Object> toMap(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        return UtilsKt.toMap(jsonObject);
    }

    @JvmStatic
    public static final Object fromJsonElementToObjectOrNull(Object value) {
        if (value == null || Intrinsics.areEqual(value, JSONObject.NULL)) {
            return null;
        }
        if (value instanceof JSONObject) {
            return UtilsKt.toMap((JSONObject) value);
        }
        return value instanceof JSONArray ? UtilsKt.toList((JSONArray) value) : value;
    }

    @JvmStatic
    public static final JSONArray toJsonArray(List<?> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return UtilsKt.toJsonArray(list);
    }

    @JvmStatic
    public static final JSONObject toJsonObject(Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return UtilsKt.toJsonObject(map);
    }

    @JvmStatic
    public static final Object fromObjectToJsonElementOrNull(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof List) {
            return UtilsKt.toJsonArray((List) value);
        }
        return value instanceof Map ? UtilsKt.toJsonObject((Map) value) : value;
    }

    @JvmStatic
    public static final <T> void set(Collection<T> to, Collection<? extends T> from) {
        Intrinsics.checkNotNullParameter(to, "to");
        UtilsKt.setSafely(to, from);
    }

    @JvmStatic
    public static final <T> void addAll(Collection<T> to, Collection<? extends T> from) {
        Intrinsics.checkNotNullParameter(to, "to");
        UtilsKt.addAllSafely(to, from);
    }

    @JvmStatic
    public static final <K, V> void set(Map<K, V> to, Map<K, ? extends V> from) {
        Intrinsics.checkNotNullParameter(to, "to");
        UtilsKt.setSafely(to, from);
    }

    @JvmStatic
    public static final <K, V> void putAll(Map<K, V> to, Map<K, ? extends V> from) {
        Intrinsics.checkNotNullParameter(to, "to");
        UtilsKt.putAllSafely(to, from);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final /* synthetic */ <T> void sort(CopyOnWriteArrayList<T> list, Comparator<T> comparator) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.reifiedOperationMarker(0, "T?");
        Object[] array = list.toArray(new Object[0]);
        Arrays.sort(array, comparator);
        int length = array.length;
        for (int i = 0; i < length; i++) {
            list.set(i, array[i]);
        }
    }

    @JvmStatic
    public static final String capitalize(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sb = new StringBuilder();
        String substring = value.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String upperCase = substring.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        StringBuilder append = sb.append(upperCase);
        String substring2 = value.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
        String lowerCase = substring2.toLowerCase(locale2);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return append.append(lowerCase).toString();
    }

    @JvmStatic
    public static final String toUnderScore(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return UtilsKt.toUnderScore(value);
    }

    @JvmStatic
    public static final String toCamelCase(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return UtilsKt.toCamelCase(value);
    }

    @JvmStatic
    public static final <T extends KeyHolder> T find(String key, T[] from) {
        Intrinsics.checkNotNullParameter(from, "from");
        return (T) UtilsKt.find(from, key);
    }

    @JvmStatic
    public static final String readSafely(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        return UtilsKt.readSafely(inputStream);
    }

    public static /* synthetic */ long write$default(InputStream inputStream, OutputStream outputStream, int i, int i2, Object obj) throws IOException {
        if ((i2 & 4) != 0) {
            i = 1024;
        }
        return write(inputStream, outputStream, i);
    }

    @JvmStatic
    public static final long write(InputStream inputStream, OutputStream outputStream, int bufferSize) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        byte[] bArr = new byte[bufferSize];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    @JvmStatic
    public static final long readIntoFile(InputStream inputStream, File file) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(file, "file");
        return UtilsKt.readIntoFile(inputStream, file);
    }

    @JvmStatic
    public static final void closeSafely(Closeable closeable) {
        UtilsKt.closeSafely(closeable);
    }

    @JvmStatic
    public static final void flushSafely(Flushable flushable) {
        UtilsKt.flushSafely(flushable);
    }

    @JvmStatic
    public static final void finalize(OutputStream outputStream) {
        UtilsKt.finalize(outputStream);
    }

    @JvmStatic
    public static final Handler createHandlerWithMyOrMainLooper() {
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        return new Handler(myLooper);
    }

    @JvmStatic
    public static final boolean isHttpUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return StringsKt.startsWith$default(url, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(url, "https://", false, 2, (Object) null);
    }

    @JvmStatic
    public static final boolean isHttpUri(Uri uri) {
        if (uri == null) {
            return false;
        }
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        return isHttpUrl(uri2);
    }

    @JvmStatic
    public static final boolean isUrlValid(String url) {
        Boolean bool;
        String str = url;
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            new URL(url);
            bool = true;
        } catch (Throwable unused) {
            bool = null;
        }
        return Intrinsics.areEqual((Object) bool, (Object) true);
    }

    @JvmStatic
    public static final String getValidUrl(String urlString) {
        String str = urlString;
        if (str == null || str.length() == 0) {
            return null;
        }
        if (isUrlValid(urlString)) {
            return urlString;
        }
        try {
            return URLDecoder.decode(urlString, "UTF-8");
        } catch (UnsupportedEncodingException | IllegalArgumentException unused) {
            return urlString;
        }
    }

    @JvmStatic
    public static final Uri getValidUri(String urlString) {
        try {
            return Uri.parse(getValidUrl(urlString));
        } catch (Throwable unused) {
            return null;
        }
    }

    @JvmStatic
    public static final Location getLocation(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getLocation(context);
    }

    @JvmStatic
    public static final ConnectivityManager getConnectivityManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getConnectivityManager(context);
    }

    @JvmStatic
    public static final WindowManager getWindowManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getWindowManager(context);
    }

    @JvmStatic
    public static final InputMethodManager getInputMethodManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getInputMethodManager(context);
    }

    @JvmStatic
    public static final AudioManager getAudioManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getAudioManager(context);
    }

    @JvmStatic
    public static final PowerManager getPowerManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getPowerManager(context);
    }

    @JvmStatic
    public static final TelephonyManager getTelephonyManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getTelephonyManager(context);
    }

    @JvmStatic
    public static final LocationManager getLocationManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getLocationManager(context);
    }

    @JvmStatic
    public static final BluetoothManager getBluetoothManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getBluetoothManager(context);
    }

    @JvmStatic
    public static final DownloadManager getDownloadManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getDownloadManager(context);
    }

    @JvmStatic
    public static final ClipboardManager getClipboardManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getClipboardManager(context);
    }

    @JvmStatic
    public static final SensorManager getSensorManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getSensorManager(context);
    }

    @JvmStatic
    public static final float getNotOverlappedAreaPercent(Rect mainRect, Rect coverRect) {
        Intrinsics.checkNotNullParameter(mainRect, "mainRect");
        Intrinsics.checkNotNullParameter(coverRect, "coverRect");
        int width = mainRect.width() * mainRect.height();
        if (width == 0) {
            return 0.0f;
        }
        return (width - (((int) Math.max(0.0d, ((int) Math.min(mainRect.right, coverRect.right)) - ((int) Math.max(mainRect.left, coverRect.left)))) * ((int) Math.max(0.0d, ((int) Math.min(mainRect.bottom, coverRect.bottom)) - ((int) Math.max(mainRect.top, coverRect.top)))))) / width;
    }

    @JvmStatic
    public static final int unitToPx(Context context, int unit, float value) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.unitToPx(context, unit, value);
    }

    @JvmStatic
    public static final int spToPx(Context context, float value) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.spToPx(context, value);
    }

    @JvmStatic
    public static final int dpToPx(Context context, float value) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.dpToPx(context, value);
    }

    @JvmStatic
    public static final int pxToDp(Context context, float value) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.pxToDp(context, value);
    }

    @JvmStatic
    public static final int getColorCompat(Context context, int id) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UtilsKt.getColorCompat(context, id);
    }

    @JvmStatic
    public static final Intent registerSystemReceiver(Context context, IntentFilter intentFilter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intentFilter, "intentFilter");
        return UtilsKt.registerSystemReceiver(context, intentFilter);
    }

    @JvmStatic
    public static final Intent registerBroadcastReceiver(BroadcastReceiver receiver, Context context, IntentFilter intentFilter) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intentFilter, "intentFilter");
        return UtilsKt.registerBroadcastReceiver(context, receiver, intentFilter);
    }

    @JvmStatic
    public static final String createHexHashCode(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return UtilsKt.createHexHashCode(value);
    }

    @JvmStatic
    public static final String toHexString(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        if (bytes.length == 0) {
            return "";
        }
        char[] cArr = new char[bytes.length * 2];
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            byte b = bytes[i];
            int i2 = i * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }

    @JvmStatic
    public static final String toSignatureHexString(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        if (bytes.length == 0) {
            return "";
        }
        char[] cArr = new char[(bytes.length * 3) - 1];
        int length = bytes.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            byte b = bytes[i2];
            char[] cArr2 = UPPER_HEX_ARRAY;
            cArr[i] = cArr2[(b & 255) >>> 4];
            int i3 = i + 2;
            cArr[i + 1] = cArr2[b & Ascii.SI];
            if (i2 < bytes.length - 1) {
                i += 3;
                cArr[i3] = AbstractJsonLexerKt.COLON;
            } else {
                i = i3;
            }
        }
        return new String(cArr);
    }

    @JvmStatic
    public static final <T> void ifNotNull(T obj, Executable<T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (obj != null) {
            action.execute(obj);
        }
    }

    @JvmStatic
    public static final String notEmptyOrDefault(String value, String defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return UtilsKt.notEmptyOrDefault(value, defaultValue);
    }

    @JvmStatic
    public static final Integer parseColorSafely(String color) {
        String str = color;
        if (str != null && str.length() != 0) {
            try {
                return Integer.valueOf(Color.parseColor(color));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @JvmStatic
    public static final String readAssetFile(AssetManager assetManager, String fileName) {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return UtilsKt.readAssetFile(assetManager, fileName);
    }

    @JvmStatic
    public static final byte[] decodeBase64(String base64, int flags) {
        Intrinsics.checkNotNullParameter(base64, "base64");
        return UtilsKt.decodeBase64(base64, flags);
    }

    public static /* synthetic */ byte[] decodeBase64$default(String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return decodeBase64(str, i);
    }

    @JvmStatic
    public static final String encodeToStringBase64(byte[] bytes, int flags) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return UtilsKt.encodeToStringBase64(bytes, flags);
    }

    public static /* synthetic */ String encodeToStringBase64$default(byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return encodeToStringBase64(bArr, i);
    }

    @JvmStatic
    public static final byte[] decodeBase64(byte[] bytes, int flags) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return UtilsKt.decodeBase64(bytes, flags);
    }

    public static /* synthetic */ byte[] decodeBase64$default(byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return decodeBase64(bArr, i);
    }

    @JvmStatic
    public static final String decodeBase64ToString(byte[] bytes, int flags) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return UtilsKt.decodeBase64ToString(bytes, flags);
    }

    public static /* synthetic */ String decodeBase64ToString$default(byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return decodeBase64ToString(bArr, i);
    }

    @JvmStatic
    public static final String decodeBase64ToString(String data, int flags) {
        Intrinsics.checkNotNullParameter(data, "data");
        return UtilsKt.decodeBase64ToString(data, flags);
    }

    public static /* synthetic */ String decodeBase64ToString$default(String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return decodeBase64ToString(str, i);
    }

    @JvmStatic
    public static final float redToRatio(int color) {
        return UtilsKt.toRatio(Integer.valueOf(Color.red(color)), 255.0f);
    }

    @JvmStatic
    public static final float greenToRatio(int color) {
        return UtilsKt.toRatio(Integer.valueOf(Color.green(color)), 255.0f);
    }

    @JvmStatic
    public static final float blueToRatio(int color) {
        return UtilsKt.toRatio(Integer.valueOf(Color.blue(color)), 255.0f);
    }
}
