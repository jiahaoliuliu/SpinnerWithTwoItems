package com.jiahaoliuliu.spinnerwithtwoitems;

/**
 * Some of the prefixes of phones according to
 * <a href="http://en.wikipedia.org/wiki/List_of_country_calling_codes">the list
 * of country calling codes</a>. Note that each country is saves with its
 * <a href="http://es.wikipedia.org/wiki/ISO_3166-1">ISO code (2 characters).</a>
 * 
 * @author Jiahao Liu Liu <a href="mailto:jiahaoliuliu@gmail.com">jiahaoliuliu@gmail.com</a>
 * @version 1.0
 * @since 1.0
 *
 */
public enum PhonePrefixes {
    DE("49"),
    SP("34"),
    GR("30");

    private String phonePrefix;

	private PhonePrefixes(final String phonePrefix) {
        this.phonePrefix = phonePrefix;
	}

	/**
	 * Return the phone prefix of the country.
	 * @since 1.0
	 *
	 * @return the phone prefix
	 */
	public String getPhonePrefix() {
	    return this.phonePrefix;
	}

	/**
	 * Return ISO code of the country
	 * 	<a href="http://es.wikipedia.org/wiki/ISO_3166-1">ISO code (2 characters).</a>
	 * @since 1.0
	 *
	 * @return The ISO code of the country
	 */
	public String getAbbreviation() {
	    return this.name();
	}

	@Override
	public String toString() {
		return getAbbreviation() + ":" + getPhonePrefix();
	}
}
