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
	// United States
    US(1),

    // Greece
    GR(30),

    // Kingdom of the Netherlands
    NL(31),

    // Belgium
    BE(32),

    // France
    FR(33),

    // Spain
    ES(34),
    
    // Hungary 
    HU(36),
    
    // Italy
    IT(39),

    // Romania
    RO(40),

    // Switzerland
    CH(41),

    // Austria
    AT(43),

    // United Kingdom
    GB(44),

    // Denmark
    DK(45),

    // Sweden
    SE(46),

    // Norway
    NO(47),

    // Poland
    PL(48),

    // Germany
    DE(49),

    // Peru
    PE(51),

    // Mexico
    MX(52),

    // Cuba
    CU(53),

    // Argentina
    AR(54),

    // Brazil
    BR(55),

    // Chile
    CL(569),

    // Colombia
    CO(57),

    // Venezuela
    VE(58),

    // Australia
    AU(61),

    // New Zealand
    NZ(64),

    // China
    CN(86),

    // Morocco
    MA(212),

    // Congo
    CG(242),

    // Greenland
    GL(299),

    // Gibraltar
    GI(350),

    // Portugal
    PT(351),

    // Luxembourg
    LU(352),

    // Republic of Ireland
    IE(353),

    // Iceland
    IS(354),

    // Albania
    AL(355),

    // Cyprus
    CY(357),

    // Finland
    FI(358),

    // Andorra
    AD(376),

    // Monaco
    MC(377),
    
    // Croatia
    HR(385),

    // Czech Republic
    CZ(420),

    // Slovakia
    SK(421),

    // Liechtenstein
    LI(423),
    
    // Guatemala
    GT(502),

    // Nicaragua
    NI(505),

    // Costa Rica
    CR(506),

    // Panama
    PA(507),

    // Bolivia
    BO(591),

    // Ecuador
    EC(593),

    // Paraguay
    PY(595),

    // Uruguay
    UY(598),

    // United Arab Emirates
    AE(971),

    // Israel
    IL(972),

    // Dominican Republic
    DO(1809);

    private int phonePrefix;

	private PhonePrefixes(final int phonePrefix) {
        this.phonePrefix = phonePrefix;
	}

	/**
	 * Return the phone prefix of the country.
	 * @since 1.0
	 *
	 * @return the phone prefix
	 */
	public int getPhonePrefix() {
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

	/**
	 * Retrieve the prefix by the iso code
	 * @param isoCode The iso code of the countries
	 * @return The prefix of that matches with the iso code
	 *         First prefix if the country is not found
	 */
	public static PhonePrefixes fromISOCode(String isoCode) {
		if (isoCode == null) {
			throw new IllegalArgumentException("The iso code cannot be null");
		}

		// Select the first elementy by default
		PhonePrefixes result = PhonePrefixes.values()[0];
		for (PhonePrefixes phonePrefixes : values()) {
			if (phonePrefixes.getAbbreviation() != null &&
					phonePrefixes.getAbbreviation().equals(isoCode)) {
				result = phonePrefixes;
				break;
			}
		}

		return result;
	}
}
