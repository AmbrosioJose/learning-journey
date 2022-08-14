package III_Data_Structures._10_Elementary_Data_Structures

class Stack {
    val list = MutableList<Int>(100){0}
    var top = -1

    fun isEmpty():Boolean{
        return top < 0
    }

    fun push(x: Int){
        top++
        if(top == list.size){
            list.add(x)
        } else {
            list[top] = x
        }
    }

    fun pop(): Int{
        if(top < 0)
            throw EmptyStack("Pop was called on an empty stack")
        return list[top--]
    }
}

class EmptyStack(message: String): Exception(message)