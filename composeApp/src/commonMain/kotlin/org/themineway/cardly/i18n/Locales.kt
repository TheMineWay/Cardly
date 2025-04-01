package org.themineway.cardly.i18n

import cardly.composeapp.generated.resources.Res
import kotlinx.serialization.json.*
import org.jetbrains.compose.resources.ExperimentalResourceApi

data class LocaleInfo(val locale: Locale, val i18nData: Map<String, String>);

object Locales {
    val locales = mapOf(Locale.en_US to "en-US.json");
    lateinit var activeLocale: LocaleInfo;

    suspend fun init(locale: Locale = Locale.en_US): Locales {
        val localeData = getLocaleFile(locale);
        activeLocale = LocaleInfo(locale, localeData);
        return this;
    }

    @OptIn(ExperimentalResourceApi::class)
    suspend fun getLocaleFile (locale: Locale): Map<String, String> {
        val path = "files/locales/${locales[locale]}";
        val fileData = Res.readBytes(path).decodeToString();

        val json: JsonObject = Json.parseToJsonElement(fileData) as JsonObject;
        return flattenJson(json);
    }

    private fun flattenJson(json: JsonObject, parentKey: String = ""): Map<String, String> {
        val result = mutableMapOf<String, String>()

        for ((key, value) in json) {
            val newKey = if (parentKey.isEmpty()) key else "$parentKey.$key"

            when (value) {
                is JsonObject -> result.putAll(flattenJson(value, newKey)) // Recursively flatten
                is JsonPrimitive -> result[newKey] = value.content // Store as key-value pair
                else -> {} // Ignore arrays or other structures if they appear
            }
        }

        return result
    }

    fun t(key: String): String {
        if (!activeLocale.i18nData.contains(key)) return key;
        return activeLocale.i18nData[key].toString();
    }
}