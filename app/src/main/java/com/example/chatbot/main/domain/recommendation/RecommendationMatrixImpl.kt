import java.lang.Integer.min

class RecommendationMatrixImpl(_buffer:Array<Array<Double>>): RecommendationMatrix(_buffer){
    override fun nerfCoefficient(topicIndex:Int , questionIndex:Int){
        _buffer[topicIndex][questionIndex]--
    }

    override fun buffCoefficient(topicIndex:Int , questionIndex:Int){
        _buffer[topicIndex][questionIndex]++
    }

    override fun getCoefficient(topicIndex:Int , questionIndex:Int):Double?{
        if(!isInside(topicIndex , questionIndex)) return null
        return _buffer[topicIndex][questionIndex]
    } // null if indexex are not inside


    override fun setCoefficient(topicIndex:Int , questionIndex:Int , value:Double):Boolean{
        if(!isInside(topicIndex , questionIndex)) return false
        _buffer[topicIndex][questionIndex] = value
        return true
    } // true if the value has been changed , false if is not inside

    override fun getRecommendedQuestions(topicIndex:Int , amount:Int):List<Int>{
        val row = _buffer[min(topicIndex , _buffer.size-1)]
       return row.sortedBy { -it }.subList(0 , min(amount , row.size-1)).withIndex().map { it.index }
    }//return the uids of the questions

    override fun updateBufferWithThresholdValue(treshHold:Double){
        for (i in _buffer.indices) {
            for (j in _buffer[i].indices) {
                _buffer[i][j] = treshHold
            }
        }
    }//set the elements of the buffer with this value

    override fun isInside(topicIndex:Int , questionIndex:Int):Boolean{
        return !(topicIndex >= _buffer.size || questionIndex >= _buffer[topicIndex].size)
    } // use this to check if the indexes are inside

}