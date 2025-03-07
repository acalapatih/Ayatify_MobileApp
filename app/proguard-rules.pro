# Please add these rules to your existing keep rules in order to suppress warnings.
# This is generated automatically by the Android Gradle plugin.
-dontwarn reactor.blockhound.integration.BlockHoundIntegration
# Jangan obfuscate atau strip model yang digunakan dalam refleksi
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.google.gson.** { *; }
-keep class retrofit2.** { *; }
-keep class okhttp3.** { *; }
-keep class com.acalapatih.ayatify.core.domain.model.bacaquran.** { *; }
-keep class com.acalapatih.ayatify.core.data.source.remote.response.** { *; }
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}