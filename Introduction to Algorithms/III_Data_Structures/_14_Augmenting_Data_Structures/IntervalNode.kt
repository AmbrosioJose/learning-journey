package III_Data_Structures._14_Augmenting_Data_Structures

/**
 * Order statistic node
 *
 * @property value
 * @constructor Create empty order statistic node
 */
class IntervalNode(interval: Interval) {
    var color = COLOR.RED
    var parent: IntervalNode? = null
    var left: IntervalNode? = null
    var right: IntervalNode? = null
    var interval: Interval
    /**
     * Subtree max
     *
     * The maximum value of any interval endpoint stored in the subtree of the current node
     */
    var subtreeMax: Int = 0

    constructor () : this(Interval(0,0))

    init{
        this.interval = interval
    }



    fun toBasicString(): String{
        return "$interval(${color.name.first()} $subtreeMax)"
    }

    override fun toString(): String{
        return "$interval"
    }

    fun updateMax(){
        val left = left?.interval?.end ?: 0
        val right = right?.interval?.end ?: 0
        subtreeMax = Math.max(Math.max(interval.end, left), right)
    }

    fun intersects(b: IntervalNode): Boolean {
        return interval.intersects(b.interval)
    }
}

/**
 * Interval
 *
 *
 *
 * @constructor Create empty Interval
 */
class Interval(val start: Int, val end: Int){

    fun intersects(b: Interval): Boolean {
        return start <= b.end && b.start <= end
    }


    override fun toString() : String{
        return "[${start},${end}]"
    }

    override fun equals(other: Any?): Boolean {
        if(other is Interval){
            return start == other.start && end == other.end
        }
        throw IllegalArgumentException("Can only compare to another Interval class")
    }

    override fun hashCode(): Int {
        var result = start
        result = (31 * result + end * 71)
        return result
    }


}