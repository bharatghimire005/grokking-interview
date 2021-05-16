package twoPointersPattern

fun main() {
    println("Are xy#z and xzz#  same ? answer: ${backSpacesCompare("xy#z", "xzz#")}")
}

fun backSpacesCompare(str1: String, str2: String): Boolean {
    var rightStr1 = str1.length - 1
    var rightStr2 = str2.length - 1
    while (rightStr1 >= 0 || rightStr2 >= 0) {
        rightStr1 = nextIndex(rightStr1, str1)
        rightStr2 = nextIndex(rightStr2, str2)
        if (rightStr1 >= 0 && rightStr2 >= 0 && str1[rightStr1] != str2[rightStr2]) {
            return false
        }
        if ((rightStr1 >= 0) != (rightStr2 >= 0)) {
            return false
        }
        rightStr1 -= 1
        rightStr2 -= 1
    }
    return true
}

private fun nextIndex(rightStr: Int, str: String): Int {
    var index = rightStr
    var backspaceCount = 0
    while (index >= 0) {
        if (str[index] == '#') {
            backspaceCount += 1
            index -= 1
        } else if (backspaceCount > 0) {
            backspaceCount -= 1
            index -= 1
        } else break
    }
    return index
}

