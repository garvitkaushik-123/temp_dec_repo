package com.unity.androidnotifications;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* loaded from: classes6.dex */
class UnityNotificationUtilities {
    private static final int INTENT_SERIALIZATION_VERSION = 0;
    private static final int NOTIFICATION_SERIALIZATION_VERSION = 3;
    static final String SAVED_NOTIFICATION_FALLBACK_KEY = "fallback.data";
    static final String SAVED_NOTIFICATION_PRIMARY_KEY = "data";
    static final byte[] UNITY_MAGIC_NUMBER = {85, 77, 78, 78};
    private static final byte[] UNITY_MAGIC_NUMBER_PARCELLED = {85, 77, 78, 80};

    UnityNotificationUtilities() {
    }

    protected static int findResourceIdInContextByName(Context context, String str) {
        if (str == null) {
            return 0;
        }
        try {
            Resources resources = context.getResources();
            if (resources != null) {
                int identifier = resources.getIdentifier(str, "mipmap", context.getPackageName());
                return identifier == 0 ? resources.getIdentifier(str, "drawable", context.getPackageName()) : identifier;
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    protected static void serializeNotification(SharedPreferences sharedPreferences, Notification notification, boolean z) {
        String encodeToString;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (z) {
                Intent intent = new Intent();
                intent.putExtra(UnityNotificationManager.KEY_NOTIFICATION, notification);
                if (!serializeNotificationParcel(intent, dataOutputStream)) {
                    return;
                }
                dataOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                encodeToString = Base64.encodeToString(byteArray, 0, byteArray.length, 0);
            } else {
                if (!serializeNotificationCustom(notification, dataOutputStream)) {
                    return;
                }
                dataOutputStream.flush();
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                encodeToString = Base64.encodeToString(byteArray2, 0, byteArray2.length, 0);
            }
            SharedPreferences.Editor clear = sharedPreferences.edit().clear();
            clear.putString("data", encodeToString);
            clear.apply();
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to serialize notification", e);
        }
    }

    static boolean serializeNotificationParcel(Intent intent, DataOutputStream dataOutputStream) {
        try {
            byte[] serializeParcelable = serializeParcelable(intent);
            if (serializeParcelable != null && serializeParcelable.length != 0) {
                dataOutputStream.write(UNITY_MAGIC_NUMBER_PARCELLED);
                dataOutputStream.writeInt(0);
                dataOutputStream.writeInt(serializeParcelable.length);
                dataOutputStream.write(serializeParcelable);
                return true;
            }
            return false;
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to serialize notification as Parcel", e);
            return false;
        } catch (OutOfMemoryError e2) {
            Log.e("UnityNotifications", "Failed to serialize notification as Parcel", e2);
            return false;
        }
    }

    private static boolean serializeNotificationCustom(Notification notification, DataOutputStream dataOutputStream) {
        try {
            dataOutputStream.write(UNITY_MAGIC_NUMBER);
            dataOutputStream.writeInt(3);
            boolean z = notification.extras.getBoolean(NotificationCompat.EXTRA_SHOW_WHEN, false);
            dataOutputStream.writeInt(notification.extras.getInt("id"));
            serializeString(dataOutputStream, notification.extras.getString(NotificationCompat.EXTRA_TITLE));
            serializeString(dataOutputStream, notification.extras.getString(NotificationCompat.EXTRA_TEXT));
            serializeString(dataOutputStream, notification.extras.getString(UnityNotificationManager.KEY_SMALL_ICON));
            serializeString(dataOutputStream, notification.extras.getString(UnityNotificationManager.KEY_LARGE_ICON));
            dataOutputStream.writeLong(notification.extras.getLong(UnityNotificationManager.KEY_FIRE_TIME, -1L));
            dataOutputStream.writeLong(notification.extras.getLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, -1L));
            serializeString(dataOutputStream, notification.extras.getString(NotificationCompat.EXTRA_BIG_TEXT));
            dataOutputStream.writeBoolean(notification.extras.getBoolean(NotificationCompat.EXTRA_SHOW_CHRONOMETER, false));
            dataOutputStream.writeBoolean(z);
            serializeString(dataOutputStream, notification.extras.getString("data"));
            dataOutputStream.writeBoolean(notification.extras.getBoolean(UnityNotificationManager.KEY_SHOW_IN_FOREGROUND, true));
            String string = notification.extras.getString(UnityNotificationManager.KEY_BIG_PICTURE);
            serializeString(dataOutputStream, string);
            if (string != null && string.length() > 0) {
                serializeString(dataOutputStream, notification.extras.getString(UnityNotificationManager.KEY_BIG_LARGE_ICON));
                serializeString(dataOutputStream, notification.extras.getString(UnityNotificationManager.KEY_BIG_CONTENT_TITLE));
                serializeString(dataOutputStream, notification.extras.getString(UnityNotificationManager.KEY_BIG_CONTENT_DESCRIPTION));
                serializeString(dataOutputStream, notification.extras.getString(UnityNotificationManager.KEY_BIG_SUMMARY_TEXT));
                dataOutputStream.writeBoolean(notification.extras.getBoolean(UnityNotificationManager.KEY_BIG_SHOW_WHEN_COLLAPSED, false));
            }
            serializeString(dataOutputStream, notification.getChannelId());
            Integer notificationColor = UnityNotificationManager.getNotificationColor(notification);
            dataOutputStream.writeBoolean(notificationColor != null);
            if (notificationColor != null) {
                dataOutputStream.writeInt(notificationColor.intValue());
            }
            dataOutputStream.writeInt(notification.number);
            dataOutputStream.writeBoolean((notification.flags & 16) != 0);
            serializeString(dataOutputStream, notification.getGroup());
            dataOutputStream.writeBoolean((notification.flags & 512) != 0);
            dataOutputStream.writeInt(UnityNotificationManager.getNotificationGroupAlertBehavior(notification));
            serializeString(dataOutputStream, notification.getSortKey());
            if (z) {
                dataOutputStream.writeLong(notification.when);
            }
            return true;
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to serialize notification", e);
            return false;
        }
    }

    static void serializeString(DataOutputStream dataOutputStream, String str) throws IOException {
        if (str == null || str.length() == 0) {
            dataOutputStream.writeInt(0);
            return;
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);
    }

    static byte[] serializeParcelable(Parcelable parcelable) {
        try {
            Parcel obtain = Parcel.obtain();
            Bundle bundle = new Bundle();
            bundle.putParcelable("obj", parcelable);
            obtain.writeParcelable(bundle, 0);
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to serialize Parcelable", e);
            return null;
        } catch (OutOfMemoryError e2) {
            Log.e("UnityNotifications", "Failed to serialize Parcelable", e2);
            return null;
        }
    }

    protected static Object deserializeNotification(Context context, SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("data", "");
        if (string != null && string.length() > 0) {
            Object deserializeNotification = deserializeNotification(context, Base64.decode(string, 0));
            if (deserializeNotification != null) {
                return deserializeNotification;
            }
            String string2 = sharedPreferences.getString(SAVED_NOTIFICATION_FALLBACK_KEY, "");
            if (string2 != null && string2.length() > 0) {
                return deserializeNotification(context, Base64.decode(string2, 0));
            }
        }
        return null;
    }

    private static Object deserializeNotification(Context context, byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        Notification deserializeNotificationParcelable = deserializeNotificationParcelable(dataInputStream);
        if (deserializeNotificationParcelable != null) {
            return deserializeNotificationParcelable;
        }
        byteArrayInputStream.reset();
        Notification.Builder deserializeNotificationCustom = deserializeNotificationCustom(context, dataInputStream);
        return deserializeNotificationCustom == null ? deserializedFromOldIntent(context, bArr) : deserializeNotificationCustom;
    }

    private static boolean readAndCheckMagicNumber(DataInputStream dataInputStream, byte[] bArr) {
        for (byte b : bArr) {
            try {
                if (dataInputStream.readByte() != b) {
                    return false;
                }
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    private static Notification deserializeNotificationParcelable(DataInputStream dataInputStream) {
        int readInt;
        try {
            if (readAndCheckMagicNumber(dataInputStream, UNITY_MAGIC_NUMBER_PARCELLED) && (readInt = dataInputStream.readInt()) >= 0 && readInt <= 0) {
                return (Notification) ((Intent) deserializeParcelable(dataInputStream)).getParcelableExtra(UnityNotificationManager.KEY_NOTIFICATION);
            }
            return null;
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to deserialize notification intent", e);
            return null;
        } catch (OutOfMemoryError e2) {
            Log.e("UnityNotifications", "Failed to deserialize notification intent", e2);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01fc A[Catch: OutOfMemoryError -> 0x0242, Exception -> 0x0244, TryCatch #6 {Exception -> 0x0244, OutOfMemoryError -> 0x0242, blocks: (B:31:0x0147, B:33:0x0151, B:34:0x0158, B:36:0x017e, B:37:0x0185, B:39:0x0193, B:41:0x01d8, B:43:0x01dd, B:45:0x01e2, B:48:0x01fc, B:50:0x0203, B:51:0x0208, B:53:0x0214, B:55:0x021a, B:56:0x021f, B:58:0x022b, B:60:0x0231, B:62:0x0238, B:66:0x01f1, B:67:0x0199, B:69:0x01b0, B:72:0x01bd, B:74:0x01c6, B:75:0x01cd), top: B:30:0x0147 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0203 A[Catch: OutOfMemoryError -> 0x0242, Exception -> 0x0244, TryCatch #6 {Exception -> 0x0244, OutOfMemoryError -> 0x0242, blocks: (B:31:0x0147, B:33:0x0151, B:34:0x0158, B:36:0x017e, B:37:0x0185, B:39:0x0193, B:41:0x01d8, B:43:0x01dd, B:45:0x01e2, B:48:0x01fc, B:50:0x0203, B:51:0x0208, B:53:0x0214, B:55:0x021a, B:56:0x021f, B:58:0x022b, B:60:0x0231, B:62:0x0238, B:66:0x01f1, B:67:0x0199, B:69:0x01b0, B:72:0x01bd, B:74:0x01c6, B:75:0x01cd), top: B:30:0x0147 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0238 A[Catch: OutOfMemoryError -> 0x0242, Exception -> 0x0244, TRY_LEAVE, TryCatch #6 {Exception -> 0x0244, OutOfMemoryError -> 0x0242, blocks: (B:31:0x0147, B:33:0x0151, B:34:0x0158, B:36:0x017e, B:37:0x0185, B:39:0x0193, B:41:0x01d8, B:43:0x01dd, B:45:0x01e2, B:48:0x01fc, B:50:0x0203, B:51:0x0208, B:53:0x0214, B:55:0x021a, B:56:0x021f, B:58:0x022b, B:60:0x0231, B:62:0x0238, B:66:0x01f1, B:67:0x0199, B:69:0x01b0, B:72:0x01bd, B:74:0x01c6, B:75:0x01cd), top: B:30:0x0147 }] */
    /* JADX WARN: Type inference failed for: r29v2 */
    /* JADX WARN: Type inference failed for: r29v3, types: [com.unity.androidnotifications.UnityNotificationManager] */
    /* JADX WARN: Type inference failed for: r29v4 */
    /* JADX WARN: Type inference failed for: r34v0 */
    /* JADX WARN: Type inference failed for: r34v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r34v2 */
    /* JADX WARN: Type inference failed for: r34v3 */
    /* JADX WARN: Type inference failed for: r34v4 */
    /* JADX WARN: Type inference failed for: r35v0 */
    /* JADX WARN: Type inference failed for: r35v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r35v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Notification.Builder deserializeNotificationCustom(Context context, DataInputStream dataInputStream) {
        String str;
        String str2;
        Notification.Builder builder;
        String str3;
        String str4;
        String str5;
        String str6;
        Bundle bundle;
        boolean z;
        String str7;
        String str8;
        String str9;
        ?? r34;
        ?? r35;
        int i;
        boolean z2;
        String str10;
        String str11;
        long j;
        long j2;
        String str12;
        boolean z3;
        String string;
        long j3;
        String str13;
        String str14;
        boolean z4;
        ?? r29;
        Notification.Builder builder2;
        Object obj;
        try {
            try {
                try {
                    if (!readAndCheckMagicNumber(dataInputStream, UNITY_MAGIC_NUMBER)) {
                        return null;
                    }
                    int readInt = dataInputStream.readInt();
                    if (readInt < 0 || readInt > 3) {
                        return null;
                    }
                    if (readInt < 2) {
                        try {
                            bundle = (Bundle) deserializeParcelable(dataInputStream);
                        } catch (OutOfMemoryError e) {
                            e = e;
                            str5 = "Failed to deserialize notification";
                            str6 = "UnityNotifications";
                            builder = null;
                            Log.e(str6, str5, e);
                            return builder;
                        }
                    } else {
                        bundle = null;
                    }
                    if (bundle == null) {
                        int readInt2 = dataInputStream.readInt();
                        String deserializeString = deserializeString(dataInputStream);
                        String deserializeString2 = deserializeString(dataInputStream);
                        String deserializeString3 = deserializeString(dataInputStream);
                        String deserializeString4 = deserializeString(dataInputStream);
                        long readLong = dataInputStream.readLong();
                        long readLong2 = dataInputStream.readLong();
                        String deserializeString5 = deserializeString(dataInputStream);
                        boolean readBoolean = dataInputStream.readBoolean();
                        z = dataInputStream.readBoolean();
                        String deserializeString6 = deserializeString(dataInputStream);
                        boolean readBoolean2 = readInt > 0 ? dataInputStream.readBoolean() : true;
                        if (readInt >= 3) {
                            String deserializeString7 = deserializeString(dataInputStream);
                            if (deserializeString7 == null || deserializeString7.length() <= 0) {
                                str8 = deserializeString7;
                                str7 = null;
                                str9 = null;
                            } else {
                                String deserializeString8 = deserializeString(dataInputStream);
                                String deserializeString9 = deserializeString(dataInputStream);
                                j = readLong;
                                j2 = readLong2;
                                str12 = deserializeString5;
                                z3 = readBoolean;
                                string = deserializeString6;
                                r34 = deserializeString(dataInputStream);
                                obj = deserializeString(dataInputStream);
                                z2 = dataInputStream.readBoolean();
                                str8 = deserializeString7;
                                str3 = "Failed to deserialize notification";
                                str4 = "UnityNotifications";
                                str7 = deserializeString8;
                                i = readInt2;
                                str10 = deserializeString;
                                z4 = readBoolean2;
                                str9 = deserializeString9;
                                builder = null;
                                str11 = deserializeString2;
                                j3 = -1;
                                str13 = deserializeString3;
                                str14 = deserializeString4;
                                r35 = obj;
                            }
                        } else {
                            str7 = null;
                            str8 = null;
                            str9 = null;
                        }
                        r34 = str9;
                        Notification.Builder builder3 = r34;
                        z2 = false;
                        i = readInt2;
                        str10 = deserializeString;
                        j = readLong;
                        j2 = readLong2;
                        str12 = deserializeString5;
                        z3 = readBoolean;
                        string = deserializeString6;
                        str3 = "Failed to deserialize notification";
                        str4 = "UnityNotifications";
                        builder = builder3;
                        str11 = deserializeString2;
                        z4 = readBoolean2;
                        obj = builder3;
                        j3 = -1;
                        str13 = deserializeString3;
                        str14 = deserializeString4;
                        r35 = obj;
                    } else {
                        String string2 = bundle.getString(NotificationCompat.EXTRA_TITLE);
                        String string3 = bundle.getString(NotificationCompat.EXTRA_TEXT);
                        String string4 = bundle.getString(UnityNotificationManager.KEY_SMALL_ICON);
                        String string5 = bundle.getString(UnityNotificationManager.KEY_LARGE_ICON);
                        long j4 = bundle.getLong(UnityNotificationManager.KEY_FIRE_TIME, -1L);
                        long j5 = bundle.getLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, -1L);
                        String string6 = bundle.getString(NotificationCompat.EXTRA_BIG_TEXT);
                        boolean z5 = bundle.getBoolean(NotificationCompat.EXTRA_SHOW_CHRONOMETER, false);
                        z = bundle.getBoolean(NotificationCompat.EXTRA_SHOW_WHEN, false);
                        builder = null;
                        str7 = null;
                        str8 = null;
                        str9 = null;
                        r34 = null;
                        r35 = 0;
                        i = 0;
                        z2 = false;
                        str10 = string2;
                        str11 = string3;
                        j = j4;
                        j2 = j5;
                        str12 = string6;
                        z3 = z5;
                        string = bundle.getString("data");
                        str3 = "Failed to deserialize notification";
                        str4 = "UnityNotifications";
                        j3 = -1;
                        str13 = string4;
                        str14 = string5;
                        z4 = true;
                    }
                    try {
                        String deserializeString10 = deserializeString(dataInputStream);
                        boolean readBoolean3 = dataInputStream.readBoolean();
                        int readInt3 = readBoolean3 ? dataInputStream.readInt() : 0;
                        boolean z6 = z3;
                        int readInt4 = dataInputStream.readInt();
                        boolean readBoolean4 = dataInputStream.readBoolean();
                        String deserializeString11 = deserializeString(dataInputStream);
                        boolean readBoolean5 = dataInputStream.readBoolean();
                        int readInt5 = dataInputStream.readInt();
                        String deserializeString12 = deserializeString(dataInputStream);
                        long readLong3 = z ? dataInputStream.readLong() : 0L;
                        UnityNotificationManager notificationManagerImpl = UnityNotificationManager.getNotificationManagerImpl(context);
                        Notification.Builder createNotificationBuilder = notificationManagerImpl.createNotificationBuilder(deserializeString10);
                        if (bundle != null) {
                            createNotificationBuilder.setExtras(bundle);
                            r29 = notificationManagerImpl;
                        } else {
                            r29 = notificationManagerImpl;
                            createNotificationBuilder.getExtras().putInt("id", i);
                            UnityNotificationManager.setNotificationIcon(createNotificationBuilder, UnityNotificationManager.KEY_SMALL_ICON, str13);
                            UnityNotificationManager.setNotificationIcon(createNotificationBuilder, UnityNotificationManager.KEY_LARGE_ICON, str14);
                            long j6 = j;
                            if (j6 != j3) {
                                createNotificationBuilder.getExtras().putLong(UnityNotificationManager.KEY_FIRE_TIME, j6);
                            }
                            long j7 = j2;
                            if (j7 != j3) {
                                createNotificationBuilder.getExtras().putLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, j7);
                            }
                            if (string != null) {
                                createNotificationBuilder.getExtras().putString("data", string);
                            }
                            createNotificationBuilder.getExtras().putBoolean(UnityNotificationManager.KEY_SHOW_IN_FOREGROUND, z4);
                        }
                        if (str10 != null) {
                            createNotificationBuilder.setContentTitle(str10);
                        }
                        if (str11 != null) {
                            createNotificationBuilder.setContentText(str11);
                        }
                        if (str12 != null) {
                            createNotificationBuilder.setStyle(new Notification.BigTextStyle().bigText(str12));
                        } else if (str8 != null) {
                            r29.setupBigPictureStyle(createNotificationBuilder, str7, str8, str9, r34, r35, z2);
                            builder2 = createNotificationBuilder;
                            if (readBoolean3) {
                                UnityNotificationManager.setNotificationColor(builder2, readInt3);
                            }
                            if (readInt4 >= 0) {
                                builder2.setNumber(readInt4);
                            }
                            builder2.setAutoCancel(readBoolean4);
                            UnityNotificationManager.setNotificationUsesChronometer(builder2, z6);
                            if (deserializeString11 != null && deserializeString11.length() > 0) {
                                builder2.setGroup(deserializeString11);
                            }
                            builder2.setGroupSummary(readBoolean5);
                            UnityNotificationManager.setNotificationGroupAlertBehavior(builder2, readInt5);
                            if (deserializeString12 != null && deserializeString12.length() > 0) {
                                builder2.setSortKey(deserializeString12);
                            }
                            if (z) {
                                builder2.setShowWhen(true);
                                builder2.setWhen(readLong3);
                            }
                            return builder2;
                        }
                        builder2 = createNotificationBuilder;
                        if (readBoolean3) {
                        }
                        if (readInt4 >= 0) {
                        }
                        builder2.setAutoCancel(readBoolean4);
                        UnityNotificationManager.setNotificationUsesChronometer(builder2, z6);
                        if (deserializeString11 != null) {
                            builder2.setGroup(deserializeString11);
                        }
                        builder2.setGroupSummary(readBoolean5);
                        UnityNotificationManager.setNotificationGroupAlertBehavior(builder2, readInt5);
                        if (deserializeString12 != null) {
                            builder2.setSortKey(deserializeString12);
                        }
                        if (z) {
                        }
                        return builder2;
                    } catch (Exception e2) {
                        e = e2;
                        str = str3;
                        str2 = str4;
                        Log.e(str2, str, e);
                        return builder;
                    } catch (OutOfMemoryError e3) {
                        e = e3;
                        str5 = str3;
                        str6 = str4;
                        Log.e(str6, str5, e);
                        return builder;
                    }
                } catch (Exception e4) {
                    e = e4;
                    str3 = "Failed to deserialize notification";
                    str4 = "UnityNotifications";
                    builder = null;
                }
            } catch (OutOfMemoryError e5) {
                e = e5;
                str3 = "Failed to deserialize notification";
                str4 = "UnityNotifications";
                builder = null;
            }
        } catch (Exception e6) {
            e = e6;
            str = "Failed to deserialize notification";
            str2 = "UnityNotifications";
            builder = null;
        }
    }

    private static Notification.Builder deserializedFromOldIntent(Context context, byte[] bArr) {
        String str;
        String str2;
        String str3;
        String str4;
        Bundle bundle;
        int i;
        String string;
        String string2;
        String string3;
        String string4;
        boolean z;
        boolean z2;
        long j;
        long j2;
        try {
            try {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(bArr, 0, bArr.length);
                    obtain.setDataPosition(0);
                    bundle = new Bundle();
                    bundle.readFromParcel(obtain);
                    i = bundle.getInt("id", -1);
                    string = bundle.getString(UnityNotificationManager.KEY_CHANNEL_ID);
                    string2 = bundle.getString("textTitle");
                    string3 = bundle.getString("textContent");
                    string4 = bundle.getString("smallIconStr");
                    z = bundle.getBoolean("autoCancel", false);
                    z2 = bundle.getBoolean("usesChronometer", false);
                    j = bundle.getLong(UnityNotificationManager.KEY_FIRE_TIME, -1L);
                    j2 = bundle.getLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, -1L);
                    str = "Failed to deserialize old style notification";
                } catch (Exception e) {
                    e = e;
                    str = "Failed to deserialize old style notification";
                }
            } catch (Exception e2) {
                e = e2;
                str2 = "Failed to deserialize old style notification";
                str3 = "UnityNotifications";
            }
        } catch (OutOfMemoryError e3) {
            e = e3;
            str = "Failed to deserialize old style notification";
        }
        try {
            String string5 = bundle.getString("largeIconStr");
            str4 = "UnityNotifications";
            try {
                int i2 = bundle.getInt("style", -1);
                int i3 = bundle.getInt("color", 0);
                int i4 = bundle.getInt("number", 0);
                String string6 = bundle.getString("data");
                String string7 = bundle.getString("group");
                boolean z3 = bundle.getBoolean("groupSummary", false);
                String string8 = bundle.getString("sortKey");
                int i5 = bundle.getInt("groupAlertBehaviour", -1);
                boolean z4 = bundle.getBoolean("showTimestamp", false);
                Notification.Builder createNotificationBuilder = UnityNotificationManager.getNotificationManagerImpl(context).createNotificationBuilder(string);
                createNotificationBuilder.getExtras().putInt("id", i);
                createNotificationBuilder.setContentTitle(string2);
                createNotificationBuilder.setContentText(string3);
                UnityNotificationManager.setNotificationIcon(createNotificationBuilder, UnityNotificationManager.KEY_SMALL_ICON, string4);
                createNotificationBuilder.setAutoCancel(z);
                createNotificationBuilder.setUsesChronometer(z2);
                createNotificationBuilder.getExtras().putLong(UnityNotificationManager.KEY_FIRE_TIME, j);
                createNotificationBuilder.getExtras().putLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, j2);
                UnityNotificationManager.setNotificationIcon(createNotificationBuilder, UnityNotificationManager.KEY_LARGE_ICON, string5);
                if (i2 == 2) {
                    createNotificationBuilder.setStyle(new Notification.BigTextStyle().bigText(string3));
                }
                if (i3 != 0) {
                    UnityNotificationManager.setNotificationColor(createNotificationBuilder, i3);
                }
                if (i4 >= 0) {
                    createNotificationBuilder.setNumber(i4);
                }
                if (string6 != null) {
                    createNotificationBuilder.getExtras().putString("data", string6);
                }
                if (string7 != null && string7.length() > 0) {
                    createNotificationBuilder.setGroup(string7);
                }
                createNotificationBuilder.setGroupSummary(z3);
                if (string8 != null && string8.length() > 0) {
                    createNotificationBuilder.setSortKey(string8);
                }
                UnityNotificationManager.setNotificationGroupAlertBehavior(createNotificationBuilder, i5);
                createNotificationBuilder.setShowWhen(z4);
                return createNotificationBuilder;
            } catch (Exception e4) {
                e = e4;
                str2 = str;
                str3 = str4;
                Log.e(str3, str2, e);
                return null;
            } catch (OutOfMemoryError e5) {
                e = e5;
                Log.e(str4, str, e);
                return null;
            }
        } catch (Exception e6) {
            e = e6;
            str4 = "UnityNotifications";
            str2 = str;
            str3 = str4;
            Log.e(str3, str2, e);
            return null;
        } catch (OutOfMemoryError e7) {
            e = e7;
            str4 = "UnityNotifications";
            Log.e(str4, str, e);
            return null;
        }
    }

    private static String deserializeString(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        if (readInt <= 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        if (dataInputStream.read(bArr) != readInt) {
            throw new IOException("Insufficient amount of bytes read");
        }
        return new String(bArr, StandardCharsets.UTF_8);
    }

    private static <T extends Parcelable> T deserializeParcelable(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        if (readInt <= 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        if (dataInputStream.read(bArr) != readInt) {
            throw new IOException("Insufficient amount of bytes read");
        }
        try {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(bArr, 0, readInt);
            obtain.setDataPosition(0);
            Bundle bundle = (Bundle) obtain.readParcelable(UnityNotificationUtilities.class.getClassLoader());
            obtain.recycle();
            if (bundle != null) {
                return (T) bundle.getParcelable("obj");
            }
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to deserialize parcelable", e);
        } catch (OutOfMemoryError e2) {
            Log.e("UnityNotifications", "Failed to deserialize parcelable", e2);
        }
        return null;
    }

    protected static Class<?> getOpenAppActivity(Context context) {
        try {
            try {
                PackageManager packageManager = context.getPackageManager();
                Bundle bundle = packageManager.getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle.containsKey("custom_notification_android_activity")) {
                    try {
                        return Class.forName(bundle.getString("custom_notification_android_activity"));
                    } catch (ClassNotFoundException e) {
                        Log.e("UnityNotifications", "Specified activity class for notifications not found: " + e.getMessage());
                    }
                }
                Log.w("UnityNotifications", "No custom_notification_android_activity found, attempting to find app activity class");
                boolean z = true;
                ActivityInfo[] activityInfoArr = packageManager.getPackageInfo(context.getPackageName(), 1).activities;
                if (activityInfoArr == null) {
                    Log.e("UnityNotifications", "Could not get package activities");
                    return null;
                }
                int length = activityInfoArr.length;
                String str = null;
                int i = 0;
                boolean z2 = false;
                boolean z3 = false;
                while (true) {
                    if (i >= length) {
                        z = z3;
                        break;
                    }
                    ActivityInfo activityInfo = activityInfoArr[i];
                    if (activityInfo.enabled && activityInfo.targetActivity == null) {
                        boolean isUnityActivity = isUnityActivity(activityInfo.name);
                        if (str == null) {
                            str = activityInfo.name;
                        } else if (z2 == isUnityActivity) {
                            if (z2 && isUnityActivity) {
                                break;
                            }
                            z3 = true;
                        } else if (isUnityActivity) {
                            str = activityInfo.name;
                            z3 = false;
                        }
                        z2 = isUnityActivity;
                    }
                    i++;
                }
                if (z) {
                    Log.e("UnityNotifications", "Multiple choices for activity for notifications, set activity explicitly in Notification Settings");
                    return null;
                }
                if (str != null) {
                    return Class.forName(str);
                }
                Log.e("UnityNotifications", "Activity class for notifications not found");
                return null;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return null;
            }
        } catch (ClassNotFoundException e3) {
            Log.e("UnityNotifications", "Failed to find activity class: " + e3.getMessage());
            return null;
        }
    }

    private static boolean isUnityActivity(String str) {
        return str.endsWith(".UnityPlayerActivity") || str.endsWith(".UnityPlayerGameActivity");
    }

    protected static Notification.Builder recoverBuilder(Context context, Notification notification) {
        try {
            Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, notification);
            recoverBuilder.setExtras(notification.extras);
            return recoverBuilder;
        } catch (Exception e) {
            Log.e("UnityNotifications", "Failed to recover builder for notification!", e);
            return recoverBuilderCustom(context, notification);
        } catch (OutOfMemoryError e2) {
            Log.e("UnityNotifications", "Failed to recover builder for notification!", e2);
            return recoverBuilderCustom(context, notification);
        }
    }

    private static Notification.Builder recoverBuilderCustom(Context context, Notification notification) {
        Notification.Builder createNotificationBuilder = UnityNotificationManager.getNotificationManagerImpl(context).createNotificationBuilder(notification.extras.getString(UnityNotificationManager.KEY_CHANNEL_ID));
        UnityNotificationManager.setNotificationIcon(createNotificationBuilder, UnityNotificationManager.KEY_SMALL_ICON, notification.extras.getString(UnityNotificationManager.KEY_SMALL_ICON));
        String string = notification.extras.getString(UnityNotificationManager.KEY_LARGE_ICON);
        if (string != null && !string.isEmpty()) {
            UnityNotificationManager.setNotificationIcon(createNotificationBuilder, UnityNotificationManager.KEY_LARGE_ICON, string);
        }
        createNotificationBuilder.setContentTitle(notification.extras.getString(NotificationCompat.EXTRA_TITLE));
        createNotificationBuilder.setContentText(notification.extras.getString(NotificationCompat.EXTRA_TEXT));
        createNotificationBuilder.setAutoCancel((notification.flags & 16) != 0);
        if (notification.number >= 0) {
            createNotificationBuilder.setNumber(notification.number);
        }
        String string2 = notification.extras.getString(NotificationCompat.EXTRA_BIG_TEXT);
        if (string2 != null) {
            createNotificationBuilder.setStyle(new Notification.BigTextStyle().bigText(string2));
        }
        createNotificationBuilder.setWhen(notification.when);
        String group = notification.getGroup();
        if (group != null && !group.isEmpty()) {
            createNotificationBuilder.setGroup(group);
        }
        createNotificationBuilder.setGroupSummary((notification.flags & 512) != 0);
        String sortKey = notification.getSortKey();
        if (sortKey != null && !sortKey.isEmpty()) {
            createNotificationBuilder.setSortKey(sortKey);
        }
        createNotificationBuilder.setShowWhen(notification.extras.getBoolean(NotificationCompat.EXTRA_SHOW_WHEN, false));
        Integer notificationColor = UnityNotificationManager.getNotificationColor(notification);
        if (notificationColor != null) {
            UnityNotificationManager.setNotificationColor(createNotificationBuilder, notificationColor.intValue());
        }
        UnityNotificationManager.setNotificationUsesChronometer(createNotificationBuilder, notification.extras.getBoolean(NotificationCompat.EXTRA_SHOW_CHRONOMETER, false));
        UnityNotificationManager.setNotificationGroupAlertBehavior(createNotificationBuilder, UnityNotificationManager.getNotificationGroupAlertBehavior(notification));
        createNotificationBuilder.getExtras().putInt("id", notification.extras.getInt("id", 0));
        createNotificationBuilder.getExtras().putLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, notification.extras.getLong(UnityNotificationManager.KEY_REPEAT_INTERVAL, 0L));
        createNotificationBuilder.getExtras().putLong(UnityNotificationManager.KEY_FIRE_TIME, notification.extras.getLong(UnityNotificationManager.KEY_FIRE_TIME, 0L));
        String string3 = notification.extras.getString("data");
        if (string3 != null && !string3.isEmpty()) {
            createNotificationBuilder.getExtras().putString("data", string3);
        }
        return createNotificationBuilder;
    }
}
