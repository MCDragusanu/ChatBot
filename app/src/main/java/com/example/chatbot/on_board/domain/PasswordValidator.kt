import com.example.chatbot.R

/**
 * An interface for validating password complexity and providing a list of specific password requirements.
 */
interface PasswordValidator {
    /**
     * Validates a password against a set of specific password requirements.
     *
     * @param password The password to be validated.
     * @return A list of [PasswordRequirements] objects that contains all the requirements satisfied by the password.
     */
    fun check(password: String): List<PasswordRequirements>

    /**
     * Checks whether the password is strong enough or not.
     *
     * @param satisfiedCriteria The list of matched requirements.
     * @return True if it is strong enough , False otherwise.
     */
    fun isStrongEnough(satisfiedCriteria:List<PasswordRequirements>):Boolean {
        //a minimum weigth that the password must have
        val thresholdWeight = 0.66
        // the sum of all the weights
        val current = satisfiedCriteria.sumOf { it.weight }
        return current > thresholdWeight
    }

    /**
     * A sealed class representing specific password requirements with associated weight, condition message, and validation logic.
     *
     * @param weight The weight assigned to this requirement in the overall evaluation.
     * @param conditionMessage The resource ID for the message describing the requirement.
     * @param validation A validation function that checks whether the requirement is met.
     */
    sealed class PasswordRequirements(
        val weight: Double,
        val conditionMessage: Int,
        val validation: (String) -> Boolean
    ) {
        /**
         * Represents the requirement for a minimum password length.
         */
        object MinimumLength : PasswordRequirements(
            weight = 0.22,
            conditionMessage = R.string.password_minimum_length,
            validation = { it.length >= 10 }
        )

        /**
         * Represents the requirement for containing at least one digit.
         */
        object ContainsDigits : PasswordRequirements(
            weight = 0.22,
            conditionMessage = R.string.password_contains_digits,
            validation = { it.any { it.isDigit() } }
        )

        /**
         * Represents the requirement for containing at least one uppercase letter.
         */
        object ContainsUpperCase : PasswordRequirements(
            weight = 0.22,
            conditionMessage = R.string.password_contains_upper_case,
            validation = { it.any { it.isUpperCase() } }
        )

        /**
         * Represents the requirement for containing at least one special character.
         */
        object ContainsSpecialCharacters : PasswordRequirements(
            weight = 0.22,
            conditionMessage = R.string.password_contains_special_characters,
            validation = { it.any { !it.isDigit() && !it.isLetter() } }
        )

        /**
         * Represents the requirement for having enough characters in the password.
         */
        object isLongEnough : PasswordRequirements(
            weight = 0.12,
            conditionMessage = R.string.password_is_long_enough,
            validation = { it.length >= 15 }
        )
    }
}
