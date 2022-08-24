package III_Data_Structures._14_Augmenting_Data_Structures

enum class COLOR {RED, BLACK}

/**
 * Order statistic node
 *
 * @property value
 * @constructor Create empty order statistic node
 */
class OSNode(val value: Int) {
    var color = COLOR.RED
    var parent: OSNode? = null
    var left: OSNode? = null
    var right: OSNode? = null
    var size: Int = 0

    fun toBasicString(): String{
        return "$value(${color.name.first()} $size)"
    }
}