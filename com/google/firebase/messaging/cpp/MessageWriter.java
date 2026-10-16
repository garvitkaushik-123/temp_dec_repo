package com.google.firebase.messaging.cpp;

import android.content.Context;
import android.net.Uri;
import com.adjust.sdk.Constants;
import com.google.firebase.messaging.RemoteMessage;
import com.google.flatbuffers.FlatBufferBuilder;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileLock;
import java.util.Map;

/* loaded from: classes4.dex */
public class MessageWriter {
    private static final MessageWriter DEFAULT_INSTANCE = new MessageWriter();
    static final String LOCK_FILE = "FIREBASE_CLOUD_MESSAGING_LOCKFILE";
    static final String STORAGE_FILE = "FIREBASE_CLOUD_MESSAGING_LOCAL_STORAGE";
    private static final String TAG = "FIREBASE_MESSAGE_WRITER";

    public static MessageWriter defaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public void writeMessage(Context context, RemoteMessage remoteMessage, boolean z, Uri uri) {
        String from = remoteMessage.getFrom();
        String to = remoteMessage.getTo();
        String messageId = remoteMessage.getMessageId();
        String messageType = remoteMessage.getMessageType();
        Map<String, String> data = remoteMessage.getData();
        byte[] rawData = remoteMessage.getRawData();
        RemoteMessage.Notification notification = remoteMessage.getNotification();
        String collapseKey = remoteMessage.getCollapseKey();
        int priority = remoteMessage.getPriority();
        int originalPriority = remoteMessage.getOriginalPriority();
        long sentTime = remoteMessage.getSentTime();
        int ttl = remoteMessage.getTtl();
        Uri link = (uri != null || notification == null) ? uri : notification.getLink();
        String uri2 = link != null ? link.toString() : null;
        String str = "(null)";
        String obj = data == null ? "(null)" : data.toString();
        if (notification != null) {
            str = notification.toString();
        }
        DebugLogging.log(TAG, String.format("onMessageReceived from=%s message_id=%s, data=%s, notification=%s", from, messageId, obj, str));
        writeMessageToInternalStorage(context, from, to, messageId, messageType, null, data, rawData, notification, z, uri2, collapseKey, priority, originalPriority, sentTime, ttl);
    }

    void writeMessageEventToInternalStorage(Context context, String str, String str2, String str3) {
        writeMessageToInternalStorage(context, null, null, str, str2, null, null, null, null, false, null, null, 0, 0, 0L, 0);
    }

    void writeMessageToInternalStorage(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map, byte[] bArr, RemoteMessage.Notification notification, boolean z, String str6, String str7, int i, int i2, long j, int i3) {
        byte[] generateMessageByteBuffer = generateMessageByteBuffer(str, str2, str3, str4, str5, map, bArr, notification, z, str6, str7, i, i2, j, i3);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(generateMessageByteBuffer.length);
        FileLock fileLock = null;
        try {
            try {
                try {
                    fileLock = context.openFileOutput(LOCK_FILE, 0).getChannel().lock();
                    FileOutputStream openFileOutput = context.openFileOutput(STORAGE_FILE, 32768);
                    openFileOutput.write(allocate.array());
                    openFileOutput.write(generateMessageByteBuffer);
                    openFileOutput.close();
                    if (fileLock != null) {
                        fileLock.release();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (fileLock != null) {
                    fileLock.release();
                }
            }
        } finally {
        }
    }

    private static String emptyIfNull(String str) {
        return str != null ? str : "";
    }

    private static String priorityToString(int i) {
        if (i == 1) {
            return Constants.HIGH;
        }
        if (i == 2) {
            return Constants.NORMAL;
        }
        return "";
    }

    private static byte[] generateMessageByteBuffer(String str, String str2, String str3, String str4, String str5, Map<String, String> map, byte[] bArr, RemoteMessage.Notification notification, boolean z, String str6, String str7, int i, int i2, long j, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(0);
        int createString = flatBufferBuilder.createString(emptyIfNull(str));
        int createString2 = flatBufferBuilder.createString(emptyIfNull(str2));
        int createString3 = flatBufferBuilder.createString(emptyIfNull(str3));
        int createString4 = flatBufferBuilder.createString(emptyIfNull(str4));
        int createString5 = flatBufferBuilder.createString(emptyIfNull(str5));
        int createString6 = flatBufferBuilder.createString(emptyIfNull(str6));
        int createString7 = flatBufferBuilder.createString(emptyIfNull(str7));
        int createString8 = flatBufferBuilder.createString(priorityToString(i));
        int createString9 = flatBufferBuilder.createString(priorityToString(i2));
        if (map != null) {
            int[] iArr = new int[map.size()];
            int i19 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                iArr[i19] = DataPair.createDataPair(flatBufferBuilder, flatBufferBuilder.createString(entry.getKey()), flatBufferBuilder.createString(entry.getValue()));
                i19++;
            }
            i4 = SerializedMessage.createDataVector(flatBufferBuilder, iArr);
        } else {
            i4 = 0;
        }
        int createByteVector = bArr != null ? flatBufferBuilder.createByteVector(bArr) : 0;
        if (notification != null) {
            int createString10 = flatBufferBuilder.createString(emptyIfNull(notification.getTitle()));
            int createString11 = flatBufferBuilder.createString(emptyIfNull(notification.getBody()));
            int createString12 = flatBufferBuilder.createString(emptyIfNull(notification.getIcon()));
            int createString13 = flatBufferBuilder.createString(emptyIfNull(notification.getSound()));
            i11 = createString6;
            int createString14 = flatBufferBuilder.createString("");
            i15 = createByteVector;
            int createString15 = flatBufferBuilder.createString(emptyIfNull(notification.getTag()));
            i5 = i4;
            int createString16 = flatBufferBuilder.createString(emptyIfNull(notification.getColor()));
            i12 = createString7;
            int createString17 = flatBufferBuilder.createString(emptyIfNull(notification.getClickAction()));
            i10 = createString5;
            int createString18 = flatBufferBuilder.createString(emptyIfNull(notification.getChannelId()));
            i14 = createString9;
            int createString19 = flatBufferBuilder.createString(emptyIfNull(notification.getBodyLocalizationKey()));
            i13 = createString8;
            String[] bodyLocalizationArgs = notification.getBodyLocalizationArgs();
            if (bodyLocalizationArgs != null) {
                i9 = createString4;
                int[] iArr2 = new int[bodyLocalizationArgs.length];
                i8 = createString3;
                int length = bodyLocalizationArgs.length;
                int i20 = 0;
                int i21 = 0;
                while (i20 < length) {
                    iArr2[i21] = flatBufferBuilder.createString(bodyLocalizationArgs[i20]);
                    i20++;
                    length = length;
                    i21++;
                }
                i17 = SerializedNotification.createBodyLocArgsVector(flatBufferBuilder, iArr2);
            } else {
                i8 = createString3;
                i9 = createString4;
                i17 = 0;
            }
            int createString20 = flatBufferBuilder.createString(emptyIfNull(notification.getTitleLocalizationKey()));
            String[] titleLocalizationArgs = notification.getTitleLocalizationArgs();
            if (titleLocalizationArgs != null) {
                i7 = createString2;
                int[] iArr3 = new int[titleLocalizationArgs.length];
                i6 = createString;
                int length2 = titleLocalizationArgs.length;
                int i22 = 0;
                int i23 = 0;
                while (i22 < length2) {
                    iArr3[i23] = flatBufferBuilder.createString(titleLocalizationArgs[i22]);
                    i22++;
                    length2 = length2;
                    i23++;
                }
                i18 = SerializedNotification.createTitleLocArgsVector(flatBufferBuilder, iArr3);
            } else {
                i6 = createString;
                i7 = createString2;
                i18 = 0;
            }
            SerializedNotification.startSerializedNotification(flatBufferBuilder);
            SerializedNotification.addTitle(flatBufferBuilder, createString10);
            SerializedNotification.addBody(flatBufferBuilder, createString11);
            SerializedNotification.addIcon(flatBufferBuilder, createString12);
            SerializedNotification.addSound(flatBufferBuilder, createString13);
            SerializedNotification.addBadge(flatBufferBuilder, createString14);
            SerializedNotification.addTag(flatBufferBuilder, createString15);
            SerializedNotification.addColor(flatBufferBuilder, createString16);
            SerializedNotification.addClickAction(flatBufferBuilder, createString17);
            SerializedNotification.addAndroidChannelId(flatBufferBuilder, createString18);
            SerializedNotification.addBodyLocKey(flatBufferBuilder, createString19);
            SerializedNotification.addBodyLocArgs(flatBufferBuilder, i17);
            SerializedNotification.addTitleLocKey(flatBufferBuilder, createString20);
            SerializedNotification.addTitleLocArgs(flatBufferBuilder, i18);
            i16 = SerializedNotification.endSerializedNotification(flatBufferBuilder);
        } else {
            i5 = i4;
            i6 = createString;
            i7 = createString2;
            i8 = createString3;
            i9 = createString4;
            i10 = createString5;
            i11 = createString6;
            i12 = createString7;
            i13 = createString8;
            i14 = createString9;
            i15 = createByteVector;
            i16 = 0;
        }
        SerializedMessage.startSerializedMessage(flatBufferBuilder);
        SerializedMessage.addFrom(flatBufferBuilder, i6);
        SerializedMessage.addTo(flatBufferBuilder, i7);
        SerializedMessage.addMessageId(flatBufferBuilder, i8);
        SerializedMessage.addMessageType(flatBufferBuilder, i9);
        SerializedMessage.addPriority(flatBufferBuilder, i13);
        SerializedMessage.addOriginalPriority(flatBufferBuilder, i14);
        SerializedMessage.addSentTime(flatBufferBuilder, j);
        SerializedMessage.addTimeToLive(flatBufferBuilder, i3);
        SerializedMessage.addError(flatBufferBuilder, i10);
        SerializedMessage.addCollapseKey(flatBufferBuilder, i12);
        if (map != null) {
            SerializedMessage.addData(flatBufferBuilder, i5);
        }
        if (bArr != null) {
            SerializedMessage.addRawData(flatBufferBuilder, i15);
        }
        if (notification != null) {
            SerializedMessage.addNotification(flatBufferBuilder, i16);
        }
        SerializedMessage.addNotificationOpened(flatBufferBuilder, z);
        SerializedMessage.addLink(flatBufferBuilder, i11);
        int endSerializedMessage = SerializedMessage.endSerializedMessage(flatBufferBuilder);
        SerializedEvent.startSerializedEvent(flatBufferBuilder);
        SerializedEvent.addEventType(flatBufferBuilder, (byte) 1);
        SerializedEvent.addEvent(flatBufferBuilder, endSerializedMessage);
        flatBufferBuilder.finish(SerializedEvent.endSerializedEvent(flatBufferBuilder));
        return flatBufferBuilder.sizedByteArray();
    }
}
