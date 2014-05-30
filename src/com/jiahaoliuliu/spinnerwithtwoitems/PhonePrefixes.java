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
    ES(34);
    /*
    Hungría("36"),
    Italia("39"),
    Rumanía("40"),
    Suiza("41"),
    Austria("43"),
    ReinoUnido("44"),
    Dinamarca("45"),
    Suecia("46"),
    Noruega("47"),
    Polonia("48"),
    Alemania("49"),
    Peru("51"),
    Mexico("52"),
    Cuba("53"),
    Argentina("54"),
    Brasil("55"),
    Chile("569"),
    Colombia("57"),
    Venezuela("58"),
    Australia("61"),
    NuevaZelanda("64"),
    China("86"),
    Marruecos("212"),
    Congo("242"),
    Groenlandia("299"),
    Gibraltar("350"),
    Portugal("351"),
    Luxemburgo("352"),
    Irlanda("353"),
    Islandia("354"),
    Albania("355"),
    Chipre("357"),
    Finlandia("358"),
    Andorra("376"),
    Mónaco("377"),
    Croacia("385"),
    RepublicaCheca("420"),
    Eslovaquia("421"),
    Liechtenstein("423"),
    Guatemala("502"),
    Nicaragua("505"),
    CostaRica("506"),
    Panama("507"),
    Bolivia("591"),
    Ecuador("593"),
    Paraguay("595"),
    Uruguay("598"),
    EmiratosArabes("971"),
    Israel("972"),
    RepublicaDominicana("1809");
	*/

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
}
