package com.jiahaoliuliu.spinnerwithtwoitems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * Demo using the built-in Android
 * <a href="http://developer.android.com/reference/android/R.layout.html#simple_list_item_2">
 * android.R.layout.simple_list_item_2</a> to display an
 * array of Java enum entries in the UI.
 * <p />
 * The demo displays a list of the prefixes along with the country which each prefix belongs
 * <p />
 *  The basic technical steps are
 * <ol>
 * <li>Create class extending
 * <a href="http://developer.android.com/reference/android/app/ListActivity.html">ListActivity</a></li>
 * <li>Obtain data as a array of enum entries</li>
 * <li>Create a
 * <a href="http://developer.android.com/reference/android/widget/SimpleAdapter.html">SimpleAdapter</a>
 * that connects the array of enum entries to simple_list_item2</li>
 * <li>Bind the ListAdapter using the
 * <a href="http://developer.android.com/reference/android/app/ListActivity.html#setListAdapter(android.widget.ListAdapter)">ListActivity.setListAdapter</a> method</li>
 * </ol>
 *
 * Based on the example of Jirawat Uttayaya about the list view with two items
 * 		<a href="http://www.javajirawat.com/2013/03/android-listview-tutorial_12.html">Link</a>
 * @author Jiahao Liu Liu <a href="mailto:jiahaoliuliu@gmail.com">jiahaoliuliu@gmail.com</a>
 * @version 1.0
 * @since 1.0
 *
 */
public class MainActivity extends Activity {
	/**
	 * The key in the SimpleAdapter Map<String, String> to map to
	 * <a href="http://developer.android.com/reference/android/R.id.html#text1">android.R.id.text1</a>.
	 */
	private static final String TEXT1 = "text1";
	/**
	 * The key in the SimpleAdapter Map<String, String> to map to
	 * <a href="http://developer.android.com/reference/android/R.id.html#text2">android.R.id.text2</a>.
	 */
	private static final String TEXT2 = "text2";

	/**
	 * The locale of the device. This allow to display the countries according to the
	 * language of the device.
	 */
	private Locale locale;

	/**
	 * The list of the map of the contents. Each element in the list is a prefix.
	 * Check the method convertToListItems for more information.
	 */
	private List<Map<String, String>> list;

    /**
     * This overridden method initializes the ListActivity.
     * After calling the parent onCreate method, it binds the ListAdapter to the
     * ListActivity via setListAdapter method.
     *
     * @param savedInstanceState If the activity is being re-initialized
     * after previously being shut down then this Bundle contains the data
     * it most recently supplied in
     * {@link android.app.Activity#onSaveInstanceState(Bundle)}.
     * <b>Note: Otherwise it is null.</b>
     */
	@Override
	protected final void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		locale = getResources().getConfiguration().locale;

		final PhonePrefix[] phonePrefixes = PhonePrefix.values();
		final SimpleAdapter simpleAdpater = createSimpleAdapter(phonePrefixes);
		
		setContentView(R.layout.activity_main);
		Spinner simpleSpinner = (Spinner)findViewById(R.id.SimpleSpinner);
		final TextView prefixSelectedTextview = (TextView)findViewById(R.id.prefixSelectedTextView);
		simpleSpinner.setAdapter(simpleAdpater);

		simpleSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				final Map<String, String> prefix = list.get(position);
				prefixSelectedTextview.setText(
						// The phone prefix
						prefix.get(TEXT1) + "\n" +
						// The country name
						prefix.get(TEXT2));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				prefixSelectedTextview
					.setText(
						getResources().getString(
							R.string.no_prefix_selected));
			}
		});

		// Preselect the country of the device, if exists
		PhonePrefix phonePrefix = PhonePrefix.fromISOCode(locale.getCountry());
		simpleSpinner.setSelection(phonePrefix.ordinal());
	}

	/**
     * A <a href="http://developer.android.com/reference/android/widget/SimpleAdapter.html">SimpleAdapter</a>
     * implements the interface <a href="http://developer.android.com/reference/android/widget/SpinnerAdapter.html">
     * SpinnerAdapter</a> which is used by <a href="http://developer.android.com/reference/android/widget/Spinner.html">
     * the spinner</a>
     * Note: This example also works if we replace the array of enum entries parameter
     * with an array or
     * <a href="http://docs.oracle.com/javase/6/docs/api/java/util/List.html">List</a>
     * of JavaBeans.
	 * @since 1.0
	 *
	 * @param states An array of {@link PhonePrefix} enum entries
	 * @return A <a href="http://developer.android.com/reference/android/widget/SimpleAdapter.html">SimpleAdapter</a>
	 * using the
	 * <a href="http://developer.android.com/reference/android/R.layout.html#simple_list_item_2">simple_list_item_2</a>
	 * layout to display an array of enum entries
	 */
	private SimpleAdapter createSimpleAdapter(final PhonePrefix[] phonePrefixes) {
		final String[] fromMapKey = new String[] {TEXT1, TEXT2};
		final int[] toLayoutId = new int[] {android.R.id.text1, android.R.id.text2};

		// Set the values to the list of maps
		list = convertToListItems(phonePrefixes);
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, list,
				android.R.layout.simple_list_item_1, fromMapKey, toLayoutId);
		// Remove the follow line to have the same view as dropdown view
		simpleAdapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_2);
		return simpleAdapter;
	}

	/**
	 * Convert an array of {@link PhonePrefix} into a List of Map<String, String>.
	 * The List of Map<String, String> will be used as part of the constructor for
	 * a <a href="http://developer.android.com/reference/android/widget/SimpleAdapter.html">SimpleAdapter</a>.
	 * <p />
	 * Each element in the List will correspond to a entry in the Android UI list.
	 * The Map<String, String> maps the attributes on the Object to the
	 * <a href="http://developer.android.com/reference/android/R.id.html#text1">android.R.id.text1</a>
	 * and
	 * <a href="http://developer.android.com/reference/android/R.id.html#text2">android.R.id.text2</a>
	 * UI fields.
	 * <p />
	 * For example, if you input
	 * PhonePrefixes[] =
	 *   [ DE(49),
	 *     ES(34),
     *     GR(30)
     *    ];
     *
	 * the output will be
	 * List<Map<String, String>> =
	 *   [ {text1="49", text2="Germany"},
	 *     {text1="34", text2="Spain"},
	 *     {text1="30", text2="Greece"}
	 *   ];
	 * @since 1.0
	 *
	 * @param states An array of {@link PhonePrefix} enum entries
	 * @return An unmodifiable List of Map<String, String> that will be passed
	 * as a SimpleAdapter constructor parameter
	 */
	private List<Map<String, String>> convertToListItems(final PhonePrefix[] states) {
		final List<Map<String, String>> listItem =
	        new ArrayList<Map<String, String>>(states.length);

		String tmpCountriesISOCode;
		Locale tmpLocale;
		for (final PhonePrefix state: states) {
			final Map<String, String> listItemMap = new HashMap<String, String>();
			listItemMap.put(TEXT1, String.valueOf(state.getPhonePrefix()));
			tmpCountriesISOCode = state.getAbbreviation();
			tmpLocale = new Locale("", tmpCountriesISOCode);
			// Display the country name according to the country iso code and the
			// device local language
			listItemMap.put(TEXT2, 
					tmpLocale.getDisplayCountry(locale));
			listItem.add(Collections.unmodifiableMap(listItemMap));
		}

		return Collections.unmodifiableList(listItem);
	}
}
