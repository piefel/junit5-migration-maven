package example.jqwik;

import example.PlzChecker;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.AlphaChars;
import net.jqwik.api.constraints.NumericChars;
import net.jqwik.api.constraints.StringLength;

import static org.assertj.core.api.Assertions.assertThat;


/*
 * This is a jqwik test using property-based testing.
 */
class PropertyBasedTest {

    private PlzChecker plzChecker = new PlzChecker();

    @Property
    void shouldValidatePostalCode(@ForAll @StringLength(5) @NumericChars String plz) {
        assertThat(plzChecker.isPlz(plz)).isTrue();
    }

    @Property
    void shouldNotValidatePostalCodeWithCharacters(@ForAll @StringLength(5) @AlphaChars String plz) {
        assertThat(plzChecker.isPlz(plz)).isFalse();
    }

    @Property
    void shouldNotValidatePostalCodeTooShort(@ForAll @StringLength(max = 4) @NumericChars String plz) {
        assertThat(plzChecker.isPlz(plz)).isFalse();
    }

    @Property
    void shouldNotValidatePostalCodeTooLong(@ForAll @StringLength(min = 6, max = 20) @NumericChars String plz) {
        assertThat(plzChecker.isPlz(plz)).isFalse();
    }

}
