package io.opentelemetry.kotlin.resource

import android.os.Build
import io.opentelemetry.kotlin.ExperimentalApi
import io.opentelemetry.kotlin.attributes.AttributeFactory
import io.opentelemetry.kotlin.semconv.AndroidAttributes
import io.opentelemetry.kotlin.semconv.IncubatingApi
import io.opentelemetry.kotlin.semconv.OsAttributes

@ExperimentalApi
@OptIn(IncubatingApi::class)
internal actual fun buildResourceAttributeFactory(): AttributeFactory {
    return AttributeFactory { container ->
        container.setStringAttribute(OsAttributes.OS_TYPE, "linux")
        container.setStringAttribute(OsAttributes.OS_NAME, "android")
        container.setStringAttribute(OsAttributes.OS_VERSION, Build.VERSION.RELEASE)
        container.setStringAttribute(OsAttributes.OS_BUILD_ID, Build.ID)
        container.setLongAttribute(
            AndroidAttributes.ANDROID_OS_API_LEVEL,
            Build.VERSION.SDK_INT.toLong(),
        )
    }
}
