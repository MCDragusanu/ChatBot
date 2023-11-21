/**
 * Abstract class representing a recommendation matrix for a set of topics and questions.
 *
 * @param _buffer Two-dimensional array representing the recommendation coefficients between topics and questions.
 */
abstract class RecommendationMatrix(protected val _buffer: Array<Array<Double>>) {

    /**
     * Applies a nerfing coefficient to the specified entry in the matrix.
     *
     * @param topicIndex Index of the topic.
     * @param questionIndex Index of the question.
     */
    abstract fun nerfCoefficient(topicIndex: Int, questionIndex: Int)

    /**
     * Applies a buffing coefficient to the specified entry in the matrix.
     *
     * @param topicIndex Index of the topic.
     * @param questionIndex Index of the question.
     */
    abstract fun buffCoefficient(topicIndex: Int, questionIndex: Int)

    /**
     * Retrieves the coefficient at the specified entry in the matrix.
     *
     * @param topicIndex Index of the topic.
     * @param questionIndex Index of the question.
     * @return The coefficient at the specified entry, or null if the indexes are outside the matrix.
     */
    abstract fun getCoefficient(topicIndex: Int, questionIndex: Int): Double?

    /**
     * Sets the coefficient at the specified entry in the matrix.
     *
     * @param topicIndex Index of the topic.
     * @param questionIndex Index of the question.
     * @param value The new value to set.
     * @return True if the value has been changed, false if the indexes are outside the matrix.
     */
    abstract fun setCoefficient(topicIndex: Int, questionIndex: Int, value: Double): Boolean

    /**
     * Retrieves a list of recommended question indices for the specified topic.
     *
     * @param topicIndex Index of the topic.
     * @param amount Number of recommended questions to retrieve.
     * @return List of question indices recommended for the specified topic.
     */
    abstract fun getRecommendedQuestions(topicIndex: Int, amount: Int): List<Int>

    /**
     * Updates all elements in the matrix with a threshold value.
     *
     * @param threshold The threshold value to set for all matrix elements.
     */
    abstract fun updateBufferWithThresholdValue(threshold: Double)

    /**
     * Checks if the specified indexes are inside the matrix.
     *
     * @param topicIndex Index of the topic.
     * @param questionIndex Index of the question.
     * @return True if the indexes are inside the matrix, false otherwise.
     */
    protected abstract fun isInside(topicIndex: Int, questionIndex: Int): Boolean
}
