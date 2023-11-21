class RecommendationMatrixImpl(_buffer:Array<Array<Double>>): RecommendationMatrix(_buffer){
    override fun nerfCoefficient(topicIndex:Int , questionIndex:Int){
        _buffer[topicIndex][questionIndex]--
    }

    override fun buffCoefficient(topicIndex:Int , questionIndex:Int){
        _buffer[topicIndex][questionIndex]++
    }

    override fun getCoefficient(topicIndex:Int , questionIndex:Int):Double?{
        if(isInside(topicIndex , questionIndex) == false) return null
        return _buffer[topicIndex][questionIndex]
    } // null if indexex are not inside{


    override fun setCoefficient(topicIndex:Int , questionIndex:Int , value:Double):Boolean{
        if(isInside(topicIndex , questionIndex) == false) return false
        _buffer[topicIndex][questionIndex] = value
        return true
    } // true if the value has been changed , false if is not inside

    override fun getRecommendedQuestions(topicIndex:Int , amount:Int):List<Int>{
        _buffer[topicIndex].sortDescending()
        val list: MutableList<Int> = MutableList(amount){0}
        for(i in 0..amount - 1)
            list[i] = i                              //de unde se iau uid-urile intrebarilor????
        return list
    }//return the uids of the questions

    override fun updateBufferWithThresholdValue(treshHold:Double){
        for (i in _buffer.indices) {
            for (j in _buffer[i].indices) {
                _buffer[i][j] = treshHold
            }
        }
    }//set the elements of the buffer with this value

    protected override fun isInside(topicIndex:Int , questionIndex:Int):Boolean{
        if(topicIndex >= _buffer.size || questionIndex >= _buffer[0].size)
            return false
        else return true
    } // use this to check if the indexes are inside

}