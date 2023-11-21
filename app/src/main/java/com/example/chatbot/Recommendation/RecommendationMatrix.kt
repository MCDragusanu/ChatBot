abstract class RecommendationMatrix(protected val _buffer:Array<Array<Double>>){

    abstract fun nerfCoefficient(topicIndex:Int , questionIndex:Int)

    abstract fun buffCoefficient(topicIndex:Int , questionIndex:Int)

    abstract fun getCoefficient(topicIndex:Int , questionIndex:Int):Double? // null if indexex are not inside

    abstract fun setCoefficient(topicIndex:Int , questionIndex:Int , value:Double):Boolean // true if the value has been changed , false if is not inside

    abstract fun getRecommendedQuestions(topicIndex:Int , amount:Int):List<Int>//return the uids of the questions

    abstract fun updateBufferWithThresholdValue(treshHold:Double)//set the elements of the buffer with this value

    protected abstract fun isInside(topicIndex:Int , questionIndex:Int):Boolean // use this to check if the indexes are inside
}