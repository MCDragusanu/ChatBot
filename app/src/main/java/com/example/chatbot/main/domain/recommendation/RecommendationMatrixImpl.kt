import java.lang.Integer.min

class RecommendationMatrixImpl(_buffer:Array<Array<Pair<Double , Long>>>): RecommendationMatrix(_buffer){
    override fun nerfCoefficient(topicIndex:Int , questionIndex:Int){

        _buffer[topicIndex][questionIndex] = _buffer[topicIndex][questionIndex].copy(_buffer[topicIndex][questionIndex].first-1)
    }

    override fun buffCoefficient(topicIndex:Int , questionIndex:Int){
        _buffer[topicIndex][questionIndex] = _buffer[topicIndex][questionIndex].copy(_buffer[topicIndex][questionIndex].first+1)

    }

    override fun getCoefficient(topicIndex:Int , questionIndex:Int):Double?{
        if(!isInside(topicIndex , questionIndex)) return null
        return _buffer[topicIndex][questionIndex].first
    } // null if indexex are not inside


    override fun setCoefficient(topicIndex:Int , questionIndex:Int , value:Double):Boolean{
        if(!isInside(topicIndex , questionIndex)) return false
        _buffer[topicIndex][questionIndex] = _buffer[topicIndex][questionIndex].copy(first = value)
        return true
    } // true if the value has been changed , false if is not inside

    override fun getRecommendedQuestions(topicIndex:Int , amount:Int):List<Long>{
        val row = _buffer[topicIndex]
       return row.sortedBy { -it.first}.subList(0 , min(amount , row.size-1)).withIndex().map { it.value.second }
    }//return the uids of the questions

    override fun updateBufferWithThresholdValue(treshHold:Double){
        for (i in _buffer.indices) {
            for (j in _buffer[i].indices) {
                _buffer[i][j] =_buffer[i][j].copy(first = treshHold)
            }
        }
    }//set the elements of the buffer with this value

    override fun isInside(topicIndex:Int , questionIndex:Int):Boolean{
        return !(topicIndex >= _buffer.size || questionIndex >= _buffer[topicIndex].size)
    } // use this to check if the indexes are inside

}