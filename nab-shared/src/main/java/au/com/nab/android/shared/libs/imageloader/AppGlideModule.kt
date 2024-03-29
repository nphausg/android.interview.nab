package au.com.nab.android.shared.libs.imageloader

import android.content.Context
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.MemoryCategory
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import au.com.nab.android.shared.libs.device.DeviceUtils

@GlideModule
class AppGlideModule : AppGlideModule() {

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        super.registerComponents(context, glide, registry)
        if (DeviceUtils.isHighPerformingDevice(context)) {
            glide.setMemoryCategory(MemoryCategory.NORMAL)
        } else {
            glide.setMemoryCategory(MemoryCategory.LOW)
        }
    }

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setLogLevel(Log.INFO)
        if (DeviceUtils.isHighPerformingDevice(context)) {
            builder.setDefaultRequestOptions(RequestOptions().format(DecodeFormat.PREFER_ARGB_8888))
        } else {
            builder.setDefaultRequestOptions(RequestOptions().format(DecodeFormat.PREFER_RGB_565))
        }
    }

    override fun isManifestParsingEnabled(): Boolean {
        return false
    }
}