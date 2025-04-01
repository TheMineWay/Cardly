package org.themineway.cardly.i18n

object I18n {
    private lateinit var language: Locale;

    init {
        setLanguage(Locale.en_US);
    }

    fun setLanguage(language: Locale) {
        I18n.language = language;

    }
}