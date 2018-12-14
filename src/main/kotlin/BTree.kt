class BTree(val t: Int) {

    var keysCount: Int = 0
        private set

    var isLeaf: Boolean = true
        private set

    var keys: ArrayList<Int> = ArrayList()
        private set

    var nodes: ArrayList<BTree> = ArrayList()
        private set

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BTree

        if (t != other.t) return false
        if (keysCount != other.keysCount) return false
        if (isLeaf != other.isLeaf) return false
        if (keys != other.keys) return false
        if (nodes != other.nodes) return false

        return true
    }

    override fun hashCode(): Int {
        var result = t
        result = 31 * result + keysCount
        result = 31 * result + isLeaf.hashCode()
        result = 31 * result + keys.hashCode()
        result = 31 * result + nodes.hashCode()
        return result
    }

}