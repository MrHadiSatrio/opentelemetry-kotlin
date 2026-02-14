package io.opentelemetry.kotlin.attributes

import io.opentelemetry.kotlin.ExperimentalApi

@OptIn(ExperimentalApi::class)
class FakeAttributeFactory(private val map: Map<String, Any> = mutableMapOf()) : AttributeFactory {

  constructor(vararg attribute: Pair<String, Any>) : this(attribute.toMap())

  override fun addTo(container: MutableAttributeContainer) {
    container.setAttributes(map)
  }
}
