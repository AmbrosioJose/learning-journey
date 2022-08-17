package III_Data_Structures._13_Red_Black_Trees

enum class COLOR {RED, BLACK}
class RBNode(val value: Int) {
    var color = COLOR.RED
    var parent: RBNode? = null
    var left: RBNode? = null
    var right: RBNode? = null

    fun toBasicString(): String{
        return "$value(${color.name.first()})"
    }
}